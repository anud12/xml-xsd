using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nscripts {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class scripts : IEquatable<scripts>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.scripts";
    public static string TagName = "scripts";

    public string NodeName {get =>"scripts";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<scripts>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nscripts.file> _file = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nscripts.file> file
    {
      get => _file;
      set
      {
        _file = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _file.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public scripts()
    {
    }

    public scripts(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public scripts(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nscripts.file> file)
      {
        this.file = file;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nscripts.file>)
      {
        this.file = null;
      }
    }

    public Action OnSelfChange(Action<scripts> callback)
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
      // Godot.GD.Print("Deserializing scripts");
      //Deserialize arguments

      //Deserialize children
      file = rawNode.InitializeWithRawNode("file", file);
      file.OnAdd = (value) =>
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
      rawNode.children["file"] = file.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing scripts");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nscripts.file.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nscripts.file.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Nscripts.file.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Nscripts.file.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.file.ContainsKey(pathIndex))
        {
          this.file[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nscripts.file();
        this.file[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nscripts.file casted_file) {
        return this._file.KeyOf(casted_file);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Nscripts.file
      || false;
    }

    public bool Equals(scripts? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (scripts)obj;
        return Equals(file, other.file);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, file);
        return acc;
    }
  }
}