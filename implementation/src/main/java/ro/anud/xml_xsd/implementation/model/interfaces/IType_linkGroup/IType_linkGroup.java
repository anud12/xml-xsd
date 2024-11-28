package ro.anud.xml_xsd.implementation.model.interfaces.IType_linkGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import java.util.stream.Stream;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.log;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

public interface IType_linkGroup<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  public RawNode getRawNode();

  //Attributes
  public String getId();
  public T setId(String value);
  public Integer getAngle();
  public T setAngle(Integer value);
  public Optional<Integer> getAngleMax();
  public T setAngleMax(Optional<Integer> value);
  public Optional<Integer> getLimit();
  public T setLimit(Optional<Integer> value);

  //Children elements
  public List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> getToOption();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> streamToOption();
  public T addToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value);
  public T addAllToOption(List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> value);
  public T removeToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value);
  public void deserialize (RawNode rawNode);

  public RawNode serializeIntoRawNode();

  public void serialize(Document document, Element element);
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