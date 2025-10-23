package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To;
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
  public class To implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "to";
    public static To fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new To();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static To fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<To> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> To.fromRawNode(o, parent)));
        }

    }
    public static List<To> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<To> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> To.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.rule_group.node_rule.portals.portal.to";
    }

    //Attributes

    private String nodeRuleRef;

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide side = new ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations width = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations height = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();

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
      return "to";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.Portal> parentAsPortal() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.Portal casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide) {
          throw new RuntimeException("trying to delete side which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          throw new RuntimeException("trying to delete width which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          throw new RuntimeException("trying to delete height which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
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
          innerLogger.log("node_rule_ref");
          var nodeRuleRefValue = rawNode.getAttributeRequired("node_rule_ref");
          if(Objects.equals(this.nodeRuleRef, nodeRuleRefValue)) {
            isDirty = true;
          }
          this.nodeRuleRef = nodeRuleRefValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          innerLogger.log("side");
          this.side = ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide.fromRawNode(rawNode.getChildrenFirst("side").get(), this);
          innerLogger.log("width");
          this.width = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("width").get(), this);
          innerLogger.log("height");
          this.height = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("height").get(), this);
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
        rawNode.setTag("to");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("node_rule_ref");
          rawNode.setAttribute("node_rule_ref", this.nodeRuleRef);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("side");
          rawNode.setChildren("side", Optional.ofNullable(side).stream().map(ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide::serializeIntoRawNode).toList());
          innerLogger.log("width");
          rawNode.setChildren("width", Optional.ofNullable(width).stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
          innerLogger.log("height");
          rawNode.setChildren("height", Optional.ofNullable(height).stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing to");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getNodeRuleRef()
    {
      return this.nodeRuleRef;
    }
    public To setNodeRuleRef(String value)
    {
      this.nodeRuleRef = value;
      notifyChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide getSide()
    {
      return this.side;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide> streamSide()
    {
      return Optional.ofNullable(side).stream();
    }
    public To setSide(ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide value)
    {
      this.side = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getWidth()
    {
      return this.width;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamWidth()
    {
      return Optional.ofNullable(width).stream();
    }
    public To setWidth(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.width = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getHeight()
    {
      return this.height;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamHeight()
    {
      return Optional.ofNullable(height).stream();
    }
    public To setHeight(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.height = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide.nodeName.length() + 3);
          return this.side.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.width.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.height.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_rectangleSide.Type_rectangleSide.nodeName.length() + 3);
          return this.side.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.width.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.height.getNodeAtPath(childXPath);
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
      },
      "name": "to"
    }
  */