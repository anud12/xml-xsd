using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class location_graph_rule : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.location_graph_rule";
    public static string TagName = "location_graph_rule";

    public string NodeName {get =>"location_graph_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<location_graph_rule>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup _setup = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup();
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup setup
    {
      get
      {
        if(_setup == null)
        {
          _setup = new();
          _setup.ParentNode = this;
          NotifyChange();
        }
        return _setup;
      }
      set
      {
        _setup = value;
        _setup.ParentNode = this;
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule> _node_rule = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule> node_rule
    {
      get => _node_rule;
      set
      {
        _node_rule = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _node_rule.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public location_graph_rule()
    {
    }

    public location_graph_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph_rule(XmlElement xmlElement)
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
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup setup)
      {
        this.setup = setup;
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule> node_rule)
      {
        this.node_rule = node_rule;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup)
      {
        this.setup = new();
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>)
      {
        this.node_rule = null;
      }
    }


    public Action OnSelfChange(Action<location_graph_rule> callback)
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
      // Godot.GD.Print("Deserializing location_graph_rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      setup = rawNode.InitializeWithRawNode("setup", setup);

      node_rule = rawNode.InitializeWithRawNode("node_rule", node_rule);
      node_rule.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(setup != null) {
        rawNode.children["setup"] = new List<RawNode> { setup.SerializeIntoRawNode() };
      }
      rawNode.children["node_rule"] = node_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph_rule");
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


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup.TagName.Length + 3);
        this.setup.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.node_rule.ContainsKey(pathIndex))
        {
          this.node_rule[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule();
        this.node_rule[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup casted_setup) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule casted_node_rule) {
        return this._node_rule.KeyOf(casted_node_rule);
      }
      return null;
    }
  }
}