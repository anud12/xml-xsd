using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nname_rule.Nentry {}
namespace XSD {
  public interface Itype__name_token {

    //Children elements
    public LinkedNodeCollection<XSD.Ntype__name_token.name_token> name_token { get; set; }
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);

  }
}
namespace XSD.Nworld_step.Nrule_group.Nname_rule {
  public class entry : XSD.ILinkedNode , Itype__name_token {

    public static string ClassTypeId = ".world_step.rule_group.name_rule.entry";
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

    //Attributes of type__name_token

    //Children elements

    //Children of type__name_token

    private LinkedNodeCollection<XSD.Ntype__name_token.name_token> _name_token = new();
    public LinkedNodeCollection<XSD.Ntype__name_token.name_token> name_token
    {
      get => _name_token;
      set
      {
        _name_token = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _name_token.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
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

      // Deserialize arguments of type__name_token


      //Deserialize children

      // Deserialize children of type__name_token
  name_token = rawNode.InitializeWithRawNode("name_token", name_token);
  name_token.OnAdd = (value) =>
    {
      value.ParentNode = this;
      OnChange();
    };
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      // Serialize arguments of type__name_token


      //Serialize children

      // Serialize children of type__name_token
  rawNode.children["name_token"] = name_token.Select(x => x.SerializeIntoRawNode()).ToList();
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