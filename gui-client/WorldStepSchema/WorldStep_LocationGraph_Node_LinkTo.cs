using System.Xml;
using Godot;

namespace WorldStepSchema {
	
	public class WorldStep_LocationGraph_Node_LinkTo : WorldStepDeserialize {

		public WorldStepSerializer serializer = new WorldStepSerializer("link_to")
			.addAttribute("node_id_ref", typeof(string));
			
		public string node_id_ref;

		public WorldStep_LocationGraph_Node_LinkTo(XmlNode xmlElement) {
			serializer.Serialize(xmlElement, this);
		}

		public void Deserialize(XmlElement element)
		{
			serializer.Deserialize(element, this);
		}
	}
}
