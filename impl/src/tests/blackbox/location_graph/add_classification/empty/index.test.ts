import {testBase} from "../../../test_base";

export const description = `
# \`location_graph.node.add_classificationt\` action with empty selection
## Given 
- \`location_graph.node.add_classificationt\` action with empty selection
- 
## Then
It should do nothing. 
`
const test= testBase(__dirname)
it(test.name, test.success)
