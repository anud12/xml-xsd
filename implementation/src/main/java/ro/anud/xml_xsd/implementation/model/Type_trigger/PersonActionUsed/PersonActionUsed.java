package ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @Getter
  @Setter
  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public class PersonActionUsed  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static PersonActionUsed fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new PersonActionUsed();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<PersonActionUsed> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(PersonActionUsed::fromRawNode));
    }
    public static List<PersonActionUsed> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<PersonActionUsed> returnList = rawNodeList.stream().map(PersonActionUsed::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    /* ignored attribute key={key} of type=Object*/

    //Children elements

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person_action_used");
      //Deserialize arguments

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person_action_used");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
  }

  /*
    dependant type:
    {
      "type": "element",
      "value": {
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
      },
      "name": "person_action_used",
      "parentType": {
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
    }
  */