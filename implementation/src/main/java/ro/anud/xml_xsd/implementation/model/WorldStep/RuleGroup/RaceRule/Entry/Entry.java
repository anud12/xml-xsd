package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry;
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
  public class Entry implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Entry fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Entry();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Entry fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
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

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> vision = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> movement = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name> name = Optional.empty();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus> propertyBonus = new ArrayList<>();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> icon = Optional.empty();

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

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.RaceRule> parentAsRaceRule() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.RaceRule casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange) {
          this.vision = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange) {
          this.movement = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name) {
          this.name = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus) {
          this.propertyBonus.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon) {
          this.icon = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus) {
          return this.propertyBonus.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon) {
          return 0;
        }
        return 0;
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
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("vision");
      this.vision = ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange.fromRawNode(rawNode.getChildrenFirst("vision"), this);
      innerLogger.log("movement");
      this.movement = ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange.fromRawNode(rawNode.getChildrenFirst("movement"), this);
      this.name = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name.fromRawNode(rawNode.getChildrenFirst("name"), this);
      this.propertyBonus = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus.fromRawNode(rawNode.getChildrenList("property_bonus"), this);
      innerLogger.log("icon");
      this.icon = ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon.fromRawNode(rawNode.getChildrenFirst("icon"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("vision");
      rawNode.setChildren("vision", vision.stream().map(ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange::serializeIntoRawNode).toList());
      innerLogger.log("movement");
      rawNode.setChildren("movement", movement.stream().map(ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange::serializeIntoRawNode).toList());
      innerLogger.log("name");
      rawNode.setChildren("name", name.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name::serializeIntoRawNode).toList());
      innerLogger.log("property_bonus");
      rawNode.setChildren("property_bonus", propertyBonus.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus::serializeIntoRawNode).toList());
      innerLogger.log("icon");
      rawNode.setChildren("icon", icon.stream().map(ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon::serializeIntoRawNode).toList());
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
    public Optional<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> getVision()
    {
      return this.vision;
    }
    public ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange getVisionOrDefault()
    {
      return this.vision.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange();
        instance.parentNode(this);
        this.vision = Optional.of(instance);
        return this.vision.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> streamVisionOrDefault()
    {
      return java.util.stream.Stream.of(getVisionOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> streamVision()
    {
      return vision.stream();
    }
    public Entry setVision(ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange value)
    {
      this.vision = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> getMovement()
    {
      return this.movement;
    }
    public ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange getMovementOrDefault()
    {
      return this.movement.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange();
        instance.parentNode(this);
        this.movement = Optional.of(instance);
        return this.movement.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> streamMovementOrDefault()
    {
      return java.util.stream.Stream.of(getMovementOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> streamMovement()
    {
      return movement.stream();
    }
    public Entry setMovement(ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange value)
    {
      this.movement = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name> getName()
    {
      return this.name;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name getNameOrDefault()
    {
      return this.name.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name();
        instance.parentNode(this);
        this.name = Optional.of(instance);
        return this.name.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name> streamNameOrDefault()
    {
      return java.util.stream.Stream.of(getNameOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name> streamName()
    {
      return name.stream();
    }
    public Entry setName(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name value)
    {
      this.name = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus> getPropertyBonus()
    {
      return this.propertyBonus;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus> streamPropertyBonus()
    {
      return propertyBonus.stream();
    }
    public Entry addPropertyBonus(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus value)
    {
      this.propertyBonus.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Entry addAllPropertyBonus(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus> value)
    {
      this.propertyBonus.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Entry removePropertyBonus(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus value)
    {
      this.propertyBonus.remove(value);
      triggerOnChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> getIcon()
    {
      return this.icon;
    }
    public ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon getIconOrDefault()
    {
      return this.icon.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon();
        instance.parentNode(this);
        this.icon = Optional.of(instance);
        return this.icon.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> streamIconOrDefault()
    {
      return java.util.stream.Stream.of(getIconOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> streamIcon()
    {
      return icon.stream();
    }
    public Entry setIcon(ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon value)
    {
      this.icon = Optional.ofNullable(value);
      value.parentNode(this);
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
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "vision": {
            "metaType": "reference",
            "value": "type_range",
            "isSingle": true,
            "isNullable": true
          },
          "movement": {
            "metaType": "reference",
            "value": "type_range",
            "isSingle": true,
            "isNullable": true
          },
          "name": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "name_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "property_bonus": {
            "metaType": "composition",
            "value": [
              {
                "metaType": "object",
                "value": {},
                "isSingle": true,
                "isNullable": false,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "property_rule_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              },
              {
                "metaType": "primitive",
                "value": "type__math_operations"
              }
            ],
            "isSingle": false,
            "isNullable": true
          },
          "icon": {
            "metaType": "reference",
            "value": "type_icon",
            "isSingle": true,
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "entry"
    }
  */