package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold;
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
  public class PropertyThreshold implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "property-threshold";
    public static PropertyThreshold fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new PropertyThreshold();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static PropertyThreshold fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<PropertyThreshold> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> PropertyThreshold.fromRawNode(o, parent)));
        }

    }
    public static List<PropertyThreshold> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<PropertyThreshold> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> PropertyThreshold.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.rule_group.property_rule.entry.property-threshold";
    }

    //Attributes

    private String name;
    @Builder.Default
    private Optional<Integer> minValueInclusive = Optional.empty();
    @Builder.Default
    private Optional<Integer> maxValueInclusive = Optional.empty();

    //Children elements

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
      return "property-threshold";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.Entry> parentAsEntry() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.Entry casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
    }

    public int buildIndexForChild(Object object) {
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
        // Godot.GD.Print("Deserializing property-threshold");

        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("name");
          this.name = rawNode.getAttributeRequired("name");
          innerLogger.log("min-value-inclusive");
          this.minValueInclusive = rawNode.getAttributeInt("min-value-inclusive");
          innerLogger.log("max-value-inclusive");
          this.maxValueInclusive = rawNode.getAttributeInt("max-value-inclusive");
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("property-threshold");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("name");
          rawNode.setAttribute("name", this.name);
          innerLogger.log("min-value-inclusive");
          this.minValueInclusive.ifPresent(o -> rawNode.setAttribute("min-value-inclusive", o));
          innerLogger.log("max-value-inclusive");
          this.maxValueInclusive.ifPresent(o -> rawNode.setAttribute("max-value-inclusive", o));
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing property-threshold");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getName()
    {
      return this.name;
    }
    public PropertyThreshold setName(String value)
    {
      this.name = value;
      notifyChange();
      return this;
    }
    public Optional<Integer> getMinValueInclusive()
    {
      return this.minValueInclusive;
    }
    public PropertyThreshold setMinValueInclusive(Optional<Integer> value)
    {
      this.minValueInclusive = value;
      notifyChange();
      return this;
    }
    public Optional<Integer> getMaxValueInclusive()
    {
      return this.maxValueInclusive;
    }
    public PropertyThreshold setMaxValueInclusive(Optional<Integer> value)
    {
      this.maxValueInclusive = value;
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
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
        "value": {},
        "isSingle": false,
        "isNullable": true,
        "attributes": {
          "metaType": "object",
          "value": {
            "name": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "min-value-inclusive": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": true
            },
            "max-value-inclusive": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": true
            }
          }
        }
      },
      "name": "property-threshold"
    }
  */