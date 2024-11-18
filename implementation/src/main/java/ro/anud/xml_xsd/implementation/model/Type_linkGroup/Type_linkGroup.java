package ro.anud.xml_xsd.implementation.model.Type_linkGroup;
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
  public class Type_linkGroup implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Type_linkGroup fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_linkGroup();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Type_linkGroup fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Type_linkGroup> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Type_linkGroup.fromRawNode(o, parent)));
    }
    public static List<Type_linkGroup> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Type_linkGroup> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Type_linkGroup.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String id;
    private Integer angle;
    private Optional<Integer> angleMax;
    private Optional<Integer> limit;

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> toOption = new ArrayList<>();

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
      return "type__link_group";
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
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption) {
          this.toOption.remove(object);
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
      // Godot.GD.Print("Deserializing type__link_group");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("id");
      this.id = rawNode.getAttributeRequired("id");
      innerLogger.log("angle");
      this.angle = rawNode.getAttributeIntRequired("angle");
      innerLogger.log("angleMax");
      this.angleMax = rawNode.getAttributeInt("angleMax");
      innerLogger.log("limit");
      this.limit = rawNode.getAttributeInt("limit");
      innerLogger = logger.log("children");
      //Deserialize children
      this.toOption = ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption.fromRawNode(rawNode.getChildrenList("to_option"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);
      innerLogger.log("angle");
      rawNode.setAttribute("angle", this.angle);
      innerLogger.log("angleMax");
      this.angleMax.ifPresent(o -> rawNode.setAttribute("angleMax", o));
      innerLogger.log("limit");
      this.limit.ifPresent(o -> rawNode.setAttribute("limit", o));

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("to_option");
      rawNode.setChildren("to_option", toOption.stream().map(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__link_group");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public Type_linkGroup setId(String value)
    {
      this.id = value;
      triggerOnChange();
      return this;
    }
    public Integer getAngle()
    {
      return this.angle;
    }
    public Type_linkGroup setAngle(Integer value)
    {
      this.angle = value;
      triggerOnChange();
      return this;
    }
    public Optional<Integer> getAngleMax()
    {
      return this.angleMax;
    }
    public Type_linkGroup setAngleMax(Optional<Integer> value)
    {
      this.angleMax = value;
      triggerOnChange();
      return this;
    }
    public Optional<Integer> getLimit()
    {
      return this.limit;
    }
    public Type_linkGroup setLimit(Optional<Integer> value)
    {
      this.limit = value;
      triggerOnChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> getToOption()
    {
      return this.toOption;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> streamToOption()
    {
      return toOption.stream();
    }
    public Type_linkGroup addToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value)
    {
      this.toOption.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Type_linkGroup addAllToOption(List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> value)
    {
      this.toOption.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Type_linkGroup removeToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value)
    {
      this.toOption.remove(value);
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
            "id": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "angle": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": false
            },
            "angleMax": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": true
            },
            "limit": {
              "metaType": "primitive",
              "value": "xs:int",
              "isNullable": true
            }
          }
        },
        "isSingle": false,
        "value": {
          "to_option": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "node_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "distance": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                },
                "maxDistance": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": true
                },
                "adjacent_depth_limit": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              }
            },
            "isSingle": false,
            "value": {
              "distance_to_progress_multiplier": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": true
              },
              "person_progress_property": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": true
              }
            },
            "isNullable": true
          }
        }
      },
      "name": "type__link_group"
    }
  */