import {testBase} from "../../../../test_base";

export const description = `
# \`location_graph.node.create_adjacent\` action should maintain link limits when adding adjacent links based on angle
## Given 

## Then
- The adjacent link limits should be maintained by creating 
\`\`\`xml
<node node_rule_ref="plains" id="0.0">
  <position x="2" y="0"/>
</node>
\`\`\`
from
\`\`\`xml
<link_group id="0" angle="0" limit="1">
  <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="1" adjacent_distance_max="1"/>
</link_group>
\`\`\`
`
const test= testBase(__dirname)
it(test.name, test.success)
