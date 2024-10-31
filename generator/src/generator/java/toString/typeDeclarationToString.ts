import {template} from "../../../template/template";
import {Type} from "../../../type";
import {DependantType, GetObjectBodyReturn} from "../typeToString";
import {getTypeName, primitives} from "./geTypeName";
import {normalizeNameClass} from "./normalizeNameClass";
import {dependantTypeToAttributeDeclaration} from "./dependantTypeToAttributeDeclaration";
import {dependantTypeToChildrenDeclaration} from "./dependantTypeToChildrenDeclaration";
import {dependantTypeToAttributeSerializationBody} from "./dependantTypeToAttributeSerializationBody";
import {dependantTypeToChildrenSerializationBody} from "./dependantTypeToChildrenSerializationBody";
import {dependantTypeToAttributeDeserializationBody} from "./dependantTypeToAttributeDeserializationBody";
import {dependantTypeToChildrenDeserializationBody} from "./dependantTypeToChildrenDeserializationBody";
import {DirectoryMetadata} from "../../../memory_fs/directoryMetadata";
import {dependantTypeGetFullQualifiedName} from "./dependantTypeGetFullQualifiedName";
import {basePackage, getDependantTypePackage} from "./getDependantTypePackage";
import {getDependantTypeChildPackage} from "./getDependantTypeChildPackage";


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

  const extensionNames = extensions.map(e => `${basePackage}.interfaces.I${normalizeNameClass(e.name)}.I${normalizeNameClass(e.name)}`)

  const templateString = template()`
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class ${normalizeNameClass(dependantType.name)} ${extensionNames.length > 0 && `implements ${extensionNames.join(", ")}`} {
    
      @ToString.Exclude()
      @EqualsAndHashCode.Exclude()
      @JsonIgnore
      private RawNode rawNode = new RawNode();
      
      public static ${normalizeNameClass(dependantType.name)} fromRawNode(RawNode rawNode) {
        logEnter();
        var instance = new ${normalizeNameClass(dependantType.name)}();
        instance.setRawNode(rawNode);
        instance.deserialize(rawNode);
        return logReturn(instance);
      }
        public static Optional<${normalizeNameClass(dependantType.name)}> fromRawNode(Optional<RawNode> rawNode) {
          logEnter();
          return logReturn(rawNode.map(${normalizeNameClass(dependantType.name)}::fromRawNode));
      }
      public static List<${normalizeNameClass(dependantType.name)}> fromRawNode(List<RawNode> rawNodeList) {
        logEnter();
        List<${normalizeNameClass(dependantType.name)}> returnList = rawNodeList.stream().map(${normalizeNameClass(dependantType.name)}::fromRawNode).collect(Collectors.toList());
        return logReturn(returnList);
      }
      
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
  
      public void deserialize (RawNode rawNode) {
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
      
      public void Serialize(Document document, Element element)
      {
          // Godot.GD.Print("Serializing ${dependantType.name}");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.populateNode(document, element);
      }
    }
    
    /*
      dependant type:
      ${JSON.stringify(dependantType, null, 2)}
    */
  `
//${dependantTypeToAttributeGetterSetter(dependantType)}
//       ${extensions.map(extension => dependantTypeToAttributeGetterSetter(extension)).join("\n")}
//       ${dependantTypeToChildrenGetterSetter(dependantType)?.templateString}
//       ${extensions.map(extension => dependantTypeToChildrenGetterSetter(extension)?.templateString).join("\n")}

  return {
    writtenClass: [dependantTypeGetFullQualifiedName(dependantType)],
    dependantTypes: dependantTypeList,
    templateString: templateString
  }
}


