import {LocationGrid, locationGrid} from "./location/locationGrid";
import {locationMarkovChainMatrix, LocationMatrix} from "./location/locationMarkovChainMatrix";
import {markovNext} from "./markovNext";
import {create} from "./location/create";
import {JsonSchema, OperationQueryType} from "./JsonSchema";
import {newRandom} from "./newRandom";
import {createOperationFromQueryType} from "./operation/createOperationFromQueryType";
import {getProperty, PersonQueryType} from "./person/getProperty";
import {getById} from "./person/getById";
import {createPerson, CreatePersonArgs} from "./person/createPerson";
import {createOperationFromParent} from "./operation/createOperationFromParent";
import {JsonQueryType} from "../JsonQueryType";
import {
  calculateNameFromChildren,
  calculateNameFromRefString, NameRuleEntryQueryType,
  NameTokenQueryTypeChild
} from "./calculateName";
import {CreateItemArgs, createItemAt} from "./item/createItemAt";
import {classifyPerson} from "./person/classifyPerson";

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

  randomListFromArray = <T>(originalArray: T[], numberOfElements: number = 1): T[] =>{
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

  randomFromArray = <T>(array: T[], numberOfElements: number = 1): T => {
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
      return String(Number(value)+ 1)
    })
    return attribute;
  }
  computeOperation = (operationQueryType: OperationQueryType["childrenList"][number], getExternalProperty?: (string: string) => string) => {
    return createOperationFromQueryType(this, operationQueryType, getExternalProperty)
  }
  computeOperationFromParent = (operationList: OperationQueryType, getExternalProperty?: (string: string) => string) => {
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

    calculateNameFromChildren: memoizeFunction((element: NameRuleEntryQueryType) => {
      return calculateNameFromChildren(this, element);
    })
  }


  item = {
    createItemAt: (args:CreateItemArgs) => {
      return createItemAt(this, args);
    }
  }

  person = {
    getProperty: (personQueryType: PersonQueryType, key) => getProperty(this, personQueryType, key),
    getById: memoizeFunction((id: string): PersonQueryType => {
      return getById(this.json, id)
    }),
    classifyPerson: (personQueryType: PersonQueryType) => {
      return classifyPerson(this, personQueryType);
    },
    getDistance: memoizeFunction((personQueryType: PersonQueryType, secondPersonQueryType: PersonQueryType) => {
      const x = Number(personQueryType.query("location").attributeMap.x);
      const y = Number(personQueryType.query("location").attributeMap.y);
      const x2 = Number(secondPersonQueryType.query("location").attributeMap.x);
      const y2 = Number(secondPersonQueryType.query("location").attributeMap.y);
      return Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2));
    }),
    create: (args: CreatePersonArgs) => createPerson(this, args)
  }

  markov = markovNext;

  getRuleGroups = ():Array<JsonSchema["children"]["rule_group"]> => {
    return this.json.queryAll("rule_group");
  }


}