package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class ToBeAdded_classification implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "to_be_added__classification";
    public static ToBeAdded_classification fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new ToBeAdded_classification();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static ToBeAdded_classification fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<ToBeAdded_classification> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> ToBeAdded_classification.fromRawNode(o, parent)));
        }

    }
    public static List<ToBeAdded_classification> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<ToBeAdded_classification> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> ToBeAdded_classification.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.actions.location_graph.node.add_classification.to_be_added__classification";
    }

    //Attributes

    private String locationClassificationRuleRef;

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And> and = Optional.empty();

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
      return "to_be_added__classification";
    }

    public void notifyChange(List<Object> list) {
      try (var logger = logScope()) {
        list.addLast(this);
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.accept(list));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> parentAsLocationGraph_node_addClassification() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And) {
          this.and = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      try (var logger = logScope()) {
        onChangeList.add(onChange);
        return logger.logReturn(() -> onChangeList.remove(onChange));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing to_be_added__classification");

        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("location_classification_rule_ref");
          this.locationClassificationRuleRef = rawNode.getAttributeRequired("location_classification_rule_ref");
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.and = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And.fromRawNode(rawNode.getChildrenFirst("and"), this);
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("to_be_added__classification");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("location_classification_rule_ref");
          rawNode.setAttribute("location_classification_rule_ref", this.locationClassificationRuleRef);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("and");
          rawNode.setChildren("and", and.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing to_be_added__classification");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getLocationClassificationRuleRef()
    {
      return this.locationClassificationRuleRef;
    }
    public ToBeAdded_classification setLocationClassificationRuleRef(String value)
    {
      this.locationClassificationRuleRef = value;
      notifyChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And> getAnd()
    {
      return this.and;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And getAndOrDefault()
    {
      return this.and.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And();
        this.and = Optional.of(instance);
        instance.parentNode(this);
        return this.and.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And> streamAndOrDefault()
    {
      return java.util.stream.Stream.of(getAndOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And> streamAnd()
    {
      return and.stream();
    }
    public ToBeAdded_classification setAnd(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And value)
    {
      this.and = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And.nodeName))
        {
          if(this.and.isEmpty()) {
            this.and = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And.nodeName.length() + 3);
          return this.and.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And.nodeName))
        {
          if(this.and.isEmpty()) {
            this.and = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.ToBeAdded_classification.And.And.nodeName.length() + 3);
          return this.and.get().getNodeAtPath(childXPath);
        }
        return Optional.of(this);
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
      },
      "name": "to_be_added__classification"
    }
  */