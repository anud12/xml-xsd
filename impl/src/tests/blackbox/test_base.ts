import {executeFromStringToString, StringArguments} from "../../execute";
import xmlFormat from "xml-formatter";
import * as fs from "fs";
import * as path from "path";

export const testBase = (dirname:string, ...stringArguments: Array<StringArguments>) => {
  const input = fs.readFileSync(`${dirname}/1_input.xml`, "utf-8");
  const targetDir = fs.readdirSync(dirname)
    .find(file => file.startsWith('2_expected'));
  const expected = fs.readFileSync(path.join(dirname, targetDir), 'utf8').replace(/\r/g, "");
  return {
    name: dirname.split("tests")[1],
    success: async () => {
      const result = (await executeFromStringToString(input, () => {
      }, stringArguments)).replace(/\r/g, "");
      expect(xmlFormat(result, {throwOnFailure: false,}))
        .toBe(xmlFormat(expected, {throwOnFailure: false,}))
    },
    error: async () => {
      try {
        await executeFromStringToString(input, () => {
        }, stringArguments);
      } catch (e: any) {
        const error = e as Error;
        const result = error.message.replace(/\r/g, "");
        expect(xmlFormat(result, {throwOnFailure: false,}))
          .toBe(xmlFormat(expected, {throwOnFailure: false,}))
        return;
      }
      throw new Error("Expected error")
    }
  }
}
