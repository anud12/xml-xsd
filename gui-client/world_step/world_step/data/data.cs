using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class data : IEquatable<data>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data";
    public static string TagName = "data";

    public string NodeName {get =>"data";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<data>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Nworld_step.Ndata.entities? _entities = null;
    public XSD.Nworld_step.Ndata.entities entitiesOrCreate
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
    public XSD.Nworld_step.Ndata.entities? entities
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

    private XSD.Nworld_step.Ndata.people? _people = null;
    public XSD.Nworld_step.Ndata.people peopleOrCreate
    {
      get
      {
        if(_people == null)
        {
          _people = new();
          _people.ParentNode = this;
          NotifyChange();
        }
        return _people;
      }
      set
      {
        _people = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.people? people
    {
      get
      {
        return _people;
      }
      set
      {
        _people = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.location? _location = null;
    public XSD.Nworld_step.Ndata.location locationOrCreate
    {
      get
      {
        if(_location == null)
        {
          _location = new();
          _location.ParentNode = this;
          NotifyChange();
        }
        return _location;
      }
      set
      {
        _location = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.location? location
    {
      get
      {
        return _location;
      }
      set
      {
        _location = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.zone_list? _zone_list = null;
    public XSD.Nworld_step.Ndata.zone_list zone_listOrCreate
    {
      get
      {
        if(_zone_list == null)
        {
          _zone_list = new();
          _zone_list.ParentNode = this;
          NotifyChange();
        }
        return _zone_list;
      }
      set
      {
        _zone_list = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.zone_list? zone_list
    {
      get
      {
        return _zone_list;
      }
      set
      {
        _zone_list = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public data()
    {
    }

    public data(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public data(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.entities entities)
      {
        this.entities = entities;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.people people)
      {
        this.people = people;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.location location)
      {
        this.location = location;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.zone_list zone_list)
      {
        this.zone_list = zone_list;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.entities)
      {
        this.entities = null;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.people)
      {
        this.people = null;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.location)
      {
        this.location = null;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.zone_list)
      {
        this.zone_list = null;
      }

    }

    public Action OnSelfChange(Action<data> callback)
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
      // Godot.GD.Print("Deserializing data");
      //Deserialize arguments

      //Deserialize children
      entities = rawNode.InitializeWithRawNode("entities", entities);

      people = rawNode.InitializeWithRawNode("people", people);

      location = rawNode.InitializeWithRawNode("location", location);

      zone_list = rawNode.InitializeWithRawNode("zone_list", zone_list);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(entities != null) {
        rawNode.children["entities"] = new List<RawNode> { entities.SerializeIntoRawNode() };
      }
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
      }
      if(location != null) {
        rawNode.children["location"] = new List<RawNode> { location.SerializeIntoRawNode() };
      }
      if(zone_list != null) {
        rawNode.children["zone_list"] = new List<RawNode> { zone_list.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing data");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.entities.TagName))
      {
        this.entities ??= new XSD.Nworld_step.Ndata.entities();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.entities.TagName.Length + 3);
        this.entities.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.people.TagName))
      {
        this.people ??= new XSD.Nworld_step.Ndata.people();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.people.TagName.Length + 3);
        this.people.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.location.TagName))
      {
        this.location ??= new XSD.Nworld_step.Ndata.location();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.location.TagName.Length + 3);
        this.location.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.zone_list.TagName))
      {
        this.zone_list ??= new XSD.Nworld_step.Ndata.zone_list();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.zone_list.TagName.Length + 3);
        this.zone_list.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.entities casted_entities) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.people casted_people) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.location casted_location) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.zone_list casted_zone_list) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.entities
      || candidateChild is XSD.Nworld_step.Ndata.people
      || candidateChild is XSD.Nworld_step.Ndata.location
      || candidateChild is XSD.Nworld_step.Ndata.zone_list
      || false;
    }

    public bool Equals(data? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (data)obj;
        return Equals(entities, other.entities) && Equals(people, other.people) && Equals(location, other.location) && Equals(zone_list, other.zone_list);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, entities);
        acc = HashCode.Combine(acc, people);
        acc = HashCode.Combine(acc, location);
        acc = HashCode.Combine(acc, zone_list);
        return acc;
    }
  }
}