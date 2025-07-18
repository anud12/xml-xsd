package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Zone.Region.Limit;
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
  public class Limit implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "limit";
    public static Limit fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new Limit();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Limit fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<Limit> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Limit.fromRawNode(o, parent)));
    }
    public static List<Limit> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Limit> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Limit.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".world_step.data.zone.region.limit";
    }

    //Attributes

    private Double width;

    private Double height;

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
      return "limit";
    }

    public void notifyChange(List<Object> list) {
      var logger = logEnter();
      list.addLast(this);
      logger.log("Notify change for", this.buildPath());
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Zone.Region.Region> parentAsRegion() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Zone.Region.Region casted){
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
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      try {
        var logger = logEnter();
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing limit");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger.log("width");
        this.width = rawNode.getAttributeDoubleRequired("width");
        innerLogger.log("height");
        this.height = rawNode.getAttributeDoubleRequired("height");
        innerLogger = logger.log("children");
        //Deserialize children
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("limit");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("width");
      rawNode.setAttribute("width", this.width);
      innerLogger.log("height");
      rawNode.setAttribute("height", this.height);

      innerLogger = logger.log("children");
      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing limit");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public Double getWidth()
    {
      return this.width;
    }
    public Limit setWidth(Double value)
    {
      this.width = value;
      notifyChange();
      return this;
    }
    public Double getHeight()
    {
      return this.height;
    }
    public Limit setHeight(Double value)
    {
      this.height = value;
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
        "isNullable": false,
        "attributes": {
          "metaType": "object",
          "value": {
            "width": {
              "metaType": "primitive",
              "value": "xs:decimal",
              "isNullable": false
            },
            "height": {
              "metaType": "primitive",
              "value": "xs:decimal",
              "isNullable": false
            }
          }
        }
      },
      "name": "limit"
    }
  */