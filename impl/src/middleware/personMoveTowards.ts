import {Middleware} from "../utils/middleware";
import {InferJsonNodeAttribute, JsonQueryType} from "../JSONQuery";

type CoordinatesNode = JsonQueryType<"x" | "y">;
type CoordinatesAttributes = InferJsonNodeAttribute<CoordinatesNode>

const calculateDestinationCoordinate = (initial: CoordinatesNode, destination: CoordinatesNode, distanceString: string): CoordinatesAttributes => {
  // Calculate the Euclidean distance between initial and destination coordinates
  const distance = Number(distanceString);

  const initialX = Number(initial.$x);
  const initialY = Number(initial.$y);

  const destinationX = Number(destination.$x);
  const destinationY = Number(destination.$y);

  const deltaX = destinationX - initialX;
  const deltaY = destinationY - initialY;
  const currentDistance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

  // Check if the current distance is greater than or equal to the given distance
  if (distance >= currentDistance) {
    return destination; // Return the destination coordinate
  } else {
    // Calculate the new coordinate by moving a fraction of the distance
    const fraction = distance / currentDistance;

    // const newX = (initialX + deltaX) * fraction;
    const newX = initialX + (destinationX - initialX) * fraction
    const newY = initialY + (destinationY - initialY) * fraction
    // const newY = (initialY + deltaY) * fraction;

    // Round the coordinates down to integers
    return {
      $x: String(Math.floor(newX)),
      $y: String(Math.floor(newY)),
    }; // Return the new coordinate
  }
}

export const personMoveTowards: Middleware = readUnit => {
  const personList = readUnit.json.queryAll("people")
    .flatMap(people => people.queryAll("person"));
  const raceMetadata = readUnit.json.queryAll("race_metadata")
    .flatMap(raceMetadata => raceMetadata.queryAll("entry"))
  const actions = readUnit.json.queryAll("actions")
    .flatMap(e => e.queryAllOptional("by"))
    .flatMap(by => {
      return by.queryAllOptional("move_towards").flatMap(moveTowards => {

        const person = personList.find(person => person.$id === by.$person);
        const race = raceMetadata.find(race => race.$name === person.query("race").$name)

        const movement = race.query("movement").$value

        const location = person.query("location")

        const newDestinationAttributes = calculateDestinationCoordinate(location, moveTowards, movement)
        return {
          person,
          destinationAttributes: moveTowards,
          newDestinationAttributes: newDestinationAttributes
        }
      })
    })
  return async writeUnit => {
    const persons = writeUnit.queryAll("people").flatMap(e => e.queryAll("person"))
    actions.forEach(action => {
      const person = persons.find(e => e.$name === action.person.$name);
      const location = person.query("location")
      location.$x = action.newDestinationAttributes.$x
      location.$y = action.newDestinationAttributes.$y

      if (location.$x === action.destinationAttributes.$x && location.$y === action.destinationAttributes.$y) {
        writeUnit.queryAllOptional("actions")
          .flatMap(e => e.queryAllOptional("by"))
          .filter(e => e.$person === action.person.$name)
          .filter(e => e.queryAllOptional("move_towards"))
          .forEach(e => {
            e.removeFromParent();
          });
      }

    });

  }
}