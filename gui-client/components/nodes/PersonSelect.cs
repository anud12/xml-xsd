using System.Linq;
using System.Security.Cryptography.X509Certificates;
using util.dataStore;
using Godot;
using Guiclient.util;
using XSD;
using XSD.Nworld_step.Ndata.Npeople;

[Tool]
[GlobalClass]
public partial class PersonSelect : OptionButton
{
    // Called when the node enters the scene tree for the first time.

    private readonly DataStore<world_step> _worldStepDataStore = StoreWorld_Step.instance;
    private person? _person;
    public readonly DataStore<person> Value = new();

    public PersonSelect()
    {
        Connect("item_selected", new Godot.Callable(this, nameof(OnItemSelected)));
        Value.OnSet(this, (person, unsubscribe) =>
        {
            Logger.Info($"Value.OnSet triggered with person: {person?.name}");
            if(IsInstanceValid(this) == false)
            {
                return;
            }
            SetById(person?.id);
        });
        _worldStepDataStore.OnSet(this, (worldStep, unsubscribe) =>
        {
            Logger.Info($"_worldStepDataStore.OnSet triggered");
            if(IsInstanceValid(this) == false)
            {
                return;
            }
            if (worldStep == null)
            {
                return;
            }
            Clear();
            //Add placeholder
            AddItem("Select Person");
            foreach (var person in worldStep.data?.people?.person ?? new ())
            {
                AddItem(person.name);
            }
            var selectedId = _person?.id;
            if (selectedId != null)
            {
                SelectById(selectedId);
            }
        });
    }
    private person? SelectById(string? id) {
        if (id == null)
        {
            Value.data = null;
            Select(0);
            return null;
        }
        var worldStep = _worldStepDataStore.data;
        if (worldStep == null)
        {
            return null;
        }
        var personList = worldStep.data.people?.person;
        var person = personList?.First(person => person.id == id);
        
        Select(personList.IndexOf(person) + 1);
        return person;
    }
    public void SetById(string? id) {
        var person = SelectById(id);
        Value.data = person;
        _person = person;
    }
    
    public void OnItemSelected(int index)
    {
        Logger.Info($"OnItemSelected called with index: {index}");
        if (index == 0)
        {
            Logger.Info("No person selected, setting Value.data to null.");
            Value.data = null;
            return;
        }
        var worldStep = _worldStepDataStore.data;
        if (worldStep == null)
        {
            Logger.Warn("_worldStepDataStore.data is null in OnItemSelected.");
            return;
        }
        var person = worldStep.data.people?.person?.ElementAt(index - 1);
        Logger.Info($"Person selected: {person?.name} (id: {person?.id})");
        _person = person;
        Value.data = person;
    }

    public override void _Process(double delta)
    {
        base._Process(delta);
        
    }
}