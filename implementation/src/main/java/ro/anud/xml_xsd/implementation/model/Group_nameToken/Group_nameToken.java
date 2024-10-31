package ro.anud.xml_xsd.implementation.model.Group_nameToken;
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
  public class Group_nameToken  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static Group_nameToken fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Group_nameToken();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<Group_nameToken> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Group_nameToken::fromRawNode));
    }
    public static List<Group_nameToken> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Group_nameToken> returnList = rawNodeList.stream().map(Group_nameToken::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken> nameToken = new ArrayList<>();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing group__name_token");
      //Deserialize arguments

      //Deserialize children
      this.nameToken = ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken.fromRawNode(rawNode.getChildrenList("name_token"));
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("name_token", nameToken);
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing group__name_token");
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
          "name_token": {
            "metaType": "union",
            "value": [
              {
                "metaType": "object",
                "isSingle": true,
                "isNullable": true,
                "value": {
                  "ref": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "name_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  }
                }
              },
              {
                "metaType": "object",
                "isSingle": true,
                "isNullable": false,
                "value": {
                  "one_of": {
                    "metaType": "reference",
                    "value": "group__name_token",
                    "isSingle": true,
                    "isNullable": false
                  }
                }
              }
            ],
            "isSingle": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "prefix": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isNullable": false
          }
        }
      },
      "name": "group__name_token"
    }
  */