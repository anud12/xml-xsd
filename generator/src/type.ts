import {mergeError} from "./mergeError";

export type Type = (TypeObject | TypePrimitive | TypeComposition | TypeUnion | TypeAny | TypeUnknown) & TypeAttribute;

export type TypeAttribute = {
  attributes?: Type
}


export type TypeObject = {
  metaType: "object",
  attributes?: Type,
  value: {
    [P: string]: Type
  }
}
export type TypeAny = {
  metaType: "any"
}

export type TypeUnknown = {
  metaType: "unknown"
}

export type TypePrimitive = {
  metaType: "primitive"
  attributes?: Type,
  value: string,
}
export type TypeComposition = {
  metaType: "composition"
  attributes?: Type,
  value: Type[],
}
export type TypeUnion = {
  metaType: "union"
  attributes?: Type,
  value: Type[],
}
export type TypeDeclaration = {
  name: string,
  type: "simple" | "complex" | "group" | "attribute" |"attributeGroup" | "element",
  value: Type
}

export function createPrimitive(value:string): TypePrimitive {
  return {
    metaType:"primitive",
    value: value,
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
  const attributes = typeMerge(first.attributes, ...second.map(value => value.attributes));

  return {
    metaType: "object",
    attributes: attributes,
    value: {
      ...first.value,
      ...secondValues
    }
  }
}

export function typeMergeAsUnion(...second: Array<Type>): Type {
  return typeUnionCreate(...second);
}

export function typeMerge(first: Type, ...second: Array<Type>): Type | undefined {
  try {
    //filter undefined values
    second = second.filter(value => value !== undefined);
    //if first type is any return any
    if (first?.metaType === "any") {
      return first;
    }
    // if first is undefined ignore
    if (first === undefined) {
      if(second === undefined || second.length === 0) {
        return undefined
      }
      if(second.length === 1) {
        return second[0];
      }

      return typeMerge(second[0], ...second.slice(1));
    }
    //if second is either undefined or empty, return first;
    if(second === undefined || second.length === 0) {
      return first;
    }

    //If all elements are recursive execute typeRecursiveMerge
    if (first?.metaType === "object" && second.every(value => value.metaType === "object")) {
      return typeRecursiveMerge(first as TypeObject, ...second as Array<TypeObject>);
    }
    //if first type is recursive but with no values ignore
    if (first?.metaType === "object" && Object.keys(first.value).length === 0) {
      return typeMerge(second[0], ...second.slice(1));
    }
    //if first type is empty union ignore
    if (first?.metaType === "union" && first.value.length === 0) {
      return typeMerge(second[0], ...second.slice(1));
    }

    //get attributes from first and second
    const attributes = typeMerge(first.attributes, ...second.map(value => value.attributes));

    // create composition
    return {
      metaType: "composition",
      attributes: attributes,
      value: [first, ...second]
    }
  } catch (e) {
    throw mergeError(e, new Error(`typeMerge failed for ${JSON.stringify(first, null, 2)} and ${JSON.stringify(second, null, 2)}`))
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
