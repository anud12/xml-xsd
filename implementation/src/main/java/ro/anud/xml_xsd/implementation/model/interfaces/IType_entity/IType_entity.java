package ro.anud.xml_xsd.implementation.model.interfaces.IType_entity;

public interface IType_entity<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Attributes
  java.util.Optional<String> getEntityRuleRef();
  T setEntityRuleRef(java.util.Optional<String> value);

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
          "entity_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": true
          }
        },
        "isNullable": true
      }
    },
    "name": "type__entity"
  }
*/