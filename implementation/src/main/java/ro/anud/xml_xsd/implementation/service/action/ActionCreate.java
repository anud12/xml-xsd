package ro.anud.xml_xsd.implementation.service.action;

import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Middleware;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.stream.Stream;

public non-sealed interface ActionCreate<Node, ActionNode, ParentNode> extends Action, Middleware {
    interface Mutation {
        void apply(WorldStepInstance outWorldStepInstance);
    }
    Stream<ActionNode> getAction(Stream<WorldStep> worldStep);
    Node create(ActionNode action);
    ParentNode getParentNode(Stream<WorldStep> worldStep);
    void append(ParentNode parentNode, Node node);

    default void apply(WorldStepInstance worldStepInstance) {
        var actionStream = getAction(worldStepInstance.streamWorldStep());
        var node = actionStream.map(this::create);

        var parentNode = getParentNode(worldStepInstance.getOutInstance().streamWorldStep());
        node.forEach(node1 -> append(parentNode,node1));
    }
}
