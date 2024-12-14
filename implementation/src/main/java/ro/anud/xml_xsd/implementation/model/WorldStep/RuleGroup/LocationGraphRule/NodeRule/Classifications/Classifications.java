package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications;
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
  public class Classifications implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Classifications fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Classifications();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Classifications fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Classifications> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Classifications.fromRawNode(o, parent)));
    }
    public static List<Classifications> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Classifications> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Classifications.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification> classification = new ArrayList<>();

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
      return "classifications";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.NodeRule> parentAsNodeRule() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.NodeRule casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification) {
          this.classification.remove(object);
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification) {
          return this.classification.indexOf(object);
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
      // Godot.GD.Print("Deserializing classifications");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.classification = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification.fromRawNode(rawNode.getChildrenList("classification"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("classification");
      rawNode.setChildren("classification", classification.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing classifications");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification> getClassification()
    {
      return this.classification;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification> streamClassification()
    {
      return classification.stream();
    }
    public Classifications addClassification(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification value)
    {
      this.classification.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Classifications addAllClassification(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification> value)
    {
      this.classification.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Classifications removeClassification(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classification.Classification value)
    {
      this.classification.remove(value);
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
          "classification": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "location_classification_rule_ref": {
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
      "name": "classifications"
    }
  */