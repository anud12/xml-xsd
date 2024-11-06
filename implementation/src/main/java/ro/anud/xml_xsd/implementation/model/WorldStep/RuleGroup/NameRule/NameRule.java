package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule;
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
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class NameRule implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static NameRule fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new NameRule();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static NameRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<NameRule> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> NameRule.fromRawNode(o, parent)));
    }
    public static List<NameRule> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<NameRule> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> NameRule.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken> entry = new ArrayList<>();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<NameRule>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "name_rule";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken) {
          this.entry.remove(object);
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<NameRule> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing name_rule");
      //Deserialize arguments

      //Deserialize children
      this.entry = ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken.fromRawNode(rawNode.getChildrenList("entry"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("entry", entry.stream().map(ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing name_rule");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken> getEntry()
    {
      return this.entry;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken> streamEntry()
    {
      return entry.stream();
    }
    public NameRule addEntry(ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken value)
    {
      this.entry.add(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public NameRule addAllEntry(List<ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken> value)
    {
      this.entry.addAll(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public NameRule removeEntry(ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken value)
    {
      this.entry.remove(value);
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
        "isSingle": true,
        "value": {
          "entry": {
            "metaType": "reference",
            "value": "group__name_token",
            "isSingle": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "id": {
                  "metaType": "unknown",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "name_rule"
    }
  */