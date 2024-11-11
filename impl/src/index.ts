import {WebSocketServer} from 'ws';
import {validateString} from "./validate";
import {executeFromString} from "./execute";
import {JsonSchema} from "./utils/JsonSchema";
import {launchWebserver} from "./launchWebserver";

const express = require("express");

const port = process.argv.includes('--port') ? process.argv[process.argv.indexOf('--port') + 1] : 8080;
const noWebSocket = process.argv.includes('--no-websocket');

console.log("arg --port:", port);
console.log("arg --noWebSocket:", noWebSocket);


const launchWebsocket = (onMessage: (string: string) => Promise<string>) => {
  const wss = new WebSocketServer({port: Number(port)});

  wss.on('connection', (ws) => {
    console.log('Client connected');

    ws.on('message', async (message) => {
      // console.log(`Received message: ${message}`);
      onMessage(message.toString())
        .then(response => {
          // console.log(`Sending response: ${response}`)
          ws.send(response)
          ws.close();
        });
    });

    ws.on('close', () => {
      console.log('Client disconnected');
    });
  });

  console.log(`WebSocket server is running on ws://localhost:${Number(port)}`);
}

if(noWebSocket) {
  launchWebserver(port)
}

if(!noWebSocket) {
  (async () => {
    launchWebsocket(async data => {
      const dataString = data.toString();
      const errors = await validateString(dataString, console.log);
      if (errors?.length) {
        throw new Error(errors.map(e => e.message).join("\n"));
      }
      const outJson = await executeFromString(data.toString(), console.log) as JsonSchema;
      return outJson.serialize();
    })
  })()

}
