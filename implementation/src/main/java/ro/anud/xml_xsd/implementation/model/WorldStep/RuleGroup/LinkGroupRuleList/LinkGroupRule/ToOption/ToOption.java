package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption;
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
  public class ToOption implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static ToOption fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new ToOption();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static ToOption fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<ToOption> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> ToOption.fromRawNode(o, parent)));
    }
    public static List<ToOption> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<ToOption> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> ToOption.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String nodeRuleRef;
    private Integer distance;
    private Optional<Integer> maxDistance;
    private Integer adjacentDepthLimit;

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> distanceToProgressMultiplier = Optional.empty();
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
    private List<Consumer<ToOption>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "to_option";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.distanceToProgressMultiplier = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.personProgressProperty = Optional.empty();
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<ToOption> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing to_option");
      //Deserialize arguments
      this.nodeRuleRef = rawNode.getAttributeRequired("node_rule_ref");
      this.distance = rawNode.getAttributeIntRequired("distance");
      this.maxDistance = rawNode.getAttributeInt("maxDistance");
      this.adjacentDepthLimit = rawNode.getAttributeIntRequired("adjacent_depth_limit");

      //Deserialize children
      this.distanceToProgressMultiplier = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("distance_to_progress_multiplier"), this);
      this.personProgressProperty = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("person_progress_property"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("node_rule_ref", this.nodeRuleRef);
      rawNode.setAttribute("distance", this.distance);
      this.maxDistance.ifPresent(o -> rawNode.setAttribute("maxDistance", o));
      rawNode.setAttribute("adjacent_depth_limit", this.adjacentDepthLimit);

      //Serialize children
      rawNode.setChildren("distance_to_progress_multiplier", distanceToProgressMultiplier.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      rawNode.setChildren("person_progress_property", personProgressProperty.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      return rawNode;
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
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Integer getDistance()
    {
      return this.distance;
    }
    public ToOption setDistance(Integer value)
    {
      this.distance = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<Integer> getMaxDistance()
    {
      return this.maxDistance;
    }
    public ToOption setMaxDistance(Optional<Integer> value)
    {
      this.maxDistance = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Integer getAdjacentDepthLimit()
    {
      return this.adjacentDepthLimit;
    }
    public ToOption setAdjacentDepthLimit(Integer value)
    {
      this.adjacentDepthLimit = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
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
        instance.setParentNode(this);
        this.distanceToProgressMultiplier = Optional.of(instance);
        return this.distanceToProgressMultiplier.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamDistanceToProgressMultiplier()
    {
      return distanceToProgressMultiplier.stream();
    }
    public ToOption setDistanceToProgressMultiplier(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.distanceToProgressMultiplier = Optional.ofNullable(value);
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
    public ToOption setPersonProgressProperty(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
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