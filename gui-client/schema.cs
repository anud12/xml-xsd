using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
namespace XSD {
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step {

    //Children elements
    public List<world_step__world_metadata> Get_world_metadata();
    public void Set_world_metadata(List<world_step__world_metadata> value);
    public List<world_step__rule_group> Get_rule_group();
    public void Set_rule_group(List<world_step__rule_group> value);
    public List<world_step__items> Get_items();
    public void Set_items(List<world_step__items> value);
    public List<world_step__people> Get_people();
    public void Set_people(List<world_step__people> value);
    public List<world_step__location_layer> Get_location_layer();
    public void Set_location_layer(List<world_step__location_layer> value);
    public List<world_step__location_graph> Get_location_graph();
    public void Set_location_graph(List<world_step__location_graph> value);
    public List<world_step__actions> Get_actions();
    public void Set_actions(List<world_step__actions> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step: Iworld_step {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__world_metadata> world_metadata = new List<world_step__world_metadata>();
    public List<world_step__world_metadata> Get_world_metadata()
    {
      return this.world_metadata;
    }
    public void Set_world_metadata(List<world_step__world_metadata> value)
    {
      this.world_metadata = value;
    }
    public List<world_step__rule_group> rule_group = new List<world_step__rule_group>();
    public List<world_step__rule_group> Get_rule_group()
    {
      return this.rule_group;
    }
    public void Set_rule_group(List<world_step__rule_group> value)
    {
      this.rule_group = value;
    }
    public List<world_step__items> items = new List<world_step__items>();
    public List<world_step__items> Get_items()
    {
      return this.items;
    }
    public void Set_items(List<world_step__items> value)
    {
      this.items = value;
    }
    public List<world_step__people> people = new List<world_step__people>();
    public List<world_step__people> Get_people()
    {
      return this.people;
    }
    public void Set_people(List<world_step__people> value)
    {
      this.people = value;
    }
    public List<world_step__location_layer> location_layer = new List<world_step__location_layer>();
    public List<world_step__location_layer> Get_location_layer()
    {
      return this.location_layer;
    }
    public void Set_location_layer(List<world_step__location_layer> value)
    {
      this.location_layer = value;
    }
    public List<world_step__location_graph> location_graph = new List<world_step__location_graph>();
    public List<world_step__location_graph> Get_location_graph()
    {
      return this.location_graph;
    }
    public void Set_location_graph(List<world_step__location_graph> value)
    {
      this.location_graph = value;
    }
    public List<world_step__actions> actions = new List<world_step__actions>();
    public List<world_step__actions> Get_actions()
    {
      return this.actions;
    }
    public void Set_actions(List<world_step__actions> value)
    {
      this.actions = value;
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

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__world_metadata {

    //Children elements
    public List<world_step__world_metadata__previous_world_step> Get_previous_world_step();
    public void Set_previous_world_step(List<world_step__world_metadata__previous_world_step> value);
    public List<world_step__world_metadata__next_world_step> Get_next_world_step();
    public void Set_next_world_step(List<world_step__world_metadata__next_world_step> value);
    public List<world_step__world_metadata__elapsed_time> Get_elapsed_time();
    public void Set_elapsed_time(List<world_step__world_metadata__elapsed_time> value);
    public List<world_step__world_metadata__stepDuration> Get_stepDuration();
    public void Set_stepDuration(List<world_step__world_metadata__stepDuration> value);
    public List<world_step__world_metadata__counter> Get_counter();
    public void Set_counter(List<world_step__world_metadata__counter> value);
    public List<world_step__world_metadata__randomization_table> Get_randomization_table();
    public void Set_randomization_table(List<world_step__world_metadata__randomization_table> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata: Iworld_step__world_metadata {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__world_metadata__previous_world_step> previous_world_step = new List<world_step__world_metadata__previous_world_step>();
    public List<world_step__world_metadata__previous_world_step> Get_previous_world_step()
    {
      return this.previous_world_step;
    }
    public void Set_previous_world_step(List<world_step__world_metadata__previous_world_step> value)
    {
      this.previous_world_step = value;
    }
    public List<world_step__world_metadata__next_world_step> next_world_step = new List<world_step__world_metadata__next_world_step>();
    public List<world_step__world_metadata__next_world_step> Get_next_world_step()
    {
      return this.next_world_step;
    }
    public void Set_next_world_step(List<world_step__world_metadata__next_world_step> value)
    {
      this.next_world_step = value;
    }
    public List<world_step__world_metadata__elapsed_time> elapsed_time = new List<world_step__world_metadata__elapsed_time>();
    public List<world_step__world_metadata__elapsed_time> Get_elapsed_time()
    {
      return this.elapsed_time;
    }
    public void Set_elapsed_time(List<world_step__world_metadata__elapsed_time> value)
    {
      this.elapsed_time = value;
    }
    public List<world_step__world_metadata__stepDuration> stepDuration = new List<world_step__world_metadata__stepDuration>();
    public List<world_step__world_metadata__stepDuration> Get_stepDuration()
    {
      return this.stepDuration;
    }
    public void Set_stepDuration(List<world_step__world_metadata__stepDuration> value)
    {
      this.stepDuration = value;
    }
    public List<world_step__world_metadata__counter> counter = new List<world_step__world_metadata__counter>();
    public List<world_step__world_metadata__counter> Get_counter()
    {
      return this.counter;
    }
    public void Set_counter(List<world_step__world_metadata__counter> value)
    {
      this.counter = value;
    }
    public List<world_step__world_metadata__randomization_table> randomization_table = new List<world_step__world_metadata__randomization_table>();
    public List<world_step__world_metadata__randomization_table> Get_randomization_table()
    {
      return this.randomization_table;
    }
    public void Set_randomization_table(List<world_step__world_metadata__randomization_table> value)
    {
      this.randomization_table = value;
    }

    public world_step__world_metadata()
    {
    }

    public world_step__world_metadata(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__world_metadata(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
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

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__rule_group__property_rule> Get_property_rule();
    public void Set_property_rule(List<world_step__rule_group__property_rule> value);
    public List<world_step__rule_group__classification_rule> Get_classification_rule();
    public void Set_classification_rule(List<world_step__rule_group__classification_rule> value);
    public List<world_step__rule_group__name_rule> Get_name_rule();
    public void Set_name_rule(List<world_step__rule_group__name_rule> value);
    public List<world_step__rule_group__race_rule> Get_race_rule();
    public void Set_race_rule(List<world_step__rule_group__race_rule> value);
    public List<world_step__rule_group__action_rule> Get_action_rule();
    public void Set_action_rule(List<world_step__rule_group__action_rule> value);
    public List<world_step__rule_group__item_rule> Get_item_rule();
    public void Set_item_rule(List<world_step__rule_group__item_rule> value);
    public List<world_step__rule_group__events_rule> Get_events_rule();
    public void Set_events_rule(List<world_step__rule_group__events_rule> value);
    public List<world_step__rule_group__locations_markov_chain> Get_locations_markov_chain();
    public void Set_locations_markov_chain(List<world_step__rule_group__locations_markov_chain> value);
    public List<world_step__rule_group__location_graph_rule> Get_location_graph_rule();
    public void Set_location_graph_rule(List<world_step__rule_group__location_graph_rule> value);
    public List<world_step__rule_group__location_classification_rule> Get_location_classification_rule();
    public void Set_location_classification_rule(List<world_step__rule_group__location_classification_rule> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group: Iworld_step__rule_group {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__rule_group__property_rule> property_rule = new List<world_step__rule_group__property_rule>();
    public List<world_step__rule_group__property_rule> Get_property_rule()
    {
      return this.property_rule;
    }
    public void Set_property_rule(List<world_step__rule_group__property_rule> value)
    {
      this.property_rule = value;
    }
    public List<world_step__rule_group__classification_rule> classification_rule = new List<world_step__rule_group__classification_rule>();
    public List<world_step__rule_group__classification_rule> Get_classification_rule()
    {
      return this.classification_rule;
    }
    public void Set_classification_rule(List<world_step__rule_group__classification_rule> value)
    {
      this.classification_rule = value;
    }
    public List<world_step__rule_group__name_rule> name_rule = new List<world_step__rule_group__name_rule>();
    public List<world_step__rule_group__name_rule> Get_name_rule()
    {
      return this.name_rule;
    }
    public void Set_name_rule(List<world_step__rule_group__name_rule> value)
    {
      this.name_rule = value;
    }
    public List<world_step__rule_group__race_rule> race_rule = new List<world_step__rule_group__race_rule>();
    public List<world_step__rule_group__race_rule> Get_race_rule()
    {
      return this.race_rule;
    }
    public void Set_race_rule(List<world_step__rule_group__race_rule> value)
    {
      this.race_rule = value;
    }
    public List<world_step__rule_group__action_rule> action_rule = new List<world_step__rule_group__action_rule>();
    public List<world_step__rule_group__action_rule> Get_action_rule()
    {
      return this.action_rule;
    }
    public void Set_action_rule(List<world_step__rule_group__action_rule> value)
    {
      this.action_rule = value;
    }
    public List<world_step__rule_group__item_rule> item_rule = new List<world_step__rule_group__item_rule>();
    public List<world_step__rule_group__item_rule> Get_item_rule()
    {
      return this.item_rule;
    }
    public void Set_item_rule(List<world_step__rule_group__item_rule> value)
    {
      this.item_rule = value;
    }
    public List<world_step__rule_group__events_rule> events_rule = new List<world_step__rule_group__events_rule>();
    public List<world_step__rule_group__events_rule> Get_events_rule()
    {
      return this.events_rule;
    }
    public void Set_events_rule(List<world_step__rule_group__events_rule> value)
    {
      this.events_rule = value;
    }
    public List<world_step__rule_group__locations_markov_chain> locations_markov_chain = new List<world_step__rule_group__locations_markov_chain>();
    public List<world_step__rule_group__locations_markov_chain> Get_locations_markov_chain()
    {
      return this.locations_markov_chain;
    }
    public void Set_locations_markov_chain(List<world_step__rule_group__locations_markov_chain> value)
    {
      this.locations_markov_chain = value;
    }
    public List<world_step__rule_group__location_graph_rule> location_graph_rule = new List<world_step__rule_group__location_graph_rule>();
    public List<world_step__rule_group__location_graph_rule> Get_location_graph_rule()
    {
      return this.location_graph_rule;
    }
    public void Set_location_graph_rule(List<world_step__rule_group__location_graph_rule> value)
    {
      this.location_graph_rule = value;
    }
    public List<world_step__rule_group__location_classification_rule> location_classification_rule = new List<world_step__rule_group__location_classification_rule>();
    public List<world_step__rule_group__location_classification_rule> Get_location_classification_rule()
    {
      return this.location_classification_rule;
    }
    public void Set_location_classification_rule(List<world_step__rule_group__location_classification_rule> value)
    {
      this.location_classification_rule = value;
    }

    public world_step__rule_group()
    {
    }

    public world_step__rule_group(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
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
      this.location_classification_rule = rawNode.InitializeWithRawNode("location_classification_rule", this.location_classification_rule);
    }

    public RawNode SerializeIntoRawNode()
    {
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
      rawNode.children["location_classification_rule"] = location_classification_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__items {

    //Children elements
    public List<type__item> Get_item();
    public void Set_item(List<type__item> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__items: Iworld_step__items {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<type__item> item = new List<type__item>();
    public List<type__item> Get_item()
    {
      return this.item;
    }
    public void Set_item(List<type__item> value)
    {
      this.item = value;
    }

    public world_step__items()
    {
    }

    public world_step__items(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__items(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__items");
      //Deserialize elements
      this.item = rawNode.InitializeWithRawNode("item", this.item);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["item"] = item.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__items");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__people {

    //Children elements
    public List<world_step__people__person> Get_person();
    public void Set_person(List<world_step__people__person> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__people: Iworld_step__people {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__people__person> person = new List<world_step__people__person>();
    public List<world_step__people__person> Get_person()
    {
      return this.person;
    }
    public void Set_person(List<world_step__people__person> value)
    {
      this.person = value;
    }

    public world_step__people()
    {
    }

    public world_step__people(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__people(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people");
      //Deserialize elements
      this.person = rawNode.InitializeWithRawNode("person", this.person);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_layer {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__location_layer__cell> Get_cell();
    public void Set_cell(List<world_step__location_layer__cell> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_layer: Iworld_step__location_layer {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__location_layer__cell> cell = new List<world_step__location_layer__cell>();
    public List<world_step__location_layer__cell> Get_cell()
    {
      return this.cell;
    }
    public void Set_cell(List<world_step__location_layer__cell> value)
    {
      this.cell = value;
    }

    public world_step__location_layer()
    {
    }

    public world_step__location_layer(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_layer(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_layer");
      //Deserialize arguments

      //Deserialize elements
      this.cell = rawNode.InitializeWithRawNode("cell", this.cell);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_graph {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);

    //Children elements
    public List<world_step__location_graph__rule> Get_rule();
    public void Set_rule(List<world_step__location_graph__rule> value);
    public List<world_step__location_graph__node> Get_node();
    public void Set_node(List<world_step__location_graph__node> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph: Iworld_step__location_graph {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }

    //Children elements
    public List<world_step__location_graph__rule> rule = new List<world_step__location_graph__rule>();
    public List<world_step__location_graph__rule> Get_rule()
    {
      return this.rule;
    }
    public void Set_rule(List<world_step__location_graph__rule> value)
    {
      this.rule = value;
    }
    public List<world_step__location_graph__node> node = new List<world_step__location_graph__node>();
    public List<world_step__location_graph__node> Get_node()
    {
      return this.node;
    }
    public void Set_node(List<world_step__location_graph__node> value)
    {
      this.node = value;
    }

    public world_step__location_graph()
    {
    }

    public world_step__location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      //Deserialize elements
      this.rule = rawNode.InitializeWithRawNode("rule", this.rule);
      this.node = rawNode.InitializeWithRawNode("node", this.node);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions {

    //Children elements
    public List<world_step__actions__by> Get_by();
    public void Set_by(List<world_step__actions__by> value);
    public List<world_step__actions__location_graph__create> Get_location_graph__create();
    public void Set_location_graph__create(List<world_step__actions__location_graph__create> value);
    public List<world_step__actions__location_graph__node__create_adjacent> Get_location_graph__node__create_adjacent();
    public void Set_location_graph__node__create_adjacent(List<world_step__actions__location_graph__node__create_adjacent> value);
    public List<world_step__actions__location_graph__node__add_classification> Get_location_graph__node__add_classification();
    public void Set_location_graph__node__add_classification(List<world_step__actions__location_graph__node__add_classification> value);
    public List<world_step__actions__person__teleport> Get_person__teleport();
    public void Set_person__teleport(List<world_step__actions__person__teleport> value);
    public List<world_step__actions__person__on_person__property_mutation> Get_person__on_person__property_mutation();
    public void Set_person__on_person__property_mutation(List<world_step__actions__person__on_person__property_mutation> value);
    public List<world_step__actions__person__create> Get_person__create();
    public void Set_person__create(List<world_step__actions__person__create> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions: Iworld_step__actions {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__actions__by> by = new List<world_step__actions__by>();
    public List<world_step__actions__by> Get_by()
    {
      return this.by;
    }
    public void Set_by(List<world_step__actions__by> value)
    {
      this.by = value;
    }
    public List<world_step__actions__location_graph__create> location_graph__create = new List<world_step__actions__location_graph__create>();
    public List<world_step__actions__location_graph__create> Get_location_graph__create()
    {
      return this.location_graph__create;
    }
    public void Set_location_graph__create(List<world_step__actions__location_graph__create> value)
    {
      this.location_graph__create = value;
    }
    public List<world_step__actions__location_graph__node__create_adjacent> location_graph__node__create_adjacent = new List<world_step__actions__location_graph__node__create_adjacent>();
    public List<world_step__actions__location_graph__node__create_adjacent> Get_location_graph__node__create_adjacent()
    {
      return this.location_graph__node__create_adjacent;
    }
    public void Set_location_graph__node__create_adjacent(List<world_step__actions__location_graph__node__create_adjacent> value)
    {
      this.location_graph__node__create_adjacent = value;
    }
    public List<world_step__actions__location_graph__node__add_classification> location_graph__node__add_classification = new List<world_step__actions__location_graph__node__add_classification>();
    public List<world_step__actions__location_graph__node__add_classification> Get_location_graph__node__add_classification()
    {
      return this.location_graph__node__add_classification;
    }
    public void Set_location_graph__node__add_classification(List<world_step__actions__location_graph__node__add_classification> value)
    {
      this.location_graph__node__add_classification = value;
    }
    public List<world_step__actions__person__teleport> person__teleport = new List<world_step__actions__person__teleport>();
    public List<world_step__actions__person__teleport> Get_person__teleport()
    {
      return this.person__teleport;
    }
    public void Set_person__teleport(List<world_step__actions__person__teleport> value)
    {
      this.person__teleport = value;
    }
    public List<world_step__actions__person__on_person__property_mutation> person__on_person__property_mutation = new List<world_step__actions__person__on_person__property_mutation>();
    public List<world_step__actions__person__on_person__property_mutation> Get_person__on_person__property_mutation()
    {
      return this.person__on_person__property_mutation;
    }
    public void Set_person__on_person__property_mutation(List<world_step__actions__person__on_person__property_mutation> value)
    {
      this.person__on_person__property_mutation = value;
    }
    public List<world_step__actions__person__create> person__create = new List<world_step__actions__person__create>();
    public List<world_step__actions__person__create> Get_person__create()
    {
      return this.person__create;
    }
    public void Set_person__create(List<world_step__actions__person__create> value)
    {
      this.person__create = value;
    }

    public world_step__actions()
    {
    }

    public world_step__actions(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions");
      //Deserialize elements
      this.by = rawNode.InitializeWithRawNode("by", this.by);
      this.location_graph__create = rawNode.InitializeWithRawNode("location_graph.create", this.location_graph__create);
      this.location_graph__node__create_adjacent = rawNode.InitializeWithRawNode("location_graph.node.create_adjacent", this.location_graph__node__create_adjacent);
      this.location_graph__node__add_classification = rawNode.InitializeWithRawNode("location_graph.node.add_classification", this.location_graph__node__add_classification);
      this.person__teleport = rawNode.InitializeWithRawNode("person.teleport", this.person__teleport);
      this.person__on_person__property_mutation = rawNode.InitializeWithRawNode("person.on_person.property_mutation", this.person__on_person__property_mutation);
      this.person__create = rawNode.InitializeWithRawNode("person.create", this.person__create);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["by"] = by.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.create"] = location_graph__create.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.node.create_adjacent"] = location_graph__node__create_adjacent.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.node.add_classification"] = location_graph__node__add_classification.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person.teleport"] = person__teleport.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person.on_person.property_mutation"] = person__on_person__property_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person.create"] = person__create.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__world_metadata__previous_world_step {
    //Attributes
    public System.String Get_value();
    public void Set_value(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__previous_world_step: Iworld_step__world_metadata__previous_world_step {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String value;
    public System.String Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String value)
    {
      this.value = value;
    }

    //Children elements

    public world_step__world_metadata__previous_world_step()
    {
    }

    public world_step__world_metadata__previous_world_step(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__previous_world_step(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__previous_world_step");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = rawNode.attributes["value"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__world_metadata__next_world_step {
    //Attributes
    public System.String Get_value();
    public void Set_value(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__next_world_step: Iworld_step__world_metadata__next_world_step {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String value;
    public System.String Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String value)
    {
      this.value = value;
    }

    //Children elements

    public world_step__world_metadata__next_world_step()
    {
    }

    public world_step__world_metadata__next_world_step(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__next_world_step(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__next_world_step");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = rawNode.attributes["value"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__world_metadata__elapsed_time {
    //Attributes
    public System.Int32 Get_value();
    public void Set_value(System.Int32 value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__elapsed_time: Iworld_step__world_metadata__elapsed_time {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 value;
    public System.Int32 Get_value()
    {
      return this.value;
    }
    public void Set_value(System.Int32 value)
    {
      this.value = value;
    }

    //Children elements

    public world_step__world_metadata__elapsed_time()
    {
    }

    public world_step__world_metadata__elapsed_time(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__elapsed_time(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__elapsed_time");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = attribute_value.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__world_metadata__stepDuration {
    //Attributes
    public System.Int32 Get_value();
    public void Set_value(System.Int32 value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__stepDuration: Iworld_step__world_metadata__stepDuration {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 value;
    public System.Int32 Get_value()
    {
      return this.value;
    }
    public void Set_value(System.Int32 value)
    {
      this.value = value;
    }

    //Children elements

    public world_step__world_metadata__stepDuration()
    {
    }

    public world_step__world_metadata__stepDuration(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__stepDuration(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__stepDuration");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = attribute_value.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__world_metadata__counter {
    //Attributes
    public System.Int32 Get_value();
    public void Set_value(System.Int32 value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__counter: Iworld_step__world_metadata__counter {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 value;
    public System.Int32 Get_value()
    {
      return this.value;
    }
    public void Set_value(System.Int32 value)
    {
      this.value = value;
    }

    //Children elements

    public world_step__world_metadata__counter()
    {
    }

    public world_step__world_metadata__counter(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__counter(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__counter");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = attribute_value.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__world_metadata__randomization_table {

    //Children elements
    public List<world_step__world_metadata__randomization_table__entry> Get_entry();
    public void Set_entry(List<world_step__world_metadata__randomization_table__entry> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__randomization_table: Iworld_step__world_metadata__randomization_table {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__world_metadata__randomization_table__entry> entry = new List<world_step__world_metadata__randomization_table__entry>();
    public List<world_step__world_metadata__randomization_table__entry> Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<world_step__world_metadata__randomization_table__entry> value)
    {
      this.entry = value;
    }

    public world_step__world_metadata__randomization_table()
    {
    }

    public world_step__world_metadata__randomization_table(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__randomization_table(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__randomization_table");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__property_rule {

    //Children elements
    public List<world_step__rule_group__property_rule__entry> Get_entry();
    public void Set_entry(List<world_step__rule_group__property_rule__entry> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule: Iworld_step__rule_group__property_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__property_rule__entry> entry = new List<world_step__rule_group__property_rule__entry>();
    public List<world_step__rule_group__property_rule__entry> Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__property_rule__entry> value)
    {
      this.entry = value;
    }

    public world_step__rule_group__property_rule()
    {
    }

    public world_step__rule_group__property_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__classification_rule {

    //Children elements
    public List<world_step__rule_group__classification_rule__entry> Get_entry();
    public void Set_entry(List<world_step__rule_group__classification_rule__entry> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__classification_rule: Iworld_step__rule_group__classification_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__classification_rule__entry> entry = new List<world_step__rule_group__classification_rule__entry>();
    public List<world_step__rule_group__classification_rule__entry> Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__classification_rule__entry> value)
    {
      this.entry = value;
    }

    public world_step__rule_group__classification_rule()
    {
    }

    public world_step__rule_group__classification_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__classification_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__classification_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__name_rule {

    //Children elements
    public List<group__name_token> Get_entry();
    public void Set_entry(List<group__name_token> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__name_rule: Iworld_step__rule_group__name_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<group__name_token> entry = new List<group__name_token>();
    public List<group__name_token> Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<group__name_token> value)
    {
      this.entry = value;
    }

    public world_step__rule_group__name_rule()
    {
    }

    public world_step__rule_group__name_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__name_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__name_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__name_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__race_rule {

    //Children elements
    public List<world_step__rule_group__race_rule__entry> Get_entry();
    public void Set_entry(List<world_step__rule_group__race_rule__entry> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__race_rule: Iworld_step__rule_group__race_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__race_rule__entry> entry = new List<world_step__rule_group__race_rule__entry>();
    public List<world_step__rule_group__race_rule__entry> Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__race_rule__entry> value)
    {
      this.entry = value;
    }

    public world_step__rule_group__race_rule()
    {
    }

    public world_step__rule_group__race_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__race_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__race_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__action_rule {

    //Children elements
    public List<world_step__rule_group__action_rule__global> Get_global();
    public void Set_global(List<world_step__rule_group__action_rule__global> value);
    public List<world_step__rule_group__action_rule__person_to_person> Get_person_to_person();
    public void Set_person_to_person(List<world_step__rule_group__action_rule__person_to_person> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule: Iworld_step__rule_group__action_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__action_rule__global> global = new List<world_step__rule_group__action_rule__global>();
    public List<world_step__rule_group__action_rule__global> Get_global()
    {
      return this.global;
    }
    public void Set_global(List<world_step__rule_group__action_rule__global> value)
    {
      this.global = value;
    }
    public List<world_step__rule_group__action_rule__person_to_person> person_to_person = new List<world_step__rule_group__action_rule__person_to_person>();
    public List<world_step__rule_group__action_rule__person_to_person> Get_person_to_person()
    {
      return this.person_to_person;
    }
    public void Set_person_to_person(List<world_step__rule_group__action_rule__person_to_person> value)
    {
      this.person_to_person = value;
    }

    public world_step__rule_group__action_rule()
    {
    }

    public world_step__rule_group__action_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule");
      //Deserialize elements
      this.global = rawNode.InitializeWithRawNode("global", this.global);
      this.person_to_person = rawNode.InitializeWithRawNode("person_to_person", this.person_to_person);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__item_rule {

    //Children elements
    public List<world_step__rule_group__item_rule__entry> Get_entry();
    public void Set_entry(List<world_step__rule_group__item_rule__entry> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__item_rule: Iworld_step__rule_group__item_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__item_rule__entry> entry = new List<world_step__rule_group__item_rule__entry>();
    public List<world_step__rule_group__item_rule__entry> Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__item_rule__entry> value)
    {
      this.entry = value;
    }

    public world_step__rule_group__item_rule()
    {
    }

    public world_step__rule_group__item_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__item_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__events_rule {

    //Children elements
    public List<world_step__rule_group__events_rule__entry> Get_entry();
    public void Set_entry(List<world_step__rule_group__events_rule__entry> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule: Iworld_step__rule_group__events_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__events_rule__entry> entry = new List<world_step__rule_group__events_rule__entry>();
    public List<world_step__rule_group__events_rule__entry> Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__events_rule__entry> value)
    {
      this.entry = value;
    }

    public world_step__rule_group__events_rule()
    {
    }

    public world_step__rule_group__events_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__locations_markov_chain {

    //Children elements
    public List<world_step__rule_group__locations_markov_chain__location_markov_link> Get_location_markov_link();
    public void Set_location_markov_link(List<world_step__rule_group__locations_markov_chain__location_markov_link> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__locations_markov_chain: Iworld_step__rule_group__locations_markov_chain {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__locations_markov_chain__location_markov_link> location_markov_link = new List<world_step__rule_group__locations_markov_chain__location_markov_link>();
    public List<world_step__rule_group__locations_markov_chain__location_markov_link> Get_location_markov_link()
    {
      return this.location_markov_link;
    }
    public void Set_location_markov_link(List<world_step__rule_group__locations_markov_chain__location_markov_link> value)
    {
      this.location_markov_link = value;
    }

    public world_step__rule_group__locations_markov_chain()
    {
    }

    public world_step__rule_group__locations_markov_chain(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__locations_markov_chain(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain");
      //Deserialize elements
      this.location_markov_link = rawNode.InitializeWithRawNode("location_markov_link", this.location_markov_link);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_graph_rule {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);

    //Children elements
    public List<world_step__rule_group__location_graph_rule__setup> Get_setup();
    public void Set_setup(List<world_step__rule_group__location_graph_rule__setup> value);
    public List<world_step__rule_group__location_graph_rule__node_rule> Get_node_rule();
    public void Set_node_rule(List<world_step__rule_group__location_graph_rule__node_rule> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule: Iworld_step__rule_group__location_graph_rule {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }

    //Children elements
    public List<world_step__rule_group__location_graph_rule__setup> setup = new List<world_step__rule_group__location_graph_rule__setup>();
    public List<world_step__rule_group__location_graph_rule__setup> Get_setup()
    {
      return this.setup;
    }
    public void Set_setup(List<world_step__rule_group__location_graph_rule__setup> value)
    {
      this.setup = value;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule> node_rule = new List<world_step__rule_group__location_graph_rule__node_rule>();
    public List<world_step__rule_group__location_graph_rule__node_rule> Get_node_rule()
    {
      return this.node_rule;
    }
    public void Set_node_rule(List<world_step__rule_group__location_graph_rule__node_rule> value)
    {
      this.node_rule = value;
    }

    public world_step__rule_group__location_graph_rule()
    {
    }

    public world_step__rule_group__location_graph_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      //Deserialize elements
      this.setup = rawNode.InitializeWithRawNode("setup", this.setup);
      this.node_rule = rawNode.InitializeWithRawNode("node_rule", this.node_rule);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_classification_rule {

    //Children elements
    public List<world_step__rule_group__location_classification_rule__entry> Get_entry();
    public void Set_entry(List<world_step__rule_group__location_classification_rule__entry> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_classification_rule: Iworld_step__rule_group__location_classification_rule {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__location_classification_rule__entry> entry = new List<world_step__rule_group__location_classification_rule__entry>();
    public List<world_step__rule_group__location_classification_rule__entry> Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__location_classification_rule__entry> value)
    {
      this.entry = value;
    }

    public world_step__rule_group__location_classification_rule()
    {
    }

    public world_step__rule_group__location_classification_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_classification_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_classification_rule");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_classification_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__item {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__item: Itype__item {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    public type__item()
    {
    }

    public type__item(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__item(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__item");
      //Deserialize arguments
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__item");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__people__person {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);
    public System.String Get_name();
    public void Set_name(System.String value);

    //Children elements
    public List<world_step__people__person__race> Get_race();
    public void Set_race(List<world_step__people__person__race> value);
    public List<type_cell_ref> Get_location();
    public void Set_location(List<type_cell_ref> value);
    public List<world_step__people__person__properties> Get_properties();
    public void Set_properties(List<world_step__people__person__properties> value);
    public List<world_step__people__person__relations> Get_relations();
    public void Set_relations(List<world_step__people__person__relations> value);
    public List<world_step__people__person__inventory> Get_inventory();
    public void Set_inventory(List<world_step__people__person__inventory> value);
    public List<world_step__people__person__classifications> Get_classifications();
    public void Set_classifications(List<world_step__people__person__classifications> value);
    public List<type_icon> Get_icon();
    public void Set_icon(List<type_icon> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__people__person: Iworld_step__people__person {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public System.String name;
    public System.String Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String value)
    {
      this.name = value;
    }

    //Children elements
    public List<world_step__people__person__race> race = new List<world_step__people__person__race>();
    public List<world_step__people__person__race> Get_race()
    {
      return this.race;
    }
    public void Set_race(List<world_step__people__person__race> value)
    {
      this.race = value;
    }
    public List<type_cell_ref> location = new List<type_cell_ref>();
    public List<type_cell_ref> Get_location()
    {
      return this.location;
    }
    public void Set_location(List<type_cell_ref> value)
    {
      this.location = value;
    }
    public List<world_step__people__person__properties> properties = new List<world_step__people__person__properties>();
    public List<world_step__people__person__properties> Get_properties()
    {
      return this.properties;
    }
    public void Set_properties(List<world_step__people__person__properties> value)
    {
      this.properties = value;
    }
    public List<world_step__people__person__relations> relations = new List<world_step__people__person__relations>();
    public List<world_step__people__person__relations> Get_relations()
    {
      return this.relations;
    }
    public void Set_relations(List<world_step__people__person__relations> value)
    {
      this.relations = value;
    }
    public List<world_step__people__person__inventory> inventory = new List<world_step__people__person__inventory>();
    public List<world_step__people__person__inventory> Get_inventory()
    {
      return this.inventory;
    }
    public void Set_inventory(List<world_step__people__person__inventory> value)
    {
      this.inventory = value;
    }
    public List<world_step__people__person__classifications> classifications = new List<world_step__people__person__classifications>();
    public List<world_step__people__person__classifications> Get_classifications()
    {
      return this.classifications;
    }
    public void Set_classifications(List<world_step__people__person__classifications> value)
    {
      this.classifications = value;
    }
    public List<type_icon> icon = new List<type_icon>();
    public List<type_icon> Get_icon()
    {
      return this.icon;
    }
    public void Set_icon(List<type_icon> value)
    {
      this.icon = value;
    }

    public world_step__people__person()
    {
    }

    public world_step__people__person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__people__person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("name"))
      {
        var attribute_name = rawNode.attributes["name"];
        this.name = rawNode.attributes["name"];
      }
      //Deserialize elements
      this.race = rawNode.InitializeWithRawNode("race", this.race);
      this.location = rawNode.InitializeWithRawNode("location", this.location);
      this.properties = rawNode.InitializeWithRawNode("properties", this.properties);
      this.relations = rawNode.InitializeWithRawNode("relations", this.relations);
      this.inventory = rawNode.InitializeWithRawNode("inventory", this.inventory);
      this.classifications = rawNode.InitializeWithRawNode("classifications", this.classifications);
      this.icon = rawNode.InitializeWithRawNode("icon", this.icon);
    }

    public RawNode SerializeIntoRawNode()
    {
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
      rawNode.children["location"] = location.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["properties"] = properties.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["relations"] = relations.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["inventory"] = inventory.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["classifications"] = classifications.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["icon"] = icon.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_layer__cell {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_layer__cell: Iworld_step__location_layer__cell {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__location_layer__cell()
    {
    }

    public world_step__location_layer__cell(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_layer__cell(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_layer__cell");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_graph__rule {
    //Attributes
    public System.String Get_location_graph_rule_ref();
    public void Set_location_graph_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__rule: Iworld_step__location_graph__rule {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_rule_ref;
    public System.String Get_location_graph_rule_ref()
    {
      return this.location_graph_rule_ref;
    }
    public void Set_location_graph_rule_ref(System.String value)
    {
      this.location_graph_rule_ref = value;
    }

    //Children elements

    public world_step__location_graph__rule()
    {
    }

    public world_step__location_graph__rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_graph__rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_rule_ref"))
      {
        var attribute_location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
        this.location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_graph__node {
    //Attributes
    public System.String Get_node_rule_ref();
    public void Set_node_rule_ref(System.String value);
    public System.String Get_id();
    public void Set_id(System.String value);

    //Children elements
    public List<world_step__location_graph__node__position> Get_position();
    public void Set_position(List<world_step__location_graph__node__position> value);
    public List<world_step__location_graph__node__classifications> Get_classifications();
    public void Set_classifications(List<world_step__location_graph__node__classifications> value);
    public List<world_step__location_graph__node__link_to> Get_link_to();
    public void Set_link_to(List<world_step__location_graph__node__link_to> value);
    public List<world_step__location_graph__node__people> Get_people();
    public void Set_people(List<world_step__location_graph__node__people> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node: Iworld_step__location_graph__node {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }

    //Children elements
    public List<world_step__location_graph__node__position> position = new List<world_step__location_graph__node__position>();
    public List<world_step__location_graph__node__position> Get_position()
    {
      return this.position;
    }
    public void Set_position(List<world_step__location_graph__node__position> value)
    {
      this.position = value;
    }
    public List<world_step__location_graph__node__classifications> classifications = new List<world_step__location_graph__node__classifications>();
    public List<world_step__location_graph__node__classifications> Get_classifications()
    {
      return this.classifications;
    }
    public void Set_classifications(List<world_step__location_graph__node__classifications> value)
    {
      this.classifications = value;
    }
    public List<world_step__location_graph__node__link_to> link_to = new List<world_step__location_graph__node__link_to>();
    public List<world_step__location_graph__node__link_to> Get_link_to()
    {
      return this.link_to;
    }
    public void Set_link_to(List<world_step__location_graph__node__link_to> value)
    {
      this.link_to = value;
    }
    public List<world_step__location_graph__node__people> people = new List<world_step__location_graph__node__people>();
    public List<world_step__location_graph__node__people> Get_people()
    {
      return this.people;
    }
    public void Set_people(List<world_step__location_graph__node__people> value)
    {
      this.people = value;
    }

    public world_step__location_graph__node()
    {
    }

    public world_step__location_graph__node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_rule_ref"))
      {
        var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
        this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      //Deserialize elements
      this.position = rawNode.InitializeWithRawNode("position", this.position);
      this.classifications = rawNode.InitializeWithRawNode("classifications", this.classifications);
      this.link_to = rawNode.InitializeWithRawNode("link_to", this.link_to);
      this.people = rawNode.InitializeWithRawNode("people", this.people);
    }

    public RawNode SerializeIntoRawNode()
    {
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
      rawNode.children["classifications"] = classifications.Select(x => x.SerializeIntoRawNode()).ToList();
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__by {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__actions__by__do> Get__do();
    public void Set__do(List<world_step__actions__by__do> value);
    public List<world_step__actions__by__move_towards> Get_move_towards();
    public void Set_move_towards(List<world_step__actions__by__move_towards> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__by: Iworld_step__actions__by {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__actions__by__do> _do = new List<world_step__actions__by__do>();
    public List<world_step__actions__by__do> Get__do()
    {
      return this._do;
    }
    public void Set__do(List<world_step__actions__by__do> value)
    {
      this._do = value;
    }
    public List<world_step__actions__by__move_towards> move_towards = new List<world_step__actions__by__move_towards>();
    public List<world_step__actions__by__move_towards> Get_move_towards()
    {
      return this.move_towards;
    }
    public void Set_move_towards(List<world_step__actions__by__move_towards> value)
    {
      this.move_towards = value;
    }

    public world_step__actions__by()
    {
    }

    public world_step__actions__by(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__by(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__by");
      //Deserialize arguments

      //Deserialize elements
      this._do = rawNode.InitializeWithRawNode("do", this._do);
      this.move_towards = rawNode.InitializeWithRawNode("move_towards", this.move_towards);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__location_graph__create {
    //Attributes
    public System.String Get_location_graph_rule_ref();
    public void Set_location_graph_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__location_graph__create: Iworld_step__actions__location_graph__create {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_rule_ref;
    public System.String Get_location_graph_rule_ref()
    {
      return this.location_graph_rule_ref;
    }
    public void Set_location_graph_rule_ref(System.String value)
    {
      this.location_graph_rule_ref = value;
    }

    //Children elements

    public world_step__actions__location_graph__create()
    {
    }

    public world_step__actions__location_graph__create(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__location_graph__create(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__location_graph__create");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_rule_ref"))
      {
        var attribute_location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
        this.location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__location_graph__node__create_adjacent {
    //Attributes
    public System.String Get_location_graph_id_ref();
    public void Set_location_graph_id_ref(System.String value);
    public System.String Get_node_id_ref();
    public void Set_node_id_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__location_graph__node__create_adjacent: Iworld_step__actions__location_graph__node__create_adjacent {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_id_ref;
    public System.String Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String value)
    {
      this.location_graph_id_ref = value;
    }
    public System.String node_id_ref;
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }

    //Children elements

    public world_step__actions__location_graph__node__create_adjacent()
    {
    }

    public world_step__actions__location_graph__node__create_adjacent(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__location_graph__node__create_adjacent(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__location_graph__node__create_adjacent");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_id_ref"))
      {
        var attribute_location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
        this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("node_id_ref"))
      {
        var attribute_node_id_ref = rawNode.attributes["node_id_ref"];
        this.node_id_ref = rawNode.attributes["node_id_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__location_graph__node__add_classification {

    //Children elements
    public List<type__node_graph__selection> Get_node_graph_selection();
    public void Set_node_graph_selection(List<type__node_graph__selection> value);
    public List<world_step__actions__location_graph__node__add_classification__to_be_added__classification> Get_to_be_added__classification();
    public void Set_to_be_added__classification(List<world_step__actions__location_graph__node__add_classification__to_be_added__classification> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__location_graph__node__add_classification: Iworld_step__actions__location_graph__node__add_classification {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<type__node_graph__selection> node_graph_selection = new List<type__node_graph__selection>();
    public List<type__node_graph__selection> Get_node_graph_selection()
    {
      return this.node_graph_selection;
    }
    public void Set_node_graph_selection(List<type__node_graph__selection> value)
    {
      this.node_graph_selection = value;
    }
    public List<world_step__actions__location_graph__node__add_classification__to_be_added__classification> to_be_added__classification = new List<world_step__actions__location_graph__node__add_classification__to_be_added__classification>();
    public List<world_step__actions__location_graph__node__add_classification__to_be_added__classification> Get_to_be_added__classification()
    {
      return this.to_be_added__classification;
    }
    public void Set_to_be_added__classification(List<world_step__actions__location_graph__node__add_classification__to_be_added__classification> value)
    {
      this.to_be_added__classification = value;
    }

    public world_step__actions__location_graph__node__add_classification()
    {
    }

    public world_step__actions__location_graph__node__add_classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__location_graph__node__add_classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__location_graph__node__add_classification");
      //Deserialize elements
      this.node_graph_selection = rawNode.InitializeWithRawNode("node_graph_selection", this.node_graph_selection);
      this.to_be_added__classification = rawNode.InitializeWithRawNode("to_be_added__classification", this.to_be_added__classification);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["node_graph_selection"] = node_graph_selection.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["to_be_added__classification"] = to_be_added__classification.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__location_graph__node__add_classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__person__teleport {
    //Attributes
    public System.String Get_person_id_ref();
    public void Set_person_id_ref(System.String value);

    //Children elements
    public List<world_step__actions__person__teleport__location_graph> Get_location_graph();
    public void Set_location_graph(List<world_step__actions__person__teleport__location_graph> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__person__teleport: Iworld_step__actions__person__teleport {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }

    //Children elements
    public List<world_step__actions__person__teleport__location_graph> location_graph = new List<world_step__actions__person__teleport__location_graph>();
    public List<world_step__actions__person__teleport__location_graph> Get_location_graph()
    {
      return this.location_graph;
    }
    public void Set_location_graph(List<world_step__actions__person__teleport__location_graph> value)
    {
      this.location_graph = value;
    }

    public world_step__actions__person__teleport()
    {
    }

    public world_step__actions__person__teleport(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__person__teleport(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__person__teleport");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }
      //Deserialize elements
      this.location_graph = rawNode.InitializeWithRawNode("location_graph", this.location_graph);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__person__on_person__property_mutation {
    //Attributes
    public System.String Get_person_id_ref();
    public void Set_person_id_ref(System.String value);
    public System.String Get_target_person_id_ref();
    public void Set_target_person_id_ref(System.String value);
    public System.String Get_action_property_mutation_rule_ref();
    public void Set_action_property_mutation_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__person__on_person__property_mutation: Iworld_step__actions__person__on_person__property_mutation {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public System.String target_person_id_ref;
    public System.String Get_target_person_id_ref()
    {
      return this.target_person_id_ref;
    }
    public void Set_target_person_id_ref(System.String value)
    {
      this.target_person_id_ref = value;
    }
    public System.String action_property_mutation_rule_ref;
    public System.String Get_action_property_mutation_rule_ref()
    {
      return this.action_property_mutation_rule_ref;
    }
    public void Set_action_property_mutation_rule_ref(System.String value)
    {
      this.action_property_mutation_rule_ref = value;
    }

    //Children elements

    public world_step__actions__person__on_person__property_mutation()
    {
    }

    public world_step__actions__person__on_person__property_mutation(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__person__on_person__property_mutation(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__person__on_person__property_mutation");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("target_person_id_ref"))
      {
        var attribute_target_person_id_ref = rawNode.attributes["target_person_id_ref"];
        this.target_person_id_ref = rawNode.attributes["target_person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("action_property_mutation_rule_ref"))
      {
        var attribute_action_property_mutation_rule_ref = rawNode.attributes["action_property_mutation_rule_ref"];
        this.action_property_mutation_rule_ref = rawNode.attributes["action_property_mutation_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__person__create {

    //Children elements
    public List<type__node_graph__selection> Get_node_graph__selection();
    public void Set_node_graph__selection(List<type__node_graph__selection> value);
    public List<type__person_selection> Get_person__selection();
    public void Set_person__selection(List<type__person_selection> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__person__create: Iworld_step__actions__person__create {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<type__node_graph__selection> node_graph__selection = new List<type__node_graph__selection>();
    public List<type__node_graph__selection> Get_node_graph__selection()
    {
      return this.node_graph__selection;
    }
    public void Set_node_graph__selection(List<type__node_graph__selection> value)
    {
      this.node_graph__selection = value;
    }
    public List<type__person_selection> person__selection = new List<type__person_selection>();
    public List<type__person_selection> Get_person__selection()
    {
      return this.person__selection;
    }
    public void Set_person__selection(List<type__person_selection> value)
    {
      this.person__selection = value;
    }

    public world_step__actions__person__create()
    {
    }

    public world_step__actions__person__create(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__person__create(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__person__create");
      //Deserialize elements
      this.node_graph__selection = rawNode.InitializeWithRawNode("node_graph__selection", this.node_graph__selection);
      this.person__selection = rawNode.InitializeWithRawNode("person__selection", this.person__selection);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["node_graph__selection"] = node_graph__selection.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person__selection"] = person__selection.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__person__create");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__world_metadata__randomization_table__entry {
    //Attributes
    public System.Int32 Get_value();
    public void Set_value(System.Int32 value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__world_metadata__randomization_table__entry: Iworld_step__world_metadata__randomization_table__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 value;
    public System.Int32 Get_value()
    {
      return this.value;
    }
    public void Set_value(System.Int32 value)
    {
      this.value = value;
    }

    //Children elements

    public world_step__world_metadata__randomization_table__entry()
    {
    }

    public world_step__world_metadata__randomization_table__entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__world_metadata__randomization_table__entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__world_metadata__randomization_table__entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = attribute_value.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__property_rule__entry {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__rule_group__property_rule__entry__person_default> Get_person_default();
    public void Set_person_default(List<world_step__rule_group__property_rule__entry__person_default> value);
    public List<world_step__rule_group__property_rule__entry__item_default> Get_item_default();
    public void Set_item_default(List<world_step__rule_group__property_rule__entry__item_default> value);
    public List<world_step__rule_group__property_rule__entry__property_threshold> Get_property_threshold();
    public void Set_property_threshold(List<world_step__rule_group__property_rule__entry__property_threshold> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule__entry: Iworld_step__rule_group__property_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__rule_group__property_rule__entry__person_default> person_default = new List<world_step__rule_group__property_rule__entry__person_default>();
    public List<world_step__rule_group__property_rule__entry__person_default> Get_person_default()
    {
      return this.person_default;
    }
    public void Set_person_default(List<world_step__rule_group__property_rule__entry__person_default> value)
    {
      this.person_default = value;
    }
    public List<world_step__rule_group__property_rule__entry__item_default> item_default = new List<world_step__rule_group__property_rule__entry__item_default>();
    public List<world_step__rule_group__property_rule__entry__item_default> Get_item_default()
    {
      return this.item_default;
    }
    public void Set_item_default(List<world_step__rule_group__property_rule__entry__item_default> value)
    {
      this.item_default = value;
    }
    public List<world_step__rule_group__property_rule__entry__property_threshold> property_threshold = new List<world_step__rule_group__property_rule__entry__property_threshold>();
    public List<world_step__rule_group__property_rule__entry__property_threshold> Get_property_threshold()
    {
      return this.property_threshold;
    }
    public void Set_property_threshold(List<world_step__rule_group__property_rule__entry__property_threshold> value)
    {
      this.property_threshold = value;
    }

    public world_step__rule_group__property_rule__entry()
    {
    }

    public world_step__rule_group__property_rule__entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule__entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry");
      //Deserialize arguments

      //Deserialize elements
      this.person_default = rawNode.InitializeWithRawNode("person_default", this.person_default);
      this.item_default = rawNode.InitializeWithRawNode("item_default", this.item_default);
      this.property_threshold = rawNode.InitializeWithRawNode("property-threshold", this.property_threshold);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize elements
      rawNode.children["person_default"] = person_default.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["item_default"] = item_default.Select(x => x.SerializeIntoRawNode()).ToList();
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__classification_rule__entry {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<group__math_operations> Get_property();
    public void Set_property(List<group__math_operations> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__classification_rule__entry: Iworld_step__rule_group__classification_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<group__math_operations> property = new List<group__math_operations>();
    public List<group__math_operations> Get_property()
    {
      return this.property;
    }
    public void Set_property(List<group__math_operations> value)
    {
      this.property = value;
    }

    public world_step__rule_group__classification_rule__entry()
    {
    }

    public world_step__rule_group__classification_rule__entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__classification_rule__entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__classification_rule__entry");
      //Deserialize arguments

      //Deserialize elements
      this.property = rawNode.InitializeWithRawNode("property", this.property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize elements
      rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__classification_rule__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Igroup__name_token {

    //Children elements
    public List<group__name_token__name_token> Get_name_token();
    public void Set_name_token(List<group__name_token__name_token> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class group__name_token: Igroup__name_token {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<group__name_token__name_token> name_token = new List<group__name_token__name_token>();
    public List<group__name_token__name_token> Get_name_token()
    {
      return this.name_token;
    }
    public void Set_name_token(List<group__name_token__name_token> value)
    {
      this.name_token = value;
    }

    public group__name_token()
    {
    }

    public group__name_token(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public group__name_token(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing group__name_token");
      //Deserialize elements
      this.name_token = rawNode.InitializeWithRawNode("name_token", this.name_token);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["name_token"] = name_token.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing group__name_token");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__race_rule__entry {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);

    //Children elements
    public List<type_range> Get_vision();
    public void Set_vision(List<type_range> value);
    public List<type_range> Get_movement();
    public void Set_movement(List<type_range> value);
    public List<world_step__rule_group__race_rule__entry__name> Get_name();
    public void Set_name(List<world_step__rule_group__race_rule__entry__name> value);
    public List<group__math_operations> Get_property_bonus();
    public void Set_property_bonus(List<group__math_operations> value);
    public List<type_icon> Get_icon();
    public void Set_icon(List<type_icon> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__race_rule__entry: Iworld_step__rule_group__race_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }

    //Children elements
    public List<type_range> vision = new List<type_range>();
    public List<type_range> Get_vision()
    {
      return this.vision;
    }
    public void Set_vision(List<type_range> value)
    {
      this.vision = value;
    }
    public List<type_range> movement = new List<type_range>();
    public List<type_range> Get_movement()
    {
      return this.movement;
    }
    public void Set_movement(List<type_range> value)
    {
      this.movement = value;
    }
    public List<world_step__rule_group__race_rule__entry__name> name = new List<world_step__rule_group__race_rule__entry__name>();
    public List<world_step__rule_group__race_rule__entry__name> Get_name()
    {
      return this.name;
    }
    public void Set_name(List<world_step__rule_group__race_rule__entry__name> value)
    {
      this.name = value;
    }
    public List<group__math_operations> property_bonus = new List<group__math_operations>();
    public List<group__math_operations> Get_property_bonus()
    {
      return this.property_bonus;
    }
    public void Set_property_bonus(List<group__math_operations> value)
    {
      this.property_bonus = value;
    }
    public List<type_icon> icon = new List<type_icon>();
    public List<type_icon> Get_icon()
    {
      return this.icon;
    }
    public void Set_icon(List<type_icon> value)
    {
      this.icon = value;
    }

    public world_step__rule_group__race_rule__entry()
    {
    }

    public world_step__rule_group__race_rule__entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__race_rule__entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__race_rule__entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      //Deserialize elements
      this.vision = rawNode.InitializeWithRawNode("vision", this.vision);
      this.movement = rawNode.InitializeWithRawNode("movement", this.movement);
      this.name = rawNode.InitializeWithRawNode("name", this.name);
      this.property_bonus = rawNode.InitializeWithRawNode("property_bonus", this.property_bonus);
      this.icon = rawNode.InitializeWithRawNode("icon", this.icon);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["vision"] = vision.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["movement"] = movement.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["name"] = name.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["property_bonus"] = property_bonus.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["icon"] = icon.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__race_rule__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__action_rule__global {

    //Children elements
    public List<world_step__rule_group__action_rule__global__entry> Get_entry();
    public void Set_entry(List<world_step__rule_group__action_rule__global__entry> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__global: Iworld_step__rule_group__action_rule__global {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__action_rule__global__entry> entry = new List<world_step__rule_group__action_rule__global__entry>();
    public List<world_step__rule_group__action_rule__global__entry> Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__action_rule__global__entry> value)
    {
      this.entry = value;
    }

    public world_step__rule_group__action_rule__global()
    {
    }

    public world_step__rule_group__action_rule__global(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__global(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__global");
      //Deserialize elements
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__action_rule__global");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__action_rule__person_to_person {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);

    //Children elements
    public List<world_step__rule_group__action_rule__person_to_person__test> Get_test();
    public void Set_test(List<world_step__rule_group__action_rule__person_to_person__test> value);
    public List<type__property_mutation_on> Get_property_mutation();
    public void Set_property_mutation(List<type__property_mutation_on> value);
    public List<world_step__rule_group__action_rule__person_to_person__location_mutation> Get_location_mutation();
    public void Set_location_mutation(List<world_step__rule_group__action_rule__person_to_person__location_mutation> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__person_to_person: Iworld_step__rule_group__action_rule__person_to_person {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }

    //Children elements
    public List<world_step__rule_group__action_rule__person_to_person__test> test = new List<world_step__rule_group__action_rule__person_to_person__test>();
    public List<world_step__rule_group__action_rule__person_to_person__test> Get_test()
    {
      return this.test;
    }
    public void Set_test(List<world_step__rule_group__action_rule__person_to_person__test> value)
    {
      this.test = value;
    }
    public List<type__property_mutation_on> property_mutation = new List<type__property_mutation_on>();
    public List<type__property_mutation_on> Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(List<type__property_mutation_on> value)
    {
      this.property_mutation = value;
    }
    public List<world_step__rule_group__action_rule__person_to_person__location_mutation> location_mutation = new List<world_step__rule_group__action_rule__person_to_person__location_mutation>();
    public List<world_step__rule_group__action_rule__person_to_person__location_mutation> Get_location_mutation()
    {
      return this.location_mutation;
    }
    public void Set_location_mutation(List<world_step__rule_group__action_rule__person_to_person__location_mutation> value)
    {
      this.location_mutation = value;
    }

    public world_step__rule_group__action_rule__person_to_person()
    {
    }

    public world_step__rule_group__action_rule__person_to_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__person_to_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      //Deserialize elements
      this.test = rawNode.InitializeWithRawNode("test", this.test);
      this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
      this.location_mutation = rawNode.InitializeWithRawNode("location_mutation", this.location_mutation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["test"] = test.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["property_mutation"] = property_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__item_rule__entry {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<group__name_token> Get_name();
    public void Set_name(List<group__name_token> value);
    public List<world_step__rule_group__item_rule__entry__weight_kg> Get_weight_kg();
    public void Set_weight_kg(List<world_step__rule_group__item_rule__entry__weight_kg> value);
    public List<world_step__rule_group__item_rule__entry__wearable> Get_wearable();
    public void Set_wearable(List<world_step__rule_group__item_rule__entry__wearable> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__item_rule__entry: Iworld_step__rule_group__item_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<group__name_token> name = new List<group__name_token>();
    public List<group__name_token> Get_name()
    {
      return this.name;
    }
    public void Set_name(List<group__name_token> value)
    {
      this.name = value;
    }
    public List<world_step__rule_group__item_rule__entry__weight_kg> weight_kg = new List<world_step__rule_group__item_rule__entry__weight_kg>();
    public List<world_step__rule_group__item_rule__entry__weight_kg> Get_weight_kg()
    {
      return this.weight_kg;
    }
    public void Set_weight_kg(List<world_step__rule_group__item_rule__entry__weight_kg> value)
    {
      this.weight_kg = value;
    }
    public List<world_step__rule_group__item_rule__entry__wearable> wearable = new List<world_step__rule_group__item_rule__entry__wearable>();
    public List<world_step__rule_group__item_rule__entry__wearable> Get_wearable()
    {
      return this.wearable;
    }
    public void Set_wearable(List<world_step__rule_group__item_rule__entry__wearable> value)
    {
      this.wearable = value;
    }

    public world_step__rule_group__item_rule__entry()
    {
    }

    public world_step__rule_group__item_rule__entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__item_rule__entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule__entry");
      //Deserialize arguments

      //Deserialize elements
      this.name = rawNode.InitializeWithRawNode("name", this.name);
      this.weight_kg = rawNode.InitializeWithRawNode("weight-kg", this.weight_kg);
      this.wearable = rawNode.InitializeWithRawNode("wearable", this.wearable);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize elements
      rawNode.children["name"] = name.Select(x => x.SerializeIntoRawNode()).ToList();
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__events_rule__entry {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);

    //Children elements
    public List<type__trigger> Get_when();
    public void Set_when(List<type__trigger> value);
    public List<world_step__rule_group__events_rule__entry__then> Get_then();
    public void Set_then(List<world_step__rule_group__events_rule__entry__then> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry: Iworld_step__rule_group__events_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }

    //Children elements
    public List<type__trigger> when = new List<type__trigger>();
    public List<type__trigger> Get_when()
    {
      return this.when;
    }
    public void Set_when(List<type__trigger> value)
    {
      this.when = value;
    }
    public List<world_step__rule_group__events_rule__entry__then> then = new List<world_step__rule_group__events_rule__entry__then>();
    public List<world_step__rule_group__events_rule__entry__then> Get_then()
    {
      return this.then;
    }
    public void Set_then(List<world_step__rule_group__events_rule__entry__then> value)
    {
      this.then = value;
    }

    public world_step__rule_group__events_rule__entry()
    {
    }

    public world_step__rule_group__events_rule__entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      //Deserialize elements
      this.when = rawNode.InitializeWithRawNode("when", this.when);
      this.then = rawNode.InitializeWithRawNode("then", this.then);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["when"] = when.Select(x => x.SerializeIntoRawNode()).ToList();
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__locations_markov_chain__location_markov_link {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__tag> Get_tag();
    public void Set_tag(List<world_step__rule_group__locations_markov_chain__location_markov_link__tag> value);
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling> Get_sibling();
    public void Set_sibling(List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling> value);
    public List<type_icon> Get_icon();
    public void Set_icon(List<type_icon> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__locations_markov_chain__location_markov_link: Iworld_step__rule_group__locations_markov_chain__location_markov_link {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__tag> tag = new List<world_step__rule_group__locations_markov_chain__location_markov_link__tag>();
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__tag> Get_tag()
    {
      return this.tag;
    }
    public void Set_tag(List<world_step__rule_group__locations_markov_chain__location_markov_link__tag> value)
    {
      this.tag = value;
    }
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling> sibling = new List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling>();
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling> Get_sibling()
    {
      return this.sibling;
    }
    public void Set_sibling(List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling> value)
    {
      this.sibling = value;
    }
    public List<type_icon> icon = new List<type_icon>();
    public List<type_icon> Get_icon()
    {
      return this.icon;
    }
    public void Set_icon(List<type_icon> value)
    {
      this.icon = value;
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link()
    {
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain__location_markov_link");
      //Deserialize arguments

      //Deserialize elements
      this.tag = rawNode.InitializeWithRawNode("tag", this.tag);
      this.sibling = rawNode.InitializeWithRawNode("sibling", this.sibling);
      this.icon = rawNode.InitializeWithRawNode("icon", this.icon);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize elements
      rawNode.children["tag"] = tag.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["sibling"] = sibling.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["icon"] = icon.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__locations_markov_chain__location_markov_link");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_graph_rule__setup {

    //Children elements
    public List<world_step__rule_group__location_graph_rule__setup__starting_node> Get_starting_node();
    public void Set_starting_node(List<world_step__rule_group__location_graph_rule__setup__starting_node> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__setup: Iworld_step__rule_group__location_graph_rule__setup {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__location_graph_rule__setup__starting_node> starting_node = new List<world_step__rule_group__location_graph_rule__setup__starting_node>();
    public List<world_step__rule_group__location_graph_rule__setup__starting_node> Get_starting_node()
    {
      return this.starting_node;
    }
    public void Set_starting_node(List<world_step__rule_group__location_graph_rule__setup__starting_node> value)
    {
      this.starting_node = value;
    }

    public world_step__rule_group__location_graph_rule__setup()
    {
    }

    public world_step__rule_group__location_graph_rule__setup(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__setup(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup");
      //Deserialize elements
      this.starting_node = rawNode.InitializeWithRawNode("starting_node", this.starting_node);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_graph_rule__node_rule {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);

    //Children elements
    public List<world_step__rule_group__location_graph_rule__node_rule__classifications> Get_classifications();
    public void Set_classifications(List<world_step__rule_group__location_graph_rule__node_rule__classifications> value);
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group> Get_link_group();
    public void Set_link_group(List<world_step__rule_group__location_graph_rule__node_rule__link_group> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__node_rule: Iworld_step__rule_group__location_graph_rule__node_rule {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }

    //Children elements
    public List<world_step__rule_group__location_graph_rule__node_rule__classifications> classifications = new List<world_step__rule_group__location_graph_rule__node_rule__classifications>();
    public List<world_step__rule_group__location_graph_rule__node_rule__classifications> Get_classifications()
    {
      return this.classifications;
    }
    public void Set_classifications(List<world_step__rule_group__location_graph_rule__node_rule__classifications> value)
    {
      this.classifications = value;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group> link_group = new List<world_step__rule_group__location_graph_rule__node_rule__link_group>();
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group> Get_link_group()
    {
      return this.link_group;
    }
    public void Set_link_group(List<world_step__rule_group__location_graph_rule__node_rule__link_group> value)
    {
      this.link_group = value;
    }

    public world_step__rule_group__location_graph_rule__node_rule()
    {
    }

    public world_step__rule_group__location_graph_rule__node_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__node_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      //Deserialize elements
      this.classifications = rawNode.InitializeWithRawNode("classifications", this.classifications);
      this.link_group = rawNode.InitializeWithRawNode("link_group", this.link_group);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements
      rawNode.children["classifications"] = classifications.Select(x => x.SerializeIntoRawNode()).ToList();
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_classification_rule__entry {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_classification_rule__entry: Iworld_step__rule_group__location_classification_rule__entry {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }

    //Children elements

    public world_step__rule_group__location_classification_rule__entry()
    {
    }

    public world_step__rule_group__location_classification_rule__entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_classification_rule__entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_classification_rule__entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_classification_rule__entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__people__person__race {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__race: Iworld_step__people__person__race {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__people__person__race()
    {
    }

    public world_step__people__person__race(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__people__person__race(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__race");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype_cell_ref {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    public System.Int32 Get_x();
    public void Set_x(System.Int32 value);
    public System.Int32 Get_y();
    public void Set_y(System.Int32 value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type_cell_ref: Itype_cell_ref {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    public System.Int32 x;
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
    }
    public System.Int32 y;
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
    }

    //Children elements

    public type_cell_ref()
    {
    }

    public type_cell_ref(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type_cell_ref(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type_cell_ref");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("x"))
      {
        var attribute_x = rawNode.attributes["x"];
        this.x = attribute_x.ToInt();
      }
      if(rawNode.attributes.ContainsKey("y"))
      {
        var attribute_y = rawNode.attributes["y"];
        this.y = attribute_y.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
        Godot.GD.Print("Serializing type_cell_ref");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__people__person__properties {

    //Children elements
    public List<world_step__people__person__properties__property> Get_property();
    public void Set_property(List<world_step__people__person__properties__property> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__properties: Iworld_step__people__person__properties {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__people__person__properties__property> property = new List<world_step__people__person__properties__property>();
    public List<world_step__people__person__properties__property> Get_property()
    {
      return this.property;
    }
    public void Set_property(List<world_step__people__person__properties__property> value)
    {
      this.property = value;
    }

    public world_step__people__person__properties()
    {
    }

    public world_step__people__person__properties(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__people__person__properties(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__properties");
      //Deserialize elements
      this.property = rawNode.InitializeWithRawNode("property", this.property);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__people__person__relations {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__relations: Iworld_step__people__person__relations {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__people__person__relations()
    {
    }

    public world_step__people__person__relations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__people__person__relations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__relations");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__people__person__inventory {

    //Children elements
    public List<type__item> Get_item();
    public void Set_item(List<type__item> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__inventory: Iworld_step__people__person__inventory {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<type__item> item = new List<type__item>();
    public List<type__item> Get_item()
    {
      return this.item;
    }
    public void Set_item(List<type__item> value)
    {
      this.item = value;
    }

    public world_step__people__person__inventory()
    {
    }

    public world_step__people__person__inventory(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__people__person__inventory(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__inventory");
      //Deserialize elements
      this.item = rawNode.InitializeWithRawNode("item", this.item);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["item"] = item.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__people__person__inventory");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__people__person__classifications {

    //Children elements
    public List<world_step__people__person__classifications__classification> Get_classification();
    public void Set_classification(List<world_step__people__person__classifications__classification> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__classifications: Iworld_step__people__person__classifications {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__people__person__classifications__classification> classification = new List<world_step__people__person__classifications__classification>();
    public List<world_step__people__person__classifications__classification> Get_classification()
    {
      return this.classification;
    }
    public void Set_classification(List<world_step__people__person__classifications__classification> value)
    {
      this.classification = value;
    }

    public world_step__people__person__classifications()
    {
    }

    public world_step__people__person__classifications(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__people__person__classifications(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__classifications");
      //Deserialize elements
      this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype_icon {
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type_icon: Itype_icon {
    public RawNode rawNode = new RawNode();

    public type_icon()
    {
    }

    public type_icon(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type_icon(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type_icon");
    }

    public RawNode SerializeIntoRawNode()
    {
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type_icon");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_graph__node__position {
    //Attributes
    public System.Int32 Get_x();
    public void Set_x(System.Int32 value);
    public System.Int32 Get_y();
    public void Set_y(System.Int32 value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__position: Iworld_step__location_graph__node__position {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 x;
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
    }
    public System.Int32 y;
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
    }

    //Children elements

    public world_step__location_graph__node__position()
    {
    }

    public world_step__location_graph__node__position(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__position(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__position");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("x"))
      {
        var attribute_x = rawNode.attributes["x"];
        this.x = attribute_x.ToInt();
      }
      if(rawNode.attributes.ContainsKey("y"))
      {
        var attribute_y = rawNode.attributes["y"];
        this.y = attribute_y.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_graph__node__classifications {

    //Children elements
    public List<world_step__location_graph__node__classifications__classification> Get_classification();
    public void Set_classification(List<world_step__location_graph__node__classifications__classification> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__classifications: Iworld_step__location_graph__node__classifications {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__location_graph__node__classifications__classification> classification = new List<world_step__location_graph__node__classifications__classification>();
    public List<world_step__location_graph__node__classifications__classification> Get_classification()
    {
      return this.classification;
    }
    public void Set_classification(List<world_step__location_graph__node__classifications__classification> value)
    {
      this.classification = value;
    }

    public world_step__location_graph__node__classifications()
    {
    }

    public world_step__location_graph__node__classifications(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__classifications(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__classifications");
      //Deserialize elements
      this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_graph__node__classifications");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_graph__node__link_to {
    //Attributes
    public System.String Get_node_id_ref();
    public void Set_node_id_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__link_to: Iworld_step__location_graph__node__link_to {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_id_ref;
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }

    //Children elements

    public world_step__location_graph__node__link_to()
    {
    }

    public world_step__location_graph__node__link_to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__link_to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__link_to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_id_ref"))
      {
        var attribute_node_id_ref = rawNode.attributes["node_id_ref"];
        this.node_id_ref = rawNode.attributes["node_id_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_graph__node__people {

    //Children elements
    public List<world_step__location_graph__node__people__person> Get_person();
    public void Set_person(List<world_step__location_graph__node__people__person> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__people: Iworld_step__location_graph__node__people {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__location_graph__node__people__person> person = new List<world_step__location_graph__node__people__person>();
    public List<world_step__location_graph__node__people__person> Get_person()
    {
      return this.person;
    }
    public void Set_person(List<world_step__location_graph__node__people__person> value)
    {
      this.person = value;
    }

    public world_step__location_graph__node__people()
    {
    }

    public world_step__location_graph__node__people(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__people(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__people");
      //Deserialize elements
      this.person = rawNode.InitializeWithRawNode("person", this.person);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__by__do {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__by__do: Iworld_step__actions__by__do {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__actions__by__do()
    {
    }

    public world_step__actions__by__do(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__by__do(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__by__do");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__by__move_towards {
    //Attributes
    public System.String Get_layer();
    public void Set_layer(System.String value);
    public System.Int32 Get_x();
    public void Set_x(System.Int32 value);
    public System.Int32 Get_y();
    public void Set_y(System.Int32 value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__by__move_towards: Iworld_step__actions__by__move_towards {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String layer;
    public System.String Get_layer()
    {
      return this.layer;
    }
    public void Set_layer(System.String value)
    {
      this.layer = value;
    }
    public System.Int32 x;
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
    }
    public System.Int32 y;
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
    }

    //Children elements

    public world_step__actions__by__move_towards()
    {
    }

    public world_step__actions__by__move_towards(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__by__move_towards(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__by__move_towards");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("layer"))
      {
        var attribute_layer = rawNode.attributes["layer"];
        this.layer = rawNode.attributes["layer"];
      }
      if(rawNode.attributes.ContainsKey("x"))
      {
        var attribute_x = rawNode.attributes["x"];
        this.x = attribute_x.ToInt();
      }
      if(rawNode.attributes.ContainsKey("y"))
      {
        var attribute_y = rawNode.attributes["y"];
        this.y = attribute_y.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__node_graph__selection {

    //Children elements
    public List<type__node_graph__selection__in__location_graph> Get_in__location_graph();
    public void Set_in__location_graph(List<type__node_graph__selection__in__location_graph> value);
    public List<type__node_graph__selection__has__node_graph_id> Get_has__node_graph_id();
    public void Set_has__node_graph_id(List<type__node_graph__selection__has__node_graph_id> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__node_graph__selection: Itype__node_graph__selection {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<type__node_graph__selection__in__location_graph> in__location_graph = new List<type__node_graph__selection__in__location_graph>();
    public List<type__node_graph__selection__in__location_graph> Get_in__location_graph()
    {
      return this.in__location_graph;
    }
    public void Set_in__location_graph(List<type__node_graph__selection__in__location_graph> value)
    {
      this.in__location_graph = value;
    }
    public List<type__node_graph__selection__has__node_graph_id> has__node_graph_id = new List<type__node_graph__selection__has__node_graph_id>();
    public List<type__node_graph__selection__has__node_graph_id> Get_has__node_graph_id()
    {
      return this.has__node_graph_id;
    }
    public void Set_has__node_graph_id(List<type__node_graph__selection__has__node_graph_id> value)
    {
      this.has__node_graph_id = value;
    }

    public type__node_graph__selection()
    {
    }

    public type__node_graph__selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__node_graph__selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__node_graph__selection");
      //Deserialize elements
      this.in__location_graph = rawNode.InitializeWithRawNode("in__location_graph", this.in__location_graph);
      this.has__node_graph_id = rawNode.InitializeWithRawNode("has__node_graph_id", this.has__node_graph_id);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["in__location_graph"] = in__location_graph.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["has__node_graph_id"] = has__node_graph_id.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__node_graph__selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__location_graph__node__add_classification__to_be_added__classification {
    //Attributes
    public System.String Get_location_classification_rule_ref();
    public void Set_location_classification_rule_ref(System.String value);

    //Children elements
    public List<world_step__actions__location_graph__node__add_classification__to_be_added__classification__and> Get_and();
    public void Set_and(List<world_step__actions__location_graph__node__add_classification__to_be_added__classification__and> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__location_graph__node__add_classification__to_be_added__classification: Iworld_step__actions__location_graph__node__add_classification__to_be_added__classification {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_classification_rule_ref;
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }

    //Children elements
    public List<world_step__actions__location_graph__node__add_classification__to_be_added__classification__and> and = new List<world_step__actions__location_graph__node__add_classification__to_be_added__classification__and>();
    public List<world_step__actions__location_graph__node__add_classification__to_be_added__classification__and> Get_and()
    {
      return this.and;
    }
    public void Set_and(List<world_step__actions__location_graph__node__add_classification__to_be_added__classification__and> value)
    {
      this.and = value;
    }

    public world_step__actions__location_graph__node__add_classification__to_be_added__classification()
    {
    }

    public world_step__actions__location_graph__node__add_classification__to_be_added__classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__location_graph__node__add_classification__to_be_added__classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__location_graph__node__add_classification__to_be_added__classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
      {
        var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
      }
      //Deserialize elements
      this.and = rawNode.InitializeWithRawNode("and", this.and);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_classification_rule_ref != null)
      {
        rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
      }
      //Serialize elements
      rawNode.children["and"] = and.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__location_graph__node__add_classification__to_be_added__classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__person__teleport__location_graph {
    //Attributes
    public System.String Get_location_graph_id_ref();
    public void Set_location_graph_id_ref(System.String value);
    public System.String Get_node_id_ref();
    public void Set_node_id_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__person__teleport__location_graph: Iworld_step__actions__person__teleport__location_graph {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_id_ref;
    public System.String Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String value)
    {
      this.location_graph_id_ref = value;
    }
    public System.String node_id_ref;
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }

    //Children elements

    public world_step__actions__person__teleport__location_graph()
    {
    }

    public world_step__actions__person__teleport__location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__person__teleport__location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__person__teleport__location_graph");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_id_ref"))
      {
        var attribute_location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
        this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("node_id_ref"))
      {
        var attribute_node_id_ref = rawNode.attributes["node_id_ref"];
        this.node_id_ref = rawNode.attributes["node_id_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__person_selection {

    //Children elements
    public List<type__math_operations> Get_radius();
    public void Set_radius(List<type__math_operations> value);
    public List<type__math_operations> Get_min();
    public void Set_min(List<type__math_operations> value);
    public List<type__math_operations> Get_max();
    public void Set_max(List<type__math_operations> value);
    public List<type__person_selection__property> Get_property();
    public void Set_property(List<type__person_selection__property> value);
    public List<type__person_selection__classification> Get_classification();
    public void Set_classification(List<type__person_selection__classification> value);
    public List<type__person_selection__race> Get_race();
    public void Set_race(List<type__person_selection__race> value);
    public List<type__person_selection__inventory> Get_inventory();
    public void Set_inventory(List<type__person_selection__inventory> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__person_selection: Itype__person_selection {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<type__math_operations> radius = new List<type__math_operations>();
    public List<type__math_operations> Get_radius()
    {
      return this.radius;
    }
    public void Set_radius(List<type__math_operations> value)
    {
      this.radius = value;
    }
    public List<type__math_operations> min = new List<type__math_operations>();
    public List<type__math_operations> Get_min()
    {
      return this.min;
    }
    public void Set_min(List<type__math_operations> value)
    {
      this.min = value;
    }
    public List<type__math_operations> max = new List<type__math_operations>();
    public List<type__math_operations> Get_max()
    {
      return this.max;
    }
    public void Set_max(List<type__math_operations> value)
    {
      this.max = value;
    }
    public List<type__person_selection__property> property = new List<type__person_selection__property>();
    public List<type__person_selection__property> Get_property()
    {
      return this.property;
    }
    public void Set_property(List<type__person_selection__property> value)
    {
      this.property = value;
    }
    public List<type__person_selection__classification> classification = new List<type__person_selection__classification>();
    public List<type__person_selection__classification> Get_classification()
    {
      return this.classification;
    }
    public void Set_classification(List<type__person_selection__classification> value)
    {
      this.classification = value;
    }
    public List<type__person_selection__race> race = new List<type__person_selection__race>();
    public List<type__person_selection__race> Get_race()
    {
      return this.race;
    }
    public void Set_race(List<type__person_selection__race> value)
    {
      this.race = value;
    }
    public List<type__person_selection__inventory> inventory = new List<type__person_selection__inventory>();
    public List<type__person_selection__inventory> Get_inventory()
    {
      return this.inventory;
    }
    public void Set_inventory(List<type__person_selection__inventory> value)
    {
      this.inventory = value;
    }

    public type__person_selection()
    {
    }

    public type__person_selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__person_selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__person_selection");
      //Deserialize elements
      this.radius = rawNode.InitializeWithRawNode("radius", this.radius);
      this.min = rawNode.InitializeWithRawNode("min", this.min);
      this.max = rawNode.InitializeWithRawNode("max", this.max);
      this.property = rawNode.InitializeWithRawNode("property", this.property);
      this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
      this.race = rawNode.InitializeWithRawNode("race", this.race);
      this.inventory = rawNode.InitializeWithRawNode("inventory", this.inventory);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["radius"] = radius.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["min"] = min.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["max"] = max.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["race"] = race.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["inventory"] = inventory.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__person_selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__property_rule__entry__person_default {

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule__entry__person_default: Iworld_step__rule_group__property_rule__entry__person_default {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__property_rule__entry__person_default()
    {
    }

    public world_step__rule_group__property_rule__entry__person_default(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule__entry__person_default(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__person_default");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__property_rule__entry__item_default {

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule__entry__item_default: Iworld_step__rule_group__property_rule__entry__item_default {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__property_rule__entry__item_default()
    {
    }

    public world_step__rule_group__property_rule__entry__item_default(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule__entry__item_default(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__item_default");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__property_rule__entry__property_threshold {
    //Attributes
    public System.String Get_name();
    public void Set_name(System.String value);
    public System.Int32 Get_min_value_inclusive();
    public void Set_min_value_inclusive(System.Int32 value);
    public System.Int32 Get_max_value_inclusive();
    public void Set_max_value_inclusive(System.Int32 value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__property_rule__entry__property_threshold: Iworld_step__rule_group__property_rule__entry__property_threshold {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String name;
    public System.String Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String value)
    {
      this.name = value;
    }
    public System.Int32 min_value_inclusive;
    public System.Int32 Get_min_value_inclusive()
    {
      return this.min_value_inclusive;
    }
    public void Set_min_value_inclusive(System.Int32 value)
    {
      this.min_value_inclusive = value;
    }
    public System.Int32 max_value_inclusive;
    public System.Int32 Get_max_value_inclusive()
    {
      return this.max_value_inclusive;
    }
    public void Set_max_value_inclusive(System.Int32 value)
    {
      this.max_value_inclusive = value;
    }

    //Children elements

    public world_step__rule_group__property_rule__entry__property_threshold()
    {
    }

    public world_step__rule_group__property_rule__entry__property_threshold(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__property_rule__entry__property_threshold(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__property_threshold");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("name"))
      {
        var attribute_name = rawNode.attributes["name"];
        this.name = rawNode.attributes["name"];
      }
      if(rawNode.attributes.ContainsKey("min-value-inclusive"))
      {
        var attribute_min_value_inclusive = rawNode.attributes["min-value-inclusive"];
        this.min_value_inclusive = attribute_min_value_inclusive.ToInt();
      }
      if(rawNode.attributes.ContainsKey("max-value-inclusive"))
      {
        var attribute_max_value_inclusive = rawNode.attributes["max-value-inclusive"];
        this.max_value_inclusive = attribute_max_value_inclusive.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Igroup__math_operations {

    //Children elements
    public List<group__operation__and> Get_operation();
    public void Set_operation(List<group__operation__and> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class group__math_operations: Igroup__math_operations {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<group__operation__and> operation = new List<group__operation__and>();
    public List<group__operation__and> Get_operation()
    {
      return this.operation;
    }
    public void Set_operation(List<group__operation__and> value)
    {
      this.operation = value;
    }

    public group__math_operations()
    {
    }

    public group__math_operations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public group__math_operations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing group__math_operations");
      //Deserialize elements
      this.operation = rawNode.InitializeWithRawNode("operation", this.operation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["operation"] = operation.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing group__math_operations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Igroup__name_token__name_token {
    //Attributes
    public System.String Get_prefix();
    public void Set_prefix(System.String value);

    //Children elements
    public List<group__name_token__name_token__ref> Get__ref();
    public void Set__ref(List<group__name_token__name_token__ref> value);
    public List<group__name_token> Get_one_of();
    public void Set_one_of(List<group__name_token> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class group__name_token__name_token: Igroup__name_token__name_token {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String prefix;
    public System.String Get_prefix()
    {
      return this.prefix;
    }
    public void Set_prefix(System.String value)
    {
      this.prefix = value;
    }

    //Children elements
    public List<group__name_token__name_token__ref> _ref = new List<group__name_token__name_token__ref>();
    public List<group__name_token__name_token__ref> Get__ref()
    {
      return this._ref;
    }
    public void Set__ref(List<group__name_token__name_token__ref> value)
    {
      this._ref = value;
    }
    public List<group__name_token> one_of = new List<group__name_token>();
    public List<group__name_token> Get_one_of()
    {
      return this.one_of;
    }
    public void Set_one_of(List<group__name_token> value)
    {
      this.one_of = value;
    }

    public group__name_token__name_token()
    {
    }

    public group__name_token__name_token(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public group__name_token__name_token(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing group__name_token__name_token");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("prefix"))
      {
        var attribute_prefix = rawNode.attributes["prefix"];
        this.prefix = rawNode.attributes["prefix"];
      }
      //Deserialize elements
      this._ref = rawNode.InitializeWithRawNode("ref", this._ref);
      this.one_of = rawNode.InitializeWithRawNode("one_of", this.one_of);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.prefix != null)
      {
        rawNode.attributes["prefix"] = this.prefix.ToString();
      }
      //Serialize elements
      rawNode.children["ref"] = _ref.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["one_of"] = one_of.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing group__name_token__name_token");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype_range {

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type_range: Itype_range {
    public RawNode rawNode = new RawNode();

    //Children elements

    public type_range()
    {
    }

    public type_range(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type_range(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type_range");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type_range");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__race_rule__entry__name {
    //Attributes
    public System.String Get_name_rule_ref();
    public void Set_name_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__race_rule__entry__name: Iworld_step__rule_group__race_rule__entry__name {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String name_rule_ref;
    public System.String Get_name_rule_ref()
    {
      return this.name_rule_ref;
    }
    public void Set_name_rule_ref(System.String value)
    {
      this.name_rule_ref = value;
    }

    //Children elements

    public world_step__rule_group__race_rule__entry__name()
    {
    }

    public world_step__rule_group__race_rule__entry__name(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__race_rule__entry__name(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__race_rule__entry__name");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("name_rule_ref"))
      {
        var attribute_name_rule_ref = rawNode.attributes["name_rule_ref"];
        this.name_rule_ref = rawNode.attributes["name_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__action_rule__global__entry {

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__global__entry: Iworld_step__rule_group__action_rule__global__entry {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__action_rule__global__entry()
    {
    }

    public world_step__rule_group__action_rule__global__entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__global__entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__global__entry");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__action_rule__person_to_person__test {

    //Children elements
    public List<group__math_operations> Get_value();
    public void Set_value(List<group__math_operations> value);
    public List<group__math_operations> Get_expected();
    public void Set_expected(List<group__math_operations> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__person_to_person__test: Iworld_step__rule_group__action_rule__person_to_person__test {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<group__math_operations> value = new List<group__math_operations>();
    public List<group__math_operations> Get_value()
    {
      return this.value;
    }
    public void Set_value(List<group__math_operations> value)
    {
      this.value = value;
    }
    public List<group__math_operations> expected = new List<group__math_operations>();
    public List<group__math_operations> Get_expected()
    {
      return this.expected;
    }
    public void Set_expected(List<group__math_operations> value)
    {
      this.expected = value;
    }

    public world_step__rule_group__action_rule__person_to_person__test()
    {
    }

    public world_step__rule_group__action_rule__person_to_person__test(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__person_to_person__test(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person__test");
      //Deserialize elements
      this.value = rawNode.InitializeWithRawNode("value", this.value);
      this.expected = rawNode.InitializeWithRawNode("expected", this.expected);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["value"] = value.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["expected"] = expected.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__action_rule__person_to_person__test");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__property_mutation_on {
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__property_mutation_on: Itype__property_mutation_on {
    public RawNode rawNode = new RawNode();

    public type__property_mutation_on()
    {
    }

    public type__property_mutation_on(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__property_mutation_on(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__property_mutation_on");
    }

    public RawNode SerializeIntoRawNode()
    {
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__property_mutation_on");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__action_rule__person_to_person__location_mutation {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    public System.String Get_on();
    public void Set_on(System.String value);

    //Children elements
    public List<group__math_operations> Get_from();
    public void Set_from(List<group__math_operations> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__action_rule__person_to_person__location_mutation: Iworld_step__rule_group__action_rule__person_to_person__location_mutation {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    public System.String on;
    public System.String Get_on()
    {
      return this.on;
    }
    public void Set_on(System.String value)
    {
      this.on = value;
    }

    //Children elements
    public List<group__math_operations> from = new List<group__math_operations>();
    public List<group__math_operations> Get_from()
    {
      return this.from;
    }
    public void Set_from(List<group__math_operations> value)
    {
      this.from = value;
    }

    public world_step__rule_group__action_rule__person_to_person__location_mutation()
    {
    }

    public world_step__rule_group__action_rule__person_to_person__location_mutation(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__action_rule__person_to_person__location_mutation(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person__location_mutation");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("on"))
      {
        var attribute_on = rawNode.attributes["on"];
        this.on = rawNode.attributes["on"];
      }
      //Deserialize elements
      this.from = rawNode.InitializeWithRawNode("from", this.from);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.on != null)
      {
        rawNode.attributes["on"] = this.on.ToString();
      }
      //Serialize elements
      rawNode.children["from"] = from.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__action_rule__person_to_person__location_mutation");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__item_rule__entry__weight_kg {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__item_rule__entry__weight_kg: Iworld_step__rule_group__item_rule__entry__weight_kg {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__rule_group__item_rule__entry__weight_kg()
    {
    }

    public world_step__rule_group__item_rule__entry__weight_kg(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__item_rule__entry__weight_kg(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule__entry__weight_kg");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__item_rule__entry__wearable {
    //Attributes
    public System.String Get_slot();
    public void Set_slot(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__item_rule__entry__wearable: Iworld_step__rule_group__item_rule__entry__wearable {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String slot;
    public System.String Get_slot()
    {
      return this.slot;
    }
    public void Set_slot(System.String value)
    {
      this.slot = value;
    }

    //Children elements

    public world_step__rule_group__item_rule__entry__wearable()
    {
    }

    public world_step__rule_group__item_rule__entry__wearable(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__item_rule__entry__wearable(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule__entry__wearable");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("slot"))
      {
        var attribute_slot = rawNode.attributes["slot"];
        this.slot = rawNode.attributes["slot"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__trigger {

    //Children elements
    public List<type__trigger__person_action_used> Get_person_action_used();
    public void Set_person_action_used(List<type__trigger__person_action_used> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__trigger: Itype__trigger {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<type__trigger__person_action_used> person_action_used = new List<type__trigger__person_action_used>();
    public List<type__trigger__person_action_used> Get_person_action_used()
    {
      return this.person_action_used;
    }
    public void Set_person_action_used(List<type__trigger__person_action_used> value)
    {
      this.person_action_used = value;
    }

    public type__trigger()
    {
    }

    public type__trigger(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__trigger(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__trigger");
      //Deserialize elements
      this.person_action_used = rawNode.InitializeWithRawNode("person_action_used", this.person_action_used);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["person_action_used"] = person_action_used.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__trigger");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__events_rule__entry__then {

    //Children elements
    public List<world_step__rule_group__events_rule__entry__then__select_person> Get_select_person();
    public void Set_select_person(List<world_step__rule_group__events_rule__entry__then__select_person> value);
    public List<world_step__rule_group__events_rule__entry__then__select_item> Get_select_item();
    public void Set_select_item(List<world_step__rule_group__events_rule__entry__then__select_item> value);
    public List<world_step__rule_group__events_rule__entry__then__property_mutation> Get_property_mutation();
    public void Set_property_mutation(List<world_step__rule_group__events_rule__entry__then__property_mutation> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry__then: Iworld_step__rule_group__events_rule__entry__then {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__events_rule__entry__then__select_person> select_person = new List<world_step__rule_group__events_rule__entry__then__select_person>();
    public List<world_step__rule_group__events_rule__entry__then__select_person> Get_select_person()
    {
      return this.select_person;
    }
    public void Set_select_person(List<world_step__rule_group__events_rule__entry__then__select_person> value)
    {
      this.select_person = value;
    }
    public List<world_step__rule_group__events_rule__entry__then__select_item> select_item = new List<world_step__rule_group__events_rule__entry__then__select_item>();
    public List<world_step__rule_group__events_rule__entry__then__select_item> Get_select_item()
    {
      return this.select_item;
    }
    public void Set_select_item(List<world_step__rule_group__events_rule__entry__then__select_item> value)
    {
      this.select_item = value;
    }
    public List<world_step__rule_group__events_rule__entry__then__property_mutation> property_mutation = new List<world_step__rule_group__events_rule__entry__then__property_mutation>();
    public List<world_step__rule_group__events_rule__entry__then__property_mutation> Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(List<world_step__rule_group__events_rule__entry__then__property_mutation> value)
    {
      this.property_mutation = value;
    }

    public world_step__rule_group__events_rule__entry__then()
    {
    }

    public world_step__rule_group__events_rule__entry__then(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry__then(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then");
      //Deserialize elements
      this.select_person = rawNode.InitializeWithRawNode("select_person", this.select_person);
      this.select_item = rawNode.InitializeWithRawNode("select_item", this.select_item);
      this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["select_person"] = select_person.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["select_item"] = select_item.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["property_mutation"] = property_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry__then");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__locations_markov_chain__location_markov_link__tag {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__locations_markov_chain__location_markov_link__tag: Iworld_step__rule_group__locations_markov_chain__location_markov_link__tag {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__rule_group__locations_markov_chain__location_markov_link__tag()
    {
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__tag(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__tag(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain__location_markov_link__tag");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__locations_markov_chain__location_markov_link__sibling {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    public System.Int32 Get_quantity();
    public void Set_quantity(System.Int32 value);
    /* ignored attribute key={key} of type=world_step__rule_group__locations_markov_chain__location_markov_link__sibling__position*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__locations_markov_chain__location_markov_link__sibling: Iworld_step__rule_group__locations_markov_chain__location_markov_link__sibling {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    public System.Int32 quantity;
    public System.Int32 Get_quantity()
    {
      return this.quantity;
    }
    public void Set_quantity(System.Int32 value)
    {
      this.quantity = value;
    }
    /* ignored attribute key={key} of type=world_step__rule_group__locations_markov_chain__location_markov_link__sibling__position*/

    //Children elements

    public world_step__rule_group__locations_markov_chain__location_markov_link__sibling()
    {
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__sibling(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__sibling(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain__location_markov_link__sibling");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("quantity"))
      {
        var attribute_quantity = rawNode.attributes["quantity"];
        this.quantity = attribute_quantity.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_graph_rule__setup__starting_node {
    //Attributes
    public System.String Get_node_rule_ref();
    public void Set_node_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__setup__starting_node: Iworld_step__rule_group__location_graph_rule__setup__starting_node {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }

    //Children elements

    public world_step__rule_group__location_graph_rule__setup__starting_node()
    {
    }

    public world_step__rule_group__location_graph_rule__setup__starting_node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__setup__starting_node(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup__starting_node");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_rule_ref"))
      {
        var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
        this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_graph_rule__node_rule__classifications {

    //Children elements
    public List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification> Get_classification();
    public void Set_classification(List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__node_rule__classifications: Iworld_step__rule_group__location_graph_rule__node_rule__classifications {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification> classification = new List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification>();
    public List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification> Get_classification()
    {
      return this.classification;
    }
    public void Set_classification(List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification> value)
    {
      this.classification = value;
    }

    public world_step__rule_group__location_graph_rule__node_rule__classifications()
    {
    }

    public world_step__rule_group__location_graph_rule__node_rule__classifications(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__node_rule__classifications(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__classifications");
      //Deserialize elements
      this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__classifications");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_graph_rule__node_rule__link_group {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);
    public System.Int32 Get_angle();
    public void Set_angle(System.Int32 value);
    public System.Int32 Get_angleMax();
    public void Set_angleMax(System.Int32 value);
    public System.Int32 Get_limit();
    public void Set_limit(System.Int32 value);

    //Children elements
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option> Get_to_option();
    public void Set_to_option(List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__node_rule__link_group: Iworld_step__rule_group__location_graph_rule__node_rule__link_group {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public System.Int32 angle;
    public System.Int32 Get_angle()
    {
      return this.angle;
    }
    public void Set_angle(System.Int32 value)
    {
      this.angle = value;
    }
    public System.Int32 angleMax;
    public System.Int32 Get_angleMax()
    {
      return this.angleMax;
    }
    public void Set_angleMax(System.Int32 value)
    {
      this.angleMax = value;
    }
    public System.Int32 limit;
    public System.Int32 Get_limit()
    {
      return this.limit;
    }
    public void Set_limit(System.Int32 value)
    {
      this.limit = value;
    }

    //Children elements
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option> to_option = new List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option>();
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option> Get_to_option()
    {
      return this.to_option;
    }
    public void Set_to_option(List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option> value)
    {
      this.to_option = value;
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group()
    {
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("angle"))
      {
        var attribute_angle = rawNode.attributes["angle"];
        this.angle = attribute_angle.ToInt();
      }
      if(rawNode.attributes.ContainsKey("angleMax"))
      {
        var attribute_angleMax = rawNode.attributes["angleMax"];
        this.angleMax = attribute_angleMax.ToInt();
      }
      if(rawNode.attributes.ContainsKey("limit"))
      {
        var attribute_limit = rawNode.attributes["limit"];
        this.limit = attribute_limit.ToInt();
      }
      //Deserialize elements
      this.to_option = rawNode.InitializeWithRawNode("to_option", this.to_option);
    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__people__person__properties__property {
    //Attributes
    public System.String Get_property_rule_ref();
    public void Set_property_rule_ref(System.String value);
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__properties__property: Iworld_step__people__person__properties__property {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public world_step__people__person__properties__property()
    {
    }

    public world_step__people__person__properties__property(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__people__person__properties__property(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__properties__property");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__people__person__classifications__classification {
    //Attributes
    public System.String Get_classification_rule_ref();
    public void Set_classification_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__people__person__classifications__classification: Iworld_step__people__person__classifications__classification {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String classification_rule_ref;
    public System.String Get_classification_rule_ref()
    {
      return this.classification_rule_ref;
    }
    public void Set_classification_rule_ref(System.String value)
    {
      this.classification_rule_ref = value;
    }

    //Children elements

    public world_step__people__person__classifications__classification()
    {
    }

    public world_step__people__person__classifications__classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__people__person__classifications__classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__people__person__classifications__classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("classification_rule_ref"))
      {
        var attribute_classification_rule_ref = rawNode.attributes["classification_rule_ref"];
        this.classification_rule_ref = rawNode.attributes["classification_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_graph__node__classifications__classification {
    //Attributes
    public System.String Get_location_classification_rule_ref();
    public void Set_location_classification_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__classifications__classification: Iworld_step__location_graph__node__classifications__classification {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_classification_rule_ref;
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }

    //Children elements

    public world_step__location_graph__node__classifications__classification()
    {
    }

    public world_step__location_graph__node__classifications__classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__classifications__classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__classifications__classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
      {
        var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_classification_rule_ref != null)
      {
        rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__location_graph__node__classifications__classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__location_graph__node__people__person {
    //Attributes
    public System.String Get_person_id_ref();
    public void Set_person_id_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__location_graph__node__people__person: Iworld_step__location_graph__node__people__person {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }

    //Children elements

    public world_step__location_graph__node__people__person()
    {
    }

    public world_step__location_graph__node__people__person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__location_graph__node__people__person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__location_graph__node__people__person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__node_graph__selection__in__location_graph {

    //Children elements
    public List<type__node_graph__selection__in__location_graph__has__location_graph_id> Get_has__location_graph_id();
    public void Set_has__location_graph_id(List<type__node_graph__selection__in__location_graph__has__location_graph_id> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__node_graph__selection__in__location_graph: Itype__node_graph__selection__in__location_graph {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<type__node_graph__selection__in__location_graph__has__location_graph_id> has__location_graph_id = new List<type__node_graph__selection__in__location_graph__has__location_graph_id>();
    public List<type__node_graph__selection__in__location_graph__has__location_graph_id> Get_has__location_graph_id()
    {
      return this.has__location_graph_id;
    }
    public void Set_has__location_graph_id(List<type__node_graph__selection__in__location_graph__has__location_graph_id> value)
    {
      this.has__location_graph_id = value;
    }

    public type__node_graph__selection__in__location_graph()
    {
    }

    public type__node_graph__selection__in__location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__node_graph__selection__in__location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__node_graph__selection__in__location_graph");
      //Deserialize elements
      this.has__location_graph_id = rawNode.InitializeWithRawNode("has__location_graph_id", this.has__location_graph_id);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["has__location_graph_id"] = has__location_graph_id.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__node_graph__selection__in__location_graph");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__node_graph__selection__has__node_graph_id {
    //Attributes
    public System.String Get_node_graph_id_ref();
    public void Set_node_graph_id_ref(System.String value);

    //Children elements
    public List<type__node_graph__selection__has__node_graph_id__or> Get_or();
    public void Set_or(List<type__node_graph__selection__has__node_graph_id__or> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__node_graph__selection__has__node_graph_id: Itype__node_graph__selection__has__node_graph_id {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_graph_id_ref;
    public System.String Get_node_graph_id_ref()
    {
      return this.node_graph_id_ref;
    }
    public void Set_node_graph_id_ref(System.String value)
    {
      this.node_graph_id_ref = value;
    }

    //Children elements
    public List<type__node_graph__selection__has__node_graph_id__or> or = new List<type__node_graph__selection__has__node_graph_id__or>();
    public List<type__node_graph__selection__has__node_graph_id__or> Get_or()
    {
      return this.or;
    }
    public void Set_or(List<type__node_graph__selection__has__node_graph_id__or> value)
    {
      this.or = value;
    }

    public type__node_graph__selection__has__node_graph_id()
    {
    }

    public type__node_graph__selection__has__node_graph_id(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__node_graph__selection__has__node_graph_id(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__node_graph__selection__has__node_graph_id");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_graph_id_ref"))
      {
        var attribute_node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
        this.node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
      }
      //Deserialize elements
      this.or = rawNode.InitializeWithRawNode("or", this.or);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_graph_id_ref != null)
      {
        rawNode.attributes["node_graph_id_ref"] = this.node_graph_id_ref.ToString();
      }
      //Serialize elements
      rawNode.children["or"] = or.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__node_graph__selection__has__node_graph_id");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__actions__location_graph__node__add_classification__to_be_added__classification__and {
    //Attributes
    public System.String Get_location_classification_rule_ref();
    public void Set_location_classification_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__actions__location_graph__node__add_classification__to_be_added__classification__and: Iworld_step__actions__location_graph__node__add_classification__to_be_added__classification__and {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_classification_rule_ref;
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }

    //Children elements

    public world_step__actions__location_graph__node__add_classification__to_be_added__classification__and()
    {
    }

    public world_step__actions__location_graph__node__add_classification__to_be_added__classification__and(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__actions__location_graph__node__add_classification__to_be_added__classification__and(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__actions__location_graph__node__add_classification__to_be_added__classification__and");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
      {
        var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_classification_rule_ref != null)
      {
        rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__actions__location_graph__node__add_classification__to_be_added__classification__and");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__math_operations {
    //Attributes
    public System.Int32 Get_initial();
    public void Set_initial(System.Int32 value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__math_operations: Itype__math_operations {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 initial;
    public System.Int32 Get_initial()
    {
      return this.initial;
    }
    public void Set_initial(System.Int32 value)
    {
      this.initial = value;
    }

    public type__math_operations()
    {
    }

    public type__math_operations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__math_operations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__math_operations");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("initial"))
      {
        var attribute_initial = rawNode.attributes["initial"];
        this.initial = attribute_initial.ToInt();
      }
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.initial != null)
      {
        rawNode.attributes["initial"] = this.initial.ToString();
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__math_operations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__person_selection__property {
    //Attributes
    public System.String Get_property_rule_ref();
    public void Set_property_rule_ref(System.String value);

    //Children elements
    public List<type__math_operations> Get_min();
    public void Set_min(List<type__math_operations> value);
    public List<type__math_operations> Get_max();
    public void Set_max(List<type__math_operations> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__person_selection__property: Itype__person_selection__property {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }

    //Children elements
    public List<type__math_operations> min = new List<type__math_operations>();
    public List<type__math_operations> Get_min()
    {
      return this.min;
    }
    public void Set_min(List<type__math_operations> value)
    {
      this.min = value;
    }
    public List<type__math_operations> max = new List<type__math_operations>();
    public List<type__math_operations> Get_max()
    {
      return this.max;
    }
    public void Set_max(List<type__math_operations> value)
    {
      this.max = value;
    }

    public type__person_selection__property()
    {
    }

    public type__person_selection__property(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__person_selection__property(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__person_selection__property");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }
      //Deserialize elements
      this.min = rawNode.InitializeWithRawNode("min", this.min);
      this.max = rawNode.InitializeWithRawNode("max", this.max);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.property_rule_ref != null)
      {
        rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
      }
      //Serialize elements
      rawNode.children["min"] = min.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["max"] = max.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__person_selection__property");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__person_selection__classification {
    //Attributes
    public System.String Get_classification_rule_ref();
    public void Set_classification_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__person_selection__classification: Itype__person_selection__classification {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String classification_rule_ref;
    public System.String Get_classification_rule_ref()
    {
      return this.classification_rule_ref;
    }
    public void Set_classification_rule_ref(System.String value)
    {
      this.classification_rule_ref = value;
    }

    //Children elements

    public type__person_selection__classification()
    {
    }

    public type__person_selection__classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__person_selection__classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__person_selection__classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("classification_rule_ref"))
      {
        var attribute_classification_rule_ref = rawNode.attributes["classification_rule_ref"];
        this.classification_rule_ref = rawNode.attributes["classification_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
        Godot.GD.Print("Serializing type__person_selection__classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__person_selection__race {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__person_selection__race: Itype__person_selection__race {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public type__person_selection__race()
    {
    }

    public type__person_selection__race(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__person_selection__race(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__person_selection__race");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__person_selection__race");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__person_selection__inventory {

    //Children elements
    public List<type__item_selection> Get_item();
    public void Set_item(List<type__item_selection> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__person_selection__inventory: Itype__person_selection__inventory {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<type__item_selection> item = new List<type__item_selection>();
    public List<type__item_selection> Get_item()
    {
      return this.item;
    }
    public void Set_item(List<type__item_selection> value)
    {
      this.item = value;
    }

    public type__person_selection__inventory()
    {
    }

    public type__person_selection__inventory(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__person_selection__inventory(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__person_selection__inventory");
      //Deserialize elements
      this.item = rawNode.InitializeWithRawNode("item", this.item);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["item"] = item.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__person_selection__inventory");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Igroup__operation__and {

    //Children elements
    public List<group__operation__and__add_property> Get_add_property();
    public void Set_add_property(List<group__operation__and__add_property> value);
    public List<group__operation__and> Get_and();
    public void Set_and(List<group__operation__and> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class group__operation__and: Igroup__operation__and {
    public RawNode rawNode = new RawNode();

    //Children elements
    public List<group__operation__and__add_property> add_property = new List<group__operation__and__add_property>();
    public List<group__operation__and__add_property> Get_add_property()
    {
      return this.add_property;
    }
    public void Set_add_property(List<group__operation__and__add_property> value)
    {
      this.add_property = value;
    }
    public List<group__operation__and> and = new List<group__operation__and>();
    public List<group__operation__and> Get_and()
    {
      return this.and;
    }
    public void Set_and(List<group__operation__and> value)
    {
      this.and = value;
    }

    public group__operation__and()
    {
    }

    public group__operation__and(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public group__operation__and(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing group__operation__and");
      //Deserialize elements
      this.add_property = rawNode.InitializeWithRawNode("add_property", this.add_property);
      this.and = rawNode.InitializeWithRawNode("and", this.and);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize elements
      rawNode.children["add_property"] = add_property.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["and"] = and.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing group__operation__and");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Igroup__name_token__name_token__ref {
    //Attributes
    public System.String Get_name_rule_ref();
    public void Set_name_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class group__name_token__name_token__ref: Igroup__name_token__name_token__ref {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String name_rule_ref;
    public System.String Get_name_rule_ref()
    {
      return this.name_rule_ref;
    }
    public void Set_name_rule_ref(System.String value)
    {
      this.name_rule_ref = value;
    }

    //Children elements

    public group__name_token__name_token__ref()
    {
    }

    public group__name_token__name_token__ref(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public group__name_token__name_token__ref(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing group__name_token__name_token__ref");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("name_rule_ref"))
      {
        var attribute_name_rule_ref = rawNode.attributes["name_rule_ref"];
        this.name_rule_ref = rawNode.attributes["name_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
        Godot.GD.Print("Serializing group__name_token__name_token__ref");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__trigger__person_action_used {
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__trigger__person_action_used: Itype__trigger__person_action_used {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements

    public type__trigger__person_action_used()
    {
    }

    public type__trigger__person_action_used(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__trigger__person_action_used(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__trigger__person_action_used");
      //Deserialize arguments

      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__trigger__person_action_used");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__events_rule__entry__then__select_person {

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry__then__select_person: Iworld_step__rule_group__events_rule__entry__then__select_person {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__events_rule__entry__then__select_person()
    {
    }

    public world_step__rule_group__events_rule__entry__then__select_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry__then__select_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then__select_person");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__events_rule__entry__then__select_item {

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry__then__select_item: Iworld_step__rule_group__events_rule__entry__then__select_item {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__events_rule__entry__then__select_item()
    {
    }

    public world_step__rule_group__events_rule__entry__then__select_item(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry__then__select_item(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then__select_item");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__events_rule__entry__then__property_mutation {

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__events_rule__entry__then__property_mutation: Iworld_step__rule_group__events_rule__entry__then__property_mutation {
    public RawNode rawNode = new RawNode();

    //Children elements

    public world_step__rule_group__events_rule__entry__then__property_mutation()
    {
    }

    public world_step__rule_group__events_rule__entry__then__property_mutation(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__events_rule__entry__then__property_mutation(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then__property_mutation");
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_graph_rule__node_rule__classifications__classification {
    //Attributes
    public System.String Get_location_classification_rule_ref();
    public void Set_location_classification_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__node_rule__classifications__classification: Iworld_step__rule_group__location_graph_rule__node_rule__classifications__classification {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_classification_rule_ref;
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }

    //Children elements

    public world_step__rule_group__location_graph_rule__node_rule__classifications__classification()
    {
    }

    public world_step__rule_group__location_graph_rule__node_rule__classifications__classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__node_rule__classifications__classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__classifications__classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
      {
        var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_classification_rule_ref != null)
      {
        rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__classifications__classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Iworld_step__rule_group__location_graph_rule__node_rule__link_group__to_option {
    //Attributes
    public System.String Get_node_rule_ref();
    public void Set_node_rule_ref(System.String value);
    public System.Int32 Get_distance();
    public void Set_distance(System.Int32 value);
    public System.Int32 Get_maxDistance();
    public void Set_maxDistance(System.Int32 value);
    public System.Int32 Get_adjacent_depth_limit();
    public void Set_adjacent_depth_limit(System.Int32 value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class world_step__rule_group__location_graph_rule__node_rule__link_group__to_option: Iworld_step__rule_group__location_graph_rule__node_rule__link_group__to_option {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.Int32 distance;
    public System.Int32 Get_distance()
    {
      return this.distance;
    }
    public void Set_distance(System.Int32 value)
    {
      this.distance = value;
    }
    public System.Int32 maxDistance;
    public System.Int32 Get_maxDistance()
    {
      return this.maxDistance;
    }
    public void Set_maxDistance(System.Int32 value)
    {
      this.maxDistance = value;
    }
    public System.Int32 adjacent_depth_limit;
    public System.Int32 Get_adjacent_depth_limit()
    {
      return this.adjacent_depth_limit;
    }
    public void Set_adjacent_depth_limit(System.Int32 value)
    {
      this.adjacent_depth_limit = value;
    }

    //Children elements

    public world_step__rule_group__location_graph_rule__node_rule__link_group__to_option()
    {
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group__to_option(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group__to_option(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group__to_option");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_rule_ref"))
      {
        var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
        this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("distance"))
      {
        var attribute_distance = rawNode.attributes["distance"];
        this.distance = attribute_distance.ToInt();
      }
      if(rawNode.attributes.ContainsKey("maxDistance"))
      {
        var attribute_maxDistance = rawNode.attributes["maxDistance"];
        this.maxDistance = attribute_maxDistance.ToInt();
      }
      if(rawNode.attributes.ContainsKey("adjacent_depth_limit"))
      {
        var attribute_adjacent_depth_limit = rawNode.attributes["adjacent_depth_limit"];
        this.adjacent_depth_limit = attribute_adjacent_depth_limit.ToInt();
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__node_graph__selection__in__location_graph__has__location_graph_id {
    //Attributes
    public System.String Get_location_graph_id_ref();
    public void Set_location_graph_id_ref(System.String value);

    //Children elements
    public List<type__node_graph__selection__in__location_graph__has__location_graph_id__or> Get_or();
    public void Set_or(List<type__node_graph__selection__in__location_graph__has__location_graph_id__or> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__node_graph__selection__in__location_graph__has__location_graph_id: Itype__node_graph__selection__in__location_graph__has__location_graph_id {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_id_ref;
    public System.String Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String value)
    {
      this.location_graph_id_ref = value;
    }

    //Children elements
    public List<type__node_graph__selection__in__location_graph__has__location_graph_id__or> or = new List<type__node_graph__selection__in__location_graph__has__location_graph_id__or>();
    public List<type__node_graph__selection__in__location_graph__has__location_graph_id__or> Get_or()
    {
      return this.or;
    }
    public void Set_or(List<type__node_graph__selection__in__location_graph__has__location_graph_id__or> value)
    {
      this.or = value;
    }

    public type__node_graph__selection__in__location_graph__has__location_graph_id()
    {
    }

    public type__node_graph__selection__in__location_graph__has__location_graph_id(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__node_graph__selection__in__location_graph__has__location_graph_id(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__node_graph__selection__in__location_graph__has__location_graph_id");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_id_ref"))
      {
        var attribute_location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
        this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
      }
      //Deserialize elements
      this.or = rawNode.InitializeWithRawNode("or", this.or);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_graph_id_ref != null)
      {
        rawNode.attributes["location_graph_id_ref"] = this.location_graph_id_ref.ToString();
      }
      //Serialize elements
      rawNode.children["or"] = or.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__node_graph__selection__in__location_graph__has__location_graph_id");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__node_graph__selection__has__node_graph_id__or {
    //Attributes
    public System.String Get_node_graph_id_ref();
    public void Set_node_graph_id_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__node_graph__selection__has__node_graph_id__or: Itype__node_graph__selection__has__node_graph_id__or {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_graph_id_ref;
    public System.String Get_node_graph_id_ref()
    {
      return this.node_graph_id_ref;
    }
    public void Set_node_graph_id_ref(System.String value)
    {
      this.node_graph_id_ref = value;
    }

    //Children elements

    public type__node_graph__selection__has__node_graph_id__or()
    {
    }

    public type__node_graph__selection__has__node_graph_id__or(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__node_graph__selection__has__node_graph_id__or(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__node_graph__selection__has__node_graph_id__or");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_graph_id_ref"))
      {
        var attribute_node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
        this.node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_graph_id_ref != null)
      {
        rawNode.attributes["node_graph_id_ref"] = this.node_graph_id_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__node_graph__selection__has__node_graph_id__or");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__item_selection {
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__item_selection: Itype__item_selection {
    public RawNode rawNode = new RawNode();

    public type__item_selection()
    {
    }

    public type__item_selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__item_selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__item_selection");
    }

    public RawNode SerializeIntoRawNode()
    {
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__item_selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Igroup__operation__and__add_property {
    //Attributes
    public System.String Get_property_rule_ref();
    public void Set_property_rule_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class group__operation__and__add_property: Igroup__operation__and__add_property {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }

    //Children elements

    public group__operation__and__add_property()
    {
    }

    public group__operation__and__add_property(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public group__operation__and__add_property(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing group__operation__and__add_property");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
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
        Godot.GD.Print("Serializing group__operation__and__add_property");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
  /*typeDeclarationElementToInterfaceString= element*/
  public interface Itype__node_graph__selection__in__location_graph__has__location_graph_id__or {
    //Attributes
    public System.String Get_location_graph_id_ref();
    public void Set_location_graph_id_ref(System.String value);

    //Children elements

    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

  /*typeDeclarationElementToString= element*/
  public class type__node_graph__selection__in__location_graph__has__location_graph_id__or: Itype__node_graph__selection__in__location_graph__has__location_graph_id__or {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_id_ref;
    public System.String Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String value)
    {
      this.location_graph_id_ref = value;
    }

    //Children elements

    public type__node_graph__selection__in__location_graph__has__location_graph_id__or()
    {
    }

    public type__node_graph__selection__in__location_graph__has__location_graph_id__or(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__node_graph__selection__in__location_graph__has__location_graph_id__or(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      Godot.GD.Print("Deserializing type__node_graph__selection__in__location_graph__has__location_graph_id__or");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_id_ref"))
      {
        var attribute_location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
        this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
      }
      //Deserialize elements

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_graph_id_ref != null)
      {
        rawNode.attributes["location_graph_id_ref"] = this.location_graph_id_ref.ToString();
      }
      //Serialize elements

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        Godot.GD.Print("Serializing type__node_graph__selection__in__location_graph__has__location_graph_id__or");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
}