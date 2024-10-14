import {Type, TypeComposition, TypeObject, TypePrimitive, TypeUnion} from "../../src/type";


export const typeDeclarationDataSets = {

  'should correctly handle primitive types': {
    name: 'test',
    type: "element",
    value: {
      metaType: 'primitive',
      value: 'string'
    } as TypePrimitive
  },
  "should correctly handle recursive types": {
    name: 'test',
    type: "element",
    value: {
      metaType: 'object',
      occurrence: "list",
      value: {
        prop: {
          metaType: 'primitive',
          occurrence: "single",
          value: 'number'
        }
      }
    } as TypeObject
  },
  "should correctly handle recursive types with mixed levels of depth": {
    name: 'test',
    type: "element",
    value: {
      metaType: 'object',
      occurrence: "list",
      value: {
        level1: {
          metaType: 'object',
          occurrence: "list",
          value: {
            level2: {
              metaType: 'primitive',
              occurrence: "list",
              value: 'boolean'
            },
            anotherLevel2: {
              metaType: 'primitive',
              occurrence: "list",
              value: 'string'
            }
          }
        },
        anotherLevel1: {
          metaType: 'primitive',
          occurrence: "list",
          value: 'number'
        }
      }
    } as TypeObject
  },
  "should correctly handle composition types": {
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
  },
  "should correctly handle composition types with recursive types": {
    name: 'test',
    type: "element",
    value: {
      metaType: 'composition',
      occurrence: "list",
      value: [
        {
          metaType: 'object',
          occurrence: "list",
          value: {
            prop1: {
              metaType: 'primitive',
              occurrence: "list",
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
  },
  "should correctly handle union types": {
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
  },
  "should correctly handle object type with attributes": {
    name: 'test',
    type: "element",
    value: {
      metaType: 'object',
      occurrence: "list",
      value: {
        prop: {
          metaType: 'primitive',
          occurrence: "list",
          value: 'string'
        }
      },
      attributes: {
        metaType: "object",
        occurrence: "list",
        value: {
          attr: {
            metaType: 'primitive',
            occurrence: "single",
            value: 'number'
          }
        }
      }
    } as Type
  },
  "should correctly handle element that extends a base complex type": [
    {
      "name": "type__action",
      "type": "complex",
      "isSingle": true,
      "value": {
        "metaType": "object",
        "value": {},
        "isSingle": true,
        "isNullable": false,
        "attributes": {
          "metaType": "object",
          "value": {
            "attributeName": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        }
      }
    },
    {
      "name": "root",
      "type": "element",
      "value": {
        "metaType": "composition",
        "value": [
          {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "id": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          {
            "metaType": "primitive",
            "value": "type__action"
          }
        ],
        "isSingle": false,
        "isNullable": true
      }
    }
  ]
}