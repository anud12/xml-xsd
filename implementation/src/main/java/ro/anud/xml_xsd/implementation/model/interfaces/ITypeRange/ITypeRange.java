package ro.anud.xml_xsd.implementation.model.interfaces.ITypeRange;

public interface ITypeRange<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

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
        "metaType": "reference",
        "value": "attributeGroup_range"
      }
    },
    "typeDeclaration": {
      "name": "type_range",
      "type": "complex",
      "isSingle": true,
      "isNullable": false,
      "value": {
        "metaType": "object",
        "value": {},
        "isSingle": true,
        "isNullable": false,
        "attributes": {
          "metaType": "reference",
          "value": "attributeGroup_range"
        }
      }
    },
    "name": "type_range"
  }
*/