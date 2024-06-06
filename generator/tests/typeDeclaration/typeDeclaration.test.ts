import {
  TypeDeclaration,
  TypePrimitive,
  TypeObject,
  TypeComposition,
  TypeUnion, Type
} from "../../src/type";
import {typeDeclarationToString} from "../../src/typeToString";

describe('typeDeclarationToString function', () => {
  it('should correctly handle primitive types', async () => {
    const typeDeclaration: TypeDeclaration = {
      name: 'test',
      value: {
        metaType: 'primitive',
        value: 'string'
      } as TypePrimitive
    };

    const result = typeDeclarationToString(typeDeclaration);
    expect(result).toEqual(`type test = string`);
  });

  it('should correctly handle recursive types', async () => {
    const typeDeclaration: TypeDeclaration = {
      name: 'test',
      value: {
        metaType: 'object',
        value: {
          prop: {
            metaType: 'primitive',
            value: 'number'
          }
        }
      } as TypeObject
    };

    const result = typeDeclarationToString(typeDeclaration);
    expect(result).toEqual(`type test = JsonQueryType<{}, {
  "prop": number;
}>`);
  });

  it('should correctly handle recursive types with mixed levels of depth', async () => {
    const typeDeclaration: TypeDeclaration = {
      name: 'test',
      value: {
        metaType: 'object',
        value: {
          level1: {
            metaType: 'object',
            value: {
              level2: {
                metaType: 'primitive',
                value: 'boolean'
              },
              anotherLevel2: {
                metaType: 'primitive',
                value: 'string'
              }
            }
          },
          anotherLevel1: {
            metaType: 'primitive',
            value: 'number'
          }
        }
      } as TypeObject
    };

    const result = typeDeclarationToString(typeDeclaration);
    expect(result).toEqual(`type test = JsonQueryType<{}, {
  "level1": JsonQueryType<{}, {
    "level2": boolean;
    "anotherLevel2": string;
  }>;
  "anotherLevel1": number;
}>`);
  });

  it('should correctly handle composition types', async () => {
    const typeDeclaration: TypeDeclaration = {
      name: 'test',
      value: {
        metaType: 'composition',
        value: [
          {
            metaType: 'primitive',
            value: 'string'
          },
          {
            metaType: 'primitive',
            value: 'number'
          }
        ]
      } as TypeComposition
    };

    const result = typeDeclarationToString(typeDeclaration);
    expect(result).toEqual(`type test = string & number`);
  });

  it('should correctly handle composition types with recursive types', async () => {
    const typeDeclaration: TypeDeclaration = {
      name: 'test',
      value: {
        metaType: 'composition',
        value: [
          {
            metaType: 'object',
            value: {
              prop1: {
                metaType: 'primitive',
                value: 'string'
              }
            }
          },
          {
            metaType: 'object',
            value: {
              prop2: {
                metaType: 'primitive',
                value: 'number'
              }
            }
          }
        ]
      } as TypeComposition
    };

    const result = typeDeclarationToString(typeDeclaration);
    expect(result).toEqual(`type test = JsonQueryType<{}, {
  "prop1": string;
}> & JsonQueryType<{}, {
  "prop2": number;
}>`);
  });

  it('should correctly handle union types', async () => {
    const typeDeclaration: TypeDeclaration = {
      name: 'test',
      value: {
        metaType: 'union',
        value: [
          {
            metaType: 'primitive',
            value: 'string'
          },
          {
            metaType: 'primitive',
            value: 'number'
          }
        ]
      } as TypeUnion
    };

    const result = typeDeclarationToString(typeDeclaration);
    expect(result).toEqual(`type test = string | number`);
  });

  it('should correctly handle object type with attributes', async () => {
    const typeDeclaration: TypeDeclaration = {
      name: 'test',
      value: {
        metaType: 'object',
        value: {
          prop: {
            metaType: 'primitive',
            value: 'string'
          }
        },
        attributes: {
          metaType:"object",
          value: {
            attr: {
              metaType: 'primitive',
              value: 'number'
            }
          }
        }
      } as Type
    };

    const result = typeDeclarationToString(typeDeclaration);
    expect(result).toEqual(`type test = JsonQueryType<{"attr": number;}, {
  "prop": string;
}>`);
  })
});