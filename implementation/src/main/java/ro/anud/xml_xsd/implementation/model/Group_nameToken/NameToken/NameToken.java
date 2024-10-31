package ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken;
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
  public class NameToken  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static NameToken fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new NameToken();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<NameToken> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(NameToken::fromRawNode));
    }
    public static List<NameToken> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<NameToken> returnList = rawNodeList.stream().map(NameToken::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String prefix;

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref> _ref = Optional.empty();
    private ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken oneOf = new ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing name_token");
      //Deserialize arguments
      this.prefix = rawNode.getAttributeRequired("prefix");

      //Deserialize children
      this._ref = ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref.fromRawNode(rawNode.getChildrenFirst("ref"));
      this.oneOf = ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken.fromRawNode(rawNode.getChildrenFirst("one_of").get());
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("prefix", this.prefix);

      //Serialize children
      rawNode.addChildren("ref", _ref);
      rawNode.addChildren("one_of", oneOf);
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing name_token");
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
          },
          "one_of": {
            "metaType": "reference",
            "value": "group__name_token",
            "isSingle": true,
            "isNullable": false
          }
        }
      },
      "name": "name_token",
      "parentType": {
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
    }
  */