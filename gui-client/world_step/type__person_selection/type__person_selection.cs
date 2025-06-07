using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__person_selection {}
namespace XSD {
}
namespace XSD {
  public class type__person_selection : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__person_selection";
    public static string TagName = "type__person_selection";

    public string NodeName {get =>"type__person_selection";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__person_selection>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes

    //Children elements
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
    public type__person_selection()
    {
    }

    public type__person_selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__person_selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<type__person_selection> callback)
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
      // Godot.GD.Print("Deserializing type__person_selection");
      //Deserialize arguments

      //Deserialize children
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

      //Serialize children
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
        // Godot.GD.Print("Serializing type__person_selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.radius ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.radius.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.min ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.min.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.max ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.max.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__person_selection.property.TagName + "["))
      {
        var startIndex = (XSD.Ntype__person_selection.property.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Ntype__person_selection.property.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Ntype__person_selection.property.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.property.ContainsKey(pathIndex))
        {
          this.property[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Ntype__person_selection.property();
        this.property[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Ntype__person_selection.classification.TagName + "["))
      {
        var startIndex = (XSD.Ntype__person_selection.classification.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Ntype__person_selection.classification.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Ntype__person_selection.classification.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.classification.ContainsKey(pathIndex))
        {
          this.classification[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Ntype__person_selection.classification();
        this.classification[pathIndex] = newEntry;
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
      if(linkedNode is type__math_operations casted_radius) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_min) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_max) {
        return 0;
      }
      if(linkedNode is XSD.Ntype__person_selection.property casted_property) {
        return this._property.KeyOf(casted_property);
      }
      if(linkedNode is XSD.Ntype__person_selection.classification casted_classification) {
        return this._classification.KeyOf(casted_classification);
      }
      return null;
    }
  }
}