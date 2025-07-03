using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.Nselect_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen {
  public class select_person : IEquatable<select_person>, XSD.ILinkedNode , Itype__person_selection {

    public static string ClassTypeId = ".world_step.rule_group.events_rule.entry.then.select_person";
    public static string TagName = "select_person";

    public string NodeName {get =>"select_person";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<select_person>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    /* ignored attribute key={key} of type=origin*/

    //Attributes of type__person_selection

    //Children elements

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
    public select_person()
    {
    }

    public select_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public select_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      /* ignored attribute key={key} of type=origin*/
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }


    public Action OnSelfChange(Action<select_person> callback)
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
      // Godot.GD.Print("Deserializing select_person");
      //Deserialize arguments

      // Deserialize arguments of type__person_selection


      //Deserialize children

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
        // Godot.GD.Print("Serializing select_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    /* ignored attribute key={key} of type=origin*/


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
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
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return false;
    }

        public bool Equals(select_person? obj)
        {
            if (obj == null || GetType() != obj.GetType())
                return false;

            var other = (select_person)obj;
            return object.Equals(this, other);
        }

    public int GetHashCode()
    {
        return base.GetHashCode();
    }
  }
}