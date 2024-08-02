using System.Collections.Generic;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_RuleGroup {
        public WorldStepSerializer serializer = new WorldStepSerializer();
        

        [Attribute]
        public string id;

        [Element]
        public List<WorldStep_RuleGroup_LocationGraphRule> location_graph_rule = new List<WorldStep_RuleGroup_LocationGraphRule>();

        public WorldStep_RuleGroup(XmlNode xmlElement) {
            serializer.Deserialize(xmlElement, this);
        }
    }
}