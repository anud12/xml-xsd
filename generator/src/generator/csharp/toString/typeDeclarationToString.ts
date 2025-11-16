import {template} from "../../../template/template";
import {Type} from "../../../type";
import {DependantType, GetObjectBodyReturn} from "../typeToString";
import {getTypeName, primitives} from "./geTypeName";
import {normalizeName} from "./normalizeName";
import {dependantTypeToAttributeDeclaration} from "./dependantTypeToAttributeDeclaration";
import {dependantTypeToAttributeGetterSetter} from "./dependantTypeToAttributeGetterSetter";
import {dependantTypeToChildrenDeclaration} from "./dependantTypeToChildrenDeclaration";
import {dependantTypeToChildrenGetterSetter} from "./dependantTypeToChildrenGetterSetter";
import {dependantTypeToAttributeSerializationBody} from "./dependantTypeToAttributeSerializationBody";
import {dependantTypeToChildrenSerializationBody} from "./dependantTypeToChildrenSerializationBody";
import {dependantTypeToAttributeDeserializationBody} from "./dependantTypeToAttributeDeserializationBody";
import {dependantTypeToChildrenDeserializationBody} from "./dependantTypeToChildrenDeserializationBody";
import {DirectoryMetadata} from "../../../memory_fs/directoryMetadata";
import {dependantTypeGetFullQualifiedName} from "./dependantTypeGetFullQualifiedName";
import {getDependantTypeNamespace} from "./getDependantTypeNamespace";
import {getDependantTypeChildNamespace} from "./getDependantTypeChildNamespace";
import {dependantTypeBuildXpath} from "./dependantType/dependantTypeBuildXpath";
import {dependantTypeToDeserializeAtPath} from "./dependantTypeToDeserializeAtPath";
import {dependantTypeBuildIndexForChild} from "./dependantType/dependantTypeBuildIndexForChild";
import {dependantTypeSetAttribute} from "./dependantType/dependatTypeSetAttribute";
import {dependantTypeSetChild} from "./dependantType/dependatTypeSetChild";
import {dependantTypeClearChild} from "./dependantType/dependatTypeClearChild";
import {dependantTypeToIsValidChildType} from "./dependantTypeToIsValidChildType";
import {dependantTypeToEqualsAndHashCodeFunctions} from "./dependantTypeToEqualsAndHashCode";


type ClassTemplateParts = {
  declaration: (body: string) => string,
  attributeDeclaration: (dependantType: DependantType) => string,
  attributeGetterSetter: (dependantType: DependantType) => string,
  childrenDeclaration: (dependantType: DependantType) => { dependantTypes: DependantType[], templateString: string },
  childrenGetterSetter: (dependantType: DependantType) => { dependantTypes: DependantType[], templateString: string },
  fieldGetterSetter: () => string,
  serializer: () => string,
}


