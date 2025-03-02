using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Nmutations {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person {
  public class mutations : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.action_rule.from_person.mutations";
    public static string TagName = "mutations";

    public string NodeName {get =>"mutations";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<mutations>> _callbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<type__property_mutation> _property_mutation = new();
    public LinkedNodeCollection<type__property_mutation> property_mutation
    {
      get => _property_mutation;
      set
      {
        _property_mutation = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _property_mutation.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public mutations()
    {
    }

    public mutations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public mutations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<mutations> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing mutations");
      //Deserialize arguments

      //Deserialize children
      property_mutation = rawNode.InitializeWithRawNode("property_mutation", property_mutation);
      property_mutation.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["property_mutation"] = property_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing mutations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__property_mutation.TagName + "["))
      {
        var startIndex = (type__property_mutation.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.property_mutation.ContainsKey(pathIndex))
        {
          this.property_mutation[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new type__property_mutation();
        this.property_mutation[pathIndex] = newEntry;
        newEntry.SetXPath(childXPath, rawNode);

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
      if(linkedNode is type__property_mutation casted_property_mutation) {
        return this._property_mutation.KeyOf(casted_property_mutation);
      }
      return null;
    }
  }
}