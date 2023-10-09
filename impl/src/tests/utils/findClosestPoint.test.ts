import {findClosestPoint} from "../../utils/findClosestPoint";

describe("", () => {
    test("", () => {
        let grid = {
            maxX: 0,
            maxY: 0,
            0: {
                0: "0-0"
            }
        }
        const d = findClosestPoint<string>(grid, 10, 30)
        console.log(d);
    })
})