package ro.anud.xml_xsd.implementation.model.Type_trigger;
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
  public class Type_trigger implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_trigger.IType_trigger<Type_trigger>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Type_trigger fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_trigger();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Type_trigger fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Type_trigger> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Type_trigger.fromRawNode(o, parent)));
    }
    public static List<Type_trigger> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Type_trigger> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Type_trigger.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed personActionUsed = new ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed();

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
    private List<Consumer<Type_trigger>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "type__trigger";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed) {
          throw new RuntimeException("trying to delete personActionUsed which is required");
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Type_trigger> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__trigger");
      //Deserialize arguments

      //Deserialize children
      this.personActionUsed = ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed.fromRawNode(rawNode.getChildrenFirst("person_action_used").get(), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("person_action_used", Optional.ofNullable(personActionUsed).stream().map(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed::serializeIntoRawNode).toList());
      return rawNode;
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
    public Stream<ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed> streamPersonActionUsed()
    {
      return Optional.ofNullable(personActionUsed).stream();
    }
    public Type_trigger setPersonActionUsed(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed value)
    {
      this.personActionUsed = value;
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
                  "metaType": "unknown",
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
                    "metaType": "unknown",
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