package ro.anud.xml_xsd.implementation.model.interfaces.IType_nameToken;
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

public interface IType_nameToken<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  public List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> getNameToken();
  public Stream<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> streamNameToken();
  public T addNameToken(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken value);
  public T addAllNameToken(List<ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken> value);
  public T removeNameToken(ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken value);
  public void deserialize (RawNode rawNode);

  public RawNode serializeIntoRawNode();

  public void serialize(Document document, Element element);
}

/*
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": false,
      "value": {
        "name_token": {
          "metaType": "union",
          "value": [
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": true,
              "value": {
                "ref": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "name_rule_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  }
                }
              }
            },
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": true,
              "value": {
                "one_of": {
                  "metaType": "composition",
                  "value": [
                    {
                      "metaType": "object",
                      "value": {},
                      "isSingle": true,
                      "isNullable": false
                    },
                    {
                      "metaType": "primitive",
                      "value": "type__name_token"
                    }
                  ],
                  "isSingle": true,
                  "isNullable": true
                }
              }
            }
          ],
          "isSingle": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "prefix": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            },
            "isNullable": false
          },
          "isNullable": false
        }
      }
    },
    "name": "type__name_token"
  }
*/