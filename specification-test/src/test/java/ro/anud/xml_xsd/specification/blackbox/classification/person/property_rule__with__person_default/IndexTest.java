package ro.anud.xml_xsd.specification.blackbox.classification.person.property_rule__with__person_default;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Classify person
## Given
During classification phase when
  - declare property rule `attribute` with `person_default` random value that:
    - starts at 10
    - adds a random value from 0 to 100
  - 3 person without properties
  - classification rule requiring that attribute is equal or more than 10
## Then
  - Offset randomization table by 1

  - On person:
    - add classification `classification`
    - add property `attribute` for each person with value:
      - first person: 35
      - second person: 60
      - third person: 85
 */
/*tags
- person
- classification
- property
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
