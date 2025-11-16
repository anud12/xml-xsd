import {template} from "../../../template/template";
import {Type} from "../../../type";
import {DependantType, GetObjectBodyReturn} from "../typeToString";
import {getTypeName, primitives} from "./getTypeName";
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
import {dependantTypeToBuildIndexForChild} from "./depedantType/dependantTypeToBuildIndexForChild";
import {dependantTypeBuildXpath} from "./depedantType/dependantTypeBuildXpath";
import {dependantTypeToDeserializeAtPath} from "./depedantType/dependantTypeToDeserializeAtPath";
import {dependantTypeToGetNodeAtPath} from "./depedantType/dependantTypeToGetNodeAtPath";


function typeDeclarationElementToClassString(directoryMetadata: DirectoryMetadata, dependantType: DependantType, extensions: DependantType[] = []): GetObjectBodyReturn {
  const dependantTypeList: DependantType[] = [];


  const childrenDeclaration = dependantTypeToChildrenDeclaration(dependantType);
  dependantTypeList.push(...(childrenDeclaration?.dependantTypes ?? []))

  let parentTypeName = dependantType.parentType?.name ? normalizeNameClass(dependantType.parentType?.name) : undefined;
  let parentFullTypeName = dependantType.parentType?.name ? `${getDependantTypePackage(dependantType.parentType)}.${normalizeNameClass(dependantType.parentType?.name)}` : "ro.anud.xml_xsd.implementation.util.LinkedNode";

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
      
      public static String nodeName = "${dependantType.name}";
      public static ${normalizeNameClass(dependantType.name)} fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try (var logger = logScope()) {
          var instance = new ${normalizeNameClass(dependantType.name)}();
          if(Objects.nonNull(parent)) {
            instance.parentNode(parent);
          }
          instance.rawNode(rawNode);
          instance.deserialize(rawNode);
          return logger.logReturn(instance);
        }
        
      }
      public static ${normalizeNameClass(dependantType.name)} fromRawNode(RawNode rawNode) {
        try (var logger = logScope()) {
          var instance = fromRawNode(rawNode, null);
          return logger.logReturn(instance);
        }
      }
      public static Optional<${normalizeNameClass(dependantType.name)}> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
          try(var logger = logScope()) {
            return logger.logReturn(rawNode.map(o -> ${normalizeNameClass(dependantType.name)}.fromRawNode(o, parent)));
          }
          
      }
      public static List<${normalizeNameClass(dependantType.name)}> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try (var logger = logScope()) {
          List<${normalizeNameClass(dependantType.name)}> returnList = Optional.ofNullable(rawNodeList)
              .orElse(List.of())
              .stream()
              .map(o -> ${normalizeNameClass(dependantType.name)}.fromRawNode(o, parent))
              .collect(Collectors.toList());
          return logger.logReturn(returnList);
        }
      }
      
      public String classTypeId() {
        return "${dependantTypeBuildXpath(dependantType)}";
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
      @Builder.Default
      private RawNode rawNode = new RawNode();
      
      public RawNode rawNode() {
        return rawNode;
      }
      public void rawNode(RawNode rawNode) {
        this.rawNode = rawNode;
      }
      
      @ToString.Exclude()
      @EqualsAndHashCode.Exclude()
      @JsonIgnore
      @Builder.Default
      private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
      
      public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode() {
        return parentNode;
      }
      
      @Builder.Default
      private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<${normalizeNameClass(dependantType.name)}>> onChangeList = new ArrayList<>();
      @Builder.Default
      private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<${normalizeNameClass(dependantType.name)}>> onRemoveList = new ArrayList<>();
      
      public String nodeName() {
        return "${dependantType.name}";
      }
      public static ${normalizeNameClass(dependantType.name)} of() {
        return new ${normalizeNameClass(dependantType.name)}(); 
      }
      
      public void notifyChange(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
        try (var logger = logScope()) {
          logger.log("Notify change for", this.buildPath());
          onChangeList.forEach(consumer -> consumer.onChange(object, this));
          parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(object));          
        }
      }
      
      public void notifyRemove(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
        try (var logger = logScope()) {
          logger.log("Notify remove for", this.buildPath());
          onRemoveList.forEach(consumer -> consumer.onRemove(object, this));
          parentNode.ifPresent(linkedNode -> linkedNode.notifyRemove(object));          
        }
      }
  
      public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
        this.parentNode.ifPresent(parent -> notifyRemove());
        this.parentNode = Optional.of(linkedNode);
        notifyChange();
      }
      
      ${parentTypeName && template()`
        public Optional<${parentFullTypeName}> parentAs${parentTypeName}() {
          return parentNode.flatMap(node -> {
            if (node instanceof ${parentFullTypeName} casted){
              return Optional.of(casted);
            }
            return Optional.empty();
          });
        }
      `}
      
      public void removeChild(Object object) {
          ${dependantTypeToRemoveChild(dependantType)}
      }
      
      public int buildIndexForChild(Object object) {
          ${dependantTypeToBuildIndexForChild(dependantType)}
          return 0;
      }
      
      public void removeFromParent() {
        parentNode.ifPresent(node -> node.removeChild(this));
      }
      
      public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<${normalizeNameClass(dependantType.name)}> callback) {
        try (var logger = logScope()) {
          onChangeList.add(callback);
          return logger.logReturn(() -> onChangeList.remove(callback));
        }
      }
      public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<${normalizeNameClass(dependantType.name)}> callback) {
        try (var logger = logScope()) {
          onRemoveList.add(callback);
          return logger.logReturn(() -> onRemoveList.remove(callback));
        }
      }
      
      public void deserialize (RawNode rawNode) {
        try (var logger = logScope()) {
          this.rawNode = rawNode;
          var isDirty = false;
          try (var innerLogger = logScope("attributes")) {
            //Deserialize attributes
            ${dependantTypeToAttributeDeserializationBody(dependantType)}
          
            ${extensions.map(extension => {
                return template()`
                                // Deserialize arguments of ${extension.name}
                                ${dependantTypeToAttributeDeserializationBody(extension)}
                              `
              }).join("\n")}
          }
          try (var innerLogger = logScope("children")) {
            //Deserialize children
            ${dependantTypeToChildrenDeserializationBody(dependantType)}
            
            ${extensions.map(extension => {
              return template()`
                               // Deserialize children of ${extension.name}
                               ${dependantTypeToChildrenDeserializationBody(extension)}
                              `
            }).join("\n")}
          }
          
          if(isDirty) {
            notifyChange();
          }
        } catch (Exception e) {
          throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
        }
        
      }
      
      public RawNode serializeIntoRawNode() 
      {
        try (var logger = logScope()) {
          rawNode.setTag("${dependantType.name}");
          try (var innerLogger = logScope("attributes")) {
            //Serialize attributes
            ${dependantTypeToAttributeSerializationBody(dependantType)}
          
            ${extensions.map(extension => {
              return template()`
                             // Serialize arguments of ${extension.name}
                             ${dependantTypeToAttributeSerializationBody(extension)}
                            `
            }).join("\n")}
          }
          try (var innerLogger = logScope("children")) {
          
            //Serialize children
            ${dependantTypeToChildrenSerializationBody(dependantType)}
        
            ${extensions.map(extension => {
                return template()`
                       // Serialize children of ${extension.name}
                       ${dependantTypeToChildrenSerializationBody(extension)}
                      `
              }).join("\n")}
            return rawNode;
          }
        }
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
      
      
      public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
         if(xpath.startsWith(".")) 
          {
            xpath = xpath.substring(1);
          }
          ${dependantTypeToDeserializeAtPath(dependantType)?.templateString}
          
          deserialize(rawNode);
          return this;
      }
    
      public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
         if(xpath.startsWith(".")) 
          {
            xpath = xpath.substring(1);
          }
          ${dependantTypeToGetNodeAtPath(dependantType)?.templateString}
          return Optional.of(this);
      }
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
      import ro.anud.xml_xsd.implementation.util.Subscription;
      import java.util.function.Consumer;
      import java.util.stream.Collectors;
      
      import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;
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