using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection {}
namespace XSD {
  public interface Itype__person_selection {

    //Children elements
    public type__math_operations? radius { get; set; }
    public type__math_operations? min { get; set; }
    public type__math_operations? max { get; set; }
    public LinkedNodeCollection<XSD.Ntype__person_selection.property> property { get; set; }
    public LinkedNodeCollection<XSD.Ntype__person_selection.classification> classification { get; set; }
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);

  }
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person {
  public class selection : XSD.ILinkedNode , Itype__person_selection {

    public static string ClassTypeId = "/world_step/rule_group/action_rule/from_person/on_person/selection";
    public static string TagName = "selection";

    public string NodeName {get =>"selection";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<selection>> _callbackList = new();

    //Attributes

    //Attributes of type__person_selection

    //Children elements
    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? _from_person_same_location_graph_node = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node from_person_same_location_graph_node
    {
      get
      {
        if(_from_person_same_location_graph_node == null)
        {
          _from_person_same_location_graph_node = new();
          _from_person_same_location_graph_node.ParentNode = this;
          OnChange();
        }
        return _from_person_same_location_graph_node;
      }
      set
      {
        _from_person_same_location_graph_node = value;
        _from_person_same_location_graph_node.ParentNode = this;
      }
    }


    //Children of type__person_selection
    private type__math_operations? _radius = null;
    public type__math_operations radius
    {
      get
      {
        if(_radius == null)
        {
          _radius = new();
          _radius.ParentNode = this;
          OnChange();
        }
        return _radius;
      }
      set
      {
        _radius = value;
        _radius.ParentNode = this;
      }
    }

    private type__math_operations? _min = null;
    public type__math_operations min
    {
      get
      {
        if(_min == null)
        {
          _min = new();
          _min.ParentNode = this;
          OnChange();
        }
        return _min;
      }
      set
      {
        _min = value;
        _min.ParentNode = this;
      }
    }

    private type__math_operations? _max = null;
    public type__math_operations max
    {
      get
      {
        if(_max == null)
        {
          _max = new();
          _max.ParentNode = this;
          OnChange();
        }
        return _max;
      }
      set
      {
        _max = value;
        _max.ParentNode = this;
      }
    }

    private LinkedNodeCollection<XSD.Ntype__person_selection.property> _property = new();
    public LinkedNodeCollection<XSD.Ntype__person_selection.property> property
    {
      get => _property;
      set
      {
        _property = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _property.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }

    private LinkedNodeCollection<XSD.Ntype__person_selection.classification> _classification = new();
    public LinkedNodeCollection<XSD.Ntype__person_selection.classification> classification
    {
      get => _classification;
      set
      {
        _classification = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _classification.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public selection()
    {
    }

    public selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<selection> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing selection");
      //Deserialize arguments

      // Deserialize arguments of type__person_selection


      //Deserialize children
      from_person_same_location_graph_node = rawNode.InitializeWithRawNode("from_person_same_location_graph_node", from_person_same_location_graph_node);


      // Deserialize children of type__person_selection
  radius = rawNode.InitializeWithRawNode("radius", radius);

  min = rawNode.InitializeWithRawNode("min", min);

  max = rawNode.InitializeWithRawNode("max", max);

  property = rawNode.InitializeWithRawNode("property", property);
  property.OnAdd = (value) =>
    {
      value.ParentNode = this;
      OnChange();
    };
  classification = rawNode.InitializeWithRawNode("classification", classification);
  classification.OnAdd = (value) =>
    {
      value.ParentNode = this;
      OnChange();
    };
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__person_selection


      //Serialize children
      if(from_person_same_location_graph_node != null) {
        rawNode.children["from_person_same_location_graph_node"] = new List<RawNode> { from_person_same_location_graph_node.SerializeIntoRawNode() };
      }

      // Serialize children of type__person_selection
  if(radius != null) {
    rawNode.children["radius"] = new List<RawNode> { radius.SerializeIntoRawNode() };
  }
  if(min != null) {
    rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
  }
  if(max != null) {
    rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
  }
  rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
  rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("/"))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node.TagName))
      {
        this.from_person_same_location_graph_node ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node.TagName.Length + 3);
        this.from_person_same_location_graph_node.SetXPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node casted_from_person_same_location_graph_node) {
        return 0;
      }
      return null;
    }
  }
}