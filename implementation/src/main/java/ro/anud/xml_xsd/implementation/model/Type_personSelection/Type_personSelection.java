package ro.anud.xml_xsd.implementation.model.Type_personSelection;
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
  public class Type_personSelection  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static Type_personSelection fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_personSelection();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<Type_personSelection> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Type_personSelection::fromRawNode));
    }
    public static List<Type_personSelection> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Type_personSelection> returnList = rawNodeList.stream().map(Type_personSelection::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> radius = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> min = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> max = Optional.empty();
    private List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> property = new ArrayList<>();
    private List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> classification = new ArrayList<>();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race> race = Optional.empty();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__person_selection");
      //Deserialize arguments

      //Deserialize children
      this.radius = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("radius"));
      this.min = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("min"));
      this.max = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("max"));
      this.property = ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property.fromRawNode(rawNode.getChildrenList("property"));
      this.classification = ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification.fromRawNode(rawNode.getChildrenList("classification"));
      this.race = ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race.fromRawNode(rawNode.getChildrenFirst("race"));
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("radius", radius);
      rawNode.addChildren("min", min);
      rawNode.addChildren("max", max);
      rawNode.addChildren("property", property);
      rawNode.addChildren("classification", classification);
      rawNode.addChildren("race", race);
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__person_selection");
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
        "isSingle": false,
        "value": {
          "radius": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": true
          },
          "min": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": true
          },
          "max": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": true
          },
          "property": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "property_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                }
              },
              "isNullable": true
            },
            "isSingle": false,
            "value": {
              "min": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": true
              },
              "max": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "classification": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "classification_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "race": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "race_rule_ref": {
                  "metaType": "unknown",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          }
        }
      },
      "name": "type__person_selection"
    }
  */