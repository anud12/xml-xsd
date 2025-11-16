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
  public class world_step : IEquatable<world_step>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step";
    public static string TagName = "world_step";

    public string NodeName {get =>"world_step";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<world_step>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Nworld_step.world_metadata? _world_metadata = null;
    public XSD.Nworld_step.world_metadata world_metadataOrCreate
    {
      get
      {
        if(_world_metadata == null)
        {
          _world_metadata = new();
          _world_metadata.ParentNode = this;
          NotifyChange();
        }
        return _world_metadata;
      }
      set
      {
        _world_metadata = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.world_metadata? world_metadata
    {
      get
      {
        return _world_metadata;
      }
      set
      {
        _world_metadata = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
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
          NotifyChange();
        };
      }
    }
    private XSD.Nworld_step.data? _data = null;
    public XSD.Nworld_step.data dataOrCreate
    {
      get
      {
        if(_data == null)
        {
          _data = new();
          _data.ParentNode = this;
          NotifyChange();
        }
        return _data;
      }
      set
      {
        _data = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.data? data
    {
      get
      {
        return _data;
      }
      set
      {
        _data = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.actions? _actions = null;
    public XSD.Nworld_step.actions actionsOrCreate
    {
      get
      {
        if(_actions == null)
        {
          _actions = new();
          _actions.ParentNode = this;
          NotifyChange();
        }
        return _actions;
      }
      set
      {
        _actions = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.actions? actions
    {
      get
      {
        return _actions;
      }
      set
      {
        _actions = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
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

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.world_metadata world_metadata)
      {
        this.world_metadata = world_metadata;
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.rule_group> rule_group)
      {
        this.rule_group = rule_group;
      }
      if(linkedNode is XSD.Nworld_step.data data)
      {
        this.data = data;
      }

      if(linkedNode is XSD.Nworld_step.actions actions)
      {
        this.actions = actions;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.world_metadata)
      {
        this.world_metadata = null;
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.rule_group>)
      {
        this.rule_group = null;
      }
      if(linkedNode is XSD.Nworld_step.data)
      {
        this.data = null;
      }

      if(linkedNode is XSD.Nworld_step.actions)
      {
        this.actions = null;
      }

    }


    public Action OnSelfChange(Action<world_step> callback)
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
      // Godot.GD.Print("Deserializing world_step");
      //Deserialize arguments

      //Deserialize children
      world_metadata = rawNode.InitializeWithRawNode("world_metadata", world_metadata);

      rule_group = rawNode.InitializeWithRawNode("rule_group", rule_group);
      rule_group.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      data = rawNode.InitializeWithRawNode("data", data);

      actions = rawNode.InitializeWithRawNode("actions", actions);
      NotifyChange();
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

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.world_metadata
      || candidateChild is XSD.Nworld_step.rule_group
      || candidateChild is XSD.Nworld_step.data
      || candidateChild is XSD.Nworld_step.actions
      || false;
    }

    public bool Equals(world_step? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (world_step)obj;
        return Equals(world_metadata, other.world_metadata) && Equals(rule_group, other.rule_group) && Equals(data, other.data) && Equals(actions, other.actions);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, world_metadata);
        acc = HashCode.Combine(acc, rule_group);
        acc = HashCode.Combine(acc, data);
        acc = HashCode.Combine(acc, actions);
        return acc;
    }
  }
}