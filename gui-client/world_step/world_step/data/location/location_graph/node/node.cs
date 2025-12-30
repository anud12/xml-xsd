using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph {
  public class node : IEquatable<node>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.location.location_graph.node";
    public static string TagName = "node";

    public string NodeName {get =>"node";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<node>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _node_rule_ref;
    public System.String node_rule_ref { get => _node_rule_ref; set => _node_rule_ref = value; }
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? _name = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name nameOrCreate
    {
      get
      {
        if(_name == null)
        {
          _name = new();
          _name.ParentNode = this;
          NotifyChange();
        }
        return _name;
      }
      set
      {
        _name = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? name
    {
      get
      {
        return _name;
      }
      set
      {
        _name = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? _position = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position positionOrCreate
    {
      get
      {
        if(_position == null)
        {
          _position = new();
          _position.ParentNode = this;
          NotifyChange();
        }
        return _position;
      }
      set
      {
        _position = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? position
    {
      get
      {
        return _position;
      }
      set
      {
        _position = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? _classifications = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications classificationsOrCreate
    {
      get
      {
        if(_classifications == null)
        {
          _classifications = new();
          _classifications.ParentNode = this;
          NotifyChange();
        }
        return _classifications;
      }
      set
      {
        _classifications = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? classifications
    {
      get
      {
        return _classifications;
      }
      set
      {
        _classifications = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? _links = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links linksOrCreate
    {
      get
      {
        if(_links == null)
        {
          _links = new();
          _links.ParentNode = this;
          NotifyChange();
        }
        return _links;
      }
      set
      {
        _links = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? links
    {
      get
      {
        return _links;
      }
      set
      {
        _links = value;
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
      if(name == "node_rule_ref")
      {
        Set_node_rule_ref(value);
      }
      if(name == "id")
      {
        Set_id(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name name)
      {
        this.name = name;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position position)
      {
        this.position = position;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications classifications)
      {
        this.classifications = classifications;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links links)
      {
        this.links = links;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name)
      {
        this.name = null;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position)
      {
        this.position = null;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications)
      {
        this.classifications = null;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links)
      {
        this.links = null;
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
      if(rawNode.attributes.ContainsKey("node_rule_ref"))
      {
        var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
        this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      name = rawNode.InitializeWithRawNode("name", name);

      position = rawNode.InitializeWithRawNode("position", position);

      classifications = rawNode.InitializeWithRawNode("classifications", classifications);

      links = rawNode.InitializeWithRawNode("links", links);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this._node_rule_ref.ToString();
      }
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }

      //Serialize children
      if(name != null) {
        rawNode.children["name"] = new List<RawNode> { name.SerializeIntoRawNode() };
      }
      if(position != null) {
        rawNode.children["position"] = new List<RawNode> { position.SerializeIntoRawNode() };
      }
      if(classifications != null) {
        rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
      }
      if(links != null) {
        rawNode.children["links"] = new List<RawNode> { links.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing node");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
      this.NotifyChange();
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


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name.TagName))
      {
        this.name ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name.TagName.Length + 3);
        this.name.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position.TagName))
      {
        this.position ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position.TagName.Length + 3);
        this.position.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications.TagName))
      {
        this.classifications ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications.TagName.Length + 3);
        this.classifications.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links.TagName))
      {
        this.links ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links.TagName.Length + 3);
        this.links.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name casted_name) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position casted_position) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications casted_classifications) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links casted_links) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name
      || candidateChild is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position
      || candidateChild is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications
      || candidateChild is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links
      || false;
    }

    public bool Equals(node? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (node)obj;
        return Equals(node_rule_ref, other.node_rule_ref) && Equals(id, other.id) && Equals(name, other.name) && Equals(position, other.position) && Equals(classifications, other.classifications) && Equals(links, other.links);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, node_rule_ref);
        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, name);
        acc = HashCode.Combine(acc, position);
        acc = HashCode.Combine(acc, classifications);
        acc = HashCode.Combine(acc, links);
        return acc;
    }
  }
}