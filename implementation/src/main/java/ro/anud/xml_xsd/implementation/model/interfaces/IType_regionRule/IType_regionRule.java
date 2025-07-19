package ro.anud.xml_xsd.implementation.model.interfaces.IType_regionRule;

public interface IType_regionRule<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit getLimit();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit> streamLimit();
  T setLimit(ro.anud.xml_xsd.implementation.model.Type_regionRule.Limit.Limit value);

  java.util.List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> getPortal();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> streamPortal();
  T addPortal(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal value);
  T addAllPortal(java.util.List<ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal> value);
  T removePortal(ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal value);
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
        "portal": {
          "metaType": "object",
          "isSingle": false,
          "value": {
            "from": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "side": {
                    "metaType": "primitive",
                    "value": "type__rectangle_side",
                    "isNullable": false
                  }
                },
                "isNullable": false
              },
              "isSingle": true,
              "value": {
                "start": {
                  "metaType": "reference",
                  "value": "type__math_operations",
                  "isSingle": true,
                  "isNullable": false
                },
                "width": {
                  "metaType": "reference",
                  "value": "type__math_operations",
                  "isSingle": true,
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "to": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "region": {
                  "metaType": "object",
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "region_rule_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "side": {
                        "metaType": "primitive",
                        "value": "type__rectangle_side",
                        "isNullable": false
                      }
                    }
                  },
                  "isSingle": true,
                  "value": {
                    "start": {
                      "metaType": "reference",
                      "value": "type__math_operations",
                      "isSingle": true,
                      "isNullable": false
                    },
                    "width": {
                      "metaType": "reference",
                      "value": "type__math_operations",
                      "isSingle": true,
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "isNullable": true
        }
      }
    },
    "name": "type__region_rule"
  }
*/