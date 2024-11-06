package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson;
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
  public class OnPerson implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static OnPerson fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new OnPerson();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static OnPerson fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<OnPerson> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> OnPerson.fromRawNode(o, parent)));
    }
    public static List<OnPerson> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<OnPerson> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> OnPerson.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.Selection> selection = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Mutations.Mutations> mutations = Optional.empty();

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
    private List<Consumer<OnPerson>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "on_person";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.Selection) {
          this.selection = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Mutations.Mutations) {
          this.mutations = Optional.empty();
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<OnPerson> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing on_person");
      //Deserialize arguments

      //Deserialize children
      this.selection = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.Selection.fromRawNode(rawNode.getChildrenFirst("selection"), this);
      this.mutations = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Mutations.Mutations.fromRawNode(rawNode.getChildrenFirst("mutations"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("selection", selection.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.Selection::serializeIntoRawNode).toList());
      rawNode.setChildren("mutations", mutations.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Mutations.Mutations::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing on_person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.Selection> getSelection()
    {
      return this.selection;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.Selection> streamSelection()
    {
      return selection.stream();
    }
    public OnPerson setSelection(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.Selection value)
    {
      this.selection = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Mutations.Mutations> getMutations()
    {
      return this.mutations;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Mutations.Mutations> streamMutations()
    {
      return mutations.stream();
    }
    public OnPerson setMutations(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Mutations.Mutations value)
    {
      this.mutations = Optional.ofNullable(value);
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
      },
      "name": "on_person"
    }
  */