package ro.anud.xml_xsd.implementation.model.On;
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
  public class On  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static On fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new On();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<On> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(On::fromRawNode));
    }
    public static List<On> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<On> returnList = rawNodeList.stream().map(On::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.On.Person.Person> person = Optional.empty();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing on");
      //Deserialize arguments

      //Deserialize children
      this.person = ro.anud.xml_xsd.implementation.model.On.Person.Person.fromRawNode(rawNode.getChildrenFirst("person"));
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
        // Godot.GD.Print("Serializing on");
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
      "name": "on"
    }
  */