package ro.anud.xml_xsd.implementation.model.Type_linkTo_selection;
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
  public class Type_linkTo_selection implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_linkTo_selection.IType_linkTo_selection<Type_linkTo_selection>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Type_linkTo_selection fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_linkTo_selection();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Type_linkTo_selection fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Type_linkTo_selection> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Type_linkTo_selection.fromRawNode(o, parent)));
    }
    public static List<Type_linkTo_selection> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Type_linkTo_selection> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Type_linkTo_selection.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> origin_nodeGraph_selection = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> destination_nodeGraph_selection = Optional.empty();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    @Builder.Default
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    @Builder.Default
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "type__link_to__selection";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
          this.origin_nodeGraph_selection = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
          this.destination_nodeGraph_selection = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
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
      // Godot.GD.Print("Deserializing type__link_to__selection");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("origin__node_graph__selection");
      this.origin_nodeGraph_selection = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.fromRawNode(rawNode.getChildrenFirst("origin__node_graph__selection"), this);
      innerLogger.log("destination__node_graph__selection");
      this.destination_nodeGraph_selection = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.fromRawNode(rawNode.getChildrenFirst("destination__node_graph__selection"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("origin__node_graph__selection");
      rawNode.setChildren("origin__node_graph__selection", origin_nodeGraph_selection.stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection::serializeIntoRawNode).toList());
      innerLogger.log("destination__node_graph__selection");
      rawNode.setChildren("destination__node_graph__selection", destination_nodeGraph_selection.stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__link_to__selection");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> getOrigin_nodeGraph_selection()
    {
      return this.origin_nodeGraph_selection;
    }
    public ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection getOrigin_nodeGraph_selectionOrDefault()
    {
      return this.origin_nodeGraph_selection.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection();
        instance.setParentNode(this);
        this.origin_nodeGraph_selection = Optional.of(instance);
        return this.origin_nodeGraph_selection.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamOrigin_nodeGraph_selectionOrDefault()
    {
      return Stream.of(getOrigin_nodeGraph_selectionOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamOrigin_nodeGraph_selection()
    {
      return origin_nodeGraph_selection.stream();
    }
    public Type_linkTo_selection setOrigin_nodeGraph_selection(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection value)
    {
      this.origin_nodeGraph_selection = Optional.ofNullable(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> getDestination_nodeGraph_selection()
    {
      return this.destination_nodeGraph_selection;
    }
    public ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection getDestination_nodeGraph_selectionOrDefault()
    {
      return this.destination_nodeGraph_selection.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection();
        instance.setParentNode(this);
        this.destination_nodeGraph_selection = Optional.of(instance);
        return this.destination_nodeGraph_selection.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamDestination_nodeGraph_selectionOrDefault()
    {
      return Stream.of(getDestination_nodeGraph_selectionOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamDestination_nodeGraph_selection()
    {
      return destination_nodeGraph_selection.stream();
    }
    public Type_linkTo_selection setDestination_nodeGraph_selection(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection value)
    {
      this.destination_nodeGraph_selection = Optional.ofNullable(value);
      value.setParentNode(this);
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
          "origin__node_graph__selection": {
            "metaType": "reference",
            "value": "type__node_graph__selection",
            "isSingle": true,
            "isNullable": true
          },
          "destination__node_graph__selection": {
            "metaType": "reference",
            "value": "type__node_graph__selection",
            "isSingle": true,
            "isNullable": true
          }
        }
      },
      "typeDeclaration": {
        "name": "type__link_to__selection",
        "type": "complex",
        "isSingle": true,
        "value": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "origin__node_graph__selection": {
              "metaType": "reference",
              "value": "type__node_graph__selection",
              "isSingle": true,
              "isNullable": true
            },
            "destination__node_graph__selection": {
              "metaType": "reference",
              "value": "type__node_graph__selection",
              "isSingle": true,
              "isNullable": true
            }
          }
        }
      },
      "name": "type__link_to__selection"
    }
  */