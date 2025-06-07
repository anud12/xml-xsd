using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {
  public class classifications : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.location.location_graph.node.classifications";
    public static string TagName = "classifications";

    public string NodeName {get =>"classifications";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<classifications>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification> _classification = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification> classification
    {
      get => _classification;
      set
      {
        _classification = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _classification.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public classifications()
    {
    }

    public classifications(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public classifications(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<classifications> callback)
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
      // Godot.GD.Print("Deserializing classifications");
      //Deserialize arguments

      //Deserialize children
      classification = rawNode.InitializeWithRawNode("classification", classification);
      classification.OnAdd = (value) =>
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
      rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing classifications");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.classification.ContainsKey(pathIndex))
        {
          this.classification[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification();
        this.classification[pathIndex] = newEntry;
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
      _bubbleCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification casted_classification) {
        return this._classification.KeyOf(casted_classification);
      }
      return null;
    }
  }
}