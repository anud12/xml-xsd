using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Xml;
using System.Xml.Linq;
using Godot;

namespace WorldStepSchema {

	[AttributeUsage(AttributeTargets.Class | AttributeTargets.Field)]
	public class WorldStepSerializerAttribute : Attribute {
		public string attributeName;

		public WorldStepSerializerAttribute() {
		}
		public WorldStepSerializerAttribute(string attributeName) {
			this.attributeName = attributeName;
		}
	}
	public class WorldStepSerializer {

		public string tagName;
		public Dictionary<string, string> attributeMap = new Dictionary<string, string>();
		public Dictionary<string, string> elementMap = new Dictionary<string, string>();

		public WorldStepSerializer addAttribute(string attributeName) {
			attributeMap.Add(attributeName,  attributeName);
			return this;
		}

		public WorldStepSerializer addAttribute(string attributeName, string fieldName) {
			attributeMap.Add(attributeName, fieldName);
			return this;
		}

		public WorldStepSerializer addElement(string elementName) {
			elementMap.Add(elementName, elementName);
			return this;
		}

		public WorldStepSerializer addElement(string elementName, string fieldName) {
			elementMap.Add(elementName, fieldName);
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
					string fieldName = attributeMap[attributeName];
					var property = type.GetFields().Where(p => p.Name == fieldName).FirstOrDefault();
					Type propertyType = property.FieldType;
					object attributeValue = Convert.ChangeType(attribute.Value, propertyType);
					
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
					string fieldName = elementMap[elementName];
					Type elementType = obj.GetType().GetField(fieldName).FieldType;
					
					
					// If the element is a List, iterate over the child elements and create a list of objects
					if (elementType.IsGenericType && elementType.GetGenericTypeDefinition() == typeof(List<>))
					{
						var elementValue = (IList)obj.GetType().GetField(fieldName).GetValue(obj);
						var listType = elementType.GetGenericArguments()[0];
						object childElementValue = Activator.CreateInstance(listType, element);
						elementValue.Add(childElementValue);
						continue;
					}
			
					// If the element is not a List, create an object and set the value
					var property = type.GetFields().Where(p => p.Name == fieldName).FirstOrDefault();
					if (property != null)
					{
						object elementInstanceValue = Activator.CreateInstance(elementType, element);
						property.SetValue(obj, elementInstanceValue);
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
				string attributeTypeName = attribute.Value;
				object attributeValue = type.GetField(attributeTypeName).GetValue(obj);
				element.SetAttribute(attributeName, attributeValue.ToString());
			}
			// Deserialize elements based on the elementMap
			foreach (var elementMap in elementMap)
			{
				string elementName = elementMap.Key;
				string elementNameTypeName = elementMap.Value;
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
