package ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region;
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
  public class Region implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "region";
    public static Region fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Region();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Region fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Region> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Region.fromRawNode(o, parent)));
        }

    }
    public static List<Region> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Region> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Region.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.data.zone_list.zone.region";
    }

    //Attributes

    private String id;

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule rule = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position position = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit limit = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals> availablePortals = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals> portals = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList> entityList = Optional.empty();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Region>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Region>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "region";
    }
    public static Region of() {
      return new Region();
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone> parentAsZone() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule) {
          throw new RuntimeException("trying to delete rule which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position) {
          throw new RuntimeException("trying to delete position which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit) {
          throw new RuntimeException("trying to delete limit which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals) {
          this.availablePortals = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals) {
          this.portals = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList) {
          this.entityList = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Region> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Region> callback) {
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
          innerLogger.log("id");
          var idValue = rawNode.getAttributeRequired("id");
          if(Objects.equals(this.id, idValue)) {
            isDirty = true;
          }
          this.id = idValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.rule = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule.fromRawNode(rawNode.getChildrenFirst("rule").get(), this);
          this.position = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position.fromRawNode(rawNode.getChildrenFirst("position").get(), this);
          this.limit = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit.fromRawNode(rawNode.getChildrenFirst("limit").get(), this);
          this.availablePortals = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals.fromRawNode(rawNode.getChildrenFirst("available_portals"), this);
          this.portals = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals.fromRawNode(rawNode.getChildrenFirst("portals"), this);
          this.entityList = ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList.fromRawNode(rawNode.getChildrenFirst("entity_list"), this);
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
        rawNode.setTag("region");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("id");
          rawNode.setAttribute("id", this.id);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("rule");
          rawNode.setChildren("rule", Optional.ofNullable(rule).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule::serializeIntoRawNode).toList());
          innerLogger.log("position");
          rawNode.setChildren("position", Optional.ofNullable(position).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position::serializeIntoRawNode).toList());
          innerLogger.log("limit");
          rawNode.setChildren("limit", Optional.ofNullable(limit).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit::serializeIntoRawNode).toList());
          innerLogger.log("available_portals");
          rawNode.setChildren("available_portals", availablePortals.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals::serializeIntoRawNode).toList());
          innerLogger.log("portals");
          rawNode.setChildren("portals", portals.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals::serializeIntoRawNode).toList());
          innerLogger.log("entity_list");
          rawNode.setChildren("entity_list", entityList.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing region");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public Region setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule getRule()
    {
      return this.rule;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule> streamRule()
    {
      return Optional.ofNullable(rule).stream();
    }
    public Region setRule(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule value)
    {
      this.rule = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position getPosition()
    {
      return this.position;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position> streamPosition()
    {
      return Optional.ofNullable(position).stream();
    }
    public Region setPosition(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position value)
    {
      this.position = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit getLimit()
    {
      return this.limit;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit> streamLimit()
    {
      return Optional.ofNullable(limit).stream();
    }
    public Region setLimit(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit value)
    {
      this.limit = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals> getAvailablePortals()
    {
      return this.availablePortals;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals getAvailablePortalsOrDefault()
    {
      return this.availablePortals.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals();
        this.availablePortals = Optional.of(instance);
        instance.parentNode(this);
        return this.availablePortals.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals> streamAvailablePortalsOrDefault()
    {
      return java.util.stream.Stream.of(getAvailablePortalsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals> streamAvailablePortals()
    {
      return availablePortals.stream();
    }
    public Region setAvailablePortals(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals value)
    {
      this.availablePortals = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals> getPortals()
    {
      return this.portals;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals getPortalsOrDefault()
    {
      return this.portals.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals();
        this.portals = Optional.of(instance);
        instance.parentNode(this);
        return this.portals.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals> streamPortalsOrDefault()
    {
      return java.util.stream.Stream.of(getPortalsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals> streamPortals()
    {
      return portals.stream();
    }
    public Region setPortals(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals value)
    {
      this.portals = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList> getEntityList()
    {
      return this.entityList;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList getEntityListOrDefault()
    {
      return this.entityList.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList();
        this.entityList = Optional.of(instance);
        instance.parentNode(this);
        return this.entityList.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList> streamEntityListOrDefault()
    {
      return java.util.stream.Stream.of(getEntityListOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList> streamEntityList()
    {
      return entityList.stream();
    }
    public Region setEntityList(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList value)
    {
      this.entityList = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule.nodeName.length() + 3);
          return this.rule.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position.nodeName.length() + 3);
          return this.position.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit.nodeName.length() + 3);
          return this.limit.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals.nodeName))
        {
          if(this.availablePortals.isEmpty()) {
            this.availablePortals = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals.nodeName.length() + 3);
          return this.availablePortals.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals.nodeName))
        {
          if(this.portals.isEmpty()) {
            this.portals = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals.nodeName.length() + 3);
          return this.portals.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList.nodeName))
        {
          if(this.entityList.isEmpty()) {
            this.entityList = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList.nodeName.length() + 3);
          return this.entityList.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule.nodeName.length() + 3);
          return this.rule.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position.nodeName.length() + 3);
          return this.position.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit.nodeName.length() + 3);
          return this.limit.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals.nodeName))
        {
          if(this.availablePortals.isEmpty()) {
            this.availablePortals = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals.nodeName.length() + 3);
          return this.availablePortals.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals.nodeName))
        {
          if(this.portals.isEmpty()) {
            this.portals = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals.nodeName.length() + 3);
          return this.portals.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList.nodeName))
        {
          if(this.entityList.isEmpty()) {
            this.entityList = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList.nodeName.length() + 3);
          return this.entityList.get().getNodeAtPath(childXPath);
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
            "id": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "rule": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "rule_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
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
                  "value": "xs:int",
                  "isNullable": false
                },
                "y": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                },
                "rotation": {
                  "metaType": "primitive",
                  "value": "type__rotation_90deg_step",
                  "isNullable": false
                }
              }
            }
          },
          "limit": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "width": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                },
                "height": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              }
            }
          },
          "available_portals": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "portal": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "start": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": false
                    },
                    "side": {
                      "metaType": "primitive",
                      "value": "type__rectangle_side",
                      "isNullable": false
                    },
                    "portal_rule_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  }
                }
              }
            },
            "isNullable": true
          },
          "portals": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "portal": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "from": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "side": {
                          "metaType": "primitive",
                          "value": "type__rectangle_side",
                          "isNullable": false
                        },
                        "start": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        },
                        "end": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        }
                      }
                    }
                  },
                  "to": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "zone_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "region_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "side": {
                          "metaType": "primitive",
                          "value": "type__rectangle_side",
                          "isNullable": false
                        },
                        "start": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        },
                        "end": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        }
                      }
                    }
                  }
                },
                "isNullable": false
              }
            },
            "isNullable": true
          },
          "entity_list": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entity": {
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
              }
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "region"
    }
  */