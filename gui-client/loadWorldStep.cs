using System;
using System.IO;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Serialization;
using Godot;
using GodotPlugins.Game;
using XSD;
using XSD.Nworld_step.Nactions;
using XSD.Nworld_step.Ndata.Nlocation;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph;
using Node = Godot.Node;
using util.dataStore;

public class LoadWorldStep
{

	public Node node;
	public LoadWorldStep(Node node)
	{
		this.node = node;
	}

	public world_step worldStep;
	public static float SCALE = LocationGraphScene.NODE_SIZE;
	public void loadFromPath(string path)
	{

		GD.Print("Loading: " + path);
		using (StreamReader sr = new StreamReader(path))
		{
			load(sr.ReadToEnd());
		}
	}

	public world_step deserializeFromPath(string path)
	{
		GD.Print("deserializeFromPath: " + path);
		using (StreamReader sr = new StreamReader(path))
		{
			var data = sr.ReadToEnd();
			XmlDocument xmlDocument = new XmlDocument();
			xmlDocument.LoadXml(data);

			GD.Print("Starting deserialization");
			return new world_step(xmlDocument.DocumentElement);
		}
	}


	public void load(string data)
	{
		GD.Print("Removing children");
		node.GetChildren()
		.ToList()
		.ForEach(child => node.RemoveChild(child));

		XmlDocument xmlDocument = new XmlDocument();
		xmlDocument.LoadXml(data);

		GD.Print("Starting deserialization");
		worldStep = new world_step(xmlDocument.DocumentElement);

		GD.Print("Loading nodes and links");
		var nodes = loadLinks(worldStep).Concat(loadNodes(worldStep));

		GD.Print("Adding nodes and links");
		nodes.ToList().ForEach(child => node.AddChild(child));
	}

	public static void executeNextStep()
	{
		GD.Print("Executing next step");
		var worldStep = StoreWorld_Step.instance.data;
		ImplProgram.SendHttp(worldStep)
			.ContinueWith(async result =>
			{
				if (result == null)
				{
					return;
				}
				XmlDocument xmlDocument = new XmlDocument();
				xmlDocument.LoadXml(await result);
				GD.Print("Starting deserialization");
				worldStep = new world_step(xmlDocument.DocumentElement);
				StoreWorld_Step.instance.QueueSet(worldStep);
			});
	}

	private System.Collections.Generic.IEnumerable<Node> loadNodes(world_step worldStep)
	{

		return worldStep.data.location?.location_graph.SelectMany(locationGraph => locationGraph.node.SelectMany(node =>
		{
			var position = node.position;
			var packedScene = LocationGraphNodeComponent.PackedScene.Instantiate();
			var locationGraphNodeComponent = packedScene.GetNode<LocationGraphNodeComponent>("./");



			var newPosition = new Vector2((float)(position.x * SCALE), (float)(position.y * SCALE));
			//set position of the node based on the offest returned by getOffset
			newPosition += locationGraphNodeComponent.getOffset();
			locationGraphNodeComponent.SetPosition(newPosition);

			locationGraphNodeComponent.initialize(node);
			locationGraphNodeComponent.setOnCreateAdjacentButtonPressed(node => addAdjacent(locationGraph, node));
			return new Node[] { locationGraphNodeComponent };
		})) ?? Array.Empty<Node>().AsEnumerable();
	}

	private void addAdjacent(location_graph locationGraph, node node)
	{
		GD.Print("Adding adjacent to " + node.id);

		var createAdjacent = new location_graph__node__create_adjacent
		{
			location_graph_id_ref = locationGraph.id,
			node_id_ref = node.id,
		};

		worldStep.actions.location_graph__node__create_adjacent.Add(createAdjacent);
		executeNextStep();
	}
	private System.Collections.Generic.IEnumerable<Node> loadLinks(world_step worldStep)
	{
		var nodeById = worldStep.data.location?.location_graph?.SelectMany(locationGraph => locationGraph.node).ToDictionary(node => node.id);
		return worldStep.data.location?.location_graph?.SelectMany(locationGraph => locationGraph.node.SelectMany(node =>
			{
				GD.Print("node.link_to: " + node.links?.link_to.Count);
				return node.links?.link_to.Select(linkTo =>
				{
					var startNode = node;
					GD.Print("linkTo.node_id_ref: " + linkTo.node_id_ref);
					var endNode = nodeById[linkTo.node_id_ref];
					var start = new Vector2((float)startNode.position.x * SCALE, (float)startNode.position.y * SCALE);
					var end = new Vector2((float)endNode.position.x * SCALE, (float)endNode.position.y * SCALE);
					var line2D = new Line2D
					{
						DefaultColor = new Color(0, 0, 0, 1),
						Points = new Vector2[] { start, end },
					};
					line2D.Width = SCALE / 10;
					return line2D;
				});
			})) ?? Array.Empty<Node>().AsEnumerable();
	}
}
