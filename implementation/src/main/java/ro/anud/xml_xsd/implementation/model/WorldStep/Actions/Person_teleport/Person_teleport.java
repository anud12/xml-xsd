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
import static ro.anud.xml_xsd.implementation.util.LocalLogger.log;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Person_teleport implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Person_teleport fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Person_teleport();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Person_teleport fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
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
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph> locationGraph = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo> linkTo = Optional.empty();

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
      return "person.teleport";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> parentAsActions() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph) {
          this.locationGraph = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo) {
          this.linkTo = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo) {
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
      // Godot.GD.Print("Deserializing person.teleport");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("person_id_ref");
      this.personIdRef = rawNode.getAttributeRequired("person_id_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      this.locationGraph = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph.fromRawNode(rawNode.getChildrenFirst("location_graph"), this);
      this.linkTo = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo.fromRawNode(rawNode.getChildrenFirst("link_to"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("person_id_ref");
      rawNode.setAttribute("person_id_ref", this.personIdRef);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("location_graph");
      rawNode.setChildren("location_graph", locationGraph.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph::serializeIntoRawNode).toList());
      innerLogger.log("link_to");
      rawNode.setChildren("link_to", linkTo.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo::serializeIntoRawNode).toList());
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
      triggerOnChange();
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
        instance.parentNode(this);
        this.locationGraph = Optional.of(instance);
        return this.locationGraph.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph> streamLocationGraphOrDefault()
    {
      return Stream.of(getLocationGraphOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph> streamLocationGraph()
    {
      return locationGraph.stream();
    }
    public Person_teleport setLocationGraph(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph.LocationGraph value)
    {
      this.locationGraph = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo> getLinkTo()
    {
      return this.linkTo;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo getLinkToOrDefault()
    {
      return this.linkTo.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo();
        instance.parentNode(this);
        this.linkTo = Optional.of(instance);
        return this.linkTo.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo> streamLinkToOrDefault()
    {
      return Stream.of(getLinkToOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo> streamLinkTo()
    {
      return linkTo.stream();
    }
    public Person_teleport setLinkTo(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo value)
    {
      this.linkTo = Optional.ofNullable(value);
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
            "isNullable": true
          }
        }
      },
      "name": "person.teleport"
    }
  */