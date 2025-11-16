using Godot;
using System;
using System.Linq;
using System.Reflection.Metadata;
using System.Xml;
using System.Xml.Serialization;
using Guiclient.util;

public partial class WorldStep2 : Godot.Node
{
	// Called when the node enters the scene tree for the first time.

	public LoadWorldStep? loadWorldStep;

	public WorldStep2() {
	}

	public override void _Ready()
	{
		loadWorldStep = new LoadWorldStep(GetNode<Node>("%WorldContainer"));
		Logger.Info("Hello, World! 2");
		
		var load = GetNode<Button>("./UI/Load");
		
		load.Pressed += () => _on_Load_pressed();

		var addChild = AddChild;
	}

	public void _on_Load_pressed()
	{
		var path = GetNode<TextEdit>("./UI/Path").Text;
		
		// var worldStep = LoadWorldStep.load(path);

		Logger.Info("Loading world step from " + path);

		loadWorldStep?.loadFromPath(path);
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}
}
