using Godot;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using XSD;

public partial class LocationGraphScene : Control
{

	public static PackedScene PackedScene = GD.Load<PackedScene>("res://scenes/LocationGraphScene.tscn");

	public static int SCALE = LocationGraphNodeComponent.SIZE;

	private String locationGraphId;
	private List<Action> unsubscribeList = new List<Action>();

	public void setLocationGraphId(String locationGraphId)
	{
		this.locationGraphId = locationGraphId;
	}

	// Called when the node enters the scene tree for the first time.
	public override void _Ready()
	{
		//set title of the node

		var title = GetNode<Label>("%Title");
		title.Text = "Location Graph: " + locationGraphId;

		var viewportContainer = GetNode<Node>("%GraphContainer");
		var unsubscribe = StoreWorld_Step.instance.OnSave(data =>
		{
			//clear the viewport container
			
			viewportContainer.GetChildren().ToList().ForEach(child => viewportContainer.RemoveChild(child));
			if(data == null)
			{
				return;
			}
			loadLinks(data).ToList().ForEach(node => viewportContainer.AddChild(node));
			loadNodes(data).ToList().ForEach(node => viewportContainer.AddChild(node));

		});
		unsubscribeList.Add(unsubscribe);
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

	private System.Collections.Generic.IEnumerable<Node> loadNodes(world_step worldStep)
	{

		return worldStep.location_graph.Where(location_graph => location_graph.id == this.locationGraphId).SelectMany(location_graph =>
		{
			return location_graph.node.SelectMany(node =>
					{
						var position = node.position.First();
						var packedScene = LocationGraphNodeComponent.PackedScene.Instantiate();
						var locationGraphNodeComponent = packedScene.GetNode<LocationGraphNodeComponent>("./");



						var newPosition = new Vector2(position.x * SCALE, position.y * SCALE);
						//set position of the node based on the offest returned by getOffset
						newPosition += locationGraphNodeComponent.getOffset();
						locationGraphNodeComponent.SetPosition(newPosition);

						locationGraphNodeComponent.initialize(node, worldStep);
						locationGraphNodeComponent.setOnCreateAdjacentButtonPressed(node => addAdjacent(location_graph, node, worldStep));
						return new Node[] { locationGraphNodeComponent };
					});
		});
	}

	private void addAdjacent(world_step__location_graph locationGraph, world_step__location_graph__node node, world_step worldStep)
	{


		GD.Print("Adding adjacent to " + node.id);

		var createAdjacent = new world_step__actions__location_graph__node__create_adjacent
		{
			location_graph_id_ref = locationGraph.id,
			node_id_ref = node.id,
		};
		if (worldStep.actions.Count == 0)
		{
			worldStep.actions.Add(new world_step__actions());
		}
		worldStep.actions.First().location_graph__node__create_adjacent.Add(createAdjacent);
		LoadWorldStep.executeNextStep();
	}
	private System.Collections.Generic.IEnumerable<Node> loadLinks(world_step worldStep)
	{
		var nodeById = worldStep.location_graph.SelectMany(locationGraph => locationGraph.node).ToDictionary(node => node.id);

		return worldStep.location_graph.Where(location_graph => location_graph.id == this.locationGraphId).SelectMany(location_graph => {
			return location_graph.node.SelectMany(node =>
			{
				GD.Print("node.link_to: " + node.link_to.Count);
				return node.link_to.Select(linkTo =>
				{
					var startNode = node;
					GD.Print("linkTo.node_id_ref: " + linkTo.node_id_ref);
					var endNode = nodeById[linkTo.node_id_ref];
					var start = new Vector2(startNode.position.First().x * SCALE, startNode.position.First().y * SCALE);
					var end = new Vector2(endNode.position.First().x * SCALE, endNode.position.First().y * SCALE);
					var line2D = new Line2D
					{
						DefaultColor = new Color(0, 0, 0, 1),
						Points = new Vector2[] { start, end },
					};
					line2D.Width = SCALE / 10;
					return line2D;
				});
			});
		});
	}
}
