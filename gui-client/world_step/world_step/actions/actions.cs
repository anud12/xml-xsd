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
  public class actions : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions";
    public static string TagName = "actions";

    public string NodeName {get =>"actions";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<actions>> _callbackList = new();

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
          OnChange();
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
          OnChange();
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
          OnChange();
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
          OnChange();
        };
      }
    }
    private XSD.Nworld_step.Nactions.person__teleport? _person__teleport = null;
    public XSD.Nworld_step.Nactions.person__teleport person__teleport
    {
      get
      {
        if(_person__teleport == null)
        {
          _person__teleport = new();
          _person__teleport.ParentNode = this;
          OnChange();
        }
        return _person__teleport;
      }
      set
      {
        _person__teleport = value;
        _person__teleport.ParentNode = this;
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
          OnChange();
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
          OnChange();
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
          OnChange();
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
          OnChange();
        };
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

    public Action OnChange(Action<actions> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
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
          OnChange();
        };
      location_graph__create = rawNode.InitializeWithRawNode("location_graph.create", location_graph__create);
      location_graph__create.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      location_graph__node__create_adjacent = rawNode.InitializeWithRawNode("location_graph.node.create_adjacent", location_graph__node__create_adjacent);
      location_graph__node__create_adjacent.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      location_graph__node__add_classification = rawNode.InitializeWithRawNode("location_graph.node.add_classification", location_graph__node__add_classification);
      location_graph__node__add_classification.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      person__teleport = rawNode.InitializeWithRawNode("person.teleport", person__teleport);

      person__on_person__property_mutation = rawNode.InitializeWithRawNode("person.on_person.property_mutation", person__on_person__property_mutation);
      person__on_person__property_mutation.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      person__create = rawNode.InitializeWithRawNode("person.create", person__create);
      person__create.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      person__move_to = rawNode.InitializeWithRawNode("person.move_to", person__move_to);
      person__move_to.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      from_person = rawNode.InitializeWithRawNode("from_person", from_person);
      from_person.OnAdd = (value) =>
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
      return null;
    }
  }
}