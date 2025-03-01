using System;
using System.Threading.Tasks;
using Godot;

namespace Guiclient.util;

public class LoadFileFromDisk
{
    public static Task<String> AsString(Node node)
    {
        String? path = null;
        var fileDialog = new FileDialog();
        node.AddChild(fileDialog);
        fileDialog.MinSize = new(400, 500);
        
        var parentWindow = node.GetWindow();
        var centerPosition = (parentWindow.Position) + (parentWindow.Size / 2) - (fileDialog.Size / 2);
        fileDialog.Position = centerPosition;

        fileDialog.FileMode = FileDialog.FileModeEnum.OpenFile;
        fileDialog.Show();
        fileDialog.GetVBox().AnchorRight = 1F;
        fileDialog.GetVBox().AnchorBottom = 1F;
        fileDialog.GetVBox().GrowVertical = Control.GrowDirection.Both;
        fileDialog.GetVBox().GrowHorizontal = Control.GrowDirection.Both;
        fileDialog.AddFilter("*.xml", "XML definition");
        fileDialog.FileSelected += givenPath =>
        {
            GD.Print("FileSelected");
            path = givenPath;
        };
        var task = new TaskCompletionSource<string>();
        fileDialog.Confirmed += () =>
        {
            GD.Print("Confirmed " + path);
            
            if (path == null)
            {
                return;
            }
            var file = FileAccess.GetFileAsString(path);
            task.TrySetResult(file);
        };
        return task.Task;
    }
}