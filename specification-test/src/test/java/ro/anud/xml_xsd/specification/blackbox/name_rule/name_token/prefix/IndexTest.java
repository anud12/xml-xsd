package ro.anud.xml_xsd.specification.blackbox.name_rule.name_token.prefix;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

import static ro.anud.xml_xsd.specification.RequestTest.Endpoints.analyzeExecuteNameRule;

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass(), analyzeExecuteNameRule("name_rule"));

    }
}
