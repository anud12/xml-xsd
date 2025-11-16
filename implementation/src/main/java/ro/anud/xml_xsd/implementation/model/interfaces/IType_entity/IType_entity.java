package ro.anud.xml_xsd.implementation.model.interfaces.IType_entity;

public interface IType_entity<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Attributes
  java.util.Optional<String> getEntityRuleRef();
  T setEntityRuleRef(java.util.Optional<String> value);

  //Children elements
  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers> getContainers();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers> streamContainers();
  T setContainers(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers value);
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
          "entity_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": true
          }
        },
        "isNullable": true
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
    "name": "type__entity"
  }
*/