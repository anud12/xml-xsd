import {TypeDeclaration, TypeObject} from "../../../src/type";

export const description = `should correctly handle recursive types with mixed levels of depth`;

export const schema = `
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="test" maxOccurs="unbounded">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="level1" maxOccurs="unbounded">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="level2" type="xs:boolean" maxOccurs="unbounded"/>
              <xs:element name="anotherLevel2" type="xs:string" maxOccurs="unbounded"/>
            </xs:sequence>
          </xs:complexType>
        </xs:element>
        <xs:element name="anotherLevel1" type="xs:double" maxOccurs="unbounded"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>
`

export const type : TypeDeclaration[] = [
  {
    isNullable: false,
    isSingle: false,
    name: "test",
    type: "element",
    value: {
      isNullable: false,
      isSingle: false,
      metaType: "object",
      value: {
        anotherLevel1: {
          isNullable: false,
          isSingle: false,
          metaType: "reference",
          value: "xs:double"
        },
        level1: {
          isNullable: false,
          isSingle: false,
          metaType: "object",
          value: {
            anotherLevel2: {
              isNullable: false,
              isSingle: false,
              metaType: "reference",
              value: "xs:string"
            },
            level2: {
              isNullable: false,
              isSingle: false,
              metaType: "reference",
              value: "xs:boolean"
            }
          }
        }
      }
    }
  }
]