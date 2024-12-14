package ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutation;
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

public interface IType_propertyMutation<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Attributes
  public String getPropertyRuleRef();
  public T setPropertyRuleRef(String value);

  //Children elements
  public List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> getFrom();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> streamFrom();
  public T addFrom(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From value);
  public T addAllFrom(List<ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From> value);
  public T removeFrom(ro.anud.xml_xsd.implementation.model.Type_propertyMutation.From.From value);
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
          "property_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        },
        "isNullable": false
      },
      "isSingle": false,
      "value": {
        "from": {
          "metaType": "object",
          "attributes": {
            "metaType": "object",
            "value": {
              "participant": {
                "metaType": "primitive",
                "value": "type_person_select",
                "isNullable": false
              }
            },
            "isNullable": false
          },
          "isSingle": false,
          "value": {
            "operation": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": false
            }
          },
          "isNullable": false
        }
      }
    },
    "typeDeclaration": {
      "name": "type__property_mutation",
      "type": "complex",
      "isSingle": false,
      "value": {
        "metaType": "object",
        "attributes": {
          "metaType": "object",
          "value": {
            "property_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "from": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "participant": {
                  "metaType": "primitive",
                  "value": "type_person_select",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isSingle": false,
            "value": {
              "operation": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": false
              }
            },
            "isNullable": false
          }
        }
      }
    },
    "name": "type__property_mutation"
  }
*/