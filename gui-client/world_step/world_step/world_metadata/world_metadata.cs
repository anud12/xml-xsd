using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nworld_metadata {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class world_metadata  {

    public static string ClassTypeId = "/world_step/world_metadata";
    public static string TagName = "world_metadata";

    public string Tag = "world_metadata";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Nworld_step.Nworld_metadata.previous_world_step? _previous_world_step = null;
    public XSD.Nworld_step.Nworld_metadata.previous_world_step? previous_world_step {
      get { return _previous_world_step; }
      set { _previous_world_step = value; }
    }

    private XSD.Nworld_step.Nworld_metadata.next_world_step? _next_world_step = null;
    public XSD.Nworld_step.Nworld_metadata.next_world_step? next_world_step {
      get { return _next_world_step; }
      set { _next_world_step = value; }
    }

    private XSD.Nworld_step.Nworld_metadata.elapsed_time _elapsed_time = new XSD.Nworld_step.Nworld_metadata.elapsed_time();
    public XSD.Nworld_step.Nworld_metadata.elapsed_time elapsed_time {
      get { return _elapsed_time; }
      set { _elapsed_time = value; }
    }

    private XSD.Nworld_step.Nworld_metadata.stepDuration _stepDuration = new XSD.Nworld_step.Nworld_metadata.stepDuration();
    public XSD.Nworld_step.Nworld_metadata.stepDuration stepDuration {
      get { return _stepDuration; }
      set { _stepDuration = value; }
    }

    private XSD.Nworld_step.Nworld_metadata.counter _counter = new XSD.Nworld_step.Nworld_metadata.counter();
    public XSD.Nworld_step.Nworld_metadata.counter counter {
      get { return _counter; }
      set { _counter = value; }
    }

    private XSD.Nworld_step.Nworld_metadata.randomization_table _randomization_table = new XSD.Nworld_step.Nworld_metadata.randomization_table();
    public XSD.Nworld_step.Nworld_metadata.randomization_table randomization_table {
      get { return _randomization_table; }
      set { _randomization_table = value; }
    }
    public world_metadata()
    {
    }

    public world_metadata(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_metadata(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing world_metadata");
      //Deserialize arguments

      //Deserialize children
      this._previous_world_step = rawNode.InitializeWithRawNode("previous_world_step", this._previous_world_step);
      this._next_world_step = rawNode.InitializeWithRawNode("next_world_step", this._next_world_step);
      this._elapsed_time = rawNode.InitializeWithRawNode("elapsed_time", this._elapsed_time);
      this._stepDuration = rawNode.InitializeWithRawNode("stepDuration", this._stepDuration);
      this._counter = rawNode.InitializeWithRawNode("counter", this._counter);
      this._randomization_table = rawNode.InitializeWithRawNode("randomization_table", this._randomization_table);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(previous_world_step != null) {
        rawNode.children["previous_world_step"] = new List<RawNode> { previous_world_step.SerializeIntoRawNode() };
      }
      if(next_world_step != null) {
        rawNode.children["next_world_step"] = new List<RawNode> { next_world_step.SerializeIntoRawNode() };
      }
      if(elapsed_time != null) {
        rawNode.children["elapsed_time"] = new List<RawNode> { elapsed_time.SerializeIntoRawNode() };
      }
      if(stepDuration != null) {
        rawNode.children["stepDuration"] = new List<RawNode> { stepDuration.SerializeIntoRawNode() };
      }
      if(counter != null) {
        rawNode.children["counter"] = new List<RawNode> { counter.SerializeIntoRawNode() };
      }
      if(randomization_table != null) {
        rawNode.children["randomization_table"] = new List<RawNode> { randomization_table.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing world_metadata");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Nworld_metadata.previous_world_step? Get_previous_world_step()
    {
      return this._previous_world_step;
    }
    public XSD.Nworld_step.Nworld_metadata.previous_world_step GetOrInsertDefault_previous_world_step()
    {
      if(this._previous_world_step == null) {

        // true2
        this._previous_world_step = new XSD.Nworld_step.Nworld_metadata.previous_world_step();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_previous_world_step();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_previous_world_step(XSD.Nworld_step.Nworld_metadata.previous_world_step? value)
    {
        this._previous_world_step = value;
    }
    public XSD.Nworld_step.Nworld_metadata.next_world_step? Get_next_world_step()
    {
      return this._next_world_step;
    }
    public XSD.Nworld_step.Nworld_metadata.next_world_step GetOrInsertDefault_next_world_step()
    {
      if(this._next_world_step == null) {

        // true2
        this._next_world_step = new XSD.Nworld_step.Nworld_metadata.next_world_step();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_next_world_step();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_next_world_step(XSD.Nworld_step.Nworld_metadata.next_world_step? value)
    {
        this._next_world_step = value;
    }
    public XSD.Nworld_step.Nworld_metadata.elapsed_time Get_elapsed_time()
    {
      return this._elapsed_time;
    }
    public XSD.Nworld_step.Nworld_metadata.elapsed_time GetOrInsertDefault_elapsed_time()
    {
      if(this._elapsed_time == null) {

        // true2
        this._elapsed_time = new XSD.Nworld_step.Nworld_metadata.elapsed_time();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_elapsed_time();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_elapsed_time(XSD.Nworld_step.Nworld_metadata.elapsed_time value)
    {
        this._elapsed_time = value;
    }
    public XSD.Nworld_step.Nworld_metadata.stepDuration Get_stepDuration()
    {
      return this._stepDuration;
    }
    public XSD.Nworld_step.Nworld_metadata.stepDuration GetOrInsertDefault_stepDuration()
    {
      if(this._stepDuration == null) {

        // true2
        this._stepDuration = new XSD.Nworld_step.Nworld_metadata.stepDuration();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_stepDuration();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_stepDuration(XSD.Nworld_step.Nworld_metadata.stepDuration value)
    {
        this._stepDuration = value;
    }
    public XSD.Nworld_step.Nworld_metadata.counter Get_counter()
    {
      return this._counter;
    }
    public XSD.Nworld_step.Nworld_metadata.counter GetOrInsertDefault_counter()
    {
      if(this._counter == null) {

        // true2
        this._counter = new XSD.Nworld_step.Nworld_metadata.counter();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_counter();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_counter(XSD.Nworld_step.Nworld_metadata.counter value)
    {
        this._counter = value;
    }
    public XSD.Nworld_step.Nworld_metadata.randomization_table Get_randomization_table()
    {
      return this._randomization_table;
    }
    public XSD.Nworld_step.Nworld_metadata.randomization_table GetOrInsertDefault_randomization_table()
    {
      if(this._randomization_table == null) {

        // true2
        this._randomization_table = new XSD.Nworld_step.Nworld_metadata.randomization_table();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_randomization_table();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_randomization_table(XSD.Nworld_step.Nworld_metadata.randomization_table value)
    {
        this._randomization_table = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.previous_world_step.TagName))
      {
        this.previous_world_step ??= new XSD.Nworld_step.Nworld_metadata.previous_world_step();
        xpath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.previous_world_step.TagName.Length + 3);
        this.previous_world_step.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.next_world_step.TagName))
      {
        this.next_world_step ??= new XSD.Nworld_step.Nworld_metadata.next_world_step();
        xpath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.next_world_step.TagName.Length + 3);
        this.next_world_step.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.elapsed_time.TagName))
      {
        xpath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.elapsed_time.TagName.Length + 3);
        this.elapsed_time.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.stepDuration.TagName))
      {
        xpath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.stepDuration.TagName.Length + 3);
        this.stepDuration.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.counter.TagName))
      {
        xpath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.counter.TagName.Length + 3);
        this.counter.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.randomization_table.TagName))
      {
        xpath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.randomization_table.TagName.Length + 3);
        this.randomization_table.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}