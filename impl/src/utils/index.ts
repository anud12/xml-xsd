import {LocationGrid, locationGrid} from "./location/locationGrid";
import {locationMarkovChainMatrix, LocationMatrix} from "./location/locationMarkovChainMatrix";
import {markovNext} from "./markovNext";
import {create} from "./location/create";
import {questMarkov} from "./questMarkov";
import {JsonSchema, OperationQueryType} from "./JsonSchema";
import {newRandom} from "./newRandom";
import {createOperationFromQueryType} from "./operation/createOperationFromQueryType";
import {getProperty, PersonQueryType} from "./person/getProperty";
import {getById} from "./person/getById";
import {createPerson, CreatePersonArgs} from "./person/createPerson";
import {JsonQueryType} from "../JSONQuery";
import {createOperationFromParent} from "./operation/createOperationFromParent";
import {json} from "stream/consumers";

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
  questMarkov: questMarkov,
}

export class JsonUtil {
  constructor(public jsonQuery: JsonSchema) {
    this.invalidate();
  }

  random: () => number;
  location: {
    grid: () => LocationGrid,
    markovChainMatrix: (direction: string) => LocationMatrix,
    create: (x: number, y: number) => void,
  }

  randomFromArray = <T>(array: T[]): T => {
    return array[Math.floor(this.random() * array.length)];
  }
  questMarkov: () => void;

  counterNext = () => {
    const counter = this.jsonQuery.query("world_metadata").query("counter");
    const next = Number(counter.$value);
    counter.$value = String(next + 1);
    return next;
  }
  computeOperation = (operationQueryType: OperationQueryType, getExternalProperty?: (string: string) => string) => {
    return createOperationFromQueryType({
      util: this,
      json: this.jsonQuery
    }, operationQueryType, getExternalProperty)
  }
  computeOperationFromParent = (operationList: JsonQueryType<any, {
    operation: OperationQueryType
  }>, getExternalProperty?: (string: string) => string) => {
    return createOperationFromParent({
        util: this,
        json: this.jsonQuery
      },
      operationList,
      getExternalProperty)
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
        return create({
          util: this,
          json: this.jsonQuery
        }, x, y)
      })
    }
    this.questMarkov = memoizeFunction(() => {
      questMarkov(this)
    })
  }

  person = {
    getProperty: (personQueryType: PersonQueryType, key) => getProperty({
      util: this,
      json: this.jsonQuery
    }, personQueryType, key),
    getById: memoizeFunction((id: string): PersonQueryType => {
      return getById(this.jsonQuery, id)
    }),
    create: (args: CreatePersonArgs) => createPerson(this, args)
  }

  markov = markovNext;


}