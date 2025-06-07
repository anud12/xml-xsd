using System;
using Godot;

namespace Guiclient.util;

public static class ButtonCreateWindowExtension
{
    public static void InstantCreateWindow(this Button control, Control child)
    {
        
        Window _window = new Window();
        _window.Hide();
        control.AddChild(_window);
        _window.MinSize = new(200, 200);
        _window.Mode = Window.ModeEnum.Windowed;
        var parentWindow = control.GetWindow();
        var centerPosition = (parentWindow.Position) + (parentWindow.Size / 2) - (_window.Size / 2);
        _window.Position = centerPosition;
        _window.CloseRequested += () =>
        {
            _window.Hide();
        };
        _window.AddChild(child);
        
        child.AnchorRight = 1F;
        child.AnchorBottom = 1F;
        child.GrowHorizontal = Control.GrowDirection.Both;
        child.GrowVertical = Control.GrowDirection.Both;
        
        control.Pressed += () =>
        {
            _window.Show();
            _window.GrabFocus();
        };
        _window.Show();
    }
    public static void CreateWindow(this Button control, Control child)
    {
        
        Window _window = new Window();
        _window.Hide();
        control.AddChild(_window);
        _window.MinSize = new(200, 200);
        _window.Mode = Window.ModeEnum.Windowed;
        var parentWindow = control.GetWindow();
        var centerPosition = (parentWindow.Position) + (parentWindow.Size / 2) - (_window.Size / 2);
        _window.Position = centerPosition;
        _window.CloseRequested += () =>
        {
            _window.Hide();
        };
        _window.AddChild(child);
        
        child.AnchorRight = 1F;
        child.AnchorBottom = 1F;
        child.GrowHorizontal = Control.GrowDirection.Both;
        child.GrowVertical = Control.GrowDirection.Both;
        
        control.Pressed += () =>
        {
            _window.Show();
            _window.GrabFocus();
        };
    }
    
    public static void CreateWindow(this Button control, Func<Control> childFunction)
    {
        
        Window _window = new Window();
        _window.Hide();
        control.AddChild(_window);
        _window.MinSize = new(200, 200);
        _window.Mode = Window.ModeEnum.Windowed;
        var parentWindow = control.GetWindow();
        var centerPosition = (parentWindow.Position) + (parentWindow.Size / 2) - (_window.Size / 2);
        _window.Position = centerPosition;
        _window.CloseRequested += () =>
        {
            _window.Hide();
        };
        bool initialized = false;
        control.Pressed += () =>
        {
            if (!initialized)
            {
                initialized = true;
                var child = childFunction();
                _window.AddChild(child);
        
                child.AnchorRight = 1F;
                child.AnchorBottom = 1F;
                child.GrowHorizontal = Control.GrowDirection.Both;
                child.GrowVertical = Control.GrowDirection.Both;
                
            }
            _window.Show();
            _window.GrabFocus();
        };
    }
}