package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By;
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
  public class By implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static By fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new By();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static By fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<By> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> By.fromRawNode(o, parent)));
    }
    public static List<By> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<By> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> By.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String personRef;

    //Children elements
    private ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement doElement = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement();
    private ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards moveTowards = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards();

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
      return "by";
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement) {
          throw new RuntimeException("trying to delete doElement which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards) {
          throw new RuntimeException("trying to delete moveTowards which is required");
        }
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
      // Godot.GD.Print("Deserializing by");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("person_ref");
      this.personRef = rawNode.getAttributeRequired("person_ref");
      innerLogger = logger.log("children");
      //Deserialize children
      this.doElement = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement.fromRawNode(rawNode.getChildrenFirst("do").get(), this);
      this.moveTowards = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards.fromRawNode(rawNode.getChildrenFirst("move_towards").get(), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("person_ref");
      rawNode.setAttribute("person_ref", this.personRef);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("do");
      rawNode.setChildren("do", Optional.ofNullable(doElement).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement::serializeIntoRawNode).toList());
      innerLogger.log("move_towards");
      rawNode.setChildren("move_towards", Optional.ofNullable(moveTowards).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing by");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPersonRef()
    {
      return this.personRef;
    }
    public By setPersonRef(String value)
    {
      this.personRef = value;
      triggerOnChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement getDoElement()
    {
      return this.doElement;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement> streamDoElement()
    {
      return Optional.ofNullable(doElement).stream();
    }
    public By setDoElement(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement value)
    {
      this.doElement = value;
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards getMoveTowards()
    {
      return this.moveTowards;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards> streamMoveTowards()
    {
      return Optional.ofNullable(moveTowards).stream();
    }
    public By setMoveTowards(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards value)
    {
      this.moveTowards = value;
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
        "attributes": {
          "metaType": "object",
          "value": {
            "person_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "value": {
          "do": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "action_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                },
                "action_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                },
                "person_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "move_towards": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "layer": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                },
                "x": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                },
                "y": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              }
            }
          }
        }
      },
      "name": "by"
    }
  */