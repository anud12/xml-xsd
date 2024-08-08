using Godot;
using System;

public partial class SelectMainPerson : Control
{
	public static PackedScene PackedScene = GD.Load<PackedScene>("res://scenes/SelectMainPerson.tscn");

	// Called when the node enters the scene tree for the first time.
	public override void _Ready()
	{
		
		//get personContainer
		var personContainer = GetNode<Control>("%PersonContainer");

		//get worldStep from WorldStepStore
		var worldStep = StoreWorld_Step.instance.data;

		//iterate through worldStep and create a button for each person
		worldStep?.people?.ForEach(personList =>
		{
			personList?.person.ForEach(person =>
			{
				var button = new Button();
				button.Text = $"{person.name}({person.id})";
				button.Pressed += () =>
				{
					StoreSession.mainPersonId.data = person.id;
					GetTree().ChangeSceneToPacked(WorldStep.PackedScene);
				};
				personContainer.AddChild(button);
			});
		});
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}
}
