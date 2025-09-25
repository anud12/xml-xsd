using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.NNodes {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata {
  public class Nodes : IEquatable<Nodes>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.Nodes";
    public static string TagName = "Nodes";

    public string NodeName {get =>"Nodes";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<Nodes>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.NNodes.Node> _Node = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.NNodes.Node> Node
    {
      get => _Node;
      set
      {
        _Node = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _Node.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public Nodes()
    {
    }

    public Nodes(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public Nodes(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.NNodes.Node> Node)
      {
        this.Node = Node;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.NNodes.Node>)
      {
        this.Node = new();
      }
    }

    public Action OnSelfChange(Action<Nodes> callback)
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
      // Godot.GD.Print("Deserializing Nodes");
      //Deserialize arguments

      //Deserialize children
      Node = rawNode.InitializeWithRawNode("Node", Node);
      Node.OnAdd = (value) =>
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
      rawNode.children["Node"] = Node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing Nodes");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.NNodes.Node.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.NNodes.Node.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.NNodes.Node.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.NNodes.Node.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.Node.ContainsKey(pathIndex))
        {
          this.Node[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.NNodes.Node();
        this.Node[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.Node casted_Node) {
        return this._Node.KeyOf(casted_Node);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.NNodes.Node
      || false;
    }

    public bool Equals(Nodes? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (Nodes)obj;
        return Equals(Node, other.Node);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, Node);
        return acc;
    }
  }
}