package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode;
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
  public class FromPersonSameLocationGraphNode implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static FromPersonSameLocationGraphNode fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new FromPersonSameLocationGraphNode();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static FromPersonSameLocationGraphNode fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<FromPersonSameLocationGraphNode> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> FromPersonSameLocationGraphNode.fromRawNode(o, parent)));
    }
    public static List<FromPersonSameLocationGraphNode> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<FromPersonSameLocationGraphNode> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> FromPersonSameLocationGraphNode.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String value;

    //Children elements

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
    private List<Consumer<FromPersonSameLocationGraphNode>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "from_person_same_location_graph_node";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<FromPersonSameLocationGraphNode> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person_same_location_graph_node");
      //Deserialize arguments
      this.value = rawNode.getAttributeRequired("value");

      //Deserialize children
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("value", this.value);

      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing from_person_same_location_graph_node");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getValue()
    {
      return this.value;
    }
    public FromPersonSameLocationGraphNode setValue(String value)
    {
      this.value = value;
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
      },
      "name": "from_person_same_location_graph_node"
    }
  */