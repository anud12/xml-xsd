using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification {
  public class to_be_added__classification  {

    public static string ClassTypeId = "/world_step/actions/location_graph.node.add_classification/to_be_added__classification";
    public static string TagName = "to_be_added__classification";

    public string Tag = "to_be_added__classification";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_classification_rule_ref;
    public System.String _location_classification_rule_ref;

    //Children elements
    private XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and? _and = null;
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and? and {
      get { return _and; }
      set { _and = value; }
    }
    public to_be_added__classification()
    {
    }

    public to_be_added__classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public to_be_added__classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing to_be_added__classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
      {
        var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
      }

      //Deserialize children
      this._and = rawNode.InitializeWithRawNode("and", this._and);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_classification_rule_ref != null)
      {
        rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
      }

      //Serialize children
      if(and != null) {
        rawNode.children["and"] = new List<RawNode> { and.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing to_be_added__classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and? Get_and()
    {
      return this._and;
    }
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and GetOrInsertDefault_and()
    {
      if(this._and == null) {

        // true2
        this._and = new XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_and();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_and(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and? value)
    {
        this._and = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and.TagName))
      {
        this.and ??= new XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and();
        xpath = xpath.Substring(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and.TagName.Length + 3);
        this.and.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}