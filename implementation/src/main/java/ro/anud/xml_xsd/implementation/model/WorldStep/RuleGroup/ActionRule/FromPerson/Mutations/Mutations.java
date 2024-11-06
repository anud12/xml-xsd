package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations;
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

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Mutations implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Mutations fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Mutations();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Mutations fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
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
    private List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> propertyMutation = new ArrayList<>();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<Mutations>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "mutations";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation) {
          this.propertyMutation.remove(object);
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Mutations> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing mutations");
      //Deserialize arguments

      //Deserialize children
      this.propertyMutation = ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation.fromRawNode(rawNode.getChildrenList("property_mutation"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
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
    public Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> streamPropertyMutation()
    {
      return propertyMutation.stream();
    }
    public Mutations addPropertyMutation(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation value)
    {
      this.propertyMutation.add(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Mutations addAllPropertyMutation(List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation> value)
    {
      this.propertyMutation.addAll(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Mutations removePropertyMutation(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation value)
    {
      this.propertyMutation.remove(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
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