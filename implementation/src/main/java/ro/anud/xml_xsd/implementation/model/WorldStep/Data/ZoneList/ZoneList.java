package ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class ZoneList implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "zone_list";
    public static ZoneList fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new ZoneList();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static ZoneList fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<ZoneList> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> ZoneList.fromRawNode(o, parent)));
    }
    public static List<ZoneList> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<ZoneList> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> ZoneList.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".world_step.data.zone_list";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone> zone = new ArrayList<>();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private RawNode rawNode = new RawNode();

    public RawNode rawNode() {
      return rawNode;
    }
    public void rawNode(RawNode rawNode) {
      this.rawNode = rawNode;
    }

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode() {
      return parentNode;
    }

    @Builder.Default
    private List<Consumer<List<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "zone_list";
    }

    public void notifyChange(List<Object> list) {
      var logger = logEnter();
      list.addLast(this);
      logger.log("Notify change for", this.buildPath());
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data> parentAsData() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone) {
          this.zone.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone) {
          return this.zone.indexOf(object);
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      try {
        var logger = logEnter();
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing zone_list");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger = logger.log("children");
        //Deserialize children
        this.zone = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone.fromRawNode(rawNode.getChildrenList("zone"), this);
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("zone_list");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("zone");
      rawNode.setChildren("zone", zone.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing zone_list");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone> getZone()
    {
      return this.zone;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone> streamZone()
    {
      return zone.stream();
    }
    public ZoneList addZone(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone value)
    {
      this.zone.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public ZoneList addAllZone(List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone> value)
    {
      this.zone.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public ZoneList removeZone(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone value)
    {
      this.zone.remove(value);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.zone.size() > pathIndex) {
              return this.zone.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone();
          this.addZone(newEntry);
          return newEntry.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.zone.size() > pathIndex) {
            return this.zone.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        return Optional.of(this);
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
          "zone": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "id": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isSingle": false,
            "value": {
              "region": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "rule": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "rule_id_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  },
                  "position": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "x": {
                          "metaType": "primitive",
                          "value": "xs:integer",
                          "isNullable": false
                        },
                        "y": {
                          "metaType": "primitive",
                          "value": "xs:integer",
                          "isNullable": false
                        }
                      }
                    }
                  },
                  "limit": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "width": {
                          "metaType": "primitive",
                          "value": "xs:integer",
                          "isNullable": false
                        },
                        "height": {
                          "metaType": "primitive",
                          "value": "xs:integer",
                          "isNullable": false
                        }
                      }
                    }
                  },
                  "portals": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "portal": {
                        "metaType": "object",
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "id": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        },
                        "isSingle": false,
                        "value": {
                          "from": {
                            "metaType": "object",
                            "value": {},
                            "isSingle": true,
                            "isNullable": false,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "side": {
                                  "metaType": "primitive",
                                  "value": "type__rectangle_side",
                                  "isNullable": false
                                },
                                "start": {
                                  "metaType": "primitive",
                                  "value": "xs:integer",
                                  "isNullable": false
                                },
                                "end": {
                                  "metaType": "primitive",
                                  "value": "xs:integer",
                                  "isNullable": false
                                }
                              }
                            }
                          },
                          "to": {
                            "metaType": "object",
                            "value": {},
                            "isSingle": true,
                            "isNullable": true,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "zone_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                },
                                "region_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                },
                                "side": {
                                  "metaType": "primitive",
                                  "value": "type__rectangle_side",
                                  "isNullable": false
                                },
                                "start": {
                                  "metaType": "primitive",
                                  "value": "xs:integer",
                                  "isNullable": false
                                },
                                "end": {
                                  "metaType": "primitive",
                                  "value": "xs:integer",
                                  "isNullable": false
                                }
                              }
                            }
                          }
                        },
                        "isNullable": false
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "zone_list"
    }
  */