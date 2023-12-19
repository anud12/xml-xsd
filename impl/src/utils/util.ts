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

  random: () => number;
  location: {
    grid: () => LocationGrid,
    markovChainMatrix: (direction: string) => LocationMatrix,
    create: (x: number, y: number) => void,
  }

  randomFromArray = <T>(array: T[]): T => {
    return array[Math.floor(this.random() * (array.length - 1))];
  }
  questMarkov: () => void;

  counterNext = () => {
    const counter = this.json.query("world_metadata").query("counter");
    counter.setAttribute("value", value => {
      return String(Number(value)+ 1)
    })
    return counter.getAttribute("value");
  }
  computeOperation = (operationQueryType: OperationQueryType["childrenList"][number], getExternalProperty?: (string: string) => string) => {
    return createOperationFromQueryType(this, operationQueryType, getExternalProperty)
  }
  computeOperationFromParent = (operationList: JsonQueryType<any, {
    operation: OperationQueryType
  }>, getExternalProperty?: (string: string) => string) => {
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

  person = {
    getProperty: (personQueryType: PersonQueryType, key) => getProperty(this, personQueryType, key),
    getById: memoizeFunction((id: string): PersonQueryType => {
      return getById(this.json, id)
    }),
    getDistance: memoizeFunction((personQueryType: PersonQueryType, secondPersonQueryType: PersonQueryType) => {
      const x = Number(personQueryType.query("location").getAttribute("x"));
      const y = Number(personQueryType.query("location").getAttribute("y"));
      const x2 = Number(secondPersonQueryType.query("location").getAttribute("x"));
      const y2 = Number(secondPersonQueryType.query("location").getAttribute("y"));
      return Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2));
    }),
    create: (args: CreatePersonArgs) => createPerson(this, args)
  }

  markov = markovNext;

  getRuleGroups = ():Array<JsonSchema["children"]["rule_group"]> => {
    return this.json.queryAll("rule_group");
  }


}