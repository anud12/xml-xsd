package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo;
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
  public class Person_moveTo implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Person_moveTo fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Person_moveTo();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Person_moveTo fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Person_moveTo> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Person_moveTo.fromRawNode(o, parent)));
    }
    public static List<Person_moveTo> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Person_moveTo> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Person_moveTo.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return "/world_step/actions/person.move_to";
    }

    //Attributes

    private String personIdRef;

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> findPathTowards = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path> path = Optional.empty();

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
      return "person.move_to";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> parentAsActions() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
          this.findPathTowards = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path) {
          this.path = Optional.empty();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path) {
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
      // Godot.GD.Print("Deserializing person.move_to");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("person_id_ref");
      this.personIdRef = rawNode.getAttributeRequired("person_id_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      innerLogger.log("find_path_towards");
      this.findPathTowards = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection.fromRawNode(rawNode.getChildrenFirst("find_path_towards"), this);
      this.path = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path.fromRawNode(rawNode.getChildrenFirst("path"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("person.move_to");
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("person_id_ref");
      rawNode.setAttribute("person_id_ref", this.personIdRef);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("find_path_towards");
      rawNode.setChildren("find_path_towards", findPathTowards.stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection::serializeIntoRawNode).toList());
      innerLogger.log("path");
      rawNode.setChildren("path", path.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person.move_to");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPersonIdRef()
    {
      return this.personIdRef;
    }
    public Person_moveTo setPersonIdRef(String value)
    {
      this.personIdRef = value;
      triggerOnChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> getFindPathTowards()
    {
      return this.findPathTowards;
    }
    public ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection getFindPathTowardsOrDefault()
    {
      return this.findPathTowards.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection();
        this.findPathTowards = Optional.of(instance);
        instance.parentNode(this);
        return this.findPathTowards.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamFindPathTowardsOrDefault()
    {
      return java.util.stream.Stream.of(getFindPathTowardsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamFindPathTowards()
    {
      return findPathTowards.stream();
    }
    public Person_moveTo setFindPathTowards(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection value)
    {
      this.findPathTowards = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path> getPath()
    {
      return this.path;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path getPathOrDefault()
    {
      return this.path.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path();
        this.path = Optional.of(instance);
        instance.parentNode(this);
        return this.path.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path> streamPathOrDefault()
    {
      return java.util.stream.Stream.of(getPathOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path> streamPath()
    {
      return path.stream();
    }
    public Person_moveTo setPath(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path value)
    {
      this.path = Optional.ofNullable(value);
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
            "person_id_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "find_path_towards": {
            "metaType": "reference",
            "value": "type__node_graph__selection",
            "isSingle": true,
            "isNullable": true
          },
          "path": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "node": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "node_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              }
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "person.move_to"
    }
  */