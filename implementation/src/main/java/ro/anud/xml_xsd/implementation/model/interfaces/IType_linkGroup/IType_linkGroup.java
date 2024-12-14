package ro.anud.xml_xsd.implementation.model.interfaces.IType_linkGroup;

public interface IType_linkGroup<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Attributes
  String getId();
  T setId(String value);
  Integer getAngle();
  T setAngle(Integer value);
  java.util.Optional<Integer> getAngleMax();
  T setAngleMax(java.util.Optional<Integer> value);
  java.util.Optional<Integer> getLimit();
  T setLimit(java.util.Optional<Integer> value);

  //Children elements
  java.util.List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> getToOption();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> streamToOption();
  T addToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value);
  T addAllToOption(java.util.List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> value);
  T removeToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value);
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
          "id": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          },
          "angle": {
            "metaType": "primitive",
            "value": "xs:int",
            "isNullable": false
          },
          "angleMax": {
            "metaType": "primitive",
            "value": "xs:int",
            "isNullable": true
          },
          "limit": {
            "metaType": "primitive",
            "value": "xs:int",
            "isNullable": true
          }
        }
      },
      "isSingle": false,
      "value": {
        "to_option": {
          "metaType": "object",
          "attributes": {
            "metaType": "object",
            "value": {
              "node_rule_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              },
              "distance": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              },
              "maxDistance": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": true
              },
              "adjacent_depth_limit": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            }
          },
          "isSingle": false,
          "value": {
            "distance_to_progress_multiplier": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": true
            },
            "person_progress_property": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": true
            }
          },
          "isNullable": true
        }
      }
    },
    "name": "type__link_group"
  }
*/