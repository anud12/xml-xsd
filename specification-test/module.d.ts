export type Context = {
  sendMessageBroadcast:sendMessageBroadcast,
  entity:EntityApi
}

type CollectionJSApi<T> = {
  count: () => number
  forEach: (consumer:(t:T) => void) => void;
}

type sendMessageBroadcast = (message: string) => void;

type EntityConstructor = {

}

type EntityQuery = {
  byId: (id:string) => EntityQuery
  byRuleId: (id:string) => EntityQuery
  inContainer:(mutation: (query: ContainerQuery) => ContainerQuery) => EntityQuery
}

type ContainerQuery = {
  byId: (id:string) => EntityConstructor
}


type EntityApi = {
  getById: (id:string) => EntityJSView,
  createByRule:(ruleId:string) => EntityConstructor
}

type ContainerJSView = {
  addEntity: (entity:EntityJSView) => ContainerJSView
}

type EntityJSView = {
  toString: () => string
  getAllEntitiesBy: (fn: (query:EntityQuery) => EntityQuery) => CollectionJSApi<EntityJSView>
  getAllContainersBy: (fn: (query:ContainerQuery) => ContainerQuery) => CollectionJSApi<ContainerJSView>
  setText:(name:string, mapper: (oldValue:string) => string) => EntityJSView
}


export declare const onServerTick: (context: Context) => void;
