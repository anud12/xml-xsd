using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__create {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class location_graph__create : IEquatable<location_graph__create>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.location_graph.create";
    public static string TagName = "location_graph.create";

    public string NodeName {get =>"location_graph.create";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<location_graph__create>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _location_graph_rule_ref;
    public System.String location_graph_rule_ref { get => _location_graph_rule_ref; set => _location_graph_rule_ref = value; }

    //Children elements
    public location_graph__create()
    {
    }

    public location_graph__create(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph__create(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "location_graph_rule_ref")
      {
        Set_location_graph_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<location_graph__create> callback)
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
      // Godot.GD.Print("Deserializing location_graph.create");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_rule_ref"))
      {
        var attribute_location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
        this.location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._location_graph_rule_ref != null)
      {
        rawNode.attributes["location_graph_rule_ref"] = this._location_graph_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph.create");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_location_graph_rule_ref()
    {
      return this.location_graph_rule_ref;
    }
    public void Set_location_graph_rule_ref(System.String value)
    {
      this.location_graph_rule_ref = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
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
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return false;
    }

    public bool Equals(location_graph__create? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (location_graph__create)obj;
        return Equals(location_graph_rule_ref, other.location_graph_rule_ref);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, location_graph_rule_ref);
        return acc;
    }
  }
}