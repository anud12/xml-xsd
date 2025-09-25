using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nnodes {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata {
  public class nodes : IEquatable<nodes>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.nodes";
    public static string TagName = "nodes";

    public string NodeName {get =>"nodes";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<nodes>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Nnodes.node> _node = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Nnodes.node> node
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
    public nodes()
    {
    }

    public nodes(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public nodes(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nnodes.node> node)
      {
        this.node = node;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nnodes.node>)
      {
        this.node = new();
      }
    }

    public Action OnSelfChange(Action<nodes> callback)
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
      // Godot.GD.Print("Deserializing nodes");
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
        // Godot.GD.Print("Serializing nodes");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nnodes.node.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nnodes.node.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.Nnodes.node.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.Nnodes.node.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.node.ContainsKey(pathIndex))
        {
          this.node[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nnodes.node();
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.node casted_node) {
        return this._node.KeyOf(casted_node);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nnodes.node
      || false;
    }

    public bool Equals(nodes? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (nodes)obj;
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