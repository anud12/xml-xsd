using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nexisting_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule {
  public class existing_person : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.location_graph_rule.node_rule.existing_person";
    public static string TagName = "existing_person";

    public string NodeName {get =>"existing_person";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<existing_person>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.Int32 _min;
    public System.Int32 min { get => _min; set => _min = value; }
    private System.Int32? _max;
    public System.Int32? max { get => _max; set => _max = value; }

    //Children elements
    private type__person_selection _person_selection = new type__person_selection();
    public type__person_selection person_selection
    {
      get
      {
        if(_person_selection == null)
        {
          _person_selection = new();
          _person_selection.ParentNode = this;
          OnChange();
        }
        return _person_selection;
      }
      set
      {
        _person_selection = value;
        _person_selection.ParentNode = this;
      }
    }
    public existing_person()
    {
    }

    public existing_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public existing_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<existing_person> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public Action OnChangeBubble(Action<List<ILinkedNode>> callback)
    {
      _bubbleCallbackList.Add(callback);
      return () => _bubbleCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing existing_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("min"))
      {
        var attribute_min = rawNode.attributes["min"];
        this.min = attribute_min.ToInt();
      }
      if(rawNode.attributes.ContainsKey("max"))
      {
        var attribute_max = rawNode.attributes["max"];
        this.max = attribute_max?.ToInt();
      }

      //Deserialize children
      person_selection = rawNode.InitializeWithRawNode("person_selection", person_selection);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.min != null)
      {
        rawNode.attributes["min"] = this.min.ToString();
      }
      if(this.max != null)
      {
        rawNode.attributes["max"] = this.max?.ToString();
      }

      //Serialize children
      if(person_selection != null) {
        rawNode.children["person_selection"] = new List<RawNode> { person_selection.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing existing_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.Int32 Get_min()
    {
      return this.min;
    }
    public void Set_min(System.Int32 value)
    {
      this.min = value;
      this.OnChange();
    }
    public System.Int32? Get_max()
    {
      return this.max;
    }
    public void Set_max(System.Int32? value)
    {
      this.max = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__person_selection.TagName))
      {
        var childXPath = xpath.Substring(type__person_selection.TagName.Length + 3);
        this.person_selection.DeserializeAtPath(childXPath, rawNode);
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
      _bubbleCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is type__person_selection casted_person_selection) {
        return 0;
      }
      return null;
    }
  }
}