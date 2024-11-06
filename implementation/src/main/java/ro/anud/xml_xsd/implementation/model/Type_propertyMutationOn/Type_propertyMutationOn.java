package ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn;
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
  public class Type_propertyMutationOn implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutationOn.IType_propertyMutationOn<Type_propertyMutationOn>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Type_propertyMutationOn fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_propertyMutationOn();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Type_propertyMutationOn fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Type_propertyMutationOn> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Type_propertyMutationOn.fromRawNode(o, parent)));
    }
    public static List<Type_propertyMutationOn> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Type_propertyMutationOn> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Type_propertyMutationOn.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements

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
    private List<Consumer<Type_propertyMutationOn>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "type__property_mutation_on";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Type_propertyMutationOn> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__property_mutation_on");
      //Deserialize arguments

      //Deserialize children
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__property_mutation_on");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

  }


  /*
    dependant type:
    {
      "type": "element",
      "value": {
        "metaType": "composition",
        "value": [
          {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "on": {
                  "metaType": "primitive",
                  "value": "type_person_select",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          {
            "metaType": "primitive",
            "value": "type__property_mutation"
          }
        ]
      },
      "typeDeclaration": {
        "name": "type__property_mutation_on",
        "type": "complex",
        "value": {
          "metaType": "composition",
          "value": [
            {
              "metaType": "object",
              "value": {},
              "isSingle": true,
              "isNullable": false,
              "attributes": {
                "metaType": "object",
                "value": {
                  "on": {
                    "metaType": "primitive",
                    "value": "type_person_select",
                    "isNullable": false
                  }
                },
                "isNullable": false
              }
            },
            {
              "metaType": "primitive",
              "value": "type__property_mutation"
            }
          ]
        }
      },
      "name": "type__property_mutation_on"
    }
  */