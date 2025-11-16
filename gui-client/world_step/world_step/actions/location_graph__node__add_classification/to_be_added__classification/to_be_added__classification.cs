using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification {
  public class to_be_added__classification : IEquatable<to_be_added__classification>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.location_graph.node.add_classification.to_be_added__classification";
    public static string TagName = "to_be_added__classification";

    public string NodeName {get =>"to_be_added__classification";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<to_be_added__classification>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _location_classification_rule_ref;
    public System.String location_classification_rule_ref { get => _location_classification_rule_ref; set => _location_classification_rule_ref = value; }

    //Children elements
    private XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and? _and = null;
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and andOrCreate
    {
      get
      {
        if(_and == null)
        {
          _and = new();
          _and.ParentNode = this;
          NotifyChange();
        }
        return _and;
      }
      set
      {
        _and = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and? and
    {
      get
      {
        return _and;
      }
      set
      {
        _and = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public to_be_added__classification()
    {
    }

    public to_be_added__classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public to_be_added__classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "location_classification_rule_ref")
      {
        Set_location_classification_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and and)
      {
        this.and = and;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and)
      {
        this.and = null;
      }

    }

    public Action OnSelfChange(Action<to_be_added__classification> callback)
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
      // Godot.GD.Print("Deserializing to_be_added__classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
      {
        var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
      }

      //Deserialize children
      and = rawNode.InitializeWithRawNode("and", and);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._location_classification_rule_ref != null)
      {
        rawNode.attributes["location_classification_rule_ref"] = this._location_classification_rule_ref.ToString();
      }

      //Serialize children
      if(and != null) {
        rawNode.children["and"] = new List<RawNode> { and.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing to_be_added__classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and.TagName))
      {
        this.and ??= new XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and.TagName.Length + 3);
        this.and.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and casted_and) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and
      || false;
    }

    public bool Equals(to_be_added__classification? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (to_be_added__classification)obj;
        return Equals(location_classification_rule_ref, other.location_classification_rule_ref) && Equals(and, other.and);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, location_classification_rule_ref);
        acc = HashCode.Combine(acc, and);
        return acc;
    }
  }
}