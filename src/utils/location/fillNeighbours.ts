import {JsonUtil} from "../index";
import {markovNext, Transition} from "../markovNext";
import {Cell, locationGrid} from "./locationGrid";

const getTransitionFromNeighbours = (json: JsonUtil, cell: Cell): Transition<string> => {
    const x = Number(cell.$.x)
    const y = Number(cell.$.y)
    const grid = json.location.grid();
    let transition = undefined;

    let element = grid?.[x]?.[y + 1];
    if (element) {
        const type = element.$.type;
        transition = json.location.markovChainMatrix("bottom")[type] ?? []
    }

    element = grid?.[x + 1]?.[y];
    if (element) {
        const type = element.$.type;
        const typeList = json.location.markovChainMatrix("left")[type]
        if (transition) {
            transition = transition.filter(e => typeList.includes(e))
        } else {
            transition = typeList
        }

    }

    element = grid?.[x]?.[y - 1];
    if (element) {
        const type = element.$.type;
        const typeList = json.location.markovChainMatrix("top")[type]
        if (transition) {
            transition = transition.filter(e => typeList.includes(e))
        } else {
            transition = typeList
        }
    }

    element = grid?.[x - 1]?.[y];
    if (element) {
        const type = element.$.type;
        const typeList = json.location.markovChainMatrix("right")[type]
        if (transition) {
            transition = transition.filter(e => typeList.includes(e))
        } else {
            transition = typeList
        }
    }
    if (!transition) {
        transition = json.location.markovChainMatrix("all")[cell.$.type]
    }
    return transition;
}
export const fillNeighbours = (writeJson: JsonUtil, originalCell: Cell, radius = 1) => {
    const grid = locationGrid(writeJson);
    const newCells = writeJson.jsonSchema.world_step[0].locations[0].cell;
    const x = Number(originalCell.$.x);
    const y = Number(originalCell.$.y);

    for (let i = -radius; i <= radius; i++) {
        for (let j = -radius; j <= radius; j++) {
            const cell = grid?.[x + i]?.[y + j];
            if (!cell) {
                const transition = getTransitionFromNeighbours(writeJson, originalCell)
                const type = markovNext(transition);
                const cell = {
                    $: {
                        type: type,
                        y: String(x + i),
                        x: String(y + j)
                    }
                };
                console.log(`Created cell: ${JSON.stringify(cell)}`)
                newCells.push(cell)
            }
        }
    }
}