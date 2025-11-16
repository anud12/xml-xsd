using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
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
  public class selection : IEquatable<selection>, XSD.ILinkedNode , Itype__person_selection {

    public static string ClassTypeId = ".world_step.rule_group.action_rule.from_person.on_person.selection";
    public static string TagName = "selection";

    public string NodeName {get =>"selection";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<selection>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Attributes of type__person_selection

    //Children elements
    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? _from_person_same_location_graph_node = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node from_person_same_location_graph_nodeOrCreate
    {
      get
      {
        if(_from_person_same_location_graph_node == null)
        {
          _from_person_same_location_graph_node = new();
          _from_person_same_location_graph_node.ParentNode = this;
          NotifyChange();
        }
        return _from_person_same_location_graph_node;
      }
      set
      {
        _from_person_same_location_graph_node = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? from_person_same_location_graph_node
    {
      get
      {
        return _from_person_same_location_graph_node;
      }
      set
      {
        _from_person_same_location_graph_node = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }


    //Children of type__person_selection
    private type__math_operations? _radius = null;
    public type__math_operations radiusOrCreate
    {
      get
      {
        if(_radius == null)
        {
          _radius = new();
          _radius.ParentNode = this;
          NotifyChange();
        }
        return _radius;
      }
      set
      {
        _radius = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations? radius
    {
      get
      {
        return _radius;
      }
      set
      {
        _radius = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private type__math_operations? _min = null;
    public type__math_operations minOrCreate
    {
      get
      {
        if(_min == null)
        {
          _min = new();
          _min.ParentNode = this;
          NotifyChange();
        }
        return _min;
      }
      set
      {
        _min = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations? min
    {
      get
      {
        return _min;
      }
      set
      {
        _min = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private type__math_operations? _max = null;
    public type__math_operations maxOrCreate
    {
      get
      {
        if(_max == null)
        {
          _max = new();
          _max.ParentNode = this;
          NotifyChange();
        }
        return _max;
      }
      set
      {
        _max = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations? max
    {
      get
      {
        return _max;
      }
      set
      {
        _max = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
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
          NotifyChange();
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
          NotifyChange();
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

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node from_person_same_location_graph_node)
      {
        this.from_person_same_location_graph_node = from_person_same_location_graph_node;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node)
      {
        this.from_person_same_location_graph_node = null;
      }

    }


    public Action OnSelfChange(Action<selection> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }

    public Action OnSelfChangeNode(Action<ILinkedNode> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }


    public Action OnChange(Action<List<ILinkedNode>> callback)
    {
      _onChangeCallbackList.Add(callback);
      return () => _onChangeCallbackList.Remove(callback);
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
      NotifyChange();
    };
  classification = rawNode.InitializeWithRawNode("classification", classification);
  classification.OnAdd = (value) =>
    {
      value.ParentNode = this;
      NotifyChange();
    };
      NotifyChange();
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


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node.TagName))
      {
        this.from_person_same_location_graph_node ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node.TagName.Length + 3);
        this.from_person_same_location_graph_node.DeserializeAtPath(childXPath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }

    public void NotifyChange(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _onSelfChangeCallbackList.ForEach(action => action(this));
      _onChangeCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.NotifyChange(linkedNodes);
    }

    public void NotifyChange()
    {
      NotifyChange(new ());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node casted_from_person_same_location_graph_node) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node
      || false;
    }

    public bool Equals(selection? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (selection)obj;
        return Equals(from_person_same_location_graph_node, other.from_person_same_location_graph_node);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, from_person_same_location_graph_node);
        return acc;
    }
  }
}