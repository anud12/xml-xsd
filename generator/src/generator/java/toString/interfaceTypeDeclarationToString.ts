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
    public interface ${interfaceName}<T> {
    
      public RawNode getRawNode();
    
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