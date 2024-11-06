package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList;
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
  public class LinkGroupList implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static LinkGroupList fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new LinkGroupList();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LinkGroupList fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<LinkGroupList> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> LinkGroupList.fromRawNode(o, parent)));
    }
    public static List<LinkGroupList> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<LinkGroupList> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> LinkGroupList.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference> reference = new ArrayList<>();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup> linkGroup = new ArrayList<>();

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
    private List<Consumer<LinkGroupList>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "link_group_list";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference) {
          this.reference.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup) {
          this.linkGroup.remove(object);
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<LinkGroupList> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_group_list");
      //Deserialize arguments

      //Deserialize children
      this.reference = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference.fromRawNode(rawNode.getChildrenList("reference"), this);
      this.linkGroup = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup.fromRawNode(rawNode.getChildrenList("link_group"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("reference", reference.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference::serializeIntoRawNode).toList());
      rawNode.setChildren("link_group", linkGroup.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing link_group_list");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference> getReference()
    {
      return this.reference;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference> streamReference()
    {
      return reference.stream();
    }
    public LinkGroupList addReference(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference value)
    {
      this.reference.add(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public LinkGroupList addAllReference(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference> value)
    {
      this.reference.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public LinkGroupList removeReference(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference value)
    {
      this.reference.remove(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup> getLinkGroup()
    {
      return this.linkGroup;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup> streamLinkGroup()
    {
      return linkGroup.stream();
    }
    public LinkGroupList addLinkGroup(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup value)
    {
      this.linkGroup.add(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public LinkGroupList addAllLinkGroup(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup> value)
    {
      this.linkGroup.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public LinkGroupList removeLinkGroup(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup value)
    {
      this.linkGroup.remove(value);
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
      "name": "link_group_list"
    }
  */