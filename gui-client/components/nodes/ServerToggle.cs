using System;
using Dependencies;
using Godot;

[Tool]
[GlobalClass]
public partial class ServerToggle : Button
{
    private Window _window = new Window();

    public override void _Ready()
    {

        _window.MinSize = new(300, 200);
        _window.Mode = Window.ModeEnum.Windowed;
        
        var parentWindow = GetWindow();
        var centerPosition = (parentWindow.Position) + (parentWindow.Size / 2) - (_window.Size / 2);
        _window.Position = centerPosition;
        
        var node = ServerControls.PackedScene.Instantiate();
        _window.AddChild(node);
        _window.CloseRequested += () => { RemoveChild(_window); };

        Pressed += () => { AddChild(_window); };
    }
}