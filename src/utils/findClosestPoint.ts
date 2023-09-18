// Function to find the coordinates of a line between two points
import {Cell, LocationGrid} from "./location/locationGrid";

export function findClosestPoint(locationGrid: LocationGrid, x: number, y: number): Cell | null {
  let closestPoint: Cell | null = null;
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