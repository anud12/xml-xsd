using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
namespace XSD {
  /*typeDeclarationElementToString= element*/
  public class world_step {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__world_metadata> world_metadata = new List<world_step__world_metadata>();
    public List<world_step__rule_group> rule_group = new List<world_step__rule_group>();
    public List<world_step__items> items = new List<world_step__items>();
    public List<world_step__people> people = new List<world_step__people>();
    public List<world_step__location_layer> location_layer = new List<world_step__location_layer>();
    public List<world_step__location_graph> location_graph = new List<world_step__location_graph>();
    public List<world_step__actions> actions = new List<world_step__actions>();

    public world_step() {
    }

    public world_step(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step");
      //Deserialize elements
      this.world_metadata = rawNode.InitializeWithRawNode("world_metadata", this.world_metadata);
      this.rule_group = rawNode.InitializeWithRawNode("rule_group", this.rule_group);
      this.items = rawNode.InitializeWithRawNode("items", this.items);
      this.people = rawNode.InitializeWithRawNode("people", this.people);
      this.location_layer = rawNode.InitializeWithRawNode("location_layer", this.location_layer);
      this.location_graph = rawNode.InitializeWithRawNode("location_graph", this.location_graph);
      this.actions = rawNode.InitializeWithRawNode("actions", this.actions);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["world_metadata"] = world_metadata.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["rule_group"] = rule_group.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["items"] = items.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["people"] = people.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_layer"] = location_layer.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph"] = location_graph.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["actions"] = actions.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__world_metadata__previous_world_step> previous_world_step = new List<world_step__world_metadata__previous_world_step>();
    public List<world_step__world_metadata__next_world_step> next_world_step = new List<world_step__world_metadata__next_world_step>();
    public List<world_step__world_metadata__elapsed_time> elapsed_time = new List<world_step__world_metadata__elapsed_time>();
    public List<world_step__world_metadata__stepDuration> stepDuration = new List<world_step__world_metadata__stepDuration>();
    public List<world_step__world_metadata__counter> counter = new List<world_step__world_metadata__counter>();
    public List<world_step__world_metadata__randomization_table> randomization_table = new List<world_step__world_metadata__randomization_table>();

    public world_step__world_metadata() {
    }

