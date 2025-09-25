package ro.anud.xml_xsd.implementation.middleware.person;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class PersonTeleportTo {

    public static void apply(WorldStepInstance worldStepInstance) {
        try (var scope = logScope()){
            worldStepInstance.getOutInstance().streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamPerson_teleport)
                    .toList()
                    .forEach(Person_teleport::removeFromParent);

            worldStepInstance.getWorldStep()
                    .flatMap(WorldStep::getActions)
                    .flatMap(Actions::getPerson_teleport)
                    .ifPresent(personTeleport -> {
                        locationGraph(worldStepInstance, personTeleport)
                                .ifPresent(consumer -> consumer.apply(worldStepInstance.getOutInstance()));
                        linkToNode(worldStepInstance, personTeleport)
                                .ifPresent(consumer -> consumer.apply(worldStepInstance.getOutInstance()));

                    });
        }
    }

    private static Optional<Mutation<WorldStepInstance>> linkToNode(
        final WorldStepInstance worldStepInstance,
        final Person_teleport personTeleport) {
        try (var scope = logScope()){
            var personIdRef = personTeleport.getPersonIdRef();
            var linkTo = personTeleport.getLinkTo();
            if (linkTo.isEmpty()) {
                scope.log("linkTo is empty");
                return Optional.empty();
            }
            var linkToList = worldStepInstance.locationGraph
                    .selectLinkTo(linkTo.get().getSelection())
                    .toList();
            var linkToElement = worldStepInstance.randomFrom(linkToList);
            if (linkToElement.isEmpty()) {
                scope.log("linkToElement is empty");
                return Optional.empty();
            }
            return Optional.of(Mutation.of(outWorldStepInstance -> {
                var outLinkTo = outWorldStepInstance.locationGraph.linkToRepository.getOrDefault(linkToElement.get());

                if (linkToList.isEmpty()) {
                    scope.log("linkToList is empty");
                    return outWorldStepInstance;
                }
                var accumulatedProgress = personTeleport.getLinkTo().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo::getAccumulatedProgress);
                outWorldStepInstance.locationGraph.removePerson(personIdRef);
                outLinkTo.streamPeopleOrDefault()
                        .forEach(people -> people
                                .addPerson(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.Person.Person()
                                        .setPersonIdRef(personIdRef)
                                        .setAccumulatedProgress(accumulatedProgress.orElse(0))
                                ));
                return outWorldStepInstance;
            }));
        }

    }

    private static Optional<Mutation<WorldStepInstance>> locationGraph(
        final WorldStepInstance worldStepInstance,
        final Person_teleport personTeleport) {
        try (var scope = logScope()){
            var personIdRef = personTeleport.getPersonIdRef();

            var targetLocationGraphId = personTeleport.getLocationGraph();
            if (targetLocationGraphId.isEmpty()) {
                scope.log("targetLocationGraphId is empty");
                return Optional.empty();
            }

            var locationGraphList = worldStepInstance.locationGraph
                    .locationGraphRepository
                    .getLocationGraphById(targetLocationGraphId.get().getLocationGraphIdRef());
            if (locationGraphList.isEmpty()) {
                scope.log("locationGraphList is empty");
                return Optional.empty();
            }
            var targetNodeId = targetLocationGraphId.get().getNodeIdRef();
            var node = locationGraphList.get().streamNode()
                    .filter(node1 -> node1.getId().equals(targetNodeId))
                    .toList();
            if (node.isEmpty()) {
                scope.log("node is empty");
                return Optional.empty();
            }

            return Optional.of(Mutation.of(outInstance -> {
                outInstance.locationGraph.removePerson(personIdRef);
                outInstance.locationGraph.nodeRepository.getNodeOrDefault(node.getFirst())
                        .getPeopleOrDefault().addPerson(new Person()
                                .setPersonIdRef(personIdRef)
                        );
                return outInstance;
            }));
        }

    }
}
