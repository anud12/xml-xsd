package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards;
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
  public class MoveTowards implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static MoveTowards fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new MoveTowards();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static MoveTowards fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<MoveTowards> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> MoveTowards.fromRawNode(o, parent)));
    }
    public static List<MoveTowards> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<MoveTowards> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> MoveTowards.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private Optional<String> layer;
    private Integer x;
    private Integer y;

    //Children elements

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
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<MoveTowards>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "move_towards";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<MoveTowards> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing move_towards");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("layer");
      this.layer = rawNode.getAttribute("layer");
      innerLogger.log("x");
      this.x = rawNode.getAttributeIntRequired("x");
      innerLogger.log("y");
      this.y = rawNode.getAttributeIntRequired("y");
      innerLogger = logger.log("children");
      //Deserialize children
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("layer");
      this.layer.ifPresent(o -> rawNode.setAttribute("layer", o));
      innerLogger.log("x");
      rawNode.setAttribute("x", this.x);
      innerLogger.log("y");
      rawNode.setAttribute("y", this.y);

      innerLogger = logger.log("children");
      //Serialize children
      return rawNode;
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
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Integer getX()
    {
      return this.x;
    }
    public MoveTowards setX(Integer value)
    {
      this.x = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Integer getY()
    {
      return this.y;
    }
    public MoveTowards setY(Integer value)
    {
      this.y = value;
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
        "value": {},
        "isSingle": true,
        "isNullable": false,
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