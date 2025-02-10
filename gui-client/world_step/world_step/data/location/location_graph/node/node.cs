using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph {
  public class node  {

    public static string ClassTypeId = "/world_step/data/location/location_graph/node";
    public static string TagName = "node";

    public string Tag = "node";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.String _node_rule_ref;
    public System.String id;
    public System.String _id;

    //Children elements
    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? _name = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? name {
      get { return _name; }
      set { _name = value; }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? _position = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? position {
      get { return _position; }
      set { _position = value; }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? _classifications = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? classifications {
      get { return _classifications; }
      set { _classifications = value; }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? _links = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? links {
      get { return _links; }
      set { _links = value; }
    }

    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people? _people = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people? people {
      get { return _people; }
      set { _people = value; }
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
      this._name = rawNode.InitializeWithRawNode("name", this._name);
      this._position = rawNode.InitializeWithRawNode("position", this._position);
      this._classifications = rawNode.InitializeWithRawNode("classifications", this._classifications);
      this._links = rawNode.InitializeWithRawNode("links", this._links);
      this._people = rawNode.InitializeWithRawNode("people", this._people);
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
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? Get_name()
    {
      return this._name;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name GetOrInsertDefault_name()
    {
      if(this._name == null) {

        // true2
        this._name = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_name();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_name(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? value)
    {
        this._name = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? Get_position()
    {
      return this._position;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position GetOrInsertDefault_position()
    {
      if(this._position == null) {

        // true2
        this._position = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_position();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_position(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? value)
    {
        this._position = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? Get_classifications()
    {
      return this._classifications;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications GetOrInsertDefault_classifications()
    {
      if(this._classifications == null) {

        // true2
        this._classifications = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_classifications();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_classifications(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? value)
    {
        this._classifications = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? Get_links()
    {
      return this._links;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links GetOrInsertDefault_links()
    {
      if(this._links == null) {

        // true2
        this._links = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_links();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_links(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? value)
    {
        this._links = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people? Get_people()
    {
      return this._people;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people GetOrInsertDefault_people()
    {
      if(this._people == null) {

        // true2
        this._people = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_people();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_people(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people? value)
    {
        this._people = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name.TagName))
      {
        this.name ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name.TagName.Length + 3);
        this.name.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position.TagName))
      {
        this.position ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position.TagName.Length + 3);
        this.position.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications.TagName))
      {
        this.classifications ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications.TagName.Length + 3);
        this.classifications.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links.TagName))
      {
        this.links ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links.TagName.Length + 3);
        this.links.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people.TagName))
      {
        this.people ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people.TagName.Length + 3);
        this.people.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}