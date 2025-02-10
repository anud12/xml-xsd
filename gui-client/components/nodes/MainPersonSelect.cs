using System.Linq;
using System.Security.Cryptography.X509Certificates;
using util.dataStore;
using Godot;
using XSD;

[Tool]
[GlobalClass]
public partial class MainPersonSelect : PersonSelect
{

    public MainPersonSelect()
    {
        GD.Print("MainPersonSelect constructor");
        value.OnSet((person, unsubscribe) =>
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