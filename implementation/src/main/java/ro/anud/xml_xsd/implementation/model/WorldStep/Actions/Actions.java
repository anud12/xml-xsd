package ro.anud.xml_xsd.implementation.model.WorldStep.Actions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Actions implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "actions";
    public static Actions fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Actions();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Actions fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Actions> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Actions.fromRawNode(o, parent)));
        }

    }
    public static List<Actions> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Actions> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Actions.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.actions";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By> by = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> locationGraph_create = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> locationGraph_node_createAdjacent = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> locationGraph_node_addClassification = new ArrayList<>();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport> person_teleport = Optional.empty();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation> person_onPerson_propertyMutation = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create> person_create = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo> person_moveTo = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson> fromPerson = new ArrayList<>();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create> zone_create = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew> region_appendNew = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals> region_resolvePortals = Optional.empty();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private RawNode rawNode = new RawNode();

    public RawNode rawNode() {
      return rawNode;
    }
    public void rawNode(RawNode rawNode) {
      this.rawNode = rawNode;
    }

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode() {
      return parentNode;
    }

    @Builder.Default
    private List<Consumer<List<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "actions";
    }

    public void notifyChange(List<Object> list) {
      try (var logger = logScope()) {
        list.addLast(this);
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.accept(list));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public void clearParentNode() {
      var parentNode = this.parentNode;
      this.parentNode = Optional.empty();
      parentNode.ifPresent(ro.anud.xml_xsd.implementation.util.LinkedNode::notifyChange);
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep> parentAsWorldStep() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By) {
          this.by.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create) {
          this.locationGraph_create.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent) {
          this.locationGraph_node_createAdjacent.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification) {
          this.locationGraph_node_addClassification.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport) {
          this.person_teleport = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation) {
          this.person_onPerson_propertyMutation.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create) {
          this.person_create.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo) {
          this.person_moveTo.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson) {
          this.fromPerson.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create) {
          this.zone_create = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew) {
          this.region_appendNew = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals) {
          this.region_resolvePortals = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By) {
          return this.by.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create) {
          return this.locationGraph_create.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent) {
          return this.locationGraph_node_createAdjacent.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification) {
          return this.locationGraph_node_addClassification.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation) {
          return this.person_onPerson_propertyMutation.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create) {
          return this.person_create.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo) {
          return this.person_moveTo.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson) {
          return this.fromPerson.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      try (var logger = logScope()) {
        onChangeList.add(onChange);
        return logger.logReturn(() -> onChangeList.remove(onChange));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.by = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By.fromRawNode(rawNode.getChildrenList("by"), this);
          this.locationGraph_create = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.fromRawNode(rawNode.getChildrenList("location_graph.create"), this);
          this.locationGraph_node_createAdjacent = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.fromRawNode(rawNode.getChildrenList("location_graph.node.create_adjacent"), this);
          this.locationGraph_node_addClassification = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.fromRawNode(rawNode.getChildrenList("location_graph.node.add_classification"), this);
          this.person_teleport = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport.fromRawNode(rawNode.getChildrenFirst("person.teleport"), this);
          this.person_onPerson_propertyMutation = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation.fromRawNode(rawNode.getChildrenList("person.on_person.property_mutation"), this);
          this.person_create = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create.fromRawNode(rawNode.getChildrenList("person.create"), this);
          this.person_moveTo = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo.fromRawNode(rawNode.getChildrenList("person.move_to"), this);
          this.fromPerson = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson.fromRawNode(rawNode.getChildrenList("from_person"), this);
          this.zone_create = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.fromRawNode(rawNode.getChildrenFirst("zone.create"), this);
          this.region_appendNew = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.fromRawNode(rawNode.getChildrenFirst("region.appendNew"), this);
          this.region_resolvePortals = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.fromRawNode(rawNode.getChildrenFirst("region.resolvePortals"), this);
        }

        if(isDirty) {
          notifyChange();
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("actions");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("by");
          rawNode.setChildren("by", by.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By::serializeIntoRawNode).toList());
          innerLogger.log("location_graph.create");
          rawNode.setChildren("location_graph.create", locationGraph_create.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create::serializeIntoRawNode).toList());
          innerLogger.log("location_graph.node.create_adjacent");
          rawNode.setChildren("location_graph.node.create_adjacent", locationGraph_node_createAdjacent.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent::serializeIntoRawNode).toList());
          innerLogger.log("location_graph.node.add_classification");
          rawNode.setChildren("location_graph.node.add_classification", locationGraph_node_addClassification.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification::serializeIntoRawNode).toList());
          innerLogger.log("person.teleport");
          rawNode.setChildren("person.teleport", person_teleport.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport::serializeIntoRawNode).toList());
          innerLogger.log("person.on_person.property_mutation");
          rawNode.setChildren("person.on_person.property_mutation", person_onPerson_propertyMutation.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation::serializeIntoRawNode).toList());
          innerLogger.log("person.create");
          rawNode.setChildren("person.create", person_create.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create::serializeIntoRawNode).toList());
          innerLogger.log("person.move_to");
          rawNode.setChildren("person.move_to", person_moveTo.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo::serializeIntoRawNode).toList());
          innerLogger.log("from_person");
          rawNode.setChildren("from_person", fromPerson.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson::serializeIntoRawNode).toList());
          innerLogger.log("zone.create");
          rawNode.setChildren("zone.create", zone_create.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create::serializeIntoRawNode).toList());
          innerLogger.log("region.appendNew");
          rawNode.setChildren("region.appendNew", region_appendNew.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew::serializeIntoRawNode).toList());
          innerLogger.log("region.resolvePortals");
          rawNode.setChildren("region.resolvePortals", region_resolvePortals.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing actions");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By> getBy()
    {
      return this.by;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By> streamBy()
    {
      return by.stream();
    }
    public Actions addBy(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By value)
    {
      this.by.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllBy(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By> value)
    {
      this.by.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removeBy(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By value)
    {
      this.by.remove(value);
      value.clearParentNode();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> getLocationGraph_create()
    {
      return this.locationGraph_create;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> streamLocationGraph_create()
    {
      return locationGraph_create.stream();
    }
    public Actions addLocationGraph_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create value)
    {
      this.locationGraph_create.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllLocationGraph_create(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> value)
    {
      this.locationGraph_create.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removeLocationGraph_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create value)
    {
      this.locationGraph_create.remove(value);
      value.clearParentNode();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> getLocationGraph_node_createAdjacent()
    {
      return this.locationGraph_node_createAdjacent;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> streamLocationGraph_node_createAdjacent()
    {
      return locationGraph_node_createAdjacent.stream();
    }
    public Actions addLocationGraph_node_createAdjacent(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent value)
    {
      this.locationGraph_node_createAdjacent.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllLocationGraph_node_createAdjacent(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> value)
    {
      this.locationGraph_node_createAdjacent.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removeLocationGraph_node_createAdjacent(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent value)
    {
      this.locationGraph_node_createAdjacent.remove(value);
      value.clearParentNode();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> getLocationGraph_node_addClassification()
    {
      return this.locationGraph_node_addClassification;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> streamLocationGraph_node_addClassification()
    {
      return locationGraph_node_addClassification.stream();
    }
    public Actions addLocationGraph_node_addClassification(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification value)
    {
      this.locationGraph_node_addClassification.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllLocationGraph_node_addClassification(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> value)
    {
      this.locationGraph_node_addClassification.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removeLocationGraph_node_addClassification(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification value)
    {
      this.locationGraph_node_addClassification.remove(value);
      value.clearParentNode();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport> getPerson_teleport()
    {
      return this.person_teleport;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport getPerson_teleportOrDefault()
    {
      return this.person_teleport.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport();
        this.person_teleport = Optional.of(instance);
        instance.parentNode(this);
        return this.person_teleport.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport> streamPerson_teleportOrDefault()
    {
      return java.util.stream.Stream.of(getPerson_teleportOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport> streamPerson_teleport()
    {
      return person_teleport.stream();
    }
    public Actions setPerson_teleport(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport value)
    {
      this.person_teleport = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation> getPerson_onPerson_propertyMutation()
    {
      return this.person_onPerson_propertyMutation;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation> streamPerson_onPerson_propertyMutation()
    {
      return person_onPerson_propertyMutation.stream();
    }
    public Actions addPerson_onPerson_propertyMutation(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation value)
    {
      this.person_onPerson_propertyMutation.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllPerson_onPerson_propertyMutation(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation> value)
    {
      this.person_onPerson_propertyMutation.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removePerson_onPerson_propertyMutation(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation value)
    {
      this.person_onPerson_propertyMutation.remove(value);
      value.clearParentNode();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create> getPerson_create()
    {
      return this.person_create;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create> streamPerson_create()
    {
      return person_create.stream();
    }
    public Actions addPerson_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create value)
    {
      this.person_create.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllPerson_create(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create> value)
    {
      this.person_create.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removePerson_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create value)
    {
      this.person_create.remove(value);
      value.clearParentNode();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo> getPerson_moveTo()
    {
      return this.person_moveTo;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo> streamPerson_moveTo()
    {
      return person_moveTo.stream();
    }
    public Actions addPerson_moveTo(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo value)
    {
      this.person_moveTo.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllPerson_moveTo(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo> value)
    {
      this.person_moveTo.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removePerson_moveTo(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo value)
    {
      this.person_moveTo.remove(value);
      value.clearParentNode();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson> getFromPerson()
    {
      return this.fromPerson;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson> streamFromPerson()
    {
      return fromPerson.stream();
    }
    public Actions addFromPerson(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson value)
    {
      this.fromPerson.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllFromPerson(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson> value)
    {
      this.fromPerson.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removeFromPerson(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson value)
    {
      this.fromPerson.remove(value);
      value.clearParentNode();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create> getZone_create()
    {
      return this.zone_create;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create getZone_createOrDefault()
    {
      return this.zone_create.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create();
        this.zone_create = Optional.of(instance);
        instance.parentNode(this);
        return this.zone_create.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create> streamZone_createOrDefault()
    {
      return java.util.stream.Stream.of(getZone_createOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create> streamZone_create()
    {
      return zone_create.stream();
    }
    public Actions setZone_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create value)
    {
      this.zone_create = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew> getRegion_appendNew()
    {
      return this.region_appendNew;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew getRegion_appendNewOrDefault()
    {
      return this.region_appendNew.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew();
        this.region_appendNew = Optional.of(instance);
        instance.parentNode(this);
        return this.region_appendNew.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew> streamRegion_appendNewOrDefault()
    {
      return java.util.stream.Stream.of(getRegion_appendNewOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew> streamRegion_appendNew()
    {
      return region_appendNew.stream();
    }
    public Actions setRegion_appendNew(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew value)
    {
      this.region_appendNew = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals> getRegion_resolvePortals()
    {
      return this.region_resolvePortals;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals getRegion_resolvePortalsOrDefault()
    {
      return this.region_resolvePortals.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals();
        this.region_resolvePortals = Optional.of(instance);
        instance.parentNode(this);
        return this.region_resolvePortals.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals> streamRegion_resolvePortalsOrDefault()
    {
      return java.util.stream.Stream.of(getRegion_resolvePortalsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals> streamRegion_resolvePortals()
    {
      return region_resolvePortals.stream();
    }
    public Actions setRegion_resolvePortals(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals value)
    {
      this.region_resolvePortals = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.by.size() > pathIndex) {
              return this.by.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addBy(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.locationGraph_create.size() > pathIndex) {
              return this.locationGraph_create.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addLocationGraph_create(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.locationGraph_node_createAdjacent.size() > pathIndex) {
              return this.locationGraph_node_createAdjacent.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addLocationGraph_node_createAdjacent(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.locationGraph_node_addClassification.size() > pathIndex) {
              return this.locationGraph_node_addClassification.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addLocationGraph_node_addClassification(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport.nodeName))
        {
          if(this.person_teleport.isEmpty()) {
            this.person_teleport = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport.nodeName.length() + 3);
          return this.person_teleport.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.person_onPerson_propertyMutation.size() > pathIndex) {
              return this.person_onPerson_propertyMutation.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addPerson_onPerson_propertyMutation(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.person_create.size() > pathIndex) {
              return this.person_create.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addPerson_create(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.person_moveTo.size() > pathIndex) {
              return this.person_moveTo.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addPerson_moveTo(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.fromPerson.size() > pathIndex) {
              return this.fromPerson.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addFromPerson(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.nodeName))
        {
          if(this.zone_create.isEmpty()) {
            this.zone_create = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.nodeName.length() + 3);
          return this.zone_create.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.nodeName))
        {
          if(this.region_appendNew.isEmpty()) {
            this.region_appendNew = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.nodeName.length() + 3);
          return this.region_appendNew.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.nodeName))
        {
          if(this.region_resolvePortals.isEmpty()) {
            this.region_resolvePortals = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.nodeName.length() + 3);
          return this.region_resolvePortals.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.by.size() > pathIndex) {
            return this.by.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.locationGraph_create.size() > pathIndex) {
            return this.locationGraph_create.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.locationGraph_node_createAdjacent.size() > pathIndex) {
            return this.locationGraph_node_createAdjacent.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.locationGraph_node_addClassification.size() > pathIndex) {
            return this.locationGraph_node_addClassification.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport.nodeName))
        {
          if(this.person_teleport.isEmpty()) {
            this.person_teleport = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport.nodeName.length() + 3);
          return this.person_teleport.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.person_onPerson_propertyMutation.size() > pathIndex) {
            return this.person_onPerson_propertyMutation.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.person_create.size() > pathIndex) {
            return this.person_create.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.person_moveTo.size() > pathIndex) {
            return this.person_moveTo.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.fromPerson.size() > pathIndex) {
            return this.fromPerson.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.nodeName))
        {
          if(this.zone_create.isEmpty()) {
            this.zone_create = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.nodeName.length() + 3);
          return this.zone_create.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.nodeName))
        {
          if(this.region_appendNew.isEmpty()) {
            this.region_appendNew = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.nodeName.length() + 3);
          return this.region_appendNew.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.nodeName))
        {
          if(this.region_resolvePortals.isEmpty()) {
            this.region_resolvePortals = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.nodeName.length() + 3);
          return this.region_resolvePortals.get().getNodeAtPath(childXPath);
        }
        return Optional.of(this);
    }
  }


  /*
    dependant type:
    {
      "type": "element",
      "value": {
        "metaType": "object",
        "isSingle": true,
        "value": {
          "by": {
            "metaType": "union",
            "value": [
              {
                "metaType": "object",
                "isSingle": true,
                "isNullable": false,
                "value": {
                  "do": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "action_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": true
                        },
                        "action_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": true
                        },
                        "person_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      }
                    }
                  }
                }
              },
              {
                "metaType": "object",
                "isSingle": true,
                "isNullable": true,
                "value": {
                  "move_towards": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "layer": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": true
                        },
                        "x": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        },
                        "y": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        }
                      }
                    }
                  }
                }
              }
            ],
            "isSingle": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "person_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isNullable": true
          },
          "location_graph.create": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "location_graph_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "location_graph.node.create_adjacent": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "location_graph_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "node_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "location_graph.node.add_classification": {
            "metaType": "object",
            "isSingle": false,
            "value": {
              "node_graph_selection": {
                "metaType": "reference",
                "value": "type__node_graph__selection",
                "isSingle": true,
                "isNullable": false
              },
              "to_be_added__classification": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "location_classification_rule_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": true,
                "value": {
                  "and": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "location_classification_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  }
                },
                "isNullable": false
              }
            },
            "isNullable": true
          },
          "person.teleport": {
            "metaType": "union",
            "value": [
              {
                "metaType": "object",
                "isSingle": true,
                "isNullable": true,
                "value": {
                  "location_graph": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "location_graph_id_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "node_id_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      }
                    }
                  }
                }
              },
              {
                "metaType": "object",
                "isSingle": true,
                "isNullable": true,
                "value": {
                  "link_to": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "accumulated_progress": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    },
                    "isSingle": true,
                    "value": {
                      "selection": {
                        "metaType": "reference",
                        "value": "type__link_to__selection",
                        "isSingle": true,
                        "isNullable": false
                      }
                    },
                    "isNullable": true
                  }
                }
              }
            ],
            "isSingle": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "person_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isNullable": true
          },
          "person.on_person.property_mutation": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "person_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "target_person_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "action_property_mutation_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "person.create": {
            "metaType": "object",
            "isSingle": false,
            "value": {
              "node_graph__selection": {
                "metaType": "reference",
                "value": "type__node_graph__selection",
                "isSingle": true,
                "isNullable": false
              },
              "person__selection": {
                "metaType": "reference",
                "value": "type__person_selection",
                "isSingle": true,
                "isNullable": false
              }
            },
            "isNullable": true
          },
          "person.move_to": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "person_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isSingle": false,
            "value": {
              "find_path_towards": {
                "metaType": "reference",
                "value": "type__node_graph__selection",
                "isSingle": true,
                "isNullable": true
              },
              "path": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "node": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": false,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "node_id_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "from_person": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "person_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "from_person_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            },
            "isSingle": false,
            "value": {
              "on_person": {
                "metaType": "object",
                "value": {},
                "isSingle": true,
                "isNullable": false,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "person_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              }
            },
            "isNullable": true
          },
          "zone.create": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "zone_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "region.appendNew": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "zone_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "region_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "portal_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "region.resolvePortals": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "zone_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "region_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          }
        },
        "isNullable": true
      },
      "name": "actions"
    }
  */