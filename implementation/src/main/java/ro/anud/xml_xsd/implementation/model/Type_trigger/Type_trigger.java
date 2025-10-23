package ro.anud.xml_xsd.implementation.model.Type_trigger;
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
  public class Type_trigger implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_trigger.IType_trigger<Type_trigger>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "type__trigger";
    public static Type_trigger fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Type_trigger();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Type_trigger fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Type_trigger> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Type_trigger.fromRawNode(o, parent)));
        }

    }
    public static List<Type_trigger> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Type_trigger> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Type_trigger.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".type__trigger";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed personActionUsed = new ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed();

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
      return "type__trigger";
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

    public void clearParentNode() {
      var parentNode = this.parentNode;
      this.parentNode = Optional.empty();
      parentNode.ifPresent(ro.anud.xml_xsd.implementation.util.LinkedNode::notifyChange);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed) {
          throw new RuntimeException("trying to delete personActionUsed which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed) {
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
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.personActionUsed = ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed.fromRawNode(rawNode.getChildrenFirst("person_action_used").get(), this);
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
        rawNode.setTag("type__trigger");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("person_action_used");
          rawNode.setChildren("person_action_used", Optional.ofNullable(personActionUsed).stream().map(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__trigger");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed getPersonActionUsed()
    {
      return this.personActionUsed;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed> streamPersonActionUsed()
    {
      return Optional.ofNullable(personActionUsed).stream();
    }
    public Type_trigger setPersonActionUsed(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed value)
    {
      this.personActionUsed = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed.nodeName.length() + 3);
          return this.personActionUsed.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed.nodeName.length() + 3);
          return this.personActionUsed.getNodeAtPath(childXPath);
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
        "isSingle": true,
        "value": {
          "person_action_used": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "action_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          }
        }
      },
      "typeDeclaration": {
        "name": "type__trigger",
        "type": "complex",
        "isSingle": true,
        "value": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "person_action_used": {
              "metaType": "object",
              "value": {},
              "isSingle": true,
              "isNullable": false,
              "attributes": {
                "metaType": "object",
                "value": {
                  "action_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  }
                },
                "isNullable": false
              }
            }
          }
        }
      },
      "name": "type__trigger"
    }
  */