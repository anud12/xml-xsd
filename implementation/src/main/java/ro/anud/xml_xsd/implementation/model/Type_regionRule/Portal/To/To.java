package ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To;
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
      return ".type__region_rule.portal.to";
    }

    //Attributes
    @Builder.Default
    private Optional<String> side = Optional.empty();

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region region = new ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region();

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

    public Optional<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> parentAsPortal() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region) {
          throw new RuntimeException("trying to delete region which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region) {
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
      try {
        var logger = logEnter();
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing to");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger.log("side");
        this.side = rawNode.getAttribute("side");
        innerLogger = logger.log("children");
        //Deserialize children
        this.region = ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region.fromRawNode(rawNode.getChildrenFirst("region").get(), this);
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
      innerLogger.log("side");
      this.side.ifPresent(o -> rawNode.setAttribute("side", o));

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("region");
      rawNode.setChildren("region", Optional.ofNullable(region).stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing to");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public Optional<String> getSide()
    {
      return this.side;
    }
    public To setSide(Optional<String> value)
    {
      this.side = value;
      notifyChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region getRegion()
    {
      return this.region;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region> streamRegion()
    {
      return Optional.ofNullable(region).stream();
    }
    public To setRegion(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region value)
    {
      this.region = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region.nodeName.length() + 3);
          return this.region.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.To.Region.Region.nodeName.length() + 3);
          return this.region.getNodeAtPath(childXPath);
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
            "side": {
              "metaType": "primitive",
              "value": "type__rectangle_side",
              "isNullable": true
            }
          },
          "isNullable": true
        },
        "isSingle": true,
        "value": {
          "region": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "region_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "side": {
                  "metaType": "primitive",
                  "value": "type__rectangle_side",
                  "isNullable": false
                }
              }
            },
            "isSingle": true,
            "value": {
              "position": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": false
              },
              "width": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        "isNullable": false
      },
      "name": "to"
    }
  */