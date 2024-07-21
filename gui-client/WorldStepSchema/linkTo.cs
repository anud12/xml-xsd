using System.Xml;

namespace WorldStepSchema {
	
	public class WorldStep_LocationGraph_Node_LinkTo : WorldStepDeserialize {

		public WorldStepSerializer serializer = new WorldStepSerializer()
			.addAttribute("node_id_ref", typeof(string));
			
		public string node_id_ref;

		public WorldStep_LocationGraph_Node_LinkTo(XmlNode xmlElement) {
			serializer.Serialize(xmlElement, this);
		}

		public void Deserialize(XmlElement element)
		{
				// XmlElement linkToElement = element.OwnerDocument.CreateElement("link_to");
				// linkToElement.SetAttribute("node_id_ref", node_id_ref);
				// element.AppendChild(linkToElement);
		}
	}
}
