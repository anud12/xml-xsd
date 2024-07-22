using System.Collections.Generic;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_RuleGroup:WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer("rule_group")
            .addAttribute("id")
            .addElement("location_graph_rule");
        

        public string id;
        public List<WorldStep_RuleGroup_LocationGraphRule> location_graph_rule = new List<WorldStep_RuleGroup_LocationGraphRule>();

        public WorldStep_RuleGroup(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }
        public void Deserialize(XmlElement element) {
            serializer.Deserialize(element, this);
        }
    }
}