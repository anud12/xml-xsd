package ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph;
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
  public class In_locationGraph implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static In_locationGraph fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new In_locationGraph();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static In_locationGraph fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<In_locationGraph> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> In_locationGraph.fromRawNode(o, parent)));
    }
    public static List<In_locationGraph> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<In_locationGraph> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> In_locationGraph.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/type__node_graph__selection/in__location_graph";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId> has_locationGraphId = Optional.empty();

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
      return "in__location_graph";
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

    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> parentAsType_nodeGraph_selection() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId) {
          this.has_locationGraphId = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId) {
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
      // Godot.GD.Print("Deserializing in__location_graph");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.has_locationGraphId = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId.fromRawNode(rawNode.getChildrenFirst("has__location_graph_id"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("in__location_graph");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("has__location_graph_id");
      rawNode.setChildren("has__location_graph_id", has_locationGraphId.stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing in__location_graph");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId> getHas_locationGraphId()
    {
      return this.has_locationGraphId;
    }
    public ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId getHas_locationGraphIdOrDefault()
    {
      return this.has_locationGraphId.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId();
        this.has_locationGraphId = Optional.of(instance);
        instance.parentNode(this);
        return this.has_locationGraphId.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId> streamHas_locationGraphIdOrDefault()
    {
      return java.util.stream.Stream.of(getHas_locationGraphIdOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId> streamHas_locationGraphId()
    {
      return has_locationGraphId.stream();
    }
    public In_locationGraph setHas_locationGraphId(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId value)
    {
      this.has_locationGraphId = Optional.ofNullable(value);
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
        "isSingle": true,
        "value": {
          "has__location_graph_id": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "location_graph_id_ref": {
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
                    "location_graph_id_ref": {
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
          }
        },
        "isNullable": true
      },
      "name": "in__location_graph"
    }
  */