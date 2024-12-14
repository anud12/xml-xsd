package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry;
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
  public class Entry implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Entry fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Entry();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Entry fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Entry> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Entry.fromRawNode(o, parent)));
    }
    public static List<Entry> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Entry> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Entry.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String id;

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger> when = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then> then = new ArrayList<>();

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
      return "entry";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule> parentAsEventsRule() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger) {
          throw new RuntimeException("trying to delete when which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then) {
          throw new RuntimeException("trying to delete then which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger) {
          return this.when.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then) {
          return this.then.indexOf(object);
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
      // Godot.GD.Print("Deserializing entry");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("id");
      this.id = rawNode.getAttributeRequired("id");
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("when");
      this.when = ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger.fromRawNode(rawNode.getChildrenList("when"), this);
      this.then = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then.fromRawNode(rawNode.getChildrenList("then"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("when");
      rawNode.setChildren("when", when.stream().map(ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger::serializeIntoRawNode).toList());
      innerLogger.log("then");
      rawNode.setChildren("then", then.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public Entry setId(String value)
    {
      this.id = value;
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger> getWhen()
    {
      return this.when;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger> streamWhen()
    {
      return when.stream();
    }
    public Entry addWhen(ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger value)
    {
      this.when.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Entry addAllWhen(List<ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger> value)
    {
      this.when.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Entry removeWhen(ro.anud.xml_xsd.implementation.model.Type_trigger.Type_trigger value)
    {
      this.when.remove(value);
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then> getThen()
    {
      return this.then;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then> streamThen()
    {
      return then.stream();
    }
    public Entry addThen(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then value)
    {
      this.then.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Entry addAllThen(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then> value)
    {
      this.then.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Entry removeThen(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then value)
    {
      this.then.remove(value);
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
      },
      "name": "entry"
    }
  */