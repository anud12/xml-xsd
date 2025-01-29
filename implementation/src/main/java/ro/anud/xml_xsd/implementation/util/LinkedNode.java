package ro.anud.xml_xsd.implementation.util;

import java.util.Optional;
import java.util.Set;

public interface LinkedNode {


    String classTypeId();

    Optional<LinkedNode> parentNode();
    RawNode serializeIntoRawNode();
    void removeChild(Object object);

    default String nodeName() {
        return "";
    }

    RawNode rawNode();

    void childChanged(Set<Object> clazzSet);

    int buildIndexForChild(Object object);

    default String buildPath() {
        var index = parentNode().map(linkedNode -> linkedNode.buildIndexForChild(this)).orElse(0);

        return parentNode().flatMap(LinkedNode::parentNode)
            .map(LinkedNode::buildPath)
            .map(string -> string + "/" + nodeName() + "[" + index + "]")
            .orElse("/");
    }
}
