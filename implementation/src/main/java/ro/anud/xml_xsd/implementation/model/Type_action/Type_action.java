package ro.anud.xml_xsd.implementation.model.Type_action;
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
  public class Type_action implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "type__action";
    public static Type_action fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Type_action();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Type_action fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Type_action> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Type_action.fromRawNode(o, parent)));
        }

    }
    public static List<Type_action> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Type_action> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Type_action.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".type__action";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_action.From.From from = new ro.anud.xml_xsd.implementation.model.Type_action.From.From();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_action.On.On on = new ro.anud.xml_xsd.implementation.model.Type_action.On.On();

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
      return "type__action";
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

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_action.From.From) {
          throw new RuntimeException("trying to delete from which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_action.On.On) {
          throw new RuntimeException("trying to delete on which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_action.From.From) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_action.On.On) {
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
          this.from = ro.anud.xml_xsd.implementation.model.Type_action.From.From.fromRawNode(rawNode.getChildrenFirst("from").get(), this);
          this.on = ro.anud.xml_xsd.implementation.model.Type_action.On.On.fromRawNode(rawNode.getChildrenFirst("on").get(), this);
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
        rawNode.setTag("type__action");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("from");
          rawNode.setChildren("from", Optional.ofNullable(from).stream().map(ro.anud.xml_xsd.implementation.model.Type_action.From.From::serializeIntoRawNode).toList());
          innerLogger.log("on");
          rawNode.setChildren("on", Optional.ofNullable(on).stream().map(ro.anud.xml_xsd.implementation.model.Type_action.On.On::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__action");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public ro.anud.xml_xsd.implementation.model.Type_action.From.From getFrom()
    {
      return this.from;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_action.From.From> streamFrom()
    {
      return Optional.ofNullable(from).stream();
    }
    public Type_action setFrom(ro.anud.xml_xsd.implementation.model.Type_action.From.From value)
    {
      this.from = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.Type_action.On.On getOn()
    {
      return this.on;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_action.On.On> streamOn()
    {
      return Optional.ofNullable(on).stream();
    }
    public Type_action setOn(ro.anud.xml_xsd.implementation.model.Type_action.On.On value)
    {
      this.on = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_action.From.From.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_action.From.From.nodeName.length() + 3);
          return this.from.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_action.On.On.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_action.On.On.nodeName.length() + 3);
          return this.on.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_action.From.From.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_action.From.From.nodeName.length() + 3);
          return this.from.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_action.On.On.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_action.On.On.nodeName.length() + 3);
          return this.on.getNodeAtPath(childXPath);
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
        "isSingle": true,
        "value": {
          "from": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "person": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "select": {
                    "metaType": "reference",
                    "value": "type__person_selection",
                    "isSingle": true,
                    "isNullable": true
                  },
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
            "isNullable": false
          },
          "on": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "person": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "select": {
                    "metaType": "reference",
                    "value": "type__person_selection",
                    "isSingle": true,
                    "isNullable": true
                  },
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
            "isNullable": false
          }
        }
      },
      "name": "type__action"
    }
  */