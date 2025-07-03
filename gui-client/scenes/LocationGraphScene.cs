using System;
using System.Collections.Generic;
using System.Linq;
using Godot;
using Guiclient.util;
using Guiclient.XSDWebsocketClient;
using util;
using util.dataStore;
using XSD;
using XSD.Ntype__node_graph__selection;
using XSD.Nworld_step.Nactions;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph;
using link_to = XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to;
using location_graph = XSD.Nworld_step.Ndata.Nlocation.location_graph;

public partial class LocationGraphScene : Control
{
    public static PackedScene PackedScene = GD.Load<PackedScene>("res://scenes/LocationGraphScene.tscn");

    public static float NODE_SIZE = 650;
    public static float LINK_SIZE = 50;

    private String locationGraphId;
    private List<Action> unsubscribeList = new List<Action>();

    private Dictionary<Vector2, Control> _vectorNodeDictionary = new Dictionary<Vector2, Control>();
    private ListSizeMonitor<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> _nodeListSizeMonitor = new();
    private Node? _nodeContainer;
    private Node? _linkContainer;
    private Node? _personContainer;
    private Dictionary<string, Node> _nodeById = new Dictionary<string, Node>();
    private location_graph? _locationGraph;
    private world_step? _worldStep;
    private ListSizeMonitor<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to> _linkListSizeMonitor = new ListSizeMonitor<link_to>();
    private Dictionary<string, LinkNode> _linkById = new Dictionary<string, LinkNode>();

    public void setLocationGraphId(String locationGraphId)
    {
        this.locationGraphId = locationGraphId;
    }

    public static bool stop = false;

    // Called when the node enters the scene tree for the first time.
    public override void _Ready()
    {
        //set title of the node

        var title = GetNode<Label>("%Title");
        title.Text = "Location Graph: " + locationGraphId;

        _nodeContainer = GetNode<Node>("%NodeContainer");
        _personContainer = GetNode<Node>("%PersonContainer");
        _linkContainer = GetNode<Node>("%LinkContainer");
        registerNodeMonitorChanges();
        registerLinks();
        Action? updateSubscription = null; 
        StoreWorld_Step.instance.OnSet(this, (data, unsubscribe) =>
        {
            if (IsInstanceValid(this) == false)
            {
                unsubscribe();
                updateSubscription?.Invoke();
                return;
            }

            stop = true;
            //clear the viewport container
            updateSubscription= data?.OnSelfChange(UpdateMonitors);
            UpdateMonitors(data);
            
            // _nodeContainer.GetChildren().ToList().ForEach(child => _nodeContainer.RemoveChild(child));
            //TODO: Implement person container
            // personContainer.GetChildren().ToList().ForEach(child => personContainer.RemoveChild(child));
            // _linkContainer.GetChildren().ToList().ForEach(child => _linkContainer.RemoveChild(child));
            // var nodesById = loadNodes(data);
            // nodesById.Item2.ToList().ForEach(node => nodeContainer.AddChild(node));
            // var links = LoadLinks(data, nodesById.Item1);
            // if (links.DefaultIfEmpty() != null)
            // {
            // 	var list = links.DefaultIfEmpty().ToList();
            // 	list.ForEach(link => _linkContainer.AddChild(link));
            // }
        });
    }

    // Called every frame. 'delta' is the elapsed time since the previous frame.
    public override void _Process(double delta)
    {
    }

    public void ClearSubscriptions()
    {
        unsubscribeList.ForEach(unsubscribe => unsubscribe());
        unsubscribeList.Clear();
    }

