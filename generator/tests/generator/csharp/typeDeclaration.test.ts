import {Type, TypeComposition, TypeDeclaration, TypeObject, TypePrimitive, TypeUnion} from "../../../src/type";
import {typeDeclarationToString} from "../../../src/generator/csharp/typeToString";

it('should correctly handle primitive types', async () => {
  const typeDeclaration: TypeDeclaration = {
    name: 'test',
    type: "element",
    value: {
      metaType: 'primitive',
      value: 'string'
    } as TypePrimitive
  };

  const result = typeDeclarationToString(typeDeclaration);
  expect(result).toEqual(`public class test {
  public WorldStepSerializer serializer = new WorldStepSerializer();

  string

  public test (XmlNode xmlElement) {
    serializer.Deserialize(xmlElement, this);
  }
}

`);
});

it('should correctly handle recursive types', async () => {
  const typeDeclaration: TypeDeclaration = {
    name: 'test',
    type: "element",
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
  expect(result).toEqual(`public class test {
  public WorldStepSerializer serializer = new WorldStepSerializer();

  [Element]
  public number prop;

  public test (XmlNode xmlElement) {
    serializer.Deserialize(xmlElement, this);
  }
}

`);
});

it('should correctly handle recursive types with mixed levels of depth', async () => {
  const typeDeclaration: TypeDeclaration = {
    name: 'test',
    type: "element",
    value: {
      metaType: 'object',
      value: {
        level1: {
          metaType: 'object',
          value: {
            level2: {
              metaType: 'object',
              value: {},
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
  expect(result).toEqual(`public class test {
  public WorldStepSerializer serializer = new WorldStepSerializer();

  [Element]
  public test__level1 level1;
  [Element]
  public number anotherLevel1;

  public test (XmlNode xmlElement) {
    serializer.Deserialize(xmlElement, this);
  }
}

public class test__level1 {
  public WorldStepSerializer serializer = new WorldStepSerializer();

  [Element]
  public test__level1__level2 level2;
  [Element]
  public string anotherLevel2;

  public test__level1 (XmlNode xmlElement) {
    serializer.Deserialize(xmlElement, this);
  }
}

public class test__level1__level2 {
  public WorldStepSerializer serializer = new WorldStepSerializer();


  public test__level1__level2 (XmlNode xmlElement) {
    serializer.Deserialize(xmlElement, this);
  }
}`);
});

it('should correctly handle composition types', async () => {
  const typeDeclaration: TypeDeclaration = {
    name: 'test',
    type: "element",
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
  expect(result).toEqual(`public class test {
  public WorldStepSerializer serializer = new WorldStepSerializer();

  string
  number

  public test (XmlNode xmlElement) {
    serializer.Deserialize(xmlElement, this);
  }
}

`);
});

it('should correctly handle composition types with recursive types', async () => {
  const typeDeclaration: TypeDeclaration = {
    name: 'test',
    type: "element",
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
  expect(result).toEqual(`public class test {
  public WorldStepSerializer serializer = new WorldStepSerializer();

  [Element]
  public string prop1;

  [Element]
  public number prop2;

  public test (XmlNode xmlElement) {
    serializer.Deserialize(xmlElement, this);
  }
}

`);
});

it('should correctly handle union types', async () => {
  const typeDeclaration: TypeDeclaration = {
    name: 'test',
    type: "element",
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
  expect(result).toEqual(`public class test {
  public WorldStepSerializer serializer = new WorldStepSerializer();

  string
  number

  public test (XmlNode xmlElement) {
    serializer.Deserialize(xmlElement, this);
  }
}

`);
});

it('should correctly handle object type with attributes', async () => {
  const typeDeclaration: TypeDeclaration = {
    name: 'test',
    type: "element",
    value: {
      metaType: 'object',
      value: {
        prop: {
          metaType: 'primitive',
          value: 'string'
        }
      },
      attributes: {
        metaType: "object",
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
  expect(result).toEqual(`public class test {
  public WorldStepSerializer serializer = new WorldStepSerializer();

  [Attribute]
  public number attr;
  [Element]
  public string prop;

  public test (XmlNode xmlElement) {
    serializer.Deserialize(xmlElement, this);
  }
}

`);
});