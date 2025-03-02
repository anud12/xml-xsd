using System;
using GdUnit4;
using Guiclient.XSDWebsocketClient;
using util.dataStore;
using XSD;

[TestSuite]
public class UpdateHandlerTest
{
    [TestCase]
    public void updateHandler()
    {
        var message = new XSDWebSocketClient.Message(XSDWebSocketClient.ReceivedMessageType.update,
            """
             .world_step[0].data[0].people[0].person[0]
             <person id="0" name="BillyWithVeryLongName"><properties><property property_rule_ref="health" value="10"/></properties><classifications><classification classification_rule_ref="alive"/></classifications></person>
             """);

        var dataStore = new DataStore<world_step>();

        dataStore.data = new world_step();
        
        UpdateHandler.updateHandler(null, message, dataStore);

        var resultObject = dataStore.data.data.people.person[0];
        
        Assertions.AssertString(resultObject.id).IsEqual("0");
        Assertions.AssertString(resultObject.name).IsEqual("BillyWithVeryLongName");
        Assertions.AssertString(resultObject.properties.property[0].property_rule_ref).IsEqual("health");
    }
}