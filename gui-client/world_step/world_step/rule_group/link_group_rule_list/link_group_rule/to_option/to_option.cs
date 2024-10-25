using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.Nlink_group_rule.Nto_option {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.Nlink_group_rule {
  public class to_option  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.Int32 distance;
    public System.Int32? maxDistance;
    public System.Int32 adjacent_depth_limit;

    //Children elements
    public type__math_operations? distance_to_progress_multiplier = null;
    public type__math_operations? person_progress_property = null;
    public to_option()
    {
    }

    public to_option(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public to_option(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing to_option");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_rule_ref"))
      {
        var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
        this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("distance"))
      {
        var attribute_distance = rawNode.attributes["distance"];
        this.distance = attribute_distance.ToInt();
      }
      if(rawNode.attributes.ContainsKey("maxDistance"))
      {
        var attribute_maxDistance = rawNode.attributes["maxDistance"];
        this.maxDistance = attribute_maxDistance?.ToInt();
      }
      if(rawNode.attributes.ContainsKey("adjacent_depth_limit"))
      {
        var attribute_adjacent_depth_limit = rawNode.attributes["adjacent_depth_limit"];
        this.adjacent_depth_limit = attribute_adjacent_depth_limit.ToInt();
      }

      //Deserialize children
      this.distance_to_progress_multiplier = rawNode.InitializeWithRawNode("distance_to_progress_multiplier", this.distance_to_progress_multiplier);
      this.person_progress_property = rawNode.InitializeWithRawNode("person_progress_property", this.person_progress_property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
      }
      if(this.distance != null)
      {
        rawNode.attributes["distance"] = this.distance.ToString();
      }
      if(this.maxDistance != null)
      {
        rawNode.attributes["maxDistance"] = this.maxDistance?.ToString();
      }
      if(this.adjacent_depth_limit != null)
      {
        rawNode.attributes["adjacent_depth_limit"] = this.adjacent_depth_limit.ToString();
      }

      //Serialize children
      if(distance_to_progress_multiplier != null) {
        rawNode.children["distance_to_progress_multiplier"] = new List<RawNode> { distance_to_progress_multiplier.SerializeIntoRawNode() };
      }
      if(person_progress_property != null) {
        rawNode.children["person_progress_property"] = new List<RawNode> { person_progress_property.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing to_option");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.Int32 Get_distance()
    {
      return this.distance;
    }
    public void Set_distance(System.Int32 value)
    {
      this.distance = value;
    }
    public System.Int32? Get_maxDistance()
    {
      return this.maxDistance;
    }
    public void Set_maxDistance(System.Int32? value)
    {
      this.maxDistance = value;
    }
    public System.Int32 Get_adjacent_depth_limit()
    {
      return this.adjacent_depth_limit;
    }
    public void Set_adjacent_depth_limit(System.Int32 value)
    {
      this.adjacent_depth_limit = value;
    }
    public type__math_operations? Get_distance_to_progress_multiplier()
    {
      return this.distance_to_progress_multiplier;
    }
    public void Set_distance_to_progress_multiplier(type__math_operations? value)
    {
      this.distance_to_progress_multiplier = value;
    }
    public type__math_operations? Get_person_progress_property()
    {
      return this.person_progress_property;
    }
    public void Set_person_progress_property(type__math_operations? value)
    {
      this.person_progress_property = value;
    }
  }
}