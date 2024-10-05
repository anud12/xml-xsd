using System;
using Godot;

[Tool]
[GlobalClass]
public partial class CircleShadowContainer : PanelContainer
{
    public CircleShadowContainer()
    {
        GD.Print("CircleContainer constructor");
    }

    public override void _Ready()
    {
        GD.Print("CircleContainer _Ready");
    }

    public override void _Draw()
    {
        base._Draw();
        var rect = GetRect();
        var size = rect.Size;


        var normalizedSize = size.Normalized();
        var diagonalSize = Math.Max(normalizedSize.X, normalizedSize.Y);

        var radius = Math.Max(size.X, size.Y) / (2 * diagonalSize);

        var position = new Vector2(size.X / 2, size.Y / 2);
        
        // Draw a circle based on size
        DrawCircle(position, radius, new Color(1, 1, 1, 0.3F));
    }
}