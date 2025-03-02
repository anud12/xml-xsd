using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nby {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class by : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.by";
    public static string TagName = "by";

    public string NodeName {get =>"by";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<by>> _callbackList = new();

    //Attributes
    private System.String _person_ref;
    public System.String person_ref { get => _person_ref; set => _person_ref = value; }

    //Children elements
    private XSD.Nworld_step.Nactions.Nby._do __do = new XSD.Nworld_step.Nactions.Nby._do();
    public XSD.Nworld_step.Nactions.Nby._do _do
    {
      get
      {
        if(__do == null)
        {
          __do = new();
          __do.ParentNode = this;
          OnChange();
        }
        return __do;
      }
      set
      {
        __do = value;
        __do.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nactions.Nby.move_towards? _move_towards = null;
    public XSD.Nworld_step.Nactions.Nby.move_towards move_towards
    {
      get
      {
        if(_move_towards == null)
        {
          _move_towards = new();
          _move_towards.ParentNode = this;
          OnChange();
        }
        return _move_towards;
      }
      set
      {
        _move_towards = value;
        _move_towards.ParentNode = this;
      }
    }
    public by()
    {
    }

    public by(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public by(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<by> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing by");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_ref"))
      {
        var attribute_person_ref = rawNode.attributes["person_ref"];
        this.person_ref = rawNode.attributes["person_ref"];
      }

      //Deserialize children
      _do = rawNode.InitializeWithRawNode("do", _do);

      move_towards = rawNode.InitializeWithRawNode("move_towards", move_towards);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_ref != null)
      {
        rawNode.attributes["person_ref"] = this.person_ref.ToString();
      }

      //Serialize children
      if(_do != null) {
        rawNode.children["do"] = new List<RawNode> { _do.SerializeIntoRawNode() };
      }
      if(move_towards != null) {
        rawNode.children["move_towards"] = new List<RawNode> { move_towards.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing by");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_person_ref()
    {
      return this.person_ref;
    }
    public void Set_person_ref(System.String value)
    {
      this.person_ref = value;
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nby._do.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.Nby._do.TagName.Length + 3);
        this._do.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nby.move_towards.TagName))
      {
        this.move_towards ??= new XSD.Nworld_step.Nactions.Nby.move_towards();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.Nby.move_towards.TagName.Length + 3);
        this.move_towards.SetXPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nactions.Nby._do casted__do) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.Nby.move_towards casted_move_towards) {
        return 0;
      }
      return null;
    }
  }
}