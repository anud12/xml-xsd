import {TypeDeclaration} from "../../src/type";
import FastXMLParser from "fast-xml-parser";
import {generateTypes} from "../../src/src";
import {testCases} from "./commonTestCases";


export function testSchema(fileSchema:string): TypeDeclaration[] {
  const parser = new FastXMLParser.XMLParser({ignoreAttributes: false, attributeNamePrefix: ''});
  const schema = parser.parse(fileSchema);
  return  generateTypes(schema);
}


describe("commonTestCases", () => {
  testCases.forEach(value => {
    it(value.description, () => {
      let resultTypes = testSchema(value.schema);
      expect(resultTypes).toEqual(value.type);
    })
  })

})
