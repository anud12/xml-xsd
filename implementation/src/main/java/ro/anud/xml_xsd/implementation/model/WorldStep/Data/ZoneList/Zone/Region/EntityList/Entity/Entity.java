package ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class Entity implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "entity";
    public static Entity fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Entity();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Entity fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Entity> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Entity.fromRawNode(o, parent)));
        }

    }
    public static List<Entity> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Entity> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Entity.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.data.zone_list.zone.region.entity_list.entity";
    }

    //Attributes

    private String entityIdRef;

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position position = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private RawNode rawNode = new RawNode();

    public RawNode rawNode() {
      return rawNode;
    }
    public void rawNode(RawNode rawNode) {
      this.rawNode = rawNode;
    }

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode() {
      return parentNode;
    }

    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Entity>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Entity>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "entity";
    }
    public static Entity of() {
      return new Entity();
    }

    public void notifyChange(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.onChange(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(object));
      }
    }

    public void notifyRemove(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify remove for", this.buildPath());
        onRemoveList.forEach(consumer -> consumer.onRemove(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyRemove(object));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode.ifPresent(parent -> notifyRemove());
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList> parentAsEntityList() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position) {
          throw new RuntimeException("trying to delete position which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Entity> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Entity> callback) {
      try (var logger = logScope()) {
        onRemoveList.add(callback);
        return logger.logReturn(() -> onRemoveList.remove(callback));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("entity_id_ref");
          var entityIdRefValue = rawNode.getAttributeRequired("entity_id_ref");
          if(Objects.equals(this.entityIdRef, entityIdRefValue)) {
            isDirty = true;
          }
          this.entityIdRef = entityIdRefValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.position = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position.fromRawNode(rawNode.getChildrenFirst("position").get(), this);
        }

        if(isDirty) {
          notifyChange();
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("entity");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("entity_id_ref");
          rawNode.setAttribute("entity_id_ref", this.entityIdRef);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("position");
          rawNode.setChildren("position", Optional.ofNullable(position).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing entity");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getEntityIdRef()
    {
      return this.entityIdRef;
    }
    public Entity setEntityIdRef(String value)
    {
      this.entityIdRef = value;
      notifyChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position getPosition()
    {
      return this.position;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position> streamPosition()
    {
      return Optional.ofNullable(position).stream();
    }
    public Entity setPosition(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position value)
    {
      this.position = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position.nodeName.length() + 3);
          return this.position.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position.nodeName.length() + 3);
          return this.position.getNodeAtPath(childXPath);
        }
        return Optional.of(this);
    }
  }


  /*
    dependant type:
    {
      "type": "element",
      "value": {
        "metaType": "object",
        "attributes": {
          "metaType": "object",
          "value": {
            "entity_id_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "position": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "x": {
                  "metaType": "primitive",
                  "value": "xs:integer",
                  "isNullable": false
                },
                "y": {
                  "metaType": "primitive",
                  "value": "xs:integer",
                  "isNullable": false
                }
              }
            }
          }
        },
        "isNullable": true
      },
      "name": "entity"
    }
  */