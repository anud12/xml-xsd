using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class data : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data";
    public static string TagName = "data";

    public string NodeName {get =>"data";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<data>> _callbackList = new();

    //Attributes

    //Children elements
    private XSD.Nworld_step.Ndata.people? _people = null;
    public XSD.Nworld_step.Ndata.people people
    {
      get
      {
        if(_people == null)
        {
          _people = new();
          _people.ParentNode = this;
          OnChange();
        }
        return _people;
      }
      set
      {
        _people = value;
        _people.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Ndata.location? _location = null;
    public XSD.Nworld_step.Ndata.location location
    {
      get
      {
        if(_location == null)
        {
          _location = new();
          _location.ParentNode = this;
          OnChange();
        }
        return _location;
      }
      set
      {
        _location = value;
        _location.ParentNode = this;
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

    public Action OnChange(Action<data> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing data");
      //Deserialize arguments

      //Deserialize children
      people = rawNode.InitializeWithRawNode("people", people);

      location = rawNode.InitializeWithRawNode("location", location);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
      }
      if(location != null) {
        rawNode.children["location"] = new List<RawNode> { location.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing data");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.people.TagName))
      {
        this.people ??= new XSD.Nworld_step.Ndata.people();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.people.TagName.Length + 3);
        this.people.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.location.TagName))
      {
        this.location ??= new XSD.Nworld_step.Ndata.location();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.location.TagName.Length + 3);
        this.location.SetXPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.people casted_people) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.location casted_location) {
        return 0;
      }
      return null;
    }
  }
}