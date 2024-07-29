using System.Xml;
using Godot;

namespace WorldStepSchema {
	
	public class WorldStep_LocationGraph_Node_LinkTo {

		public WorldStepSerializer serializer = new WorldStepSerializer();
		
		[Attribute]
		public string node_id_ref;

		public WorldStep_LocationGraph_Node_LinkTo(XmlNode xmlElement) {
			serializer.Deserialize(xmlElement, this);
		}
	}
}
