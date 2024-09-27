using System;
using System.Threading;
using dataStore;
using Godot;

[GlobalClass]
[Tool]
public partial class NextStep : Button
{

    [Export]
    public new string Text = "Execute Step";

    public DataStore<bool> isLooping = new DataStore<bool>(false);

    private double lastTimeSeconds = 0;

    public NextStep()
    {
        //set label
        CallDeferred(Button.MethodName.SetText, Text);

        Pressed += () =>
        {
            Console.WriteLine("NextStep Pressed");
            isLooping.Set(!isLooping.data);
            CallDeferred(Button.MethodName.SetText, isLooping.data ? "Stop" : Text);
        };
    }

    public override void _ExitTree()
    {
        isLooping.data = false;
    }

    public override void _Process(double delta)
    {
        
        base._Process(delta);
        if (isLooping.data) {
            lastTimeSeconds += delta;
            if (lastTimeSeconds > 0.5)
            {
                lastTimeSeconds = 0;
                    LoadWorldStep.executeNextStep();
            }
        }
    }


}