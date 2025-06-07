using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nproperty_rule {
  public class entry : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.property_rule.entry";
    public static string TagName = "entry";

    public string NodeName {get =>"entry";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<entry>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String _units;
    public System.String units { get => _units; set => _units = value; }

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default? _person_default = null;
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default person_default
    {
      get
      {
        if(_person_default == null)
        {
          _person_default = new();
          _person_default.ParentNode = this;
          OnChange();
        }
        return _person_default;
      }
      set
      {
        _person_default = value;
        _person_default.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default? _item_default = null;
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default item_default
    {
      get
      {
        if(_item_default == null)
        {
          _item_default = new();
          _item_default.ParentNode = this;
          OnChange();
        }
        return _item_default;
      }
      set
      {
        _item_default = value;
        _item_default.ParentNode = this;
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold> _property_threshold = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold> property_threshold
    {
      get => _property_threshold;
      set
      {
        _property_threshold = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _property_threshold.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public entry()
    {
    }

    public entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<entry> callback)
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
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("units"))
      {
        var attribute_units = rawNode.attributes["units"];
        this.units = rawNode.attributes["units"];
      }

      //Deserialize children
      person_default = rawNode.InitializeWithRawNode("person_default", person_default);

      item_default = rawNode.InitializeWithRawNode("item_default", item_default);

      property_threshold = rawNode.InitializeWithRawNode("property-threshold", property_threshold);
      property_threshold.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.units != null)
      {
        rawNode.attributes["units"] = this.units.ToString();
      }

      //Serialize children
      if(person_default != null) {
        rawNode.children["person_default"] = new List<RawNode> { person_default.SerializeIntoRawNode() };
      }
      if(item_default != null) {
        rawNode.children["item_default"] = new List<RawNode> { item_default.SerializeIntoRawNode() };
      }
      rawNode.children["property-threshold"] = property_threshold.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
      this.OnChange();
    }
    public System.String Get_units()
    {
      return this.units;
    }
    public void Set_units(System.String value)
    {
      this.units = value;
      this.OnChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default.TagName))
      {
        this.person_default ??= new XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default.TagName.Length + 3);
        this.person_default.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default.TagName))
      {
        this.item_default ??= new XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default.TagName.Length + 3);
        this.item_default.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.property_threshold.ContainsKey(pathIndex))
        {
          this.property_threshold[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold();
        this.property_threshold[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default casted_person_default) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default casted_item_default) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold casted_property_threshold) {
        return this._property_threshold.KeyOf(casted_property_threshold);
      }
      return null;
    }
  }
}