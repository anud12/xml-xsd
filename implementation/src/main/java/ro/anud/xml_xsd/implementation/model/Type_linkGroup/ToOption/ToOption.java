package ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption;
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
  public class ToOption implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "to_option";
    public static ToOption fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new ToOption();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static ToOption fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<ToOption> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> ToOption.fromRawNode(o, parent)));
        }

    }
    public static List<ToOption> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<ToOption> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> ToOption.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".type__link_group.to_option";
    }

    //Attributes

    private String nodeRuleRef;

    private Integer distance;
    @Builder.Default
    private Optional<Integer> maxDistance = Optional.empty();

    private Integer adjacentDepthLimit;

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> distanceToProgressMultiplier = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> personProgressProperty = Optional.empty();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<ToOption>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<ToOption>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "to_option";
    }
    public static ToOption of() {
      return new ToOption();
    }

    public void notifyChange(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.onChange(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(object));
      }
    }

    public void notifyRemove(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify remove for", this.buildPath());
        onRemoveList.forEach(consumer -> consumer.onRemove(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyRemove(object));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode.ifPresent(parent -> notifyRemove());
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_linkGroup.Type_linkGroup> parentAsType_linkGroup() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.Type_linkGroup.Type_linkGroup casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.distanceToProgressMultiplier = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.personProgressProperty = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<ToOption> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<ToOption> callback) {
      try (var logger = logScope()) {
        onRemoveList.add(callback);
        return logger.logReturn(() -> onRemoveList.remove(callback));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("node_rule_ref");
          var nodeRuleRefValue = rawNode.getAttributeRequired("node_rule_ref");
          if(Objects.equals(this.nodeRuleRef, nodeRuleRefValue)) {
            isDirty = true;
          }
          this.nodeRuleRef = nodeRuleRefValue;
          innerLogger.log("distance");
          var distanceValue = rawNode.getAttributeIntRequired("distance");
          if(Objects.equals(this.distance, distanceValue)) {
            isDirty = true;
          }
          this.distance = distanceValue;
          innerLogger.log("maxDistance");
          var maxDistanceValue = rawNode.getAttributeInt("maxDistance");
          if(Objects.equals(this.maxDistance, maxDistanceValue)) {
            isDirty = true;
          }
          this.maxDistance = maxDistanceValue;
          innerLogger.log("adjacent_depth_limit");
          var adjacentDepthLimitValue = rawNode.getAttributeIntRequired("adjacent_depth_limit");
          if(Objects.equals(this.adjacentDepthLimit, adjacentDepthLimitValue)) {
            isDirty = true;
          }
          this.adjacentDepthLimit = adjacentDepthLimitValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          innerLogger.log("distance_to_progress_multiplier");
          this.distanceToProgressMultiplier = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("distance_to_progress_multiplier"), this);
          innerLogger.log("person_progress_property");
          this.personProgressProperty = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("person_progress_property"), this);
        }

        if(isDirty) {
          notifyChange();
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("to_option");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("node_rule_ref");
          rawNode.setAttribute("node_rule_ref", this.nodeRuleRef);
          innerLogger.log("distance");
          rawNode.setAttribute("distance", this.distance);
          innerLogger.log("maxDistance");
          this.maxDistance.ifPresent(o -> rawNode.setAttribute("maxDistance", o));
          innerLogger.log("adjacent_depth_limit");
          rawNode.setAttribute("adjacent_depth_limit", this.adjacentDepthLimit);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("distance_to_progress_multiplier");
          rawNode.setChildren("distance_to_progress_multiplier", distanceToProgressMultiplier.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
          innerLogger.log("person_progress_property");
          rawNode.setChildren("person_progress_property", personProgressProperty.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing to_option");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getNodeRuleRef()
    {
      return this.nodeRuleRef;
    }
    public ToOption setNodeRuleRef(String value)
    {
      this.nodeRuleRef = value;
      notifyChange();
      return this;
    }
    public Integer getDistance()
    {
      return this.distance;
    }
    public ToOption setDistance(Integer value)
    {
      this.distance = value;
      notifyChange();
      return this;
    }
    public Optional<Integer> getMaxDistance()
    {
      return this.maxDistance;
    }
    public ToOption setMaxDistance(Optional<Integer> value)
    {
      this.maxDistance = value;
      notifyChange();
      return this;
    }
    public Integer getAdjacentDepthLimit()
    {
      return this.adjacentDepthLimit;
    }
    public ToOption setAdjacentDepthLimit(Integer value)
    {
      this.adjacentDepthLimit = value;
      notifyChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getDistanceToProgressMultiplier()
    {
      return this.distanceToProgressMultiplier;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getDistanceToProgressMultiplierOrDefault()
    {
      return this.distanceToProgressMultiplier.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        this.distanceToProgressMultiplier = Optional.of(instance);
        instance.parentNode(this);
        return this.distanceToProgressMultiplier.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamDistanceToProgressMultiplierOrDefault()
    {
      return java.util.stream.Stream.of(getDistanceToProgressMultiplierOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamDistanceToProgressMultiplier()
    {
      return distanceToProgressMultiplier.stream();
    }
    public ToOption setDistanceToProgressMultiplier(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.distanceToProgressMultiplier = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
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
        this.personProgressProperty = Optional.of(instance);
        instance.parentNode(this);
        return this.personProgressProperty.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamPersonProgressPropertyOrDefault()
    {
      return java.util.stream.Stream.of(getPersonProgressPropertyOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamPersonProgressProperty()
    {
      return personProgressProperty.stream();
    }
    public ToOption setPersonProgressProperty(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.personProgressProperty = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.distanceToProgressMultiplier.isEmpty()) {
            this.distanceToProgressMultiplier = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.distanceToProgressMultiplier.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.personProgressProperty.isEmpty()) {
            this.personProgressProperty = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.personProgressProperty.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.distanceToProgressMultiplier.isEmpty()) {
            this.distanceToProgressMultiplier = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.distanceToProgressMultiplier.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.personProgressProperty.isEmpty()) {
            this.personProgressProperty = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.personProgressProperty.get().getNodeAtPath(childXPath);
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
            "node_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "distance": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            },
            "maxDistance": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": true
            },
            "adjacent_depth_limit": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            }
          }
        },
        "isSingle": false,
        "value": {
          "distance_to_progress_multiplier": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
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
      "name": "to_option"
    }
  */