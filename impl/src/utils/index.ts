import {locationGrid} from "./location/locationGrid";
import {locationMarkovChainMatrix} from "./location/locationMarkovChainMatrix";
import {markovNext} from "./markovNext";
import {create} from "./location/create";
import {questMarkov} from "./questMarkov";
import {JsonSchema} from "./JsonSchema";
import {newRandom} from "./newRandom";
import {XMLBuilder} from "fast-xml-parser";

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
  constructor(public jsonSchema: JsonSchema) {
    this.random = newRandom(this.jsonSchema);
  }

  random: () => number;

  location = {
    grid: memoizeFunction(() => {
      return locationGrid(this)
    }),

    markovChainMatrix: memoizeFunction((direction: string) => {
      return locationMarkovChainMatrix(this, direction)
    }),

    create: memoizeFunction((x: number, y: number) => {
      return create(x, y)(this)
    })
  }
  markov = markovNext

  questMarkov = memoizeFunction(() => {
    questMarkov(this)
  })

  writeToString = () => {
    return new XMLBuilder({
      attributeNamePrefix: "",
      attributesGroupName: "$",
      format: true,
      ignoreAttributes: false,
      suppressEmptyNode: true,
    }).build(this.jsonSchema)

  }


}