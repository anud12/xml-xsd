import {WebSocketServer} from 'ws';
import {validateString} from "./validate";
import {executeFromString} from "./execute";
import {JsonSchema} from "./utils/JsonSchema";

const express = require("express");

const launchWebsocket = (onMessage: (string: string) => Promise<string>) => {
  const wss = new WebSocketServer({port: 8080});

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

  console.log('WebSocket server is running on ws://localhost:8081');
}


const app = express();
app.use(express.text())
app.get("/health", (_, res) => {
  res.send("Ok");
});

app.post("/analyze/execute", async (req, res) => {

  try {
    const dataString = req.body;
    const errors = await validateString(dataString, console.log);
    if (errors?.length) {
      const errorMessage = errors.map(e => e.message).join("\n");
      res.status(400).send(errorMessage);
      return;
    }
    const outJson = await executeFromString(req.body, console.log) as JsonSchema;
    res.setHeader("Content-Type", "text/plain");
    res.send(outJson.serialize());
  } catch (e) {
    res.status(500).send(e.message);
  }
});

app.post(`/analyze/execute/name_rule/:name_rule`, async (req, res) => {

  try {
    const dataString = req.body;
    const errors = await validateString(dataString, console.log);
    if (errors?.length) {
      const errorMessage = errors.map(e => e.message).join("\n");
      res.status(400).send(errorMessage);
      return;
    }
    const outJson = await executeFromString(req.body, console.log, [`--name_rule ${req.params.name_rule}`]) as JsonSchema;
    res.setHeader("Content-Type", "text/plain");
    if (typeof outJson === "string") {
      res.send(outJson);
      return;
    }
    res.send(outJson.serialize());
  } catch (e) {
    console.log(`Sending ${e.message}`)
    res.status(500).send(e.message);
  }
});
const port = process.argv.includes('--port') ? process.argv[process.argv.indexOf('--port') + 1] : undefined;
app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`)
});

(async () => {
  if(port) {
    return;
  }
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
