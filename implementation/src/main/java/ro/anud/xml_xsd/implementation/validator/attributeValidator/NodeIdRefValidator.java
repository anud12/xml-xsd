package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class NodeIdRefValidator implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamData()
            .flatMap(Data::streamLocation)
            .flatMap(Location::streamLocationGraph)
            .flatMap(LocationGraph::streamNode)
            .map(Node::getId);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "node_id_ref";
    }
}
