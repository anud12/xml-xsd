using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nworld_metadata {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class world_metadata  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Nworld_step.Nworld_metadata.previous_world_step? previous_world_step = null;
    public XSD.Nworld_step.Nworld_metadata.next_world_step? next_world_step = null;
    public XSD.Nworld_step.Nworld_metadata.elapsed_time elapsed_time = new XSD.Nworld_step.Nworld_metadata.elapsed_time();
    public XSD.Nworld_step.Nworld_metadata.stepDuration stepDuration = new XSD.Nworld_step.Nworld_metadata.stepDuration();
    public XSD.Nworld_step.Nworld_metadata.counter counter = new XSD.Nworld_step.Nworld_metadata.counter();
    public XSD.Nworld_step.Nworld_metadata.randomization_table randomization_table = new XSD.Nworld_step.Nworld_metadata.randomization_table();
    public world_metadata()
    {
    }

    public world_metadata(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_metadata(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing world_metadata");
      //Deserialize arguments

      //Deserialize children
      this.previous_world_step = rawNode.InitializeWithRawNode("previous_world_step", this.previous_world_step);
      this.next_world_step = rawNode.InitializeWithRawNode("next_world_step", this.next_world_step);
      this.elapsed_time = rawNode.InitializeWithRawNode("elapsed_time", this.elapsed_time);
      this.stepDuration = rawNode.InitializeWithRawNode("stepDuration", this.stepDuration);
      this.counter = rawNode.InitializeWithRawNode("counter", this.counter);
      this.randomization_table = rawNode.InitializeWithRawNode("randomization_table", this.randomization_table);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(previous_world_step != null) {
        rawNode.children["previous_world_step"] = new List<RawNode> { previous_world_step.SerializeIntoRawNode() };
      }
      if(next_world_step != null) {
        rawNode.children["next_world_step"] = new List<RawNode> { next_world_step.SerializeIntoRawNode() };
      }
      if(elapsed_time != null) {
        rawNode.children["elapsed_time"] = new List<RawNode> { elapsed_time.SerializeIntoRawNode() };
      }
      if(stepDuration != null) {
        rawNode.children["stepDuration"] = new List<RawNode> { stepDuration.SerializeIntoRawNode() };
      }
      if(counter != null) {
        rawNode.children["counter"] = new List<RawNode> { counter.SerializeIntoRawNode() };
      }
      if(randomization_table != null) {
        rawNode.children["randomization_table"] = new List<RawNode> { randomization_table.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing world_metadata");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Nworld_metadata.previous_world_step? Get_previous_world_step()
    {
      return this.previous_world_step;
    }
    public XSD.Nworld_step.Nworld_metadata.previous_world_step GetOrInsertDefault_previous_world_step()
    {
      if(this.previous_world_step == null) {
        this.previous_world_step = new XSD.Nworld_step.Nworld_metadata.previous_world_step();
      }
      return this.previous_world_step;
    }
    public void Set_previous_world_step(XSD.Nworld_step.Nworld_metadata.previous_world_step? value)
    {
      this.previous_world_step = value;
    }
    public XSD.Nworld_step.Nworld_metadata.next_world_step? Get_next_world_step()
    {
      return this.next_world_step;
    }
    public XSD.Nworld_step.Nworld_metadata.next_world_step GetOrInsertDefault_next_world_step()
    {
      if(this.next_world_step == null) {
        this.next_world_step = new XSD.Nworld_step.Nworld_metadata.next_world_step();
      }
      return this.next_world_step;
    }
    public void Set_next_world_step(XSD.Nworld_step.Nworld_metadata.next_world_step? value)
    {
      this.next_world_step = value;
    }
    public XSD.Nworld_step.Nworld_metadata.elapsed_time Get_elapsed_time()
    {
      return this.elapsed_time;
    }
    public XSD.Nworld_step.Nworld_metadata.elapsed_time GetOrInsertDefault_elapsed_time()
    {
      if(this.elapsed_time == null) {
        this.elapsed_time = new XSD.Nworld_step.Nworld_metadata.elapsed_time();
      }
      return this.elapsed_time;
    }
    public void Set_elapsed_time(XSD.Nworld_step.Nworld_metadata.elapsed_time value)
    {
      this.elapsed_time = value;
    }
    public XSD.Nworld_step.Nworld_metadata.stepDuration Get_stepDuration()
    {
      return this.stepDuration;
    }
    public XSD.Nworld_step.Nworld_metadata.stepDuration GetOrInsertDefault_stepDuration()
    {
      if(this.stepDuration == null) {
        this.stepDuration = new XSD.Nworld_step.Nworld_metadata.stepDuration();
      }
      return this.stepDuration;
    }
    public void Set_stepDuration(XSD.Nworld_step.Nworld_metadata.stepDuration value)
    {
      this.stepDuration = value;
    }
    public XSD.Nworld_step.Nworld_metadata.counter Get_counter()
    {
      return this.counter;
    }
    public XSD.Nworld_step.Nworld_metadata.counter GetOrInsertDefault_counter()
    {
      if(this.counter == null) {
        this.counter = new XSD.Nworld_step.Nworld_metadata.counter();
      }
      return this.counter;
    }
    public void Set_counter(XSD.Nworld_step.Nworld_metadata.counter value)
    {
      this.counter = value;
    }
    public XSD.Nworld_step.Nworld_metadata.randomization_table Get_randomization_table()
    {
      return this.randomization_table;
    }
    public XSD.Nworld_step.Nworld_metadata.randomization_table GetOrInsertDefault_randomization_table()
    {
      if(this.randomization_table == null) {
        this.randomization_table = new XSD.Nworld_step.Nworld_metadata.randomization_table();
      }
      return this.randomization_table;
    }
    public void Set_randomization_table(XSD.Nworld_step.Nworld_metadata.randomization_table value)
    {
      this.randomization_table = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": true,
      "value": {
        "previous_world_step": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": true,
          "attributes": {
            "metaType": "object",
            "value": {
              "value": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": true
              }
            },
            "isNullable": true
          }
        },
        "next_world_step": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": true,
          "attributes": {
            "metaType": "object",
            "value": {
              "value": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": true
              }
            },
            "isNullable": true
          }
        },
        "elapsed_time": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "value": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        "stepDuration": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "value": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        "counter": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "value": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        "randomization_table": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "entry": {
              "metaType": "object",
              "value": {},
              "isSingle": false,
              "isNullable": false,
              "attributes": {
                "metaType": "object",
                "value": {
                  "value": {
                    "metaType": "primitive",
                    "value": "xs:int",
                    "isNullable": true
                  }
                },
                "isNullable": true
              }
            }
          },
          "isNullable": false
        }
      },
      "isNullable": false
    },
    "name": "world_metadata"
  }
*/