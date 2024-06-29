import {testBase} from "../../../test_base";

export const description = `
# \`location_graph.node.create_adjacent\` action with maxAngle
## Given 
3 entries with \`location_graph.node.create_adjacent\` with attribute \`location_graph_id_ref\` set to "location_graph_id"
and \`node_id_ref\` set to \`node_id\`.
the \`link_group\` has \`angleMax\` attribute set.

## Then
It should create 
  -3 new nodes
  -3 links for node references by \`node_id_ref\` with different angle values
    - 120
    - 360
    - 240
`
const test= testBase(__dirname)
it(test.name, test.success)
