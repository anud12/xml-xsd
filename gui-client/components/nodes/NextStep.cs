using System;
using Godot;

[GlobalClass]
[Tool]
public partial class NextStep: Button {

    [Export]
    public new string Text = "Execute Step";
    
    public NextStep() {
        //set label
        CallDeferred(Button.MethodName.SetText, Text);
        
        //on click 
        Pressed += () => {
            Console.WriteLine("NextStep Pressed");
            LoadWorldStep.executeNextStep();
        };
    }
}