import {typeDeclarationToString} from "../../../src/generator/csharp/typeToString";
import {typeDeclarationDataSets} from "../typeDeclarationDataSets";
import {template} from "../../../src/template/template";

it("should correctly handle primitive types" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
/*typeDeclarationElementToInterfaceString= element*/
public interface Itest {
  public void Deserialize (RawNode rawNode);

  public RawNode SerializeIntoRawNode();

  public void Serialize(XmlElement element);
}

/*typeDeclarationElementToString= element*/
public class test: Itest {
  public RawNode rawNode = new RawNode();

  public test()
  {
  }

  public test(RawNode rawNode)
  {
    Deserialize(rawNode);
  }

  public test(XmlElement xmlElement)
  {
    this.rawNode.Deserialize(xmlElement);
    Deserialize(rawNode);
  }

  public void Deserialize (RawNode rawNode)
  {
    this.rawNode = rawNode;
    Godot.GD.Print("Deserializing test");
  }

  public RawNode SerializeIntoRawNode()
  {
    return rawNode;
  }

  public void Serialize(XmlElement element)
  {
      Godot.GD.Print("Serializing test");
      var updatedRawNode = SerializeIntoRawNode();
      updatedRawNode.Serialize(element);
  }
}
`);
})

it("should correctly handle recursive types" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
/*typeDeclarationElementToInterfaceString= element*/
public interface Itest {

  //Children elements
  /* ignored children key:prop of type:number*/
  public void Deserialize (RawNode rawNode);

  public RawNode SerializeIntoRawNode();

  public void Serialize(XmlElement element);
}

/*typeDeclarationElementToString= element*/
public class test: Itest {
  public RawNode rawNode = new RawNode();

  //Children elements
  /* ignored children key:prop of type:number*/

  public test()
  {
  }

  public test(RawNode rawNode)
  {
    Deserialize(rawNode);
  }

  public test(XmlElement xmlElement)
  {
    this.rawNode.Deserialize(xmlElement);
    Deserialize(rawNode);
  }

  public void Deserialize (RawNode rawNode)
  {
    this.rawNode = rawNode;
    Godot.GD.Print("Deserializing test");
    //Deserialize elements

  }

  public RawNode SerializeIntoRawNode()
  {
    //Serialize elements

    return rawNode;
  }

  public void Serialize(XmlElement element)
  {
      Godot.GD.Print("Serializing test");
      var updatedRawNode = SerializeIntoRawNode();
      updatedRawNode.Serialize(element);
  }
}
`);
})

it("should correctly handle recursive types with mixed levels of depth" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
/*typeDeclarationElementToInterfaceString= element*/
public interface Itest {

  //Children elements
  public List<test__level1> Get_level1();
  public void Set_level1(List<test__level1> value);
  /* ignored children key:anotherLevel1 of type:number*/
  public void Deserialize (RawNode rawNode);

  public RawNode SerializeIntoRawNode();

  public void Serialize(XmlElement element);
}

/*typeDeclarationElementToString= element*/
public class test: Itest {
  public RawNode rawNode = new RawNode();

  //Children elements
  public List<test__level1> level1 = new List<test__level1>();
  public List<test__level1> Get_level1()
  {
    return this.level1;
  }
  public List<test__level1> GetOrInsertDefault_level1()
  {
    if(this.level1 == null) {
      this.level1 = new List<test__level1>();
    }
    return this.level1;
  }
  public void Set_level1(List<test__level1> value)
  {
    this.level1 = value;
  }
  /* ignored children key:anotherLevel1 of type:number*/

  public test()
  {
  }

  public test(RawNode rawNode)
  {
    Deserialize(rawNode);
  }

  public test(XmlElement xmlElement)
  {
    this.rawNode.Deserialize(xmlElement);
    Deserialize(rawNode);
  }

  public void Deserialize (RawNode rawNode)
  {
    this.rawNode = rawNode;
    Godot.GD.Print("Deserializing test");
    //Deserialize elements
    this.level1 = rawNode.InitializeWithRawNode("level1", this.level1);
  }

  public RawNode SerializeIntoRawNode()
  {
    //Serialize elements
    rawNode.children["level1"] = level1.Select(x => x.SerializeIntoRawNode()).ToList();
    return rawNode;
  }

  public void Serialize(XmlElement element)
  {
      Godot.GD.Print("Serializing test");
      var updatedRawNode = SerializeIntoRawNode();
      updatedRawNode.Serialize(element);
  }
}
/*typeDeclarationElementToInterfaceString= element*/
public interface Itest__level1 {

  //Children elements
  /* ignored children key:level2 of type:boolean*/
  /* ignored children key:anotherLevel2 of type:string*/
  public void Deserialize (RawNode rawNode);

  public RawNode SerializeIntoRawNode();

  public void Serialize(XmlElement element);
}

/*typeDeclarationElementToString= element*/
public class test__level1: Itest__level1 {
  public RawNode rawNode = new RawNode();

  //Children elements
  /* ignored children key:level2 of type:boolean*/
  /* ignored children key:anotherLevel2 of type:string*/

  public test__level1()
  {
  }

  public test__level1(RawNode rawNode)
  {
    Deserialize(rawNode);
  }

  public test__level1(XmlElement xmlElement)
  {
    this.rawNode.Deserialize(xmlElement);
    Deserialize(rawNode);
  }

  public void Deserialize (RawNode rawNode)
  {
    this.rawNode = rawNode;
    Godot.GD.Print("Deserializing test__level1");
    //Deserialize elements

  }

  public RawNode SerializeIntoRawNode()
  {
    //Serialize elements

    return rawNode;
  }

  public void Serialize(XmlElement element)
  {
      Godot.GD.Print("Serializing test__level1");
      var updatedRawNode = SerializeIntoRawNode();
      updatedRawNode.Serialize(element);
  }
}
`);
})


it("should correctly handle composition types" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
/*typeDeclarationElementToInterfaceString= element*/
public interface Itest {
  public void Deserialize (RawNode rawNode);

  public RawNode SerializeIntoRawNode();

  public void Serialize(XmlElement element);
}

/*typeDeclarationElementToString= element*/
public class test: Itest {
  public RawNode rawNode = new RawNode();

  public test()
  {
  }

  public test(RawNode rawNode)
  {
    Deserialize(rawNode);
  }

  public test(XmlElement xmlElement)
  {
    this.rawNode.Deserialize(xmlElement);
    Deserialize(rawNode);
  }

  public void Deserialize (RawNode rawNode)
  {
    this.rawNode = rawNode;
    Godot.GD.Print("Deserializing test");
  }

  public RawNode SerializeIntoRawNode()
  {
    return rawNode;
  }

  public void Serialize(XmlElement element)
  {
      Godot.GD.Print("Serializing test");
      var updatedRawNode = SerializeIntoRawNode();
      updatedRawNode.Serialize(element);
  }
}
`);
})


