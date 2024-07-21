using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep:WorldStepDeserialize {

        public WorldStepSerializer serializer = new WorldStepSerializer("world_step")
            .addElement("world_metadata", typeof(WorldStep_WorldMetadata))
            .addElement("rule_group", typeof(List<WorldStep_RuleGroup>))
            .addElement("location_graph", typeof(List<WorldStep_LocationGraph>))
            .addElement("actions", typeof(WorldStep_Actions));

        public WorldStep_WorldMetadata world_metadata;

        public List<WorldStep_RuleGroup> rule_group = new List<WorldStep_RuleGroup>();
        public List<WorldStep_LocationGraph> location_graph = new List<WorldStep_LocationGraph>();

        public WorldStep_Actions actions;

        public WorldStep(XmlNode xmlNode) {
            serializer.Serialize(xmlNode, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }

        public void Serialize(XmlDocument document)
        {
            XmlElement worldStepElement = document.CreateElement("world_step");
            document.AppendChild(worldStepElement);
            Deserialize(worldStepElement);
        }
        
    }
}