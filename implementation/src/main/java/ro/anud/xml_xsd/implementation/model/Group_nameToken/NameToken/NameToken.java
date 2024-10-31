package ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken;
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
  public class NameToken  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<NameToken>> onChangeList = new ArrayList<>();

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

    public Runnable onChange(Consumer<NameToken> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
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

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("prefix", this.prefix);

      //Serialize children
      rawNode.addChildren("ref", _ref);
      rawNode.addChildren("one_of", oneOf);
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing name_token");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPrefix()
    {
      return this.prefix;
    }
    public NameToken setPrefix(String value)
    {
      this.prefix = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref> get_ref()
    {
      return this._ref;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref> GetOrInsertDefault__ref()
    {
      if(this._ref == null) {
        this._ref = Optional.empty();
      }
      return this._ref;
    }
    */
    public NameToken set_ref(Optional<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref> value)
    {
      this._ref = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken getOneOf()
    {
      return this.oneOf;
    }
    public NameToken setOneOf(ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken value)
    {
      this.oneOf = value;
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