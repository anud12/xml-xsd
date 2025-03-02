using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph {
  public class node : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.location.location_graph.node";
    public static string TagName = "node";

    public string NodeName {get =>"node";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<node>> _callbackList = new();

    //Attributes
    private System.String _node_rule_ref;
    public System.String node_rule_ref { get => _node_rule_ref; set => _node_rule_ref = value; }
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? _name = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name name
    {
      get
      {
        if(_name == null)
        {
          _name = new();
          _name.ParentNode = this;
          OnChange();
        }
        return _name;
      }
      set
      {
        _name = value;
        _name.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? _position = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position position
    {
      get
      {
        if(_position == null)
        {
          _position = new();
          _position.ParentNode = this;
          OnChange();
        }
        return _position;
      }
      set
      {
        _position = value;
        _position.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? _classifications = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications classifications
    {
      get
      {
        if(_classifications == null)
        {
          _classifications = new();
          _classifications.ParentNode = this;
          OnChange();
        }
        return _classifications;
      }
      set
      {
        _classifications = value;
        _classifications.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? _links = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links links
    {
      get
      {
        if(_links == null)
        {
          _links = new();
          _links.ParentNode = this;
          OnChange();
        }
        return _links;
      }
      set
      {
        _links = value;
        _links.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people? _people = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people people
    {
      get
      {
        if(_people == null)
        {
          _people = new();
          _people.ParentNode = this;
          OnChange();
        }
        return _people;
      }
      set
      {
        _people = value;
        _people.ParentNode = this;
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

    public Action OnChange(Action<node> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
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

      people = rawNode.InitializeWithRawNode("people", people);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
      }
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
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
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
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
      this.OnChange();
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name.TagName))
      {
        this.name ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name.TagName.Length + 3);
        this.name.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position.TagName))
      {
        this.position ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position.TagName.Length + 3);
        this.position.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications.TagName))
      {
        this.classifications ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications.TagName.Length + 3);
        this.classifications.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links.TagName))
      {
        this.links ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links.TagName.Length + 3);
        this.links.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people.TagName))
      {
        this.people ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people.TagName.Length + 3);
        this.people.SetXPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people casted_people) {
        return 0;
      }
      return null;
    }
  }
}