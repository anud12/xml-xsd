package ro.anud.xml_xsd.implementation.model.Type_linkGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Type_linkGroup implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "type__link_group";
    public static Type_linkGroup fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Type_linkGroup();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Type_linkGroup fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Type_linkGroup> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Type_linkGroup.fromRawNode(o, parent)));
        }

    }
    public static List<Type_linkGroup> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Type_linkGroup> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Type_linkGroup.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".type__link_group";
    }

    //Attributes

    private String id;

    private Integer angle;
    @Builder.Default
    private Optional<Integer> angleMax = Optional.empty();
    @Builder.Default
    private Optional<Integer> limit = Optional.empty();

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> toOption = new ArrayList<>();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Type_linkGroup>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Type_linkGroup>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "type__link_group";
    }
    public static Type_linkGroup of() {
      return new Type_linkGroup();
    }

    public void notifyChange(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.onChange(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(object));
      }
    }

    public void notifyRemove(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify remove for", this.buildPath());
        onRemoveList.forEach(consumer -> consumer.onRemove(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyRemove(object));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode.ifPresent(parent -> notifyRemove());
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption) {
          this.toOption.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption) {
          return this.toOption.indexOf(object);
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Type_linkGroup> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Type_linkGroup> callback) {
      try (var logger = logScope()) {
        onRemoveList.add(callback);
        return logger.logReturn(() -> onRemoveList.remove(callback));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("id");
          var idValue = rawNode.getAttributeRequired("id");
          if(Objects.equals(this.id, idValue)) {
            isDirty = true;
          }
          this.id = idValue;
          innerLogger.log("angle");
          var angleValue = rawNode.getAttributeIntRequired("angle");
          if(Objects.equals(this.angle, angleValue)) {
            isDirty = true;
          }
          this.angle = angleValue;
          innerLogger.log("angleMax");
          var angleMaxValue = rawNode.getAttributeInt("angleMax");
          if(Objects.equals(this.angleMax, angleMaxValue)) {
            isDirty = true;
          }
          this.angleMax = angleMaxValue;
          innerLogger.log("limit");
          var limitValue = rawNode.getAttributeInt("limit");
          if(Objects.equals(this.limit, limitValue)) {
            isDirty = true;
          }
          this.limit = limitValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.toOption = ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption.fromRawNode(rawNode.getChildrenList("to_option"), this);
        }

        if(isDirty) {
          notifyChange();
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("type__link_group");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("id");
          rawNode.setAttribute("id", this.id);
          innerLogger.log("angle");
          rawNode.setAttribute("angle", this.angle);
          innerLogger.log("angleMax");
          this.angleMax.ifPresent(o -> rawNode.setAttribute("angleMax", o));
          innerLogger.log("limit");
          this.limit.ifPresent(o -> rawNode.setAttribute("limit", o));
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("to_option");
          rawNode.setChildren("to_option", toOption.stream().map(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
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
      notifyChange();
      return this;
    }
    public Integer getAngle()
    {
      return this.angle;
    }
    public Type_linkGroup setAngle(Integer value)
    {
      this.angle = value;
      notifyChange();
      return this;
    }
    public Optional<Integer> getAngleMax()
    {
      return this.angleMax;
    }
    public Type_linkGroup setAngleMax(Optional<Integer> value)
    {
      this.angleMax = value;
      notifyChange();
      return this;
    }
    public Optional<Integer> getLimit()
    {
      return this.limit;
    }
    public Type_linkGroup setLimit(Optional<Integer> value)
    {
      this.limit = value;
      notifyChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> getToOption()
    {
      return this.toOption;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> streamToOption()
    {
      return toOption.stream();
    }
    public Type_linkGroup addToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value)
    {
      this.toOption.add(value);
      value.parentNode(this);
      return this;
    }
    public Type_linkGroup addAllToOption(List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> value)
    {
      this.toOption.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Type_linkGroup removeToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value)
    {
      this.toOption.remove(value);
      value.clearParentNode();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.toOption.size() > pathIndex) {
              return this.toOption.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addToOption(newEntry);
          return linkedNode;
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.toOption.size() > pathIndex) {
            return this.toOption.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        return Optional.of(this);
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
              }
            },
            "isNullable": true
          }
        }
      },
      "name": "type__link_group"
    }
  */