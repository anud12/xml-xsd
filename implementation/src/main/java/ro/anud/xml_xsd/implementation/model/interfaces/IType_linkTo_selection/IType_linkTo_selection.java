package ro.anud.xml_xsd.implementation.model.interfaces.IType_linkTo_selection;

public interface IType_linkTo_selection<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> getOrigin_nodeGraph_selection();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamOrigin_nodeGraph_selection();
  T setOrigin_nodeGraph_selection(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection value);

  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> getDestination_nodeGraph_selection();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection> streamDestination_nodeGraph_selection();
  T setDestination_nodeGraph_selection(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection value);
  void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

  ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

  void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
}

/*
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": true,
      "value": {
        "origin__node_graph__selection": {
          "metaType": "reference",
          "value": "type__node_graph__selection",
          "isSingle": true,
          "isNullable": true
        },
        "destination__node_graph__selection": {
          "metaType": "reference",
          "value": "type__node_graph__selection",
          "isSingle": true,
          "isNullable": true
        }
      }
    },
    "typeDeclaration": {
      "name": "type__link_to__selection",
      "type": "complex",
      "isSingle": true,
      "value": {
        "metaType": "object",
        "isSingle": true,
        "value": {
          "origin__node_graph__selection": {
            "metaType": "reference",
            "value": "type__node_graph__selection",
            "isSingle": true,
            "isNullable": true
          },
          "destination__node_graph__selection": {
            "metaType": "reference",
            "value": "type__node_graph__selection",
            "isSingle": true,
            "isNullable": true
          }
        }
      }
    },
    "name": "type__link_to__selection"
  }
*/