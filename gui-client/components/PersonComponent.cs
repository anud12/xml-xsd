using Godot;
using System;
using System.Linq;
using XSD;

public partial class PersonComponent : Control
{
	// Called when the node enters the scene tree for the first time.
	public static PackedScene PackedScene = GD.Load<PackedScene>("res://components/PersonComponent.tscn");
	
	private world_step__people__person  person;
	public void initializeFromId(string personId, world_step worldStep) {
		//find the person with the given id in world_step people
		var people = worldStep.people.First();
		GD.Print("People: " + people.person.Count);
		var person = people.person.Find(person => (String)person.id == personId);
		this.person = person;
	}

	public override void _Ready()
	{
		//Set NameLabel node value to person id attribute value
		var nameLabel = GetNode<Label>("%NameLabel");
		nameLabel.Text = (string)person.name;

		//Clear classificationContainer
		var classificationContainer = GetNode<Control>("%ClassificationContainer");
		classificationContainer.GetChildren().ToList().ForEach(child => classificationContainer.RemoveChild(child));
		//if there are classifications add them into container
		if (person.classifications.Count != 0) {
			person.classifications.SelectMany(classification => classification.classification).ToList().ForEach(classification => {
				classificationContainer.AddChild(new Label() { Text = classification.classification_rule_ref });
			});
		}
		
		//Clear propertiesContainer
		var propertiesContainer = GetNode<Control>("%PropertiesContainer");
		propertiesContainer.GetChildren().ToList().ForEach(child => propertiesContainer.RemoveChild(child));
		//if there are properties add them into container
		if (person.properties.Count != 0) {
			//Add properties into container
			person.properties.SelectMany(properties => properties.property).ToList().ForEach(property => {
				//ref
				propertiesContainer.AddChild(new Label() { Text = property.property_rule_ref });
				//value
				propertiesContainer.AddChild(new Label() { Text = (string)property.value });
			});
		}

		
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
	}

}
