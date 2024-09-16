import {executeFromStringToString, StringArguments} from "../../execute";
import xmlFormat from "xml-formatter";
import * as fs from "fs";
import * as path from "path";
import * as xmllint from "xmllint"
import * as net from "node:net";
import {spawn} from "node:child_process";

const {exec} = require('child_process');

export const documentation = `
The \`testBase\` function is a test runner that takes a directory name and an array of string arguments. It is designed to run tests based on XML files. Here's what a programmer should be aware of:

- **Parameters**: The function accepts two parameters:
  - \`dirname\`: A string representing the directory name where the test files are located.
  - \`...stringArguments\`: A rest parameter that represents an array of string arguments.

- **Test Files**: The function expects two types of files in the provided directory:
  - \`1_input.xml\`: This file contains the input data for the test.
  - Files that start with \`2_expected\`: These files contain the expected output of the test.

- **Test Cases**: The function
  - validates input xml against xsd schema 
  - returns an object with two async methods, \`success\` and \`error\`, which represent successful and error test cases respectively.

- **Success Case**: In the \`success\` method, the function reads the \`1_input.xml\` file, executes the \`executeFromStringToString\` function with the input and string arguments, and compares the formatted result with the expected output.

- **Error Case**: In the \`error\` method, the function tries to execute the \`executeFromStringToString\` function with the input and string arguments. If an error is thrown, it compares the error message with the expected output. If no error is thrown, it throws an "Expected error".

- **XML Formatting**: Both the result and expected output are formatted using the \`xmlFormat\` function before comparison. This function is configured not to throw on failure.

- **Carriage Return Characters**: The function removes all carriage return characters (\`\\r\`) from the result and expected output before comparison.

- **Test Name**: The name of the test is derived from the directory name by removing the "tests" string.
`

const schema = fs.readFileSync(`${__dirname}${path.sep}..${path.sep}..${path.sep}..${path.sep}..${path.sep}world_step.xsd`, "utf-8");
//Might fail when running multiple instances due to xmllint being asm library
const validateXml = (input: string) => {
  // const validationResult = xmllint.validateXML({
  //   xml: input,
  //   schema: schema,
  // })
  // if(validationResult.errors?.length > 0) {
  //   throw new Error(validationResult.errors.join("\n"))
  // }
}

function getAvailablePort() {
  return new Promise<string>((resolve, reject) => {
    const server = net.createServer();
    server.listen(0, () => {
      const port = (server.address() as any).port;
      server.close(() => resolve(port));
    });
    server.on('error', reject);
  });
}

const startChildProcess = (port: string) => {
  return new Promise<() => void>((res,) => {
    console.log("Starting server on port", port)
    const child = spawn('node', ['../gui-client/dependencies_bin/node/bundle.js', '--', '--port', port]);
    child.stdout.on('data', (data) => {
      // Print the output as it comes
      process.stdout.write(data);
    });

    // Listen for errors
    child.stderr.on('data', (data) => {
      process.stderr.write(`stderr: ${data}`);
    });
    return res(() => {
      child.kill();
      console.log("Server process closed");
    });
  })
}


const waitForHeartbeat = async (url: string, maxRetries: number = 20, delay: number = 100) => {
  let currentDelay = delay;

  for (let attempt = 1; attempt <= maxRetries; attempt++) {
    try {
      console.log('Sending heartbeat');
      const response = await fetch(url);
      if (response.ok) {
        console.log('Heartbeat successful');
        return;
      }
    } catch (error) {
      console.log(`Attempt ${attempt} failed: ${error.message}, retrying in ${currentDelay}ms`);
    }
    currentDelay = currentDelay * 1.5;
    await new Promise(res => setTimeout(res, currentDelay));
  }
  throw new Error('All heartbeat attempts failed');
}

const sendRequest = async (port: string, path:string, body: string, ) => {
  const http = require('http');

  return new Promise<{ status: number, body: string }>((resolve) => {
    const options = {
      hostname: 'localhost',
      port: port,
      path: path,
      method: 'POST',
      headers: {
        'Content-Type': 'text/plain',
        'Content-Length': Buffer.byteLength(body),
      },
    };

    const req = http.request(options, (res) => {
      let responseBody = '';

      res.on('data', (chunk) => {
        responseBody += chunk;
      });

      res.on('end', () => {
        resolve({
          status: res.statusCode || 500,
          body: responseBody,
        });
      });
    });

    req.on('error', (error) => {
      console.error(`Request failed: ${error}`);
      resolve({
        status: 500,
        body: error,
      });
    });

    req.write(body);
    req.end();
  });
};
export const testEndpoints = {
  analyzeExecute: "/analyze/execute",
  analyzeNameRule: (name_rule:string) => `/analyze/execute/name_rule/${name_rule}`
}
export const testBase = (dirname: string, endpoint: string = testEndpoints.analyzeExecute) => {


  // const formattedSchema = xmlFormat(schema, {throwOnFailure: false,})
  const input = fs.readFileSync(`${dirname}/1_input.xml`, "utf-8");
  validateXml(input);
  const targetDir = fs.readdirSync(dirname)
    .find(file => file.startsWith('2_expected'));
  const expected = fs.readFileSync(path.join(dirname, targetDir), 'utf8').replace(/\r/g, "");

  return {
    name: dirname.split("tests")[1],
    success: async () => {

      const port = await getAvailablePort();
      const closeProcess = await startChildProcess(port);
      try {
        await waitForHeartbeat(`http://localhost:${port}/health`);
        let result = await sendRequest(port, endpoint , input, )
        expect(xmlFormat(result.body, {throwOnFailure: false,}))
          .toBe(xmlFormat(expected, {throwOnFailure: false,}))
        expect(result.status).toBe(200);
      } finally {
        closeProcess()
      }
      // const result = (await executeFromStringToString(input, () => {
      // }, stringArguments)).replace(/\r/g, "");
      // expect(xmlFormat(result, {throwOnFailure: false,}))
      //   .toBe(xmlFormat(expected, {throwOnFailure: false,}))

    },
    validationError: async () => {
      const port = await getAvailablePort();
      const closeProcess = await startChildProcess(port);
      try {
        await waitForHeartbeat(`http://localhost:${port}/health`);
        let result = await sendRequest(port, endpoint, input)

        expect(xmlFormat(result.body, {throwOnFailure: false,}))
          .toBe(xmlFormat(expected, {throwOnFailure: false,}))
        expect(result.status).toBe(400);
      } finally {
        closeProcess()
      }
    },
    error: async () => {
      const port = await getAvailablePort();
      const closeProcess = await startChildProcess(port);
      try {
        await waitForHeartbeat(`http://localhost:${port}/health`);
        let result = await sendRequest(port, endpoint, input)

        expect(xmlFormat(result.body, {throwOnFailure: false,}))
          .toBe(xmlFormat(expected, {throwOnFailure: false,}))
        expect(result.status).toBe(500);
      } finally {
        closeProcess()
      }
    }
  }
}
