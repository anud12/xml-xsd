using GdUnit4;
using XSD;
using XSD.Nworld_step;
using XSD.Nworld_step.Nrule_group.Nproperty_rule;

namespace Examples;

/// <summary>
/// Test suite for testing the SetXPath functionality.
/// </summary>
[TestSuite]
public class DeserializeAtPathTests
{
    /// <summary>
    /// Test using children that aren't lists
    /// </summary>
    [TestCase]
    public void NoList()
    {
        //setup initial value
        var worldStep = new world_step()
        {
            world_metadata = new()
            {
                counter = new()
                {
                    value = 0
                }
            }
        };

        //assert initial state
        Assertions.AssertInt(worldStep.world_metadata.counter.value).IsEqual(0);

        //build changed object
        world_metadata receivedWorldMetadata = new()
        {
            counter = new()
            {
                value = 1
            }
        };

        //update inital value with given instance at specific xpath
        worldStep.DeserializeAtPath("world_metadata[0]", receivedWorldMetadata.SerializeIntoRawNode());

        //assert expected state
        Assertions.AssertInt(worldStep.world_metadata.counter.value).IsEqual(1);
    }

    /// <summary>
    /// Test using by adding out of order
    /// </summary>
    [TestCase]
    public void ListOutOfOrder()
    {
        //setup initial value
        var worldStep = new world_step()
        {
            rule_group = new()
            {
                new()
                {
                    property_rule = new()
                    {
                        entry = new()
                        {
                            new()
                            {
                                id = "property_id_0"
                            }
                        }
                    }
                }
            }
        };

        //assert initial state
        Assertions.AssertInt(worldStep.rule_group[0].property_rule.entry.Count).IsEqual(1);
        Assertions.AssertString(worldStep.rule_group[0].property_rule.entry[0].id).IsEqual("property_id_0");

        //build changed object
        entry entry = new()
        {
            id = "property_id_3"
        };

        //update inital value with given instance at specific xpath
        worldStep.DeserializeAtPath("rule_group[0].property_rule[0].entry[3]", entry.SerializeIntoRawNode());

        //assert expected state
        Assertions.AssertInt(worldStep.rule_group[0].property_rule.entry.Count).IsEqual(2);
        Assertions.AssertString(worldStep.rule_group[0].property_rule.entry[3].id).IsEqual("property_id_3");
    }
    
    /// <summary>
    /// Test using by adding out of with 3 digit number
    /// </summary>
    [TestCase]
    public void ListOutOfOrder3DigitNumber()
    {
        //setup initial value
        var worldStep = new world_step()
        {
            rule_group = new()
            {
                new()
                {
                    property_rule = new()
                    {
                        entry = new()
                        {
                            new()
                            {
                                id = "property_id_0"
                            }
                        }
                    }
                }
            }
        };

        //assert initial state
        Assertions.AssertInt(worldStep.rule_group[0].property_rule.entry.Count).IsEqual(1);
        Assertions.AssertString(worldStep.rule_group[0].property_rule.entry[0].id).IsEqual("property_id_0");

        //build changed object
        entry entry = new()
        {
            id = "property_id_100"
        };

        //update inital value with given instance at specific xpath
        worldStep.DeserializeAtPath("rule_group[0].property_rule[0].entry[100]", entry.SerializeIntoRawNode());

        //assert expected state
        Assertions.AssertInt(worldStep.rule_group[0].property_rule.entry.Count).IsEqual(2);
        Assertions.AssertString(worldStep.rule_group[0].property_rule.entry[100].id).IsEqual("property_id_100");
    }
}