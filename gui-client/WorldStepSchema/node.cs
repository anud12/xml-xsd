using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema{
	public class WorldStep_LocationGraph_Node : WorldStepDeserialize{

		public WorldStepSerializer serializer = new WorldStepSerializer()
			.addAttribute("id", typeof(string))
			.addAttribute("node_rule_ref", typeof(string))
			.addElement("position", typeof(WorldStep_LocationGraph_Node_Position))
			.addElement("link_to", typeof(List<WorldStep_LocationGraph_Node_LinkTo>));
			
		public string id;
		public string node_rule_ref;

		public WorldStep_LocationGraph_Node_Position position;
		public List<WorldStep_LocationGraph_Node_LinkTo> link_to = new List<WorldStep_LocationGraph_Node_LinkTo>();
		public WorldStep_LocationGraph_Node(XmlNode xmlElement) {
			serializer.Serialize(xmlElement, this);
		}

		public void Deserialize(XmlElement element)
		{
			XmlElement nodeElement = element.OwnerDocument.CreateElement("node");
			nodeElement.SetAttribute("id", id);
			nodeElement.SetAttribute("node_rule_ref", node_rule_ref);
			element.AppendChild(nodeElement);
			position.Deserialize(nodeElement);
			foreach (var l in this.link_to)
			{
				l.Deserialize(nodeElement);
			}
		}
	}
}
