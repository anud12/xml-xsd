package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson;
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
  public class FromPerson implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static final String TYPE_ID = "/world_step/actions/from_person";

    public static FromPerson fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new FromPerson();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static FromPerson fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<FromPerson> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> FromPerson.fromRawNode(o, parent)));
    }
    public static List<FromPerson> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<FromPerson> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> FromPerson.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    private String personIdRef;

    private String fromPersonRuleRef;

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson onPerson = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson();

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
      return "from_person";
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> parentAsActions() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson) {
          throw new RuntimeException("trying to delete onPerson which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson) {
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
      // Godot.GD.Print("Deserializing from_person");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("person_id_ref");
      this.personIdRef = rawNode.getAttributeRequired("person_id_ref");
      innerLogger.log("from_person_rule_ref");
      this.fromPersonRuleRef = rawNode.getAttributeRequired("from_person_rule_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      this.onPerson = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson.fromRawNode(rawNode.getChildrenFirst("on_person").get(), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("person_id_ref");
      rawNode.setAttribute("person_id_ref", this.personIdRef);
      innerLogger.log("from_person_rule_ref");
      rawNode.setAttribute("from_person_rule_ref", this.fromPersonRuleRef);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("on_person");
      rawNode.setChildren("on_person", Optional.ofNullable(onPerson).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing from_person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPersonIdRef()
    {
      return this.personIdRef;
    }
    public FromPerson setPersonIdRef(String value)
    {
      this.personIdRef = value;
      triggerOnChange();
      return this;
    }
    public String getFromPersonRuleRef()
    {
      return this.fromPersonRuleRef;
    }
    public FromPerson setFromPersonRuleRef(String value)
    {
      this.fromPersonRuleRef = value;
      triggerOnChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson getOnPerson()
    {
      return this.onPerson;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson> streamOnPerson()
    {
      return Optional.ofNullable(onPerson).stream();
    }
    public FromPerson setOnPerson(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.OnPerson.OnPerson value)
    {
      this.onPerson = value;
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
            },
            "from_person_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          }
        },
        "isSingle": false,
        "value": {
          "on_person": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
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
            }
          }
        },
        "isNullable": true
      },
      "name": "from_person"
    }
  */