    private void UpdateMonitors(world_step data)
    {
        Logger.Info("Updating monitors for location graph: " + locationGraphId);
        _locationGraph =
            data?.data?.location?.location_graph.First(locationGraph => locationGraph.id == locationGraphId);
        _worldStep = data;

        _nodeListSizeMonitor.Update(_locationGraph?.node);
        var linkList = _locationGraph?.node.SelectMany(node => node.links?.link_to ?? new()).ToList();
        _linkListSizeMonitor.Update(linkList);

    }
    private (Dictionary<string, Control>, IEnumerable<Node>) loadNodes(world_step worldStep)
    {
        Dictionary<string, Control> nodeById = new Dictionary<string, Control>();
        Dictionary<Vector2, Control> node2DVector2D = new Dictionary<Vector2, Control>();


        // var nodeList = CreateComponents(worldStep, locagionGraph, nodeById, node2DVector2D);

        var nodeList = worldStep.data.location?.location_graph
            .Where(location_graph => location_graph.id == this.locationGraphId).SelectMany(location_graph =>
            {
                return CreateComponents(worldStep, location_graph, nodeById, node2DVector2D);
            });
        return (nodeById, nodeList);
    }

    private IEnumerable<Node> CreateComponents(world_step worldStep, location_graph location_graph,
        Dictionary<string, Control> nodeById, Dictionary<Vector2, Control> node2DVector2D)
    {
        return location_graph.node.SelectMany(node =>
        {
            var position = node.position;
            var packedScene = LocationGraphNodeComponent.PackedScene.Instantiate();
            var locationGraphNodeComponent = packedScene.GetNode<LocationGraphNodeComponent>("./");
            nodeById[node.id] = locationGraphNodeComponent;
            //set position of the node based on the offest returned by getOffset
            locationGraphNodeComponent.Update(node);
            locationGraphNodeComponent.setOnCreateAdjacentButtonPressed(node => AddAdjacent(node));
            locationGraphNodeComponent.setOnTeleportToButtonPressed(node => TeleportTo(node));
            locationGraphNodeComponent.setOnPathToButtonPressed(node => PathTo(node));

            var newPosition = new Vector2((float)position.x * NODE_SIZE, (float)position.y * NODE_SIZE);
            newPosition += locationGraphNodeComponent.getOffset();
            if (node2DVector2D.ContainsKey(newPosition))
            {
                var node2D = node2DVector2D[newPosition];
                node2D.AddChild(locationGraphNodeComponent);
                var childrenSize = node2D.GetChildren().Count;

                var tableScale = 1 + (int)Math.Sqrt(childrenSize - 1);

                //iterate over children of node2d with index

                for (int i = 0; i < childrenSize; i++)
                {
                    var child = node2D.GetChild(i);
                    if (child is LocationGraphNodeComponent)
                    {
                        var chilLocationGraphNodeComponent = (LocationGraphNodeComponent)child;
                        chilLocationGraphNodeComponent.Scale = new Vector2(1f / tableScale, 1f / tableScale);
                        chilLocationGraphNodeComponent.Position = new Vector2(NODE_SIZE / tableScale * (i % tableScale),
                            NODE_SIZE / tableScale * (i / tableScale));
                    }
                }

                return new Node[] { };
            }
            else
            {
                var node2D = new Container();
                node2D.Size = new Vector2(NODE_SIZE, NODE_SIZE);
                node2D.Position = newPosition;
                node2D.AddChild(locationGraphNodeComponent);
                node2DVector2D[newPosition] = node2D;
                return new Node[] { node2D };
            }
        });
    }

    private void AddAdjacent(node node)
    {
        Logger.Info("Adding adjacent to " + node.id);

        var createAdjacent = new location_graph__node__create_adjacent
        {
            location_graph_id_ref = _locationGraph.id,
            node_id_ref = node.id,
        };
        XSDWebSocketClient.instance.data?.SendNode(_worldStep.actionsOrCreate, createAdjacent);
        // worldStep.actionsOrCreate.location_graph__node__create_adjacent.Add(createAdjacent);
        // LoadWorldStep.executeNextStep();
    }

    private void TeleportTo(node node)
    {
        Logger.Info("Teleporting to " + node.id);

        var teleport = new person__teleport
        {
            person_id_ref = StoreSession.mainPersonId.data,
            location_graph = new XSD.Nworld_step.Nactions.Nperson__teleport.location_graph
            {
                location_graph_id_ref = _locationGraph.id,
                node_id_ref = node.id,
            }
        };
        XSDWebSocketClient.instance.data?.SendNode(_worldStep.actionsOrCreate, teleport);
        // worldStep.actionsOrCreate.person__teleport = teleport;
        // LoadWorldStep.executeNextStep();
    }

