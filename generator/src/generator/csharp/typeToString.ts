import {Type, TypeComposition, TypeDeclaration, TypeObject, TypeUnion} from "../../type";
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
  object:"System.Object"
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
  type: "element"
}

function typeDeclarationElementToString(typeDeclaration: DependantType): [DependantType[], string] {

  let extend = undefined;
  if (typeDeclaration.value.metaType === "primitive") {
    extend = typeDeclaration.value.value;
  }

  const dependantType:DependantType[] = [];

  const templateString = template()`
    /*typeDeclarationElementToString: ${typeDeclaration.type}*/
    public class ${normalizeName(typeDeclaration.name)}${extend && `: ${extend}`} {
      public RawNode rawNode = new RawNode();
      ${typeDeclaration.value.metaType === "object" && typeDeclaration.value.attributes?.metaType ==="object" && template()`
        //Attributes
        ${Object.entries(typeDeclaration.value.attributes.value ?? {}).map(([key, value]) => {
          const type = getTypeName(value, key, typeDeclaration.name);
          if(value.metaType === "primitive") {
            if(type !== primitives.int) {
              return template()`public ${primitives.string} ${normalizeName(key)};`
            }
            return template()`public ${type} ${normalizeName(key)};`
          }
          
          return template()`/* ignored attribute key:${key} of type:${type}*/`
        }).filter(e => e).join("\n")}
      `}
      
      ${typeDeclaration.value.metaType === "object" && template()`
        //Children elements
        ${Object.entries(typeDeclaration.value.value).map(([key, value]) => {
          let type = getTypeName(value, key, typeDeclaration.name);
          type = normalizeName(type);
          if(value.metaType === "object") {
            dependantType.push({
              type: "element",
              value: value,
              name: type,
            })
            return template()`public List<${type}> ${normalizeName(key)} = new List<${type}>();`
          }
          return template()`/* ignored children key:${key} of type:${type}*/`
        }).filter(e => e).join("\n")}
      `}
      
      public ${normalizeName(typeDeclaration.name)}() {
      }
      
      public ${normalizeName(typeDeclaration.name)}(RawNode rawNode) {
        Deserialize(rawNode);
      }
      
      public ${normalizeName(typeDeclaration.name)}(XmlElement xmlElement) {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }
      
      public void Deserialize (RawNode rawNode)${extend && `: base(xmlElement)`} {
        this.rawNode = rawNode;
        Godot.GD.Print("Deserializing ${typeDeclaration.name}");
        ${typeDeclaration.value.attributes?.metaType === "object" && template()`
          //Deserialize arguments
          ${Object.entries(typeDeclaration.value.attributes.value ?? []).map(([key, value]) => {
            if(value.metaType === "primitive" ) {
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
        ${typeDeclaration.value.metaType === "object" && typeDeclaration.value.value && template()`
          //Deserialize elements
          ${Object.entries(typeDeclaration.value.value).map(([key, value]) => {
            if(value.metaType === "object") {
              return template()`this.${normalizeName(key)} = rawNode.InitializeWithRawNode("${key}", this.${normalizeName(key)});`;
            }
          }).filter(e => e).join("\n")}
        `}
      }
      
      public RawNode SerializeIntoRawNode() {
        ${typeDeclaration.value.attributes?.metaType === "object" && template()`
          //Serialize arguments
          ${Object.entries(typeDeclaration.value.attributes.value ?? []).map(([key, value]) => {
            if(value.metaType === "primitive") {
              return template()`
              if(this.${normalizeName(key)} != null) 
              {
                rawNode.attributes["${key}"] = this.${normalizeName(key)}.ToString();
              }
              `;
            }
          }).filter(e => e).join("\n")}
        `}
        ${typeDeclaration.value.metaType === "object" && typeDeclaration.value.value && template()`
          //Serialize elements
          ${Object.entries(typeDeclaration.value.value).map(([key, value]) => {
            if(value.metaType === "object") {
              return template()`rawNode.children["${key}"] = ${normalizeName(key)}.Select(x => x.SerializeIntoRawNode()).ToList();`;
            }
          }).filter(e => e).join("\n")}
        `}
        return rawNode;
      }
      
      public void Serialize(XmlElement element)
      {
          Godot.GD.Print("Serializing ${typeDeclaration.name}");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    }
  `


  return [dependantType, templateString]
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
    iterate.forEach((element) => {
      if(element.type === "element") {
        var [typeDeclaration, templateString] = typeDeclarationElementToString(element);
      }
      typeDeclaration.forEach(e => elementDeclarationList.push(e));
      templateList.push(templateString)
    })
  } while (elementDeclarationList.length > 0)


  return template()`
    
    ${templateList.join("\n")}
    `
}
