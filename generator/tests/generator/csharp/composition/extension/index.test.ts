import {typeDeclarationToString} from "../../../../../src/generator/csharp/typeToString";
import {typeDeclarationDataSets} from "../../../typeDeclarationDataSets";

const fs = require("fs");

export const description = ``

it("should correctly handle element that extends a base complex type" satisfies keyof typeof typeDeclarationDataSets, () => {

  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(fs.readFileSync(`${__dirname}/output.txt`, "utf-8").replace(/\r\n/g, '\n').toString())
})