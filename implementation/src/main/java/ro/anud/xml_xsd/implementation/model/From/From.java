package ro.anud.xml_xsd.implementation.model.From;
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
  public class From  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static From fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new From();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<From> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(From::fromRawNode));
    }
    public static List<From> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<From> returnList = rawNodeList.stream().map(From::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.From.Person.Person> person = Optional.empty();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from");
      //Deserialize arguments

      //Deserialize children
      this.person = ro.anud.xml_xsd.implementation.model.From.Person.Person.fromRawNode(rawNode.getChildrenFirst("person"));
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("person", person);
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing from");
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
  */