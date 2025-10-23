package ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.To;
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
  public class To implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "to";
    public static To fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new To();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static To fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<To> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> To.fromRawNode(o, parent)));
        }

    }
    public static List<To> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<To> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> To.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.data.zone_list.zone.region.portals.portal.to";
    }

    //Attributes

    private String zoneRef;

    private String regionRef;

    private String side;

    private Integer start;

    private Integer end;

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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.Portal> parentAsPortal() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.Portal casted){
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
          innerLogger.log("zone_ref");
          var zoneRefValue = rawNode.getAttributeRequired("zone_ref");
          if(Objects.equals(this.zoneRef, zoneRefValue)) {
            isDirty = true;
          }
          this.zoneRef = zoneRefValue;
          innerLogger.log("region_ref");
          var regionRefValue = rawNode.getAttributeRequired("region_ref");
          if(Objects.equals(this.regionRef, regionRefValue)) {
            isDirty = true;
          }
          this.regionRef = regionRefValue;
          innerLogger.log("side");
          var sideValue = rawNode.getAttributeRequired("side");
          if(Objects.equals(this.side, sideValue)) {
            isDirty = true;
          }
          this.side = sideValue;
          innerLogger.log("start");
          var startValue = rawNode.getAttributeIntRequired("start");
          if(Objects.equals(this.start, startValue)) {
            isDirty = true;
          }
          this.start = startValue;
          innerLogger.log("end");
          var endValue = rawNode.getAttributeIntRequired("end");
          if(Objects.equals(this.end, endValue)) {
            isDirty = true;
          }
          this.end = endValue;
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
        rawNode.setTag("to");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("zone_ref");
          rawNode.setAttribute("zone_ref", this.zoneRef);
          innerLogger.log("region_ref");
          rawNode.setAttribute("region_ref", this.regionRef);
          innerLogger.log("side");
          rawNode.setAttribute("side", this.side);
          innerLogger.log("start");
          rawNode.setAttribute("start", this.start);
          innerLogger.log("end");
          rawNode.setAttribute("end", this.end);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          return rawNode;
        }
      }
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
    public Integer getStart()
    {
      return this.start;
    }
    public To setStart(Integer value)
    {
      this.start = value;
      notifyChange();
      return this;
    }
    public Integer getEnd()
    {
      return this.end;
    }
    public To setEnd(Integer value)
    {
      this.end = value;
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
            "start": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            },
            "end": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            }
          }
        }
      },
      "name": "to"
    }
  */