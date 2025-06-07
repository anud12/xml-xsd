using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation {
  public class location_graph : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.location.location_graph";
    public static string TagName = "location_graph";

    public string NodeName {get =>"location_graph";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<location_graph>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule _rule = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule();
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule rule
    {
      get
      {
        if(_rule == null)
        {
          _rule = new();
          _rule.ParentNode = this;
          OnChange();
        }
        return _rule;
      }
      set
      {
        _rule = value;
        _rule.ParentNode = this;
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> _node = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> node
    {
      get => _node;
      set
      {
        _node = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _node.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public location_graph()
    {
    }

    public location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<location_graph> callback)
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
      // Godot.GD.Print("Deserializing location_graph");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      rule = rawNode.InitializeWithRawNode("rule", rule);

      node = rawNode.InitializeWithRawNode("node", node);
      node.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(rule != null) {
        rawNode.children["rule"] = new List<RawNode> { rule.SerializeIntoRawNode() };
      }
      rawNode.children["node"] = node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph");
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


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule.TagName.Length + 3);
        this.rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.node.ContainsKey(pathIndex))
        {
          this.node[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node();
        this.node[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule casted_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node casted_node) {
        return this._node.KeyOf(casted_node);
      }
      return null;
    }
  }
}