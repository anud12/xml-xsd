using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class actions : IEquatable<actions>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions";
    public static string TagName = "actions";

    public string NodeName {get =>"actions";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<actions>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__create> _location_graph__create = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__create> location_graph__create
    {
      get => _location_graph__create;
      set
      {
        _location_graph__create = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _location_graph__create.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent> _location_graph__node__create_adjacent = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent> location_graph__node__create_adjacent
    {
      get => _location_graph__node__create_adjacent;
      set
      {
        _location_graph__node__create_adjacent = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _location_graph__node__create_adjacent.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__node__add_classification> _location_graph__node__add_classification = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__node__add_classification> location_graph__node__add_classification
    {
      get => _location_graph__node__add_classification;
      set
      {
        _location_graph__node__add_classification = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _location_graph__node__add_classification.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    private XSD.Nworld_step.Nactions.zone__create? _zone__create = null;
    public XSD.Nworld_step.Nactions.zone__create zone__createOrCreate
    {
      get
      {
        if(_zone__create == null)
        {
          _zone__create = new();
          _zone__create.ParentNode = this;
          NotifyChange();
        }
        return _zone__create;
      }
      set
      {
        _zone__create = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.zone__create? zone__create
    {
      get
      {
        return _zone__create;
      }
      set
      {
        _zone__create = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nactions.region__appendNew? _region__appendNew = null;
    public XSD.Nworld_step.Nactions.region__appendNew region__appendNewOrCreate
    {
      get
      {
        if(_region__appendNew == null)
        {
          _region__appendNew = new();
          _region__appendNew.ParentNode = this;
          NotifyChange();
        }
        return _region__appendNew;
      }
      set
      {
        _region__appendNew = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.region__appendNew? region__appendNew
    {
      get
      {
        return _region__appendNew;
      }
      set
      {
        _region__appendNew = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nactions.region__resolvePortals? _region__resolvePortals = null;
    public XSD.Nworld_step.Nactions.region__resolvePortals region__resolvePortalsOrCreate
    {
      get
      {
        if(_region__resolvePortals == null)
        {
          _region__resolvePortals = new();
          _region__resolvePortals.ParentNode = this;
          NotifyChange();
        }
        return _region__resolvePortals;
      }
      set
      {
        _region__resolvePortals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.region__resolvePortals? region__resolvePortals
    {
      get
      {
        return _region__resolvePortals;
      }
      set
      {
        _region__resolvePortals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nactions.region__teleportEntity? _region__teleportEntity = null;
    public XSD.Nworld_step.Nactions.region__teleportEntity region__teleportEntityOrCreate
    {
      get
      {
        if(_region__teleportEntity == null)
        {
          _region__teleportEntity = new();
          _region__teleportEntity.ParentNode = this;
          NotifyChange();
        }
        return _region__teleportEntity;
      }
      set
      {
        _region__teleportEntity = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.region__teleportEntity? region__teleportEntity
    {
      get
      {
        return _region__teleportEntity;
      }
      set
      {
        _region__teleportEntity = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nactions.entity__create? _entity__create = null;
    public XSD.Nworld_step.Nactions.entity__create entity__createOrCreate
    {
      get
      {
        if(_entity__create == null)
        {
          _entity__create = new();
          _entity__create.ParentNode = this;
          NotifyChange();
        }
        return _entity__create;
      }
      set
      {
        _entity__create = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.entity__create? entity__create
    {
      get
      {
        return _entity__create;
      }
      set
      {
        _entity__create = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nactions.entity__setText? _entity__setText = null;
    public XSD.Nworld_step.Nactions.entity__setText entity__setTextOrCreate
    {
      get
      {
        if(_entity__setText == null)
        {
          _entity__setText = new();
          _entity__setText.ParentNode = this;
          NotifyChange();
        }
        return _entity__setText;
      }
      set
      {
        _entity__setText = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.entity__setText? entity__setText
    {
      get
      {
        return _entity__setText;
      }
      set
      {
        _entity__setText = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nactions.container__addOnEntity? _container__addOnEntity = null;
    public XSD.Nworld_step.Nactions.container__addOnEntity container__addOnEntityOrCreate
    {
      get
      {
        if(_container__addOnEntity == null)
        {
          _container__addOnEntity = new();
          _container__addOnEntity.ParentNode = this;
          NotifyChange();
        }
        return _container__addOnEntity;
      }
      set
      {
        _container__addOnEntity = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.container__addOnEntity? container__addOnEntity
    {
      get
      {
        return _container__addOnEntity;
      }
      set
      {
        _container__addOnEntity = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nactions.operation__echo? _operation__echo = null;
    public XSD.Nworld_step.Nactions.operation__echo operation__echoOrCreate
    {
      get
      {
        if(_operation__echo == null)
        {
          _operation__echo = new();
          _operation__echo.ParentNode = this;
          NotifyChange();
        }
        return _operation__echo;
      }
      set
      {
        _operation__echo = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.operation__echo? operation__echo
    {
      get
      {
        return _operation__echo;
      }
      set
      {
        _operation__echo = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public actions()
    {
    }

    public actions(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public actions(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__create> location_graph__create)
      {
        this.location_graph__create = location_graph__create;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent> location_graph__node__create_adjacent)
      {
        this.location_graph__node__create_adjacent = location_graph__node__create_adjacent;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__node__add_classification> location_graph__node__add_classification)
      {
        this.location_graph__node__add_classification = location_graph__node__add_classification;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.zone__create zone__create)
      {
        this.zone__create = zone__create;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.region__appendNew region__appendNew)
      {
        this.region__appendNew = region__appendNew;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.region__resolvePortals region__resolvePortals)
      {
        this.region__resolvePortals = region__resolvePortals;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.region__teleportEntity region__teleportEntity)
      {
        this.region__teleportEntity = region__teleportEntity;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.entity__create entity__create)
      {
        this.entity__create = entity__create;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.entity__setText entity__setText)
      {
        this.entity__setText = entity__setText;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.container__addOnEntity container__addOnEntity)
      {
        this.container__addOnEntity = container__addOnEntity;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.operation__echo operation__echo)
      {
        this.operation__echo = operation__echo;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__create>)
      {
        this.location_graph__create = null;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>)
      {
        this.location_graph__node__create_adjacent = null;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.location_graph__node__add_classification>)
      {
        this.location_graph__node__add_classification = null;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.zone__create)
      {
        this.zone__create = null;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.region__appendNew)
      {
        this.region__appendNew = null;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.region__resolvePortals)
      {
        this.region__resolvePortals = null;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.region__teleportEntity)
      {
        this.region__teleportEntity = null;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.entity__create)
      {
        this.entity__create = null;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.entity__setText)
      {
        this.entity__setText = null;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.container__addOnEntity)
      {
        this.container__addOnEntity = null;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.operation__echo)
      {
        this.operation__echo = null;
      }

    }

    public Action OnSelfChange(Action<actions> callback)
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
      // Godot.GD.Print("Deserializing actions");
      //Deserialize arguments

      //Deserialize children
      location_graph__create = rawNode.InitializeWithRawNode("location_graph.create", location_graph__create);
      location_graph__create.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      location_graph__node__create_adjacent = rawNode.InitializeWithRawNode("location_graph.node.create_adjacent", location_graph__node__create_adjacent);
      location_graph__node__create_adjacent.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      location_graph__node__add_classification = rawNode.InitializeWithRawNode("location_graph.node.add_classification", location_graph__node__add_classification);
      location_graph__node__add_classification.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      zone__create = rawNode.InitializeWithRawNode("zone.create", zone__create);

      region__appendNew = rawNode.InitializeWithRawNode("region.appendNew", region__appendNew);

      region__resolvePortals = rawNode.InitializeWithRawNode("region.resolvePortals", region__resolvePortals);

      region__teleportEntity = rawNode.InitializeWithRawNode("region.teleportEntity", region__teleportEntity);

      entity__create = rawNode.InitializeWithRawNode("entity.create", entity__create);

      entity__setText = rawNode.InitializeWithRawNode("entity.setText", entity__setText);

      container__addOnEntity = rawNode.InitializeWithRawNode("container.addOnEntity", container__addOnEntity);

      operation__echo = rawNode.InitializeWithRawNode("operation.echo", operation__echo);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["location_graph.create"] = location_graph__create.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.node.create_adjacent"] = location_graph__node__create_adjacent.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.node.add_classification"] = location_graph__node__add_classification.Select(x => x.SerializeIntoRawNode()).ToList();
      if(zone__create != null) {
        rawNode.children["zone.create"] = new List<RawNode> { zone__create.SerializeIntoRawNode() };
      }
      if(region__appendNew != null) {
        rawNode.children["region.appendNew"] = new List<RawNode> { region__appendNew.SerializeIntoRawNode() };
      }
      if(region__resolvePortals != null) {
        rawNode.children["region.resolvePortals"] = new List<RawNode> { region__resolvePortals.SerializeIntoRawNode() };
      }
      if(region__teleportEntity != null) {
        rawNode.children["region.teleportEntity"] = new List<RawNode> { region__teleportEntity.SerializeIntoRawNode() };
      }
      if(entity__create != null) {
        rawNode.children["entity.create"] = new List<RawNode> { entity__create.SerializeIntoRawNode() };
      }
      if(entity__setText != null) {
        rawNode.children["entity.setText"] = new List<RawNode> { entity__setText.SerializeIntoRawNode() };
      }
      if(container__addOnEntity != null) {
        rawNode.children["container.addOnEntity"] = new List<RawNode> { container__addOnEntity.SerializeIntoRawNode() };
      }
      if(operation__echo != null) {
        rawNode.children["operation.echo"] = new List<RawNode> { operation__echo.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing actions");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.location_graph__create.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.location_graph__create.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nactions.location_graph__create.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nactions.location_graph__create.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.location_graph__create.ContainsKey(pathIndex))
        {
          this.location_graph__create[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nactions.location_graph__create();
        this.location_graph__create[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.location_graph__node__create_adjacent.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.location_graph__node__create_adjacent.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nactions.location_graph__node__create_adjacent.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nactions.location_graph__node__create_adjacent.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.location_graph__node__create_adjacent.ContainsKey(pathIndex))
        {
          this.location_graph__node__create_adjacent[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nactions.location_graph__node__create_adjacent();
        this.location_graph__node__create_adjacent[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.location_graph__node__add_classification.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.location_graph__node__add_classification.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nactions.location_graph__node__add_classification.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nactions.location_graph__node__add_classification.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.location_graph__node__add_classification.ContainsKey(pathIndex))
        {
          this.location_graph__node__add_classification[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nactions.location_graph__node__add_classification();
        this.location_graph__node__add_classification[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.zone__create.TagName))
      {
        this.zone__create ??= new XSD.Nworld_step.Nactions.zone__create();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.zone__create.TagName.Length + 3);
        this.zone__create.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.region__appendNew.TagName))
      {
        this.region__appendNew ??= new XSD.Nworld_step.Nactions.region__appendNew();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.region__appendNew.TagName.Length + 3);
        this.region__appendNew.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.region__resolvePortals.TagName))
      {
        this.region__resolvePortals ??= new XSD.Nworld_step.Nactions.region__resolvePortals();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.region__resolvePortals.TagName.Length + 3);
        this.region__resolvePortals.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.region__teleportEntity.TagName))
      {
        this.region__teleportEntity ??= new XSD.Nworld_step.Nactions.region__teleportEntity();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.region__teleportEntity.TagName.Length + 3);
        this.region__teleportEntity.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.entity__create.TagName))
      {
        this.entity__create ??= new XSD.Nworld_step.Nactions.entity__create();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.entity__create.TagName.Length + 3);
        this.entity__create.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.entity__setText.TagName))
      {
        this.entity__setText ??= new XSD.Nworld_step.Nactions.entity__setText();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.entity__setText.TagName.Length + 3);
        this.entity__setText.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.container__addOnEntity.TagName))
      {
        this.container__addOnEntity ??= new XSD.Nworld_step.Nactions.container__addOnEntity();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.container__addOnEntity.TagName.Length + 3);
        this.container__addOnEntity.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.operation__echo.TagName))
      {
        this.operation__echo ??= new XSD.Nworld_step.Nactions.operation__echo();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.operation__echo.TagName.Length + 3);
        this.operation__echo.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nactions.location_graph__create casted_location_graph__create) {
        return this._location_graph__create.KeyOf(casted_location_graph__create);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.location_graph__node__create_adjacent casted_location_graph__node__create_adjacent) {
        return this._location_graph__node__create_adjacent.KeyOf(casted_location_graph__node__create_adjacent);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.location_graph__node__add_classification casted_location_graph__node__add_classification) {
        return this._location_graph__node__add_classification.KeyOf(casted_location_graph__node__add_classification);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.zone__create casted_zone__create) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.region__appendNew casted_region__appendNew) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.region__resolvePortals casted_region__resolvePortals) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.region__teleportEntity casted_region__teleportEntity) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.entity__create casted_entity__create) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.entity__setText casted_entity__setText) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.container__addOnEntity casted_container__addOnEntity) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.operation__echo casted_operation__echo) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nactions.location_graph__create
      || candidateChild is XSD.Nworld_step.Nactions.location_graph__node__create_adjacent
      || candidateChild is XSD.Nworld_step.Nactions.location_graph__node__add_classification
      || candidateChild is XSD.Nworld_step.Nactions.zone__create
      || candidateChild is XSD.Nworld_step.Nactions.region__appendNew
      || candidateChild is XSD.Nworld_step.Nactions.region__resolvePortals
      || candidateChild is XSD.Nworld_step.Nactions.region__teleportEntity
      || candidateChild is XSD.Nworld_step.Nactions.entity__create
      || candidateChild is XSD.Nworld_step.Nactions.entity__setText
      || candidateChild is XSD.Nworld_step.Nactions.container__addOnEntity
      || candidateChild is XSD.Nworld_step.Nactions.operation__echo
      || false;
    }

    public bool Equals(actions? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (actions)obj;
        return Equals(location_graph__create, other.location_graph__create) && Equals(location_graph__node__create_adjacent, other.location_graph__node__create_adjacent) && Equals(location_graph__node__add_classification, other.location_graph__node__add_classification) && Equals(zone__create, other.zone__create) && Equals(region__appendNew, other.region__appendNew) && Equals(region__resolvePortals, other.region__resolvePortals) && Equals(region__teleportEntity, other.region__teleportEntity) && Equals(entity__create, other.entity__create) && Equals(entity__setText, other.entity__setText) && Equals(container__addOnEntity, other.container__addOnEntity) && Equals(operation__echo, other.operation__echo);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, location_graph__create);
        acc = HashCode.Combine(acc, location_graph__node__create_adjacent);
        acc = HashCode.Combine(acc, location_graph__node__add_classification);
        acc = HashCode.Combine(acc, zone__create);
        acc = HashCode.Combine(acc, region__appendNew);
        acc = HashCode.Combine(acc, region__resolvePortals);
        acc = HashCode.Combine(acc, region__teleportEntity);
        acc = HashCode.Combine(acc, entity__create);
        acc = HashCode.Combine(acc, entity__setText);
        acc = HashCode.Combine(acc, container__addOnEntity);
        acc = HashCode.Combine(acc, operation__echo);
        return acc;
    }
  }
}