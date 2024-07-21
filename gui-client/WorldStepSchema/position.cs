using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_LocationGraph_Node_Position : WorldStepDeserialize {

        public WorldStepSerializer serializer = new WorldStepSerializer()
            .addAttribute("x", typeof(int))
            .addAttribute("y", typeof(int));

        public int x;
        public int y;
        public WorldStep_LocationGraph_Node_Position(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }

        public void Deserialize(XmlElement element)
        {
            XmlElement positionElement = element.OwnerDocument.CreateElement("position");
            positionElement.SetAttribute("x", x.ToString());
            positionElement.SetAttribute("y", y.ToString());
            element.AppendChild(positionElement);
        }
    }
}