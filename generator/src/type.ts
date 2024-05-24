export type Type = TypeRecursive | TypePrimitive | TypeComposition | TypeUnion;

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
export type TypeComposition = {
  metaType: "composition"
  value: Type[],
}
export type TypeUnion = {
  metaType: "union"
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

export function typeRecursiveMerge(first: TypeRecursive, ...second: Array<TypeRecursive>): TypeRecursive {
  const secondValues = second.reduce((acc, value) => {
    return {
      ...acc,
      ...value.value
    }
  }, {});
  return {
    metaType: "recursive",
    value: {
      ...first.value,
      ...secondValues
    }
  }
}

export function typeMerge(first:Type, ...second: Array<Type>): Type {
  //If all elements are recursive execute typeRecursiveMerge
  if(first.metaType === "recursive" && second.every(value => value.metaType === "recursive")) {
    return typeRecursiveMerge(first as TypeRecursive, ...second as Array<TypeRecursive>);
  }
  //Else create composition
  return {
    metaType: "composition",
    value: [first, ...second]
  }
}

export function typeAddDeclarations(first: Type, ...declarations: Array<TypeDeclaration>): Type {
  //If all elements are recursive execute typeRecursiveAddDeclarations
  if(first.metaType === "recursive" && declarations.every(value => value.value.metaType === "recursive")) {
    return typeRecursiveAddDeclarations(first as TypeRecursive, ...declarations as Array<TypeDeclaration>);
  }
  //Else create union and add declarations as recursive type
  return typeCompositionAddRecursive(first, ...declarations);
}

export function typeRecursiveAddDeclarations(first: TypeRecursive, ...declarations: Array<TypeDeclaration>): TypeRecursive {
  const declarationsValue = declarations.reduce((acc, value) => {
    return {
      ...acc,
      [value.name]: value.value
    }
  }, {});
  return {
    metaType: "recursive",
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

export function typeDeclarationsToRecursive(...declarations: Array<TypeDeclaration>): TypeRecursive {
  const declarationsValue = declarations.reduce((acc, value) => {
    return {
      ...acc,
      [value.name]: value.value
    }
  }, {});
  return {
    metaType: "recursive",
    value: declarationsValue
  }
}

function handlePrimitiveType(type: TypePrimitive): string {
  return type.value;
}

function handleRecursiveType(type: TypeRecursive, indentLevel = 0): string {
  const indent = ' '.repeat(indentLevel);
  const properties = Object.keys(type.value).map(key => {
    const propertyType = type.value[key];
    let propertyTypeString: string = handleTypes(propertyType, indentLevel + 2);
    return `${indent}  "${key}": ${propertyTypeString};`;
  });
  return `{\n${properties.join('\n')}\n${indent}}`;
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
  switch (type.metaType) {
    case "primitive":
      result += handlePrimitiveType(type as TypePrimitive);
      break;
    case "recursive":
      result += handleRecursiveType(type as TypeRecursive, indentLevel);
      break;
    case "composition":
      result += handleCompositionType(type as TypeComposition, indentLevel);
      break;
    case "union":
      result += handleUnionType(type as TypeUnion, indentLevel);
      break;
  }
  return result;
}

export function typeDeclarationToString(typeDeclaration: TypeDeclaration, indentLevel = 0): string {
  let result = `type ${typeDeclaration.name} = `;
  result += handleTypes(typeDeclaration.value, indentLevel)
  return result;
}