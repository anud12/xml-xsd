using System;
using System.Collections.Generic;
using System.Reflection;
using Godot;
using Guiclient.util;
using XSD;

namespace Guiclient.components.nodes;

[Tool]
[GlobalClass]
public partial class NodeExplorerButton: Button
{
    private ILinkedNode? _iLinkedNode;
    private Control Scene { get; set; }
    public Func<Control>? Clicked;

    public ILinkedNode LinkedNodeOrCollection
    {
        get => _iLinkedNode;
        set => _iLinkedNode = value;
    }
    public override void _Ready()
    {
        this.Text = "Explore";
        this.Pressed += () =>
        {
            var control = new Control();
            control.AnchorBottom = 0F;
            control.AnchorTop = 0F;
            control.AnchorLeft = 0F;
            control.AnchorRight = 0F;
            
            if (Clicked != null)
            {
                control.AddChild(Clicked());
            }
            switch (_iLinkedNode?.GetType())
            {
                case Type t when typeof(ILinkedNode).IsAssignableFrom(t):
                    // Handle ILinkedNode logic here
                    Logger.Info("LinkedNode");
                    var nodeExplorer = NodeExplorer.PackedScene.Instantiate<NodeExplorer>();
                    nodeExplorer._linkedNode = _iLinkedNode;
                    control.AddChild(nodeExplorer);
                    break;
            }
            this.SpawnWindow(control);
        };
    }
}