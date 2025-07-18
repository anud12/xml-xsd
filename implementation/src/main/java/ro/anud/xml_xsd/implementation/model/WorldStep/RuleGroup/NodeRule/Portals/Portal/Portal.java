package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal;
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
  public class Portal implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "portal";
    public static Portal fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new Portal();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Portal fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<Portal> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Portal.fromRawNode(o, parent)));
    }
    public static List<Portal> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Portal> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Portal.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".world_step.rule_group.node_rule.portals.portal";
    }

    //Attributes

    private String side;

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations width = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations height = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To to = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To();

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
      return "portal";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals> parentAsPortals() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portals casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          throw new RuntimeException("trying to delete width which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          throw new RuntimeException("trying to delete height which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To) {
          throw new RuntimeException("trying to delete to which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To) {
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
        // Godot.GD.Print("Deserializing portal");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger.log("side");
        this.side = rawNode.getAttributeRequired("side");
        innerLogger = logger.log("children");
        //Deserialize children
        innerLogger.log("width");
        this.width = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("width").get(), this);
        innerLogger.log("height");
        this.height = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("height").get(), this);
        this.to = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To.fromRawNode(rawNode.getChildrenFirst("to").get(), this);
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("portal");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("side");
      rawNode.setAttribute("side", this.side);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("width");
      rawNode.setChildren("width", Optional.ofNullable(width).stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      innerLogger.log("height");
      rawNode.setChildren("height", Optional.ofNullable(height).stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      innerLogger.log("to");
      rawNode.setChildren("to", Optional.ofNullable(to).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing portal");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getSide()
    {
      return this.side;
    }
    public Portal setSide(String value)
    {
      this.side = value;
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
    public Portal setWidth(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
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
    public Portal setHeight(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.height = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To getTo()
    {
      return this.to;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To> streamTo()
    {
      return Optional.ofNullable(to).stream();
    }
    public Portal setTo(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To value)
    {
      this.to = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
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
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To.nodeName.length() + 3);
          return this.to.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
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
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.Portals.Portal.To.To.nodeName.length() + 3);
          return this.to.getNodeAtPath(childXPath);
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
      },
      "name": "portal"
    }
  */