package ro.anud.xml_xsd.implementation.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.InvalidClassException;
import java.io.StringWriter;
import java.util.*;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class RawNode {
    static Logger logger = LoggerFactory.getLogger(RawNode.class);
    private String tag;
    @Builder.Default
    private LinkedHashMap<String, String> attributeMap = new LinkedHashMap<>();
    @Builder.Default
    private Optional<RawNode> parentNode = Optional.empty();
    @Builder.Default
    private List<RawNode> childrenList = new ArrayList<>();
    @Builder.Default
    private LinkedHashMap<String, List<RawNode>> childrenMap = new LinkedHashMap<>();

    public static String getNodePath(Node node) {
        if (node == null) {
            return "";
        }
        if (node.getParentNode() == null) {
            return node.getNodeName();
        }
        var parentNode = node.getParentNode();
        return getNodePath(parentNode) + "/" + node.getNodeName();
    }

    public static RawNode fromNode(Node node, Optional<RawNode> parentNode) {

        var rawNode = RawNode.builder()
            .tag(node.getNodeName())
            .parentNode(parentNode)
            .build();
        var logger = logEnter();


        if (node.hasAttributes()) {
            var attributeNodeList = node.getAttributes();
            for (var index = 0; index < attributeNodeList.getLength(); index++) {
                var item = attributeNodeList.item(index);
                var attributeKey = item.getNodeName();
                var value = item.getNodeValue();
                rawNode.setAttribute(attributeKey, value);
            }
        }

        if (node.hasChildNodes()) {
            var childrenNodeList = node.getChildNodes();
            for (var index = 0; index < childrenNodeList.getLength(); index++) {
                var item = childrenNodeList.item(index);
                var childRawNode = RawNode.fromNode(item, Optional.of(rawNode));
                rawNode.addChildren(item.getNodeName(), childRawNode);
                logger.log("adding child", childRawNode.getPath());
            }
        }


        return logReturn(
            rawNode
        );
    }

    public static RawNode fromNode(Node node) {
        return fromNode(node, Optional.empty());
    }

    public Optional<Integer> getAttributeInt(String key) {
        logEnter("key:", key);
        var value = this.attributeMap.get(key);
        if (Strings.isBlank(value)) {
            return logReturn(Optional.empty());
        }
        return logReturn(Optional.of(Integer.parseInt(value.trim())));
    }

    public Optional<Double> getAttributeDouble(String key) {
        logEnter("key:", key);
        var value = this.attributeMap.get(key);
        if (Strings.isBlank(value)) {
            return logReturn(Optional.empty());
        }
        return logReturn(Optional.of(Double.parseDouble(value.trim())));
    }

    public Optional<String> getAttribute(String key) {
        logEnter("key:", key);
        return Optional.ofNullable(this.attributeMap.get(key));
    }

    public RawNode setAttribute(String key, Object value) {
        logEnter("key:", key, "value:", value);
        setAttribute(key, Optional.of(value));
        return this;
    }

    public RawNode setAttribute(String key, Optional<Object> value) {
        logEnter("key:", key, "value:", value);
        value.ifPresent(o -> attributeMap.put(key, o.toString()));
        return this;
    }

    public int getAttributeIntRequired(String key) {
        logEnter("key:", key);
        return logReturn(getAttributeInt(key).get());
    }


    public double getAttributeDoubleRequired(String key) {
        logEnter("key:", key);
        return logReturn(getAttributeDouble(key).get());
    }

    public String getAttributeRequired(String key) {
        logEnter("key:", key);
        return getAttribute(key).get();
    }

    public Optional<RawNode> getParentNode() {
        return parentNode;
    }

    public RawNode setParentNode(final RawNode parentNode) {
        this.parentNode = Optional.ofNullable(parentNode);
        return this;
    }

    public Optional<RawNode> getChildrenFirst(String key) {
        logEnter("key:", key);
        if (this.childrenMap.containsKey(key)) {
            return logReturn(this.childrenMap.get(key).stream().findFirst());
        }
        return logReturn(Optional.empty(), "No value found");
    }


    public List<RawNode> getChildrenList(String key) {
        logEnter("key:", key);
        var value = this.childrenMap.get(key);
        if (value == null) {
            return new ArrayList<>();
        }
        return logReturn(this.childrenMap.get(key));
    }

    public boolean hasChildren() {
        return !this.childrenMap.entrySet().stream()
            .filter(stringListEntry -> !stringListEntry.getKey().equals("#text"))
            .map(Map.Entry::getValue)
            .allMatch(List::isEmpty);
    }

    public void setChildren(String key, Optional<RawNode> value) {
        value.ifPresent(rawNode -> {
            var childrenList = new ArrayList<RawNode>();
            childrenList.add(rawNode);
            this.childrenMap.put(key, childrenList);
        });
    }

    public List<RawNode> getAllChildren() {
        return this.childrenList;
    }

    public void setChildren(String key, List<RawNode> value) {
        var childrenList = new ArrayList<>(value);
        this.childrenMap.put(key, childrenList);
    }

    public RawNode addChildren(String key, Object value) {
        logEnter("key:", key, "value:", value);
        switch (value) {
            case Optional<?> optionalValue -> {
                optionalValue.ifPresent(o -> addChildren(key, o));
            }
            case List<?> listValue -> listValue.forEach(o -> addChildren(key, o));
            case RawNode rawNode -> {
                var childrenList = this.childrenMap.getOrDefault(key, new ArrayList<>());
                childrenList.add(rawNode);
                this.childrenMap.put(key, childrenList);
                this.childrenList.add(rawNode);
            }
            case null -> throw new NullPointerException();
            default -> throw new RuntimeException(new InvalidClassException(value.getClass().getName()));
        }

        logReturnVoid();
        return this;
    }

    public String toDocumentString() {
        try {
            var outputDocument = toDocument(tag);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(outputDocument), new StreamResult(writer));
            return writer.getBuffer().toString()
                .replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>","");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Document toDocument(String rootElementName) {
        logEnter(rootElementName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document document = builder.newDocument();
        Element element = document.createElement(rootElementName);
        this.populateNode(document, element);
        document.appendChild(element);

        return logReturn(document);
    }

    public void populateNode(Document document, Element element) {
        logEnter(getNodePath(element));
        this.attributeMap.forEach(element::setAttribute);
        this.childrenMap.forEach((childName, rawNodes) -> {
            rawNodes.forEach(rawNode -> {
                if ("#text".equals(childName)) {
                    log("Ignoring #text child");
                    return;
                }
                log("Creating element with", childName);
                var childElement = document.createElement(childName);
                rawNode.populateNode(document, childElement);
                element.appendChild(childElement);
            });
        });
        logReturnVoid(getNodePath(element));
    }

    public int getChildIndex(RawNode object) {
        return childrenMap.values().stream()
            .map(rawNodes -> rawNodes.indexOf(object))
            .filter(integer -> integer != -1)
            .findFirst()
            .orElse(0);
    }

    public String getPath() {
        var parentPath = parentNode.map(RawNode::getPath).orElse("/");
        var index = parentNode.map(rawNode -> rawNode.getChildIndex(this)).orElse(0);
        return parentPath + "/" + getTag() + "[" + index + "]";
    }

    public RawNode setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getTag() {
        return this.tag;
    }

}
