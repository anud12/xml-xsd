using Godot;
using Guiclient.util;
using util.dataStore;

[Tool]
[GlobalClass]
public partial class MainPersonSelect : PersonSelect
{

    public MainPersonSelect()
    {
        Logger.Info("MainPersonSelect constructor");
        Value.OnSet(this, (person, unsubscribe) =>
        {
            Logger.Info("MainPersonSelect Value.OnSet triggered");
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
        StoreSession.mainPersonId.OnSet(this, (mainPersonId, unsubscribe) =>
        {
            Logger.Info("MainPersonSelect StoreSession.mainPersonId.OnSet triggered");
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