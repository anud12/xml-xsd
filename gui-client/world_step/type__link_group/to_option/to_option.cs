using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__link_group.Nto_option {}
namespace XSD {
}
namespace XSD.Ntype__link_group {
  public class to_option : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__link_group.to_option";
    public static string TagName = "to_option";

    public string NodeName {get =>"to_option";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<to_option>> _callbackList = new();

    //Attributes
    private System.String _node_rule_ref;
    public System.String node_rule_ref { get => _node_rule_ref; set => _node_rule_ref = value; }
    private System.Int32 _distance;
    public System.Int32 distance { get => _distance; set => _distance = value; }
    private System.Int32? _maxDistance;
    public System.Int32? maxDistance { get => _maxDistance; set => _maxDistance = value; }
    private System.Int32 _adjacent_depth_limit;
    public System.Int32 adjacent_depth_limit { get => _adjacent_depth_limit; set => _adjacent_depth_limit = value; }

    //Children elements
    private type__math_operations? _distance_to_progress_multiplier = null;
    public type__math_operations distance_to_progress_multiplier
    {
      get
      {
        if(_distance_to_progress_multiplier == null)
        {
          _distance_to_progress_multiplier = new();
          _distance_to_progress_multiplier.ParentNode = this;
          OnChange();
        }
        return _distance_to_progress_multiplier;
      }
      set
      {
        _distance_to_progress_multiplier = value;
        _distance_to_progress_multiplier.ParentNode = this;
      }
    }

    private type__math_operations? _person_progress_property = null;
    public type__math_operations person_progress_property
    {
      get
      {
        if(_person_progress_property == null)
        {
          _person_progress_property = new();
          _person_progress_property.ParentNode = this;
          OnChange();
        }
        return _person_progress_property;
      }
      set
      {
        _person_progress_property = value;
        _person_progress_property.ParentNode = this;
      }
    }
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

    public Action OnChange(Action<to_option> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
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
      distance_to_progress_multiplier = rawNode.InitializeWithRawNode("distance_to_progress_multiplier", distance_to_progress_multiplier);

      person_progress_property = rawNode.InitializeWithRawNode("person_progress_property", person_progress_property);
      OnChange();
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
      this.OnChange();
    }
    public System.Int32 Get_distance()
    {
      return this.distance;
    }
    public void Set_distance(System.Int32 value)
    {
      this.distance = value;
      this.OnChange();
    }
    public System.Int32? Get_maxDistance()
    {
      return this.maxDistance;
    }
    public void Set_maxDistance(System.Int32? value)
    {
      this.maxDistance = value;
      this.OnChange();
    }
    public System.Int32 Get_adjacent_depth_limit()
    {
      return this.adjacent_depth_limit;
    }
    public void Set_adjacent_depth_limit(System.Int32 value)
    {
      this.adjacent_depth_limit = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.distance_to_progress_multiplier ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.distance_to_progress_multiplier.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.person_progress_property ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.person_progress_property.DeserializeAtPath(childXPath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }

    public void ChildChanged(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _callbackList.ForEach(action => action(this));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is type__math_operations casted_distance_to_progress_multiplier) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_person_progress_property) {
        return 0;
      }
      return null;
    }
  }
}