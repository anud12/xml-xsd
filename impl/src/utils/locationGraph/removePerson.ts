import {JsonUtil} from "../util";

export const removePerson = (readJson: JsonUtil, personIdRef: string) => {
  readJson.json
    .queryOptional("data")
    ?.queryOptional("location")
    ?.queryAllOptional("location_graph")
    .find(locationGraphElement => locationGraphElement.queryAllOptional("node")
      .find(nodeElement => {
        nodeElement.queryAllOptional("people").find(peopleElement => {
          const personElement = peopleElement.queryAllOptional("person")
            .find(personElement => personElement.attributeMap.person_id_ref === personIdRef);
          personElement?.removeFromParent();
        })

        nodeElement.queryAllOptional("links")
          .flatMap(linksElement => linksElement.queryAllOptional("link_to"))
          .find(linkToElement => {
            linkToElement.queryAllOptional("people").find(peopleElement => {
              const personElement = peopleElement.queryAllOptional("person")
                .find(personElement => personElement.attributeMap.person_id_ref === personIdRef);
              personElement?.removeFromParent();
            })
          })
      }))
}