package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup;
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
  public class RuleGroup implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static RuleGroup fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new RuleGroup();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static RuleGroup fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<RuleGroup> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> RuleGroup.fromRawNode(o, parent)));
    }
    public static List<RuleGroup> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<RuleGroup> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> RuleGroup.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/world_step/rule_group";
    }

    //Attributes
    /* ignored attribute key={key} of type=Object*/

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule> propertyRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> classificationRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> nameRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule> actionRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule> eventsRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> linkGroupRuleList = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> locationGraphRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> locationClassificationRule = Optional.empty();

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
      return "rule_group";
    }

    public void childChanged(List<Object> list) {
      list.addLast(this);
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(list));
    }

    private void triggerOnChange() {
      childChanged(new ArrayList<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep> parentAsWorldStep() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule) {
          this.propertyRule = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule) {
          this.classificationRule = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule) {
          this.nameRule = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule) {
          this.actionRule = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule) {
          this.eventsRule = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList) {
          this.linkGroupRuleList = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule) {
          this.locationGraphRule = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule) {
          this.locationClassificationRule = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing rule_group");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.propertyRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule.fromRawNode(rawNode.getChildrenFirst("property_rule"), this);
      this.classificationRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule.fromRawNode(rawNode.getChildrenFirst("classification_rule"), this);
      this.nameRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule.fromRawNode(rawNode.getChildrenFirst("name_rule"), this);
      this.actionRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule.fromRawNode(rawNode.getChildrenFirst("action_rule"), this);
      this.eventsRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule.fromRawNode(rawNode.getChildrenFirst("events_rule"), this);
      this.linkGroupRuleList = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList.fromRawNode(rawNode.getChildrenFirst("link_group_rule_list"), this);
      this.locationGraphRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule.fromRawNode(rawNode.getChildrenFirst("location_graph_rule"), this);
      this.locationClassificationRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule.fromRawNode(rawNode.getChildrenFirst("location_classification_rule"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("rule_group");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("property_rule");
      rawNode.setChildren("property_rule", propertyRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule::serializeIntoRawNode).toList());
      innerLogger.log("classification_rule");
      rawNode.setChildren("classification_rule", classificationRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule::serializeIntoRawNode).toList());
      innerLogger.log("name_rule");
      rawNode.setChildren("name_rule", nameRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule::serializeIntoRawNode).toList());
      innerLogger.log("action_rule");
      rawNode.setChildren("action_rule", actionRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule::serializeIntoRawNode).toList());
      innerLogger.log("events_rule");
      rawNode.setChildren("events_rule", eventsRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule::serializeIntoRawNode).toList());
      innerLogger.log("link_group_rule_list");
      rawNode.setChildren("link_group_rule_list", linkGroupRuleList.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList::serializeIntoRawNode).toList());
      innerLogger.log("location_graph_rule");
      rawNode.setChildren("location_graph_rule", locationGraphRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule::serializeIntoRawNode).toList());
      innerLogger.log("location_classification_rule");
      rawNode.setChildren("location_classification_rule", locationClassificationRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing rule_group");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    /* ignored attribute key={key} of type=Object*/
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule> getPropertyRule()
    {
      return this.propertyRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule getPropertyRuleOrDefault()
    {
      return this.propertyRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule();
        this.propertyRule = Optional.of(instance);
        instance.parentNode(this);
        return this.propertyRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule> streamPropertyRuleOrDefault()
    {
      return java.util.stream.Stream.of(getPropertyRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule> streamPropertyRule()
    {
      return propertyRule.stream();
    }
    public RuleGroup setPropertyRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule value)
    {
      this.propertyRule = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> getClassificationRule()
    {
      return this.classificationRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule getClassificationRuleOrDefault()
    {
      return this.classificationRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule();
        this.classificationRule = Optional.of(instance);
        instance.parentNode(this);
        return this.classificationRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> streamClassificationRuleOrDefault()
    {
      return java.util.stream.Stream.of(getClassificationRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> streamClassificationRule()
    {
      return classificationRule.stream();
    }
    public RuleGroup setClassificationRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule value)
    {
      this.classificationRule = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> getNameRule()
    {
      return this.nameRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule getNameRuleOrDefault()
    {
      return this.nameRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule();
        this.nameRule = Optional.of(instance);
        instance.parentNode(this);
        return this.nameRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> streamNameRuleOrDefault()
    {
      return java.util.stream.Stream.of(getNameRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> streamNameRule()
    {
      return nameRule.stream();
    }
    public RuleGroup setNameRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule value)
    {
      this.nameRule = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule> getActionRule()
    {
      return this.actionRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule getActionRuleOrDefault()
    {
      return this.actionRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule();
        this.actionRule = Optional.of(instance);
        instance.parentNode(this);
        return this.actionRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule> streamActionRuleOrDefault()
    {
      return java.util.stream.Stream.of(getActionRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule> streamActionRule()
    {
      return actionRule.stream();
    }
    public RuleGroup setActionRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule value)
    {
      this.actionRule = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule> getEventsRule()
    {
      return this.eventsRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule getEventsRuleOrDefault()
    {
      return this.eventsRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule();
        this.eventsRule = Optional.of(instance);
        instance.parentNode(this);
        return this.eventsRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule> streamEventsRuleOrDefault()
    {
      return java.util.stream.Stream.of(getEventsRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule> streamEventsRule()
    {
      return eventsRule.stream();
    }
    public RuleGroup setEventsRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule value)
    {
      this.eventsRule = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> getLinkGroupRuleList()
    {
      return this.linkGroupRuleList;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList getLinkGroupRuleListOrDefault()
    {
      return this.linkGroupRuleList.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList();
        this.linkGroupRuleList = Optional.of(instance);
        instance.parentNode(this);
        return this.linkGroupRuleList.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> streamLinkGroupRuleListOrDefault()
    {
      return java.util.stream.Stream.of(getLinkGroupRuleListOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> streamLinkGroupRuleList()
    {
      return linkGroupRuleList.stream();
    }
    public RuleGroup setLinkGroupRuleList(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList value)
    {
      this.linkGroupRuleList = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> getLocationGraphRule()
    {
      return this.locationGraphRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule getLocationGraphRuleOrDefault()
    {
      return this.locationGraphRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule();
        this.locationGraphRule = Optional.of(instance);
        instance.parentNode(this);
        return this.locationGraphRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> streamLocationGraphRuleOrDefault()
    {
      return java.util.stream.Stream.of(getLocationGraphRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> streamLocationGraphRule()
    {
      return locationGraphRule.stream();
    }
    public RuleGroup setLocationGraphRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule value)
    {
      this.locationGraphRule = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> getLocationClassificationRule()
    {
      return this.locationClassificationRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule getLocationClassificationRuleOrDefault()
    {
      return this.locationClassificationRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule();
        this.locationClassificationRule = Optional.of(instance);
        instance.parentNode(this);
        return this.locationClassificationRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> streamLocationClassificationRuleOrDefault()
    {
      return java.util.stream.Stream.of(getLocationClassificationRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> streamLocationClassificationRule()
    {
      return locationClassificationRule.stream();
    }
    public RuleGroup setLocationClassificationRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule value)
    {
      this.locationClassificationRule = Optional.ofNullable(value);
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
            "id": {
              "metaType": "unknown",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "property_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "units": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  }
                },
                "isSingle": false,
                "value": {
                  "person_default": {
                    "metaType": "composition",
                    "value": [
                      {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": false
                      },
                      {
                        "metaType": "primitive",
                        "value": "type__math_operations"
                      }
                    ],
                    "isSingle": true,
                    "isNullable": true
                  },
                  "item_default": {
                    "metaType": "composition",
                    "value": [
                      {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": false
                      },
                      {
                        "metaType": "primitive",
                        "value": "type__math_operations"
                      }
                    ],
                    "isSingle": true,
                    "isNullable": true
                  },
                  "property-threshold": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": false,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "name": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "min-value-inclusive": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": true
                        },
                        "max-value-inclusive": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": true
                        }
                      }
                    }
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "classification_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "property": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "property_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "is": {
                          "metaType": "union",
                          "value": [
                            {
                              "metaType": "primitive",
                              "value": "\"lessThan\""
                            },
                            {
                              "metaType": "primitive",
                              "value": "\"lessThanOrEqual\""
                            },
                            {
                              "metaType": "primitive",
                              "value": "\"greaterThan\""
                            },
                            {
                              "metaType": "primitive",
                              "value": "\"greaterThanOrEqual\""
                            },
                            {
                              "metaType": "primitive",
                              "value": "\"equal\""
                            }
                          ]
                        }
                      }
                    },
                    "isSingle": false,
                    "value": {
                      "operation": {
                        "metaType": "reference",
                        "value": "type__math_operations",
                        "isSingle": true,
                        "isNullable": false
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "name_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
                "metaType": "composition",
                "value": [
                  {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "id": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  },
                  {
                    "metaType": "primitive",
                    "value": "type__name_token"
                  }
                ],
                "isSingle": false,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "action_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "from_person": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "selection": {
                    "metaType": "reference",
                    "value": "type__person_selection",
                    "isSingle": true,
                    "isNullable": true
                  },
                  "mutations": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "property_mutation": {
                        "metaType": "reference",
                        "value": "type__property_mutation",
                        "isSingle": false,
                        "isNullable": true
                      }
                    },
                    "isNullable": true
                  },
                  "on_person": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "selection": {
                        "metaType": "composition",
                        "value": [
                          {
                            "metaType": "object",
                            "isSingle": true,
                            "value": {
                              "from_person_same_location_graph_node": {
                                "metaType": "object",
                                "value": {},
                                "isSingle": true,
                                "isNullable": true,
                                "attributes": {
                                  "metaType": "object",
                                  "value": {
                                    "value": {
                                      "metaType": "primitive",
                                      "value": "xs:boolean",
                                      "isNullable": false
                                    }
                                  },
                                  "isNullable": false
                                }
                              }
                            }
                          },
                          {
                            "metaType": "primitive",
                            "value": "type__person_selection"
                          }
                        ],
                        "isSingle": true,
                        "isNullable": true
                      },
                      "mutations": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "property_mutation": {
                            "metaType": "reference",
                            "value": "type__property_mutation",
                            "isSingle": true,
                            "isNullable": true
                          }
                        },
                        "isNullable": true
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": true
              },
              "global": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "entry": {
                    "metaType": "composition",
                    "value": [
                      {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": false,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "id": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        }
                      },
                      {
                        "metaType": "primitive",
                        "value": "type__action"
                      }
                    ],
                    "isSingle": false,
                    "isNullable": true
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "events_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "when": {
                    "metaType": "reference",
                    "value": "type__trigger",
                    "isSingle": false,
                    "isNullable": false
                  },
                  "then": {
                    "metaType": "object",
                    "isSingle": false,
                    "value": {
                      "select_person": {
                        "metaType": "composition",
                        "value": [
                          {
                            "metaType": "object",
                            "value": {},
                            "isSingle": true,
                            "isNullable": false,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "origin": {
                                  "metaType": "union",
                                  "value": [
                                    {
                                      "metaType": "primitive",
                                      "value": "\"target\""
                                    },
                                    {
                                      "metaType": "primitive",
                                      "value": "\"self\""
                                    }
                                  ]
                                }
                              }
                            }
                          },
                          {
                            "metaType": "primitive",
                            "value": "type__person_selection"
                          }
                        ],
                        "isSingle": false,
                        "isNullable": true
                      },
                      "property_mutation": {
                        "metaType": "composition",
                        "value": [
                          {
                            "metaType": "object",
                            "value": {},
                            "isSingle": true,
                            "isNullable": false,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "property_rule_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                }
                              },
                              "isNullable": false
                            }
                          },
                          {
                            "metaType": "primitive",
                            "value": "type__math_operations"
                          }
                        ],
                        "isSingle": true,
                        "isNullable": true
                      }
                    },
                    "isNullable": false
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "link_group_rule_list": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "link_group_rule": {
                "metaType": "composition",
                "value": [
                  {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false
                  },
                  {
                    "metaType": "primitive",
                    "value": "type__link_group"
                  }
                ],
                "isSingle": false,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "location_graph_rule": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "id": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isSingle": true,
            "value": {
              "setup": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "starting_node": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "node_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  },
                  "necessary_node": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "node_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "min": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        },
                        "max": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": true
                        }
                      }
                    },
                    "isSingle": false,
                    "value": {
                      "or": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "node_rule_ref": {
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
                  }
                },
                "isNullable": false
              },
              "node_rule": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "name": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "name_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  },
                  "classifications": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "classification": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
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
                    "isNullable": true
                  },
                  "link_group_list": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "reference": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "link_group_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        }
                      },
                      "link_group": {
                        "metaType": "composition",
                        "value": [
                          {
                            "metaType": "object",
                            "value": {},
                            "isSingle": true,
                            "isNullable": false
                          },
                          {
                            "metaType": "primitive",
                            "value": "type__link_group"
                          }
                        ],
                        "isSingle": false,
                        "isNullable": true
                      }
                    },
                    "isNullable": true
                  },
                  "existing_person": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "min": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        },
                        "max": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": true
                        }
                      }
                    },
                    "isSingle": true,
                    "value": {
                      "person_selection": {
                        "metaType": "reference",
                        "value": "type__person_selection",
                        "isSingle": true,
                        "isNullable": false
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "location_classification_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": false,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
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
          }
        },
        "isNullable": true
      },
      "name": "rule_group"
    }
  */