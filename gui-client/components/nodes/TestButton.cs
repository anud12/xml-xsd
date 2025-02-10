using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.WebSockets;
using System.Xml;
using Godot;
using util.dataStore;
using util.repository;
using XSD;
using XSD.Nworld_step.Ndata.Nlocation;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph;
using XSD.Nworld_step.Ndata.Npeople;

[Tool]
[GlobalClass]
public partial class TestButton : Button
{
    MyWebsocketClient client = new MyWebsocketClient();
    private static DataStore<world_step> worldStep = StoreWorld_Step.instance;

    public override void _Ready()
    {
        Text = "Test Button";
        Connect("pressed", new Callable(this, MethodName.onPressed));

    }

    public void onPressed()
    {
        GD.Print("Button pressed");

        var dd = new List<string>(); 

        client.connect().OnMessageReceived((message) =>
        {
            updateHandler(message);
            downloadHandler(message);
        });
    }

    private static void updateHandler(MyWebsocketClient.Message message)
    {
        if (message.type != MyWebsocketClient.ReceivedMessageType.update)
        {
            return;
        }
        var parts = message.data.Split("\n");
        var classTypeId = parts[0];
        var xmlString = parts[1];
        XmlDocument xmlDocument = new XmlDocument();
        xmlDocument.LoadXml(xmlString);
        if (person.ClassTypeId == classTypeId)
        {
            var instance = new person(xmlDocument.DocumentElement);
            Repository<object>.Person.Add(instance);
            return;
        }

        if (node.ClassTypeId == classTypeId)
        {
            var instance = new node(xmlDocument.DocumentElement);
            Repository<object>.Node.Add(instance);
            return;
        }

        if (location_graph.ClassTypeId == classTypeId)
        {
            var instance = new location_graph(xmlDocument.DocumentElement);
            Repository<object>.LocationGraph.Add(instance);
            return;
        }
    }

    private static void downloadHandler(MyWebsocketClient.Message message)
    {
        if (message.type != MyWebsocketClient.ReceivedMessageType.download)
        {
            return;
        }
        var xmlString = message.data;
        XmlDocument xmlDocument = new XmlDocument();
        xmlDocument.LoadXml(xmlString);
        var instance = new world_step(xmlDocument.DocumentElement);
        Repository<object>.Person.Reindex(instance);
        Repository<object>.Node.Reindex(instance);
        Repository<object>.LocationGraph.Reindex(instance);
        worldStep.data = instance;
    }

    public class MyWebsocketClient
    {

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
        }

        private ClientWebSocket ws = new ClientWebSocket();
        private List<Message> _messageList = new List<Message>();
        private List<Action<Message>> _messageHandlers = new List<Action<Message>>();

        /* connect to localhost:8080 websocket endpoint */
        public MyWebsocketClient connect()
        {
            var uri = new System.Uri("ws://localhost:8080/ws");
            ws = new System.Net.WebSockets.ClientWebSocket();
            ws.ConnectAsync(uri, System.Threading.CancellationToken.None).Wait();

            // send message "download" to server
            var messageString = SendMessageType.download + "\n";
            var messageBytes = System.Text.Encoding.UTF8.GetBytes(messageString);
            ws.SendAsync(new ArraySegment<byte>(messageBytes), WebSocketMessageType.Text, true, System.Threading.CancellationToken.None);

            // spawn new thread to read messages from ws client
            System.Threading.Thread t = new System.Threading.Thread(() =>
            {
                GD.Print("Thread started");
                var buffer = new byte[1024];
                String messageString = "";
                while (true)
                {
                    var result = ws.ReceiveAsync(buffer, System.Threading.CancellationToken.None).Result;
                    messageString += System.Text.Encoding.UTF8.GetString(buffer);
                    if (result.EndOfMessage)
                    {
                        var messageObject = MessageFromString(messageString);
                        _messageList.Add(messageObject);
                        GD.Print("Message received: " + messageObject);
                        foreach (var handler in _messageHandlers)
                        {
                            handler(messageObject);
                        }
                        messageString = ""; ;
                    }
                }
            });
            t.Start();
            return this;
        }

        public void OnMessageReceived(Action<Message> action)
        {
            _messageHandlers.Add(action);
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
    }
}