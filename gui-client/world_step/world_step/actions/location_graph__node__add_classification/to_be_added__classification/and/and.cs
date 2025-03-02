using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.Nand {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification {
  public class and : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.location_graph.node.add_classification.to_be_added__classification.and";
    public static string TagName = "and";

    public string NodeName {get =>"and";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<and>> _callbackList = new();

    //Attributes
    private System.String _location_classification_rule_ref;
    public System.String location_classification_rule_ref { get => _location_classification_rule_ref; set => _location_classification_rule_ref = value; }

    //Children elements
    public and()
    {
    }

    public and(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public and(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<and> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing and");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
      {
        var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
      }

      //Deserialize children
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_classification_rule_ref != null)
      {
        rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing and");
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
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
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
      return null;
    }
  }
}