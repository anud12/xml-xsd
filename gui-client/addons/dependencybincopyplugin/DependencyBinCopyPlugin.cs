#if TOOLS
using Godot;
using System;
using System.IO;

[Tool]
public partial class DependencyBinCopyPlugin : EditorPlugin
{
	private NodeDependencyPlugin? nodeDependencyPlugin;
	public override void _EnterTree()
	{
		// Initialization of the plugin goes here.
		nodeDependencyPlugin = new NodeDependencyPlugin();
		// Add the plugin to the editor.
		AddExportPlugin(nodeDependencyPlugin);
	}

	public override void _ExitTree()
	{
		// Clean-up of the plugin goes here.
		RemoveExportPlugin(nodeDependencyPlugin);
	}

	public partial class NodeDependencyPlugin : EditorExportPlugin
	{
		private string _localPath = "./dependencies_bin";
		private string _destinationPath = "";

		public override void _ExportBegin(string[] features, bool isDebug, string path, uint flags)
		{
			_destinationPath = path.Replace("/Gui-client.exe", "");
			GD.Print("Saving path: " + _destinationPath);
			GD.Print("LocalPath: " + _localPath);
		}
		public override void _ExportEnd()
		{
			GD.Print("Copying from " + _localPath + " to " + _destinationPath);

			// Copy the dependencies_bin folder to the export folder.
			GD.Print("Creating directory: " + _destinationPath + "/dependencies_bin");
			Directory.CreateDirectory(_destinationPath + "/dependencies_bin");
			var sourceDirectory = new DirectoryInfo(_localPath);
			var destinationDirectory = new DirectoryInfo(_destinationPath + "/dependencies_bin");
			CopyDirectory(sourceDirectory, destinationDirectory);
			
			
		}

		// Helper method to copy a directory and its contents recursively.
		private static void CopyDirectory(DirectoryInfo source, DirectoryInfo destination)
			{
				if (!destination.Exists)
				{
					GD.Print("Creating directory: " + destination.FullName);
					destination.Create();
				}
			
				foreach (var file in source.GetFiles())
				{
					GD.Print("Copying file: " + file.Name);
					file.CopyTo(Path.Combine(destination.FullName, file.Name), true);
				}
			
				foreach (var subdirectory in source.GetDirectories())
				{
					GD.Print("Creating subdirectory: " + subdirectory.Name);
					var subdirectoryDestination = destination.CreateSubdirectory(subdirectory.Name);
					GD.Print("Copying subdirectory: " + subdirectory.Name);
					CopyDirectory(subdirectory, subdirectoryDestination);
				}
			}
	}
}
#endif
