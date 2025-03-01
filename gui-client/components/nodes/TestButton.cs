using System.Collections.Generic;
using Godot;
using Guiclient.XSDWebsocketClient;

[Tool]
[GlobalClass]
public partial class TestButton : Button
{
    XSDWebSocketClient client = new XSDWebSocketClient();
    
    public override void _Ready()
    {
        Text = "Test Button";
        Connect("pressed", new Callable(this, MethodName.onPressed));

    }

    public void onPressed()
    {
        GD.Print("Button pressed");

        var dd = new List<string>(); 

        client.Connect();
        client.SendDownload();
    }

    
}