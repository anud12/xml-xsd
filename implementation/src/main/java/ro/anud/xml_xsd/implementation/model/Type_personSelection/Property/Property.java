package ro.anud.xml_xsd.implementation.model.Type_personSelection.Property;
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
  public class Property implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "property";
    public static Property fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Property();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Property fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Property> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Property.fromRawNode(o, parent)));
        }

    }
    public static List<Property> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Property> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Property.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".type__person_selection.property";
    }

    //Attributes

    private String propertyRuleRef;

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> min = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> max = Optional.empty();

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
      return "property";
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

    public Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> parentAsType_personSelection() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.min = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.max = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
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
          innerLogger.log("property_rule_ref");
          var propertyRuleRefValue = rawNode.getAttributeRequired("property_rule_ref");
          if(Objects.equals(this.propertyRuleRef, propertyRuleRefValue)) {
            isDirty = true;
          }
          this.propertyRuleRef = propertyRuleRefValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          innerLogger.log("min");
          this.min = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("min"), this);
          innerLogger.log("max");
          this.max = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("max"), this);
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
        rawNode.setTag("property");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("property_rule_ref");
          rawNode.setAttribute("property_rule_ref", this.propertyRuleRef);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("min");
          rawNode.setChildren("min", min.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
          innerLogger.log("max");
          rawNode.setChildren("max", max.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing property");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPropertyRuleRef()
    {
      return this.propertyRuleRef;
    }
    public Property setPropertyRuleRef(String value)
    {
      this.propertyRuleRef = value;
      notifyChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMin()
    {
      return this.min;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getMinOrDefault()
    {
      return this.min.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        this.min = Optional.of(instance);
        instance.parentNode(this);
        return this.min.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMinOrDefault()
    {
      return java.util.stream.Stream.of(getMinOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMin()
    {
      return min.stream();
    }
    public Property setMin(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.min = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMax()
    {
      return this.max;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getMaxOrDefault()
    {
      return this.max.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        this.max = Optional.of(instance);
        instance.parentNode(this);
        return this.max.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMaxOrDefault()
    {
      return java.util.stream.Stream.of(getMaxOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMax()
    {
      return max.stream();
    }
    public Property setMax(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.max = Optional.ofNullable(value);
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
          if(this.min.isEmpty()) {
            this.min = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.min.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.max.isEmpty()) {
            this.max = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.max.get().deserializeAtPath(childXPath, rawNode);
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
          if(this.min.isEmpty()) {
            this.min = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.min.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.max.isEmpty()) {
            this.max = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.max.get().getNodeAtPath(childXPath);
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
            "property_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "min": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": true
          },
          "max": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "property"
    }
  */