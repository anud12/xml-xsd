using dataStore;
using Godot;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using XSD;

public partial class PersonComponent : Control
{
	// Called when the node enters the scene tree for the first time.
	public static PackedScene PackedScene = GD.Load<PackedScene>("res://components/PersonComponent.tscn");
	private DataStore<world_step> worldStep = StoreWorld_Step.instance;
	private DataStore<world_step__people__person> person = new DataStore<world_step__people__person>();

	private List<Action> unsubscribeList = new List<Action>();
	public void initializeFromId(string? personId)
	{

		var worldStep = StoreWorld_Step.instance.data;
		if (worldStep == null)
		{
			return;
		}
		var person = worldStep.people.SelectMany(people => people.person).First(person => person.id == personId);
		this.person.data = person;

	}

	public override void _Ready()
	{
		//Set NameLabel node value to person id attribute value
		try
		{
			var nameLabel = GetNode<Label>("%NameLabel");
			var unsubscribe = person.OnSet((person, unsubscribe) =>
			{
				if(IsInstanceValid(this) == false)
				{
					unsubscribe();
					return;
				}
				if (person == null)
				{
					return;
				}
				nameLabel.Text = person.name;
			});
			unsubscribeList.Add(unsubscribe);
			addClassifications();
			addProperties();
			addPersonToPersonActions();
		}
		catch (Exception e)
		{
			GD.PrintErr("Error: " + e.Message);
		}

	}

	public void ClearSubscriptions()
	{
		unsubscribeList.ForEach(unsubscribe => unsubscribe());
		unsubscribeList.Clear();
	}

	private void addPersonToPersonActions()
	{
		StoreSession.mainPersonId.OnSet((mainPersonId, unsubscribe) =>
		{
			if(IsInstanceValid(this) == false)
			{
				unsubscribe();
				return;
			}

			if (mainPersonId == null)
			{
				return;
			}


			worldStep.OnSet((worldStep, unsubscribe) =>
			{
				if(IsInstanceValid(this) == false)
				{
					unsubscribe();
					return;
				}
				if (worldStep == null)
				{
					return;
				}
				//Clear actionsContainer
				var actionsContainer = GetNode<Control>("%ActionsContainer");
				actionsContainer.GetChildren().ToList().ForEach(child => actionsContainer.RemoveChild(child));


				if (mainPersonId == person.data.id)
				{
					return;
				}

				//if there are actions add them into container
				worldStep.rule_group.SelectMany(ruleGroup => ruleGroup.action_rule.SelectMany(actionRule => actionRule.person_to_person)).ToList().ForEach(entry =>
				{

					//add buttons per entry
					var button = new Button();
					button.Text = entry.id;
					button.Pressed += () =>
				{
					var mainPersonId = StoreSession.mainPersonId.data;
					ProcessPersonToPersonAction(person.data.id, entry.id);
				};
					actionsContainer.AddChild(button);
				});
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
		if(worldStep.actions.Count == 0)
		{
			worldStep.actions.Add(new world_step__actions());
		}

		worldStep.actions.First().person__on_person__property_mutation.Add(new world_step__actions__person__on_person__property_mutation
		{
			action_property_mutation_rule_ref = actionId,
			person_id_ref = mainPersonId,
			target_person_id_ref = targetPersonId,
		});
		LoadWorldStep.executeNextStep();
	}

	private void addClassifications()
	{
		person.OnSet((person, unsubscribe) =>
		{
			if(IsInstanceValid(this) == false)
			{
				unsubscribe();
				return;
			}
			if (person == null)
			{
				return;
			}
			//Clear classificationContainer
			var classificationContainer = GetNode<Control>("%ClassificationContainer");
			classificationContainer.GetChildren().ToList().ForEach(child => classificationContainer.RemoveChild(child));
			//if there are classifications add them into container
			if (person.classifications.Count != 0)
			{
				person.classifications.SelectMany(classification => classification.classification).ToList().ForEach(classification =>
				{
					classificationContainer.AddChild(new Label() { Text = classification.classification_rule_ref });
				});
			}
		});
	}

	private void addProperties()
	{
		var unsubscribe = person.OnSet((person, unsubscribe) =>
		{
			if(IsInstanceValid(this) == false)
			{
				unsubscribe();
				return;
			}
			if (person == null)
			{
				return;
			}
			//Clear propertiesContainer
			var propertiesContainer = GetNode<Control>("%PropertiesContainer");
			propertiesContainer.GetChildren().ToList().ForEach(child => propertiesContainer.RemoveChild(child));
			//if there are properties add them into container
			if (person.properties.Count != 0)
			{
				//Add properties into container
				person.properties.SelectMany(properties => properties.property).ToList().ForEach(property =>
				{
					//create hbox container
					var hboxContainer = new HBoxContainer();
					propertiesContainer.AddChild(hboxContainer);
					//ref
					hboxContainer.AddChild(new Label() { Text = property.property_rule_ref });
					//value
					hboxContainer.AddChild(new Label() { Text = (string)property.rawNode.attributes["value"] });
				});
			}
		});
		unsubscribeList.Add(unsubscribe);

	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}

}
