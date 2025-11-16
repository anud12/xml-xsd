using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nportals.Nportal {}
namespace XSD {
}
namespace XSD.Nportals {
  public class portal : IEquatable<portal>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".portals.portal";
    public static string TagName = "portal";

    public string NodeName {get =>"portal";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<portal>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _side;
    public System.String side { get => _side; set => _side = value; }
    private System.String _portal_rule_ref;
    public System.String portal_rule_ref { get => _portal_rule_ref; set => _portal_rule_ref = value; }

    //Children elements
    private type__math_operations _start = new type__math_operations();
    public type__math_operations startOrCreate
    {
      get
      {
        if(_start == null)
        {
          _start = new();
          _start.ParentNode = this;
          NotifyChange();
        }
        return _start;
      }
      set
      {
        _start = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations start
    {
      get
      {
        return _start;
      }
      set
      {
        _start = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public portal()
    {
    }

    public portal(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public portal(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "side")
      {
        Set_side(value);
      }
      if(name == "portal_rule_ref")
      {
        Set_portal_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations start)
      {
        this.start = start;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations)
      {
        this.start = new();
      }

    }

    public Action OnSelfChange(Action<portal> callback)
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
      // Godot.GD.Print("Deserializing portal");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("side"))
      {
        var attribute_side = rawNode.attributes["side"];
        this.side = rawNode.attributes["side"];
      }
      if(rawNode.attributes.ContainsKey("portal_rule_ref"))
      {
        var attribute_portal_rule_ref = rawNode.attributes["portal_rule_ref"];
        this.portal_rule_ref = rawNode.attributes["portal_rule_ref"];
      }

      //Deserialize children
      start = rawNode.InitializeWithRawNode("start", start);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._side != null)
      {
        rawNode.attributes["side"] = this._side.ToString();
      }
      if(this._portal_rule_ref != null)
      {
        rawNode.attributes["portal_rule_ref"] = this._portal_rule_ref.ToString();
      }

      //Serialize children
      if(start != null) {
        rawNode.children["start"] = new List<RawNode> { start.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing portal");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_side()
    {
      return this.side;
    }
    public void Set_side(System.String value)
    {
      this.side = value;
      this.NotifyChange();
    }
    public System.String Get_portal_rule_ref()
    {
      return this.portal_rule_ref;
    }
    public void Set_portal_rule_ref(System.String value)
    {
      this.portal_rule_ref = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.start.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__math_operations casted_start) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is type__math_operations
      || false;
    }

    public bool Equals(portal? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (portal)obj;
        return Equals(side, other.side) && Equals(portal_rule_ref, other.portal_rule_ref) && Equals(start, other.start);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, side);
        acc = HashCode.Combine(acc, portal_rule_ref);
        acc = HashCode.Combine(acc, start);
        return acc;
    }
  }
}