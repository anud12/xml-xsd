package ro.anud.xml_xsd.implementation.service.action;


import ro.anud.xml_xsd.implementation.service.Middleware;

import java.util.Set;

public sealed interface Action extends Middleware permits ActionCreate {
    void assignDependencies(Set<Action> middlewareSet);
}
