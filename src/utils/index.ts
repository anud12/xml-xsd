import {locationGrid} from "./locationGrid";
import {locationMarkovChainMatrix} from "./locationMarkovChainMatrix";
import {markovNext} from "./markovNext";
import {newLocation} from "./newLocation";
import {questMarkov} from "./questMarkov";
import {JsonSchema} from "./JsonSchema";

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
  newLocation: newLocation,
  questMarkov: questMarkov,
}

export class JsonUtil {
  constructor(public jsonSchema: JsonSchema) {
  }

  locationGrid = memoizeFunction(() => {
    return locationGrid(this)
  })
  locationMarkovChainMatrix = memoizeFunction((direction: string) => {
    return locationMarkovChainMatrix(this, direction)
  })
  markov = markovNext

  newLocation = memoizeFunction((x: number, y: number) => {
    return newLocation(x, y)(this)
  })

  questMarkov = memoizeFunction(() => {
    questMarkov(this)
  })

}