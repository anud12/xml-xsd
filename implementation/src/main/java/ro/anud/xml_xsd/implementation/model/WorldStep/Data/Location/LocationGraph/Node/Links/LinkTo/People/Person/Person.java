package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.Person;
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
    private String personIdRef;
    private Integer accumulatedProgress;

    //Children elements

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
      this.personIdRef = rawNode.getAttributeRequired("person_id_ref");
      this.accumulatedProgress = rawNode.getAttributeIntRequired("accumulated_progress");

      //Deserialize children
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("person_id_ref", this.personIdRef);
      rawNode.setAttribute("accumulated_progress", this.accumulatedProgress);

      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPersonIdRef()
    {
      return this.personIdRef;
    }
    public Person setPersonIdRef(String value)
    {
      this.personIdRef = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Integer getAccumulatedProgress()
    {
      return this.accumulatedProgress;
    }
    public Person setAccumulatedProgress(Integer value)
    {
      this.accumulatedProgress = value;
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
            "accumulated_progress": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            }
          }
        }
      },
      "name": "person"
    }
  */