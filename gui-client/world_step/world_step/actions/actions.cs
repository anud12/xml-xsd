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

    private LinkedNodeCollection<XSD.Nworld_step.Nactions.by> _by = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nactions.by> by
    {
      get => _by;
      set
      {
        _by = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _by.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }

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
    private XSD.Nworld_step.Nactions.person__teleport? _person__teleport = null;
    public XSD.Nworld_step.Nactions.person__teleport person__teleportOrCreate
    {
      get
      {
        if(_person__teleport == null)
        {
          _person__teleport = new();
          _person__teleport.ParentNode = this;
          NotifyChange();
        }
        return _person__teleport;
      }
      set
      {
        _person__teleport = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nactions.person__teleport? person__teleport
    {
      get
      {
        return _person__teleport;
      }
      set
      {
        _person__teleport = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nactions.person__on_person__property_mutation> _person__on_person__property_mutation = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nactions.person__on_person__property_mutation> person__on_person__property_mutation
    {
      get => _person__on_person__property_mutation;
      set
      {
        _person__on_person__property_mutation = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _person__on_person__property_mutation.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nactions.person__create> _person__create = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nactions.person__create> person__create
    {
      get => _person__create;
      set
      {
        _person__create = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _person__create.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nactions.person__move_to> _person__move_to = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nactions.person__move_to> person__move_to
    {
      get => _person__move_to;
      set
      {
        _person__move_to = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _person__move_to.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nactions.from_person> _from_person = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nactions.from_person> from_person
    {
      get => _from_person;
      set
      {
        _from_person = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _from_person.OnAdd = (value) =>
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

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.by> by)
      {
        this.by = by;
      }

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
      if(linkedNode is XSD.Nworld_step.Nactions.person__teleport person__teleport)
      {
        this.person__teleport = person__teleport;
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.person__on_person__property_mutation> person__on_person__property_mutation)
      {
        this.person__on_person__property_mutation = person__on_person__property_mutation;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.person__create> person__create)
      {
        this.person__create = person__create;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.person__move_to> person__move_to)
      {
        this.person__move_to = person__move_to;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.from_person> from_person)
      {
        this.from_person = from_person;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.zone__create zone__create)
      {
        this.zone__create = zone__create;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.region__appendNew region__appendNew)
      {
        this.region__appendNew = region__appendNew;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.by>)
      {
        this.by = null;
      }

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
      if(linkedNode is XSD.Nworld_step.Nactions.person__teleport)
      {
        this.person__teleport = null;
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.person__on_person__property_mutation>)
      {
        this.person__on_person__property_mutation = null;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.person__create>)
      {
        this.person__create = null;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.person__move_to>)
      {
        this.person__move_to = null;
      }

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nactions.from_person>)
      {
        this.from_person = null;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.zone__create)
      {
        this.zone__create = null;
      }

      if(linkedNode is XSD.Nworld_step.Nactions.region__appendNew)
      {
        this.region__appendNew = null;
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
      by = rawNode.InitializeWithRawNode("by", by);
      by.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
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
      person__teleport = rawNode.InitializeWithRawNode("person.teleport", person__teleport);

      person__on_person__property_mutation = rawNode.InitializeWithRawNode("person.on_person.property_mutation", person__on_person__property_mutation);
      person__on_person__property_mutation.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      person__create = rawNode.InitializeWithRawNode("person.create", person__create);
      person__create.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      person__move_to = rawNode.InitializeWithRawNode("person.move_to", person__move_to);
      person__move_to.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      from_person = rawNode.InitializeWithRawNode("from_person", from_person);
      from_person.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      zone__create = rawNode.InitializeWithRawNode("zone.create", zone__create);

      region__appendNew = rawNode.InitializeWithRawNode("region.appendNew", region__appendNew);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["by"] = by.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.create"] = location_graph__create.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.node.create_adjacent"] = location_graph__node__create_adjacent.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.node.add_classification"] = location_graph__node__add_classification.Select(x => x.SerializeIntoRawNode()).ToList();
      if(person__teleport != null) {
        rawNode.children["person.teleport"] = new List<RawNode> { person__teleport.SerializeIntoRawNode() };
      }
      rawNode.children["person.on_person.property_mutation"] = person__on_person__property_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person.create"] = person__create.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person.move_to"] = person__move_to.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["from_person"] = from_person.Select(x => x.SerializeIntoRawNode()).ToList();
      if(zone__create != null) {
        rawNode.children["zone.create"] = new List<RawNode> { zone__create.SerializeIntoRawNode() };
      }
      if(region__appendNew != null) {
        rawNode.children["region.appendNew"] = new List<RawNode> { region__appendNew.SerializeIntoRawNode() };
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
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.by.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.by.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nactions.by.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nactions.by.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.by.ContainsKey(pathIndex))
        {
          this.by[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nactions.by();
        this.by[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
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
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.person__teleport.TagName))
      {
        this.person__teleport ??= new XSD.Nworld_step.Nactions.person__teleport();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.person__teleport.TagName.Length + 3);
        this.person__teleport.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.person__on_person__property_mutation.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.person__on_person__property_mutation.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nactions.person__on_person__property_mutation.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nactions.person__on_person__property_mutation.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.person__on_person__property_mutation.ContainsKey(pathIndex))
        {
          this.person__on_person__property_mutation[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nactions.person__on_person__property_mutation();
        this.person__on_person__property_mutation[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.person__create.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.person__create.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nactions.person__create.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nactions.person__create.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.person__create.ContainsKey(pathIndex))
        {
          this.person__create[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nactions.person__create();
        this.person__create[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.person__move_to.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.person__move_to.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nactions.person__move_to.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nactions.person__move_to.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.person__move_to.ContainsKey(pathIndex))
        {
          this.person__move_to[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nactions.person__move_to();
        this.person__move_to[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.from_person.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.from_person.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nactions.from_person.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nactions.from_person.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.from_person.ContainsKey(pathIndex))
        {
          this.from_person[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nactions.from_person();
        this.from_person[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Nactions.by casted_by) {
        return this._by.KeyOf(casted_by);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.location_graph__create casted_location_graph__create) {
        return this._location_graph__create.KeyOf(casted_location_graph__create);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.location_graph__node__create_adjacent casted_location_graph__node__create_adjacent) {
        return this._location_graph__node__create_adjacent.KeyOf(casted_location_graph__node__create_adjacent);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.location_graph__node__add_classification casted_location_graph__node__add_classification) {
        return this._location_graph__node__add_classification.KeyOf(casted_location_graph__node__add_classification);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.person__teleport casted_person__teleport) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.person__on_person__property_mutation casted_person__on_person__property_mutation) {
        return this._person__on_person__property_mutation.KeyOf(casted_person__on_person__property_mutation);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.person__create casted_person__create) {
        return this._person__create.KeyOf(casted_person__create);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.person__move_to casted_person__move_to) {
        return this._person__move_to.KeyOf(casted_person__move_to);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.from_person casted_from_person) {
        return this._from_person.KeyOf(casted_from_person);
      }
      if(linkedNode is XSD.Nworld_step.Nactions.zone__create casted_zone__create) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.region__appendNew casted_region__appendNew) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nactions.by
      || candidateChild is XSD.Nworld_step.Nactions.location_graph__create
      || candidateChild is XSD.Nworld_step.Nactions.location_graph__node__create_adjacent
      || candidateChild is XSD.Nworld_step.Nactions.location_graph__node__add_classification
      || candidateChild is XSD.Nworld_step.Nactions.person__teleport
      || candidateChild is XSD.Nworld_step.Nactions.person__on_person__property_mutation
      || candidateChild is XSD.Nworld_step.Nactions.person__create
      || candidateChild is XSD.Nworld_step.Nactions.person__move_to
      || candidateChild is XSD.Nworld_step.Nactions.from_person
      || candidateChild is XSD.Nworld_step.Nactions.zone__create
      || candidateChild is XSD.Nworld_step.Nactions.region__appendNew
      || false;
    }

    public bool Equals(actions? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (actions)obj;
        return Equals(by, other.by) && Equals(location_graph__create, other.location_graph__create) && Equals(location_graph__node__create_adjacent, other.location_graph__node__create_adjacent) && Equals(location_graph__node__add_classification, other.location_graph__node__add_classification) && Equals(person__teleport, other.person__teleport) && Equals(person__on_person__property_mutation, other.person__on_person__property_mutation) && Equals(person__create, other.person__create) && Equals(person__move_to, other.person__move_to) && Equals(from_person, other.from_person) && Equals(zone__create, other.zone__create) && Equals(region__appendNew, other.region__appendNew);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, by);
        acc = HashCode.Combine(acc, location_graph__create);
        acc = HashCode.Combine(acc, location_graph__node__create_adjacent);
        acc = HashCode.Combine(acc, location_graph__node__add_classification);
        acc = HashCode.Combine(acc, person__teleport);
        acc = HashCode.Combine(acc, person__on_person__property_mutation);
        acc = HashCode.Combine(acc, person__create);
        acc = HashCode.Combine(acc, person__move_to);
        acc = HashCode.Combine(acc, from_person);
        acc = HashCode.Combine(acc, zone__create);
        acc = HashCode.Combine(acc, region__appendNew);
        return acc;
    }
  }
}