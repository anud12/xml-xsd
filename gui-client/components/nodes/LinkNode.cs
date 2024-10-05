
using System;
using System.Collections.Generic;
using System.IO;
using Godot;

[Tool]
[GlobalClass]
public partial class LinkNode : Control
{

    private Control? startNode;
    [Export]
    public Control? StartNode
    {
        get => startNode;
        set
        {
            if (startNode != null)
            {
                startNode.ItemRectChanged -= recalculate;
            }
            if (value != null)
            {
                value.ItemRectChanged += recalculate;
            }
            startNode = value;
            recalculate();
        }
    }

    private Control? endNode;
    [Export]
    public Control? EndNode
    {
        get => endNode;
        set
        {
            if (endNode != null)
            {
                endNode.ItemRectChanged -= recalculate;
            }
            if (value != null)
            {
                value.ItemRectChanged += recalculate;
            }
            endNode = value;
            recalculate();
        }
    }


    private Texture2D? texture;
    [Export]
    public Texture2D? Texture
    {
        get => texture;
        set
        {
            texture = value;
            recalculate();
        }
    }

    private int maxSteps = 0;
    [Export]
    public int MaxSteps
    {
        get => maxSteps;
        set
        {
            maxSteps = value;
            recalculate();
        }
    }

    private Godot.Collections.Dictionary<Node, int> children = new Godot.Collections.Dictionary<Node, int>();

    [Export]
    public Godot.Collections.Dictionary<NodePath, int> ChildrenByNodePath
    {
        get
        {
            /* convert value from Node to NodePath */
            var result = new Godot.Collections.Dictionary<NodePath, int>();
            foreach (var entry in children)
            {
                if (entry.Key != null)
                {
                    result[entry.Key.GetPath()] = entry.Value;
                }
            }
            return result;
        }
        set
        {
            /* convert value from NodePath to Node */
            children.Clear();
            foreach (var entry in value)
            {
                var node = GetNodeOrNull(entry.Key) as Node;
                if (node != null)
                {
                    children[node] = entry.Value;
                }
            }
            recalculate();
        }
    }


    [Export]
    public Godot.Collections.Dictionary<Node, int> ChildrenByNode
    {
        get => children;
        set
        {
            children = value;
            recalculate();
        }
    }


    [Export]
    public float Width
    {
        get => width;
        set
        {
            width = value;
            createDefaultTexture();
            recalculate();
        }
    }

    private float angle = 0;
    private float distance = 0;
    private float width = 2;
    private Vector2 startPoint = new Vector2(0, 0);
    private Vector2 endPoint = new Vector2(0, 0);

    private static Texture2D DefaultTexture;

    public LinkNode()
    {   
        if(DefaultTexture == null)
        {
            createDefaultTexture();
        }
    }

    private void createDefaultTexture()
    {
        /* Fill texture with solid color */

        Image defaultImage = Image.Create((int)width, (int)width, false, Image.Format.Rgba8);

        defaultImage.Fill(Colors.White);
        Texture2D clonedTexture = ImageTexture.CreateFromImage(defaultImage);

        /* read image from ./LinkNode.png */
        var imagePath = "res://components/nodes/LinkNode.png";
        var defaultImageTexture = GD.Load<Texture2D>(imagePath);
        if (defaultImageTexture != null)
        {
            clonedTexture = defaultImageTexture.Duplicate() as Texture2D;
        }

        if (texture != null)
        {
            clonedTexture = texture.Duplicate() as Texture2D;

        }

        float aspectRatio = (float)clonedTexture.GetWidth() / clonedTexture.GetHeight();
        Vector2 newSize;

        if (clonedTexture.GetWidth() > clonedTexture.GetHeight())
        {
            newSize = new Vector2(width, width / aspectRatio);
        }
        else
        {
            newSize = new Vector2(width * aspectRatio, width);
        }

        var image = clonedTexture.GetImage();
        image.Rotate90(ClockDirection.Clockwise);
        image.Resize((int)newSize.X, (int)newSize.Y, Image.Interpolation.Trilinear);
        DefaultTexture = ImageTexture.CreateFromImage(image);
    }

    private void recalculate()
    {
        calculateStartEndPoint();
        calculateAngle();
        adjustPositionBasedOnAngle();
        calculateAngle();
        calculateDistance();
        calculatePosition();
        calculateSize();
        arrangeChildren();
        scaleChildren();
        QueueRedraw();
    }

    public override void _EnterTree()
    {
        recalculate();
    }

    /* Calculate the start and end points of the link to be the center of the node */
    private void calculateStartEndPoint()
    {
        if (startNode != null)
        {
            startPoint = startNode.GlobalPosition + (startNode.Size / 2);
        }
        if (endNode != null)
        {
            endPoint = endNode.GlobalPosition + (endNode.Size / 2);
        }
    }

