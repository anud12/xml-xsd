package ro.anud.xml_xsd.implementation.middleware;

import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;


public class PersonAssignClassification {
    public static void apply(final WorldStepInstance inInstance) {
        var logger = logEnter();
        inInstance.getOutInstance().person.repository
            .streamAll()
            .toList()
            .stream().flatMap(inInstance.getOutInstance().person::classifyPerson)
            .toList();
        logger.logReturnVoid();
    }
}
