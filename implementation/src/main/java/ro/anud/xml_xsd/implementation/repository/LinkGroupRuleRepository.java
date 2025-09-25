package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.LinkGroupRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.Subscription;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class LinkGroupRuleRepository {

    private final WorldStepInstance worldStepInstance;
    private Optional<Subscription> subscription = Optional.empty();
    private HashMap<String, LinkGroupRule> map = new HashMap<>();

    public LinkGroupRuleRepository(WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            this.worldStepInstance = worldStepInstance;
        }
    }

    public void index() {
        try (var scope = logScope()) {
            subscription.ifPresent(Subscription::unsubscribe);
            subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange(objects -> {
                scope.logTodo("Streamline checking");
                if (objects.stream().map(Object::getClass).anyMatch(o -> o.equals(LinkGroupRuleList.class))) {
                    loadData();
                }
            }));
            loadData();
        }

    }

    private void loadData() {
        try (var scope = logScope()) {
            map.clear();
            worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamRuleGroup)
                .flatMap(RuleGroup::streamLinkGroupRuleList)
                .flatMap(LinkGroupRuleList::streamLinkGroupRule)
                .forEach(linkGroupRule -> {
                    map.put(linkGroupRule.getId(), linkGroupRule);
                });
        }
    }
    public Optional<LinkGroupRule> getById(String id) {
        try (var scope = logScope("Get LinkGroupRule by id: " + id)) {
            return scope.logReturn(Optional.ofNullable(map.get(id)));
        }
    }

    public Stream<LinkGroupRule> streamById(String id) {
        try (var scope = logScope("Stream LinkGroupRule by id: " + id)) {
            return scope.logReturn(getById(id).stream());
        }
    }
}
