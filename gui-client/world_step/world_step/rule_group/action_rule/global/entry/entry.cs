using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.Nentry {}
namespace XSD {
  public interface Itype__action {

    //Children elements
    public XSD.Ntype__action.from from { get; set; }
    public XSD.Ntype__action.on on { get; set; }
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);

  }
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal {
  public class entry : XSD.ILinkedNode , Itype__action {

    public static string ClassTypeId = ".world_step.rule_group.action_rule.global.entry";
    public static string TagName = "entry";

    public string NodeName {get =>"entry";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<entry>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Attributes of type__action

    //Children elements

    //Children of type__action
    private XSD.Ntype__action.from _from = new XSD.Ntype__action.from();
    public XSD.Ntype__action.from from
    {
      get
      {
        if(_from == null)
        {
          _from = new();
          _from.ParentNode = this;
          OnChange();
        }
        return _from;
      }
      set
      {
        _from = value;
        _from.ParentNode = this;
      }
    }

    private XSD.Ntype__action.on _on = new XSD.Ntype__action.on();
    public XSD.Ntype__action.on on
    {
      get
      {
        if(_on == null)
        {
          _on = new();
          _on.ParentNode = this;
          OnChange();
        }
        return _on;
      }
      set
      {
        _on = value;
        _on.ParentNode = this;
      }
    }
    public entry()
    {
    }

    public entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<entry> callback)
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
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      // Deserialize arguments of type__action


      //Deserialize children

      // Deserialize children of type__action
  from = rawNode.InitializeWithRawNode("from", from);

  on = rawNode.InitializeWithRawNode("on", on);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      // Serialize arguments of type__action


      //Serialize children

      // Serialize children of type__action
  if(from != null) {
    rawNode.children["from"] = new List<RawNode> { from.SerializeIntoRawNode() };
  }
  if(on != null) {
    rawNode.children["on"] = new List<RawNode> { on.SerializeIntoRawNode() };
  }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
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