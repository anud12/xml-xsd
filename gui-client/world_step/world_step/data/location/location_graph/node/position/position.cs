using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nposition {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {
  public class position : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.location.location_graph.node.position";
    public static string TagName = "position";

    public string NodeName {get =>"position";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<position>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.Int32 _x;
    public System.Int32 x { get => _x; set => _x = value; }
    private System.Int32 _y;
    public System.Int32 y { get => _y; set => _y = value; }

    //Children elements
    public position()
    {
    }

    public position(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public position(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<position> callback)
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
      // Godot.GD.Print("Deserializing position");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("x"))
      {
        var attribute_x = rawNode.attributes["x"];
        this.x = attribute_x.ToInt();
      }
      if(rawNode.attributes.ContainsKey("y"))
      {
        var attribute_y = rawNode.attributes["y"];
        this.y = attribute_y.ToInt();
      }

      //Deserialize children
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.x != null)
      {
        rawNode.attributes["x"] = this.x.ToString();
      }
      if(this.y != null)
      {
        rawNode.attributes["y"] = this.y.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing position");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
      this.OnChange();
    }
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
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
      return null;
    }
  }
}