using System;
using System.Collections.Generic;
using System.Linq;
using Godot;
using Guiclient.components.nodes;
using Guiclient.util;
using Guiclient.XSDWebsocketClient;
using util;
using util.dataStore;
using XSD;
using XSD.Nworld_step.Nactions;
using XSD.Nworld_step.Nactions.Nfrom_person;
using XSD.Nworld_step.Ndata.Npeople;

public partial class PersonComponent : Control
{
    // Called when the node enters the scene tree for the first time.
    public static PackedScene PackedScene = GD.Load<PackedScene>("res://components/PersonComponent.tscn");
    private DataStore<world_step> worldStep = StoreWorld_Step.instance;
    private DataStore<person> person = new();

    private List<Action> unsubscribeList = new();

    private Label? nameLabel;
    private Control? classificationContainer;
    private Control? propertiesContainer;
    private ListSizeMonitor<XSD.Nworld_step.Ndata.Npeople.Nperson.Nclassifications.classification> classificationMonitor = new();
    private ListSizeMonitor<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property> propertyMonitor = new();
    private ListSizeMonitor<XSD.Nworld_step.Nrule_group.Naction_rule.from_person> fromPersonActionMonitor = new();
    private ListSizeMonitor<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry> globalActionMonitor = new();
    public static bool stop;

    public void InitializeFromId(string? personId)
    {
        var worldStep = StoreWorld_Step.instance.data;
        if (worldStep == null)
        {
            return;
        }

        var person = worldStep.data?.people?.person?.FirstOrDefault(person => person.id == personId);
        this.person.data = person;
    }


