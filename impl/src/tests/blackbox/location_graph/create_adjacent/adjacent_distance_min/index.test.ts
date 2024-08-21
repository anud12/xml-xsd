import {testBase} from "../../../test_base";

export const description = `
# \`location_graph.node.create_adjacent\` action with maxDistance and adjacent_distance
## Given 
3 nodes at position
  - 0, 0
  - 10, 0
  - 20, 0

## Then
It should create a link between the nodes with the distance between them less than the \`adjacent_distance_max\` attribute inclusive.
  -1 link towards node \`node_id_3\` because the distance is greater than 4
  -1 link towards \`node_id\`
It should not create a link towards \`node_id_2\` because the distance is greater than 4
`
const test= testBase(__dirname)
it(test.name, test.success)
