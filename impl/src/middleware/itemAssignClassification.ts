import {MutationMiddleware} from "./_type";
import {classifyItem} from "../utils/item/classifyItem";

export const itemAssignClassification: MutationMiddleware = (readJson) => {
  const itemList = readJson.item.queryItem();
  const classificationListById = itemList.map(item => {
    const classificationList = classifyItem(readJson, item);
    return {
      id: item.attributeMap.id,
      classificationList
    }
  })
  return async writeJson => {
    const itemList = writeJson.item.queryItem();
    classificationListById.forEach(({id, classificationList}) => {
      if(classificationList.length === 0 ) {
        return;
      }
      const item = itemList.find(e => e.attributeMap.id === id);
      let classifications = item.queryOptional("classifications");
      if(!classifications) {
        classifications = item.appendChild("classifications");
      }
      classifications.childrenList = [];
      classificationList.forEach(classification => {
        classifications.appendChild("classification", undefined, {
          classification_rule_ref: classification
        })
      })
    })
  }
}