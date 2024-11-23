package ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId;
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
  public class Has_locationGraphId implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Has_locationGraphId fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Has_locationGraphId();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Has_locationGraphId fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Has_locationGraphId> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Has_locationGraphId.fromRawNode(o, parent)));
    }
    public static List<Has_locationGraphId> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Has_locationGraphId> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Has_locationGraphId.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String locationGraphIdRef;

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or> or = new ArrayList<>();

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
      return "has__location_graph_id";
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or) {
          this.or.remove(object);
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or) {
          return this.or.indexOf(object);
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
      // Godot.GD.Print("Deserializing has__location_graph_id");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("location_graph_id_ref");
      this.locationGraphIdRef = rawNode.getAttributeRequired("location_graph_id_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      this.or = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or.fromRawNode(rawNode.getChildrenList("or"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("location_graph_id_ref");
      rawNode.setAttribute("location_graph_id_ref", this.locationGraphIdRef);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("or");
      rawNode.setChildren("or", or.stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing has__location_graph_id");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getLocationGraphIdRef()
    {
      return this.locationGraphIdRef;
    }
    public Has_locationGraphId setLocationGraphIdRef(String value)
    {
      this.locationGraphIdRef = value;
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or> getOr()
    {
      return this.or;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or> streamOr()
    {
      return or.stream();
    }
    public Has_locationGraphId addOr(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or value)
    {
      this.or.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Has_locationGraphId addAllOr(List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or> value)
    {
      this.or.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Has_locationGraphId removeOr(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or value)
    {
      this.or.remove(value);
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
      },
      "name": "has__location_graph_id"
    }
  */