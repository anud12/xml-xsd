using Godot;
using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Drawing;
using System.Linq;
using Guiclient.components.nodes;
using util;
using XSD;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople;

public partial class LocationGraphNodeComponent : BoxContainer
{

	public static PackedScene PackedScene = GD.Load<PackedScene>("res://components/LocationGraphNodeComponent.tscn");
	private node node;
	private ListSizeMonitor<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person> _personMonitor = new ();
	private Container? _personContainer;
	private Label? _nameLabel;
	private Label? _ruleValue;
	private NodeExplorerButton? _nodeExplorerButton;
	private Dictionary<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Npeople.person, Node> _personNodes = new ();

	public LocationGraphNodeComponent()
	{
		_personMonitor.OnSet += (person, i) =>
		{
			var personComponent = _personContainer.GetChildOrNull<PersonComponent>(i);
			if (personComponent == null)
			{
				var packedScene = PersonComponent.PackedScene.Instantiate();
				personComponent = packedScene.GetNode<PersonComponent>("./");
				_personContainer.AddChild(personComponent);
			}
			
			personComponent.InitializeFromId(person.person_id_ref);
			personComponent.Scale = new Vector2(0.5f, 0.5f);
			_personNodes[person] = personComponent;
		};
		_personMonitor.OnDecrease += (person, i) =>
		{
			if (_personNodes.TryGetValue(person, out var node))
			{
				_personNodes.Remove(person);
				node.GetParent().RemoveChild(node);
				node.Free();
			}
		};
	}

	public override void _Ready()
	{
		base._Ready();
		_personContainer = GetNode<Container>("%PersonContainer");
		_nameLabel = GetNode<Label>("%NameLabel");
		_ruleValue = GetNode<Label>("%RuleValue");
		_nodeExplorerButton = GetNode<NodeExplorerButton>("%NodeExplorerButton");
	}

	//populate the node with the data from the graph node
	public void Update(node node)
	{
		_personContainer = GetNode<Container>("%PersonContainer");
		_nameLabel = GetNode<Label>("%NameLabel");
		_ruleValue = GetNode<Label>("%RuleValue");
		_nodeExplorerButton = GetNode<NodeExplorerButton>("%NodeExplorerButton");
		this.node = node;
		if(node.name != null) {
			_nameLabel.Text = node.name.value;
		} else {
			_nameLabel.Text = "";
		}
		
		_nameLabel.Text += "(" + node.id + ")";
		//Set RuleValue node value to value of node node_rule_ref attribute
		var ruleValue = GetNode<Label>("%RuleValue");
		ruleValue.Text = node.node_rule_ref;
		
		
		_nodeExplorerButton.LinkedNodeOrCollection = node;
		
		_personMonitor.Update(node.people?.person);
		
	}

	public void SetScale(float scale)
	{
		Scale = new Vector2(scale, scale);
	}

	//setter that takes a callback and it calls it when action button is pressed
	public void setOnCreateAdjacentButtonPressed(Action<node> callback)
	{
		var actionButton = GetNode<Button>("%CreateAdjacentButton");
		actionButton.Pressed += () => callback(node);
	}
	public void setOnTeleportToButtonPressed(Action<node> callback)
	{
		var actionButton = GetNode<Button>("%TeleportToButton");
		actionButton.Pressed += () => callback(node);
	}


	public void setOnPathToButtonPressed(Action<node> callback)
	{
		var actionButton = GetNode<Button>("%PathToButton");
		actionButton.Pressed += () => callback(node);
	}


	// returns offest to align positions based on DataContainer size
	public Vector2 getOffset()
	{

		return new Vector2(-LocationGraphScene.NODE_SIZE / 2, -LocationGraphScene.NODE_SIZE / 2);
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}
}
