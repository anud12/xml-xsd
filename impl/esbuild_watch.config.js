const {context} = require("./esbuild_context");

context.then(async (context) => {
    return context.watch()
    .catch(() => process.exit(1));
})