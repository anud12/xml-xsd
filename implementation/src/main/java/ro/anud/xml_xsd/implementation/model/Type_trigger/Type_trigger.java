package ro.anud.xml_xsd.implementation.model.Type_trigger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public class Type_trigger  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<Type_trigger>> onChangeList = new ArrayList<>();

    public static Type_trigger fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_trigger();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<Type_trigger> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Type_trigger::fromRawNode));
    }
    public static List<Type_trigger> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Type_trigger> returnList = rawNodeList.stream().map(Type_trigger::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<Type_trigger> onChange) {
      onChangeList.add(onChange);
      return () -> onChangeList.remove(onChange);
    }

    //Attributes

    //Children elements
    private ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed personActionUsed = new ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__trigger");
      //Deserialize arguments

      //Deserialize children
      this.personActionUsed = ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed.fromRawNode(rawNode.getChildrenFirst("person_action_used").get());
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("person_action_used", personActionUsed);
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
    /*
    public ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed GetOrInsertDefault_PersonActionUsed()
    {
      if(this.personActionUsed == null) {
        this.personActionUsed = new ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed();
      }
      return this.personActionUsed;
    }
    */
    public Type_trigger setPersonActionUsed(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed value)
    {
      this.personActionUsed = value;
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
      "name": "type__trigger"
    }
  */