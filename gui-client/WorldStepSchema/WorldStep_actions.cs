using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_Actions : WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer("actions")
        .addElement("location_graph.node.create_adjacent", "create_adjacent");

        [Element("create_adjacent")]
        public WorldStep_Actions_CreateAdjacent create_adjacent;

        public WorldStep_Actions() {
        }
        public WorldStep_Actions(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }
        public void Deserialize(XmlElement element) {
            serializer.Deserialize(element, this);
        }
    }

    public class WorldStep_Actions_CreateAdjacent:WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer("create_adjacent")
        .addAttribute("location_graph_id_ref")
        .addAttribute("node_id_ref");

        public string location_graph_id_ref;
        public string node_id_ref;

        public WorldStep_Actions_CreateAdjacent() {
        }

        public WorldStep_Actions_CreateAdjacent(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }
}