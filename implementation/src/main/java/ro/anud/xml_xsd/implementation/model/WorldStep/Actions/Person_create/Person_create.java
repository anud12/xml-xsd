package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create;
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
  public class Person_create implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "person.create";
    public static Person_create fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Person_create();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Person_create fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Person_create> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Person_create.fromRawNode(o, parent)));
        }

    }
    public static List<Person_create> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Person_create> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Person_create.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.actions.person.create";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection nodeGraph_selection = new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection person_selection = new ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection();

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
      return "person.create";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> parentAsActions() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
          throw new RuntimeException("trying to delete nodeGraph_selection which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection) {
          throw new RuntimeException("trying to delete person_selection which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection) {
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
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          innerLogger.log("node_graph__selection");
          this.nodeGraph_selection = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.fromRawNode(rawNode.getChildrenFirst("node_graph__selection").get(), this);
          innerLogger.log("person__selection");
          this.person_selection = ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.fromRawNode(rawNode.getChildrenFirst("person__selection").get(), this);
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
        rawNode.setTag("person.create");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("node_graph__selection");
          rawNode.setChildren("node_graph__selection", Optional.ofNullable(nodeGraph_selection).stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection::serializeIntoRawNode).toList());
          innerLogger.log("person__selection");
          rawNode.setChildren("person__selection", Optional.ofNullable(person_selection).stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person.create");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection getNodeGraph_selection()
    {
      return this.nodeGraph_selection;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamNodeGraph_selection()
    {
      return Optional.ofNullable(nodeGraph_selection).stream();
    }
    public Person_create setNodeGraph_selection(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection value)
    {
      this.nodeGraph_selection = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection getPerson_selection()
    {
      return this.person_selection;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> streamPerson_selection()
    {
      return Optional.ofNullable(person_selection).stream();
    }
    public Person_create setPerson_selection(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection value)
    {
      this.person_selection = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.nodeName.length() + 3);
          return this.nodeGraph_selection.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName.length() + 3);
          return this.person_selection.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.nodeName.length() + 3);
          return this.nodeGraph_selection.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName.length() + 3);
          return this.person_selection.getNodeAtPath(childXPath);
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
        "isSingle": false,
        "value": {
          "node_graph__selection": {
            "metaType": "reference",
            "value": "type__node_graph__selection",
            "isSingle": true,
            "isNullable": false
          },
          "person__selection": {
            "metaType": "reference",
            "value": "type__person_selection",
            "isSingle": true,
            "isNullable": false
          }
        },
        "isNullable": true
      },
      "name": "person.create"
    }
  */