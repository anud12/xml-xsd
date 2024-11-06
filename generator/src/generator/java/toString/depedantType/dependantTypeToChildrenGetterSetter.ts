import {DependantType} from "../../typeToString";
import {template} from "../../../../template/template";
import {normalizeNameClass, normalizeNameField} from "../normalizeNameClass";
import {getTypeName} from "../geTypeName";
import {Type} from "../../../../type";
import {basePackage, getDependantTypePackage} from "./getDependantTypePackage";

export const dependantTypeToChildrenGetterSetter = (dependantType: DependantType, parentDependantType?:DependantType): { dependantTypes:DependantType[], templateString: string } | undefined => {

  const dependantTypeList: DependantType[] = [];

  if (dependantType.value?.metaType !== "object") {
    return undefined;
  }


  const templateString =  Object.entries(dependantType.value.value).flatMap(([key, value]) => {
    return [[key, value] as [string, Type]]
  })
    .map(([key, value]) => {

      let type = getTypeName(value, key, dependantType);
      const normalizedName = normalizeNameClass(type);

      let baseTypeString = `${getDependantTypePackage(dependantType)}.${normalizedName}.${normalizedName}`;
      if(value.metaType === "reference" ) {
        baseTypeString = `${basePackage}.${normalizedName}.${normalizedName}`;
      }


      let pathString =  "";
      if(value.isSingle) {
        pathString = baseTypeString;
      }
      if(value.isNullable) {
        pathString = `Optional<${baseTypeString}>`
      }
      if(!value.isSingle) {
        pathString = `List<${baseTypeString}>`
      }


      let streamBody =  `Optional.ofNullable(${normalizeNameField(key)})`;
      if(value.isSingle) {
        streamBody = `Optional.ofNullable(${normalizeNameField(key)}).stream()`;
      }
      if(value.isNullable) {
        streamBody = `${normalizeNameField(key)}.stream()`
      }
      if(!value.isSingle) {
        streamBody = `${normalizeNameField(key)}.stream()`
      }

      const templateString = template()`
              public ${pathString} get${normalizeNameClass(key)}()
              {
                return this.${normalizeNameField(key)};
              }
              ${value.isSingle && value.isNullable && template()`
              public ${baseTypeString} get${normalizeNameClass(key)}OrDefault()
              {
                return this.${normalizeNameField(key)}.orElseGet(() -> {
                  var instance = new ${baseTypeString}();
                  instance.setParentNode(this);
                  this.${normalizeNameField(key)} = Optional.of(instance);
                  return this.${normalizeNameField(key)}.get();
                });
              }
              `}
              public Stream<${baseTypeString}> stream${normalizeNameClass(key)}()
              {
                return ${streamBody};
              }
              ${value.isSingle && template()`
              public ${normalizeNameClass(parentDependantType?.name ?? dependantType.name)} set${normalizeNameClass(key)}(${baseTypeString} value)
              {
                ${value.isNullable && `this.${normalizeNameField(key)} = Optional.ofNullable(value);`}
                ${!value.isNullable && `this.${normalizeNameField(key)} = value;`}
                value.setParentNode(this);
                onChangeList.forEach(consumer -> consumer.accept(this));
                return this;
              }
              `}
              ${!value.isSingle && template()`
              public ${normalizeNameClass(parentDependantType?.name ?? dependantType.name)} add${normalizeNameClass(key)}(${baseTypeString} value)
              {
                this.${normalizeNameField(key)}.add(value);
                value.setParentNode(this);
                onChangeList.forEach(consumer -> consumer.accept(this));
                return this;
              }
              public ${normalizeNameClass(parentDependantType?.name ?? dependantType.name)} addAll${normalizeNameClass(key)}(List<${baseTypeString}> value)
              {
                this.${normalizeNameField(key)}.addAll(value);
                value.forEach(e -> e.setParentNode(this));
                onChangeList.forEach(consumer -> consumer.accept(this));
                return this;
              }
              public ${normalizeNameClass(parentDependantType?.name ?? dependantType.name)} remove${normalizeNameClass(key)}(${baseTypeString} value)
              {
                this.${normalizeNameField(key)}.remove(value);
                onChangeList.forEach(consumer -> consumer.accept(this));
                return this;
              }
              `}
              
              `

      if (value.metaType === "object") {
        dependantTypeList.push({
          type: "element",
          value: value,
          name: type,
          typeDeclaration: undefined,
          parentType: dependantType,
        })
        return templateString;
      }
      if (value.metaType === "union" || value.metaType === "composition") {
        dependantTypeList.push({
          type: value.metaType,
          value: value,
          name: type,
          typeDeclaration: undefined,
          parentType: dependantType,
        })
        return templateString
      }
      if (value.metaType === "reference") {
        dependantTypeList.push({
          type: "reference",
          value: value,
          typeDeclaration: undefined,
          name: type,
        })
        return templateString;
      }
      return template()`/* ignored children key:${key} of type:${type}*/`
    }).filter(e => e).join("\n")

  return {
    dependantTypes: dependantTypeList,
    templateString: templateString,
  }
}