using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nworld_metadata.Nrandomization_table {}
namespace XSD {
}
namespace XSD.Nworld_step.Nworld_metadata {
  public class randomization_table : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.world_metadata.randomization_table";
    public static string TagName = "randomization_table";

    public string NodeName {get =>"randomization_table";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<randomization_table>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry> _entry = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry> entry
    {
      get => _entry;
      set
      {
        _entry = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _entry.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public randomization_table()
    {
    }

    public randomization_table(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public randomization_table(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry> entry)
      {
        this.entry = entry;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry>)
      {
        this.entry = new();
      }
    }

    public Action OnSelfChange(Action<randomization_table> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }

    public Action OnSelfChangeNode(Action<ILinkedNode> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }


    public Action OnChange(Action<List<ILinkedNode>> callback)
    {
      _onChangeCallbackList.Add(callback);
      return () => _onChangeCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing randomization_table");
      //Deserialize arguments

      //Deserialize children
      entry = rawNode.InitializeWithRawNode("entry", entry);
      entry.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing randomization_table");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.entry.ContainsKey(pathIndex))
        {
          this.entry[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry();
        this.entry[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }

      Deserialize(rawNode);
    }

    public void NotifyChange(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _onSelfChangeCallbackList.ForEach(action => action(this));
      _onChangeCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.NotifyChange(linkedNodes);
    }

    public void NotifyChange()
    {
      NotifyChange(new ());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry casted_entry) {
        return this._entry.KeyOf(casted_entry);
      }
      return null;
    }
  }
}