using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_LocationGraph : WorldStepDeserialize{

        public WorldStepSerializer serializer = new WorldStepSerializer("location_graph")
            .addAttribute("id")
            .addElement("node");

        public string id;
        public List<WorldStep_LocationGraph_Node> node = new List<WorldStep_LocationGraph_Node>();

        public Dictionary<string, WorldStep_LocationGraph_Node> nodeById = new Dictionary<string, WorldStep_LocationGraph_Node>();

        public WorldStep_LocationGraph(XmlNode locationGraph) {
            serializer.Serialize(locationGraph, this);
            nodeById = node.ToDictionary(n => n.id);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }
}
