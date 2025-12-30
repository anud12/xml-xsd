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
  public class to_option : IEquatable<to_option>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__link_group.to_option";
    public static string TagName = "to_option";

    public string NodeName {get =>"to_option";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<to_option>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

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
    public type__math_operations distance_to_progress_multiplierOrCreate
    {
      get
      {
        if(_distance_to_progress_multiplier == null)
        {
          _distance_to_progress_multiplier = new();
          _distance_to_progress_multiplier.ParentNode = this;
          NotifyChange();
        }
        return _distance_to_progress_multiplier;
      }
      set
      {
        _distance_to_progress_multiplier = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations? distance_to_progress_multiplier
    {
      get
      {
        return _distance_to_progress_multiplier;
      }
      set
      {
        _distance_to_progress_multiplier = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
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

    public void SetAttribute(string name, string? value)
    {
      if(name == "node_rule_ref")
      {
        Set_node_rule_ref(value);
      }
      if(name == "distance")
      {
        Set_distance(value?.ToInt() ?? 0);
      }
      if(name == "maxDistance")
      {
        Set_maxDistance(value?.ToInt() ?? 0);
      }
      if(name == "adjacent_depth_limit")
      {
        Set_adjacent_depth_limit(value?.ToInt() ?? 0);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations distance_to_progress_multiplier)
      {
        this.distance_to_progress_multiplier = distance_to_progress_multiplier;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations)
      {
        this.distance_to_progress_multiplier = null;
      }

    }

    public Action OnSelfChange(Action<to_option> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }

    public Action OnSelfChangeNode(Action<ILinkedNode> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }


    public Action OnChange(Action<List<ILinkedNode>> callback)
    {
      _onChangeCallbackList.Add(callback);
      return () => _onChangeCallbackList.Remove(callback);
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
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this._node_rule_ref.ToString();
      }
      if(this._distance != null)
      {
        rawNode.attributes["distance"] = this._distance.ToString();
      }
      if(this._maxDistance != null)
      {
        rawNode.attributes["maxDistance"] = this._maxDistance?.ToString();
      }
      if(this._adjacent_depth_limit != null)
      {
        rawNode.attributes["adjacent_depth_limit"] = this._adjacent_depth_limit.ToString();
      }

      //Serialize children
      if(distance_to_progress_multiplier != null) {
        rawNode.children["distance_to_progress_multiplier"] = new List<RawNode> { distance_to_progress_multiplier.SerializeIntoRawNode() };
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
      this.NotifyChange();
    }
    public System.Int32 Get_distance()
    {
      return this.distance;
    }
    public void Set_distance(System.Int32 value)
    {
      this.distance = value;
      this.NotifyChange();
    }
    public System.Int32? Get_maxDistance()
    {
      return this.maxDistance;
    }
    public void Set_maxDistance(System.Int32? value)
    {
      this.maxDistance = value;
      this.NotifyChange();
    }
    public System.Int32 Get_adjacent_depth_limit()
    {
      return this.adjacent_depth_limit;
    }
    public void Set_adjacent_depth_limit(System.Int32 value)
    {
      this.adjacent_depth_limit = value;
      this.NotifyChange();
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

      Deserialize(rawNode);
    }

    public void NotifyChange(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _onSelfChangeCallbackList.ForEach(action => action(this));
      _onChangeCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.NotifyChange(linkedNodes);
    }

    public void NotifyChange()
    {
      NotifyChange(new ());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is type__math_operations casted_distance_to_progress_multiplier) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is type__math_operations
      || false;
    }

    public bool Equals(to_option? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (to_option)obj;
        return Equals(node_rule_ref, other.node_rule_ref) && Equals(distance, other.distance) && Equals(maxDistance, other.maxDistance) && Equals(adjacent_depth_limit, other.adjacent_depth_limit) && Equals(distance_to_progress_multiplier, other.distance_to_progress_multiplier);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, node_rule_ref);
        acc = HashCode.Combine(acc, distance);
        acc = HashCode.Combine(acc, maxDistance);
        acc = HashCode.Combine(acc, adjacent_depth_limit);
        acc = HashCode.Combine(acc, distance_to_progress_multiplier);
        return acc;
    }
  }
}