package ro.anud.xml_xsd.implementation.util;

import java.util.Optional;
import java.util.Set;

public interface LinkedNode {
    Optional<LinkedNode> getParentNode();

    void removeChild(Object object);

    default String nodeName() {
        return "";
    }

    public RawNode getRawNode();

    public void childChanged(Set<Object> clazzSet);

    public int buildIndexForChild(Object object);

    public default String buildPath() {
        var index = getParentNode().map(linkedNode -> linkedNode.buildIndexForChild(this)).orElse(0);

        return getParentNode().flatMap(LinkedNode::getParentNode)
            .map(LinkedNode::buildPath)
            .map(string -> string + "/" + nodeName() + "[" + index + "]")
            .orElse("/");
    }
}
