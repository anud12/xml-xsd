package ro.anud.xml_xsd.implementation.service.location_graph;

import ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection;
import ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.location_graph.repository.LocationGraphRepository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.location_graph.repository.NodeRepository;
import ro.anud.xml_xsd.implementation.service.location_graph.util.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class LocationGraphInstance {
    final WorldStepInstance worldStepInstance;
    public final LocationGraphRepository locationGraphRepository;
    public final NodeRepository nodeRepository;

    public LocationGraphInstance(final WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        locationGraphRepository = new LocationGraphRepository(worldStepInstance)
            .index(worldStepInstance);
        nodeRepository = new NodeRepository(worldStepInstance)
            .index(worldStepInstance);
    }

    public Stream<Node> selectNodeGraph(final Type_nodeGraph_selection nodeGraphSelection) {
        return SelectNodeGraph.streamSelectNodeGraph(worldStepInstance, nodeGraphSelection);
    }

    public Optional<Mutation<LocationGraph>> createLocationGraph(final String locationGraphRuleRef) {
        return CreateLocationGraph.createLocationGraph(worldStepInstance, locationGraphRuleRef);
    }

    public Optional<CreateGraphNode.Result> createGraphNode(final LocationGraph locationGraph, final String startNodeRef) {
        return CreateGraphNode.createGraphNode(worldStepInstance, locationGraph, startNodeRef);
    }

    public Optional<CreateGraphNode.Result> createGraphNode(
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
        var logger = logEnter();
        var locationGraphElementResult = this.worldStepInstance.locationGraph.locationGraphRepository.getLocationGraphById(
            locationGraphId);
        if (locationGraphElementResult.isEmpty()) {
            logger.log("locationGraph not found");
            return logger.logReturn(Optional.empty());
        }
        var locationGraphElement = locationGraphElementResult.get();
        return CreateAdjacent.createAdjacent(worldStepInstance, locationGraphElement, nodeRuleId);
    }

    public void removePerson(final String personIdRef) {
        var logger = logEnter("personIdRef:", personIdRef);
        worldStepInstance.getWorldStep()
            .streamData()
            .flatMap(Data::streamLocation)
            .flatMap(Location::streamLocationGraph)
            .flatMap(LocationGraph::streamNode)
            .forEach(node -> {
                node.streamPeople()
                    .flatMap(People::streamPerson)
                    .filter(person -> person.getPersonIdRef().equals(personIdRef))
                    .toList()
                    .forEach(person -> {
                        logger.log("removing person", person.buildPath());
                        person.removeFromParent();
                    });
                node.streamLinks()
                    .flatMap(Links::streamLinkTo)
                    .flatMap(LinkTo::streamPeople)
                    .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People::streamPerson)
                    .filter(person -> person.getPersonIdRef().equals(personIdRef))
                    .toList()
                    .forEach(person -> {
                        logger.log("removing person", person.buildPath());
                        person.removeFromParent();
                    });
            });
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

    public Stream<LinkTo> selectLinkTo(final Type_linkTo_selection selection) {
        return SelectLinkTo.selectLinkTo(worldStepInstance, selection);
    }

    public record FindPersonResult(LocationGraph locationGraph, Optional<Node> node, Optional<LinkTo> linkTo) {}

    public List<FindPersonResult> findPersonLocation(String personId) {
        var logger = logEnter("personId:", personId);
        var locationGraphStream = worldStepInstance.getWorldStep()
            .streamData()
            .flatMap(Data::streamLocation)
            .flatMap(Location::streamLocationGraph);


        var result = locationGraphStream
            .flatMap(locationGraph -> {
                var nodeElement = locationGraph.streamNode()
                    .filter(node -> node.streamPeople()
                        .flatMap(People::streamPerson)
                        .anyMatch(innerPerson -> innerPerson.getPersonIdRef().equals(personId)))
                    .findAny();
                if (nodeElement.isPresent()) {
                    return Stream.of(new FindPersonResult(locationGraph, nodeElement, Optional.empty()));
                }
                var linkToPerson = locationGraph.streamNode()
                    .flatMap(Node::streamLinks)
                    .flatMap(Links::streamLinkTo)
                    .filter(linkTo -> linkTo.streamPeople()
                        .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People::streamPerson)
                        .anyMatch(innerPerson -> innerPerson.getPersonIdRef().equals(personId))
                    )
                    .findAny();
                if (linkToPerson.isPresent()) {
                    return Stream.of(new FindPersonResult(locationGraph, Optional.empty(), linkToPerson));
                }
                return Stream.empty();
            }).toList();

        return logger.logReturn(result);
    }
}
