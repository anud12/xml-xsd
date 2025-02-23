package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection;
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
  public class Selection implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection.IType_personSelection<Selection>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static final String TYPE_ID = "/world_step/rule_group/action_rule/from_person/on_person/selection";

    public static Selection fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Selection();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Selection fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Selection> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Selection.fromRawNode(o, parent)));
    }
    public static List<Selection> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Selection> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Selection.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Attributes of type__person_selection

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode> fromPersonSameLocationGraphNode = Optional.empty();

    //Children of type__person_selection
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> radius = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> min = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> max = Optional.empty();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> property = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> classification = new ArrayList<>();

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
      return "selection";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson> parentAsOnPerson() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode) {
          this.fromPersonSameLocationGraphNode = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode) {
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
      // Godot.GD.Print("Deserializing selection");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes

      // Deserialize arguments of type__person_selection

      innerLogger = logger.log("children");
      //Deserialize children
      this.fromPersonSameLocationGraphNode = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode.fromRawNode(rawNode.getChildrenFirst("from_person_same_location_graph_node"), this);

      // Deserialize children of type__person_selection
      innerLogger.log("radius");
      this.radius = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("radius"), this);
      innerLogger.log("min");
      this.min = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("min"), this);
      innerLogger.log("max");
      this.max = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("max"), this);
      this.property = ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property.fromRawNode(rawNode.getChildrenList("property"), this);
      this.classification = ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification.fromRawNode(rawNode.getChildrenList("classification"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      // Serialize arguments of type__person_selection


      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("from_person_same_location_graph_node");
      rawNode.setChildren("from_person_same_location_graph_node", fromPersonSameLocationGraphNode.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode::serializeIntoRawNode).toList());

      // Serialize children of type__person_selection
      innerLogger.log("radius");
      rawNode.setChildren("radius", radius.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      innerLogger.log("min");
      rawNode.setChildren("min", min.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      innerLogger.log("max");
      rawNode.setChildren("max", max.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      innerLogger.log("property");
      rawNode.setChildren("property", property.stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property::serializeIntoRawNode).toList());
      innerLogger.log("classification");
      rawNode.setChildren("classification", classification.stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing selection");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode> getFromPersonSameLocationGraphNode()
    {
      return this.fromPersonSameLocationGraphNode;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode getFromPersonSameLocationGraphNodeOrDefault()
    {
      return this.fromPersonSameLocationGraphNode.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode();
        instance.parentNode(this);
        this.fromPersonSameLocationGraphNode = Optional.of(instance);
        return this.fromPersonSameLocationGraphNode.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode> streamFromPersonSameLocationGraphNodeOrDefault()
    {
      return java.util.stream.Stream.of(getFromPersonSameLocationGraphNodeOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode> streamFromPersonSameLocationGraphNode()
    {
      return fromPersonSameLocationGraphNode.stream();
    }
    public Selection setFromPersonSameLocationGraphNode(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode value)
    {
      this.fromPersonSameLocationGraphNode = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getRadius()
    {
      return this.radius;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getRadiusOrDefault()
    {
      return this.radius.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        instance.parentNode(this);
        this.radius = Optional.of(instance);
        return this.radius.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamRadiusOrDefault()
    {
      return java.util.stream.Stream.of(getRadiusOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamRadius()
    {
      return radius.stream();
    }
    public Selection setRadius(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.radius = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMin()
    {
      return this.min;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getMinOrDefault()
    {
      return this.min.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        instance.parentNode(this);
        this.min = Optional.of(instance);
        return this.min.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMinOrDefault()
    {
      return java.util.stream.Stream.of(getMinOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMin()
    {
      return min.stream();
    }
    public Selection setMin(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.min = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMax()
    {
      return this.max;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getMaxOrDefault()
    {
      return this.max.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        instance.parentNode(this);
        this.max = Optional.of(instance);
        return this.max.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMaxOrDefault()
    {
      return java.util.stream.Stream.of(getMaxOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMax()
    {
      return max.stream();
    }
    public Selection setMax(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.max = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> getProperty()
    {
      return this.property;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> streamProperty()
    {
      return property.stream();
    }
    public Selection addProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value)
    {
      this.property.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Selection addAllProperty(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> value)
    {
      this.property.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Selection removeProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value)
    {
      this.property.remove(value);
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> getClassification()
    {
      return this.classification;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> streamClassification()
    {
      return classification.stream();
    }
    public Selection addClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value)
    {
      this.classification.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Selection addAllClassification(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> value)
    {
      this.classification.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Selection removeClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value)
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
        "attributes": {
          "metaType": "object",
          "value": {}
        },
        "value": {
          "from_person_same_location_graph_node": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "value": {
                  "metaType": "primitive",
                  "value": "xs:boolean",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          }
        }
      },
      "name": "selection"
    }
  */