    private void PathTo(node node)
    {
        Logger.Info("Teleporting to " + node.id);

        var action = new person__move_to()
        {
            person_id_ref = StoreSession.mainPersonId.data,
        };

        action.find_path_towards = new type__node_graph__selection
        {
            has__node_graph_id = new has__node_graph_id
            {
                node_graph_id_ref = node.id
            }
        };
        XSDWebSocketClient.instance.data?.SendNode(_worldStep.actionsOrCreate, action);
        // worldStep.actionsOrCreate.person__move_to.Add(action);
        // LoadWorldStep.executeNextStep();
    }

    
    private void registerNodeMonitorChanges()
    {
        var computePosition = (node node) =>
        {
            var position = node.position;
            var newPosition = new Vector2((float)position.x * NODE_SIZE, (float)position.y * NODE_SIZE);
            return newPosition;
        };
        var resizeNodeContainer = (Control node2D) =>
        {
            var childrenSize = node2D.GetChildren().Count;
            var tableScale = 1 + (int)Math.Sqrt(childrenSize - 1);
            //iterate over children of node2d with index

            for (int i = 0; i < childrenSize; i++)
            {
                var child = node2D.GetChild(i);
                if (child is LocationGraphNodeComponent)
                {
                    var chilLocationGraphNodeComponent = (LocationGraphNodeComponent)child;
                    chilLocationGraphNodeComponent.Scale = new Vector2(1f / tableScale, 1f / tableScale);
                    chilLocationGraphNodeComponent.Position = new Vector2(NODE_SIZE / tableScale * (i % tableScale),
                        NODE_SIZE / tableScale * (i / tableScale));
                }
            }
        };
        _nodeListSizeMonitor.OnDecrease += (node, i) =>
        {
            Logger.Info("_nodeListSizeMonitor.OnDecrease: " + node.id);
            if (!_nodeById.ContainsKey(node.id))
            {
                Logger.Error("Node not found: " + node.id);
                return;
            }
            var godotNode = _nodeById[node.id];
            var parent = godotNode.GetParent();
            parent.RemoveChild(godotNode);
            _nodeById.Remove(node.id);
            _vectorNodeDictionary.Remove(computePosition(node));
            godotNode.Free();
            resizeNodeContainer(parent as Control ?? throw new InvalidOperationException());
        };
        _nodeListSizeMonitor.OnUpdateWithOld += (oldNode, node, i) =>
        {

            var locationGraphNodeComponent = _nodeById[node.id] as LocationGraphNodeComponent;
            Logger.Info("_nodeListSizeMonitor.OnItemReplaced: " + oldNode.id + " with " + node.id);
            locationGraphNodeComponent.Update(node);
            var newPosition = computePosition(node);
            if (_vectorNodeDictionary.ContainsKey(newPosition))
            {
                var node2D = _vectorNodeDictionary[newPosition];
                node2D.AddChild(locationGraphNodeComponent);
                resizeNodeContainer(node2D);
            }
            else
            {
                var node2D = new Container();
                node2D.Size = new Vector2(NODE_SIZE, NODE_SIZE);
                node2D.Position = newPosition;
                node2D.AddChild(locationGraphNodeComponent);
                _vectorNodeDictionary[newPosition] = node2D;
                _nodeContainer?.AddChild(node2D);
            }
        };
        _nodeListSizeMonitor.OnIncrease += (node, i) =>
        {
            Logger.Info("_nodeListSizeMonitor.OnIncrease: " + node.id);
            var packedScene = LocationGraphNodeComponent.PackedScene.Instantiate();
            var locationGraphNodeComponent = packedScene.GetNode<LocationGraphNodeComponent>("./");
            _nodeById[node.id] = locationGraphNodeComponent;
            locationGraphNodeComponent.setOnCreateAdjacentButtonPressed(node => AddAdjacent(node));
            locationGraphNodeComponent.setOnTeleportToButtonPressed(node => TeleportTo(node));
            locationGraphNodeComponent.setOnPathToButtonPressed(node => PathTo(node));
            var newPosition = computePosition(node);
            if (_vectorNodeDictionary.ContainsKey(newPosition))
            {
                var node2D = _vectorNodeDictionary[newPosition];
                node2D.AddChild(locationGraphNodeComponent);
                resizeNodeContainer(node2D);
            }
            else
            {
                var node2D = new Container();
                node2D.Size = new Vector2(NODE_SIZE, NODE_SIZE);
                node2D.Position = newPosition;
                node2D.AddChild(locationGraphNodeComponent);
                _vectorNodeDictionary[newPosition] = node2D;
                _nodeContainer?.AddChild(node2D);
            }
            locationGraphNodeComponent.Update(node);
        };
    }
    
    
    private void registerLinks()
    {
        var getParentNode = (link_to linkTo) => linkTo.ParentNode?.ParentNode as node ??
                                                throw new InvalidOperationException("Parent node is not a node");

        var getUniqueId = (link_to linkTo) =>
        {
            var parent = getParentNode(linkTo);
            return $"{parent.id}->{linkTo.node_id_ref}";
        };
        var update = (LinkNode linkNode, link_to linkTo) =>
        {
            var startNodeElement = getParentNode(linkTo);
            _nodeById.TryGetValue(linkTo.node_id_ref, out var endNode);
            if (endNode == null)
            {
                return;
            }
            var startNode = _nodeById[startNodeElement.id];

            linkNode.StartNode = startNode as Control ??
                                 throw new InvalidOperationException("Start node is not a control");
            linkNode.EndNode = endNode as Control ?? throw new InvalidOperationException("End node is not a control");
            linkNode.Width = LINK_SIZE;
            linkNode.MaxSteps = linkTo.total_progress - 1;

            linkTo.people?.person?.ForEach(person =>
                {
                    var personId = person.person_id_ref;
                    var personData = _worldStep.data.people?.person?.Where(person => person.id == personId)
                        .First();
                    var personScene = PersonComponent.PackedScene.Instantiate();
                    var personComponent = personScene.GetNode<PersonComponent>("./");
                    personComponent.InitializeFromId(personId);

                    var personContainer = new Gimbal2D();
                    personContainer.Rotation = 0;
                    personContainer.Size = new Vector2(NODE_SIZE, NODE_SIZE);
                    personContainer.AddChild(personComponent);

                    linkNode.ChildrenByNode.Add(personContainer, person.accumulated_progress - 1);
                    _personContainer.AddChild(personContainer);
                }
            );
        };
        _linkListSizeMonitor.OnDecrease += (linkTo, i) =>
        {
            Logger.Info("_linkListSizeMonitor.OnDecrease: " + linkTo.node_id_ref);
            var uniqueId = getUniqueId(linkTo);
            if (!this._linkById.TryGetValue(uniqueId, out var node))
            {
                Logger.Error("LinkNode not found for uniqueId: " + uniqueId);
                return;
            }
            var parent = node.GetParent();
            parent.RemoveChild(node);
            _linkById.Remove(uniqueId);
        };
        _linkListSizeMonitor.OnUpdate += (linkTo, i) =>
        {
            Logger.Info("_linkListSizeMonitor.OnUpdate: " + linkTo.node_id_ref);
            var uniqueId = getUniqueId(linkTo);
            if (!this._linkById.TryGetValue(uniqueId, out var linkNode))
            {
                return;
            }
            update(linkNode, linkTo);
        };
        this._linkListSizeMonitor.OnIncrease += (linkTo, i) =>
        {
            Logger.Info("_linkListSizeMonitor.OnIncrease: " + linkTo.node_id_ref);
            var linkNode = new LinkNode();
            var uniqueId = getUniqueId(linkTo);
            this._linkById[uniqueId] = linkNode;
            update(linkNode, linkTo);
            _linkContainer.AddChild(linkNode);
        };
    }

