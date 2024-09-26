using System;
using Dependencies;
using Godot;

[GlobalClass]
public partial class ServerToggle: Button {

    [Export]
    public string StartText = "Start Server";
    [Export]
    public string StopText = "Stop Server";

    public ServerToggle() {
        
        Pressed += () => {
            if(NodeDependency.isRunning.data == false)
            {
                NodeDependency.Start();
            }
            else
            {
                NodeDependency.Close();
            }
        };
        NodeDependency.isRunning.OnSet((isRunning, unsubscribe) =>
        {
            if(IsInstanceValid(this) == false)
            {
                unsubscribe();
                return;
            }
            CallDeferred(Button.MethodName.SetText, isRunning ? StopText : StartText);
        });
    }
}
