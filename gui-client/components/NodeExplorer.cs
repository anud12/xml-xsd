using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Godot;
using Guiclient.components.nodes;
using XSD;

public partial class NodeExplorer : PanelContainer
{
    public static PackedScene PackedScene = GD.Load<PackedScene>("res://components/NodeExplorer.tscn");

    public ILinkedNode? _linkedNode = new world_step()
    {
        rule_group = new ()
        {
        }
    };

    private GridContainer? _attributeContainer;
    private Container? _childContainer;
    public CheckButton _expandButton;
    public string? Title;

    // Called when the node enters the scene tree for the first time.
    public override void _Ready()
    {
        _expandButton = GetNode<CheckButton>("%NodeName");
        var nameLabel = GetNode<CheckButton>("%NodeName");
        var _refreshButton = GetNode<Button>("%RefreshButton");
        _refreshButton.Pressed += () =>
        {
            Populate();
        };
        _attributeContainer = GetNode<GridContainer>("%AttributeContainer");
        _childContainer = GetNode<Container>("%ChildContainer");
        
        _attributeContainer.Visible = _expandButton.ButtonPressed;
        _childContainer.Visible = _expandButton.ButtonPressed;
        _expandButton.Toggled += (pressed) =>
        {
            _attributeContainer.Visible = pressed;
            _childContainer.Visible = pressed;
        };

        var _nodeExplorerButton = GetNode<NodeExplorerButton>("%NodeExplorerButton");
        _nodeExplorerButton.LinkedNodeOrCollection = this._linkedNode;
        
        foreach (var child in _attributeContainer.GetChildren())
        {
            _attributeContainer.RemoveChild(child);
        }

        foreach (var child in _childContainer.GetChildren())
        {
            _childContainer.RemoveChild(child);
        }

        if (_linkedNode == null)
        {
            return;
        }


        nameLabel.Text = Title ?? _linkedNode.GetType().Name;
        Populate();
    }

    private void Populate()
    {
        PopulateAttributes();
        PopulateChildren();
    }
    public void DisableScroll()
    {
        var scrollContainer = GetNode<ScrollContainer>("%ScrollContainer");
        scrollContainer.VerticalScrollMode = ScrollContainer.ScrollMode.Disabled;
        scrollContainer.HorizontalScrollMode = ScrollContainer.ScrollMode.Disabled;
    }

    private Button AddButton(PropertyInfo propertyInfo)
    {
        var createNewButton = new Button();
        createNewButton.Text = "Add";
        createNewButton.Pressed += () =>
        {
            if (propertyInfo.PropertyType == typeof(string))
            {
                var newValue = string.Empty;
                // propertyInfo.SetValue(_linkedNode, newValue);
                _linkedNode.SetAttribute(propertyInfo.Name, newValue);
                Populate();
                return;
            }

            if (propertyInfo.PropertyType == typeof(int))
            {
                int? newValue = null;
                _linkedNode.SetAttribute(propertyInfo.Name, newValue.ToString());
                Populate();
                return;
            }

            var newProperty = Activator.CreateInstance(propertyInfo.PropertyType);
            _linkedNode.SetChild(newProperty);
            Populate();
        };
        return createNewButton;
    }

    
    private Button AttributeClearButton(PropertyInfo propertyInfo)
    {
        var createNewButton = new Button();
        createNewButton.Text = "Clear";
        createNewButton.Pressed += () =>
        {
            _linkedNode.SetAttribute(propertyInfo.Name, null);
            PopulateAttributes();
        };
        return createNewButton;
    }
    
    private Button ChildClearButton(PropertyInfo propertyInfo)
    {
        var createNewButton = new Button();
        createNewButton.Text = "Clear";
        createNewButton.Pressed += () =>
        {
            _linkedNode.ClearChild(propertyInfo.GetValue(_linkedNode));
            PopulateAttributes();
        };
        return createNewButton;
    }

    private void PopulateChildren()
    {
        IEnumerable<PropertyInfo> propertyInfos = _linkedNode.GetType().GetProperties()
            .Where(info => info.Name != "ParentNode")
            .Where(info => info.Name != "NodeName")
            .Select((fieldInfo) => fieldInfo);

        foreach (var child in _childContainer.GetChildren())
        {
            _childContainer.RemoveChild(child);
        }

        foreach (var propertyInfo in propertyInfos)
        {
            var objectValue = propertyInfo.GetValue(_linkedNode);

            switch (propertyInfo.PropertyType)
            {
                case Type t when typeof(ILinkedNode).IsAssignableFrom(t):
                    HandleLinkedNodeChild(propertyInfo, objectValue);
                    break;
                case Type t when t.IsGenericType && t.GetGenericTypeDefinition() == typeof(LinkedNodeCollection<>):
                    HandleLinkedNodeCollectionChild(propertyInfo);
                    break;
            }
        }
    }

