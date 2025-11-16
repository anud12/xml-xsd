package ro.anud.xml_xsd.implementation.model.interfaces.IType_entityRule;

public interface IType_entityRule<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Attributes
  String getName();
  T setName(String value);

  //Children elements
  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_entityRule.Containers.Containers> getContainers();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_entityRule.Containers.Containers> streamContainers();
  T setContainers(ro.anud.xml_xsd.implementation.model.Type_entityRule.Containers.Containers value);
  void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

  ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

  void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
}

/*
  {
    "type": "element",
    "value": {
      "metaType": "object",
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
      },
      "isSingle": true,
      "value": {
        "containers": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "container": {
              "metaType": "object",
              "value": {},
              "isSingle": false,
              "isNullable": true,
              "attributes": {
                "metaType": "object",
                "value": {
                  "container_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  }
                },
                "isNullable": false
              }
            }
          },
          "isNullable": true
        }
      }
    },
    "name": "type__entity_rule"
  }
*/