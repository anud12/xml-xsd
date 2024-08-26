/**
 * for each file in tests/blackbox named index.test.ts
 * 1. extract the description
 * create a file in ../documentation with the same name as path to the file replacing "/" with "__" and ".test.ts" with ".md"
 * write the description to the file
 *
 */


import {readFileSync} from "fs";
import {readdirSync, writeFileSync} from "node:fs";
import * as fs from "fs";

const outputPath = "./documentation";
const indexFile = `${outputPath}/index.md`

//delete documentation folder
if (fs.existsSync(outputPath)) {
  fs.rmdirSync(outputPath, {recursive: true});
}
//create documentation folder
fs.mkdirSync(outputPath);

writeFileSync(indexFile, `# Index\n\n`, {flag: "w"});


const sideBySideTable = (path:string) => {
  if(!fs.existsSync(`${path}/1_input.xml`)) {
    return "";
  }
  if(!fs.existsSync(`${path}/2_expected.xml`)) {
    return "";
  }

  const inputXmlFile = readFileSync(`${path}/1_input.xml`, "utf-8");
  const expectedXmlFile = readFileSync(`${path}/2_expected.xml`, "utf-8");
  return `
<table>
<tr>
<th>1_input.xml</th>
<th>2_expected.xml</th>
</tr>
<tr>
<td>
  
\`\`\`xml
${inputXmlFile}
\`\`\`
  
</td>
<td>

\`\`\`xml
${expectedXmlFile}
\`\`\`

</td>
</tr>
</table>
\``
}


const readDirectory = (path: string) => {
  const directory = readdirSync(path, {withFileTypes: true});
  directory?.forEach(dirent => {
    if (dirent.isDirectory()) {
      readDirectory(`${path}/${dirent.name}`)
    } else {
      if (dirent.name === "index.test.ts") {

        const testFile = readFileSync(`${path}/${dirent.name}`, "utf-8");
        const description = testFile?.split("/*description")[1]?.split("*/")[0]?.trim();
        const tags = testFile?.split("/*tags")[1]?.split("*/")[0]?.trim();

        const fileName = path.replace(/\//g, "__").replace("src__tests__blackbox", "documentation") + ".md";
        let fileContent = `[Index](./index.md)\n${description ?? ""}`;
        fileContent += sideBySideTable(path);
        writeFileSync(`${outputPath}/${fileName}`, fileContent, {flag: "w"});

        writeFileSync(indexFile, `## [${path.replace("/src/tests/blackbox", "")}](./${fileName})\n\n### Tags:\n${tags}\n\n`, {flag: "a"});
      }

    }
  })
}
readDirectory("./src/tests/blackbox");
