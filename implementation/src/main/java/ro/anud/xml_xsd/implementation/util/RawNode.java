package ro.anud.xml_xsd.implementation.util;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InvalidClassException;
import java.util.*;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class RawNode {
    static Logger logger = LoggerFactory.getLogger(RawNode.class);
    private LinkedHashMap<String, String> attributeMap = new LinkedHashMap<>();
    private LinkedHashMap<String, List<RawNode>> childrenMap = new LinkedHashMap<>();

    private static String getNodePath(Node node) {
        if (node == null) {
            return "";
        }
        if (node.getParentNode() == null) {
            return node.getNodeName();
        }
        return getNodePath(node.getParentNode()) + "/" + node.getNodeName();
    }

    public static RawNode fromNode(Node node) {
        logEnter(getNodePath(node));
        var attributeMap = new LinkedHashMap<String, String>();

        if (node.hasAttributes()) {
            var attributeNodeList = node.getAttributes();
            for (var index = 0; index < attributeNodeList.getLength(); index++) {
                var item = attributeNodeList.item(index);
                attributeMap.put(item.getNodeName(), item.getNodeValue());
            }
        }
        var childrenMap = new LinkedHashMap<String, List<RawNode>>();
        if (node.hasChildNodes()) {
            var childrenNodeList = node.getChildNodes();
            for (var index = 0; index < childrenNodeList.getLength(); index++) {
                var item = childrenNodeList.item(index);
                var list = childrenMap.getOrDefault(item.getNodeName(), new ArrayList<>());
                childrenMap.put(item.getNodeName(), list);
                list.addLast(RawNode.fromNode(item));
            }

        }

        return logReturn(
            RawNode.builder()
                .childrenMap(childrenMap)
                .attributeMap(attributeMap)
                .build(),
            getNodePath(node));
    }

    public Optional<Integer> getAttributeInt(String key) {
        logEnter("key:", key);
        var value = this.attributeMap.get(key);
        return logReturn(Optional.of(Integer.parseInt(value)));
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

    public String getAttributeRequired(String key) {
        logEnter("key:", key);
        return getAttribute(key).get();
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
        return logReturn(this.childrenMap.get(key));
    }

    public void setChildren(String key, Optional<RawNode> value) {
        value.ifPresent(rawNode -> {
            var childrenList = new ArrayList<RawNode>();
            childrenList.add(rawNode);
            this.childrenMap.put(key, childrenList);
        });
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
            }
            case null -> throw new NullPointerException();
            default -> throw new RuntimeException(new InvalidClassException(value.getClass().getName()));
        }

        logReturnVoid();
        return this;
    }

    public Document toDocument(String rootElementName) throws ParserConfigurationException {
        logEnter(rootElementName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
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

}
