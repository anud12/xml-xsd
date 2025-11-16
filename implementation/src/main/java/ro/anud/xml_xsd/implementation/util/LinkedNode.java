package ro.anud.xml_xsd.implementation.util;

import java.util.ArrayList;
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

    void notifyChange(LinkedNode linkedNode);
    default void notifyChange() {
        notifyChange(this);
    }
    void notifyRemove(LinkedNode linkedNode);
    default void notifyRemove() {
        notifyRemove(this);
    }

    default void clearParentNode() {
        notifyRemove();
        var parentNode = parentNode();
        parentNode = Optional.empty();
        parentNode.ifPresent(LinkedNode::notifyChange);
    }

    int buildIndexForChild(Object object);

    LinkedNode deserializeAtPath(String xpath, RawNode rawNode);

    default String buildPath() {
        var index = parentNode().map(linkedNode -> linkedNode.buildIndexForChild(this)).orElse(0);
        var path = "." + nodeName() + "[" + index + "]";

        return parentNode()
            .map(LinkedNode::buildPath)
            .map(string -> string + path)
            .orElse(path);
    }
}
