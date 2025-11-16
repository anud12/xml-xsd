using util.dataStore;
using Dependencies;
using Godot;
using System;
using System.Net.WebSockets;
using System.Text;
using System.Threading;
using Guiclient.util;

public partial class MainScene : Control
{
    public static PackedScene PackedScene = GD.Load<PackedScene>("res://scenes/MainScene.tscn");
    public LoadWorldStep loadWorldStep;

    // Called when the node enters the scene tree for the first time.
    public override void _Ready()
    {
        var load = GetNode<Button>("%LoadFromDisk");
        this.loadWorldStep = new LoadWorldStep(this);

        load.Pressed += () =>
        {
            var path = GetNode<TextEdit>("%FilePathInput").Text;
            Logger.Info("Loading world step from " + path);
            StoreWorld_Step.instance.data = loadWorldStep.deserializeFromPath(path);
            GetTree().ChangeSceneToPacked(WorldStepScene.PackedScene);
        };
    }


    // Called every frame. 'delta' is the elapsed time since the previous frame.
    public override void _Process(double delta)
    {
    }
}
