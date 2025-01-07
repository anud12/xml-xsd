package ro.anud.xml_xsd.implementation.model.On.Person;
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
  public class Person implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static final String TYPE_ID = "/on/person";

    public static Person fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Person();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Person fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Person> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Person.fromRawNode(o, parent)));
    }
    public static List<Person> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Person> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Person.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> select = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> propertyMutation = Optional.empty();

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
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "person";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.On.On> parentAsOn() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.On.On casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection) {
          this.select = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation) {
          this.propertyMutation = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation) {
          return 0;
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
      // Godot.GD.Print("Deserializing person");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("select");
      this.select = ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.fromRawNode(rawNode.getChildrenFirst("select"), this);
      innerLogger.log("property_mutation");
      this.propertyMutation = ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation.fromRawNode(rawNode.getChildrenFirst("property_mutation"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("select");
      rawNode.setChildren("select", select.stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection::serializeIntoRawNode).toList());
      innerLogger.log("property_mutation");
      rawNode.setChildren("property_mutation", propertyMutation.stream().map(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> getSelect()
    {
      return this.select;
    }
    public ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection getSelectOrDefault()
    {
      return this.select.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection();
        instance.parentNode(this);
        this.select = Optional.of(instance);
        return this.select.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> streamSelectOrDefault()
    {
      return java.util.stream.Stream.of(getSelectOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> streamSelect()
    {
      return select.stream();
    }
    public Person setSelect(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection value)
    {
      this.select = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> getPropertyMutation()
    {
      return this.propertyMutation;
    }
    public ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation getPropertyMutationOrDefault()
    {
      return this.propertyMutation.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation();
        instance.parentNode(this);
        this.propertyMutation = Optional.of(instance);
        return this.propertyMutation.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> streamPropertyMutationOrDefault()
    {
      return java.util.stream.Stream.of(getPropertyMutationOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> streamPropertyMutation()
    {
      return propertyMutation.stream();
    }
    public Person setPropertyMutation(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation value)
    {
      this.propertyMutation = Optional.ofNullable(value);
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
      },
      "name": "person"
    }
  */