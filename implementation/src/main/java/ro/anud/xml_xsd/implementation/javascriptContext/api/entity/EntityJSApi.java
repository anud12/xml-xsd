package ro.anud.xml_xsd.implementation.javascriptContext.api.entity;

import org.graalvm.polyglot.HostAccess;
import ro.anud.xml_xsd.implementation.javascriptContext.JavascriptRunner;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class EntityJSApi {

    private final JavascriptRunner javascriptRunner;

    public JavascriptRunner getJavascriptRunner() {
        return javascriptRunner;
    }

    public EntityJSApi(JavascriptRunner javascriptRunner) {
        this.javascriptRunner = javascriptRunner;
    }

    @HostAccess.Export
    public EntityJSView getById(String id) {
        return new EntityJSView(this.javascriptRunner, id);
    }


}
