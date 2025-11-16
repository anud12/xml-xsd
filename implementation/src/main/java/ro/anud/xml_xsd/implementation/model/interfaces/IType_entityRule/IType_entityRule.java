package ro.anud.xml_xsd.implementation.model.interfaces.IType_entityRule;

public interface IType_entityRule<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Attributes
  String getName();
  T setName(String value);

  //Children elements

  void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

  ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

  void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
}

/*
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "value": {},
      "isSingle": true,
      "isNullable": false,
      "attributes": {
        "metaType": "object",
        "value": {
          "name": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        },
        "isNullable": false
      }
    },
    "name": "type__entity_rule"
  }
*/