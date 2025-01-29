package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification;
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
  public class LocationGraph_node_addClassification implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static LocationGraph_node_addClassification fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new LocationGraph_node_addClassification();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LocationGraph_node_addClassification fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<LocationGraph_node_addClassification> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> LocationGraph_node_addClassification.fromRawNode(o, parent)));
    }
    public static List<LocationGraph_node_addClassification> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<LocationGraph_node_addClassification> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> LocationGraph_node_addClassification.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/world_step/actions/location_graph.node.add_classification";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection nodeGraphSelection = new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.ToBeAdded_classification toBeAdded_classification = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.ToBeAdded_classification();

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
      return "location_graph.node.add_classification";
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
          throw new RuntimeException("trying to delete nodeGraphSelection which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.ToBeAdded_classification) {
          throw new RuntimeException("trying to delete toBeAdded_classification which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.ToBeAdded_classification) {
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
      // Godot.GD.Print("Deserializing location_graph.node.add_classification");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("node_graph_selection");
      this.nodeGraphSelection = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.fromRawNode(rawNode.getChildrenFirst("node_graph_selection").get(), this);
      this.toBeAdded_classification = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.ToBeAdded_classification.fromRawNode(rawNode.getChildrenFirst("to_be_added__classification").get(), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("location_graph.node.add_classification");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("node_graph_selection");
      rawNode.setChildren("node_graph_selection", Optional.ofNullable(nodeGraphSelection).stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection::serializeIntoRawNode).toList());
      innerLogger.log("to_be_added__classification");
      rawNode.setChildren("to_be_added__classification", Optional.ofNullable(toBeAdded_classification).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.ToBeAdded_classification::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing location_graph.node.add_classification");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection getNodeGraphSelection()
    {
      return this.nodeGraphSelection;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamNodeGraphSelection()
    {
      return Optional.ofNullable(nodeGraphSelection).stream();
    }
    public LocationGraph_node_addClassification setNodeGraphSelection(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection value)
    {
      this.nodeGraphSelection = value;
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.ToBeAdded_classification getToBeAdded_classification()
    {
      return this.toBeAdded_classification;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.ToBeAdded_classification> streamToBeAdded_classification()
    {
      return Optional.ofNullable(toBeAdded_classification).stream();
    }
    public LocationGraph_node_addClassification setToBeAdded_classification(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.ToBeAdded_classification value)
    {
      this.toBeAdded_classification = value;
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
      "name": "location_graph.node.add_classification"
    }
  */