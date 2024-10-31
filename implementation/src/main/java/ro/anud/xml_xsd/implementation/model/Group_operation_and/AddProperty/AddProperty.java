package ro.anud.xml_xsd.implementation.model.Group_operation_and.AddProperty;
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
  public class AddProperty  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<AddProperty>> onChangeList = new ArrayList<>();

    public static AddProperty fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new AddProperty();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<AddProperty> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(AddProperty::fromRawNode));
    }
    public static List<AddProperty> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<AddProperty> returnList = rawNodeList.stream().map(AddProperty::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<AddProperty> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    //Attributes
    private String propertyRuleRef;

    //Children elements

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing add_property");
      //Deserialize arguments
      this.propertyRuleRef = rawNode.getAttributeRequired("property_rule_ref");

      //Deserialize children
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("property_rule_ref", this.propertyRuleRef);

      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing add_property");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPropertyRuleRef()
    {
      return this.propertyRuleRef;
    }
    public AddProperty setPropertyRuleRef(String value)
    {
      this.propertyRuleRef = value;
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
        "value": {},
        "isSingle": true,
        "isNullable": true,
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
      "name": "add_property",
      "parentType": {
        "type": "element",
        "value": {
          "metaType": "object",
          "isSingle": false,
          "value": {
            "add_property": {
              "metaType": "object",
              "value": {},
              "isSingle": true,
              "isNullable": true,
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
            "and": {
              "metaType": "reference",
              "value": "group__operation__and",
              "isSingle": false,
              "attributes": {
                "metaType": "object",
                "value": {
                  "do": {
                    "metaType": "primitive",
                    "value": "type__group__operation__and",
                    "isNullable": false
                  },
                  "value": {
                    "metaType": "primitive",
                    "value": "xs:int",
                    "isNullable": false
                  }
                }
              },
              "isNullable": true
            }
          }
        },
        "name": "group__operation__and"
      }
    }
  */