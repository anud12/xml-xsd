using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
namespace XSD {
    public class world_step  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public world_step__world_metadata world_metadata = new world_step__world_metadata();
      public List<world_step__rule_group> rule_group = new List<world_step__rule_group>();
      public world_step__data data = new world_step__data();
      public world_step__actions? actions = null;
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
        this.world_metadata = rawNode.InitializeWithRawNode("world_metadata", this.world_metadata);
        this.rule_group = rawNode.InitializeWithRawNode("rule_group", this.rule_group);
        this.data = rawNode.InitializeWithRawNode("data", this.data);
        this.actions = rawNode.InitializeWithRawNode("actions", this.actions);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(world_metadata != null) {
          rawNode.children["world_metadata"] = new List<RawNode> { world_metadata.SerializeIntoRawNode() };
        }
        rawNode.children["rule_group"] = rule_group.Select(x => x.SerializeIntoRawNode()).ToList();
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
    public world_step__world_metadata Get_world_metadata()
    {
      return this.world_metadata;
    }
    public world_step__world_metadata GetOrInsertDefault_world_metadata()
    {
      if(this.world_metadata == null) {
        this.world_metadata = new world_step__world_metadata();
      }
      return this.world_metadata;
    }
    public void Set_world_metadata(world_step__world_metadata value)
    {
      this.world_metadata = value;
    }
    public List<world_step__rule_group> Get_rule_group()
    {
      return this.rule_group;
    }
    public List<world_step__rule_group> GetOrInsertDefault_rule_group()
    {
      if(this.rule_group == null) {
        this.rule_group = new List<world_step__rule_group>();
      }
      return this.rule_group;
    }
    public void Set_rule_group(List<world_step__rule_group> value)
    {
      this.rule_group = value;
    }
    public world_step__data Get_data()
    {
      return this.data;
    }
    public world_step__data GetOrInsertDefault_data()
    {
      if(this.data == null) {
        this.data = new world_step__data();
      }
      return this.data;
    }
    public void Set_data(world_step__data value)
    {
      this.data = value;
    }
    public world_step__actions? Get_actions()
    {
      return this.actions;
    }
    public world_step__actions GetOrInsertDefault_actions()
    {
      if(this.actions == null) {
        this.actions = new world_step__actions();
      }
      return this.actions;
    }
    public void Set_actions(world_step__actions? value)
    {
      this.actions = value;
    }
  }

    public class world_step__world_metadata  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public world_step__world_metadata__previous_world_step? previous_world_step = null;
      public world_step__world_metadata__next_world_step? next_world_step = null;
      public world_step__world_metadata__elapsed_time elapsed_time = new world_step__world_metadata__elapsed_time();
      public world_step__world_metadata__stepDuration stepDuration = new world_step__world_metadata__stepDuration();
      public world_step__world_metadata__counter counter = new world_step__world_metadata__counter();
      public world_step__world_metadata__randomization_table randomization_table = new world_step__world_metadata__randomization_table();
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
        // Godot.GD.Print("Deserializing world_step__world_metadata");
        //Deserialize arguments

        //Deserialize children
        this.previous_world_step = rawNode.InitializeWithRawNode("previous_world_step", this.previous_world_step);
        this.next_world_step = rawNode.InitializeWithRawNode("next_world_step", this.next_world_step);
        this.elapsed_time = rawNode.InitializeWithRawNode("elapsed_time", this.elapsed_time);
        this.stepDuration = rawNode.InitializeWithRawNode("stepDuration", this.stepDuration);
        this.counter = rawNode.InitializeWithRawNode("counter", this.counter);
        this.randomization_table = rawNode.InitializeWithRawNode("randomization_table", this.randomization_table);
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
          // Godot.GD.Print("Serializing world_step__world_metadata");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public world_step__world_metadata__previous_world_step? Get_previous_world_step()
    {
      return this.previous_world_step;
    }
    public world_step__world_metadata__previous_world_step GetOrInsertDefault_previous_world_step()
    {
      if(this.previous_world_step == null) {
        this.previous_world_step = new world_step__world_metadata__previous_world_step();
      }
      return this.previous_world_step;
    }
    public void Set_previous_world_step(world_step__world_metadata__previous_world_step? value)
    {
      this.previous_world_step = value;
    }
    public world_step__world_metadata__next_world_step? Get_next_world_step()
    {
      return this.next_world_step;
    }
    public world_step__world_metadata__next_world_step GetOrInsertDefault_next_world_step()
    {
      if(this.next_world_step == null) {
        this.next_world_step = new world_step__world_metadata__next_world_step();
      }
      return this.next_world_step;
    }
    public void Set_next_world_step(world_step__world_metadata__next_world_step? value)
    {
      this.next_world_step = value;
    }
    public world_step__world_metadata__elapsed_time Get_elapsed_time()
    {
      return this.elapsed_time;
    }
    public world_step__world_metadata__elapsed_time GetOrInsertDefault_elapsed_time()
    {
      if(this.elapsed_time == null) {
        this.elapsed_time = new world_step__world_metadata__elapsed_time();
      }
      return this.elapsed_time;
    }
    public void Set_elapsed_time(world_step__world_metadata__elapsed_time value)
    {
      this.elapsed_time = value;
    }
    public world_step__world_metadata__stepDuration Get_stepDuration()
    {
      return this.stepDuration;
    }
    public world_step__world_metadata__stepDuration GetOrInsertDefault_stepDuration()
    {
      if(this.stepDuration == null) {
        this.stepDuration = new world_step__world_metadata__stepDuration();
      }
      return this.stepDuration;
    }
    public void Set_stepDuration(world_step__world_metadata__stepDuration value)
    {
      this.stepDuration = value;
    }
    public world_step__world_metadata__counter Get_counter()
    {
      return this.counter;
    }
    public world_step__world_metadata__counter GetOrInsertDefault_counter()
    {
      if(this.counter == null) {
        this.counter = new world_step__world_metadata__counter();
      }
      return this.counter;
    }
    public void Set_counter(world_step__world_metadata__counter value)
    {
      this.counter = value;
    }
    public world_step__world_metadata__randomization_table Get_randomization_table()
    {
      return this.randomization_table;
    }
    public world_step__world_metadata__randomization_table GetOrInsertDefault_randomization_table()
    {
      if(this.randomization_table == null) {
        this.randomization_table = new world_step__world_metadata__randomization_table();
      }
      return this.randomization_table;
    }
    public void Set_randomization_table(world_step__world_metadata__randomization_table value)
    {
      this.randomization_table = value;
    }
  }

    public class world_step__rule_group  {
      public RawNode rawNode = new RawNode();
      //Attributes
      /* ignored attribute key={key} of type=System.Object*/

      //Children elements
      public world_step__rule_group__property_rule? property_rule = null;
      public world_step__rule_group__classification_rule? classification_rule = null;
      public world_step__rule_group__name_rule? name_rule = null;
      public world_step__rule_group__race_rule? race_rule = null;
      public world_step__rule_group__action_rule? action_rule = null;
      public world_step__rule_group__events_rule? events_rule = null;
      public world_step__rule_group__link_group_rule_list? link_group_rule_list = null;
      public world_step__rule_group__location_graph_rule? location_graph_rule = null;
      public world_step__rule_group__location_classification_rule? location_classification_rule = null;
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
        // Godot.GD.Print("Deserializing world_step__rule_group");
        //Deserialize arguments

        //Deserialize children
        this.property_rule = rawNode.InitializeWithRawNode("property_rule", this.property_rule);
        this.classification_rule = rawNode.InitializeWithRawNode("classification_rule", this.classification_rule);
        this.name_rule = rawNode.InitializeWithRawNode("name_rule", this.name_rule);
        this.race_rule = rawNode.InitializeWithRawNode("race_rule", this.race_rule);
        this.action_rule = rawNode.InitializeWithRawNode("action_rule", this.action_rule);
        this.events_rule = rawNode.InitializeWithRawNode("events_rule", this.events_rule);
        this.link_group_rule_list = rawNode.InitializeWithRawNode("link_group_rule_list", this.link_group_rule_list);
        this.location_graph_rule = rawNode.InitializeWithRawNode("location_graph_rule", this.location_graph_rule);
        this.location_classification_rule = rawNode.InitializeWithRawNode("location_classification_rule", this.location_classification_rule);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(property_rule != null) {
          rawNode.children["property_rule"] = new List<RawNode> { property_rule.SerializeIntoRawNode() };
        }
        if(classification_rule != null) {
          rawNode.children["classification_rule"] = new List<RawNode> { classification_rule.SerializeIntoRawNode() };
        }
        if(name_rule != null) {
          rawNode.children["name_rule"] = new List<RawNode> { name_rule.SerializeIntoRawNode() };
        }
        if(race_rule != null) {
          rawNode.children["race_rule"] = new List<RawNode> { race_rule.SerializeIntoRawNode() };
        }
        if(action_rule != null) {
          rawNode.children["action_rule"] = new List<RawNode> { action_rule.SerializeIntoRawNode() };
        }
        if(events_rule != null) {
          rawNode.children["events_rule"] = new List<RawNode> { events_rule.SerializeIntoRawNode() };
        }
        if(link_group_rule_list != null) {
          rawNode.children["link_group_rule_list"] = new List<RawNode> { link_group_rule_list.SerializeIntoRawNode() };
        }
        if(location_graph_rule != null) {
          rawNode.children["location_graph_rule"] = new List<RawNode> { location_graph_rule.SerializeIntoRawNode() };
        }
        if(location_classification_rule != null) {
          rawNode.children["location_classification_rule"] = new List<RawNode> { location_classification_rule.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    /* ignored attribute key={key} of type=System.Object*/
    public world_step__rule_group__property_rule? Get_property_rule()
    {
      return this.property_rule;
    }
    public world_step__rule_group__property_rule GetOrInsertDefault_property_rule()
    {
      if(this.property_rule == null) {
        this.property_rule = new world_step__rule_group__property_rule();
      }
      return this.property_rule;
    }
    public void Set_property_rule(world_step__rule_group__property_rule? value)
    {
      this.property_rule = value;
    }
    public world_step__rule_group__classification_rule? Get_classification_rule()
    {
      return this.classification_rule;
    }
    public world_step__rule_group__classification_rule GetOrInsertDefault_classification_rule()
    {
      if(this.classification_rule == null) {
        this.classification_rule = new world_step__rule_group__classification_rule();
      }
      return this.classification_rule;
    }
    public void Set_classification_rule(world_step__rule_group__classification_rule? value)
    {
      this.classification_rule = value;
    }
    public world_step__rule_group__name_rule? Get_name_rule()
    {
      return this.name_rule;
    }
    public world_step__rule_group__name_rule GetOrInsertDefault_name_rule()
    {
      if(this.name_rule == null) {
        this.name_rule = new world_step__rule_group__name_rule();
      }
      return this.name_rule;
    }
    public void Set_name_rule(world_step__rule_group__name_rule? value)
    {
      this.name_rule = value;
    }
    public world_step__rule_group__race_rule? Get_race_rule()
    {
      return this.race_rule;
    }
    public world_step__rule_group__race_rule GetOrInsertDefault_race_rule()
    {
      if(this.race_rule == null) {
        this.race_rule = new world_step__rule_group__race_rule();
      }
      return this.race_rule;
    }
    public void Set_race_rule(world_step__rule_group__race_rule? value)
    {
      this.race_rule = value;
    }
    public world_step__rule_group__action_rule? Get_action_rule()
    {
      return this.action_rule;
    }
    public world_step__rule_group__action_rule GetOrInsertDefault_action_rule()
    {
      if(this.action_rule == null) {
        this.action_rule = new world_step__rule_group__action_rule();
      }
      return this.action_rule;
    }
    public void Set_action_rule(world_step__rule_group__action_rule? value)
    {
      this.action_rule = value;
    }
    public world_step__rule_group__events_rule? Get_events_rule()
    {
      return this.events_rule;
    }
    public world_step__rule_group__events_rule GetOrInsertDefault_events_rule()
    {
      if(this.events_rule == null) {
        this.events_rule = new world_step__rule_group__events_rule();
      }
      return this.events_rule;
    }
    public void Set_events_rule(world_step__rule_group__events_rule? value)
    {
      this.events_rule = value;
    }
    public world_step__rule_group__link_group_rule_list? Get_link_group_rule_list()
    {
      return this.link_group_rule_list;
    }
    public world_step__rule_group__link_group_rule_list GetOrInsertDefault_link_group_rule_list()
    {
      if(this.link_group_rule_list == null) {
        this.link_group_rule_list = new world_step__rule_group__link_group_rule_list();
      }
      return this.link_group_rule_list;
    }
    public void Set_link_group_rule_list(world_step__rule_group__link_group_rule_list? value)
    {
      this.link_group_rule_list = value;
    }
    public world_step__rule_group__location_graph_rule? Get_location_graph_rule()
    {
      return this.location_graph_rule;
    }
    public world_step__rule_group__location_graph_rule GetOrInsertDefault_location_graph_rule()
    {
      if(this.location_graph_rule == null) {
        this.location_graph_rule = new world_step__rule_group__location_graph_rule();
      }
      return this.location_graph_rule;
    }
    public void Set_location_graph_rule(world_step__rule_group__location_graph_rule? value)
    {
      this.location_graph_rule = value;
    }
    public world_step__rule_group__location_classification_rule? Get_location_classification_rule()
    {
      return this.location_classification_rule;
    }
    public world_step__rule_group__location_classification_rule GetOrInsertDefault_location_classification_rule()
    {
      if(this.location_classification_rule == null) {
        this.location_classification_rule = new world_step__rule_group__location_classification_rule();
      }
      return this.location_classification_rule;
    }
    public void Set_location_classification_rule(world_step__rule_group__location_classification_rule? value)
    {
      this.location_classification_rule = value;
    }
  }


    public class world_step__data  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public world_step__data__people? people = null;
      public world_step__data__location? location = null;
      public world_step__data()
      {
      }

      public world_step__data(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data");
        //Deserialize arguments

        //Deserialize children
        this.people = rawNode.InitializeWithRawNode("people", this.people);
        this.location = rawNode.InitializeWithRawNode("location", this.location);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(people != null) {
          rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
        }
        if(location != null) {
          rawNode.children["location"] = new List<RawNode> { location.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public world_step__data__people? Get_people()
    {
      return this.people;
    }
    public world_step__data__people GetOrInsertDefault_people()
    {
      if(this.people == null) {
        this.people = new world_step__data__people();
      }
      return this.people;
    }
    public void Set_people(world_step__data__people? value)
    {
      this.people = value;
    }
    public world_step__data__location? Get_location()
    {
      return this.location;
    }
    public world_step__data__location GetOrInsertDefault_location()
    {
      if(this.location == null) {
        this.location = new world_step__data__location();
      }
      return this.location;
    }
    public void Set_location(world_step__data__location? value)
    {
      this.location = value;
    }
  }


    public class world_step__actions  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__actions__by>? by = new List<world_step__actions__by>();
      public List<world_step__actions__location_graph__create>? location_graph__create = new List<world_step__actions__location_graph__create>();
      public List<world_step__actions__location_graph__node__create_adjacent>? location_graph__node__create_adjacent = new List<world_step__actions__location_graph__node__create_adjacent>();
      public List<world_step__actions__location_graph__node__add_classification>? location_graph__node__add_classification = new List<world_step__actions__location_graph__node__add_classification>();
      public world_step__actions__person__teleport? person__teleport = null;
      public List<world_step__actions__person__on_person__property_mutation>? person__on_person__property_mutation = new List<world_step__actions__person__on_person__property_mutation>();
      public List<world_step__actions__person__create>? person__create = new List<world_step__actions__person__create>();
      public List<world_step__actions__person__move_to>? person__move_to = new List<world_step__actions__person__move_to>();
      public List<world_step__actions__from_person>? from_person = new List<world_step__actions__from_person>();
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
        // Godot.GD.Print("Deserializing world_step__actions");
        //Deserialize arguments

        //Deserialize children
        this.by = rawNode.InitializeWithRawNode("by", this.by);
        this.location_graph__create = rawNode.InitializeWithRawNode("location_graph.create", this.location_graph__create);
        this.location_graph__node__create_adjacent = rawNode.InitializeWithRawNode("location_graph.node.create_adjacent", this.location_graph__node__create_adjacent);
        this.location_graph__node__add_classification = rawNode.InitializeWithRawNode("location_graph.node.add_classification", this.location_graph__node__add_classification);
        this.person__teleport = rawNode.InitializeWithRawNode("person.teleport", this.person__teleport);
        this.person__on_person__property_mutation = rawNode.InitializeWithRawNode("person.on_person.property_mutation", this.person__on_person__property_mutation);
        this.person__create = rawNode.InitializeWithRawNode("person.create", this.person__create);
        this.person__move_to = rawNode.InitializeWithRawNode("person.move_to", this.person__move_to);
        this.from_person = rawNode.InitializeWithRawNode("from_person", this.from_person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["by"] = by.Select(x => x.SerializeIntoRawNode()).ToList();
        rawNode.children["location_graph.create"] = location_graph__create.Select(x => x.SerializeIntoRawNode()).ToList();
        rawNode.children["location_graph.node.create_adjacent"] = location_graph__node__create_adjacent.Select(x => x.SerializeIntoRawNode()).ToList();
        rawNode.children["location_graph.node.add_classification"] = location_graph__node__add_classification.Select(x => x.SerializeIntoRawNode()).ToList();
        if(person__teleport != null) {
          rawNode.children["person.teleport"] = new List<RawNode> { person__teleport.SerializeIntoRawNode() };
        }
        rawNode.children["person.on_person.property_mutation"] = person__on_person__property_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
        rawNode.children["person.create"] = person__create.Select(x => x.SerializeIntoRawNode()).ToList();
        rawNode.children["person.move_to"] = person__move_to.Select(x => x.SerializeIntoRawNode()).ToList();
        rawNode.children["from_person"] = from_person.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__actions__by>? Get_by()
    {
      return this.by;
    }
    public void Set_by(List<world_step__actions__by>? value)
    {
      this.by = value;
    }
    public List<world_step__actions__location_graph__create>? Get_location_graph__create()
    {
      return this.location_graph__create;
    }
    public List<world_step__actions__location_graph__create> GetOrInsertDefault_location_graph__create()
    {
      if(this.location_graph__create == null) {
        this.location_graph__create = new List<world_step__actions__location_graph__create>();
      }
      return this.location_graph__create;
    }
    public void Set_location_graph__create(List<world_step__actions__location_graph__create>? value)
    {
      this.location_graph__create = value;
    }
    public List<world_step__actions__location_graph__node__create_adjacent>? Get_location_graph__node__create_adjacent()
    {
      return this.location_graph__node__create_adjacent;
    }
    public List<world_step__actions__location_graph__node__create_adjacent> GetOrInsertDefault_location_graph__node__create_adjacent()
    {
      if(this.location_graph__node__create_adjacent == null) {
        this.location_graph__node__create_adjacent = new List<world_step__actions__location_graph__node__create_adjacent>();
      }
      return this.location_graph__node__create_adjacent;
    }
    public void Set_location_graph__node__create_adjacent(List<world_step__actions__location_graph__node__create_adjacent>? value)
    {
      this.location_graph__node__create_adjacent = value;
    }
    public List<world_step__actions__location_graph__node__add_classification>? Get_location_graph__node__add_classification()
    {
      return this.location_graph__node__add_classification;
    }
    public List<world_step__actions__location_graph__node__add_classification> GetOrInsertDefault_location_graph__node__add_classification()
    {
      if(this.location_graph__node__add_classification == null) {
        this.location_graph__node__add_classification = new List<world_step__actions__location_graph__node__add_classification>();
      }
      return this.location_graph__node__add_classification;
    }
    public void Set_location_graph__node__add_classification(List<world_step__actions__location_graph__node__add_classification>? value)
    {
      this.location_graph__node__add_classification = value;
    }
    public world_step__actions__person__teleport? Get_person__teleport()
    {
      return this.person__teleport;
    }
    public void Set_person__teleport(world_step__actions__person__teleport? value)
    {
      this.person__teleport = value;
    }
    public List<world_step__actions__person__on_person__property_mutation>? Get_person__on_person__property_mutation()
    {
      return this.person__on_person__property_mutation;
    }
    public List<world_step__actions__person__on_person__property_mutation> GetOrInsertDefault_person__on_person__property_mutation()
    {
      if(this.person__on_person__property_mutation == null) {
        this.person__on_person__property_mutation = new List<world_step__actions__person__on_person__property_mutation>();
      }
      return this.person__on_person__property_mutation;
    }
    public void Set_person__on_person__property_mutation(List<world_step__actions__person__on_person__property_mutation>? value)
    {
      this.person__on_person__property_mutation = value;
    }
    public List<world_step__actions__person__create>? Get_person__create()
    {
      return this.person__create;
    }
    public List<world_step__actions__person__create> GetOrInsertDefault_person__create()
    {
      if(this.person__create == null) {
        this.person__create = new List<world_step__actions__person__create>();
      }
      return this.person__create;
    }
    public void Set_person__create(List<world_step__actions__person__create>? value)
    {
      this.person__create = value;
    }
    public List<world_step__actions__person__move_to>? Get_person__move_to()
    {
      return this.person__move_to;
    }
    public List<world_step__actions__person__move_to> GetOrInsertDefault_person__move_to()
    {
      if(this.person__move_to == null) {
        this.person__move_to = new List<world_step__actions__person__move_to>();
      }
      return this.person__move_to;
    }
    public void Set_person__move_to(List<world_step__actions__person__move_to>? value)
    {
      this.person__move_to = value;
    }
    public List<world_step__actions__from_person>? Get_from_person()
    {
      return this.from_person;
    }
    public List<world_step__actions__from_person> GetOrInsertDefault_from_person()
    {
      if(this.from_person == null) {
        this.from_person = new List<world_step__actions__from_person>();
      }
      return this.from_person;
    }
    public void Set_from_person(List<world_step__actions__from_person>? value)
    {
      this.from_person = value;
    }
  }


    public class world_step__world_metadata__previous_world_step  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String? value;

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
        // Godot.GD.Print("Deserializing world_step__world_metadata__previous_world_step");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("value"))
        {
          var attribute_value = rawNode.attributes["value"];
          this.value = rawNode.attributes["value"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.value != null)
        {
          rawNode.attributes["value"] = this.value?.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__world_metadata__previous_world_step");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String? Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String? value)
    {
      this.value = value;
    }
  }


    public class world_step__world_metadata__next_world_step  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String? value;

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
        // Godot.GD.Print("Deserializing world_step__world_metadata__next_world_step");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("value"))
        {
          var attribute_value = rawNode.attributes["value"];
          this.value = rawNode.attributes["value"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.value != null)
        {
          rawNode.attributes["value"] = this.value?.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__world_metadata__next_world_step");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String? Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String? value)
    {
      this.value = value;
    }
  }


    public class world_step__world_metadata__elapsed_time  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.Int32 value;

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
        // Godot.GD.Print("Deserializing world_step__world_metadata__elapsed_time");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("value"))
        {
          var attribute_value = rawNode.attributes["value"];
          this.value = attribute_value.ToInt();
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.value != null)
        {
          rawNode.attributes["value"] = this.value.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__world_metadata__elapsed_time");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32 Get_value()
    {
      return this.value;
    }
    public void Set_value(System.Int32 value)
    {
      this.value = value;
    }
  }


    public class world_step__world_metadata__stepDuration  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.Int32 value;

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
        // Godot.GD.Print("Deserializing world_step__world_metadata__stepDuration");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("value"))
        {
          var attribute_value = rawNode.attributes["value"];
          this.value = attribute_value.ToInt();
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.value != null)
        {
          rawNode.attributes["value"] = this.value.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__world_metadata__stepDuration");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32 Get_value()
    {
      return this.value;
    }
    public void Set_value(System.Int32 value)
    {
      this.value = value;
    }
  }


    public class world_step__world_metadata__counter  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.Int32 value;

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
        // Godot.GD.Print("Deserializing world_step__world_metadata__counter");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("value"))
        {
          var attribute_value = rawNode.attributes["value"];
          this.value = attribute_value.ToInt();
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.value != null)
        {
          rawNode.attributes["value"] = this.value.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__world_metadata__counter");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32 Get_value()
    {
      return this.value;
    }
    public void Set_value(System.Int32 value)
    {
      this.value = value;
    }
  }


    public class world_step__world_metadata__randomization_table  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__world_metadata__randomization_table__entry> entry = new List<world_step__world_metadata__randomization_table__entry>();
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
        // Godot.GD.Print("Deserializing world_step__world_metadata__randomization_table");
        //Deserialize arguments

        //Deserialize children
        this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__world_metadata__randomization_table");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__world_metadata__randomization_table__entry> Get_entry()
    {
      return this.entry;
    }
    public List<world_step__world_metadata__randomization_table__entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<world_step__world_metadata__randomization_table__entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<world_step__world_metadata__randomization_table__entry> value)
    {
      this.entry = value;
    }
  }


    public class world_step__rule_group__property_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__property_rule__entry>? entry = new List<world_step__rule_group__property_rule__entry>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__property_rule");
        //Deserialize arguments

        //Deserialize children
        this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__property_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__property_rule__entry>? Get_entry()
    {
      return this.entry;
    }
    public List<world_step__rule_group__property_rule__entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<world_step__rule_group__property_rule__entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__property_rule__entry>? value)
    {
      this.entry = value;
    }
  }


    public class world_step__rule_group__classification_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__classification_rule__entry>? entry = new List<world_step__rule_group__classification_rule__entry>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__classification_rule");
        //Deserialize arguments

        //Deserialize children
        this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__classification_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__classification_rule__entry>? Get_entry()
    {
      return this.entry;
    }
    public List<world_step__rule_group__classification_rule__entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<world_step__rule_group__classification_rule__entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__classification_rule__entry>? value)
    {
      this.entry = value;
    }
  }


    public class world_step__rule_group__name_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<group__name_token>? entry = new List<group__name_token>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__name_rule");
        //Deserialize arguments

        //Deserialize children
        this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__name_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<group__name_token>? Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<group__name_token>? value)
    {
      this.entry = value;
    }
  }


    public class world_step__rule_group__race_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__race_rule__entry>? entry = new List<world_step__rule_group__race_rule__entry>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__race_rule");
        //Deserialize arguments

        //Deserialize children
        this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__race_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__race_rule__entry>? Get_entry()
    {
      return this.entry;
    }
    public List<world_step__rule_group__race_rule__entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<world_step__rule_group__race_rule__entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__race_rule__entry>? value)
    {
      this.entry = value;
    }
  }


    public class world_step__rule_group__action_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__action_rule__from_person>? from_person = new List<world_step__rule_group__action_rule__from_person>();
      public world_step__rule_group__action_rule__global? global = null;
      public List<world_step__rule_group__action_rule__person_to_person>? person_to_person = new List<world_step__rule_group__action_rule__person_to_person>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule");
        //Deserialize arguments

        //Deserialize children
        this.from_person = rawNode.InitializeWithRawNode("from_person", this.from_person);
        this.global = rawNode.InitializeWithRawNode("global", this.global);
        this.person_to_person = rawNode.InitializeWithRawNode("person_to_person", this.person_to_person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["from_person"] = from_person.Select(x => x.SerializeIntoRawNode()).ToList();
        if(global != null) {
          rawNode.children["global"] = new List<RawNode> { global.SerializeIntoRawNode() };
        }
        rawNode.children["person_to_person"] = person_to_person.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__action_rule__from_person>? Get_from_person()
    {
      return this.from_person;
    }
    public List<world_step__rule_group__action_rule__from_person> GetOrInsertDefault_from_person()
    {
      if(this.from_person == null) {
        this.from_person = new List<world_step__rule_group__action_rule__from_person>();
      }
      return this.from_person;
    }
    public void Set_from_person(List<world_step__rule_group__action_rule__from_person>? value)
    {
      this.from_person = value;
    }
    public world_step__rule_group__action_rule__global? Get_global()
    {
      return this.global;
    }
    public world_step__rule_group__action_rule__global GetOrInsertDefault_global()
    {
      if(this.global == null) {
        this.global = new world_step__rule_group__action_rule__global();
      }
      return this.global;
    }
    public void Set_global(world_step__rule_group__action_rule__global? value)
    {
      this.global = value;
    }
    public List<world_step__rule_group__action_rule__person_to_person>? Get_person_to_person()
    {
      return this.person_to_person;
    }
    public List<world_step__rule_group__action_rule__person_to_person> GetOrInsertDefault_person_to_person()
    {
      if(this.person_to_person == null) {
        this.person_to_person = new List<world_step__rule_group__action_rule__person_to_person>();
      }
      return this.person_to_person;
    }
    public void Set_person_to_person(List<world_step__rule_group__action_rule__person_to_person>? value)
    {
      this.person_to_person = value;
    }
  }


    public class world_step__rule_group__events_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__events_rule__entry>? entry = new List<world_step__rule_group__events_rule__entry>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__events_rule");
        //Deserialize arguments

        //Deserialize children
        this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__events_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__events_rule__entry>? Get_entry()
    {
      return this.entry;
    }
    public List<world_step__rule_group__events_rule__entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<world_step__rule_group__events_rule__entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__events_rule__entry>? value)
    {
      this.entry = value;
    }
  }


    public class world_step__rule_group__link_group_rule_list  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__link_group_rule_list__link_group_rule>? link_group_rule = new List<world_step__rule_group__link_group_rule_list__link_group_rule>();
      public world_step__rule_group__link_group_rule_list()
      {
      }

      public world_step__rule_group__link_group_rule_list(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__link_group_rule_list(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__link_group_rule_list");
        //Deserialize arguments

        //Deserialize children
        this.link_group_rule = rawNode.InitializeWithRawNode("link_group_rule", this.link_group_rule);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["link_group_rule"] = link_group_rule.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__link_group_rule_list");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__link_group_rule_list__link_group_rule>? Get_link_group_rule()
    {
      return this.link_group_rule;
    }
    public List<world_step__rule_group__link_group_rule_list__link_group_rule> GetOrInsertDefault_link_group_rule()
    {
      if(this.link_group_rule == null) {
        this.link_group_rule = new List<world_step__rule_group__link_group_rule_list__link_group_rule>();
      }
      return this.link_group_rule;
    }
    public void Set_link_group_rule(List<world_step__rule_group__link_group_rule_list__link_group_rule>? value)
    {
      this.link_group_rule = value;
    }
  }


    public class world_step__rule_group__location_graph_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;

      //Children elements
      public world_step__rule_group__location_graph_rule__setup setup = new world_step__rule_group__location_graph_rule__setup();
      public List<world_step__rule_group__location_graph_rule__node_rule>? node_rule = new List<world_step__rule_group__location_graph_rule__node_rule>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("id"))
        {
          var attribute_id = rawNode.attributes["id"];
          this.id = rawNode.attributes["id"];
        }

        //Deserialize children
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

        //Serialize children
        if(setup != null) {
          rawNode.children["setup"] = new List<RawNode> { setup.SerializeIntoRawNode() };
        }
        rawNode.children["node_rule"] = node_rule.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public world_step__rule_group__location_graph_rule__setup Get_setup()
    {
      return this.setup;
    }
    public world_step__rule_group__location_graph_rule__setup GetOrInsertDefault_setup()
    {
      if(this.setup == null) {
        this.setup = new world_step__rule_group__location_graph_rule__setup();
      }
      return this.setup;
    }
    public void Set_setup(world_step__rule_group__location_graph_rule__setup value)
    {
      this.setup = value;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule>? Get_node_rule()
    {
      return this.node_rule;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule> GetOrInsertDefault_node_rule()
    {
      if(this.node_rule == null) {
        this.node_rule = new List<world_step__rule_group__location_graph_rule__node_rule>();
      }
      return this.node_rule;
    }
    public void Set_node_rule(List<world_step__rule_group__location_graph_rule__node_rule>? value)
    {
      this.node_rule = value;
    }
  }


    public class world_step__rule_group__location_classification_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__location_classification_rule__entry> entry = new List<world_step__rule_group__location_classification_rule__entry>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__location_classification_rule");
        //Deserialize arguments

        //Deserialize children
        this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_classification_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__location_classification_rule__entry> Get_entry()
    {
      return this.entry;
    }
    public List<world_step__rule_group__location_classification_rule__entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<world_step__rule_group__location_classification_rule__entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__location_classification_rule__entry> value)
    {
      this.entry = value;
    }
  }


    public class world_step__data__people  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__data__people__person>? person = new List<world_step__data__people__person>();
      public world_step__data__people()
      {
      }

      public world_step__data__people(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__people(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__people");
        //Deserialize arguments

        //Deserialize children
        this.person = rawNode.InitializeWithRawNode("person", this.person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["person"] = person.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__people");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__data__people__person>? Get_person()
    {
      return this.person;
    }
    public List<world_step__data__people__person> GetOrInsertDefault_person()
    {
      if(this.person == null) {
        this.person = new List<world_step__data__people__person>();
      }
      return this.person;
    }
    public void Set_person(List<world_step__data__people__person>? value)
    {
      this.person = value;
    }
  }


    public class world_step__data__location  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__data__location__location_graph>? location_graph = new List<world_step__data__location__location_graph>();
      public world_step__data__location()
      {
      }

      public world_step__data__location(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location");
        //Deserialize arguments

        //Deserialize children
        this.location_graph = rawNode.InitializeWithRawNode("location_graph", this.location_graph);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["location_graph"] = location_graph.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__data__location__location_graph>? Get_location_graph()
    {
      return this.location_graph;
    }
    public List<world_step__data__location__location_graph> GetOrInsertDefault_location_graph()
    {
      if(this.location_graph == null) {
        this.location_graph = new List<world_step__data__location__location_graph>();
      }
      return this.location_graph;
    }
    public void Set_location_graph(List<world_step__data__location__location_graph>? value)
    {
      this.location_graph = value;
    }
  }


    public class world_step__actions__by  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String person_ref;

      //Children elements
      public world_step__actions__by__do _do = new world_step__actions__by__do();
      public world_step__actions__by__move_towards move_towards = new world_step__actions__by__move_towards();
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
        // Godot.GD.Print("Deserializing world_step__actions__by");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("person_ref"))
        {
          var attribute_person_ref = rawNode.attributes["person_ref"];
          this.person_ref = rawNode.attributes["person_ref"];
        }

        //Deserialize children
        this._do = rawNode.InitializeWithRawNode("do", this._do);
        this.move_towards = rawNode.InitializeWithRawNode("move_towards", this.move_towards);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.person_ref != null)
        {
          rawNode.attributes["person_ref"] = this.person_ref.ToString();
        }

        //Serialize children
        if(_do != null) {
          rawNode.children["do"] = new List<RawNode> { _do.SerializeIntoRawNode() };
        }
        if(move_towards != null) {
          rawNode.children["move_towards"] = new List<RawNode> { move_towards.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__by");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_person_ref()
    {
      return this.person_ref;
    }
    public void Set_person_ref(System.String value)
    {
      this.person_ref = value;
    }
    public world_step__actions__by__do Get__do()
    {
      return this._do;
    }
    public world_step__actions__by__do GetOrInsertDefault__do()
    {
      if(this._do == null) {
        this._do = new world_step__actions__by__do();
      }
      return this._do;
    }
    public void Set__do(world_step__actions__by__do value)
    {
      this._do = value;
    }
    public world_step__actions__by__move_towards Get_move_towards()
    {
      return this.move_towards;
    }
    public world_step__actions__by__move_towards GetOrInsertDefault_move_towards()
    {
      if(this.move_towards == null) {
        this.move_towards = new world_step__actions__by__move_towards();
      }
      return this.move_towards;
    }
    public void Set_move_towards(world_step__actions__by__move_towards value)
    {
      this.move_towards = value;
    }
  }


    public class world_step__actions__location_graph__create  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String location_graph_rule_ref;

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
        // Godot.GD.Print("Deserializing world_step__actions__location_graph__create");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("location_graph_rule_ref"))
        {
          var attribute_location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
          this.location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.location_graph_rule_ref != null)
        {
          rawNode.attributes["location_graph_rule_ref"] = this.location_graph_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__location_graph__create");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_location_graph_rule_ref()
    {
      return this.location_graph_rule_ref;
    }
    public void Set_location_graph_rule_ref(System.String value)
    {
      this.location_graph_rule_ref = value;
    }
  }


    public class world_step__actions__location_graph__node__create_adjacent  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String location_graph_id_ref;
      public System.String node_id_ref;

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
        // Godot.GD.Print("Deserializing world_step__actions__location_graph__node__create_adjacent");
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

        //Deserialize children
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

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__location_graph__node__create_adjacent");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String value)
    {
      this.location_graph_id_ref = value;
    }
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }
  }


    public class world_step__actions__location_graph__node__add_classification  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__node_graph__selection node_graph_selection = new type__node_graph__selection();
      public world_step__actions__location_graph__node__add_classification__to_be_added__classification to_be_added__classification = new world_step__actions__location_graph__node__add_classification__to_be_added__classification();
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
        // Godot.GD.Print("Deserializing world_step__actions__location_graph__node__add_classification");
        //Deserialize arguments

        //Deserialize children
        this.node_graph_selection = rawNode.InitializeWithRawNode("node_graph_selection", this.node_graph_selection);
        this.to_be_added__classification = rawNode.InitializeWithRawNode("to_be_added__classification", this.to_be_added__classification);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(node_graph_selection != null) {
          rawNode.children["node_graph_selection"] = new List<RawNode> { node_graph_selection.SerializeIntoRawNode() };
        }
        if(to_be_added__classification != null) {
          rawNode.children["to_be_added__classification"] = new List<RawNode> { to_be_added__classification.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__location_graph__node__add_classification");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__node_graph__selection Get_node_graph_selection()
    {
      return this.node_graph_selection;
    }
    public void Set_node_graph_selection(type__node_graph__selection value)
    {
      this.node_graph_selection = value;
    }
    public world_step__actions__location_graph__node__add_classification__to_be_added__classification Get_to_be_added__classification()
    {
      return this.to_be_added__classification;
    }
    public world_step__actions__location_graph__node__add_classification__to_be_added__classification GetOrInsertDefault_to_be_added__classification()
    {
      if(this.to_be_added__classification == null) {
        this.to_be_added__classification = new world_step__actions__location_graph__node__add_classification__to_be_added__classification();
      }
      return this.to_be_added__classification;
    }
    public void Set_to_be_added__classification(world_step__actions__location_graph__node__add_classification__to_be_added__classification value)
    {
      this.to_be_added__classification = value;
    }
  }


    public class world_step__actions__person__teleport  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String person_id_ref;

      //Children elements
      public world_step__actions__person__teleport__location_graph? location_graph = null;
      public world_step__actions__person__teleport__link_to link_to = new world_step__actions__person__teleport__link_to();
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
        // Godot.GD.Print("Deserializing world_step__actions__person__teleport");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("person_id_ref"))
        {
          var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
          this.person_id_ref = rawNode.attributes["person_id_ref"];
        }

        //Deserialize children
        this.location_graph = rawNode.InitializeWithRawNode("location_graph", this.location_graph);
        this.link_to = rawNode.InitializeWithRawNode("link_to", this.link_to);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.person_id_ref != null)
        {
          rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
        }

        //Serialize children
        if(location_graph != null) {
          rawNode.children["location_graph"] = new List<RawNode> { location_graph.SerializeIntoRawNode() };
        }
        if(link_to != null) {
          rawNode.children["link_to"] = new List<RawNode> { link_to.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__person__teleport");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public world_step__actions__person__teleport__location_graph? Get_location_graph()
    {
      return this.location_graph;
    }
    public world_step__actions__person__teleport__location_graph GetOrInsertDefault_location_graph()
    {
      if(this.location_graph == null) {
        this.location_graph = new world_step__actions__person__teleport__location_graph();
      }
      return this.location_graph;
    }
    public void Set_location_graph(world_step__actions__person__teleport__location_graph? value)
    {
      this.location_graph = value;
    }
    public world_step__actions__person__teleport__link_to Get_link_to()
    {
      return this.link_to;
    }
    public world_step__actions__person__teleport__link_to GetOrInsertDefault_link_to()
    {
      if(this.link_to == null) {
        this.link_to = new world_step__actions__person__teleport__link_to();
      }
      return this.link_to;
    }
    public void Set_link_to(world_step__actions__person__teleport__link_to value)
    {
      this.link_to = value;
    }
  }


    public class world_step__actions__person__on_person__property_mutation  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String person_id_ref;
      public System.String target_person_id_ref;
      public System.String action_property_mutation_rule_ref;

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
        // Godot.GD.Print("Deserializing world_step__actions__person__on_person__property_mutation");
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

        //Deserialize children
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

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__person__on_person__property_mutation");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public System.String Get_target_person_id_ref()
    {
      return this.target_person_id_ref;
    }
    public void Set_target_person_id_ref(System.String value)
    {
      this.target_person_id_ref = value;
    }
    public System.String Get_action_property_mutation_rule_ref()
    {
      return this.action_property_mutation_rule_ref;
    }
    public void Set_action_property_mutation_rule_ref(System.String value)
    {
      this.action_property_mutation_rule_ref = value;
    }
  }


    public class world_step__actions__person__create  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__node_graph__selection node_graph__selection = new type__node_graph__selection();
      public type__person_selection person__selection = new type__person_selection();
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
        // Godot.GD.Print("Deserializing world_step__actions__person__create");
        //Deserialize arguments

        //Deserialize children
        this.node_graph__selection = rawNode.InitializeWithRawNode("node_graph__selection", this.node_graph__selection);
        this.person__selection = rawNode.InitializeWithRawNode("person__selection", this.person__selection);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(node_graph__selection != null) {
          rawNode.children["node_graph__selection"] = new List<RawNode> { node_graph__selection.SerializeIntoRawNode() };
        }
        if(person__selection != null) {
          rawNode.children["person__selection"] = new List<RawNode> { person__selection.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__person__create");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__node_graph__selection Get_node_graph__selection()
    {
      return this.node_graph__selection;
    }
    public void Set_node_graph__selection(type__node_graph__selection value)
    {
      this.node_graph__selection = value;
    }
    public type__person_selection Get_person__selection()
    {
      return this.person__selection;
    }
    public void Set_person__selection(type__person_selection value)
    {
      this.person__selection = value;
    }
  }


    public class world_step__actions__person__move_to  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String person_id_ref;

      //Children elements
      public type__node_graph__selection? find_path_towards = null;
      public world_step__actions__person__move_to__path? path = null;
      public world_step__actions__person__move_to()
      {
      }

      public world_step__actions__person__move_to(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__actions__person__move_to(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__actions__person__move_to");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("person_id_ref"))
        {
          var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
          this.person_id_ref = rawNode.attributes["person_id_ref"];
        }

        //Deserialize children
        this.find_path_towards = rawNode.InitializeWithRawNode("find_path_towards", this.find_path_towards);
        this.path = rawNode.InitializeWithRawNode("path", this.path);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.person_id_ref != null)
        {
          rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
        }

        //Serialize children
        if(find_path_towards != null) {
          rawNode.children["find_path_towards"] = new List<RawNode> { find_path_towards.SerializeIntoRawNode() };
        }
        if(path != null) {
          rawNode.children["path"] = new List<RawNode> { path.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__person__move_to");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public type__node_graph__selection? Get_find_path_towards()
    {
      return this.find_path_towards;
    }
    public void Set_find_path_towards(type__node_graph__selection? value)
    {
      this.find_path_towards = value;
    }
    public world_step__actions__person__move_to__path? Get_path()
    {
      return this.path;
    }
    public world_step__actions__person__move_to__path GetOrInsertDefault_path()
    {
      if(this.path == null) {
        this.path = new world_step__actions__person__move_to__path();
      }
      return this.path;
    }
    public void Set_path(world_step__actions__person__move_to__path? value)
    {
      this.path = value;
    }
  }


    public class world_step__actions__from_person  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String person_id_ref;
      public System.String from_person_rule_ref;

      //Children elements
      public world_step__actions__from_person__on_person on_person = new world_step__actions__from_person__on_person();
      public world_step__actions__from_person()
      {
      }

      public world_step__actions__from_person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__actions__from_person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__actions__from_person");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("person_id_ref"))
        {
          var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
          this.person_id_ref = rawNode.attributes["person_id_ref"];
        }
        if(rawNode.attributes.ContainsKey("from_person_rule_ref"))
        {
          var attribute_from_person_rule_ref = rawNode.attributes["from_person_rule_ref"];
          this.from_person_rule_ref = rawNode.attributes["from_person_rule_ref"];
        }

        //Deserialize children
        this.on_person = rawNode.InitializeWithRawNode("on_person", this.on_person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.person_id_ref != null)
        {
          rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
        }
        if(this.from_person_rule_ref != null)
        {
          rawNode.attributes["from_person_rule_ref"] = this.from_person_rule_ref.ToString();
        }

        //Serialize children
        if(on_person != null) {
          rawNode.children["on_person"] = new List<RawNode> { on_person.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__from_person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public System.String Get_from_person_rule_ref()
    {
      return this.from_person_rule_ref;
    }
    public void Set_from_person_rule_ref(System.String value)
    {
      this.from_person_rule_ref = value;
    }
    public world_step__actions__from_person__on_person Get_on_person()
    {
      return this.on_person;
    }
    public world_step__actions__from_person__on_person GetOrInsertDefault_on_person()
    {
      if(this.on_person == null) {
        this.on_person = new world_step__actions__from_person__on_person();
      }
      return this.on_person;
    }
    public void Set_on_person(world_step__actions__from_person__on_person value)
    {
      this.on_person = value;
    }
  }


    public class world_step__world_metadata__randomization_table__entry  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.Int32? value;

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
        // Godot.GD.Print("Deserializing world_step__world_metadata__randomization_table__entry");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("value"))
        {
          var attribute_value = rawNode.attributes["value"];
          this.value = attribute_value?.ToInt();
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.value != null)
        {
          rawNode.attributes["value"] = this.value?.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__world_metadata__randomization_table__entry");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32? Get_value()
    {
      return this.value;
    }
    public void Set_value(System.Int32? value)
    {
      this.value = value;
    }
  }


    public class world_step__rule_group__property_rule__entry  {
      public RawNode rawNode = new RawNode();
      //Attributes
      /* ignored attribute key={key} of type=System.Object*/
      /* ignored attribute key={key} of type=System.Object*/

      //Children elements
      public world_step__rule_group__property_rule__entry__person_default? person_default = null;
      public world_step__rule_group__property_rule__entry__item_default? item_default = null;
      public List<world_step__rule_group__property_rule__entry__property_threshold>? property_threshold = new List<world_step__rule_group__property_rule__entry__property_threshold>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry");
        //Deserialize arguments

        //Deserialize children
        this.person_default = rawNode.InitializeWithRawNode("person_default", this.person_default);
        this.item_default = rawNode.InitializeWithRawNode("item_default", this.item_default);
        this.property_threshold = rawNode.InitializeWithRawNode("property-threshold", this.property_threshold);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(person_default != null) {
          rawNode.children["person_default"] = new List<RawNode> { person_default.SerializeIntoRawNode() };
        }
        if(item_default != null) {
          rawNode.children["item_default"] = new List<RawNode> { item_default.SerializeIntoRawNode() };
        }
        rawNode.children["property-threshold"] = property_threshold.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__property_rule__entry");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    /* ignored attribute key={key} of type=System.Object*/
    /* ignored attribute key={key} of type=System.Object*/
    public world_step__rule_group__property_rule__entry__person_default? Get_person_default()
    {
      return this.person_default;
    }
    public void Set_person_default(world_step__rule_group__property_rule__entry__person_default? value)
    {
      this.person_default = value;
    }
    public world_step__rule_group__property_rule__entry__item_default? Get_item_default()
    {
      return this.item_default;
    }
    public void Set_item_default(world_step__rule_group__property_rule__entry__item_default? value)
    {
      this.item_default = value;
    }
    public List<world_step__rule_group__property_rule__entry__property_threshold>? Get_property_threshold()
    {
      return this.property_threshold;
    }
    public List<world_step__rule_group__property_rule__entry__property_threshold> GetOrInsertDefault_property_threshold()
    {
      if(this.property_threshold == null) {
        this.property_threshold = new List<world_step__rule_group__property_rule__entry__property_threshold>();
      }
      return this.property_threshold;
    }
    public void Set_property_threshold(List<world_step__rule_group__property_rule__entry__property_threshold>? value)
    {
      this.property_threshold = value;
    }
  }


    public class world_step__rule_group__classification_rule__entry  {
      public RawNode rawNode = new RawNode();
      //Attributes
      /* ignored attribute key={key} of type=System.Object*/

      //Children elements
      public List<group__math_operations>? property = new List<group__math_operations>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__classification_rule__entry");
        //Deserialize arguments

        //Deserialize children
        this.property = rawNode.InitializeWithRawNode("property", this.property);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__classification_rule__entry");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    /* ignored attribute key={key} of type=System.Object*/
    public List<group__math_operations>? Get_property()
    {
      return this.property;
    }
    public void Set_property(List<group__math_operations>? value)
    {
      this.property = value;
    }
  }


    public class group__name_token  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<group__name_token__name_token> name_token = new List<group__name_token__name_token>();
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
        // Godot.GD.Print("Deserializing group__name_token");
        //Deserialize arguments

        //Deserialize children
        this.name_token = rawNode.InitializeWithRawNode("name_token", this.name_token);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["name_token"] = name_token.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing group__name_token");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<group__name_token__name_token> Get_name_token()
    {
      return this.name_token;
    }
    public void Set_name_token(List<group__name_token__name_token> value)
    {
      this.name_token = value;
    }
  }


    public class world_step__rule_group__race_rule__entry  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;

      //Children elements
      public type_range? vision = null;
      public type_range? movement = null;
      public world_step__rule_group__race_rule__entry__name? name = null;
      public List<group__math_operations>? property_bonus = new List<group__math_operations>();
      public type_icon? icon = null;
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
        // Godot.GD.Print("Deserializing world_step__rule_group__race_rule__entry");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("id"))
        {
          var attribute_id = rawNode.attributes["id"];
          this.id = rawNode.attributes["id"];
        }

        //Deserialize children
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

        //Serialize children
        if(vision != null) {
          rawNode.children["vision"] = new List<RawNode> { vision.SerializeIntoRawNode() };
        }
        if(movement != null) {
          rawNode.children["movement"] = new List<RawNode> { movement.SerializeIntoRawNode() };
        }
        if(name != null) {
          rawNode.children["name"] = new List<RawNode> { name.SerializeIntoRawNode() };
        }
        rawNode.children["property_bonus"] = property_bonus.Select(x => x.SerializeIntoRawNode()).ToList();
        if(icon != null) {
          rawNode.children["icon"] = new List<RawNode> { icon.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__race_rule__entry");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public type_range? Get_vision()
    {
      return this.vision;
    }
    public void Set_vision(type_range? value)
    {
      this.vision = value;
    }
    public type_range? Get_movement()
    {
      return this.movement;
    }
    public void Set_movement(type_range? value)
    {
      this.movement = value;
    }
    public world_step__rule_group__race_rule__entry__name? Get_name()
    {
      return this.name;
    }
    public world_step__rule_group__race_rule__entry__name GetOrInsertDefault_name()
    {
      if(this.name == null) {
        this.name = new world_step__rule_group__race_rule__entry__name();
      }
      return this.name;
    }
    public void Set_name(world_step__rule_group__race_rule__entry__name? value)
    {
      this.name = value;
    }
    public List<group__math_operations>? Get_property_bonus()
    {
      return this.property_bonus;
    }
    public void Set_property_bonus(List<group__math_operations>? value)
    {
      this.property_bonus = value;
    }
    public type_icon? Get_icon()
    {
      return this.icon;
    }
    public void Set_icon(type_icon? value)
    {
      this.icon = value;
    }
  }


    public class world_step__rule_group__action_rule__from_person  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;

      //Children elements
      public type__person_selection? selection = null;
      public world_step__rule_group__action_rule__from_person__mutations? mutations = null;
      public world_step__rule_group__action_rule__from_person__on_person? on_person = null;
      public world_step__rule_group__action_rule__from_person()
      {
      }

      public world_step__rule_group__action_rule__from_person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__action_rule__from_person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__from_person");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("id"))
        {
          var attribute_id = rawNode.attributes["id"];
          this.id = rawNode.attributes["id"];
        }

        //Deserialize children
        this.selection = rawNode.InitializeWithRawNode("selection", this.selection);
        this.mutations = rawNode.InitializeWithRawNode("mutations", this.mutations);
        this.on_person = rawNode.InitializeWithRawNode("on_person", this.on_person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.id != null)
        {
          rawNode.attributes["id"] = this.id.ToString();
        }

        //Serialize children
        if(selection != null) {
          rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
        }
        if(mutations != null) {
          rawNode.children["mutations"] = new List<RawNode> { mutations.SerializeIntoRawNode() };
        }
        if(on_person != null) {
          rawNode.children["on_person"] = new List<RawNode> { on_person.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__from_person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public type__person_selection? Get_selection()
    {
      return this.selection;
    }
    public void Set_selection(type__person_selection? value)
    {
      this.selection = value;
    }
    public world_step__rule_group__action_rule__from_person__mutations? Get_mutations()
    {
      return this.mutations;
    }
    public world_step__rule_group__action_rule__from_person__mutations GetOrInsertDefault_mutations()
    {
      if(this.mutations == null) {
        this.mutations = new world_step__rule_group__action_rule__from_person__mutations();
      }
      return this.mutations;
    }
    public void Set_mutations(world_step__rule_group__action_rule__from_person__mutations? value)
    {
      this.mutations = value;
    }
    public world_step__rule_group__action_rule__from_person__on_person? Get_on_person()
    {
      return this.on_person;
    }
    public world_step__rule_group__action_rule__from_person__on_person GetOrInsertDefault_on_person()
    {
      if(this.on_person == null) {
        this.on_person = new world_step__rule_group__action_rule__from_person__on_person();
      }
      return this.on_person;
    }
    public void Set_on_person(world_step__rule_group__action_rule__from_person__on_person? value)
    {
      this.on_person = value;
    }
  }


    public class world_step__rule_group__action_rule__global  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__action_rule__global__entry>? entry = new List<world_step__rule_group__action_rule__global__entry>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__global");
        //Deserialize arguments

        //Deserialize children
        this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__global");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__action_rule__global__entry>? Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<world_step__rule_group__action_rule__global__entry>? value)
    {
      this.entry = value;
    }
  }


    public class world_step__rule_group__action_rule__person_to_person  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;

      //Children elements
      public world_step__rule_group__action_rule__person_to_person__test test = new world_step__rule_group__action_rule__person_to_person__test();
      public type__property_mutation_on? property_mutation = null;
      public world_step__rule_group__action_rule__person_to_person__location_mutation? location_mutation = null;
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
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("id"))
        {
          var attribute_id = rawNode.attributes["id"];
          this.id = rawNode.attributes["id"];
        }

        //Deserialize children
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

        //Serialize children
        if(test != null) {
          rawNode.children["test"] = new List<RawNode> { test.SerializeIntoRawNode() };
        }
        if(property_mutation != null) {
          rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
        }
        if(location_mutation != null) {
          rawNode.children["location_mutation"] = new List<RawNode> { location_mutation.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__person_to_person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public world_step__rule_group__action_rule__person_to_person__test Get_test()
    {
      return this.test;
    }
    public world_step__rule_group__action_rule__person_to_person__test GetOrInsertDefault_test()
    {
      if(this.test == null) {
        this.test = new world_step__rule_group__action_rule__person_to_person__test();
      }
      return this.test;
    }
    public void Set_test(world_step__rule_group__action_rule__person_to_person__test value)
    {
      this.test = value;
    }
    public type__property_mutation_on? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(type__property_mutation_on? value)
    {
      this.property_mutation = value;
    }
    public world_step__rule_group__action_rule__person_to_person__location_mutation? Get_location_mutation()
    {
      return this.location_mutation;
    }
    public world_step__rule_group__action_rule__person_to_person__location_mutation GetOrInsertDefault_location_mutation()
    {
      if(this.location_mutation == null) {
        this.location_mutation = new world_step__rule_group__action_rule__person_to_person__location_mutation();
      }
      return this.location_mutation;
    }
    public void Set_location_mutation(world_step__rule_group__action_rule__person_to_person__location_mutation? value)
    {
      this.location_mutation = value;
    }
  }


    public class world_step__rule_group__events_rule__entry  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;

      //Children elements
      public List<type__trigger> when = new List<type__trigger>();
      public List<world_step__rule_group__events_rule__entry__then> then = new List<world_step__rule_group__events_rule__entry__then>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("id"))
        {
          var attribute_id = rawNode.attributes["id"];
          this.id = rawNode.attributes["id"];
        }

        //Deserialize children
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

        //Serialize children
        rawNode.children["when"] = when.Select(x => x.SerializeIntoRawNode()).ToList();
        rawNode.children["then"] = then.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public List<type__trigger> Get_when()
    {
      return this.when;
    }
    public void Set_when(List<type__trigger> value)
    {
      this.when = value;
    }
    public List<world_step__rule_group__events_rule__entry__then> Get_then()
    {
      return this.then;
    }
    public List<world_step__rule_group__events_rule__entry__then> GetOrInsertDefault_then()
    {
      if(this.then == null) {
        this.then = new List<world_step__rule_group__events_rule__entry__then>();
      }
      return this.then;
    }
    public void Set_then(List<world_step__rule_group__events_rule__entry__then> value)
    {
      this.then = value;
    }
  }


    public class world_step__rule_group__link_group_rule_list__link_group_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;
      public System.Int32 angle;
      public System.Int32? angleMax;
      public System.Int32? limit;

      //Children elements
      public List<world_step__rule_group__link_group_rule_list__link_group_rule__to_option>? to_option = new List<world_step__rule_group__link_group_rule_list__link_group_rule__to_option>();
      public world_step__rule_group__link_group_rule_list__link_group_rule()
      {
      }

      public world_step__rule_group__link_group_rule_list__link_group_rule(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__link_group_rule_list__link_group_rule(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__link_group_rule_list__link_group_rule");
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
          this.angleMax = attribute_angleMax?.ToInt();
        }
        if(rawNode.attributes.ContainsKey("limit"))
        {
          var attribute_limit = rawNode.attributes["limit"];
          this.limit = attribute_limit?.ToInt();
        }

        //Deserialize children
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
          rawNode.attributes["angleMax"] = this.angleMax?.ToString();
        }
        if(this.limit != null)
        {
          rawNode.attributes["limit"] = this.limit?.ToString();
        }

        //Serialize children
        rawNode.children["to_option"] = to_option.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__link_group_rule_list__link_group_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public System.Int32 Get_angle()
    {
      return this.angle;
    }
    public void Set_angle(System.Int32 value)
    {
      this.angle = value;
    }
    public System.Int32? Get_angleMax()
    {
      return this.angleMax;
    }
    public void Set_angleMax(System.Int32? value)
    {
      this.angleMax = value;
    }
    public System.Int32? Get_limit()
    {
      return this.limit;
    }
    public void Set_limit(System.Int32? value)
    {
      this.limit = value;
    }
    public List<world_step__rule_group__link_group_rule_list__link_group_rule__to_option>? Get_to_option()
    {
      return this.to_option;
    }
    public List<world_step__rule_group__link_group_rule_list__link_group_rule__to_option> GetOrInsertDefault_to_option()
    {
      if(this.to_option == null) {
        this.to_option = new List<world_step__rule_group__link_group_rule_list__link_group_rule__to_option>();
      }
      return this.to_option;
    }
    public void Set_to_option(List<world_step__rule_group__link_group_rule_list__link_group_rule__to_option>? value)
    {
      this.to_option = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__setup  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public world_step__rule_group__location_graph_rule__setup__starting_node starting_node = new world_step__rule_group__location_graph_rule__setup__starting_node();
      public List<world_step__rule_group__location_graph_rule__setup__necessary_node>? necessary_node = new List<world_step__rule_group__location_graph_rule__setup__necessary_node>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup");
        //Deserialize arguments

        //Deserialize children
        this.starting_node = rawNode.InitializeWithRawNode("starting_node", this.starting_node);
        this.necessary_node = rawNode.InitializeWithRawNode("necessary_node", this.necessary_node);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(starting_node != null) {
          rawNode.children["starting_node"] = new List<RawNode> { starting_node.SerializeIntoRawNode() };
        }
        rawNode.children["necessary_node"] = necessary_node.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__setup");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public world_step__rule_group__location_graph_rule__setup__starting_node Get_starting_node()
    {
      return this.starting_node;
    }
    public world_step__rule_group__location_graph_rule__setup__starting_node GetOrInsertDefault_starting_node()
    {
      if(this.starting_node == null) {
        this.starting_node = new world_step__rule_group__location_graph_rule__setup__starting_node();
      }
      return this.starting_node;
    }
    public void Set_starting_node(world_step__rule_group__location_graph_rule__setup__starting_node value)
    {
      this.starting_node = value;
    }
    public List<world_step__rule_group__location_graph_rule__setup__necessary_node>? Get_necessary_node()
    {
      return this.necessary_node;
    }
    public List<world_step__rule_group__location_graph_rule__setup__necessary_node> GetOrInsertDefault_necessary_node()
    {
      if(this.necessary_node == null) {
        this.necessary_node = new List<world_step__rule_group__location_graph_rule__setup__necessary_node>();
      }
      return this.necessary_node;
    }
    public void Set_necessary_node(List<world_step__rule_group__location_graph_rule__setup__necessary_node>? value)
    {
      this.necessary_node = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__node_rule  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;

      //Children elements
      public world_step__rule_group__location_graph_rule__node_rule__name? name = null;
      public world_step__rule_group__location_graph_rule__node_rule__classifications? classifications = null;
      public world_step__rule_group__location_graph_rule__node_rule__link_group_list? link_group_list = null;
      public world_step__rule_group__location_graph_rule__node_rule__existing_person? existing_person = null;
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
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("id"))
        {
          var attribute_id = rawNode.attributes["id"];
          this.id = rawNode.attributes["id"];
        }

        //Deserialize children
        this.name = rawNode.InitializeWithRawNode("name", this.name);
        this.classifications = rawNode.InitializeWithRawNode("classifications", this.classifications);
        this.link_group_list = rawNode.InitializeWithRawNode("link_group_list", this.link_group_list);
        this.existing_person = rawNode.InitializeWithRawNode("existing_person", this.existing_person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.id != null)
        {
          rawNode.attributes["id"] = this.id.ToString();
        }

        //Serialize children
        if(name != null) {
          rawNode.children["name"] = new List<RawNode> { name.SerializeIntoRawNode() };
        }
        if(classifications != null) {
          rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
        }
        if(link_group_list != null) {
          rawNode.children["link_group_list"] = new List<RawNode> { link_group_list.SerializeIntoRawNode() };
        }
        if(existing_person != null) {
          rawNode.children["existing_person"] = new List<RawNode> { existing_person.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public world_step__rule_group__location_graph_rule__node_rule__name? Get_name()
    {
      return this.name;
    }
    public world_step__rule_group__location_graph_rule__node_rule__name GetOrInsertDefault_name()
    {
      if(this.name == null) {
        this.name = new world_step__rule_group__location_graph_rule__node_rule__name();
      }
      return this.name;
    }
    public void Set_name(world_step__rule_group__location_graph_rule__node_rule__name? value)
    {
      this.name = value;
    }
    public world_step__rule_group__location_graph_rule__node_rule__classifications? Get_classifications()
    {
      return this.classifications;
    }
    public world_step__rule_group__location_graph_rule__node_rule__classifications GetOrInsertDefault_classifications()
    {
      if(this.classifications == null) {
        this.classifications = new world_step__rule_group__location_graph_rule__node_rule__classifications();
      }
      return this.classifications;
    }
    public void Set_classifications(world_step__rule_group__location_graph_rule__node_rule__classifications? value)
    {
      this.classifications = value;
    }
    public world_step__rule_group__location_graph_rule__node_rule__link_group_list? Get_link_group_list()
    {
      return this.link_group_list;
    }
    public world_step__rule_group__location_graph_rule__node_rule__link_group_list GetOrInsertDefault_link_group_list()
    {
      if(this.link_group_list == null) {
        this.link_group_list = new world_step__rule_group__location_graph_rule__node_rule__link_group_list();
      }
      return this.link_group_list;
    }
    public void Set_link_group_list(world_step__rule_group__location_graph_rule__node_rule__link_group_list? value)
    {
      this.link_group_list = value;
    }
    public world_step__rule_group__location_graph_rule__node_rule__existing_person? Get_existing_person()
    {
      return this.existing_person;
    }
    public world_step__rule_group__location_graph_rule__node_rule__existing_person GetOrInsertDefault_existing_person()
    {
      if(this.existing_person == null) {
        this.existing_person = new world_step__rule_group__location_graph_rule__node_rule__existing_person();
      }
      return this.existing_person;
    }
    public void Set_existing_person(world_step__rule_group__location_graph_rule__node_rule__existing_person? value)
    {
      this.existing_person = value;
    }
  }


    public class world_step__rule_group__location_classification_rule__entry  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;

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
        // Godot.GD.Print("Deserializing world_step__rule_group__location_classification_rule__entry");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("id"))
        {
          var attribute_id = rawNode.attributes["id"];
          this.id = rawNode.attributes["id"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.id != null)
        {
          rawNode.attributes["id"] = this.id.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_classification_rule__entry");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
  }


    public class world_step__data__people__person  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;
      public System.String? name;

      //Children elements
      public world_step__data__people__person__race? race = null;
      public world_step__data__people__person__properties? properties = null;
      public List<world_step__data__people__person__relations>? relations = new List<world_step__data__people__person__relations>();
      public world_step__data__people__person__classifications? classifications = null;
      public type_icon? icon = null;
      public world_step__data__people__person()
      {
      }

      public world_step__data__people__person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__people__person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__people__person");
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

        //Deserialize children
        this.race = rawNode.InitializeWithRawNode("race", this.race);
        this.properties = rawNode.InitializeWithRawNode("properties", this.properties);
        this.relations = rawNode.InitializeWithRawNode("relations", this.relations);
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
          rawNode.attributes["name"] = this.name?.ToString();
        }

        //Serialize children
        if(race != null) {
          rawNode.children["race"] = new List<RawNode> { race.SerializeIntoRawNode() };
        }
        if(properties != null) {
          rawNode.children["properties"] = new List<RawNode> { properties.SerializeIntoRawNode() };
        }
        rawNode.children["relations"] = relations.Select(x => x.SerializeIntoRawNode()).ToList();
        if(classifications != null) {
          rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
        }
        if(icon != null) {
          rawNode.children["icon"] = new List<RawNode> { icon.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__people__person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public System.String? Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String? value)
    {
      this.name = value;
    }
    public world_step__data__people__person__race? Get_race()
    {
      return this.race;
    }
    public world_step__data__people__person__race GetOrInsertDefault_race()
    {
      if(this.race == null) {
        this.race = new world_step__data__people__person__race();
      }
      return this.race;
    }
    public void Set_race(world_step__data__people__person__race? value)
    {
      this.race = value;
    }
    public world_step__data__people__person__properties? Get_properties()
    {
      return this.properties;
    }
    public world_step__data__people__person__properties GetOrInsertDefault_properties()
    {
      if(this.properties == null) {
        this.properties = new world_step__data__people__person__properties();
      }
      return this.properties;
    }
    public void Set_properties(world_step__data__people__person__properties? value)
    {
      this.properties = value;
    }
    public List<world_step__data__people__person__relations>? Get_relations()
    {
      return this.relations;
    }
    public List<world_step__data__people__person__relations> GetOrInsertDefault_relations()
    {
      if(this.relations == null) {
        this.relations = new List<world_step__data__people__person__relations>();
      }
      return this.relations;
    }
    public void Set_relations(List<world_step__data__people__person__relations>? value)
    {
      this.relations = value;
    }
    public world_step__data__people__person__classifications? Get_classifications()
    {
      return this.classifications;
    }
    public world_step__data__people__person__classifications GetOrInsertDefault_classifications()
    {
      if(this.classifications == null) {
        this.classifications = new world_step__data__people__person__classifications();
      }
      return this.classifications;
    }
    public void Set_classifications(world_step__data__people__person__classifications? value)
    {
      this.classifications = value;
    }
    public type_icon? Get_icon()
    {
      return this.icon;
    }
    public void Set_icon(type_icon? value)
    {
      this.icon = value;
    }
  }


    public class world_step__data__location__location_graph  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String? id;

      //Children elements
      public world_step__data__location__location_graph__rule rule = new world_step__data__location__location_graph__rule();
      public List<world_step__data__location__location_graph__node> node = new List<world_step__data__location__location_graph__node>();
      public world_step__data__location__location_graph()
      {
      }

      public world_step__data__location__location_graph(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("id"))
        {
          var attribute_id = rawNode.attributes["id"];
          this.id = rawNode.attributes["id"];
        }

        //Deserialize children
        this.rule = rawNode.InitializeWithRawNode("rule", this.rule);
        this.node = rawNode.InitializeWithRawNode("node", this.node);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.id != null)
        {
          rawNode.attributes["id"] = this.id?.ToString();
        }

        //Serialize children
        if(rule != null) {
          rawNode.children["rule"] = new List<RawNode> { rule.SerializeIntoRawNode() };
        }
        rawNode.children["node"] = node.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String? Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String? value)
    {
      this.id = value;
    }
    public world_step__data__location__location_graph__rule Get_rule()
    {
      return this.rule;
    }
    public world_step__data__location__location_graph__rule GetOrInsertDefault_rule()
    {
      if(this.rule == null) {
        this.rule = new world_step__data__location__location_graph__rule();
      }
      return this.rule;
    }
    public void Set_rule(world_step__data__location__location_graph__rule value)
    {
      this.rule = value;
    }
    public List<world_step__data__location__location_graph__node> Get_node()
    {
      return this.node;
    }
    public List<world_step__data__location__location_graph__node> GetOrInsertDefault_node()
    {
      if(this.node == null) {
        this.node = new List<world_step__data__location__location_graph__node>();
      }
      return this.node;
    }
    public void Set_node(List<world_step__data__location__location_graph__node> value)
    {
      this.node = value;
    }
  }


    public class world_step__actions__by__do  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String? action_rule_ref;
      public System.String? action_ref;
      public System.String person_ref;

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
        // Godot.GD.Print("Deserializing world_step__actions__by__do");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("action_rule_ref"))
        {
          var attribute_action_rule_ref = rawNode.attributes["action_rule_ref"];
          this.action_rule_ref = rawNode.attributes["action_rule_ref"];
        }
        if(rawNode.attributes.ContainsKey("action_ref"))
        {
          var attribute_action_ref = rawNode.attributes["action_ref"];
          this.action_ref = rawNode.attributes["action_ref"];
        }
        if(rawNode.attributes.ContainsKey("person_ref"))
        {
          var attribute_person_ref = rawNode.attributes["person_ref"];
          this.person_ref = rawNode.attributes["person_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.action_rule_ref != null)
        {
          rawNode.attributes["action_rule_ref"] = this.action_rule_ref?.ToString();
        }
        if(this.action_ref != null)
        {
          rawNode.attributes["action_ref"] = this.action_ref?.ToString();
        }
        if(this.person_ref != null)
        {
          rawNode.attributes["person_ref"] = this.person_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__by__do");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String? Get_action_rule_ref()
    {
      return this.action_rule_ref;
    }
    public void Set_action_rule_ref(System.String? value)
    {
      this.action_rule_ref = value;
    }
    public System.String? Get_action_ref()
    {
      return this.action_ref;
    }
    public void Set_action_ref(System.String? value)
    {
      this.action_ref = value;
    }
    public System.String Get_person_ref()
    {
      return this.person_ref;
    }
    public void Set_person_ref(System.String value)
    {
      this.person_ref = value;
    }
  }


    public class world_step__actions__by__move_towards  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String? layer;
      public System.Int32 x;
      public System.Int32 y;

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
        // Godot.GD.Print("Deserializing world_step__actions__by__move_towards");
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

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.layer != null)
        {
          rawNode.attributes["layer"] = this.layer?.ToString();
        }
        if(this.x != null)
        {
          rawNode.attributes["x"] = this.x.ToString();
        }
        if(this.y != null)
        {
          rawNode.attributes["y"] = this.y.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__by__move_towards");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String? Get_layer()
    {
      return this.layer;
    }
    public void Set_layer(System.String? value)
    {
      this.layer = value;
    }
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
    }
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
    }
  }


    public class type__node_graph__selection  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__node_graph__selection__in__location_graph? in__location_graph = null;
      public type__node_graph__selection__has__node_graph_id? has__node_graph_id = null;
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
        // Godot.GD.Print("Deserializing type__node_graph__selection");
        //Deserialize arguments

        //Deserialize children
        this.in__location_graph = rawNode.InitializeWithRawNode("in__location_graph", this.in__location_graph);
        this.has__node_graph_id = rawNode.InitializeWithRawNode("has__node_graph_id", this.has__node_graph_id);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(in__location_graph != null) {
          rawNode.children["in__location_graph"] = new List<RawNode> { in__location_graph.SerializeIntoRawNode() };
        }
        if(has__node_graph_id != null) {
          rawNode.children["has__node_graph_id"] = new List<RawNode> { has__node_graph_id.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__node_graph__selection");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__node_graph__selection__in__location_graph? Get_in__location_graph()
    {
      return this.in__location_graph;
    }
    public type__node_graph__selection__in__location_graph GetOrInsertDefault_in__location_graph()
    {
      if(this.in__location_graph == null) {
        this.in__location_graph = new type__node_graph__selection__in__location_graph();
      }
      return this.in__location_graph;
    }
    public void Set_in__location_graph(type__node_graph__selection__in__location_graph? value)
    {
      this.in__location_graph = value;
    }
    public type__node_graph__selection__has__node_graph_id? Get_has__node_graph_id()
    {
      return this.has__node_graph_id;
    }
    public type__node_graph__selection__has__node_graph_id GetOrInsertDefault_has__node_graph_id()
    {
      if(this.has__node_graph_id == null) {
        this.has__node_graph_id = new type__node_graph__selection__has__node_graph_id();
      }
      return this.has__node_graph_id;
    }
    public void Set_has__node_graph_id(type__node_graph__selection__has__node_graph_id? value)
    {
      this.has__node_graph_id = value;
    }
  }


    public class world_step__actions__location_graph__node__add_classification__to_be_added__classification  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String location_classification_rule_ref;

      //Children elements
      public world_step__actions__location_graph__node__add_classification__to_be_added__classification__and? and = null;
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
        // Godot.GD.Print("Deserializing world_step__actions__location_graph__node__add_classification__to_be_added__classification");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
        {
          var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
          this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        }

        //Deserialize children
        this.and = rawNode.InitializeWithRawNode("and", this.and);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.location_classification_rule_ref != null)
        {
          rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
        }

        //Serialize children
        if(and != null) {
          rawNode.children["and"] = new List<RawNode> { and.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__location_graph__node__add_classification__to_be_added__classification");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }
    public world_step__actions__location_graph__node__add_classification__to_be_added__classification__and? Get_and()
    {
      return this.and;
    }
    public world_step__actions__location_graph__node__add_classification__to_be_added__classification__and GetOrInsertDefault_and()
    {
      if(this.and == null) {
        this.and = new world_step__actions__location_graph__node__add_classification__to_be_added__classification__and();
      }
      return this.and;
    }
    public void Set_and(world_step__actions__location_graph__node__add_classification__to_be_added__classification__and? value)
    {
      this.and = value;
    }
  }


    public class world_step__actions__person__teleport__location_graph  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String location_graph_id_ref;
      public System.String node_id_ref;

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
        // Godot.GD.Print("Deserializing world_step__actions__person__teleport__location_graph");
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

        //Deserialize children
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

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__person__teleport__location_graph");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String value)
    {
      this.location_graph_id_ref = value;
    }
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }
  }


    public class world_step__actions__person__teleport__link_to  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.Int32 accumulated_progress;

      //Children elements
      public type__link_to__selection selection = new type__link_to__selection();
      public world_step__actions__person__teleport__link_to()
      {
      }

      public world_step__actions__person__teleport__link_to(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__actions__person__teleport__link_to(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__actions__person__teleport__link_to");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("accumulated_progress"))
        {
          var attribute_accumulated_progress = rawNode.attributes["accumulated_progress"];
          this.accumulated_progress = attribute_accumulated_progress.ToInt();
        }

        //Deserialize children
        this.selection = rawNode.InitializeWithRawNode("selection", this.selection);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.accumulated_progress != null)
        {
          rawNode.attributes["accumulated_progress"] = this.accumulated_progress.ToString();
        }

        //Serialize children
        if(selection != null) {
          rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__person__teleport__link_to");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32 Get_accumulated_progress()
    {
      return this.accumulated_progress;
    }
    public void Set_accumulated_progress(System.Int32 value)
    {
      this.accumulated_progress = value;
    }
    public type__link_to__selection Get_selection()
    {
      return this.selection;
    }
    public void Set_selection(type__link_to__selection value)
    {
      this.selection = value;
    }
  }


    public class type__person_selection  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__math_operations? radius = null;
      public type__math_operations? min = null;
      public type__math_operations? max = null;
      public List<type__person_selection__property>? property = new List<type__person_selection__property>();
      public List<type__person_selection__classification>? classification = new List<type__person_selection__classification>();
      public type__person_selection__race? race = null;
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
        // Godot.GD.Print("Deserializing type__person_selection");
        //Deserialize arguments

        //Deserialize children
        this.radius = rawNode.InitializeWithRawNode("radius", this.radius);
        this.min = rawNode.InitializeWithRawNode("min", this.min);
        this.max = rawNode.InitializeWithRawNode("max", this.max);
        this.property = rawNode.InitializeWithRawNode("property", this.property);
        this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
        this.race = rawNode.InitializeWithRawNode("race", this.race);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(radius != null) {
          rawNode.children["radius"] = new List<RawNode> { radius.SerializeIntoRawNode() };
        }
        if(min != null) {
          rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
        }
        if(max != null) {
          rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
        }
        rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
        rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
        if(race != null) {
          rawNode.children["race"] = new List<RawNode> { race.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__person_selection");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__math_operations? Get_radius()
    {
      return this.radius;
    }
    public void Set_radius(type__math_operations? value)
    {
      this.radius = value;
    }
    public type__math_operations? Get_min()
    {
      return this.min;
    }
    public void Set_min(type__math_operations? value)
    {
      this.min = value;
    }
    public type__math_operations? Get_max()
    {
      return this.max;
    }
    public void Set_max(type__math_operations? value)
    {
      this.max = value;
    }
    public List<type__person_selection__property>? Get_property()
    {
      return this.property;
    }
    public List<type__person_selection__property> GetOrInsertDefault_property()
    {
      if(this.property == null) {
        this.property = new List<type__person_selection__property>();
      }
      return this.property;
    }
    public void Set_property(List<type__person_selection__property>? value)
    {
      this.property = value;
    }
    public List<type__person_selection__classification>? Get_classification()
    {
      return this.classification;
    }
    public List<type__person_selection__classification> GetOrInsertDefault_classification()
    {
      if(this.classification == null) {
        this.classification = new List<type__person_selection__classification>();
      }
      return this.classification;
    }
    public void Set_classification(List<type__person_selection__classification>? value)
    {
      this.classification = value;
    }
    public type__person_selection__race? Get_race()
    {
      return this.race;
    }
    public type__person_selection__race GetOrInsertDefault_race()
    {
      if(this.race == null) {
        this.race = new type__person_selection__race();
      }
      return this.race;
    }
    public void Set_race(type__person_selection__race? value)
    {
      this.race = value;
    }
  }


    public class world_step__actions__person__move_to__path  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__actions__person__move_to__path__node>? node = new List<world_step__actions__person__move_to__path__node>();
      public world_step__actions__person__move_to__path()
      {
      }

      public world_step__actions__person__move_to__path(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__actions__person__move_to__path(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__actions__person__move_to__path");
        //Deserialize arguments

        //Deserialize children
        this.node = rawNode.InitializeWithRawNode("node", this.node);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["node"] = node.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__person__move_to__path");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__actions__person__move_to__path__node>? Get_node()
    {
      return this.node;
    }
    public List<world_step__actions__person__move_to__path__node> GetOrInsertDefault_node()
    {
      if(this.node == null) {
        this.node = new List<world_step__actions__person__move_to__path__node>();
      }
      return this.node;
    }
    public void Set_node(List<world_step__actions__person__move_to__path__node>? value)
    {
      this.node = value;
    }
  }


    public class world_step__actions__from_person__on_person  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String person_id_ref;

      //Children elements
      public world_step__actions__from_person__on_person()
      {
      }

      public world_step__actions__from_person__on_person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__actions__from_person__on_person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__actions__from_person__on_person");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("person_id_ref"))
        {
          var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
          this.person_id_ref = rawNode.attributes["person_id_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.person_id_ref != null)
        {
          rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__from_person__on_person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
  }
  public interface Itype__math_operations {
    //Attributes
    public System.Int32 Get_initial();
    public void Set_initial(System.Int32 value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

    public class world_step__rule_group__property_rule__entry__person_default : Itype__math_operations {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Attributes of type__math_operations
      public System.Int32 initial;

      //Children elements

      //Children of type__math_operations

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
        // Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__person_default");
        //Deserialize arguments

        // Deserialize arguments of type__math_operations
  if(rawNode.attributes.ContainsKey("initial"))
  {
    var attribute_initial = rawNode.attributes["initial"];
    this.initial = attribute_initial.ToInt();
  }

        //Deserialize children

        // Deserialize children of type__math_operations

      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        // Serialize arguments of type__math_operations
  if(this.initial != null)
  {
    rawNode.attributes["initial"] = this.initial.ToString();
  }

        //Serialize children

        // Serialize children of type__math_operations

        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__property_rule__entry__person_default");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32 Get_initial()
    {
      return this.initial;
    }
    public void Set_initial(System.Int32 value)
    {
      this.initial = value;
    }
  }


    public class world_step__rule_group__property_rule__entry__item_default : Itype__math_operations {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Attributes of type__math_operations
      public System.Int32 initial;

      //Children elements

      //Children of type__math_operations

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
        // Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__item_default");
        //Deserialize arguments

        // Deserialize arguments of type__math_operations
  if(rawNode.attributes.ContainsKey("initial"))
  {
    var attribute_initial = rawNode.attributes["initial"];
    this.initial = attribute_initial.ToInt();
  }

        //Deserialize children

        // Deserialize children of type__math_operations

      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        // Serialize arguments of type__math_operations
  if(this.initial != null)
  {
    rawNode.attributes["initial"] = this.initial.ToString();
  }

        //Serialize children

        // Serialize children of type__math_operations

        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__property_rule__entry__item_default");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32 Get_initial()
    {
      return this.initial;
    }
    public void Set_initial(System.Int32 value)
    {
      this.initial = value;
    }
  }


    public class world_step__rule_group__property_rule__entry__property_threshold  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String name;
      public System.Int32? min_value_inclusive;
      public System.Int32? max_value_inclusive;

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
        // Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__property_threshold");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("name"))
        {
          var attribute_name = rawNode.attributes["name"];
          this.name = rawNode.attributes["name"];
        }
        if(rawNode.attributes.ContainsKey("min-value-inclusive"))
        {
          var attribute_min_value_inclusive = rawNode.attributes["min-value-inclusive"];
          this.min_value_inclusive = attribute_min_value_inclusive?.ToInt();
        }
        if(rawNode.attributes.ContainsKey("max-value-inclusive"))
        {
          var attribute_max_value_inclusive = rawNode.attributes["max-value-inclusive"];
          this.max_value_inclusive = attribute_max_value_inclusive?.ToInt();
        }

        //Deserialize children
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
          rawNode.attributes["min-value-inclusive"] = this.min_value_inclusive?.ToString();
        }
        if(this.max_value_inclusive != null)
        {
          rawNode.attributes["max-value-inclusive"] = this.max_value_inclusive?.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__property_rule__entry__property_threshold");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String value)
    {
      this.name = value;
    }
    public System.Int32? Get_min_value_inclusive()
    {
      return this.min_value_inclusive;
    }
    public void Set_min_value_inclusive(System.Int32? value)
    {
      this.min_value_inclusive = value;
    }
    public System.Int32? Get_max_value_inclusive()
    {
      return this.max_value_inclusive;
    }
    public void Set_max_value_inclusive(System.Int32? value)
    {
      this.max_value_inclusive = value;
    }
  }


    public class group__math_operations  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public group__operation__and operation = new group__operation__and();
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
        // Godot.GD.Print("Deserializing group__math_operations");
        //Deserialize arguments

        //Deserialize children
        this.operation = rawNode.InitializeWithRawNode("operation", this.operation);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(operation != null) {
          rawNode.children["operation"] = new List<RawNode> { operation.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing group__math_operations");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public group__operation__and Get_operation()
    {
      return this.operation;
    }
    public void Set_operation(group__operation__and value)
    {
      this.operation = value;
    }
  }


    public class group__name_token__name_token  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String prefix;

      //Children elements
      public group__name_token__name_token__ref? _ref = null;
      public group__name_token one_of = new group__name_token();
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
        // Godot.GD.Print("Deserializing group__name_token__name_token");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("prefix"))
        {
          var attribute_prefix = rawNode.attributes["prefix"];
          this.prefix = rawNode.attributes["prefix"];
        }

        //Deserialize children
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

        //Serialize children
        if(_ref != null) {
          rawNode.children["ref"] = new List<RawNode> { _ref.SerializeIntoRawNode() };
        }
        if(one_of != null) {
          rawNode.children["one_of"] = new List<RawNode> { one_of.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing group__name_token__name_token");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_prefix()
    {
      return this.prefix;
    }
    public void Set_prefix(System.String value)
    {
      this.prefix = value;
    }
    public group__name_token__name_token__ref? Get__ref()
    {
      return this._ref;
    }
    public group__name_token__name_token__ref GetOrInsertDefault__ref()
    {
      if(this._ref == null) {
        this._ref = new group__name_token__name_token__ref();
      }
      return this._ref;
    }
    public void Set__ref(group__name_token__name_token__ref? value)
    {
      this._ref = value;
    }
    public group__name_token Get_one_of()
    {
      return this.one_of;
    }
    public void Set_one_of(group__name_token value)
    {
      this.one_of = value;
    }
  }


    public class type_range  {
      public RawNode rawNode = new RawNode();
      //Attributes

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
        // Godot.GD.Print("Deserializing type_range");
        //Deserialize arguments

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type_range");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
  }


    public class world_step__rule_group__race_rule__entry__name  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String name_rule_ref;

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
        // Godot.GD.Print("Deserializing world_step__rule_group__race_rule__entry__name");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("name_rule_ref"))
        {
          var attribute_name_rule_ref = rawNode.attributes["name_rule_ref"];
          this.name_rule_ref = rawNode.attributes["name_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.name_rule_ref != null)
        {
          rawNode.attributes["name_rule_ref"] = this.name_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__race_rule__entry__name");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_name_rule_ref()
    {
      return this.name_rule_ref;
    }
    public void Set_name_rule_ref(System.String value)
    {
      this.name_rule_ref = value;
    }
  }


    public class type_icon  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
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
        // Godot.GD.Print("Deserializing type_icon");
        //Deserialize arguments

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type_icon");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
  }


    public class world_step__rule_group__action_rule__from_person__mutations  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<type__property_mutation>? property_mutation = new List<type__property_mutation>();
      public world_step__rule_group__action_rule__from_person__mutations()
      {
      }

      public world_step__rule_group__action_rule__from_person__mutations(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__action_rule__from_person__mutations(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__from_person__mutations");
        //Deserialize arguments

        //Deserialize children
        this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["property_mutation"] = property_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__from_person__mutations");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<type__property_mutation>? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(List<type__property_mutation>? value)
    {
      this.property_mutation = value;
    }
  }


    public class world_step__rule_group__action_rule__from_person__on_person  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public world_step__rule_group__action_rule__from_person__on_person__selection? selection = null;
      public world_step__rule_group__action_rule__from_person__on_person__mutations? mutations = null;
      public world_step__rule_group__action_rule__from_person__on_person()
      {
      }

      public world_step__rule_group__action_rule__from_person__on_person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__action_rule__from_person__on_person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__from_person__on_person");
        //Deserialize arguments

        //Deserialize children
        this.selection = rawNode.InitializeWithRawNode("selection", this.selection);
        this.mutations = rawNode.InitializeWithRawNode("mutations", this.mutations);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(selection != null) {
          rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
        }
        if(mutations != null) {
          rawNode.children["mutations"] = new List<RawNode> { mutations.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__from_person__on_person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public world_step__rule_group__action_rule__from_person__on_person__selection? Get_selection()
    {
      return this.selection;
    }
    public void Set_selection(world_step__rule_group__action_rule__from_person__on_person__selection? value)
    {
      this.selection = value;
    }
    public world_step__rule_group__action_rule__from_person__on_person__mutations? Get_mutations()
    {
      return this.mutations;
    }
    public world_step__rule_group__action_rule__from_person__on_person__mutations GetOrInsertDefault_mutations()
    {
      if(this.mutations == null) {
        this.mutations = new world_step__rule_group__action_rule__from_person__on_person__mutations();
      }
      return this.mutations;
    }
    public void Set_mutations(world_step__rule_group__action_rule__from_person__on_person__mutations? value)
    {
      this.mutations = value;
    }
  }
  public interface Itype__action {

    //Children elements
    public type__action__from Get_from();
    public void Set_from(type__action__from value);
    public type__action__on Get_on();
    public void Set_on(type__action__on value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

    public class world_step__rule_group__action_rule__global__entry : Itype__action {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;

      //Attributes of type__action

      //Children elements

      //Children of type__action
      public type__action__from from = new type__action__from();
      public type__action__on on = new type__action__on();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__global__entry");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("id"))
        {
          var attribute_id = rawNode.attributes["id"];
          this.id = rawNode.attributes["id"];
        }

        // Deserialize arguments of type__action

        //Deserialize children

        // Deserialize children of type__action
  this.from = rawNode.InitializeWithRawNode("from", this.from);
  this.on = rawNode.InitializeWithRawNode("on", this.on);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.id != null)
        {
          rawNode.attributes["id"] = this.id.ToString();
        }

        // Serialize arguments of type__action


        //Serialize children

        // Serialize children of type__action
  if(from != null) {
    rawNode.children["from"] = new List<RawNode> { from.SerializeIntoRawNode() };
  }
  if(on != null) {
    rawNode.children["on"] = new List<RawNode> { on.SerializeIntoRawNode() };
  }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__global__entry");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public type__action__from Get_from()
    {
      return this.from;
    }
    public type__action__from GetOrInsertDefault_from()
    {
      if(this.from == null) {
        this.from = new type__action__from();
      }
      return this.from;
    }
    public void Set_from(type__action__from value)
    {
      this.from = value;
    }
    public type__action__on Get_on()
    {
      return this.on;
    }
    public type__action__on GetOrInsertDefault_on()
    {
      if(this.on == null) {
        this.on = new type__action__on();
      }
      return this.on;
    }
    public void Set_on(type__action__on value)
    {
      this.on = value;
    }
  }


    public class world_step__rule_group__action_rule__person_to_person__test  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public group__math_operations value = new group__math_operations();
      public group__math_operations expected = new group__math_operations();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person__test");
        //Deserialize arguments

        //Deserialize children
        this.value = rawNode.InitializeWithRawNode("value", this.value);
        this.expected = rawNode.InitializeWithRawNode("expected", this.expected);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(value != null) {
          rawNode.children["value"] = new List<RawNode> { value.SerializeIntoRawNode() };
        }
        if(expected != null) {
          rawNode.children["expected"] = new List<RawNode> { expected.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__person_to_person__test");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public group__math_operations Get_value()
    {
      return this.value;
    }
    public void Set_value(group__math_operations value)
    {
      this.value = value;
    }
    public group__math_operations Get_expected()
    {
      return this.expected;
    }
    public void Set_expected(group__math_operations value)
    {
      this.expected = value;
    }
  }


    public class type__property_mutation_on  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
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
        // Godot.GD.Print("Deserializing type__property_mutation_on");
        //Deserialize arguments

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__property_mutation_on");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
  }


    public class world_step__rule_group__action_rule__person_to_person__location_mutation  {
      public RawNode rawNode = new RawNode();
      //Attributes
      /* ignored attribute key={key} of type=System.Object*/
      public System.String on;

      //Children elements
      public List<group__math_operations> from = new List<group__math_operations>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person__location_mutation");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("on"))
        {
          var attribute_on = rawNode.attributes["on"];
          this.on = rawNode.attributes["on"];
        }

        //Deserialize children
        this.from = rawNode.InitializeWithRawNode("from", this.from);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.on != null)
        {
          rawNode.attributes["on"] = this.on.ToString();
        }

        //Serialize children
        rawNode.children["from"] = from.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__person_to_person__location_mutation");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    /* ignored attribute key={key} of type=System.Object*/
    public System.String Get_on()
    {
      return this.on;
    }
    public void Set_on(System.String value)
    {
      this.on = value;
    }
    public List<group__math_operations> Get_from()
    {
      return this.from;
    }
    public void Set_from(List<group__math_operations> value)
    {
      this.from = value;
    }
  }


    public class type__trigger  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__trigger__person_action_used person_action_used = new type__trigger__person_action_used();
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
        // Godot.GD.Print("Deserializing type__trigger");
        //Deserialize arguments

        //Deserialize children
        this.person_action_used = rawNode.InitializeWithRawNode("person_action_used", this.person_action_used);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(person_action_used != null) {
          rawNode.children["person_action_used"] = new List<RawNode> { person_action_used.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__trigger");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__trigger__person_action_used Get_person_action_used()
    {
      return this.person_action_used;
    }
    public type__trigger__person_action_used GetOrInsertDefault_person_action_used()
    {
      if(this.person_action_used == null) {
        this.person_action_used = new type__trigger__person_action_used();
      }
      return this.person_action_used;
    }
    public void Set_person_action_used(type__trigger__person_action_used value)
    {
      this.person_action_used = value;
    }
  }


    public class world_step__rule_group__events_rule__entry__then  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__events_rule__entry__then__select_person>? select_person = new List<world_step__rule_group__events_rule__entry__then__select_person>();
      public world_step__rule_group__events_rule__entry__then__property_mutation? property_mutation = null;
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
        // Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then");
        //Deserialize arguments

        //Deserialize children
        this.select_person = rawNode.InitializeWithRawNode("select_person", this.select_person);
        this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["select_person"] = select_person.Select(x => x.SerializeIntoRawNode()).ToList();
        if(property_mutation != null) {
          rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry__then");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__events_rule__entry__then__select_person>? Get_select_person()
    {
      return this.select_person;
    }
    public void Set_select_person(List<world_step__rule_group__events_rule__entry__then__select_person>? value)
    {
      this.select_person = value;
    }
    public world_step__rule_group__events_rule__entry__then__property_mutation? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(world_step__rule_group__events_rule__entry__then__property_mutation? value)
    {
      this.property_mutation = value;
    }
  }


    public class world_step__rule_group__link_group_rule_list__link_group_rule__to_option  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String node_rule_ref;
      public System.Int32 distance;
      public System.Int32? maxDistance;
      public System.Int32 adjacent_depth_limit;

      //Children elements
      public type__math_operations? distance_to_progress_multiplier = null;
      public type__math_operations? person_progress_property = null;
      public world_step__rule_group__link_group_rule_list__link_group_rule__to_option()
      {
      }

      public world_step__rule_group__link_group_rule_list__link_group_rule__to_option(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__link_group_rule_list__link_group_rule__to_option(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__link_group_rule_list__link_group_rule__to_option");
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
          this.maxDistance = attribute_maxDistance?.ToInt();
        }
        if(rawNode.attributes.ContainsKey("adjacent_depth_limit"))
        {
          var attribute_adjacent_depth_limit = rawNode.attributes["adjacent_depth_limit"];
          this.adjacent_depth_limit = attribute_adjacent_depth_limit.ToInt();
        }

        //Deserialize children
        this.distance_to_progress_multiplier = rawNode.InitializeWithRawNode("distance_to_progress_multiplier", this.distance_to_progress_multiplier);
        this.person_progress_property = rawNode.InitializeWithRawNode("person_progress_property", this.person_progress_property);
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
          rawNode.attributes["maxDistance"] = this.maxDistance?.ToString();
        }
        if(this.adjacent_depth_limit != null)
        {
          rawNode.attributes["adjacent_depth_limit"] = this.adjacent_depth_limit.ToString();
        }

        //Serialize children
        if(distance_to_progress_multiplier != null) {
          rawNode.children["distance_to_progress_multiplier"] = new List<RawNode> { distance_to_progress_multiplier.SerializeIntoRawNode() };
        }
        if(person_progress_property != null) {
          rawNode.children["person_progress_property"] = new List<RawNode> { person_progress_property.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__link_group_rule_list__link_group_rule__to_option");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.Int32 Get_distance()
    {
      return this.distance;
    }
    public void Set_distance(System.Int32 value)
    {
      this.distance = value;
    }
    public System.Int32? Get_maxDistance()
    {
      return this.maxDistance;
    }
    public void Set_maxDistance(System.Int32? value)
    {
      this.maxDistance = value;
    }
    public System.Int32 Get_adjacent_depth_limit()
    {
      return this.adjacent_depth_limit;
    }
    public void Set_adjacent_depth_limit(System.Int32 value)
    {
      this.adjacent_depth_limit = value;
    }
    public type__math_operations? Get_distance_to_progress_multiplier()
    {
      return this.distance_to_progress_multiplier;
    }
    public void Set_distance_to_progress_multiplier(type__math_operations? value)
    {
      this.distance_to_progress_multiplier = value;
    }
    public type__math_operations? Get_person_progress_property()
    {
      return this.person_progress_property;
    }
    public void Set_person_progress_property(type__math_operations? value)
    {
      this.person_progress_property = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__setup__starting_node  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String node_rule_ref;

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
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup__starting_node");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("node_rule_ref"))
        {
          var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
          this.node_rule_ref = rawNode.attributes["node_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.node_rule_ref != null)
        {
          rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__setup__starting_node");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__setup__necessary_node  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String node_rule_ref;
      public System.Int32 min;
      public System.Int32? max;

      //Children elements
      public List<world_step__rule_group__location_graph_rule__setup__necessary_node__or>? or = new List<world_step__rule_group__location_graph_rule__setup__necessary_node__or>();
      public world_step__rule_group__location_graph_rule__setup__necessary_node()
      {
      }

      public world_step__rule_group__location_graph_rule__setup__necessary_node(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__location_graph_rule__setup__necessary_node(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup__necessary_node");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("node_rule_ref"))
        {
          var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
          this.node_rule_ref = rawNode.attributes["node_rule_ref"];
        }
        if(rawNode.attributes.ContainsKey("min"))
        {
          var attribute_min = rawNode.attributes["min"];
          this.min = attribute_min.ToInt();
        }
        if(rawNode.attributes.ContainsKey("max"))
        {
          var attribute_max = rawNode.attributes["max"];
          this.max = attribute_max?.ToInt();
        }

        //Deserialize children
        this.or = rawNode.InitializeWithRawNode("or", this.or);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.node_rule_ref != null)
        {
          rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
        }
        if(this.min != null)
        {
          rawNode.attributes["min"] = this.min.ToString();
        }
        if(this.max != null)
        {
          rawNode.attributes["max"] = this.max?.ToString();
        }

        //Serialize children
        rawNode.children["or"] = or.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__setup__necessary_node");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.Int32 Get_min()
    {
      return this.min;
    }
    public void Set_min(System.Int32 value)
    {
      this.min = value;
    }
    public System.Int32? Get_max()
    {
      return this.max;
    }
    public void Set_max(System.Int32? value)
    {
      this.max = value;
    }
    public List<world_step__rule_group__location_graph_rule__setup__necessary_node__or>? Get_or()
    {
      return this.or;
    }
    public List<world_step__rule_group__location_graph_rule__setup__necessary_node__or> GetOrInsertDefault_or()
    {
      if(this.or == null) {
        this.or = new List<world_step__rule_group__location_graph_rule__setup__necessary_node__or>();
      }
      return this.or;
    }
    public void Set_or(List<world_step__rule_group__location_graph_rule__setup__necessary_node__or>? value)
    {
      this.or = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__node_rule__name  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String name_rule_ref;

      //Children elements
      public world_step__rule_group__location_graph_rule__node_rule__name()
      {
      }

      public world_step__rule_group__location_graph_rule__node_rule__name(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__location_graph_rule__node_rule__name(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__name");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("name_rule_ref"))
        {
          var attribute_name_rule_ref = rawNode.attributes["name_rule_ref"];
          this.name_rule_ref = rawNode.attributes["name_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.name_rule_ref != null)
        {
          rawNode.attributes["name_rule_ref"] = this.name_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__name");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_name_rule_ref()
    {
      return this.name_rule_ref;
    }
    public void Set_name_rule_ref(System.String value)
    {
      this.name_rule_ref = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__node_rule__classifications  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification>? classification = new List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification>();
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
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__classifications");
        //Deserialize arguments

        //Deserialize children
        this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__classifications");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification>? Get_classification()
    {
      return this.classification;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification> GetOrInsertDefault_classification()
    {
      if(this.classification == null) {
        this.classification = new List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification>();
      }
      return this.classification;
    }
    public void Set_classification(List<world_step__rule_group__location_graph_rule__node_rule__classifications__classification>? value)
    {
      this.classification = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__node_rule__link_group_list  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference>? reference = new List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference>();
      public List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group>? link_group = new List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group>();
      public world_step__rule_group__location_graph_rule__node_rule__link_group_list()
      {
      }

      public world_step__rule_group__location_graph_rule__node_rule__link_group_list(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__location_graph_rule__node_rule__link_group_list(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group_list");
        //Deserialize arguments

        //Deserialize children
        this.reference = rawNode.InitializeWithRawNode("reference", this.reference);
        this.link_group = rawNode.InitializeWithRawNode("link_group", this.link_group);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["reference"] = reference.Select(x => x.SerializeIntoRawNode()).ToList();
        rawNode.children["link_group"] = link_group.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__link_group_list");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference>? Get_reference()
    {
      return this.reference;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference> GetOrInsertDefault_reference()
    {
      if(this.reference == null) {
        this.reference = new List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference>();
      }
      return this.reference;
    }
    public void Set_reference(List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference>? value)
    {
      this.reference = value;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group>? Get_link_group()
    {
      return this.link_group;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group> GetOrInsertDefault_link_group()
    {
      if(this.link_group == null) {
        this.link_group = new List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group>();
      }
      return this.link_group;
    }
    public void Set_link_group(List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group>? value)
    {
      this.link_group = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__node_rule__existing_person  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.Int32 min;
      public System.Int32? max;

      //Children elements
      public type__person_selection person_selection = new type__person_selection();
      public world_step__rule_group__location_graph_rule__node_rule__existing_person()
      {
      }

      public world_step__rule_group__location_graph_rule__node_rule__existing_person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__location_graph_rule__node_rule__existing_person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__existing_person");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("min"))
        {
          var attribute_min = rawNode.attributes["min"];
          this.min = attribute_min.ToInt();
        }
        if(rawNode.attributes.ContainsKey("max"))
        {
          var attribute_max = rawNode.attributes["max"];
          this.max = attribute_max?.ToInt();
        }

        //Deserialize children
        this.person_selection = rawNode.InitializeWithRawNode("person_selection", this.person_selection);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.min != null)
        {
          rawNode.attributes["min"] = this.min.ToString();
        }
        if(this.max != null)
        {
          rawNode.attributes["max"] = this.max?.ToString();
        }

        //Serialize children
        if(person_selection != null) {
          rawNode.children["person_selection"] = new List<RawNode> { person_selection.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__existing_person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32 Get_min()
    {
      return this.min;
    }
    public void Set_min(System.Int32 value)
    {
      this.min = value;
    }
    public System.Int32? Get_max()
    {
      return this.max;
    }
    public void Set_max(System.Int32? value)
    {
      this.max = value;
    }
    public type__person_selection Get_person_selection()
    {
      return this.person_selection;
    }
    public void Set_person_selection(type__person_selection value)
    {
      this.person_selection = value;
    }
  }


    public class world_step__data__people__person__race  {
      public RawNode rawNode = new RawNode();
      //Attributes
      /* ignored attribute key={key} of type=System.Object*/

      //Children elements
      public world_step__data__people__person__race()
      {
      }

      public world_step__data__people__person__race(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__people__person__race(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__people__person__race");
        //Deserialize arguments

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__people__person__race");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    /* ignored attribute key={key} of type=System.Object*/
  }


    public class world_step__data__people__person__properties  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__data__people__person__properties__property>? property = new List<world_step__data__people__person__properties__property>();
      public world_step__data__people__person__properties()
      {
      }

      public world_step__data__people__person__properties(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__people__person__properties(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__people__person__properties");
        //Deserialize arguments

        //Deserialize children
        this.property = rawNode.InitializeWithRawNode("property", this.property);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__people__person__properties");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__data__people__person__properties__property>? Get_property()
    {
      return this.property;
    }
    public List<world_step__data__people__person__properties__property> GetOrInsertDefault_property()
    {
      if(this.property == null) {
        this.property = new List<world_step__data__people__person__properties__property>();
      }
      return this.property;
    }
    public void Set_property(List<world_step__data__people__person__properties__property>? value)
    {
      this.property = value;
    }
  }


    public class world_step__data__people__person__relations  {
      public RawNode rawNode = new RawNode();
      //Attributes
      /* ignored attribute key={key} of type=System.Object*/

      //Children elements
      public world_step__data__people__person__relations()
      {
      }

      public world_step__data__people__person__relations(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__people__person__relations(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__people__person__relations");
        //Deserialize arguments

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__people__person__relations");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    /* ignored attribute key={key} of type=System.Object*/
  }


    public class world_step__data__people__person__classifications  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__data__people__person__classifications__classification>? classification = new List<world_step__data__people__person__classifications__classification>();
      public world_step__data__people__person__classifications()
      {
      }

      public world_step__data__people__person__classifications(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__people__person__classifications(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__people__person__classifications");
        //Deserialize arguments

        //Deserialize children
        this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__people__person__classifications");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__data__people__person__classifications__classification>? Get_classification()
    {
      return this.classification;
    }
    public List<world_step__data__people__person__classifications__classification> GetOrInsertDefault_classification()
    {
      if(this.classification == null) {
        this.classification = new List<world_step__data__people__person__classifications__classification>();
      }
      return this.classification;
    }
    public void Set_classification(List<world_step__data__people__person__classifications__classification>? value)
    {
      this.classification = value;
    }
  }


    public class world_step__data__location__location_graph__rule  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String location_graph_rule_ref;

      //Children elements
      public world_step__data__location__location_graph__rule()
      {
      }

      public world_step__data__location__location_graph__rule(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__rule(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__rule");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("location_graph_rule_ref"))
        {
          var attribute_location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
          this.location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.location_graph_rule_ref != null)
        {
          rawNode.attributes["location_graph_rule_ref"] = this.location_graph_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__rule");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_location_graph_rule_ref()
    {
      return this.location_graph_rule_ref;
    }
    public void Set_location_graph_rule_ref(System.String value)
    {
      this.location_graph_rule_ref = value;
    }
  }


    public class world_step__data__location__location_graph__node  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String node_rule_ref;
      public System.String id;

      //Children elements
      public world_step__data__location__location_graph__node__name? name = null;
      public world_step__data__location__location_graph__node__position? position = null;
      public world_step__data__location__location_graph__node__classifications? classifications = null;
      public List<world_step__data__location__location_graph__node__link_to>? link_to = new List<world_step__data__location__location_graph__node__link_to>();
      public world_step__data__location__location_graph__node__people? people = null;
      public world_step__data__location__location_graph__node()
      {
      }

      public world_step__data__location__location_graph__node(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node");
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

        //Deserialize children
        this.name = rawNode.InitializeWithRawNode("name", this.name);
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

        //Serialize children
        if(name != null) {
          rawNode.children["name"] = new List<RawNode> { name.SerializeIntoRawNode() };
        }
        if(position != null) {
          rawNode.children["position"] = new List<RawNode> { position.SerializeIntoRawNode() };
        }
        if(classifications != null) {
          rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
        }
        rawNode.children["link_to"] = link_to.Select(x => x.SerializeIntoRawNode()).ToList();
        if(people != null) {
          rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public world_step__data__location__location_graph__node__name? Get_name()
    {
      return this.name;
    }
    public world_step__data__location__location_graph__node__name GetOrInsertDefault_name()
    {
      if(this.name == null) {
        this.name = new world_step__data__location__location_graph__node__name();
      }
      return this.name;
    }
    public void Set_name(world_step__data__location__location_graph__node__name? value)
    {
      this.name = value;
    }
    public world_step__data__location__location_graph__node__position? Get_position()
    {
      return this.position;
    }
    public world_step__data__location__location_graph__node__position GetOrInsertDefault_position()
    {
      if(this.position == null) {
        this.position = new world_step__data__location__location_graph__node__position();
      }
      return this.position;
    }
    public void Set_position(world_step__data__location__location_graph__node__position? value)
    {
      this.position = value;
    }
    public world_step__data__location__location_graph__node__classifications? Get_classifications()
    {
      return this.classifications;
    }
    public world_step__data__location__location_graph__node__classifications GetOrInsertDefault_classifications()
    {
      if(this.classifications == null) {
        this.classifications = new world_step__data__location__location_graph__node__classifications();
      }
      return this.classifications;
    }
    public void Set_classifications(world_step__data__location__location_graph__node__classifications? value)
    {
      this.classifications = value;
    }
    public List<world_step__data__location__location_graph__node__link_to>? Get_link_to()
    {
      return this.link_to;
    }
    public List<world_step__data__location__location_graph__node__link_to> GetOrInsertDefault_link_to()
    {
      if(this.link_to == null) {
        this.link_to = new List<world_step__data__location__location_graph__node__link_to>();
      }
      return this.link_to;
    }
    public void Set_link_to(List<world_step__data__location__location_graph__node__link_to>? value)
    {
      this.link_to = value;
    }
    public world_step__data__location__location_graph__node__people? Get_people()
    {
      return this.people;
    }
    public world_step__data__location__location_graph__node__people GetOrInsertDefault_people()
    {
      if(this.people == null) {
        this.people = new world_step__data__location__location_graph__node__people();
      }
      return this.people;
    }
    public void Set_people(world_step__data__location__location_graph__node__people? value)
    {
      this.people = value;
    }
  }


    public class type__node_graph__selection__in__location_graph  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__node_graph__selection__in__location_graph__has__location_graph_id? has__location_graph_id = null;
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
        // Godot.GD.Print("Deserializing type__node_graph__selection__in__location_graph");
        //Deserialize arguments

        //Deserialize children
        this.has__location_graph_id = rawNode.InitializeWithRawNode("has__location_graph_id", this.has__location_graph_id);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(has__location_graph_id != null) {
          rawNode.children["has__location_graph_id"] = new List<RawNode> { has__location_graph_id.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__node_graph__selection__in__location_graph");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__node_graph__selection__in__location_graph__has__location_graph_id? Get_has__location_graph_id()
    {
      return this.has__location_graph_id;
    }
    public type__node_graph__selection__in__location_graph__has__location_graph_id GetOrInsertDefault_has__location_graph_id()
    {
      if(this.has__location_graph_id == null) {
        this.has__location_graph_id = new type__node_graph__selection__in__location_graph__has__location_graph_id();
      }
      return this.has__location_graph_id;
    }
    public void Set_has__location_graph_id(type__node_graph__selection__in__location_graph__has__location_graph_id? value)
    {
      this.has__location_graph_id = value;
    }
  }


    public class type__node_graph__selection__has__node_graph_id  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String node_graph_id_ref;

      //Children elements
      public List<type__node_graph__selection__has__node_graph_id__or>? or = new List<type__node_graph__selection__has__node_graph_id__or>();
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
        // Godot.GD.Print("Deserializing type__node_graph__selection__has__node_graph_id");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("node_graph_id_ref"))
        {
          var attribute_node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
          this.node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
        }

        //Deserialize children
        this.or = rawNode.InitializeWithRawNode("or", this.or);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.node_graph_id_ref != null)
        {
          rawNode.attributes["node_graph_id_ref"] = this.node_graph_id_ref.ToString();
        }

        //Serialize children
        rawNode.children["or"] = or.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__node_graph__selection__has__node_graph_id");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_node_graph_id_ref()
    {
      return this.node_graph_id_ref;
    }
    public void Set_node_graph_id_ref(System.String value)
    {
      this.node_graph_id_ref = value;
    }
    public List<type__node_graph__selection__has__node_graph_id__or>? Get_or()
    {
      return this.or;
    }
    public List<type__node_graph__selection__has__node_graph_id__or> GetOrInsertDefault_or()
    {
      if(this.or == null) {
        this.or = new List<type__node_graph__selection__has__node_graph_id__or>();
      }
      return this.or;
    }
    public void Set_or(List<type__node_graph__selection__has__node_graph_id__or>? value)
    {
      this.or = value;
    }
  }


    public class world_step__actions__location_graph__node__add_classification__to_be_added__classification__and  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String location_classification_rule_ref;

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
        // Godot.GD.Print("Deserializing world_step__actions__location_graph__node__add_classification__to_be_added__classification__and");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
        {
          var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
          this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.location_classification_rule_ref != null)
        {
          rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__location_graph__node__add_classification__to_be_added__classification__and");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }
  }


    public class type__link_to__selection  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__node_graph__selection? origin__node_graph__selection = null;
      public type__node_graph__selection? destination__node_graph__selection = null;
      public type__link_to__selection()
      {
      }

      public type__link_to__selection(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public type__link_to__selection(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing type__link_to__selection");
        //Deserialize arguments

        //Deserialize children
        this.origin__node_graph__selection = rawNode.InitializeWithRawNode("origin__node_graph__selection", this.origin__node_graph__selection);
        this.destination__node_graph__selection = rawNode.InitializeWithRawNode("destination__node_graph__selection", this.destination__node_graph__selection);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(origin__node_graph__selection != null) {
          rawNode.children["origin__node_graph__selection"] = new List<RawNode> { origin__node_graph__selection.SerializeIntoRawNode() };
        }
        if(destination__node_graph__selection != null) {
          rawNode.children["destination__node_graph__selection"] = new List<RawNode> { destination__node_graph__selection.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__link_to__selection");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__node_graph__selection? Get_origin__node_graph__selection()
    {
      return this.origin__node_graph__selection;
    }
    public void Set_origin__node_graph__selection(type__node_graph__selection? value)
    {
      this.origin__node_graph__selection = value;
    }
    public type__node_graph__selection? Get_destination__node_graph__selection()
    {
      return this.destination__node_graph__selection;
    }
    public void Set_destination__node_graph__selection(type__node_graph__selection? value)
    {
      this.destination__node_graph__selection = value;
    }
  }


    public class type__math_operations  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.Int32 initial;

      //Children elements
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
        // Godot.GD.Print("Deserializing type__math_operations");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("initial"))
        {
          var attribute_initial = rawNode.attributes["initial"];
          this.initial = attribute_initial.ToInt();
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.initial != null)
        {
          rawNode.attributes["initial"] = this.initial.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__math_operations");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32 Get_initial()
    {
      return this.initial;
    }
    public void Set_initial(System.Int32 value)
    {
      this.initial = value;
    }
  }


    public class type__person_selection__property  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String? property_rule_ref;

      //Children elements
      public type__math_operations? min = null;
      public type__math_operations? max = null;
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
        // Godot.GD.Print("Deserializing type__person_selection__property");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("property_rule_ref"))
        {
          var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
          this.property_rule_ref = rawNode.attributes["property_rule_ref"];
        }

        //Deserialize children
        this.min = rawNode.InitializeWithRawNode("min", this.min);
        this.max = rawNode.InitializeWithRawNode("max", this.max);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.property_rule_ref != null)
        {
          rawNode.attributes["property_rule_ref"] = this.property_rule_ref?.ToString();
        }

        //Serialize children
        if(min != null) {
          rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
        }
        if(max != null) {
          rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__person_selection__property");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String? Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String? value)
    {
      this.property_rule_ref = value;
    }
    public type__math_operations? Get_min()
    {
      return this.min;
    }
    public void Set_min(type__math_operations? value)
    {
      this.min = value;
    }
    public type__math_operations? Get_max()
    {
      return this.max;
    }
    public void Set_max(type__math_operations? value)
    {
      this.max = value;
    }
  }


    public class type__person_selection__classification  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String classification_rule_ref;

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
        // Godot.GD.Print("Deserializing type__person_selection__classification");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("classification_rule_ref"))
        {
          var attribute_classification_rule_ref = rawNode.attributes["classification_rule_ref"];
          this.classification_rule_ref = rawNode.attributes["classification_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.classification_rule_ref != null)
        {
          rawNode.attributes["classification_rule_ref"] = this.classification_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__person_selection__classification");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_classification_rule_ref()
    {
      return this.classification_rule_ref;
    }
    public void Set_classification_rule_ref(System.String value)
    {
      this.classification_rule_ref = value;
    }
  }


    public class type__person_selection__race  {
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
        // Godot.GD.Print("Deserializing type__person_selection__race");
        //Deserialize arguments

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__person_selection__race");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    /* ignored attribute key={key} of type=System.Object*/
  }


    public class world_step__actions__person__move_to__path__node  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String node_id_ref;

      //Children elements
      public world_step__actions__person__move_to__path__node()
      {
      }

      public world_step__actions__person__move_to__path__node(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__actions__person__move_to__path__node(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__actions__person__move_to__path__node");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("node_id_ref"))
        {
          var attribute_node_id_ref = rawNode.attributes["node_id_ref"];
          this.node_id_ref = rawNode.attributes["node_id_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.node_id_ref != null)
        {
          rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__actions__person__move_to__path__node");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }
  }


    public class group__operation__and  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public group__operation__and__add_property? add_property = null;
      public List<group__operation__and>? and = new List<group__operation__and>();
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
        // Godot.GD.Print("Deserializing group__operation__and");
        //Deserialize arguments

        //Deserialize children
        this.add_property = rawNode.InitializeWithRawNode("add_property", this.add_property);
        this.and = rawNode.InitializeWithRawNode("and", this.and);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(add_property != null) {
          rawNode.children["add_property"] = new List<RawNode> { add_property.SerializeIntoRawNode() };
        }
        rawNode.children["and"] = and.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing group__operation__and");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public group__operation__and__add_property? Get_add_property()
    {
      return this.add_property;
    }
    public group__operation__and__add_property GetOrInsertDefault_add_property()
    {
      if(this.add_property == null) {
        this.add_property = new group__operation__and__add_property();
      }
      return this.add_property;
    }
    public void Set_add_property(group__operation__and__add_property? value)
    {
      this.add_property = value;
    }
    public List<group__operation__and>? Get_and()
    {
      return this.and;
    }
    public void Set_and(List<group__operation__and>? value)
    {
      this.and = value;
    }
  }


    public class group__name_token__name_token__ref  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String name_rule_ref;

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
        // Godot.GD.Print("Deserializing group__name_token__name_token__ref");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("name_rule_ref"))
        {
          var attribute_name_rule_ref = rawNode.attributes["name_rule_ref"];
          this.name_rule_ref = rawNode.attributes["name_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.name_rule_ref != null)
        {
          rawNode.attributes["name_rule_ref"] = this.name_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing group__name_token__name_token__ref");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_name_rule_ref()
    {
      return this.name_rule_ref;
    }
    public void Set_name_rule_ref(System.String value)
    {
      this.name_rule_ref = value;
    }
  }


    public class type__property_mutation  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String property_rule_ref;

      //Children elements
      public List<group__math_operations> from = new List<group__math_operations>();
      public type__property_mutation()
      {
      }

      public type__property_mutation(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public type__property_mutation(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing type__property_mutation");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("property_rule_ref"))
        {
          var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
          this.property_rule_ref = rawNode.attributes["property_rule_ref"];
        }

        //Deserialize children
        this.from = rawNode.InitializeWithRawNode("from", this.from);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.property_rule_ref != null)
        {
          rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
        }

        //Serialize children
        rawNode.children["from"] = from.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__property_mutation");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
    public List<group__math_operations> Get_from()
    {
      return this.from;
    }
    public void Set_from(List<group__math_operations> value)
    {
      this.from = value;
    }
  }
  public interface Itype__person_selection {

    //Children elements
    public type__math_operations? Get_radius();
    public void Set_radius(type__math_operations? value);
    public type__math_operations? Get_min();
    public void Set_min(type__math_operations? value);
    public type__math_operations? Get_max();
    public void Set_max(type__math_operations? value);
    public List<type__person_selection__property>? Get_property();
    public void Set_property(List<type__person_selection__property>? value);
    public List<type__person_selection__classification>? Get_classification();
    public void Set_classification(List<type__person_selection__classification>? value);
    public type__person_selection__race? Get_race();
    public void Set_race(type__person_selection__race? value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }

    public class world_step__rule_group__action_rule__from_person__on_person__selection : Itype__person_selection {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Attributes of type__person_selection

      //Children elements
      public world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node? from_person_same_location_graph_node = null;

      //Children of type__person_selection
      public type__math_operations? radius = null;
      public type__math_operations? min = null;
      public type__math_operations? max = null;
      public List<type__person_selection__property>? property = new List<type__person_selection__property>();
      public List<type__person_selection__classification>? classification = new List<type__person_selection__classification>();
      public type__person_selection__race? race = null;
      public world_step__rule_group__action_rule__from_person__on_person__selection()
      {
      }

      public world_step__rule_group__action_rule__from_person__on_person__selection(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__action_rule__from_person__on_person__selection(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__from_person__on_person__selection");
        //Deserialize arguments

        // Deserialize arguments of type__person_selection

        //Deserialize children
        this.from_person_same_location_graph_node = rawNode.InitializeWithRawNode("from_person_same_location_graph_node", this.from_person_same_location_graph_node);

        // Deserialize children of type__person_selection
  this.radius = rawNode.InitializeWithRawNode("radius", this.radius);
  this.min = rawNode.InitializeWithRawNode("min", this.min);
  this.max = rawNode.InitializeWithRawNode("max", this.max);
  this.property = rawNode.InitializeWithRawNode("property", this.property);
  this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
  this.race = rawNode.InitializeWithRawNode("race", this.race);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        // Serialize arguments of type__person_selection


        //Serialize children
        if(from_person_same_location_graph_node != null) {
          rawNode.children["from_person_same_location_graph_node"] = new List<RawNode> { from_person_same_location_graph_node.SerializeIntoRawNode() };
        }

        // Serialize children of type__person_selection
  if(radius != null) {
    rawNode.children["radius"] = new List<RawNode> { radius.SerializeIntoRawNode() };
  }
  if(min != null) {
    rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
  }
  if(max != null) {
    rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
  }
  rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
  rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
  if(race != null) {
    rawNode.children["race"] = new List<RawNode> { race.SerializeIntoRawNode() };
  }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__from_person__on_person__selection");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node? Get_from_person_same_location_graph_node()
    {
      return this.from_person_same_location_graph_node;
    }
    public world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node GetOrInsertDefault_from_person_same_location_graph_node()
    {
      if(this.from_person_same_location_graph_node == null) {
        this.from_person_same_location_graph_node = new world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node();
      }
      return this.from_person_same_location_graph_node;
    }
    public void Set_from_person_same_location_graph_node(world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node? value)
    {
      this.from_person_same_location_graph_node = value;
    }
    public type__math_operations? Get_radius()
    {
      return this.radius;
    }
    public void Set_radius(type__math_operations? value)
    {
      this.radius = value;
    }
    public type__math_operations? Get_min()
    {
      return this.min;
    }
    public void Set_min(type__math_operations? value)
    {
      this.min = value;
    }
    public type__math_operations? Get_max()
    {
      return this.max;
    }
    public void Set_max(type__math_operations? value)
    {
      this.max = value;
    }
    public List<type__person_selection__property>? Get_property()
    {
      return this.property;
    }
    public List<type__person_selection__property> GetOrInsertDefault_property()
    {
      if(this.property == null) {
        this.property = new List<type__person_selection__property>();
      }
      return this.property;
    }
    public void Set_property(List<type__person_selection__property>? value)
    {
      this.property = value;
    }
    public List<type__person_selection__classification>? Get_classification()
    {
      return this.classification;
    }
    public List<type__person_selection__classification> GetOrInsertDefault_classification()
    {
      if(this.classification == null) {
        this.classification = new List<type__person_selection__classification>();
      }
      return this.classification;
    }
    public void Set_classification(List<type__person_selection__classification>? value)
    {
      this.classification = value;
    }
    public type__person_selection__race? Get_race()
    {
      return this.race;
    }
    public type__person_selection__race GetOrInsertDefault_race()
    {
      if(this.race == null) {
        this.race = new type__person_selection__race();
      }
      return this.race;
    }
    public void Set_race(type__person_selection__race? value)
    {
      this.race = value;
    }
  }


    public class world_step__rule_group__action_rule__from_person__on_person__mutations  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__property_mutation? property_mutation = null;
      public world_step__rule_group__action_rule__from_person__on_person__mutations()
      {
      }

      public world_step__rule_group__action_rule__from_person__on_person__mutations(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__action_rule__from_person__on_person__mutations(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__from_person__on_person__mutations");
        //Deserialize arguments

        //Deserialize children
        this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(property_mutation != null) {
          rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__from_person__on_person__mutations");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__property_mutation? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(type__property_mutation? value)
    {
      this.property_mutation = value;
    }
  }


    public class type__action__from  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__action__from__person? person = null;
      public type__action__from()
      {
      }

      public type__action__from(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public type__action__from(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing type__action__from");
        //Deserialize arguments

        //Deserialize children
        this.person = rawNode.InitializeWithRawNode("person", this.person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(person != null) {
          rawNode.children["person"] = new List<RawNode> { person.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__action__from");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__action__from__person? Get_person()
    {
      return this.person;
    }
    public type__action__from__person GetOrInsertDefault_person()
    {
      if(this.person == null) {
        this.person = new type__action__from__person();
      }
      return this.person;
    }
    public void Set_person(type__action__from__person? value)
    {
      this.person = value;
    }
  }


    public class type__action__on  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__action__on__person? person = null;
      public type__action__on()
      {
      }

      public type__action__on(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public type__action__on(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing type__action__on");
        //Deserialize arguments

        //Deserialize children
        this.person = rawNode.InitializeWithRawNode("person", this.person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(person != null) {
          rawNode.children["person"] = new List<RawNode> { person.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__action__on");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__action__on__person? Get_person()
    {
      return this.person;
    }
    public type__action__on__person GetOrInsertDefault_person()
    {
      if(this.person == null) {
        this.person = new type__action__on__person();
      }
      return this.person;
    }
    public void Set_person(type__action__on__person? value)
    {
      this.person = value;
    }
  }


    public class type__action  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__action__from from = new type__action__from();
      public type__action__on on = new type__action__on();
      public type__action()
      {
      }

      public type__action(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public type__action(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing type__action");
        //Deserialize arguments

        //Deserialize children
        this.from = rawNode.InitializeWithRawNode("from", this.from);
        this.on = rawNode.InitializeWithRawNode("on", this.on);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(from != null) {
          rawNode.children["from"] = new List<RawNode> { from.SerializeIntoRawNode() };
        }
        if(on != null) {
          rawNode.children["on"] = new List<RawNode> { on.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__action");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__action__from Get_from()
    {
      return this.from;
    }
    public type__action__from GetOrInsertDefault_from()
    {
      if(this.from == null) {
        this.from = new type__action__from();
      }
      return this.from;
    }
    public void Set_from(type__action__from value)
    {
      this.from = value;
    }
    public type__action__on Get_on()
    {
      return this.on;
    }
    public type__action__on GetOrInsertDefault_on()
    {
      if(this.on == null) {
        this.on = new type__action__on();
      }
      return this.on;
    }
    public void Set_on(type__action__on value)
    {
      this.on = value;
    }
  }


    public class type__trigger__person_action_used  {
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
        // Godot.GD.Print("Deserializing type__trigger__person_action_used");
        //Deserialize arguments

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__trigger__person_action_used");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    /* ignored attribute key={key} of type=System.Object*/
  }


    public class world_step__rule_group__events_rule__entry__then__select_person : Itype__person_selection {
      public RawNode rawNode = new RawNode();
      //Attributes
      /* ignored attribute key={key} of type=world_step__rule_group__events_rule__entry__then__select_person__origin*/

      //Attributes of type__person_selection

      //Children elements

      //Children of type__person_selection
      public type__math_operations? radius = null;
      public type__math_operations? min = null;
      public type__math_operations? max = null;
      public List<type__person_selection__property>? property = new List<type__person_selection__property>();
      public List<type__person_selection__classification>? classification = new List<type__person_selection__classification>();
      public type__person_selection__race? race = null;
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
        // Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then__select_person");
        //Deserialize arguments

        // Deserialize arguments of type__person_selection

        //Deserialize children

        // Deserialize children of type__person_selection
  this.radius = rawNode.InitializeWithRawNode("radius", this.radius);
  this.min = rawNode.InitializeWithRawNode("min", this.min);
  this.max = rawNode.InitializeWithRawNode("max", this.max);
  this.property = rawNode.InitializeWithRawNode("property", this.property);
  this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
  this.race = rawNode.InitializeWithRawNode("race", this.race);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        // Serialize arguments of type__person_selection


        //Serialize children

        // Serialize children of type__person_selection
  if(radius != null) {
    rawNode.children["radius"] = new List<RawNode> { radius.SerializeIntoRawNode() };
  }
  if(min != null) {
    rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
  }
  if(max != null) {
    rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
  }
  rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
  rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
  if(race != null) {
    rawNode.children["race"] = new List<RawNode> { race.SerializeIntoRawNode() };
  }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry__then__select_person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    /* ignored attribute key={key} of type=world_step__rule_group__events_rule__entry__then__select_person__origin*/
    public type__math_operations? Get_radius()
    {
      return this.radius;
    }
    public void Set_radius(type__math_operations? value)
    {
      this.radius = value;
    }
    public type__math_operations? Get_min()
    {
      return this.min;
    }
    public void Set_min(type__math_operations? value)
    {
      this.min = value;
    }
    public type__math_operations? Get_max()
    {
      return this.max;
    }
    public void Set_max(type__math_operations? value)
    {
      this.max = value;
    }
    public List<type__person_selection__property>? Get_property()
    {
      return this.property;
    }
    public List<type__person_selection__property> GetOrInsertDefault_property()
    {
      if(this.property == null) {
        this.property = new List<type__person_selection__property>();
      }
      return this.property;
    }
    public void Set_property(List<type__person_selection__property>? value)
    {
      this.property = value;
    }
    public List<type__person_selection__classification>? Get_classification()
    {
      return this.classification;
    }
    public List<type__person_selection__classification> GetOrInsertDefault_classification()
    {
      if(this.classification == null) {
        this.classification = new List<type__person_selection__classification>();
      }
      return this.classification;
    }
    public void Set_classification(List<type__person_selection__classification>? value)
    {
      this.classification = value;
    }
    public type__person_selection__race? Get_race()
    {
      return this.race;
    }
    public type__person_selection__race GetOrInsertDefault_race()
    {
      if(this.race == null) {
        this.race = new type__person_selection__race();
      }
      return this.race;
    }
    public void Set_race(type__person_selection__race? value)
    {
      this.race = value;
    }
  }


    public class world_step__rule_group__events_rule__entry__then__property_mutation : Itype__math_operations {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String property_rule_ref;

      //Attributes of type__math_operations
      public System.Int32 initial;

      //Children elements

      //Children of type__math_operations

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
        // Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then__property_mutation");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("property_rule_ref"))
        {
          var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
          this.property_rule_ref = rawNode.attributes["property_rule_ref"];
        }

        // Deserialize arguments of type__math_operations
  if(rawNode.attributes.ContainsKey("initial"))
  {
    var attribute_initial = rawNode.attributes["initial"];
    this.initial = attribute_initial.ToInt();
  }

        //Deserialize children

        // Deserialize children of type__math_operations

      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.property_rule_ref != null)
        {
          rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
        }

        // Serialize arguments of type__math_operations
  if(this.initial != null)
  {
    rawNode.attributes["initial"] = this.initial.ToString();
  }

        //Serialize children

        // Serialize children of type__math_operations

        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__events_rule__entry__then__property_mutation");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
    public System.Int32 Get_initial()
    {
      return this.initial;
    }
    public void Set_initial(System.Int32 value)
    {
      this.initial = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__setup__necessary_node__or  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String node_rule_ref;

      //Children elements
      public world_step__rule_group__location_graph_rule__setup__necessary_node__or()
      {
      }

      public world_step__rule_group__location_graph_rule__setup__necessary_node__or(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__location_graph_rule__setup__necessary_node__or(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup__necessary_node__or");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("node_rule_ref"))
        {
          var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
          this.node_rule_ref = rawNode.attributes["node_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.node_rule_ref != null)
        {
          rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__setup__necessary_node__or");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__node_rule__classifications__classification  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String location_classification_rule_ref;

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
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__classifications__classification");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
        {
          var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
          this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.location_classification_rule_ref != null)
        {
          rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__classifications__classification");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String link_group_rule_ref;

      //Children elements
      public world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference()
      {
      }

      public world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("link_group_rule_ref"))
        {
          var attribute_link_group_rule_ref = rawNode.attributes["link_group_rule_ref"];
          this.link_group_rule_ref = rawNode.attributes["link_group_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.link_group_rule_ref != null)
        {
          rawNode.attributes["link_group_rule_ref"] = this.link_group_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__link_group_list__reference");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_link_group_rule_ref()
    {
      return this.link_group_rule_ref;
    }
    public void Set_link_group_rule_ref(System.String value)
    {
      this.link_group_rule_ref = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String id;
      public System.Int32 angle;
      public System.Int32? angleMax;
      public System.Int32? limit;

      //Children elements
      public List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option>? to_option = new List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option>();
      public world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group()
      {
      }

      public world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group");
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
          this.angleMax = attribute_angleMax?.ToInt();
        }
        if(rawNode.attributes.ContainsKey("limit"))
        {
          var attribute_limit = rawNode.attributes["limit"];
          this.limit = attribute_limit?.ToInt();
        }

        //Deserialize children
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
          rawNode.attributes["angleMax"] = this.angleMax?.ToString();
        }
        if(this.limit != null)
        {
          rawNode.attributes["limit"] = this.limit?.ToString();
        }

        //Serialize children
        rawNode.children["to_option"] = to_option.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public System.Int32 Get_angle()
    {
      return this.angle;
    }
    public void Set_angle(System.Int32 value)
    {
      this.angle = value;
    }
    public System.Int32? Get_angleMax()
    {
      return this.angleMax;
    }
    public void Set_angleMax(System.Int32? value)
    {
      this.angleMax = value;
    }
    public System.Int32? Get_limit()
    {
      return this.limit;
    }
    public void Set_limit(System.Int32? value)
    {
      this.limit = value;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option>? Get_to_option()
    {
      return this.to_option;
    }
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option> GetOrInsertDefault_to_option()
    {
      if(this.to_option == null) {
        this.to_option = new List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option>();
      }
      return this.to_option;
    }
    public void Set_to_option(List<world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option>? value)
    {
      this.to_option = value;
    }
  }


    public class world_step__data__people__person__properties__property  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String property_rule_ref;
      /* ignored attribute key={key} of type=System.Object*/

      //Children elements
      public world_step__data__people__person__properties__property()
      {
      }

      public world_step__data__people__person__properties__property(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__people__person__properties__property(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__people__person__properties__property");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("property_rule_ref"))
        {
          var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
          this.property_rule_ref = rawNode.attributes["property_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.property_rule_ref != null)
        {
          rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__people__person__properties__property");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
    /* ignored attribute key={key} of type=System.Object*/
  }


    public class world_step__data__people__person__classifications__classification  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String classification_rule_ref;

      //Children elements
      public world_step__data__people__person__classifications__classification()
      {
      }

      public world_step__data__people__person__classifications__classification(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__people__person__classifications__classification(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__people__person__classifications__classification");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("classification_rule_ref"))
        {
          var attribute_classification_rule_ref = rawNode.attributes["classification_rule_ref"];
          this.classification_rule_ref = rawNode.attributes["classification_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.classification_rule_ref != null)
        {
          rawNode.attributes["classification_rule_ref"] = this.classification_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__people__person__classifications__classification");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_classification_rule_ref()
    {
      return this.classification_rule_ref;
    }
    public void Set_classification_rule_ref(System.String value)
    {
      this.classification_rule_ref = value;
    }
  }


    public class world_step__data__location__location_graph__node__name  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String value;

      //Children elements
      public world_step__data__location__location_graph__node__name()
      {
      }

      public world_step__data__location__location_graph__node__name(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node__name(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node__name");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("value"))
        {
          var attribute_value = rawNode.attributes["value"];
          this.value = rawNode.attributes["value"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.value != null)
        {
          rawNode.attributes["value"] = this.value.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node__name");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String value)
    {
      this.value = value;
    }
  }


    public class world_step__data__location__location_graph__node__position  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.Int32 x;
      public System.Int32 y;

      //Children elements
      public world_step__data__location__location_graph__node__position()
      {
      }

      public world_step__data__location__location_graph__node__position(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node__position(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node__position");
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

        //Deserialize children
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

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node__position");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
    }
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
    }
  }


    public class world_step__data__location__location_graph__node__classifications  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__data__location__location_graph__node__classifications__classification>? classification = new List<world_step__data__location__location_graph__node__classifications__classification>();
      public world_step__data__location__location_graph__node__classifications()
      {
      }

      public world_step__data__location__location_graph__node__classifications(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node__classifications(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node__classifications");
        //Deserialize arguments

        //Deserialize children
        this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node__classifications");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__data__location__location_graph__node__classifications__classification>? Get_classification()
    {
      return this.classification;
    }
    public List<world_step__data__location__location_graph__node__classifications__classification> GetOrInsertDefault_classification()
    {
      if(this.classification == null) {
        this.classification = new List<world_step__data__location__location_graph__node__classifications__classification>();
      }
      return this.classification;
    }
    public void Set_classification(List<world_step__data__location__location_graph__node__classifications__classification>? value)
    {
      this.classification = value;
    }
  }


    public class world_step__data__location__location_graph__node__link_to  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String node_id_ref;
      public System.Int32 total_progress;

      //Children elements
      public world_step__data__location__location_graph__node__link_to__people? people = null;
      public type__math_operations? person_progress_property = null;
      public world_step__data__location__location_graph__node__link_to()
      {
      }

      public world_step__data__location__location_graph__node__link_to(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node__link_to(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node__link_to");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("node_id_ref"))
        {
          var attribute_node_id_ref = rawNode.attributes["node_id_ref"];
          this.node_id_ref = rawNode.attributes["node_id_ref"];
        }
        if(rawNode.attributes.ContainsKey("total_progress"))
        {
          var attribute_total_progress = rawNode.attributes["total_progress"];
          this.total_progress = attribute_total_progress.ToInt();
        }

        //Deserialize children
        this.people = rawNode.InitializeWithRawNode("people", this.people);
        this.person_progress_property = rawNode.InitializeWithRawNode("person_progress_property", this.person_progress_property);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.node_id_ref != null)
        {
          rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
        }
        if(this.total_progress != null)
        {
          rawNode.attributes["total_progress"] = this.total_progress.ToString();
        }

        //Serialize children
        if(people != null) {
          rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
        }
        if(person_progress_property != null) {
          rawNode.children["person_progress_property"] = new List<RawNode> { person_progress_property.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node__link_to");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }
    public System.Int32 Get_total_progress()
    {
      return this.total_progress;
    }
    public void Set_total_progress(System.Int32 value)
    {
      this.total_progress = value;
    }
    public world_step__data__location__location_graph__node__link_to__people? Get_people()
    {
      return this.people;
    }
    public world_step__data__location__location_graph__node__link_to__people GetOrInsertDefault_people()
    {
      if(this.people == null) {
        this.people = new world_step__data__location__location_graph__node__link_to__people();
      }
      return this.people;
    }
    public void Set_people(world_step__data__location__location_graph__node__link_to__people? value)
    {
      this.people = value;
    }
    public type__math_operations? Get_person_progress_property()
    {
      return this.person_progress_property;
    }
    public void Set_person_progress_property(type__math_operations? value)
    {
      this.person_progress_property = value;
    }
  }


    public class world_step__data__location__location_graph__node__people  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__data__location__location_graph__node__people__person>? person = new List<world_step__data__location__location_graph__node__people__person>();
      public world_step__data__location__location_graph__node__people()
      {
      }

      public world_step__data__location__location_graph__node__people(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node__people(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node__people");
        //Deserialize arguments

        //Deserialize children
        this.person = rawNode.InitializeWithRawNode("person", this.person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["person"] = person.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node__people");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__data__location__location_graph__node__people__person>? Get_person()
    {
      return this.person;
    }
    public List<world_step__data__location__location_graph__node__people__person> GetOrInsertDefault_person()
    {
      if(this.person == null) {
        this.person = new List<world_step__data__location__location_graph__node__people__person>();
      }
      return this.person;
    }
    public void Set_person(List<world_step__data__location__location_graph__node__people__person>? value)
    {
      this.person = value;
    }
  }


    public class type__node_graph__selection__in__location_graph__has__location_graph_id  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String location_graph_id_ref;

      //Children elements
      public List<type__node_graph__selection__in__location_graph__has__location_graph_id__or>? or = new List<type__node_graph__selection__in__location_graph__has__location_graph_id__or>();
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
        // Godot.GD.Print("Deserializing type__node_graph__selection__in__location_graph__has__location_graph_id");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("location_graph_id_ref"))
        {
          var attribute_location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
          this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
        }

        //Deserialize children
        this.or = rawNode.InitializeWithRawNode("or", this.or);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.location_graph_id_ref != null)
        {
          rawNode.attributes["location_graph_id_ref"] = this.location_graph_id_ref.ToString();
        }

        //Serialize children
        rawNode.children["or"] = or.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__node_graph__selection__in__location_graph__has__location_graph_id");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String value)
    {
      this.location_graph_id_ref = value;
    }
    public List<type__node_graph__selection__in__location_graph__has__location_graph_id__or>? Get_or()
    {
      return this.or;
    }
    public List<type__node_graph__selection__in__location_graph__has__location_graph_id__or> GetOrInsertDefault_or()
    {
      if(this.or == null) {
        this.or = new List<type__node_graph__selection__in__location_graph__has__location_graph_id__or>();
      }
      return this.or;
    }
    public void Set_or(List<type__node_graph__selection__in__location_graph__has__location_graph_id__or>? value)
    {
      this.or = value;
    }
  }


    public class type__node_graph__selection__has__node_graph_id__or  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String? node_graph_id_ref;

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
        // Godot.GD.Print("Deserializing type__node_graph__selection__has__node_graph_id__or");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("node_graph_id_ref"))
        {
          var attribute_node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
          this.node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.node_graph_id_ref != null)
        {
          rawNode.attributes["node_graph_id_ref"] = this.node_graph_id_ref?.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__node_graph__selection__has__node_graph_id__or");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String? Get_node_graph_id_ref()
    {
      return this.node_graph_id_ref;
    }
    public void Set_node_graph_id_ref(System.String? value)
    {
      this.node_graph_id_ref = value;
    }
  }


    public class group__operation__and__add_property  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String property_rule_ref;

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
        // Godot.GD.Print("Deserializing group__operation__and__add_property");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("property_rule_ref"))
        {
          var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
          this.property_rule_ref = rawNode.attributes["property_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.property_rule_ref != null)
        {
          rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing group__operation__and__add_property");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
  }


    public class world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String value;

      //Children elements
      public world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node()
      {
      }

      public world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("value"))
        {
          var attribute_value = rawNode.attributes["value"];
          this.value = rawNode.attributes["value"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.value != null)
        {
          rawNode.attributes["value"] = this.value.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__action_rule__from_person__on_person__selection__from_person_same_location_graph_node");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String value)
    {
      this.value = value;
    }
  }


    public class type__action__from__person  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__person_selection? select = null;
      public type__property_mutation? property_mutation = null;
      public type__action__from__person()
      {
      }

      public type__action__from__person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public type__action__from__person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing type__action__from__person");
        //Deserialize arguments

        //Deserialize children
        this.select = rawNode.InitializeWithRawNode("select", this.select);
        this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(select != null) {
          rawNode.children["select"] = new List<RawNode> { select.SerializeIntoRawNode() };
        }
        if(property_mutation != null) {
          rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__action__from__person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__person_selection? Get_select()
    {
      return this.select;
    }
    public void Set_select(type__person_selection? value)
    {
      this.select = value;
    }
    public type__property_mutation? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(type__property_mutation? value)
    {
      this.property_mutation = value;
    }
  }


    public class type__action__on__person  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public type__person_selection? select = null;
      public type__property_mutation? property_mutation = null;
      public type__action__on__person()
      {
      }

      public type__action__on__person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public type__action__on__person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing type__action__on__person");
        //Deserialize arguments

        //Deserialize children
        this.select = rawNode.InitializeWithRawNode("select", this.select);
        this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        if(select != null) {
          rawNode.children["select"] = new List<RawNode> { select.SerializeIntoRawNode() };
        }
        if(property_mutation != null) {
          rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__action__on__person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public type__person_selection? Get_select()
    {
      return this.select;
    }
    public void Set_select(type__person_selection? value)
    {
      this.select = value;
    }
    public type__property_mutation? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(type__property_mutation? value)
    {
      this.property_mutation = value;
    }
  }


    public class world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String node_rule_ref;
      public System.Int32 distance;
      public System.Int32? maxDistance;
      public System.Int32 adjacent_depth_limit;

      //Children elements
      public type__math_operations? distance_to_progress_multiplier = null;
      public type__math_operations? person_progress_property = null;
      public world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option()
      {
      }

      public world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option");
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
          this.maxDistance = attribute_maxDistance?.ToInt();
        }
        if(rawNode.attributes.ContainsKey("adjacent_depth_limit"))
        {
          var attribute_adjacent_depth_limit = rawNode.attributes["adjacent_depth_limit"];
          this.adjacent_depth_limit = attribute_adjacent_depth_limit.ToInt();
        }

        //Deserialize children
        this.distance_to_progress_multiplier = rawNode.InitializeWithRawNode("distance_to_progress_multiplier", this.distance_to_progress_multiplier);
        this.person_progress_property = rawNode.InitializeWithRawNode("person_progress_property", this.person_progress_property);
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
          rawNode.attributes["maxDistance"] = this.maxDistance?.ToString();
        }
        if(this.adjacent_depth_limit != null)
        {
          rawNode.attributes["adjacent_depth_limit"] = this.adjacent_depth_limit.ToString();
        }

        //Serialize children
        if(distance_to_progress_multiplier != null) {
          rawNode.children["distance_to_progress_multiplier"] = new List<RawNode> { distance_to_progress_multiplier.SerializeIntoRawNode() };
        }
        if(person_progress_property != null) {
          rawNode.children["person_progress_property"] = new List<RawNode> { person_progress_property.SerializeIntoRawNode() };
        }
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__rule_group__location_graph_rule__node_rule__link_group_list__link_group__to_option");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.Int32 Get_distance()
    {
      return this.distance;
    }
    public void Set_distance(System.Int32 value)
    {
      this.distance = value;
    }
    public System.Int32? Get_maxDistance()
    {
      return this.maxDistance;
    }
    public void Set_maxDistance(System.Int32? value)
    {
      this.maxDistance = value;
    }
    public System.Int32 Get_adjacent_depth_limit()
    {
      return this.adjacent_depth_limit;
    }
    public void Set_adjacent_depth_limit(System.Int32 value)
    {
      this.adjacent_depth_limit = value;
    }
    public type__math_operations? Get_distance_to_progress_multiplier()
    {
      return this.distance_to_progress_multiplier;
    }
    public void Set_distance_to_progress_multiplier(type__math_operations? value)
    {
      this.distance_to_progress_multiplier = value;
    }
    public type__math_operations? Get_person_progress_property()
    {
      return this.person_progress_property;
    }
    public void Set_person_progress_property(type__math_operations? value)
    {
      this.person_progress_property = value;
    }
  }


    public class world_step__data__location__location_graph__node__classifications__classification  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String location_classification_rule_ref;

      //Children elements
      public world_step__data__location__location_graph__node__classifications__classification()
      {
      }

      public world_step__data__location__location_graph__node__classifications__classification(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node__classifications__classification(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node__classifications__classification");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
        {
          var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
          this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.location_classification_rule_ref != null)
        {
          rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node__classifications__classification");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }
  }


    public class world_step__data__location__location_graph__node__link_to__people  {
      public RawNode rawNode = new RawNode();
      //Attributes

      //Children elements
      public List<world_step__data__location__location_graph__node__link_to__people__person>? person = new List<world_step__data__location__location_graph__node__link_to__people__person>();
      public world_step__data__location__location_graph__node__link_to__people()
      {
      }

      public world_step__data__location__location_graph__node__link_to__people(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node__link_to__people(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node__link_to__people");
        //Deserialize arguments

        //Deserialize children
        this.person = rawNode.InitializeWithRawNode("person", this.person);
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments

        //Serialize children
        rawNode.children["person"] = person.Select(x => x.SerializeIntoRawNode()).ToList();
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node__link_to__people");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public List<world_step__data__location__location_graph__node__link_to__people__person>? Get_person()
    {
      return this.person;
    }
    public List<world_step__data__location__location_graph__node__link_to__people__person> GetOrInsertDefault_person()
    {
      if(this.person == null) {
        this.person = new List<world_step__data__location__location_graph__node__link_to__people__person>();
      }
      return this.person;
    }
    public void Set_person(List<world_step__data__location__location_graph__node__link_to__people__person>? value)
    {
      this.person = value;
    }
  }


    public class world_step__data__location__location_graph__node__people__person  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String person_id_ref;

      //Children elements
      public world_step__data__location__location_graph__node__people__person()
      {
      }

      public world_step__data__location__location_graph__node__people__person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node__people__person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node__people__person");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("person_id_ref"))
        {
          var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
          this.person_id_ref = rawNode.attributes["person_id_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.person_id_ref != null)
        {
          rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node__people__person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
  }


    public class type__node_graph__selection__in__location_graph__has__location_graph_id__or  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String? location_graph_id_ref;

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
        // Godot.GD.Print("Deserializing type__node_graph__selection__in__location_graph__has__location_graph_id__or");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("location_graph_id_ref"))
        {
          var attribute_location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
          this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.location_graph_id_ref != null)
        {
          rawNode.attributes["location_graph_id_ref"] = this.location_graph_id_ref?.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing type__node_graph__selection__in__location_graph__has__location_graph_id__or");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String? Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String? value)
    {
      this.location_graph_id_ref = value;
    }
  }


    public class world_step__data__location__location_graph__node__link_to__people__person  {
      public RawNode rawNode = new RawNode();
      //Attributes
      public System.String person_id_ref;
      public System.Int32 accumulated_progress;

      //Children elements
      public world_step__data__location__location_graph__node__link_to__people__person()
      {
      }

      public world_step__data__location__location_graph__node__link_to__people__person(RawNode rawNode)
      {
        Deserialize(rawNode);
      }

      public world_step__data__location__location_graph__node__link_to__people__person(XmlElement xmlElement)
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }

      public void Deserialize (RawNode rawNode)
      {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing world_step__data__location__location_graph__node__link_to__people__person");
        //Deserialize arguments
        if(rawNode.attributes.ContainsKey("person_id_ref"))
        {
          var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
          this.person_id_ref = rawNode.attributes["person_id_ref"];
        }
        if(rawNode.attributes.ContainsKey("accumulated_progress"))
        {
          var attribute_accumulated_progress = rawNode.attributes["accumulated_progress"];
          this.accumulated_progress = attribute_accumulated_progress.ToInt();
        }

        //Deserialize children
      }

      public RawNode SerializeIntoRawNode()
      {
        //Serialize arguments
        if(this.person_id_ref != null)
        {
          rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
        }
        if(this.accumulated_progress != null)
        {
          rawNode.attributes["accumulated_progress"] = this.accumulated_progress.ToString();
        }

        //Serialize children
        return rawNode;
      }

      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing world_step__data__location__location_graph__node__link_to__people__person");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public System.Int32 Get_accumulated_progress()
    {
      return this.accumulated_progress;
    }
    public void Set_accumulated_progress(System.Int32 value)
    {
      this.accumulated_progress = value;
    }
  }
}