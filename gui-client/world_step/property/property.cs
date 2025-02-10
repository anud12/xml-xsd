using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nproperty {}
namespace XSD {
}
namespace XSD {
  public class property  {

    public static string ClassTypeId = "/property";
    public static string TagName = "property";

    public string Tag = "property";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;
    public System.String _property_rule_ref;

    //Children elements
    private type__math_operations? _min = null;
    public type__math_operations? min {
      get { return _min; }
      set { _min = value; }
    }

    private type__math_operations? _max = null;
    public type__math_operations? max {
      get { return _max; }
      set { _max = value; }
    }
    public property()
    {
    }

    public property(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public property(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing property");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }

      //Deserialize children
      this._min = rawNode.InitializeWithRawNode("min", this._min);
      this._max = rawNode.InitializeWithRawNode("max", this._max);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.property_rule_ref != null)
      {
        rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
      }

      //Serialize children
      if(min != null) {
        rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
      }
      if(max != null) {
        rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing property");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
    public type__math_operations? Get_min()
    {
      return this.min;
    }
    public void Set_min(type__math_operations? value)
    {
      this.min = value;
    }
    public type__math_operations? Get_max()
    {
      return this.max;
    }
    public void Set_max(type__math_operations? value)
    {
      this.max = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.min ??= new type__math_operations();
        xpath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.min.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.max ??= new type__math_operations();
        xpath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.max.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}