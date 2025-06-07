using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__teleport {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class person__teleport : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.person.teleport";
    public static string TagName = "person.teleport";

    public string NodeName {get =>"person.teleport";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<person__teleport>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String _person_id_ref;
    public System.String person_id_ref { get => _person_id_ref; set => _person_id_ref = value; }

    //Children elements
    private XSD.Nworld_step.Nactions.Nperson__teleport.location_graph? _location_graph = null;
    public XSD.Nworld_step.Nactions.Nperson__teleport.location_graph location_graph
    {
      get
      {
        if(_location_graph == null)
        {
          _location_graph = new();
          _location_graph.ParentNode = this;
          OnChange();
        }
        return _location_graph;
      }
      set
      {
        _location_graph = value;
        _location_graph.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nactions.Nperson__teleport.link_to? _link_to = null;
    public XSD.Nworld_step.Nactions.Nperson__teleport.link_to link_to
    {
      get
      {
        if(_link_to == null)
        {
          _link_to = new();
          _link_to.ParentNode = this;
          OnChange();
        }
        return _link_to;
      }
      set
      {
        _link_to = value;
        _link_to.ParentNode = this;
      }
    }
    public person__teleport()
    {
    }

    public person__teleport(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person__teleport(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<person__teleport> callback)
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
      // Godot.GD.Print("Deserializing person.teleport");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }

      //Deserialize children
      location_graph = rawNode.InitializeWithRawNode("location_graph", location_graph);

      link_to = rawNode.InitializeWithRawNode("link_to", link_to);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }

      //Serialize children
      if(location_graph != null) {
        rawNode.children["location_graph"] = new List<RawNode> { location_graph.SerializeIntoRawNode() };
      }
      if(link_to != null) {
        rawNode.children["link_to"] = new List<RawNode> { link_to.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person.teleport");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nperson__teleport.location_graph.TagName))
      {
        this.location_graph ??= new XSD.Nworld_step.Nactions.Nperson__teleport.location_graph();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.Nperson__teleport.location_graph.TagName.Length + 3);
        this.location_graph.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nperson__teleport.link_to.TagName))
      {
        this.link_to ??= new XSD.Nworld_step.Nactions.Nperson__teleport.link_to();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.Nperson__teleport.link_to.TagName.Length + 3);
        this.link_to.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nactions.Nperson__teleport.location_graph casted_location_graph) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.Nperson__teleport.link_to casted_link_to) {
        return 0;
      }
      return null;
    }
  }
}