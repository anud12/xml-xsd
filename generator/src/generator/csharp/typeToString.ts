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

  referenceNameToTypeString(name: string, ignoredTypes: Type[]) {
    let type = this.element.get(name)
      ?? this.attribute.get(name)
      ?? this.attributeGroup.get(name)
      ?? this.group.get(name)
      ?? this.complex.get(name)
      ?? this.simple.get(name)
    if (type) {
      return typeToString(this, type, name, ignoredTypes)
    }

    return undefined;
  }

  elementAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.element.has(name)) {
      this.element.set(name, type);
    }
    typeToString(this, type, name, []);

  }

  attributeAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.attribute.has(name)) {
      this.attribute.set(name, type);
    }
    typeToString(this, type, name, []);

  }

  attributeGroupAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.attributeGroup.has(name)) {
      this.attributeGroup.set(name, type);
    }
    typeToString(this, type, name, []);

  }

  groupAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.group.has(name)) {
      this.group.set(name, type);
    }
    typeToString(this, type, name, []);

  }

  complexAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (!this.complex.has(name)) {
      this.complex.set(name, type);
    }
    typeToString(this, type, name, []);

  }

  simpleAddOrCreateIgnorePrimitives(name: string, type: Type) {
    if (type.metaType === "primitive") {
      return;
    }
    if (!this.simple.has(name)) {
      this.simple.set(name, type);
    }
    typeToString(this, type, name, []);

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
    case "reference":

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

function objectToString(declaredTypes: DeclaredTypes, type: TypeObject, parentName: string) {
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

function typeToString(declaredTypes: DeclaredTypes, type: Type, parentName: string, ignoredTypes: Type[]) {

  if (ignoredTypes.map(e => JSON.stringify(e)).includes(JSON.stringify(type))) {
    return "";
  }
  switch (type.metaType) {
    case "primitive":
      console.log(`typeToString ${type.metaType} ${type.value}`)
      return getTypeName(type, parentName)
    case "reference":
      console.log(`typeToString ${type.metaType} ${type.value}`)
      const newIgnoredTypes = [...ignoredTypes, type];
      return declaredTypes.referenceNameToTypeString(type.value, newIgnoredTypes) ?? `/*undeclared reference ${type.value}*/`
    case "object":
      console.log(`typeToString ${type.metaType} Parent: ${parentName}`)
      return objectToString(declaredTypes, type, parentName)
    case "union":
      console.log(`typeToString ${type.metaType} Parent: ${parentName}`)
    case "composition":
      console.log(`typeToString ${type.metaType} Parent: ${parentName}`)
      return template()`
      ${type.value
        .map(value => {

          switch (value.metaType) {
            case "reference":
            case "primitive": {
              let type = declaredTypes.complex.get(value.value)
              if (type) {
                return template()`
              //composition-${value.metaType}
              ${typeToString(declaredTypes, type, parentName, newIgnoredTypes)}
              `
              }
              type = declaredTypes.group.get(value.value)
              if (type) {
                return template()`
              //composition-${value.metaType}
              ${typeToString(declaredTypes, type, parentName, newIgnoredTypes)}
              `;
              }
              type = declaredTypes.attributeGroup.get(value.value)
              if (type) {
                return template()`
              //composition-${value.metaType}
              ${typeToString(declaredTypes, type, parentName, newIgnoredTypes)}
              `;
              }

            }
            default:
              return template()`
                //composition-default
                ${typeToString(declaredTypes, value, parentName, newIgnoredTypes)}
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

  let extend = undefined;
  let body = typeToString(declaredTypes, typeDeclaration.value, normalizeName(typeDeclaration.name), []);
  if (typeDeclaration.value.metaType === "primitive") {
    body = typeToString(declaredTypes, {
      metaType: "object",
      value: {},
      attributes: typeDeclaration.value.attributes
    }, typeDeclaration.name, [])
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

  typeDeclaration.filter(type => type.type === "simple")
    .forEach(type => declaredTypes.simpleAddOrCreateIgnorePrimitives(type.name, type.value))

  typeDeclaration.filter(type => type.type === "attribute")
    .forEach(type => declaredTypes.attributeAddOrCreateIgnorePrimitives(type.name, type.value))

  typeDeclaration.filter(type => type.type === "attributeGroup")
    .forEach(type => declaredTypes.attributeGroupAddOrCreateIgnorePrimitives(type.name, type.value))

  typeDeclaration.filter(type => type.type === "complex")
    .forEach(type => declaredTypes.complexAddOrCreateIgnorePrimitives(type.name, type.value))

  typeDeclaration.filter(type => type.type === "group")
    .forEach(type => declaredTypes.groupAddOrCreateIgnorePrimitives(type.name, type.value))


  const attributeSimple = typeDeclaration.map(typeDeclaration => {
    switch (typeDeclaration.type) {
      case "attribute":
      case "simple":
        return typeDeclarationAttributeToString(declaredTypes, typeDeclaration)
      default:
        return undefined;
    }
  }).filter(e => e)

  const objects = typeDeclaration.map(typeDeclaration => {
    switch (typeDeclaration.type) {
      case "element":
        return typeDeclarationElementToString(declaredTypes, typeDeclaration)

      default:
        return undefined
    }
  }).filter(e => e);

  const declaredTypesElements = [...declaredTypes.element.entries()].map(([name, type]) => {
    return typeDeclarationElementToString(declaredTypes, {
      name: name,
      type: "element",
      value: type
    })
  }).filter(e => e)

  const declaredTypesGroup = [...declaredTypes.group.entries()].map(([name, type]) => {
    return typeDeclarationElementToString(declaredTypes, {
      name: name,
      type: "group",
      value: type
    })
  }).filter(e => e)

  return template()`
    ${attributeSimple.join("\n")}
    ${objects.join("\n")}
    
    ${declaredTypesElements.join("\n\n")}

    ${declaredTypesGroup.join("\n\n")}
    `
}
