package ro.anud.xml_xsd.implementation.middleware.action;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Person_create.Person_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class PersonCreateAction {
    public static void apply(final WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        var actionList = worldStepInstance.getWorldStep()
            .streamActions()
            .flatMap(Actions::streamPerson_create)
            .toList();

        actionList.forEach(personCreate -> {
            var nodeGraphSelection = personCreate.getNodeGraph_selection();
            var locationList = worldStepInstance.getOutInstance().locationGraph.selectNodeGraph(nodeGraphSelection);
            var locatioElementOptional = worldStepInstance.randomFrom(locationList);
            if (locatioElementOptional.isEmpty()) {
                return;
            }
            var personSelection = personCreate.getPerson_selection();
            var person = worldStepInstance.getOutInstance().person.createPerson(personSelection);
            locatioElementOptional.ifPresent(node -> {
                node.getPeopleOrDefault().addPerson(new Person().setPersonIdRef(person.getId()));
            });
            logger.logTodo("move to person creation function");
            worldStepInstance.getOutInstance().person.classifyPerson(person);
        });
        worldStepInstance.getOutInstance().getWorldStep()
            .streamActions()
            .flatMap(Actions::streamPerson_create)
            .toList()
            .forEach(Person_create::removeFromParent);
    }

}
