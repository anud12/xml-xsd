package ro.anud.xml_xsd.implementation.service.action;

import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.LinkedNode;

import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public non-sealed interface ActionCreate<Node, ActionNode extends LinkedNode, ParentNode> extends Action {
    interface Mutation {
        void apply(WorldStepInstance outWorldStepInstance);
    }
    Stream<ActionNode> getAction(Stream<WorldStep> worldStep);
    Node create(WorldStepInstance worldStepInstance, ActionNode actionNode);
    ParentNode getParentNode(Stream<WorldStep> worldStep, ActionNode actionNode);
    void append(ParentNode parentNode, Node node);

    default Node applyAction(WorldStepInstance worldStepInstance, ActionNode actionNode) {
        try (var scope = logScope()){
            Node node = create(worldStepInstance, actionNode);

            ParentNode parentNode = getParentNode(worldStepInstance.getOutInstance().streamWorldStep(), actionNode);
            append(parentNode,node);
            getAction(worldStepInstance.getOutInstance().streamWorldStep()).forEach(actionNode1 -> {
                actionNode1.parentNode().ifPresent(linkedNode -> linkedNode.removeChild(actionNode1));
            });
            return node;
        }
    }

    default void apply(WorldStepInstance worldStepInstance) {
        try(var scope = logScope()) {
            getAction(worldStepInstance.streamWorldStep())
                    .forEach(actionNode -> applyAction(worldStepInstance,actionNode));
        }
    }
}
