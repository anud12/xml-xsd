package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry;
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
  public class Entry implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

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
      return ".world_step.rule_group.property_rule.entry";
    }

    //Attributes

    private String id;

    private String units;

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault> personDefault = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault> itemDefault = Optional.empty();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold> propertyThreshold = new ArrayList<>();

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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule> parentAsPropertyRule() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault) {
          this.personDefault = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault) {
          this.itemDefault = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold) {
          this.propertyThreshold.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold) {
          return this.propertyThreshold.indexOf(object);
        }
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
          innerLogger.log("units");
          var unitsValue = rawNode.getAttributeRequired("units");
          if(Objects.equals(this.units, unitsValue)) {
            isDirty = true;
          }
          this.units = unitsValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.personDefault = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault.fromRawNode(rawNode.getChildrenFirst("person_default"), this);
          this.itemDefault = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault.fromRawNode(rawNode.getChildrenFirst("item_default"), this);
          this.propertyThreshold = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold.fromRawNode(rawNode.getChildrenList("property-threshold"), this);
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
          innerLogger.log("units");
          rawNode.setAttribute("units", this.units);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("person_default");
          rawNode.setChildren("person_default", personDefault.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault::serializeIntoRawNode).toList());
          innerLogger.log("item_default");
          rawNode.setChildren("item_default", itemDefault.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault::serializeIntoRawNode).toList());
          innerLogger.log("property-threshold");
          rawNode.setChildren("property-threshold", propertyThreshold.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold::serializeIntoRawNode).toList());
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
    public String getUnits()
    {
      return this.units;
    }
    public Entry setUnits(String value)
    {
      this.units = value;
      notifyChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault> getPersonDefault()
    {
      return this.personDefault;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault getPersonDefaultOrDefault()
    {
      return this.personDefault.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault();
        this.personDefault = Optional.of(instance);
        instance.parentNode(this);
        return this.personDefault.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault> streamPersonDefaultOrDefault()
    {
      return java.util.stream.Stream.of(getPersonDefaultOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault> streamPersonDefault()
    {
      return personDefault.stream();
    }
    public Entry setPersonDefault(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault value)
    {
      this.personDefault = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault> getItemDefault()
    {
      return this.itemDefault;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault getItemDefaultOrDefault()
    {
      return this.itemDefault.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault();
        this.itemDefault = Optional.of(instance);
        instance.parentNode(this);
        return this.itemDefault.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault> streamItemDefaultOrDefault()
    {
      return java.util.stream.Stream.of(getItemDefaultOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault> streamItemDefault()
    {
      return itemDefault.stream();
    }
    public Entry setItemDefault(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault value)
    {
      this.itemDefault = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold> getPropertyThreshold()
    {
      return this.propertyThreshold;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold> streamPropertyThreshold()
    {
      return propertyThreshold.stream();
    }
    public Entry addPropertyThreshold(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold value)
    {
      this.propertyThreshold.add(value);
      value.parentNode(this);
      return this;
    }
    public Entry addAllPropertyThreshold(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold> value)
    {
      this.propertyThreshold.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Entry removePropertyThreshold(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold value)
    {
      this.propertyThreshold.remove(value);
      value.clearParentNode();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault.nodeName))
        {
          if(this.personDefault.isEmpty()) {
            this.personDefault = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault.nodeName.length() + 3);
          return this.personDefault.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault.nodeName))
        {
          if(this.itemDefault.isEmpty()) {
            this.itemDefault = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault.nodeName.length() + 3);
          return this.itemDefault.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.propertyThreshold.size() > pathIndex) {
              return this.propertyThreshold.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addPropertyThreshold(newEntry);
          return linkedNode;
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault.nodeName))
        {
          if(this.personDefault.isEmpty()) {
            this.personDefault = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault.nodeName.length() + 3);
          return this.personDefault.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault.nodeName))
        {
          if(this.itemDefault.isEmpty()) {
            this.itemDefault = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault.nodeName.length() + 3);
          return this.itemDefault.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.propertyThreshold.size() > pathIndex) {
            return this.propertyThreshold.get(pathIndex).getNodeAtPath(childXPath);
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
        "attributes": {
          "metaType": "object",
          "value": {
            "id": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "units": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          }
        },
        "isSingle": false,
        "value": {
          "person_default": {
            "metaType": "composition",
            "value": [
              {
                "metaType": "object",
                "value": {},
                "isSingle": true,
                "isNullable": false
              },
              {
                "metaType": "primitive",
                "value": "type__math_operations"
              }
            ],
            "isSingle": true,
            "isNullable": true
          },
          "item_default": {
            "metaType": "composition",
            "value": [
              {
                "metaType": "object",
                "value": {},
                "isSingle": true,
                "isNullable": false
              },
              {
                "metaType": "primitive",
                "value": "type__math_operations"
              }
            ],
            "isSingle": true,
            "isNullable": true
          },
          "property-threshold": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "name": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "min-value-inclusive": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": true
                },
                "max-value-inclusive": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": true
                }
              }
            }
          }
        },
        "isNullable": true
      },
      "name": "entry"
    }
  */