it("should correctly handle composition types with recursive types" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
/*typeDeclarationElementToInterfaceString= element*/
public interface Itest {
  public void Deserialize (RawNode rawNode);

  public RawNode SerializeIntoRawNode();

  public void Serialize(XmlElement element);
}

/*typeDeclarationElementToString= element*/
public class test: Itest {
  public RawNode rawNode = new RawNode();

  public test()
  {
  }

  public test(RawNode rawNode)
  {
    Deserialize(rawNode);
  }

  public test(XmlElement xmlElement)
  {
    this.rawNode.Deserialize(xmlElement);
    Deserialize(rawNode);
  }

  public void Deserialize (RawNode rawNode)
  {
    this.rawNode = rawNode;
    Godot.GD.Print("Deserializing test");
  }

  public RawNode SerializeIntoRawNode()
  {
    return rawNode;
  }

  public void Serialize(XmlElement element)
  {
      Godot.GD.Print("Serializing test");
      var updatedRawNode = SerializeIntoRawNode();
      updatedRawNode.Serialize(element);
  }
}
`);
})

it("should correctly handle object type with attributes" satisfies keyof typeof typeDeclarationDataSets, () => {
  const result = typeDeclarationToString(typeDeclarationDataSets[expect.getState().currentTestName]);
  expect(result).toEqual(template()`
/*typeDeclarationElementToInterfaceString= element*/
public interface Itest {
  //Attributes
  public System.String Get_attr();
  public void Set_attr(System.String value);

  //Children elements
  /* ignored children key:prop of type:string*/
  public void Deserialize (RawNode rawNode);

  public RawNode SerializeIntoRawNode();

  public void Serialize(XmlElement element);
}

/*typeDeclarationElementToString= element*/
public class test: Itest {
  public RawNode rawNode = new RawNode();
  //Attributes
  public System.String attr;
  public System.String Get_attr()
  {
    return this.attr;
  }
  public void Set_attr(System.String value)
  {
    this.attr = value;
  }

  //Children elements
  /* ignored children key:prop of type:string*/

  public test()
  {
  }

  public test(RawNode rawNode)
  {
    Deserialize(rawNode);
  }

  public test(XmlElement xmlElement)
  {
    this.rawNode.Deserialize(xmlElement);
    Deserialize(rawNode);
  }

  public void Deserialize (RawNode rawNode)
  {
    this.rawNode = rawNode;
    Godot.GD.Print("Deserializing test");
    //Deserialize arguments
    if(rawNode.attributes.ContainsKey("attr"))
    {
      var attribute_attr = rawNode.attributes["attr"];
      this.attr = rawNode.attributes["attr"];
    }
    //Deserialize elements

  }

  public RawNode SerializeIntoRawNode()
  {
    //Serialize arguments
    if(this.attr != null)
    {
      rawNode.attributes["attr"] = this.attr.ToString();
    }
    //Serialize elements

    return rawNode;
  }

  public void Serialize(XmlElement element)
  {
      Godot.GD.Print("Serializing test");
      var updatedRawNode = SerializeIntoRawNode();
      updatedRawNode.Serialize(element);
  }
}
`);
})
