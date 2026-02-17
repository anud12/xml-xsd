package ro.anud.xml_xsd.implementation.model.WorldStep.Actions;
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
  public class Actions implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "actions";
    public static Actions fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Actions();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Actions fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Actions> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Actions.fromRawNode(o, parent)));
        }

    }
    public static List<Actions> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Actions> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Actions.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.actions";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> locationGraph_create = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> locationGraph_node_createAdjacent = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> locationGraph_node_addClassification = new ArrayList<>();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create> zone_create = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew> region_appendNew = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals> region_resolvePortals = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity> region_teleportEntity = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create> entity_create = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText> entity_setText = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity> container_addOnEntity = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo> operation_echo = Optional.empty();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Actions>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Actions>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "actions";
    }
    public static Actions of() {
      return new Actions();
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep> parentAsWorldStep() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create) {
          this.locationGraph_create.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent) {
          this.locationGraph_node_createAdjacent.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification) {
          this.locationGraph_node_addClassification.remove(object);
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create) {
          this.zone_create = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew) {
          this.region_appendNew = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals) {
          this.region_resolvePortals = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity) {
          this.region_teleportEntity = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create) {
          this.entity_create = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText) {
          this.entity_setText = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity) {
          this.container_addOnEntity = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo) {
          this.operation_echo = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create) {
          return this.locationGraph_create.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent) {
          return this.locationGraph_node_createAdjacent.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification) {
          return this.locationGraph_node_addClassification.indexOf(object);
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Actions> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Actions> callback) {
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
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.locationGraph_create = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.fromRawNode(rawNode.getChildrenList("location_graph.create"), this);
          this.locationGraph_node_createAdjacent = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.fromRawNode(rawNode.getChildrenList("location_graph.node.create_adjacent"), this);
          this.locationGraph_node_addClassification = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.fromRawNode(rawNode.getChildrenList("location_graph.node.add_classification"), this);
          this.zone_create = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.fromRawNode(rawNode.getChildrenFirst("zone.create"), this);
          this.region_appendNew = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.fromRawNode(rawNode.getChildrenFirst("region.appendNew"), this);
          this.region_resolvePortals = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.fromRawNode(rawNode.getChildrenFirst("region.resolvePortals"), this);
          this.region_teleportEntity = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity.fromRawNode(rawNode.getChildrenFirst("region.teleportEntity"), this);
          this.entity_create = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create.fromRawNode(rawNode.getChildrenFirst("entity.create"), this);
          this.entity_setText = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText.fromRawNode(rawNode.getChildrenFirst("entity.setText"), this);
          this.container_addOnEntity = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity.fromRawNode(rawNode.getChildrenFirst("container.addOnEntity"), this);
          this.operation_echo = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo.fromRawNode(rawNode.getChildrenFirst("operation.echo"), this);
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
        rawNode.setTag("actions");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("location_graph.create");
          rawNode.setChildren("location_graph.create", locationGraph_create.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create::serializeIntoRawNode).toList());
          innerLogger.log("location_graph.node.create_adjacent");
          rawNode.setChildren("location_graph.node.create_adjacent", locationGraph_node_createAdjacent.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent::serializeIntoRawNode).toList());
          innerLogger.log("location_graph.node.add_classification");
          rawNode.setChildren("location_graph.node.add_classification", locationGraph_node_addClassification.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification::serializeIntoRawNode).toList());
          innerLogger.log("zone.create");
          rawNode.setChildren("zone.create", zone_create.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create::serializeIntoRawNode).toList());
          innerLogger.log("region.appendNew");
          rawNode.setChildren("region.appendNew", region_appendNew.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew::serializeIntoRawNode).toList());
          innerLogger.log("region.resolvePortals");
          rawNode.setChildren("region.resolvePortals", region_resolvePortals.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals::serializeIntoRawNode).toList());
          innerLogger.log("region.teleportEntity");
          rawNode.setChildren("region.teleportEntity", region_teleportEntity.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity::serializeIntoRawNode).toList());
          innerLogger.log("entity.create");
          rawNode.setChildren("entity.create", entity_create.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create::serializeIntoRawNode).toList());
          innerLogger.log("entity.setText");
          rawNode.setChildren("entity.setText", entity_setText.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText::serializeIntoRawNode).toList());
          innerLogger.log("container.addOnEntity");
          rawNode.setChildren("container.addOnEntity", container_addOnEntity.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity::serializeIntoRawNode).toList());
          innerLogger.log("operation.echo");
          rawNode.setChildren("operation.echo", operation_echo.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing actions");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> getLocationGraph_create()
    {
      return this.locationGraph_create;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> streamLocationGraph_create()
    {
      return locationGraph_create.stream();
    }
    public Actions addLocationGraph_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create value)
    {
      this.locationGraph_create.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllLocationGraph_create(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create> value)
    {
      this.locationGraph_create.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removeLocationGraph_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create value)
    {
      this.locationGraph_create.remove(value);
      value.clearParentNode();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> getLocationGraph_node_createAdjacent()
    {
      return this.locationGraph_node_createAdjacent;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> streamLocationGraph_node_createAdjacent()
    {
      return locationGraph_node_createAdjacent.stream();
    }
    public Actions addLocationGraph_node_createAdjacent(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent value)
    {
      this.locationGraph_node_createAdjacent.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllLocationGraph_node_createAdjacent(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent> value)
    {
      this.locationGraph_node_createAdjacent.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removeLocationGraph_node_createAdjacent(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent value)
    {
      this.locationGraph_node_createAdjacent.remove(value);
      value.clearParentNode();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> getLocationGraph_node_addClassification()
    {
      return this.locationGraph_node_addClassification;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> streamLocationGraph_node_addClassification()
    {
      return locationGraph_node_addClassification.stream();
    }
    public Actions addLocationGraph_node_addClassification(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification value)
    {
      this.locationGraph_node_addClassification.add(value);
      value.parentNode(this);
      return this;
    }
    public Actions addAllLocationGraph_node_addClassification(List<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification> value)
    {
      this.locationGraph_node_addClassification.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Actions removeLocationGraph_node_addClassification(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification value)
    {
      this.locationGraph_node_addClassification.remove(value);
      value.clearParentNode();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create> getZone_create()
    {
      return this.zone_create;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create getZone_createOrDefault()
    {
      return this.zone_create.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create();
        this.zone_create = Optional.of(instance);
        instance.parentNode(this);
        return this.zone_create.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create> streamZone_createOrDefault()
    {
      return java.util.stream.Stream.of(getZone_createOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create> streamZone_create()
    {
      return zone_create.stream();
    }
    public Actions setZone_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create value)
    {
      this.zone_create = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew> getRegion_appendNew()
    {
      return this.region_appendNew;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew getRegion_appendNewOrDefault()
    {
      return this.region_appendNew.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew();
        this.region_appendNew = Optional.of(instance);
        instance.parentNode(this);
        return this.region_appendNew.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew> streamRegion_appendNewOrDefault()
    {
      return java.util.stream.Stream.of(getRegion_appendNewOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew> streamRegion_appendNew()
    {
      return region_appendNew.stream();
    }
    public Actions setRegion_appendNew(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew value)
    {
      this.region_appendNew = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals> getRegion_resolvePortals()
    {
      return this.region_resolvePortals;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals getRegion_resolvePortalsOrDefault()
    {
      return this.region_resolvePortals.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals();
        this.region_resolvePortals = Optional.of(instance);
        instance.parentNode(this);
        return this.region_resolvePortals.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals> streamRegion_resolvePortalsOrDefault()
    {
      return java.util.stream.Stream.of(getRegion_resolvePortalsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals> streamRegion_resolvePortals()
    {
      return region_resolvePortals.stream();
    }
    public Actions setRegion_resolvePortals(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals value)
    {
      this.region_resolvePortals = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity> getRegion_teleportEntity()
    {
      return this.region_teleportEntity;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity getRegion_teleportEntityOrDefault()
    {
      return this.region_teleportEntity.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity();
        this.region_teleportEntity = Optional.of(instance);
        instance.parentNode(this);
        return this.region_teleportEntity.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity> streamRegion_teleportEntityOrDefault()
    {
      return java.util.stream.Stream.of(getRegion_teleportEntityOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity> streamRegion_teleportEntity()
    {
      return region_teleportEntity.stream();
    }
    public Actions setRegion_teleportEntity(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity value)
    {
      this.region_teleportEntity = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create> getEntity_create()
    {
      return this.entity_create;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create getEntity_createOrDefault()
    {
      return this.entity_create.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create();
        this.entity_create = Optional.of(instance);
        instance.parentNode(this);
        return this.entity_create.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create> streamEntity_createOrDefault()
    {
      return java.util.stream.Stream.of(getEntity_createOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create> streamEntity_create()
    {
      return entity_create.stream();
    }
    public Actions setEntity_create(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create value)
    {
      this.entity_create = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText> getEntity_setText()
    {
      return this.entity_setText;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText getEntity_setTextOrDefault()
    {
      return this.entity_setText.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText();
        this.entity_setText = Optional.of(instance);
        instance.parentNode(this);
        return this.entity_setText.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText> streamEntity_setTextOrDefault()
    {
      return java.util.stream.Stream.of(getEntity_setTextOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText> streamEntity_setText()
    {
      return entity_setText.stream();
    }
    public Actions setEntity_setText(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText value)
    {
      this.entity_setText = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity> getContainer_addOnEntity()
    {
      return this.container_addOnEntity;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity getContainer_addOnEntityOrDefault()
    {
      return this.container_addOnEntity.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity();
        this.container_addOnEntity = Optional.of(instance);
        instance.parentNode(this);
        return this.container_addOnEntity.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity> streamContainer_addOnEntityOrDefault()
    {
      return java.util.stream.Stream.of(getContainer_addOnEntityOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity> streamContainer_addOnEntity()
    {
      return container_addOnEntity.stream();
    }
    public Actions setContainer_addOnEntity(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity value)
    {
      this.container_addOnEntity = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo> getOperation_echo()
    {
      return this.operation_echo;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo getOperation_echoOrDefault()
    {
      return this.operation_echo.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo();
        this.operation_echo = Optional.of(instance);
        instance.parentNode(this);
        return this.operation_echo.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo> streamOperation_echoOrDefault()
    {
      return java.util.stream.Stream.of(getOperation_echoOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo> streamOperation_echo()
    {
      return operation_echo.stream();
    }
    public Actions setOperation_echo(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo value)
    {
      this.operation_echo = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.locationGraph_create.size() > pathIndex) {
              return this.locationGraph_create.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addLocationGraph_create(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.locationGraph_node_createAdjacent.size() > pathIndex) {
              return this.locationGraph_node_createAdjacent.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addLocationGraph_node_createAdjacent(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.locationGraph_node_addClassification.size() > pathIndex) {
              return this.locationGraph_node_addClassification.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addLocationGraph_node_addClassification(newEntry);
          return linkedNode;
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.nodeName))
        {
          if(this.zone_create.isEmpty()) {
            this.zone_create = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.nodeName.length() + 3);
          return this.zone_create.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.nodeName))
        {
          if(this.region_appendNew.isEmpty()) {
            this.region_appendNew = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.nodeName.length() + 3);
          return this.region_appendNew.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.nodeName))
        {
          if(this.region_resolvePortals.isEmpty()) {
            this.region_resolvePortals = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.nodeName.length() + 3);
          return this.region_resolvePortals.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity.nodeName))
        {
          if(this.region_teleportEntity.isEmpty()) {
            this.region_teleportEntity = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity.nodeName.length() + 3);
          return this.region_teleportEntity.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create.nodeName))
        {
          if(this.entity_create.isEmpty()) {
            this.entity_create = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create.nodeName.length() + 3);
          return this.entity_create.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText.nodeName))
        {
          if(this.entity_setText.isEmpty()) {
            this.entity_setText = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText.nodeName.length() + 3);
          return this.entity_setText.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity.nodeName))
        {
          if(this.container_addOnEntity.isEmpty()) {
            this.container_addOnEntity = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity.nodeName.length() + 3);
          return this.container_addOnEntity.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo.nodeName))
        {
          if(this.operation_echo.isEmpty()) {
            this.operation_echo = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo.nodeName.length() + 3);
          return this.operation_echo.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.locationGraph_create.size() > pathIndex) {
            return this.locationGraph_create.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.locationGraph_node_createAdjacent.size() > pathIndex) {
            return this.locationGraph_node_createAdjacent.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.locationGraph_node_addClassification.size() > pathIndex) {
            return this.locationGraph_node_addClassification.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.nodeName))
        {
          if(this.zone_create.isEmpty()) {
            this.zone_create = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create.nodeName.length() + 3);
          return this.zone_create.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.nodeName))
        {
          if(this.region_appendNew.isEmpty()) {
            this.region_appendNew = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew.nodeName.length() + 3);
          return this.region_appendNew.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.nodeName))
        {
          if(this.region_resolvePortals.isEmpty()) {
            this.region_resolvePortals = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_resolvePortals.Region_resolvePortals.nodeName.length() + 3);
          return this.region_resolvePortals.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity.nodeName))
        {
          if(this.region_teleportEntity.isEmpty()) {
            this.region_teleportEntity = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity.nodeName.length() + 3);
          return this.region_teleportEntity.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create.nodeName))
        {
          if(this.entity_create.isEmpty()) {
            this.entity_create = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create.nodeName.length() + 3);
          return this.entity_create.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText.nodeName))
        {
          if(this.entity_setText.isEmpty()) {
            this.entity_setText = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_setText.Entity_setText.nodeName.length() + 3);
          return this.entity_setText.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity.nodeName))
        {
          if(this.container_addOnEntity.isEmpty()) {
            this.container_addOnEntity = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity.nodeName.length() + 3);
          return this.container_addOnEntity.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo.nodeName))
        {
          if(this.operation_echo.isEmpty()) {
            this.operation_echo = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo.nodeName.length() + 3);
          return this.operation_echo.get().getNodeAtPath(childXPath);
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
        "isSingle": true,
        "value": {
          "location_graph.create": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "location_graph_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "location_graph.node.create_adjacent": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "location_graph_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "node_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "location_graph.node.add_classification": {
            "metaType": "object",
            "isSingle": false,
            "value": {
              "node_graph_selection": {
                "metaType": "reference",
                "value": "type__node_graph__selection",
                "isSingle": true,
                "isNullable": false
              },
              "to_be_added__classification": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "location_classification_rule_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": true,
                "value": {
                  "and": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "location_classification_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  }
                },
                "isNullable": false
              }
            },
            "isNullable": true
          },
          "zone.create": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "zone_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "region.appendNew": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "zone_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "region_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "portal_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "region.resolvePortals": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "zone_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "region_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "region.teleportEntity": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "zone_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "region_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "entity_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "x": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                },
                "y": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              }
            }
          },
          "entity.create": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "entity_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "entity.setText": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "entity_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "name": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "value": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "container.addOnEntity": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "container_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "entity_id": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "operation.echo": {
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
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "entity_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  }
                }
              },
              {
                "metaType": "primitive",
                "value": "type__math_operations"
              }
            ],
            "isSingle": true,
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "actions"
    }
  */