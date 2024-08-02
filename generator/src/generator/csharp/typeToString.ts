import {Type, TypeDeclaration, TypeObject} from "../../type";
import {template} from "../../template/template";

type DeclarationMap = Map<string, Type>;
type ParentScope = string[];
type HandleType = (type: Type, declarationMap: DeclarationMap, parentScope: ParentScope, indentLevel?: number) => string;


class DeclaredTypes {

  element = new Map<string, Type>();
  attribute = new Map<string, Type>();
  attributeGroup = new Map<string, Type>();
  group = new Map<string, Type>();
  complex = new Map<string, Type>();
  simple = new Map<string, Type>();

  constructor() {
  }

  elementAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.element.has(name)) {
      this.element.set(name, type);
    }
    typeToString(this, type, name);

  }

  attributeAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.attribute.has(name)) {
      this.attribute.set(name, type);
    }
    typeToString(this, type, name);

  }

  attributeGroupAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.attributeGroup.has(name)) {
      this.attributeGroup.set(name, type);
    }
    typeToString(this, type, name);

  }

  groupAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.group.has(name)) {
      this.group.set(name, type);
    }
    typeToString(this, type, name);

  }

  complexAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.complex.has(name)) {
      this.complex.set(name, type);
    }
    typeToString(this, type, name);

  }

  simpleAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.simple.has(name)) {
      this.simple.set(name, type);
    }
    typeToString(this, type, name);

  }
}

function normalizeName(name: string) {
  if (name === "ref") {
    return "_ref";
  }
  return name?.replace(/-/g, "_")
    .replace(/\./g, "__")
}

function getTypeName(type: Type, parentKey?: string, parentName?: string) {
  switch (type.metaType) {
    case "primitive":
      switch (type.value) {
        case 'xs:int':
        case 'xs:integer':
        case 'xs:decimal':
          return "System.Int32"
        case 'xs:boolean':
          return "System.Boolean"
        case 'xs:string':
        case 'xs:anyURI':
          return 'string';
        case 'unknown':
          return 'System.Object /*unknown primitive*/'
        default:
          return type.value
      }

    case "object":
    case "composition":
      return `${parentName}__${parentKey}`;
    default:
      return 'System.Object';
  }
}

function objectToString(declaredTypes: DeclaredTypes, type: TypeObject, parentName?: string) {

  const attributeList = type?.attributes?.metaType === "object" && Object.entries(type.attributes.value).map(([key, type]) => {
    const typeName = getTypeName(type, normalizeName(key), parentName);
    declaredTypes.elementAddOrCreateIgnorePrimitives(typeName, type);
    return template()`
                [Attribute("${key}")]
                public ${typeName} ${normalizeName(key)}; 
                `
  })

  const elementList = Object.entries(type.value)
    .map(([key, type]) => {
      const typeName = getTypeName(type, normalizeName(key), parentName);
      declaredTypes.elementAddOrCreateIgnorePrimitives(typeName, type);
      return template()`
              [Element("${key}")]
              public List<${typeName}> ${normalizeName(key)} = new List<${typeName}>(); 
              `
    })
  return template()`
    ${(attributeList || []).join("\n")}
    ${(elementList || []).join("\n")}
  `
}

function typeToString(declaredTypes: DeclaredTypes, type: Type, parentName?: string) {
  switch (type.metaType) {
    case "primitive":
      return getTypeName(type, parentName)
    case "object":
      return objectToString(declaredTypes, type, parentName)
    case "union":
    case "composition":
      return template()`
      ${type.value
        .map(value => {

          switch (value.metaType) {
            case "primitive": {
              let type = declaredTypes.complex.get(value.value)
              if (type) {
                return template()`
              //composition-${value.metaType}
              ${typeToString(declaredTypes, type)}
              `
              }
              type = declaredTypes.group.get(value.value)
              if (type) {
                return template()`
              //composition-${value.metaType}
              ${typeToString(declaredTypes, type)}
              `;
              }
              type = declaredTypes.attributeGroup.get(value.value)
              if (type) {
                return template()`
              //composition-${value.metaType}
              ${typeToString(declaredTypes, type)}
              `;
              }
            }
            default:
              return template()`
          //composition-default
          ${typeToString(declaredTypes, value, parentName)}
          `
          }
        })
        .join("\n")
      }
    `
  }
}

