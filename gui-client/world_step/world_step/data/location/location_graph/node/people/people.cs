using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {
  public class people  {

    public static string ClassTypeId = "/world_step/data/location/location_graph/node/people";
    public static string TagName = "people";

    public string Tag = "people";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person> _person = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person>();
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person> person {
      get { return _person.Values.ToList(); }
      set
      {
        _person = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public people()
    {
    }

    public people(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public people(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing people");
      //Deserialize arguments

      //Deserialize children
      this._person = rawNode.InitializeWithRawNode("person", this._person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["person"] = _person?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing people");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person>? Get_person()
    {
      return this._person?.Values.ToList();
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person> GetOrInsertDefault_person()
    {
      if(this._person == null) {

        // false2
        this._person = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_person();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_person(List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person>? value)
    {
      this._person = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._person.ContainsKey(indexString.ToInt()))
        {
          this._person[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person();
        newEntry.SetXPath(xpath, rawNode);
        this._person.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}