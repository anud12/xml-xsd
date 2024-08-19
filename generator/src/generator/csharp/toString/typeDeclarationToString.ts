import {template} from "../../../template/template";
import {Type} from "../../../type";
import {DependantType, GetObjectBodyReturn} from "../typeToString";
import {getTypeName, primitives} from "./geTypeName";
import {normalizeName} from "./normalizeName";


function typeDeclarationElementToClassString(dependantType: DependantType, extensions: string[] = []): GetObjectBodyReturn {
  const dependantTypeList: DependantType[] = [];

  const templateString = template()`
    /*typeDeclarationElementToString= ${dependantType.type}*/
    public class ${normalizeName(dependantType.name)}: I${normalizeName(dependantType.name)}${extensions?.length !== 0 && `, ${extensions.map(s => "I"+normalizeName(s)).join(",")}`} {
      public RawNode rawNode = new RawNode();
      ${dependantType.value.attributes?.metaType === "object" && template()`
        //Attributes
        ${Object.entries(dependantType.value.attributes.value ?? {}).map(([key, value]) => {
          const type = getTypeName(value, key, dependantType.name);
          if (value.metaType === "primitive") {
            if (type !== primitives.int) {
              return template()`
                public ${primitives.string} ${normalizeName(key)};
                public ${primitives.string} Get_${normalizeName(key)}()
                {
                  return this.${normalizeName(key)};
                }
                public void Set_${normalizeName(key)}(${primitives.string} value)
                {
                  this.${normalizeName(key)} = value;
                }`
            }
            return template()`
              public ${type} ${normalizeName(key)};
              public ${type} Get_${normalizeName(key)}()
              {
                return this.${normalizeName(key)};
              }
              public void Set_${normalizeName(key)}(${type} value)
              {
                this.${normalizeName(key)} = value;
              }`
          }
      
          return template()`/* ignored attribute key={key} of type=${type}*/`
        }).filter(e => e).join("\n")}
      `}
      
      ${dependantType.value.metaType === "object" && template()`
        //Children elements
        ${Object.entries(dependantType.value.value).flatMap(([key, value]) => {
          return [[key, value] as [string, Type]]
        })
        .map(([key, value]) => {
          let type = getTypeName(value, key, dependantType.name);
          type = normalizeName(type);
          if (value.metaType === "object") {
            dependantTypeList.push({
              type: "element",
              value: value,
              name: type,
            })
            return template()`
                      public List<${type}> ${normalizeName(key)} = new List<${type}>();
                      public List<${type}> Get_${normalizeName(key)}()
                      {
                        return this.${normalizeName(key)};
                      }
                      public void Set_${normalizeName(key)}(List<${type}> value)
                      {
                        this.${normalizeName(key)} = value;
                      }
                      `
          }
          if (value.metaType === "union" || value.metaType === "composition") {
            dependantTypeList.push({
              type: "union",
              value: value,
              name: type,
            })
            return template()`
              public List<${type}> ${normalizeName(key)} = new List<${type}>();
              public List<${type}> Get_${normalizeName(key)}()
              {
                return this.${normalizeName(key)};
              }
              public void Set_${normalizeName(key)}(List<${type}> value)
              {
                this.${normalizeName(key)} = value;
              }
              `
          }
          if(value.metaType === "reference") {
            dependantTypeList.push({
              type: "reference",
              value: value,
              name: type,
            })
            return template()`
              public List<${type}> ${normalizeName(key)} = new List<${type}>();
              public List<${type}> Get_${normalizeName(key)}()
              {
                return this.${normalizeName(key)};
              }
              public void Set_${normalizeName(key)}(List<${type}> value)
              {
                this.${normalizeName(key)} = value;
              }
              `
          }
          return template()`/* ignored children key:${key} of type:${type}*/`
        }).filter(e => e).join("\n")}
      `}
      
      public ${normalizeName(dependantType.name)}() 
      {
      }
      
      public ${normalizeName(dependantType.name)}(RawNode rawNode) 
      {
        Deserialize(rawNode);
      }
      
      public ${normalizeName(dependantType.name)}(XmlElement xmlElement) 
      {
        this.rawNode.Deserialize(xmlElement);
        Deserialize(rawNode);
      }
      
      public void Deserialize (RawNode rawNode) 
      {
        this.rawNode = rawNode;
        Godot.GD.Print("Deserializing ${dependantType.name}");
        ${dependantType.value.attributes?.metaType === "object" && template()`
          //Deserialize arguments
          ${Object.entries(dependantType.value.attributes.value ?? []).map(([key, value]) => {
            if (value.metaType === "primitive") {
              if (value.value === "xs:int") {
                return template()`
                  var attribute_${normalizeName(key)} = rawNode.attributes["${key}"];
                  if(attribute_${normalizeName(key)} != null)
                  {
                    this.${normalizeName(key)} = attribute_${normalizeName(key)}.ToInt();
                  }
                  `;
              }
              return template()`this.${normalizeName(key)} = rawNode.attributes["${key}"];`;
            }
          }).filter(e => e).join("\n")}
        `}
        ${dependantType.value.metaType === "object" && dependantType.value.value && template()`
          //Deserialize elements
          ${Object.entries(dependantType.value.value).map(([key, value]) => {
            if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition" || value.metaType === "reference") {
              return template()`this.${normalizeName(key)} = rawNode.InitializeWithRawNode("${key}", this.${normalizeName(key)});`;
            }
          }).filter(e => e).join("\n")}
        `}
      }
      
      public RawNode SerializeIntoRawNode() 
      {
        ${dependantType.value.attributes?.metaType === "object" && template()`
          //Serialize arguments
          ${Object.entries(dependantType.value.attributes.value ?? []).map(([key, value]) => {
            if (value.metaType === "primitive") {
              return template()`
                if(this.${normalizeName(key)} != null) 
                {
                  rawNode.attributes["${key}"] = this.${normalizeName(key)}.ToString();
                }
                `;
            }
          }).filter(e => e).join("\n")}
        `}
        ${dependantType.value.metaType === "object" && dependantType.value.value && template()`
          //Serialize elements
          ${Object.entries(dependantType.value.value).map(([key, value]) => {
            if (value.metaType === "object" || value.metaType === "union" || value.metaType === "composition" || value.metaType === "reference") {
              return template()`rawNode.children["${key}"] = ${normalizeName(key)}.Select(x => x.SerializeIntoRawNode()).ToList();`;
            }
          }).filter(e => e).join("\n")}
        `}
        return rawNode;
      }
      
      public void Serialize(XmlElement element)
      {
          Godot.GD.Print("Serializing ${dependantType.name}");
          var updatedRawNode = SerializeIntoRawNode();
          updatedRawNode.Serialize(element);
      }
    }
  `


  return {
    dependantTypes: dependantTypeList,
    templateString: templateString
  }
}


