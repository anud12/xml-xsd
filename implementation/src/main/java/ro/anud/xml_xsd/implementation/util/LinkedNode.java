package ro.anud.xml_xsd.implementation.util;

import java.util.Optional;
import java.util.Set;

public interface LinkedNode {
    Optional<LinkedNode> parentNode();

    void removeChild(Object object);

    default String nodeName() {
        return "";
    }

    public RawNode rawNode();

    public void childChanged(Set<Object> clazzSet);

    public int buildIndexForChild(Object object);

    public default String buildPath() {
        var index = parentNode().map(linkedNode -> linkedNode.buildIndexForChild(this)).orElse(0);

        return parentNode().flatMap(LinkedNode::parentNode)
            .map(LinkedNode::buildPath)
            .map(string -> string + "/" + nodeName() + "[" + index + "]")
            .orElse("/");
    }
}
