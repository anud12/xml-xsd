using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata {
  public class location : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.location";
    public static string TagName = "location";

    public string NodeName {get =>"location";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<location>> _callbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Nlocation.location_graph> _location_graph = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Nlocation.location_graph> location_graph
    {
      get => _location_graph;
      set
      {
        _location_graph = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _location_graph.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public location()
    {
    }

    public location(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<location> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location");
      //Deserialize arguments

      //Deserialize children
      location_graph = rawNode.InitializeWithRawNode("location_graph", location_graph);
      location_graph.OnAdd = (value) =>
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
      rawNode.children["location_graph"] = location_graph.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.location_graph.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nlocation.location_graph.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.location_graph.ContainsKey(pathIndex))
        {
          this.location_graph[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nlocation.location_graph();
        this.location_graph[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.location_graph casted_location_graph) {
        return this._location_graph.KeyOf(casted_location_graph);
      }
      return null;
    }
  }
}