function typeDeclarationElementToInterfaceString(directoryMetadata: DirectoryMetadata, writtenClasses: string[], dependantType: DependantType): GetObjectBodyReturn {
  const dependantTypeList: DependantType[] = [];
  const interfaceName = `I${normalizeNameClass(dependantType.name)}`;

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
                    public ${typeString} get${normalizeNameClass(key)}();
                    public void set${normalizeNameClass(key)}(${typeString} value);`
      }

      const typeString = value.isNullable
        ? `${type}?`
        : type;
      return template()`
                  public ${typeString} get${normalizeNameClass(key)}();
                  public void set${normalizeNameClass(key)}(${typeString} value);`
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
      const normalizedName = normalizeNameClass(type);


      let nullableFullPathString =  "";
      if(value.isSingle) {
        nullableFullPathString = `${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}`;
      }
      if(value.isNullable) {
        nullableFullPathString = `Optional<${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}>`
      }
      if(!value.isSingle) {
        nullableFullPathString = `List<${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}>`
      }

      let nullableTypeString = ""
      if(value.isSingle) {
        nullableTypeString = `${basePackage}.${normalizedName}.${normalizedName}`;
      }
      if(value.isNullable) {
        nullableTypeString = `Optional<${basePackage}.${normalizedName}.${normalizedName}>`
      }
      if(!value.isSingle) {
        nullableTypeString = `List<${basePackage}.${normalizedName}.${normalizedName}>`
      }
      
      let typeString = value.isSingle
        ? `${basePackage}.${type}.${type}`
        : `List<${basePackage}.${type}.${type}>`
      typeString = value.isNullable
        ? `${typeString}?`
        : typeString

      const fullPathTypeString = value.isSingle
        ? `${getDependantTypePackage(dependantType)}.${normalizeNameClass(type)}.${normalizeNameClass(type)}`
        : `List<${getDependantTypePackage(dependantType)}.${normalizeNameClass(type)}.${normalizeNameClass(type)}>`;
      
      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          name: type,
        })
        return template()`
          public ${nullableFullPathString} get${normalizeNameClass(key)}();
          public void set${normalizeNameClass(key)}(${nullableFullPathString} value);
          `
      }
      if (value.metaType === "union" || value.metaType === "composition") {
        dependantTypeList.push({
          type: "union",
          value: value,
          name: type,
        })
        return template()`
        public ${nullableFullPathString} get${normalizeNameClass(key)}();
        public void set${normalizeNameClass(key)}(${nullableFullPathString} value);
        `
      }
      if (value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          name: type,
        })
        return template()`
        public ${nullableTypeString} get${normalizeNameClass(key)}();
        public void set${normalizeNameClass(key)}(${nullableTypeString} value);
        `
      }
      return template()`/* ignored children key:${key} of type:${type}*/`
    }).filter(e => e).join("\n")}
      `}
      public void deserialize (RawNode rawNode);

      public RawNode SerializeIntoRawNode();

      public void Serialize(Document document, Element element);
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

  const commonImports = template()`
      import com.fasterxml.jackson.annotation.JsonIgnore;
      import lombok.*;
      import org.w3c.dom.Document;
      import org.w3c.dom.Element;
      import ro.anud.xml_xsd.implementation.util.RawNode;
      
      import java.util.List;
      import java.util.ArrayList;
      import java.util.Optional;
      import java.util.stream.Collectors;
      
      import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
      import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
      `

  const templateString = template()`
      package ${getDependantTypePackage(dependantType)};
      ${commonImports}
      
      ${classResult.templateString}
      `;


  // namespace ${getDependantTypeChildNamespace(dependantType)} {}
  // namespace XSD {
  //   ${interfaceResult.map(e => e.templateString).filter(e => e).join("\n")}
  // }
  // namespace ${getDependantTypeNamespace(dependantType)} {
  //   ${classResult.templateString}
  // }
  const directory = getDependantTypePackage(dependantType)
    .replace(basePackage, "").split(".")
    .reduce((acc, value) => {
      return acc.createOrGetDirectory(value)
    }, directoryMetadata);

  directory.createFile(normalizeNameClass(dependantType.name) + ".java", () => templateString)

  interfaceResult.forEach(result => {

    const directory = directoryMetadata.createOrGetDirectory("interfaces").createOrGetDirectory(result.writtenClass[0])
    directory.createOrGetFile(`${result.writtenClass[0]}.java`, () => {
      return template()`
        package ${basePackage}.interfaces.${result.writtenClass[0]};
        ${commonImports}
        
        ${result.templateString}
      `
    })
  })

  interfaceResult.map(e => e.templateString).filter(e => e).join("\n")

  return {
    writtenClass: [
      ...classResult.writtenClass,
      ...interfaceResult.flatMap(e => e?.writtenClass)
    ],
    dependantTypes: [...classResult.dependantTypes, ...interfaceResult.flatMap(e => e?.dependantTypes)],
    templateString: templateString
  }
}