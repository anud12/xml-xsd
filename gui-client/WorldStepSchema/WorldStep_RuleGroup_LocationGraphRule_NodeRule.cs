using System.Collections.Generic;
using System.Xml;

namespace WorldStepSchema {
  
    public class WorldStep_RuleGroup_LocationGraphRule_NodeRule : WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer("node_rule")
            .addAttribute("id")
            .addElement("link_group");
        
        public string id;

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
        public WorldStepSerializer serializer = new WorldStepSerializer("link_group")
            .addAttribute("id")
            .addAttribute("angle")
            .addAttribute("angleMax")
            .addElement("to_option");
        
        public string id;
        public float angle;
        public float angleMax;

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
        public WorldStepSerializer serializer = new WorldStepSerializer("to_option")
            .addAttribute("node_rule_ref")
            .addAttribute("adjacent_depth_limit")
            .addAttribute("distance");
        
        public string node_rule_ref;
        public int adjacent_depth_limit;
        public int distance;

        
        public WorldStep_RuleGroup_LocationGraphRule_NodeRule_LinkGroup_ToOption(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }

        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }
}