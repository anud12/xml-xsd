package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule;
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
  public class PortalRule implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "portal_rule";
    public static PortalRule fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new PortalRule();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static PortalRule fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<PortalRule> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> PortalRule.fromRawNode(o, parent)));
        }

    }
    public static List<PortalRule> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<PortalRule> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> PortalRule.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.rule_group.portal_rule";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry> entry = new ArrayList<>();

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
      return "portal_rule";
    }

    public void notifyChange(List<Object> list) {
      try (var logger = logScope()) {
        list.addLast(this);
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.accept(list));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public void clearParentNode() {
      var parentNode = this.parentNode;
      this.parentNode = Optional.empty();
      parentNode.ifPresent(ro.anud.xml_xsd.implementation.util.LinkedNode::notifyChange);
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup> parentAsRuleGroup() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry) {
          this.entry.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry) {
          return this.entry.indexOf(object);
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      try (var logger = logScope()) {
        onChangeList.add(onChange);
        return logger.logReturn(() -> onChangeList.remove(onChange));
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
          this.entry = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry.fromRawNode(rawNode.getChildrenList("entry"), this);
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
        rawNode.setTag("portal_rule");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("entry");
          rawNode.setChildren("entry", entry.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing portal_rule");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry> getEntry()
    {
      return this.entry;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry> streamEntry()
    {
      return entry.stream();
    }
    public PortalRule addEntry(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry value)
    {
      this.entry.add(value);
      value.parentNode(this);
      return this;
    }
    public PortalRule addAllEntry(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry> value)
    {
      this.entry.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public PortalRule removeEntry(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry value)
    {
      this.entry.remove(value);
      value.clearParentNode();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.entry.size() > pathIndex) {
              return this.entry.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addEntry(newEntry);
          return linkedNode;
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.entry.size() > pathIndex) {
            return this.entry.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
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
      "name": "portal_rule"
    }
  */