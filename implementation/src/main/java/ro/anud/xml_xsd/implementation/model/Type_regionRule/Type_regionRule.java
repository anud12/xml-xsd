package ro.anud.xml_xsd.implementation.model.Type_regionRule;
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
  public class Type_regionRule implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "type__region_rule";
    public static Type_regionRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new Type_regionRule();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Type_regionRule fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<Type_regionRule> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Type_regionRule.fromRawNode(o, parent)));
    }
    public static List<Type_regionRule> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Type_regionRule> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Type_regionRule.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".type__region_rule";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit limit = new ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> portal = new ArrayList<>();

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
      return "type__region_rule";
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

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit) {
          throw new RuntimeException("trying to delete limit which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal) {
          this.portal.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal) {
          return this.portal.indexOf(object);
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
        // Godot.GD.Print("Deserializing type__region_rule");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger = logger.log("children");
        //Deserialize children
        this.limit = ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit.fromRawNode(rawNode.getChildrenFirst("limit").get(), this);
        this.portal = ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal.fromRawNode(rawNode.getChildrenList("portal"), this);
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("type__region_rule");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("limit");
      rawNode.setChildren("limit", Optional.ofNullable(limit).stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit::serializeIntoRawNode).toList());
      innerLogger.log("portal");
      rawNode.setChildren("portal", portal.stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__region_rule");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit getLimit()
    {
      return this.limit;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit> streamLimit()
    {
      return Optional.ofNullable(limit).stream();
    }
    public Type_regionRule setLimit(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit value)
    {
      this.limit = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> getPortal()
    {
      return this.portal;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> streamPortal()
    {
      return portal.stream();
    }
    public Type_regionRule addPortal(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal value)
    {
      this.portal.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public Type_regionRule addAllPortal(List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> value)
    {
      this.portal.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public Type_regionRule removePortal(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal value)
    {
      this.portal.remove(value);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit.nodeName.length() + 3);
          return this.limit.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.portal.size() > pathIndex) {
              return this.portal.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal();
          this.addPortal(newEntry);
          return newEntry.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit.nodeName.length() + 3);
          return this.limit.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.portal.size() > pathIndex) {
            return this.portal.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
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
        "isSingle": false,
        "value": {
          "limit": {
            "metaType": "object",
            "isSingle": true,
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
              }
            },
            "isNullable": false
          },
          "portal": {
            "metaType": "object",
            "isSingle": false,
            "value": {
              "from": {
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
                "isSingle": true,
                "value": {
                  "position": {
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
              "to": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "side": {
                      "metaType": "primitive",
                      "value": "type__rectangle_side",
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                },
                "isSingle": true,
                "value": {
                  "region": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "region_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "side": {
                          "metaType": "primitive",
                          "value": "type__rectangle_side",
                          "isNullable": false
                        }
                      }
                    },
                    "isSingle": true,
                    "value": {
                      "position": {
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
                  }
                },
                "isNullable": false
              }
            },
            "isNullable": true
          }
        }
      },
      "name": "type__region_rule"
    }
  */