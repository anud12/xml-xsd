import {Middleware} from "./_type";
import {JsonQueryType} from "../JsonQueryType";

type CoordinatesNode = JsonQueryType<{
  x:string
  y:string
}>;
type CoordinatesAttributes = CoordinatesNode["attributeMap"]

const calculateDestinationCoordinate = (initial: CoordinatesNode, destination: CoordinatesNode, distanceString: string): CoordinatesAttributes => {
  // Calculate the Euclidean distance between initial and destination coordinates
  const distance = Number(distanceString);

  const initialX = Number(initial.attributeMap.x);
  const initialY = Number(initial.attributeMap.y);

  const destinationX = Number(destination.attributeMap.x);
  const destinationY = Number(destination.attributeMap.y);

  const deltaX = destinationX - initialX;
  const deltaY = destinationY - initialY;
  const currentDistance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

  // Check if the current distance is greater than or equal to the given distance
  if (distance >= currentDistance) {
    return destination.attributeMap; // Return the destination coordinate
  } else {
    // Calculate the new coordinate by moving a fraction of the distance
    const fraction = distance / currentDistance;

    // const newX = (initialX + deltaX) * fraction;
    const newX = initialX + (destinationX - initialX) * fraction
    const newY = initialY + (destinationY - initialY) * fraction
    // const newY = (initialY + deltaY) * fraction;

    // Round the coordinates down to integers
    return {
      x: String(Math.floor(newX)),
      y: String(Math.floor(newY)),
    }; // Return the new coordinate
  }
}

export const personMoveTowards: Middleware = readUnit => {
  const ruleGroup = readUnit.getRuleGroups();
  const raceMetadata = ruleGroup.flatMap(ruleGroup => ruleGroup.queryAllOptional("race_metadata"))
    .flatMap(raceMetadata => raceMetadata.queryAll("entry"))
  const personList = readUnit.json.queryAll("people")
    .flatMap(people => people.queryAll("person"));

  const actions = readUnit.json.queryAll("actions")
    .flatMap(e => e.queryAllOptional("by"))
    .flatMap(by => {
      return by.queryAllOptional("move_towards").flatMap(moveTowards => {

        const person = personList.find(person => person.attributeMap.id === by.attributeMap.person_ref);
        const race = raceMetadata.find(race => race.attributeMap.name === person.query("race").attributeMap.race_ref)

        const movement = race.query("movement").attributeMap.value

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
    const persons = writeUnit.json.queryAll("people").flatMap(e => e.queryAll("person"))
    actions.forEach(mutation => {
      const person = persons.find(e => e.attributeMap.name === mutation.person.attributeMap.name);
      const location = person.query("location")
      location.setAttribute("x", mutation.newDestinationAttributes.x)
      location.setAttribute("y", mutation.newDestinationAttributes.y)

      if (location.attributeMap.x === mutation.destinationAttributes.attributeMap.x && location.attributeMap.y === mutation.destinationAttributes.attributeMap.y) {
        writeUnit.json.queryAllOptional("actions")
          .flatMap(actions => actions.queryAllOptional("by"))
          .filter(by => by.attributeMap.person_ref === mutation.person.attributeMap.id)
          .filter(by => by.queryAllOptional("move_towards"))
          .forEach(e => {
            e.removeFromParent();
          });
      }

    });

  }
}