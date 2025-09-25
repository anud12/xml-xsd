using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.NNodes.NNode {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.NNodes {
  public class Node : IEquatable<Node>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.Nodes.Node";
    public static string TagName = "Node";

    public string NodeName {get =>"Node";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<Node>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String _name;
    public System.String name { get => _name; set => _name = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.NNodes.NNode.Origin _Origin = new XSD.Nworld_step.Ndata.NNodes.NNode.Origin();
    public XSD.Nworld_step.Ndata.NNodes.NNode.Origin OriginOrCreate
    {
      get
      {
        if(_Origin == null)
        {
          _Origin = new();
          _Origin.ParentNode = this;
          NotifyChange();
        }
        return _Origin;
      }
      set
      {
        _Origin = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.NNodes.NNode.Origin Origin
    {
      get
      {
        return _Origin;
      }
      set
      {
        _Origin = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.NNodes.NNode.Area _Area = new XSD.Nworld_step.Ndata.NNodes.NNode.Area();
    public XSD.Nworld_step.Ndata.NNodes.NNode.Area AreaOrCreate
    {
      get
      {
        if(_Area == null)
        {
          _Area = new();
          _Area.ParentNode = this;
          NotifyChange();
        }
        return _Area;
      }
      set
      {
        _Area = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.NNodes.NNode.Area Area
    {
      get
      {
        return _Area;
      }
      set
      {
        _Area = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.NNodes.NNode.Portals? _Portals = null;
    public XSD.Nworld_step.Ndata.NNodes.NNode.Portals PortalsOrCreate
    {
      get
      {
        if(_Portals == null)
        {
          _Portals = new();
          _Portals.ParentNode = this;
          NotifyChange();
        }
        return _Portals;
      }
      set
      {
        _Portals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.NNodes.NNode.Portals? Portals
    {
      get
      {
        return _Portals;
      }
      set
      {
        _Portals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public Node()
    {
    }

    public Node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public Node(XmlElement xmlElement)
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
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.Origin Origin)
      {
        this.Origin = Origin;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.Area Area)
      {
        this.Area = Area;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.Portals Portals)
      {
        this.Portals = Portals;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.Origin)
      {
        this.Origin = new();
      }

      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.Area)
      {
        this.Area = new();
      }

      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.Portals)
      {
        this.Portals = null;
      }

    }

    public Action OnSelfChange(Action<Node> callback)
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
      // Godot.GD.Print("Deserializing Node");
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
      Origin = rawNode.InitializeWithRawNode("Origin", Origin);

      Area = rawNode.InitializeWithRawNode("Area", Area);

      Portals = rawNode.InitializeWithRawNode("Portals", Portals);
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
      if(Origin != null) {
        rawNode.children["Origin"] = new List<RawNode> { Origin.SerializeIntoRawNode() };
      }
      if(Area != null) {
        rawNode.children["Area"] = new List<RawNode> { Area.SerializeIntoRawNode() };
      }
      if(Portals != null) {
        rawNode.children["Portals"] = new List<RawNode> { Portals.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing Node");
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
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.NNodes.NNode.Origin.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.NNodes.NNode.Origin.TagName.Length + 3);
        this.Origin.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.NNodes.NNode.Area.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.NNodes.NNode.Area.TagName.Length + 3);
        this.Area.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.NNodes.NNode.Portals.TagName))
      {
        this.Portals ??= new XSD.Nworld_step.Ndata.NNodes.NNode.Portals();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.NNodes.NNode.Portals.TagName.Length + 3);
        this.Portals.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.Origin casted_Origin) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.Area casted_Area) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.Portals casted_Portals) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.NNodes.NNode.Origin
      || candidateChild is XSD.Nworld_step.Ndata.NNodes.NNode.Area
      || candidateChild is XSD.Nworld_step.Ndata.NNodes.NNode.Portals
      || false;
    }

    public bool Equals(Node? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (Node)obj;
        return Equals(id, other.id) && Equals(name, other.name) && Equals(Origin, other.Origin) && Equals(Area, other.Area) && Equals(Portals, other.Portals);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, name);
        acc = HashCode.Combine(acc, Origin);
        acc = HashCode.Combine(acc, Area);
        acc = HashCode.Combine(acc, Portals);
        return acc;
    }
  }
}