    public world_step__world_metadata(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__world_metadata(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata");
      //Deserialize elements
      this.previous_world_step = rawNode.InitializeWithRawNode("previous_world_step", this.previous_world_step);
      this.next_world_step = rawNode.InitializeWithRawNode("next_world_step", this.next_world_step);
      this.elapsed_time = rawNode.InitializeWithRawNode("elapsed_time", this.elapsed_time);
      this.stepDuration = rawNode.InitializeWithRawNode("stepDuration", this.stepDuration);
      this.counter = rawNode.InitializeWithRawNode("counter", this.counter);
      this.randomization_table = rawNode.InitializeWithRawNode("randomization_table", this.randomization_table);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["previous_world_step"] = previous_world_step.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["next_world_step"] = next_world_step.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["elapsed_time"] = elapsed_time.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["stepDuration"] = stepDuration.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["counter"] = counter.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["randomization_table"] = randomization_table.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__world_metadata");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__rule_group__property_rule> property_rule = new List<world_step__rule_group__property_rule>();
    public List<world_step__rule_group__classification_rule> classification_rule = new List<world_step__rule_group__classification_rule>();
    public List<world_step__rule_group__name_rule> name_rule = new List<world_step__rule_group__name_rule>();
    public List<world_step__rule_group__race_rule> race_rule = new List<world_step__rule_group__race_rule>();
    public List<world_step__rule_group__action_rule> action_rule = new List<world_step__rule_group__action_rule>();
    public List<world_step__rule_group__item_rule> item_rule = new List<world_step__rule_group__item_rule>();
    public List<world_step__rule_group__events_rule> events_rule = new List<world_step__rule_group__events_rule>();
    public List<world_step__rule_group__locations_markov_chain> locations_markov_chain = new List<world_step__rule_group__locations_markov_chain>();
    public List<world_step__rule_group__location_graph_rule> location_graph_rule = new List<world_step__rule_group__location_graph_rule>();

    public world_step__rule_group() {
    }

    public world_step__rule_group(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group");
      //Deserialize arguments

      //Deserialize elements
      this.property_rule = rawNode.InitializeWithRawNode("property_rule", this.property_rule);
      this.classification_rule = rawNode.InitializeWithRawNode("classification_rule", this.classification_rule);
      this.name_rule = rawNode.InitializeWithRawNode("name_rule", this.name_rule);
      this.race_rule = rawNode.InitializeWithRawNode("race_rule", this.race_rule);
      this.action_rule = rawNode.InitializeWithRawNode("action_rule", this.action_rule);
      this.item_rule = rawNode.InitializeWithRawNode("item_rule", this.item_rule);
      this.events_rule = rawNode.InitializeWithRawNode("events_rule", this.events_rule);
      this.locations_markov_chain = rawNode.InitializeWithRawNode("locations_markov_chain", this.locations_markov_chain);
      this.location_graph_rule = rawNode.InitializeWithRawNode("location_graph_rule", this.location_graph_rule);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements
      rawNode.children["property_rule"] = property_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["classification_rule"] = classification_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["name_rule"] = name_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["race_rule"] = race_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["action_rule"] = action_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["item_rule"] = item_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["events_rule"] = events_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["locations_markov_chain"] = locations_markov_chain.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph_rule"] = location_graph_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__items {
    public RawNode rawNode = new RawNode();

    //Children elements
    /* ignored children key:item of type:type__item*/

    public world_step__items() {
    }

    public world_step__items(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__items(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__items");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__items");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__people {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__people__person> person = new List<world_step__people__person>();

    public world_step__people() {
    }

    public world_step__people(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__people(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people");
      //Deserialize elements
      this.person = rawNode.InitializeWithRawNode("person", this.person);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["person"] = person.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__location_layer {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__location_layer__cell> cell = new List<world_step__location_layer__cell>();

    public world_step__location_layer() {
    }

    public world_step__location_layer(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__location_layer(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_layer");
      //Deserialize arguments

      //Deserialize elements
      this.cell = rawNode.InitializeWithRawNode("cell", this.cell);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements
      rawNode.children["cell"] = cell.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_layer");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public List<world_step__location_graph__rule> rule = new List<world_step__location_graph__rule>();
    public List<world_step__location_graph__node> node = new List<world_step__location_graph__node>();

    public world_step__location_graph() {
    }

    public world_step__location_graph(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__location_graph(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph");
      //Deserialize arguments
      this.id = rawNode.attributes["id"];
      //Deserialize elements
      this.rule = rawNode.InitializeWithRawNode("rule", this.rule);
      this.node = rawNode.InitializeWithRawNode("node", this.node);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["rule"] = rule.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["node"] = node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_graph");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__actions {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__actions__by> by = new List<world_step__actions__by>();
    public List<world_step__actions__location_graph__create> location_graph__create = new List<world_step__actions__location_graph__create>();
    public List<world_step__actions__location_graph__node__create_adjacent> location_graph__node__create_adjacent = new List<world_step__actions__location_graph__node__create_adjacent>();
    public List<world_step__actions__person__teleport> person__teleport = new List<world_step__actions__person__teleport>();
    public List<world_step__actions__person__on_person__property_mutation> person__on_person__property_mutation = new List<world_step__actions__person__on_person__property_mutation>();

    public world_step__actions() {
    }

    public world_step__actions(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__actions(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions");
      //Deserialize elements
      this.by = rawNode.InitializeWithRawNode("by", this.by);
      this.location_graph__create = rawNode.InitializeWithRawNode("location_graph.create", this.location_graph__create);
      this.location_graph__node__create_adjacent = rawNode.InitializeWithRawNode("location_graph.node.create_adjacent", this.location_graph__node__create_adjacent);
      this.person__teleport = rawNode.InitializeWithRawNode("person.teleport", this.person__teleport);
      this.person__on_person__property_mutation = rawNode.InitializeWithRawNode("person.on_person.property_mutation", this.person__on_person__property_mutation);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["by"] = by.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.create"] = location_graph__create.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.node.create_adjacent"] = location_graph__node__create_adjacent.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person.teleport"] = person__teleport.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person.on_person.property_mutation"] = person__on_person__property_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__previous_world_step {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String value;

    //Children elements

    public world_step__world_metadata__previous_world_step() {
    }

    public world_step__world_metadata__previous_world_step(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__previous_world_step(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__previous_world_step");
      //Deserialize arguments
      this.value = rawNode.attributes["value"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__world_metadata__previous_world_step");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__next_world_step {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String value;

    //Children elements

    public world_step__world_metadata__next_world_step() {
    }

    public world_step__world_metadata__next_world_step(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__next_world_step(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__next_world_step");
      //Deserialize arguments
      this.value = rawNode.attributes["value"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__world_metadata__next_world_step");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__elapsed_time {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 value;

    //Children elements

    public world_step__world_metadata__elapsed_time() {
    }

    public world_step__world_metadata__elapsed_time(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__elapsed_time(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__elapsed_time");
      //Deserialize arguments
      var attribute_value = rawNode.attributes["value"];
      if(attribute_value != null)
      {
        this.value = attribute_value.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__world_metadata__elapsed_time");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__stepDuration {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 value;

    //Children elements

    public world_step__world_metadata__stepDuration() {
    }

    public world_step__world_metadata__stepDuration(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__stepDuration(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__stepDuration");
      //Deserialize arguments
      var attribute_value = rawNode.attributes["value"];
      if(attribute_value != null)
      {
        this.value = attribute_value.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__world_metadata__stepDuration");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__counter {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 value;

    //Children elements

    public world_step__world_metadata__counter() {
    }

    public world_step__world_metadata__counter(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__counter(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__counter");
      //Deserialize arguments
      var attribute_value = rawNode.attributes["value"];
      if(attribute_value != null)
      {
        this.value = attribute_value.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__world_metadata__counter");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__randomization_table {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__world_metadata__randomization_table__entry> entry = new List<world_step__world_metadata__randomization_table__entry>();

    public world_step__world_metadata__randomization_table() {
    }

    public world_step__world_metadata__randomization_table(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__randomization_table(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__randomization_table");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__world_metadata__randomization_table");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__property_rule__entry> entry = new List<world_step__rule_group__property_rule__entry>();

    public world_step__rule_group__property_rule() {
    }

    public world_step__rule_group__property_rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__property_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__classification_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__classification_rule__entry> entry = new List<world_step__rule_group__classification_rule__entry>();

    public world_step__rule_group__classification_rule() {
    }

    public world_step__rule_group__classification_rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__classification_rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__classification_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__classification_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__name_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    /* ignored children key:entry of type:group__name_token*/

    public world_step__rule_group__name_rule() {
    }

    public world_step__rule_group__name_rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__name_rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__name_rule");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__name_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__race_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__race_rule__entry> entry = new List<world_step__rule_group__race_rule__entry>();

    public world_step__rule_group__race_rule() {
    }

    public world_step__rule_group__race_rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__race_rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__race_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__race_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__action_rule__global> global = new List<world_step__rule_group__action_rule__global>();
    public List<world_step__rule_group__action_rule__person_to_person> person_to_person = new List<world_step__rule_group__action_rule__person_to_person>();

    public world_step__rule_group__action_rule() {
    }

    public world_step__rule_group__action_rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule");
      //Deserialize elements
      this.global = rawNode.InitializeWithRawNode("global", this.global);
      this.person_to_person = rawNode.InitializeWithRawNode("person_to_person", this.person_to_person);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["global"] = global.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person_to_person"] = person_to_person.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__action_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__item_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__item_rule__entry> entry = new List<world_step__rule_group__item_rule__entry>();

    public world_step__rule_group__item_rule() {
    }

    public world_step__rule_group__item_rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__item_rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__item_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__events_rule__entry> entry = new List<world_step__rule_group__events_rule__entry>();

    public world_step__rule_group__events_rule() {
    }

    public world_step__rule_group__events_rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__events_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__locations_markov_chain {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__locations_markov_chain__location_markov_link> location_markov_link = new List<world_step__rule_group__locations_markov_chain__location_markov_link>();

    public world_step__rule_group__locations_markov_chain() {
    }

    public world_step__rule_group__locations_markov_chain(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__locations_markov_chain(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain");
      //Deserialize elements
      this.location_markov_link = rawNode.InitializeWithRawNode("location_markov_link", this.location_markov_link);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["location_markov_link"] = location_markov_link.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__locations_markov_chain");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public List<world_step__rule_group__location_graph_rule__setup> setup = new List<world_step__rule_group__location_graph_rule__setup>();
    public List<world_step__rule_group__location_graph_rule__node_rule> node_rule = new List<world_step__rule_group__location_graph_rule__node_rule>();

    public world_step__rule_group__location_graph_rule() {
    }

    public world_step__rule_group__location_graph_rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule");
      //Deserialize arguments
      this.id = rawNode.attributes["id"];
      //Deserialize elements
      this.setup = rawNode.InitializeWithRawNode("setup", this.setup);
      this.node_rule = rawNode.InitializeWithRawNode("node_rule", this.node_rule);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["setup"] = setup.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["node_rule"] = node_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__people__person {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String name;

    //Children elements
    public List<world_step__people__person__race> race = new List<world_step__people__person__race>();
    /* ignored children key:location of type:type_cell_ref*/
    public List<world_step__people__person__properties> properties = new List<world_step__people__person__properties>();
    public List<world_step__people__person__relations> relations = new List<world_step__people__person__relations>();
    public List<world_step__people__person__inventory> inventory = new List<world_step__people__person__inventory>();
    public List<world_step__people__person__classifications> classifications = new List<world_step__people__person__classifications>();
    /* ignored children key:icon of type:type_icon*/

    public world_step__people__person() {
    }

    public world_step__people__person(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__people__person(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person");
      //Deserialize arguments
      this.id = rawNode.attributes["id"];
      this.name = rawNode.attributes["name"];
      //Deserialize elements
      this.race = rawNode.InitializeWithRawNode("race", this.race);
      this.properties = rawNode.InitializeWithRawNode("properties", this.properties);
      this.relations = rawNode.InitializeWithRawNode("relations", this.relations);
      this.inventory = rawNode.InitializeWithRawNode("inventory", this.inventory);
      this.classifications = rawNode.InitializeWithRawNode("classifications", this.classifications);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.name != null)
      {
        rawNode.attributes["name"] = this.name.ToString();
      }
      //Serialize elements
      rawNode.children["race"] = race.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["properties"] = properties.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["relations"] = relations.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["inventory"] = inventory.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["classifications"] = classifications.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__location_layer__cell {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__location_layer__cell() {
    }

    public world_step__location_layer__cell(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__location_layer__cell(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_layer__cell");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_layer__cell");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__rule {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_rule_ref;

    //Children elements

    public world_step__location_graph__rule() {
    }

    public world_step__location_graph__rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__location_graph__rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__rule");
      //Deserialize arguments
      this.location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.location_graph_rule_ref != null)
      {
        rawNode.attributes["location_graph_rule_ref"] = this.location_graph_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_graph__rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.String id;

    //Children elements
    public List<world_step__location_graph__node__position> position = new List<world_step__location_graph__node__position>();
    public List<world_step__location_graph__node__link_to> link_to = new List<world_step__location_graph__node__link_to>();
    public List<world_step__location_graph__node__people> people = new List<world_step__location_graph__node__people>();

    public world_step__location_graph__node() {
    }

    public world_step__location_graph__node(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node");
      //Deserialize arguments
      this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      this.id = rawNode.attributes["id"];
      //Deserialize elements
      this.position = rawNode.InitializeWithRawNode("position", this.position);
      this.link_to = rawNode.InitializeWithRawNode("link_to", this.link_to);
      this.people = rawNode.InitializeWithRawNode("people", this.people);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
      }
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["position"] = position.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["link_to"] = link_to.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["people"] = people.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_graph__node");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__actions__by {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__actions__by__do> _do = new List<world_step__actions__by__do>();
    public List<world_step__actions__by__move_towards> move_towards = new List<world_step__actions__by__move_towards>();

    public world_step__actions__by() {
    }

    public world_step__actions__by(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__actions__by(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__by");
      //Deserialize arguments

      //Deserialize elements
      this._do = rawNode.InitializeWithRawNode("do", this._do);
      this.move_towards = rawNode.InitializeWithRawNode("move_towards", this.move_towards);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements
      rawNode.children["do"] = _do.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["move_towards"] = move_towards.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__by");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__actions__location_graph__create {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_rule_ref;

    //Children elements

    public world_step__actions__location_graph__create() {
    }

    public world_step__actions__location_graph__create(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__actions__location_graph__create(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__location_graph__create");
      //Deserialize arguments
      this.location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.location_graph_rule_ref != null)
      {
        rawNode.attributes["location_graph_rule_ref"] = this.location_graph_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__location_graph__create");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__actions__location_graph__node__create_adjacent {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_id_ref;
    public System.String node_id_ref;

    //Children elements

    public world_step__actions__location_graph__node__create_adjacent() {
    }

    public world_step__actions__location_graph__node__create_adjacent(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__actions__location_graph__node__create_adjacent(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__location_graph__node__create_adjacent");
      //Deserialize arguments
      this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
      this.node_id_ref = rawNode.attributes["node_id_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.location_graph_id_ref != null)
      {
        rawNode.attributes["location_graph_id_ref"] = this.location_graph_id_ref.ToString();
      }
      if(this.node_id_ref != null)
      {
        rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__location_graph__node__create_adjacent");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__actions__person__teleport {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;

    //Children elements
    public List<world_step__actions__person__teleport__location_graph> location_graph = new List<world_step__actions__person__teleport__location_graph>();

    public world_step__actions__person__teleport() {
    }

    public world_step__actions__person__teleport(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__actions__person__teleport(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__person__teleport");
      //Deserialize arguments
      this.person_id_ref = rawNode.attributes["person_id_ref"];
      //Deserialize elements
      this.location_graph = rawNode.InitializeWithRawNode("location_graph", this.location_graph);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }
      //Serialize elements
      rawNode.children["location_graph"] = location_graph.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__person__teleport");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__actions__person__on_person__property_mutation {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;
    public System.String target_person_id_ref;
    public System.String action_property_mutation_rule_ref;

    //Children elements

    public world_step__actions__person__on_person__property_mutation() {
    }

    public world_step__actions__person__on_person__property_mutation(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__actions__person__on_person__property_mutation(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__person__on_person__property_mutation");
      //Deserialize arguments
      this.person_id_ref = rawNode.attributes["person_id_ref"];
      this.target_person_id_ref = rawNode.attributes["target_person_id_ref"];
      this.action_property_mutation_rule_ref = rawNode.attributes["action_property_mutation_rule_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }
      if(this.target_person_id_ref != null)
      {
        rawNode.attributes["target_person_id_ref"] = this.target_person_id_ref.ToString();
      }
      if(this.action_property_mutation_rule_ref != null)
      {
        rawNode.attributes["action_property_mutation_rule_ref"] = this.action_property_mutation_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__person__on_person__property_mutation");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__randomization_table__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 value;

    //Children elements

    public world_step__world_metadata__randomization_table__entry() {
    }

    public world_step__world_metadata__randomization_table__entry(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__randomization_table__entry(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__randomization_table__entry");
      //Deserialize arguments
      var attribute_value = rawNode.attributes["value"];
      if(attribute_value != null)
      {
        this.value = attribute_value.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__world_metadata__randomization_table__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__rule_group__property_rule__entry__person_default> person_default = new List<world_step__rule_group__property_rule__entry__person_default>();
    public List<world_step__rule_group__property_rule__entry__item_default> item_default = new List<world_step__rule_group__property_rule__entry__item_default>();
    public List<world_step__rule_group__property_rule__entry__property_threshold> property_threshold = new List<world_step__rule_group__property_rule__entry__property_threshold>();

    public world_step__rule_group__property_rule__entry() {
    }

    public world_step__rule_group__property_rule__entry(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule__entry(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry");
      //Deserialize arguments

      //Deserialize elements
      this.person_default = rawNode.InitializeWithRawNode("person_default", this.person_default);
      this.item_default = rawNode.InitializeWithRawNode("item_default", this.item_default);
      this.property_threshold = rawNode.InitializeWithRawNode("property-threshold", this.property_threshold);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements
      rawNode.children["property-threshold"] = property_threshold.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__property_rule__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__classification_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    /* ignored children key:property of type:group__math_operations*/

    public world_step__rule_group__classification_rule__entry() {
    }

    public world_step__rule_group__classification_rule__entry(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__classification_rule__entry(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__classification_rule__entry");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__classification_rule__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__race_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    /* ignored children key:vision of type:type_range*/
    /* ignored children key:movement of type:type_range*/
    public List<world_step__rule_group__race_rule__entry__name> name = new List<world_step__rule_group__race_rule__entry__name>();
    /* ignored children key:property_bonus of type:group__math_operations*/
    /* ignored children key:icon of type:type_icon*/

    public world_step__rule_group__race_rule__entry() {
    }

    public world_step__rule_group__race_rule__entry(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__race_rule__entry(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__race_rule__entry");
      //Deserialize arguments
      this.id = rawNode.attributes["id"];
      //Deserialize elements
      this.name = rawNode.InitializeWithRawNode("name", this.name);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["name"] = name.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__race_rule__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__global {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__action_rule__global__entry> entry = new List<world_step__rule_group__action_rule__global__entry>();

    public world_step__rule_group__action_rule__global() {
    }

    public world_step__rule_group__action_rule__global(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__global(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__global");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__action_rule__global");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__person_to_person {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public List<world_step__rule_group__action_rule__person_to_person__test> test = new List<world_step__rule_group__action_rule__person_to_person__test>();
    /* ignored children key:property_mutation of type:type__property_mutation_on*/
    public List<world_step__rule_group__action_rule__person_to_person__location_mutation> location_mutation = new List<world_step__rule_group__action_rule__person_to_person__location_mutation>();

    public world_step__rule_group__action_rule__person_to_person() {
    }

    public world_step__rule_group__action_rule__person_to_person(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__person_to_person(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person");
      //Deserialize arguments
      this.id = rawNode.attributes["id"];
      //Deserialize elements
      this.test = rawNode.InitializeWithRawNode("test", this.test);
      this.location_mutation = rawNode.InitializeWithRawNode("location_mutation", this.location_mutation);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["test"] = test.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_mutation"] = location_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__action_rule__person_to_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__item_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    /* ignored children key:name of type:group__name_token*/
    public List<world_step__rule_group__item_rule__entry__weight_kg> weight_kg = new List<world_step__rule_group__item_rule__entry__weight_kg>();
    public List<world_step__rule_group__item_rule__entry__wearable> wearable = new List<world_step__rule_group__item_rule__entry__wearable>();

    public world_step__rule_group__item_rule__entry() {
    }

    public world_step__rule_group__item_rule__entry(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__item_rule__entry(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule__entry");
      //Deserialize arguments

      //Deserialize elements
      this.weight_kg = rawNode.InitializeWithRawNode("weight-kg", this.weight_kg);
      this.wearable = rawNode.InitializeWithRawNode("wearable", this.wearable);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements
      rawNode.children["weight-kg"] = weight_kg.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["wearable"] = wearable.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__item_rule__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    /* ignored children key:when of type:type__trigger*/
    public List<world_step__rule_group__events_rule__entry__then> then = new List<world_step__rule_group__events_rule__entry__then>();

    public world_step__rule_group__events_rule__entry() {
    }

    public world_step__rule_group__events_rule__entry(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry");
      //Deserialize arguments
      this.id = rawNode.attributes["id"];
      //Deserialize elements
      this.then = rawNode.InitializeWithRawNode("then", this.then);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["then"] = then.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__locations_markov_chain__location_markov_link {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__tag> tag = new List<world_step__rule_group__locations_markov_chain__location_markov_link__tag>();
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling> sibling = new List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling>();
    /* ignored children key:icon of type:type_icon*/

    public world_step__rule_group__locations_markov_chain__location_markov_link() {
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain__location_markov_link");
      //Deserialize arguments

      //Deserialize elements
      this.tag = rawNode.InitializeWithRawNode("tag", this.tag);
      this.sibling = rawNode.InitializeWithRawNode("sibling", this.sibling);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements
      rawNode.children["tag"] = tag.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["sibling"] = sibling.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__locations_markov_chain__location_markov_link");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__setup {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__location_graph_rule__setup__starting_node> starting_node = new List<world_step__rule_group__location_graph_rule__setup__starting_node>();

    public world_step__rule_group__location_graph_rule__setup() {
    }

    public world_step__rule_group__location_graph_rule__setup(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__setup(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup");
      //Deserialize elements
      this.starting_node = rawNode.InitializeWithRawNode("starting_node", this.starting_node);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["starting_node"] = starting_node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__setup");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__node_rule {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group> link_group = new List<world_step__rule_group__location_graph_rule__node_rule__link_group>();

    public world_step__rule_group__location_graph_rule__node_rule() {
    }

    public world_step__rule_group__location_graph_rule__node_rule(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__node_rule(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule");
      //Deserialize arguments
      this.id = rawNode.attributes["id"];
      //Deserialize elements
      this.link_group = rawNode.InitializeWithRawNode("link_group", this.link_group);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["link_group"] = link_group.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__race {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__people__person__race() {
    }

    public world_step__people__person__race(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__people__person__race(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__race");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person__race");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__properties {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__people__person__properties__property> property = new List<world_step__people__person__properties__property>();

    public world_step__people__person__properties() {
    }

    public world_step__people__person__properties(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__people__person__properties(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__properties");
      //Deserialize elements
      this.property = rawNode.InitializeWithRawNode("property", this.property);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person__properties");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__relations {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__people__person__relations() {
    }

    public world_step__people__person__relations(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__people__person__relations(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__relations");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person__relations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__inventory {
    public RawNode rawNode = new RawNode();

    //Children elements
    /* ignored children key:item of type:type__item*/

    public world_step__people__person__inventory() {
    }

    public world_step__people__person__inventory(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__people__person__inventory(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__inventory");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person__inventory");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__classifications {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__people__person__classifications__classification> classification = new List<world_step__people__person__classifications__classification>();

    public world_step__people__person__classifications() {
    }

    public world_step__people__person__classifications(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__people__person__classifications(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__classifications");
      //Deserialize elements
      this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person__classifications");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__position {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 x;
    public System.Int32 y;

    //Children elements

    public world_step__location_graph__node__position() {
    }

    public world_step__location_graph__node__position(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__position(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__position");
      //Deserialize arguments
      var attribute_x = rawNode.attributes["x"];
      if(attribute_x != null)
      {
        this.x = attribute_x.ToInt();
      }
      var attribute_y = rawNode.attributes["y"];
      if(attribute_y != null)
      {
        this.y = attribute_y.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.x != null)
      {
        rawNode.attributes["x"] = this.x.ToString();
      }
      if(this.y != null)
      {
        rawNode.attributes["y"] = this.y.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_graph__node__position");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__link_to {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_id_ref;

    //Children elements

    public world_step__location_graph__node__link_to() {
    }

    public world_step__location_graph__node__link_to(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__link_to(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__link_to");
      //Deserialize arguments
      this.node_id_ref = rawNode.attributes["node_id_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.node_id_ref != null)
      {
        rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_graph__node__link_to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__people {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__location_graph__node__people__person> person = new List<world_step__location_graph__node__people__person>();

    public world_step__location_graph__node__people() {
    }

    public world_step__location_graph__node__people(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__people(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__people");
      //Deserialize elements
      this.person = rawNode.InitializeWithRawNode("person", this.person);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements
      rawNode.children["person"] = person.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_graph__node__people");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__actions__by__do {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__actions__by__do() {
    }

    public world_step__actions__by__do(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__actions__by__do(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__by__do");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__by__do");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__actions__by__move_towards {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String layer;
    public System.Int32 x;
    public System.Int32 y;

    //Children elements

    public world_step__actions__by__move_towards() {
    }

    public world_step__actions__by__move_towards(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__actions__by__move_towards(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__by__move_towards");
      //Deserialize arguments
      this.layer = rawNode.attributes["layer"];
      var attribute_x = rawNode.attributes["x"];
      if(attribute_x != null)
      {
        this.x = attribute_x.ToInt();
      }
      var attribute_y = rawNode.attributes["y"];
      if(attribute_y != null)
      {
        this.y = attribute_y.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.layer != null)
      {
        rawNode.attributes["layer"] = this.layer.ToString();
      }
      if(this.x != null)
      {
        rawNode.attributes["x"] = this.x.ToString();
      }
      if(this.y != null)
      {
        rawNode.attributes["y"] = this.y.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__by__move_towards");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__actions__person__teleport__location_graph {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_id_ref;
    public System.String node_id_ref;

    //Children elements

    public world_step__actions__person__teleport__location_graph() {
    }

    public world_step__actions__person__teleport__location_graph(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__actions__person__teleport__location_graph(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__person__teleport__location_graph");
      //Deserialize arguments
      this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
      this.node_id_ref = rawNode.attributes["node_id_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.location_graph_id_ref != null)
      {
        rawNode.attributes["location_graph_id_ref"] = this.location_graph_id_ref.ToString();
      }
      if(this.node_id_ref != null)
      {
        rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__person__teleport__location_graph");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule__entry__person_default {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__property_rule__entry__person_default() {
    }

    public world_step__rule_group__property_rule__entry__person_default(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule__entry__person_default(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__person_default");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__property_rule__entry__person_default");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule__entry__item_default {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__property_rule__entry__item_default() {
    }

    public world_step__rule_group__property_rule__entry__item_default(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule__entry__item_default(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__item_default");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__property_rule__entry__item_default");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule__entry__property_threshold {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String name;
    public System.Int32 min_value_inclusive;
    public System.Int32 max_value_inclusive;

    //Children elements

    public world_step__rule_group__property_rule__entry__property_threshold() {
    }

    public world_step__rule_group__property_rule__entry__property_threshold(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule__entry__property_threshold(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__property_threshold");
      //Deserialize arguments
      this.name = rawNode.attributes["name"];
      var attribute_min_value_inclusive = rawNode.attributes["min-value-inclusive"];
      if(attribute_min_value_inclusive != null)
      {
        this.min_value_inclusive = attribute_min_value_inclusive.ToInt();
      }
      var attribute_max_value_inclusive = rawNode.attributes["max-value-inclusive"];
      if(attribute_max_value_inclusive != null)
      {
        this.max_value_inclusive = attribute_max_value_inclusive.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.name != null)
      {
        rawNode.attributes["name"] = this.name.ToString();
      }
      if(this.min_value_inclusive != null)
      {
        rawNode.attributes["min-value-inclusive"] = this.min_value_inclusive.ToString();
      }
      if(this.max_value_inclusive != null)
      {
        rawNode.attributes["max-value-inclusive"] = this.max_value_inclusive.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__property_rule__entry__property_threshold");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__race_rule__entry__name {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String name_rule_ref;

    //Children elements

    public world_step__rule_group__race_rule__entry__name() {
    }

    public world_step__rule_group__race_rule__entry__name(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__race_rule__entry__name(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__race_rule__entry__name");
      //Deserialize arguments
      this.name_rule_ref = rawNode.attributes["name_rule_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.name_rule_ref != null)
      {
        rawNode.attributes["name_rule_ref"] = this.name_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__race_rule__entry__name");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__global__entry {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__action_rule__global__entry() {
    }

    public world_step__rule_group__action_rule__global__entry(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__global__entry(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__global__entry");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__action_rule__global__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__person_to_person__test {
    public RawNode rawNode = new RawNode();

    //Children elements
    /* ignored children key:value of type:group__math_operations*/
    /* ignored children key:expected of type:group__math_operations*/

    public world_step__rule_group__action_rule__person_to_person__test() {
    }

    public world_step__rule_group__action_rule__person_to_person__test(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__person_to_person__test(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person__test");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__action_rule__person_to_person__test");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__person_to_person__location_mutation {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    public System.String on;

    //Children elements
    /* ignored children key:from of type:group__math_operations*/

    public world_step__rule_group__action_rule__person_to_person__location_mutation() {
    }

    public world_step__rule_group__action_rule__person_to_person__location_mutation(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__person_to_person__location_mutation(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person__location_mutation");
      //Deserialize arguments
      this.on = rawNode.attributes["on"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.on != null)
      {
        rawNode.attributes["on"] = this.on.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__action_rule__person_to_person__location_mutation");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__item_rule__entry__weight_kg {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__rule_group__item_rule__entry__weight_kg() {
    }

    public world_step__rule_group__item_rule__entry__weight_kg(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__item_rule__entry__weight_kg(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule__entry__weight_kg");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__item_rule__entry__weight_kg");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__item_rule__entry__wearable {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String slot;

    //Children elements

    public world_step__rule_group__item_rule__entry__wearable() {
    }

    public world_step__rule_group__item_rule__entry__wearable(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__item_rule__entry__wearable(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule__entry__wearable");
      //Deserialize arguments
      this.slot = rawNode.attributes["slot"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.slot != null)
      {
        rawNode.attributes["slot"] = this.slot.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__item_rule__entry__wearable");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry__then {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__events_rule__entry__then__select_person> select_person = new List<world_step__rule_group__events_rule__entry__then__select_person>();
    public List<world_step__rule_group__events_rule__entry__then__select_item> select_item = new List<world_step__rule_group__events_rule__entry__then__select_item>();
    public List<world_step__rule_group__events_rule__entry__then__property_mutation> property_mutation = new List<world_step__rule_group__events_rule__entry__then__property_mutation>();

    public world_step__rule_group__events_rule__entry__then() {
    }

    public world_step__rule_group__events_rule__entry__then(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry__then(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then");
      //Deserialize elements
      this.select_person = rawNode.InitializeWithRawNode("select_person", this.select_person);
      this.select_item = rawNode.InitializeWithRawNode("select_item", this.select_item);
      this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry__then");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__locations_markov_chain__location_markov_link__tag {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__rule_group__locations_markov_chain__location_markov_link__tag() {
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__tag(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__tag(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain__location_markov_link__tag");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments

      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__locations_markov_chain__location_markov_link__tag");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__locations_markov_chain__location_markov_link__sibling {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    public System.Int32 quantity;
    /* ignored attribute key={key} of type=world_step__rule_group__locations_markov_chain__location_markov_link__sibling__position*/

    //Children elements

    public world_step__rule_group__locations_markov_chain__location_markov_link__sibling() {
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__sibling(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__sibling(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain__location_markov_link__sibling");
      //Deserialize arguments
      var attribute_quantity = rawNode.attributes["quantity"];
      if(attribute_quantity != null)
      {
        this.quantity = attribute_quantity.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.quantity != null)
      {
        rawNode.attributes["quantity"] = this.quantity.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__locations_markov_chain__location_markov_link__sibling");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__setup__starting_node {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;

    //Children elements

    public world_step__rule_group__location_graph_rule__setup__starting_node() {
    }

    public world_step__rule_group__location_graph_rule__setup__starting_node(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__setup__starting_node(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup__starting_node");
      //Deserialize arguments
      this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__setup__starting_node");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__node_rule__link_group {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.Int32 angle;
    public System.Int32 angleMax;
    public System.Int32 limit;

    //Children elements
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option> to_option = new List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option>();

    public world_step__rule_group__location_graph_rule__node_rule__link_group() {
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group");
      //Deserialize arguments
      this.id = rawNode.attributes["id"];
      var attribute_angle = rawNode.attributes["angle"];
      if(attribute_angle != null)
      {
        this.angle = attribute_angle.ToInt();
      }
      var attribute_angleMax = rawNode.attributes["angleMax"];
      if(attribute_angleMax != null)
      {
        this.angleMax = attribute_angleMax.ToInt();
      }
      var attribute_limit = rawNode.attributes["limit"];
      if(attribute_limit != null)
      {
        this.limit = attribute_limit.ToInt();
      }
      //Deserialize elements
      this.to_option = rawNode.InitializeWithRawNode("to_option", this.to_option);
    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.angle != null)
      {
        rawNode.attributes["angle"] = this.angle.ToString();
      }
      if(this.angleMax != null)
      {
        rawNode.attributes["angleMax"] = this.angleMax.ToString();
      }
      if(this.limit != null)
      {
        rawNode.attributes["limit"] = this.limit.ToString();
      }
      //Serialize elements
      rawNode.children["to_option"] = to_option.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__link_group");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__properties__property {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__people__person__properties__property() {
    }

    public world_step__people__person__properties__property(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__people__person__properties__property(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__properties__property");
      //Deserialize arguments
      this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.property_rule_ref != null)
      {
        rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person__properties__property");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__classifications__classification {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String classification_rule_ref;

    //Children elements

    public world_step__people__person__classifications__classification() {
    }

    public world_step__people__person__classifications__classification(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__people__person__classifications__classification(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__classifications__classification");
      //Deserialize arguments
      this.classification_rule_ref = rawNode.attributes["classification_rule_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.classification_rule_ref != null)
      {
        rawNode.attributes["classification_rule_ref"] = this.classification_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person__classifications__classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__people__person {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;

    //Children elements

    public world_step__location_graph__node__people__person() {
    }

    public world_step__location_graph__node__people__person(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__people__person(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__people__person");
      //Deserialize arguments
      this.person_id_ref = rawNode.attributes["person_id_ref"];
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_graph__node__people__person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry__then__select_person {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__events_rule__entry__then__select_person() {
    }

    public world_step__rule_group__events_rule__entry__then__select_person(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry__then__select_person(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then__select_person");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry__then__select_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry__then__select_item {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__events_rule__entry__then__select_item() {
    }

    public world_step__rule_group__events_rule__entry__then__select_item(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry__then__select_item(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then__select_item");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry__then__select_item");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry__then__property_mutation {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__events_rule__entry__then__property_mutation() {
    }

    public world_step__rule_group__events_rule__entry__then__property_mutation(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry__then__property_mutation(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then__property_mutation");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry__then__property_mutation");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__node_rule__link_group__to_option {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.Int32 distance;
    public System.Int32 maxDistance;
    public System.Int32 adjacent_depth_limit;

    //Children elements

    public world_step__rule_group__location_graph_rule__node_rule__link_group__to_option() {
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group__to_option(RawNode rawNode) {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group__to_option(XmlElement xmlElement) {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group__to_option");
      //Deserialize arguments
      this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      var attribute_distance = rawNode.attributes["distance"];
      if(attribute_distance != null)
      {
        this.distance = attribute_distance.ToInt();
      }
      var attribute_maxDistance = rawNode.attributes["maxDistance"];
      if(attribute_maxDistance != null)
      {
        this.maxDistance = attribute_maxDistance.ToInt();
      }
      var attribute_adjacent_depth_limit = rawNode.attributes["adjacent_depth_limit"];
      if(attribute_adjacent_depth_limit != null)
      {
        this.adjacent_depth_limit = attribute_adjacent_depth_limit.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode() {
      //Serialize arguments
      if(this.node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
      }
      if(this.distance != null)
      {
        rawNode.attributes["distance"] = this.distance.ToString();
      }
      if(this.maxDistance != null)
      {
        rawNode.attributes["maxDistance"] = this.maxDistance.ToString();
      }
      if(this.adjacent_depth_limit != null)
      {
        rawNode.attributes["adjacent_depth_limit"] = this.adjacent_depth_limit.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__link_group__to_option");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
}