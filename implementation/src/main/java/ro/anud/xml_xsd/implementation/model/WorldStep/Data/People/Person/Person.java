package ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person;
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
  public class Person implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Person fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Person();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Person fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Person> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Person.fromRawNode(o, parent)));
    }
    public static List<Person> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Person> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Person.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes
    private String id;
    private Optional<String> name;

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race> race = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties> properties = Optional.empty();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations> relations = new ArrayList<>();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications> classifications = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> icon = Optional.empty();

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
      return "person";
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race) {
          this.race = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties) {
          this.properties = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations) {
          this.relations.remove(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications) {
          this.classifications = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon) {
          this.icon = Optional.empty();
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
      // Godot.GD.Print("Deserializing person");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("id");
      this.id = rawNode.getAttributeRequired("id");
      innerLogger.log("name");
      this.name = rawNode.getAttribute("name");
      innerLogger = logger.log("children");
      //Deserialize children
      this.race = ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race.fromRawNode(rawNode.getChildrenFirst("race"), this);
      this.properties = ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties.fromRawNode(rawNode.getChildrenFirst("properties"), this);
      this.relations = ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations.fromRawNode(rawNode.getChildrenList("relations"), this);
      this.classifications = ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications.fromRawNode(rawNode.getChildrenFirst("classifications"), this);
      innerLogger.log("icon");
      this.icon = ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon.fromRawNode(rawNode.getChildrenFirst("icon"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);
      innerLogger.log("name");
      this.name.ifPresent(o -> rawNode.setAttribute("name", o));

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("race");
      rawNode.setChildren("race", race.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race::serializeIntoRawNode).toList());
      innerLogger.log("properties");
      rawNode.setChildren("properties", properties.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties::serializeIntoRawNode).toList());
      innerLogger.log("relations");
      rawNode.setChildren("relations", relations.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations::serializeIntoRawNode).toList());
      innerLogger.log("classifications");
      rawNode.setChildren("classifications", classifications.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications::serializeIntoRawNode).toList());
      innerLogger.log("icon");
      rawNode.setChildren("icon", icon.stream().map(ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon::serializeIntoRawNode).toList());
      return rawNode;
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
      triggerOnChange();
      return this;
    }
    public Optional<String> getName()
    {
      return this.name;
    }
    public Person setName(Optional<String> value)
    {
      this.name = value;
      triggerOnChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race> getRace()
    {
      return this.race;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race getRaceOrDefault()
    {
      return this.race.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race();
        instance.setParentNode(this);
        this.race = Optional.of(instance);
        return this.race.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race> streamRaceOrDefault()
    {
      return Stream.of(getRaceOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race> streamRace()
    {
      return race.stream();
    }
    public Person setRace(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race value)
    {
      this.race = Optional.ofNullable(value);
      value.setParentNode(this);
      triggerOnChange();
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
        instance.setParentNode(this);
        this.properties = Optional.of(instance);
        return this.properties.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties> streamPropertiesOrDefault()
    {
      return Stream.of(getPropertiesOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties> streamProperties()
    {
      return properties.stream();
    }
    public Person setProperties(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties value)
    {
      this.properties = Optional.ofNullable(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations> getRelations()
    {
      return this.relations;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations> streamRelations()
    {
      return relations.stream();
    }
    public Person addRelations(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations value)
    {
      this.relations.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public Person addAllRelations(List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations> value)
    {
      this.relations.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public Person removeRelations(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Relations.Relations value)
    {
      this.relations.remove(value);
      triggerOnChange();
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
        instance.setParentNode(this);
        this.classifications = Optional.of(instance);
        return this.classifications.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications> streamClassificationsOrDefault()
    {
      return Stream.of(getClassificationsOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications> streamClassifications()
    {
      return classifications.stream();
    }
    public Person setClassifications(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications value)
    {
      this.classifications = Optional.ofNullable(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> getIcon()
    {
      return this.icon;
    }
    public ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon getIconOrDefault()
    {
      return this.icon.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon();
        instance.setParentNode(this);
        this.icon = Optional.of(instance);
        return this.icon.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> streamIconOrDefault()
    {
      return Stream.of(getIconOrDefault());
    }
    public Stream<ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon> streamIcon()
    {
      return icon.stream();
    }
    public Person setIcon(ro.anud.xml_xsd.implementation.model.TypeIcon.TypeIcon value)
    {
      this.icon = Optional.ofNullable(value);
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
          "race": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "race_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
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
          },
          "icon": {
            "metaType": "reference",
            "value": "type_icon",
            "isSingle": true,
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "person"
    }
  */