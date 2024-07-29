using System.Xml;

namespace WorldStepSchema {
    
    public class WorldStep_RuleGroup_LocationGraphRule_Setup {
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Element]
        public WorldStep_RuleGroup_LocationGraphRule_Setup_StartingNode starting_node;

        public WorldStep_RuleGroup_LocationGraphRule_Setup(XmlNode xmlElement) {
            serializer.Deserialize(xmlElement, this);
        }
    }

    public class WorldStep_RuleGroup_LocationGraphRule_Setup_StartingNode {
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Attribute]
        public string node_rule_ref;

        public WorldStep_RuleGroup_LocationGraphRule_Setup_StartingNode(XmlNode xmlElement) {
            serializer.Deserialize(xmlElement, this);
        }
    }
}