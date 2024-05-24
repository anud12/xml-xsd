import {
  TypeDeclaration,
  typeDeclarationToString,
  TypePrimitive,
  TypeRecursive,
  TypeComposition,
  TypeUnion
} from "../../src/type";

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
        metaType: 'recursive',
        value: {
          prop: {
            metaType: 'primitive',
            value: 'number'
          }
        }
      } as TypeRecursive
    };

    const result = typeDeclarationToString(typeDeclaration);
    expect(result).toEqual(`type test = {
  "prop": number;
}`);
  });

  it('should correctly handle recursive types with mixed levels of depth', async () => {
    const typeDeclaration: TypeDeclaration = {
      name: 'test',
      value: {
        metaType: 'recursive',
        value: {
          level1: {
            metaType: 'recursive',
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
      } as TypeRecursive
    };

    const result = typeDeclarationToString(typeDeclaration);
    expect(result).toEqual(`type test = {
  "level1": {
    "level2": boolean;
    "anotherLevel2": string;
  };
  "anotherLevel1": number;
}`);
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
    expect(result).toEqual(`type test = string
& number`);
  });

  it('should correctly handle composition types with recursive types', async () => {
    const typeDeclaration: TypeDeclaration = {
      name: 'test',
      value: {
        metaType: 'composition',
        value: [
          {
            metaType: 'recursive',
            value: {
              prop1: {
                metaType: 'primitive',
                value: 'string'
              }
            }
          },
          {
            metaType: 'recursive',
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
    expect(result).toEqual(`type test = {
  "prop1": string;
}
& {
  "prop2": number;
}`);
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
    expect(result).toEqual(`type test = string
| number`);
  });
});