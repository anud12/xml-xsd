package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards;
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
  public class MoveTowards implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "move_towards";
    public static MoveTowards fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new MoveTowards();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static MoveTowards fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<MoveTowards> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> MoveTowards.fromRawNode(o, parent)));
        }

    }
    public static List<MoveTowards> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<MoveTowards> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> MoveTowards.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.actions.by.move_towards";
    }

    //Attributes
    @Builder.Default
    private Optional<String> layer = Optional.empty();

    private Integer x;

    private Integer y;

    //Children elements

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
      return "move_towards";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By> parentAsBy() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
    }

    public int buildIndexForChild(Object object) {
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
          innerLogger.log("layer");
          var layerValue = rawNode.getAttribute("layer");
          if(Objects.equals(this.layer, layerValue)) {
            isDirty = true;
          }
          this.layer = layerValue;
          innerLogger.log("x");
          var xValue = rawNode.getAttributeIntRequired("x");
          if(Objects.equals(this.x, xValue)) {
            isDirty = true;
          }
          this.x = xValue;
          innerLogger.log("y");
          var yValue = rawNode.getAttributeIntRequired("y");
          if(Objects.equals(this.y, yValue)) {
            isDirty = true;
          }
          this.y = yValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
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
        rawNode.setTag("move_towards");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("layer");
          this.layer.ifPresent(o -> rawNode.setAttribute("layer", o));
          innerLogger.log("x");
          rawNode.setAttribute("x", this.x);
          innerLogger.log("y");
          rawNode.setAttribute("y", this.y);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing move_towards");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public Optional<String> getLayer()
    {
      return this.layer;
    }
    public MoveTowards setLayer(Optional<String> value)
    {
      this.layer = value;
      notifyChange();
      return this;
    }
    public Integer getX()
    {
      return this.x;
    }
    public MoveTowards setX(Integer value)
    {
      this.x = value;
      notifyChange();
      return this;
    }
    public Integer getY()
    {
      return this.y;
    }
    public MoveTowards setY(Integer value)
    {
      this.y = value;
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
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
        "value": {},
        "isSingle": true,
        "isNullable": true,
        "attributes": {
          "metaType": "object",
          "value": {
            "layer": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": true
            },
            "x": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            },
            "y": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            }
          }
        }
      },
      "name": "move_towards"
    }
  */