using System.IO;
using System.Linq;
using System.Threading;
using System.Xml;
using System.Xml.Serialization;
using Godot;
using GodotPlugins.Game;
using XSD;
using Node = Godot.Node;

public class LoadWorldStep {

	public Node node;
	public LoadWorldStep(Node node) {
		this.node = node;
	}	

	public world_step worldStep;
	public static int SCALE = 10;
	public void load(string path) {

		GD.Print("Loading: " + path);	

		GD.Print("Removing children");
		node.GetChildren().ToList()
		.Where(child => child is ColorRect || child is Button || child is Line2D)
		.ToList()
		.ForEach(child => node.RemoveChild(child));


		Godot.GD.Print("Loading world step from " + path);
		XmlDocument xmlDocument = new XmlDocument();
		xmlDocument.Load(path);

		GD.Print("Starting deserialization");
		worldStep = new world_step(xmlDocument.DocumentElement);
		
		GD.Print("Loading nodes and links");
		 var nodes = loadLinks(worldStep).Concat(loadNodes(worldStep));

		GD.Print("Adding nodes and links");
		nodes.ToList().ForEach(child => node.AddChild(child));
	}

	public void executeNextStep() {
		ImplProgram.Main(worldStep);
		GD.Print("Executing next step");
		Thread.Sleep(1500);
		GD.Print("Loading next step");

		load("./"+worldStep.world_metadata.First().next_world_step.First().value.Replace("../gui-client/", "") + ".xml");
	}

	private System.Collections.Generic.IEnumerable<Node> loadNodes  (world_step worldStep) {

		return worldStep.location_graph.SelectMany(locationGraph => locationGraph.node.SelectMany(node => {
			var position = node.position.First();
			var newPosition = new Vector2( position.x * SCALE, position.y * SCALE);
			var colorRectangle = new ColorRect
			{
				Color = new Color(1, 1, 1, 1),
				Position = newPosition,
			};
			colorRectangle.SetSize(new Vector2(SCALE, SCALE));

			var button = new Button
			{
				Text = node.id + ": Create Adjacent",
				Size = new Vector2(SCALE, SCALE),
				Position = newPosition,
			};
			
			button.Pressed += () => {
				addAdjacent(locationGraph, node);
			};

			return new Node[] {colorRectangle, button};
		}));
	}

	private void addAdjacent(world_step__location_graph locationGraph, world_step__location_graph__node node) {


		GD.Print("Adding adjacent to " + node.id);

		var createAdjacent = new world_step__actions__location_graph__node__create_adjacent
		{
			location_graph_id_ref = locationGraph.id,
			node_id_ref = node.id,
		};
		if(worldStep.actions.Count == 0) {
			worldStep.actions.Add(new world_step__actions());
		}
		worldStep.actions.First().location_graph__node__create_adjacent.Add(createAdjacent);
		executeNextStep();
	}
	private System.Collections.Generic.IEnumerable<Node> loadLinks  (world_step worldStep) {
		var nodeById = worldStep.location_graph.SelectMany(locationGraph => locationGraph.node).ToDictionary(node => node.id);
		return worldStep.location_graph.SelectMany(locationGraph => locationGraph.node.SelectMany(node => 
			{
				GD.Print("node.link_to: " + node.link_to.Count);
				return node.link_to.Select(linkTo => {
				var startNode = node;
				GD.Print("linkTo.node_id_ref: " + linkTo.node_id_ref);
				var endNode = nodeById[linkTo.node_id_ref];
				var start = new Vector2(startNode.position.First().x * SCALE, startNode.position.First().y * SCALE);
				var end = new Vector2(endNode.position.First().x * SCALE, endNode.position.First().y * SCALE);
				var line2D = new Line2D
				{
					DefaultColor = new Color(1, 1, 1, 1),
					Points = new Vector2[] {start, end},
				};
				line2D.Width  = SCALE;
				return line2D;
			});
			}));
	}
}
