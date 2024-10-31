package ro.anud.xml_xsd.implementation.model.Type_propertyMutation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public class Type_propertyMutation  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<Type_propertyMutation>> onChangeList = new ArrayList<>();

    public static Type_propertyMutation fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_propertyMutation();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<Type_propertyMutation> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Type_propertyMutation::fromRawNode));
    }
    public static List<Type_propertyMutation> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Type_propertyMutation> returnList = rawNodeList.stream().map(Type_propertyMutation::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<Type_propertyMutation> onChange) {
      onChangeList.add(onChange);
      return () -> onChangeList.remove(onChange);
    }

    //Attributes
    private String propertyRuleRef;

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.Group_mathOperations.Group_mathOperations> from = new ArrayList<>();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__property_mutation");
      //Deserialize arguments
      this.propertyRuleRef = rawNode.getAttributeRequired("property_rule_ref");

      //Deserialize children
      this.from = ro.anud.xml_xsd.implementation.model.Group_mathOperations.Group_mathOperations.fromRawNode(rawNode.getChildrenList("from"));
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("property_rule_ref", this.propertyRuleRef);

      //Serialize children
      rawNode.addChildren("from", from);
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
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Group_mathOperations.Group_mathOperations> getFrom()
    {
      return this.from;
    }
    public Type_propertyMutation setFrom(List<ro.anud.xml_xsd.implementation.model.Group_mathOperations.Group_mathOperations> value)
    {
      this.from = value;
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
            "metaType": "reference",
            "value": "group__math_operations",
            "isSingle": false,
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
            "isNullable": false
          }
        }
      },
      "name": "type__property_mutation"
    }
  */