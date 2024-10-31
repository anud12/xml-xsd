package ro.anud.xml_xsd.implementation.model.Type_action.On;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public class On  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<On>> onChangeList = new ArrayList<>();

    public static On fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new On();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<On> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(On::fromRawNode));
    }
    public static List<On> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<On> returnList = rawNodeList.stream().map(On::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<On> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Type_action.On.Person.Person> person = Optional.empty();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing on");
      //Deserialize arguments

      //Deserialize children
      this.person = ro.anud.xml_xsd.implementation.model.Type_action.On.Person.Person.fromRawNode(rawNode.getChildrenFirst("person"));
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("person", person);
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing on");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_action.On.Person.Person> getPerson()
    {
      return this.person;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.Type_action.On.Person.Person> GetOrInsertDefault_Person()
    {
      if(this.person == null) {
        this.person = Optional.empty();
      }
      return this.person;
    }
    */
    public On setPerson(Optional<ro.anud.xml_xsd.implementation.model.Type_action.On.Person.Person> value)
    {
      this.person = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

  }

  /*
    dependant type:
    {
      "type": "element",
      "value": {
        "metaType": "object",
        "isSingle": true,
        "value": {
          "person": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "select": {
                "metaType": "reference",
                "value": "type__person_selection",
                "isSingle": true,
                "isNullable": true
              },
              "property_mutation": {
                "metaType": "reference",
                "value": "type__property_mutation",
                "isSingle": true,
                "isNullable": true
              }
            },
            "isNullable": true
          }
        },
        "isNullable": false
      },
      "name": "on",
      "parentType": {
        "type": "element",
        "value": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "from": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "person": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "select": {
                      "metaType": "reference",
                      "value": "type__person_selection",
                      "isSingle": true,
                      "isNullable": true
                    },
                    "property_mutation": {
                      "metaType": "reference",
                      "value": "type__property_mutation",
                      "isSingle": true,
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                }
              },
              "isNullable": false
            },
            "on": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "person": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "select": {
                      "metaType": "reference",
                      "value": "type__person_selection",
                      "isSingle": true,
                      "isNullable": true
                    },
                    "property_mutation": {
                      "metaType": "reference",
                      "value": "type__property_mutation",
                      "isSingle": true,
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                }
              },
              "isNullable": false
            }
          }
        },
        "name": "type__action"
      }
    }
  */