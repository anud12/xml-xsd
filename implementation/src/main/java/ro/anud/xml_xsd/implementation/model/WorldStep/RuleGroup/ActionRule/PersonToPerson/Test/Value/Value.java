package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.Test.Value;
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

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Value implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Value fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Value();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Value fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Value> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Value.fromRawNode(o, parent)));
    }
    public static List<Value> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Value> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Value.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String target;

    //Children elements
    private ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations operation = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<Value>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "value";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          throw new RuntimeException("trying to delete operation which is required");
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Value> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing value");
      //Deserialize arguments
      this.target = rawNode.getAttributeRequired("target");

      //Deserialize children
      this.operation = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("operation").get(), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("target", this.target);

      //Serialize children
      rawNode.setChildren("operation", Optional.ofNullable(operation).stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing value");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getTarget()
    {
      return this.target;
    }
    public Value setTarget(String value)
    {
      this.target = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getOperation()
    {
      return this.operation;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamOperation()
    {
      return Optional.ofNullable(operation).stream();
    }
    public Value setOperation(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.operation = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
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
            "target": {
              "metaType": "primitive",
              "value": "type_person_select",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": true,
        "value": {
          "operation": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": false
          }
        },
        "isNullable": false
      },
      "name": "value"
    }
  */