package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo;
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
  public class LinkTo implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static LinkTo fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new LinkTo();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LinkTo fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
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

    public String classTypeId() {
      return "/world_step/actions/person.teleport/link_to";
    }

    //Attributes

    private Integer accumulatedProgress;

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection selection = new ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection();

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
      return "link_to";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport> parentAsPerson_teleport() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection) {
          throw new RuntimeException("trying to delete selection which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection) {
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
      // Godot.GD.Print("Deserializing link_to");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("accumulated_progress");
      this.accumulatedProgress = rawNode.getAttributeIntRequired("accumulated_progress");
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("selection");
      this.selection = ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection.fromRawNode(rawNode.getChildrenFirst("selection").get(), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("link_to");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("accumulated_progress");
      rawNode.setAttribute("accumulated_progress", this.accumulatedProgress);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("selection");
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
      triggerOnChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection getSelection()
    {
      return this.selection;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection> streamSelection()
    {
      return Optional.ofNullable(selection).stream();
    }
    public LinkTo setSelection(ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection value)
    {
      this.selection = value;
      value.parentNode(this);
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
        "isNullable": true
      },
      "name": "link_to"
    }
  */