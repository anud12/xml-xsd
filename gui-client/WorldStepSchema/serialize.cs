using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Xml;
using System.Xml.Linq;
using Godot;

namespace WorldStepSchema {
	public class WorldStepSerializer {

		public Dictionary<string, Type> attributeMap = new Dictionary<string, Type>();
		public Dictionary<string, Type> elementMap = new Dictionary<string, Type>();

		public WorldStepSerializer addAttribute(string attributeName, Type attributeType) {
			attributeMap.Add(attributeName, attributeType);
			return this;
		}

		public WorldStepSerializer addElement(string elementName, Type elementType) {
			elementMap.Add(elementName, elementType);
			return this;
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
					Type attributeType = attributeMap[attributeName];
					object attributeValue = Convert.ChangeType(attribute.Value, attributeType);
					var property = type.GetFields().Where(p => p.Name == attributeName).FirstOrDefault();
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
					Type elementType = elementMap[elementName];
			
					// If the element is a List, iterate over the child elements and create a list of objects
					if (elementType.IsGenericType && elementType.GetGenericTypeDefinition() == typeof(List<>))
					{
						var listType = elementType.GetGenericArguments()[0];
						var list = (IList)obj.GetType().GetField(elementName).GetValue(obj);
						object childElementValue = Activator.CreateInstance(listType, element);
						list.Add(childElementValue);
						continue;
					}
			
					// If the element is not a List, create an object and set the value
					var property = type.GetFields().Where(p => p.Name == elementName).FirstOrDefault();
					if (property != null)
					{
						object elementValue = Activator.CreateInstance(elementType, element);
						property.SetValue(obj, elementValue);
					}
				}
			}
		}

		public void Deserialize<T>(XmlElement element, T obj)
		{
			Type type = obj.GetType();
			// Deserialize attributes based on the attributeMap
			foreach (var attribute in attributeMap)
			{
				var attributeName = attribute.Key;
				var attributeType = attribute.Value;
				var property = type.GetFields().Where(p => p.Name == attributeName).FirstOrDefault();
				if (property != null)
				{
					var attributeValue = property.GetValue(obj);
					element.SetAttribute(attributeName, attributeValue.ToString());
				}
			}
			// Deserialize elements based on the elementMap
			foreach (var elementMap in elementMap)
			{
				var elementName = elementMap.Key;
				var elementType = elementMap.Value;
				var property = type.GetFields().Where(p => p.Name == elementName).FirstOrDefault();
				if (property != null)
				{
					var elementValue = property.GetValue(obj);
					if (elementType.IsGenericType && elementType.GetGenericTypeDefinition() == typeof(List<>))
					{
						var list = (IList)elementValue;
						foreach (var childElement in list)
						{
							var childElementValue = (object)childElement;
							var childElementElement = element.OwnerDocument.CreateElement(elementName);
							childElementValue.GetType().GetMethod("Deserialize").Invoke(childElementValue, new object[] { childElementElement });
							element.AppendChild(childElementElement);
						}
					}
					else
					{
						var childElementElement = element.OwnerDocument.CreateElement(elementName);
						elementValue.GetType().GetMethod("Deserialize").Invoke(elementValue, new object[] { childElementElement });
						element.AppendChild(childElementElement);
					}
				}
			}
		}
	}
}
