using System.Collections.Generic;
using System.Xml;

namespace WorldStepSchema {
    public class WorldStep_WorldMetadata:WorldStepDeserialize {
        
        public WorldStepSerializer serializer = new WorldStepSerializer("world_metadata")
            .addElement("next_world_step", typeof(WorldStep_WorldMetadata_NextWorldStep))
            .addElement("elapsed_time", typeof(WorldStep_WorldMetadata_ElapsedTime))
            .addElement("stepDuration", typeof(WorldStep_WorldMetadata_StepDuration))
            .addElement("counter", typeof(WorldStep_WorldMetadata_Counter))
            .addElement("randomization_table", typeof(WorldStep_WorldMetadata_RandomizationTable));
        

        public WorldStep_WorldMetadata_NextWorldStep next_world_step;
        public WorldStep_WorldMetadata_ElapsedTime elapsed_time;
        public WorldStep_WorldMetadata_StepDuration stepDuration;
        public WorldStep_WorldMetadata_Counter counter;
        public WorldStep_WorldMetadata_RandomizationTable randomization_table;
        
        public WorldStep_WorldMetadata(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }
        
        public void Deserialize(XmlElement element) {
            serializer.Deserialize(element, this);
        }
    }

    public class WorldStep_WorldMetadata_Counter:WorldStepDeserialize
    {
        public WorldStepSerializer serializer = new WorldStepSerializer("counter")
            .addAttribute("value", typeof(int));
        public int value;
        public WorldStep_WorldMetadata_Counter(XmlNode xmlElement)
        {
            serializer.Serialize(xmlElement, this);
        }
        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }

    public class WorldStep_WorldMetadata_StepDuration:WorldStepDeserialize
    {
        public WorldStepSerializer serializer = new WorldStepSerializer("stepDuration")
            .addAttribute("value", typeof(int));
        public int value;
        public WorldStep_WorldMetadata_StepDuration(XmlNode xmlElement)
        {
            serializer.Serialize(xmlElement, this);
        }
        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }

    public class WorldStep_WorldMetadata_ElapsedTime:WorldStepDeserialize
    {
        public WorldStepSerializer serializer = new WorldStepSerializer("elapsed_time")
            .addAttribute("value", typeof(int));
        public int value;
        public WorldStep_WorldMetadata_ElapsedTime(XmlNode xmlElement)
        {
            serializer.Serialize(xmlElement, this);
        }
        public void Deserialize(XmlElement element)
        {
            serializer.Deserialize(element, this);
        }
    }

    public class WorldStep_WorldMetadata_NextWorldStep:WorldStepDeserialize {
        public WorldStepSerializer serializer = new WorldStepSerializer("next_world_step");
        public string world_step_id_ref = "../gui-client/data_" + System.DateTime.UtcNow.Subtract(new System.DateTime(1970, 1, 1)).TotalSeconds;
        public WorldStep_WorldMetadata_NextWorldStep(XmlNode xmlElement) {
            serializer.Serialize(xmlElement, this);
        }
        public void Deserialize(XmlElement element) {
            serializer.Deserialize(element, this);
            //add to element string body with value "./data_" + unix timestamp
            element.InnerText = world_step_id_ref;
        }
    }
}