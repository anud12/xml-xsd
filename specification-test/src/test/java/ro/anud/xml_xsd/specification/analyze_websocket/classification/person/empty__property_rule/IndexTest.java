package ro.anud.xml_xsd.specification.analyze_websocket.classification.person.empty__property_rule;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;
import ro.anud.xml_xsd.websocket.tests.AnalyzeTest;

import java.util.Collection;
import java.util.List;

/*description
# Classify person without any properties and property_rule doesn't have a default value for people
## Given
  - declare property rule `attribute`
  - person without properties
  - classification rule requiring that attribute is equal to 10
## Then
  Person doesn't change.
 */

/*tags
- person
- classification
- property
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
