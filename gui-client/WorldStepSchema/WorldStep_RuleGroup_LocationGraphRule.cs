using System.Collections.Generic;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_RuleGroup_LocationGraphRule : WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer();
        

        [Attribute]
        public string id;

        [Element]
        public WorldStep_RuleGroup_LocationGraphRule_Setup setup;

        [Element]
        public List<WorldStep_RuleGroup_LocationGraphRule_NodeRule> node_rule = new List<WorldStep_RuleGroup_LocationGraphRule_NodeRule>();

        public WorldStep_RuleGroup_LocationGraphRule(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }
        public void Deserialize(XmlElement element) {
            serializer.Deserialize(element, this);
        }
    }

}