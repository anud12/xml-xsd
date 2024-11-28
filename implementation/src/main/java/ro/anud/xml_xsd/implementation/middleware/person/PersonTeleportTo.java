package ro.anud.xml_xsd.implementation.middleware.person;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.Person_teleport;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;
import java.util.function.Consumer;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class PersonTeleportTo {

    public static void apply(WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        worldStepInstance.getWorldStep()
            .getActions()
            .flatMap(Actions::getPerson_teleport)
            .ifPresent(personTeleport -> {
                locationGraph(worldStepInstance, personTeleport)
                    .ifPresent(consumer -> consumer.accept(worldStepInstance.getOutInstance()));
                linkToNode(worldStepInstance, personTeleport)
                    .ifPresent(consumer -> consumer.accept(worldStepInstance.getOutInstance()));

            });
    }

    private static Optional<Consumer<WorldStepInstance>> linkToNode(
        final WorldStepInstance worldStepInstance,
        final Person_teleport personTeleport) {
        var logger = logEnter();
        var personIdRef = personTeleport.getPersonIdRef();
        var linkTo = personTeleport.getLinkTo();
        if(linkTo.isEmpty()) {
            logger.log("linkTo is empty");
            return Optional.empty();
        }
        return Optional.of(outWorldStepInstance -> {
            personTeleport.removeFromParent();
            var linkToList = outWorldStepInstance.locationGraph
                .selectLinkTo(linkTo.get().getSelection())
                .toList();
            if(linkToList.isEmpty()) {
                logger.log("linkToList is empty");
                return;
            }
            var accumulatedProgress = personTeleport.getLinkTo().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_teleport.LinkTo.LinkTo::getAccumulatedProgress);
            outWorldStepInstance.locationGraph.removePerson(personIdRef);
            outWorldStepInstance.randomFrom(linkToList)
                .stream()
                .flatMap(LinkTo::streamPeopleOrDefault)
                .forEach(people -> {
                    people.addPerson(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.Person.Person()
                        .setPersonIdRef(personIdRef)
                        .setAccumulatedProgress(accumulatedProgress.orElse(0))
                    );
                });

        });
    }

    private static Optional<Consumer<WorldStepInstance>> locationGraph(
        final WorldStepInstance worldStepInstance,
        final Person_teleport personTeleport) {
        var logger = logEnter();
        var personIdRef = personTeleport.getPersonIdRef();

        var targetLocationGraphId = personTeleport.getLocationGraph();
        if(targetLocationGraphId.isEmpty()) {
            logger.log("targetLocationGraphId is empty");
            return Optional.empty();
        }
        return Optional.of(outWorldStepInstance -> {
            personTeleport.removeFromParent();
            var locationGraphList = outWorldStepInstance.locationGraph
                .repository
                .getLocationGraphById(targetLocationGraphId.get().getLocationGraphIdRef());
            if(locationGraphList.isEmpty()) {
                logger.log("locationGraphList is empty");
                return;
            }
            outWorldStepInstance.locationGraph.removePerson(personIdRef);
            var targetNodeId = targetLocationGraphId.get().getNodeIdRef();
            var node = locationGraphList.get().streamNode()
                .filter(node1 -> node1.getId().equals(targetNodeId))
                .toList();
            if(node.isEmpty()) {
                logger.log("node is empty");
                return;
            }
            node.getFirst().getPeopleOrDefault().addPerson(new Person()
                .setPersonIdRef(personIdRef)
            );
        });
    }
}
