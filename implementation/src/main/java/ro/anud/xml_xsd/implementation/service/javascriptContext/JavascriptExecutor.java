package ro.anud.xml_xsd.implementation.service.javascriptContext;

import org.graalvm.polyglot.PolyglotException;
import ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.Text.Text;
import ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.javascriptContext.mutation.TextMutation;

import java.util.*;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class JavascriptExecutor {

    private final Map<String, Map<String, List<TextMutation>>> entityIdToPropertyNameToTextMutationMap = new HashMap<>();

    public void add(TextMutation textMutation) {
        var propertyNameMap = entityIdToPropertyNameToTextMutationMap.getOrDefault(textMutation.entityId(), new HashMap<>());
        entityIdToPropertyNameToTextMutationMap.put(textMutation.entityId(), propertyNameMap);
        var textMutationList = propertyNameMap.getOrDefault(textMutation.name(), new ArrayList<>());
        propertyNameMap.put(textMutation.name(), textMutationList);
        textMutationList.add(textMutation);
    }

    public void executeMutations(WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            entityIdToPropertyNameToTextMutationMap.forEach((entityId, stringListMap) -> {
                try (var entityScope = logScope("entityId", entityId)){
                    var entity = worldStepInstance.entity.repository.byId.get(entityId);
                    if(entity.isEmpty()) {
                        String javascriptCodePoints = stringListMap.values().stream().flatMap(Collection::stream)
                                        .map(textMutation -> {
                                            for (PolyglotException.StackFrame frame: textMutation.stackFrame()) {
                                                if (frame.isGuestFrame()) {
                                                    return frame.getSourceLocation().getSource().getName() + ":" + frame.getSourceLocation().getStartLine();
                                                }
                                            }
                                            return "<No guest frame found>";
                                        }).collect(Collectors.joining(",", "[", "]"));
                        worldStepInstance.broadcastDebug("error: Required entity by id not found: " + entityId + " called by: " + javascriptCodePoints);
                        return;
                    }

                    var outputEntity = worldStepInstance.getOutInstance()
                            .entity
                            .repository
                            .getOrDefault(entity.get());
                    stringListMap.forEach((propertyName, textMutations) -> {
                        try (var propertyScope = logScope("property name", propertyName)){
                            var property = entity.get().streamTextMap()
                                    .flatMap(TextMap::streamText)
                                    .filter(text -> text.getName().equals(propertyName))
                                    .findFirst();
                            String value = property.map(Text::getValue).orElse("");
                            String newValue = value;
                            for (TextMutation mutation : textMutations) {
                                var nextValue = mutation.mapper().apply(newValue);
                                var mergedValue = mutation.joiner().apply(newValue, nextValue);
                                newValue = mergedValue;
                            }
                            var outputText = outputEntity.streamTextMapOrDefault()
                                    .flatMap(TextMap::streamText)
                                    .filter(text -> text.getName().equals(propertyName))
                                    .findFirst()
                                    .orElseGet(() -> {
                                        var text = Text.of()
                                                .setName(propertyName)
                                                .setValue("");
                                        outputEntity.getTextMapOrDefault()
                                                .addText(text);
                                        return text;
                                    });
                            propertyScope.log("new value", newValue);
                            outputText.setValue(newValue);
                        }

                    });
                }

            });
        }

    }

    public void clearMutations() {
        entityIdToPropertyNameToTextMutationMap.clear();
    }
}
