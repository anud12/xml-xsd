import {Type, TypeDeclaration, TypeObject} from "../../type";
import {template} from "../../template/template";

function normalizeName(name: string) {
  if (name === "ref") {
    return "_ref";
  }
  if (name === "do") {
    return "_do";
  }
  return name?.replace(/-/g, "_")
    .replace(/\./g, "__")
}

const primitives = {
  int: "System.Int32",
  string: "System.String",
  boolean: "System.Boolean",
  object: "System.Object"
}

function getTypeName(type: Type, parentKey?: string, parentName?: string) {
  switch (type.metaType) {
    case "reference":
    case "primitive":
      switch (type.value) {
        case 'xs:int':
        case 'xs:integer':
        case 'xs:decimal':
          return primitives.int
        case 'xs:boolean':
          return primitives.boolean
        case 'xs:string':
        case 'xs:anyURI':
          return primitives.string;
        case 'unknown':
          return `${primitives.object} /*unknown primitive*/`
        default:
          return type.value
      }
    case "union":
    case "object":
    case "composition":
      return `${parentName}__${parentKey}`;
    default:
      return primitives.object;
  }
}

type DependantType = {
  name: string,
  value: Type,
  type: "element" | "union"
}

type GetObjectBodyReturn = {
  dependantTypes: DependantType[],
  templateString: string,
}

function unionTypeDeclarationToString(dependantType:DependantType):GetObjectBodyReturn {
  if(dependantType.type === "union") {
    if(dependantType.value.metaType === "union" || dependantType.value.metaType  === "composition") {
      const value = dependantType.value.value.flatMap(e => {
        if(e.metaType === "object") {
          return Object.entries(e.value)
        }
        return [];
      }) .reduce((acc, [key, value]) => {
        return {
          ...acc,
          [key]: value,
        }
      }, {} as TypeObject["value"])
      const type:Type = {
        metaType: "object",
        attributes: dependantType.value.attributes,
        value: value
      }
      return typeDeclarationElementToString({
        type: "element",
        value: type,
        name: dependantType.name
      })
    }

  }
  throw Error(`Invalid ${JSON.stringify(dependantType, null ,2)}`);
}

