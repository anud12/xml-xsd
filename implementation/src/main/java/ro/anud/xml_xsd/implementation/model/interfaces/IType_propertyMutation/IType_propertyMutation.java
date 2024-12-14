package ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutation;

public interface IType_propertyMutation<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Attributes
  String getPropertyRuleRef();
  T setPropertyRuleRef(String value);

  //Children elements
  java.util.List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> getFrom();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> streamFrom();
  T addFrom(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From value);
  T addAllFrom(java.util.List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> value);
  T removeFrom(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From value);
  void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

  ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

  void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
}

/*
  {
    "type": "element",
    "value": {
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
        "from": {
          "metaType": "object",
          "attributes": {
            "metaType": "object",
            "value": {
              "participant": {
                "metaType": "primitive",
                "value": "type_person_select",
                "isNullable": false
              }
            },
            "isNullable": false
          },
          "isSingle": false,
          "value": {
            "operation": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": false
            }
          },
          "isNullable": false
        }
      }
    },
    "typeDeclaration": {
      "name": "type__property_mutation",
      "type": "complex",
      "isSingle": false,
      "value": {
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
          "from": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "participant": {
                  "metaType": "primitive",
                  "value": "type_person_select",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isSingle": false,
            "value": {
              "operation": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": false
              }
            },
            "isNullable": false
          }
        }
      }
    },
    "name": "type__property_mutation"
  }
*/