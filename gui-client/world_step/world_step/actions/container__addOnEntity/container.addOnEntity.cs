using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Ncontainer__addOnEntity {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class container__addOnEntity : IEquatable<container__addOnEntity>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.container.addOnEntity";
    public static string TagName = "container.addOnEntity";

    public string NodeName {get =>"container.addOnEntity";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<container__addOnEntity>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _container_rule_ref;
    public System.String container_rule_ref { get => _container_rule_ref; set => _container_rule_ref = value; }
    private System.String _entity_id;
    public System.String entity_id { get => _entity_id; set => _entity_id = value; }

    //Children elements
    public container__addOnEntity()
    {
    }

    public container__addOnEntity(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public container__addOnEntity(XmlElement xmlElement)
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
      if(name == "entity_id")
      {
        Set_entity_id(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<container__addOnEntity> callback)
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
      // Godot.GD.Print("Deserializing container.addOnEntity");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("container_rule_ref"))
      {
        var attribute_container_rule_ref = rawNode.attributes["container_rule_ref"];
        this.container_rule_ref = rawNode.attributes["container_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("entity_id"))
      {
        var attribute_entity_id = rawNode.attributes["entity_id"];
        this.entity_id = rawNode.attributes["entity_id"];
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
      if(this._entity_id != null)
      {
        rawNode.attributes["entity_id"] = this._entity_id.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing container.addOnEntity");
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
    public System.String Get_entity_id()
    {
      return this.entity_id;
    }
    public void Set_entity_id(System.String value)
    {
      this.entity_id = value;
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

    public bool Equals(container__addOnEntity? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (container__addOnEntity)obj;
        return Equals(container_rule_ref, other.container_rule_ref) && Equals(entity_id, other.entity_id);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, container_rule_ref);
        acc = HashCode.Combine(acc, entity_id);
        return acc;
    }
  }
}