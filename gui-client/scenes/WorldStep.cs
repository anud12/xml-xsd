using Godot;
using System;
using System.Collections.Generic;
using System.Linq;

public partial class WorldStep : Control
{
	public static PackedScene PackedScene = GD.Load<PackedScene>("res://scenes/WorldStep.tscn");
	// Called when the node enters the scene tree for the first time.

	private List<Action> unsubscribeList = new List<Action>();

	public override void _Ready()
	{
		addLocationGraph();
		addMainPersonData();
		initializeMenuButton();
	}

	private void addMainPersonData()
	{
		var mainPersonContainer = GetNode<Control>("%MainPersonContainer");
		var mainPersonData = PersonComponent.PackedScene.Instantiate<PersonComponent>();
		unsubscribeList.Add(() => mainPersonData.ClearSubscriptions());
		mainPersonData.AnchorLeft = 1;
		mainPersonData.AnchorRight = 1;
		mainPersonData.AnchorBottom = 1;
		mainPersonData.AnchorTop = 1;
		mainPersonContainer.AddChild(mainPersonData);
		StoreWorld_Step.instance.OnSave((data, unsubscribe) =>
		{
			if(IsInstanceValid(this) == false) {
				unsubscribe();
				return;
			}
			StoreSession.mainPersonId.OnSave((mainPersonId, unsubscribe) =>
			{
				if(IsInstanceValid(this) == false) {
					unsubscribe();
					return;
				}
				mainPersonData.initializeFromId(mainPersonId);

			});
		});
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}

	public void ClearSubscriptions()
	{
		unsubscribeList.ForEach(unsubscribe => unsubscribe());
		unsubscribeList.Clear();
	}

	private void initializeMenuButton()
	{

		var menuButton = GetNode<Button>("%MenuButton");
		menuButton.Pressed += () =>
		{
			ClearSubscriptions();
			GetTree().ChangeSceneToPacked(Main.PackedScene);
		};
	}


	private void addLocationGraph()
	{
		StoreWorld_Step.instance.OnSave((worldStep, unsubscribe) =>
		{
			if(IsInstanceValid(this) == false) {
				unsubscribe();
				return;
			}
			//read location graphs from world_step and add buttons for each into LocationGraphList node
			var locationGraphList = GetNode<Control>("%LocationGraphList");

			//clear LocationGraphList
			locationGraphList.GetChildren().ToList().ForEach(child => locationGraphList.RemoveChild(child));
			worldStep?.location_graph?.ForEach(locationGraph =>
			{
				var button = new Button();
				button.Text = locationGraph.id;
				button.Pressed += () =>
				{
					//clear LocationGraphSceneContainer
					var locationGraphSceneContainer = GetNode<Control>("%LocationGraphSceneContainer");
					locationGraphSceneContainer.GetChildren().ToList().ForEach(child => locationGraphSceneContainer.RemoveChild(child));


					//instantiate new LocationGraphScene from packed scene and add locationGrapId

					var locationGraphScene = LocationGraphScene.PackedScene.Instantiate<LocationGraphScene>();

					locationGraphScene.setLocationGraphId(locationGraph.id);
					unsubscribeList.Add(() => locationGraphScene.ClearSubscriptions());

					//add LocationGraphScene to LocationGraphSceneContainer
					GetNode<Control>("%LocationGraphSceneContainer").AddChild(locationGraphScene);
				};
				locationGraphList.AddChild(button);
			});
		});
	}
}
