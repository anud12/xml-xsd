package ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection;

public interface IType_personSelection<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getRadius();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamRadius();
  T setRadius(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value);

  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMin();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMin();
  T setMin(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value);

  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMax();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> streamMax();
  T setMax(ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations value);

  java.util.List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> getProperty();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> streamProperty();
  T addProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value);
  T addAllProperty(java.util.List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> value);
  T removeProperty(ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property value);
  java.util.List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> getClassification();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> streamClassification();
  T addClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value);
  T addAllClassification(java.util.List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> value);
  T removeClassification(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification value);
  void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

  ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

  void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
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