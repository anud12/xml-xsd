package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Zone.Region.Portals.Portal.To;
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
  public class To implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "to";
    public static To fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new To();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static To fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<To> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> To.fromRawNode(o, parent)));
    }
    public static List<To> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<To> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> To.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".world_step.data.zone.region.portals.portal.to";
    }

    //Attributes

    private String zoneRef;

    private String regionRef;

    private String side;

    private Double position;
    @Builder.Default
    private Optional<String> maxWidth = Optional.empty();

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
      return "to";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Zone.Region.Portals.Portal.Portal> parentAsPortal() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Zone.Region.Portals.Portal.Portal casted){
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
        // Godot.GD.Print("Deserializing to");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger.log("zone_ref");
        this.zoneRef = rawNode.getAttributeRequired("zone_ref");
        innerLogger.log("region_ref");
        this.regionRef = rawNode.getAttributeRequired("region_ref");
        innerLogger.log("side");
        this.side = rawNode.getAttributeRequired("side");
        innerLogger.log("position");
        this.position = rawNode.getAttributeDoubleRequired("position");
        innerLogger.log("maxWidth");
        this.maxWidth = rawNode.getAttribute("maxWidth");
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
      rawNode.setTag("to");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("zone_ref");
      rawNode.setAttribute("zone_ref", this.zoneRef);
      innerLogger.log("region_ref");
      rawNode.setAttribute("region_ref", this.regionRef);
      innerLogger.log("side");
      rawNode.setAttribute("side", this.side);
      innerLogger.log("position");
      rawNode.setAttribute("position", this.position);
      innerLogger.log("maxWidth");
      this.maxWidth.ifPresent(o -> rawNode.setAttribute("maxWidth", o));

      innerLogger = logger.log("children");
      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing to");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getZoneRef()
    {
      return this.zoneRef;
    }
    public To setZoneRef(String value)
    {
      this.zoneRef = value;
      notifyChange();
      return this;
    }
    public String getRegionRef()
    {
      return this.regionRef;
    }
    public To setRegionRef(String value)
    {
      this.regionRef = value;
      notifyChange();
      return this;
    }
    public String getSide()
    {
      return this.side;
    }
    public To setSide(String value)
    {
      this.side = value;
      notifyChange();
      return this;
    }
    public Double getPosition()
    {
      return this.position;
    }
    public To setPosition(Double value)
    {
      this.position = value;
      notifyChange();
      return this;
    }
    public Optional<String> getMaxWidth()
    {
      return this.maxWidth;
    }
    public To setMaxWidth(Optional<String> value)
    {
      this.maxWidth = value;
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
            "zone_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "region_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "side": {
              "metaType": "primitive",
              "value": "type__rectangle_side",
              "isNullable": false
            },
            "position": {
              "metaType": "primitive",
              "value": "xs:decimal",
              "isNullable": false
            },
            "maxWidth": {
              "metaType": "primitive",
              "value": "xs:positiveInteger",
              "isNullable": true
            }
          }
        }
      },
      "name": "to"
    }
  */