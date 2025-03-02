using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__trigger.Nperson_action_used {}
namespace XSD {
}
namespace XSD.Ntype__trigger {
  public class person_action_used : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__trigger.person_action_used";
    public static string TagName = "person_action_used";

    public string NodeName {get =>"person_action_used";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<person_action_used>> _callbackList = new();

    //Attributes
    private System.String _action_rule_ref;
    public System.String action_rule_ref { get => _action_rule_ref; set => _action_rule_ref = value; }

    //Children elements
    public person_action_used()
    {
    }

    public person_action_used(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person_action_used(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<person_action_used> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person_action_used");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("action_rule_ref"))
      {
        var attribute_action_rule_ref = rawNode.attributes["action_rule_ref"];
        this.action_rule_ref = rawNode.attributes["action_rule_ref"];
      }

      //Deserialize children
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.action_rule_ref != null)
      {
        rawNode.attributes["action_rule_ref"] = this.action_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person_action_used");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_action_rule_ref()
    {
      return this.action_rule_ref;
    }
    public void Set_action_rule_ref(System.String value)
    {
      this.action_rule_ref = value;
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