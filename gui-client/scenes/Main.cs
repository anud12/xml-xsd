using dataStore;
using Dependencies;
using Godot;
using System;
using System.Net.WebSockets;
using System.Text;
using System.Threading;
public partial class Main : Control
{
    public static PackedScene PackedScene = GD.Load<PackedScene>("res://scenes/Main.tscn");
    public LoadWorldStep loadWorldStep;

    // Called when the node enters the scene tree for the first time.
    public override void _Ready()
    {
        var load = GetNode<Button>("%LoadFromDisk");
        this.loadWorldStep = new LoadWorldStep(this);

        load.Pressed += () =>
        {
            var path = GetNode<TextEdit>("%FilePathInput").Text;
            GD.Print("Loading world step from " + path);
            StoreWorld_Step.instance.data = loadWorldStep.deserializeFromPath(path);
            GetTree().ChangeSceneToPacked(SelectMainPerson.PackedScene);
        };
        NodeDependency.ReadFromOs();
        var startServer = GetNode<Button>("%StartServerButton");
        startServer.Pressed += () =>
        {
            NodeDependency.Start();
        };
        var serverStatusLabel = GetNode<Label>("%ServerStatusLabel");
        NodeDependency.isRunning.OnSet((isRunning, unsubscribe) =>
        {
            if(isRunning == true)
            {
                serverStatusLabel.Text = "Running";
            }
            else
            {
                serverStatusLabel.Text = "Stopped";
            }
        });
    }


    // Called every frame. 'delta' is the elapsed time since the previous frame.
    public override void _Process(double delta)
    {
    }
}
