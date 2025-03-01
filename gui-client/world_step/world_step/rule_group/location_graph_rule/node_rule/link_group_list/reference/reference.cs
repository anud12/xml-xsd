using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.Nreference {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list {
  public class reference : XSD.ILinkedNode  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule/node_rule/link_group_list/reference";
    public static string TagName = "reference";

    public string NodeName {get =>"reference";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<reference>> _callbackList = new();

    //Attributes
    private System.String _link_group_rule_ref;
    public System.String link_group_rule_ref { get => _link_group_rule_ref; set => _link_group_rule_ref = value; }

    //Children elements
    public reference()
    {
    }

    public reference(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public reference(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<reference> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing reference");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("link_group_rule_ref"))
      {
        var attribute_link_group_rule_ref = rawNode.attributes["link_group_rule_ref"];
        this.link_group_rule_ref = rawNode.attributes["link_group_rule_ref"];
      }

      //Deserialize children
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.link_group_rule_ref != null)
      {
        rawNode.attributes["link_group_rule_ref"] = this.link_group_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing reference");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_link_group_rule_ref()
    {
      return this.link_group_rule_ref;
    }
    public void Set_link_group_rule_ref(System.String value)
    {
      this.link_group_rule_ref = value;
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("/"))
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