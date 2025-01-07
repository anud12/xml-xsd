import {validateString} from "./validate";
import {executeFromString} from "./execute";
import {JsonSchema} from "./utils/JsonSchema";

const express = require("express");

export const launchWebserver = (port:string | number, callback?: (server) => void) => {
  console.log(`Launching http://localhost:${port}`)

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
        callback?.(server);
        return;
      }
      const outJson = await executeFromString(req.body, console.log) as JsonSchema;
      res.setHeader("Content-Type", "text/plain");
      res.send(outJson.serialize());
      callback?.(server);
    } catch (e) {
      callback?.(server);
      res.status(500).send(e.stack);
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
        callback?.(server);
        return;
      }
      callback?.(server);
      res.send(outJson.serialize());
    } catch (e) {
      console.log(`Sending ${e}`)
      callback?.(server);
      res.status(500).send(e.stack);
    }
  });

  const server = app.listen(port , () => {
    console.log(`Server running on http://localhost:${port}`)
  });
  return () => {
    server.close();
  }
}