using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.WebSockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Godot;
using Guiclient.XSDWebsocketClient;
using util.dataStore;
using XSD;

namespace Guiclient.XSDWebsocketClient;

public class XSDWebSocketClient
{
    public static DataStore<XSDWebSocketClient> instance = new(new());
    public bool Connected => ws.State == WebSocketState.Open;

    private static DataStore<world_step> worldStep = StoreWorld_Step.instance;

    private List<Message> _messageList = new ();

    public enum ReceivedMessageType
    {
        other,
        update,
        load,
        download,
    }

    public enum SendMessageType
    {
        download,
        startStop,
        start,
        load
    }

    private ClientWebSocket ws = new ClientWebSocket();
    private readonly List<String> _sendMessageList = new();

    private List<Action<XSDWebSocketClient, Message, DataStore<world_step>>> _messageHandlers = new()
    {
        UpdateHandler.updateHandler,
        DownloadHandler.downloadHandler,
        LoadHandler.loadHandler,
    };

    /* connect to localhost:8080 websocket endpoint */
    public XSDWebSocketClient Connect()
    {
        var uri = new Uri("ws://localhost:8080/ws");
        ws = new ClientWebSocket();
        ws.ConnectAsync(uri, CancellationToken.None).Wait();
        // spawn new thread to read messages from ws client
        Thread t = new Thread(() =>
        {
            try
            {
                GD.Print("XSDWebSocketClient Thread started");
                var buffer = new byte[1024];
                String messageString = "";
                while (ws.State == WebSocketState.Open)
                {
                    buffer = new byte[1024];
                    var result = ws.ReceiveAsync(buffer, CancellationToken.None).Result;
                    messageString += Encoding.UTF8.GetString(buffer);
                    if (result.EndOfMessage)
                    {
                        var messageObject = MessageFromString(messageString);
                        _messageList.Add(messageObject);
                        GD.Print("Message received: " + messageObject + " lenght " + messageString.Length);
                        foreach (var handler in _messageHandlers)
                        {
                            try
                            {
                                handler(this, messageObject, worldStep);
                            }
                            catch (Exception e)
                            {
                                GD.PrintErr(e);
                            }
                        }
                        buffer = new byte[1024];
                        messageString = "";
                    }

                }
                GD.Print("XSDWebSocketClient Returning");
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                GD.PrintErr(e);
            }
        });
        t.Start();
        return this;
    }


    private Message MessageFromString(string str)
    {
        var parts = str.Split("\n");
        try
        {
            var type = (ReceivedMessageType)Enum.Parse(typeof(ReceivedMessageType), parts[0]);
            return new Message(type, parts.Skip(1).Aggregate((a, b) => a + "\n" + b).Trim().Replace("\0", ""));
        }
        catch (ArgumentException)
        {
            return new Message(ReceivedMessageType.other, str);
        }
    }


    public record Message(ReceivedMessageType type, string data);

    public void SendStartStop()
    {
        GD.Print("Send StartTop");
        Send(SendMessageType.startStop + "\n");
    }

    private void Send(string message)
    {
        var messageBytes = Encoding.UTF8.GetBytes(message);
        ws.SendAsync(new ArraySegment<byte>(messageBytes),
            WebSocketMessageType.Text,
            true,
            CancellationToken.None
        );  
    }
    
    public void SendDownload()
    {
        GD.Print("Sending Download");
        // send message "download" to server
        var messageString = SendMessageType.download + "\n";
        var messageBytes = Encoding.UTF8.GetBytes(messageString);
        ws.SendAsync(new ArraySegment<byte>(messageBytes), WebSocketMessageType.Text, true,
            CancellationToken.None);
    }

    public void SendLoad(string taskResult)
    {
        var messageString = SendMessageType.load+"\n"+taskResult;
        Send(messageString);
    }
    public void SendStart()
    {
        var messageString = SendMessageType.start+"\n";
        Send(messageString);
    }

    public void Disconnect()
    {
        if (ws.State == WebSocketState.Open)
        {
            ws.CloseAsync(WebSocketCloseStatus.NormalClosure, "", CancellationToken.None);    
        }
        
    }
}