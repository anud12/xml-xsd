import {DependantType} from "../typeToString";
import {template} from "../../../template/template";
import {normalizeName} from "./normalizeName";

export const dependantTypeToEqualsAndHashCodeFunctions = (dependantType: DependantType): string | undefined => {

  if (dependantType.value?.metaType !== "object") {
    const equalsMethod = template()`
        public bool Equals(${normalizeName(dependantType.name)}? obj)
        {
            if (obj == null || GetType() != obj.GetType())
                return false;
    
            var other = (${normalizeName(dependantType.name)})obj;
            return object.Equals(this, other);
        }
      `;

    const hashCodeMethod = template()`
        public int GetHashCode()
        {
            return base.GetHashCode();
        }
      `;

    return `${equalsMethod}\n\n${hashCodeMethod}`;
  }

  let attributes = [];
  if (dependantType.value.attributes?.metaType === "object") {
    attributes = Object.entries(dependantType.value.attributes.value ?? {}).filter(([key, value]) => {
      return value.metaType == "primitive";
    })
      .map(([key, value]) => normalizeName(key))
  }

  const properties = Object.entries(dependantType.value.value)
    .map(([key, value]) => normalizeName(key))
    .filter(e => e);

  const fields = [...attributes, ...properties];

  if (fields.length == 0) {
    const equalsMethod = template()`
        public bool Equals(${normalizeName(dependantType.name)}? obj)
        {
            if (obj == null || GetType() != obj.GetType())
                return false;
    
            var other = (${normalizeName(dependantType.name)})obj;
            return object.Equals(this, other);
        }
      `;

    const hashCodeMethod = template()`
        public int GetHashCode()
        {
            return base.GetHashCode();
        }
      `;

    return `${equalsMethod}\n\n${hashCodeMethod}`;

  }

  const equalsMethod = template()`
    public bool Equals(${normalizeName(dependantType.name)}? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (${normalizeName(dependantType.name)})obj;
        return ${fields.map(prop => `Equals(${prop}, other.${prop})`).join(" && ") ?? "true"};
    }
  `;

  const hashCodeMethod = template()`
    public override int GetHashCode()
    {
        var acc = 0;
        
        ${template()`${fields.map(value => `acc = HashCode.Combine(acc, ${value});`).join("\n")}`}
        return acc;
    }
  `;

  return `${equalsMethod}\n\n${hashCodeMethod}`;

}