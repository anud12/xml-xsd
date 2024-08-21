const {context} = require("./esbuild_context");

context.then(async (context) => {
    await context.watch();
    await context.dispose();
})