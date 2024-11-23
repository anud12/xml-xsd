package ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken;
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
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref> _ref = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf> oneOf = Optional.empty();

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
      return "name_token";
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref) {
          this._ref = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf) {
          this.oneOf = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf) {
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
      // Godot.GD.Print("Deserializing name_token");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("prefix");
      this.prefix = rawNode.getAttributeRequired("prefix");
      innerLogger = logger.log("children");
      //Deserialize children
      this._ref = ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref.fromRawNode(rawNode.getChildrenFirst("ref"), this);
      this.oneOf = ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf.fromRawNode(rawNode.getChildrenFirst("one_of"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("prefix");
      rawNode.setAttribute("prefix", this.prefix);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("ref");
      rawNode.setChildren("ref", _ref.stream().map(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref::serializeIntoRawNode).toList());
      innerLogger.log("one_of");
      rawNode.setChildren("one_of", oneOf.stream().map(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf::serializeIntoRawNode).toList());
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
      triggerOnChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref> get_ref()
    {
      return this._ref;
    }
    public ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref get_refOrDefault()
    {
      return this._ref.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref();
        instance.setParentNode(this);
        this._ref = Optional.of(instance);
        return this._ref.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref> stream_refOrDefault()
    {
      return Stream.of(get_refOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref> stream_ref()
    {
      return _ref.stream();
    }
    public NameToken set_ref(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken._ref._ref value)
    {
      this._ref = Optional.ofNullable(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf> getOneOf()
    {
      return this.oneOf;
    }
    public ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf getOneOfOrDefault()
    {
      return this.oneOf.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf();
        instance.setParentNode(this);
        this.oneOf = Optional.of(instance);
        return this.oneOf.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf> streamOneOfOrDefault()
    {
      return Stream.of(getOneOfOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf> streamOneOf()
    {
      return oneOf.stream();
    }
    public NameToken setOneOf(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.OneOf.OneOf value)
    {
      this.oneOf = Optional.ofNullable(value);
      value.setParentNode(this);
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
                "value": "type__name_token"
              }
            ],
            "isSingle": true,
            "isNullable": true
          }
        }
      },
      "name": "name_token"
    }
  */