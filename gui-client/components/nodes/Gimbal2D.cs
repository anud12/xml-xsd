
using System;
using Godot;
using Guiclient.util;


/* Class that applies a its rotation reversed to its children in a 2D space */

[Tool]
[GlobalClass]
public partial class Gimbal2D : VBoxContainer
{

    private float _oldRotation = 0;
    public Gimbal2D()
    {
        ChildOrderChanged += () =>
        {
            Logger.Info("ChildOrderChanged");
            QueueRedraw();
        };
        ItemRectChanged += () =>
        {
            Logger.Info("ItemRectChanged");
            QueueRedraw();
        };
    }    

    public override void _EnterTree()
    {
        base._EnterTree();
        Logger.Info("Enter Tree");
        QueueRedraw();
    }

    public override void _Process(double delta)
    {
        base._Process(delta);
        if (Rotation == _oldRotation)
        {
            return;
        }
        _oldRotation = Rotation;
        calculate();
    }
    public override void _Draw()
    {
        base._Draw();
        calculate();
    }

    private void calculate()
    {
        Logger.Info("Calculate");
        float currentRotation = Rotation;
        Logger.Info("children: " + GetChildren().Count);
        foreach (Node child in GetChildren())
        {
            if (child is Control child2D)
            {
                child2D.QueueRedraw();
                child2D.Rotation = -currentRotation;


                /*
                    Determine the maximum size of the child's rectangle that can be fully contained within the current container rectangle at an angle.
                 */
                float angle = Mathf.Abs(currentRotation % (Mathf.Pi / 2));
                float cosAngle = Mathf.Cos(angle);
                float sinAngle = Mathf.Sin(angle);

                float containerWidth = Size.X;
                float containerHeight = Size.Y;
                float childWidth = child2D.Size.X;
                float childHeight = child2D.Size.Y;

                float maxWidth = (containerWidth * cosAngle) + (containerHeight * sinAngle);
                float maxHeight = (containerHeight * cosAngle) + (containerWidth * sinAngle);

                float scale = Mathf.Min(maxWidth / childWidth, maxHeight / childHeight);

                child2D.Scale = new Vector2(scale, scale);


                /* set pivot offset to the center of child */
                child2D.PivotOffset = child2D.Size / 2;



                /* move child to the center of the container at current angle offset */

                Vector2 containerCenter = Size / 2;
                Vector2 childCenter = child2D.Size / 2;
                Vector2 offset = containerCenter - childCenter;
                child2D.Position = offset;
            }
        }
    }

}