    private IEnumerable<Node> LoadLinks(world_step worldStep, Dictionary<string, Control> nodesById)
    {
        var personContainerNode = GetNode<Node>("%PersonContainer");
        IEnumerable<Node> nodeList = worldStep.data?.location?.location_graph
            .Where(location_graph => location_graph.id == locationGraphId)
            .SelectMany(location_graph => location_graph.node)
            .SelectMany(startNodeElement => startNodeElement.links?.link_to.SelectMany(linkTo =>
            {
                var endNode = nodesById[linkTo.node_id_ref];
                var startNode = nodesById[startNodeElement.id];
                var linkNode = new LinkNode();

                linkNode.StartNode = startNode;
                linkNode.EndNode = endNode;
                linkNode.Width = LINK_SIZE;
                linkNode.MaxSteps = linkTo.total_progress - 1;

                linkTo.people?.person?.ForEach(person =>
                    {
                        var personId = person.person_id_ref;
                        var personData = worldStep.data.people?.person?.Where(person => person.id == personId)
                            .First();
                        var personScene = PersonComponent.PackedScene.Instantiate();
                        var personComponent = personScene.GetNode<PersonComponent>("./");
                        personComponent.InitializeFromId(personId);

                        var personContainer = new Gimbal2D();
                        personContainer.Rotation = 0;
                        personContainer.Size = new Vector2(NODE_SIZE, NODE_SIZE);
                        personContainer.AddChild(personComponent);

                        linkNode.ChildrenByNode.Add(personContainer, person.accumulated_progress - 1);
                        personContainerNode.AddChild(personContainer);
                    }
                );

                List<Node> returnList = new List<Node>
                {
                    linkNode
                };
                return returnList;
            }) ?? new List<Node>());
        return nodeList ?? Enumerable.Empty<Node>();
    }

