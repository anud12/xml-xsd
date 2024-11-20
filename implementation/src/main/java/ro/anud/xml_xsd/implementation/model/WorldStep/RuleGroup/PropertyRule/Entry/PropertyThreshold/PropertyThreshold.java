package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold;
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
import static ro.anud.xml_xsd.implementation.util.LocalLogger.log;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class PropertyThreshold implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static PropertyThreshold fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new PropertyThreshold();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static PropertyThreshold fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<PropertyThreshold> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> PropertyThreshold.fromRawNode(o, parent)));
    }
    public static List<PropertyThreshold> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<PropertyThreshold> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> PropertyThreshold.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String name;
    private Optional<Integer> minValueInclusive;
    private Optional<Integer> maxValueInclusive;

    //Children elements

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    @Builder.Default
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    @Builder.Default
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "property-threshold";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public void removeChild(Object object) {
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Set<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing property-threshold");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("name");
      this.name = rawNode.getAttributeRequired("name");
      innerLogger.log("min-value-inclusive");
      this.minValueInclusive = rawNode.getAttributeInt("min-value-inclusive");
      innerLogger.log("max-value-inclusive");
      this.maxValueInclusive = rawNode.getAttributeInt("max-value-inclusive");
      innerLogger = logger.log("children");
      //Deserialize children
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("name");
      rawNode.setAttribute("name", this.name);
      innerLogger.log("min-value-inclusive");
      this.minValueInclusive.ifPresent(o -> rawNode.setAttribute("min-value-inclusive", o));
      innerLogger.log("max-value-inclusive");
      this.maxValueInclusive.ifPresent(o -> rawNode.setAttribute("max-value-inclusive", o));

      innerLogger = logger.log("children");
      //Serialize children
      return rawNode;
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
      triggerOnChange();
      return this;
    }
    public Optional<Integer> getMinValueInclusive()
    {
      return this.minValueInclusive;
    }
    public PropertyThreshold setMinValueInclusive(Optional<Integer> value)
    {
      this.minValueInclusive = value;
      triggerOnChange();
      return this;
    }
    public Optional<Integer> getMaxValueInclusive()
    {
      return this.maxValueInclusive;
    }
    public PropertyThreshold setMaxValueInclusive(Optional<Integer> value)
    {
      this.maxValueInclusive = value;
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