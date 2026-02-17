package ro.anud.xml_xsd.implementation.service.entity.repository;

import ro.anud.xml_xsd.implementation.javascriptContext.api.entity.ContainerQueryJSApi;

import java.util.List;
import java.util.function.UnaryOperator;

public interface EntityQuery {
    List<String> getIdList();
    List<String> getRuleIdList();
    List<UnaryOperator<ContainerQueryJSApi>> getContainer();
}