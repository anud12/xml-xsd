using System.Collections.Generic;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_WorldMetadata {
        
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Element]
        public WorldStep_WorldMetadata_NextWorldStep next_world_step;
        [Element]
        public WorldStep_WorldMetadata_ElapsedTime elapsed_time;
        [Element]
        public WorldStep_WorldMetadata_StepDuration stepDuration;
        [Element]
        public WorldStep_WorldMetadata_Counter counter;
        [Element]
        public WorldStep_WorldMetadata_RandomizationTable randomization_table;
        
        public WorldStep_WorldMetadata(XmlNode xmlElement) {
            serializer.Deserialize(xmlElement, this);
        }
        
    }

    public class WorldStep_WorldMetadata_Counter
    {
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Attribute]
        public int value;
        public WorldStep_WorldMetadata_Counter(XmlNode xmlElement)
        {
            serializer.Deserialize(xmlElement, this);
        }
    }

    public class WorldStep_WorldMetadata_StepDuration
    {
        public WorldStepSerializer serializer = new WorldStepSerializer();

        [Attribute]
        public int value;
        public WorldStep_WorldMetadata_StepDuration(XmlNode xmlElement)
        {
            serializer.Deserialize(xmlElement, this);
        }
    }

    public class WorldStep_WorldMetadata_ElapsedTime
    {
        
        public WorldStepSerializer serializer = new WorldStepSerializer();
        [Attribute]
        public int value;
        public WorldStep_WorldMetadata_ElapsedTime(XmlNode xmlElement)
        {
            serializer.Deserialize(xmlElement, this);
        }
    }

    public class WorldStep_WorldMetadata_NextWorldStep:ManualSerializer {
        public WorldStepSerializer serializer = new WorldStepSerializer();
        public string world_step_id_ref = "../gui-client/data_" + System.DateTime.UtcNow.Subtract(new System.DateTime(1970, 1, 1)).TotalSeconds;
        public WorldStep_WorldMetadata_NextWorldStep(XmlNode xmlElement) {
            serializer.Deserialize(xmlElement, this);
        }
        public void Serialize(XmlElement element) {
            element.InnerText = world_step_id_ref;
        }

    }
}