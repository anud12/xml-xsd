package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule;
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

    public static String nodeName = "node_rule";
    public static NodeRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new NodeRule();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static NodeRule fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
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
      return ".world_step.rule_group.node_rule";
    }

    //Attributes

    private String id;

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area area = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals portals = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals();

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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup> parentAsRuleGroup() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area) {
          throw new RuntimeException("trying to delete area which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals) {
          throw new RuntimeException("trying to delete portals which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals) {
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
        // Godot.GD.Print("Deserializing node_rule");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger.log("id");
        this.id = rawNode.getAttributeRequired("id");
        innerLogger = logger.log("children");
        //Deserialize children
        this.area = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area.fromRawNode(rawNode.getChildrenFirst("area").get(), this);
        this.portals = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals.fromRawNode(rawNode.getChildrenFirst("portals").get(), this);
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
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
      innerLogger.log("area");
      rawNode.setChildren("area", Optional.ofNullable(area).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area::serializeIntoRawNode).toList());
      innerLogger.log("portals");
      rawNode.setChildren("portals", Optional.ofNullable(portals).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals::serializeIntoRawNode).toList());
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
      notifyChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area getArea()
    {
      return this.area;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area> streamArea()
    {
      return Optional.ofNullable(area).stream();
    }
    public NodeRule setArea(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area value)
    {
      this.area = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals getPortals()
    {
      return this.portals;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals> streamPortals()
    {
      return Optional.ofNullable(portals).stream();
    }
    public NodeRule setPortals(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals value)
    {
      this.portals = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area.nodeName.length() + 3);
          return this.area.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals.nodeName.length() + 3);
          return this.portals.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Area.Area.nodeName.length() + 3);
          return this.area.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals.nodeName.length() + 3);
          return this.portals.getNodeAtPath(childXPath);
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
        "isSingle": true,
        "value": {
          "area": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "height": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": false
              },
              "width": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": false
              }
            },
            "isNullable": false
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
                    "side": {
                      "metaType": "primitive",
                      "value": "type__rectangle_side",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "width": {
                    "metaType": "reference",
                    "value": "type__math_operations",
                    "isSingle": true,
                    "isNullable": false
                  },
                  "height": {
                    "metaType": "reference",
                    "value": "type__math_operations",
                    "isSingle": true,
                    "isNullable": false
                  },
                  "to": {
                    "metaType": "object",
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
                    },
                    "isSingle": true,
                    "value": {
                      "side": {
                        "metaType": "reference",
                        "value": "type__rectangle_side",
                        "isSingle": true,
                        "isNullable": false
                      },
                      "width": {
                        "metaType": "reference",
                        "value": "type__math_operations",
                        "isSingle": true,
                        "isNullable": false
                      },
                      "height": {
                        "metaType": "reference",
                        "value": "type__math_operations",
                        "isSingle": true,
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": false
          }
        },
        "isNullable": true
      },
      "name": "node_rule"
    }
  */