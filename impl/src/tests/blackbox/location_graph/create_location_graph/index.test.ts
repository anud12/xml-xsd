import {testBase} from "../../test_base";

export const description = `
# \`create_location_graph\` action
## Given 
create_location_graph with attribute \`location_graph_rule_ref\` set to "location_graph_rule_id"
## Then
It should create a new location graph starting from \`setup > starting node\` rule
`
const test= testBase(__dirname)
it(test.name, test.success)
