using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {
  public class classifications  {

    public static string ClassTypeId = "/world_step/data/location/location_graph/node/classifications";
    public static string TagName = "classifications";

    public string Tag = "classifications";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification> _classification = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification>();
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification> classification {
      get { return _classification.Values.ToList(); }
      set
      {
        _classification = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public classifications()
    {
    }

    public classifications(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public classifications(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing classifications");
      //Deserialize arguments

      //Deserialize children
      this._classification = rawNode.InitializeWithRawNode("classification", this._classification);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["classification"] = _classification?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing classifications");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification>? Get_classification()
    {
      return this._classification?.Values.ToList();
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification> GetOrInsertDefault_classification()
    {
      if(this._classification == null) {

        // false2
        this._classification = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_classification();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_classification(List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification>? value)
    {
      this._classification = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._classification.ContainsKey(indexString.ToInt()))
        {
          this._classification[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification();
        newEntry.SetXPath(xpath, rawNode);
        this._classification.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}