    private void AddSteps(Line2D line2D, link_to linkTo)
    {
        var totalProgress = linkTo.total_progress - 1;

        var start = line2D.Points[0];
        var end = line2D.Points[1];

        float totalLength = (start - end).Length();
        float interval = totalLength / (float)totalProgress;
        Vector2 direction = (end - start).Normalized();

        for (int i = 0; i < (totalProgress); i++)
        {
            Vector2 position = start + direction * (i * interval);
            var label = new Label
            {
                Text = linkTo.total_progress.ToString() + "(" + i + ")",
                // Text = "",
                Size = new Vector2(NODE_SIZE, NODE_SIZE),
            };
            line2D.AddChild(label);
            label.Position = position;
            label.HorizontalAlignment = HorizontalAlignment.Center;
            label.Set("theme_override_font_sizes/font_size", NODE_SIZE / 6);
        }
    }

    private void AddPersons(Line2D line2D, link_to linkTo, world_step world_Step)
    {
        var totalProgress = (linkTo.total_progress - 1) * 2;

        var start = line2D.Points[0];
        var end = line2D.Points[1];

        float totalLength = (start - end).Length();
        float interval = totalLength / (float)totalProgress;
        Vector2 direction = (end - start).Normalized();

        for (int i = 0; i < (totalProgress); i++)
        {
            if (i % 2 == 0)
            {
                continue;
            }

            Vector2 position = start + direction * (i * interval);
            var label = new Label
            {
                Text = "",
                Size = new Vector2(NODE_SIZE, NODE_SIZE),
            };
            line2D.AddChild(label);
            linkTo.people?.person?.ForEach(person =>
            {
                string personId = person.person_id_ref;
                int progress = int.Parse(person.rawNode.attributes["accumulated_progress"]);
                var relativeProgress = (i + 2) / 2;
                Logger.Info("progress: " + progress + " Iteration: " + i + " Relative Progress: " + relativeProgress +
                            " Total Progress: " + totalProgress);

                if (progress != relativeProgress)
                {
                    return;
                }

                var personData = world_Step.data.people?.person?.Where(person => person.id == personId).First();
                if (personData != null)
                {
                    string personName = personData.name?.ToString() + "(" + progress + ")" + "(" + relativeProgress +
                                        ")";
                    label.Text = personName.ToString();
                }
            });


            label.Position = position;
            label.HorizontalAlignment = HorizontalAlignment.Center;
            label.Set("theme_override_font_sizes/font_size", NODE_SIZE / 6);
        }
    }
}