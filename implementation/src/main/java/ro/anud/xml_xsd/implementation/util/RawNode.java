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
import java.util.*;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class RawNode {
    static Logger logger = LoggerFactory.getLogger(RawNode.class);
    private LinkedHashMap<String, String> attributeMap;
    private LinkedHashMap<String, List<RawNode>> childrenMap;

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
        var value = this.attributeMap.get(key);
        return Optional.of(Integer.parseInt(value));
    }

    public Optional<String> getAttribute(String key) {
        return Optional.ofNullable(this.attributeMap.get(key));
    }
    public int getAttributeIntRequired(String key) {
        return getAttributeInt(key).get();
    }

    public String getAttributeRequired(String key) {
        return getAttribute(key).get();
    }


    public Optional<RawNode> getChildrenFirst(String key) {
        return this.childrenMap.get(key).stream().findFirst();
    }

    public RawNode getChildrenFirstRequired(String key) {
        try {
            return this.childrenMap.get(key).stream().findFirst().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<RawNode> getChildrenList(String key) {
        return this.childrenMap.get(key);
    }

    public Document toDocument(String rootElementName) throws ParserConfigurationException {
        logEnter(this);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElement(rootElementName);
        this.populateNode(document, element);
        document.appendChild(element);

        return logReturn(document);
    }

    public void populateNode(Document document, Element element) {
        logEnter(this);
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
        logReturnVoid(this);
    }

}
