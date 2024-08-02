using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Xml;
using System.Xml.Linq;
using Godot;

namespace WorldStepSchema {

	[AttributeUsage(AttributeTargets.Field)]
	public class AttributeAttribute : Attribute {
		public string name;

		public AttributeAttribute() {
		}
		public AttributeAttribute(string attributeName) {
			this.name = attributeName;
		}
	}

	
	[AttributeUsage(AttributeTargets.Field)]
	public class ElementAttribute : Attribute {
		public string name;

		public ElementAttribute() {
		}
		public ElementAttribute(string attributeName) {
			this.name = attributeName;
		}
	}

	public interface ManualSerializer {
		void Serialize(XmlElement element);
	
	}

	public class WorldStepSerializer {

		public WorldStepSerializer() {
		}

		public void Deserialize<T>(XmlNode xmlElement, T obj) {
			Type type = obj.GetType();
			// GD.Print("Serialize - type: " + type.Name);
			// Serialize attributes  
			DeserializeAttributes(xmlElement, obj);
			// Serialize elements
			DeserializeElements(xmlElement, obj);
		}

		private void DeserializeAttributes<T>(XmlNode xmlElement, T obj) {
			Type type = obj.GetType();
			var fields = type.GetFields();

			foreach (XmlAttribute attribute in xmlElement.Attributes)
			{
				string attributeName = attribute.Name;

				FieldInfo fieldInfo = fields.Where(p => p.GetCustomAttributes(typeof(AttributeAttribute), false).Length > 0)
				.Where(p => {
					var attribute = (AttributeAttribute)p.GetCustomAttributes(typeof(AttributeAttribute), false)[0];
					if(attribute.name != null) {
						return attribute.name == attributeName;
					}
					return p.Name == attributeName;

				}).FirstOrDefault();

				if(fieldInfo == null) {
					// GD.Print("Serialize - attributeName: " + attributeName + " not found");
					continue;
				}
				if (fieldInfo != null)
				{
					string fieldName = fieldInfo.Name; 
					AttributeAttribute attributeAttribute = (AttributeAttribute)fieldInfo.GetCustomAttribute(typeof(AttributeAttribute));
					if(attributeAttribute == null) {
						fieldName = attributeAttribute.name;
					}
					var property = fieldInfo;
					Type propertyType = property.FieldType;
					object attributeValue = Convert.ChangeType(attribute.Value, property.FieldType);
					property.SetValue(obj, attributeValue);
				}
			}
		}

		private void DeserializeElements<T>(XmlNode xmlElement, T obj) {
			Type type = obj.GetType();
			var fields = type.GetFields();

			foreach (XmlNode element in xmlElement.ChildNodes)
			{
				string elementName = element.Name;
				
				FieldInfo fieldInfo = fields.Where(p => p.GetCustomAttributes(typeof(ElementAttribute), false).Length > 0)
				.Where(p => {
					var attribute = (ElementAttribute)p.GetCustomAttributes(typeof(ElementAttribute), false)[0];
					if(attribute.name != null) {
						return attribute.name == elementName;
					}
					return p.Name == elementName;
				}).FirstOrDefault();
				if(fieldInfo == null) {
					GD.Print("Serialize - elementName: " + elementName + " not found");
					continue;
				}
				if (fieldInfo != null)
				{
					// GD.Print("Serialize - elementName: " + elementName + " fieldInfo: " + fieldInfo.Name);
					string fieldName = fieldInfo.Name;
					ElementAttribute elementAttribute = (ElementAttribute)fieldInfo.GetCustomAttribute(typeof(ElementAttribute));
					if(elementAttribute == null) {
						fieldName = elementAttribute.name;
					}
					Type elementType = fieldInfo.FieldType;
					
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
					var property = fieldInfo;
					object elementInstanceValue = Activator.CreateInstance(elementType, element);
					property.SetValue(obj, elementInstanceValue);
				}
				// GD.Print("Serialize - elementName: " + elementName + " done");
			}
		}




		public void Serialize<T>(XmlElement element, T obj)
		{
			Type type = obj.GetType();
			// GD.Print("Deserialize - type: " + type.Name);
			
			// Deserialize attributes
			SerializeAttributes(element, obj);
			// Deserialize elements
			SerializeElements(element, obj);
			
			// GD.Print("Deserialize - type: " + type.Name + " done");
			
			SerializeManualSerializer(element, obj);
		}

		private void SerializeAttributes<T>(XmlElement element, T obj) {
			Type type = obj.GetType();
			var fields = type.GetFields();
			var attributeFields = fields.Where(p => p.GetCustomAttributes(typeof(AttributeAttribute), false).Length > 0).ToList();

			foreach (var field in attributeFields)
			{
				// GD.Print("Deserialize - attribute field: " + field.Name);
				var attributeName = field.Name;
				var customAttribute = (AttributeAttribute)field.GetCustomAttribute(typeof(AttributeAttribute), false);
				if(customAttribute.name != null) {
					attributeName = customAttribute.name;
				}
				object attributeValue = field.GetValue(obj);
				if(attributeValue == null) {
					continue;
				}
				element.SetAttribute(attributeName, attributeValue.ToString());
			}
		}

		private void SerializeElements<T>(XmlElement element, T obj) {
			Type type = obj.GetType();
			var fields = type.GetFields();
			var elementFields = fields.Where(p => p.GetCustomAttributes(typeof(ElementAttribute), false).Length > 0).ToList();

			// Deserialize elements
			foreach (var field in elementFields)
			{
				// GD.Print("Deserialize - element field: " + field.Name);
				var elementName = field.Name;
				if(field.GetCustomAttributes(typeof(ElementAttribute), false).Length > 0) {
					if(((ElementAttribute)field.GetCustomAttributes(typeof(ElementAttribute), false)[0]).name != null) {
						elementName = ((ElementAttribute)field.GetCustomAttributes(typeof(ElementAttribute), false)[0]).name;
					}
				}
				object elementValue;
				try {
					elementValue = field.GetValue(obj);
				} catch (Exception e) {
					// GD.PrintErr("Deserialize - elementName: " + elementName + " not found in " + type.Name);
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
						Serialize(newElementChildList, childElement);
					}
					continue;
				}
				//create element
				XmlElement newElementChild = element.OwnerDocument.CreateElement(elementName);
				element.AppendChild(newElementChild);
				// If the element is not a List, create an object and set the value
				Serialize(newElementChild, elementValue);
			}
		}

		private void SerializeManualSerializer<T>(XmlElement element, T obj) {
			//check if obj implements ManualSerializer then calll Deserialize
			if(obj is ManualSerializer) {
				((ManualSerializer)obj).Serialize(element);
			}
		}
	}
	
}
