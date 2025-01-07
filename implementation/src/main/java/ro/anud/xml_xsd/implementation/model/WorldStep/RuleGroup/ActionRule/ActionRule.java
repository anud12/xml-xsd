package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule;
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
  public class ActionRule implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static final String TYPE_ID = "/world_step/rule_group/action_rule";

    public static ActionRule fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new ActionRule();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static ActionRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<ActionRule> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> ActionRule.fromRawNode(o, parent)));
    }
    public static List<ActionRule> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<ActionRule> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> ActionRule.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson> fromPerson = new ArrayList<>();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global> global = Optional.empty();

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
      return "action_rule";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup> parentAsRuleGroup() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson) {
          this.fromPerson.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global) {
          this.global = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson) {
          return this.fromPerson.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global) {
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
      // Godot.GD.Print("Deserializing action_rule");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.fromPerson = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson.fromRawNode(rawNode.getChildrenList("from_person"), this);
      this.global = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global.fromRawNode(rawNode.getChildrenFirst("global"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("from_person");
      rawNode.setChildren("from_person", fromPerson.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson::serializeIntoRawNode).toList());
      innerLogger.log("global");
      rawNode.setChildren("global", global.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing action_rule");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson> getFromPerson()
    {
      return this.fromPerson;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson> streamFromPerson()
    {
      return fromPerson.stream();
    }
    public ActionRule addFromPerson(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson value)
    {
      this.fromPerson.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public ActionRule addAllFromPerson(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson> value)
    {
      this.fromPerson.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public ActionRule removeFromPerson(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson value)
    {
      this.fromPerson.remove(value);
      triggerOnChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global> getGlobal()
    {
      return this.global;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global getGlobalOrDefault()
    {
      return this.global.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global();
        instance.parentNode(this);
        this.global = Optional.of(instance);
        return this.global.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global> streamGlobalOrDefault()
    {
      return java.util.stream.Stream.of(getGlobalOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global> streamGlobal()
    {
      return global.stream();
    }
    public ActionRule setGlobal(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global value)
    {
      this.global = Optional.ofNullable(value);
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
      "name": "action_rule"
    }
  */