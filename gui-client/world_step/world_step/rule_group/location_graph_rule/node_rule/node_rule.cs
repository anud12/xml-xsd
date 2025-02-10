using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {
  public class node_rule  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule/node_rule";
    public static string TagName = "node_rule";

    public string Tag = "node_rule";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name? _name = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name? name {
      get { return _name; }
      set { _name = value; }
    }

    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications? _classifications = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications? classifications {
      get { return _classifications; }
      set { _classifications = value; }
    }

    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list? _link_group_list = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list? link_group_list {
      get { return _link_group_list; }
      set { _link_group_list = value; }
    }

    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person? _existing_person = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person? existing_person {
      get { return _existing_person; }
      set { _existing_person = value; }
    }
    public node_rule()
    {
    }

    public node_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public node_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing node_rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this._name = rawNode.InitializeWithRawNode("name", this._name);
      this._classifications = rawNode.InitializeWithRawNode("classifications", this._classifications);
      this._link_group_list = rawNode.InitializeWithRawNode("link_group_list", this._link_group_list);
      this._existing_person = rawNode.InitializeWithRawNode("existing_person", this._existing_person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(name != null) {
        rawNode.children["name"] = new List<RawNode> { name.SerializeIntoRawNode() };
      }
      if(classifications != null) {
        rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
      }
      if(link_group_list != null) {
        rawNode.children["link_group_list"] = new List<RawNode> { link_group_list.SerializeIntoRawNode() };
      }
      if(existing_person != null) {
        rawNode.children["existing_person"] = new List<RawNode> { existing_person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing node_rule");
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
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name? Get_name()
    {
      return this._name;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name GetOrInsertDefault_name()
    {
      if(this._name == null) {

        // true2
        this._name = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_name();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_name(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name? value)
    {
        this._name = value;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications? Get_classifications()
    {
      return this._classifications;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications GetOrInsertDefault_classifications()
    {
      if(this._classifications == null) {

        // true2
        this._classifications = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_classifications();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_classifications(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications? value)
    {
        this._classifications = value;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list? Get_link_group_list()
    {
      return this._link_group_list;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list GetOrInsertDefault_link_group_list()
    {
      if(this._link_group_list == null) {

        // true2
        this._link_group_list = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_link_group_list();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_link_group_list(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list? value)
    {
        this._link_group_list = value;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person? Get_existing_person()
    {
      return this._existing_person;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person GetOrInsertDefault_existing_person()
    {
      if(this._existing_person == null) {

        // true2
        this._existing_person = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_existing_person();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_existing_person(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person? value)
    {
        this._existing_person = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name.TagName))
      {
        this.name ??= new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name.TagName.Length + 3);
        this.name.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications.TagName))
      {
        this.classifications ??= new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications.TagName.Length + 3);
        this.classifications.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list.TagName))
      {
        this.link_group_list ??= new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list.TagName.Length + 3);
        this.link_group_list.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person.TagName))
      {
        this.existing_person ??= new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person.TagName.Length + 3);
        this.existing_person.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}