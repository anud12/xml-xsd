const esbuild = require('esbuild');
const path = require('path');
const {readFileSync, writeFileSync} = require("fs");

const exportString = "../gui-client/dependencies_bin/node/bundle.js"
const exportPath = path.resolve(__dirname, exportString);


const replaceContentPlugin = {
    name: 'replace-content',
    setup(build) {
        build.onEnd(() => {
            replaceContent();
        });
    },
}


const context = esbuild.context({
    entryPoints: ['./src/index.ts'], // Adjust the entry point as needed
    bundle: true,
    outfile: exportPath,
    platform: 'node',
    target: 'es2022',
    format: 'cjs',
    sourcemap: true,
    treeShaking: true,
    plugins: [replaceContentPlugin],
});


const replaceContent = (filePath) => {
    if(!filePath) {
        filePath = exportPath;
    }
    console.log("Replacing syncWorkerFile require statement with null");
    const file = readFileSync(filePath, 'utf-8')

    const newFile = file.replaceAll(
        "    var syncWorkerFile = require.resolve ? require.resolve(\"./xhr-sync-worker.js\") : null;",
        "    var syncWorkerFile = null"
    );
    //replace file content
    writeFileSync(filePath, newFile, {encoding: 'utf-8', flag: 'w'});
}

module.exports = {
    context,
    replaceContent,
    replaceContentPlugin
}

