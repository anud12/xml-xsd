import {DependantType, GetObjectBodyReturn} from "../typeToString";
import {normalizeNameClass} from "./normalizeNameClass";
import {template} from "../../../template/template";
import {getTypeName, primitives} from "./geTypeName";
import {Type} from "../../../type";
import {basePackage, getDependantTypePackage} from "./depedantType/getDependantTypePackage";
import {DirectoryMetadata} from "../../../memory_fs/directoryMetadata";

export function interfaceTypeDeclarationToString(directoryMetadata: DirectoryMetadata, writtenClasses: string[], dependantType: DependantType): GetObjectBodyReturn {
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
    public interface ${interfaceName}<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {
                
      ${dependantType.value.attributes?.metaType === "object" && template()`
        //Attributes
        ${Object.entries(dependantType.value.attributes.value ?? {}).map(([key, value]) => {
    const type = getTypeName(value, key, dependantType);
    if (value.metaType === "primitive") {
      if (type !== primitives.int) {

        const typeString = value.isNullable
          ? `java.util.Optional<${primitives.string}>`
          : primitives.string;
        return template()`
                    ${typeString} get${normalizeNameClass(key)}();
                    T set${normalizeNameClass(key)}(${typeString} value);`
      }

      const typeString = value.isNullable
        ? `java.util.Optional<${type}>`
        : type;
      return template()`
                  ${typeString} get${normalizeNameClass(key)}();
                  T set${normalizeNameClass(key)}(${typeString} value);`
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
        pathString = `java.util.Optional<${baseTypeString}>`
      }
      if (!value.isSingle) {
        pathString = `java.util.List<${baseTypeString}>`
      }

      const templateString = template()`
          ${pathString} get${normalizeNameClass(key)}();
          java.util.stream.Stream<${baseTypeString}> stream${normalizeNameClass(key)}();
          ${value.isSingle && template()`
            T set${normalizeNameClass(key)}(${baseTypeString} value);
          `}
          ${!value.isSingle && template()`
            T add${normalizeNameClass(key)}(${baseTypeString} value);
            T addAll${normalizeNameClass(key)}(java.util.List<${baseTypeString}> value);
            T remove${normalizeNameClass(key)}(${baseTypeString} value);
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
      void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

      ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

      void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
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