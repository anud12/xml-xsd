package ro.anud.xml_xsd.implementation.model.interfaces.IType_portalRule;

public interface IType_portalRule<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  ro.anud.xml_xsd.implementation.model.Type_portalRule.Limit.Limit getLimit();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_portalRule.Limit.Limit> streamLimit();
  T setLimit(ro.anud.xml_xsd.implementation.model.Type_portalRule.Limit.Limit value);

  ro.anud.xml_xsd.implementation.model.Type_portalRule.To.To getTo();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_portalRule.To.To> streamTo();
  T setTo(ro.anud.xml_xsd.implementation.model.Type_portalRule.To.To value);
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
        "limit": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "width": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        "to": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "region": {
              "metaType": "object",
              "value": {},
              "isSingle": false,
              "isNullable": true,
              "attributes": {
                "metaType": "object",
                "value": {
                  "region_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  }
                },
                "isNullable": false
              }
            }
          },
          "isNullable": false
        }
      }
    },
    "name": "type__portal_rule"
  }
*/