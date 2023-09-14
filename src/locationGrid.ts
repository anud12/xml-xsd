export const locationGrid = (json) => {
  const location = json.world_step[0].locations[0].location;

  const xLocation = location.reduce((acc, e) => {
    const xObj = acc[Number(e.$x)] ?? {};
    const yObj = xObj[Number(e.$y)] ?? [];
    acc[Number(e.$x)] = {
      ...xObj,
      [Number(e.$y)]: [e, ...yObj]
    }
    return acc;
  }, {});

  return xLocation;
}