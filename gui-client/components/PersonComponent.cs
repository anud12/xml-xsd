using dataStore;
using Godot;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using XSD;
using XSD.Nworld_step.Nactions;
using XSD.Nworld_step.Nactions.Nfrom_person;
using XSD.Nworld_step.Ndata.Npeople;

public partial class PersonComponent : Control
{
	// Called when the node enters the scene tree for the first time.
	public static PackedScene PackedScene = GD.Load<PackedScene>("res://components/PersonComponent.tscn");
	private DataStore<world_step> worldStep = StoreWorld_Step.instance;	private DataStore<person> person = new DataStore<person>();

	private List<Action> unsubscribeList = new List<Action>();
	public void initializeFromId(string? personId)
	{

		var worldStep = StoreWorld_Step.instance.data;
		if (worldStep == null)
		{
			return;
		}
		var person = worldStep.data.people?.person?.First(person => person.id == personId);
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
				if (IsInstanceValid(this) == false)
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
			if (IsInstanceValid(this) == false)
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
				if (IsInstanceValid(this) == false)
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
				worldStep.rule_group.ForEach(ruleGroup =>
				{
					ruleGroup?.action_rule?.from_person?.ForEach(fromPersonElement => {
						if(fromPersonElement.on_person == null) {
							return;
						}

						//add buttons per entry
						var button = new Button();
						button.Text = fromPersonElement.id;
						button.Pressed += () =>
					{
						var mainPersonId = StoreSession.mainPersonId.data;
						ProcessPersonToPersonAction(person.data.id, fromPersonElement.id);
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
						ProcessPersonToPersonAction(person.data.id, entry.id);
					};
						actionsContainer.AddChild(button);

					});
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

		worldStep.GetOrInsertDefault_actions().GetOrInsertDefault_from_person().Add(new from_person
		{
			person_id_ref = mainPersonId,
			from_person_rule_ref = actionId,
			on_person = new on_person
			{
				person_id_ref = targetPersonId,
			}
		});
		// worldStep.GetOrInsertDefault_actions().person__on_person__property_mutation.Add(new world_step__actions__person__on_person__property_mutation
		// {
		// 	action_property_mutation_rule_ref = actionId,
		// 	person_id_ref = mainPersonId,
		// 	target_person_id_ref = targetPersonId,
		// });
		LoadWorldStep.executeNextStep();
	}

	private void addClassifications()
	{
		person.OnSet((person, unsubscribe) =>
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
			//Clear classificationContainer
			var classificationContainer = GetNode<Control>("%ClassificationContainer");
			classificationContainer.GetChildren().ToList().ForEach(child => classificationContainer.RemoveChild(child));
			person.classifications.classification.ForEach(classification =>
			{
				classificationContainer.AddChild(new Label() { Text = classification.classification_rule_ref });
			});
		});
	}

	private void addProperties()
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
			//Clear propertiesContainer
			var propertiesContainer = GetNode<Control>("%PropertiesContainer");
			propertiesContainer.GetChildren().ToList().ForEach(child => propertiesContainer.RemoveChild(child));
			//if there are properties add them into container
			person.properties.property.ForEach(property =>
				{
					//create hbox container
					var hboxContainer = new HBoxContainer();
					propertiesContainer.AddChild(hboxContainer);
					//ref
					hboxContainer.AddChild(new Label() { Text = property.property_rule_ref });
					//value
					hboxContainer.AddChild(new Label() { Text = (string)property.rawNode.attributes["value"] });
				});
		});
		unsubscribeList.Add(unsubscribe);

	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}

}
