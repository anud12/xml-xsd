package ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

public interface IType_personSelection {

  //Children elements
  public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getRadius();
  public void setRadius(Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> value);
  public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMin();
  public void setMin(Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> value);
  public Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> getMax();
  public void setMax(Optional<ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations> value);
  public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> getProperty();
  public void setProperty(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property> value);
  public List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> getClassification();
  public void setClassification(List<ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification> value);
  public Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race> getRace();
  public void setRace(Optional<ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race> value);
  public void deserialize (RawNode rawNode);

  public RawNode SerializeIntoRawNode();

  public void Serialize(Document document, Element element);
}