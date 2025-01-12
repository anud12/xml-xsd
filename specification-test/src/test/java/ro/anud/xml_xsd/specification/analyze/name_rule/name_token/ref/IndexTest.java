package ro.anud.xml_xsd.specification.analyze.name_rule.name_token.ref;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

import static ro.anud.xml_xsd.specification.HttpRequestTest.Endpoints.analyzeExecuteNameRule;

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass(), analyzeExecuteNameRule("name_rule"));
    }
}
