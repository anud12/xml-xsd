package ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutationOn;

public interface IType_propertyMutationOn<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {
  void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

  ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

  void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
}

/*
  {
    "type": "element",
    "value": {
      "metaType": "composition",
      "value": [
        {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "on": {
                "metaType": "primitive",
                "value": "type_person_select",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        {
          "metaType": "primitive",
          "value": "type__property_mutation"
        }
      ]
    },
    "typeDeclaration": {
      "name": "type__property_mutation_on",
      "type": "complex",
      "value": {
        "metaType": "composition",
        "value": [
          {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "on": {
                  "metaType": "primitive",
                  "value": "type_person_select",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          {
            "metaType": "primitive",
            "value": "type__property_mutation"
          }
        ]
      }
    },
    "name": "type__property_mutation_on"
  }
*/