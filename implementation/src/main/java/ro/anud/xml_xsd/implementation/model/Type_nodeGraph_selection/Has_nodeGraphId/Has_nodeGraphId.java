package ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId;
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
  public class Has_nodeGraphId implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Has_nodeGraphId fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Has_nodeGraphId();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Has_nodeGraphId fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Has_nodeGraphId> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Has_nodeGraphId.fromRawNode(o, parent)));
    }
    public static List<Has_nodeGraphId> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Has_nodeGraphId> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Has_nodeGraphId.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String nodeGraphIdRef;

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or.Or> or = new ArrayList<>();

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
    private List<Consumer<Has_nodeGraphId>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "has__node_graph_id";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or.Or) {
          this.or.remove(object);
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Has_nodeGraphId> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing has__node_graph_id");
      //Deserialize arguments
      this.nodeGraphIdRef = rawNode.getAttributeRequired("node_graph_id_ref");

      //Deserialize children
      this.or = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or.Or.fromRawNode(rawNode.getChildrenList("or"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("node_graph_id_ref", this.nodeGraphIdRef);

      //Serialize children
      rawNode.setChildren("or", or.stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or.Or::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing has__node_graph_id");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getNodeGraphIdRef()
    {
      return this.nodeGraphIdRef;
    }
    public Has_nodeGraphId setNodeGraphIdRef(String value)
    {
      this.nodeGraphIdRef = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or.Or> getOr()
    {
      return this.or;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or.Or> streamOr()
    {
      return or.stream();
    }
    public Has_nodeGraphId addOr(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or.Or value)
    {
      this.or.add(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Has_nodeGraphId addAllOr(List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or.Or> value)
    {
      this.or.addAll(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Has_nodeGraphId removeOr(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or.Or value)
    {
      this.or.remove(value);
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
            "node_graph_id_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": true,
        "value": {
          "or": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "node_graph_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                }
              },
              "isNullable": true
            }
          }
        },
        "isNullable": true
      },
      "name": "has__node_graph_id"
    }
  */