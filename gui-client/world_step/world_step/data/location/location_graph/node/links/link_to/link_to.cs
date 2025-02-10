using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks {
  public class link_to  {

    public static string ClassTypeId = "/world_step/data/location/location_graph/node/links/link_to";
    public static string TagName = "link_to";

    public string Tag = "link_to";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_id_ref;
    public System.String _node_id_ref;
    public System.Int32 total_progress;
    public System.Int32 _total_progress;

    //Children elements
    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people? _people = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people? people {
      get { return _people; }
      set { _people = value; }
    }

    private type__math_operations? _person_progress_property = null;
    public type__math_operations? person_progress_property {
      get { return _person_progress_property; }
      set { _person_progress_property = value; }
    }
    public link_to()
    {
    }

    public link_to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_id_ref"))
      {
        var attribute_node_id_ref = rawNode.attributes["node_id_ref"];
        this.node_id_ref = rawNode.attributes["node_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("total_progress"))
      {
        var attribute_total_progress = rawNode.attributes["total_progress"];
        this.total_progress = attribute_total_progress.ToInt();
      }

      //Deserialize children
      this._people = rawNode.InitializeWithRawNode("people", this._people);
      this._person_progress_property = rawNode.InitializeWithRawNode("person_progress_property", this._person_progress_property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_id_ref != null)
      {
        rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
      }
      if(this.total_progress != null)
      {
        rawNode.attributes["total_progress"] = this.total_progress.ToString();
      }

      //Serialize children
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
      }
      if(person_progress_property != null) {
        rawNode.children["person_progress_property"] = new List<RawNode> { person_progress_property.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }
    public System.Int32 Get_total_progress()
    {
      return this.total_progress;
    }
    public void Set_total_progress(System.Int32 value)
    {
      this.total_progress = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people? Get_people()
    {
      return this._people;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people GetOrInsertDefault_people()
    {
      if(this._people == null) {

        // true2
        this._people = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_people();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_people(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people? value)
    {
        this._people = value;
    }
    public type__math_operations? Get_person_progress_property()
    {
      return this.person_progress_property;
    }
    public void Set_person_progress_property(type__math_operations? value)
    {
      this.person_progress_property = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people.TagName))
      {
        this.people ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people.TagName.Length + 3);
        this.people.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.person_progress_property ??= new type__math_operations();
        xpath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.person_progress_property.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}