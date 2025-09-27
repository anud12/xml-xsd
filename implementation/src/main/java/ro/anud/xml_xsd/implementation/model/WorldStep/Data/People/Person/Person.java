package ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person;
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
  public class Person implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "person";
    public static Person fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Person();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Person fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Person> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Person.fromRawNode(o, parent)));
        }

    }
    public static List<Person> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Person> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Person.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.data.people.person";
    }

    //Attributes

    private String id;
    @Builder.Default
    private Optional<String> name = Optional.empty();

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties> properties = Optional.empty();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations> relations = new ArrayList<>();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications> classifications = Optional.empty();

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
      return "person";
    }

    public void notifyChange(List<Object> list) {
      try (var logger = logScope()) {
        list.addLast(this);
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.accept(list));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People> parentAsPeople() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties) {
          this.properties = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations) {
          this.relations.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications) {
          this.classifications = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations) {
          return this.relations.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      try (var logger = logScope()) {
        onChangeList.add(onChange);
        return logger.logReturn(() -> onChangeList.remove(onChange));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing person");

        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("id");
          this.id = rawNode.getAttributeRequired("id");
          innerLogger.log("name");
          this.name = rawNode.getAttribute("name");
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.properties = ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties.fromRawNode(rawNode.getChildrenFirst("properties"), this);
          this.relations = ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations.fromRawNode(rawNode.getChildrenList("relations"), this);
          this.classifications = ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications.fromRawNode(rawNode.getChildrenFirst("classifications"), this);
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("person");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("id");
          rawNode.setAttribute("id", this.id);
          innerLogger.log("name");
          this.name.ifPresent(o -> rawNode.setAttribute("name", o));
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("properties");
          rawNode.setChildren("properties", properties.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties::serializeIntoRawNode).toList());
          innerLogger.log("relations");
          rawNode.setChildren("relations", relations.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations::serializeIntoRawNode).toList());
          innerLogger.log("classifications");
          rawNode.setChildren("classifications", classifications.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing person");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public Person setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public Optional<String> getName()
    {
      return this.name;
    }
    public Person setName(Optional<String> value)
    {
      this.name = value;
      notifyChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties> getProperties()
    {
      return this.properties;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties getPropertiesOrDefault()
    {
      return this.properties.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties();
        this.properties = Optional.of(instance);
        instance.parentNode(this);
        return this.properties.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties> streamPropertiesOrDefault()
    {
      return java.util.stream.Stream.of(getPropertiesOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties> streamProperties()
    {
      return properties.stream();
    }
    public Person setProperties(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties value)
    {
      this.properties = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations> getRelations()
    {
      return this.relations;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations> streamRelations()
    {
      return relations.stream();
    }
    public Person addRelations(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations value)
    {
      this.relations.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public Person addAllRelations(List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations> value)
    {
      this.relations.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public Person removeRelations(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations value)
    {
      this.relations.remove(value);
      notifyChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications> getClassifications()
    {
      return this.classifications;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications getClassificationsOrDefault()
    {
      return this.classifications.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications();
        this.classifications = Optional.of(instance);
        instance.parentNode(this);
        return this.classifications.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications> streamClassificationsOrDefault()
    {
      return java.util.stream.Stream.of(getClassificationsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications> streamClassifications()
    {
      return classifications.stream();
    }
    public Person setClassifications(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications value)
    {
      this.classifications = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties.nodeName))
        {
          if(this.properties.isEmpty()) {
            this.properties = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties.nodeName.length() + 3);
          return this.properties.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.relations.size() > pathIndex) {
              return this.relations.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations();
          this.addRelations(newEntry);
          return newEntry.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications.nodeName))
        {
          if(this.classifications.isEmpty()) {
            this.classifications = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications.nodeName.length() + 3);
          return this.classifications.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties.nodeName))
        {
          if(this.properties.isEmpty()) {
            this.properties = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties.nodeName.length() + 3);
          return this.properties.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.relations.size() > pathIndex) {
            return this.relations.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications.nodeName))
        {
          if(this.classifications.isEmpty()) {
            this.classifications = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications.nodeName.length() + 3);
          return this.classifications.get().getNodeAtPath(childXPath);
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
            "name": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": true
            }
          }
        },
        "isSingle": false,
        "value": {
          "properties": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "property": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "property_rule_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "value": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": false
                    }
                  }
                }
              }
            },
            "isNullable": true
          },
          "relations": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "with": {
                  "metaType": "unknown",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "classifications": {
            "metaType": "object",
            "isSingle": true,
            "value": {
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
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "person"
    }
  */