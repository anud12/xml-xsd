using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.NNodes.NNode.NPortals {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.NNodes.NNode {
  public class Portals : IEquatable<Portals>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.Nodes.Node.Portals";
    public static string TagName = "Portals";

    public string NodeName {get =>"Portals";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<Portals>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal> _Portal = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal> Portal
    {
      get => _Portal;
      set
      {
        _Portal = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _Portal.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public Portals()
    {
    }

    public Portals(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public Portals(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal> Portal)
      {
        this.Portal = Portal;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal>)
      {
        this.Portal = new();
      }
    }

    public Action OnSelfChange(Action<Portals> callback)
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
      // Godot.GD.Print("Deserializing Portals");
      //Deserialize arguments

      //Deserialize children
      Portal = rawNode.InitializeWithRawNode("Portal", Portal);
      Portal.OnAdd = (value) =>
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
      rawNode.children["Portal"] = Portal.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing Portals");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.Portal.ContainsKey(pathIndex))
        {
          this.Portal[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal();
        this.Portal[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal casted_Portal) {
        return this._Portal.KeyOf(casted_Portal);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.Portal
      || false;
    }

    public bool Equals(Portals? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (Portals)obj;
        return Equals(Portal, other.Portal);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, Portal);
        return acc;
    }
  }
}