package ro.anud.xml_xsd.implementation.validator;

import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;


public interface AttributeValidator {
    record InvalidAttribute(String path, String value, List<String> allowedValues) {}

    public Stream<String> getAllowedValues(WorldStep worldStep);

    public String getAttributeKeyToBeTested();

    public default List<InvalidAttribute> validate(WorldStep worldStep, RawNode rawNode) {
        try (var logger = logScope(rawNode.getPath());){
            var allowedValues = getAllowedValues(worldStep).toList();
            var key = getAttributeKeyToBeTested();
            var resultList = new ArrayList<InvalidAttribute>();
            rawNode.getAttribute(key).ifPresent(string -> {
                if (allowedValues.stream().anyMatch(allowedValue -> allowedValue.equals(string))) {
                    return;
                }
                logger.log("Remove culling '//world_step[0]'");
                var path = rawNode.getPath() + "@" + key;
                path = path.replace("//world_step[0]","/");
                resultList.add(new InvalidAttribute(
                        path,
                        string,
                        allowedValues
                ));
            });
            var childrenResult = rawNode.getAllChildren()
                    .stream()
                    .flatMap(childNode -> validate(worldStep, childNode).stream())
                    .toList();

            resultList.addAll(childrenResult);

            return resultList;
        }
    }

    public default List<InvalidAttribute> validate(WorldStep worldStep) {
        return validate(worldStep, worldStep.rawNode());
    }
}