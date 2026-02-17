package ro.anud.xml_xsd.implementation.javascriptContext.api.entity;

import lombok.Getter;
import org.graalvm.polyglot.HostAccess;
import ro.anud.xml_xsd.implementation.service.entity.repository.ContainerQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@Getter
public class ContainerQueryJSApi implements ContainerQuery {

    public final static ContainerQueryJSApi EMPTY = new ContainerQueryJSApi();

    private final List<String> idList = new ArrayList<>();
    private final List<String> ruleIdList = new ArrayList<>();

    @HostAccess.Export
    public ContainerQueryJSApi byId(String ...idArray) {
        try (var scope = logScope()){
            Collections.addAll(idList, idArray);
            return this;
        }
    }

    @HostAccess.Export
    public ContainerQueryJSApi byRuleId(String ...idArray) {
        try (var scope = logScope()){
            Collections.addAll(ruleIdList, idArray);
            return this;
        }
    }
}
