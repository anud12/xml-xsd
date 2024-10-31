package ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection;
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

public interface IType_personSelection<T> {

  //Children elements
  public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getRadius();
  public T setRadius(Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> value);
  public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMin();
  public T setMin(Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> value);
  public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMax();
  public T setMax(Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> value);
  public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> getProperty();
  public T setProperty(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> value);
  public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> getClassification();
  public T setClassification(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> value);
  public Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race> getRace();
  public T setRace(Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race> value);
  public void deserialize (RawNode rawNode);

  public RawNode serializeIntoRawNode();

  public void serialize(Document document, Element element);
}