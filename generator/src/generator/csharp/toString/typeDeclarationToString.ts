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
    public class ${normalizeName(dependantType.name)} ${extensionNames.length > 0 && `: ${extensionNames.join(", ")}`} {
      public RawNode rawNode = new RawNode();
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
                    public ${typeString} Get_${normalizeName(key)}();
                    public void Set_${normalizeName(key)}(${typeString} value);`
      }

      const typeString = value.isNullable
        ? `${type}?`
        : type;
      return template()`
                  public ${typeString} Get_${normalizeName(key)}();
                  public void Set_${normalizeName(key)}(${typeString} value);`
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
        : `List<${type}>`
      typeString = value.isNullable
        ? `${typeString}?`
        : typeString

      const fullPathTypeString = value.isSingle
        ? `${getDependantTypeChildNamespace(dependantType)}.${type}`
        : `List<${getDependantTypeChildNamespace(dependantType)}.${type}>`;
      
      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          name: type,
        })
        return template()`
          public ${fullPathTypeString} Get_${normalizeName(key)}();
          public void Set_${normalizeName(key)}(${fullPathTypeString} value);
          `
      }
      if (value.metaType === "union" || value.metaType === "composition") {
        dependantTypeList.push({
          type: "union",
          value: value,
          name: type,
        })
        return template()`
        public ${fullPathTypeString} Get_${normalizeName(key)}();
        public void Set_${normalizeName(key)}(${fullPathTypeString} value);
        `
      }
      if (value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          name: type,
        })
        return template()`
        public ${typeString} Get_${normalizeName(key)}();
        public void Set_${normalizeName(key)}(${typeString} value);
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
      using System.Collections.Generic;
      using System.Xml;
      using System.Linq;
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