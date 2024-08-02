using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_Actions {
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Element("location_graph.node.create_adjacent")]
        public WorldStep_Actions_CreateAdjacent create_adjacent;

        public WorldStep_Actions() {
        }
        public WorldStep_Actions(XmlNode xmlElement) {
            serializer.Deserialize(xmlElement, this);
        }
    }

    public class WorldStep_Actions_CreateAdjacent {
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Attribute]
        public string location_graph_id_ref;
        [Attribute]
        public string node_id_ref;

        public WorldStep_Actions_CreateAdjacent() {
        }

        public WorldStep_Actions_CreateAdjacent(XmlNode xmlElement) {
            serializer.Deserialize(xmlElement, this);
        }
    }
}