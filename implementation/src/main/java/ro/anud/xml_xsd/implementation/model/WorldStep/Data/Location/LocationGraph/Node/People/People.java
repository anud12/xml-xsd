package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People;
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
  public class People implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static People fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new People();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static People fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<People> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> People.fromRawNode(o, parent)));
    }
    public static List<People> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<People> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> People.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person> person = new ArrayList<>();

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
    private List<Consumer<People>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "people";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person) {
          this.person.remove(object);
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<People> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing people");
      //Deserialize arguments

      //Deserialize children
      this.person = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person.fromRawNode(rawNode.getChildrenList("person"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("person", person.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing people");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person> getPerson()
    {
      return this.person;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person> streamPerson()
    {
      return person.stream();
    }
    public People addPerson(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person value)
    {
      this.person.add(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public People addAllPerson(List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person> value)
    {
      this.person.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public People removePerson(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person value)
    {
      this.person.remove(value);
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
          "person": {
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
                }
              },
              "isNullable": false
            }
          }
        },
        "isNullable": true
      },
      "name": "people"
    }
  */