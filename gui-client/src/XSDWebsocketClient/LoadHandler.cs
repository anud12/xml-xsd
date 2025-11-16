using System.Linq;
using System.Xml;
using util.dataStore;
using XSD;

namespace Guiclient.XSDWebsocketClient;

public class LoadHandler
{
    public static void loadHandler(XSDWebSocketClient client, XSDWebSocketClient.Message message, DataStore<world_step> worldStep)
    {
        if (message.type != XSDWebSocketClient.ReceivedMessageType.load)
        {
            return;
        }
        client.SendDownload();
    }
}