using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class location_graph_rule : XSD.ILinkedNode  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule";
    public static string TagName = "location_graph_rule";

    public string NodeName {get =>"location_graph_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<location_graph_rule>> _callbackList = new();

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
          OnChange();
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
          OnChange();
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

    public Action OnChange(Action<location_graph_rule> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
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
      this.OnChange();
    }


    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("/"))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup.TagName.Length + 3);
        this.setup.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.node_rule.ContainsKey(pathIndex))
        {
          this.node_rule[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule();
        this.node_rule[pathIndex] = newEntry;
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