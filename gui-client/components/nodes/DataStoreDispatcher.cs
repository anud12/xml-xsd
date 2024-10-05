using Godot;


[Tool]
[GlobalClass]
public partial class DataStoreDispatcher: Node {


    [Export]
    public bool enabled = true;
    public override void _Process(double delta)
    {
        StoreWorld_Step.instance.Dispatch();
        StoreSession.mainPersonId.Dispatch();
    }

}