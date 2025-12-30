package ro.anud.xml_xsd.implementation.model.WorldStep.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Data implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "data";
    public static Data fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Data();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Data fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Data> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Data.fromRawNode(o, parent)));
        }

    }
    public static List<Data> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Data> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Data.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.data";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities> entities = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location> location = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList> zoneList = Optional.empty();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Data>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Data>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "data";
    }
    public static Data of() {
      return new Data();
    }

    public void notifyChange(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.onChange(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(object));
      }
    }

    public void notifyRemove(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify remove for", this.buildPath());
        onRemoveList.forEach(consumer -> consumer.onRemove(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyRemove(object));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode.ifPresent(parent -> notifyRemove());
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep> parentAsWorldStep() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities) {
          this.entities = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location) {
          this.location = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList) {
          this.zoneList = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Data> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Data> callback) {
      try (var logger = logScope()) {
        onRemoveList.add(callback);
        return logger.logReturn(() -> onRemoveList.remove(callback));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.entities = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities.fromRawNode(rawNode.getChildrenFirst("entities"), this);
          this.location = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location.fromRawNode(rawNode.getChildrenFirst("location"), this);
          this.zoneList = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList.fromRawNode(rawNode.getChildrenFirst("zone_list"), this);
        }

        if(isDirty) {
          notifyChange();
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("data");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("entities");
          rawNode.setChildren("entities", entities.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities::serializeIntoRawNode).toList());
          innerLogger.log("location");
          rawNode.setChildren("location", location.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location::serializeIntoRawNode).toList());
          innerLogger.log("zone_list");
          rawNode.setChildren("zone_list", zoneList.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing data");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities> getEntities()
    {
      return this.entities;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities getEntitiesOrDefault()
    {
      return this.entities.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities();
        this.entities = Optional.of(instance);
        instance.parentNode(this);
        return this.entities.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities> streamEntitiesOrDefault()
    {
      return java.util.stream.Stream.of(getEntitiesOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities> streamEntities()
    {
      return entities.stream();
    }
    public Data setEntities(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities value)
    {
      this.entities = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location> getLocation()
    {
      return this.location;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location getLocationOrDefault()
    {
      return this.location.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location();
        this.location = Optional.of(instance);
        instance.parentNode(this);
        return this.location.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location> streamLocationOrDefault()
    {
      return java.util.stream.Stream.of(getLocationOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location> streamLocation()
    {
      return location.stream();
    }
    public Data setLocation(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location value)
    {
      this.location = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList> getZoneList()
    {
      return this.zoneList;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList getZoneListOrDefault()
    {
      return this.zoneList.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList();
        this.zoneList = Optional.of(instance);
        instance.parentNode(this);
        return this.zoneList.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList> streamZoneListOrDefault()
    {
      return java.util.stream.Stream.of(getZoneListOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList> streamZoneList()
    {
      return zoneList.stream();
    }
    public Data setZoneList(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList value)
    {
      this.zoneList = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities.nodeName))
        {
          if(this.entities.isEmpty()) {
            this.entities = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities.nodeName.length() + 3);
          return this.entities.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location.nodeName))
        {
          if(this.location.isEmpty()) {
            this.location = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location.nodeName.length() + 3);
          return this.location.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList.nodeName))
        {
          if(this.zoneList.isEmpty()) {
            this.zoneList = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList.nodeName.length() + 3);
          return this.zoneList.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities.nodeName))
        {
          if(this.entities.isEmpty()) {
            this.entities = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities.nodeName.length() + 3);
          return this.entities.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location.nodeName))
        {
          if(this.location.isEmpty()) {
            this.location = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location.nodeName.length() + 3);
          return this.location.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList.nodeName))
        {
          if(this.zoneList.isEmpty()) {
            this.zoneList = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList.nodeName.length() + 3);
          return this.zoneList.get().getNodeAtPath(childXPath);
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
          "entities": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entity": {
                "metaType": "composition",
                "value": [
                  {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false
                  },
                  {
                    "metaType": "primitive",
                    "value": "type__entity"
                  }
                ],
                "isSingle": false,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "location": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "location_graph": {
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
                        "location_graph_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  },
                  "node": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "node_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "id": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      }
                    },
                    "isSingle": false,
                    "value": {
                      "name": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "value": {
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
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "x": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": false
                            },
                            "y": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": false
                            }
                          }
                        }
                      },
                      "classifications": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "classification": {
                            "metaType": "object",
                            "value": {},
                            "isSingle": false,
                            "isNullable": true,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "location_classification_rule_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                }
                              },
                              "isNullable": false
                            }
                          }
                        },
                        "isNullable": true
                      },
                      "links": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "link_to": {
                            "metaType": "object",
                            "value": {},
                            "isSingle": false,
                            "isNullable": true,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "node_id_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                },
                                "total_progress": {
                                  "metaType": "primitive",
                                  "value": "xs:int",
                                  "isNullable": false
                                }
                              }
                            }
                          }
                        },
                        "isNullable": true
                      }
                    },
                    "isNullable": false
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "zone_list": {
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
                              "value": "xs:int",
                              "isNullable": false
                            },
                            "y": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": false
                            },
                            "rotation": {
                              "metaType": "primitive",
                              "value": "type__rotation_90deg_step",
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
                              "value": "xs:int",
                              "isNullable": false
                            },
                            "height": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": false
                            }
                          }
                        }
                      },
                      "available_portals": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "portal": {
                            "metaType": "object",
                            "value": {},
                            "isSingle": false,
                            "isNullable": true,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "id": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                },
                                "start": {
                                  "metaType": "primitive",
                                  "value": "xs:int",
                                  "isNullable": false
                                },
                                "side": {
                                  "metaType": "primitive",
                                  "value": "type__rectangle_side",
                                  "isNullable": false
                                },
                                "portal_rule_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                }
                              }
                            }
                          }
                        },
                        "isNullable": true
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
                                      "value": "xs:int",
                                      "isNullable": false
                                    },
                                    "end": {
                                      "metaType": "primitive",
                                      "value": "xs:int",
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
                                      "value": "xs:int",
                                      "isNullable": false
                                    },
                                    "end": {
                                      "metaType": "primitive",
                                      "value": "xs:int",
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
                      },
                      "entity_list": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "entity": {
                            "metaType": "object",
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "entity_id_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                }
                              },
                              "isNullable": false
                            },
                            "isSingle": false,
                            "value": {
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
              }
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "data"
    }
  */