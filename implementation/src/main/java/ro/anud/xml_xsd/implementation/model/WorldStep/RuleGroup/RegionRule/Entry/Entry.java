package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.Entry;
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
  public class Entry implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_regionRule.IType_regionRule<Entry>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "entry";
    public static Entry fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new Entry();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Entry fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<Entry> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Entry.fromRawNode(o, parent)));
    }
    public static List<Entry> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Entry> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Entry.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".world_step.rule_group.region_rule.entry";
    }

    //Attributes

    private String id;

    //Attributes of type__region_rule

    //Children elements

    //Children of type__region_rule
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit limit = new ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> portal = new ArrayList<>();

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
      return "entry";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule> parentAsRegionRule() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule casted){
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
        // Godot.GD.Print("Deserializing entry");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger.log("id");
        this.id = rawNode.getAttributeRequired("id");

        // Deserialize arguments of type__region_rule

        innerLogger = logger.log("children");
        //Deserialize children

        // Deserialize children of type__region_rule
        this.limit = ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit.fromRawNode(rawNode.getChildrenFirst("limit").get(), this);
        this.portal = ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal.fromRawNode(rawNode.getChildrenList("portal"), this);
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("entry");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);

      // Serialize arguments of type__region_rule


      innerLogger = logger.log("children");
      //Serialize children

      // Serialize children of type__region_rule
      innerLogger.log("limit");
      rawNode.setChildren("limit", Optional.ofNullable(limit).stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit::serializeIntoRawNode).toList());
      innerLogger.log("portal");
      rawNode.setChildren("portal", portal.stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public Entry setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit getLimit()
    {
      return this.limit;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit> streamLimit()
    {
      return Optional.ofNullable(limit).stream();
    }
    public Entry setLimit(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit value)
    {
      this.limit = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> getPortal()
    {
      return this.portal;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> streamPortal()
    {
      return portal.stream();
    }
    public Entry addPortal(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal value)
    {
      this.portal.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public Entry addAllPortal(List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> value)
    {
      this.portal.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public Entry removePortal(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal value)
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
        "attributes": {
          "metaType": "object",
          "value": {
            "id": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          }
        },
        "value": {}
      },
      "name": "entry"
    }
  */