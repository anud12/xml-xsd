import {template} from "../../../template/template";
import {Type} from "../../../type";
import {DependantType, GetObjectBodyReturn} from "../typeToString";
import {getTypeName, primitives} from "./geTypeName";
import {normalizeNameClass} from "./normalizeNameClass";
import {dependantTypeToAttributeDeclaration} from "./depedantType/dependantTypeToAttributeDeclaration";
import {dependantTypeToChildrenDeclaration} from "./depedantType/dependantTypeToChildrenDeclaration";
import {dependantTypeToAttributeSerializationBody} from "./depedantType/dependantTypeToAttributeSerializationBody";
import {dependantTypeToChildrenSerializationBody} from "./depedantType/dependantTypeToChildrenSerializationBody";
import {dependantTypeToAttributeDeserializationBody} from "./depedantType/dependantTypeToAttributeDeserializationBody";
import {dependantTypeToChildrenDeserializationBody} from "./depedantType/dependantTypeToChildrenDeserializationBody";
import {DirectoryMetadata} from "../../../memory_fs/directoryMetadata";
import {dependantTypeGetFullQualifiedName} from "./depedantType/dependantTypeGetFullQualifiedName";
import {basePackage, getDependantTypePackage} from "./depedantType/getDependantTypePackage";
import {getDependantTypeChildPackage} from "./depedantType/getDependantTypeChildPackage";
import {dependantTypeToAttributeGetterSetter} from "./depedantType/dependantTypeToAttributeGetterSetter";
import {dependantTypeToChildrenGetterSetter} from "./depedantType/dependantTypeToChildrenGetterSetter";
import {interfaceTypeDeclarationToString} from "./interfaceTypeDeclarationToString";
import {dependantTypeToRemoveChild} from "./depedantType/dependantTypeToRemoveChild";


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
    @NoArgsConstructor
    @AllArgsConstructor
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public class ${normalizeNameClass(dependantType.name)} implements ${extensionNames.length > 0 && ` ${extensionNames.map(e => e + `<${normalizeNameClass(dependantType.name)}>`).join(", ")}, `} ro.anud.xml_xsd.implementation.util.LinkedNode {
          
          
      public static ${normalizeNameClass(dependantType.name)} fromRawNode(RawNode rawNode) {
        logEnter();
        var instance = new ${normalizeNameClass(dependantType.name)}();
        instance.setRawNode(rawNode);
        instance.deserialize(rawNode);
        return logReturn(instance);
      }
      public static ${normalizeNameClass(dependantType.name)} fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        var instance = fromRawNode(rawNode);
        instance.setParentNode(parent);
        return logReturn(instance);
      }
      public static Optional<${normalizeNameClass(dependantType.name)}> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
          logEnter();
          return logReturn(rawNode.map(o -> ${normalizeNameClass(dependantType.name)}.fromRawNode(o, parent)));
      }
      public static List<${normalizeNameClass(dependantType.name)}> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        List<${normalizeNameClass(dependantType.name)}> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> ${normalizeNameClass(dependantType.name)}.fromRawNode(o, parent))
            .collect(Collectors.toList());
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
      @Builder.Default
      private RawNode rawNode = new RawNode();
      
      @Getter
      @ToString.Exclude()
      @EqualsAndHashCode.Exclude()
      @JsonIgnore
      @Builder.Default
      private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
      
      @Builder.Default
      private List<Consumer<${normalizeNameClass(dependantType.name)}>> onChangeList = new ArrayList<>();
      
      public String nodeName() {
        return "${dependantType.name}";
      }
  
      public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
        this.parentNode = Optional.of(linkedNode);
      }
      
      public void removeChild(Object object) {
          ${dependantTypeToRemoveChild(dependantType)}
      }
      
      public void removeFromParent() {
        parentNode.ifPresent(node -> node.removeChild(this));
      }
      
      public Subscription onChange(Consumer<${normalizeNameClass(dependantType.name)}> onChange) {
        logEnter();
        onChangeList.add(onChange);
        return logReturn(() -> onChangeList.remove(onChange));
      }
      
      public void deserialize (RawNode rawNode) {
        var logger = logEnter();
        this.rawNode = rawNode;
        // Godot.GD.Print("Deserializing ${dependantType.name}");
        var innerLogger = logger.log("attributes");
        //Deserialize attributes
        ${dependantTypeToAttributeDeserializationBody(dependantType)}
        
        ${extensions.map(extension => {
    return template()`
                   // Deserialize arguments of ${extension.name}
                   ${dependantTypeToAttributeDeserializationBody(extension)}
                  `
  }).join("\n")}
        innerLogger = logger.log("children");
        //Deserialize children
        ${dependantTypeToChildrenDeserializationBody(dependantType)}
        
        ${extensions.map(extension => {
    return template()`
                     // Deserialize children of ${extension.name}
                     ${dependantTypeToChildrenDeserializationBody(extension)}
                    `
  }).join("\n")}
        logReturnVoid();
      }
      
      public RawNode serializeIntoRawNode() 
      {
        var logger = logEnter();
        var innerLogger = logger.log("attributes");
        //Serialize attributes
        ${dependantTypeToAttributeSerializationBody(dependantType)}
        
        ${extensions.map(extension => {
    return template()`
                   // Serialize arguments of ${extension.name}
                   ${dependantTypeToAttributeSerializationBody(extension)}
                  `
  }).join("\n")}
        
        innerLogger = logger.log("children");
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
    const result = interfaceTypeDeclarationToString(directoryMetadata, localWrittenClassesList, extensinon);
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
      import static ro.anud.xml_xsd.implementation.util.LocalLogger.log;
      import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;
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