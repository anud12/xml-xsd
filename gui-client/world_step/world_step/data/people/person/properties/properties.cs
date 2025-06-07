using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople.Nperson {
  public class properties : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.people.person.properties";
    public static string TagName = "properties";

    public string NodeName {get =>"properties";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<properties>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property> _property = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property> property
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
    public properties()
    {
    }

    public properties(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public properties(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<properties> callback)
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
      // Godot.GD.Print("Deserializing properties");
      //Deserialize arguments

      //Deserialize children
      property = rawNode.InitializeWithRawNode("property", property);
      property.OnAdd = (value) =>
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
      rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing properties");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.property.ContainsKey(pathIndex))
        {
          this.property[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property();
        this.property[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property casted_property) {
        return this._property.KeyOf(casted_property);
      }
      return null;
    }
  }
}