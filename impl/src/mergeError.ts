export const mergeError = (oldError:Error, newError:Error):Error => {
  const mergedError = new Error(`${newError.message}\n${oldError.message}`);
  mergedError.stack += '\nCaused by: ' + newError.stack;
  return mergedError;
}