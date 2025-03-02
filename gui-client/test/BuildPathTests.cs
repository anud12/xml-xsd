using GdUnit4;
using XSD;
using XSD.Nworld_step;
using XSD.Nworld_step.Nrule_group;
using XSD.Nworld_step.Nrule_group.Nproperty_rule;

namespace Examples;

/// <summary>
/// Test suite for testing the BuildPath functionality.
/// </summary>
[TestSuite]
public class BuildPathTests
{
    [TestCase]
    public void Root()
    {
        //setup initial value
        var worldStep = new world_step {};
        
        
        //assert initial state
        Assertions.AssertString(((ILinkedNode)worldStep).BuildPath()).IsEqual(".world_step[0]");
    }
    
    
    [TestCase]
    public void DeepSingle()
    {
        //setup initial value
        var worldStep = new world_step
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
        Assertions.AssertString(((ILinkedNode)worldStep.world_metadata.counter).BuildPath()).IsEqual(".world_step[0].world_metadata[0].counter[0]");
    }
    
    [TestCase]
    public void DeepList()
    {
        //setup initial value
        var worldStep = new world_step
        {
            rule_group = new ()
            {
                new rule_group(),
                new rule_group(),
                new rule_group
                {
                    property_rule = new property_rule()
                    {
                        entry = new ()
                        {
                            new entry(),
                            new entry()
                        }
                    }
                }
            }
        };
        
        
        //assert initial state
        Assertions.AssertString(((ILinkedNode)worldStep.rule_group[2].property_rule.entry[1]).BuildPath()).IsEqual(".world_step[0].rule_group[2].property_rule[0].entry[1]");
    }
}