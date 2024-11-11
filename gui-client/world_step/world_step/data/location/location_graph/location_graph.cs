using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation {
  public class location_graph  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule rule = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule();
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> node = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node>();
    public location_graph()
    {
    }

    public location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this.rule = rawNode.InitializeWithRawNode("rule", this.rule);
      this.node = rawNode.InitializeWithRawNode("node", this.node);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(rule != null) {
        rawNode.children["rule"] = new List<RawNode> { rule.SerializeIntoRawNode() };
      }
      rawNode.children["node"] = node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph");
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
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule Get_rule()
    {
      return this.rule;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule GetOrInsertDefault_rule()
    {
      if(this.rule == null) {
        this.rule = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule();
      }
      return this.rule;
    }
    public void Set_rule(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule value)
    {
      this.rule = value;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> Get_node()
    {
      return this.node;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> GetOrInsertDefault_node()
    {
      if(this.node == null) {
        this.node = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node>();
      }
      return this.node;
    }
    public void Set_node(List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> value)
    {
      this.node = value;
    }
  }
}