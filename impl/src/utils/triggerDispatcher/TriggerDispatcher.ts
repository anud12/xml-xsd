type Listener<Data> = (data: Data) => Promise<void>;

export class TriggerDispatcher<Key, Data> {
  private listeners: Map<Key, Array<Listener<Data>>>  = new Map();

  public on(key: Key, listener: Listener<Data>) {

    if (!this.listeners.has(key)){
      this.listeners.set(key, []);
    }
    this.listeners.get(key)!.push(listener);

    return () => {
      this.remove.bind(this)(key, listener);
    }
  }

  public remove(key: Key, listener: Listener<Data>) {
    if (this.listeners.has(key)) {
      const listeners = this.listeners.get(key)!;
      const index = listeners.indexOf(listener);
      if (index !== -1) {
        listeners.splice(index, 1);
      }
    }
  }

  public async dispatch(key: Key, data:Data) {
    if (this.listeners.has(key)) {
      const listeners = this.listeners.get(key)!;
      for (const listener of listeners) {
        await listener(data);
      }
    }
  }
}