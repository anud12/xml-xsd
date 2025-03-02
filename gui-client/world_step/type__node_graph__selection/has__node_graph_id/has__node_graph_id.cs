using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection.Nhas__node_graph_id {}
namespace XSD {
}
namespace XSD.Ntype__node_graph__selection {
  public class has__node_graph_id : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__node_graph__selection.has__node_graph_id";
    public static string TagName = "has__node_graph_id";

    public string NodeName {get =>"has__node_graph_id";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<has__node_graph_id>> _callbackList = new();

    //Attributes
    private System.String _node_graph_id_ref;
    public System.String node_graph_id_ref { get => _node_graph_id_ref; set => _node_graph_id_ref = value; }

    //Children elements

    private LinkedNodeCollection<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or> _or = new();
    public LinkedNodeCollection<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or> or
    {
      get => _or;
      set
      {
        _or = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _or.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public has__node_graph_id()
    {
    }

    public has__node_graph_id(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public has__node_graph_id(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<has__node_graph_id> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing has__node_graph_id");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_graph_id_ref"))
      {
        var attribute_node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
        this.node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
      }

      //Deserialize children
      or = rawNode.InitializeWithRawNode("or", or);
      or.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_graph_id_ref != null)
      {
        rawNode.attributes["node_graph_id_ref"] = this.node_graph_id_ref.ToString();
      }

      //Serialize children
      rawNode.children["or"] = or.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing has__node_graph_id");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_graph_id_ref()
    {
      return this.node_graph_id_ref;
    }
    public void Set_node_graph_id_ref(System.String value)
    {
      this.node_graph_id_ref = value;
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or.TagName + "["))
      {
        var startIndex = (XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.or.ContainsKey(pathIndex))
        {
          this.or[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or();
        this.or[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or casted_or) {
        return this._or.KeyOf(casted_or);
      }
      return null;
    }
  }
}