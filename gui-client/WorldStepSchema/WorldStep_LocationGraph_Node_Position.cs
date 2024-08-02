using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_LocationGraph_Node_Position {

        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Attribute]
        public int x;
        [Attribute]
        public int y;
        public WorldStep_LocationGraph_Node_Position(XmlNode xmlElement) {
            serializer.Deserialize(xmlElement, this);
        }
    }
}