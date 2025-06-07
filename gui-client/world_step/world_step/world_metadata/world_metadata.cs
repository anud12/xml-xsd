using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nworld_metadata {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class world_metadata : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.world_metadata";
    public static string TagName = "world_metadata";

    public string NodeName {get =>"world_metadata";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<world_metadata>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Nworld_step.Nworld_metadata.previous_world_step? _previous_world_step = null;
    public XSD.Nworld_step.Nworld_metadata.previous_world_step previous_world_step
    {
      get
      {
        if(_previous_world_step == null)
        {
          _previous_world_step = new();
          _previous_world_step.ParentNode = this;
          OnChange();
        }
        return _previous_world_step;
      }
      set
      {
        _previous_world_step = value;
        _previous_world_step.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nworld_metadata.next_world_step? _next_world_step = null;
    public XSD.Nworld_step.Nworld_metadata.next_world_step next_world_step
    {
      get
      {
        if(_next_world_step == null)
        {
          _next_world_step = new();
          _next_world_step.ParentNode = this;
          OnChange();
        }
        return _next_world_step;
      }
      set
      {
        _next_world_step = value;
        _next_world_step.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nworld_metadata.elapsed_time _elapsed_time = new XSD.Nworld_step.Nworld_metadata.elapsed_time();
    public XSD.Nworld_step.Nworld_metadata.elapsed_time elapsed_time
    {
      get
      {
        if(_elapsed_time == null)
        {
          _elapsed_time = new();
          _elapsed_time.ParentNode = this;
          OnChange();
        }
        return _elapsed_time;
      }
      set
      {
        _elapsed_time = value;
        _elapsed_time.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nworld_metadata.stepDuration _stepDuration = new XSD.Nworld_step.Nworld_metadata.stepDuration();
    public XSD.Nworld_step.Nworld_metadata.stepDuration stepDuration
    {
      get
      {
        if(_stepDuration == null)
        {
          _stepDuration = new();
          _stepDuration.ParentNode = this;
          OnChange();
        }
        return _stepDuration;
      }
      set
      {
        _stepDuration = value;
        _stepDuration.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nworld_metadata.counter _counter = new XSD.Nworld_step.Nworld_metadata.counter();
    public XSD.Nworld_step.Nworld_metadata.counter counter
    {
      get
      {
        if(_counter == null)
        {
          _counter = new();
          _counter.ParentNode = this;
          OnChange();
        }
        return _counter;
      }
      set
      {
        _counter = value;
        _counter.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nworld_metadata.randomization_table _randomization_table = new XSD.Nworld_step.Nworld_metadata.randomization_table();
    public XSD.Nworld_step.Nworld_metadata.randomization_table randomization_table
    {
      get
      {
        if(_randomization_table == null)
        {
          _randomization_table = new();
          _randomization_table.ParentNode = this;
          OnChange();
        }
        return _randomization_table;
      }
      set
      {
        _randomization_table = value;
        _randomization_table.ParentNode = this;
      }
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

    public Action OnChange(Action<world_metadata> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public Action OnChangeBubble(Action<List<ILinkedNode>> callback)
    {
      _bubbleCallbackList.Add(callback);
      return () => _bubbleCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing world_metadata");
      //Deserialize arguments

      //Deserialize children
      previous_world_step = rawNode.InitializeWithRawNode("previous_world_step", previous_world_step);

      next_world_step = rawNode.InitializeWithRawNode("next_world_step", next_world_step);

      elapsed_time = rawNode.InitializeWithRawNode("elapsed_time", elapsed_time);

      stepDuration = rawNode.InitializeWithRawNode("stepDuration", stepDuration);

      counter = rawNode.InitializeWithRawNode("counter", counter);

      randomization_table = rawNode.InitializeWithRawNode("randomization_table", randomization_table);
      OnChange();
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

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.previous_world_step.TagName))
      {
        this.previous_world_step ??= new XSD.Nworld_step.Nworld_metadata.previous_world_step();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.previous_world_step.TagName.Length + 3);
        this.previous_world_step.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.next_world_step.TagName))
      {
        this.next_world_step ??= new XSD.Nworld_step.Nworld_metadata.next_world_step();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.next_world_step.TagName.Length + 3);
        this.next_world_step.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.elapsed_time.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.elapsed_time.TagName.Length + 3);
        this.elapsed_time.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.stepDuration.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.stepDuration.TagName.Length + 3);
        this.stepDuration.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.counter.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.counter.TagName.Length + 3);
        this.counter.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.randomization_table.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nworld_metadata.randomization_table.TagName.Length + 3);
        this.randomization_table.DeserializeAtPath(childXPath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }

    public void ChildChanged(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _callbackList.ForEach(action => action(this));
      _bubbleCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nworld_metadata.previous_world_step casted_previous_world_step) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nworld_metadata.next_world_step casted_next_world_step) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nworld_metadata.elapsed_time casted_elapsed_time) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nworld_metadata.stepDuration casted_stepDuration) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nworld_metadata.counter casted_counter) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nworld_metadata.randomization_table casted_randomization_table) {
        return 0;
      }
      return null;
    }
  }
}