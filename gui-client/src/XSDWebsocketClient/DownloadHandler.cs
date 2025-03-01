using System.Xml;
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
        var instance = new world_step(xmlDocument.DocumentElement);
        worldStep.QueueSet(instance);
    }
}