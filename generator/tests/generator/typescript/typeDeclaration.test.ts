import {typeDeclarationToString} from "../../../src/generator/typescript/typeToString";
import {typeDeclarationDataSets} from "../typeDeclaration";
import {template} from "../../../src/template/template";


it("should correctly handle primitive types" satisfies keyof typeof typeDeclarationDataSets , () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
      export type test = string
      `);
})

it("should correctly handle recursive types" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
      export type test = JsonQueryType<{}, {
        "prop": number & JsonQueryType<{}, {}>;
      }>
      `);
})

it("should correctly handle recursive types with mixed levels of depth" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
      export type test = JsonQueryType<{}, {
        "level1": JsonQueryType<{}, {
          "level2": boolean & JsonQueryType<{}, {}>;
          "anotherLevel2": string & JsonQueryType<{}, {}>;
        }> & JsonQueryType<{}, {}>;
        "anotherLevel1": number & JsonQueryType<{}, {}>;
      }>
      `);
})


it("should correctly handle composition types" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
      export type test = string
        & number
      `);
})


it("should correctly handle composition types with recursive types" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
      export type test = JsonQueryType<{}, {
        "prop1": string & JsonQueryType<{}, {}>;
      }>
        & JsonQueryType<{}, {
        "prop2": number & JsonQueryType<{}, {}>;
      }>
      `);
})

it("should correctly handle object type with attributes" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
      export type test = JsonQueryType<{"attr": number;}, {
        "prop": string & JsonQueryType<{}, {}>;
      }>
      `);
})