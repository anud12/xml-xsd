package ro.anud.xml_xsd.implementation.middleware.action;

import org.springframework.stereotype.Service;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.FromPerson.FromPerson;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.Mutations.Mutations;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.OnPerson;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.FromPersonSameLocationGraphNode.FromPersonSameLocationGraphNode;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Selection.Selection;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@Service
public class FromPersonAction {

    public static void apply(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            var ruleRepository = worldStepInstance.ruleRepository;
            var personRepository = worldStepInstance.person.repository;

            var fromPersonStream = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamFromPerson)
                    .toList();
            if (fromPersonStream.isEmpty()) {
                scope.log("fromPerson list is empty");
                return;
            }


            worldStepInstance.getOutInstance()
                    .streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamFromPerson)
                    .toList()
                    .forEach(FromPerson::removeFromParent);


            fromPersonStream.forEach(actionElement -> {
                try (var localLogger = logScope(actionElement.buildPath())){
                    localLogger.log("fromPersonRuleRef", actionElement.getFromPersonRuleRef());
                    localLogger.log("personIdRef", actionElement.getPersonIdRef());
                    var actionRuleOptional = ruleRepository.getPersonById(actionElement.getFromPersonRuleRef());
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
                        var result = worldStepInstance.person.selection.isSelectionApplicableTo(
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
                                try(var localLocalLogger = logScope()) {
                                    var onPersonRule = actionRule.getOnPerson();
                                    var targetPerson = personRepository.personById(onPerson.getPersonIdRef());
                                    if (onPersonRule.isEmpty() || targetPerson.isEmpty()) {
                                        localLocalLogger.log(
                                                "onPersonRule:", onPersonRule,
                                                "targetPerson", targetPerson
                                        );
                                        return;
                                    }
                                    if (!onPersonApplicable(
                                            worldStepInstance,
                                            selfPerson,
                                            targetPerson.get(),
                                            onPersonRule.get()
                                    )) {
                                        localLocalLogger.log("onPersonApplicable false");
                                        return;
                                    }
                                    Stream<Mutation<Person>> fromMutationResult = actionRule.streamMutations()
                                            .flatMap(Mutations::streamPropertyMutation)
                                            .map(typePropertyMutation -> worldStepInstance.person
                                                    .applyPropertyMutation(
                                                            selfPerson,
                                                            typePropertyMutation,
                                                            selfPerson,
                                                            targetPerson.get()
                                                    )
                                            );
                                    Stream<Mutation<Person>> onPersonMutationResult = onPersonRule.flatMap(OnPerson::getMutations)
                                            .stream()
                                            .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.OnPerson.Mutations.Mutations::streamPropertyMutation)
                                            .map(typePropertyMutation -> worldStepInstance
                                                    .person
                                                    .applyPropertyMutation(
                                                            targetPerson.get(),
                                                            typePropertyMutation,
                                                            targetPerson.get(),
                                                            selfPerson
                                                    )
                                            );

                                    Stream.concat(fromMutationResult, onPersonMutationResult)
                                            .forEach(mutation -> {
                                                mutation.apply(worldStepInstance.getOutInstance());
                                            });
                                }

                            });
                }

            });
        }

    }

    private static boolean onPersonApplicable(
        final WorldStepInstance worldStepInstance,
        final Person originPerson,
        final Person targetPerson,
        final OnPerson onPersonRule) {
        try (var scope = logScope("originPerson", originPerson.getId(), "targetPerson", targetPerson.getId())){
            var selection = onPersonRule.getSelection();
            if (selection.isEmpty()) {
                return true;
            }
            var isNotFromSameLocation = selection.flatMap(Selection::getFromPersonSameLocationGraphNode)
                    .map(fromPersonSameLocationGraphNode -> !isFromPersonSameLocationGraphNode(
                            worldStepInstance,
                            originPerson,
                            targetPerson,
                            fromPersonSameLocationGraphNode)
                    )
                    .orElse(false);

            if (isNotFromSameLocation) {
                scope.log("isNotFromSameLocation");
                return scope.logReturn(false);

            }
            var selectionInstance = worldStepInstance.person.selection;
            var invalidSelectionList = selection
                    .stream()
                    .filter(selection1 -> !selectionInstance.isSelectionApplicableTo(
                            selection1,
                            targetPerson)
                    )
                    .findAny();

            if (invalidSelectionList.isPresent()) {
                scope.log("invalid selection found");
                return scope.logReturn(false);
            }
            return scope.logReturn(true);
        }

    }

    private static boolean isFromPersonSameLocationGraphNode(
        final WorldStepInstance worldStepInstance,
        final Person selfPerson,
        final Person targetPerson,
        final FromPersonSameLocationGraphNode fromPersonSameLocationGraphNode) {
        try (var scope = logScope()){
            var locationGraphInstance = worldStepInstance.locationGraph;
            var originLocation = locationGraphInstance.findPersonLocation(selfPerson.getId());
            var targetLocation = locationGraphInstance.findPersonLocation(targetPerson.getId());

            if (originLocation.isEmpty() || targetLocation.isEmpty()) {
                scope.log("originLocation or targetLocation is empty");
                return scope.logReturn(false);
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
                return scope.logReturn(commonLocation);
            }
            return scope.logReturn(!commonLocation);
        }

    }
}
