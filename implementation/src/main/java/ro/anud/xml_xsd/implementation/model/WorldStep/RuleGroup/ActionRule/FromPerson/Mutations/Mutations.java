package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations;
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
  public class Mutations implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Mutations fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Mutations();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Mutations fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Mutations> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Mutations.fromRawNode(o, parent)));
    }
    public static List<Mutations> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Mutations> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Mutations.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> propertyMutation = new ArrayList<>();

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
      return "mutations";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson> parentAsFromPerson() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation) {
          this.propertyMutation.remove(object);
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation) {
          return this.propertyMutation.indexOf(object);
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
      // Godot.GD.Print("Deserializing mutations");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("property_mutation");
      this.propertyMutation = ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation.fromRawNode(rawNode.getChildrenList("property_mutation"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("property_mutation");
      rawNode.setChildren("property_mutation", propertyMutation.stream().map(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing mutations");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> getPropertyMutation()
    {
      return this.propertyMutation;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> streamPropertyMutation()
    {
      return propertyMutation.stream();
    }
    public Mutations addPropertyMutation(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation value)
    {
      this.propertyMutation.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public Mutations addAllPropertyMutation(List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> value)
    {
      this.propertyMutation.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public Mutations removePropertyMutation(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation value)
    {
      this.propertyMutation.remove(value);
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
          "property_mutation": {
            "metaType": "reference",
            "value": "type__property_mutation",
            "isSingle": false,
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "mutations"
    }
  */