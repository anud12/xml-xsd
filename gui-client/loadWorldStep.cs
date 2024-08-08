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
using Node = Godot.Node;

public class LoadWorldStep
{

	public Node node;
	public LoadWorldStep(Node node)
	{
		this.node = node;
	}

	public world_step worldStep;
	public static int SCALE = LocationGraphNodeComponent.SIZE;
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
		Task<String> result = ImplProgram.Send(worldStep);
		result.Wait();
		XmlDocument xmlDocument = new XmlDocument();
		xmlDocument.LoadXml(result.Result);
		GD.Print("Starting deserialization");
		worldStep = new world_step(xmlDocument.DocumentElement);
		StoreWorld_Step.instance.data = worldStep;
	}

	private System.Collections.Generic.IEnumerable<Node> loadNodes(world_step worldStep)
	{

		return worldStep.location_graph.SelectMany(locationGraph => locationGraph.node.SelectMany(node =>
		{
			var position = node.position.First();
			var packedScene = LocationGraphNodeComponent.PackedScene.Instantiate();
			var locationGraphNodeComponent = packedScene.GetNode<LocationGraphNodeComponent>("./");



			var newPosition = new Vector2(position.x * SCALE, position.y * SCALE);
			//set position of the node based on the offest returned by getOffset
			newPosition += locationGraphNodeComponent.getOffset();
			locationGraphNodeComponent.SetPosition(newPosition);

			locationGraphNodeComponent.initialize(node, worldStep);
			locationGraphNodeComponent.setOnCreateAdjacentButtonPressed(node => addAdjacent(locationGraph, node));
			return new Node[] { locationGraphNodeComponent };
		}));
	}

	private void addAdjacent(world_step__location_graph locationGraph, world_step__location_graph__node node)
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
		executeNextStep();
	}
	private System.Collections.Generic.IEnumerable<Node> loadLinks(world_step worldStep)
	{
		var nodeById = worldStep.location_graph.SelectMany(locationGraph => locationGraph.node).ToDictionary(node => node.id);
		return worldStep.location_graph.SelectMany(locationGraph => locationGraph.node.SelectMany(node =>
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
			}));
	}
}
