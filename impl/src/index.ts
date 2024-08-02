import {WebSocketServer} from 'ws';
import {validateString} from "./validate";
import {executeFromString} from "./execute";
import {JsonSchema} from "./utils/JsonSchema";

const launchServer = (onMessage: (string:string) => Promise<string>) => {
  const wss = new WebSocketServer({ port: 8080 });

  wss.on('connection', (ws) => {
    console.log('Client connected');

    ws.on('message', async (message) => {
      console.log(`Received message: ${message}`);
      onMessage(message.toString())
        .then(response => {
          console.log(`Sending response: ${response}`)
          ws.send(response)
          ws.close();
        });
    });

    ws.on('close', () => {
      console.log('Client disconnected');
    });
  });

  console.log('WebSocket server is running on ws://localhost:8080');
}



(async () => {
  launchServer(async data => {
    const dataString = data.toString();
    const errors = await validateString(dataString, console.log);
    if(errors?.length) {
      throw new Error(errors.map(e => e.message).join("\n"));
    }
    const outJson = await executeFromString(data.toString(), console.log) as JsonSchema;
    return outJson.serialize();
  })
})()
