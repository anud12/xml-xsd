using System;
using System.Collections.Generic;
using dataStore;
using Godot;

[GlobalClass]
[Tool]
public partial class ButtonWithDropdownNode : BoxContainer
{
    private Button _button = new Button();
    private MenuButton _optionButton = new MenuButton();
    private Godot.Collections.Array<string> _options = new Godot.Collections.Array<string>();

    private DataStore<string> _value = new DataStore<string>();

    private DataStore<Action<string>> _onClick = new DataStore<Action<string>>();
    [Export]
    public Godot.Collections.Array<string> options {
        get {
            return _options;
        }
        set {
            _options = value;
            _optionButton.GetPopup().Clear();
            foreach (var option in value)
            {
                _optionButton.GetPopup().AddItem(option);
            }
        }
    }

    [Export]
    public string PlaceholderText
    {
        get
        {
            return _button.Text;
        }
        set
        {
            _button.Text = value;
        }
    }

    public ButtonWithDropdownNode() {
        _optionButton.Flat = false;
        _optionButton.Text = "⏷";
    }

    public override void _Ready()
    {
        AddThemeConstantOverride("separation", 0);
        AddChild(_button);
        AddChild(_optionButton);

        _button.Connect("pressed", new Callable(this, nameof(OnButtonPressed)));
        _optionButton.GetPopup().Connect("index_pressed", new Callable(this, nameof(OnPopupPressed)));
        
        if(_value.data == null) {
            _button.Disabled = true;
        }

        _value.OnSet((value, unsubscribe) =>
        {
            if(IsInstanceValid(this) == false)
            {
                return;
            }
            _button.Disabled = false;
            _button.Text = value;
        });
    }

    public void SetValue(string value)
    {
        _value.data = value;
    }

    private void OnButtonPressed()
    {
        _onClick.data?.Invoke(_button.Text);
        _value.data = _button.Text;
    }

    private void OnPopupPressed(int index)
    {
        var selectedValue = _optionButton.GetPopup().GetItemText(index);
        _onClick.data?.Invoke(selectedValue);
        _value.data = selectedValue;
    }



    public void OnClick(Action<string> action) {
        _onClick.data = action;
    }

    public void AddOption(string text)
    {
        var option = new Button();
        option.Text = text;
        _optionButton.AddChild(option);
    }
}