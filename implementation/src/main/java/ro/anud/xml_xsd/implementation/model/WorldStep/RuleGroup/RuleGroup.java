package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup;
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
  public class RuleGroup implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "rule_group";
    public static RuleGroup fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new RuleGroup();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static RuleGroup fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<RuleGroup> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> RuleGroup.fromRawNode(o, parent)));
        }

    }
    public static List<RuleGroup> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<RuleGroup> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> RuleGroup.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.rule_group";
    }

    //Attributes
    /* ignored attribute key={key} of type=Object*/

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule> entityRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule> containerRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> classificationRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> nameRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> linkGroupRuleList = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> locationGraphRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> locationClassificationRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule> nodeRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule> portalRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule> regionRule = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule> zoneRule = Optional.empty();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<RuleGroup>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<RuleGroup>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "rule_group";
    }
    public static RuleGroup of() {
      return new RuleGroup();
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule) {
          this.entityRule = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule) {
          this.containerRule = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule) {
          this.classificationRule = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule) {
          this.nameRule = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList) {
          this.linkGroupRuleList = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule) {
          this.locationGraphRule = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule) {
          this.locationClassificationRule = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule) {
          this.nodeRule = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule) {
          this.portalRule = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule) {
          this.regionRule = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule) {
          this.zoneRule = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<RuleGroup> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<RuleGroup> callback) {
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
          this.entityRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule.fromRawNode(rawNode.getChildrenFirst("entity_rule"), this);
          this.containerRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule.fromRawNode(rawNode.getChildrenFirst("container_rule"), this);
          this.classificationRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule.fromRawNode(rawNode.getChildrenFirst("classification_rule"), this);
          this.nameRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule.fromRawNode(rawNode.getChildrenFirst("name_rule"), this);
          this.linkGroupRuleList = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList.fromRawNode(rawNode.getChildrenFirst("link_group_rule_list"), this);
          this.locationGraphRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule.fromRawNode(rawNode.getChildrenFirst("location_graph_rule"), this);
          this.locationClassificationRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule.fromRawNode(rawNode.getChildrenFirst("location_classification_rule"), this);
          this.nodeRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule.fromRawNode(rawNode.getChildrenFirst("node_rule"), this);
          this.portalRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule.fromRawNode(rawNode.getChildrenFirst("portal_rule"), this);
          this.regionRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule.fromRawNode(rawNode.getChildrenFirst("region_rule"), this);
          this.zoneRule = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule.fromRawNode(rawNode.getChildrenFirst("zone_rule"), this);
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
        rawNode.setTag("rule_group");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("entity_rule");
          rawNode.setChildren("entity_rule", entityRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule::serializeIntoRawNode).toList());
          innerLogger.log("container_rule");
          rawNode.setChildren("container_rule", containerRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule::serializeIntoRawNode).toList());
          innerLogger.log("classification_rule");
          rawNode.setChildren("classification_rule", classificationRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule::serializeIntoRawNode).toList());
          innerLogger.log("name_rule");
          rawNode.setChildren("name_rule", nameRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule::serializeIntoRawNode).toList());
          innerLogger.log("link_group_rule_list");
          rawNode.setChildren("link_group_rule_list", linkGroupRuleList.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList::serializeIntoRawNode).toList());
          innerLogger.log("location_graph_rule");
          rawNode.setChildren("location_graph_rule", locationGraphRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule::serializeIntoRawNode).toList());
          innerLogger.log("location_classification_rule");
          rawNode.setChildren("location_classification_rule", locationClassificationRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule::serializeIntoRawNode).toList());
          innerLogger.log("node_rule");
          rawNode.setChildren("node_rule", nodeRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule::serializeIntoRawNode).toList());
          innerLogger.log("portal_rule");
          rawNode.setChildren("portal_rule", portalRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule::serializeIntoRawNode).toList());
          innerLogger.log("region_rule");
          rawNode.setChildren("region_rule", regionRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule::serializeIntoRawNode).toList());
          innerLogger.log("zone_rule");
          rawNode.setChildren("zone_rule", zoneRule.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing rule_group");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    /* ignored attribute key={key} of type=Object*/
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule> getEntityRule()
    {
      return this.entityRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule getEntityRuleOrDefault()
    {
      return this.entityRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule();
        this.entityRule = Optional.of(instance);
        instance.parentNode(this);
        return this.entityRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule> streamEntityRuleOrDefault()
    {
      return java.util.stream.Stream.of(getEntityRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule> streamEntityRule()
    {
      return entityRule.stream();
    }
    public RuleGroup setEntityRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule value)
    {
      this.entityRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule> getContainerRule()
    {
      return this.containerRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule getContainerRuleOrDefault()
    {
      return this.containerRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule();
        this.containerRule = Optional.of(instance);
        instance.parentNode(this);
        return this.containerRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule> streamContainerRuleOrDefault()
    {
      return java.util.stream.Stream.of(getContainerRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule> streamContainerRule()
    {
      return containerRule.stream();
    }
    public RuleGroup setContainerRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule value)
    {
      this.containerRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> getClassificationRule()
    {
      return this.classificationRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule getClassificationRuleOrDefault()
    {
      return this.classificationRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule();
        this.classificationRule = Optional.of(instance);
        instance.parentNode(this);
        return this.classificationRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> streamClassificationRuleOrDefault()
    {
      return java.util.stream.Stream.of(getClassificationRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule> streamClassificationRule()
    {
      return classificationRule.stream();
    }
    public RuleGroup setClassificationRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule value)
    {
      this.classificationRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> getNameRule()
    {
      return this.nameRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule getNameRuleOrDefault()
    {
      return this.nameRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule();
        this.nameRule = Optional.of(instance);
        instance.parentNode(this);
        return this.nameRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> streamNameRuleOrDefault()
    {
      return java.util.stream.Stream.of(getNameRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule> streamNameRule()
    {
      return nameRule.stream();
    }
    public RuleGroup setNameRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule value)
    {
      this.nameRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> getLinkGroupRuleList()
    {
      return this.linkGroupRuleList;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList getLinkGroupRuleListOrDefault()
    {
      return this.linkGroupRuleList.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList();
        this.linkGroupRuleList = Optional.of(instance);
        instance.parentNode(this);
        return this.linkGroupRuleList.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> streamLinkGroupRuleListOrDefault()
    {
      return java.util.stream.Stream.of(getLinkGroupRuleListOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> streamLinkGroupRuleList()
    {
      return linkGroupRuleList.stream();
    }
    public RuleGroup setLinkGroupRuleList(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList value)
    {
      this.linkGroupRuleList = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> getLocationGraphRule()
    {
      return this.locationGraphRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule getLocationGraphRuleOrDefault()
    {
      return this.locationGraphRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule();
        this.locationGraphRule = Optional.of(instance);
        instance.parentNode(this);
        return this.locationGraphRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> streamLocationGraphRuleOrDefault()
    {
      return java.util.stream.Stream.of(getLocationGraphRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule> streamLocationGraphRule()
    {
      return locationGraphRule.stream();
    }
    public RuleGroup setLocationGraphRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule value)
    {
      this.locationGraphRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> getLocationClassificationRule()
    {
      return this.locationClassificationRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule getLocationClassificationRuleOrDefault()
    {
      return this.locationClassificationRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule();
        this.locationClassificationRule = Optional.of(instance);
        instance.parentNode(this);
        return this.locationClassificationRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> streamLocationClassificationRuleOrDefault()
    {
      return java.util.stream.Stream.of(getLocationClassificationRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule> streamLocationClassificationRule()
    {
      return locationClassificationRule.stream();
    }
    public RuleGroup setLocationClassificationRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule value)
    {
      this.locationClassificationRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule> getNodeRule()
    {
      return this.nodeRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule getNodeRuleOrDefault()
    {
      return this.nodeRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule();
        this.nodeRule = Optional.of(instance);
        instance.parentNode(this);
        return this.nodeRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule> streamNodeRuleOrDefault()
    {
      return java.util.stream.Stream.of(getNodeRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule> streamNodeRule()
    {
      return nodeRule.stream();
    }
    public RuleGroup setNodeRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule value)
    {
      this.nodeRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule> getPortalRule()
    {
      return this.portalRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule getPortalRuleOrDefault()
    {
      return this.portalRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule();
        this.portalRule = Optional.of(instance);
        instance.parentNode(this);
        return this.portalRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule> streamPortalRuleOrDefault()
    {
      return java.util.stream.Stream.of(getPortalRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule> streamPortalRule()
    {
      return portalRule.stream();
    }
    public RuleGroup setPortalRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule value)
    {
      this.portalRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule> getRegionRule()
    {
      return this.regionRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule getRegionRuleOrDefault()
    {
      return this.regionRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule();
        this.regionRule = Optional.of(instance);
        instance.parentNode(this);
        return this.regionRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule> streamRegionRuleOrDefault()
    {
      return java.util.stream.Stream.of(getRegionRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule> streamRegionRule()
    {
      return regionRule.stream();
    }
    public RuleGroup setRegionRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule value)
    {
      this.regionRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule> getZoneRule()
    {
      return this.zoneRule;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule getZoneRuleOrDefault()
    {
      return this.zoneRule.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule();
        this.zoneRule = Optional.of(instance);
        instance.parentNode(this);
        return this.zoneRule.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule> streamZoneRuleOrDefault()
    {
      return java.util.stream.Stream.of(getZoneRuleOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule> streamZoneRule()
    {
      return zoneRule.stream();
    }
    public RuleGroup setZoneRule(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule value)
    {
      this.zoneRule = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule.nodeName))
        {
          if(this.entityRule.isEmpty()) {
            this.entityRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule.nodeName.length() + 3);
          return this.entityRule.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule.nodeName))
        {
          if(this.containerRule.isEmpty()) {
            this.containerRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule.nodeName.length() + 3);
          return this.containerRule.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule.nodeName))
        {
          if(this.classificationRule.isEmpty()) {
            this.classificationRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule.nodeName.length() + 3);
          return this.classificationRule.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule.nodeName))
        {
          if(this.nameRule.isEmpty()) {
            this.nameRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule.nodeName.length() + 3);
          return this.nameRule.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList.nodeName))
        {
          if(this.linkGroupRuleList.isEmpty()) {
            this.linkGroupRuleList = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList.nodeName.length() + 3);
          return this.linkGroupRuleList.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule.nodeName))
        {
          if(this.locationGraphRule.isEmpty()) {
            this.locationGraphRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule.nodeName.length() + 3);
          return this.locationGraphRule.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule.nodeName))
        {
          if(this.locationClassificationRule.isEmpty()) {
            this.locationClassificationRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule.nodeName.length() + 3);
          return this.locationClassificationRule.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule.nodeName))
        {
          if(this.nodeRule.isEmpty()) {
            this.nodeRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule.nodeName.length() + 3);
          return this.nodeRule.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule.nodeName))
        {
          if(this.portalRule.isEmpty()) {
            this.portalRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule.nodeName.length() + 3);
          return this.portalRule.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule.nodeName))
        {
          if(this.regionRule.isEmpty()) {
            this.regionRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule.nodeName.length() + 3);
          return this.regionRule.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule.nodeName))
        {
          if(this.zoneRule.isEmpty()) {
            this.zoneRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule.nodeName.length() + 3);
          return this.zoneRule.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule.nodeName))
        {
          if(this.entityRule.isEmpty()) {
            this.entityRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule.nodeName.length() + 3);
          return this.entityRule.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule.nodeName))
        {
          if(this.containerRule.isEmpty()) {
            this.containerRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule.nodeName.length() + 3);
          return this.containerRule.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule.nodeName))
        {
          if(this.classificationRule.isEmpty()) {
            this.classificationRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule.nodeName.length() + 3);
          return this.classificationRule.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule.nodeName))
        {
          if(this.nameRule.isEmpty()) {
            this.nameRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule.nodeName.length() + 3);
          return this.nameRule.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList.nodeName))
        {
          if(this.linkGroupRuleList.isEmpty()) {
            this.linkGroupRuleList = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList.nodeName.length() + 3);
          return this.linkGroupRuleList.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule.nodeName))
        {
          if(this.locationGraphRule.isEmpty()) {
            this.locationGraphRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule.nodeName.length() + 3);
          return this.locationGraphRule.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule.nodeName))
        {
          if(this.locationClassificationRule.isEmpty()) {
            this.locationClassificationRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule.nodeName.length() + 3);
          return this.locationClassificationRule.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule.nodeName))
        {
          if(this.nodeRule.isEmpty()) {
            this.nodeRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NodeRule.NodeRule.nodeName.length() + 3);
          return this.nodeRule.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule.nodeName))
        {
          if(this.portalRule.isEmpty()) {
            this.portalRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule.nodeName.length() + 3);
          return this.portalRule.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule.nodeName))
        {
          if(this.regionRule.isEmpty()) {
            this.regionRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule.nodeName.length() + 3);
          return this.regionRule.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule.nodeName))
        {
          if(this.zoneRule.isEmpty()) {
            this.zoneRule = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule.nodeName.length() + 3);
          return this.zoneRule.get().getNodeAtPath(childXPath);
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
              "metaType": "unknown",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "entity_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "name": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "text_map": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "text": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
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
                      }
                    },
                    "isNullable": true
                  },
                  "containers": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "container": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "container_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
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
          "container_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "name": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                },
                "isSingle": false,
                "value": {
                  "allowed_entity": {
                    "metaType": "object",
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
                    },
                    "isSingle": false,
                    "value": {
                      "max": {
                        "metaType": "reference",
                        "value": "type__math_operations",
                        "isSingle": true,
                        "isNullable": true
                      },
                      "min": {
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
              }
            },
            "isNullable": true
          },
          "classification_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
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
                  "property": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "property_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "is": {
                          "metaType": "union",
                          "value": [
                            {
                              "metaType": "primitive",
                              "value": "\"lessThan\""
                            },
                            {
                              "metaType": "primitive",
                              "value": "\"lessThanOrEqual\""
                            },
                            {
                              "metaType": "primitive",
                              "value": "\"greaterThan\""
                            },
                            {
                              "metaType": "primitive",
                              "value": "\"greaterThanOrEqual\""
                            },
                            {
                              "metaType": "primitive",
                              "value": "\"equal\""
                            }
                          ]
                        }
                      }
                    },
                    "isSingle": false,
                    "value": {
                      "operation": {
                        "metaType": "reference",
                        "value": "type__math_operations",
                        "isSingle": true,
                        "isNullable": false
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
          "name_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
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
                        }
                      },
                      "isNullable": false
                    }
                  },
                  {
                    "metaType": "primitive",
                    "value": "type__name_token"
                  }
                ],
                "isSingle": false,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "link_group_rule_list": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "link_group_rule": {
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
                    "value": "type__link_group"
                  }
                ],
                "isSingle": false,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "location_graph_rule": {
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
            "isSingle": true,
            "value": {
              "setup": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "starting_node": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "node_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  },
                  "necessary_node": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "node_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "min": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        },
                        "max": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": true
                        }
                      }
                    },
                    "isSingle": false,
                    "value": {
                      "or": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "node_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        }
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": false
              },
              "node_rule": {
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
                  "name": {
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
                  },
                  "classifications": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "classification": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
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
                    "isNullable": true
                  },
                  "link_group_list": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "reference": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "link_group_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        }
                      },
                      "link_group": {
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
                            "value": "type__link_group"
                          }
                        ],
                        "isSingle": false,
                        "isNullable": true
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
          "location_classification_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": false,
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
                }
              }
            },
            "isNullable": true
          },
          "node_rule": {
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
            "isSingle": true,
            "value": {
              "area": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "height": {
                    "metaType": "reference",
                    "value": "type__math_operations",
                    "isSingle": true,
                    "isNullable": false
                  },
                  "width": {
                    "metaType": "reference",
                    "value": "type__math_operations",
                    "isSingle": true,
                    "isNullable": false
                  }
                },
                "isNullable": false
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
                        "side": {
                          "metaType": "primitive",
                          "value": "type__rectangle_side",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    },
                    "isSingle": false,
                    "value": {
                      "width": {
                        "metaType": "reference",
                        "value": "type__math_operations",
                        "isSingle": true,
                        "isNullable": false
                      },
                      "height": {
                        "metaType": "reference",
                        "value": "type__math_operations",
                        "isSingle": true,
                        "isNullable": false
                      },
                      "to": {
                        "metaType": "object",
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "node_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        },
                        "isSingle": true,
                        "value": {
                          "side": {
                            "metaType": "reference",
                            "value": "type__rectangle_side",
                            "isSingle": true,
                            "isNullable": false
                          },
                          "width": {
                            "metaType": "reference",
                            "value": "type__math_operations",
                            "isSingle": true,
                            "isNullable": false
                          },
                          "height": {
                            "metaType": "reference",
                            "value": "type__math_operations",
                            "isSingle": true,
                            "isNullable": false
                          }
                        },
                        "isNullable": false
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": false
              }
            },
            "isNullable": true
          },
          "portal_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
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
                        }
                      },
                      "isNullable": false
                    }
                  },
                  {
                    "metaType": "primitive",
                    "value": "type__portal_rule"
                  }
                ],
                "isSingle": false,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "region_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
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
                        }
                      },
                      "isNullable": false
                    }
                  },
                  {
                    "metaType": "primitive",
                    "value": "type__region_rule"
                  }
                ],
                "isSingle": false,
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "zone_rule": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
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
                "isSingle": true,
                "value": {
                  "starting_region": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": false,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "region_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
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
      "name": "rule_group"
    }
  */