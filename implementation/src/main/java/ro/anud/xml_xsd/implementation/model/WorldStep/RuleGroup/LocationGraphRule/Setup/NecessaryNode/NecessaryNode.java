package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode;
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
  public class NecessaryNode implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static final String TYPE_ID = "/world_step/rule_group/location_graph_rule/setup/necessary_node";

    public static NecessaryNode fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new NecessaryNode();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static NecessaryNode fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<NecessaryNode> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> NecessaryNode.fromRawNode(o, parent)));
    }
    public static List<NecessaryNode> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<NecessaryNode> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> NecessaryNode.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    private String nodeRuleRef;

    private Integer min;
    @Builder.Default
    private Optional<Integer> max = Optional.empty();

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or> or = new ArrayList<>();

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
      return "necessary_node";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.Setup> parentAsSetup() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.Setup casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or) {
          this.or.remove(object);
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or) {
          return this.or.indexOf(object);
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
      // Godot.GD.Print("Deserializing necessary_node");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("node_rule_ref");
      this.nodeRuleRef = rawNode.getAttributeRequired("node_rule_ref");
      innerLogger.log("min");
      this.min = rawNode.getAttributeIntRequired("min");
      innerLogger.log("max");
      this.max = rawNode.getAttributeInt("max");
      innerLogger = logger.log("children");
      //Deserialize children
      this.or = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or.fromRawNode(rawNode.getChildrenList("or"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("node_rule_ref");
      rawNode.setAttribute("node_rule_ref", this.nodeRuleRef);
      innerLogger.log("min");
      rawNode.setAttribute("min", this.min);
      innerLogger.log("max");
      this.max.ifPresent(o -> rawNode.setAttribute("max", o));

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("or");
      rawNode.setChildren("or", or.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing necessary_node");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getNodeRuleRef()
    {
      return this.nodeRuleRef;
    }
    public NecessaryNode setNodeRuleRef(String value)
    {
      this.nodeRuleRef = value;
      triggerOnChange();
      return this;
    }
    public Integer getMin()
    {
      return this.min;
    }
    public NecessaryNode setMin(Integer value)
    {
      this.min = value;
      triggerOnChange();
      return this;
    }
    public Optional<Integer> getMax()
    {
      return this.max;
    }
    public NecessaryNode setMax(Optional<Integer> value)
    {
      this.max = value;
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or> getOr()
    {
      return this.or;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or> streamOr()
    {
      return or.stream();
    }
    public NecessaryNode addOr(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or value)
    {
      this.or.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public NecessaryNode addAllOr(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or> value)
    {
      this.or.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public NecessaryNode removeOr(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.Or.Or value)
    {
      this.or.remove(value);
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
            "node_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "min": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            },
            "max": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": true
            }
          }
        },
        "isSingle": false,
        "value": {
          "or": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "node_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          }
        },
        "isNullable": true
      },
      "name": "necessary_node"
    }
  */