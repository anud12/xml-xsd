using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {
  public class links  {

    public static string ClassTypeId = "/world_step/data/location/location_graph/node/links";
    public static string TagName = "links";

    public string Tag = "links";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to> _link_to = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to>();
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to> link_to {
      get { return _link_to.Values.ToList(); }
      set
      {
        _link_to = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public links()
    {
    }

    public links(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public links(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing links");
      //Deserialize arguments

      //Deserialize children
      this._link_to = rawNode.InitializeWithRawNode("link_to", this._link_to);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["link_to"] = _link_to?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing links");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to>? Get_link_to()
    {
      return this._link_to?.Values.ToList();
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to> GetOrInsertDefault_link_to()
    {
      if(this._link_to == null) {

        // false2
        this._link_to = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_link_to();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_link_to(List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to>? value)
    {
      this._link_to = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._link_to.ContainsKey(indexString.ToInt()))
        {
          this._link_to[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to();
        newEntry.SetXPath(xpath, rawNode);
        this._link_to.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}