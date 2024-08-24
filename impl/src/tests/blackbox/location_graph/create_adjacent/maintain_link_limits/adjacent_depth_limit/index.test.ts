import {testBase} from "../../../../test_base";

export const description = `
# \`location_graph.node.create_adjacent\` action should maintain link limits when adding adjacent links
## Given 

## Then
- The adjacent link limits should be maintained
`
const test= testBase(__dirname)
it(test.name, test.success)
