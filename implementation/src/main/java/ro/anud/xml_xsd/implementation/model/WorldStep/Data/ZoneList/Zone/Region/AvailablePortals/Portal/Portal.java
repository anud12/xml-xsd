package ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.Portal;
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
  public class Portal implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "portal";
    public static Portal fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new Portal();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Portal fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<Portal> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Portal.fromRawNode(o, parent)));
    }
    public static List<Portal> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Portal> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Portal.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".world_step.data.zone_list.zone.region.available_portals.portal";
    }

    //Attributes

    private String id;

    private Integer start;

    private String side;

    private String portalRuleRef;

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
      return "portal";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals> parentAsAvailablePortals() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals casted){
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
        // Godot.GD.Print("Deserializing portal");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger.log("id");
        this.id = rawNode.getAttributeRequired("id");
        innerLogger.log("start");
        this.start = rawNode.getAttributeIntRequired("start");
        innerLogger.log("side");
        this.side = rawNode.getAttributeRequired("side");
        innerLogger.log("portal_rule_ref");
        this.portalRuleRef = rawNode.getAttributeRequired("portal_rule_ref");
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
      rawNode.setTag("portal");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);
      innerLogger.log("start");
      rawNode.setAttribute("start", this.start);
      innerLogger.log("side");
      rawNode.setAttribute("side", this.side);
      innerLogger.log("portal_rule_ref");
      rawNode.setAttribute("portal_rule_ref", this.portalRuleRef);

      innerLogger = logger.log("children");
      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing portal");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public Portal setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public Integer getStart()
    {
      return this.start;
    }
    public Portal setStart(Integer value)
    {
      this.start = value;
      notifyChange();
      return this;
    }
    public String getSide()
    {
      return this.side;
    }
    public Portal setSide(String value)
    {
      this.side = value;
      notifyChange();
      return this;
    }
    public String getPortalRuleRef()
    {
      return this.portalRuleRef;
    }
    public Portal setPortalRuleRef(String value)
    {
      this.portalRuleRef = value;
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
        "isSingle": false,
        "isNullable": true,
        "attributes": {
          "metaType": "object",
          "value": {
            "id": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "start": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            },
            "side": {
              "metaType": "primitive",
              "value": "type__rectangle_side",
              "isNullable": false
            },
            "portal_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          }
        }
      },
      "name": "portal"
    }
  */