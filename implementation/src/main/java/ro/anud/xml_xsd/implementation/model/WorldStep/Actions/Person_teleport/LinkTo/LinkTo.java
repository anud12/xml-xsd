package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo;
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
  public class LinkTo implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static LinkTo fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new LinkTo();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LinkTo fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<LinkTo> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> LinkTo.fromRawNode(o, parent)));
    }
    public static List<LinkTo> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<LinkTo> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> LinkTo.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private Integer accumulatedProgress;

    //Children elements
    private ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection selection = new ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection();

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
    private List<Consumer<LinkTo>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "link_to";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection) {
          throw new RuntimeException("trying to delete selection which is required");
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<LinkTo> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_to");
      //Deserialize arguments
      this.accumulatedProgress = rawNode.getAttributeIntRequired("accumulated_progress");

      //Deserialize children
      this.selection = ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection.fromRawNode(rawNode.getChildrenFirst("selection").get(), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("accumulated_progress", this.accumulatedProgress);

      //Serialize children
      rawNode.setChildren("selection", Optional.ofNullable(selection).stream().map(ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing link_to");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public Integer getAccumulatedProgress()
    {
      return this.accumulatedProgress;
    }
    public LinkTo setAccumulatedProgress(Integer value)
    {
      this.accumulatedProgress = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection getSelection()
    {
      return this.selection;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection> streamSelection()
    {
      return Optional.ofNullable(selection).stream();
    }
    public LinkTo setSelection(ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection value)
    {
      this.selection = value;
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
        "attributes": {
          "metaType": "object",
          "value": {
            "accumulated_progress": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": true,
        "value": {
          "selection": {
            "metaType": "reference",
            "value": "type__link_to__selection",
            "isSingle": true,
            "isNullable": false
          }
        },
        "isNullable": false
      },
      "name": "link_to"
    }
  */