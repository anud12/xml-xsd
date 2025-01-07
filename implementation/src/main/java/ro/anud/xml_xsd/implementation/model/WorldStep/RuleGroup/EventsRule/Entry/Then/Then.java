package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then;
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
  public class Then implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static final String TYPE_ID = "/world_step/rule_group/events_rule/entry/then";

    public static Then fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Then();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Then fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Then> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Then.fromRawNode(o, parent)));
    }
    public static List<Then> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Then> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Then.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson> selectPerson = new ArrayList<>();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation> propertyMutation = Optional.empty();

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
      return "then";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Entry> parentAsEntry() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Entry casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson) {
          this.selectPerson.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation) {
          this.propertyMutation = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson) {
          return this.selectPerson.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation) {
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
      // Godot.GD.Print("Deserializing then");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.selectPerson = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson.fromRawNode(rawNode.getChildrenList("select_person"), this);
      this.propertyMutation = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation.fromRawNode(rawNode.getChildrenFirst("property_mutation"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("select_person");
      rawNode.setChildren("select_person", selectPerson.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson::serializeIntoRawNode).toList());
      innerLogger.log("property_mutation");
      rawNode.setChildren("property_mutation", propertyMutation.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing then");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson> getSelectPerson()
    {
      return this.selectPerson;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson> streamSelectPerson()
    {
      return selectPerson.stream();
    }
    public Then addSelectPerson(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson value)
    {
      this.selectPerson.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Then addAllSelectPerson(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson> value)
    {
      this.selectPerson.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Then removeSelectPerson(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson.SelectPerson value)
    {
      this.selectPerson.remove(value);
      triggerOnChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation> getPropertyMutation()
    {
      return this.propertyMutation;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation getPropertyMutationOrDefault()
    {
      return this.propertyMutation.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation();
        instance.parentNode(this);
        this.propertyMutation = Optional.of(instance);
        return this.propertyMutation.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation> streamPropertyMutationOrDefault()
    {
      return java.util.stream.Stream.of(getPropertyMutationOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation> streamPropertyMutation()
    {
      return propertyMutation.stream();
    }
    public Then setPropertyMutation(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.PropertyMutation.PropertyMutation value)
    {
      this.propertyMutation = Optional.ofNullable(value);
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
      },
      "name": "then"
    }
  */