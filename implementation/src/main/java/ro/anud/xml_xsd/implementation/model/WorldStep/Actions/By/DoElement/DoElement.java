package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement;
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
  public class DoElement implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static DoElement fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new DoElement();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static DoElement fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<DoElement> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> DoElement.fromRawNode(o, parent)));
    }
    public static List<DoElement> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<DoElement> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> DoElement.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/world_step/actions/by/do";
    }

    //Attributes
    @Builder.Default
    private Optional<String> actionRuleRef = Optional.empty();
    @Builder.Default
    private Optional<String> actionRef = Optional.empty();

    private String personRef;

    //Children elements

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
      return "do";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By> parentAsBy() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.By casted){
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
      // Godot.GD.Print("Deserializing do");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("action_rule_ref");
      this.actionRuleRef = rawNode.getAttribute("action_rule_ref");
      innerLogger.log("action_ref");
      this.actionRef = rawNode.getAttribute("action_ref");
      innerLogger.log("person_ref");
      this.personRef = rawNode.getAttributeRequired("person_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("do");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("action_rule_ref");
      this.actionRuleRef.ifPresent(o -> rawNode.setAttribute("action_rule_ref", o));
      innerLogger.log("action_ref");
      this.actionRef.ifPresent(o -> rawNode.setAttribute("action_ref", o));
      innerLogger.log("person_ref");
      rawNode.setAttribute("person_ref", this.personRef);

      innerLogger = logger.log("children");
      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing do");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public Optional<String> getActionRuleRef()
    {
      return this.actionRuleRef;
    }
    public DoElement setActionRuleRef(Optional<String> value)
    {
      this.actionRuleRef = value;
      triggerOnChange();
      return this;
    }
    public Optional<String> getActionRef()
    {
      return this.actionRef;
    }
    public DoElement setActionRef(Optional<String> value)
    {
      this.actionRef = value;
      triggerOnChange();
      return this;
    }
    public String getPersonRef()
    {
      return this.personRef;
    }
    public DoElement setPersonRef(String value)
    {
      this.personRef = value;
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
        "value": {},
        "isSingle": true,
        "isNullable": false,
        "attributes": {
          "metaType": "object",
          "value": {
            "action_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": true
            },
            "action_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": true
            },
            "person_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          }
        }
      },
      "name": "do"
    }
  */