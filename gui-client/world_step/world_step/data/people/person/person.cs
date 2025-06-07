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
  public class person : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.people.person";
    public static string TagName = "person";

    public string NodeName {get =>"person";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<person>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String? _name;
    public System.String? name { get => _name; set => _name = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Npeople.Nperson.properties? _properties = null;
    public XSD.Nworld_step.Ndata.Npeople.Nperson.properties properties
    {
      get
      {
        if(_properties == null)
        {
          _properties = new();
          _properties.ParentNode = this;
          OnChange();
        }
        return _properties;
      }
      set
      {
        _properties = value;
        _properties.ParentNode = this;
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
          OnChange();
        };
      }
    }
    private XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? _classifications = null;
    public XSD.Nworld_step.Ndata.Npeople.Nperson.classifications classifications
    {
      get
      {
        if(_classifications == null)
        {
          _classifications = new();
          _classifications.ParentNode = this;
          OnChange();
        }
        return _classifications;
      }
      set
      {
        _classifications = value;
        _classifications.ParentNode = this;
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

    public Action OnChange(Action<person> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public Action OnChangeBubble(Action<List<ILinkedNode>> callback)
    {
      _bubbleCallbackList.Add(callback);
      return () => _bubbleCallbackList.Remove(callback);
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
          OnChange();
        };
      classifications = rawNode.InitializeWithRawNode("classifications", classifications);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.name != null)
      {
        rawNode.attributes["name"] = this.name?.ToString();
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
      this.OnChange();
    }
    public System.String? Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String? value)
    {
      this.name = value;
      this.OnChange();
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

    public void ChildChanged(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _callbackList.ForEach(action => action(this));
      _bubbleCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
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
  }
}