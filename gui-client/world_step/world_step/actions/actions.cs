using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class actions  {

    public static string ClassTypeId = "/world_step/actions";
    public static string TagName = "actions";

    public string Tag = "actions";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nactions.by> _by = new Dictionary<int, XSD.Nworld_step.Nactions.by>();
    public List<XSD.Nworld_step.Nactions.by> by {
      get { return _by.Values.ToList(); }
      set
      {
        _by = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }

    private Dictionary<int, XSD.Nworld_step.Nactions.location_graph__create> _location_graph__create = new Dictionary<int, XSD.Nworld_step.Nactions.location_graph__create>();
    public List<XSD.Nworld_step.Nactions.location_graph__create> location_graph__create {
      get { return _location_graph__create.Values.ToList(); }
      set
      {
        _location_graph__create = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }

    private Dictionary<int, XSD.Nworld_step.Nactions.location_graph__node__create_adjacent> _location_graph__node__create_adjacent = new Dictionary<int, XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>();
    public List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent> location_graph__node__create_adjacent {
      get { return _location_graph__node__create_adjacent.Values.ToList(); }
      set
      {
        _location_graph__node__create_adjacent = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }

    private Dictionary<int, XSD.Nworld_step.Nactions.location_graph__node__add_classification> _location_graph__node__add_classification = new Dictionary<int, XSD.Nworld_step.Nactions.location_graph__node__add_classification>();
    public List<XSD.Nworld_step.Nactions.location_graph__node__add_classification> location_graph__node__add_classification {
      get { return _location_graph__node__add_classification.Values.ToList(); }
      set
      {
        _location_graph__node__add_classification = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    private XSD.Nworld_step.Nactions.person__teleport? _person__teleport = null;
    public XSD.Nworld_step.Nactions.person__teleport? person__teleport {
      get { return _person__teleport; }
      set { _person__teleport = value; }
    }

    private Dictionary<int, XSD.Nworld_step.Nactions.person__on_person__property_mutation> _person__on_person__property_mutation = new Dictionary<int, XSD.Nworld_step.Nactions.person__on_person__property_mutation>();
    public List<XSD.Nworld_step.Nactions.person__on_person__property_mutation> person__on_person__property_mutation {
      get { return _person__on_person__property_mutation.Values.ToList(); }
      set
      {
        _person__on_person__property_mutation = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }

    private Dictionary<int, XSD.Nworld_step.Nactions.person__create> _person__create = new Dictionary<int, XSD.Nworld_step.Nactions.person__create>();
    public List<XSD.Nworld_step.Nactions.person__create> person__create {
      get { return _person__create.Values.ToList(); }
      set
      {
        _person__create = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }

    private Dictionary<int, XSD.Nworld_step.Nactions.person__move_to> _person__move_to = new Dictionary<int, XSD.Nworld_step.Nactions.person__move_to>();
    public List<XSD.Nworld_step.Nactions.person__move_to> person__move_to {
      get { return _person__move_to.Values.ToList(); }
      set
      {
        _person__move_to = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }

    private Dictionary<int, XSD.Nworld_step.Nactions.from_person> _from_person = new Dictionary<int, XSD.Nworld_step.Nactions.from_person>();
    public List<XSD.Nworld_step.Nactions.from_person> from_person {
      get { return _from_person.Values.ToList(); }
      set
      {
        _from_person = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public actions()
    {
    }

    public actions(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public actions(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing actions");
      //Deserialize arguments

      //Deserialize children
      this._by = rawNode.InitializeWithRawNode("by", this._by);
      this._location_graph__create = rawNode.InitializeWithRawNode("location_graph.create", this._location_graph__create);
      this._location_graph__node__create_adjacent = rawNode.InitializeWithRawNode("location_graph.node.create_adjacent", this._location_graph__node__create_adjacent);
      this._location_graph__node__add_classification = rawNode.InitializeWithRawNode("location_graph.node.add_classification", this._location_graph__node__add_classification);
      this._person__teleport = rawNode.InitializeWithRawNode("person.teleport", this._person__teleport);
      this._person__on_person__property_mutation = rawNode.InitializeWithRawNode("person.on_person.property_mutation", this._person__on_person__property_mutation);
      this._person__create = rawNode.InitializeWithRawNode("person.create", this._person__create);
      this._person__move_to = rawNode.InitializeWithRawNode("person.move_to", this._person__move_to);
      this._from_person = rawNode.InitializeWithRawNode("from_person", this._from_person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["by"] = _by?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      rawNode.children["location_graph.create"] = _location_graph__create?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      rawNode.children["location_graph.node.create_adjacent"] = _location_graph__node__create_adjacent?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      rawNode.children["location_graph.node.add_classification"] = _location_graph__node__add_classification?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      if(person__teleport != null) {
        rawNode.children["person.teleport"] = new List<RawNode> { person__teleport.SerializeIntoRawNode() };
      }
      rawNode.children["person.on_person.property_mutation"] = _person__on_person__property_mutation?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      rawNode.children["person.create"] = _person__create?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      rawNode.children["person.move_to"] = _person__move_to?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      rawNode.children["from_person"] = _from_person?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing actions");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nactions.by>? Get_by()
    {
      return this.by;
    }
    public void Set_by(List<XSD.Nworld_step.Nactions.by>? value)
    {
      this.by = value;
    }
    public List<XSD.Nworld_step.Nactions.location_graph__create>? Get_location_graph__create()
    {
      return this._location_graph__create?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nactions.location_graph__create> GetOrInsertDefault_location_graph__create()
    {
      if(this._location_graph__create == null) {

        // false2
        this._location_graph__create = new Dictionary<int, XSD.Nworld_step.Nactions.location_graph__create>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_location_graph__create();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_location_graph__create(List<XSD.Nworld_step.Nactions.location_graph__create>? value)
    {
      this._location_graph__create = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>? Get_location_graph__node__create_adjacent()
    {
      return this._location_graph__node__create_adjacent?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent> GetOrInsertDefault_location_graph__node__create_adjacent()
    {
      if(this._location_graph__node__create_adjacent == null) {

        // false2
        this._location_graph__node__create_adjacent = new Dictionary<int, XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_location_graph__node__create_adjacent();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_location_graph__node__create_adjacent(List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>? value)
    {
      this._location_graph__node__create_adjacent = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public List<XSD.Nworld_step.Nactions.location_graph__node__add_classification>? Get_location_graph__node__add_classification()
    {
      return this._location_graph__node__add_classification?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nactions.location_graph__node__add_classification> GetOrInsertDefault_location_graph__node__add_classification()
    {
      if(this._location_graph__node__add_classification == null) {

        // false2
        this._location_graph__node__add_classification = new Dictionary<int, XSD.Nworld_step.Nactions.location_graph__node__add_classification>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_location_graph__node__add_classification();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_location_graph__node__add_classification(List<XSD.Nworld_step.Nactions.location_graph__node__add_classification>? value)
    {
      this._location_graph__node__add_classification = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public XSD.Nworld_step.Nactions.person__teleport? Get_person__teleport()
    {
      return this.person__teleport;
    }
    public void Set_person__teleport(XSD.Nworld_step.Nactions.person__teleport? value)
    {
      this.person__teleport = value;
    }
    public List<XSD.Nworld_step.Nactions.person__on_person__property_mutation>? Get_person__on_person__property_mutation()
    {
      return this._person__on_person__property_mutation?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nactions.person__on_person__property_mutation> GetOrInsertDefault_person__on_person__property_mutation()
    {
      if(this._person__on_person__property_mutation == null) {

        // false2
        this._person__on_person__property_mutation = new Dictionary<int, XSD.Nworld_step.Nactions.person__on_person__property_mutation>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_person__on_person__property_mutation();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_person__on_person__property_mutation(List<XSD.Nworld_step.Nactions.person__on_person__property_mutation>? value)
    {
      this._person__on_person__property_mutation = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public List<XSD.Nworld_step.Nactions.person__create>? Get_person__create()
    {
      return this._person__create?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nactions.person__create> GetOrInsertDefault_person__create()
    {
      if(this._person__create == null) {

        // false2
        this._person__create = new Dictionary<int, XSD.Nworld_step.Nactions.person__create>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_person__create();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_person__create(List<XSD.Nworld_step.Nactions.person__create>? value)
    {
      this._person__create = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public List<XSD.Nworld_step.Nactions.person__move_to>? Get_person__move_to()
    {
      return this._person__move_to?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nactions.person__move_to> GetOrInsertDefault_person__move_to()
    {
      if(this._person__move_to == null) {

        // false2
        this._person__move_to = new Dictionary<int, XSD.Nworld_step.Nactions.person__move_to>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_person__move_to();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_person__move_to(List<XSD.Nworld_step.Nactions.person__move_to>? value)
    {
      this._person__move_to = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public List<XSD.Nworld_step.Nactions.from_person>? Get_from_person()
    {
      return this._from_person?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nactions.from_person> GetOrInsertDefault_from_person()
    {
      if(this._from_person == null) {

        // false2
        this._from_person = new Dictionary<int, XSD.Nworld_step.Nactions.from_person>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_from_person();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_from_person(List<XSD.Nworld_step.Nactions.from_person>? value)
    {
      this._from_person = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.by.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.by.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._by.ContainsKey(indexString.ToInt()))
        {
          this._by[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nactions.by();
        newEntry.SetXPath(xpath, rawNode);
        this._by.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.location_graph__create.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.location_graph__create.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._location_graph__create.ContainsKey(indexString.ToInt()))
        {
          this._location_graph__create[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nactions.location_graph__create();
        newEntry.SetXPath(xpath, rawNode);
        this._location_graph__create.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.location_graph__node__create_adjacent.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.location_graph__node__create_adjacent.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._location_graph__node__create_adjacent.ContainsKey(indexString.ToInt()))
        {
          this._location_graph__node__create_adjacent[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nactions.location_graph__node__create_adjacent();
        newEntry.SetXPath(xpath, rawNode);
        this._location_graph__node__create_adjacent.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.location_graph__node__add_classification.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.location_graph__node__add_classification.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._location_graph__node__add_classification.ContainsKey(indexString.ToInt()))
        {
          this._location_graph__node__add_classification[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nactions.location_graph__node__add_classification();
        newEntry.SetXPath(xpath, rawNode);
        this._location_graph__node__add_classification.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.person__teleport.TagName))
      {
        this.person__teleport ??= new XSD.Nworld_step.Nactions.person__teleport();
        xpath = xpath.Substring(XSD.Nworld_step.Nactions.person__teleport.TagName.Length + 3);
        this.person__teleport.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.person__on_person__property_mutation.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.person__on_person__property_mutation.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._person__on_person__property_mutation.ContainsKey(indexString.ToInt()))
        {
          this._person__on_person__property_mutation[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nactions.person__on_person__property_mutation();
        newEntry.SetXPath(xpath, rawNode);
        this._person__on_person__property_mutation.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.person__create.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.person__create.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._person__create.ContainsKey(indexString.ToInt()))
        {
          this._person__create[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nactions.person__create();
        newEntry.SetXPath(xpath, rawNode);
        this._person__create.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.person__move_to.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.person__move_to.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._person__move_to.ContainsKey(indexString.ToInt()))
        {
          this._person__move_to[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nactions.person__move_to();
        newEntry.SetXPath(xpath, rawNode);
        this._person__move_to.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.from_person.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nactions.from_person.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._from_person.ContainsKey(indexString.ToInt()))
        {
          this._from_person[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nactions.from_person();
        newEntry.SetXPath(xpath, rawNode);
        this._from_person.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}