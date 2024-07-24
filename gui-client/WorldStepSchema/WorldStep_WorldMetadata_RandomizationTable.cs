using System.Collections.Generic;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_WorldMetadata_RandomizationTable : WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Element]
        public List<WorldStep_WorldMetadata_RandomizationTable_Entry> entry = new List<WorldStep_WorldMetadata_RandomizationTable_Entry>();
        public WorldStep_WorldMetadata_RandomizationTable(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }
        public void Deserialize(XmlElement element) {
            serializer.Deserialize(element, this);
        }
    }

    public class WorldStep_WorldMetadata_RandomizationTable_Entry: WorldStepDeserialize
    {
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Attribute]
        public int value;
        public WorldStep_WorldMetadata_RandomizationTable_Entry(XmlNode xmlElement)
        {
            serializer.Serialize(xmlElement, this);
        }
        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }
}