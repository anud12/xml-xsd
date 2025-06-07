using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nclassification {}
namespace XSD {
}
namespace XSD {
  public class classification : XSD.ILinkedNode  {

    public static string ClassTypeId = ".classification";
    public static string TagName = "classification";

    public string NodeName {get =>"classification";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<classification>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String _classification_rule_ref;
    public System.String classification_rule_ref { get => _classification_rule_ref; set => _classification_rule_ref = value; }

    //Children elements
    public classification()
    {
    }

    public classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<classification> callback)
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
      // Godot.GD.Print("Deserializing classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("classification_rule_ref"))
      {
        var attribute_classification_rule_ref = rawNode.attributes["classification_rule_ref"];
        this.classification_rule_ref = rawNode.attributes["classification_rule_ref"];
      }

      //Deserialize children
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.classification_rule_ref != null)
      {
        rawNode.attributes["classification_rule_ref"] = this.classification_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_classification_rule_ref()
    {
      return this.classification_rule_ref;
    }
    public void Set_classification_rule_ref(System.String value)
    {
      this.classification_rule_ref = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
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
      return null;
    }
  }
}