using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_LocationGraph{

        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Attribute]
        public string id;

        [Element]
        public WorldStep_LocationGraph_Rule rule;

        [Element]
        public List<WorldStep_LocationGraph_Node> node = new List<WorldStep_LocationGraph_Node>();

        public Dictionary<string, WorldStep_LocationGraph_Node> nodeById = new Dictionary<string, WorldStep_LocationGraph_Node>();

        public WorldStep_LocationGraph(XmlNode locationGraph) {
            serializer.Deserialize(locationGraph, this);
            nodeById = node.ToDictionary(n => n.id);
        }
    }

    
}
