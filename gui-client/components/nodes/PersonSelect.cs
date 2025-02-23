using System.Linq;
using System.Security.Cryptography.X509Certificates;
using dataStore;
using Godot;
using XSD;
using XSD.Nworld_step.Ndata.Npeople;

[Tool]
[GlobalClass]
public partial class PersonSelect : OptionButton
{
    // Called when the node enters the scene tree for the first time.

    private DataStore<world_step> _worldStepDataStore = StoreWorld_Step.instance;

    
    private person? _person;
    public DataStore<person> value = new DataStore<person>();

    public PersonSelect()
    {
        Connect("item_selected", new Godot.Callable(this, nameof(OnItemSelected)));
        value.OnSet((person, unsubscribe) =>
        {
            if(IsInstanceValid(this) == false)
            {
                return;
            }
            SetById(person?.id);
        });
        _worldStepDataStore.OnSet((worldStep, unsubscribe) =>
        {
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
            foreach (var person in worldStep.data.people?.person)
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
            value.data = null;
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
        value.data = person;
        _person = person;
    }

    public void OnItemSelected(int index)
    {
        if (index == 0)
        {
            value.data = null;
            return;
        }
        var worldStep = _worldStepDataStore.data;
        if (worldStep == null)
        {
            return;
        }
        var person = worldStep.data.people?.person?.ElementAt(index - 1);
        _person = person;
        value.data = person;
    }
}