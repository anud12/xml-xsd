package ro.anud.xml_xsd.implementation.service;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.People;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class LocationGraphInstance {
    final WorldStepInstance worldStepInstance;

    public LocationGraphInstance(final WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    public record FindPersonResult(LocationGraph locationGraph, Optional<Node> node, Optional<LinkTo> linkTo) {}

    public List<FindPersonResult> findPersonLocation(String personId) {
        var logger = logEnter("personId:", personId);
        var locationGraphStream = worldStepInstance.getWorldStep()
                .streamData()
                .flatMap(Data::streamLocation)
                .flatMap(Location::streamLocationGraph);


        var result = locationGraphStream
                .flatMap(locationGraph -> {
                    var nodeElement = locationGraph.streamNode()
                            .filter(node -> node.streamPeople()
                                    .flatMap(People::streamPerson)
                                    .anyMatch(innerPerson -> innerPerson.getPersonIdRef().equals(personId)))
                            .findAny();
                    if (nodeElement.isPresent()) {
                        return Stream.of(new FindPersonResult(locationGraph, nodeElement, Optional.empty()));
                    }
                    var linkToPerson = locationGraph.streamNode()
                            .flatMap(Node::streamLinks)
                            .flatMap(Links::streamLinkTo)
                            .filter(linkTo -> linkTo.streamPeople()
                                    .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.People.People::streamPerson)
                                    .anyMatch(innerPerson -> innerPerson.getPersonIdRef().equals(personId))
                            )
                            .findAny();
                    if (linkToPerson.isPresent()) {
                        return Stream.of(new FindPersonResult(locationGraph, Optional.empty(), linkToPerson));
                    }
                    return Stream.empty();
                }).toList();

        return logger.logReturn(result);
    }
}
