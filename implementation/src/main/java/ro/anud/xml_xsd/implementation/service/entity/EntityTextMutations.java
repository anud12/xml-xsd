package ro.anud.xml_xsd.implementation.service.entity;

import org.graalvm.polyglot.PolyglotException;
import ro.anud.xml_xsd.implementation.javascriptContext.operations.mutation.TextMutation;
import ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.Text.Text;
import ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.worldStepLifecycle.StepEnd;

import java.util.*;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class EntityTextMutations implements StepEnd {
    private final WorldStepInstance worldStepInstance;
    private final Map<String, List<String>> entityIdToPropertyNames = new HashMap<>();

    public EntityTextMutations(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    public void execute(TextMutation textMutation) {
        try (var entityScope = logScope("entityId", textMutation.entityId(), "property name", textMutation.name())) {
            var entity = getEntity(textMutation);
            if (entity.isEmpty()) {
                var javascriptCodePoint = "<No guest frame found>";
                for (PolyglotException.StackFrame frame : textMutation.stackFrame()) {
                    if (frame.isGuestFrame()) {
                        javascriptCodePoint = frame.getSourceLocation().getSource().getName() + ":" + frame.getSourceLocation().getStartLine();
                    }
                }
                worldStepInstance.broadcastDebug("error: Required entity by id not found: " + textMutation.entityId() + " called by: " + javascriptCodePoint);
                return;
            }

            var originalEntity = worldStepInstance.entity.repository.byId.get(textMutation.entityId());

            var currentProperty = getValue(textMutation, entity.get());
            var originalProperty = getValue(textMutation, originalEntity.get());
            var propertyList = entityIdToPropertyNames.getOrDefault(textMutation.entityId(), new ArrayList<>());
            propertyList.add(textMutation.name());
            entityIdToPropertyNames.put(textMutation.entityId(), propertyList);


            var newValue = textMutation.mapper().apply(originalProperty);
            var joinedValue = textMutation.joiner().apply(currentProperty, newValue);
            entityScope.log("currentProperty:", currentProperty, "originalProperty:", originalProperty, "joinedValue:", joinedValue);

            var outputEntity = worldStepInstance.getOutInstance()
                    .entity
                    .repository
                    .getOrDefault(entity.get());
            var outputText = outputEntity.streamTextMapOrDefault()
                    .flatMap(TextMap::streamText)
                    .filter(text -> text.getName().equals(textMutation.name()))
                    .findFirst()
                    .orElseGet(() -> {
                        var text = Text.of()
                                .setName(textMutation.name())
                                .setValue("");
                        outputEntity.getTextMapOrDefault()
                                .addText(text);
                        return text;
                    });
            entityScope.log("new value", joinedValue);
            outputText.setValue(joinedValue);
        }
    }

    @Override
    public void endStep() {
        try (var scope = logScope()) {
            entityIdToPropertyNames.clear();
        }
    }

    private Optional<Entity> getEntity(TextMutation textMutation) {
        var entityOptional = worldStepInstance.entity.repository.byId.get(textMutation.entityId());
        if (entityOptional.isEmpty()) {
            return Optional.empty();
        }
        var entity = entityOptional.get();
        if (entityIdToPropertyNames.getOrDefault(textMutation.entityId(), List.of())
                .contains(textMutation.name())) {
            entity = worldStepInstance.getOutInstance()
                    .entity
                    .repository
                    .getOrDefault(entity);

        }
        return Optional.of(entity);
    }

    private Optional<Entity> getOriginalEntity(TextMutation textMutation) {
        var entityOptional = worldStepInstance.entity.repository.byId.get(textMutation.entityId());
        if (entityOptional.isEmpty()) {
            return Optional.empty();
        }
        var entity = entityOptional.get();
        if (entityIdToPropertyNames.getOrDefault(textMutation.entityId(), List.of())
                .contains(textMutation.name())) {
            entity = worldStepInstance.getOutInstance()
                    .entity
                    .repository
                    .getOrDefault(entity);

        }
        return Optional.of(entity);
    }
    private String getValue(TextMutation textMutation, Entity entity) {
        try (var scope = logScope()) {
            var value = entity.streamTextMap()
                    .flatMap(TextMap::streamText)
                    .filter(text -> text.getName().equals(textMutation.name()))
                    .findFirst()
                    .map(Text::getValue).orElse("");
            return value;
        }
    }
}
