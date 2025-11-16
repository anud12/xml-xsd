using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Godot;
using Guiclient.util;
using XSD;

namespace Guiclient.components.nodes;

public partial class LinkedNodeGraphElement<T>: GraphNode where T : ILinkedNode
{
    private T? _node;
    private LinkedNodeGraph _parentGraph;
    public LinkedNodeGraphElement(T? node, LinkedNodeGraph parentGraph)
    {
        this.Size = new(100, 100);
        _node = node;
        _parentGraph = parentGraph;
        
        
    }

    private IEnumerable<(PropertyInfo fieldInfo, int index)> GetTypeList (Type type)
    {
        var typeList = type.GetProperties()
            .Where(info => info.Name != "NodeName" && info.Name != "ParentNode")
            .Select((fieldInfo, index) => (fieldInfo, index));
        return typeList;
    }
    
    private bool _hasInit = false;
    public override void _Process(double delta)
    {
        if (_hasInit)
        {
            return;
        }

        _hasInit = true;
        var type = typeof(T);
        this.Name = _node.GetHashCode().ToString();
        this.Title = type.Name;
        var createdChildren = 0;
        
        var typeList = type.GetProperties()
            .Where(info => info.Name != "NodeName" && info.Name != "ParentNode")
            .Select((fieldInfo, index) => (fieldInfo, index));
        foreach (var (fieldInfo, index) in typeList)
        {
            
            this.SetSlotEnabledRight(index  , true);
            Logger.Info($@"index {index}");
            if (typeof(ILinkedNode).IsAssignableFrom(fieldInfo.PropertyType))
            {
                var value = fieldInfo.GetValue(_node);
                var valueType = value.GetType();
                var genericType = typeof(LinkedNodeGraphElement<>).MakeGenericType(valueType);
                // Create an instance of the generic type
                var instance = Activator.CreateInstance(genericType, value, _parentGraph);
                // Add the instance to the parent graph
                
                GraphNode toLinkedNode = (GraphNode)instance;
                
                toLinkedNode.SetSlotEnabledLeft(0, true);
                toLinkedNode.Name = value.GetHashCode().ToString();
                toLinkedNode.Ready += () =>
                {
                    var count = GetTypeList(valueType).Count();
                    var newPosition = this.PositionOffset + new Vector2(this.Size.X, 0) +
                                      new Vector2(300, createdChildren * this.Size.Y) + new Vector2(0, count * this.Size.Y);
                    toLinkedNode.PositionOffset = newPosition;
                };
                _parentGraph.AddChild((Node)instance);
                this.SetSlotEnabledRight(index  , true);
                _parentGraph.ConnectNode(this.Name, index, toLinkedNode.Name, 0);
                createdChildren += 1;
            }
            var label = new Label();
            label.Text = fieldInfo.Name;
            
            this.AddChild(label);
        }
        
    }

}