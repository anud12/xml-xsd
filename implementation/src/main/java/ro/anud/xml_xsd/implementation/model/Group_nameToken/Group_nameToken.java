package ro.anud.xml_xsd.implementation.model.Group_nameToken;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import java.util.stream.Stream;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Group_nameToken implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Group_nameToken fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Group_nameToken();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Group_nameToken fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Group_nameToken> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Group_nameToken.fromRawNode(o, parent)));
    }
    public static List<Group_nameToken> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Group_nameToken> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Group_nameToken.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken> nameToken = new ArrayList<>();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<Group_nameToken>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "group__name_token";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken) {
          throw new RuntimeException("trying to delete nameToken which is required");
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Group_nameToken> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing group__name_token");
      //Deserialize arguments

      //Deserialize children
      this.nameToken = ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken.fromRawNode(rawNode.getChildrenList("name_token"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("name_token", nameToken.stream().map(ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing group__name_token");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken> getNameToken()
    {
      return this.nameToken;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken> streamNameToken()
    {
      return nameToken.stream();
    }
    public Group_nameToken addNameToken(ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken value)
    {
      this.nameToken.add(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Group_nameToken addAllNameToken(List<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken> value)
    {
      this.nameToken.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Group_nameToken removeNameToken(ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken.NameToken value)
    {
      this.nameToken.remove(value);
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
      "typeDeclaration": {
        "name": "group__name_token",
        "type": "group",
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
        }
      },
      "name": "group__name_token"
    }
  */