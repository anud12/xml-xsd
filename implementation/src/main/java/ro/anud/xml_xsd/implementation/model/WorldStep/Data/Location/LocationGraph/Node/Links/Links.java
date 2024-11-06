package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links;
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

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Links implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Links fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Links();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Links fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Links> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Links.fromRawNode(o, parent)));
    }
    public static List<Links> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Links> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Links.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo> linkTo = new ArrayList<>();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<Links>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "links";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo) {
          this.linkTo.remove(object);
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Links> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing links");
      //Deserialize arguments

      //Deserialize children
      this.linkTo = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo.fromRawNode(rawNode.getChildrenList("link_to"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("link_to", linkTo.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing links");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo> getLinkTo()
    {
      return this.linkTo;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo> streamLinkTo()
    {
      return linkTo.stream();
    }
    public Links addLinkTo(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo value)
    {
      this.linkTo.add(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Links addAllLinkTo(List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo> value)
    {
      this.linkTo.addAll(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Links removeLinkTo(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo value)
    {
      this.linkTo.remove(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

  }


  /*
    dependant type:
    {
      "type": "element",
      "value": {
        "metaType": "object",
        "isSingle": true,
        "value": {
          "link_to": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "node_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "total_progress": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              }
            },
            "isSingle": false,
            "value": {
              "people": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "person": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": false,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "person_id_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "accumulated_progress": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        }
                      }
                    }
                  }
                },
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
        },
        "isNullable": true
      },
      "name": "links"
    }
  */