using System;
using Godot;

namespace Guiclient.components.nodes;

[Tool]
[GlobalClass]
public partial class LoadFileFromDisk : Button
{
    public Action<string>? OnOpen;
    public override void _Ready()
    {
        Text = "Load from disk";
        Connect("pressed", new Callable(this, MethodName.onPressed));
    }
    
    
    public void onPressed()
    {
        string? path = null;
        var fileDialog = new FileDialog();
        fileDialog.FileMode = FileDialog.FileModeEnum.OpenFile;
        
        var parentWindow = GetWindow();
        var centerPosition = (parentWindow.Position) + (parentWindow.Size / 2) - (fileDialog.Size / 2);
        fileDialog.Position = centerPosition;
        
        AddChild(fileDialog);
        fileDialog.GetVBox().AnchorRight = 1F;
        fileDialog.GetVBox().AnchorBottom = 1F;
        fileDialog.GetVBox().GrowVertical = GrowDirection.Both;
        fileDialog.GetVBox().GrowHorizontal = GrowDirection.Both;
        fileDialog.Show();
        fileDialog.AddFilter("*.xml", "XML definition");
        fileDialog.FileSelected += givenPath =>
        {
            path = givenPath;
        };
        fileDialog.Confirmed += () =>
        {
            GD.Print("Loaded file:" + path);
            var file = FileAccess.GetFileAsString(path);
            GD.Print(file);
            OnOpen?.Invoke(file);
        };
    }
}