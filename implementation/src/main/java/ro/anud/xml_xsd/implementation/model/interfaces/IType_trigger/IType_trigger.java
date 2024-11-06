package ro.anud.xml_xsd.implementation.model.interfaces.IType_trigger;
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

public interface IType_trigger<T> {

  public RawNode getRawNode();

  //Children elements
  public ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed getPersonActionUsed();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed> streamPersonActionUsed();
  public T setPersonActionUsed(ro.anud.xml_xsd.implementation.model.Type_trigger.PersonActionUsed.PersonActionUsed value);
  public void deserialize (RawNode rawNode);

  public RawNode serializeIntoRawNode();

  public void serialize(Document document, Element element);
}

/*
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": true,
      "value": {
        "person_action_used": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "action_rule_ref": {
                "metaType": "unknown",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        }
      }
    },
    "typeDeclaration": {
      "name": "type__trigger",
      "type": "complex",
      "isSingle": true,
      "value": {
        "metaType": "object",
        "isSingle": true,
        "value": {
          "person_action_used": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "action_rule_ref": {
                  "metaType": "unknown",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          }
        }
      }
    },
    "name": "type__trigger"
  }
*/