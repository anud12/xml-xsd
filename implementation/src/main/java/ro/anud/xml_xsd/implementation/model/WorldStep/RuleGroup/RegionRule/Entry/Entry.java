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

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Entry implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_regionRule.IType_regionRule<Entry>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "entry";
    public static Entry fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Entry();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Entry fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Entry> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Entry.fromRawNode(o, parent)));
        }

    }
    public static List<Entry> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Entry> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Entry.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
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
    private Optional<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> portals = Optional.empty();

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
          innerLogger.log("id");
          var idValue = rawNode.getAttributeRequired("id");
          if(Objects.equals(this.id, idValue)) {
            isDirty = true;
          }
          this.id = idValue;

          // Deserialize arguments of type__region_rule

        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children

          // Deserialize children of type__region_rule
          this.limit = ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit.fromRawNode(rawNode.getChildrenFirst("limit").get(), this);
          this.portals = ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals.fromRawNode(rawNode.getChildrenFirst("portals"), this);
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
        rawNode.setTag("entry");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("id");
          rawNode.setAttribute("id", this.id);

          // Serialize arguments of type__region_rule

        }
        try (var innerLogger = logScope("children")) {

          //Serialize children

          // Serialize children of type__region_rule
          innerLogger.log("limit");
          rawNode.setChildren("limit", Optional.ofNullable(limit).stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit::serializeIntoRawNode).toList());
          innerLogger.log("portals");
          rawNode.setChildren("portals", portals.stream().map(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
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

    public Optional<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> getPortals()
    {
      return this.portals;
    }
    public ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals getPortalsOrDefault()
    {
      return this.portals.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals();
        this.portals = Optional.of(instance);
        instance.parentNode(this);
        return this.portals.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> streamPortalsOrDefault()
    {
      return java.util.stream.Stream.of(getPortalsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> streamPortals()
    {
      return portals.stream();
    }
    public Entry setPortals(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals value)
    {
      this.portals = Optional.ofNullable(value);
      value.parentNode(this);
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