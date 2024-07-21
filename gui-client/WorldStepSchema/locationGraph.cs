using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_LocationGraph : WorldStepDeserialize{

        public WorldStepSerializer serializer = new WorldStepSerializer()
            .addAttribute("id", typeof(string))
            .addElement("node", typeof(List<WorldStep_LocationGraph_Node>));

        public string id;
        public List<WorldStep_LocationGraph_Node> node = new List<WorldStep_LocationGraph_Node>();

        public Dictionary<string, WorldStep_LocationGraph_Node> nodeById = new Dictionary<string, WorldStep_LocationGraph_Node>();

        public WorldStep_LocationGraph(XmlNode locationGraph) {
            serializer.Serialize(locationGraph, this);
            nodeById = node.ToDictionary(n => n.id);
        }

        public void Deserialize(XmlElement element)
        {
            XmlElement locationGraphElement = element.OwnerDocument.CreateElement("location_graph");
            locationGraphElement.SetAttribute("id", id);
            element.AppendChild(locationGraphElement);
            foreach (var n in this.node)
            {
                n.Deserialize(locationGraphElement);
            }
        }
    }
}
