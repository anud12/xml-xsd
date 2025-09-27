package ro.anud.xml_xsd.implementation.middleware.person;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Path.Path;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_moveTo.Person_moveTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class PersonMoveTo {
    public static void apply(WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            worldStepInstance.getOutInstance().streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamPerson_moveTo)
                    .toList()
                    .forEach(Person_moveTo::removeFromParent);


            worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamPerson_moveTo)
                    .toList()
                    .forEach(personMoveTo -> {
                        var findPathResult = applyFindPath(worldStepInstance, personMoveTo);
                        if (findPathResult.isEmpty()) {
                            applyPath(worldStepInstance, personMoveTo)
                                    .ifPresent(worldStepInstanceConsumer -> worldStepInstanceConsumer.apply(worldStepInstance.getOutInstance()));
                        }
                        findPathResult.ifPresent(worldStepInstanceConsumer -> worldStepInstanceConsumer.apply(worldStepInstance.getOutInstance()));
                    });

            worldStepInstance.getOutInstance()
                    .streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamPerson_moveTo)
                    .toList()
                    .forEach(personMoveTo -> {
                        personMoveTo.getPath().ifPresent(path -> {
                            if (path.getNode().isEmpty()) {
                                personMoveTo.removeFromParent();
                            }
                        });
                        personMoveTo.getFindPathTowards()
                                .ifPresent(ignored -> personMoveTo.removeFromParent());
                    });
        }


    }

    private static Optional<Mutation<WorldStepInstance>> applyPath(
        final WorldStepInstance worldStepInstance,
        final Person_moveTo personMoveTo) {
        try (var logger = logScope()) {
            var pathElementOptional = personMoveTo.getPath();
            if (pathElementOptional.isEmpty()) {
                logger.log("empty pathElement");
                return logger.logReturn(Optional.empty());
            }

            var pathElement = pathElementOptional.get();
            var destinationNode = pathElement.getNode();
            if (destinationNode.isEmpty()) {
                logger.log("empty destinationNode");
                return logger.logReturn(Optional.empty());
            }

            var personIdRef = personMoveTo.getPersonIdRef();

            var hasExecuted = applyPathRecursiveFromLink(worldStepInstance, pathElement, destinationNode, personIdRef);
            if (hasExecuted.isPresent()) {
                logger.log("hasExecuted");
                return logger.logReturn(Optional.of(Mutation.of(outInstance -> {
                    hasExecuted.get().apply(outInstance);
                    return outInstance;
                })));
            }

            var originNodeOptional = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamData)
                    .flatMap(Data::streamLocation)
                    .flatMap(Location::streamLocationGraph)
                    .flatMap(LocationGraph::streamNode)
                    .filter(node -> node.streamPeople()
                            .flatMap(People::streamPerson)
                            .anyMatch(person -> person.getPersonIdRef().equals(personIdRef))
                    ).findFirst();
            if (originNodeOptional.isEmpty()) {
                logger.log("empty originNodeOptional");
                return logger.logReturn(Optional.empty());
            }
            var originNode = originNodeOptional.get();
            logger.log("originNode", originNode);

            var filteredDestinationNode = destinationNode.stream()
                    .filter(node -> !node.getNodeIdRef().equals(originNode.getId()))
                    .toList();

            var result = applyPathRecursive(
                    worldStepInstance,
                    pathElement,
                    originNode.getId(),
                    filteredDestinationNode,
                    personIdRef,
                    1);

            return Optional.of(Mutation.of(outInstance -> {
                result.ifPresent(consumer -> consumer.apply(outInstance));
                var moveTo = getPersonMoveTo(outInstance, personIdRef);

                moveTo.getPathOrDefault().getNode()
                        .stream()
                        .filter(node -> node.getNodeIdRef().equals(originNode.getId()))
                        .toList()
                        .forEach(node -> {
                            logger.log("removing node", node);
                            pathElement.removeNode(node);
                        });
                return outInstance;
            }));
        }
    }

    private static Person_moveTo getPersonMoveTo(final WorldStepInstance outInstance, final String personIdRef) {
        var moveToOptional = outInstance.streamWorldStep()
            .flatMap(WorldStep::streamActions)
            .flatMap(Actions::streamPerson_moveTo)
            .filter(personMoveToElement -> personMoveToElement.getPersonIdRef().equals(personIdRef))
            .findFirst();
        return moveToOptional.orElseGet(() -> {
            var personMoveToElement = new Person_moveTo()
                .setPersonIdRef(personIdRef);

            outInstance.getWorldStep()
                .ifPresent(worldStep -> worldStep
                    .getActionsOrDefault()
                    .addPerson_moveTo(personMoveToElement)
                );
            return personMoveToElement;
        });
    }

    private static Optional<Mutation<WorldStepInstance>> applyPathRecursive(
        final WorldStepInstance worldStepInstance,
        final Path pathElement,
        final String currentNodeId,
        final List<Node> filteredDestinationNode,
        final String personIdRef,
        final float remainingProgressFraction) {
        try (var logger = logScope(
                "currentNodeId",
                currentNodeId,
                "personIdRef",
                personIdRef,
                "remainingProgressFraction",
                remainingProgressFraction
        )){
            if (filteredDestinationNode.isEmpty()) {
                logger.log("empty filteredDestinationNode");
                return logger.logReturn(Optional.empty());
            }
            var destinationNode = filteredDestinationNode.getFirst();
            if (Objects.isNull(destinationNode)) {
                logger.log("empty destinationNode");
                return logger.logReturn(Optional.empty());
            }

            var originNode = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamData)
                    .flatMap(Data::streamLocation)
                    .flatMap(Location::streamLocationGraph)
                    .flatMap(LocationGraph::streamNode)
                    .filter(node -> node.getId().equals(currentNodeId))
                    .findFirst();

            if (originNode.isEmpty()) {
                logger.log("empty originNode");
                return logger.logReturn(Optional.empty());
            }

            var linkElement = originNode.stream()
                    .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node::streamLinks)
                    .flatMap(Links::streamLinkTo)
                    .filter(linkTo -> linkTo.getNodeIdRef().equals(destinationNode.getNodeIdRef()))
                    .findFirst();
            if (linkElement.isEmpty()) {
                logger.log("empty linkElement");

                return logger.logReturn(Optional.of(Mutation.of(outWorldStepInstance -> {
                    outWorldStepInstance.locationGraph.removePerson(personIdRef);
                    logger.log("adding person [" + personIdRef + "] to destination node [" + destinationNode.getNodeIdRef() + "]");
                    outWorldStepInstance.locationGraph.nodeRepository.getNodeOrDefault(originNode.get())
                            .getPeopleOrDefault().addPerson(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person()
                                    .setPersonIdRef(personIdRef)
                            );
                    return outWorldStepInstance;
                })));
            }
            var progressProperty = linkElement.get().getPersonProgressProperty();
            if (progressProperty.isEmpty()) {
                logger.log("empty progressProperty");
                return logger.logReturn(Optional.empty());
            }
            var progressValue = worldStepInstance.computeOperation(progressProperty.get()).orElse(0) * remainingProgressFraction;
            var totalProgress = linkElement.get().getTotalProgress();
            if (progressValue == 0) {
                logger.log("reach destination");
                worldStepInstance.locationGraph.removePerson(personIdRef);
                worldStepInstance.streamWorldStep()
                        .flatMap(WorldStep::streamData)
                        .flatMap(Data::streamLocation)
                        .flatMap(Location::streamLocationGraph)
                        .flatMap(LocationGraph::streamNode)
                        .filter(node -> node.getId().equals(destinationNode.getNodeIdRef()))
                        .findFirst()
                        .ifPresent(node -> {
                            logger.log("progressValue == 0", node);
                            node.getPeopleOrDefault().addPerson(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person()
                                    .setPersonIdRef(personIdRef)
                            );
                        });
            }

            if (progressValue >= totalProgress) {
                logger.log("progressValue (" + progressValue + ") >= totalProgress(" + totalProgress + ")");
                var nextRemainingProgressFraction = (float) (progressValue - totalProgress) / progressValue;
                var filteredDestinationNodeList = filteredDestinationNode.stream()
                        .filter(node -> {
                            var keep = !node.getNodeIdRef().equals(destinationNode.getNodeIdRef());
                            if (!keep) {
                                logger.log("removing node", node);
                            }
                            return keep;
                        })
                        .toList();
                var applyPathRecursiveResult = applyPathRecursive(
                        worldStepInstance,
                        pathElement,
                        destinationNode.getNodeIdRef(),
                        filteredDestinationNodeList,
                        personIdRef,
                        nextRemainingProgressFraction
                );
                if (applyPathRecursiveResult.isPresent()) {
                    logger.log("applyPathRecursive has result");
                    return logger.logReturn(Optional.of(Mutation.of(outWorldStepInstance -> {

                        logger.logTodo("merge duplicated code [id: 1]");
                        var personMoveTo = getPersonMoveTo(outWorldStepInstance, personIdRef);
                        var newPath = personMoveTo.getPath()
                                .orElseGet(() -> {
                                    var transientPath = Path.fromRawNode(pathElement.serializeIntoRawNode());
                                    personMoveTo.setPath(transientPath);
                                    return transientPath;
                                });
                        newPath.streamNode()
                                .filter(node -> node.getNodeIdRef().equals(destinationNode.getNodeIdRef()))
                                .toList()
                                .forEach(node -> {
                                    logger.log("removing node", node);
                                    node.removeFromParent();
                                });

                        applyPathRecursiveResult.get().apply(outWorldStepInstance);
                        return outWorldStepInstance;
                    })));
                }
                logger.log("reached destination to node " + destinationNode.getNodeIdRef());
                return logger.logReturn(Optional.of(Mutation.of(outWorldStepInstance -> {
                    outWorldStepInstance.locationGraph.removePerson(personIdRef);

                    logger.logTodo("merge duplicated code [id: 1]");
                    var personMoveTo = getPersonMoveTo(outWorldStepInstance, personIdRef);
                    var newPath = personMoveTo.getPath()
                            .orElseGet(() -> {
                                var transientPath = Path.fromRawNode(pathElement.serializeIntoRawNode());
                                personMoveTo.setPath(transientPath);
                                return transientPath;
                            });
                    newPath.streamNode()
                            .filter(node -> node.getNodeIdRef().equals(destinationNode.getNodeIdRef()))
                            .toList()
                            .forEach(node -> {
                                logger.log("removing node", node);
                                node.removeFromParent();
                            });

                    outWorldStepInstance.streamWorldStep()
                            .flatMap(WorldStep::streamData)
                            .flatMap(Data::streamLocation)
                            .flatMap(Location::streamLocationGraph)
                            .flatMap(LocationGraph::streamNode)
                            .filter(node -> node.getId().equals(destinationNode.getNodeIdRef()))
                            .findFirst()
                            .ifPresent(endNode -> endNode.getPeopleOrDefault()
                                    .addPerson(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person()
                                            .setPersonIdRef(personIdRef)
                                    ));
                    return outWorldStepInstance;
                })));
            }

            logger.log("reach destination to link_to " + originNode.get().getId() + " -> " + linkElement.get().getNodeIdRef() + " with progressValue " + progressValue);

            return logger.logReturn(Optional.of(Mutation.of(outWorldStepInstance -> {
                logger.log("applyPathRecursiveMutation: removing person from node " + originNode.get().getId());
                outWorldStepInstance.locationGraph.removePerson(personIdRef);

                logger.logTodo("merge duplicated code [id: 1]");
                var personMoveTo = getPersonMoveTo(outWorldStepInstance, personIdRef);
                var newPath = personMoveTo.getPath()
                        .orElseGet(() -> {
                            var transientPath = Path.fromRawNode(pathElement.serializeIntoRawNode());
                            personMoveTo.setPath(transientPath);
                            return transientPath;
                        });
                newPath.streamNode()
                        .filter(node -> !node.getNodeIdRef().equals(destinationNode.getNodeIdRef()))
                        .toList()
                        .forEach(node -> {
                            logger.log("removing node", node);
                            node.removeFromParent();
                        });


                logger.log("on link " + linkElement.get().getNodeIdRef() + " with accumulatedProgress " + progressValue);
                outWorldStepInstance.locationGraph.linkToRepository.getOrDefault(linkElement.get())
                        .getPeopleOrDefault()
                        .addPerson(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.Person.Person()
                                .setPersonIdRef(personIdRef)
                                .setAccumulatedProgress((int) progressValue)
                        );
                return outWorldStepInstance;
            })));
        }
    }

    private static Optional<Mutation<WorldStepInstance>> applyPathRecursiveFromLink(
        final WorldStepInstance worldStepInstance,
        final Path pathElement,
        final List<Node> destinationNode,
        final String personIdRef) {
        try (var logger = logScope(
                "personIdRef",
                personIdRef,
                "destinationNode",
                destinationNode.stream().map(Node::getNodeIdRef).toList()
        );){
            logger.logTodo("repository, get node from person id ref");
            var personNodeResult = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamData)
                    .flatMap(Data::streamLocation)
                    .flatMap(Location::streamLocationGraph)
                    .flatMap(LocationGraph::streamNode)
                    .filter(node -> node.streamLinks()
                            .flatMap(Links::streamLinkTo)
                            .flatMap(LinkTo::streamPeople)
                            .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People::streamPerson)
                            .anyMatch(person -> person.getPersonIdRef().equals(personIdRef))
                    )
                    .findFirst();
            if (personNodeResult.isEmpty()) {
                logger.log("empty personNodeResult");
                return logger.logReturn(Optional.empty());
            }

            logger.logTodo("repository, get link from person id ref");
            record LinkElementAndPersonLink(LinkTo linkTo, Person person) {}
            var linkElementAndPersonLink = personNodeResult.stream()
                    .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node::streamLinks)
                    .flatMap(Links::streamLinkTo)
                    .flatMap(linkTo -> linkTo.streamPeople()
                            .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People::streamPerson)
                            .filter(person -> person.getPersonIdRef().equals(personIdRef))
                            .findFirst()
                            .stream().map(person -> new LinkElementAndPersonLink(linkTo, person))
                    )
                    .findFirst();
            if (linkElementAndPersonLink.isEmpty()) {
                logger.log("empty linkElementAndPersonLink");
                return logger.logReturn(Optional.empty());
            }

            var linkTo = linkElementAndPersonLink.get().linkTo;
            logger.log("linkTo", linkTo.buildPath());
            var personNodeElement = linkElementAndPersonLink.get().person;
            var progressPropertyResult = linkTo.getPersonProgressProperty();
            if (progressPropertyResult.isEmpty()) {
                logger.log("empty progressProperty");
                return logger.logReturn(Optional.empty());
            }
            var accumulatedProgress = personNodeElement.getAccumulatedProgress();
            logger.log("accumulatedProgress", accumulatedProgress);
            var progressValue = worldStepInstance.computeOperation(progressPropertyResult.get()).orElse(0) + accumulatedProgress;
            var totalProgress = linkTo.getTotalProgress();
            Mutation<WorldStepInstance> mutationResult = Mutation.of(outWorldStepInstance -> {
                logger.log("mutation applyPathRecursiveFromLink: removing person from node", personIdRef);
                outWorldStepInstance.locationGraph.removePerson(personIdRef);
                logger.log(
                        "mutation applyPathRecursiveFromLink: adding person to linkTo",
                        linkTo.buildPath(),
                        "with accumulatedProgress",
                        totalProgress);
                outWorldStepInstance.locationGraph.linkToRepository.getOrDefault(linkTo)
                        .getPeopleOrDefault().addPerson(new Person()
                                .setPersonIdRef(personIdRef)
                                .setAccumulatedProgress(totalProgress)
                        );
                return outWorldStepInstance;
            });

            if (progressValue >= totalProgress) {
                logger.log("progressValue (" + progressValue + ") >= totalProgress(" + totalProgress + ")");
                float nextRemainingProgressFraction = (float) (progressValue - totalProgress) / progressValue;
                var filterDestinationNodeList = destinationNode.stream()
                        .filter(node -> {
                            var keep = !Objects.equals(node.getNodeIdRef(), personNodeResult.get().getId());
                            if (!keep) {
                                logger.log("removing node", node);
                            }
                            return keep;
                        })
                        .toList();
                var applyPathRecursiveResult = applyPathRecursive(
                        worldStepInstance,
                        pathElement,
                        linkTo.getNodeIdRef(),
                        filterDestinationNodeList,
                        personIdRef,
                        nextRemainingProgressFraction
                );
                if (applyPathRecursiveResult.isPresent()) {
                    mutationResult = applyPathRecursiveResult.get();
                }
            }

            final Mutation<WorldStepInstance> finalMutationResult = mutationResult;

            return logger.logReturn(Optional.of(Mutation.of(outWorldStepInstance -> {
                logger.log("applying finalMutationResult");
                getPersonMoveTo(outWorldStepInstance, personIdRef)
                        .setPath(new Path()
                                .addAllNode(pathElement.streamNode()
                                        .filter(node -> !node.getNodeIdRef().equals(personNodeResult.get().getId()))
                                        .toList())
                        );
                finalMutationResult.apply(outWorldStepInstance);
                return outWorldStepInstance;
            })));
        }
    }

    private static Optional<Mutation<Person_moveTo>> applyFindPath(
        final WorldStepInstance worldStepInstance,
        final Person_moveTo personMoveTo) {
        try (var logger = logScope(personMoveTo.buildPath())) {
            var findPathTowardElement = personMoveTo.getFindPathTowards();
            if (findPathTowardElement.isEmpty()) {
                logger.log("empty findPathTowardElement");
                return logger.logReturn(Optional.empty());
            }

            var personIdRef = personMoveTo.getPersonIdRef();
            logger.log("personIdRef", personIdRef);
            var originNodeList = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamData)
                    .flatMap(Data::streamLocation)
                    .flatMap(Location::streamLocationGraph)
                    .flatMap(LocationGraph::streamNode)
                    .filter(node -> node.streamPeople()
                            .flatMap(People::streamPerson)
                            .anyMatch(person -> person.getPersonIdRef().equals(personIdRef))
                    )
                    .toList();
            Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node> originNodeResult = Optional.empty();
            if (!originNodeList.isEmpty()) {
                originNodeResult = Optional.of(originNodeList.getFirst());
            }
            if (originNodeList.isEmpty()) {
                originNodeResult = worldStepInstance.streamWorldStep()
                        .flatMap(WorldStep::streamData)
                        .flatMap(Data::streamLocation)
                        .flatMap(Location::streamLocationGraph)
                        .flatMap(LocationGraph::streamNode)
                        .filter(node -> node.streamLinks()
                                .flatMap(Links::streamLinkTo)
                                .flatMap(LinkTo::streamPeople)
                                .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People::streamPerson)
                                .anyMatch(person -> person.getPersonIdRef().equals(personIdRef)))
                        .findFirst();
            }

            if (originNodeResult.isEmpty()) {
                logger.log("empty originNodeResult");
                return logger.logReturn(Optional.empty());
            }
            var originNode = originNodeResult.get();
            var locationGraph = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamData)
                    .flatMap(Data::streamLocation)
                    .flatMap(Location::streamLocationGraph)
                    .filter(locationGraphElement -> locationGraphElement
                            .streamNode()
                            .anyMatch(node -> node.getId().equals(originNode.getId()))
                    )
                    .findFirst();
            if (locationGraph.isEmpty()) {
                logger.log("empty locationGraph");
                return logger.logReturn(Optional.empty());
            }
            var destinationNode = worldStepInstance.locationGraph.selectNodeGraph(findPathTowardElement.get());

            var nodePath = worldStepInstance.locationGraph.shortestPathsInGraphExcludeStart(
                    locationGraph.get(),
                    originNode,
                    worldStepInstance.randomFrom(destinationNode).get(),
                    1
            );

            if (nodePath.isEmpty()) {
                logger.log("empty nodePath");
                return Optional.empty();
            }

            return Optional.of(Mutation.of(outWorldStepInstance -> {
                logger.log("removing personMoveTo", personMoveTo.buildPath());
                outWorldStepInstance.streamWorldStep()
                        .flatMap(WorldStep::streamActions)
                        .flatMap(Actions::streamPerson_moveTo)
                        .filter(personMoveToElement -> personMoveToElement.getPersonIdRef().equals(personIdRef))
                        .toList()
                        .forEach(Person_moveTo::removeFromParent);


                var path = new Path();

                nodePath.getFirst().forEach(node -> path
                        .addNode(new Node()
                                .setNodeIdRef(node.getId())
                        ));

                var personMoveToElement = new Person_moveTo()
                        .setPersonIdRef(personIdRef)
                        .setPath(path);
                outWorldStepInstance.getWorldStep()
                        .ifPresent(worldStep -> {
                            var actionElement = worldStep.getActionsOrDefault();
                            actionElement.addPerson_moveTo(personMoveToElement);
                        });
                return personMoveToElement;
            }));
        }
    }
}