    private void HandleLinkedNodeChild(PropertyInfo propertyInfo, object? objectValue)
    {
        var instance = PackedScene.Instantiate();
        var nodeExplorer = instance.GetNode<NodeExplorer>("./");
        nodeExplorer.SetAnchorsPreset(LayoutPreset.TopWide);
        nodeExplorer.SizeFlagsVertical = SizeFlags.Fill;
        nodeExplorer._linkedNode = objectValue as ILinkedNode;
        nodeExplorer.DisableScroll();

        _childContainer.AddChild(instance);
        nodeExplorer._expandButton.ButtonPressed = false;
    }

    private void HandleLinkedNodeCollectionChild(PropertyInfo propertyInfo)
    {
        
        var instance = CollectionNodeExplorer.PackedScene.Instantiate();
        var nodeExplorer = instance.GetNode<CollectionNodeExplorer>("./");
        nodeExplorer.SetAnchorsPreset(LayoutPreset.TopWide);
        nodeExplorer.SizeFlagsVertical = SizeFlags.Fill;
        nodeExplorer._linkedNode = _linkedNode;
        nodeExplorer.PropertyInfo = propertyInfo;
        nodeExplorer._nodeName = propertyInfo.Name;
        nodeExplorer.ListType = propertyInfo.PropertyType;
        nodeExplorer.DisableScroll();

        _childContainer.AddChild(instance);
    }


    private void PopulateAttributes()
    {
        IEnumerable<PropertyInfo> propertyInfos = _linkedNode.GetType().GetProperties()
            .Where(info => info.Name != "ParentNode")
            .Where(info => info.Name != "NodeName")
            .Select((fieldInfo) => fieldInfo);

        foreach (var child in _attributeContainer.GetChildren())
        {
            _attributeContainer.RemoveChild(child);
        }


        foreach (var propertyInfo in propertyInfos)
        {
            var objectValue = propertyInfo.GetValue(_linkedNode);

            switch (objectValue)
            {
                case null:
                    HandleNullProperty(propertyInfo);
                    break;
                case string:
                    HandleStringProperty(propertyInfo, objectValue);
                    break;
                case int:
                    HandleIntProperty(propertyInfo, objectValue);
                    break;
                case ILinkedNode:
                    HandleLinkedNodeProperty(propertyInfo, objectValue);
                    break;
            }
        }
    }


    private void HandleNullProperty(PropertyInfo propertyInfo)
    {
        var nameLabel = new Label();
        nameLabel.Text = propertyInfo.Name;
        _attributeContainer.AddChild(nameLabel);
        _attributeContainer.AddChild(new Label() { Text = "NULL" });
        _attributeContainer.AddChild(AddButton(propertyInfo));
    }

    private void HandleStringProperty(PropertyInfo propertyInfo, object? objectValue)
    {
        var nameLabel = new Label();
        nameLabel.Text = propertyInfo.Name;
        _attributeContainer.AddChild(nameLabel);

        if (propertyInfo.CanWrite)
        {
            var valueInput = new LineEdit();
            valueInput.SizeFlagsVertical = SizeFlags.Fill;
            valueInput.Text = objectValue?.ToString() ?? "null";
            valueInput.TextChanged += (newValue) =>
            {
                _linkedNode.SetAttribute(propertyInfo.Name, newValue);
            };
                
            _attributeContainer.AddChild(valueInput);
        }
        else
        {
            var valueLabel = new Label();
            valueLabel.Text = propertyInfo.GetValue(_linkedNode)?.ToString() ?? "null";
            _attributeContainer.AddChild(valueLabel);
        }

        _attributeContainer.AddChild(AttributeClearButton(propertyInfo));
    }

    private void HandleIntProperty(PropertyInfo propertyInfo, object? objectValue)
    {
        var nameLabel = new Label();
        nameLabel.Text = propertyInfo.Name;
        _attributeContainer.AddChild(nameLabel);

        if (propertyInfo.CanWrite)
        {
            var valueInput = new SpinBox();
            valueInput.SizeFlagsVertical = SizeFlags.Fill;
            valueInput.Value = Convert.ToDouble(objectValue ?? 0);
            valueInput.ValueChanged += (newValue) =>
            {
                GD.Print($"New value ${newValue}");
                _linkedNode.SetAttribute(propertyInfo.Name, newValue.ToString());
            };
            _attributeContainer.AddChild(valueInput);
        }
        else
        {
            var valueLabel = new Label();
            valueLabel.Text = propertyInfo.GetValue(_linkedNode)?.ToString() ?? "null";
            _attributeContainer.AddChild(valueLabel);
        }

        _attributeContainer.AddChild(ChildClearButton(propertyInfo));
    }

    private void HandleLinkedNodeProperty(PropertyInfo propertyInfo, object? objectValue)
    {
        var value = objectValue;
        var instance = PackedScene.Instantiate();
        var nodeExplorer = instance.GetNode<NodeExplorer>("./");
        nodeExplorer.SetAnchorsPreset(LayoutPreset.TopWide);
        nodeExplorer._linkedNode = value as ILinkedNode;
        nodeExplorer.DisableScroll();

        _childContainer.AddChild(instance);
    }
}