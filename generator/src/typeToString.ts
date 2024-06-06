import {Type, TypeAny, TypeComposition, TypeDeclaration, TypeObject, TypePrimitive, TypeUnion} from "./type";

function handleAttributePrimitive(type: TypePrimitive): string {
  return type.value;
}

function handleAttributeObject(type: TypeObject, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  const properties = Object.keys(type.value).map(key => {
    const propertyType = type.value[key];
    let propertyTypeString: string = handleAttribute((propertyType as any));
    return `${indent}  "${key}": ${propertyTypeString};`;
  });
  if(properties.length === 0) {
    return "";
  }
  const body = `{\n${properties.join('\n')}\n${indent}}`;
  return body;
}
function handleAttributeCompositionType(type: TypeComposition, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  const types = type.value.map(t => handleAttribute(t, indentLevel));
  return types.join(`\n${indent}& `);
}

function handleAttributeUnionType(type: TypeUnion, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  const types = type.value.map(t => handleAttribute(t, indentLevel));
  return types.join(`\n${indent}| `);
}

function handleAttribute(type: Type, indentLevel = 0): string {
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


function handlePrimitiveType(type: TypePrimitive): string {
  return type.value
}


function handleObjectType(type: TypeObject, indentLevel = 0): string {
  const attributes = type.attributes && handleAttribute(type.attributes, indentLevel);
  const indent = ' '.repeat(indentLevel);
  const properties = Object.keys(type.value).map(key => {
    const propertyType = type.value[key];
    let propertyTypeString: string = handleTypes(propertyType, indentLevel + 2);
    return `${indent}  "${key}": ${propertyTypeString};`;
  });
  const body = `{\n${properties.join('\n')}\n${indent}}`;
  if(attributes) {
    return `JsonQueryType<${attributes}, ${body}>`
  }
  return `JsonQueryType<{}, ${body}>`;
}

function handleCompositionType(type: TypeComposition, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  const types = type.value.map(t => handleTypes(t, indentLevel));
  return types.join(`\n${indent}& `);
}

function handleUnionType(type: TypeUnion, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  const types = type.value.map(t => handleTypes(t, indentLevel));
  return types.join(`\n${indent}| `);
}

function handleAnyType(type: TypeAny, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  return `${indent}any`;
}

function handleTypes(type: Type, indentLevel = 0): string {
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