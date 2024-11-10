package ro.anud.xml_xsd.implementation.service.location_graph.util;

import ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId;
import ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class SelectNodeGraph {
    public static Stream<Node> streamSelectNodeGraph(
        WorldStepInstance worldStepInstance,
        Type_nodeGraph_selection typeNodeGraphSelection) {
        var logger = logEnter();
        return logger.logReturn(worldStepInstance.getWorldStep()
            .streamData()
            .flatMap(Data::streamLocation)
            .flatMap(Location::streamLocationGraph)
            .filter(locationGraph -> filterLocationGraph(typeNodeGraphSelection, locationGraph))
            .flatMap(LocationGraph::streamNode)
            .filter(node -> filterNodeGraph(typeNodeGraphSelection, node))
        );
    }

    private static boolean filterLocationGraph(
        Type_nodeGraph_selection nodeGraphSelection,
        LocationGraph locationGraph
    ) {
        var logger = logEnter("locationGraphId", locationGraph.getId());
        var inLocationGraphList = nodeGraphSelection.streamIn_locationGraph().toList();
        if (inLocationGraphList.isEmpty()) {
            return true;
        }
        var applicableGraphList = inLocationGraphList.stream()
            .filter(inLocationGraph -> inLocationGraph
                .getHas_locationGraphId()
                .map(hasLocationGraphId -> hasLocationGraphId.getLocationGraphIdRef().equals(locationGraph.getId()))
                .orElse(false)
            );
        return logger.logReturn(applicableGraphList.findAny().isPresent());
    }

    private static boolean filterNodeGraph(Type_nodeGraph_selection nodeGraphSelection, Node node) {
        var logger = logEnter("NodeId", node.getId());
        var hasNodeGraphIdList = nodeGraphSelection.streamHas_nodeGraphId().toList();
        if (hasNodeGraphIdList.isEmpty()) {
            return true;
        }
        return logger.logReturn(hasNodeGraphIdList.stream()
            .map(Has_nodeGraphId::getNodeGraphIdRef)
            .anyMatch(string -> string.equals(node.getId()))
        );
    }
}
