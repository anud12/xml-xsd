package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule;
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
  public class LinkGroupRule implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static LinkGroupRule fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new LinkGroupRule();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LinkGroupRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<LinkGroupRule> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> LinkGroupRule.fromRawNode(o, parent)));
    }
    public static List<LinkGroupRule> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<LinkGroupRule> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> LinkGroupRule.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String id;
    private Integer angle;
    private Optional<Integer> angleMax;
    private Optional<Integer> limit;

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption.ToOption> toOption = new ArrayList<>();

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
    private List<Consumer<LinkGroupRule>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "link_group_rule";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption.ToOption) {
          this.toOption.remove(object);
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<LinkGroupRule> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_group_rule");
      //Deserialize arguments
      this.id = rawNode.getAttributeRequired("id");
      this.angle = rawNode.getAttributeIntRequired("angle");
      this.angleMax = rawNode.getAttributeInt("angleMax");
      this.limit = rawNode.getAttributeInt("limit");

      //Deserialize children
      this.toOption = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption.ToOption.fromRawNode(rawNode.getChildrenList("to_option"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("id", this.id);
      rawNode.setAttribute("angle", this.angle);
      this.angleMax.ifPresent(o -> rawNode.setAttribute("angleMax", o));
      this.limit.ifPresent(o -> rawNode.setAttribute("limit", o));

      //Serialize children
      rawNode.setChildren("to_option", toOption.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption.ToOption::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing link_group_rule");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public LinkGroupRule setId(String value)
    {
      this.id = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Integer getAngle()
    {
      return this.angle;
    }
    public LinkGroupRule setAngle(Integer value)
    {
      this.angle = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<Integer> getAngleMax()
    {
      return this.angleMax;
    }
    public LinkGroupRule setAngleMax(Optional<Integer> value)
    {
      this.angleMax = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<Integer> getLimit()
    {
      return this.limit;
    }
    public LinkGroupRule setLimit(Optional<Integer> value)
    {
      this.limit = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption.ToOption> getToOption()
    {
      return this.toOption;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption.ToOption> streamToOption()
    {
      return toOption.stream();
    }
    public LinkGroupRule addToOption(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption.ToOption value)
    {
      this.toOption.add(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public LinkGroupRule addAllToOption(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption.ToOption> value)
    {
      this.toOption.addAll(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public LinkGroupRule removeToOption(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.ToOption.ToOption value)
    {
      this.toOption.remove(value);
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
            "id": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "angle": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            },
            "angleMax": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": true
            },
            "limit": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": true
            }
          }
        },
        "isSingle": false,
        "value": {
          "to_option": {
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
          }
        },
        "isNullable": true
      },
      "name": "link_group_rule"
    }
  */