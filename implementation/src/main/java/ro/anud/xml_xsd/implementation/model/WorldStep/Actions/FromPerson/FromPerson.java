package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson;
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
  public class FromPerson  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<FromPerson>> onChangeList = new ArrayList<>();

    public static FromPerson fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new FromPerson();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<FromPerson> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(FromPerson::fromRawNode));
    }
    public static List<FromPerson> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<FromPerson> returnList = rawNodeList.stream().map(FromPerson::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<FromPerson> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    //Attributes
    private String personIdRef;
    private String fromPersonRuleRef;

    //Children elements
    private ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson onPerson = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person");
      //Deserialize arguments
      this.personIdRef = rawNode.getAttributeRequired("person_id_ref");
      this.fromPersonRuleRef = rawNode.getAttributeRequired("from_person_rule_ref");

      //Deserialize children
      this.onPerson = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson.fromRawNode(rawNode.getChildrenFirst("on_person").get());
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("person_id_ref", this.personIdRef);
      rawNode.setAttribute("from_person_rule_ref", this.fromPersonRuleRef);

      //Serialize children
      rawNode.addChildren("on_person", onPerson);
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing from_person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPersonIdRef()
    {
      return this.personIdRef;
    }
    public FromPerson setPersonIdRef(String value)
    {
      this.personIdRef = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public String getFromPersonRuleRef()
    {
      return this.fromPersonRuleRef;
    }
    public FromPerson setFromPersonRuleRef(String value)
    {
      this.fromPersonRuleRef = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson getOnPerson()
    {
      return this.onPerson;
    }
    /*
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson GetOrInsertDefault_OnPerson()
    {
      if(this.onPerson == null) {
        this.onPerson = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson();
      }
      return this.onPerson;
    }
    */
    public FromPerson setOnPerson(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson value)
    {
      this.onPerson = value;
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
      },
      "name": "from_person",
      "parentType": {
        "type": "element",
        "value": {
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
        },
        "name": "actions",
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
    }
  */