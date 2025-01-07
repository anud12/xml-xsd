package ro.anud.xml_xsd.implementation.model.interfaces.IType_nameToken;

public interface IType_nameToken<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  java.util.List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> getNameToken();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> streamNameToken();
  T addNameToken(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken value);
  T addAllNameToken(java.util.List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> value);
  T removeNameToken(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken value);
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
        "name_token": {
          "metaType": "union",
          "value": [
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": true,
              "value": {
                "ref": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "name_rule_ref": {
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
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": true,
              "value": {
                "one_of": {
                  "metaType": "composition",
                  "value": [
                    {
                      "metaType": "object",
                      "value": {},
                      "isSingle": true,
                      "isNullable": false
                    },
                    {
                      "metaType": "primitive",
                      "value": "type__name_token"
                    }
                  ],
                  "isSingle": true,
                  "isNullable": true
                }
              }
            }
          ],
          "isSingle": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "prefix": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            },
            "isNullable": false
          },
          "isNullable": false
        }
      }
    },
    "name": "type__name_token"
  }
*/