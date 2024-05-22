export type Type = TypeRecursive | TypePrimitive;

export type TypeRecursive = {
  metaType: "recursive",
  value: {
    [P: string]: Type
  }
}
export type TypePrimitive = {
  metaType: "primitive"
  value: string,
}

export type TypeDeclaration = {
  name:string,
  value:Type
}


function handlePrimitiveType(type: TypePrimitive): string {
  return type.value;
}

function handleRecursiveType(type: TypeRecursive, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  const properties = Object.keys(type.value).map(key => {
    const propertyType = type.value[key];
    let propertyTypeString: string;
    if (propertyType.metaType === 'recursive') {
      propertyTypeString = handleRecursiveType(propertyType as TypeRecursive, indentLevel + 2);
    } else {
      propertyTypeString = handlePrimitiveType(propertyType as TypePrimitive);
    }
    return `${indent}  "${key}": ${propertyTypeString};`;
  });
  return `{\n${properties.join('\n')}\n${indent}}`;
}

export function typeDeclarationToString(typeDeclaration: TypeDeclaration, indentLevel = 0): string {
  let result = `type ${typeDeclaration.name} = `;
  switch (typeDeclaration.value.metaType) {
    case "primitive":
      result += handlePrimitiveType(typeDeclaration.value as TypePrimitive);
      break;
    case "recursive":
      result += handleRecursiveType(typeDeclaration.value as TypeRecursive, indentLevel);
      break;
  }
  return result;
}