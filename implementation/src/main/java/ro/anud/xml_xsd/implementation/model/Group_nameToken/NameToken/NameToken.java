package ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken;
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
  public class NameToken implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static NameToken fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new NameToken();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static NameToken fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<NameToken> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> NameToken.fromRawNode(o, parent)));
    }
    public static List<NameToken> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<NameToken> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> NameToken.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String prefix;

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref> _ref = Optional.empty();
    private ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken oneOf = new ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken();

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
    private List<Consumer<NameToken>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "name_token";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref) {
          this._ref = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken) {
          throw new RuntimeException("trying to delete oneOf which is required");
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<NameToken> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing name_token");
      //Deserialize arguments
      this.prefix = rawNode.getAttributeRequired("prefix");

      //Deserialize children
      this._ref = ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref.fromRawNode(rawNode.getChildrenFirst("ref"), this);
      this.oneOf = ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken.fromRawNode(rawNode.getChildrenFirst("one_of").get(), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("prefix", this.prefix);

      //Serialize children
      rawNode.setChildren("ref", _ref.stream().map(ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref::serializeIntoRawNode).toList());
      rawNode.setChildren("one_of", Optional.ofNullable(oneOf).stream().map(ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing name_token");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPrefix()
    {
      return this.prefix;
    }
    public NameToken setPrefix(String value)
    {
      this.prefix = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref> get_ref()
    {
      return this._ref;
    }
    public ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref get_refOrDefault()
    {
      return this._ref.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref();
        instance.setParentNode(this);
        this._ref = Optional.of(instance);
        return this._ref.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref> stream_ref()
    {
      return _ref.stream();
    }
    public NameToken set_ref(ro.anud.xml_xsd.implementation.model.Group_nameToken.NameToken._ref._ref value)
    {
      this._ref = Optional.ofNullable(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken getOneOf()
    {
      return this.oneOf;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken> streamOneOf()
    {
      return Optional.ofNullable(oneOf).stream();
    }
    public NameToken setOneOf(ro.anud.xml_xsd.implementation.model.Group_nameToken.Group_nameToken value)
    {
      this.oneOf = value;
      value.setParentNode(this);
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
            "prefix": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "value": {
          "ref": {
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
          "one_of": {
            "metaType": "reference",
            "value": "group__name_token",
            "isSingle": true,
            "isNullable": false
          }
        }
      },
      "name": "name_token"
    }
  */