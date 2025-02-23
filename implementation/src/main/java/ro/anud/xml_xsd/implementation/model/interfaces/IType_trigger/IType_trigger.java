package ro.anud.xml_xsd.implementation.model.interfaces.IType_trigger;

public interface IType_trigger<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed getPersonActionUsed();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed> streamPersonActionUsed();
  T setPersonActionUsed(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed value);
  void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

  ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

  void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
}

/*
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": true,
      "value": {
        "person_action_used": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "action_rule_ref": {
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
      "name": "type__trigger",
      "type": "complex",
      "isSingle": true,
      "value": {
        "metaType": "object",
        "isSingle": true,
        "value": {
          "person_action_used": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "action_rule_ref": {
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
    "name": "type__trigger"
  }
*/