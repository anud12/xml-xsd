package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry;
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

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
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

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> vision = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> movement = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name> name = Optional.empty();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus> propertyBonus = new ArrayList<>();
    private Optional<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> icon = Optional.empty();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<Entry>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "entry";
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getParentNode() {
      return parentNode;
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
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

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Entry> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      this.id = rawNode.getAttributeRequired("id");

      //Deserialize children
      this.vision = ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange.fromRawNode(rawNode.getChildrenFirst("vision"), this);
      this.movement = ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange.fromRawNode(rawNode.getChildrenFirst("movement"), this);
      this.name = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name.fromRawNode(rawNode.getChildrenFirst("name"), this);
      this.propertyBonus = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus.fromRawNode(rawNode.getChildrenList("property_bonus"), this);
      this.icon = ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon.fromRawNode(rawNode.getChildrenFirst("icon"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("id", this.id);

      //Serialize children
      rawNode.setChildren("vision", vision.stream().map(o -> o.serializeIntoRawNode()).toList());
      rawNode.setChildren("movement", movement.stream().map(o -> o.serializeIntoRawNode()).toList());
      rawNode.setChildren("name", name.stream().map(o -> o.serializeIntoRawNode()).toList());
      rawNode.setChildren("property_bonus", propertyBonus.stream().map(o -> o.serializeIntoRawNode()).toList());
      rawNode.setChildren("icon", icon.stream().map(o -> o.serializeIntoRawNode()).toList());
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
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> getVision()
    {
      return this.vision;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> streamVision()
    {
      return vision.stream();
    }
    public Entry setVision(ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange value)
    {
      this.vision = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> getMovement()
    {
      return this.movement;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange> streamMovement()
    {
      return movement.stream();
    }
    public Entry setMovement(ro.anud.xml_xsd.implementation.model.TypeRange.TypeRange value)
    {
      this.movement = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name> getName()
    {
      return this.name;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name> streamName()
    {
      return name.stream();
    }
    public Entry setName(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Name.Name value)
    {
      this.name = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus> getPropertyBonus()
    {
      return this.propertyBonus;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus> streamPropertyBonus()
    {
      return propertyBonus.stream();
    }
    public Entry addPropertyBonus(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus value)
    {
      this.propertyBonus.add(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Entry addAllPropertyBonus(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus> value)
    {
      this.propertyBonus.addAll(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Entry removePropertyBonus(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus value)
    {
      this.propertyBonus.remove(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> getIcon()
    {
      return this.icon;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> streamIcon()
    {
      return icon.stream();
    }
    public Entry setIcon(ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon value)
    {
      this.icon = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
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