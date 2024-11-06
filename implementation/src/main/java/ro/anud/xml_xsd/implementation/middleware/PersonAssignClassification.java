package ro.anud.xml_xsd.implementation.middleware;

import org.springframework.stereotype.Service;
import ro.anud.xml_xsd.implementation.service.Middleware;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

@Service
public class PersonAssignClassification implements Middleware {
    @Override
    public void apply(final WorldStepInstance inInstance) {
        var logger = logEnter();
        inInstance.person.repository
            .streamAll()
            .flatMap(inInstance.person::classifyPerson)
            .count();
        logger.logReturnVoid();
    }
}
