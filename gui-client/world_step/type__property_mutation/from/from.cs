using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__property_mutation.Nfrom {}
namespace XSD {
}
namespace XSD.Ntype__property_mutation {
  public class from  {

    public static string ClassTypeId = "/type__property_mutation/from";
    public static string TagName = "from";

    public string Tag = "from";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String participant;
    public System.String _participant;

    //Children elements
    private type__math_operations _operation = new type__math_operations();
    public type__math_operations operation {
      get { return _operation; }
      set { _operation = value; }
    }
    public from()
    {
    }

    public from(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("participant"))
      {
        var attribute_participant = rawNode.attributes["participant"];
        this.participant = rawNode.attributes["participant"];
      }

      //Deserialize children
      this._operation = rawNode.InitializeWithRawNode("operation", this._operation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.participant != null)
      {
        rawNode.attributes["participant"] = this.participant.ToString();
      }

      //Serialize children
      if(operation != null) {
        rawNode.children["operation"] = new List<RawNode> { operation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_participant()
    {
      return this.participant;
    }
    public void Set_participant(System.String value)
    {
      this.participant = value;
    }
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