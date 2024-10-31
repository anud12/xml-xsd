package ro.anud.xml_xsd.implementation.model.interfaces.IType_action;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

public interface IType_action<T> {

  //Children elements
  public ro.anud.xml_xsd.implementation.model.Type_action.From.From getFrom();
  public T setFrom(ro.anud.xml_xsd.implementation.model.Type_action.From.From value);
  public ro.anud.xml_xsd.implementation.model.Type_action.On.On getOn();
  public T setOn(ro.anud.xml_xsd.implementation.model.Type_action.On.On value);
  public void deserialize (RawNode rawNode);

  public RawNode serializeIntoRawNode();

  public void serialize(Document document, Element element);
}