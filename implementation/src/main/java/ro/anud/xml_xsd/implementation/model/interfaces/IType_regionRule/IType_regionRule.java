package ro.anud.xml_xsd.implementation.model.interfaces.IType_regionRule;

public interface IType_regionRule<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit getLimit();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit> streamLimit();
  T setLimit(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit value);

  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> getPortals();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals> streamPortals();
  T setPortals(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals value);
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
          "isSingle": true,
          "value": {
            "width": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": false
            },
            "height": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "portals": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "portal": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "side": {
                    "metaType": "primitive",
                    "value": "type__rectangle_side",
                    "isNullable": false
                  },
                  "portal_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  }
                }
              },
              "isSingle": false,
              "value": {
                "start": {
                  "metaType": "reference",
                  "value": "type__math_operations",
                  "isSingle": true,
                  "isNullable": false
                }
              },
              "isNullable": true
            }
          },
          "isNullable": true
        }
      }
    },
    "name": "type__region_rule"
  }
*/