function typeDeclarationAttributeToString(declaredTypes: DeclaredTypes, typeDeclaration: TypeDeclaration): string {
  return template()`
    /*Type: ${typeDeclaration.type}*/
    using ${typeDeclaration.name} = System.String;
  `
}

function typeDeclarationElementToString(declaredTypes: DeclaredTypes, typeDeclaration: TypeDeclaration): string {
  // return  typeToString(declaredTypes, typeDeclaration.value, typeDeclaration.name);

  let extend = undefined;
  let body = typeToString(declaredTypes, typeDeclaration.value, normalizeName(typeDeclaration.name));
  if (typeDeclaration.value.metaType === "primitive") {
    body = typeToString(declaredTypes, {
      metaType: "object",
      value: {},
      attributes: typeDeclaration.value.attributes
    })
    extend = typeDeclaration.value.value;
  }

  return template()`
    /*typeDeclarationElementToString: ${typeDeclaration.type}*/
    public class ${normalizeName(typeDeclaration.name)}${extend && `: ${extend}`} {
      public WorldStepSerializer serializer = new WorldStepSerializer();

      ${body}
      
      public ${normalizeName(typeDeclaration.name)}() {
      }
      
      public ${normalizeName(typeDeclaration.name)} (XmlNode xmlElement)${extend && `: base(xmlElement)`} {
        Godot.GD.Print("Deserializing ${typeDeclaration.name}");
        serializer.Deserialize(xmlElement, this);
      }
      
      public void Serialize(XmlElement element)
      {
          serializer.Serialize(element, this);
      }
    }
  `
}


export function typeDeclarationToString(...typeDeclaration: Array<TypeDeclaration>): string {
  const declaredTypes = new DeclaredTypes();

  typeDeclaration.map(type => {
    switch (type.type) {
      case "attribute":
        return declaredTypes.attributeAddOrCreateIgnorePrimitives(type.name, type.value);
      case "attributeGroup":
        return declaredTypes.attributeGroupAddOrCreateIgnorePrimitives(type.name, type.value)
      case "group":
        return declaredTypes.groupAddOrCreateIgnorePrimitives(type.name, type.value);
      case "complex":
        return declaredTypes.complexAddOrCreateIgnorePrimitives(type.name, type.value);
      case "simple":
        return declaredTypes.simpleAddOrCreateIgnorePrimitives(type.name, type.value)
    }
  })
  return template()`
     ${typeDeclaration.map(typeDeclaration => {
    switch (typeDeclaration.type) {
      case "attribute":
      case "simple":
        return typeDeclarationAttributeToString(declaredTypes, typeDeclaration)
      default:
        return undefined;
    }
  }).filter(e => e).join("\n")}
    ${typeDeclaration.map(typeDeclaration => {
    switch (typeDeclaration.type) {
      case "complex":
      case "group":
      case "element":
        return typeDeclarationElementToString(declaredTypes, typeDeclaration)

      default:
        return undefined
    }
  }).filter(e => e).join("\n")}
    
    ${[...declaredTypes.element.entries()].map(([name, type]) => {
    return typeDeclarationElementToString(declaredTypes, {
      name: name,
      type: "element",
      value: type
    })
  }).filter(e => e).join("\n\n")}

    ${[...declaredTypes.group.entries()].map(([name, type]) => {
    return typeDeclarationElementToString(declaredTypes, {
      name: name,
      type: "group",
      value: type
    })
  }).filter(e => e).join("\n\n")}
    `
}
