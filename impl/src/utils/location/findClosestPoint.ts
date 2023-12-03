// Function to find the coordinates of a line between two points

export type Grid<T> = Record<number, Record<number, T>> & {
    maxX: number,
    maxY: number
}

export function findClosestPoint<T>(locationGrid: Grid<T>, x: number, y: number): T | null {
    if(isNaN(x)) {
        throw new Error("x is NaN")
    }
    if(isNaN(y)) {
        throw new Error("y is NaN")
    }
    let closestPoint: T | null = null;
    let minDistance: number | null = null;

    for (const i in locationGrid) {
        const rowX = Number(i);

        for (const j in locationGrid[i]) {
            const rowY = Number(j);
            const cell = locationGrid[i][j];
            const distance = Math.sqrt((x - rowX) ** 2 + (y - rowY) ** 2);

            if (minDistance === null || distance < minDistance) {
                minDistance = distance;
                closestPoint = cell;
            }
        }
    }

    return closestPoint;
}