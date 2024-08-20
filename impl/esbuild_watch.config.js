const {context} = require("./esbuild_context");

context.then((context) => {
    return context.watch()
    .catch(() => process.exit(1));
})