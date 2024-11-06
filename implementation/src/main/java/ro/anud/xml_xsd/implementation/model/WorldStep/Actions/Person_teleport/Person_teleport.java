package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport;
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
  public class Person_teleport implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Person_teleport fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Person_teleport();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Person_teleport fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Person_teleport> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Person_teleport.fromRawNode(o, parent)));
    }
    public static List<Person_teleport> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Person_teleport> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Person_teleport.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String personIdRef;

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph> locationGraph = Optional.empty();
    private ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo linkTo = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo();

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
    private List<Consumer<Person_teleport>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "person.teleport";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph) {
          this.locationGraph = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo) {
          throw new RuntimeException("trying to delete linkTo which is required");
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Person_teleport> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person.teleport");
      //Deserialize arguments
      this.personIdRef = rawNode.getAttributeRequired("person_id_ref");

      //Deserialize children
      this.locationGraph = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph.fromRawNode(rawNode.getChildrenFirst("location_graph"), this);
      this.linkTo = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo.fromRawNode(rawNode.getChildrenFirst("link_to").get(), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("person_id_ref", this.personIdRef);

      //Serialize children
      rawNode.setChildren("location_graph", locationGraph.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph::serializeIntoRawNode).toList());
      rawNode.setChildren("link_to", Optional.ofNullable(linkTo).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person.teleport");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPersonIdRef()
    {
      return this.personIdRef;
    }
    public Person_teleport setPersonIdRef(String value)
    {
      this.personIdRef = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph> getLocationGraph()
    {
      return this.locationGraph;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph getLocationGraphOrDefault()
    {
      return this.locationGraph.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph();
        instance.setParentNode(this);
        this.locationGraph = Optional.of(instance);
        return this.locationGraph.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph> streamLocationGraph()
    {
      return locationGraph.stream();
    }
    public Person_teleport setLocationGraph(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph value)
    {
      this.locationGraph = Optional.ofNullable(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo getLinkTo()
    {
      return this.linkTo;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo> streamLinkTo()
    {
      return Optional.ofNullable(linkTo).stream();
    }
    public Person_teleport setLinkTo(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo value)
    {
      this.linkTo = value;
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
            "person_id_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
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
          },
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
            "isNullable": false
          }
        }
      },
      "name": "person.teleport"
    }
  */