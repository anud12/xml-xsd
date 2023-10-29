import {jsonSchema} from "../";
import {Command} from "./commandType";

export const status:Command<[string]> = {
  key: "status",
  action: async (personName:string) => {
    const person = jsonSchema.queryAll("people")
      .flatMap(e => e.queryAll("person"))
      .find(e => e.$name === personName);
    // Handle the "stats" commandconsole.log(`Person Name: ${personName}`);
    console.log(`Race: ${person.query("race").$name}`);
    console.log(`Location: X: ${person.query("location").$x}, Y: ${person.query("location").$y}`);
    console.log('Relations:');
    console.log('Properties:');
    person.query("properties").queryAllOptional("property").forEach((property) => {
      console.log(`  - ${property.$ref}: ${property.$value}`);
    });
    // console.log('Inventory:');
    // person.query("inventory").queryAllOptional("item").forEach((item) => {
    //   console.log(`  - ${item.$ref} (Equipped: ${item.$equipped ? 'Yes' : 'No'})`);
    // });
  }
}