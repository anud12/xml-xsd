using System.Xml;

namespace WorldStepSchema {
    
    public class WorldStep_RuleGroup_LocationGraphRule_Setup : WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer("setup")
            .addElement("starting_node", typeof(WorldStep_RuleGroup_LocationGraphRule_Setup_StartingNode));

        public WorldStep_RuleGroup_LocationGraphRule_Setup_StartingNode starting_node;

        public WorldStep_RuleGroup_LocationGraphRule_Setup(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }

    public class WorldStep_RuleGroup_LocationGraphRule_Setup_StartingNode: WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer("starting_node")
            .addAttribute("node_rule_ref", typeof(string));

        public string node_rule_ref;

        public WorldStep_RuleGroup_LocationGraphRule_Setup_StartingNode(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }
}