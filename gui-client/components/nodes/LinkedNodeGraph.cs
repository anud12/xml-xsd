using System;
using System.Reflection;
using Godot;
using XSD;

namespace Guiclient.components.nodes;

public partial class LinkedNodeGraph: GraphEdit
{
    private ILinkedNode? _root; 
    public LinkedNodeGraph(ILinkedNode? root)
    {
        _root = root;
    }
    public override void _Ready()
    {
        base._Ready();
        if (_root == null)
        {
            return;
        }
        var valueType = _root.GetType();
        var genericType = typeof(LinkedNodeGraphElement<>).MakeGenericType(valueType);
        // Create an instance of the generic type
        var instance = Activator.CreateInstance(genericType, _root, this);
        this.AddChild((Node)instance);
        
    }
}