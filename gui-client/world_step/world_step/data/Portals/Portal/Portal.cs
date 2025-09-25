using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.NNodes.NNode.NPortals {
  public class Portal : IEquatable<Portal>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.Nodes.Node.Portals.Portal";
    public static string TagName = "Portal";

    public string NodeName {get =>"Portal";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<Portal>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String? _maxWidth;
    public System.String? maxWidth { get => _maxWidth; set => _maxWidth = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From _From = new XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From();
    public XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From FromOrCreate
    {
      get
      {
        if(_From == null)
        {
          _From = new();
          _From.ParentNode = this;
          NotifyChange();
        }
        return _From;
      }
      set
      {
        _From = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From From
    {
      get
      {
        return _From;
      }
      set
      {
        _From = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To _To = new XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To();
    public XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To ToOrCreate
    {
      get
      {
        if(_To == null)
        {
          _To = new();
          _To.ParentNode = this;
          NotifyChange();
        }
        return _To;
      }
      set
      {
        _To = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To To
    {
      get
      {
        return _To;
      }
      set
      {
        _To = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public Portal()
    {
    }

    public Portal(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public Portal(XmlElement xmlElement)
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
      if(name == "maxWidth")
      {
        Set_maxWidth(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From From)
      {
        this.From = From;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To To)
      {
        this.To = To;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From)
      {
        this.From = new();
      }

      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To)
      {
        this.To = new();
      }

    }

    public Action OnSelfChange(Action<Portal> callback)
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
      // Godot.GD.Print("Deserializing Portal");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("maxWidth"))
      {
        var attribute_maxWidth = rawNode.attributes["maxWidth"];
        this.maxWidth = rawNode.attributes["maxWidth"];
      }

      //Deserialize children
      From = rawNode.InitializeWithRawNode("From", From);

      To = rawNode.InitializeWithRawNode("To", To);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }
      if(this._maxWidth != null)
      {
        rawNode.attributes["maxWidth"] = this._maxWidth?.ToString();
      }

      //Serialize children
      if(From != null) {
        rawNode.children["From"] = new List<RawNode> { From.SerializeIntoRawNode() };
      }
      if(To != null) {
        rawNode.children["To"] = new List<RawNode> { To.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing Portal");
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
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From.TagName.Length + 3);
        this.From.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To.TagName.Length + 3);
        this.To.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From casted_From) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To casted_To) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.From
      || candidateChild is XSD.Nworld_step.Ndata.NNodes.NNode.NPortals.NPortal.To
      || false;
    }

    public bool Equals(Portal? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (Portal)obj;
        return Equals(id, other.id) && Equals(maxWidth, other.maxWidth) && Equals(From, other.From) && Equals(To, other.To);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, maxWidth);
        acc = HashCode.Combine(acc, From);
        acc = HashCode.Combine(acc, To);
        return acc;
    }
  }
}