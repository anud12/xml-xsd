using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_LocationGraph_Rule : WorldStepDeserialize{

        public WorldStepSerializer serializer = new WorldStepSerializer("rule");

        [Attribute]
        public string location_graph_rule_ref;

        
        public WorldStep_LocationGraph_Rule(XmlNode locationGraph) {
            serializer.Serialize(locationGraph, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }
}
