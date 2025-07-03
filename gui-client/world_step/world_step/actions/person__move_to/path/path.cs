using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__move_to.Npath {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nperson__move_to {
  public class path : IEquatable<path>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.person.move_to.path";
    public static string TagName = "path";

    public string NodeName {get =>"path";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<path>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node> _node = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node> node
    {
      get => _node;
      set
      {
        _node = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _node.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public path()
    {
    }

    public path(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public path(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node> node)
      {
        this.node = node;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>)
      {
        this.node = null;
      }
    }

    public Action OnSelfChange(Action<path> callback)
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
      // Godot.GD.Print("Deserializing path");
      //Deserialize arguments

      //Deserialize children
      node = rawNode.InitializeWithRawNode("node", node);
      node.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["node"] = node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing path");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.node.ContainsKey(pathIndex))
        {
          this.node[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node();
        this.node[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

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
      if(linkedNode is XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node casted_node) {
        return this._node.KeyOf(casted_node);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node
      || false;
    }

    public bool Equals(path? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (path)obj;
        return Equals(node, other.node);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, node);
        return acc;
    }
  }
}