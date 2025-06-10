using System;
using System.Collections;
using System.Reflection;
using Godot;
using Guiclient.components.nodes;
using XSD;

public partial class CollectionNodeExplorer : PanelContainer
{
	public static PackedScene PackedScene = GD.Load<PackedScene>("res://components/CollectionNodeExplorer.tscn");
	

	public string? _nodeName;
	public Type ListType;
	public ILinkedNode? _linkedNode;
	public PropertyInfo PropertyInfo;
	private Container? _childContainer;
	public CheckButton _expandButton;
	private Button _addButton;

	// Called when the node enters the scene tree for the first time.
	public override void _Ready()
	{
		_addButton = GetNode<Button>("%AddButton");
		_addButton.Pressed += () =>
		{
			AddChildren();
		};
		var _refreshButton = GetNode<Button>("%RefreshButton");
		_refreshButton.Pressed += () =>
		{
			Populate();
		};
		var _nodeExplorerButton = GetNode<NodeExplorerButton>("%NodeExplorerButton");
		_nodeExplorerButton.Clicked += () =>
		{
			// Handle LinkedNodeCollection logic here
			GD.Print("LinkedNodeCollection");
			var collectionNode = CollectionNodeExplorer.PackedScene.Instantiate<CollectionNodeExplorer>();
			collectionNode._linkedNode = _linkedNode;
			collectionNode.PropertyInfo = this.PropertyInfo;
			return collectionNode;
		};
		
		_expandButton = GetNode<CheckButton>("%NodeName");
		var nameLabel = GetNode<CheckButton>("%NodeName");
		nameLabel.Text = _nodeName ?? "null";
		
		_childContainer = GetNode<Container>("%ChildContainer");
		_childContainer.Visible = false;
		_expandButton.ButtonPressed = false;
		_addButton.Visible = false;
		_expandButton.Toggled += (pressed) =>
		{
			_childContainer.Visible = pressed;
			_addButton.Visible = pressed;
		};
		//
		PopulateChildren();
	}

	public void AddChildren()
	{
		ILinkedNodeCollection? collection = (ILinkedNodeCollection?)this.PropertyInfo.GetValue(_linkedNode);
		if (collection == null)
		{
			collection = (ILinkedNodeCollection?)Activator.CreateInstance(this.PropertyInfo.PropertyType);
			
		}
		ILinkedNode node = Activator.CreateInstance(collection.GetType().GetGenericArguments()[0]) as ILinkedNode;
		node.ParentNode = _linkedNode;
		collection.AddILinkedNode(node);
		_linkedNode.SetChild(collection);
		AddInstance(node);
	}
	
	public void DisableScroll()
	{
		var scrollContainer = GetNode<ScrollContainer>("%ScrollContainer");
		scrollContainer.VerticalScrollMode = ScrollContainer.ScrollMode.Disabled;
		scrollContainer.HorizontalScrollMode = ScrollContainer.ScrollMode.Disabled;
	}

	private void Populate()
	{
		PopulateChildren();
	}
	
	private void AddInstance(ILinkedNode node)
	{
		var instance = NodeExplorer.PackedScene.Instantiate();
		var nodeExplorer = instance.GetNode<NodeExplorer>("./");
		nodeExplorer.SetAnchorsPreset(LayoutPreset.TopWide);
		nodeExplorer.SizeFlagsVertical = SizeFlags.Fill;
		nodeExplorer._linkedNode = node;
		nodeExplorer.Title = node.ParentNode.BuildIndexForChild(node) + " - " + node.GetType().Name;
		nodeExplorer.DisableScroll();

		_childContainer.AddChild(instance);
		nodeExplorer._expandButton.ButtonPressed = false;
	}
	
	private void PopulateChildren()
	{
		foreach (var child in _childContainer.GetChildren())
		{
			_childContainer.RemoveChild(child);
		}

		dynamic _LinkedNodeCollection = this.PropertyInfo.GetValue(_linkedNode);
		int index = 0;
		foreach (var node in _LinkedNodeCollection)
		{
			AddInstance(node);
		}
	}
}
