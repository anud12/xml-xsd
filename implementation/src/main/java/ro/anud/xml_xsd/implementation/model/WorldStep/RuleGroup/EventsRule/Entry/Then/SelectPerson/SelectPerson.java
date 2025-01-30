package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.SelectPerson;
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
  public class SelectPerson implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection.IType_personSelection<SelectPerson>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static SelectPerson fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new SelectPerson();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static SelectPerson fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<SelectPerson> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> SelectPerson.fromRawNode(o, parent)));
    }
    public static List<SelectPerson> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<SelectPerson> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> SelectPerson.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/world_step/rule_group/events_rule/entry/then/select_person";
    }

    //Attributes
    /* ignored attribute key={key} of type=origin*/

    //Attributes of type__person_selection

    //Children elements

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
    private List<Consumer<List<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "select_person";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then> parentAsThen() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then casted){
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
      // Godot.GD.Print("Deserializing select_person");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes

      // Deserialize arguments of type__person_selection

      innerLogger = logger.log("children");
      //Deserialize children

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
      rawNode.setTag("select_person");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      // Serialize arguments of type__person_selection


      innerLogger = logger.log("children");
      //Serialize children

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
        // Godot.GD.Print("Serializing select_person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    /* ignored attribute key={key} of type=origin*/
    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getRadius()
    {
      return this.radius;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getRadiusOrDefault()
    {
      return this.radius.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        this.radius = Optional.of(instance);
        instance.parentNode(this);
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
    public SelectPerson setRadius(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
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
        this.min = Optional.of(instance);
        instance.parentNode(this);
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
    public SelectPerson setMin(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
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
        this.max = Optional.of(instance);
        instance.parentNode(this);
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
    public SelectPerson setMax(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
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
    public SelectPerson addProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value)
    {
      this.property.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public SelectPerson addAllProperty(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> value)
    {
      this.property.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public SelectPerson removeProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value)
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
    public SelectPerson addClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value)
    {
      this.classification.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public SelectPerson addAllClassification(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> value)
    {
      this.classification.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public SelectPerson removeClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value)
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
          "value": {
            "origin": {
              "metaType": "union",
              "value": [
                {
                  "metaType": "primitive",
                  "value": "\"target\""
                },
                {
                  "metaType": "primitive",
                  "value": "\"self\""
                }
              ]
            }
          }
        },
        "value": {}
      },
      "name": "select_person"
    }
  */