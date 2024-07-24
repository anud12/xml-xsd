using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep:WorldStepDeserialize {

        public WorldStepSerializer serializer = new WorldStepSerializer();

        
        [Element]
        public WorldStep_WorldMetadata world_metadata;

        [Element]
        public List<WorldStep_RuleGroup> rule_group = new List<WorldStep_RuleGroup>();

        [Element]
        public List<WorldStep_LocationGraph> location_graph = new List<WorldStep_LocationGraph>();

        [Element]
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