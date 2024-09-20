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
		StoreWorld_Step.instance.OnSet((data, unsubscribe) =>
		{
			if(IsInstanceValid(this) == false) {
				unsubscribe();
				return;
			}
			//clear the viewport container

			viewportContainer.GetChildren().ToList().ForEach(child => viewportContainer.RemoveChild(child));
			if (data == null)
			{
				return;
			}
			loadLinks(data).ToList().ForEach(node => viewportContainer.AddChild(node));
			loadNodes(data).ToList().ForEach(node => viewportContainer.AddChild(node));

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
						locationGraphNodeComponent.setOnTeleportToButtonPressed(node => TeleportTo(location_graph, node, worldStep));
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

	private void TeleportTo(world_step__location_graph locationGraph, world_step__location_graph__node node, world_step worldStep)
	{
		GD.Print("Teleporting to " + node.id);

		var teleport = new world_step__actions__person__teleport {
			person_id_ref = StoreSession.mainPersonId.data,
		};
		teleport.location_graph = new List<world_step__actions__person__teleport__location_graph> {
			new world_step__actions__person__teleport__location_graph
			{
				location_graph_id_ref = locationGraph.id,
				node_id_ref = node.id,
			}
		 };

		if (worldStep.actions.Count == 0)
		{
			worldStep.actions.Add(new world_step__actions());
		}
		worldStep.actions.First().person__teleport.Add(teleport);
		LoadWorldStep.executeNextStep();
	}
	private System.Collections.Generic.IEnumerable<Node> loadLinks(world_step worldStep)
	{
		

		return worldStep.location_graph.Where(location_graph => location_graph.id == this.locationGraphId).SelectMany(location_graph =>
		{
			var nodeById =  location_graph.node.ToDictionary(node => node.id);
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

					//write hello world labels equal to total_progress on the line2D on equidistant points
					var totalProgress = linkTo.total_progress;

					float totalLength = (start - end).Length();
					float interval = totalLength / (totalProgress);
					Vector2 direction = (end - start).Normalized();

					for (int i = 0; i < (totalProgress ); i++)
					{
						Vector2 position = start + direction * (i * interval);
						var label = new Label
						{
							Text = linkTo.total_progress.ToString(),
							Size = new Vector2(SCALE, SCALE),
						};
						line2D.AddChild(label);
						label.Position = position;
						label.Set("theme_override_font_sizes/font_size", SCALE/2);
					}


					// var totalProgress = linkTo.total_progress;
					// var totalProgressLength = totalProgress * SCALE;
					// var dividerSize = SCALE / 2;
					// var dividerStep = (start + end) / totalProgress;
					// Enumerable.Range(0, totalProgress).ToList().ForEach(i =>
					// {

					// 	var label = new Label
					// 	{
					// 		Text = linkTo.total_progress.ToString(),
					// 	};
					// 	line2D.AddChild(label);
					// 	//set position of the label to the middle of the line2D
					// 	// label.Position = (start + end) / 2;

					// 	label.Position = start + dividerStep * i;
					// 	var totalProgressDirection = (end - start).Normalized();
					// 	var totalProgressStart = start + totalProgressDirection * totalProgressLength;
					// 	var totalProgressEnd = end - totalProgressDirection * totalProgressLength;
					// 	var totalProgressLine2D = new Line2D
					// 	{
					// 		DefaultColor = new Color(1, 1, 1, 1),
					// 		Points = new Vector2[] { totalProgressStart, totalProgressEnd },
					// 	};
					// 	line2D.AddChild(totalProgressLine2D);


					// });
					line2D.Width = SCALE /2;
					return line2D;
				});
			});
		});
	}
}
