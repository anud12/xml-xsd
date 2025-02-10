using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection.Nhas__node_graph_id {}
namespace XSD {
}
namespace XSD.Ntype__node_graph__selection {
  public class has__node_graph_id  {

    public static string ClassTypeId = "/type__node_graph__selection/has__node_graph_id";
    public static string TagName = "has__node_graph_id";

    public string Tag = "has__node_graph_id";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_graph_id_ref;
    public System.String _node_graph_id_ref;

    //Children elements

    private Dictionary<int, XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or> _or = new Dictionary<int, XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or>();
    public List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or> or {
      get { return _or.Values.ToList(); }
      set
      {
        _or = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
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
      this._or = rawNode.InitializeWithRawNode("or", this._or);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_graph_id_ref != null)
      {
        rawNode.attributes["node_graph_id_ref"] = this.node_graph_id_ref.ToString();
      }

      //Serialize children
      rawNode.children["or"] = _or?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
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
    }
    public List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or>? Get_or()
    {
      return this._or?.Values.ToList();
    }
    public List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or> GetOrInsertDefault_or()
    {
      if(this._or == null) {

        // false2
        this._or = new Dictionary<int, XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_or();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_or(List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or>? value)
    {
      this._or = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or.TagName + "["))
      {
        var startIndex = (XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._or.ContainsKey(indexString.ToInt()))
        {
          this._or[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or();
        newEntry.SetXPath(xpath, rawNode);
        this._or.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}