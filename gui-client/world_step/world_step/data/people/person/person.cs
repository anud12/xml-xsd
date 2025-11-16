using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople {
  public class person : IEquatable<person>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.people.person";
    public static string TagName = "person";

    public string NodeName {get =>"person";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<person>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String? _name;
    public System.String? name { get => _name; set => _name = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Npeople.Nperson.properties? _properties = null;
    public XSD.Nworld_step.Ndata.Npeople.Nperson.properties propertiesOrCreate
    {
      get
      {
        if(_properties == null)
        {
          _properties = new();
          _properties.ParentNode = this;
          NotifyChange();
        }
        return _properties;
      }
      set
      {
        _properties = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.properties? properties
    {
      get
      {
        return _properties;
      }
      set
      {
        _properties = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Npeople.Nperson.relations> _relations = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Npeople.Nperson.relations> relations
    {
      get => _relations;
      set
      {
        _relations = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _relations.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    private XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? _classifications = null;
    public XSD.Nworld_step.Ndata.Npeople.Nperson.classifications classificationsOrCreate
    {
      get
      {
        if(_classifications == null)
        {
          _classifications = new();
          _classifications.ParentNode = this;
          NotifyChange();
        }
        return _classifications;
      }
      set
      {
        _classifications = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? classifications
    {
      get
      {
        return _classifications;
      }
      set
      {
        _classifications = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public person()
    {
    }

    public person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person(XmlElement xmlElement)
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
      if(name == "name")
      {
        Set_name(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Npeople.Nperson.properties properties)
      {
        this.properties = properties;
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Npeople.Nperson.relations> relations)
      {
        this.relations = relations;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Npeople.Nperson.classifications classifications)
      {
        this.classifications = classifications;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Npeople.Nperson.properties)
      {
        this.properties = null;
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Npeople.Nperson.relations>)
      {
        this.relations = null;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Npeople.Nperson.classifications)
      {
        this.classifications = null;
      }

    }


    public Action OnSelfChange(Action<person> callback)
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
      // Godot.GD.Print("Deserializing person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("name"))
      {
        var attribute_name = rawNode.attributes["name"];
        this.name = rawNode.attributes["name"];
      }

      //Deserialize children
      properties = rawNode.InitializeWithRawNode("properties", properties);

      relations = rawNode.InitializeWithRawNode("relations", relations);
      relations.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      classifications = rawNode.InitializeWithRawNode("classifications", classifications);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }
      if(this._name != null)
      {
        rawNode.attributes["name"] = this._name?.ToString();
      }

      //Serialize children
      if(properties != null) {
        rawNode.children["properties"] = new List<RawNode> { properties.SerializeIntoRawNode() };
      }
      rawNode.children["relations"] = relations.Select(x => x.SerializeIntoRawNode()).ToList();
      if(classifications != null) {
        rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person");
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
    public System.String? Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String? value)
    {
      this.name = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Npeople.Nperson.properties.TagName))
      {
        this.properties ??= new XSD.Nworld_step.Ndata.Npeople.Nperson.properties();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Npeople.Nperson.properties.TagName.Length + 3);
        this.properties.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Npeople.Nperson.relations.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Npeople.Nperson.relations.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.Npeople.Nperson.relations.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.Npeople.Nperson.relations.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.relations.ContainsKey(pathIndex))
        {
          this.relations[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Npeople.Nperson.relations();
        this.relations[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Npeople.Nperson.classifications.TagName))
      {
        this.classifications ??= new XSD.Nworld_step.Ndata.Npeople.Nperson.classifications();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Npeople.Nperson.classifications.TagName.Length + 3);
        this.classifications.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.Npeople.Nperson.properties casted_properties) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Npeople.Nperson.relations casted_relations) {
        return this._relations.KeyOf(casted_relations);
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Npeople.Nperson.classifications casted_classifications) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Npeople.Nperson.properties
      || candidateChild is XSD.Nworld_step.Ndata.Npeople.Nperson.relations
      || candidateChild is XSD.Nworld_step.Ndata.Npeople.Nperson.classifications
      || false;
    }

    public bool Equals(person? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (person)obj;
        return Equals(id, other.id) && Equals(name, other.name) && Equals(properties, other.properties) && Equals(relations, other.relations) && Equals(classifications, other.classifications);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, name);
        acc = HashCode.Combine(acc, properties);
        acc = HashCode.Combine(acc, relations);
        acc = HashCode.Combine(acc, classifications);
        return acc;
    }
  }
}