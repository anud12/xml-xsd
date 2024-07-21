using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep {

        public WorldStepSerializer serializer = new WorldStepSerializer()
            .addElement("location_graph", typeof(List<WorldStep_LocationGraph>));

        public List<WorldStep_LocationGraph> location_graph = new List<WorldStep_LocationGraph>();

        public WorldStep(XmlNode xmlNode) {
            serializer.Serialize(xmlNode, this);
        }

        public void Serialize(XmlDocument document)
        {
            XmlElement worldStepElement = document.CreateElement("world_step");
            document.AppendChild(worldStepElement);
            foreach (var l in this.location_graph)
            {
                l.Deserialize(worldStepElement);
            }
        }
    }
}