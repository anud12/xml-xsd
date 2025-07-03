package ro.anud.xml_xsd.implementation.model.Type_personSelection;
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
  public class Type_personSelection implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection.IType_personSelection<Type_personSelection>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "type__person_selection";
    public static Type_personSelection fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new Type_personSelection();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Type_personSelection fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<Type_personSelection> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Type_personSelection.fromRawNode(o, parent)));
    }
    public static List<Type_personSelection> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Type_personSelection> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Type_personSelection.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".type__person_selection";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> radius = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> min = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> max = Optional.empty();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> property = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> classification = new ArrayList<>();

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
      return "type__person_selection";
    }

    public void notifyChange(List<Object> list) {
      var logger = logEnter();
      list.addLast(this);
      logger.log("Notify change for", this.buildPath());
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.radius = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.min = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          this.max = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property) {
          this.property.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification) {
          this.classification.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property) {
          return this.property.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification) {
          return this.classification.indexOf(object);
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
      try {
        var logger = logEnter();
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing type__person_selection");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        innerLogger = logger.log("children");
        //Deserialize children
        innerLogger.log("radius");
        this.radius = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("radius"), this);
        innerLogger.log("min");
        this.min = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("min"), this);
        innerLogger.log("max");
        this.max = ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.fromRawNode(rawNode.getChildrenFirst("max"), this);
        this.property = ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property.fromRawNode(rawNode.getChildrenList("property"), this);
        this.classification = ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification.fromRawNode(rawNode.getChildrenList("classification"), this);
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("type__person_selection");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("radius");
      rawNode.setChildren("radius", radius.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      innerLogger.log("min");
      rawNode.setChildren("min", min.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      innerLogger.log("max");
      rawNode.setChildren("max", max.stream().map(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations::serializeIntoRawNode).toList());
      innerLogger.log("property");
      rawNode.setChildren("property", property.stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property::serializeIntoRawNode).toList());
      innerLogger.log("classification");
      rawNode.setChildren("classification", classification.stream().map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__person_selection");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getRadius()
    {
      return this.radius;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getRadiusOrDefault()
    {
      return this.radius.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        this.radius = Optional.of(instance);
        instance.parentNode(this);
        return this.radius.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamRadiusOrDefault()
    {
      return java.util.stream.Stream.of(getRadiusOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamRadius()
    {
      return radius.stream();
    }
    public Type_personSelection setRadius(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.radius = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMin()
    {
      return this.min;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getMinOrDefault()
    {
      return this.min.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        this.min = Optional.of(instance);
        instance.parentNode(this);
        return this.min.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMinOrDefault()
    {
      return java.util.stream.Stream.of(getMinOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMin()
    {
      return min.stream();
    }
    public Type_personSelection setMin(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.min = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMax()
    {
      return this.max;
    }
    public ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations getMaxOrDefault()
    {
      return this.max.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations();
        this.max = Optional.of(instance);
        instance.parentNode(this);
        return this.max.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMaxOrDefault()
    {
      return java.util.stream.Stream.of(getMaxOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMax()
    {
      return max.stream();
    }
    public Type_personSelection setMax(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value)
    {
      this.max = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> getProperty()
    {
      return this.property;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> streamProperty()
    {
      return property.stream();
    }
    public Type_personSelection addProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value)
    {
      this.property.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public Type_personSelection addAllProperty(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> value)
    {
      this.property.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public Type_personSelection removeProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value)
    {
      this.property.remove(value);
      notifyChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> getClassification()
    {
      return this.classification;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> streamClassification()
    {
      return classification.stream();
    }
    public Type_personSelection addClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value)
    {
      this.classification.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public Type_personSelection addAllClassification(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> value)
    {
      this.classification.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public Type_personSelection removeClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value)
    {
      this.classification.remove(value);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.radius.isEmpty()) {
            this.radius = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.radius.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.min.isEmpty()) {
            this.min = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.min.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.max.isEmpty()) {
            this.max = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.max.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.property.size() > pathIndex) {
              return this.property.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property();
          this.addProperty(newEntry);
          return newEntry.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.classification.size() > pathIndex) {
              return this.classification.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification();
          this.addClassification(newEntry);
          return newEntry.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.radius.isEmpty()) {
            this.radius = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.radius.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.min.isEmpty()) {
            this.min = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.min.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName))
        {
          if(this.max.isEmpty()) {
            this.max = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations.nodeName.length() + 3);
          return this.max.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.property.size() > pathIndex) {
            return this.property.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.classification.size() > pathIndex) {
            return this.classification.get(pathIndex).getNodeAtPath(childXPath);
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
        "isSingle": false,
        "value": {
          "radius": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": true
          },
          "min": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": true
          },
          "max": {
            "metaType": "reference",
            "value": "type__math_operations",
            "isSingle": true,
            "isNullable": true
          },
          "property": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "property_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isSingle": false,
            "value": {
              "min": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": true
              },
              "max": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "classification": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "classification_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          }
        }
      },
      "typeDeclaration": {
        "name": "type__person_selection",
        "type": "complex",
        "isSingle": false,
        "value": {
          "metaType": "object",
          "isSingle": false,
          "value": {
            "radius": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": true
            },
            "min": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": true
            },
            "max": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": true
            },
            "property": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "property_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  }
                },
                "isNullable": false
              },
              "isSingle": false,
              "value": {
                "min": {
                  "metaType": "reference",
                  "value": "type__math_operations",
                  "isSingle": true,
                  "isNullable": true
                },
                "max": {
                  "metaType": "reference",
                  "value": "type__math_operations",
                  "isSingle": true,
                  "isNullable": true
                }
              },
              "isNullable": true
            },
            "classification": {
              "metaType": "object",
              "value": {},
              "isSingle": false,
              "isNullable": true,
              "attributes": {
                "metaType": "object",
                "value": {
                  "classification_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  }
                },
                "isNullable": false
              }
            }
          }
        }
      },
      "name": "type__person_selection"
    }
  */