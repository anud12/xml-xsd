using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list {
  public class entity : IEquatable<entity>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list.zone.region.entity_list.entity";
    public static string TagName = "entity";

    public string NodeName {get =>"entity";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<entity>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _entity_id_ref;
    public System.String entity_id_ref { get => _entity_id_ref; set => _entity_id_ref = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position _position = new XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position();
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position positionOrCreate
    {
      get
      {
        if(_position == null)
        {
          _position = new();
          _position.ParentNode = this;
          NotifyChange();
        }
        return _position;
      }
      set
      {
        _position = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position position
    {
      get
      {
        return _position;
      }
      set
      {
        _position = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public entity()
    {
    }

    public entity(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entity(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "entity_id_ref")
      {
        Set_entity_id_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position position)
      {
        this.position = position;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position)
      {
        this.position = new();
      }

    }

    public Action OnSelfChange(Action<entity> callback)
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
      // Godot.GD.Print("Deserializing entity");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("entity_id_ref"))
      {
        var attribute_entity_id_ref = rawNode.attributes["entity_id_ref"];
        this.entity_id_ref = rawNode.attributes["entity_id_ref"];
      }

      //Deserialize children
      position = rawNode.InitializeWithRawNode("position", position);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._entity_id_ref != null)
      {
        rawNode.attributes["entity_id_ref"] = this._entity_id_ref.ToString();
      }

      //Serialize children
      if(position != null) {
        rawNode.children["position"] = new List<RawNode> { position.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entity");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_entity_id_ref()
    {
      return this.entity_id_ref;
    }
    public void Set_entity_id_ref(System.String value)
    {
      this.entity_id_ref = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position.TagName.Length + 3);
        this.position.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position casted_position) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.position
      || false;
    }

    public bool Equals(entity? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (entity)obj;
        return Equals(entity_id_ref, other.entity_id_ref) && Equals(position, other.position);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, entity_id_ref);
        acc = HashCode.Combine(acc, position);
        return acc;
    }
  }
}