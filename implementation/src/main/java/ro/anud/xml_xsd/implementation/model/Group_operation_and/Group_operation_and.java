package ro.anud.xml_xsd.implementation.model.Group_operation_and;
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
  public class Group_operation_and  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static Group_operation_and fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Group_operation_and();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<Group_operation_and> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Group_operation_and::fromRawNode));
    }
    public static List<Group_operation_and> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Group_operation_and> returnList = rawNodeList.stream().map(Group_operation_and::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Group_operation_and.AddProperty.AddProperty> addProperty = Optional.empty();
    private List<ro.anud.xml_xsd.implementation.model.Group_operation_and.Group_operation_and> and = new ArrayList<>();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing group__operation__and");
      //Deserialize arguments

      //Deserialize children
      this.addProperty = ro.anud.xml_xsd.implementation.model.Group_operation_and.AddProperty.AddProperty.fromRawNode(rawNode.getChildrenFirst("add_property"));
      this.and = ro.anud.xml_xsd.implementation.model.Group_operation_and.Group_operation_and.fromRawNode(rawNode.getChildrenList("and"));
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("add_property", addProperty);
      rawNode.addChildren("and", and);
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing group__operation__and");
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
  */