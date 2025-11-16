using Godot;
using Guiclient.util;
using util.dataStore;
using XSD;

namespace Guiclient.components.nodes;

[Tool]
[GlobalClass]
public partial class LinkedNodeViewer: Button
{
    LinkedNodeViewer()
    {
        this.Text = "LinkedNodeViewer";
    }
    public override void _Ready()
    {
        base._Ready();
        this.Pressed += () =>
        {
            this.SpawnWindow(new LinkedNodeGraph(StoreWorld_Step.instance.data));
        };
    }
}