using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__entity.Ncontainers.Ncontainer {}
namespace XSD {
}
namespace XSD.Ntype__entity.Ncontainers {
  public class container : IEquatable<container>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__entity.containers.container";
    public static string TagName = "container";

    public string NodeName {get =>"container";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<container>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String _container_rule_ref;
    public System.String container_rule_ref { get => _container_rule_ref; set => _container_rule_ref = value; }

    //Children elements
    private XSD.Ntype__entity.Ncontainers.Ncontainer.entities? _entities = null;
    public XSD.Ntype__entity.Ncontainers.Ncontainer.entities entitiesOrCreate
    {
      get
      {
        if(_entities == null)
        {
          _entities = new();
          _entities.ParentNode = this;
          NotifyChange();
        }
        return _entities;
      }
      set
      {
        _entities = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__entity.Ncontainers.Ncontainer.entities? entities
    {
      get
      {
        return _entities;
      }
      set
      {
        _entities = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
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
      if(name == "id")
      {
        Set_id(value);
      }
      if(name == "container_rule_ref")
      {
        Set_container_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__entity.Ncontainers.Ncontainer.entities entities)
      {
        this.entities = entities;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__entity.Ncontainers.Ncontainer.entities)
      {
        this.entities = null;
      }

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
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("container_rule_ref"))
      {
        var attribute_container_rule_ref = rawNode.attributes["container_rule_ref"];
        this.container_rule_ref = rawNode.attributes["container_rule_ref"];
      }

      //Deserialize children
      entities = rawNode.InitializeWithRawNode("entities", entities);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }
      if(this._container_rule_ref != null)
      {
        rawNode.attributes["container_rule_ref"] = this._container_rule_ref.ToString();
      }

      //Serialize children
      if(entities != null) {
        rawNode.children["entities"] = new List<RawNode> { entities.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing container");
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
      this.NotifyChange();
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
      if(xpath.StartsWith(XSD.Ntype__entity.Ncontainers.Ncontainer.entities.TagName))
      {
        this.entities ??= new XSD.Ntype__entity.Ncontainers.Ncontainer.entities();
        var childXPath = xpath.Substring(XSD.Ntype__entity.Ncontainers.Ncontainer.entities.TagName.Length + 3);
        this.entities.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Ntype__entity.Ncontainers.Ncontainer.entities casted_entities) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Ntype__entity.Ncontainers.Ncontainer.entities
      || false;
    }

    public bool Equals(container? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (container)obj;
        return Equals(id, other.id) && Equals(container_rule_ref, other.container_rule_ref) && Equals(entities, other.entities);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, container_rule_ref);
        acc = HashCode.Combine(acc, entities);
        return acc;
    }
  }
}