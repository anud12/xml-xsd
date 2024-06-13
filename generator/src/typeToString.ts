import {Type, TypeAny, TypeComposition, TypeDeclaration, TypeObject, TypePrimitive, TypeUnion} from "./type";

function mapXsdTypeToTs(xsdType: string | undefined): TypePrimitive {
  if(!xsdType) {
    return {
      metaType: 'primitive',
      value: "unknown"
    } as TypePrimitive;
  }
  let value: string;
  switch (xsdType) {
    case 'xs:string':
    case 'xs:anyURI':
      value = 'string';
      break;
    case 'xs:int':
    case 'xs:integer':
    case 'xs:decimal':
      value = 'number';
      break;
    case 'xs:boolean':
      value = 'boolean';
      break;
    default:
      value = xsdType;
  }
  return {
    metaType: 'primitive',
    value: value
  } as TypePrimitive;
}

function handleAttributePrimitive(type: TypePrimitive, indentLevel = 0): string {
  const value = mapXsdTypeToTs(type.value)
  return ' '.repeat(indentLevel) + value.value;
}

function handleAttributeObject(type: TypeObject, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  const properties = Object.keys(type.value).map(key => {
    const propertyType = type.value[key];
    let propertyTypeString: string = handleAttribute(propertyType, indentLevel + 2);
    return `"${key}": ${propertyTypeString};`;
  });

  let body = `{${properties.join('  ')}}`;
  return body;
}
function handleAttributeCompositionType(type: TypeComposition, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel + 2);
  const types = type.value.map(t => handleAttribute(t, indentLevel));
  return types.join(` & `);
}

function handleAttributeUnionType(type: TypeUnion, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel + 2);
  const types = type.value.map(t => handleAttribute(t, indentLevel));
  return types.join(` | `);
}

function handleAttribute(type: Type, indentLevel = 0): string | undefined {
  if(!type) {
    return undefined;
  }
  let result = ``;
  switch (type?.metaType) {
    case "primitive":
      result += handleAttributePrimitive(type as TypePrimitive);
      break;
    case "object":
      result += handleAttributeObject(type as TypeObject, indentLevel);
      break;
    case "composition":
      result += handleAttributeCompositionType(type as TypeComposition, indentLevel);
      break;
    case "union":
      result += handleAttributeUnionType(type as TypeUnion, indentLevel);
      break;
    case "any":
      result += handleAnyType(type as TypeAny, indentLevel);
      break;
    default: {
      result += "unknown"
    }
  }
  return result;
}


function handlePrimitiveType(type: TypePrimitive, indentLevel = 0): string {
  const value = mapXsdTypeToTs(type.value)
  return ' '.repeat(indentLevel) + value.value;
}


function handleObjectType(type: TypeObject, indentLevel = 0): string {
  const attributes = type.attributes && handleAttribute(type.attributes, indentLevel);
  const indent = ' '.repeat(indentLevel);
  const properties = Object.keys(type.value).map(key => {
    const propertyType = type.value[key];
    let propertyTypeString: string = handleTypes(propertyType, indentLevel + 2);
    return `\n${indent}  "${key}": ${propertyTypeString};`;
  });

  let body = `{${properties.join('')}`;
  if(properties.length) {
    body += `\n${indent}}`
  }
  if(!properties.length) {
    body += `}`
  }
  if(attributes) {
    return `JsonQueryType<${attributes}, ${body}>`
  }
  return `JsonQueryType<{}, ${body}>`;
}

function handleCompositionType(type: TypeComposition, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel + 2);
  const types = type.value.map(t => handleTypes(t, indentLevel));
  const attribute = handleAttribute(type.attributes, indentLevel);
  if(attribute) {
    return `JsonQueryType<${attribute}, ${types.join(`\n${indent}| `)}>`
  }
  return types.join(`\n${indent}& `);
}

function handleUnionType(type: TypeUnion, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel + 2);
  const types = type.value.map(t => handleTypes(t, indentLevel));
  const attribute = handleAttribute(type.attributes, indentLevel);
  if(attribute) {
    return `JsonQueryType<${attribute}, ${types.join(`\n${indent}| `)}>`
  }
  return types.join(`\n${indent}| `);
}

function handleAnyType(type: TypeAny, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  return `${indent}any`;
}

export function handleTypes(type: Type, indentLevel = 0): string {
  let result = ``;
  switch (type?.metaType) {
    case "primitive":
      result += handlePrimitiveType(type as TypePrimitive);
      break;
    case "object":
      result += handleObjectType(type as TypeObject, indentLevel);
      break;
    case "composition":
      result += handleCompositionType(type as TypeComposition, indentLevel);
      break;
    case "union":
      result += handleUnionType(type as TypeUnion, indentLevel);
      break;
    case "any":
      result += handleAnyType(type as TypeAny, indentLevel);
      break;
    default: {
      result += "JsonQueryType"
    }
  }
  return result;
}

export function typeDeclarationToString(typeDeclaration: TypeDeclaration, indentLevel = 0): string {
  let result = `type ${typeDeclaration.name} = `;
  result += handleTypes(typeDeclaration.value, indentLevel)
  return result;
}