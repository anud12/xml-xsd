package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Entry;
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
  public class Entry implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_action.IType_action<Entry>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

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

    //Attributes of type__action

    //Children elements

    //Children of type__action
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_action.From.From from = new ro.anud.xml_xsd.implementation.model.Type_action.From.From();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_action.On.On on = new ro.anud.xml_xsd.implementation.model.Type_action.On.On();


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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global> parentAsGlobal() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.Global.Global casted){
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

      // Deserialize arguments of type__action

      innerLogger = logger.log("children");
      //Deserialize children

      // Deserialize children of type__action
      this.from = ro.anud.xml_xsd.implementation.model.Type_action.From.From.fromRawNode(rawNode.getChildrenFirst("from").get(), this);
      this.on = ro.anud.xml_xsd.implementation.model.Type_action.On.On.fromRawNode(rawNode.getChildrenFirst("on").get(), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);

      // Serialize arguments of type__action


      innerLogger = logger.log("children");
      //Serialize children

      // Serialize children of type__action
      innerLogger.log("from");
      rawNode.setChildren("from", Optional.ofNullable(from).stream().map(ro.anud.xml_xsd.implementation.model.Type_action.From.From::serializeIntoRawNode).toList());
      innerLogger.log("on");
      rawNode.setChildren("on", Optional.ofNullable(on).stream().map(ro.anud.xml_xsd.implementation.model.Type_action.On.On::serializeIntoRawNode).toList());
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
    public ro.anud.xml_xsd.implementation.model.Type_action.From.From getFrom()
    {
      return this.from;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_action.From.From> streamFrom()
    {
      return Optional.ofNullable(from).stream();
    }
    public Entry setFrom(ro.anud.xml_xsd.implementation.model.Type_action.From.From value)
    {
      this.from = value;
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.Type_action.On.On getOn()
    {
      return this.on;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_action.On.On> streamOn()
    {
      return Optional.ofNullable(on).stream();
    }
    public Entry setOn(ro.anud.xml_xsd.implementation.model.Type_action.On.On value)
    {
      this.on = value;
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
          }
        },
        "value": {}
      },
      "name": "entry"
    }
  */