    public override void _Ready()
    {
        //Set NameLabel node value to person id attribute value
        nameLabel = GetNode<Label>("%NameLabel");
        classificationContainer = GetNode<Control>("%ClassificationContainer");
        classificationContainer.GetChildren().ToList().ForEach(child => classificationContainer.RemoveChild(child));
        propertiesContainer = GetNode<Control>("%PropertiesContainer");
        propertiesContainer.GetChildren().ToList().ForEach(child => propertiesContainer.RemoveChild(child));

        classificationContainer.GetChildren().ToList().ForEach(child =>
        {
            classificationContainer.RemoveChild(child);
            child.QueueFree();
        });
        classificationMonitor.OnIncrease += (classification, index) =>
        {
            classificationContainer?.AddChild(new Label()
            {
                Text = classification.classification_rule_ref
            });
        };
        classificationMonitor.OnUpdate += (classification, index) =>
        {
            classificationContainer.GetChild<Label>(index).Text = classification.classification_rule_ref;
        };
        classificationMonitor.OnRemove += (classification, index) =>
        {
            var node = classificationContainer.GetChild(index);
            classificationContainer.RemoveChild(node);
            node.QueueFree();
        };
        
        
        propertyMonitor.OnIncrease += (property, i) =>
        {
            //create hbox container
            var hboxContainer = new HBoxContainer();
            propertiesContainer.AddChild(hboxContainer);
            //ref
            hboxContainer.AddChild(new Label() { Text = property.property_rule_ref });
            //value
            hboxContainer.AddChild(new Label() { Text = property.value.ToString() });
        };
        
        propertyMonitor.OnUpdate += (property, i) =>
        {
            var container = propertiesContainer.GetChild(i);

            container.GetChild<Label>(0).Text = property.property_rule_ref;
            container.GetChild<Label>(1).Text = property.value.ToString();
        };
        propertyMonitor.OnRemove += (property, i) =>
        {
            var node = propertiesContainer.GetChild(i);
            classificationContainer.RemoveChild(node);
            node.QueueFree();
        };
        
        
        var actionsContainer = GetNode<Control>("%ActionsContainer");
        actionsContainer.GetChildren().ToList().ForEach(child => actionsContainer.RemoveChild(child));
        fromPersonActionMonitor.OnIncrease += (fromPerson, i) =>
        {
            //add buttons per entry
            var button = new Button();
            button.Text = fromPerson.id;
            button.Pressed += () =>
            {
                ProcessPersonToPersonAction( fromPerson.id);
            };
            actionsContainer.AddChild(button);
        };
        fromPersonActionMonitor.OnUpdate += (fromPerson, i) =>
        {
            var button = actionsContainer.GetChild<Button>(i);
            if (button == null)
            {
                Logger.Error($"Button at index {i} is null in actionsContainer.");
                return;
            }
            button.Pressed += () =>
            {
                ProcessPersonToPersonAction( fromPerson.id);
            };
            
        };
        fromPersonActionMonitor.OnDecrease += (fromPerson, i) =>
        {
            var node = actionsContainer.GetChild(i);
            actionsContainer.RemoveChild(node);
            node?.Free();
        };
        
        
        var globalActionsContainer = GetNode<Control>("%GlobalActionsContainer");
        globalActionsContainer.GetChildren().ToList().ForEach(child => globalActionsContainer.RemoveChild(child));
        globalActionMonitor.OnIncrease += (globalAction, i) =>
        {
            //add buttons per entry
            var button = new Button();
            button.Text = globalAction.id;
            button.Pressed += () =>
            {
                ProcessPersonToPersonAction( globalAction.id);
            };
            globalActionsContainer.AddChild(button);
        };
        globalActionMonitor.OnUpdate += (globalAction, i) =>
        {
            var button = globalActionsContainer.GetChild<Button>(i);
            button.Pressed += () =>
            {
                ProcessPersonToPersonAction( globalAction.id);
            };
            
        };
        globalActionMonitor.OnRemove += (globalAction, i) =>
        {
            var node = actionsContainer.GetChild(i);
            globalActionsContainer.RemoveChild(node);
            node.Free();
        };
        
        try
        {
            var unsubscribe = person.OnSet(this, (person, unsubscribe) =>
            {
                if (IsInstanceValid(this) == false)
                {
                    unsubscribe();
                    return;
                }

                if (person == null)
                {
                    return;
                }

                GetNode<NodeExplorerButton>("%NodeExplorerButton").LinkedNodeOrCollection = person;
                Redraw(person);
                Action? unsubscribeOnChange = null;
                 unsubscribeOnChange = person.OnChange((_) =>
                {
                    if (IsInstanceValid(this) == false)
                    {
                        unsubscribeOnChange();
                        return;
                    }

                    if (person == null)
                    {
                        return;
                    }
                    Logger.Info("Change");
                    Redraw(person);
                });
            });
            unsubscribeList.Add(unsubscribe);
            worldStep.OnSet(this, (step, action) =>
            {
                if (IsInstanceValid(this) == false)
                {
                    unsubscribe();
                    return;
                }

                if (person == null)
                {
                    return;
                }

                Redraw(person.data);
            });
            StoreSession.mainPersonId.OnSet(this, (mainPersonId, action) =>
            {
                Logger.Info($"mainPersonId changed: {mainPersonId}");
                if (IsInstanceValid(this) == false)
                {
                    unsubscribe();
                    return;
                }

                if (mainPersonId == null)
                {
                    return;
                }
            });
        }
        catch (Exception e)
        {
            Logger.Error("Error: " + e.Message);
        }

        Redraw(person.data);
    }

    public void ClearSubscriptions()
    {
        unsubscribeList.ForEach(unsubscribe => unsubscribe());
        unsubscribeList.Clear();
    }

    private void Redraw(person? person)
    {
        if (nameLabel != null)
        {
            nameLabel.Text = person?.name ?? "Null";
        }

        this.classificationMonitor.Update(person?.classifications?.classification);
        this.propertyMonitor.Update(person?.properties?.property);
        fromPersonActionMonitor.Update(worldStep.data.rule_group.SelectMany(group => group.action_rule?.from_person ?? new()).ToList());
        globalActionMonitor.Update(worldStep.data.rule_group.SelectMany(group => group.action_rule?.global?.entry ?? new()).ToList());
        
    }


    private void ProcessPersonToPersonAction(String actionId)
    {
        var mainPersonId = StoreSession.mainPersonId.data;
        var worldStep = StoreWorld_Step.instance.data;
        if (worldStep == null)
        {
            return;
        }

        var action = new from_person
        {
            person_id_ref = mainPersonId,
            from_person_rule_ref = actionId,
            on_person = new on_person
            {
                person_id_ref = this.person.data.id,
            }
        };

        var targetPath = ((ILinkedNode)(action)).BuildPath().Replace("[0]", "[new]");

        //TODO: Send to put using websockets
        XSDWebSocketClient.instance.data.SendNode(worldStep.actionsOrCreate, action);
    }


    // Called every frame. 'delta' is the elapsed time since the previous frame.
    public override void _Process(double delta)
    {
    }
}