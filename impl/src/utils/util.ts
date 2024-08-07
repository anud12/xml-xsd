import {LocationGrid, locationGrid} from "./location/locationGrid";
import {locationMarkovChainMatrix, LocationMatrix} from "./location/locationMarkovChainMatrix";
import {markovNext} from "./markovNext";
import {create} from "./location/create";
import {
  ItemQueryType,
  JsonSchema,
  PropertyMutationQueryType,
  SelectItemQueryType,
  SelectPersonQueryType,
} from "./JsonSchema";
import {newRandom} from "./newRandom";
import {createOperationFromQueryType} from "./operation/createOperationFromQueryType";
import {getPersonProperty, PersonQueryType} from "./person/getPersonProperty";
import {getById} from "./person/getById";
import {createOperationFromParent} from "./operation/createOperationFromParent";
import {calculateNameFromChildren, calculateNameFromRefString, NameRuleEntryQueryType} from "./calculateName";
import {CreateItemArgs, createItemAt} from "./item/createItemAt";
import {classifyPerson} from "./person/classifyPerson";
import {setProperty} from "./person/setProperty";
import {Position, selectPerson} from "./person/selectPerson";
import {selectItem} from "./item/selectItem";
import {queryItem} from "./item/queryItem";
import {classifyItem} from "./item/classifyItem";
import {getItemProperty} from "./item/getItemProperty";
import {filterItem} from "./item/filterItem";
import {applyPropertyMutation} from "./person/applyPropertyMutation";
import {group__name_token, group__operation__and, type__math_operations} from "../world_step.schema";
import {createLocationGraph} from "./locationGraph/createLocationGraph";
import {createGraphNode, LocationGraphQueryType} from "./locationGraph/createGraphNode";
import {createAdjacent} from "./locationGraph/createAdjacent";

export const memoizeFunction = <T>(func: T): T => {
  let value;
  return new Proxy(func as any, {
    apply(target: (func) => (func) => any, thisArg: any, argArray: any[]): any {
      if (!value) {
        value = target.apply(thisArg, argArray);
      }
      return value;
    }
  }) as any
}

export const utils = {
  locationGrid: locationGrid,
  locationMarkovChainMatrix: locationMarkovChainMatrix,
  markov: markovNext,
  newLocation: create,
}

export class JsonUtil {
  constructor(public json: JsonSchema) {
    this.invalidate();
  }

  /**
   * Returns a function that returns a random number between 0 and 1
   */
  random: () => number;
  location: {
    grid: () => LocationGrid,
    markovChainMatrix: (direction: string) => LocationMatrix,
    create: (x: number, y: number) => void,
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
  computeOperation = (operationQueryType: group__operation__and["childrenList"][number], getExternalProperty?: (string: string) => string) => {
    return createOperationFromQueryType(this, operationQueryType, getExternalProperty)
  }
  computeOperationFromParent = (operationList: type__math_operations, getExternalProperty?: (string: string) => string) => {
    return createOperationFromParent(this, operationList, getExternalProperty)
  }
  invalidate = () => {
    this.random = newRandom(this);
    this.location = {
      grid: memoizeFunction(() => {
        return locationGrid(this)
      }),

      markovChainMatrix: memoizeFunction((direction: string) => {
        return locationMarkovChainMatrix(this, direction)
      }),

      create: memoizeFunction((x: number, y: number) => {
        return create(this, x, y)
      })
    }
  }

  name = {
    calculateNameFromRefString: memoizeFunction((name: string) => {
      return calculateNameFromRefString(this, name);
    }),

    calculateNameFromChildren: (element: group__name_token) => {
      return calculateNameFromChildren(this, element);
    }
  }

  classification: {}

  item = {
    classifyItem: (args: ItemQueryType) => {
      return classifyItem(this, args)
    },
    createItemAt: (args: CreateItemArgs) => {
      return createItemAt(this, args);
    },
    selectItem: (args: SelectItemQueryType,) => {
      return selectItem(this, args)
    },
    queryItem: () => {
      return queryItem(this)
    },
    getProperty: (args: ItemQueryType, key: string) => {
      return getItemProperty(this, args, key)
    },
    filterItem(selectItemQueryType: SelectItemQueryType, itemQueryElement: ItemQueryType) {
      return filterItem(this, selectItemQueryType, itemQueryElement);
    }
  }

  locationGraph = {
    createLocationGraph: (ref:string) => {
      return createLocationGraph(this, ref)
    },
    createGraphNode: (locationGraph: LocationGraphQueryType, ref:string) => {
      return createGraphNode(this, locationGraph, ref)
    },
    createAdjacent: (locationGraphRef: string, nodeRef: string) => {
      return createAdjacent(this, locationGraphRef, nodeRef)
    }
  }

  person = {
    selectPerson: (selectPersonQueryType: SelectPersonQueryType, position?: Position) => {
      return selectPerson(this, selectPersonQueryType, position);
    },
    applyPropertyMutation: (personQueryType: PersonQueryType, propertyMutation:PropertyMutationQueryType, getPropertyTarget? :(key:string) => string) => {
      return applyPropertyMutation(this, personQueryType, propertyMutation, getPropertyTarget)
    },
    getProperty: (personQueryType: PersonQueryType, key) => getPersonProperty(this, personQueryType, key),
    setProperty: (personQueryType: PersonQueryType, key, value: string) => setProperty(this, personQueryType, key, value),
    getById: memoizeFunction((id: string): PersonQueryType => {
      return getById(this.json, id)
    }),
    classifyPerson: (personQueryType: PersonQueryType) => {
      return classifyPerson(this, personQueryType);
    },
    getDistance: memoizeFunction((personQueryType: PersonQueryType, secondPersonQueryType: PersonQueryType) => {
      const x = Number(personQueryType.queryOptional("location")?.attributeMap.x);
      const y = Number(personQueryType.queryOptional("location")?.attributeMap.y);
      const x2 = Number(secondPersonQueryType.queryOptional("location")?.attributeMap.x);
      const y2 = Number(secondPersonQueryType.queryOptional("location")?.attributeMap.y);
      const distance = Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2))
      if (isNaN(distance)) {
        return;
      }
      return distance;
    }),
  }

  markov = markovNext;

  getRuleGroups = (): Array<JsonSchema["children"]["rule_group"]> => {
    return this.json.queryAll("rule_group");
  }

}