function typeDeclarationElementToString(dependantType: DependantType): GetObjectBodyReturn {
  const dependantTypeList: DependantType[] = [];
  const extend: string[] = [];

  const templateString = template()`
    /*typeDeclarationElementToString= ${dependantType.type}*/
    public class ${normalizeName(dependantType.name)}${extend?.length !== 0 && `: ${extend.map(s => normalizeName(s)).join(",")}`} {
      public RawNode rawNode = new RawNode();
      ${dependantType.value.metaType === "object" && dependantType.value.attributes?.metaType === "object" && template()`
        //Attributes
        ${Object.entries(dependantType.value.attributes.value ?? {}).map(([key, value]) => {
          const type = getTypeName(value, key, dependantType.name);
          if (value.metaType === "primitive") {
            if (type !== primitives.int) {
              return template()`public ${primitives.string} ${normalizeName(key)};`
            }
            return template()`public ${type} ${normalizeName(key)};`
          }
      
          return template()`/* ignored attribute key={key} of type=${type}*/`
        }).filter(e => e).join("\n")}
      `}
      
      ${dependantType.value.metaType === "object" && template()`
        //Children elements
        ${Object.entries(dependantType.value.value).flatMap(([key, value]) => {
            return [[key, value] as [string, Type]]
          }).map(([key, value]) => {
          let type = getTypeName(value, key, dependantType.name);
          type = normalizeName(type);
          if (value.metaType === "object") {
            dependantTypeList.push({
              type: "element",
              value: value,
              name: type,
            })
            return template()`public List<${type}> ${normalizeName(key)} = new List<${type}>();`
          }
          if (value.metaType === "union" || value.metaType === "composition") {
            dependantTypeList.push({
              type: "union",
              value: value,
              name: type,
            })
            return template()`public List<${type}> ${normalizeName(key)} = new List<${type}>();`
          }
          return template()`/* ignored children key:${key} of type:${type}*/`
        }).filter(e => e).join("\n")}
      `}
      
      public ${normalizeName(dependantType.name)}() {
      }
      
      public ${normalizeName(dependantType.name)}(RawNode rawNode) {
        Deserialize(rawNode);
      }
      
      public ${normalizeName(dependantType.name)}(XmlElement xmlElement) {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }
      
      public void Deserialize (RawNode rawNode)${extend?.length !== 0 && `: base(xmlElement)`} {
        this.rawNode = rawNode;
        Godot.GD.Print("Deserializing ${dependantType.name}");
        ${dependantType.value.attributes?.metaType === "object" && template()`
          //Deserialize arguments
          ${Object.entries(dependantType.value.attributes.value ?? []).map(([key, value]) => {
          if (value.metaType === "primitive") {
            if (value.value === "xs:int") {
              return template()`
                        var attribute_${normalizeName(key)} = rawNode.attributes["${key}"];
                        if(attribute_${normalizeName(key)} != null)
                        {
                          this.${normalizeName(key)} = attribute_${normalizeName(key)}.ToInt();
                        }
                        `;
            }
            return template()`this.${normalizeName(key)} = rawNode.attributes["${key}"];`;
          }
          }).filter(e => e).join("\n")}
        `}
        ${dependantType.value.metaType === "object" && dependantType.value.value && template()`
          //Deserialize elements
          ${Object.entries(dependantType.value.value).map(([key, value]) => {
            if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition") {
              return template()`this.${normalizeName(key)} = rawNode.InitializeWithRawNode("${key}", this.${normalizeName(key)});`;
            }
          }).filter(e => e).join("\n")}
        `}
      }
      
      public RawNode SerializeIntoRawNode() {
        ${dependantType.value.attributes?.metaType === "object" && template()`
          //Serialize arguments
          ${Object.entries(dependantType.value.attributes.value ?? []).map(([key, value]) => {
            if (value.metaType === "primitive") {
              return template()`
                      if(this.${normalizeName(key)} != null) 
                      {
                        rawNode.attributes["${key}"] = this.${normalizeName(key)}.ToString();
                      }
                      `;
            }
          }).filter(e => e).join("\n")}
        `}
        ${dependantType.value.metaType === "object" && dependantType.value.value && template()`
          //Serialize elements
          ${Object.entries(dependantType.value.value).map(([key, value]) => {
            if (value.metaType === "object" || value.metaType === "union") {
              return template()`rawNode.children["${key}"] = ${normalizeName(key)}.Select(x => x.SerializeIntoRawNode()).ToList();`;
            }
          }).filter(e => e).join("\n")}
        `}
        return rawNode;
      }
      
      public void Serialize(XmlElement element)
      {
          Godot.GD.Print("Serializing ${dependantType.name}");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    }
  `


  return {
    dependantTypes: dependantTypeList,
    templateString: templateString
  }
}


export function typeDeclarationToString(...typeDeclaration: Array<TypeDeclaration>): string {

  let elementDeclarationList: DependantType[] = typeDeclaration.filter(element => element.type === "element")
    .map(element => {
      return {
        type: "element",
        value: element.value,
        name: element.name
      }
    });
  let templateList: string[] = [];
  do {
    const iterate = [...elementDeclarationList];
    elementDeclarationList = [];
    iterate?.forEach((element) => {
      if (element.type === "element") {
        const {dependantTypes, templateString} = typeDeclarationElementToString(element);
        dependantTypes?.forEach(e => elementDeclarationList.push(e));
        templateList.push(templateString)
      }
      if(element.type === "union") {
        const {dependantTypes, templateString} = unionTypeDeclarationToString(element);
        dependantTypes?.forEach(e => elementDeclarationList.push(e));
        templateList.push(templateString)
      }
    })
  } while (elementDeclarationList.length > 0)


  return template()`
    
    ${templateList.join("\n")}
    `
}
