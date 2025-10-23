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

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class FromPerson implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "from_person";
    public static FromPerson fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new FromPerson();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static FromPerson fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<FromPerson> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> FromPerson.fromRawNode(o, parent)));
        }

    }
    public static List<FromPerson> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<FromPerson> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> FromPerson.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.rule_group.action_rule.from_person";
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
    private List<Consumer<List<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "from_person";
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

    public void clearParentNode() {
      var parentNode = this.parentNode;
      this.parentNode = Optional.empty();
      parentNode.ifPresent(ro.anud.xml_xsd.implementation.util.LinkedNode::notifyChange);
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
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations) {
          this.mutations = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson) {
          this.onPerson = Optional.empty();
          notifyChange();
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

    public Subscription onChange(Consumer<List<Object>> onChange) {
      try (var logger = logScope()) {
        onChangeList.add(onChange);
        return logger.logReturn(() -> onChangeList.remove(onChange));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("id");
          var idValue = rawNode.getAttributeRequired("id");
          if(Objects.equals(this.id, idValue)) {
            isDirty = true;
          }
          this.id = idValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          innerLogger.log("selection");
          this.selection = ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.fromRawNode(rawNode.getChildrenFirst("selection"), this);
          this.mutations = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations.fromRawNode(rawNode.getChildrenFirst("mutations"), this);
          this.onPerson = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson.fromRawNode(rawNode.getChildrenFirst("on_person"), this);
        }

        if(isDirty) {
          notifyChange();
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("from_person");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("id");
          rawNode.setAttribute("id", this.id);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("selection");
          rawNode.setChildren("selection", selection.stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection::serializeIntoRawNode).toList());
          innerLogger.log("mutations");
          rawNode.setChildren("mutations", mutations.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations::serializeIntoRawNode).toList());
          innerLogger.log("on_person");
          rawNode.setChildren("on_person", onPerson.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
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
      notifyChange();
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
        this.selection = Optional.of(instance);
        instance.parentNode(this);
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
      notifyChange();
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
        this.mutations = Optional.of(instance);
        instance.parentNode(this);
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
      notifyChange();
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
        this.onPerson = Optional.of(instance);
        instance.parentNode(this);
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
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName))
        {
          if(this.selection.isEmpty()) {
            this.selection = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName.length() + 3);
          return this.selection.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations.nodeName))
        {
          if(this.mutations.isEmpty()) {
            this.mutations = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations.nodeName.length() + 3);
          return this.mutations.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson.nodeName))
        {
          if(this.onPerson.isEmpty()) {
            this.onPerson = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson.nodeName.length() + 3);
          return this.onPerson.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName))
        {
          if(this.selection.isEmpty()) {
            this.selection = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName.length() + 3);
          return this.selection.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations.nodeName))
        {
          if(this.mutations.isEmpty()) {
            this.mutations = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations.nodeName.length() + 3);
          return this.mutations.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson.nodeName))
        {
          if(this.onPerson.isEmpty()) {
            this.onPerson = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson.nodeName.length() + 3);
          return this.onPerson.get().getNodeAtPath(childXPath);
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