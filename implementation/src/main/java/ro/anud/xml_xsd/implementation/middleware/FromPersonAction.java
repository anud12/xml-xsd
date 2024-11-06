package ro.anud.xml_xsd.implementation.middleware;

import org.springframework.stereotype.Service;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.Selection;
import ro.anud.xml_xsd.implementation.service.Middleware;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

@Service
public class FromPersonAction implements Middleware {

    @Override
    public void apply(final WorldStepInstance worldStepInstance, WorldStepInstance outInstance) {
        var logger = logEnter();
        var ruleRepository = worldStepInstance.getRuleRepository();
        var personRepository = worldStepInstance.getPersonRepository();

        var fromPersonStream = worldStepInstance.getWorldStep()
            .streamActions()
            .flatMap(Actions::streamFromPerson)
            .toList();

        fromPersonStream.forEach(actionElement -> {
            actionElement.removeFromParent();
            var localLogger = logger.logEnter(actionElement.getNodeId());
            localLogger.log("personIdRef", actionElement.getPersonIdRef());
            var actionRuleOptional = ruleRepository.fromPersonById(actionElement.getFromPersonRuleRef());
            if (actionRuleOptional.isEmpty()) {
                localLogger.log("early return actionRule is empty");
                return;
            }
            var actionRule = actionRuleOptional.get();
            var selfPersonOptional = personRepository.personById(actionElement.getPersonIdRef());
            if (selfPersonOptional.isEmpty()) {
                localLogger.log("early return actionRule is empty");
                return;
            }
            var selfPerson = selfPersonOptional.get();
            var selfSelection = actionRule.getSelection();
            if (selfSelection.isPresent()) {
                var result = worldStepInstance.getPersonInstance().selection().isSelectionApplicableTo(
                    selfSelection.get(),
                    selfPersonOptional.get()
                );

                if (!result) {
                    localLogger.log("early return isSelectionNotApplicable is ", result);
                    return;
                }
            }

            actionElement.streamOnPerson()
                .forEach(onPerson -> {
                    var localLocalLogger = localLogger.logEnter(onPerson.getNodeId());
                    var onPersonRule = actionRule.getOnPerson();
                    var targetPerson = personRepository.personById(onPerson.getPersonIdRef());
                    if (onPersonRule.isEmpty() || targetPerson.isEmpty()) {
                        localLocalLogger.logReturnVoid(
                            "onPersonRule:",
                            onPersonRule,
                            "targetPerson",
                            targetPerson);
                        return;
                    }
                    if (!onPersonApplicable(
                        worldStepInstance,
                        selfPerson,
                        targetPerson.get(),
                        onPersonRule.get()
                    )) {
                        localLocalLogger.logReturnVoid("onPersonApplicable false");
                        return;
                    }
                    var result = actionRule.streamMutations()
                        .flatMap(Mutations::streamPropertyMutation)
                        .map(typePropertyMutation -> worldStepInstance.getPersonInstance()
                            .applyPropertyMutation(
                                selfPerson,
                                typePropertyMutation,
                                selfPerson,
                                targetPerson.get()
                            )
                        ).toList();
                    localLocalLogger.log("applyPropertyMutation result length:", result.size());
                    result.forEach(worldStepInstanceConsumer -> worldStepInstanceConsumer.accept(outInstance));

                    result = onPersonHandle(
                        worldStepInstance,
                        onPersonRule.get(),
                        selfPerson,
                        targetPerson.get())
                        .toList();
                    localLocalLogger.log("onPersonHandle result length:", result.size());
                    result.forEach(worldStepInstanceConsumer -> worldStepInstanceConsumer.accept(outInstance));
                });
        });


    }

    private Stream<Consumer<WorldStepInstance>> onPersonHandle(
        final WorldStepInstance worldStepInstance,
        final OnPerson onPerson,
        final Person selfPerson,
        final Person targetPerson) {
        var logger = logEnter();
        var result = onPerson.streamMutations()
            .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Mutations.Mutations::streamPropertyMutation)
            .map(typePropertyMutation -> worldStepInstance
                .getPersonInstance()
                .applyPropertyMutation(
                    targetPerson,
                    typePropertyMutation,
                    targetPerson,
                    selfPerson
                )
            );
        return logger.logReturn(result);
    }

    private boolean onPersonApplicable(
        final WorldStepInstance worldStepInstance,
        final Person selfPerson,
        final Person targetPerson,
        final OnPerson onPersonRule) {
        var logger = logEnter();
        var selection = onPersonRule.getSelection();

        var isNotFromSameLocation = selection.flatMap(Selection::getFromPersonSameLocationGraphNode)
            .map(fromPersonSameLocationGraphNode -> !isFromPersonSameLocationGraphNode(
                worldStepInstance,
                selfPerson,
                targetPerson,
                fromPersonSameLocationGraphNode)
            )
            .orElse(false);

        if (isNotFromSameLocation) {
            return logger.logReturn(false, "isNotFromSameLocation is true");

        }
        var selectionInstance = worldStepInstance.getPersonInstance().selection();
        var isSelectionApplicable = selection
            .stream()
            .filter(selection1 -> selectionInstance.isSelectionApplicableTo(
                selection1,
                selfPerson)
            )
            .findAny();

        if (isSelectionApplicable.isEmpty()) {
            return logger.logReturn(false, "isSelectionApplicable.isEmpty() is true");
        }
        return logger.logReturn(true);
    }

    private boolean isFromPersonSameLocationGraphNode(
        final WorldStepInstance worldStepInstance,
        final Person selfPerson,
        final Person targetPerson,
        final FromPersonSameLocationGraphNode fromPersonSameLocationGraphNode) {
        var locationGraphInstance = worldStepInstance.getLocationGraphInstance();
        var originLocation = locationGraphInstance.findPersonLocation(selfPerson.getId());
        var targetLocation = locationGraphInstance.findPersonLocation(targetPerson.getId());

        if (originLocation.isEmpty() || targetLocation.isEmpty()) {
            return false;
        }

        var commonLocation = originLocation.stream().anyMatch(originFindPersonResult -> targetLocation.stream()
            .anyMatch(targetFindPersonResult -> {
                var originNode = originFindPersonResult.node();
                var targetNode = originFindPersonResult.node();
                if (originNode.isEmpty() || targetNode.isEmpty()) {
                    return false;
                }
                return originFindPersonResult.locationGraph().getId() == targetFindPersonResult.locationGraph().getId()
                    && originNode.get().getId().equals(targetNode.get().getId());

            })
        );
        var applicable = fromPersonSameLocationGraphNode.getValue().equals("true");
        if (applicable) {
            return commonLocation;
        }
        return !commonLocation;
    }
}