function typeDeclarationElementToClassString(directoryMetadata: DirectoryMetadata, dependantType: DependantType, extensions: DependantType[] = []): GetObjectBodyReturn {
  const dependantTypeList: DependantType[] = [];


  const childrenDeclaration = dependantTypeToChildrenDeclaration(dependantType);
  dependantTypeList.push(...(childrenDeclaration?.dependantTypes ?? []))

  const extensionNames = extensions.map(e => `I${e.name}`)

  const templateString = template()`
    public class ${normalizeName(dependantType.name)} : IEquatable<${normalizeName(dependantType.name)}>, XSD.ILinkedNode ${extensionNames.length > 0 && `, ${extensionNames.join(", ")}`} {
      
      public static string ClassTypeId = "${dependantTypeBuildXpath(dependantType)}";
      public static string TagName = "${dependantType.name}";
      
      public string NodeName {get =>"${dependantType.name}";}
      public RawNode rawNode = new RawNode();
      
      private ILinkedNode? _parentNode; 
      public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
      private List<Action<${normalizeName(dependantType.name)}>> _onSelfChangeCallbackList = new();
      private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();
      
      //Attributes
      ${dependantTypeToAttributeDeclaration(dependantType)}
      
      ${extensions.map(extension => {
    return template()`
        //Attributes of ${extension.name}
        ${dependantTypeToAttributeDeclaration(extension)}
        `
  }).join("\n")}
      
      //Children elements
      ${childrenDeclaration?.templateString}
      
      ${extensions.map(extension => {
    return template()`
        //Children of ${extension.name}
        ${dependantTypeToChildrenDeclaration(extension)?.templateString}
        `
  }).join("\n")}
      public ${normalizeName(dependantType.name)}() 
      {
      }
      
      public ${normalizeName(dependantType.name)}(RawNode rawNode) 
      {
        Deserialize(rawNode);
      }
      
      public ${normalizeName(dependantType.name)}(XmlElement xmlElement) 
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }
      
      public void SetAttribute(string name, string? value) 
      {
        ${dependantTypeSetAttribute(dependantType)}
      }
      
      public void SetChild(dynamic linkedNode) 
      {
        ${dependantTypeSetChild(dependantType)?.templateString ?? ""}
      }
      
      public void ClearChild(dynamic linkedNode) 
      {
        ${dependantTypeClearChild(dependantType)?.templateString ?? ""}
      }
      
      
      public Action OnSelfChange(Action<${normalizeName(dependantType.name)}> callback)
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
        // Godot.GD.Print("Deserializing ${dependantType.name}");
        //Deserialize arguments
        ${dependantTypeToAttributeDeserializationBody(dependantType)}
        
        ${extensions.map(extension => {
    return template()`
             // Deserialize arguments of ${extension.name}
             ${dependantTypeToAttributeDeserializationBody(extension)}
            `
  })}
        
        //Deserialize children
        ${dependantTypeToChildrenDeserializationBody(dependantType)}
        
        ${extensions.map(extension => {
    return template()`
               // Deserialize children of ${extension.name}
               ${dependantTypeToChildrenDeserializationBody(extension)}
              `
  })}
        NotifyChange();
      }
      
      public RawNode SerializeIntoRawNode() 
      {
        //Serialize arguments
        ${dependantTypeToAttributeSerializationBody(dependantType)}
        
        ${extensions.map(extension => {
    return template()`
             // Serialize arguments of ${extension.name}
             ${dependantTypeToAttributeSerializationBody(extension)}
            `
  })}
        
        //Serialize children
        ${dependantTypeToChildrenSerializationBody(dependantType)}
        
        ${extensions.map(extension => {
    return template()`
           // Serialize children of ${extension.name}
           ${dependantTypeToChildrenSerializationBody(extension)}
          `
  })}
        return rawNode;
      }
      
      public void Serialize(XmlElement element)
      {
          // Godot.GD.Print("Serializing ${dependantType.name}");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
      ${dependantTypeToAttributeGetterSetter(dependantType)}
      ${extensions.map(extension => dependantTypeToAttributeGetterSetter(extension)).join("\n")}
      ${dependantTypeToChildrenGetterSetter(dependantType)?.templateString}
      ${extensions.map(extension => dependantTypeToChildrenGetterSetter(extension)?.templateString).join("\n")}
      
      
      public void DeserializeAtPath(string xpath, RawNode rawNode) 
      {
        if(xpath.StartsWith(".")) 
        {
          xpath = xpath.Substring(1);
        }
        ${dependantTypeToDeserializeAtPath(dependantType)?.templateString}
        
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
        ${dependantTypeBuildIndexForChild(dependantType)}
        return null;
      }
      
      public bool IsValidChildType(ILinkedNode candidateChild) {
        ${dependantTypeToIsValidChildType(dependantType)?.templateString}
      }
      
      ${dependantTypeToEqualsAndHashCodeFunctions(dependantType)}
    }
    
  `


  return {
    writtenClass: [dependantTypeGetFullQualifiedName(dependantType)],
    dependantTypes: dependantTypeList,
    templateString: templateString
  }
}


