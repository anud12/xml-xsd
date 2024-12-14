package ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection;
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

public interface IType_personSelection<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getRadius();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamRadius();
  public T setRadius(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value);

  public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMin();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMin();
  public T setMin(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value);

  public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMax();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMax();
  public T setMax(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value);

  public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> getProperty();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> streamProperty();
  public T addProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value);
  public T addAllProperty(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> value);
  public T removeProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value);
  public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> getClassification();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> streamClassification();
  public T addClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value);
  public T addAllClassification(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> value);
  public T removeClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value);
  public Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race> getRace();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race> streamRace();
  public T setRace(ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race value);
  public void deserialize (RawNode rawNode);

  public RawNode serializeIntoRawNode();

  public void serialize(Document document, Element element);
}

/*
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
        },
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
          },
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
          }
        }
      }
    },
    "name": "type__person_selection"
  }
*/