package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup;
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
  public class RuleGroup  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<RuleGroup>> onChangeList = new ArrayList<>();

    public static RuleGroup fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new RuleGroup();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<RuleGroup> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(RuleGroup::fromRawNode));
    }
    public static List<RuleGroup> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<RuleGroup> returnList = rawNodeList.stream().map(RuleGroup::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<RuleGroup> onChange) {
      onChangeList.add(onChange);
      return () -> onChangeList.remove(onChange);
    }

    //Attributes
    /* ignored attribute key={key} of type=Object*/

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule> propertyRule = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> classificationRule = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> nameRule = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.RaceRule> raceRule = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule> actionRule = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule> eventsRule = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> linkGroupRuleList = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> locationGraphRule = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> locationClassificationRule = Optional.empty();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing rule_group");
      //Deserialize arguments

      //Deserialize children
      this.propertyRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule.fromRawNode(rawNode.getChildrenFirst("property_rule"));
      this.classificationRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule.fromRawNode(rawNode.getChildrenFirst("classification_rule"));
      this.nameRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule.fromRawNode(rawNode.getChildrenFirst("name_rule"));
      this.raceRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.RaceRule.fromRawNode(rawNode.getChildrenFirst("race_rule"));
      this.actionRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule.fromRawNode(rawNode.getChildrenFirst("action_rule"));
      this.eventsRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule.fromRawNode(rawNode.getChildrenFirst("events_rule"));
      this.linkGroupRuleList = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList.fromRawNode(rawNode.getChildrenFirst("link_group_rule_list"));
      this.locationGraphRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule.fromRawNode(rawNode.getChildrenFirst("location_graph_rule"));
      this.locationClassificationRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule.fromRawNode(rawNode.getChildrenFirst("location_classification_rule"));
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("property_rule", propertyRule);
      rawNode.addChildren("classification_rule", classificationRule);
      rawNode.addChildren("name_rule", nameRule);
      rawNode.addChildren("race_rule", raceRule);
      rawNode.addChildren("action_rule", actionRule);
      rawNode.addChildren("events_rule", eventsRule);
      rawNode.addChildren("link_group_rule_list", linkGroupRuleList);
      rawNode.addChildren("location_graph_rule", locationGraphRule);
      rawNode.addChildren("location_classification_rule", locationClassificationRule);
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing rule_group");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    /* ignored attribute key={key} of type=Object*/
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule> getPropertyRule()
    {
      return this.propertyRule;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule> GetOrInsertDefault_PropertyRule()
    {
      if(this.propertyRule == null) {
        this.propertyRule = Optional.empty();
      }
      return this.propertyRule;
    }
    */
    public RuleGroup setPropertyRule(Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule> value)
    {
      this.propertyRule = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> getClassificationRule()
    {
      return this.classificationRule;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> GetOrInsertDefault_ClassificationRule()
    {
      if(this.classificationRule == null) {
        this.classificationRule = Optional.empty();
      }
      return this.classificationRule;
    }
    */
    public RuleGroup setClassificationRule(Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> value)
    {
      this.classificationRule = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> getNameRule()
    {
      return this.nameRule;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> GetOrInsertDefault_NameRule()
    {
      if(this.nameRule == null) {
        this.nameRule = Optional.empty();
      }
      return this.nameRule;
    }
    */
    public RuleGroup setNameRule(Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> value)
    {
      this.nameRule = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.RaceRule> getRaceRule()
    {
      return this.raceRule;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.RaceRule> GetOrInsertDefault_RaceRule()
    {
      if(this.raceRule == null) {
        this.raceRule = Optional.empty();
      }
      return this.raceRule;
    }
    */
    public RuleGroup setRaceRule(Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.RaceRule> value)
    {
      this.raceRule = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule> getActionRule()
    {
      return this.actionRule;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule> GetOrInsertDefault_ActionRule()
    {
      if(this.actionRule == null) {
        this.actionRule = Optional.empty();
      }
      return this.actionRule;
    }
    */
    public RuleGroup setActionRule(Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule> value)
    {
      this.actionRule = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule> getEventsRule()
    {
      return this.eventsRule;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule> GetOrInsertDefault_EventsRule()
    {
      if(this.eventsRule == null) {
        this.eventsRule = Optional.empty();
      }
      return this.eventsRule;
    }
    */
    public RuleGroup setEventsRule(Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule> value)
    {
      this.eventsRule = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> getLinkGroupRuleList()
    {
      return this.linkGroupRuleList;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> GetOrInsertDefault_LinkGroupRuleList()
    {
      if(this.linkGroupRuleList == null) {
        this.linkGroupRuleList = Optional.empty();
      }
      return this.linkGroupRuleList;
    }
    */
    public RuleGroup setLinkGroupRuleList(Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> value)
    {
      this.linkGroupRuleList = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> getLocationGraphRule()
    {
      return this.locationGraphRule;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> GetOrInsertDefault_LocationGraphRule()
    {
      if(this.locationGraphRule == null) {
        this.locationGraphRule = Optional.empty();
      }
      return this.locationGraphRule;
    }
    */
    public RuleGroup setLocationGraphRule(Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> value)
    {
      this.locationGraphRule = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> getLocationClassificationRule()
    {
      return this.locationClassificationRule;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> GetOrInsertDefault_LocationClassificationRule()
    {
      if(this.locationClassificationRule == null) {
        this.locationClassificationRule = Optional.empty();
      }
      return this.locationClassificationRule;
    }
    */
    public RuleGroup setLocationClassificationRule(Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> value)
    {
      this.locationClassificationRule = value;
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
                      "metaType": "unknown",
                      "isNullable": false
                    },
                    "units": {
                      "metaType": "unknown",
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
                      "metaType": "unknown",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "property": {
                    "metaType": "reference",
                    "value": "group__math_operations",
                    "isSingle": false,
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
                "metaType": "reference",
                "value": "group__name_token",
                "isSingle": false,
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
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "race_rule": {
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
                  "vision": {
                    "metaType": "reference",
                    "value": "type_range",
                    "isSingle": true,
                    "isNullable": true
                  },
                  "movement": {
                    "metaType": "reference",
                    "value": "type_range",
                    "isSingle": true,
                    "isNullable": true
                  },
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
                  "property_bonus": {
                    "metaType": "reference",
                    "value": "group__math_operations",
                    "isSingle": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "property_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": true
                        }
                      },
                      "isNullable": true
                    },
                    "isNullable": true
                  },
                  "icon": {
                    "metaType": "reference",
                    "value": "type_icon",
                    "isSingle": true,
                    "isNullable": true
                  }
                },
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
              },
              "person_to_person": {
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
                  "test": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "value": {
                        "metaType": "reference",
                        "value": "group__math_operations",
                        "isSingle": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "target": {
                              "metaType": "primitive",
                              "value": "type_person_select",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        },
                        "isNullable": false
                      },
                      "expected": {
                        "metaType": "reference",
                        "value": "group__math_operations",
                        "isSingle": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "target": {
                              "metaType": "primitive",
                              "value": "type_person_select",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        },
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  },
                  "property_mutation": {
                    "metaType": "reference",
                    "value": "type__property_mutation_on",
                    "isSingle": true,
                    "isNullable": true
                  },
                  "location_mutation": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "name": {
                          "metaType": "unknown",
                          "isNullable": true
                        },
                        "on": {
                          "metaType": "primitive",
                          "value": "type_person_select",
                          "isNullable": false
                        }
                      }
                    },
                    "isSingle": true,
                    "value": {
                      "from": {
                        "metaType": "reference",
                        "value": "group__math_operations",
                        "isSingle": false,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "participant": {
                              "metaType": "primitive",
                              "value": "type_person_select",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
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
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "angle": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": false
                    },
                    "angleMax": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": true
                    },
                    "limit": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": true
                    }
                  }
                },
                "isSingle": false,
                "value": {
                  "to_option": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "node_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "distance": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        },
                        "maxDistance": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": true
                        },
                        "adjacent_depth_limit": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        }
                      }
                    },
                    "isSingle": false,
                    "value": {
                      "distance_to_progress_multiplier": {
                        "metaType": "reference",
                        "value": "type__math_operations",
                        "isSingle": true,
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
                        "metaType": "object",
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "id": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            },
                            "angle": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": false
                            },
                            "angleMax": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": true
                            },
                            "limit": {
                              "metaType": "primitive",
                              "value": "xs:int",
                              "isNullable": true
                            }
                          }
                        },
                        "isSingle": false,
                        "value": {
                          "to_option": {
                            "metaType": "object",
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "node_rule_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                },
                                "distance": {
                                  "metaType": "primitive",
                                  "value": "xs:int",
                                  "isNullable": false
                                },
                                "maxDistance": {
                                  "metaType": "primitive",
                                  "value": "xs:int",
                                  "isNullable": true
                                },
                                "adjacent_depth_limit": {
                                  "metaType": "primitive",
                                  "value": "xs:int",
                                  "isNullable": false
                                }
                              }
                            },
                            "isSingle": false,
                            "value": {
                              "distance_to_progress_multiplier": {
                                "metaType": "reference",
                                "value": "type__math_operations",
                                "isSingle": true,
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
        "isNullable": false
      },
      "name": "rule_group",
      "parentType": {
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
                            "isNullable": true
                          }
                        },
                        "isNullable": true
                      }
                    }
                  },
                  "isNullable": false
                }
              },
              "isNullable": false
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
                            "metaType": "unknown",
                            "isNullable": false
                          },
                          "units": {
                            "metaType": "unknown",
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
                            "metaType": "unknown",
                            "isNullable": false
                          }
                        },
                        "isNullable": false
                      },
                      "isSingle": false,
                      "value": {
                        "property": {
                          "metaType": "reference",
                          "value": "group__math_operations",
                          "isSingle": false,
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
                      "metaType": "reference",
                      "value": "group__name_token",
                      "isSingle": false,
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
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                },
                "race_rule": {
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
                        "vision": {
                          "metaType": "reference",
                          "value": "type_range",
                          "isSingle": true,
                          "isNullable": true
                        },
                        "movement": {
                          "metaType": "reference",
                          "value": "type_range",
                          "isSingle": true,
                          "isNullable": true
                        },
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
                        "property_bonus": {
                          "metaType": "reference",
                          "value": "group__math_operations",
                          "isSingle": false,
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "property_rule_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": true
                              }
                            },
                            "isNullable": true
                          },
                          "isNullable": true
                        },
                        "icon": {
                          "metaType": "reference",
                          "value": "type_icon",
                          "isSingle": true,
                          "isNullable": true
                        }
                      },
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
                    },
                    "person_to_person": {
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
                        "test": {
                          "metaType": "object",
                          "isSingle": true,
                          "value": {
                            "value": {
                              "metaType": "reference",
                              "value": "group__math_operations",
                              "isSingle": true,
                              "attributes": {
                                "metaType": "object",
                                "value": {
                                  "target": {
                                    "metaType": "primitive",
                                    "value": "type_person_select",
                                    "isNullable": false
                                  }
                                },
                                "isNullable": false
                              },
                              "isNullable": false
                            },
                            "expected": {
                              "metaType": "reference",
                              "value": "group__math_operations",
                              "isSingle": true,
                              "attributes": {
                                "metaType": "object",
                                "value": {
                                  "target": {
                                    "metaType": "primitive",
                                    "value": "type_person_select",
                                    "isNullable": false
                                  }
                                },
                                "isNullable": false
                              },
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        },
                        "property_mutation": {
                          "metaType": "reference",
                          "value": "type__property_mutation_on",
                          "isSingle": true,
                          "isNullable": true
                        },
                        "location_mutation": {
                          "metaType": "object",
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "name": {
                                "metaType": "unknown",
                                "isNullable": true
                              },
                              "on": {
                                "metaType": "primitive",
                                "value": "type_person_select",
                                "isNullable": false
                              }
                            }
                          },
                          "isSingle": true,
                          "value": {
                            "from": {
                              "metaType": "reference",
                              "value": "group__math_operations",
                              "isSingle": false,
                              "attributes": {
                                "metaType": "object",
                                "value": {
                                  "participant": {
                                    "metaType": "primitive",
                                    "value": "type_person_select",
                                    "isNullable": false
                                  }
                                },
                                "isNullable": false
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
                      "metaType": "object",
                      "attributes": {
                        "metaType": "object",
                        "value": {
                          "id": {
                            "metaType": "primitive",
                            "value": "xs:string",
                            "isNullable": false
                          },
                          "angle": {
                            "metaType": "primitive",
                            "value": "xs:int",
                            "isNullable": false
                          },
                          "angleMax": {
                            "metaType": "primitive",
                            "value": "xs:int",
                            "isNullable": true
                          },
                          "limit": {
                            "metaType": "primitive",
                            "value": "xs:int",
                            "isNullable": true
                          }
                        }
                      },
                      "isSingle": false,
                      "value": {
                        "to_option": {
                          "metaType": "object",
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "node_rule_ref": {
                                "metaType": "primitive",
                                "value": "xs:string",
                                "isNullable": false
                              },
                              "distance": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": false
                              },
                              "maxDistance": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": true
                              },
                              "adjacent_depth_limit": {
                                "metaType": "primitive",
                                "value": "xs:int",
                                "isNullable": false
                              }
                            }
                          },
                          "isSingle": false,
                          "value": {
                            "distance_to_progress_multiplier": {
                              "metaType": "reference",
                              "value": "type__math_operations",
                              "isSingle": true,
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
                              "metaType": "object",
                              "attributes": {
                                "metaType": "object",
                                "value": {
                                  "id": {
                                    "metaType": "primitive",
                                    "value": "xs:string",
                                    "isNullable": false
                                  },
                                  "angle": {
                                    "metaType": "primitive",
                                    "value": "xs:int",
                                    "isNullable": false
                                  },
                                  "angleMax": {
                                    "metaType": "primitive",
                                    "value": "xs:int",
                                    "isNullable": true
                                  },
                                  "limit": {
                                    "metaType": "primitive",
                                    "value": "xs:int",
                                    "isNullable": true
                                  }
                                }
                              },
                              "isSingle": false,
                              "value": {
                                "to_option": {
                                  "metaType": "object",
                                  "attributes": {
                                    "metaType": "object",
                                    "value": {
                                      "node_rule_ref": {
                                        "metaType": "primitive",
                                        "value": "xs:string",
                                        "isNullable": false
                                      },
                                      "distance": {
                                        "metaType": "primitive",
                                        "value": "xs:int",
                                        "isNullable": false
                                      },
                                      "maxDistance": {
                                        "metaType": "primitive",
                                        "value": "xs:int",
                                        "isNullable": true
                                      },
                                      "adjacent_depth_limit": {
                                        "metaType": "primitive",
                                        "value": "xs:int",
                                        "isNullable": false
                                      }
                                    }
                                  },
                                  "isSingle": false,
                                  "value": {
                                    "distance_to_progress_multiplier": {
                                      "metaType": "reference",
                                      "value": "type__math_operations",
                                      "isSingle": true,
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
              "isNullable": false
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
                        "race": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": true,
                          "isNullable": true,
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "race_rule_ref": {
                                "metaType": "unknown",
                                "isNullable": false
                              }
                            },
                            "isNullable": false
                          }
                        },
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
                                    "metaType": "unknown",
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
                        },
                        "icon": {
                          "metaType": "reference",
                          "value": "type_icon",
                          "isSingle": true,
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
                            "isNullable": true
                          }
                        },
                        "isNullable": true
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
              "isNullable": false
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
                      "isNullable": false,
                      "value": {
                        "move_towards": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": true,
                          "isNullable": false,
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
                      "isNullable": false,
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
                          "isNullable": false
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
        "name": "world_step"
      }
    }
  */