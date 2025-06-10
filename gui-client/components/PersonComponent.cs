using System;
using System.Collections.Generic;
using System.Linq;
using Godot;
using Guiclient.components.nodes;
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
	public void initializeFromId(string? personId)
	{

		var worldStep = StoreWorld_Step.instance.data;
		if (worldStep == null)
		{
			return;
		}
		var person = worldStep.data.people?.person?.FirstOrDefault(person => person.id == personId);
		this.person.data = person;

	}

	
	public override void _Ready()
	{
		//Set NameLabel node value to person id attribute value
		try
		{
			var unsubscribe = person.OnSet((person, unsubscribe) =>
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
				unsubscribeList.Add(person.OnChange((_) =>
				{
					GD.Print("ChangeBubble");
					Redraw(person);
				}));
				unsubscribeList.Add(person.OnChange((_) =>
				{
					GD.Print("Change");
					Redraw(person);
				}));
			});
			unsubscribeList.Add(unsubscribe);
			worldStep.OnSet((step, action) =>
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
			StoreSession.mainPersonId.OnSet((mainPersonId, action) =>
			{
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
			GD.PrintErr("Error: " + e.Message);
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
		var nameLabel = GetNode<Label>("%NameLabel");
		nameLabel.Text = person?.name ?? "Null";
		AddClassifications(person);
		AddProperties(person);
		AddPersonToPersonActions(person);
	}

	private void AddPersonToPersonActions(person? person)
	{
		var mainPersonId = StoreSession.mainPersonId.data;
		var worldStep = this.worldStep.data;
			
		//Clear actionsContainer
		var actionsContainer = GetNode<Control>("%ActionsContainer");
		actionsContainer.GetChildren().ToList().ForEach(child => actionsContainer.RemoveChild(child));


		if (mainPersonId == person?.id)
		{
			return;
		}

		//if there are actions add them into container
		worldStep?.rule_group?.ForEach(ruleGroup =>
		{
			ruleGroup?.action_rule?.from_person?.ForEach(fromPersonElement =>
			{
				if (fromPersonElement.on_person == null)
				{
					return;
				}

				//add buttons per entry
				var button = new Button();
				button.Text = fromPersonElement.id;
				button.Pressed += () =>
				{
					var mainPersonId = StoreSession.mainPersonId.data;
					ProcessPersonToPersonAction(person.id, fromPersonElement.id);
				};
				actionsContainer.AddChild(button);
			});
			ruleGroup?.action_rule?.global?.entry?.ForEach(entry =>
			{
				if (entry.from.person == null)
				{
					return;
				}

				if (entry.on.person == null)
				{
					return;
				}

				//add buttons per entry
				var button = new Button();
				button.Text = entry.id;
				button.Pressed += () =>
				{
					var mainPersonId = StoreSession.mainPersonId.data;
					ProcessPersonToPersonAction(person.id, entry.id);
				};
				actionsContainer.AddChild(button);
			});
		});

	}

	private void ProcessPersonToPersonAction(String targetPersonId, String actionId)
	{
		var mainPersonId = StoreSession.mainPersonId.data;
		var worldStep = StoreWorld_Step.instance.data;
		if (worldStep == null)
		{
			return;
		}

		worldStep.actions.from_person.Add(new from_person
		{
			person_id_ref = mainPersonId,
			from_person_rule_ref = actionId,
			on_person = new on_person
			{
				person_id_ref = targetPersonId,
			}
		});
		LoadWorldStep.executeNextStep();
	}

	private void AddClassifications(person? person)
	{
		//Clear classificationContainer
		var classificationContainer = GetNode<Control>("%ClassificationContainer");
		classificationContainer.GetChildren().ToList().ForEach(child => classificationContainer.RemoveChild(child));
		person?.classifications.classification.ForEach(classification =>
		{
			classificationContainer.AddChild(new Label() { Text = classification.classification_rule_ref });
		});
	}

	private void AddProperties(person? person)
	{
		var propertiesContainer = GetNode<Control>("%PropertiesContainer");
		propertiesContainer.GetChildren().ToList().ForEach(child => propertiesContainer.RemoveChild(child));
		//if there are properties add them into container
		person?.properties.property.ForEach(property =>
		{
			//create hbox container
			var hboxContainer = new HBoxContainer();
			propertiesContainer.AddChild(hboxContainer);
			//ref
			hboxContainer.AddChild(new Label() { Text = property.property_rule_ref });
			//value
			hboxContainer.AddChild(new Label() { Text = property.value.ToString() });
			
		});
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}

}
