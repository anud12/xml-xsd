package ro.anud.xml_xsd.specification.analyze.name_rule.name_token.one_of;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

import static ro.anud.xml_xsd.specification.HttpRequestTest.Endpoints.analyzeExecuteNameRule;

/*description
# `name_rule` `name_token` `one_of`

The name_rule is used to generate a string based on the name_token elements it contains.
The prefix attribute of a name_token is a string that is added to the beginning of the generated string.
The one_of list is a feature that allows for the selection of one name_token from a list.

## Given
During the execution phase when
  - An XML input with a 'name_rule' defined
  - The 'name_rule' contains a 'name_token' with a 'one_of' list
  - a name_rule is defined with an entry that contains a name_token.
This name_token has a prefix attribute with the value "prefix" and a one_of list
that contains another name_token with a prefix attribute of "first one_of".

## Then
  - The function 'executeFromStringToString' should correctly interpret the '--name_rule' parameter
  - It should execute the rule and produce the expected output
  - The output should match the expected result, by concatenating the prefix of the outer name_token ("prefix"), the prefix of
the selected name_token from the one_of list ("first one_of"). This results in the string "prefixfirst one_of".
 */

/*tags
- name_rule
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass(), analyzeExecuteNameRule("name_rule"));
    }
}
