package ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref;
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
  public class _ref  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<_ref>> onChangeList = new ArrayList<>();

    public static _ref fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new _ref();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<_ref> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(_ref::fromRawNode));
    }
    public static List<_ref> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<_ref> returnList = rawNodeList.stream().map(_ref::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<_ref> onChange) {
      onChangeList.add(onChange);
      return () -> onChangeList.remove(onChange);
    }

    //Attributes
    private String nameRuleRef;

    //Children elements

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing ref");
      //Deserialize arguments
      this.nameRuleRef = rawNode.getAttributeRequired("name_rule_ref");

      //Deserialize children
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("name_rule_ref", this.nameRuleRef);

      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing ref");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getNameRuleRef()
    {
      return this.nameRuleRef;
    }
    public _ref setNameRuleRef(String value)
    {
      this.nameRuleRef = value;
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
            "name_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        }
      },
      "name": "ref",
      "parentType": {
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
    }
  */