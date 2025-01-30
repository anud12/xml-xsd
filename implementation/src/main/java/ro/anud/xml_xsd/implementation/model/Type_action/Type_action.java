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

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Type_action implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Type_action fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_action();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Type_action fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Type_action> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Type_action.fromRawNode(o, parent)));
    }
    public static List<Type_action> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Type_action> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Type_action.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/type__action";
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

    public void childChanged(List<Object> list) {
      list.addLast(this);
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(list));
    }

    private void triggerOnChange() {
      childChanged(new ArrayList<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
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
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__action");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.from = ro.anud.xml_xsd.implementation.model.Type_action.From.From.fromRawNode(rawNode.getChildrenFirst("from").get(), this);
      this.on = ro.anud.xml_xsd.implementation.model.Type_action.On.On.fromRawNode(rawNode.getChildrenFirst("on").get(), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("type__action");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("from");
      rawNode.setChildren("from", Optional.ofNullable(from).stream().map(ro.anud.xml_xsd.implementation.model.Type_action.From.From::serializeIntoRawNode).toList());
      innerLogger.log("on");
      rawNode.setChildren("on", Optional.ofNullable(on).stream().map(ro.anud.xml_xsd.implementation.model.Type_action.On.On::serializeIntoRawNode).toList());
      return rawNode;
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
      triggerOnChange();
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