    private void calculateAngle()
    {
        if (startNode == null || endNode == null)
        {
            return;
        }
        angle = (endPoint - startPoint).Angle();
        this.Rotation = angle;
    }


    /* Adjust the position of the link 
        so that either its corners starts and ends at the closest edge of the nodes basd on angle 

    */
    private void adjustPositionBasedOnAngle()
    {
        if (startNode != null && endNode != null)
        {
            var startRect = startNode.GetGlobalRect();
            var endRect = endNode.GetGlobalRect();

            var startEdgePoint = startRect.Position + startRect.Size / 2;
            var endEdgePoint = endRect.Position + endRect.Size / 2;

            var direction = (endEdgePoint - startEdgePoint).Normalized();

            // Find the closest edge point on the start node
            if (Mathf.Abs(direction.X) > Mathf.Abs(direction.Y))
            {
                startEdgePoint.X += direction.X > 0 ? startRect.Size.X / 2 : -startRect.Size.X / 2;
            }
            else
            {
                startEdgePoint.Y += direction.Y > 0 ? startRect.Size.Y / 2 : -startRect.Size.Y / 2;
            }

            // Find the closest edge point on the end node
            if (Mathf.Abs(direction.X) > Mathf.Abs(direction.Y))
            {
                endEdgePoint.X += direction.X > 0 ? -endRect.Size.X / 2 : endRect.Size.X / 2;
            }
            else
            {
                endEdgePoint.Y += direction.Y > 0 ? -endRect.Size.Y / 2 : endRect.Size.Y / 2;
            }

            startPoint = startEdgePoint;
            endPoint = endEdgePoint;
        }
    }

    private void calculatePosition()
    {
        // Set position of the link to the start node offset by half width but keep the angle
        if (startNode != null)
        {
            this.Position = startPoint + new Vector2(0, -width / 2).Rotated(angle);
        }
    }

    private void calculateSize()
    {
        this.SetSize(new Vector2(distance, width));
    }
    private void calculateDistance()
    {
        if (startNode == null || endNode == null)
        {
            return;
        }
        distance = startPoint.DistanceTo(endPoint);
    }

    private void arrangeChildren()
    {
        if (maxSteps <= 0)
        {
            return;
        }
        var stepSize = distance / (maxSteps * 2);

        foreach (var childEntry in children)
        {
            var childNodePath = childEntry.Key as Control;
            var childIndex = (childEntry.Value * 2);
            var newPosition = startPoint + new Vector2(0, -width / 2).Rotated(angle) + new Vector2(childIndex * stepSize, 0).Rotated(angle);

            var child = childNodePath;
            if (child != null)
            {
                child.GlobalPosition = newPosition;
                GD.Print("Child Rotation: " + angle);
                child.Rotation = angle;
                child.EmitSignal(SignalName.ItemRectChanged);
                
                child.QueueRedraw();
            }

        }
    }

    /* Scale children to fit the link width by getting the max width or height and scaling the node accordingly
        make sure they do not overlap by setting by clamping the scale to the maximum childrect size
    */
    private void scaleChildren()
    {

        foreach (var childNode in children)
        {
            var child = childNode.Key as Control;
            if (child != null)
            {
                var childSize = child.Size;
                float scaleFactor = width / Mathf.Max(childSize.X, childSize.Y);
                child.Scale = new Vector2(scaleFactor, scaleFactor);
                child.QueueRedraw();
            }
        }
    }



    // Called when the node needs to render
    public override void _Draw()
    {
        if (StartNode == null || EndNode == null)
        {
            return;
        }
        if (width <= 0)
        {
            return;
        }
        /* Resize texture while keeping the aspect ratio to have either the width or height equal to width property */



        /* Use the given texture to draw a line with distance of 'distance' at angle '0' degress by tiling it */
        float filledDistance = 0;
        while (filledDistance < distance - DefaultTexture.GetWidth())
        {
            DrawTexture(DefaultTexture, new Vector2(filledDistance, 0), Colors.White);
            filledDistance += DefaultTexture.GetWidth();
        }

        /* Draw the remaining distance by culling the texture */
        if (filledDistance < distance)
        {
            float remainingDistance = distance - filledDistance;
            Rect2 sourceRect = new Rect2(0, 0, remainingDistance, DefaultTexture.GetHeight());
            Rect2 destRect = new Rect2(filledDistance, 0, remainingDistance, width);
            DrawTextureRectRegion(DefaultTexture, destRect, sourceRect);
        }  // Set custom rectangle size
    }
}