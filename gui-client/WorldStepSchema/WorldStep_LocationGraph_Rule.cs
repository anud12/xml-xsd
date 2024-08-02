using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_LocationGraph_Rule{

        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Attribute]
        public string location_graph_rule_ref;

        
        public WorldStep_LocationGraph_Rule(XmlNode locationGraph) {
            serializer.Deserialize(locationGraph, this);
        }
    }
}
