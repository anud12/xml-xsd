package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.Entry.Property;
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
  public class Property implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Property fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Property();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Property fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
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

    //Attributes
    private String propertyRuleRef;
    /* ignored attribute key={key} of type=is*/

    //Children elements
    private ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations operation = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();

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
      return "property";
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          throw new RuntimeException("trying to delete operation which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          return 0;
        }
        return 0;
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
      // Godot.GD.Print("Deserializing property");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("property_rule_ref");
      this.propertyRuleRef = rawNode.getAttributeRequired("property_rule_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("operation");
      this.operation = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("operation").get(), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("property_rule_ref");
      rawNode.setAttribute("property_rule_ref", this.propertyRuleRef);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("operation");
      rawNode.setChildren("operation", Optional.ofNullable(operation).stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
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
    /* ignored attribute key={key} of type=is*/
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getOperation()
    {
      return this.operation;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamOperation()
    {
      return Optional.ofNullable(operation).stream();
    }
    public Property setOperation(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.operation = value;
      value.setParentNode(this);
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
            },
            "is": {
              "metaType": "union",
              "value": [
                {
                  "metaType": "primitive",
                  "value": "\"lessThan\""
                },
                {
                  "metaType": "primitive",
                  "value": "\"lessThanOrEqual\""
                },
                {
                  "metaType": "primitive",
                  "value": "\"greaterThan\""
                },
                {
                  "metaType": "primitive",
                  "value": "\"greaterThanOrEqual\""
                },
                {
                  "metaType": "primitive",
                  "value": "\"equal\""
                }
              ]
            }
          }
        },
        "isSingle": false,
        "value": {
          "operation": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": false
          }
        },
        "isNullable": true
      },
      "name": "property"
    }
  */