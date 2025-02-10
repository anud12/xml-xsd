using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__move_to.Npath {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nperson__move_to {
  public class path  {

    public static string ClassTypeId = "/world_step/actions/person.move_to/path";
    public static string TagName = "path";

    public string Tag = "path";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node> _node = new Dictionary<int, XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>();
    public List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node> node {
      get { return _node.Values.ToList(); }
      set
      {
        _node = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public path()
    {
    }

    public path(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public path(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing path");
      //Deserialize arguments

      //Deserialize children
      this._node = rawNode.InitializeWithRawNode("node", this._node);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["node"] = _node?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing path");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>? Get_node()
    {
      return this._node?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node> GetOrInsertDefault_node()
    {
      if(this._node == null) {

        // false2
        this._node = new Dictionary<int, XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_node();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_node(List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>? value)
    {
      this._node = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._node.ContainsKey(indexString.ToInt()))
        {
          this._node[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node();
        newEntry.SetXPath(xpath, rawNode);
        this._node.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}