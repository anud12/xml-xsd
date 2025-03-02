using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nworld_metadata.Nelapsed_time {}
namespace XSD {
}
namespace XSD.Nworld_step.Nworld_metadata {
  public class elapsed_time : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.world_metadata.elapsed_time";
    public static string TagName = "elapsed_time";

    public string NodeName {get =>"elapsed_time";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<elapsed_time>> _callbackList = new();

    //Attributes
    private System.Int32 _value;
    public System.Int32 value { get => _value; set => _value = value; }

    //Children elements
    public elapsed_time()
    {
    }

    public elapsed_time(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public elapsed_time(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<elapsed_time> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing elapsed_time");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = attribute_value.ToInt();
      }

      //Deserialize children
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing elapsed_time");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.Int32 Get_value()
    {
      return this.value;
    }
    public void Set_value(System.Int32 value)
    {
      this.value = value;
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
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