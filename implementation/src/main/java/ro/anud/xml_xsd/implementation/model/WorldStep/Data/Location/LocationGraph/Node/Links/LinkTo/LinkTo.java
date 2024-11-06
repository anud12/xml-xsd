package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo;
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
  public class LinkTo implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static LinkTo fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new LinkTo();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LinkTo fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<LinkTo> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> LinkTo.fromRawNode(o, parent)));
    }
    public static List<LinkTo> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<LinkTo> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> LinkTo.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String nodeIdRef;
    private Integer totalProgress;

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People> people = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> personProgressProperty = Optional.empty();

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
    private List<Consumer<LinkTo>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "link_to";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People) {
          this.people = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.personProgressProperty = Optional.empty();
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<LinkTo> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_to");
      //Deserialize arguments
      this.nodeIdRef = rawNode.getAttributeRequired("node_id_ref");
      this.totalProgress = rawNode.getAttributeIntRequired("total_progress");

      //Deserialize children
      this.people = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People.fromRawNode(rawNode.getChildrenFirst("people"), this);
      this.personProgressProperty = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("person_progress_property"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("node_id_ref", this.nodeIdRef);
      rawNode.setAttribute("total_progress", this.totalProgress);

      //Serialize children
      rawNode.setChildren("people", people.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People::serializeIntoRawNode).toList());
      rawNode.setChildren("person_progress_property", personProgressProperty.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing link_to");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getNodeIdRef()
    {
      return this.nodeIdRef;
    }
    public LinkTo setNodeIdRef(String value)
    {
      this.nodeIdRef = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Integer getTotalProgress()
    {
      return this.totalProgress;
    }
    public LinkTo setTotalProgress(Integer value)
    {
      this.totalProgress = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People> getPeople()
    {
      return this.people;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People getPeopleOrDefault()
    {
      return this.people.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People();
        instance.setParentNode(this);
        this.people = Optional.of(instance);
        return this.people.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People> streamPeople()
    {
      return people.stream();
    }
    public LinkTo setPeople(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People value)
    {
      this.people = Optional.ofNullable(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getPersonProgressProperty()
    {
      return this.personProgressProperty;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getPersonProgressPropertyOrDefault()
    {
      return this.personProgressProperty.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        instance.setParentNode(this);
        this.personProgressProperty = Optional.of(instance);
        return this.personProgressProperty.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamPersonProgressProperty()
    {
      return personProgressProperty.stream();
    }
    public LinkTo setPersonProgressProperty(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.personProgressProperty = Optional.ofNullable(value);
      value.setParentNode(this);
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
        "attributes": {
          "metaType": "object",
          "value": {
            "node_id_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "total_progress": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            }
          }
        },
        "isSingle": false,
        "value": {
          "people": {
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
                    },
                    "accumulated_progress": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": false
                    }
                  }
                }
              }
            },
            "isNullable": true
          },
          "person_progress_property": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "link_to"
    }
  */