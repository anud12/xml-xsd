package ro.anud.xml_xsd.implementation.model.Property;
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
  public class Property implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Property fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Property();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Property fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Property> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Property.fromRawNode(o, parent)));
    }
    public static List<Property> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Property> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Property.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/property";
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

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.min = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.max = Optional.empty();
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
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing property");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("property_rule_ref");
      this.propertyRuleRef = rawNode.getAttributeRequired("property_rule_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("min");
      this.min = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("min"), this);
      innerLogger.log("max");
      this.max = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("max"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("property");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("property_rule_ref");
      rawNode.setAttribute("property_rule_ref", this.propertyRuleRef);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("min");
      rawNode.setChildren("min", min.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      innerLogger.log("max");
      rawNode.setChildren("max", max.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      return rawNode;
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
      triggerOnChange();
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
      triggerOnChange();
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