package ro.anud.xml_xsd.implementation.model.On;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class On implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static On fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new On();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static On fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<On> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> On.fromRawNode(o, parent)));
    }
    public static List<On> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<On> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> On.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/on";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.On.Person.Person> person = Optional.empty();

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
      return "on";
    }

    public void childChanged(List<Object> list) {
      list.addLast(this);
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(list));
    }

    private void triggerOnChange() {
      childChanged(new ArrayList<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.On.Person.Person) {
          this.person = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.On.Person.Person) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing on");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.person = ro.anud.xml_xsd.implementation.model.On.Person.Person.fromRawNode(rawNode.getChildrenFirst("person"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("on");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("person");
      rawNode.setChildren("person", person.stream().map(ro.anud.xml_xsd.implementation.model.On.Person.Person::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing on");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.On.Person.Person> getPerson()
    {
      return this.person;
    }
    public ro.anud.xml_xsd.implementation.model.On.Person.Person getPersonOrDefault()
    {
      return this.person.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.On.Person.Person();
        this.person = Optional.of(instance);
        instance.parentNode(this);
        return this.person.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.On.Person.Person> streamPersonOrDefault()
    {
      return java.util.stream.Stream.of(getPersonOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.On.Person.Person> streamPerson()
    {
      return person.stream();
    }
    public On setPerson(ro.anud.xml_xsd.implementation.model.On.Person.Person value)
    {
      this.person = Optional.ofNullable(value);
      value.parentNode(this);
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
          "person": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "select": {
                "metaType": "reference",
                "value": "type__person_selection",
                "isSingle": true,
                "isNullable": true
              },
              "property_mutation": {
                "metaType": "reference",
                "value": "type__property_mutation",
                "isSingle": true,
                "isNullable": true
              }
            },
            "isNullable": true
          }
        },
        "isNullable": false
      },
      "name": "on"
    }
  */