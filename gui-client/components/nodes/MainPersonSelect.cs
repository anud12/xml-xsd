using Godot;
using util.dataStore;

[Tool]
[GlobalClass]
public partial class MainPersonSelect : PersonSelect
{

    public MainPersonSelect()
    {
        GD.Print("MainPersonSelect constructor");
        Value.OnSet((person, unsubscribe) =>
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
            StoreSession.mainPersonId.data = person.id;
        });
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
            SetById(mainPersonId);
        });
    }
}