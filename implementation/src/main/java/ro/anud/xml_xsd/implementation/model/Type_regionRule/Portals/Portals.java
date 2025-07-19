package ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals;
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
  public class Portals implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "portals";
    public static Portals fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new Portals();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Portals fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<Portals> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Portals.fromRawNode(o, parent)));
    }
    public static List<Portals> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Portals> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Portals.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".type__region_rule.portals";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal> portal = new ArrayList<>();

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
      return "portals";
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

    public Optional<ro.anud.xml_xsd.implementation.model.Type_regionRule.Type_regionRule> parentAsType_regionRule() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Type_regionRule casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal) {
          this.portal.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal) {
          return this.portal.indexOf(object);
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
        // Godot.GD.Print("Deserializing portals");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger = logger.log("children");
        //Deserialize children
        this.portal = ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal.fromRawNode(rawNode.getChildrenList("portal"), this);
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("portals");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("portal");
      rawNode.setChildren("portal", portal.stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing portals");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal> getPortal()
    {
      return this.portal;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal> streamPortal()
    {
      return portal.stream();
    }
    public Portals addPortal(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal value)
    {
      this.portal.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public Portals addAllPortal(List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal> value)
    {
      this.portal.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public Portals removePortal(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal value)
    {
      this.portal.remove(value);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.portal.size() > pathIndex) {
              return this.portal.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal();
          this.addPortal(newEntry);
          return newEntry.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.portal.size() > pathIndex) {
            return this.portal.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
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
          "portal": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
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
            },
            "isSingle": false,
            "value": {
              "start": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": false
              }
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "portals"
    }
  */