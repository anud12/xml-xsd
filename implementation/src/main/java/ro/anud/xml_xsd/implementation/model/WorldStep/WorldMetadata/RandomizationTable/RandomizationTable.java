package ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable;
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
import static ro.anud.xml_xsd.implementation.util.LocalLogger.log;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class RandomizationTable implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static RandomizationTable fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new RandomizationTable();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static RandomizationTable fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<RandomizationTable> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> RandomizationTable.fromRawNode(o, parent)));
    }
    public static List<RandomizationTable> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<RandomizationTable> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> RandomizationTable.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry> entry = new ArrayList<>();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    @Builder.Default
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    @Builder.Default
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "randomization_table";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry) {
          throw new RuntimeException("trying to delete entry which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry) {
          return this.entry.indexOf(object);
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Set<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing randomization_table");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.entry = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry.fromRawNode(rawNode.getChildrenList("entry"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("entry");
      rawNode.setChildren("entry", entry.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing randomization_table");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry> getEntry()
    {
      return this.entry;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry> streamEntry()
    {
      return entry.stream();
    }
    public RandomizationTable addEntry(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry value)
    {
      this.entry.add(value);
      value.setParentNode(this);
      triggerOnChange();
      return this;
    }
    public RandomizationTable addAllEntry(List<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry> value)
    {
      this.entry.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      triggerOnChange();
      return this;
    }
    public RandomizationTable removeEntry(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry value)
    {
      this.entry.remove(value);
      triggerOnChange();
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
          "entry": {
            "metaType": "object",
            "value": {},
            "isSingle": false,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "value": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          }
        },
        "isNullable": false
      },
      "name": "randomization_table"
    }
  */