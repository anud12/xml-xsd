package ro.anud.xml_xsd.implementation.model.interfaces.ITypeIcon;

public interface ITypeIcon<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {
  void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

  ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

  void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
}

/*
  {
    "type": "element",
    "value": {
      "metaType": "any"
    },
    "typeDeclaration": {
      "name": "type_icon",
      "type": "complex",
      "value": {
        "metaType": "any"
      }
    },
    "name": "type_icon"
  }
*/