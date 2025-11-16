using System.Linq;
using System.Xml;
using Guiclient.util;
using util.dataStore;
using XSD;

namespace Guiclient.XSDWebsocketClient;

public class UpdateHandler
{
    public static void updateHandler(XSDWebSocketClient client, XSDWebSocketClient.Message message, DataStore<world_step> worldStep)
    {
        if (message.type != XSDWebSocketClient.ReceivedMessageType.update)
        {
            Logger.Info($"UpdateHandler: Ignoring message of type {message.type}");
            return;
        }
        var parts = message.data.Split("\n");
        var xPath = parts[0];
        var xmlString = parts[1];
        XmlDocument xmlDocument = new XmlDocument();
        xmlDocument.LoadXml(xmlString);
        var rawNode = new RawNode();
        rawNode.Deserialize(xmlDocument);
        var childXpath = xPath.Replace(".world_step[0]", "");
        var firstChildRawNode = rawNode.children.First().Value.First();
        if (firstChildRawNode == null)
        {
            Logger.Error($"UpdateHandler: No child found at path {childXpath}");
            return;
        }
        worldStep.QueueSet((worldStep) =>
        {
            Logger.Info($"UpdateHandler: Deserializing at path {childXpath}");
            worldStep.DeserializeAtPath(childXpath, firstChildRawNode);
            return worldStep;
        });
    }
}