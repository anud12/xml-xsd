package ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations;
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

public interface IType_mathOperations<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {
  public void deserialize (RawNode rawNode);

  public RawNode serializeIntoRawNode();

  public void serialize(Document document, Element element);
}

/*
  {
    "type": "element",
    "value": {
      "metaType": "composition",
      "value": [
        {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "initial": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        {
          "metaType": "primitive",
          "value": "type__math_operations_and"
        }
      ]
    },
    "name": "type__math_operations"
  }
*/