package ro.anud.xml_xsd.implementation.util;

import java.util.Optional;
import java.util.Set;

public interface LinkedNode {
    Optional<LinkedNode> getParentNode();

    void removeChild(Object object);

    default String nodeName() {
        return "";
    }

    public void childChanged(Set<Object> clazzSet);

    public default String getNodeId() {
        return getParentNode().flatMap(LinkedNode::getParentNode)
            .map(LinkedNode::getNodeId)
            .map(string ->  string + "/" +nodeName())
            .orElse("/");
    }
}
