import {Type, TypeAny, TypeComposition, TypeDeclaration, TypeObject, TypePrimitive, TypeUnion} from "./type";

type DeclarationMap = Map<string, Type>;
type ParentScope = string[];
type HandleType = (type: Type, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel?: number) => string;

function mapXsdTypeToTs(xsdType: string | undefined, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel :number, handleObject:HandleType): string {
  if (!xsdType) {
    return "any";
  }

  const type = parentScope.find(type => {
    return type === xsdType
  })

  if(type) {
    return `${xsdType} | any`;
  }

  const declarationType = declarationMap.get(xsdType);
  if(declarationType) {
    return `${xsdType} & JsonQueryType`;
  }

  switch (xsdType) {
    case 'xs:string':
    case 'xs:anyURI':
      return  'string';
    case 'xs:int':
    case 'xs:integer':
    case 'xs:decimal':
      return  'number';
    case 'xs:boolean':
      return  'boolean';
    case 'unknown':
      return 'any'
    default:
      return  xsdType;
  }
}

function handleAttributePrimitive(type: TypePrimitive, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  const value = mapXsdTypeToTs(type.value, declarationMap, parentScope, indentLevel, handleAttribute)
  return value;
}

function handleAttributeObject(type: TypeObject, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  const indent = ' '.repeat(indentLevel);
  const properties = Object.keys(type.value).map(key => {
    const propertyType = type.value[key];
    let propertyTypeString: string = handleAttribute(propertyType, declarationMap, parentScope, indentLevel + 2);
    return `"${key}": ${propertyTypeString};`;
  });

  let body = `{${properties.join('  ')}}`;
  return body;
}

function handleAttributeCompositionType(type: TypeComposition, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  const indent = ' '.repeat(indentLevel + 2);
  const types = type.value.map(t => handleAttribute(t, declarationMap, parentScope, indentLevel));
  return types.join(` & `);
}

function handleAttributeUnionType(type: TypeUnion, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  const indent = ' '.repeat(indentLevel + 2);
  const types = type.value.map(t => handleAttribute(t, declarationMap, parentScope, indentLevel));
  return types.join(` | `);
}

function handleAttribute(type: Type, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string | undefined {
  if (!type) {
    return undefined;
  }
  let result = ``;
  switch (type?.metaType) {
    case "primitive":
      result += handleAttributePrimitive(type as TypePrimitive, declarationMap, parentScope, indentLevel);
      break;
    case "object":
      result += handleAttributeObject(type as TypeObject, declarationMap, parentScope, indentLevel);
      break;
    case "composition":
      result += handleAttributeCompositionType(type as TypeComposition, declarationMap, parentScope, indentLevel);
      break;
    case "union":
      result += handleAttributeUnionType(type as TypeUnion, declarationMap, parentScope, indentLevel);
      break;
    case "any":
      result += handleAnyType(type as TypeAny, declarationMap, parentScope, indentLevel);
      break;
    default: {
      result += "unknown"
    }
  }
  return result;
}


function handlePrimitiveType(type: TypePrimitive, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  const value = mapXsdTypeToTs(type.value, declarationMap, parentScope, indentLevel, handleTypes)
  return value;
}


function handleObjectType(type: TypeObject, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  const attributes = type.attributes && handleAttribute(type.attributes, declarationMap, parentScope, indentLevel);
  const indent = ' '.repeat(indentLevel);
  const properties = Object.keys(type.value).map(key => {
    const propertyType = type.value[key];
    let propertyTypeString: string = handleTypes(propertyType, declarationMap, [key, ...parentScope], indentLevel + 2);
    return `\n${indent}  "${key}": ${propertyTypeString};`;
  });

  let body = `{${properties.join('')}`;
  if (properties.length) {
    body += `\n${indent}}`
  }
  if (!properties.length) {
    body += `}`
  }
  if (attributes) {
    return `JsonQueryType<${attributes}, ${body}>`
  }
  return `JsonQueryType<{}, ${body}>`;
}

function handleCompositionType(type: TypeComposition, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  const indent = ' '.repeat(indentLevel + 2);
  const types = type.value.map(t => handleTypes(t, declarationMap, parentScope, indentLevel));
  const attribute = handleAttribute(type.attributes, declarationMap, parentScope, indentLevel);
  if (attribute) {
    return `JsonQueryType<${attribute}, ${types.join(`\n${indent}| `)}>`
  }
  return types.join(`\n${indent}& `);
}

function handleUnionType(type: TypeUnion, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  const indent = ' '.repeat(indentLevel + 2);
  const types = type.value.map(t => handleTypes(t, declarationMap, parentScope, indentLevel + 2));
  const attribute = handleAttribute(type.attributes, declarationMap, parentScope, indentLevel);
  if (attribute) {
    return `JsonQueryType<${attribute}, {}> & ${types.join(`\n${indent}| `)}`
  }
  return types.join(`\n${indent}| `);
}

function handleAnyType(type: TypeAny, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  const indent = ' '.repeat(indentLevel);
  return `${indent}any`;
}

export function handleTypes(type: Type, declarationMap: DeclarationMap, parentScope:ParentScope, indentLevel: number): string {
  let result = ``;
  switch (type?.metaType) {
    case "primitive":
      result += handlePrimitiveType(type as TypePrimitive, declarationMap, parentScope, indentLevel);
      break;
    case "object":
      result += handleObjectType(type as TypeObject, declarationMap, parentScope, indentLevel);
      break;
    case "composition":
      result += handleCompositionType(type as TypeComposition, declarationMap, parentScope, indentLevel);
      break;
    case "union":
      result += handleUnionType(type as TypeUnion, declarationMap, parentScope, indentLevel);
      break;
    case "any":
      result += handleAnyType(type as TypeAny, declarationMap, parentScope, indentLevel);
      break;
    default: {
      result += "JsonQueryType"
    }
  }
  return result;
}

export function typeDeclarationToString(...typeDeclaration: Array<TypeDeclaration>): string {

  let declarationMap = new Map<string, Type>();
  typeDeclaration.forEach(type => {
    declarationMap.set(type.name, type.value)
  })

  return typeDeclaration.map(type => {
    let result = `type ${type.name} = `;
    result += handleTypes(type.value, declarationMap, [type.name], 0)
    return result;
  }).join("\n")
}