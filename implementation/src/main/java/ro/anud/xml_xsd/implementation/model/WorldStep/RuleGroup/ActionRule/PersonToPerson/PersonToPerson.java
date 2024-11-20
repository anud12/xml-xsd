package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson;
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
  public class PersonToPerson implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static PersonToPerson fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new PersonToPerson();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static PersonToPerson fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<PersonToPerson> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> PersonToPerson.fromRawNode(o, parent)));
    }
    public static List<PersonToPerson> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<PersonToPerson> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> PersonToPerson.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String id;

    //Children elements
    private ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.Test.Test test = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.Test.Test();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn> propertyMutation = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation> locationMutation = Optional.empty();

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
      return "person_to_person";
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.Test.Test) {
          throw new RuntimeException("trying to delete test which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn) {
          this.propertyMutation = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation) {
          this.locationMutation = Optional.empty();
        }
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
      // Godot.GD.Print("Deserializing person_to_person");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("id");
      this.id = rawNode.getAttributeRequired("id");
      innerLogger = logger.log("children");
      //Deserialize children
      this.test = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.Test.Test.fromRawNode(rawNode.getChildrenFirst("test").get(), this);
      innerLogger.log("property_mutation");
      this.propertyMutation = ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn.fromRawNode(rawNode.getChildrenFirst("property_mutation"), this);
      this.locationMutation = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation.fromRawNode(rawNode.getChildrenFirst("location_mutation"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("test");
      rawNode.setChildren("test", Optional.ofNullable(test).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.Test.Test::serializeIntoRawNode).toList());
      innerLogger.log("property_mutation");
      rawNode.setChildren("property_mutation", propertyMutation.stream().map(ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn::serializeIntoRawNode).toList());
      innerLogger.log("location_mutation");
      rawNode.setChildren("location_mutation", locationMutation.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person_to_person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public PersonToPerson setId(String value)
    {
      this.id = value;
      triggerOnChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.Test.Test getTest()
    {
      return this.test;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.Test.Test> streamTest()
    {
      return Optional.ofNullable(test).stream();
    }
    public PersonToPerson setTest(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.Test.Test value)
    {
      this.test = value;
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn> getPropertyMutation()
    {
      return this.propertyMutation;
    }
    public ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn getPropertyMutationOrDefault()
    {
      return this.propertyMutation.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn();
        instance.setParentNode(this);
        this.propertyMutation = Optional.of(instance);
        return this.propertyMutation.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn> streamPropertyMutationOrDefault()
    {
      return Stream.of(getPropertyMutationOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn> streamPropertyMutation()
    {
      return propertyMutation.stream();
    }
    public PersonToPerson setPropertyMutation(ro.anud.xml_xsd.implementation.model.Type_propertyMutationOn.Type_propertyMutationOn value)
    {
      this.propertyMutation = Optional.ofNullable(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation> getLocationMutation()
    {
      return this.locationMutation;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation getLocationMutationOrDefault()
    {
      return this.locationMutation.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation();
        instance.setParentNode(this);
        this.locationMutation = Optional.of(instance);
        return this.locationMutation.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation> streamLocationMutationOrDefault()
    {
      return Stream.of(getLocationMutationOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation> streamLocationMutation()
    {
      return locationMutation.stream();
    }
    public PersonToPerson setLocationMutation(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.LocationMutation.LocationMutation value)
    {
      this.locationMutation = Optional.ofNullable(value);
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
            "id": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "test": {
            "metaType": "object",
            "isSingle": true,
            "value": {
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
              "expected": {
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
              }
            },
            "isNullable": false
          },
          "property_mutation": {
            "metaType": "reference",
            "value": "type__property_mutation_on",
            "isSingle": true,
            "isNullable": true
          },
          "location_mutation": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "name": {
                  "metaType": "unknown",
                  "isNullable": true
                },
                "on": {
                  "metaType": "primitive",
                  "value": "type_person_select",
                  "isNullable": false
                }
              }
            },
            "isSingle": true,
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
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "person_to_person"
    }
  */