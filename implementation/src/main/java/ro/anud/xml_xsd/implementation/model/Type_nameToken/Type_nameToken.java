package ro.anud.xml_xsd.implementation.model.Type_nameToken;
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
  public class Type_nameToken implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Type_nameToken fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_nameToken();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Type_nameToken fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Type_nameToken> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Type_nameToken.fromRawNode(o, parent)));
    }
    public static List<Type_nameToken> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Type_nameToken> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Type_nameToken.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> nameToken = new ArrayList<>();

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
      return "type__name_token";
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken) {
          throw new RuntimeException("trying to delete nameToken which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken) {
          return this.nameToken.indexOf(object);
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
      // Godot.GD.Print("Deserializing type__name_token");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.nameToken = ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken.fromRawNode(rawNode.getChildrenList("name_token"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("name_token");
      rawNode.setChildren("name_token", nameToken.stream().map(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__name_token");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> getNameToken()
    {
      return this.nameToken;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> streamNameToken()
    {
      return nameToken.stream();
    }
    public Type_nameToken addNameToken(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken value)
    {
      this.nameToken.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Type_nameToken addAllNameToken(List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> value)
    {
      this.nameToken.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Type_nameToken removeNameToken(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken value)
    {
      this.nameToken.remove(value);
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
        "isSingle": false,
        "value": {
          "name_token": {
            "metaType": "union",
            "value": [
              {
                "metaType": "object",
                "isSingle": true,
                "isNullable": true,
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
                  }
                }
              },
              {
                "metaType": "object",
                "isSingle": true,
                "isNullable": true,
                "value": {
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
              }
            ],
            "isSingle": false,
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
            "isNullable": false
          }
        }
      },
      "name": "type__name_token"
    }
  */