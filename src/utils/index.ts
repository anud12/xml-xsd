import {locationGrid} from "./locationGrid";
import {locationMarkovChainMatrix} from "./locationMarkovChainMatrix";
import {markovNext} from "./markovNext";
import {newLocation} from "./newLocation";
import {questMarkov} from "./questMarkov";

export const utils = {
  locationGrid: locationGrid,
  locationMarkovChainMatrix: locationMarkovChainMatrix,
  markov: markovNext,
  newLocation: newLocation,
  questMarkov: questMarkov,
}