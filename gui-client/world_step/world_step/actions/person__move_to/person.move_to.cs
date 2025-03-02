using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__move_to {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class person__move_to : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.person.move_to";
    public static string TagName = "person.move_to";

    public string NodeName {get =>"person.move_to";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<person__move_to>> _callbackList = new();

    //Attributes
    private System.String _person_id_ref;
    public System.String person_id_ref { get => _person_id_ref; set => _person_id_ref = value; }

    //Children elements
    private type__node_graph__selection? _find_path_towards = null;
    public type__node_graph__selection find_path_towards
    {
      get
      {
        if(_find_path_towards == null)
        {
          _find_path_towards = new();
          _find_path_towards.ParentNode = this;
          OnChange();
        }
        return _find_path_towards;
      }
      set
      {
        _find_path_towards = value;
        _find_path_towards.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nactions.Nperson__move_to.path? _path = null;
    public XSD.Nworld_step.Nactions.Nperson__move_to.path path
    {
      get
      {
        if(_path == null)
        {
          _path = new();
          _path.ParentNode = this;
          OnChange();
        }
        return _path;
      }
      set
      {
        _path = value;
        _path.ParentNode = this;
      }
    }
    public person__move_to()
    {
    }

    public person__move_to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person__move_to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<person__move_to> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person.move_to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }

      //Deserialize children
      find_path_towards = rawNode.InitializeWithRawNode("find_path_towards", find_path_towards);

      path = rawNode.InitializeWithRawNode("path", path);
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
      if(find_path_towards != null) {
        rawNode.children["find_path_towards"] = new List<RawNode> { find_path_towards.SerializeIntoRawNode() };
      }
      if(path != null) {
        rawNode.children["path"] = new List<RawNode> { path.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person.move_to");
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
      if(xpath.StartsWith(type__node_graph__selection.TagName))
      {
        this.find_path_towards ??= new type__node_graph__selection();
        var childXPath = xpath.Substring(type__node_graph__selection.TagName.Length + 3);
        this.find_path_towards.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nperson__move_to.path.TagName))
      {
        this.path ??= new XSD.Nworld_step.Nactions.Nperson__move_to.path();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.Nperson__move_to.path.TagName.Length + 3);
        this.path.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__node_graph__selection casted_find_path_towards) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.Nperson__move_to.path casted_path) {
        return 0;
      }
      return null;
    }
  }
}