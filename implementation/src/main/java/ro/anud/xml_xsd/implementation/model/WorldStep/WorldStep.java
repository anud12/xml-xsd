package ro.anud.xml_xsd.implementation.model.WorldStep;
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
  public class WorldStep implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static final String TYPE_ID = "/world_step";

    public static WorldStep fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new WorldStep();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static WorldStep fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<WorldStep> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> WorldStep.fromRawNode(o, parent)));
    }
    public static List<WorldStep> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<WorldStep> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> WorldStep.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata> worldMetadata = Optional.empty();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup> ruleGroup = new ArrayList<>();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data> data = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> actions = Optional.empty();

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
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "world_step";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata) {
          this.worldMetadata = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup) {
          this.ruleGroup.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data) {
          this.data = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions) {
          this.actions = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup) {
          return this.ruleGroup.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Set<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing world_step");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.worldMetadata = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata.fromRawNode(rawNode.getChildrenFirst("world_metadata"), this);
      this.ruleGroup = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup.fromRawNode(rawNode.getChildrenList("rule_group"), this);
      this.data = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data.fromRawNode(rawNode.getChildrenFirst("data"), this);
      this.actions = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions.fromRawNode(rawNode.getChildrenFirst("actions"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("world_metadata");
      rawNode.setChildren("world_metadata", worldMetadata.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata::serializeIntoRawNode).toList());
      innerLogger.log("rule_group");
      rawNode.setChildren("rule_group", ruleGroup.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup::serializeIntoRawNode).toList());
      innerLogger.log("data");
      rawNode.setChildren("data", data.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data::serializeIntoRawNode).toList());
      innerLogger.log("actions");
      rawNode.setChildren("actions", actions.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing world_step");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata> getWorldMetadata()
    {
      return this.worldMetadata;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata getWorldMetadataOrDefault()
    {
      return this.worldMetadata.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata();
        instance.parentNode(this);
        this.worldMetadata = Optional.of(instance);
        return this.worldMetadata.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata> streamWorldMetadataOrDefault()
    {
      return java.util.stream.Stream.of(getWorldMetadataOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata> streamWorldMetadata()
    {
      return worldMetadata.stream();
    }
    public WorldStep setWorldMetadata(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata value)
    {
      this.worldMetadata = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup> getRuleGroup()
    {
      return this.ruleGroup;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup> streamRuleGroup()
    {
      return ruleGroup.stream();
    }
    public WorldStep addRuleGroup(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup value)
    {
      this.ruleGroup.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public WorldStep addAllRuleGroup(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup> value)
    {
      this.ruleGroup.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public WorldStep removeRuleGroup(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup value)
    {
      this.ruleGroup.remove(value);
      triggerOnChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data> getData()
    {
      return this.data;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data getDataOrDefault()
    {
      return this.data.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data();
        instance.parentNode(this);
        this.data = Optional.of(instance);
        return this.data.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data> streamDataOrDefault()
    {
      return java.util.stream.Stream.of(getDataOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data> streamData()
    {
      return data.stream();
    }
    public WorldStep setData(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data value)
    {
      this.data = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> getActions()
    {
      return this.actions;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions getActionsOrDefault()
    {
      return this.actions.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions();
        instance.parentNode(this);
        this.actions = Optional.of(instance);
        return this.actions.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> streamActionsOrDefault()
    {
      return java.util.stream.Stream.of(getActionsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> streamActions()
    {
      return actions.stream();
    }
    public WorldStep setActions(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions value)
    {
      this.actions = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
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
          "world_metadata": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "previous_world_step": {
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
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                }
              },
              "next_world_step": {
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
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                }
              },
              "elapsed_time": {
                "metaType": "object",
                "value": {},
                "isSingle": true,
                "isNullable": false,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "value": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              },
              "stepDuration": {
                "metaType": "object",
                "value": {},
                "isSingle": true,
                "isNullable": false,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "value": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              },
              "counter": {
                "metaType": "object",
                "value": {},
                "isSingle": true,
                "isNullable": false,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "value": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              },
              "randomization_table": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "entry": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": false,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "value": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  }
                },
                "isNullable": false
              }
            },
            "isNullable": true
          },
          "rule_group": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "id": {
                  "metaType": "unknown",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isSingle": false,
            "value": {
              "property_rule": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "entry": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "id": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "units": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      }
                    },
                    "isSingle": false,
                    "value": {
                      "person_default": {
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
                            "value": "type__math_operations"
                          }
                        ],
                        "isSingle": true,
                        "isNullable": true
                      },
                      "item_default": {
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
                            "value": "type__math_operations"
                          }
                        ],
                        "isSingle": true,
                        "isNullable": true
                      },
                      "property-threshold": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "name": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            },
                            "min-value-inclusive": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": true
                            },
                            "max-value-inclusive": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": true
                            }
                          }
                        }
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": true
              },
              "classification_rule": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "entry": {
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
                      "property": {
                        "metaType": "object",
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "property_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            },
                            "is": {
                              "metaType": "union",
                              "value": [
                                {
                                  "metaType": "primitive",
                                  "value": "\"lessThan\""
                                },
                                {
                                  "metaType": "primitive",
                                  "value": "\"lessThanOrEqual\""
                                },
                                {
                                  "metaType": "primitive",
                                  "value": "\"greaterThan\""
                                },
                                {
                                  "metaType": "primitive",
                                  "value": "\"greaterThanOrEqual\""
                                },
                                {
                                  "metaType": "primitive",
                                  "value": "\"equal\""
                                }
                              ]
                            }
                          }
                        },
                        "isSingle": false,
                        "value": {
                          "operation": {
                            "metaType": "reference",
                            "value": "type__math_operations",
                            "isSingle": true,
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
              },
              "name_rule": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "entry": {
                    "metaType": "composition",
                    "value": [
                      {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": false,
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
                        }
                      },
                      {
                        "metaType": "primitive",
                        "value": "type__name_token"
                      }
                    ],
                    "isSingle": false,
                    "isNullable": true
                  }
                },
                "isNullable": true
              },
              "action_rule": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "from_person": {
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
                      "selection": {
                        "metaType": "reference",
                        "value": "type__person_selection",
                        "isSingle": true,
                        "isNullable": true
                      },
                      "mutations": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "property_mutation": {
                            "metaType": "reference",
                            "value": "type__property_mutation",
                            "isSingle": false,
                            "isNullable": true
                          }
                        },
                        "isNullable": true
                      },
                      "on_person": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "selection": {
                            "metaType": "composition",
                            "value": [
                              {
                                "metaType": "object",
                                "isSingle": true,
                                "value": {
                                  "from_person_same_location_graph_node": {
                                    "metaType": "object",
                                    "value": {},
                                    "isSingle": true,
                                    "isNullable": true,
                                    "attributes": {
                                      "metaType": "object",
                                      "value": {
                                        "value": {
                                          "metaType": "primitive",
                                          "value": "xs:boolean",
                                          "isNullable": false
                                        }
                                      },
                                      "isNullable": false
                                    }
                                  }
                                }
                              },
                              {
                                "metaType": "primitive",
                                "value": "type__person_selection"
                              }
                            ],
                            "isSingle": true,
                            "isNullable": true
                          },
                          "mutations": {
                            "metaType": "object",
                            "isSingle": true,
                            "value": {
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
                        "isNullable": true
                      }
                    },
                    "isNullable": true
                  },
                  "global": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "entry": {
                        "metaType": "composition",
                        "value": [
                          {
                            "metaType": "object",
                            "value": {},
                            "isSingle": true,
                            "isNullable": false,
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
                            }
                          },
                          {
                            "metaType": "primitive",
                            "value": "type__action"
                          }
                        ],
                        "isSingle": false,
                        "isNullable": true
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": true
              },
              "events_rule": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "entry": {
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
                      "when": {
                        "metaType": "reference",
                        "value": "type__trigger",
                        "isSingle": false,
                        "isNullable": false
                      },
                      "then": {
                        "metaType": "object",
                        "isSingle": false,
                        "value": {
                          "select_person": {
                            "metaType": "composition",
                            "value": [
                              {
                                "metaType": "object",
                                "value": {},
                                "isSingle": true,
                                "isNullable": false,
                                "attributes": {
                                  "metaType": "object",
                                  "value": {
                                    "origin": {
                                      "metaType": "union",
                                      "value": [
                                        {
                                          "metaType": "primitive",
                                          "value": "\"target\""
                                        },
                                        {
                                          "metaType": "primitive",
                                          "value": "\"self\""
                                        }
                                      ]
                                    }
                                  }
                                }
                              },
                              {
                                "metaType": "primitive",
                                "value": "type__person_selection"
                              }
                            ],
                            "isSingle": false,
                            "isNullable": true
                          },
                          "property_mutation": {
                            "metaType": "composition",
                            "value": [
                              {
                                "metaType": "object",
                                "value": {},
                                "isSingle": true,
                                "isNullable": false,
                                "attributes": {
                                  "metaType": "object",
                                  "value": {
                                    "property_rule_ref": {
                                      "metaType": "primitive",
                                      "value": "xs:string",
                                      "isNullable": false
                                    }
                                  },
                                  "isNullable": false
                                }
                              },
                              {
                                "metaType": "primitive",
                                "value": "type__math_operations"
                              }
                            ],
                            "isSingle": true,
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
              "link_group_rule_list": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "link_group_rule": {
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
                        "value": "type__link_group"
                      }
                    ],
                    "isSingle": false,
                    "isNullable": true
                  }
                },
                "isNullable": true
              },
              "location_graph_rule": {
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
                "isSingle": true,
                "value": {
                  "setup": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "starting_node": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": false,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "node_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        }
                      },
                      "necessary_node": {
                        "metaType": "object",
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "node_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            },
                            "min": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": false
                            },
                            "max": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": true
                            }
                          }
                        },
                        "isSingle": false,
                        "value": {
                          "or": {
                            "metaType": "object",
                            "value": {},
                            "isSingle": false,
                            "isNullable": true,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "node_rule_ref": {
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
                      }
                    },
                    "isNullable": false
                  },
                  "node_rule": {
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
                      "name": {
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
                      "link_group_list": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "reference": {
                            "metaType": "object",
                            "value": {},
                            "isSingle": false,
                            "isNullable": true,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "link_group_rule_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                }
                              },
                              "isNullable": false
                            }
                          },
                          "link_group": {
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
                                "value": "type__link_group"
                              }
                            ],
                            "isSingle": false,
                            "isNullable": true
                          }
                        },
                        "isNullable": true
                      },
                      "existing_person": {
                        "metaType": "object",
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "min": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": false
                            },
                            "max": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": true
                            }
                          }
                        },
                        "isSingle": true,
                        "value": {
                          "person_selection": {
                            "metaType": "reference",
                            "value": "type__person_selection",
                            "isSingle": true,
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
              },
              "location_classification_rule": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "entry": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": false,
                    "isNullable": false,
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
                    }
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "data": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "people": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "person": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "id": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "name": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": true
                        }
                      }
                    },
                    "isSingle": false,
                    "value": {
                      "properties": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "property": {
                            "metaType": "object",
                            "value": {},
                            "isSingle": false,
                            "isNullable": true,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "property_rule_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                },
                                "value": {
                                  "metaType": "primitive",
                                  "value": "xs:int",
                                  "isNullable": false
                                }
                              }
                            }
                          }
                        },
                        "isNullable": true
                      },
                      "relations": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "with": {
                              "metaType": "unknown",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
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
                                "classification_rule_ref": {
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
                      }
                    },
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
                                },
                                "isSingle": false,
                                "value": {
                                  "people": {
                                    "metaType": "object",
                                    "isSingle": true,
                                    "value": {
                                      "person": {
                                        "metaType": "object",
                                        "value": {},
                                        "isSingle": false,
                                        "isNullable": true,
                                        "attributes": {
                                          "metaType": "object",
                                          "value": {
                                            "person_id_ref": {
                                              "metaType": "primitive",
                                              "value": "xs:string",
                                              "isNullable": false
                                            },
                                            "accumulated_progress": {
                                              "metaType": "primitive",
                                              "value": "xs:int",
                                              "isNullable": false
                                            }
                                          }
                                        }
                                      }
                                    },
                                    "isNullable": true
                                  },
                                  "person_progress_property": {
                                    "metaType": "reference",
                                    "value": "type__math_operations",
                                    "isSingle": true,
                                    "isNullable": true
                                  }
                                },
                                "isNullable": true
                              }
                            },
                            "isNullable": true
                          },
                          "people": {
                            "metaType": "object",
                            "isSingle": true,
                            "value": {
                              "person": {
                                "metaType": "object",
                                "value": {},
                                "isSingle": false,
                                "isNullable": true,
                                "attributes": {
                                  "metaType": "object",
                                  "value": {
                                    "person_id_ref": {
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
          },
          "actions": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "by": {
                "metaType": "union",
                "value": [
                  {
                    "metaType": "object",
                    "isSingle": true,
                    "isNullable": false,
                    "value": {
                      "do": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": false,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "action_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": true
                            },
                            "action_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": true
                            },
                            "person_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          }
                        }
                      }
                    }
                  },
                  {
                    "metaType": "object",
                    "isSingle": true,
                    "isNullable": true,
                    "value": {
                      "move_towards": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "layer": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": true
                            },
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
                      }
                    }
                  }
                ],
                "isSingle": false,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "person_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isNullable": true
              },
              "location_graph.create": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": true,
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
              "location_graph.node.create_adjacent": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "location_graph_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "node_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  }
                }
              },
              "location_graph.node.add_classification": {
                "metaType": "object",
                "isSingle": false,
                "value": {
                  "node_graph_selection": {
                    "metaType": "reference",
                    "value": "type__node_graph__selection",
                    "isSingle": true,
                    "isNullable": false
                  },
                  "to_be_added__classification": {
                    "metaType": "object",
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
                    },
                    "isSingle": true,
                    "value": {
                      "and": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
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
                    "isNullable": false
                  }
                },
                "isNullable": true
              },
              "person.teleport": {
                "metaType": "union",
                "value": [
                  {
                    "metaType": "object",
                    "isSingle": true,
                    "isNullable": true,
                    "value": {
                      "location_graph": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "location_graph_id_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            },
                            "node_id_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          }
                        }
                      }
                    }
                  },
                  {
                    "metaType": "object",
                    "isSingle": true,
                    "isNullable": true,
                    "value": {
                      "link_to": {
                        "metaType": "object",
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "accumulated_progress": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        },
                        "isSingle": true,
                        "value": {
                          "selection": {
                            "metaType": "reference",
                            "value": "type__link_to__selection",
                            "isSingle": true,
                            "isNullable": false
                          }
                        },
                        "isNullable": true
                      }
                    }
                  }
                ],
                "isSingle": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "person_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isNullable": true
              },
              "person.on_person.property_mutation": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "person_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "target_person_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "action_property_mutation_rule_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  }
                }
              },
              "person.create": {
                "metaType": "object",
                "isSingle": false,
                "value": {
                  "node_graph__selection": {
                    "metaType": "reference",
                    "value": "type__node_graph__selection",
                    "isSingle": true,
                    "isNullable": false
                  },
                  "person__selection": {
                    "metaType": "reference",
                    "value": "type__person_selection",
                    "isSingle": true,
                    "isNullable": false
                  }
                },
                "isNullable": true
              },
              "person.move_to": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "person_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "find_path_towards": {
                    "metaType": "reference",
                    "value": "type__node_graph__selection",
                    "isSingle": true,
                    "isNullable": true
                  },
                  "path": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "node": {
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
                            }
                          },
                          "isNullable": false
                        }
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": true
              },
              "from_person": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "person_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "from_person_rule_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  }
                },
                "isSingle": false,
                "value": {
                  "on_person": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "person_id_ref": {
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
              }
            },
            "isNullable": true
          }
        },
        "isNullable": false
      },
      "typeDeclaration": {
        "name": "world_step",
        "type": "element",
        "isSingle": true,
        "isNullable": false,
        "value": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "world_metadata": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "previous_world_step": {
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
                        "isNullable": true
                      }
                    },
                    "isNullable": true
                  }
                },
                "next_world_step": {
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
                        "isNullable": true
                      }
                    },
                    "isNullable": true
                  }
                },
                "elapsed_time": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
                  "isNullable": false,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "value": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  }
                },
                "stepDuration": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
                  "isNullable": false,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "value": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  }
                },
                "counter": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
                  "isNullable": false,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "value": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  }
                },
                "randomization_table": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "entry": {
                      "metaType": "object",
                      "value": {},
                      "isSingle": false,
                      "isNullable": false,
                      "attributes": {
                        "metaType": "object",
                        "value": {
                          "value": {
                            "metaType": "primitive",
                            "value": "xs:int",
                            "isNullable": false
                          }
                        },
                        "isNullable": false
                      }
                    }
                  },
                  "isNullable": false
                }
              },
              "isNullable": true
            },
            "rule_group": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "id": {
                    "metaType": "unknown",
                    "isNullable": false
                  }
                },
                "isNullable": false
              },
              "isSingle": false,
              "value": {
                "property_rule": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "entry": {
                      "metaType": "object",
                      "attributes": {
                        "metaType": "object",
                        "value": {
                          "id": {
                            "metaType": "primitive",
                            "value": "xs:string",
                            "isNullable": false
                          },
                          "units": {
                            "metaType": "primitive",
                            "value": "xs:string",
                            "isNullable": false
                          }
                        }
                      },
                      "isSingle": false,
                      "value": {
                        "person_default": {
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
                              "value": "type__math_operations"
                            }
                          ],
                          "isSingle": true,
                          "isNullable": true
                        },
                        "item_default": {
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
                              "value": "type__math_operations"
                            }
                          ],
                          "isSingle": true,
                          "isNullable": true
                        },
                        "property-threshold": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": false,
                          "isNullable": true,
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "name": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": false
                              },
                              "min-value-inclusive": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": true
                              },
                              "max-value-inclusive": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": true
                              }
                            }
                          }
                        }
                      },
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                },
                "classification_rule": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "entry": {
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
                        "property": {
                          "metaType": "object",
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "property_rule_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": false
                              },
                              "is": {
                                "metaType": "union",
                                "value": [
                                  {
                                    "metaType": "primitive",
                                    "value": "\"lessThan\""
                                  },
                                  {
                                    "metaType": "primitive",
                                    "value": "\"lessThanOrEqual\""
                                  },
                                  {
                                    "metaType": "primitive",
                                    "value": "\"greaterThan\""
                                  },
                                  {
                                    "metaType": "primitive",
                                    "value": "\"greaterThanOrEqual\""
                                  },
                                  {
                                    "metaType": "primitive",
                                    "value": "\"equal\""
                                  }
                                ]
                              }
                            }
                          },
                          "isSingle": false,
                          "value": {
                            "operation": {
                              "metaType": "reference",
                              "value": "type__math_operations",
                              "isSingle": true,
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
                },
                "name_rule": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "entry": {
                      "metaType": "composition",
                      "value": [
                        {
                          "metaType": "object",
                          "value": {},
                          "isSingle": true,
                          "isNullable": false,
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
                          }
                        },
                        {
                          "metaType": "primitive",
                          "value": "type__name_token"
                        }
                      ],
                      "isSingle": false,
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                },
                "action_rule": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "from_person": {
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
                        "selection": {
                          "metaType": "reference",
                          "value": "type__person_selection",
                          "isSingle": true,
                          "isNullable": true
                        },
                        "mutations": {
                          "metaType": "object",
                          "isSingle": true,
                          "value": {
                            "property_mutation": {
                              "metaType": "reference",
                              "value": "type__property_mutation",
                              "isSingle": false,
                              "isNullable": true
                            }
                          },
                          "isNullable": true
                        },
                        "on_person": {
                          "metaType": "object",
                          "isSingle": true,
                          "value": {
                            "selection": {
                              "metaType": "composition",
                              "value": [
                                {
                                  "metaType": "object",
                                  "isSingle": true,
                                  "value": {
                                    "from_person_same_location_graph_node": {
                                      "metaType": "object",
                                      "value": {},
                                      "isSingle": true,
                                      "isNullable": true,
                                      "attributes": {
                                        "metaType": "object",
                                        "value": {
                                          "value": {
                                            "metaType": "primitive",
                                            "value": "xs:boolean",
                                            "isNullable": false
                                          }
                                        },
                                        "isNullable": false
                                      }
                                    }
                                  }
                                },
                                {
                                  "metaType": "primitive",
                                  "value": "type__person_selection"
                                }
                              ],
                              "isSingle": true,
                              "isNullable": true
                            },
                            "mutations": {
                              "metaType": "object",
                              "isSingle": true,
                              "value": {
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
                          "isNullable": true
                        }
                      },
                      "isNullable": true
                    },
                    "global": {
                      "metaType": "object",
                      "isSingle": true,
                      "value": {
                        "entry": {
                          "metaType": "composition",
                          "value": [
                            {
                              "metaType": "object",
                              "value": {},
                              "isSingle": true,
                              "isNullable": false,
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
                              }
                            },
                            {
                              "metaType": "primitive",
                              "value": "type__action"
                            }
                          ],
                          "isSingle": false,
                          "isNullable": true
                        }
                      },
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                },
                "events_rule": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "entry": {
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
                        "when": {
                          "metaType": "reference",
                          "value": "type__trigger",
                          "isSingle": false,
                          "isNullable": false
                        },
                        "then": {
                          "metaType": "object",
                          "isSingle": false,
                          "value": {
                            "select_person": {
                              "metaType": "composition",
                              "value": [
                                {
                                  "metaType": "object",
                                  "value": {},
                                  "isSingle": true,
                                  "isNullable": false,
                                  "attributes": {
                                    "metaType": "object",
                                    "value": {
                                      "origin": {
                                        "metaType": "union",
                                        "value": [
                                          {
                                            "metaType": "primitive",
                                            "value": "\"target\""
                                          },
                                          {
                                            "metaType": "primitive",
                                            "value": "\"self\""
                                          }
                                        ]
                                      }
                                    }
                                  }
                                },
                                {
                                  "metaType": "primitive",
                                  "value": "type__person_selection"
                                }
                              ],
                              "isSingle": false,
                              "isNullable": true
                            },
                            "property_mutation": {
                              "metaType": "composition",
                              "value": [
                                {
                                  "metaType": "object",
                                  "value": {},
                                  "isSingle": true,
                                  "isNullable": false,
                                  "attributes": {
                                    "metaType": "object",
                                    "value": {
                                      "property_rule_ref": {
                                        "metaType": "primitive",
                                        "value": "xs:string",
                                        "isNullable": false
                                      }
                                    },
                                    "isNullable": false
                                  }
                                },
                                {
                                  "metaType": "primitive",
                                  "value": "type__math_operations"
                                }
                              ],
                              "isSingle": true,
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
                "link_group_rule_list": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "link_group_rule": {
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
                          "value": "type__link_group"
                        }
                      ],
                      "isSingle": false,
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                },
                "location_graph_rule": {
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
                  "isSingle": true,
                  "value": {
                    "setup": {
                      "metaType": "object",
                      "isSingle": true,
                      "value": {
                        "starting_node": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": true,
                          "isNullable": false,
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "node_rule_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": false
                              }
                            },
                            "isNullable": false
                          }
                        },
                        "necessary_node": {
                          "metaType": "object",
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "node_rule_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": false
                              },
                              "min": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": false
                              },
                              "max": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": true
                              }
                            }
                          },
                          "isSingle": false,
                          "value": {
                            "or": {
                              "metaType": "object",
                              "value": {},
                              "isSingle": false,
                              "isNullable": true,
                              "attributes": {
                                "metaType": "object",
                                "value": {
                                  "node_rule_ref": {
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
                        }
                      },
                      "isNullable": false
                    },
                    "node_rule": {
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
                        "name": {
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
                        "link_group_list": {
                          "metaType": "object",
                          "isSingle": true,
                          "value": {
                            "reference": {
                              "metaType": "object",
                              "value": {},
                              "isSingle": false,
                              "isNullable": true,
                              "attributes": {
                                "metaType": "object",
                                "value": {
                                  "link_group_rule_ref": {
                                    "metaType": "primitive",
                                    "value": "xs:string",
                                    "isNullable": false
                                  }
                                },
                                "isNullable": false
                              }
                            },
                            "link_group": {
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
                                  "value": "type__link_group"
                                }
                              ],
                              "isSingle": false,
                              "isNullable": true
                            }
                          },
                          "isNullable": true
                        },
                        "existing_person": {
                          "metaType": "object",
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "min": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": false
                              },
                              "max": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": true
                              }
                            }
                          },
                          "isSingle": true,
                          "value": {
                            "person_selection": {
                              "metaType": "reference",
                              "value": "type__person_selection",
                              "isSingle": true,
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
                },
                "location_classification_rule": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "entry": {
                      "metaType": "object",
                      "value": {},
                      "isSingle": false,
                      "isNullable": false,
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
                      }
                    }
                  },
                  "isNullable": true
                }
              },
              "isNullable": true
            },
            "data": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "people": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "person": {
                      "metaType": "object",
                      "attributes": {
                        "metaType": "object",
                        "value": {
                          "id": {
                            "metaType": "primitive",
                            "value": "xs:string",
                            "isNullable": false
                          },
                          "name": {
                            "metaType": "primitive",
                            "value": "xs:string",
                            "isNullable": true
                          }
                        }
                      },
                      "isSingle": false,
                      "value": {
                        "properties": {
                          "metaType": "object",
                          "isSingle": true,
                          "value": {
                            "property": {
                              "metaType": "object",
                              "value": {},
                              "isSingle": false,
                              "isNullable": true,
                              "attributes": {
                                "metaType": "object",
                                "value": {
                                  "property_rule_ref": {
                                    "metaType": "primitive",
                                    "value": "xs:string",
                                    "isNullable": false
                                  },
                                  "value": {
                                    "metaType": "primitive",
                                    "value": "xs:int",
                                    "isNullable": false
                                  }
                                }
                              }
                            }
                          },
                          "isNullable": true
                        },
                        "relations": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": false,
                          "isNullable": true,
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "with": {
                                "metaType": "unknown",
                                "isNullable": false
                              }
                            },
                            "isNullable": false
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
                                  "classification_rule_ref": {
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
                        }
                      },
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
                                  },
                                  "isSingle": false,
                                  "value": {
                                    "people": {
                                      "metaType": "object",
                                      "isSingle": true,
                                      "value": {
                                        "person": {
                                          "metaType": "object",
                                          "value": {},
                                          "isSingle": false,
                                          "isNullable": true,
                                          "attributes": {
                                            "metaType": "object",
                                            "value": {
                                              "person_id_ref": {
                                                "metaType": "primitive",
                                                "value": "xs:string",
                                                "isNullable": false
                                              },
                                              "accumulated_progress": {
                                                "metaType": "primitive",
                                                "value": "xs:int",
                                                "isNullable": false
                                              }
                                            }
                                          }
                                        }
                                      },
                                      "isNullable": true
                                    },
                                    "person_progress_property": {
                                      "metaType": "reference",
                                      "value": "type__math_operations",
                                      "isSingle": true,
                                      "isNullable": true
                                    }
                                  },
                                  "isNullable": true
                                }
                              },
                              "isNullable": true
                            },
                            "people": {
                              "metaType": "object",
                              "isSingle": true,
                              "value": {
                                "person": {
                                  "metaType": "object",
                                  "value": {},
                                  "isSingle": false,
                                  "isNullable": true,
                                  "attributes": {
                                    "metaType": "object",
                                    "value": {
                                      "person_id_ref": {
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
            },
            "actions": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "by": {
                  "metaType": "union",
                  "value": [
                    {
                      "metaType": "object",
                      "isSingle": true,
                      "isNullable": false,
                      "value": {
                        "do": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": true,
                          "isNullable": false,
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "action_rule_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": true
                              },
                              "action_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": true
                              },
                              "person_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": false
                              }
                            }
                          }
                        }
                      }
                    },
                    {
                      "metaType": "object",
                      "isSingle": true,
                      "isNullable": true,
                      "value": {
                        "move_towards": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": true,
                          "isNullable": true,
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "layer": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": true
                              },
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
                        }
                      }
                    }
                  ],
                  "isSingle": false,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "person_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  },
                  "isNullable": true
                },
                "location_graph.create": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": false,
                  "isNullable": true,
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
                "location_graph.node.create_adjacent": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": false,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "location_graph_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "node_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    }
                  }
                },
                "location_graph.node.add_classification": {
                  "metaType": "object",
                  "isSingle": false,
                  "value": {
                    "node_graph_selection": {
                      "metaType": "reference",
                      "value": "type__node_graph__selection",
                      "isSingle": true,
                      "isNullable": false
                    },
                    "to_be_added__classification": {
                      "metaType": "object",
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
                      },
                      "isSingle": true,
                      "value": {
                        "and": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": true,
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
                      "isNullable": false
                    }
                  },
                  "isNullable": true
                },
                "person.teleport": {
                  "metaType": "union",
                  "value": [
                    {
                      "metaType": "object",
                      "isSingle": true,
                      "isNullable": true,
                      "value": {
                        "location_graph": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": true,
                          "isNullable": true,
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "location_graph_id_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": false
                              },
                              "node_id_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": false
                              }
                            }
                          }
                        }
                      }
                    },
                    {
                      "metaType": "object",
                      "isSingle": true,
                      "isNullable": true,
                      "value": {
                        "link_to": {
                          "metaType": "object",
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "accumulated_progress": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": false
                              }
                            },
                            "isNullable": false
                          },
                          "isSingle": true,
                          "value": {
                            "selection": {
                              "metaType": "reference",
                              "value": "type__link_to__selection",
                              "isSingle": true,
                              "isNullable": false
                            }
                          },
                          "isNullable": true
                        }
                      }
                    }
                  ],
                  "isSingle": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "person_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  },
                  "isNullable": true
                },
                "person.on_person.property_mutation": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": false,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "person_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "target_person_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "action_property_mutation_rule_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    }
                  }
                },
                "person.create": {
                  "metaType": "object",
                  "isSingle": false,
                  "value": {
                    "node_graph__selection": {
                      "metaType": "reference",
                      "value": "type__node_graph__selection",
                      "isSingle": true,
                      "isNullable": false
                    },
                    "person__selection": {
                      "metaType": "reference",
                      "value": "type__person_selection",
                      "isSingle": true,
                      "isNullable": false
                    }
                  },
                  "isNullable": true
                },
                "person.move_to": {
                  "metaType": "object",
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "person_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  },
                  "isSingle": false,
                  "value": {
                    "find_path_towards": {
                      "metaType": "reference",
                      "value": "type__node_graph__selection",
                      "isSingle": true,
                      "isNullable": true
                    },
                    "path": {
                      "metaType": "object",
                      "isSingle": true,
                      "value": {
                        "node": {
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
                              }
                            },
                            "isNullable": false
                          }
                        }
                      },
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                },
                "from_person": {
                  "metaType": "object",
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "person_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "from_person_rule_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    }
                  },
                  "isSingle": false,
                  "value": {
                    "on_person": {
                      "metaType": "object",
                      "value": {},
                      "isSingle": true,
                      "isNullable": false,
                      "attributes": {
                        "metaType": "object",
                        "value": {
                          "person_id_ref": {
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
                }
              },
              "isNullable": true
            }
          },
          "isNullable": false
        }
      },
      "name": "world_step"
    }
  */