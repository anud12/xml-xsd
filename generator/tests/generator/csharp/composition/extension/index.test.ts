import {typeDeclarationToString} from "../../../../../src/generator/csharp/typeToString";
import {typeDeclarationDataSets} from "../../../typeDeclarationDataSets";
import * as path from "node:path";

const fs = require("fs");

export const description = ``

describe("should correctly handle element that extends a base complex type" satisfies keyof typeof typeDeclarationDataSets, () => {

  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  // result.getAllFilesRecursively().forEach(file => {
  //   console.log(file.name, file.data());
  //   const filePath = `${__dirname}/${file.getStringPathToRoot()}`
  //   it(file.getStringPathToRoot(), () => {
  //     expect(file.data()).toEqual(fs.readFileSync(filePath, "utf-8").replace(/\r\n/g, '\n').toString())
  //   })
  // })
  expect(result).toEqual(fs.readFileSync(`${__dirname}/output.txt`, "utf-8").replace(/\r\n/g, '\n').toString())
})