function typeDeclarationElementToInterfaceString(dependantType: DependantType, extensions: string[] = []): GetObjectBodyReturn {
  const dependantTypeList: DependantType[] = [];

  const templateString = template()`
    /*typeDeclarationElementToInterfaceString= ${dependantType.type}*/
    public interface I${normalizeName(dependantType.name)}${extensions?.length !== 0 && `: ${extensions.map(s => "I"+normalizeName(s)).join(",")}`} {
      ${dependantType.value.attributes?.metaType === "object" && template()`
        //Attributes
        ${Object.entries(dependantType.value.attributes.value ?? {}).map(([key, value]) => {
    const type = getTypeName(value, key, dependantType.name);
    if (value.metaType === "primitive") {
      if (type !== primitives.int) {
        return template()`
                    public ${primitives.string} Get_${normalizeName(key)}();
                    public void Set_${normalizeName(key)}(${primitives.string} value);`
      }
      return template()`
                  public ${type} Get_${normalizeName(key)}();
                  public void Set_${normalizeName(key)}(${type} value);`
    }

    return template()`/* ignored attribute key={key} of type=${type}*/`
  }).filter(e => e).join("\n")}
      `}
      
      ${dependantType.value.metaType === "object" && template()`
        //Children elements
        ${Object.entries(dependantType.value.value).flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {
      let type = getTypeName(value, key, dependantType.name);
      type = normalizeName(type);
      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          name: type,
        })
        return template()`
          public List<${type}> Get_${normalizeName(key)}();
          public void Set_${normalizeName(key)}(List<${type}> value);
          `
      }
      if (value.metaType === "union" || value.metaType === "composition") {
        dependantTypeList.push({
          type: "union",
          value: value,
          name: type,
        })
        return template()`
        public List<${type}> Get_${normalizeName(key)}();
        public void Set_${normalizeName(key)}(List<${type}> value);
        `
      }
      if(value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          name: type,
        })
        return template()`
        public List<${type}> Get_${normalizeName(key)}();
        public void Set_${normalizeName(key)}(List<${type}> value);
        `
      }
      return template()`/* ignored children key:${key} of type:${type}*/`
    }).filter(e => e).join("\n")}
      `}
      public void Deserialize (RawNode rawNode);
      
      public RawNode SerializeIntoRawNode();
      
      public void Serialize(XmlElement element);
    }
  `


  return {
    dependantTypes: dependantTypeList,
    templateString: templateString
  }
}

export function typeDeclarationElementToString(dependantType: DependantType, extensions: string[] = []): GetObjectBodyReturn {
  const classResult = typeDeclarationElementToClassString(dependantType, extensions);
  const interfaceResult = typeDeclarationElementToInterfaceString(dependantType, extensions);
  return {
    dependantTypes: classResult.dependantTypes,
    templateString: template()`
      ${interfaceResult.templateString}
      
      
      ${classResult.templateString}
      
      
      `,
  }
}