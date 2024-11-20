package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry;
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
  public class Entry implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Entry fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Entry();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Entry fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
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

    //Attributes
    private String id;
    private String units;

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault> personDefault = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault> itemDefault = Optional.empty();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold> propertyThreshold = new ArrayList<>();

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
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    @Builder.Default
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "entry";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault) {
          this.personDefault = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault) {
          this.itemDefault = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold) {
          this.propertyThreshold.remove(object);
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Set<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing entry");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("id");
      this.id = rawNode.getAttributeRequired("id");
      innerLogger.log("units");
      this.units = rawNode.getAttributeRequired("units");
      innerLogger = logger.log("children");
      //Deserialize children
      this.personDefault = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault.fromRawNode(rawNode.getChildrenFirst("person_default"), this);
      this.itemDefault = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault.fromRawNode(rawNode.getChildrenFirst("item_default"), this);
      this.propertyThreshold = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold.fromRawNode(rawNode.getChildrenList("property-threshold"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);
      innerLogger.log("units");
      rawNode.setAttribute("units", this.units);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("person_default");
      rawNode.setChildren("person_default", personDefault.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault::serializeIntoRawNode).toList());
      innerLogger.log("item_default");
      rawNode.setChildren("item_default", itemDefault.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault::serializeIntoRawNode).toList());
      innerLogger.log("property-threshold");
      rawNode.setChildren("property-threshold", propertyThreshold.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold::serializeIntoRawNode).toList());
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
      triggerOnChange();
      return this;
    }
    public String getUnits()
    {
      return this.units;
    }
    public Entry setUnits(String value)
    {
      this.units = value;
      triggerOnChange();
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
        instance.setParentNode(this);
        this.personDefault = Optional.of(instance);
        return this.personDefault.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault> streamPersonDefaultOrDefault()
    {
      return Stream.of(getPersonDefaultOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault> streamPersonDefault()
    {
      return personDefault.stream();
    }
    public Entry setPersonDefault(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault.PersonDefault value)
    {
      this.personDefault = Optional.ofNullable(value);
      value.setParentNode(this);
      triggerOnChange();
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
        instance.setParentNode(this);
        this.itemDefault = Optional.of(instance);
        return this.itemDefault.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault> streamItemDefaultOrDefault()
    {
      return Stream.of(getItemDefaultOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault> streamItemDefault()
    {
      return itemDefault.stream();
    }
    public Entry setItemDefault(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.ItemDefault.ItemDefault value)
    {
      this.itemDefault = Optional.ofNullable(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold> getPropertyThreshold()
    {
      return this.propertyThreshold;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold> streamPropertyThreshold()
    {
      return propertyThreshold.stream();
    }
    public Entry addPropertyThreshold(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold value)
    {
      this.propertyThreshold.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Entry addAllPropertyThreshold(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold> value)
    {
      this.propertyThreshold.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Entry removePropertyThreshold(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PropertyThreshold.PropertyThreshold value)
    {
      this.propertyThreshold.remove(value);
      triggerOnChange();
      return this;
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