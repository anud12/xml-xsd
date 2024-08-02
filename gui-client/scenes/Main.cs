using Godot;
using System;
using System.Net.WebSockets;
using System.Text;
using System.Threading;
public partial class Main : Control
{
	// Called when the node enters the scene tree for the first time.
	public override void _Ready()
	{
		using (ClientWebSocket ws = new ClientWebSocket())
        {
            Uri serverUri = new Uri("ws://localhost:8080");
            ws.ConnectAsync(serverUri, CancellationToken.None).Wait();
            GD.Print("Connected to the server");

            string message = "Hello from C#";
            ArraySegment<byte> bytesToSend = new ArraySegment<byte>(Encoding.UTF8.GetBytes(message));
            ws.SendAsync(bytesToSend, WebSocketMessageType.Text, true, CancellationToken.None).Wait();
            GD.Print($"Sent: {message}");

            ArraySegment<byte> bytesReceived = new ArraySegment<byte>(new byte[1024]);
            WebSocketReceiveResult result = ws.ReceiveAsync(bytesReceived, CancellationToken.None).Result;
            string receivedMessage = Encoding.UTF8.GetString(bytesReceived.Array, 0, result.Count);
            GD.Print($"Received: {receivedMessage}");

            ws.CloseAsync(WebSocketCloseStatus.NormalClosure, "Closing", CancellationToken.None).Wait();
            GD.Print("Connection closed");
        }
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}
}
