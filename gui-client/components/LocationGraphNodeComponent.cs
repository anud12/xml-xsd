using Godot;
using System;
using System.Drawing;
using System.Linq;
using XSD;

public partial class LocationGraphNodeComponent : BoxContainer
{

	public static PackedScene PackedScene = GD.Load<PackedScene>("res://components/LocationGraphNodeComponent.tscn");
	public static int SIZE = 350;
	private world_step__location_graph__node node;
	private world_step worldStep;
	//populate the node with the data from the graph node
	public void initialize(world_step__location_graph__node node, world_step worldStep)
	{
		this.node = node;
		this.worldStep = worldStep;
		var personContainer = GetNode<Control>("%PersonContainer");
		node.people.SelectMany(person => person.person).ToList().ForEach(person =>
		{
			var packedScene = PersonComponent.PackedScene.Instantiate();
			var personComponent = packedScene.GetNode<PersonComponent>("./");
			personComponent.initializeFromId(person.person_id_ref);
			personComponent.Scale = new Vector2(0.5f, 0.5f);
			personContainer.AddChild(personComponent);
		});
	}

	public void SetScale(float scale)
	{
		Scale = new Vector2(scale, scale);
	}

	//setter that takes a callback and it calls it when action button is pressed
	public void setOnCreateAdjacentButtonPressed(Action<world_step__location_graph__node> callback)
	{
		var actionButton = GetNode<Button>("%CreateAdjacentButton");
		actionButton.Pressed += () => callback(node);
	}
	public void setOnTeleportToButtonPressed(Action<world_step__location_graph__node> callback)
	{
		var actionButton = GetNode<Button>("%TeleportToButton");
		actionButton.Pressed += () => callback(node);
	}


	public void setOnPathToButtonPressed(Action<world_step__location_graph__node> callback)
	{
		var actionButton = GetNode<Button>("%PathToButton");
		actionButton.Pressed += () => callback(node);
	}


	// Called when the node enters the scene tree for the first time.
	public override void _Ready()
	{
		//Set NameLabel node value to node id attribute value
		var nameLabel = GetNode<Label>("%NameLabel");
		nameLabel.Text = node.id;

		//Set RuleValue node value to value of node node_rule_ref attribute
		var ruleValue = GetNode<Label>("%RuleValue");
		ruleValue.Text = node.node_rule_ref;
	}

	// returns offest to align positions based on DataContainer size
	public Vector2 getOffset()
	{

		return new Vector2(-SIZE / 2, -SIZE / 2);
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}
}
