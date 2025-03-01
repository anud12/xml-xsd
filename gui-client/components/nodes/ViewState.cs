using System.Xml.Linq;
using Godot;
using util.dataStore;

namespace Guiclient.components.nodes;
[Tool]
[GlobalClass]
public partial class ViewState: Button
{
    private Window _window = new Window();
    
    public override void _Ready()
    {
        _window.MinSize = new(200, 200);
        _window.Mode = Window.ModeEnum.Windowed;
        
        var parentWindow = GetWindow();
        var centerPosition = (parentWindow.Position) + (parentWindow.Size / 2) - (_window.Size / 2);
        _window.Position = centerPosition;
        var codeEdit = new CodeEdit();
        StoreWorld_Step.instance.data?.OnChange(step =>
        {
            GD.Print("ViewState callback called");
            var code = step.SerializeIntoRawNode().SerializeToString("world_step");
            codeEdit.Text = XElement.Parse(code).ToString();
        });
        
        codeEdit.AnchorRight = 1F;
        codeEdit.AnchorBottom = 1F;
        codeEdit.GrowHorizontal = GrowDirection.Both;
        codeEdit.GrowVertical = GrowDirection.Both;
        
        StoreWorld_Step.instance.OnSet((step, action) =>
        {
            var code = step.SerializeIntoRawNode().SerializeToString("world_step");
            codeEdit.Text = XElement.Parse(code).ToString();
        });
        _window.AddChild(codeEdit);
        
        _window.CloseRequested += () =>
        {
            RemoveChild(_window);
        };
        
        Text = "View state";
        Pressed += () =>
        {
            _window.GrabFocus();
            _window.MoveToCenter();
            AddChild(_window);
        };

        
    }
}