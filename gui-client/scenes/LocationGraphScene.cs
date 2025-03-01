using Godot;
using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Linq;
using System.Threading.Tasks;
using XSD;
using XSD.Ntype__node_graph__selection;
using XSD.Nworld_step.Nactions;
using XSD.Nworld_step.Ndata.Nlocation;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks;
using link_to = XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to;
using location_graph = XSD.Nworld_step.Ndata.Nlocation.location_graph;
using util.dataStore;

public partial class LocationGraphScene : Control
{

	public static PackedScene PackedScene = GD.Load<PackedScene>("res://scenes/LocationGraphScene.tscn");

	public static float NODE_SIZE = 650;
	public static float LINK_SIZE = 50;

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

		var nodeContainer = GetNode<Node>("%NodeContainer");
		var personContainer = GetNode<Node>("%PersonContainer");
		var linkContainer = GetNode<Node>("%LinkContainer");
		StoreWorld_Step.instance.OnSet((data, unsubscribe) =>
		{
			if (IsInstanceValid(this) == false)
			{
				unsubscribe();
				return;
			}
			//clear the viewport container

			nodeContainer.GetChildren().ToList().ForEach(child => nodeContainer.RemoveChild(child));
			personContainer.GetChildren().ToList().ForEach(child => personContainer.RemoveChild(child));
			linkContainer.GetChildren().ToList().ForEach(child => linkContainer.RemoveChild(child));
			if (data == null)
			{
				return;
			}
			var nodesById = loadNodes(data);
			nodesById.Item2.ToList().ForEach(node => nodeContainer.AddChild(node));
			loadLinks(data, nodesById.Item1).ToList().ForEach(link => linkContainer.AddChild(link));

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

	private (Dictionary<string, Control>, IEnumerable<Node>) loadNodes(world_step worldStep)
	{
		Dictionary<string, Control> nodeById = new Dictionary<string, Control>();
		Dictionary<Vector2, Control> node2DVector2D = new Dictionary<Vector2, Control>();


		// var nodeList = CreateComponents(worldStep, locagionGraph, nodeById, node2DVector2D);

		var nodeList = worldStep.data.location?.location_graph.Where(location_graph => location_graph.id == this.locationGraphId).SelectMany(location_graph =>
        {
            return CreateComponents(worldStep, location_graph, nodeById, node2DVector2D);
        });
		return (nodeById, nodeList);
	}

    private IEnumerable<Node> CreateComponents(world_step worldStep, location_graph location_graph, Dictionary<string, Control> nodeById, Dictionary<Vector2, Control> node2DVector2D)
    {
        return location_graph.node.SelectMany(node =>
        {
			var position = node.position;
            var packedScene = LocationGraphNodeComponent.PackedScene.Instantiate();
            var locationGraphNodeComponent = packedScene.GetNode<LocationGraphNodeComponent>("./");
            nodeById[node.id] = locationGraphNodeComponent;
            //set position of the node based on the offest returned by getOffset
            locationGraphNodeComponent.initialize(node);
            locationGraphNodeComponent.setOnCreateAdjacentButtonPressed(node => addAdjacent(location_graph, node, worldStep));
            locationGraphNodeComponent.setOnTeleportToButtonPressed(node => TeleportTo(location_graph, node, worldStep));
            locationGraphNodeComponent.setOnPathToButtonPressed(node => PathTo(location_graph, node, worldStep));

            var newPosition = new Vector2((float)position.x * NODE_SIZE, (float)position.y * NODE_SIZE);
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
                        chilLocationGraphNodeComponent.Position = new Vector2(NODE_SIZE / tableScale * (i % tableScale), NODE_SIZE / tableScale * (i / tableScale));
                    }
                }

                return new Node[] { };
            }
            else
            {
                var node2D = new Container();
                node2D.Size = new Vector2(NODE_SIZE, NODE_SIZE);
                node2D.Position = newPosition;
                node2D.AddChild(locationGraphNodeComponent);
                node2DVector2D[newPosition] = node2D;
                return new Node[] { node2D };
            }
        });
    }

    private void addAdjacent(location_graph locationGraph, node node, world_step worldStep)
	{
		GD.Print("Adding adjacent to " + node.id);

		var createAdjacent = new location_graph__node__create_adjacent
		{
			location_graph_id_ref = locationGraph.id,
			node_id_ref = node.id,
		};
		worldStep.actions.location_graph__node__create_adjacent.Add(createAdjacent);
		LoadWorldStep.executeNextStep();
	}

	private void TeleportTo(location_graph locationGraph, node node, world_step worldStep)
	{
		GD.Print("Teleporting to " + node.id);

		var teleport = new person__teleport
		{
			person_id_ref = StoreSession.mainPersonId.data,
			location_graph = new XSD.Nworld_step.Nactions.Nperson__teleport.location_graph
			{
				location_graph_id_ref = locationGraph.id,
				node_id_ref = node.id,
			}
		};

		worldStep.actions.person__teleport = teleport;
		LoadWorldStep.executeNextStep();
	}
	private void PathTo(location_graph locationGraph, node node, world_step worldStep)
	{
		GD.Print("Teleporting to " + node.id);

		var action = new person__move_to()
		{
			person_id_ref = StoreSession.mainPersonId.data,
		};

		action.find_path_towards = new type__node_graph__selection
		{
			has__node_graph_id = new has__node_graph_id
			{
				node_graph_id_ref = node.id
			}
		};
		worldStep.actions.person__move_to.Add(action);
		LoadWorldStep.executeNextStep();
	}
	private IEnumerable<Node> loadLinks(world_step worldStep, Dictionary<string, Control> nodesById)
	{
		var personContainerNode = GetNode<Node>("%PersonContainer");
		IEnumerable<Node> nodeList = worldStep.data.location.location_graph
		.Where(location_graph => location_graph.id == locationGraphId)
		.SelectMany(location_graph => location_graph.node)
		.SelectMany(startNodeElement => startNodeElement.links.link_to.SelectMany(linkTo =>
			{
				var endNode = nodesById[linkTo.node_id_ref];
				var startNode = nodesById[startNodeElement.id];
				var linkNode = new LinkNode();

				linkNode.StartNode = startNode;
				linkNode.EndNode = endNode;
				linkNode.Width = LINK_SIZE;
				linkNode.MaxSteps = linkTo.total_progress - 1;

				linkTo.people?.person?.ForEach(person =>
					{
						var personId = person.person_id_ref;
						var personData = worldStep.data.people?.person?.Where(person => person.id == personId).First();
						var personScene = PersonComponent.PackedScene.Instantiate();
						var personComponent = personScene.GetNode<PersonComponent>("./");
						personComponent.initializeFromId(personId);

						var personContainer = new Gimbal2D();
						personContainer.Rotation = 0;
						personContainer.Size = new Vector2(NODE_SIZE, NODE_SIZE);
						personContainer.AddChild(personComponent);

						linkNode.ChildrenByNode.Add(personContainer, person.accumulated_progress - 1);
						personContainerNode.AddChild(personContainer);
						

					}
				);

				List<Node> returnList = new List<Node>
				{
					linkNode
				};
				return returnList;
			})
		);
		return nodeList ?? new List<Node>();
	}

	private void addSteps(Line2D line2D,  link_to linkTo)
	{
		var totalProgress = linkTo.total_progress - 1;

		var start = line2D.Points[0];
		var end = line2D.Points[1];

		float totalLength = (start - end).Length();
		float interval = totalLength / (float)totalProgress;
		Vector2 direction = (end - start).Normalized();

		for (int i = 0; i < (totalProgress); i++)
		{
			Vector2 position = start + direction * (i * interval);
			var label = new Label
			{
				Text = linkTo.total_progress.ToString() + "(" + i + ")",
				// Text = "",
				Size = new Vector2(NODE_SIZE, NODE_SIZE),
			};
			line2D.AddChild(label);
			label.Position = position;
			label.HorizontalAlignment = HorizontalAlignment.Center;
			label.Set("theme_override_font_sizes/font_size", NODE_SIZE / 6);
		}
	}

	private void addPersons(Line2D line2D, link_to linkTo, world_step world_Step)
	{
		var totalProgress = (linkTo.total_progress - 1) * 2;

		var start = line2D.Points[0];
		var end = line2D.Points[1];

		float totalLength = (start - end).Length();
		float interval = totalLength / (float)totalProgress;
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
				Size = new Vector2(NODE_SIZE, NODE_SIZE),
			};
			line2D.AddChild(label);
			linkTo.people?.person?.ForEach(person =>
			{
				string personId = person.person_id_ref;
				int progress = int.Parse(person.rawNode.attributes["accumulated_progress"]);
				var relativeProgress = (i + 2) / 2;
				GD.Print("progress: " + progress + " Iteration: " + i + " Relative Progress: " + relativeProgress + " Total Progress: " + totalProgress);

				if (progress != relativeProgress)
				{
					return;
				}

				var personData = world_Step.data.people?.person?.Where(person => person.id == personId).First();
				if (personData != null)
				{
					string personName = personData.name?.ToString() + "(" + progress + ")" + "(" + relativeProgress + ")";
					label.Text = personName.ToString();
				}
			});



			label.Position = position;
			label.HorizontalAlignment = HorizontalAlignment.Center;
			label.Set("theme_override_font_sizes/font_size", NODE_SIZE / 6);
		}
	}
}
