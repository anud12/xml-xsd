using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal.Nto {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nnodes.Nnode.Nportals.Nportal {
  public class to : IEquatable<to>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.nodes.node.portals.portal.to";
    public static string TagName = "to";

    public string NodeName {get =>"to";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<to>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _node_ref;
    public System.String node_ref { get => _node_ref; set => _node_ref = value; }
    private System.String? _side;
    public System.String? side { get => _side; set => _side = value; }
    private System.Int32 _position;
    public System.Int32 position { get => _position; set => _position = value; }
    private System.String? _maxWidth;
    public System.String? maxWidth { get => _maxWidth; set => _maxWidth = value; }

    //Children elements
    public to()
    {
    }

    public to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "node_ref")
      {
        Set_node_ref(value);
      }
      if(name == "side")
      {
        Set_side(value);
      }
      if(name == "position")
      {
        Set_position(value?.ToInt() ?? 0);
      }
      if(name == "maxWidth")
      {
        Set_maxWidth(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<to> callback)
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
      // Godot.GD.Print("Deserializing to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_ref"))
      {
        var attribute_node_ref = rawNode.attributes["node_ref"];
        this.node_ref = rawNode.attributes["node_ref"];
      }
      if(rawNode.attributes.ContainsKey("side"))
      {
        var attribute_side = rawNode.attributes["side"];
        this.side = rawNode.attributes["side"];
      }
      if(rawNode.attributes.ContainsKey("position"))
      {
        var attribute_position = rawNode.attributes["position"];
        this.position = rawNode.attributes["position"];
      }
      if(rawNode.attributes.ContainsKey("maxWidth"))
      {
        var attribute_maxWidth = rawNode.attributes["maxWidth"];
        this.maxWidth = rawNode.attributes["maxWidth"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._node_ref != null)
      {
        rawNode.attributes["node_ref"] = this._node_ref.ToString();
      }
      if(this._side != null)
      {
        rawNode.attributes["side"] = this._side?.ToString();
      }
      if(this._position != null)
      {
        rawNode.attributes["position"] = this._position.ToString();
      }
      if(this._maxWidth != null)
      {
        rawNode.attributes["maxWidth"] = this._maxWidth?.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_ref()
    {
      return this.node_ref;
    }
    public void Set_node_ref(System.String value)
    {
      this.node_ref = value;
      this.NotifyChange();
    }
    public System.String? Get_side()
    {
      return this.side;
    }
    public void Set_side(System.String? value)
    {
      this.side = value;
      this.NotifyChange();
    }
    public System.Int32 Get_position()
    {
      return this.position;
    }
    public void Set_position(System.Int32 value)
    {
      this.position = value;
      this.NotifyChange();
    }
    public System.String? Get_maxWidth()
    {
      return this.maxWidth;
    }
    public void Set_maxWidth(System.String? value)
    {
      this.maxWidth = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
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
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return false;
    }

    public bool Equals(to? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (to)obj;
        return Equals(node_ref, other.node_ref) && Equals(side, other.side) && Equals(position, other.position) && Equals(maxWidth, other.maxWidth);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, node_ref);
        acc = HashCode.Combine(acc, side);
        acc = HashCode.Combine(acc, position);
        acc = HashCode.Combine(acc, maxWidth);
        return acc;
    }
  }
}