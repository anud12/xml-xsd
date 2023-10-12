import {LocationGrid, locationGrid} from "./location/locationGrid";
import {locationMarkovChainMatrix, LocationMatrix} from "./location/locationMarkovChainMatrix";
import {markovNext} from "./markovNext";
import {create} from "./location/create";
import {questMarkov} from "./questMarkov";
import {JsonSchema, OperationQueryType} from "./JsonSchema";
import {newRandom} from "./newRandom";
import {Unit} from "./middleware";
import {computeOperation} from "./operation/computeOperation";

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
  questMarkov: () => void;
  computeOperation = (operationQueryType:OperationQueryType, getExternalProperty?: (string:string) => string) => {
    return computeOperation({
      util:this,
      json: this.jsonQuery
    }, operationQueryType, getExternalProperty)
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
        },x, y)
      })
    }
    this.questMarkov = memoizeFunction(() => {
      questMarkov(this)
    })
  }

  markov = markovNext;


}