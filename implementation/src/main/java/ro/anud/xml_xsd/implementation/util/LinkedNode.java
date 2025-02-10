package ro.anud.xml_xsd.implementation.util;

import java.util.List;
import java.util.Optional;

public interface LinkedNode {


    String classTypeId();

    Optional<LinkedNode> parentNode();
    RawNode serializeIntoRawNode();
    void removeChild(Object object);

    default String nodeName() {
        return "";
    }

    RawNode rawNode();

    void childChanged(List<Object> clazzSet);

    int buildIndexForChild(Object object);

    default String buildPath() {
        var index = parentNode().map(linkedNode -> linkedNode.buildIndexForChild(this)).orElse(0);
        var path = "/" + nodeName() + "[" + index + "]";

        return parentNode()
            .map(LinkedNode::buildPath)
            .map(string -> string + path)
            .orElse(path);
    }
}
