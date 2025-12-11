import {TypeDeclaration, TypeObject, TypePrimitive} from "../../../src/type";

export const description = `should correctly handle complexType extending complex types`

export const schema = `
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:complexType name="inner_type">
    <xs:sequence>
      <xs:element name="inner_type_element_first" minOccurs="0">
        <xs:complexType>
          <xs:attribute name="inner_type_element_attribute" use="required" type="xs:string"/>
        </xs:complexType>
      </xs:element>
      <xs:element name="inner_type_element_second" minOccurs="0" maxOccurs="unbounded">
        <xs:complexType>
          <xs:complexContent>
            <xs:extension base="inner_type">
              <xs:attribute name="inner_type_element_second_attribute" use="required" type="xs:string"/>
            </xs:extension>
          </xs:complexContent>
        </xs:complexType>
      </xs:element>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="type">
    <xs:complexContent>
      <xs:extension base="inner_type">
        <xs:attribute name="type_attribute" use="required" type="xs:int">
          <xs:annotation>
            <xs:documentation>
              Represents the initial value of the operation.
            </xs:documentation>
          </xs:annotation>
        </xs:attribute>
      </xs:extension>
    </xs:complexContent>
  </xs:complexType>
</xs:schema>
`


export const type : TypeDeclaration[] = [
  {
    isSingle: false,
    name: "inner_type",
    type: "complex",
    value: {
      isSingle: false,
      metaType: "object",
      value: {
        inner_type_element_first: {
          attributes: {
            isNullable: false,
            metaType: "object",
            value: {
              inner_type_element_attribute: {
                isNullable: false,
                metaType: "primitive",
                value: "xs:string"
              }
            }
          },
          isNullable: true,
          isSingle: true,
          metaType: "object",
          value: {}
        },
        inner_type_element_second: {
          isNullable: true,
          isSingle: false,
          metaType: "composition",
          value: [
            {
              attributes: {
                isNullable: false,
                metaType: "object",
                value: {
                  inner_type_element_second_attribute: {
                    isNullable: false,
                    metaType: "primitive",
                    value: "xs:string"
                  }
                }
              },
              isNullable: false,
              isSingle: true,
              metaType: "object",
              value: {}
            },
            {
              metaType: "primitive",
              value: "inner_type"
            }
          ]
        }
      }
    }
  },
  {
    name: "type",
    type: "complex",
    value: {
      metaType: "composition",
      value: [
        {
          attributes: {
            isNullable: false,
            metaType: "object",
            value: {
              type_attribute: {
                isNullable: false,
                metaType: "primitive",
                value: "xs:int"
              }
            }
          },
          isNullable: false,
          isSingle: true,
          metaType: "object",
          value: {}
        },
        {
          metaType: "primitive",
          value: "inner_type"
        }
      ]
    }
  }
]