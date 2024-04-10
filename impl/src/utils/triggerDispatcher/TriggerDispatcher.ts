type Listener<Data> = (data: Data) => Promise<void>;

export class TriggerDispatcher<Key, Data> {
  private listeners: Map<string, Array<Listener<Data>>>  = new Map();

  public on(key: Key, listener: Listener<Data>) {
    const keyString = JSON.stringify(key);
    if (!this.listeners.has(keyString)){
      this.listeners.set(keyString, []);
    }
    this.listeners.get(keyString)!.push(listener);

    return () => {
      this.remove.bind(this)(key, listener);
    }
  }

  public remove(key: Key, listener: Listener<Data>) {
    const keyString = JSON.stringify(key);
    if (this.listeners.has(keyString)) {
      const listeners = this.listeners.get(keyString)!;
      const index = listeners.indexOf(listener);
      if (index !== -1) {
        listeners.splice(index, 1);
      }
    }
  }

  public async dispatch(key: Key, data:Data) {
    const keyString = JSON.stringify(key);
    if (this.listeners.has(keyString)) {
      const listeners = this.listeners.get(keyString)!;
      for (const listener of listeners) {
        await listener(data);
      }
    }
  }
}