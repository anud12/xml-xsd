using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks {
  public class link_to : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.location.location_graph.node.links.link_to";
    public static string TagName = "link_to";

    public string NodeName {get =>"link_to";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<link_to>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String _node_id_ref;
    public System.String node_id_ref { get => _node_id_ref; set => _node_id_ref = value; }
    private System.Int32 _total_progress;
    public System.Int32 total_progress { get => _total_progress; set => _total_progress = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people? _people = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people people
    {
      get
      {
        if(_people == null)
        {
          _people = new();
          _people.ParentNode = this;
          OnChange();
        }
        return _people;
      }
      set
      {
        _people = value;
        _people.ParentNode = this;
      }
    }

    private type__math_operations? _person_progress_property = null;
    public type__math_operations person_progress_property
    {
      get
      {
        if(_person_progress_property == null)
        {
          _person_progress_property = new();
          _person_progress_property.ParentNode = this;
          OnChange();
        }
        return _person_progress_property;
      }
      set
      {
        _person_progress_property = value;
        _person_progress_property.ParentNode = this;
      }
    }
    public link_to()
    {
    }

    public link_to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<link_to> callback)
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
      // Godot.GD.Print("Deserializing link_to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_id_ref"))
      {
        var attribute_node_id_ref = rawNode.attributes["node_id_ref"];
        this.node_id_ref = rawNode.attributes["node_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("total_progress"))
      {
        var attribute_total_progress = rawNode.attributes["total_progress"];
        this.total_progress = attribute_total_progress.ToInt();
      }

      //Deserialize children
      people = rawNode.InitializeWithRawNode("people", people);

      person_progress_property = rawNode.InitializeWithRawNode("person_progress_property", person_progress_property);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_id_ref != null)
      {
        rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
      }
      if(this.total_progress != null)
      {
        rawNode.attributes["total_progress"] = this.total_progress.ToString();
      }

      //Serialize children
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
      }
      if(person_progress_property != null) {
        rawNode.children["person_progress_property"] = new List<RawNode> { person_progress_property.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
      this.OnChange();
    }
    public System.Int32 Get_total_progress()
    {
      return this.total_progress;
    }
    public void Set_total_progress(System.Int32 value)
    {
      this.total_progress = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people.TagName))
      {
        this.people ??= new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people.TagName.Length + 3);
        this.people.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.person_progress_property ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.person_progress_property.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people casted_people) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_person_progress_property) {
        return 0;
      }
      return null;
    }
  }
}