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

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Type_regionRule implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "type__region_rule";
    public static Type_regionRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Type_regionRule();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Type_regionRule fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Type_regionRule> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Type_regionRule.fromRawNode(o, parent)));
        }

    }
    public static List<Type_regionRule> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Type_regionRule> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Type_regionRule.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".type__region_rule";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit limit = new ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> portals = Optional.empty();

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
      try (var logger = logScope()) {
        list.addLast(this);
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.accept(list));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public void clearParentNode() {
      var parentNode = this.parentNode;
      this.parentNode = Optional.empty();
      parentNode.ifPresent(ro.anud.xml_xsd.implementation.util.LinkedNode::notifyChange);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit) {
          throw new RuntimeException("trying to delete limit which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals) {
          this.portals = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      try (var logger = logScope()) {
        onChangeList.add(onChange);
        return logger.logReturn(() -> onChangeList.remove(onChange));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.limit = ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit.fromRawNode(rawNode.getChildrenFirst("limit").get(), this);
          this.portals = ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals.fromRawNode(rawNode.getChildrenFirst("portals"), this);
        }

        if(isDirty) {
          notifyChange();
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("type__region_rule");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("limit");
          rawNode.setChildren("limit", Optional.ofNullable(limit).stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit::serializeIntoRawNode).toList());
          innerLogger.log("portals");
          rawNode.setChildren("portals", portals.stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
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

    public Optional<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> getPortals()
    {
      return this.portals;
    }
    public ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals getPortalsOrDefault()
    {
      return this.portals.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals();
        this.portals = Optional.of(instance);
        instance.parentNode(this);
        return this.portals.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> streamPortalsOrDefault()
    {
      return java.util.stream.Stream.of(getPortalsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> streamPortals()
    {
      return portals.stream();
    }
    public Type_regionRule setPortals(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals value)
    {
      this.portals = Optional.ofNullable(value);
      value.parentNode(this);
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
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals.nodeName))
        {
          if(this.portals.isEmpty()) {
            this.portals = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals.nodeName.length() + 3);
          return this.portals.get().deserializeAtPath(childXPath, rawNode);
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
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals.nodeName))
        {
          if(this.portals.isEmpty()) {
            this.portals = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals.nodeName.length() + 3);
          return this.portals.get().getNodeAtPath(childXPath);
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
        "isSingle": true,
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
                    },
                    "portal_rule_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  }
                },
                "isSingle": false,
                "value": {
                  "start": {
                    "metaType": "reference",
                    "value": "type__math_operations",
                    "isSingle": true,
                    "isNullable": false
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          }
        }
      },
      "name": "type__region_rule"
    }
  */