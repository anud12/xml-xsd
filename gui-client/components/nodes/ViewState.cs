using System.Xml.Linq;
using Godot;
using util.dataStore;
using Guiclient.util;

namespace Guiclient.components.nodes;
[Tool]
[GlobalClass]
public partial class ViewState: Button
{
    private Window _window = new Window();
    
    public override void _Ready()
    {
        Text = "View state";
        this.Pressed += () =>
        {
            var codeEdit = new CodeEdit();
            StoreWorld_Step.instance.data?.OnSelfChange(step =>
            {
                Logger.Info("ViewState callback called");
                var code = step.SerializeIntoRawNode().SerializeToString("world_step");
                codeEdit.Text = XElement.Parse(code).ToString();
            });
            StoreWorld_Step.instance.OnSet(this, (step, action) =>
            {
                var code = step.SerializeIntoRawNode().SerializeToString("world_step");
                if (codeEdit == null || !IsInstanceValid(codeEdit))
                {
                    return;
                }
                codeEdit.Text = XElement.Parse(code).ToString();
            });
            this.SpawnWindow(codeEdit);
        };
    }
}