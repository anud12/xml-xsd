package ro.anud.xml_xsd.implementation.model.Group_mathOperations;
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
  public class Group_mathOperations  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static Group_mathOperations fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Group_mathOperations();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<Group_mathOperations> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Group_mathOperations::fromRawNode));
    }
    public static List<Group_mathOperations> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Group_mathOperations> returnList = rawNodeList.stream().map(Group_mathOperations::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private ro.anud.xml_xsd.implementation.model.Group_operation_and.Group_operation_and operation = new ro.anud.xml_xsd.implementation.model.Group_operation_and.Group_operation_and();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing group__math_operations");
      //Deserialize arguments

      //Deserialize children
      this.operation = ro.anud.xml_xsd.implementation.model.Group_operation_and.Group_operation_and.fromRawNode(rawNode.getChildrenFirst("operation").get());
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("operation", operation);
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing group__math_operations");
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
          "operation": {
            "metaType": "reference",
            "value": "group__operation__and",
            "isSingle": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "initial": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isNullable": false
          }
        }
      },
      "name": "group__math_operations"
    }
  */