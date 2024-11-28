package ro.anud.xml_xsd.implementation.middleware.person;

import ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Type_nodeGraph_selection;
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
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class PersonMoveTo {
    public static void apply(WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        worldStepInstance.getWorldStep()
            .streamActions()
            .flatMap(Actions::streamPerson_moveTo)
            .toList()
            .forEach(personMoveTo -> {
                applyFindPath(worldStepInstance, personMoveTo)
                    .or(() -> applyPath(worldStepInstance, personMoveTo))
                    .ifPresent(worldStepInstanceConsumer -> worldStepInstanceConsumer.accept(worldStepInstance));
                personMoveTo.getPath().ifPresent(path -> {
                    if (path.getNode().isEmpty()) {
                        personMoveTo.removeFromParent();
                    }
                });
                personMoveTo.getFindPathTowards()
                    .ifPresent(ignored -> personMoveTo.removeFromParent());
            });
    }

    private static Optional<Consumer<WorldStepInstance>> applyPath(
        final WorldStepInstance worldStepInstance,
        final Person_moveTo personMoveTo) {
        var logger = logEnter();

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
            return logger.logReturn(hasExecuted);
        }

        var originNodeOptional = worldStepInstance.getWorldStep()
            .streamData()
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

        return Optional.of(outWorldStepInstance -> {
            result.ifPresent(consumer -> consumer.accept(outWorldStepInstance));
            pathElement.getNode()
                .stream()
                .filter(node -> node.getNodeIdRef().equals(originNode.getId()))
                .toList()
                .forEach(node -> {
                    logger.log("removing node", node);
                    pathElement.removeNode(node);
                });
        });
    }

    private static Optional<Consumer<WorldStepInstance>> applyPathRecursive(
        final WorldStepInstance worldStepInstance,
        final Path pathElement,
        final String currentNodeId,
        final List<Node> filteredDestinationNode,
        final String personIdRef,
        final float remainingProgressFraction) {
        var logger = logEnter(
            "currentNodeId",
            currentNodeId,
            "personIdRef",
            personIdRef,
            "remainingProgressFraction",
            remainingProgressFraction
        );
        if (filteredDestinationNode.isEmpty()) {
            logger.log("empty filteredDestinationNode");
            return logger.logReturn(Optional.empty());
        }
        var destinationNode = filteredDestinationNode.getFirst();
        if (Objects.isNull(destinationNode)) {
            logger.log("empty destinationNode");
            return logger.logReturn(Optional.empty());
        }

        var originNode = worldStepInstance.getWorldStep()
            .streamData()
            .flatMap(Data::streamLocation)
            .flatMap(Location::streamLocationGraph)
            .flatMap(LocationGraph::streamNode)
            .filter(node -> node.getId().equals(currentNodeId))
            .findFirst();

        var linkElement = originNode.stream()
            .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node::streamLinks)
            .flatMap(Links::streamLinkTo)
            .filter(linkTo -> linkTo.getNodeIdRef().equals(destinationNode.getNodeIdRef()))
            .findFirst();
        if (linkElement.isEmpty()) {
            logger.log("empty linkElement");
            worldStepInstance.locationGraph.removePerson(personIdRef);
            originNode.get().getPeopleOrDefault().addPerson(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person()
                .setPersonIdRef(personIdRef)
            );
            return logger.logReturn(Optional.empty());
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
            worldStepInstance.getWorldStep()
                .streamData()
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
            destinationNode.removeFromParent();
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
                return logger.logReturn(applyPathRecursiveResult);
            }
            logger.log("reached destination to node " + destinationNode.getNodeIdRef());
            return logger.logReturn(Optional.of(outWorldStepInstance -> {
                outWorldStepInstance.locationGraph.removePerson(personIdRef);
                outWorldStepInstance.getWorldStep()
                    .streamData()
                    .flatMap(Data::streamLocation)
                    .flatMap(Location::streamLocationGraph)
                    .flatMap(LocationGraph::streamNode)
                    .filter(node -> node.getId().equals(destinationNode.getNodeIdRef()))
                    .findFirst()
                    .ifPresent(endNode -> {
                        endNode.getPeopleOrDefault()
                            .addPerson(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person()
                                .setPersonIdRef(personIdRef)
                            );
                    });
            }));
        }

        logger.log("reach destination to link_to " + originNode.get().getId() + " -> " + linkElement.get().getNodeIdRef() + " with progressValue " + progressValue);
        return logger.logReturn(Optional.of(outWorldStepInstance -> {
            logger.log("removing person from node " + originNode.get().getId());
            worldStepInstance.locationGraph.removePerson(personIdRef);
            logger.log("on link " + linkElement.get().getNodeIdRef() + " with accumulatedProgress " + progressValue);
            linkElement.get().getPeopleOrDefault()
                .addPerson(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.Person.Person()
                    .setPersonIdRef(personIdRef)
                    .setAccumulatedProgress((int) progressValue)
                );
        }));

    }

    private static Optional<Consumer<WorldStepInstance>> applyPathRecursiveFromLink(
        final WorldStepInstance worldStepInstance,
        final Path pathElement,
        final List<Node> destinationNode,
        final String personIdRef) {
        var logger = logEnter(
            "personIdRef",
            personIdRef,
            "destinationNode",
            destinationNode.stream().map(Node::getNodeIdRef).toList()
        );
        logger.logTodo("repository, get node from person id ref");
        var personNodeResult = worldStepInstance.getWorldStep()
            .streamData()
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
        var personNodeElement = linkElementAndPersonLink.get().person;
        var progressPropertyResult = linkTo.getPersonProgressProperty();
        if (progressPropertyResult.isEmpty()) {
            logger.log("empty progressProperty");
            return logger.logReturn(Optional.empty());
        }
        var accumulatedProgress = personNodeElement.getAccumulatedProgress();
        var progressValue = worldStepInstance.computeOperation(progressPropertyResult.get()).orElse(0) + accumulatedProgress;
        var totalProgress = linkTo.getTotalProgress();
        Consumer<WorldStepInstance> mutationResult = outWorldStepInstance -> {
            outWorldStepInstance.locationGraph.removePerson(personIdRef);
            linkTo.getPeopleOrDefault().addPerson(new Person()
                .setPersonIdRef(personIdRef)
                .setAccumulatedProgress(accumulatedProgress)
            );
        };

        if (progressValue >= totalProgress) {
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

        final Consumer<WorldStepInstance> finalMutationResult = mutationResult;
        return logger.logReturn(Optional.of(outWorldStepInstance -> {
            pathElement.streamNode()
                .filter(node -> node.getNodeIdRef().equals(personNodeResult.get().getId()))
                .toList()
                .forEach(node -> {
                    logger.log("removing node", node);
                    pathElement.removeNode(node);
                });

            finalMutationResult.accept(outWorldStepInstance);
        }));
    }

    private static Optional<Consumer<WorldStepInstance>> applyFindPath(
        final WorldStepInstance worldStepInstance,
        final Person_moveTo personMoveTo) {
        var logger = logEnter(personMoveTo.buildPath());
        var findPathTowardElement = personMoveTo.getFindPathTowards();
        if (findPathTowardElement.isEmpty()) {
            logger.log("empty findPathTowardElement");
            return logger.logReturn(Optional.empty());
        }

        var personIdRef = personMoveTo.getPersonIdRef();
        logger.log("personIdRef", personIdRef);
        var originNodeList = worldStepInstance.getWorldStep()
            .streamData()
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
            originNodeResult = Optional.of(originNodeList.get(0));
        }
        if (originNodeList.isEmpty()) {
            originNodeResult = worldStepInstance
                .getWorldStep()
                .streamData()
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
        var locationGraph = worldStepInstance.getWorldStep()
            .streamData()
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
        return Optional.of(outWorldStepInstance -> {
            logger.log("removing personMoveTo", personMoveTo.buildPath());
            personMoveTo.removeFromParent();
            if (nodePath.isEmpty()) {
                logger.log("empty nodePath");
                return;
            }

            var actionElement = outWorldStepInstance.getWorldStep()
                .getActionsOrDefault();

            var path = new Path();

            nodePath.getFirst().forEach(node -> {
                path.addNode(new Node()
                    .setNodeIdRef(node.getId())
                );
            });

            actionElement.addPerson_moveTo(new Person_moveTo()
                .setPersonIdRef(personIdRef)
                .setPath(path)
            );


        });
    }
}
