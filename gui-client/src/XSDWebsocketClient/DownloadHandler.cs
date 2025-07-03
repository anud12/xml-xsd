using System.Linq;
using System.Xml;
using Guiclient.util;
using util.dataStore;
using XSD;

namespace Guiclient.XSDWebsocketClient;
public class DownloadHandler
{
    public static void downloadHandler(XSDWebSocketClient client, XSDWebSocketClient.Message message, DataStore<world_step> worldStep)
    {
        if (message.type != XSDWebSocketClient.ReceivedMessageType.download)
        {
            return;
        }
        var xmlString = message.data;
        XmlDocument xmlDocument = new XmlDocument();
        xmlDocument.LoadXml(xmlString);
        var rawNode = new RawNode();
        rawNode.Deserialize(xmlDocument);
        var firstChildRawNode = rawNode.children.First().Value.First();
        worldStep.QueueSet(step =>
        {
            if (step == null)
            {
                return new world_step(xmlDocument.DocumentElement);
            }
            step.DeserializeAtPath("./", firstChildRawNode);
            return step;
        });
    }
}