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

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class OneOf implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_nameToken.IType_nameToken<OneOf>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static OneOf fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new OneOf();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static OneOf fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<OneOf> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> OneOf.fromRawNode(o, parent)));
    }
    public static List<OneOf> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<OneOf> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> OneOf.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/name_token/one_of";
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

    public void childChanged(List<Object> list) {
      list.addLast(this);
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(list));
    }

    private void triggerOnChange() {
      childChanged(new ArrayList<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
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
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing one_of");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes

      // Deserialize arguments of type__name_token

      innerLogger = logger.log("children");
      //Deserialize children

      // Deserialize children of type__name_token
      this.nameToken = ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken.fromRawNode(rawNode.getChildrenList("name_token"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("one_of");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      // Serialize arguments of type__name_token


      innerLogger = logger.log("children");
      //Serialize children

      // Serialize children of type__name_token
      innerLogger.log("name_token");
      rawNode.setChildren("name_token", nameToken.stream().map(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken::serializeIntoRawNode).toList());
      return rawNode;
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
      triggerOnChange();
      return this;
    }
    public OneOf addAllNameToken(List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> value)
    {
      this.nameToken.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public OneOf removeNameToken(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken value)
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
        "attributes": {
          "metaType": "object",
          "value": {}
        },
        "value": {}
      },
      "name": "one_of"
    }
  */