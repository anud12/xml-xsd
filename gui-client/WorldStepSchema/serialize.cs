using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Xml;
using System.Xml.Linq;
using Godot;

namespace WorldStepSchema {
	public class WorldStepSerializer {

		public string tagName;
		public Dictionary<string, (Type, string)> attributeMap = new Dictionary<string, (Type, string)>();
		public Dictionary<string, (Type, string)> elementMap = new Dictionary<string, (Type, string)>();

		public WorldStepSerializer addAttribute(string attributeName, Type attributeType) {
			attributeMap.Add(attributeName, (attributeType, attributeName));
			return this;
		}

		public WorldStepSerializer addAttribute(string attributeName, Type attributeType, string fieldName) {
			attributeMap.Add(attributeName, (attributeType, fieldName));
			return this;
		}

		public WorldStepSerializer addElement(string elementName, Type elementType) {
			elementMap.Add(elementName, (elementType, elementName));
			return this;
		}

		public WorldStepSerializer addElement(string elementName, Type elementType, string fieldName) {
			elementMap.Add(elementName, (elementType, fieldName));
			return this;
		}
		
		public WorldStepSerializer(string tagName) {
			this.tagName = tagName;
		}

		public void Serialize<T>(XmlNode xmlElement, T obj) {
			Type type = obj.GetType();
			// Serialize attributes based on the attributeMap        
			foreach (XmlAttribute attribute in xmlElement.Attributes)
			{
				string attributeName = attribute.Name;
				var contains= attributeMap.ContainsKey(attributeName);
				if (contains)
				{
					(Type attributeType, string fieldName) = attributeMap[attributeName];
					object attributeValue = Convert.ChangeType(attribute.Value, attributeType);
					var property = type.GetFields().Where(p => p.Name == fieldName).FirstOrDefault();
					if (property != null)
					{
						property.SetValue(obj, attributeValue);
					}
				}
			}
			// Serialize elements based on the elementMap

			foreach (XmlNode element in xmlElement.ChildNodes)
			{
				string elementName = element.Name;
				var contains = elementMap.ContainsKey(elementName);
				if (contains)
				{
					(Type elementType, string fieldName) = elementMap[elementName];
			
					// If the element is a List, iterate over the child elements and create a list of objects
					if (elementType.IsGenericType && elementType.GetGenericTypeDefinition() == typeof(List<>))
					{
						var listType = elementType.GetGenericArguments()[0];
						var list = (IList)obj.GetType().GetField(fieldName).GetValue(obj);
						object childElementValue = Activator.CreateInstance(listType, element);
						list.Add(childElementValue);
						continue;
					}
			
					// If the element is not a List, create an object and set the value
					var property = type.GetFields().Where(p => p.Name == fieldName).FirstOrDefault();
					if (property != null)
					{
						object elementValue = Activator.CreateInstance(elementType, element);
						property.SetValue(obj, elementValue);
					}
				}
			}
		}

		public void Deserialize<T>(XmlElement element, T obj) where T : WorldStepDeserialize
		{
			Type type = obj.GetType();
			
			// Deserialize attributes based on the attributeMap
			foreach (var attribute in attributeMap)
			{
				string attributeName = attribute.Key;
				string attributeTypeName = attribute.Value.Item2;
				object attributeValue = type.GetField(attributeTypeName).GetValue(obj);
				element.SetAttribute(attributeName, attributeValue.ToString());
			}
			// Deserialize elements based on the elementMap
			foreach (var elementMap in elementMap)
			{
				string elementName = elementMap.Key;
				string elementNameTypeName = elementMap.Value.Item2;
				object elementValue;
				try {
					elementValue = type.GetField(elementNameTypeName).GetValue(obj);
				} catch (Exception e) {
					GD.PrintErr("elementName: " + elementName + " not found in " + type.Name);
					continue;
				}
				


				if (elementValue == null)
				{
					continue;
				}
				

				// If the element is a List, iterate over the child elements and create a list of objects
				if (elementValue is IList)
				{
					foreach (var childElement in (IList)elementValue)
					{
						//create element
						XmlElement newElementChildList = element.OwnerDocument.CreateElement(elementName);
						element.AppendChild(newElementChildList);
						((WorldStepDeserialize)childElement).Deserialize(newElementChildList);
					}
					continue;
				}
				//create element
				XmlElement newElementChild = element.OwnerDocument.CreateElement(elementName);
				element.AppendChild(newElementChild);
				// If the element is not a List, create an object and set the value
				((WorldStepDeserialize)elementValue).Deserialize(newElementChild);
			}
			
		}
	}
}
