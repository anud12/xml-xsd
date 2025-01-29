package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup;
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
  public class Setup implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Setup fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Setup();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Setup fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Setup> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Setup.fromRawNode(o, parent)));
    }
    public static List<Setup> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Setup> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Setup.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/world_step/rule_group/location_graph_rule/setup";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.StartingNode.StartingNode startingNode = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.StartingNode.StartingNode();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode> necessaryNode = new ArrayList<>();

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
      return "setup";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> parentAsLocationGraphRule() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.StartingNode.StartingNode) {
          throw new RuntimeException("trying to delete startingNode which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode) {
          this.necessaryNode.remove(object);
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.StartingNode.StartingNode) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode) {
          return this.necessaryNode.indexOf(object);
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
      // Godot.GD.Print("Deserializing setup");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.startingNode = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.StartingNode.StartingNode.fromRawNode(rawNode.getChildrenFirst("starting_node").get(), this);
      this.necessaryNode = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode.fromRawNode(rawNode.getChildrenList("necessary_node"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("setup");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("starting_node");
      rawNode.setChildren("starting_node", Optional.ofNullable(startingNode).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.StartingNode.StartingNode::serializeIntoRawNode).toList());
      innerLogger.log("necessary_node");
      rawNode.setChildren("necessary_node", necessaryNode.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing setup");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.StartingNode.StartingNode getStartingNode()
    {
      return this.startingNode;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.StartingNode.StartingNode> streamStartingNode()
    {
      return Optional.ofNullable(startingNode).stream();
    }
    public Setup setStartingNode(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.StartingNode.StartingNode value)
    {
      this.startingNode = value;
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode> getNecessaryNode()
    {
      return this.necessaryNode;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode> streamNecessaryNode()
    {
      return necessaryNode.stream();
    }
    public Setup addNecessaryNode(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode value)
    {
      this.necessaryNode.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Setup addAllNecessaryNode(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode> value)
    {
      this.necessaryNode.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Setup removeNecessaryNode(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.Setup.NecessaryNode.NecessaryNode value)
    {
      this.necessaryNode.remove(value);
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
        "isSingle": true,
        "value": {
          "starting_node": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
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
          },
          "necessary_node": {
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
          }
        },
        "isNullable": false
      },
      "name": "setup"
    }
  */