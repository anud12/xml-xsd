using Godot;
using System;
using Guiclient.util;
using Guiclient.XSDWebsocketClient;
using util.dataStore;

public partial class ServerControls : PanelContainer
{
	private DataStore<XSDWebSocketClient> _client = XSDWebSocketClient.instance;
	public static PackedScene PackedScene = GD.Load<PackedScene>("res://scenes/ServerControls.tscn");
	private CheckButton? _connectButton;
	
	// Called when the node enters the scene tree for the first time.
	public override void _Ready()
	{
		_connectButton = GetNode<CheckButton>("%ConnectButton"); 
		_connectButton.Pressed += () =>
		{
			if (!(_client.data?.Connected ?? false))
			{
				_client.data?.Connect();
			}
			else
			{
				_client.data?.Disconnect();
			}
			
		};
		GetNode<Button>("%StartStopButton").Pressed += () =>
		{
			_client.data?.SendStartStop();
		};
		GetNode<Button>("%DownloadButton").Pressed += () =>
		{
			_client.data?.SendDownload();
		};
		GetNode<Button>("%LoadButton").Pressed += () =>
		{
			GD.Print("Load clicked");
			LoadFileFromDisk.AsString(this).ContinueWith(task =>
			{
				GD.Print("file returned");
				_client.data?.SendLoad(task.Result);
			});
		};
		GetNode<Button>("%StartButton").Pressed += () =>
		{
			_client.data?.SendStart();
		};
	}
	
	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
		if (_connectButton != null)
		{
			_connectButton.ButtonPressed = _client.data?.Connected ?? false;			
		}
		
	}
}