function typeDeclarationElementToInterfaceString(directoryMetadata: DirectoryMetadata, writtenClasses: string[], dependantType: DependantType): GetObjectBodyReturn {
  const dependantTypeList: DependantType[] = [];
  const interfaceName = `I${normalizeName(dependantType.name)}`;

  if (writtenClasses.includes(interfaceName)) {
    return {
      dependantTypes: [],
      templateString: "",
      writtenClass: []
    }
  }

  const templateString = template()`
    public interface ${interfaceName} {
      ${dependantType.value.attributes?.metaType === "object" && template()`
        //Attributes
        ${Object.entries(dependantType.value.attributes.value ?? {}).map(([key, value]) => {
    const type = getTypeName(value, key, dependantType);
    if (value.metaType === "primitive") {
      if (type !== primitives.int) {

        const typeString = value.isNullable
          ? `${primitives.string}?`
          : primitives.string;
        return template()`
                    public ${typeString} ${normalizeName(key)} { get; set; }
                    `
      }

      const typeString = value.isNullable
        ? `${type}?`
        : type;
      return template()`
                  public ${typeString} ${normalizeName(key)} { get; set; }
                  `
    }

    return template()`/* ignored attribute key={key} of type=${type}*/`
  }).filter(e => e).join("\n")}
      `}

      ${dependantType.value.metaType === "object" && template()`
        //Children elements
        ${Object.entries(dependantType.value.value).flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {
      let type = getTypeName(value, key, dependantType);
      type = normalizeName(type);

      let typeString = value.isSingle
        ? `${type}`
        : `LinkedNodeCollection<${type}>`
      typeString = value.isNullable
        ? `${typeString}?`
        : typeString

      const fullPathTypeString = value.isSingle
        ? `${getDependantTypeChildNamespace(dependantType)}.${type}`
        : `LinkedNodeCollection<${getDependantTypeChildNamespace(dependantType)}.${type}>`;
      
      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          name: type,
        })
        return template()`
          public ${fullPathTypeString} ${normalizeName(key)} { get; set; }
          `
      }
      if (value.metaType === "union" || value.metaType === "composition") {
        dependantTypeList.push({
          type: "union",
          value: value,
          name: type,
        })
        return template()`
         public ${fullPathTypeString} ${normalizeName(key)} { get; set; }
        `
      }
      if (value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          name: type,
        })
        return template()`
         public ${typeString} ${normalizeName(key)} { get; set; }
        `
      }
      return template()`/* ignored children key:${key} of type:${type}*/`
    }).filter(e => e).join("\n")}
      `}
      public void Deserialize (RawNode rawNode);

      public RawNode SerializeIntoRawNode();

      public void Serialize(XmlElement element);
      
    }
  `


  return {
    writtenClass: [interfaceName],
    dependantTypes: dependantTypeList,
    templateString: templateString
  }
}

export function typeDeclarationElementToString(directoryMetadata: DirectoryMetadata, writtenClassesList: string[], dependantType: DependantType, extensions: DependantType[] = []): GetObjectBodyReturn {


  let subNamespaces: string[] = [];
  let parentType = dependantType.parentType;
  while (parentType) {
    subNamespaces.push(parentType.name)
    parentType = parentType.parentType;
  }
  subNamespaces.reverse()

  console.log("typeDeclarationElementToString", subNamespaces, dependantType.name)

  let localWrittenClassesList = [...writtenClassesList];
  const classResult = typeDeclarationElementToClassString(directoryMetadata, dependantType, extensions);

  const interfaceResult = extensions.map(extensinon => {
    const result = typeDeclarationElementToInterfaceString(directoryMetadata, localWrittenClassesList, extensinon);
    localWrittenClassesList = [...localWrittenClassesList, ...result.writtenClass]
    return result;
  })

  const templateString = template()`
      using System;
      using System.Collections.Immutable;
      using System.Collections.Generic;
      using System.Xml;
      using System.Linq;
      using Guiclient.util;
      using Godot;
      using XSD;
      
      
      namespace ${getDependantTypeChildNamespace(dependantType)} {}
      namespace XSD {
        ${interfaceResult.map(e => e.templateString).filter(e => e).join("\n")}
      }
      namespace ${getDependantTypeNamespace(dependantType)} {
        ${classResult.templateString}
      }
      `;

  const directory = getDependantTypeChildNamespace(dependantType).split(".")
    .filter(value => value !== "XSD")
    .reduce((acc, value) => {
      return acc.createOrGetDirectory(value.split("N")[1])
    }, directoryMetadata);

  directory.createFile(dependantType.name + ".cs", () => templateString)

  return {
    writtenClass: [
      ...classResult.writtenClass,
      ...interfaceResult.flatMap(e => e?.writtenClass)
    ],
    dependantTypes: [...classResult.dependantTypes, ...interfaceResult.flatMap(e => e?.dependantTypes)],
    templateString: templateString
  }
}