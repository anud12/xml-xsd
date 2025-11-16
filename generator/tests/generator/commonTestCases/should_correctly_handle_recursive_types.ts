import {TypeDeclaration, TypeObject} from "../../../src/type";

export const description = `should correctly handle recursive types`

export const schema = `
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="test" maxOccurs="unbounded">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="prop" type="number" minOccurs="1" maxOccurs="1"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>
`

export const type: TypeDeclaration[] = [
  {
    name: 'test',
    type: "element",
    isNullable:false,
    isSingle:false,
    value: {
      metaType: 'object',
      isSingle: false,
      isNullable:false,
      attributes: undefined,
      value: {
        prop: {
          metaType: 'reference',
          value: 'number',
          isSingle:true,
          isNullable:false,
        }
      }
    } as TypeObject
  }
]