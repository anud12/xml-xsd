package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule;
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
  public class NodeRule implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static NodeRule fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new NodeRule();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static NodeRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<NodeRule> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> NodeRule.fromRawNode(o, parent)));
    }
    public static List<NodeRule> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<NodeRule> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> NodeRule.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String id;

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name> name = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications> classifications = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList> linkGroupList = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson> existingPerson = Optional.empty();

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
    private List<Consumer<NodeRule>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "node_rule";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name) {
          this.name = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications) {
          this.classifications = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList) {
          this.linkGroupList = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson) {
          this.existingPerson = Optional.empty();
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<NodeRule> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing node_rule");
      //Deserialize arguments
      this.id = rawNode.getAttributeRequired("id");

      //Deserialize children
      this.name = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name.fromRawNode(rawNode.getChildrenFirst("name"), this);
      this.classifications = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications.fromRawNode(rawNode.getChildrenFirst("classifications"), this);
      this.linkGroupList = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList.fromRawNode(rawNode.getChildrenFirst("link_group_list"), this);
      this.existingPerson = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson.fromRawNode(rawNode.getChildrenFirst("existing_person"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("id", this.id);

      //Serialize children
      rawNode.setChildren("name", name.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name::serializeIntoRawNode).toList());
      rawNode.setChildren("classifications", classifications.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications::serializeIntoRawNode).toList());
      rawNode.setChildren("link_group_list", linkGroupList.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList::serializeIntoRawNode).toList());
      rawNode.setChildren("existing_person", existingPerson.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing node_rule");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public NodeRule setId(String value)
    {
      this.id = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name> getName()
    {
      return this.name;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name getNameOrDefault()
    {
      return this.name.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name();
        instance.setParentNode(this);
        this.name = Optional.of(instance);
        return this.name.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name> streamName()
    {
      return name.stream();
    }
    public NodeRule setName(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name value)
    {
      this.name = Optional.ofNullable(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications> getClassifications()
    {
      return this.classifications;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications getClassificationsOrDefault()
    {
      return this.classifications.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications();
        instance.setParentNode(this);
        this.classifications = Optional.of(instance);
        return this.classifications.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications> streamClassifications()
    {
      return classifications.stream();
    }
    public NodeRule setClassifications(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications value)
    {
      this.classifications = Optional.ofNullable(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList> getLinkGroupList()
    {
      return this.linkGroupList;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList getLinkGroupListOrDefault()
    {
      return this.linkGroupList.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList();
        instance.setParentNode(this);
        this.linkGroupList = Optional.of(instance);
        return this.linkGroupList.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList> streamLinkGroupList()
    {
      return linkGroupList.stream();
    }
    public NodeRule setLinkGroupList(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList value)
    {
      this.linkGroupList = Optional.ofNullable(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson> getExistingPerson()
    {
      return this.existingPerson;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson getExistingPersonOrDefault()
    {
      return this.existingPerson.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson();
        instance.setParentNode(this);
        this.existingPerson = Optional.of(instance);
        return this.existingPerson.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson> streamExistingPerson()
    {
      return existingPerson.stream();
    }
    public NodeRule setExistingPerson(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson value)
    {
      this.existingPerson = Optional.ofNullable(value);
      value.setParentNode(this);
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
      },
      "name": "node_rule"
    }
  */