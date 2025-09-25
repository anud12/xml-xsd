package ro.anud.xml_xsd.implementation.service.location_graph.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.LinkedNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.log;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ShortestPathsInGraphExcludeStart {
    public static List<List<Node>> shortestPathInGraphExcludeStart(
        final LocationGraph locationGraph,
        final Node startNode,
        final Node destinationNode,
        final int numberOfPaths) {
        return shortestPathInGraph(locationGraph, startNode, destinationNode, numberOfPaths)
            .stream()
            .map(path -> path.subList(1, path.size()))
            .toList();
    }

    private static List<List<Node>> shortestPathInGraph(
        final LocationGraph locationGraph,
        final Node startNode,
        final Node destinationNode,
        final int numberOfPaths) {
        try (var scope = logScope(
                "startNode:",
                startNode.getId(),
                "destinationNode:",
                destinationNode.getId(),
                "numberOfPaths:",
                numberOfPaths)){
            var nodes = locationGraph.getNode();

            var startNodeExists = nodes.stream().filter(node -> node.equals(startNode))
                    .findFirst();
            if (startNodeExists.isEmpty()) {
                throw new RuntimeException("start node not found");
            }
            var destinationNodeExists = nodes.stream().filter(node -> node.equals(destinationNode))
                    .findFirst();
            if (destinationNodeExists.isEmpty()) {
                throw new RuntimeException("destination node not found");
            }

            var map = new HashMap<String, Node>();
            nodes.forEach(node -> map.put(node.getId(), node));
            List<List<Node>> paths = getPathsToDestinationOrdered(map, startNode, destinationNode, numberOfPaths);
            if (paths.isEmpty()) {
                throw new RuntimeException("no path found");
            }
            return paths.subList(0, Math.min(paths.size(), numberOfPaths));
        }

    }

    private static List<List<Node>> getPathsToDestinationOrdered(
        final HashMap<String, Node> map,
        final Node startNode,
        final Node destinationNode,
        final int numberOfPaths) {
        try (var scope = logScope(
                "startNode:",
                startNode.getId(),
                "destinationNode:",
                destinationNode.getId(),
                "numberOfPaths:",
                numberOfPaths)){
            if (numberOfPaths <= 0) {
                scope.log("numberOfPaths is 0");
                return List.of();
            }
            record PathResult(List<Node> path, int foundPaths, int totalCost) {}
            var queue = new ArrayList<PathResult>();
            queue.add(new PathResult(List.of(startNode), 0, 0));
            var resultList = new ArrayList<List<Node>>();
            scope.log(
                    "queue nodes",
                    queue.stream()
                            .flatMap(pathResult -> pathResult.path
                                    .stream()
                                    .map(Node::getId)
                            )
                            .toList()
            );
            while (queue.size() > 0 && resultList.size() < numberOfPaths) {
                var element = queue.removeFirst();
                var path = element.path;
                var foundPaths = element.foundPaths;
                var totalCost = element.totalCost;

                var currentNode = path.get(path.size() - 1);
                if (currentNode == null) {
                    scope.log("continue: currentNode is null");
                    continue;
                }
                if (currentNode.getId().equals(destinationNode.getId())) {
                    resultList.add(path);
                    scope.log("continue: found path", path.stream().map(Node::getId).toList());
                    continue;
                }
                record Entry(Node node, LinkTo linkTo) {}
                List<Entry> adjacentNodesAndLinks = currentNode.streamLinks()
                        .flatMap(Links::streamLinkTo)
                        .reduce(
                                new ArrayList<>(),
                                (acc, linkTo) -> {
                                    var entry = new Entry(
                                            map.get(linkTo.getNodeIdRef()),
                                            linkTo
                                    );
                                    return insertValueToSortedList(
                                            acc, entry,
                                            (entry1, entry2) -> entry1.linkTo.getTotalProgress() < entry2.linkTo.getTotalProgress()
                                    );
                                }, (acc1, acc2) -> {
                                    acc1.addAll(acc2);
                                    return acc1;
                                });
                adjacentNodesAndLinks.forEach(nodeAndLinks -> {
                    if (resultList.size() >= numberOfPaths) {
                        return;
                    }
                    var linkTotalCost = nodeAndLinks.linkTo.getTotalProgress();
                    var pathResult = new PathResult(
                            new ArrayList<>(path),
                            foundPaths + 1,
                            totalCost + linkTotalCost
                    );
                    scope.log(
                            "adding node:",
                            nodeAndLinks.node.getId(),
                            "totalCost:",
                            pathResult.totalCost,
                            "path:",
                            pathResult.path.stream().map(Node::getId).toList()
                    );
                    pathResult.path.add(nodeAndLinks.node);
                    insertValueInPlaceToSortedArray(
                            queue,
                            pathResult,
                            (first, second) -> first.totalCost < second.totalCost);
                });
            }
            scope.log("exit while");
            return resultList;
        }

    }

    private static <T> void insertValueInPlaceToSortedArray(
        final ArrayList<T> array,
        final T value,
        final BiFunction<T, T, Boolean> comparator) {
        array.add(value);
        array.sort((o1, o2) -> {
            if (comparator.apply(o1, o2)) {
                return -1;
            }
            return 1;
        });

    }

    private static <T> ArrayList<T> insertValueToSortedList(
        final ArrayList<T> array,
        final T value,
        final BiFunction<T, T, Boolean> comparator) {
        array.add(value);
        array.sort((o1, o2) -> {
            if (comparator.apply(o1, o2)) {
                return -1;
            }
            return 1;
        });
        return array;
    }
}
