import {typeDeclarationDataSets} from "../../../../typeDeclarationDataSets";
import {typeDeclarationToString} from "../../../../../../src/generator/csharp/typeToString";

const testName = "should correctly handle object type with attributes" satisfies keyof typeof typeDeclarationDataSets;
describe(testName, () => {
    const rootDirectory = typeDeclarationToString(typeDeclarationDataSets[testName as string]);
    rootDirectory
      .getAllFilesRecursively()
      .forEach(file => {
        const pathObject = require("path").join(...file.getStringPathFromRoot().split("/"));
        const fullPath = `${__dirname}/${pathObject.toString()}`;
        let expected = undefined;
        try {
          expected = require("fs").readFileSync(fullPath, "utf-8");
        } catch (e) {

        }
        it(file.getStringPathFromRoot(), () => {
          expect(file.data()).toEqual(expected);
        })
      })
  }
)