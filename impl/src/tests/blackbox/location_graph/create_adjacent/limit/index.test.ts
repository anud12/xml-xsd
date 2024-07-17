import {testBase} from "../../../test_base";

export const description = `
# \`location_graph.node.create_adjacent\` action with limit and angle
## Given 
- 2 entries with \`location_graph.node.create_adjacent\` with attribute \`location_graph_id_ref\` set to "location_graph_id"
and \`node_id_ref\` set to \`node_id\`.
the \`link_group\` has 
  - \`angle\` attribute set
  - \`limit\` attribute set 
- \`link_group\` rule with an angle of \`0\`
- 2 nodes that are at an angle of \'0\' degrees
## Then
It should do nothing because the \`link_group\` doesn't allow another node to be created.
`
const test= testBase(__dirname)
it(test.name, test.success)
