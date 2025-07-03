package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node;
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
  public class Node implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "node";
    public static Node fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new Node();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Node fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
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

    public String classTypeId() {
      return ".world_step.data.location.location_graph.node";
    }

    //Attributes

    private String nodeRuleRef;

    private String id;

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name> name = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position> position = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications> classifications = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links> links = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People> people = Optional.empty();

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
      return "node";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph> parentAsLocationGraph() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name) {
          this.name = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position) {
          this.position = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications) {
          this.classifications = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links) {
          this.links = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People) {
          this.people = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People) {
          return 0;
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
        // Godot.GD.Print("Deserializing node");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger.log("node_rule_ref");
        this.nodeRuleRef = rawNode.getAttributeRequired("node_rule_ref");
        innerLogger.log("id");
        this.id = rawNode.getAttributeRequired("id");
        innerLogger = logger.log("children");
        //Deserialize children
        this.name = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name.fromRawNode(rawNode.getChildrenFirst("name"), this);
        this.position = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position.fromRawNode(rawNode.getChildrenFirst("position"), this);
        this.classifications = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications.fromRawNode(rawNode.getChildrenFirst("classifications"), this);
        this.links = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links.fromRawNode(rawNode.getChildrenFirst("links"), this);
        this.people = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People.fromRawNode(rawNode.getChildrenFirst("people"), this);
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("node");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("node_rule_ref");
      rawNode.setAttribute("node_rule_ref", this.nodeRuleRef);
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("name");
      rawNode.setChildren("name", name.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name::serializeIntoRawNode).toList());
      innerLogger.log("position");
      rawNode.setChildren("position", position.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position::serializeIntoRawNode).toList());
      innerLogger.log("classifications");
      rawNode.setChildren("classifications", classifications.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications::serializeIntoRawNode).toList());
      innerLogger.log("links");
      rawNode.setChildren("links", links.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links::serializeIntoRawNode).toList());
      innerLogger.log("people");
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
      notifyChange();
      return this;
    }
    public String getId()
    {
      return this.id;
    }
    public Node setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name> getName()
    {
      return this.name;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name getNameOrDefault()
    {
      return this.name.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name();
        this.name = Optional.of(instance);
        instance.parentNode(this);
        return this.name.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name> streamNameOrDefault()
    {
      return java.util.stream.Stream.of(getNameOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name> streamName()
    {
      return name.stream();
    }
    public Node setName(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name value)
    {
      this.name = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position> getPosition()
    {
      return this.position;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position getPositionOrDefault()
    {
      return this.position.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position();
        this.position = Optional.of(instance);
        instance.parentNode(this);
        return this.position.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position> streamPositionOrDefault()
    {
      return java.util.stream.Stream.of(getPositionOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position> streamPosition()
    {
      return position.stream();
    }
    public Node setPosition(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position value)
    {
      this.position = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications> getClassifications()
    {
      return this.classifications;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications getClassificationsOrDefault()
    {
      return this.classifications.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications();
        this.classifications = Optional.of(instance);
        instance.parentNode(this);
        return this.classifications.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications> streamClassificationsOrDefault()
    {
      return java.util.stream.Stream.of(getClassificationsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications> streamClassifications()
    {
      return classifications.stream();
    }
    public Node setClassifications(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications value)
    {
      this.classifications = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links> getLinks()
    {
      return this.links;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links getLinksOrDefault()
    {
      return this.links.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links();
        this.links = Optional.of(instance);
        instance.parentNode(this);
        return this.links.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links> streamLinksOrDefault()
    {
      return java.util.stream.Stream.of(getLinksOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links> streamLinks()
    {
      return links.stream();
    }
    public Node setLinks(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links value)
    {
      this.links = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People> getPeople()
    {
      return this.people;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People getPeopleOrDefault()
    {
      return this.people.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People();
        this.people = Optional.of(instance);
        instance.parentNode(this);
        return this.people.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People> streamPeopleOrDefault()
    {
      return java.util.stream.Stream.of(getPeopleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People> streamPeople()
    {
      return people.stream();
    }
    public Node setPeople(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People value)
    {
      this.people = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name.nodeName))
        {
          if(this.name.isEmpty()) {
            this.name = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name.nodeName.length() + 3);
          return this.name.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position.nodeName))
        {
          if(this.position.isEmpty()) {
            this.position = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position.nodeName.length() + 3);
          return this.position.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications.nodeName))
        {
          if(this.classifications.isEmpty()) {
            this.classifications = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications.nodeName.length() + 3);
          return this.classifications.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links.nodeName))
        {
          if(this.links.isEmpty()) {
            this.links = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links.nodeName.length() + 3);
          return this.links.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People.nodeName))
        {
          if(this.people.isEmpty()) {
            this.people = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People.nodeName.length() + 3);
          return this.people.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name.nodeName))
        {
          if(this.name.isEmpty()) {
            this.name = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Name.Name.nodeName.length() + 3);
          return this.name.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position.nodeName))
        {
          if(this.position.isEmpty()) {
            this.position = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position.nodeName.length() + 3);
          return this.position.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications.nodeName))
        {
          if(this.classifications.isEmpty()) {
            this.classifications = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications.nodeName.length() + 3);
          return this.classifications.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links.nodeName))
        {
          if(this.links.isEmpty()) {
            this.links = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links.nodeName.length() + 3);
          return this.links.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People.nodeName))
        {
          if(this.people.isEmpty()) {
            this.people = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People.nodeName.length() + 3);
          return this.people.get().getNodeAtPath(childXPath);
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