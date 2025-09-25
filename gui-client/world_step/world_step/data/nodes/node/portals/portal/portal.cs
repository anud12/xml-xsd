using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals {
  public class portal : IEquatable<portal>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.nodes.node.portals.portal";
    public static string TagName = "portal";

    public string NodeName {get =>"portal";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<portal>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String? _maxWidth;
    public System.String? maxWidth { get => _maxWidth; set => _maxWidth = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from _from = new XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from();
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from fromOrCreate
    {
      get
      {
        if(_from == null)
        {
          _from = new();
          _from.ParentNode = this;
          NotifyChange();
        }
        return _from;
      }
      set
      {
        _from = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from from
    {
      get
      {
        return _from;
      }
      set
      {
        _from = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to _to = new XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to();
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to toOrCreate
    {
      get
      {
        if(_to == null)
        {
          _to = new();
          _to.ParentNode = this;
          NotifyChange();
        }
        return _to;
      }
      set
      {
        _to = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to to
    {
      get
      {
        return _to;
      }
      set
      {
        _to = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public portal()
    {
    }

    public portal(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public portal(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "id")
      {
        Set_id(value);
      }
      if(name == "maxWidth")
      {
        Set_maxWidth(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from from)
      {
        this.from = from;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to to)
      {
        this.to = to;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from)
      {
        this.from = new();
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to)
      {
        this.to = new();
      }

    }

    public Action OnSelfChange(Action<portal> callback)
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
      // Godot.GD.Print("Deserializing portal");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("maxWidth"))
      {
        var attribute_maxWidth = rawNode.attributes["maxWidth"];
        this.maxWidth = rawNode.attributes["maxWidth"];
      }

      //Deserialize children
      from = rawNode.InitializeWithRawNode("from", from);

      to = rawNode.InitializeWithRawNode("to", to);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }
      if(this._maxWidth != null)
      {
        rawNode.attributes["maxWidth"] = this._maxWidth?.ToString();
      }

      //Serialize children
      if(from != null) {
        rawNode.children["from"] = new List<RawNode> { from.SerializeIntoRawNode() };
      }
      if(to != null) {
        rawNode.children["to"] = new List<RawNode> { to.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing portal");
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
      this.NotifyChange();
    }
    public System.String? Get_maxWidth()
    {
      return this.maxWidth;
    }
    public void Set_maxWidth(System.String? value)
    {
      this.maxWidth = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from.TagName.Length + 3);
        this.from.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to.TagName.Length + 3);
        this.to.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from casted_from) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to casted_to) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.from
      || candidateChild is XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.to
      || false;
    }

    public bool Equals(portal? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (portal)obj;
        return Equals(id, other.id) && Equals(maxWidth, other.maxWidth) && Equals(from, other.from) && Equals(to, other.to);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, maxWidth);
        acc = HashCode.Combine(acc, from);
        acc = HashCode.Combine(acc, to);
        return acc;
    }
  }
}