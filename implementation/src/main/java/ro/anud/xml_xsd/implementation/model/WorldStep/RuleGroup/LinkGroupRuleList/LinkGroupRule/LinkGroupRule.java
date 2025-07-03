package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class LinkGroupRule implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_linkGroup.IType_linkGroup<LinkGroupRule>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "link_group_rule";
    public static LinkGroupRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = new LinkGroupRule();
      if(Objects.nonNull(parent)) {
        instance.parentNode(parent);
      }
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LinkGroupRule fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = fromRawNode(rawNode, null);
      return logReturn(instance);
    }
    public static Optional<LinkGroupRule> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> LinkGroupRule.fromRawNode(o, parent)));
    }
    public static List<LinkGroupRule> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<LinkGroupRule> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> LinkGroupRule.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    public String classTypeId() {
      return ".world_step.rule_group.link_group_rule_list.link_group_rule";
    }

    //Attributes

    //Attributes of type__link_group

    private String id;

    private Integer angle;
    @Builder.Default
    private Optional<Integer> angleMax = Optional.empty();
    @Builder.Default
    private Optional<Integer> limit = Optional.empty();

    //Children elements

    //Children of type__link_group
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> toOption = new ArrayList<>();

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
    private List<Consumer<List<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "link_group_rule";
    }

    public void notifyChange(List<Object> list) {
      var logger = logEnter();
      list.addLast(this);
      logger.log("Notify change for", this.buildPath());
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList> parentAsLinkGroupRuleList() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
    }

    public int buildIndexForChild(Object object) {
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      try {
        var logger = logEnter();
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing link_group_rule");

        var innerLogger = logger.log("attributes");
        //Deserialize attributes

        // Deserialize arguments of type__link_group
        innerLogger.log("id");
        this.id = rawNode.getAttributeRequired("id");
        innerLogger.log("angle");
        this.angle = rawNode.getAttributeIntRequired("angle");
        innerLogger.log("angleMax");
        this.angleMax = rawNode.getAttributeInt("angleMax");
        innerLogger.log("limit");
        this.limit = rawNode.getAttributeInt("limit");
        innerLogger = logger.log("children");
        //Deserialize children

        // Deserialize children of type__link_group
        this.toOption = ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption.fromRawNode(rawNode.getChildrenList("to_option"), this);
        logReturnVoid();
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("link_group_rule");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      // Serialize arguments of type__link_group
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);
      innerLogger.log("angle");
      rawNode.setAttribute("angle", this.angle);
      innerLogger.log("angleMax");
      this.angleMax.ifPresent(o -> rawNode.setAttribute("angleMax", o));
      innerLogger.log("limit");
      this.limit.ifPresent(o -> rawNode.setAttribute("limit", o));

      innerLogger = logger.log("children");
      //Serialize children

      // Serialize children of type__link_group
      innerLogger.log("to_option");
      rawNode.setChildren("to_option", toOption.stream().map(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing link_group_rule");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public String getId()
    {
      return this.id;
    }
    public LinkGroupRule setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public Integer getAngle()
    {
      return this.angle;
    }
    public LinkGroupRule setAngle(Integer value)
    {
      this.angle = value;
      notifyChange();
      return this;
    }
    public Optional<Integer> getAngleMax()
    {
      return this.angleMax;
    }
    public LinkGroupRule setAngleMax(Optional<Integer> value)
    {
      this.angleMax = value;
      notifyChange();
      return this;
    }
    public Optional<Integer> getLimit()
    {
      return this.limit;
    }
    public LinkGroupRule setLimit(Optional<Integer> value)
    {
      this.limit = value;
      notifyChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> getToOption()
    {
      return this.toOption;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> streamToOption()
    {
      return toOption.stream();
    }
    public LinkGroupRule addToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value)
    {
      this.toOption.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public LinkGroupRule addAllToOption(List<ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption> value)
    {
      this.toOption.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public LinkGroupRule removeToOption(ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption value)
    {
      this.toOption.remove(value);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
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
          "value": {}
        },
        "value": {}
      },
      "name": "link_group_rule"
    }
  */