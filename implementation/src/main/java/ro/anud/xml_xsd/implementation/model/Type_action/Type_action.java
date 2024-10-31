package ro.anud.xml_xsd.implementation.model.Type_action;
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
  public class Type_action  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static Type_action fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_action();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<Type_action> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Type_action::fromRawNode));
    }
    public static List<Type_action> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Type_action> returnList = rawNodeList.stream().map(Type_action::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private ro.anud.xml_xsd.implementation.model.Type_action.From.From from = new ro.anud.xml_xsd.implementation.model.Type_action.From.From();
    private ro.anud.xml_xsd.implementation.model.Type_action.On.On on = new ro.anud.xml_xsd.implementation.model.Type_action.On.On();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__action");
      //Deserialize arguments

      //Deserialize children
      this.from = ro.anud.xml_xsd.implementation.model.Type_action.From.From.fromRawNode(rawNode.getChildrenFirst("from").get());
      this.on = ro.anud.xml_xsd.implementation.model.Type_action.On.On.fromRawNode(rawNode.getChildrenFirst("on").get());
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("from", from);
      rawNode.addChildren("on", on);
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__action");
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
        "isSingle": true,
        "value": {
          "from": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "person": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "select": {
                    "metaType": "reference",
                    "value": "type__person_selection",
                    "isSingle": true,
                    "isNullable": true
                  },
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
            "isNullable": false
          },
          "on": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "person": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "select": {
                    "metaType": "reference",
                    "value": "type__person_selection",
                    "isSingle": true,
                    "isNullable": true
                  },
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
            "isNullable": false
          }
        }
      },
      "name": "type__action"
    }
  */