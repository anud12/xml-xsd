package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation;
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
  public class Person_onPerson_propertyMutation implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Person_onPerson_propertyMutation fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Person_onPerson_propertyMutation();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Person_onPerson_propertyMutation fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Person_onPerson_propertyMutation> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Person_onPerson_propertyMutation.fromRawNode(o, parent)));
    }
    public static List<Person_onPerson_propertyMutation> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Person_onPerson_propertyMutation> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Person_onPerson_propertyMutation.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String personIdRef;
    private String targetPersonIdRef;
    private String actionPropertyMutationRuleRef;

    //Children elements

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    @Builder.Default
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    @Builder.Default
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "person.on_person.property_mutation";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public void removeChild(Object object) {
    }

    public int buildIndexForChild(Object object) {
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
      // Godot.GD.Print("Deserializing person.on_person.property_mutation");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("person_id_ref");
      this.personIdRef = rawNode.getAttributeRequired("person_id_ref");
      innerLogger.log("target_person_id_ref");
      this.targetPersonIdRef = rawNode.getAttributeRequired("target_person_id_ref");
      innerLogger.log("action_property_mutation_rule_ref");
      this.actionPropertyMutationRuleRef = rawNode.getAttributeRequired("action_property_mutation_rule_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("person_id_ref");
      rawNode.setAttribute("person_id_ref", this.personIdRef);
      innerLogger.log("target_person_id_ref");
      rawNode.setAttribute("target_person_id_ref", this.targetPersonIdRef);
      innerLogger.log("action_property_mutation_rule_ref");
      rawNode.setAttribute("action_property_mutation_rule_ref", this.actionPropertyMutationRuleRef);

      innerLogger = logger.log("children");
      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person.on_person.property_mutation");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPersonIdRef()
    {
      return this.personIdRef;
    }
    public Person_onPerson_propertyMutation setPersonIdRef(String value)
    {
      this.personIdRef = value;
      triggerOnChange();
      return this;
    }
    public String getTargetPersonIdRef()
    {
      return this.targetPersonIdRef;
    }
    public Person_onPerson_propertyMutation setTargetPersonIdRef(String value)
    {
      this.targetPersonIdRef = value;
      triggerOnChange();
      return this;
    }
    public String getActionPropertyMutationRuleRef()
    {
      return this.actionPropertyMutationRuleRef;
    }
    public Person_onPerson_propertyMutation setActionPropertyMutationRuleRef(String value)
    {
      this.actionPropertyMutationRuleRef = value;
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
        "value": {},
        "isSingle": false,
        "isNullable": true,
        "attributes": {
          "metaType": "object",
          "value": {
            "person_id_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "target_person_id_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "action_property_mutation_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          }
        }
      },
      "name": "person.on_person.property_mutation"
    }
  */