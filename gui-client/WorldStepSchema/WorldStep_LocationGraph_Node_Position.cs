using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_LocationGraph_Node_Position : WorldStepDeserialize {

        public WorldStepSerializer serializer = new WorldStepSerializer("position")
            .addAttribute("x")
            .addAttribute("y");

        public int x;
        public int y;
        public WorldStep_LocationGraph_Node_Position(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }
}