using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata {
  public class location  {

    public static string ClassTypeId = "/world_step/data/location";
    public static string TagName = "location";

    public string Tag = "location";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.location_graph> _location_graph = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.location_graph>();
    public List<XSD.Nworld_step.Ndata.Nlocation.location_graph> location_graph {
      get { return _location_graph.Values.ToList(); }
      set
      {
        _location_graph = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public location()
    {
    }

    public location(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location");
      //Deserialize arguments

      //Deserialize children
      this._location_graph = rawNode.InitializeWithRawNode("location_graph", this._location_graph);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["location_graph"] = _location_graph?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.location_graph>? Get_location_graph()
    {
      return this._location_graph?.Values.ToList();
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.location_graph> GetOrInsertDefault_location_graph()
    {
      if(this._location_graph == null) {

        // false2
        this._location_graph = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.location_graph>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_location_graph();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_location_graph(List<XSD.Nworld_step.Ndata.Nlocation.location_graph>? value)
    {
      this._location_graph = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.location_graph.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nlocation.location_graph.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._location_graph.ContainsKey(indexString.ToInt()))
        {
          this._location_graph[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nlocation.location_graph();
        newEntry.SetXPath(xpath, rawNode);
        this._location_graph.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}