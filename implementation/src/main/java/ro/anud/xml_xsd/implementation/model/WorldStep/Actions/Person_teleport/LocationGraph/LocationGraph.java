package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LocationGraph;
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
  public class LocationGraph implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static LocationGraph fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new LocationGraph();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LocationGraph fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<LocationGraph> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> LocationGraph.fromRawNode(o, parent)));
    }
    public static List<LocationGraph> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<LocationGraph> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> LocationGraph.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/world_step/actions/person.teleport/location_graph";
    }

    //Attributes

    private String locationGraphIdRef;

    private String nodeIdRef;

    //Children elements

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
      return "location_graph";
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
    }

    public int buildIndexForChild(Object object) {
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
      // Godot.GD.Print("Deserializing location_graph");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("location_graph_id_ref");
      this.locationGraphIdRef = rawNode.getAttributeRequired("location_graph_id_ref");
      innerLogger.log("node_id_ref");
      this.nodeIdRef = rawNode.getAttributeRequired("node_id_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("location_graph");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("location_graph_id_ref");
      rawNode.setAttribute("location_graph_id_ref", this.locationGraphIdRef);
      innerLogger.log("node_id_ref");
      rawNode.setAttribute("node_id_ref", this.nodeIdRef);

      innerLogger = logger.log("children");
      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing location_graph");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getLocationGraphIdRef()
    {
      return this.locationGraphIdRef;
    }
    public LocationGraph setLocationGraphIdRef(String value)
    {
      this.locationGraphIdRef = value;
      triggerOnChange();
      return this;
    }
    public String getNodeIdRef()
    {
      return this.nodeIdRef;
    }
    public LocationGraph setNodeIdRef(String value)
    {
      this.nodeIdRef = value;
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
        "value": {},
        "isSingle": true,
        "isNullable": true,
        "attributes": {
          "metaType": "object",
          "value": {
            "location_graph_id_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "node_id_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          }
        }
      },
      "name": "location_graph"
    }
  */