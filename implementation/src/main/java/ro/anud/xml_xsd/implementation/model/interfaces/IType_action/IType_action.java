package ro.anud.xml_xsd.implementation.model.interfaces.IType_action;

public interface IType_action<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  ro.anud.xml_xsd.implementation.model.Type_action.From.From getFrom();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_action.From.From> streamFrom();
  T setFrom(ro.anud.xml_xsd.implementation.model.Type_action.From.From value);

  ro.anud.xml_xsd.implementation.model.Type_action.On.On getOn();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_action.On.On> streamOn();
  T setOn(ro.anud.xml_xsd.implementation.model.Type_action.On.On value);
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
*/