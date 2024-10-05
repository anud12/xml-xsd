using System;
using Godot;

[Tool]
[GlobalClass]
public partial class CircleContainer : Container
{
    private float radius = 50;
    [Export]
    public float Radius
    {
        get => radius;
        set
        {
            radius = value;
            OnRadiusChanged();
        }
    }

    private Color _color = new Color(1, 1, 1, 1);
    [Export]
    public Color Color
    {
        get {
            return _color;
        }
        set
        {
            QueueRedraw();
            _color = value;
        }
    }

    //enter tree callback
    public override void _EnterTree()
    {
        GD.Print("CircleContainer constructor");
        GetRect().Grow(0);
        updateMaxSize();
        updateChild();
        //connect the child_entered_tree signal
        QueueRedraw();
    }

    public void OnRadiusChanged()
    {

        updateMaxSize();
        updateChild();
        QueueRedraw();
    }
    private void updateChild()
    {
        var maxSize = new Vector2(radius * 2, radius * 2);
        GD.Print("maxSize: " + maxSize);
        var childSize = new Vector2(maxSize.X * 0.7071F, maxSize.Y * 0.7071F);
        // Update size of children
        foreach (Node child in GetChildren())
        {
            GD.Print("child className: " + child.GetType().Name);
            if (child is Control control)
            {
                GD.Print("child is Control");
                control.Position = new Vector2(maxSize.X * 0.1464F, maxSize.Y * 0.1464F);
                control.Size = childSize;
                control.AnchorTop = 0F;
                control.AnchorLeft = 0F;
                control.QueueRedraw();
            }
        }
    }

    private void updateMaxSize()
    {

        var maxSize = new Vector2(radius * 2, radius * 2);
        this.Size = maxSize;
        //update minimum size
        CustomMinimumSize = maxSize;
    }

    public override void _Draw()
    {
        base._Draw();
        var rect = GetRect();
        var size = rect.Size;



        var position = new Vector2(size.X / 2, size.Y / 2);

        // Draw a circle based on size
        DrawCircle(position, radius, Color);
    }
}