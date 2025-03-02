using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {
  public class people : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.location.location_graph.node.people";
    public static string TagName = "people";

    public string NodeName {get =>"people";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<people>> _callbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person> _person = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person> person
    {
      get => _person;
      set
      {
        _person = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _person.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public people()
    {
    }

    public people(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public people(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<people> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing people");
      //Deserialize arguments

      //Deserialize children
      person = rawNode.InitializeWithRawNode("person", person);
      person.OnAdd = (value) =>
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
      rawNode.children["person"] = person.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing people");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.person.ContainsKey(pathIndex))
        {
          this.person[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person();
        this.person[pathIndex] = newEntry;
        newEntry.SetXPath(childXPath, rawNode);

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
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person casted_person) {
        return this._person.KeyOf(casted_person);
      }
      return null;
    }
  }
}