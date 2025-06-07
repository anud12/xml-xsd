using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.Nfrom_person_same_location_graph_node {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection {
  public class from_person_same_location_graph_node : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.action_rule.from_person.on_person.selection.from_person_same_location_graph_node";
    public static string TagName = "from_person_same_location_graph_node";

    public string NodeName {get =>"from_person_same_location_graph_node";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<from_person_same_location_graph_node>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String _value;
    public System.String value { get => _value; set => _value = value; }

    //Children elements
    public from_person_same_location_graph_node()
    {
    }

    public from_person_same_location_graph_node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from_person_same_location_graph_node(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<from_person_same_location_graph_node> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public Action OnChangeBubble(Action<List<ILinkedNode>> callback)
    {
      _bubbleCallbackList.Add(callback);
      return () => _bubbleCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person_same_location_graph_node");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = rawNode.attributes["value"];
      }

      //Deserialize children
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from_person_same_location_graph_node");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String value)
    {
      this.value = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
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
      _bubbleCallbackList.ForEach(action => action(linkedNodes));
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