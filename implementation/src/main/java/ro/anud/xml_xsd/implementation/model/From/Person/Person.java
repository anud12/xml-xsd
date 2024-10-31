package ro.anud.xml_xsd.implementation.model.From.Person;
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
  public class Person  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static Person fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Person();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<Person> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Person::fromRawNode));
    }
    public static List<Person> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Person> returnList = rawNodeList.stream().map(Person::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> select = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> propertyMutation = Optional.empty();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person");
      //Deserialize arguments

      //Deserialize children
      this.select = ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.fromRawNode(rawNode.getChildrenFirst("select"));
      this.propertyMutation = ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation.fromRawNode(rawNode.getChildrenFirst("property_mutation"));
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("select", select);
      rawNode.addChildren("property_mutation", propertyMutation);
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person");
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
      },
      "name": "person",
      "parentType": {
        "type": "element",
        "value": {
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
        "name": "from"
      }
    }
  */