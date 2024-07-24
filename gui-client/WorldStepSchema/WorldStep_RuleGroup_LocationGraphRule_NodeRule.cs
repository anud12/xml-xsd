using System;
using System.Collections.Generic;
using System.Xml;

namespace WorldStepSchema {
  
    public class WorldStep_RuleGroup_LocationGraphRule_NodeRule : WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Attribute]        
        public string id;

        [Element]
        public WorldStep_RuleGroup_LocationGraphRule_NodeRule_LinkGroup link_group;

        public WorldStep_RuleGroup_LocationGraphRule_NodeRule(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }

    /*
    <link_group id="all" angle="0" angleMax="360">
		  <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
		</link_group>
    */
    public class WorldStep_RuleGroup_LocationGraphRule_NodeRule_LinkGroup: WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer();
        
        [Attribute]
        public string id;
        [Attribute]
        public Int32 angle;
        [Attribute]
        public Int32 angleMax;
        [Attribute]
        public Int32 limit;

        [Element]
        public List<WorldStep_RuleGroup_LocationGraphRule_NodeRule_LinkGroup_ToOption> to_option = new List<WorldStep_RuleGroup_LocationGraphRule_NodeRule_LinkGroup_ToOption>();
      
        public WorldStep_RuleGroup_LocationGraphRule_NodeRule_LinkGroup(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }

    public class WorldStep_RuleGroup_LocationGraphRule_NodeRule_LinkGroup_ToOption:WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer();
        
        [Attribute]
        public String node_rule_ref;

        [Attribute]
        public Int32 adjacent_depth_limit;

        [Attribute]
        public Int32 distance;
        [Attribute]
        public Int32 maxDistance;

        
        public WorldStep_RuleGroup_LocationGraphRule_NodeRule_LinkGroup_ToOption(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }
}