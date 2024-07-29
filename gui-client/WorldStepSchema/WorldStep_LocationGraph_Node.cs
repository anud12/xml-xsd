using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml;

namespace WorldStepSchema{
	public class WorldStep_LocationGraph_Node{

		public WorldStepSerializer serializer = new WorldStepSerializer();
			
		[Attribute]
		public string id;
		[Attribute]
		public string node_rule_ref;

		[Element]
		public WorldStep_LocationGraph_Node_Position position;

		[Element]
		public List<WorldStep_LocationGraph_Node_LinkTo> link_to = new List<WorldStep_LocationGraph_Node_LinkTo>();
		public WorldStep_LocationGraph_Node(XmlNode xmlElement) {
			serializer.Deserialize(xmlElement, this);
		}
	}
}
