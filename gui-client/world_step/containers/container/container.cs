using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ncontainers.Ncontainer {}
namespace XSD {
}
namespace XSD.Ncontainers {
  public class container : IEquatable<container>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".containers.container";
    public static string TagName = "container";

    public string NodeName {get =>"container";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<container>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _container_rule_ref;
    public System.String container_rule_ref { get => _container_rule_ref; set => _container_rule_ref = value; }

    //Children elements
    public container()
    {
    }

    public container(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public container(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "container_rule_ref")
      {
        Set_container_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<container> callback)
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
      // Godot.GD.Print("Deserializing container");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("container_rule_ref"))
      {
        var attribute_container_rule_ref = rawNode.attributes["container_rule_ref"];
        this.container_rule_ref = rawNode.attributes["container_rule_ref"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._container_rule_ref != null)
      {
        rawNode.attributes["container_rule_ref"] = this._container_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing container");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_container_rule_ref()
    {
      return this.container_rule_ref;
    }
    public void Set_container_rule_ref(System.String value)
    {
      this.container_rule_ref = value;
      this.NotifyChange();
    }


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

    public bool Equals(container? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (container)obj;
        return Equals(container_rule_ref, other.container_rule_ref);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, container_rule_ref);
        return acc;
    }
  }
}