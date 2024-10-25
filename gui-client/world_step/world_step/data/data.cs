using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class data  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Nworld_step.Ndata.people? people = null;
    public XSD.Nworld_step.Ndata.location? location = null;
    public data()
    {
    }

    public data(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public data(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing data");
      //Deserialize arguments

      //Deserialize children
      this.people = rawNode.InitializeWithRawNode("people", this.people);
      this.location = rawNode.InitializeWithRawNode("location", this.location);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
      }
      if(location != null) {
        rawNode.children["location"] = new List<RawNode> { location.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing data");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Ndata.people? Get_people()
    {
      return this.people;
    }
    public XSD.Nworld_step.Ndata.people GetOrInsertDefault_people()
    {
      if(this.people == null) {
        this.people = new XSD.Nworld_step.Ndata.people();
      }
      return this.people;
    }
    public void Set_people(XSD.Nworld_step.Ndata.people? value)
    {
      this.people = value;
    }
    public XSD.Nworld_step.Ndata.location? Get_location()
    {
      return this.location;
    }
    public XSD.Nworld_step.Ndata.location GetOrInsertDefault_location()
    {
      if(this.location == null) {
        this.location = new XSD.Nworld_step.Ndata.location();
      }
      return this.location;
    }
    public void Set_location(XSD.Nworld_step.Ndata.location? value)
    {
      this.location = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
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
    "name": "data"
  }
*/