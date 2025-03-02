using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step {}
namespace XSD {
}
namespace XSD {
  public class world_step : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step";
    public static string TagName = "world_step";

    public string NodeName {get =>"world_step";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<world_step>> _callbackList = new();

    //Attributes

    //Children elements
    private XSD.Nworld_step.world_metadata? _world_metadata = null;
    public XSD.Nworld_step.world_metadata world_metadata
    {
      get
      {
        if(_world_metadata == null)
        {
          _world_metadata = new();
          _world_metadata.ParentNode = this;
          OnChange();
        }
        return _world_metadata;
      }
      set
      {
        _world_metadata = value;
        _world_metadata.ParentNode = this;
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.rule_group> _rule_group = new();
    public LinkedNodeCollection<XSD.Nworld_step.rule_group> rule_group
    {
      get => _rule_group;
      set
      {
        _rule_group = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _rule_group.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    private XSD.Nworld_step.data? _data = null;
    public XSD.Nworld_step.data data
    {
      get
      {
        if(_data == null)
        {
          _data = new();
          _data.ParentNode = this;
          OnChange();
        }
        return _data;
      }
      set
      {
        _data = value;
        _data.ParentNode = this;
      }
    }

    private XSD.Nworld_step.actions? _actions = null;
    public XSD.Nworld_step.actions actions
    {
      get
      {
        if(_actions == null)
        {
          _actions = new();
          _actions.ParentNode = this;
          OnChange();
        }
        return _actions;
      }
      set
      {
        _actions = value;
        _actions.ParentNode = this;
      }
    }
    public world_step()
    {
    }

    public world_step(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<world_step> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing world_step");
      //Deserialize arguments

      //Deserialize children
      world_metadata = rawNode.InitializeWithRawNode("world_metadata", world_metadata);

      rule_group = rawNode.InitializeWithRawNode("rule_group", rule_group);
      rule_group.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      data = rawNode.InitializeWithRawNode("data", data);

      actions = rawNode.InitializeWithRawNode("actions", actions);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(world_metadata != null) {
        rawNode.children["world_metadata"] = new List<RawNode> { world_metadata.SerializeIntoRawNode() };
      }
      rawNode.children["rule_group"] = rule_group.Select(x => x.SerializeIntoRawNode()).ToList();
      if(data != null) {
        rawNode.children["data"] = new List<RawNode> { data.SerializeIntoRawNode() };
      }
      if(actions != null) {
        rawNode.children["actions"] = new List<RawNode> { actions.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing world_step");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.world_metadata.TagName))
      {
        this.world_metadata ??= new XSD.Nworld_step.world_metadata();
        var childXPath = xpath.Substring(XSD.Nworld_step.world_metadata.TagName.Length + 3);
        this.world_metadata.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.rule_group.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.rule_group.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.rule_group.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.rule_group.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.rule_group.ContainsKey(pathIndex))
        {
          this.rule_group[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.rule_group();
        this.rule_group[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.data.TagName))
      {
        this.data ??= new XSD.Nworld_step.data();
        var childXPath = xpath.Substring(XSD.Nworld_step.data.TagName.Length + 3);
        this.data.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.actions.TagName))
      {
        this.actions ??= new XSD.Nworld_step.actions();
        var childXPath = xpath.Substring(XSD.Nworld_step.actions.TagName.Length + 3);
        this.actions.DeserializeAtPath(childXPath, rawNode);
        return;
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
      if(linkedNode is XSD.Nworld_step.world_metadata casted_world_metadata) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.rule_group casted_rule_group) {
        return this._rule_group.KeyOf(casted_rule_group);
      }
      if(linkedNode is XSD.Nworld_step.data casted_data) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.actions casted_actions) {
        return 0;
      }
      return null;
    }
  }
}