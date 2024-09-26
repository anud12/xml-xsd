using Godot;
using System;
using System.Collections.Generic;
using System.Collections.Immutable;
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
			if (IsInstanceValid(this) == false)
			{
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

		Dictionary<Vector2, Control> node2DVector2D = new Dictionary<Vector2, Control>();
		return worldStep.location_graph.Where(location_graph => location_graph.id == this.locationGraphId).SelectMany(location_graph =>
		{
			return location_graph.node.SelectMany(node =>
					{
						var position = node.position.First();
						var packedScene = LocationGraphNodeComponent.PackedScene.Instantiate();
						var locationGraphNodeComponent = packedScene.GetNode<LocationGraphNodeComponent>("./");
						//set position of the node based on the offest returned by getOffset
						locationGraphNodeComponent.initialize(node, worldStep);
						locationGraphNodeComponent.setOnCreateAdjacentButtonPressed(node => addAdjacent(location_graph, node, worldStep));
						locationGraphNodeComponent.setOnTeleportToButtonPressed(node => TeleportTo(location_graph, node, worldStep));
						locationGraphNodeComponent.setOnPathToButtonPressed(node => PathTo(location_graph, node, worldStep));

						var newPosition = new Vector2(position.x * SCALE, position.y * SCALE);
						newPosition += locationGraphNodeComponent.getOffset();
						if (node2DVector2D.ContainsKey(newPosition))
						{
							var node2D = node2DVector2D[newPosition];
							node2D.AddChild(locationGraphNodeComponent);
							var childrenSize = node2D.GetChildren().Count;

							var tableScale = 1 + (int)Math.Sqrt(childrenSize - 1);

							//iterate over children of node2d with index

							for (int i = 0; i < childrenSize; i++)
							{
								var child = node2D.GetChild(i);
								if (child is LocationGraphNodeComponent)
								{
									var chilLocationGraphNodeComponent = (LocationGraphNodeComponent)child;
									chilLocationGraphNodeComponent.Scale = new Vector2(1f / tableScale, 1f / tableScale);
									chilLocationGraphNodeComponent.Position = new Vector2(SCALE / tableScale * (i % tableScale), SCALE / tableScale * (i / tableScale));
								}
							}

							return new Node[] { };
						}
						else
						{
							var node2D = new Panel();
							node2D.Size = new Vector2(SCALE, SCALE);
							node2D.Position = newPosition;
							node2D.AddChild(locationGraphNodeComponent);
							node2DVector2D[newPosition] = node2D;
							return new Node[] { node2D };
						}
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

		var teleport = new world_step__actions__person__teleport
		{
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
	private void PathTo(world_step__location_graph locationGraph, world_step__location_graph__node node, world_step worldStep)
	{
		GD.Print("Teleporting to " + node.id);

		var action = new world_step__actions__person__move_to()
		{
			person_id_ref = StoreSession.mainPersonId.data,
		};

		action.find_path_towards.Add(new type__node_graph__selection
		{
			has__node_graph_id = new List<type__node_graph__selection__has__node_graph_id>{
				new type__node_graph__selection__has__node_graph_id
				{
					node_graph_id_ref = node.id,
				}
			}
		});

		if (worldStep.actions.Count == 0)
		{
			worldStep.actions.Add(new world_step__actions());
		}
		worldStep.actions.First().person__move_to.Add(action);
		LoadWorldStep.executeNextStep();
	}
	private System.Collections.Generic.IEnumerable<Node> loadLinks(world_step worldStep)
	{


		return worldStep.location_graph.Where(location_graph => location_graph.id == this.locationGraphId).SelectMany(location_graph =>
		{
			var nodeById = location_graph.node.ToDictionary(node => node.id);
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

					addSteps(line2D, linkTo);
					addPersons(line2D, linkTo, worldStep);
					line2D.Width = SCALE / 6;
					return line2D;
				});
			});
		});
	}

	private void addSteps(Line2D line2D, world_step__location_graph__node__link_to linkTo)
	{
		var totalProgress = linkTo.total_progress - 1;

		var start = line2D.Points[0];
		var end = line2D.Points[1];

		float totalLength = (start - end).Length();
		float interval = totalLength / totalProgress;
		Vector2 direction = (end - start).Normalized();

		for (int i = 0; i < (totalProgress); i++)
		{
			Vector2 position = start + direction * (i * interval);
			var label = new Label
			{
				Text = linkTo.total_progress.ToString() + "(" + i + ")",
				// Text = "",
				Size = new Vector2(SCALE, SCALE),
			};
			line2D.AddChild(label);
			label.Position = position;
			label.HorizontalAlignment = HorizontalAlignment.Center;
			label.Set("theme_override_font_sizes/font_size", SCALE / 6);
		}
	}

	private void addPersons(Line2D line2D, world_step__location_graph__node__link_to linkTo, world_step world_Step)
	{
		var totalProgress = (linkTo.total_progress - 1) * 2;

		var start = line2D.Points[0];
		var end = line2D.Points[1];

		float totalLength = (start - end).Length();
		float interval = totalLength / totalProgress;
		Vector2 direction = (end - start).Normalized();

		for (int i = 0; i < (totalProgress); i++)
		{
			if (i % 2 == 0)
			{
				continue;
			}
			Vector2 position = start + direction * (i * interval);
			var label = new Label
			{
				Text = "",
				Size = new Vector2(SCALE, SCALE),
			};
			line2D.AddChild(label);
			linkTo.people?.SelectMany(people => people.person).ToList().ForEach(person =>
			{
				string personId = person.person_id_ref;
				int progress = int.Parse(person.rawNode.attributes["accumulated_progress"]);
				var relativeProgress = (i +2 ) / 2;
				GD.Print("progress: " + progress + " Iteration: " + i + " Relative Progress: "+ relativeProgress +" Total Progress: " + totalProgress);

				if(progress != relativeProgress)
				{
					return;
				}

				var personData = world_Step.people.SelectMany(people => people.person).Where(person => person.id == personId).First();
				if (personData != null)
				{
					string personName = personData.name.ToString() + "(" + progress + ")" + "(" + relativeProgress + ")";
					label.Text = personName.ToString();
				}
			});



			label.Position = position;
			label.HorizontalAlignment = HorizontalAlignment.Center;
			label.Set("theme_override_font_sizes/font_size", SCALE / 6);
		}
	}
}
