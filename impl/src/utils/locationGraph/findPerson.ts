import {JsonUtil} from "../util";
import {LocationGraphNodeQueryType, LocationGraphQueryType} from "./createGraphNode";
import {LinkToQueryType} from "./selectLinkTo";

export type FindPersonResult = {
  locationGraph: LocationGraphQueryType,
  node?: LocationGraphNodeQueryType,
  linkTo?: LinkToQueryType,
}

export const findPersonLocation = (readJson: JsonUtil, personIdRef: string): Array<FindPersonResult> => {
  const result: FindPersonResult[] = readJson.json
    .queryOptional("data")
    ?.queryOptional("location")
    ?.queryAllOptional("location_graph")
    .flatMap(locationGraphElement => {
      const nodeElementList = locationGraphElement.queryAllOptional("node")
      return nodeElementList.flatMap(nodeElement => {
        const person = nodeElement.queryAllOptional("people").flatMap(peopleElement => {
          return peopleElement.queryAllOptional("person");

        }).find(personElement => personElement.attributeMap.person_id_ref === personIdRef)
        if (person) {
          return [{
                    locationGraph: locationGraphElement,
                    node: nodeElement,
                    linkTo: undefined,
                  } satisfies FindPersonResult];
        }
        const linkToPerson = nodeElement.queryAllOptional("link_to").find(linkToElement => {
          return linkToElement.queryAllOptional("people")
            .flatMap(peopleElement => peopleElement.queryAllOptional("person"))
            .find(personElement => personElement.attributeMap.person_id_ref === personIdRef)
        })
        return [{
                  locationGraph: locationGraphElement,
                  node: undefined,
                  linkTo: linkToPerson
                } satisfies FindPersonResult]
      })
    });
  return result ?? [];
}