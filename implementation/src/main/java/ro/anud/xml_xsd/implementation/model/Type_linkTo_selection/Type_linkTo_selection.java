package ro.anud.xml_xsd.implementation.model.Type_linkTo_selection;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public class Type_linkTo_selection  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<Type_linkTo_selection>> onChangeList = new ArrayList<>();

    public static Type_linkTo_selection fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_linkTo_selection();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<Type_linkTo_selection> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Type_linkTo_selection::fromRawNode));
    }
    public static List<Type_linkTo_selection> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Type_linkTo_selection> returnList = rawNodeList.stream().map(Type_linkTo_selection::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<Type_linkTo_selection> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> origin_nodeGraph_selection = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> destination_nodeGraph_selection = Optional.empty();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__link_to__selection");
      //Deserialize arguments

      //Deserialize children
      this.origin_nodeGraph_selection = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.fromRawNode(rawNode.getChildrenFirst("origin__node_graph__selection"));
      this.destination_nodeGraph_selection = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.fromRawNode(rawNode.getChildrenFirst("destination__node_graph__selection"));
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("origin__node_graph__selection", origin_nodeGraph_selection);
      rawNode.addChildren("destination__node_graph__selection", destination_nodeGraph_selection);
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
    public Type_linkTo_selection setOrigin_nodeGraph_selection(Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> value)
    {
      this.origin_nodeGraph_selection = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> getDestination_nodeGraph_selection()
    {
      return this.destination_nodeGraph_selection;
    }
    public Type_linkTo_selection setDestination_nodeGraph_selection(Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> value)
    {
      this.destination_nodeGraph_selection = value;
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
      "name": "type__link_to__selection"
    }
  */