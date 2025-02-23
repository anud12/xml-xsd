package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson;
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
  public class FromPerson implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static final String TYPE_ID = "/world_step/rule_group/action_rule/from_person";

    public static FromPerson fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new FromPerson();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static FromPerson fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<FromPerson> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> FromPerson.fromRawNode(o, parent)));
    }
    public static List<FromPerson> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<FromPerson> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> FromPerson.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    private String id;

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> selection = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations> mutations = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson> onPerson = Optional.empty();

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
      return "from_person";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule> parentAsActionRule() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection) {
          this.selection = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations) {
          this.mutations = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson) {
          this.onPerson = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson) {
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
      // Godot.GD.Print("Deserializing from_person");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("id");
      this.id = rawNode.getAttributeRequired("id");
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("selection");
      this.selection = ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.fromRawNode(rawNode.getChildrenFirst("selection"), this);
      this.mutations = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations.fromRawNode(rawNode.getChildrenFirst("mutations"), this);
      this.onPerson = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson.fromRawNode(rawNode.getChildrenFirst("on_person"), this);
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
      innerLogger.log("selection");
      rawNode.setChildren("selection", selection.stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection::serializeIntoRawNode).toList());
      innerLogger.log("mutations");
      rawNode.setChildren("mutations", mutations.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations::serializeIntoRawNode).toList());
      innerLogger.log("on_person");
      rawNode.setChildren("on_person", onPerson.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing from_person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public FromPerson setId(String value)
    {
      this.id = value;
      triggerOnChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> getSelection()
    {
      return this.selection;
    }
    public ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection getSelectionOrDefault()
    {
      return this.selection.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection();
        instance.parentNode(this);
        this.selection = Optional.of(instance);
        return this.selection.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> streamSelectionOrDefault()
    {
      return java.util.stream.Stream.of(getSelectionOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> streamSelection()
    {
      return selection.stream();
    }
    public FromPerson setSelection(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection value)
    {
      this.selection = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations> getMutations()
    {
      return this.mutations;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations getMutationsOrDefault()
    {
      return this.mutations.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations();
        instance.parentNode(this);
        this.mutations = Optional.of(instance);
        return this.mutations.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations> streamMutationsOrDefault()
    {
      return java.util.stream.Stream.of(getMutationsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations> streamMutations()
    {
      return mutations.stream();
    }
    public FromPerson setMutations(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations value)
    {
      this.mutations = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson> getOnPerson()
    {
      return this.onPerson;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson getOnPersonOrDefault()
    {
      return this.onPerson.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson();
        instance.parentNode(this);
        this.onPerson = Optional.of(instance);
        return this.onPerson.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson> streamOnPersonOrDefault()
    {
      return java.util.stream.Stream.of(getOnPersonOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson> streamOnPerson()
    {
      return onPerson.stream();
    }
    public FromPerson setOnPerson(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson value)
    {
      this.onPerson = Optional.ofNullable(value);
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
          "selection": {
            "metaType": "reference",
            "value": "type__person_selection",
            "isSingle": true,
            "isNullable": true
          },
          "mutations": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "property_mutation": {
                "metaType": "reference",
                "value": "type__property_mutation",
                "isSingle": false,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "on_person": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "selection": {
                "metaType": "composition",
                "value": [
                  {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "from_person_same_location_graph_node": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": true,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "value": {
                              "metaType": "primitive",
                              "value": "xs:boolean",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        }
                      }
                    }
                  },
                  {
                    "metaType": "primitive",
                    "value": "type__person_selection"
                  }
                ],
                "isSingle": true,
                "isNullable": true
              },
              "mutations": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "property_mutation": {
                    "metaType": "reference",
                    "value": "type__property_mutation",
                    "isSingle": true,
                    "isNullable": true
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "from_person"
    }
  */