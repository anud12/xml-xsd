using System;
using Godot;

namespace Guiclient.util;

public static class ButtonCreateWindowExtension
{
    public static void SpawnWindow(this Node control, Control child)
    {
        Window _window = new Window();
        _window.MinSize = new(200, 200);
        _window.Mode = Window.ModeEnum.Windowed;
        var parentWindow = control.GetWindow();
        var centerPosition = (parentWindow.Position) + (parentWindow.Size / 2) - (_window.Size / 2);
        _window.Position = centerPosition;
        _window.CloseRequested += () =>
        {
            control.RemoveChild(_window);
            _window.QueueFree();
        };
        _window.AddChild(child);
        
        child.AnchorRight = 1F;
        child.AnchorBottom = 1F;
        child.GrowHorizontal = Control.GrowDirection.Both;
        child.GrowVertical = Control.GrowDirection.Both;
        
        _window.Show();
        control.AddChild(_window);
    }
}