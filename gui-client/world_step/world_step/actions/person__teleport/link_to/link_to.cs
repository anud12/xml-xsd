using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__teleport.Nlink_to {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nperson__teleport {
  public class link_to : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.person.teleport.link_to";
    public static string TagName = "link_to";

    public string NodeName {get =>"link_to";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<link_to>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.Int32 _accumulated_progress;
    public System.Int32 accumulated_progress { get => _accumulated_progress; set => _accumulated_progress = value; }

    //Children elements
    private type__link_to__selection _selection = new type__link_to__selection();
    public type__link_to__selection selection
    {
      get
      {
        if(_selection == null)
        {
          _selection = new();
          _selection.ParentNode = this;
          NotifyChange();
        }
        return _selection;
      }
      set
      {
        _selection = value;
        _selection.ParentNode = this;
      }
    }
    public link_to()
    {
    }

    public link_to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "accumulated_progress")
      {
        Set_accumulated_progress(value?.ToInt() ?? 0);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__link_to__selection selection)
      {
        this.selection = selection;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__link_to__selection)
      {
        this.selection = new();
      }

    }

    public Action OnSelfChange(Action<link_to> callback)
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
      // Godot.GD.Print("Deserializing link_to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("accumulated_progress"))
      {
        var attribute_accumulated_progress = rawNode.attributes["accumulated_progress"];
        this.accumulated_progress = attribute_accumulated_progress.ToInt();
      }

      //Deserialize children
      selection = rawNode.InitializeWithRawNode("selection", selection);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.accumulated_progress != null)
      {
        rawNode.attributes["accumulated_progress"] = this.accumulated_progress.ToString();
      }

      //Serialize children
      if(selection != null) {
        rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.Int32 Get_accumulated_progress()
    {
      return this.accumulated_progress;
    }
    public void Set_accumulated_progress(System.Int32 value)
    {
      this.accumulated_progress = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__link_to__selection.TagName))
      {
        var childXPath = xpath.Substring(type__link_to__selection.TagName.Length + 3);
        this.selection.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__link_to__selection casted_selection) {
        return 0;
      }
      return null;
    }
  }
}