package ro.anud.xml_xsd.implementation.javascriptContext.api.entity;

import lombok.Getter;
import lombok.ToString;
import org.graalvm.polyglot.HostAccess;
import ro.anud.xml_xsd.implementation.service.entity.repository.EntityQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@ToString
@Getter
public class EntityQueryJSApi implements EntityQuery {

    private final List<String> idList = new ArrayList<>();
    private final List<String> ruleIdList = new ArrayList<>();
    private final List<UnaryOperator<ContainerQueryJSApi>> container = new ArrayList<>();
    @HostAccess.Export
    public EntityQueryJSApi byId(String ...idArray) {
        try (var scope = logScope()){
            Collections.addAll(idList, idArray);
            return this;
        }

    }
    @HostAccess.Export
    public EntityQueryJSApi byRuleId(String ...idArray) {
        try (var scope = logScope()){
            Collections.addAll(ruleIdList, idArray);
            return this;
        }
    }

    @HostAccess.Export
    public EntityQueryJSApi inContainer(UnaryOperator<ContainerQueryJSApi> arg) {
        try (var scope = logScope()){
            container.add(arg);
            return this;
        }
    }
}
