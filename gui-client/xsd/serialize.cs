using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Xml;
using System.Xml.Linq;
using Godot;

namespace XSD {

	public class RawNode {

		public List<T> InitializeWithRawNode<T>(string key, List<T> defaultValue) {
			//get type of elements in the list
			var type = typeof(T);

			var childRawNode = this.children.ContainsKey(key) ? this.children[key] : null;
			if(childRawNode == null) {
				return defaultValue;
			}
			return childRawNode.Select(o => {
				//create new instante calling the contructor with the rawNode as first argument
				var newInstance = (T)Activator.CreateInstance(type, new object[] { o })!;
				return newInstance;
			}).ToList();

		}

		public T InitializeWithRawNode<T>(string key, T defaultValue)
		{
			//get type of elements in the list
			var type = typeof(T);

			var childRawNodeList = this.children.ContainsKey(key) ? this.children[key] : null;
			if (childRawNodeList == null || childRawNodeList.Count == 0)
			{
				return defaultValue;
			}

			var childRawNode = childRawNodeList.FirstOrDefault();

			var newInstance = (T)Activator.CreateInstance(type, new object[] { childRawNode })!;
			return newInstance;

		}

		public Dictionary<string, string?> attributes = new Dictionary<string, string?>();
		public Dictionary<string, List<RawNode>> children = new Dictionary<string, List<RawNode>>();

		public XmlNode Deserialize(XmlNode xmlElement) {
			foreach (XmlAttribute attribute in xmlElement.Attributes)
			{
				attributes[attribute.Name] = attribute.Value;
			}
			foreach (XmlNode childNode in xmlElement.ChildNodes)
			{
				if(childNode.NodeType == XmlNodeType.Element) {
					if(!children.ContainsKey(childNode.Name)) {
						children[childNode.Name] = new List<RawNode>();
					}
					RawNode rawNode = new RawNode();
					children[childNode.Name].Add(rawNode);
					rawNode.Deserialize(childNode);
				}
			}
			return xmlElement;
		}
		public XmlNode Serialize(XmlNode xmlElement) {
			foreach (var attribute in attributes)
			{
				xmlElement.Attributes.Append(xmlElement.OwnerDocument.CreateAttribute(attribute.Key)).Value = attribute.Value;
			}
			foreach (var child in children)
			{
				foreach (var childNode in child.Value)
				{
					xmlElement.AppendChild(childNode.Serialize(xmlElement.OwnerDocument.CreateElement(child.Key)));
				}
			}
			return xmlElement;
		}
	}

}
