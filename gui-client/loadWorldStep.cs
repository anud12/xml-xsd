using System.IO;
using System.Linq;
using System.Threading;
using System.Xml;
using System.Xml.Serialization;
using Godot;
using GodotPlugins.Game;
using WorldStepSchema;
using Node = Godot.Node;

public class LoadWorldStep {

	public Node node;
	public LoadWorldStep(Node node) {
		this.node = node;
	}	

	public WorldStep worldStep;
	public static int SCALE = 10;
	public void load(string path) {

		GD.Print("Loading: " + path);	

		
		node.GetChildren().ToList()
		.Where(child => child is ColorRect || child is Button || child is Line2D)
		.ToList()
		.ForEach(child => node.RemoveChild(child));

		XmlDocument xmlDocument = new XmlDocument();
		xmlDocument.Load(path);

		worldStep = new WorldStep(xmlDocument.DocumentElement);
		
		 var nodes = loadNodes(worldStep).Concat(loadLinks(worldStep));

		nodes.ToList().ForEach(child => node.AddChild(child));
	}

	public void executeNextStep() {
		ImplProgram.Main(worldStep);
		GD.Print("Executing next step");
		Thread.Sleep(1500);
		GD.Print("Loading next step");

		load("./"+worldStep.world_metadata.next_world_step.world_step_id_ref.Replace("../gui-client/", "") + ".xml");
	}

	private System.Collections.Generic.IEnumerable<Node> loadNodes  (WorldStep worldStep) {
		return worldStep.location_graph.SelectMany(locationGraph => locationGraph.node.SelectMany(node => {
			var position = node.position;
			var newPosition = new Vector2( position.x * SCALE, position.y * SCALE);
			var colorRectangle = new ColorRect
			{
				Color = new Color(1, 1, 1, 1),
				Position = newPosition,
			};
			colorRectangle.SetSize(new Vector2(SCALE, SCALE));

			var button = new Button
			{
				Text = "Create Adjacent",
				Size = new Vector2(SCALE, SCALE),
				Position = newPosition,
			};
			
			button.Pressed += () => {
				addAdjacent(locationGraph, node);
			};

			return new Node[] {button, colorRectangle};
		}));
	}

	private void addAdjacent(WorldStep_LocationGraph locationGraph, WorldStep_LocationGraph_Node node) {


		GD.Print("Adding adjacent to " + node.id);
		if(worldStep.actions == null) {
			worldStep.actions = new WorldStep_Actions();
		}
		worldStep.actions.create_adjacent = new WorldStep_Actions_CreateAdjacent
		{
			location_graph_id_ref = locationGraph.id,
			node_id_ref = node.id,
		};
		executeNextStep();
	}
	private System.Collections.Generic.IEnumerable<Node> loadLinks  (WorldStep worldStep) {
		return worldStep.location_graph.SelectMany(locationGraph => locationGraph.node.SelectMany(node => 
			{
				GD.Print("node.link_to: " + node.link_to.Count);
				return node.link_to.Select(linkTo => {
				var startNode = node;
				GD.Print("linkTo.node_id_ref: " + linkTo.node_id_ref);
				var endNode = locationGraph.nodeById[linkTo.node_id_ref];
				var start = new Vector2(startNode.position.x * SCALE, startNode.position.y * SCALE);
				var end = new Vector2(endNode.position.x * SCALE, endNode.position.y * SCALE);
				var line2D = new Line2D
				{
					DefaultColor = new Color(1, 1, 1, 1),
					Points = new Vector2[] {start, end},
				};
				line2D.Width  = 4;
				return line2D;
			});
			}));
	}
}
