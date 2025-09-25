package ro.anud.xml_xsd.implementation.middleware.action;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class PersonCreateAction {
    public static void personCreateAction(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()){
            var outInstance = worldStepInstance.getOutInstance();

            var actionList = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamPerson_create)
                    .toList();

            actionList.forEach(personCreate -> {
                var nodeGraphSelection = personCreate.getNodeGraph_selection();
                var locationList = worldStepInstance.locationGraph.selectNodeGraph(nodeGraphSelection);
                var locatioElementOptional = worldStepInstance.randomFrom(locationList);
                if (locatioElementOptional.isEmpty()) {
                    return;
                }
                var personSelection = personCreate.getPerson_selection();
                var person = worldStepInstance.person.createPerson(personSelection).apply(outInstance);
                locatioElementOptional.ifPresent(node -> {
                    outInstance.locationGraph.nodeRepository.getNodeOrDefault(node)
                            .getPeopleOrDefault()
                            .addPerson(new Person()
                                    .setPersonIdRef(person.getId())
                            );
                });
                scope.logTodo("move to person creation function");
                outInstance.person.classifyPerson(person);
            });

            outInstance.streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamPerson_create)
                    .toList()
                    .forEach(Person_create::removeFromParent);
        }
    }

}
