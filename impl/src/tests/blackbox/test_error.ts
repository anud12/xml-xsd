import {executeFromStringToString, StringArguments} from "../../execute";
import xmlFormat from "xml-formatter";
import * as fs from "fs";
import * as path from "path";

export const test_error = async (dirname:string,...stringArguments: Array<StringArguments>):Promise<void> => {
  const input = fs.readFileSync(`${dirname}/1_input.xml`, "utf-8");
  const targetDir = fs.readdirSync(dirname)
    .find(file => file.startsWith('2_expected'));
  const expected = fs.readFileSync(path.join(dirname, targetDir), 'utf8').replace(/\r/g, "");
  try {
    await executeFromStringToString(input, () => {
    },stringArguments);
    throw new Error("Expected error")
  } catch (e:any) {
    const error = e as Error;
    const result = error.message.replace(/\r/g, "");
    expect(xmlFormat(result, {throwOnFailure: false,}))
      .toBe(xmlFormat(expected, {throwOnFailure: false,}))
    return;
  }


}