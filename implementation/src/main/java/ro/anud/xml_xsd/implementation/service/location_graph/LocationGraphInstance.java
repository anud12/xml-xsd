package ro.anud.xml_xsd.implementation.service.location_graph;

import ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.location_graph.repository.LinkToRepository;
import ro.anud.xml_xsd.implementation.service.location_graph.repository.LocationGraphRepository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.location_graph.repository.NodeRepository;
import ro.anud.xml_xsd.implementation.service.location_graph.util.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class LocationGraphInstance {
    final WorldStepInstance worldStepInstance;
    public final LocationGraphRepository locationGraphRepository;
    public final NodeRepository nodeRepository;
    public final LinkToRepository linkToRepository;

    public LocationGraphInstance(final WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        locationGraphRepository = new LocationGraphRepository(worldStepInstance);
        nodeRepository = new NodeRepository(worldStepInstance);
        linkToRepository = new LinkToRepository(worldStepInstance);
    }


    public LocationGraphInstance index() {
        locationGraphRepository.index();
        nodeRepository.index();
        linkToRepository.index();
        return this;
    }

    public Stream<Node> selectNodeGraph(final Type_nodeGraph_selection nodeGraphSelection) {
        return SelectNodeGraph.streamSelectNodeGraph(worldStepInstance, nodeGraphSelection);
    }

    public Optional<Mutation<LocationGraph>> createLocationGraph(final String locationGraphRuleRef) {
        return CreateLocationGraph.createLocationGraph(worldStepInstance, locationGraphRuleRef);
    }

    public Optional<Node> createGraphNode(final LocationGraph locationGraph, final String startNodeRef) {
        return CreateGraphNode.createGraphNode(worldStepInstance, locationGraph, startNodeRef);
    }

    public Optional<Node> createGraphNode(
        WorldStepInstance worldStepInstance,
        LocationGraph locationGraph,
        String startNodeRef,
        final CreateAdjacent.XYPosition position,
        final Stream<String> classificationLocationList) {
        return CreateGraphNode.createGraphNode(
            worldStepInstance,
            locationGraph,
            startNodeRef,
            position,
            classificationLocationList
        );
    }

    public Optional<Mutation<Node>> createAdjacent(final LocationGraph locationGraph, final String nodeRuleRefId) {
        return CreateAdjacent.createAdjacent(worldStepInstance, locationGraph, nodeRuleRefId);
    }

    public Optional<Mutation<Node>> createAdjacent(final String locationGraphId, final String nodeRuleId) {
        try (var scope = logScope()){
            var locationGraphElementResult = this.worldStepInstance.locationGraph.locationGraphRepository.getLocationGraphById(
                    locationGraphId);
            if (locationGraphElementResult.isEmpty()) {
                scope.log("locationGraph not found");
                return scope.logReturn(Optional.empty());
            }
            var locationGraphElement = locationGraphElementResult.get();
            return CreateAdjacent.createAdjacent(worldStepInstance, locationGraphElement, nodeRuleId);
        }
    }


    public List<List<Node>> shortestPathsInGraphExcludeStart(
        final LocationGraph locationGraph,
        final Node startNode,
        final Node destinationNode,
        final int numberOfPaths) {
        return ShortestPathsInGraphExcludeStart.shortestPathInGraphExcludeStart(
            locationGraph,
            startNode,
            destinationNode,
            numberOfPaths);
    }
}
