package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule;
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
  public class NodeRule implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static NodeRule fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new NodeRule();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static NodeRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
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

    public String classTypeId() {
      return "/world_step/rule_group/location_graph_rule/node_rule";
    }

    //Attributes

    private String id;

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name> name = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications> classifications = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList> linkGroupList = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson> existingPerson = Optional.empty();

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
      return "node_rule";
    }

    public void childChanged(List<Object> list) {
      list.addLast(this);
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(list));
    }

    private void triggerOnChange() {
      childChanged(new ArrayList<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> parentAsLocationGraphRule() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
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

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson) {
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
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing node_rule");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("id");
      this.id = rawNode.getAttributeRequired("id");
      innerLogger = logger.log("children");
      //Deserialize children
      this.name = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name.fromRawNode(rawNode.getChildrenFirst("name"), this);
      this.classifications = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications.fromRawNode(rawNode.getChildrenFirst("classifications"), this);
      this.linkGroupList = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList.fromRawNode(rawNode.getChildrenFirst("link_group_list"), this);
      this.existingPerson = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson.fromRawNode(rawNode.getChildrenFirst("existing_person"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("node_rule");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("name");
      rawNode.setChildren("name", name.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name::serializeIntoRawNode).toList());
      innerLogger.log("classifications");
      rawNode.setChildren("classifications", classifications.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications::serializeIntoRawNode).toList());
      innerLogger.log("link_group_list");
      rawNode.setChildren("link_group_list", linkGroupList.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList::serializeIntoRawNode).toList());
      innerLogger.log("existing_person");
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
      triggerOnChange();
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
        this.name = Optional.of(instance);
        instance.parentNode(this);
        return this.name.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name> streamNameOrDefault()
    {
      return java.util.stream.Stream.of(getNameOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name> streamName()
    {
      return name.stream();
    }
    public NodeRule setName(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name value)
    {
      this.name = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
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
        this.classifications = Optional.of(instance);
        instance.parentNode(this);
        return this.classifications.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications> streamClassificationsOrDefault()
    {
      return java.util.stream.Stream.of(getClassificationsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications> streamClassifications()
    {
      return classifications.stream();
    }
    public NodeRule setClassifications(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications value)
    {
      this.classifications = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
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
        this.linkGroupList = Optional.of(instance);
        instance.parentNode(this);
        return this.linkGroupList.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList> streamLinkGroupListOrDefault()
    {
      return java.util.stream.Stream.of(getLinkGroupListOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList> streamLinkGroupList()
    {
      return linkGroupList.stream();
    }
    public NodeRule setLinkGroupList(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList value)
    {
      this.linkGroupList = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
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
        this.existingPerson = Optional.of(instance);
        instance.parentNode(this);
        return this.existingPerson.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson> streamExistingPersonOrDefault()
    {
      return java.util.stream.Stream.of(getExistingPersonOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson> streamExistingPerson()
    {
      return existingPerson.stream();
    }
    public NodeRule setExistingPerson(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson.ExistingPerson value)
    {
      this.existingPerson = Optional.ofNullable(value);
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
      },
      "name": "node_rule"
    }
  */