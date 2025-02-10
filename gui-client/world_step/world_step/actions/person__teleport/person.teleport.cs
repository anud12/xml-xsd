using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__teleport {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class person__teleport  {

    public static string ClassTypeId = "/world_step/actions/person.teleport";
    public static string TagName = "person.teleport";

    public string Tag = "person.teleport";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;
    public System.String _person_id_ref;

    //Children elements
    private XSD.Nworld_step.Nactions.Nperson__teleport.location_graph? _location_graph = null;
    public XSD.Nworld_step.Nactions.Nperson__teleport.location_graph? location_graph {
      get { return _location_graph; }
      set { _location_graph = value; }
    }

    private XSD.Nworld_step.Nactions.Nperson__teleport.link_to? _link_to = null;
    public XSD.Nworld_step.Nactions.Nperson__teleport.link_to? link_to {
      get { return _link_to; }
      set { _link_to = value; }
    }
    public person__teleport()
    {
    }

    public person__teleport(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person__teleport(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person.teleport");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }

      //Deserialize children
      this._location_graph = rawNode.InitializeWithRawNode("location_graph", this._location_graph);
      this._link_to = rawNode.InitializeWithRawNode("link_to", this._link_to);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }

      //Serialize children
      if(location_graph != null) {
        rawNode.children["location_graph"] = new List<RawNode> { location_graph.SerializeIntoRawNode() };
      }
      if(link_to != null) {
        rawNode.children["link_to"] = new List<RawNode> { link_to.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person.teleport");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public XSD.Nworld_step.Nactions.Nperson__teleport.location_graph? Get_location_graph()
    {
      return this._location_graph;
    }
    public XSD.Nworld_step.Nactions.Nperson__teleport.location_graph GetOrInsertDefault_location_graph()
    {
      if(this._location_graph == null) {

        // true2
        this._location_graph = new XSD.Nworld_step.Nactions.Nperson__teleport.location_graph();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_location_graph();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_location_graph(XSD.Nworld_step.Nactions.Nperson__teleport.location_graph? value)
    {
        this._location_graph = value;
    }
    public XSD.Nworld_step.Nactions.Nperson__teleport.link_to? Get_link_to()
    {
      return this._link_to;
    }
    public XSD.Nworld_step.Nactions.Nperson__teleport.link_to GetOrInsertDefault_link_to()
    {
      if(this._link_to == null) {

        // true2
        this._link_to = new XSD.Nworld_step.Nactions.Nperson__teleport.link_to();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_link_to();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_link_to(XSD.Nworld_step.Nactions.Nperson__teleport.link_to? value)
    {
        this._link_to = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nperson__teleport.location_graph.TagName))
      {
        this.location_graph ??= new XSD.Nworld_step.Nactions.Nperson__teleport.location_graph();
        xpath = xpath.Substring(XSD.Nworld_step.Nactions.Nperson__teleport.location_graph.TagName.Length + 3);
        this.location_graph.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nperson__teleport.link_to.TagName))
      {
        this.link_to ??= new XSD.Nworld_step.Nactions.Nperson__teleport.link_to();
        xpath = xpath.Substring(XSD.Nworld_step.Nactions.Nperson__teleport.link_to.TagName.Length + 3);
        this.link_to.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}