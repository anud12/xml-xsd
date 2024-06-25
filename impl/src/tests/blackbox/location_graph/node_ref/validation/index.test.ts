import {testBase} from "../../../test_base";

export const description = `
# \`node_ref\` validation
## Given 
A property value of \`node_ref\` that isn't found in
  - \`node\` \`id\` attribute
## Then
It should throw an error with following information 
  - node that triggered the error (\`//rule_group[0]/location_graph_rule[0]/node[0]/link_group[0]/to_option[0]@node_ref\`)
  - list of valid values (\`[node]\`)
  - actual value (\`other\`)
`
const test= testBase(__dirname)
it(test.name, test.error)
