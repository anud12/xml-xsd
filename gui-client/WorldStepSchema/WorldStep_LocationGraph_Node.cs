using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema{
	public class WorldStep_LocationGraph_Node : WorldStepDeserialize{

		public WorldStepSerializer serializer = new WorldStepSerializer("node")
			.addAttribute("id")
			.addAttribute("node_rule_ref")
			.addElement("position")
			.addElement("link_to");
			
		public string id;
		public string node_rule_ref;

		public WorldStep_LocationGraph_Node_Position position;
		public List<WorldStep_LocationGraph_Node_LinkTo> link_to = new List<WorldStep_LocationGraph_Node_LinkTo>();
		public WorldStep_LocationGraph_Node(XmlNode xmlElement) {
			serializer.Serialize(xmlElement, this);
		}

		public void Deserialize(XmlElement element)
		{
			serializer.Deserialize(element, this);
		}
	}
}
