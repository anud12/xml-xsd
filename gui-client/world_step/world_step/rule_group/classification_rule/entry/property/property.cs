using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.Nproperty {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry {
  public class property  {

    public static string ClassTypeId = "/world_step/rule_group/classification_rule/entry/property";
    public static string TagName = "property";

    public string Tag = "property";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;
    public System.String _property_rule_ref;
    /* ignored attribute key={key} of type=is*/

    //Children elements
    private type__math_operations _operation = new type__math_operations();
    public type__math_operations operation {
      get { return _operation; }
      set { _operation = value; }
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
      this._operation = rawNode.InitializeWithRawNode("operation", this._operation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.property_rule_ref != null)
      {
        rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
      }

      //Serialize children
      if(operation != null) {
        rawNode.children["operation"] = new List<RawNode> { operation.SerializeIntoRawNode() };
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
    /* ignored attribute key={key} of type=is*/
    public type__math_operations Get_operation()
    {
      return this.operation;
    }
    public void Set_operation(type__math_operations value)
    {
      this.operation = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        xpath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.operation.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}