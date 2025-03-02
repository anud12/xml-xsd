using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nfrom_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class from_person : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.from_person";
    public static string TagName = "from_person";

    public string NodeName {get =>"from_person";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<from_person>> _callbackList = new();

    //Attributes
    private System.String _person_id_ref;
    public System.String person_id_ref { get => _person_id_ref; set => _person_id_ref = value; }
    private System.String _from_person_rule_ref;
    public System.String from_person_rule_ref { get => _from_person_rule_ref; set => _from_person_rule_ref = value; }

    //Children elements
    private XSD.Nworld_step.Nactions.Nfrom_person.on_person _on_person = new XSD.Nworld_step.Nactions.Nfrom_person.on_person();
    public XSD.Nworld_step.Nactions.Nfrom_person.on_person on_person
    {
      get
      {
        if(_on_person == null)
        {
          _on_person = new();
          _on_person.ParentNode = this;
          OnChange();
        }
        return _on_person;
      }
      set
      {
        _on_person = value;
        _on_person.ParentNode = this;
      }
    }
    public from_person()
    {
    }

    public from_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<from_person> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("from_person_rule_ref"))
      {
        var attribute_from_person_rule_ref = rawNode.attributes["from_person_rule_ref"];
        this.from_person_rule_ref = rawNode.attributes["from_person_rule_ref"];
      }

      //Deserialize children
      on_person = rawNode.InitializeWithRawNode("on_person", on_person);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }
      if(this.from_person_rule_ref != null)
      {
        rawNode.attributes["from_person_rule_ref"] = this.from_person_rule_ref.ToString();
      }

      //Serialize children
      if(on_person != null) {
        rawNode.children["on_person"] = new List<RawNode> { on_person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from_person");
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
      this.OnChange();
    }
    public System.String Get_from_person_rule_ref()
    {
      return this.from_person_rule_ref;
    }
    public void Set_from_person_rule_ref(System.String value)
    {
      this.from_person_rule_ref = value;
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nfrom_person.on_person.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.Nfrom_person.on_person.TagName.Length + 3);
        this.on_person.SetXPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nactions.Nfrom_person.on_person casted_on_person) {
        return 0;
      }
      return null;
    }
  }
}