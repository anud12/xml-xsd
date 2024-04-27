import {JsonUtil} from "../util";
import {ItemQueryType} from "../JsonSchema";

export const getItemProperty = (readJson: JsonUtil, itemQueryType: ItemQueryType, key: string): string | undefined => {
  let propertiesElement = itemQueryType.queryOptional("properties");

  const properties = propertiesElement?.queryAllOptional("property");

  const propertyElement = properties?.find(propertyElement => propertyElement?.attributeMap.property_rule_ref === key)
  if (propertyElement?.attributeMap) {
    return propertyElement.attributeMap.value;
  }

  const propertyElementList = readJson.getRuleGroups()
    .flatMap(ruleElement => ruleElement.queryAllOptional("property_rule"))
    .flatMap(propertyRuleElement => propertyRuleElement.queryAllOptional("entry"));

  const propertyRuleElement = propertyElementList.find(propertyElement => {
    if(propertyElement.attributeMap.id !== key) {
      return false;
    }
    return propertyElement.queryOptional("item_default");

  })
  if(!propertyRuleElement) {
    return;
  }

  const propertyValue = readJson.computeOperationFromParent(propertyRuleElement.queryOptional("item_default"), string => {
    return getItemProperty(readJson, itemQueryType, string)
  });


  if(!propertiesElement)  {
    propertiesElement = itemQueryType.appendChild("properties")
  }

  propertiesElement.appendChild("property", undefined, {
    property_rule_ref: key,
    value: propertyValue
  })
  return propertyValue;
}