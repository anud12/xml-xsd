/**
 * for each file in tests/blackbox named index.test.ts
 * 1. extract the description
 * create a file in ../documentation with the same name as path to the file replacing "/" with "__" and ".test.ts" with ".md"
 * write the description to the file
 *
 */


import {readFileSync} from "fs";
import {readdirSync, watch, writeFileSync} from "node:fs";
import * as fs from "fs";

const outputPath = "./documentation";
const indexFile = `${outputPath}/index.md`




const inputRelativePath = `1_input.xml`
const expectedRelativePath = `2_expected.xml`

const sideBySideTable = (path:string) => {
  if(!fs.existsSync(`${path}/${inputRelativePath}`)) {
    return "";
  }
  if(!fs.existsSync(`${path}/${expectedRelativePath}`)) {
    return "";
  }

  const inputXmlFile = readFileSync(`${path}/${inputRelativePath}`, "utf-8");
  const expectedXmlFile = readFileSync(`${path}/${expectedRelativePath}`, "utf-8");
  return `
<table>
<tr>
<th>1_input.xml</th>
<th>2_expected.xml</th>
</tr>
<tr>
<td style="vertical-align:top">
  
\`\`\`xml
${inputXmlFile}
\`\`\`
  
</td>
<td style="vertical-align:top">

\`\`\`xml
${expectedXmlFile}
\`\`\`

</td>
</tr>
</table>
`
}

const watchFolder = (folderPath: string, callback: () => void) => {
  callback();
  if (process.argv.includes("-w")) {
    watch(folderPath, (eventType, filename) => {
      if (filename) {
        if (fs.existsSync(outputPath)) {
          fs.rmSync(outputPath, {recursive: true});
        }
        if(fs.existsSync(indexFile)) {
          fs.rmSync(indexFile);
        }
        //create documentation folder
        fs.mkdirSync(outputPath);

        writeFileSync(indexFile, `# Index\n\n`, {flag: "w"});
        readDirectory("../specification-test/src/test/java/ro/anud/xml_xsd/specification/analyze", "Test.java", false);
      }
    });
  }

};


const readDirectory = (path: string, fileName:string, watch:boolean = true) => {
  console.log("Reading directory:", path);
  const directory = readdirSync(path, {withFileTypes: true});
  directory?.forEach(dirent => {
    if (dirent.isDirectory()) {
      readDirectory(`${path}/${dirent.name}`, fileName, watch)
    } else {
      if (dirent.name.includes(fileName)) {

        const testFile = readFileSync(`${path}/${dirent.name}`, "utf-8");
        const description = testFile?.split("/*description")[1]?.split("*/")[0]?.trim();
        const tags = testFile?.split("/*tags")[1]?.split("*/")[0]?.trim();

        const fileName = path.replace(/\//g, "__").replace("src__tests__blackbox", "documentation") + ".md";
        let fileContent = `[Index](./index.md)\n${description ?? ""}`;
        fileContent += sideBySideTable(path);
        writeFileSync(`${outputPath}/${fileName}`, fileContent, {flag: "w"});

        const inputXmlFile = readFileSync(`${path}/${inputRelativePath}`, "utf-8").toString();
        const inputXmlString = `#### Input XML\n\`\`\`xml\n${inputXmlFile}\n\`\`\``;

        writeFileSync(indexFile, `## [${path.replace("/src/tests/analyze", "")}](./${fileName})\n\n#### Tags:\n${tags}\n\n${inputXmlString}\n\n`, {flag: "a"});
      }

    }
  })
  if(watch) {
    watchFolder(path, () => {

    })
  }
}

const start = () => {

  //delete documentation folder
  if (fs.existsSync(outputPath)) {
    fs.rmSync(outputPath, {recursive: true});
  }
  if(fs.existsSync(indexFile)) {
    fs.rmSync(indexFile);
  }
  //create documentation folder
  fs.mkdirSync(outputPath);

  writeFileSync(indexFile, `# Index\n\n`, {flag: "w"});
  readDirectory("../specification-test/src/test/java/ro/anud/xml_xsd/specification/analyze", "Test.java");
}
start();
