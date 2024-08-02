using System;
using System.Collections.Generic;
using System.Xml;

namespace XSD {
   /*Type: attribute*/
   using property_rule_ref = System.String;
   /*Type: simple*/
   using item_slot = System.String;
   /*Type: simple*/
   using type_direction = System.String;
   /*Type: simple*/
   using type_person_select = System.String;
   /*Type: simple*/
   using type__group__operation__and = System.String;
  /*Type: complex*/
  public class group__item_data {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("classifications")]
    public List<type__classification_list> classifications = new List<type__classification_list>();
    [Element("properties")]
    public List<type__property_list> properties = new List<type__property_list>();

    public group__item_data() {
    }

    public group__item_data (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing group__item_data");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class group__operation__and {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("add_property")]
    public List<group__operation__and__add_property> add_property = new List<group__operation__and__add_property>();
    [Element("and")]
    public List<group__operation__and> and = new List<group__operation__and>();

    public group__operation__and() {
    }

    public group__operation__and (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing group__operation__and");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class group__math_operations {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("operation")]
    public List<group__operation__and> operation = new List<group__operation__and>();

    public group__math_operations() {
    }

    public group__math_operations (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing group__math_operations");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class group__name_token {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("name_token")]
    public List<System.Object> name_token = new List<System.Object>();

    public group__name_token() {
    }

    public group__name_token (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing group__name_token");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type_range {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    public type_range() {
    }

    public type_range (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type_range");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__property_mutation_on {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("on")]
    public type_person_select on;

    [Attribute("property_rule_ref")]
    public string property_rule_ref;
    [Element("from")]
    public List<group__math_operations> from = new List<group__math_operations>();

    public type__property_mutation_on() {
    }

    public type__property_mutation_on (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__property_mutation_on");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__property_mutation {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("property_rule_ref")]
    public string property_rule_ref;
    [Element("from")]
    public List<group__math_operations> from = new List<group__math_operations>();

    public type__property_mutation() {
    }

    public type__property_mutation (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__property_mutation");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type_icon {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    public type_icon() {
    }

    public type_icon (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type_icon");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__property_list {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("property")]
    public List<type__property_list__property> property = new List<type__property_list__property>();

    public type__property_list() {
    }

    public type__property_list (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__property_list");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__classification_list {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("classification")]
    public List<type__classification_list__classification> classification = new List<type__classification_list__classification>();

    public type__classification_list() {
    }

    public type__classification_list (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__classification_list");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__item: group__item_data {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public System.Object id;
    [Attribute("name")]
    public System.Object name;

    public type__item() {
    }

    public type__item (XmlNode xmlElement): base(xmlElement) {
      Godot.GD.Print("Deserializing type__item");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__item_selection {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("min")]
    public List<type__math_operations> min = new List<type__math_operations>();
    [Element("max")]
    public List<type__math_operations> max = new List<type__math_operations>();

    [Element("classifications")]
    public List<type__classification_list> classifications = new List<type__classification_list>();
    [Element("properties")]
    public List<type__property_list> properties = new List<type__property_list>();

    public type__item_selection() {
    }

    public type__item_selection (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__item_selection");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type_cell_ref {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("layer")]
    public System.Object layer;
    [Attribute("x")]
    public System.Int32 x;
    [Attribute("y")]
    public System.Int32 y;

    public type_cell_ref() {
    }

    public type_cell_ref (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type_cell_ref");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__person_selection {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("radius")]
    public List<type__math_operations> radius = new List<type__math_operations>();
    [Element("min")]
    public List<type__math_operations> min = new List<type__math_operations>();
    [Element("max")]
    public List<type__math_operations> max = new List<type__math_operations>();
    [Element("property")]
    public List<type__person_selection__property> property = new List<type__person_selection__property>();
    [Element("classification")]
    public List<type__person_selection__classification> classification = new List<type__person_selection__classification>();
    [Element("race")]
    public List<type__person_selection__race> race = new List<type__person_selection__race>();
    [Element("inventory")]
    public List<type__person_selection__inventory> inventory = new List<type__person_selection__inventory>();

    public type__person_selection() {
    }

    public type__person_selection (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__person_selection");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__trigger {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("person_action_used")]
    public List<type__trigger__person_action_used> person_action_used = new List<type__trigger__person_action_used>();

    public type__trigger() {
    }

    public type__trigger (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__trigger");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__math_operations: group__operation__and {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("initial")]
    public System.Int32 initial;

    public type__math_operations() {
    }

    public type__math_operations (XmlNode xmlElement): base(xmlElement) {
      Godot.GD.Print("Deserializing type__math_operations");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: complex*/
  public class type__action {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("from")]
    public List<type__action__from> from = new List<type__action__from>();
    [Element("on")]
    public List<type__action__on> on = new List<type__action__on>();

    public type__action() {
    }

    public type__action (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__action");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }
  /*Type: element*/
  public class world_step {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("world_metadata")]
    public List<world_step__world_metadata> world_metadata = new List<world_step__world_metadata>();
    [Element("rule_group")]
    public List<world_step__rule_group> rule_group = new List<world_step__rule_group>();
    [Element("items")]
    public List<world_step__items> items = new List<world_step__items>();
    [Element("people")]
    public List<world_step__people> people = new List<world_step__people>();
    [Element("location_layer")]
    public List<world_step__location_layer> location_layer = new List<world_step__location_layer>();
    [Element("location_graph")]
    public List<world_step__location_graph> location_graph = new List<world_step__location_graph>();
    [Element("actions")]
    public List<world_step__actions> actions = new List<world_step__actions>();

    public world_step() {
    }

    public world_step (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }

        internal object Serialize()
        {
            throw new NotImplementedException();
        }
    }

  /*Type: element*/
  public class group__operation__and__add_property {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("property_rule_ref")]
    public string property_rule_ref;

    public group__operation__and__add_property() {
    }

    public group__operation__and__add_property (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing group__operation__and__add_property");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class System__Object {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("ref")]
    public List<System__Object___ref> _ref = new List<System__Object___ref>();

    [Element("one_of")]
    public List<group__name_token> one_of = new List<group__name_token>();

    public System__Object() {
    }

    public System__Object (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing System.Object");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class System__Object___ref {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("name_rule_ref")]
    public string name_rule_ref;

    public System__Object___ref() {
    }

    public System__Object___ref (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing System.Object___ref");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__property_list__property {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("property_rule_ref")]
    public string property_rule_ref;
    [Attribute("value")]
    public System.Int32 value;

    public type__property_list__property() {
    }

    public type__property_list__property (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__property_list__property");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__classification_list__classification {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("classification_rule_ref")]
    public string classification_rule_ref;

    public type__classification_list__classification() {
    }

    public type__classification_list__classification (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__classification_list__classification");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__person_selection__property {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("property_rule_ref")]
    public string property_rule_ref;
    [Element("min")]
    public List<type__math_operations> min = new List<type__math_operations>();
    [Element("max")]
    public List<type__math_operations> max = new List<type__math_operations>();

    public type__person_selection__property() {
    }

    public type__person_selection__property (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__person_selection__property");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__person_selection__classification {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("classification_rule_ref")]
    public string classification_rule_ref;

    public type__person_selection__classification() {
    }

    public type__person_selection__classification (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__person_selection__classification");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__person_selection__race {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("race_rule_ref")]
    public System.Object race_rule_ref;

    public type__person_selection__race() {
    }

    public type__person_selection__race (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__person_selection__race");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__person_selection__inventory {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("item")]
    public List<type__item_selection> item = new List<type__item_selection>();

    public type__person_selection__inventory() {
    }

    public type__person_selection__inventory (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__person_selection__inventory");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__trigger__person_action_used {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("action_rule_ref")]
    public System.Object action_rule_ref;

    public type__trigger__person_action_used() {
    }

    public type__trigger__person_action_used (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__trigger__person_action_used");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__action__from {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("person")]
    public List<type__action__from__person> person = new List<type__action__from__person>();

    public type__action__from() {
    }

    public type__action__from (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__action__from");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__action__from__person {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("select")]
    public List<type__person_selection> select = new List<type__person_selection>();
    [Element("property_mutation")]
    public List<type__property_mutation> property_mutation = new List<type__property_mutation>();

    public type__action__from__person() {
    }

    public type__action__from__person (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__action__from__person");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__action__on {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("person")]
    public List<type__action__on__person> person = new List<type__action__on__person>();

    public type__action__on() {
    }

    public type__action__on (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__action__on");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class type__action__on__person {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("select")]
    public List<type__person_selection> select = new List<type__person_selection>();
    [Element("property_mutation")]
    public List<type__property_mutation> property_mutation = new List<type__property_mutation>();

    public type__action__on__person() {
    }

    public type__action__on__person (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing type__action__on__person");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__world_metadata {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("previous_world_step")]
    public List<world_step__world_metadata__previous_world_step> previous_world_step = new List<world_step__world_metadata__previous_world_step>();
    [Element("next_world_step")]
    public List<world_step__world_metadata__next_world_step> next_world_step = new List<world_step__world_metadata__next_world_step>();
    [Element("elapsed_time")]
    public List<world_step__world_metadata__elapsed_time> elapsed_time = new List<world_step__world_metadata__elapsed_time>();
    [Element("stepDuration")]
    public List<world_step__world_metadata__stepDuration> stepDuration = new List<world_step__world_metadata__stepDuration>();
    [Element("counter")]
    public List<world_step__world_metadata__counter> counter = new List<world_step__world_metadata__counter>();
    [Element("randomization_table")]
    public List<world_step__world_metadata__randomization_table> randomization_table = new List<world_step__world_metadata__randomization_table>();

    public world_step__world_metadata() {
    }

    public world_step__world_metadata (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__world_metadata");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__world_metadata__previous_world_step {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("value")]
    public string value;

    public world_step__world_metadata__previous_world_step() {
    }

    public world_step__world_metadata__previous_world_step (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__world_metadata__previous_world_step");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__world_metadata__next_world_step {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("value")]
    public string value;

    public world_step__world_metadata__next_world_step() {
    }

    public world_step__world_metadata__next_world_step (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__world_metadata__next_world_step");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__world_metadata__elapsed_time {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("value")]
    public System.Int32 value;

    public world_step__world_metadata__elapsed_time() {
    }

    public world_step__world_metadata__elapsed_time (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__world_metadata__elapsed_time");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__world_metadata__stepDuration {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("value")]
    public System.Int32 value;

    public world_step__world_metadata__stepDuration() {
    }

    public world_step__world_metadata__stepDuration (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__world_metadata__stepDuration");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__world_metadata__counter {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("value")]
    public System.Int32 value;

    public world_step__world_metadata__counter() {
    }

    public world_step__world_metadata__counter (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__world_metadata__counter");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__world_metadata__randomization_table {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("entry")]
    public List<world_step__world_metadata__randomization_table__entry> entry = new List<world_step__world_metadata__randomization_table__entry>();

    public world_step__world_metadata__randomization_table() {
    }

    public world_step__world_metadata__randomization_table (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__world_metadata__randomization_table");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__world_metadata__randomization_table__entry {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("value")]
    public System.Int32 value;

    public world_step__world_metadata__randomization_table__entry() {
    }

    public world_step__world_metadata__randomization_table__entry (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__world_metadata__randomization_table__entry");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public System.Object id;
    [Element("property_rule")]
    public List<world_step__rule_group__property_rule> property_rule = new List<world_step__rule_group__property_rule>();
    [Element("classification_rule")]
    public List<world_step__rule_group__classification_rule> classification_rule = new List<world_step__rule_group__classification_rule>();
    [Element("name_rule")]
    public List<world_step__rule_group__name_rule> name_rule = new List<world_step__rule_group__name_rule>();
    [Element("race_rule")]
    public List<world_step__rule_group__race_rule> race_rule = new List<world_step__rule_group__race_rule>();
    [Element("action_rule")]
    public List<world_step__rule_group__action_rule> action_rule = new List<world_step__rule_group__action_rule>();
    [Element("item_rule")]
    public List<world_step__rule_group__item_rule> item_rule = new List<world_step__rule_group__item_rule>();
    [Element("events_rule")]
    public List<world_step__rule_group__events_rule> events_rule = new List<world_step__rule_group__events_rule>();
    [Element("locations_markov_chain")]
    public List<world_step__rule_group__locations_markov_chain> locations_markov_chain = new List<world_step__rule_group__locations_markov_chain>();
    [Element("location_graph_rule")]
    public List<world_step__rule_group__location_graph_rule> location_graph_rule = new List<world_step__rule_group__location_graph_rule>();

    public world_step__rule_group() {
    }

    public world_step__rule_group (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__property_rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("entry")]
    public List<world_step__rule_group__property_rule__entry> entry = new List<world_step__rule_group__property_rule__entry>();

    public world_step__rule_group__property_rule() {
    }

    public world_step__rule_group__property_rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__property_rule__entry {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public System.Object id;
    [Attribute("units")]
    public System.Object units;
    [Element("person_default")]
    public List<System.Object> person_default = new List<System.Object>();
    [Element("item_default")]
    public List<System.Object> item_default = new List<System.Object>();
    [Element("property-threshold")]
    public List<world_step__rule_group__property_rule__entry__property_threshold> property_threshold = new List<world_step__rule_group__property_rule__entry__property_threshold>();

    public world_step__rule_group__property_rule__entry() {
    }

    public world_step__rule_group__property_rule__entry (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__property_rule__entry__property_threshold {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("name")]
    public string name;
    [Attribute("min-value-inclusive")]
    public System.Int32 min_value_inclusive;
    [Attribute("max-value-inclusive")]
    public System.Int32 max_value_inclusive;

    public world_step__rule_group__property_rule__entry__property_threshold() {
    }

    public world_step__rule_group__property_rule__entry__property_threshold (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__property_rule__entry__property_threshold");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__classification_rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("entry")]
    public List<world_step__rule_group__classification_rule__entry> entry = new List<world_step__rule_group__classification_rule__entry>();

    public world_step__rule_group__classification_rule() {
    }

    public world_step__rule_group__classification_rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__classification_rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__classification_rule__entry {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public System.Object id;
    [Element("property")]
    public List<group__math_operations> property = new List<group__math_operations>();

    public world_step__rule_group__classification_rule__entry() {
    }

    public world_step__rule_group__classification_rule__entry (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__classification_rule__entry");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__name_rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("entry")]
    public List<group__name_token> entry = new List<group__name_token>();

    public world_step__rule_group__name_rule() {
    }

    public world_step__rule_group__name_rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__name_rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__race_rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("entry")]
    public List<world_step__rule_group__race_rule__entry> entry = new List<world_step__rule_group__race_rule__entry>();

    public world_step__rule_group__race_rule() {
    }

    public world_step__rule_group__race_rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__race_rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__race_rule__entry {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public string id;
    [Element("vision")]
    public List<type_range> vision = new List<type_range>();
    [Element("movement")]
    public List<type_range> movement = new List<type_range>();
    [Element("name")]
    public List<world_step__rule_group__race_rule__entry__name> name = new List<world_step__rule_group__race_rule__entry__name>();
    [Element("property_bonus")]
    public List<group__math_operations> property_bonus = new List<group__math_operations>();
    [Element("icon")]
    public List<type_icon> icon = new List<type_icon>();

    public world_step__rule_group__race_rule__entry() {
    }

    public world_step__rule_group__race_rule__entry (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__race_rule__entry");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__race_rule__entry__name {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("name_rule_ref")]
    public string name_rule_ref;

    public world_step__rule_group__race_rule__entry__name() {
    }

    public world_step__rule_group__race_rule__entry__name (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__race_rule__entry__name");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__action_rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("global")]
    public List<world_step__rule_group__action_rule__global> global = new List<world_step__rule_group__action_rule__global>();
    [Element("person_to_person")]
    public List<world_step__rule_group__action_rule__person_to_person> person_to_person = new List<world_step__rule_group__action_rule__person_to_person>();

    public world_step__rule_group__action_rule() {
    }

    public world_step__rule_group__action_rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__action_rule__global {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("entry")]
    public List<System.Object> entry = new List<System.Object>();

    public world_step__rule_group__action_rule__global() {
    }

    public world_step__rule_group__action_rule__global (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__global");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class undefined__from {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("person")]
    public List<undefined__from__person> person = new List<undefined__from__person>();

    public undefined__from() {
    }

    public undefined__from (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing undefined__from");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class undefined__from__person {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("select")]
    public List<type__person_selection> select = new List<type__person_selection>();
    [Element("property_mutation")]
    public List<type__property_mutation> property_mutation = new List<type__property_mutation>();

    public undefined__from__person() {
    }

    public undefined__from__person (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing undefined__from__person");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class undefined__on {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("person")]
    public List<undefined__on__person> person = new List<undefined__on__person>();

    public undefined__on() {
    }

    public undefined__on (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing undefined__on");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class undefined__on__person {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("select")]
    public List<type__person_selection> select = new List<type__person_selection>();
    [Element("property_mutation")]
    public List<type__property_mutation> property_mutation = new List<type__property_mutation>();

    public undefined__on__person() {
    }

    public undefined__on__person (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing undefined__on__person");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__action_rule__person_to_person {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public System.Object id;
    [Element("test")]
    public List<world_step__rule_group__action_rule__person_to_person__test> test = new List<world_step__rule_group__action_rule__person_to_person__test>();
    [Element("property_mutation")]
    public List<type__property_mutation_on> property_mutation = new List<type__property_mutation_on>();
    [Element("location_mutation")]
    public List<world_step__rule_group__action_rule__person_to_person__location_mutation> location_mutation = new List<world_step__rule_group__action_rule__person_to_person__location_mutation>();

    public world_step__rule_group__action_rule__person_to_person() {
    }

    public world_step__rule_group__action_rule__person_to_person (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__action_rule__person_to_person__test {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("value")]
    public List<group__math_operations> value = new List<group__math_operations>();
    [Element("expected")]
    public List<group__math_operations> expected = new List<group__math_operations>();

    public world_step__rule_group__action_rule__person_to_person__test() {
    }

    public world_step__rule_group__action_rule__person_to_person__test (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person__test");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__action_rule__person_to_person__location_mutation {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("name")]
    public System.Object name;
    [Attribute("on")]
    public type_person_select on;
    [Element("from")]
    public List<group__math_operations> from = new List<group__math_operations>();

    public world_step__rule_group__action_rule__person_to_person__location_mutation() {
    }

    public world_step__rule_group__action_rule__person_to_person__location_mutation (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__action_rule__person_to_person__location_mutation");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__item_rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("entry")]
    public List<world_step__rule_group__item_rule__entry> entry = new List<world_step__rule_group__item_rule__entry>();

    public world_step__rule_group__item_rule() {
    }

    public world_step__rule_group__item_rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__item_rule__entry {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public System.Object id;
    [Element("name")]
    public List<group__name_token> name = new List<group__name_token>();
    [Element("weight-kg")]
    public List<world_step__rule_group__item_rule__entry__weight_kg> weight_kg = new List<world_step__rule_group__item_rule__entry__weight_kg>();
    [Element("wearable")]
    public List<world_step__rule_group__item_rule__entry__wearable> wearable = new List<world_step__rule_group__item_rule__entry__wearable>();

    public world_step__rule_group__item_rule__entry() {
    }

    public world_step__rule_group__item_rule__entry (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule__entry");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__item_rule__entry__weight_kg {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("value")]
    public System.Object value;

    public world_step__rule_group__item_rule__entry__weight_kg() {
    }

    public world_step__rule_group__item_rule__entry__weight_kg (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule__entry__weight_kg");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__item_rule__entry__wearable {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("slot")]
    public item_slot slot;

    public world_step__rule_group__item_rule__entry__wearable() {
    }

    public world_step__rule_group__item_rule__entry__wearable (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__item_rule__entry__wearable");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__events_rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("entry")]
    public List<world_step__rule_group__events_rule__entry> entry = new List<world_step__rule_group__events_rule__entry>();

    public world_step__rule_group__events_rule() {
    }

    public world_step__rule_group__events_rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__events_rule__entry {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public string id;
    [Element("when")]
    public List<type__trigger> when = new List<type__trigger>();
    [Element("then")]
    public List<world_step__rule_group__events_rule__entry__then> then = new List<world_step__rule_group__events_rule__entry__then>();

    public world_step__rule_group__events_rule__entry() {
    }

    public world_step__rule_group__events_rule__entry (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__events_rule__entry__then {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("select_person")]
    public List<System.Object> select_person = new List<System.Object>();
    [Element("select_item")]
    public List<System.Object> select_item = new List<System.Object>();
    [Element("property_mutation")]
    public List<System.Object> property_mutation = new List<System.Object>();

    public world_step__rule_group__events_rule__entry__then() {
    }

    public world_step__rule_group__events_rule__entry__then (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__events_rule__entry__then");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class undefined__property {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("property_rule_ref")]
    public string property_rule_ref;
    [Element("min")]
    public List<type__math_operations> min = new List<type__math_operations>();
    [Element("max")]
    public List<type__math_operations> max = new List<type__math_operations>();

    public undefined__property() {
    }

    public undefined__property (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing undefined__property");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class undefined__classification {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("classification_rule_ref")]
    public string classification_rule_ref;

    public undefined__classification() {
    }

    public undefined__classification (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing undefined__classification");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class undefined__race {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("race_rule_ref")]
    public System.Object race_rule_ref;

    public undefined__race() {
    }

    public undefined__race (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing undefined__race");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class undefined__inventory {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("item")]
    public List<type__item_selection> item = new List<type__item_selection>();

    public undefined__inventory() {
    }

    public undefined__inventory (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing undefined__inventory");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__locations_markov_chain {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("location_markov_link")]
    public List<world_step__rule_group__locations_markov_chain__location_markov_link> location_markov_link = new List<world_step__rule_group__locations_markov_chain__location_markov_link>();

    public world_step__rule_group__locations_markov_chain() {
    }

    public world_step__rule_group__locations_markov_chain (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__locations_markov_chain__location_markov_link {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("type")]
    public System.Object type;
    [Element("tag")]
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__tag> tag = new List<world_step__rule_group__locations_markov_chain__location_markov_link__tag>();
    [Element("sibling")]
    public List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling> sibling = new List<world_step__rule_group__locations_markov_chain__location_markov_link__sibling>();
    [Element("icon")]
    public List<type_icon> icon = new List<type_icon>();

    public world_step__rule_group__locations_markov_chain__location_markov_link() {
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain__location_markov_link");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__locations_markov_chain__location_markov_link__tag {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("name")]
    public System.Object name;

    public world_step__rule_group__locations_markov_chain__location_markov_link__tag() {
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__tag (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain__location_markov_link__tag");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__locations_markov_chain__location_markov_link__sibling {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("location_rule_ref")]
    public System.Object location_rule_ref;
    [Attribute("quantity")]
    public System.Int32 quantity;
    [Attribute("position")]
    public System.Object position;

    public world_step__rule_group__locations_markov_chain__location_markov_link__sibling() {
    }

    public world_step__rule_group__locations_markov_chain__location_markov_link__sibling (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__locations_markov_chain__location_markov_link__sibling");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__location_graph_rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public string id;
    [Element("setup")]
    public List<world_step__rule_group__location_graph_rule__setup> setup = new List<world_step__rule_group__location_graph_rule__setup>();
    [Element("node_rule")]
    public List<world_step__rule_group__location_graph_rule__node_rule> node_rule = new List<world_step__rule_group__location_graph_rule__node_rule>();

    public world_step__rule_group__location_graph_rule() {
    }

    public world_step__rule_group__location_graph_rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__location_graph_rule__setup {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("starting_node")]
    public List<world_step__rule_group__location_graph_rule__setup__starting_node> starting_node = new List<world_step__rule_group__location_graph_rule__setup__starting_node>();

    public world_step__rule_group__location_graph_rule__setup() {
    }

    public world_step__rule_group__location_graph_rule__setup (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__location_graph_rule__setup__starting_node {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("node_rule_ref")]
    public string node_rule_ref;

    public world_step__rule_group__location_graph_rule__setup__starting_node() {
    }

    public world_step__rule_group__location_graph_rule__setup__starting_node (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__setup__starting_node");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__location_graph_rule__node_rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public string id;
    [Element("link_group")]
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group> link_group = new List<world_step__rule_group__location_graph_rule__node_rule__link_group>();

    public world_step__rule_group__location_graph_rule__node_rule() {
    }

    public world_step__rule_group__location_graph_rule__node_rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__location_graph_rule__node_rule__link_group {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public string id;
    [Attribute("angle")]
    public System.Int32 angle;
    [Attribute("angleMax")]
    public System.Int32 angleMax;
    [Attribute("limit")]
    public System.Int32 limit;
    [Element("to_option")]
    public List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option> to_option = new List<world_step__rule_group__location_graph_rule__node_rule__link_group__to_option>();

    public world_step__rule_group__location_graph_rule__node_rule__link_group() {
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__rule_group__location_graph_rule__node_rule__link_group__to_option {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("node_rule_ref")]
    public string node_rule_ref;
    [Attribute("distance")]
    public System.Int32 distance;
    [Attribute("maxDistance")]
    public System.Int32 maxDistance;
    [Attribute("adjacent_depth_limit")]
    public System.Int32 adjacent_depth_limit;

    public world_step__rule_group__location_graph_rule__node_rule__link_group__to_option() {
    }

    public world_step__rule_group__location_graph_rule__node_rule__link_group__to_option (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__rule_group__location_graph_rule__node_rule__link_group__to_option");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__items {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("item")]
    public List<type__item> item = new List<type__item>();

    public world_step__items() {
    }

    public world_step__items (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__items");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__people {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("person")]
    public List<world_step__people__person> person = new List<world_step__people__person>();

    public world_step__people() {
    }

    public world_step__people (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__people");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__people__person {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public System.Object id;
    [Attribute("name")]
    public System.Object name;
    [Element("race")]
    public List<world_step__people__person__race> race = new List<world_step__people__person__race>();
    [Element("location")]
    public List<type_cell_ref> location = new List<type_cell_ref>();
    [Element("properties")]
    public List<world_step__people__person__properties> properties = new List<world_step__people__person__properties>();
    [Element("relations")]
    public List<world_step__people__person__relations> relations = new List<world_step__people__person__relations>();
    [Element("inventory")]
    public List<world_step__people__person__inventory> inventory = new List<world_step__people__person__inventory>();
    [Element("classifications")]
    public List<world_step__people__person__classifications> classifications = new List<world_step__people__person__classifications>();
    [Element("icon")]
    public List<type_icon> icon = new List<type_icon>();

    public world_step__people__person() {
    }

    public world_step__people__person (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__people__person");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__people__person__race {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("race_rule_ref")]
    public System.Object race_rule_ref;

    public world_step__people__person__race() {
    }

    public world_step__people__person__race (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__people__person__race");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__people__person__properties {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("property")]
    public List<world_step__people__person__properties__property> property = new List<world_step__people__person__properties__property>();

    public world_step__people__person__properties() {
    }

    public world_step__people__person__properties (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__people__person__properties");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__people__person__properties__property {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("property_rule_ref")]
    public string property_rule_ref;
    [Attribute("value")]
    public System.Object value;

    public world_step__people__person__properties__property() {
    }

    public world_step__people__person__properties__property (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__people__person__properties__property");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__people__person__relations {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("with")]
    public System.Object with;

    public world_step__people__person__relations() {
    }

    public world_step__people__person__relations (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__people__person__relations");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__people__person__inventory {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("item")]
    public List<type__item> item = new List<type__item>();

    public world_step__people__person__inventory() {
    }

    public world_step__people__person__inventory (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__people__person__inventory");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__people__person__classifications {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("classification")]
    public List<world_step__people__person__classifications__classification> classification = new List<world_step__people__person__classifications__classification>();

    public world_step__people__person__classifications() {
    }

    public world_step__people__person__classifications (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__people__person__classifications");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__people__person__classifications__classification {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("classification_rule_ref")]
    public string classification_rule_ref;

    public world_step__people__person__classifications__classification() {
    }

    public world_step__people__person__classifications__classification (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__people__person__classifications__classification");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__location_layer {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("name")]
    public System.Object name;
    [Element("cell")]
    public List<world_step__location_layer__cell> cell = new List<world_step__location_layer__cell>();

    public world_step__location_layer() {
    }

    public world_step__location_layer (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__location_layer");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__location_layer__cell {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("location_rule_ref")]
    public System.Object location_rule_ref;
    [Attribute("x")]
    public System.Object x;
    [Attribute("y")]
    public System.Object y;

    public world_step__location_layer__cell() {
    }

    public world_step__location_layer__cell (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__location_layer__cell");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__location_graph {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("id")]
    public string id;
    [Element("rule")]
    public List<world_step__location_graph__rule> rule = new List<world_step__location_graph__rule>();
    [Element("node")]
    public List<world_step__location_graph__node> node = new List<world_step__location_graph__node>();

    public world_step__location_graph() {
    }

    public world_step__location_graph (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__location_graph");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__location_graph__rule {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("location_graph_rule_ref")]
    public string location_graph_rule_ref;

    public world_step__location_graph__rule() {
    }

    public world_step__location_graph__rule (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__location_graph__rule");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__location_graph__node {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("node_rule_ref")]
    public string node_rule_ref;
    [Attribute("id")]
    public string id;
    [Element("position")]
    public List<world_step__location_graph__node__position> position = new List<world_step__location_graph__node__position>();
    [Element("link_to")]
    public List<world_step__location_graph__node__link_to> link_to = new List<world_step__location_graph__node__link_to>();
    [Element("people")]
    public List<world_step__location_graph__node__people> people = new List<world_step__location_graph__node__people>();

    public world_step__location_graph__node() {
    }

    public world_step__location_graph__node (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__location_graph__node");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__location_graph__node__position {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("x")]
    public System.Int32 x;
    [Attribute("y")]
    public System.Int32 y;

    public world_step__location_graph__node__position() {
    }

    public world_step__location_graph__node__position (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__location_graph__node__position");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__location_graph__node__link_to {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("node_id_ref")]
    public string node_id_ref;

    public world_step__location_graph__node__link_to() {
    }

    public world_step__location_graph__node__link_to (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__location_graph__node__link_to");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__location_graph__node__people {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("person")]
    public List<world_step__location_graph__node__people__person> person = new List<world_step__location_graph__node__people__person>();

    public world_step__location_graph__node__people() {
    }

    public world_step__location_graph__node__people (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__location_graph__node__people");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__location_graph__node__people__person {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("person_id_ref")]
    public string person_id_ref;

    public world_step__location_graph__node__people__person() {
    }

    public world_step__location_graph__node__people__person (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__location_graph__node__people__person");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__actions {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Element("by")]
    public List<System.Object> by = new List<System.Object>();
    [Element("location_graph.create")]
    public List<world_step__actions__location_graph__create> location_graph__create = new List<world_step__actions__location_graph__create>();
    [Element("location_graph.node.create_adjacent")]
    public List<world_step__actions__location_graph__node__create_adjacent> location_graph__node__create_adjacent = new List<world_step__actions__location_graph__node__create_adjacent>();
    [Element("person.teleport")]
    public List<System.Object> person__teleport = new List<System.Object>();
    [Element("person.on_person.property_mutation")]
    public List<world_step__actions__person__on_person__property_mutation> person__on_person__property_mutation = new List<world_step__actions__person__on_person__property_mutation>();

    public world_step__actions() {
    }

    public world_step__actions (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__actions");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class System__Object__do {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("action_rule_ref")]
    public System.Object action_rule_ref;
    [Attribute("action_ref")]
    public System.Object action_ref;
    [Attribute("person_ref")]
    public System.Object person_ref;

    public System__Object__do() {
    }

    public System__Object__do (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing System.Object__do");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class System__Object__move_towards {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("layer")]
    public string layer;
    [Attribute("x")]
    public System.Int32 x;
    [Attribute("y")]
    public System.Int32 y;

    public System__Object__move_towards() {
    }

    public System__Object__move_towards (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing System.Object__move_towards");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__actions__location_graph__create {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("location_graph_rule_ref")]
    public string location_graph_rule_ref;

    public world_step__actions__location_graph__create() {
    }

    public world_step__actions__location_graph__create (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__actions__location_graph__create");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__actions__location_graph__node__create_adjacent {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("location_graph_id_ref")]
    public string location_graph_id_ref;
    [Attribute("node_id_ref")]
    public string node_id_ref;

    public world_step__actions__location_graph__node__create_adjacent() {
    }

    public world_step__actions__location_graph__node__create_adjacent (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__actions__location_graph__node__create_adjacent");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class System__Object__location_graph {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("location_graph_id")]
    public string location_graph_id;
    [Attribute("node_id")]
    public string node_id;

    public System__Object__location_graph() {
    }

    public System__Object__location_graph (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing System.Object__location_graph");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }

  /*Type: element*/
  public class world_step__actions__person__on_person__property_mutation {
    public WorldStepSerializer serializer = new WorldStepSerializer();

    [Attribute("person_id_ref")]
    public string person_id_ref;
    [Attribute("target_person_id_ref")]
    public string target_person_id_ref;
    [Attribute("action_property_mutation_rule_ref")]
    public string action_property_mutation_rule_ref;

    public world_step__actions__person__on_person__property_mutation() {
    }

    public world_step__actions__person__on_person__property_mutation (XmlNode xmlElement) {
      Godot.GD.Print("Deserializing world_step__actions__person__on_person__property_mutation");
      serializer.Deserialize(xmlElement, this);
    }

    public void Serialize(XmlElement element)
    {
        serializer.Serialize(element, this);
    }
  }


}