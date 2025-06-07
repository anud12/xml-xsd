using Godot;
using System;
using System.Collections.Generic;
using System.Linq;
using util.dataStore;

public partial class WorldStepScene : Control
{
	public static PackedScene PackedScene = GD.Load<PackedScene>("res://scenes/WorldStepScene.tscn");
	// Called when the node enters the scene tree for the first time.

	private List<Action> unsubscribeList = new List<Action>();

	public override void _Ready()
	{
		addLocationGraph();
		addMainPersonData();
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
		StoreWorld_Step.instance.OnSet((data, unsubscribe) =>
		{
			if(IsInstanceValid(this) == false) {
				unsubscribe();
				return;
			}
			StoreSession.mainPersonId.OnSet((mainPersonId, unsubscribe) =>
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



	private void addLocationGraph()
	{
		StoreWorld_Step.instance.OnSet((worldStep, unsubscribe) =>
		{
			if(IsInstanceValid(this) == false) {
				unsubscribe();
				return;
			}
			//read location graphs from world_step and add buttons for each into LocationGraphList node
			var locationGraphList = GetNode<Control>("%LocationGraphList");

			//clear LocationGraphList
			locationGraphList.GetChildren().ToList().ForEach(child => locationGraphList.RemoveChild(child));
			var rootLocationGraphNode = GetNode<ButtonWithDropdownNode>("%RootLocationGraph");
			rootLocationGraphNode.options.Clear();
			rootLocationGraphNode.OnClick(locationGraphId =>
			{
					//clear LocationGraphSceneContainer
					var locationGraphSceneContainer = GetNode<Control>("%LocationGraphSceneContainer");
					locationGraphSceneContainer.GetChildren().ToList().ForEach(child => locationGraphSceneContainer.RemoveChild(child));


					//instantiate new LocationGraphScene from packed scene and add locationGrapId

					var locationGraphScene = LocationGraphScene.PackedScene.Instantiate<LocationGraphScene>();

					locationGraphScene.setLocationGraphId(locationGraphId);
					unsubscribeList.Add(() => locationGraphScene.ClearSubscriptions());

					//add LocationGraphScene to LocationGraphSceneContainer
					GetNode<Control>("%LocationGraphSceneContainer").AddChild(locationGraphScene);
			});
			worldStep?.data?.location?.location_graph?.ForEach(locationGraph =>
			{
				rootLocationGraphNode.options.Add(locationGraph.id);
				rootLocationGraphNode.options = rootLocationGraphNode.options;
			});
		});
	}
}
