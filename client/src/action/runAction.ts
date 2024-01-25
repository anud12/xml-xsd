import {JsonUtil} from "demo/src/utils/util";
import {execute} from "demo/src/execute";
import {clearInterval} from "node:timers";

let interval: undefined | (() => void );


const executeInterval = (func: () => Promise<void>, interval) => {
  let isRunning = true;
  async function myFunction() {
    console.log("Executing function: " + new Date());
    // Your code here
    await func();

    setTimeout(async () => {
      console.log("Asynchronous operation completed at: " + new Date());

      if(isRunning) {
        executeInterval();
      }
    }, interval);
  }

  function executeInterval() {
    setTimeout(async () => {
      if(isRunning) {
        await myFunction();
      }; // Call your function
    }, interval);
  }
  myFunction();
  return () => isRunning = false;
}


export const runAction = async (jsonUtil: JsonUtil | undefined, onFinish: (jsonUtil:JsonUtil) => void ) => {
  console.log("called")
  if (!jsonUtil) {
    return;
  }
  if(interval) {
    interval?.();
    return
  }
    const response = await execute(jsonUtil.json, console.log)
    onFinish(new JsonUtil(response));
  //
  // interval = executeInterval(async () => {
  //   console.log("Executing")
  //   const response = await execute(jsonUtil.json, console.log)
  //   onFinish(new JsonUtil(response));
  // }, 25)
}