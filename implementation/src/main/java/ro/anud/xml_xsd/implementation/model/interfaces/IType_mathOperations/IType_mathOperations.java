package ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations;

public interface IType_mathOperations<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {
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
              "initial": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        {
          "metaType": "primitive",
          "value": "type__math_operations_and"
        }
      ]
    },
    "name": "type__math_operations"
  }
*/