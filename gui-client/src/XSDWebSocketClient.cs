using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.WebSockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml;
using Godot;
using Guiclient.util;
using Guiclient.XSDWebsocketClient;
using Microsoft.CSharp.RuntimeBinder;
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
        load,
        put
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
                Logger.Info("XSDWebSocketClient Thread started");
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
                        Logger.Info("Message received: " + messageObject + " lenght " + messageString.Length);
                        foreach (var handler in _messageHandlers)
                        {
                            try
                            {
                                handler(this, messageObject, worldStep);
                            }
                            catch (Exception e)
                            {
                                Logger.Error(e);
                            }
                        }
                        buffer = new byte[1024];
                        messageString = "";
                    }

                }
                Logger.Info("XSDWebSocketClient Returning");
            }
            catch (Exception e)
            {
                Logger.Error(e);
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
        Logger.Info("Send StartTop");
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
        Logger.Info("Sending Download");
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

    public void SendNode(ILinkedNode parentNode, ILinkedNode node)
    {
        Logger.Info($"SendNode called with parentNode: {parentNode}, node: {node}");
        if (!parentNode.IsValidChildType(node))
        {
            Logger.Error("Invalid child node type. The provided node is not a valid child of the parent node.");
            throw new InvalidOperationException("The provided node is not a valid child of the parent node.");
        }
        
        var buildPath = parentNode.BuildPath() + node.BuildPath().Replace("[0]", "[new]");
        Logger.Info($"Sending update with buildPath: {buildPath}");
        this.SendPut(buildPath, node);
    }

    private void SendPut(string buildPath, ILinkedNode node)
    {
        Logger.Info($"SendUpdate called with buildPath: {buildPath}, node: {node}");

        var messageString = SendMessageType.put + "\n";
        messageString += buildPath + "\n";
        Logger.Info("Initialized messageString for update.");

        var document = new XmlDocument();
        XmlElement worldStepElement = document.CreateElement(node.NodeName);
        document.AppendChild(worldStepElement);
        Logger.Info("Created XmlDocument and world_step element.");

        Logger.Info("Serializing world step.");
        node.Serialize(worldStepElement);

        Logger.Info("Serializing node into raw node.");
        node.SerializeIntoRawNode();

        var stringWriter = new StringWriter();
        var xmlTextWriter = new XmlTextWriter(stringWriter);
        document.WriteTo(xmlTextWriter);
        xmlTextWriter.Flush();
        var documentString = stringWriter.GetStringBuilder().ToString();
        Logger.Info($"Serialized XML document: {documentString}");

        messageString += documentString;
        Logger.Info("Final messageString prepared, sending message.");
        Send(messageString);
    }
}