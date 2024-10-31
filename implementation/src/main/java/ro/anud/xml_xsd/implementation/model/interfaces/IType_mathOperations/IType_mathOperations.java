package ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations;
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

public interface IType_mathOperations {
  //Attributes
  public Integer getInitial();
  public void setInitial(Integer value);
  public void deserialize (RawNode rawNode);

  public RawNode SerializeIntoRawNode();

  public void Serialize(Document document, Element element);
}