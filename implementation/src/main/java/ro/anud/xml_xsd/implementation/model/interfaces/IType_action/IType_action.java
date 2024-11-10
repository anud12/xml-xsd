package ro.anud.xml_xsd.implementation.model.interfaces.IType_action;
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

public interface IType_action<T> {

  public RawNode getRawNode();

  //Children elements
  public ro.anud.xml_xsd.implementation.model.Type_action.From.From getFrom();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_action.From.From> streamFrom();
  public T setFrom(ro.anud.xml_xsd.implementation.model.Type_action.From.From value);

  public ro.anud.xml_xsd.implementation.model.Type_action.On.On getOn();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_action.On.On> streamOn();
  public T setOn(ro.anud.xml_xsd.implementation.model.Type_action.On.On value);
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
        "from": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "person": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "select": {
                  "metaType": "reference",
                  "value": "type__person_selection",
                  "isSingle": true,
                  "isNullable": true
                },
                "property_mutation": {
                  "metaType": "reference",
                  "value": "type__property_mutation",
                  "isSingle": true,
                  "isNullable": true
                }
              },
              "isNullable": true
            }
          },
          "isNullable": false
        },
        "on": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "person": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "select": {
                  "metaType": "reference",
                  "value": "type__person_selection",
                  "isSingle": true,
                  "isNullable": true
                },
                "property_mutation": {
                  "metaType": "reference",
                  "value": "type__property_mutation",
                  "isSingle": true,
                  "isNullable": true
                }
              },
              "isNullable": true
            }
          },
          "isNullable": false
        }
      }
    },
    "name": "type__action"
  }
*/