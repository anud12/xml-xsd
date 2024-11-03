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
import {dependantTypeToAttributeGetterSetter} from "./dependantTypeToAttributeGetterSetter";
import {dependantTypeToChildrenGetterSetter} from "./dependantTypeToChildrenGetterSetter";


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
  if (dependantType.typeDeclaration?.type === "complex") {
    extensionNames.push(`${basePackage}.interfaces.I${normalizeNameClass(dependantType.name)}.I${normalizeNameClass(dependantType.name)}`)
  }
  const templateString = template()`
    @EqualsAndHashCode
    @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class ${normalizeNameClass(dependantType.name)} ${extensionNames.length > 0 && `implements ${extensionNames.map(e => e + `<${normalizeNameClass(dependantType.name)}>`).join(", ")}`} {
          
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
  
  
      @ToString.Exclude()
      @EqualsAndHashCode.Exclude()
      @JsonIgnore
      @Getter
      @Setter
      private RawNode rawNode = new RawNode();
      private List<Consumer<${normalizeNameClass(dependantType.name)}>> onChangeList = new ArrayList<>();
  
      
      public Subscription onChange(Consumer<${normalizeNameClass(dependantType.name)}> onChange) {
        logEnter();
        onChangeList.add(onChange);
        return logReturn(() -> onChangeList.remove(onChange));
      }
      
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
  }).join("\n")}
        
        //Deserialize children
        ${dependantTypeToChildrenDeserializationBody(dependantType)}
        
        ${extensions.map(extension => {
    return template()`
                     // Deserialize children of ${extension.name}
                     ${dependantTypeToChildrenDeserializationBody(extension)}
                    `
  }).join("\n")}
      }
      
      public RawNode serializeIntoRawNode() 
      {
        //Serialize arguments
        ${dependantTypeToAttributeSerializationBody(dependantType)}
        
        ${extensions.map(extension => {
    return template()`
                   // Serialize arguments of ${extension.name}
                   ${dependantTypeToAttributeSerializationBody(extension)}
                  `
  }).join("\n")}
        
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
      
      public void serialize(Document document, Element element)
      {
          // Godot.GD.Print("Serializing ${dependantType.name}");
          var updatedRawNode = serializeIntoRawNode();
          updatedRawNode.populateNode(document, element);
      }
      
      ${dependantTypeToAttributeGetterSetter(dependantType)}
      ${extensions.map(extension => dependantTypeToAttributeGetterSetter(extension, dependantType)).join("\n")}
      ${dependantTypeToChildrenGetterSetter(dependantType)?.templateString}
      ${extensions.map(extension => dependantTypeToChildrenGetterSetter(extension, dependantType)?.templateString).join("\n")}
      
    }
    
    
    /*
      dependant type:
      ${JSON.stringify({...dependantType, parentType: undefined}, null, 2)}
    */
  `

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
    public interface ${interfaceName}<T> {
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
                    public T set${normalizeNameClass(key)}(${typeString} value);`
      }

      const typeString = value.isNullable
        ? `${type}?`
        : type;
      return template()`
                  public ${typeString} get${normalizeNameClass(key)}();
                  public T set${normalizeNameClass(key)}(${typeString} value);`
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

      let baseTypeString = `${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}`;
      if (value.metaType === "reference") {
        baseTypeString = `${basePackage}.${normalizedName}.${normalizedName}`;
      }


      let pathString = "";
      if (value.isSingle) {
        pathString = baseTypeString;
      }
      if (value.isNullable) {
        pathString = `Optional<${baseTypeString}>`
      }
      if (!value.isSingle) {
        pathString = `List<${baseTypeString}>`
      }

      const templateString = template()`
          public ${pathString} get${normalizeNameClass(key)}();
          public Stream<${baseTypeString}> stream${normalizeNameClass(key)}();
          ${value.isSingle && template()`
            public T set${normalizeNameClass(key)}(${baseTypeString} value);
          `}
          ${!value.isSingle && template()`
            public T add${normalizeNameClass(key)}(${baseTypeString} value);
            public T addAll${normalizeNameClass(key)}(List<${baseTypeString}> value);
            public T remove${normalizeNameClass(key)}(${baseTypeString} value);
          `}
      `

      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          typeDeclaration: undefined,
          name: type,
        })
        return templateString;
      }
      if (value.metaType === "union" || value.metaType === "composition") {
        dependantTypeList.push({
          type: "union",
          value: value,
          typeDeclaration: undefined,
          name: type,
        })
        return templateString;
      }
      if (value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          typeDeclaration: undefined,
          name: type,
        })
        return templateString;
      }
      return template()`/* ignored children key:${key} of type:${type}*/`
    }).filter(e => e).join("\n")}
      `}
      public void deserialize (RawNode rawNode);

      public RawNode serializeIntoRawNode();

      public void serialize(Document document, Element element);
    }
    
    /*
    ${JSON.stringify({...dependantType, parentType: undefined}, null, 2)}
    */
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


  if (dependantType.typeDeclaration?.type === "complex") {
    extensions.push(dependantType);
  }

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
      
      import java.util.*;
      import java.util.stream.Stream;
      import ro.anud.xml_xsd.implementation.util.Subscription;
      import java.util.function.Consumer;
      import java.util.stream.Collectors;
      
      import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
      import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
      `

  const templateString = template()`
      package ${getDependantTypePackage(dependantType)};
      ${commonImports}
      
      ${classResult.templateString}
      `;


  const directory = getDependantTypePackage(dependantType)
    .replace(basePackage, "").split(".")
    .reduce((acc, value) => {
      return acc.createOrGetDirectory(value)
    }, directoryMetadata);

  directory.createFile(normalizeNameClass(dependantType.name) + ".java", () => templateString)

  interfaceResult.filter(result => result?.writtenClass[0]).forEach(result => {

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