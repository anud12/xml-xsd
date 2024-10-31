package ro.anud.xml_xsd.implementation.model.Type_mathOperations;
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
  public class Type_mathOperations  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static Type_mathOperations fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_mathOperations();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<Type_mathOperations> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Type_mathOperations::fromRawNode));
    }
    public static List<Type_mathOperations> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Type_mathOperations> returnList = rawNodeList.stream().map(Type_mathOperations::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private Integer initial;

    //Children elements

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__math_operations");
      //Deserialize arguments
      this.initial = rawNode.getAttributeIntRequired("initial");

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("initial", this.initial);

      //Serialize children
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__math_operations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
  }

  /*
    dependant type:
    {
      "type": "element",
      "value": {
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
        }
      },
      "name": "type__math_operations"
    }
  */