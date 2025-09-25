import {TypeDeclaration, TypeObject, TypePrimitive} from "../../../src/type";

export const description = `should correctly handle primitive types`

export const schema = `
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="test" type="xs:string"/>
</xs:schema>
`


export const type : TypeDeclaration[] = [
  {
    name: "test",
    type: "element",
    isSingle: true,
    isNullable: false,
    value: {
      metaType: "reference",
      value: "xs:string",
      isSingle: true,
      isNullable: false
    }
  }
]