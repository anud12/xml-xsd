using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nnodes.Nnode {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nnodes {
  public class node : IEquatable<node>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.nodes.node";
    public static string TagName = "node";

    public string NodeName {get =>"node";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<node>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String _name;
    public System.String name { get => _name; set => _name = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Nnodes.Nnode.origin _origin = new XSD.Nworld_step.Ndata.Nnodes.Nnode.origin();
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.origin originOrCreate
    {
      get
      {
        if(_origin == null)
        {
          _origin = new();
          _origin.ParentNode = this;
          NotifyChange();
        }
        return _origin;
      }
      set
      {
        _origin = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.origin origin
    {
      get
      {
        return _origin;
      }
      set
      {
        _origin = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.Nnodes.Nnode.area _area = new XSD.Nworld_step.Ndata.Nnodes.Nnode.area();
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.area areaOrCreate
    {
      get
      {
        if(_area == null)
        {
          _area = new();
          _area.ParentNode = this;
          NotifyChange();
        }
        return _area;
      }
      set
      {
        _area = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.area area
    {
      get
      {
        return _area;
      }
      set
      {
        _area = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.Nnodes.Nnode.portals? _portals = null;
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.portals portalsOrCreate
    {
      get
      {
        if(_portals == null)
        {
          _portals = new();
          _portals.ParentNode = this;
          NotifyChange();
        }
        return _portals;
      }
      set
      {
        _portals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nnodes.Nnode.portals? portals
    {
      get
      {
        return _portals;
      }
      set
      {
        _portals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public node()
    {
    }

    public node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public node(XmlElement xmlElement)
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
      if(name == "name")
      {
        Set_name(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.origin origin)
      {
        this.origin = origin;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.area area)
      {
        this.area = area;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.portals portals)
      {
        this.portals = portals;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.origin)
      {
        this.origin = new();
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.area)
      {
        this.area = new();
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.portals)
      {
        this.portals = null;
      }

    }

    public Action OnSelfChange(Action<node> callback)
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
      // Godot.GD.Print("Deserializing node");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("name"))
      {
        var attribute_name = rawNode.attributes["name"];
        this.name = rawNode.attributes["name"];
      }

      //Deserialize children
      origin = rawNode.InitializeWithRawNode("origin", origin);

      area = rawNode.InitializeWithRawNode("area", area);

      portals = rawNode.InitializeWithRawNode("portals", portals);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }
      if(this._name != null)
      {
        rawNode.attributes["name"] = this._name.ToString();
      }

      //Serialize children
      if(origin != null) {
        rawNode.children["origin"] = new List<RawNode> { origin.SerializeIntoRawNode() };
      }
      if(area != null) {
        rawNode.children["area"] = new List<RawNode> { area.SerializeIntoRawNode() };
      }
      if(portals != null) {
        rawNode.children["portals"] = new List<RawNode> { portals.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing node");
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
    public System.String Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String value)
    {
      this.name = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nnodes.Nnode.origin.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nnodes.Nnode.origin.TagName.Length + 3);
        this.origin.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nnodes.Nnode.area.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nnodes.Nnode.area.TagName.Length + 3);
        this.area.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nnodes.Nnode.portals.TagName))
      {
        this.portals ??= new XSD.Nworld_step.Ndata.Nnodes.Nnode.portals();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nnodes.Nnode.portals.TagName.Length + 3);
        this.portals.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.origin casted_origin) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.area casted_area) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nnodes.Nnode.portals casted_portals) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nnodes.Nnode.origin
      || candidateChild is XSD.Nworld_step.Ndata.Nnodes.Nnode.area
      || candidateChild is XSD.Nworld_step.Ndata.Nnodes.Nnode.portals
      || false;
    }

    public bool Equals(node? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (node)obj;
        return Equals(id, other.id) && Equals(name, other.name) && Equals(origin, other.origin) && Equals(area, other.area) && Equals(portals, other.portals);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, name);
        acc = HashCode.Combine(acc, origin);
        acc = HashCode.Combine(acc, area);
        acc = HashCode.Combine(acc, portals);
        return acc;
    }
  }
}