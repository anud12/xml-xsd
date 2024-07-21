using System.IO;
using System.Linq;
using System.Xml;
using System.Xml.Serialization;
using Godot;
using WorldStepSchema;
using Node = Godot.Node;

public class LoadWorldStep {

	public static int SCALE = 10;
	public static System.Collections.Generic.IEnumerable<Node> load(string path) {
		XmlDocument xmlDocument = new XmlDocument();
		xmlDocument.Load(path);

		WorldStep worldStep = new WorldStep(xmlDocument.DocumentElement);
		
		//serialize worldStep to out.xml
		
		
		// //create if not exist the file out.xml
		// if (!File.Exists("out.xml"))
		// {
		// 	File.Create("out.xml").Close();
		// }
		// //open file out.xml
		// using (StreamWriter sw = new StreamWriter("out.xml"))
		// {
		// 	var document = new XmlDocument();
		// 	worldStep.Serialize(document);
		// 	document.Save(sw);
		// }
		
	
		return loadNodes(worldStep).Concat(loadLinks(worldStep));

	}

	private static System.Collections.Generic.IEnumerable<Node> loadNodes  (WorldStep worldStep) {
		return worldStep.location_graph.SelectMany(locationGraph => locationGraph.node.Select(node => {
			var position = node.position;
			var newPosition = new Vector2( position.x * SCALE, position.y * SCALE);
			var colorRectangle = new ColorRect
			{
				Color = new Color(1, 1, 1, 1),
				Position = newPosition,
			};
			colorRectangle.SetSize(new Vector2(SCALE, SCALE));
			return colorRectangle;
		}));
	}
	private static System.Collections.Generic.IEnumerable<Node> loadLinks  (WorldStep worldStep) {
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
				line2D.Width  = 1;
				return line2D;
			});
			}));
	}
}
