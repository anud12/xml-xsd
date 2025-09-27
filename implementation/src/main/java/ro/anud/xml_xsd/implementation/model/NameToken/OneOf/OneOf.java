package ro.anud.xml_xsd.implementation.model.NameToken.OneOf;
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
  public class OneOf implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_nameToken.IType_nameToken<OneOf>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "one_of";
    public static OneOf fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new OneOf();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static OneOf fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<OneOf> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> OneOf.fromRawNode(o, parent)));
        }

    }
    public static List<OneOf> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<OneOf> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> OneOf.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".name_token.one_of";
    }

    //Attributes

    //Attributes of type__name_token

    //Children elements

    //Children of type__name_token
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> nameToken = new ArrayList<>();

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
      return "one_of";
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

    public Optional<ro.anud.xml_xsd.implementation.model.NameToken.NameToken> parentAsNameToken() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.NameToken.NameToken casted){
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
        // Godot.GD.Print("Deserializing one_of");

        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes

          // Deserialize arguments of type__name_token

        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children

          // Deserialize children of type__name_token
          this.nameToken = ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken.fromRawNode(rawNode.getChildrenList("name_token"), this);
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("one_of");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes

          // Serialize arguments of type__name_token

        }
        try (var innerLogger = logScope("children")) {

          //Serialize children

          // Serialize children of type__name_token
          innerLogger.log("name_token");
          rawNode.setChildren("name_token", nameToken.stream().map(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing one_of");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> getNameToken()
    {
      return this.nameToken;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> streamNameToken()
    {
      return nameToken.stream();
    }
    public OneOf addNameToken(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken value)
    {
      this.nameToken.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public OneOf addAllNameToken(List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> value)
    {
      this.nameToken.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public OneOf removeNameToken(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken value)
    {
      this.nameToken.remove(value);
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
          "value": {}
        },
        "value": {}
      },
      "name": "one_of"
    }
  */