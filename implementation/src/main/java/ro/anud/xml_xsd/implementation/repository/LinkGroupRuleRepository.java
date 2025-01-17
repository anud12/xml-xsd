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

public class LinkGroupRuleRepository {

    private final WorldStepInstance worldStepInstance;
    private Optional<Subscription> subscription = Optional.empty();
    private HashMap<String, LinkGroupRule> map = new HashMap<>();

    public LinkGroupRuleRepository(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    public void index() {
        var logger = logEnter("LinkGroupRuleRepository indexing");
        subscription.ifPresent(Subscription::unsubscribe);
        subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange(objects -> {
            logger.logTodo("Streamline checking");
            if (objects.stream().map(Object::getClass).anyMatch(o -> o.equals(LinkGroupRuleList.class))) {
                loadData();
            }
        }));
        loadData();
    }

    private void loadData() {
        var logger = logEnter();
        map.clear();
        worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamRuleGroup)
            .flatMap(RuleGroup::streamLinkGroupRuleList)
            .flatMap(LinkGroupRuleList::streamLinkGroupRule)
            .forEach(linkGroupRule -> {
                map.put(linkGroupRule.getId(), linkGroupRule);
            });
        logger.logReturnVoid();
    }
    public Optional<LinkGroupRule> getById(String id) {
        return logEnter().logReturn(Optional.ofNullable(map.get(id)));
    }

    public Stream<LinkGroupRule> streamById(String id) {
        return logEnter().logReturn(getById(id).stream());
    }
}
