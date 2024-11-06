package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.PersonDefault;
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
  public class PersonDefault implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations.IType_mathOperations<PersonDefault>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static PersonDefault fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new PersonDefault();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static PersonDefault fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<PersonDefault> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> PersonDefault.fromRawNode(o, parent)));
    }
    public static List<PersonDefault> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<PersonDefault> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> PersonDefault.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Attributes of type__math_operations

    //Children elements

    //Children of type__math_operations



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
    private List<Consumer<PersonDefault>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "person_default";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<PersonDefault> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person_default");
      //Deserialize arguments

      // Deserialize arguments of type__math_operations


      //Deserialize children

      // Deserialize children of type__math_operations

    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__math_operations


      //Serialize children

      // Serialize children of type__math_operations

      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person_default");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
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
        "value": {}
      },
      "name": "person_default"
    }
  */