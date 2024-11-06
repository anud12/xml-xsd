package ro.anud.xml_xsd.implementation.model.Type_action.On.Person;
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

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Person implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Person fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Person();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Person fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
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
    private Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> select = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> propertyMutation = Optional.empty();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<Person>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "person";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection) {
          this.select = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation) {
          this.propertyMutation = Optional.empty();
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Person> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person");
      //Deserialize arguments

      //Deserialize children
      this.select = ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.fromRawNode(rawNode.getChildrenFirst("select"), this);
      this.propertyMutation = ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation.fromRawNode(rawNode.getChildrenFirst("property_mutation"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("select", select.stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection::serializeIntoRawNode).toList());
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
    public Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> streamSelect()
    {
      return select.stream();
    }
    public Person setSelect(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection value)
    {
      this.select = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> getPropertyMutation()
    {
      return this.propertyMutation;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> streamPropertyMutation()
    {
      return propertyMutation.stream();
    }
    public Person setPropertyMutation(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation value)
    {
      this.propertyMutation = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
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