package ro.anud.xml_xsd.implementation.model.WorldStep.Actions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import java.util.stream.Stream;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.log;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Actions implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Actions fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Actions();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Actions fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Actions> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Actions.fromRawNode(o, parent)));
    }
    public static List<Actions> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Actions> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Actions.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By> by = new ArrayList<>();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> locationGraph_create = new ArrayList<>();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> locationGraph_node_createAdjacent = new ArrayList<>();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> locationGraph_node_addClassification = new ArrayList<>();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport> person_teleport = Optional.empty();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation> person_onPerson_propertyMutation = new ArrayList<>();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create> person_create = new ArrayList<>();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo> person_moveTo = new ArrayList<>();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson> fromPerson = new ArrayList<>();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    @Builder.Default
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    @Builder.Default
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "actions";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By) {
          this.by.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create) {
          this.locationGraph_create.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent) {
          this.locationGraph_node_createAdjacent.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification) {
          this.locationGraph_node_addClassification.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport) {
          this.person_teleport = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation) {
          this.person_onPerson_propertyMutation.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create) {
          this.person_create.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo) {
          this.person_moveTo.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson) {
          this.fromPerson.remove(object);
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
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Set<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing actions");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
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
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
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
      return rawNode;
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
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By> streamBy()
    {
      return by.stream();
    }
    public Actions addBy(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By value)
    {
      this.by.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Actions addAllBy(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By> value)
    {
      this.by.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Actions removeBy(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By value)
    {
      this.by.remove(value);
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> getLocationGraph_create()
    {
      return this.locationGraph_create;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> streamLocationGraph_create()
    {
      return locationGraph_create.stream();
    }
    public Actions addLocationGraph_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create value)
    {
      this.locationGraph_create.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Actions addAllLocationGraph_create(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> value)
    {
      this.locationGraph_create.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Actions removeLocationGraph_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create value)
    {
      this.locationGraph_create.remove(value);
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> getLocationGraph_node_createAdjacent()
    {
      return this.locationGraph_node_createAdjacent;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> streamLocationGraph_node_createAdjacent()
    {
      return locationGraph_node_createAdjacent.stream();
    }
    public Actions addLocationGraph_node_createAdjacent(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent value)
    {
      this.locationGraph_node_createAdjacent.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Actions addAllLocationGraph_node_createAdjacent(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> value)
    {
      this.locationGraph_node_createAdjacent.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Actions removeLocationGraph_node_createAdjacent(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent value)
    {
      this.locationGraph_node_createAdjacent.remove(value);
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> getLocationGraph_node_addClassification()
    {
      return this.locationGraph_node_addClassification;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> streamLocationGraph_node_addClassification()
    {
      return locationGraph_node_addClassification.stream();
    }
    public Actions addLocationGraph_node_addClassification(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification value)
    {
      this.locationGraph_node_addClassification.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Actions addAllLocationGraph_node_addClassification(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> value)
    {
      this.locationGraph_node_addClassification.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Actions removeLocationGraph_node_addClassification(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification value)
    {
      this.locationGraph_node_addClassification.remove(value);
      triggerOnChange();
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
        instance.setParentNode(this);
        this.person_teleport = Optional.of(instance);
        return this.person_teleport.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport> streamPerson_teleportOrDefault()
    {
      return Stream.of(getPerson_teleportOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport> streamPerson_teleport()
    {
      return person_teleport.stream();
    }
    public Actions setPerson_teleport(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport value)
    {
      this.person_teleport = Optional.ofNullable(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation> getPerson_onPerson_propertyMutation()
    {
      return this.person_onPerson_propertyMutation;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation> streamPerson_onPerson_propertyMutation()
    {
      return person_onPerson_propertyMutation.stream();
    }
    public Actions addPerson_onPerson_propertyMutation(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation value)
    {
      this.person_onPerson_propertyMutation.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Actions addAllPerson_onPerson_propertyMutation(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation> value)
    {
      this.person_onPerson_propertyMutation.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Actions removePerson_onPerson_propertyMutation(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation.Person_onPerson_propertyMutation value)
    {
      this.person_onPerson_propertyMutation.remove(value);
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create> getPerson_create()
    {
      return this.person_create;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create> streamPerson_create()
    {
      return person_create.stream();
    }
    public Actions addPerson_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create value)
    {
      this.person_create.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Actions addAllPerson_create(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create> value)
    {
      this.person_create.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Actions removePerson_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create value)
    {
      this.person_create.remove(value);
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo> getPerson_moveTo()
    {
      return this.person_moveTo;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo> streamPerson_moveTo()
    {
      return person_moveTo.stream();
    }
    public Actions addPerson_moveTo(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo value)
    {
      this.person_moveTo.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Actions addAllPerson_moveTo(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo> value)
    {
      this.person_moveTo.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Actions removePerson_moveTo(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo value)
    {
      this.person_moveTo.remove(value);
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson> getFromPerson()
    {
      return this.fromPerson;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson> streamFromPerson()
    {
      return fromPerson.stream();
    }
    public Actions addFromPerson(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson value)
    {
      this.fromPerson.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Actions addAllFromPerson(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson> value)
    {
      this.fromPerson.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Actions removeFromPerson(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson value)
    {
      this.fromPerson.remove(value);
      triggerOnChange();
      return this;
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
          }
        },
        "isNullable": true
      },
      "name": "actions"
    }
  */