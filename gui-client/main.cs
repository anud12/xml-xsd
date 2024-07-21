using Godot;
using System;
using System.Linq;
using System.Reflection.Metadata;
using System.Xml;
using System.Xml.Serialization;

public partial class main : Godot.Node
{
	// Called when the node enters the scene tree for the first time.
	public override void _Ready()
	{
		System.Console.WriteLine("Hello, World! 1");
		GD.Print("Hello, World! 2");
		
		var load = GetNode<Button>("./UI/Load");
		
		load.Pressed += () => _on_Load_pressed();
	}

	public void _on_Load_pressed()
	{
		var path = GetNode<TextEdit>("./UI/Path").Text;
		
		// var worldStep = LoadWorldStep.load(path);

		GD.Print("Loading world step from " + path);

		LoadWorldStep.load(path).ToList().ForEach(child => AddChild(child));
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}
}
