var blessed = require('blessed');

// Create a screen object.
var screen = blessed.screen({
    smartCSR: true,
    dockBorders: true,
});

screen.title = 'my window title';

// Create a box perfectly centered horizontally and vertically.
var box = blessed.box({
    content: 'Hello world!',
    border: "line",
    width: 10,
    height: 15,
});

// Append our box to the screen.
// screen.append(box);
// screen.append(blessed.box({
//     content: 'Second box',
//     width: 10,
//     height: 5,
//     border: "line",
//     style: {
//         fg: 'magenta',
//         hover: {
//             bg: 'green'
//         }
//     }
// }))

const layout = blessed.layout({
    width: 20,
    height: 10,
    dockBorders: true,
    border:"line"
})

layout.append(blessed.box({
    content: 'Second box',
    // border: "line",
    style: {
        fg: 'magenta',
        hover: {
            bg: 'green'
        }
    }
}))

layout.append(blessed.box({
    content: 'Second box with large text that wraps and keeps going',
    scrollable: true,
    scrollbar:true,
    border: "line",
    style: {
        fg: 'magenta',
        hover: {
            bg: 'green'
        }
    }
}))

screen.append(layout)


// Quit on Escape, q, or Control-C.
screen.key(['escape', 'q', 'C-c'], function (ch, key) {
    return process.exit(0);
});

// Focus our element.
// box.focus();

// Render the screen.
screen.render();