/// <reference path="../module.d.ts" />
export const onServerTick = (context) => {
  context.sendMessageBroadcast("Found entities: " + context.entity.getById("1")
    .getAllEntitiesBy(query => query
      .byId("2")
      .inContainer(query => query.byId("containerId_2"))
    )
    .count());

  context.entity.getById("2")
    .getAllEntitiesBy()
}