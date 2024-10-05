
using Godot;


/* Container that on overflow happens due to children it shirnk its contents accordingly */
[Tool]
[GlobalClass]
public partial class ScaleContainer : Container
{

    /* When a child is added add a listener to its rect changes */
    public ScaleContainer()
    {
        ChildOrderChanged += () =>
        {
            foreach (Node child in GetChildren())
            {
                if (child is Control child2D)
                {
                    child2D.ItemRectChanged += () =>
                    {
                        QueueRedraw();
                    };
                }
            }
        };
    }

    public override void _Draw()
    {
        float maxChildWidth = 0;
        float maxChildHeight = 0;
        foreach (Node child in GetChildren())
        {
            if (child is Control child2D)
            {
                if (child2D.Size.X > maxChildWidth)
                {
                    maxChildWidth = child2D.Size.X;
                }
                if (child2D.Size.Y > maxChildHeight)
                {
                    maxChildHeight = child2D.Size.Y;
                }
            }
        }
        var newSize = new Vector2(maxChildWidth, maxChildHeight);

        /* normalize newSize value based on the container size */
        var normalizedSize = new Vector2(
            Size.X / newSize.X,
            Size.Y / newSize.Y
        );

        var scale = Mathf.Min(normalizedSize.X, normalizedSize.Y);
        if (scale > 1)
        {
            scale = 1;
        }
        foreach (Node child in GetChildren())
        {
            if (child is Control child2D)
            {
                child2D.Scale = new Vector2(scale, scale);
            }
        }
    }
}