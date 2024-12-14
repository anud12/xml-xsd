package ro.anud.xml_xsd.implementation.model.Type_propertyMutation;
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
  public class Type_propertyMutation implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutation.IType_propertyMutation<Type_propertyMutation>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Type_propertyMutation fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_propertyMutation();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Type_propertyMutation fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Type_propertyMutation> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Type_propertyMutation.fromRawNode(o, parent)));
    }
    public static List<Type_propertyMutation> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Type_propertyMutation> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Type_propertyMutation.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String propertyRuleRef;

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> from = new ArrayList<>();

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
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "type__property_mutation";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From) {
          throw new RuntimeException("trying to delete from which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From) {
          return this.from.indexOf(object);
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
      // Godot.GD.Print("Deserializing type__property_mutation");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("property_rule_ref");
      this.propertyRuleRef = rawNode.getAttributeRequired("property_rule_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      this.from = ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From.fromRawNode(rawNode.getChildrenList("from"), this);
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
      innerLogger.log("from");
      rawNode.setChildren("from", from.stream().map(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__property_mutation");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPropertyRuleRef()
    {
      return this.propertyRuleRef;
    }
    public Type_propertyMutation setPropertyRuleRef(String value)
    {
      this.propertyRuleRef = value;
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> getFrom()
    {
      return this.from;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> streamFrom()
    {
      return from.stream();
    }
    public Type_propertyMutation addFrom(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From value)
    {
      this.from.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Type_propertyMutation addAllFrom(List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> value)
    {
      this.from.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Type_propertyMutation removeFrom(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From value)
    {
      this.from.remove(value);
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
          "from": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "participant": {
                  "metaType": "primitive",
                  "value": "type_person_select",
                  "isNullable": false
                }
              },
              "isNullable": false
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
            "isNullable": false
          }
        }
      },
      "typeDeclaration": {
        "name": "type__property_mutation",
        "type": "complex",
        "isSingle": false,
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
            "from": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "participant": {
                    "metaType": "primitive",
                    "value": "type_person_select",
                    "isNullable": false
                  }
                },
                "isNullable": false
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
              "isNullable": false
            }
          }
        }
      },
      "name": "type__property_mutation"
    }
  */