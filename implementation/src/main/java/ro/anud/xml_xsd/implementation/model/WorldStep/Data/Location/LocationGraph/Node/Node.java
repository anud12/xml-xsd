package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node;
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
  public class Node implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Node fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Node();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Node fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Node> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Node.fromRawNode(o, parent)));
    }
    public static List<Node> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Node> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Node.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String nodeRuleRef;
    private String id;

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name> name = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position> position = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications> classifications = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links> links = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People> people = Optional.empty();

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
    private List<Consumer<Node>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "node";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name) {
          this.name = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position) {
          this.position = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications) {
          this.classifications = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links) {
          this.links = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People) {
          this.people = Optional.empty();
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Node> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing node");
      //Deserialize arguments
      this.nodeRuleRef = rawNode.getAttributeRequired("node_rule_ref");
      this.id = rawNode.getAttributeRequired("id");

      //Deserialize children
      this.name = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name.fromRawNode(rawNode.getChildrenFirst("name"), this);
      this.position = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position.fromRawNode(rawNode.getChildrenFirst("position"), this);
      this.classifications = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications.fromRawNode(rawNode.getChildrenFirst("classifications"), this);
      this.links = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links.fromRawNode(rawNode.getChildrenFirst("links"), this);
      this.people = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People.fromRawNode(rawNode.getChildrenFirst("people"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("node_rule_ref", this.nodeRuleRef);
      rawNode.setAttribute("id", this.id);

      //Serialize children
      rawNode.setChildren("name", name.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name::serializeIntoRawNode).toList());
      rawNode.setChildren("position", position.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position::serializeIntoRawNode).toList());
      rawNode.setChildren("classifications", classifications.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications::serializeIntoRawNode).toList());
      rawNode.setChildren("links", links.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links::serializeIntoRawNode).toList());
      rawNode.setChildren("people", people.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing node");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getNodeRuleRef()
    {
      return this.nodeRuleRef;
    }
    public Node setNodeRuleRef(String value)
    {
      this.nodeRuleRef = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public String getId()
    {
      return this.id;
    }
    public Node setId(String value)
    {
      this.id = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name> getName()
    {
      return this.name;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name> streamName()
    {
      return name.stream();
    }
    public Node setName(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name value)
    {
      this.name = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position> getPosition()
    {
      return this.position;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position> streamPosition()
    {
      return position.stream();
    }
    public Node setPosition(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position value)
    {
      this.position = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications> getClassifications()
    {
      return this.classifications;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications> streamClassifications()
    {
      return classifications.stream();
    }
    public Node setClassifications(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications value)
    {
      this.classifications = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links> getLinks()
    {
      return this.links;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links> streamLinks()
    {
      return links.stream();
    }
    public Node setLinks(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links value)
    {
      this.links = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People> getPeople()
    {
      return this.people;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People> streamPeople()
    {
      return people.stream();
    }
    public Node setPeople(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People value)
    {
      this.people = Optional.ofNullable(value);
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
      },
      "name": "node"
    }
  */