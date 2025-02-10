using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step {}
namespace XSD {
}
namespace XSD {
  public class world_step  {

    public static string ClassTypeId = "/world_step";
    public static string TagName = "world_step";

    public string Tag = "world_step";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Nworld_step.world_metadata? _world_metadata = null;
    public XSD.Nworld_step.world_metadata? world_metadata {
      get { return _world_metadata; }
      set { _world_metadata = value; }
    }

    private Dictionary<int, XSD.Nworld_step.rule_group> _rule_group = new Dictionary<int, XSD.Nworld_step.rule_group>();
    public List<XSD.Nworld_step.rule_group> rule_group {
      get { return _rule_group.Values.ToList(); }
      set
      {
        _rule_group = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    private XSD.Nworld_step.data? _data = null;
    public XSD.Nworld_step.data? data {
      get { return _data; }
      set { _data = value; }
    }

    private XSD.Nworld_step.actions? _actions = null;
    public XSD.Nworld_step.actions? actions {
      get { return _actions; }
      set { _actions = value; }
    }
    public world_step()
    {
    }

    public world_step(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing world_step");
      //Deserialize arguments

      //Deserialize children
      this._world_metadata = rawNode.InitializeWithRawNode("world_metadata", this._world_metadata);
      this._rule_group = rawNode.InitializeWithRawNode("rule_group", this._rule_group);
      this._data = rawNode.InitializeWithRawNode("data", this._data);
      this._actions = rawNode.InitializeWithRawNode("actions", this._actions);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(world_metadata != null) {
        rawNode.children["world_metadata"] = new List<RawNode> { world_metadata.SerializeIntoRawNode() };
      }
      rawNode.children["rule_group"] = _rule_group?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      if(data != null) {
        rawNode.children["data"] = new List<RawNode> { data.SerializeIntoRawNode() };
      }
      if(actions != null) {
        rawNode.children["actions"] = new List<RawNode> { actions.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing world_step");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.world_metadata? Get_world_metadata()
    {
      return this._world_metadata;
    }
    public XSD.Nworld_step.world_metadata GetOrInsertDefault_world_metadata()
    {
      if(this._world_metadata == null) {

        // true2
        this._world_metadata = new XSD.Nworld_step.world_metadata();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_world_metadata();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_world_metadata(XSD.Nworld_step.world_metadata? value)
    {
        this._world_metadata = value;
    }
    public List<XSD.Nworld_step.rule_group>? Get_rule_group()
    {
      return this._rule_group?.Values.ToList();
    }
    public List<XSD.Nworld_step.rule_group> GetOrInsertDefault_rule_group()
    {
      if(this._rule_group == null) {

        // false2
        this._rule_group = new Dictionary<int, XSD.Nworld_step.rule_group>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_rule_group();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_rule_group(List<XSD.Nworld_step.rule_group>? value)
    {
      this._rule_group = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public XSD.Nworld_step.data? Get_data()
    {
      return this._data;
    }
    public XSD.Nworld_step.data GetOrInsertDefault_data()
    {
      if(this._data == null) {

        // true2
        this._data = new XSD.Nworld_step.data();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_data();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_data(XSD.Nworld_step.data? value)
    {
        this._data = value;
    }
    public XSD.Nworld_step.actions? Get_actions()
    {
      return this._actions;
    }
    public XSD.Nworld_step.actions GetOrInsertDefault_actions()
    {
      if(this._actions == null) {

        // true2
        this._actions = new XSD.Nworld_step.actions();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_actions();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_actions(XSD.Nworld_step.actions? value)
    {
        this._actions = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.world_metadata.TagName))
      {
        this.world_metadata ??= new XSD.Nworld_step.world_metadata();
        xpath = xpath.Substring(XSD.Nworld_step.world_metadata.TagName.Length + 3);
        this.world_metadata.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.rule_group.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.rule_group.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._rule_group.ContainsKey(indexString.ToInt()))
        {
          this._rule_group[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.rule_group();
        newEntry.SetXPath(xpath, rawNode);
        this._rule_group.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.data.TagName))
      {
        this.data ??= new XSD.Nworld_step.data();
        xpath = xpath.Substring(XSD.Nworld_step.data.TagName.Length + 3);
        this.data.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.actions.TagName))
      {
        this.actions ??= new XSD.Nworld_step.actions();
        xpath = xpath.Substring(XSD.Nworld_step.actions.TagName.Length + 3);
        this.actions.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}