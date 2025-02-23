import {markovNext} from "./markovNext";
import {
  JsonSchema,
  PropertyMutationQueryType,
  SelectNodeGraphQueryType,
  SelectPersonQueryType,
} from "./JsonSchema";
import {newRandom} from "./newRandom";
import {createOperationFromQueryType} from "./operation/createOperationFromQueryType";
import {getPersonProperty, PersonQueryType} from "./person/getPersonProperty";
import {getById} from "./person/getById";
import {createOperationFromParent} from "./operation/createOperationFromParent";
import {calculateNameFromChildren, calculateNameFromRefString} from "./calculateName";
import {classifyPerson} from "./person/classifyPerson";
import {setProperty} from "./person/setProperty";
import {selectPerson} from "./person/selectPerson";
import {applyPropertyMutation, oldApplyPropertyMutation} from "./person/applyPropertyMutation";
import {
  group__name_token,
  type__math_operations,
  type__math_operations_and
} from "../world_step.schema";
import {createLocationGraph} from "./locationGraph/createLocationGraph";
import {createGraphNode, LocationGraphNodeQueryType, LocationGraphQueryType} from "./locationGraph/createGraphNode";
import {createAdjacent} from "./locationGraph/createAdjacent";
import {createPerson} from "./person/createPerson";
import {selectNodeGraph} from "./locationGraph/selectNodeGraph";
import {selectLinkTo, SelectLinkToQueryType} from "./locationGraph/selectLinkTo";
import {shortestPathsInGraph, shortestPathsInGraphExcludeStart} from "./locationGraph/shortestPathsInGraph";
import {removePerson} from "./locationGraph/removePerson";
import {MutationResult} from "../middleware/_type";
import {findPersonLocation, FindPersonResult} from "./locationGraph/findPerson";
import {isSelectionApplicableTo} from "./person/isSelectionApplicableTo";



export const utils = {
  markov: markovNext,
}

export class JsonUtil {
  constructor(public json: JsonSchema) {
    this.invalidate();
  }

  /**
   * Returns a function that returns a random number between 0 and 1
   */
  random: () => number;
  randomBetween = (min: number, max: number) => {
    if(min > max) {
      console.log(`randomBetween (${min}, ${max}) -> mix > max`)
      return this.randomBetween(max, min);
    }
    const modOperation = (n, d) => ((n % d) + d) % d
    const randomValue = this.random()

    const maxRange = max + 1 - min;
    console.log(`randomBetween (${min}, ${max}) maxRange: ${maxRange}`)
    if (maxRange === 0) {
      const isGreaterThan = randomValue >= 0.5;
      const returnValue = isGreaterThan
        ? max
        : min;
      console.log(`randomBetween (${min}, ${max}) -> ${returnValue}, because randomValue ${randomValue} isGreaterThan test resulted ${isGreaterThan}`)
      return returnValue;
    }

    const delta = max - min;
    const result = randomValue * delta + min;
    console.log(`randomBetween (${min}, ${max}) -> ${randomValue} * ${delta} + ${min} -> ${result}`)
    return result;
  }
  randomBetweenInt = (min: number, max: number) => {
    const result = Math.floor(this.randomBetween(min, max));
    console.log(`randomBetweenInt: (${min}, ${max}) -> ${result}`)
    return result
  }

  randomListFromArray = <T>(originalArray: T[], numberOfElements: number = 1): T[] => {
    // Create a copy of the array to avoid modifying the original array
    let array = [...originalArray];

    let currentIndex = array.length;
    while (currentIndex !== 0) {
      const randomIndex = Math.floor(this.random() * (currentIndex - 1));
      currentIndex--;

      // Swap elements
      const temporaryValue = array[currentIndex];
      array[currentIndex] = array[randomIndex];
      array[randomIndex] = temporaryValue;
    }
    return array.slice(0, numberOfElements);
  }

  randomFromArray = <T>(array: T[]): T => {
    return array[Math.floor(this.random() * (array.length - 1))];
  }
  questMarkov: () => void;

  getNextId = () => {
    const time = this.json.query("world_metadata").query("elapsed_time").attributeMap.value;
    return `${time}.${this.counterNext()}`
  }

