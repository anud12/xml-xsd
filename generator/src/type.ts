export type Type = (TypeObject | TypePrimitive | TypeComposition | TypeUnion) & TypeAttribute;

export type TypeAttribute = {
  attributes?: Type
}

export type TypeObject = {
  metaType: "object",
  attributes?: TypeObject,
  value: {
    [P: string]: Type
  }
}
export type TypeUnknown = {
  metaType: "unknown"
}
export type TypePrimitive = {
  metaType: "primitive"
  value: string,
}
export type TypeComposition = {
  metaType: "composition"
  attributes?: TypeObject,
  value: Type[],
}
export type TypeUnion = {
  metaType: "union"
  attributes?: TypeObject,
  value: Type[],
}
export type TypeDeclaration = {
  name: string,
  value: Type
}

export function typeCompositionMerge(first: TypeComposition, ...second: Array<TypeComposition>): TypeComposition {
  const secondValues = second.reduce((acc, value) => {
    return [...acc, ...value.value];
  }, []);
  return {
    metaType: "composition",
    value: [
      ...first.value,
      ...secondValues
    ]
  }
}

export function typeUnionCreate(...second: Array<Type>): Type {
  return {
    metaType: "union",
    value: second
  }
}

export function typeRecursiveMerge(first: TypeObject, ...second: Array<TypeObject>): TypeObject {
  const secondValues = second.reduce((acc, value) => {
    return {
      ...acc,
      ...value.value
    }
  }, {});
  return {
    metaType: "object",
    value: {
      ...first.value,
      ...secondValues
    }
  }
}

export function typeMergeAsUnion(first: Type, ...second: Array<Type>): Type {
  return typeUnionCreate(first, ...second);
}

export function typeMerge(first: Type, ...second: Array<Type>): Type {

  //filter undefined values
  second = second.filter(value => value !== undefined);
  //if first type is recursive but with no values ignore
  if (first?.metaType === "object" && Object.keys(first.value).length === 0) {
    return typeMerge(second[0], ...second.slice(1));
  }

  //If all elements are recursive execute typeRecursiveMerge
  if (first?.metaType === "object" && second.every(value => value.metaType === "object")) {
    return typeRecursiveMerge(first as TypeObject, ...second as Array<TypeObject>);
  }
  //if first type is empty union ignore
  if (first?.metaType === "union" && first.value.length === 0) {
    return typeMerge(second[0], ...second.slice(1));
  }
  // if first is undefined ignore
  if (first === undefined) {
    return typeMerge(second[0], ...second.slice(1));
  }
  //if first is undefined and second length 1 return second
  if (first === undefined && second.length === 1) {
    return second[0];
  }




//Else create composition
  return {
    metaType: "composition",
    value: [first, ...second]
  }
}

export function typeAddDeclarations(first: Type, ...declarations: Array<TypeDeclaration>): Type {
  //If all elements are recursive execute typeRecursiveAddDeclarations
  if (first.metaType === "object" && declarations.every(value => value.value.metaType === "object")) {
    return typeRecursiveAddDeclarations(first as TypeObject, ...declarations as Array<TypeDeclaration>);
  }
  //Else create union and add declarations as recursive type
  return typeCompositionAddRecursive(first, ...declarations);
}

export function typeRecursiveAddDeclarations(first: TypeObject, ...declarations: Array<TypeDeclaration>): TypeObject {
  const declarationsValue = declarations.reduce((acc, value) => {
    return {
      ...acc,
      [value.name]: value.value
    }
  }, {});
  return {
    metaType: "object",
    value: {
      ...first.value,
      ...declarationsValue
    }
  }
}

export function typeCompositionAddRecursive(first: Type, ...declarations: Array<TypeDeclaration>): TypeComposition {
  // Create a recursive type based on declarations
  const recursiveType = typeDeclarationsToRecursive(...declarations);

  // Create a union between the first type and the recursive type
  return {
    metaType: "composition",
    value: [first, recursiveType]
  };
}

export function typeDeclarationsToRecursive(...declarations: Array<TypeDeclaration>): TypeObject {
  const declarationsValue = declarations.reduce((acc, value) => {
    return {
      ...acc,
      [value.name]: value.value
    }
  }, {});
  return {
    metaType: "object",
    value: declarationsValue
  }
}

function handlePrimitiveType(type: TypePrimitive): string {
  return type.value;
}

function handleObjectType(type: TypeObject, indentLevel = 0): string {
  const attributes = type.attributes && handleTypes(type.attributes);
  const indent = ' '.repeat(indentLevel);
  const properties = Object.keys(type.value).map(key => {
    const propertyType = type.value[key];
    let propertyTypeString: string = handleTypes(propertyType, indentLevel + 2);
    return `${indent}  "${key}": ${propertyTypeString};`;
  });
  const body = `{\n${properties.join('\n')}\n${indent}}`;
  if(attributes) {
    return `${attributes} & ${body}`
  }
  return body;
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
    default: {
      result += "unknown"
    }
  }
  return result;
}

export function typeDeclarationToString(typeDeclaration: TypeDeclaration, indentLevel = 0): string {
  let result = `type ${typeDeclaration.name} = `;
  result += handleTypes(typeDeclaration.value, indentLevel)
  return result;
}