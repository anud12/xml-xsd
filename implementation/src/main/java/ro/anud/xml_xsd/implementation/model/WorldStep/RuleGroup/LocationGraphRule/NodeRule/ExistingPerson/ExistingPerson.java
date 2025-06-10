package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.ExistingPerson;
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
  public class ExistingPerson implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "existing_person";
    public static ExistingPerson fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new ExistingPerson();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static ExistingPerson fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<ExistingPerson> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> ExistingPerson.fromRawNode(o, parent)));
    }
    public static List<ExistingPerson> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<ExistingPerson> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> ExistingPerson.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".world_step.rule_group.location_graph_rule.node_rule.existing_person";
    }

    //Attributes

    private Integer min;
    @Builder.Default
    private Optional<Integer> max = Optional.empty();

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection personSelection = new ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection();

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
      return "existing_person";
    }

    public void notifyChange(List<Object> list) {
      list.addLast(this);
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection) {
          throw new RuntimeException("trying to delete personSelection which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection) {
          return 0;
        }
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
      // Godot.GD.Print("Deserializing existing_person");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("min");
      this.min = rawNode.getAttributeIntRequired("min");
      innerLogger.log("max");
      this.max = rawNode.getAttributeInt("max");
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("person_selection");
      this.personSelection = ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.fromRawNode(rawNode.getChildrenFirst("person_selection").get(), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("existing_person");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("min");
      rawNode.setAttribute("min", this.min);
      innerLogger.log("max");
      this.max.ifPresent(o -> rawNode.setAttribute("max", o));

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("person_selection");
      rawNode.setChildren("person_selection", Optional.ofNullable(personSelection).stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing existing_person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public Integer getMin()
    {
      return this.min;
    }
    public ExistingPerson setMin(Integer value)
    {
      this.min = value;
      notifyChange();
      return this;
    }
    public Optional<Integer> getMax()
    {
      return this.max;
    }
    public ExistingPerson setMax(Optional<Integer> value)
    {
      this.max = value;
      notifyChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection getPersonSelection()
    {
      return this.personSelection;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection> streamPersonSelection()
    {
      return Optional.ofNullable(personSelection).stream();
    }
    public ExistingPerson setPersonSelection(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection value)
    {
      this.personSelection = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection.nodeName.length() + 3);
          return this.personSelection.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
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
        "isSingle": true,
        "value": {
          "person_selection": {
            "metaType": "reference",
            "value": "type__person_selection",
            "isSingle": true,
            "isNullable": false
          }
        },
        "isNullable": true
      },
      "name": "existing_person"
    }
  */