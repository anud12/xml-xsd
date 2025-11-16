package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_onPerson_propertyMutation;
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
  public class Person_onPerson_propertyMutation implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "person.on_person.property_mutation";
    public static Person_onPerson_propertyMutation fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Person_onPerson_propertyMutation();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Person_onPerson_propertyMutation fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Person_onPerson_propertyMutation> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Person_onPerson_propertyMutation.fromRawNode(o, parent)));
        }

    }
    public static List<Person_onPerson_propertyMutation> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Person_onPerson_propertyMutation> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Person_onPerson_propertyMutation.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.actions.person.on_person.property_mutation";
    }

    //Attributes

    private String personIdRef;

    private String targetPersonIdRef;

    private String actionPropertyMutationRuleRef;

    //Children elements

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Person_onPerson_propertyMutation>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Person_onPerson_propertyMutation>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "person.on_person.property_mutation";
    }
    public static Person_onPerson_propertyMutation of() {
      return new Person_onPerson_propertyMutation();
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> parentAsActions() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
    }

    public int buildIndexForChild(Object object) {
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Person_onPerson_propertyMutation> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Person_onPerson_propertyMutation> callback) {
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
          innerLogger.log("person_id_ref");
          var personIdRefValue = rawNode.getAttributeRequired("person_id_ref");
          if(Objects.equals(this.personIdRef, personIdRefValue)) {
            isDirty = true;
          }
          this.personIdRef = personIdRefValue;
          innerLogger.log("target_person_id_ref");
          var targetPersonIdRefValue = rawNode.getAttributeRequired("target_person_id_ref");
          if(Objects.equals(this.targetPersonIdRef, targetPersonIdRefValue)) {
            isDirty = true;
          }
          this.targetPersonIdRef = targetPersonIdRefValue;
          innerLogger.log("action_property_mutation_rule_ref");
          var actionPropertyMutationRuleRefValue = rawNode.getAttributeRequired("action_property_mutation_rule_ref");
          if(Objects.equals(this.actionPropertyMutationRuleRef, actionPropertyMutationRuleRefValue)) {
            isDirty = true;
          }
          this.actionPropertyMutationRuleRef = actionPropertyMutationRuleRefValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
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
        rawNode.setTag("person.on_person.property_mutation");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("person_id_ref");
          rawNode.setAttribute("person_id_ref", this.personIdRef);
          innerLogger.log("target_person_id_ref");
          rawNode.setAttribute("target_person_id_ref", this.targetPersonIdRef);
          innerLogger.log("action_property_mutation_rule_ref");
          rawNode.setAttribute("action_property_mutation_rule_ref", this.actionPropertyMutationRuleRef);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          return rawNode;
        }
      }
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
      notifyChange();
      return this;
    }
    public String getTargetPersonIdRef()
    {
      return this.targetPersonIdRef;
    }
    public Person_onPerson_propertyMutation setTargetPersonIdRef(String value)
    {
      this.targetPersonIdRef = value;
      notifyChange();
      return this;
    }
    public String getActionPropertyMutationRuleRef()
    {
      return this.actionPropertyMutationRuleRef;
    }
    public Person_onPerson_propertyMutation setActionPropertyMutationRuleRef(String value)
    {
      this.actionPropertyMutationRuleRef = value;
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
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