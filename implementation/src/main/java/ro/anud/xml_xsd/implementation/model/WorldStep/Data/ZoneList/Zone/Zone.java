package ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone;
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
  public class Zone implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "zone";
    public static Zone fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Zone();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Zone fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Zone> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Zone.fromRawNode(o, parent)));
        }

    }
    public static List<Zone> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Zone> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Zone.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.data.zone_list.zone";
    }

    //Attributes

    private String id;

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region> region = new ArrayList<>();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Zone>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Zone>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "zone";
    }
    public static Zone of() {
      return new Zone();
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList> parentAsZoneList() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region) {
          this.region.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region) {
          return this.region.indexOf(object);
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Zone> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Zone> callback) {
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
          innerLogger.log("id");
          var idValue = rawNode.getAttributeRequired("id");
          if(Objects.equals(this.id, idValue)) {
            isDirty = true;
          }
          this.id = idValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.region = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region.fromRawNode(rawNode.getChildrenList("region"), this);
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
        rawNode.setTag("zone");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("id");
          rawNode.setAttribute("id", this.id);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("region");
          rawNode.setChildren("region", region.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing zone");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public Zone setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region> getRegion()
    {
      return this.region;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region> streamRegion()
    {
      return region.stream();
    }
    public Zone addRegion(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region value)
    {
      this.region.add(value);
      value.parentNode(this);
      return this;
    }
    public Zone addAllRegion(List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region> value)
    {
      this.region.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Zone removeRegion(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region value)
    {
      this.region.remove(value);
      value.clearParentNode();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.region.size() > pathIndex) {
              return this.region.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addRegion(newEntry);
          return linkedNode;
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.region.size() > pathIndex) {
            return this.region.get(pathIndex).getNodeAtPath(childXPath);
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
      },
      "name": "zone"
    }
  */