  counterNext = () => {
    const counter = this.json.query("world_metadata").query("counter");
    const attribute = counter.attributeMap.value;
    counter.setAttribute("value", value => {
      return String(Number(value) + 1)
    })
    return attribute;
  }
  computeOperation = (operationQueryType: type__math_operations_and["childrenList"][number], getExternalProperty?: (string: string) => string) => {
    return createOperationFromQueryType(this, operationQueryType, getExternalProperty)
  }
  computeOperationFromParent = (operationList: type__math_operations, getExternalProperty?: (string: string) => string) => {
    return createOperationFromParent(this, operationList, getExternalProperty)
  }
  invalidate = () => {
    this.random = newRandom(this);
  }

  name = {
    calculateNameFromRefString: (name: string) => {
      return calculateNameFromRefString(this, name);
    },

    calculateNameFromChildren: (element: group__name_token) => {
      return calculateNameFromChildren(this, element);
    }
  }

  classification: {}


  locationGraph = {
    createLocationGraph: (ref: string) => {
      return createLocationGraph(this, ref)
    },
    createGraphNode: (locationGraph: LocationGraphQueryType, ref: string) => {
      return createGraphNode(this, locationGraph, ref)
    },
    createAdjacent: (locationGraphRef: string, nodeRef: string) => {
      return createAdjacent(this, locationGraphRef, nodeRef)
    },
    selectNodeGraph: (selectNodeGraphQueryType: SelectNodeGraphQueryType) => {
      return selectNodeGraph(this, selectNodeGraphQueryType)
    },
    selectLinkTo: (selectLinkToQueryType: SelectLinkToQueryType) => {
      return selectLinkTo(this, selectLinkToQueryType)
    },
    shortestPathsInGraph: (locationGraph: LocationGraphQueryType, startNode: LocationGraphNodeQueryType, destinationNode: LocationGraphNodeQueryType, numberOfPaths: number) => {
      return shortestPathsInGraph(this, locationGraph, startNode, destinationNode, numberOfPaths)
    },
    shortestPathsInGraphExcludeStart: (locationGraph: LocationGraphQueryType, startNode: LocationGraphNodeQueryType, destinationNode: LocationGraphNodeQueryType, numberOfPaths: number) => {
      return shortestPathsInGraphExcludeStart(this, locationGraph, startNode, destinationNode, numberOfPaths)
    },
    removePerson: (personIdRef: string) => {
      return removePerson(this, personIdRef)
    },
    findPersonLocation: (personIdRef: string): Array<FindPersonResult> => {
      return findPersonLocation(this, personIdRef);
    }
  }

  person = {
    selectPerson: (selectPersonQueryType: SelectPersonQueryType) => {
      return selectPerson(this, selectPersonQueryType);
    },
    isSelectionApplicableTo: (selectPersonQueryType: SelectPersonQueryType, personQueryType: PersonQueryType) => {
      return isSelectionApplicableTo(this, selectPersonQueryType, personQueryType);
    },
    createPerson: (selectPersonQueryType: SelectPersonQueryType) => {
      return createPerson(this, selectPersonQueryType);
    },
    oldApplyPropertyMutation: (personQueryType: PersonQueryType, propertyMutation: PropertyMutationQueryType, getPropertyTarget?: (key: string) => string) => {
      return oldApplyPropertyMutation(this, personQueryType, propertyMutation, getPropertyTarget)
    },
    applyPropertyMutation: (outputPersonQueryType: PersonQueryType, propertyMutation: PropertyMutationQueryType | undefined, selfPersonQueryType: PersonQueryType, targetPersonQueryType: PersonQueryType): MutationResult => {
      return applyPropertyMutation(this, outputPersonQueryType, propertyMutation, selfPersonQueryType, targetPersonQueryType)
    },
    getProperty: (personQueryType: PersonQueryType, key) => getPersonProperty(this, personQueryType, key),
    setProperty: (personQueryType: PersonQueryType, key, value: string) => setProperty(this, personQueryType, key, value),
    getById:(id: string): PersonQueryType => {
      return getById(this.json, id)
    },
    classifyPerson: (personQueryType: PersonQueryType) => {
      return classifyPerson(this, personQueryType);
    },
  }

  markov = markovNext;

  getRuleGroups = (): Array<JsonSchema["children"]["rule_group"]> => {
    return this.json.queryAll("rule_group");
  }

}