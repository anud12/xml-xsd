using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nby.N_do {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nby {
  public class _do : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.by.do";
    public static string TagName = "do";

    public string NodeName {get =>"do";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<_do>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String? _action_rule_ref;
    public System.String? action_rule_ref { get => _action_rule_ref; set => _action_rule_ref = value; }
    private System.String? _action_ref;
    public System.String? action_ref { get => _action_ref; set => _action_ref = value; }
    private System.String _person_ref;
    public System.String person_ref { get => _person_ref; set => _person_ref = value; }

    //Children elements
    public _do()
    {
    }

    public _do(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public _do(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<_do> callback)
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
      // Godot.GD.Print("Deserializing do");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("action_rule_ref"))
      {
        var attribute_action_rule_ref = rawNode.attributes["action_rule_ref"];
        this.action_rule_ref = rawNode.attributes["action_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("action_ref"))
      {
        var attribute_action_ref = rawNode.attributes["action_ref"];
        this.action_ref = rawNode.attributes["action_ref"];
      }
      if(rawNode.attributes.ContainsKey("person_ref"))
      {
        var attribute_person_ref = rawNode.attributes["person_ref"];
        this.person_ref = rawNode.attributes["person_ref"];
      }

      //Deserialize children
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.action_rule_ref != null)
      {
        rawNode.attributes["action_rule_ref"] = this.action_rule_ref?.ToString();
      }
      if(this.action_ref != null)
      {
        rawNode.attributes["action_ref"] = this.action_ref?.ToString();
      }
      if(this.person_ref != null)
      {
        rawNode.attributes["person_ref"] = this.person_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing do");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String? Get_action_rule_ref()
    {
      return this.action_rule_ref;
    }
    public void Set_action_rule_ref(System.String? value)
    {
      this.action_rule_ref = value;
      this.OnChange();
    }
    public System.String? Get_action_ref()
    {
      return this.action_ref;
    }
    public void Set_action_ref(System.String? value)
    {
      this.action_ref = value;
      this.OnChange();
    }
    public System.String Get_person_ref()
    {
      return this.person_ref;
    }
    public void Set_person_ref(System.String value)
    {
      this.person_ref = value;
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