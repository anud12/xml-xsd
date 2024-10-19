# Index

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action/person/create/empty](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action__person__create__empty.md)

#### Tags:
action,person,person.create,

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
  </rule_group>
  <data>
    <people/>
  </data>
  <actions>
    <person.create>
      <node_graph__selection/>
      <person__selection/>
    </person.create>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action/person/create/property](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action__person__create__property.md)

#### Tags:
- action
- person
- person.create,
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property_ref" units="">
        <person_default initial="1"/>
      </entry>
    </property_rule>
    <location_graph_rule id="">
      <setup>
        <starting_node node_rule_ref="node_rule_ref"/>
      </setup>
      <node_rule id="node_rule_ref"/>
    </location_graph_rule>
  </rule_group>
  <data>
    <people/>
    <location>
      <location_graph>
        <rule location_graph_rule_ref=""/>
        <node node_rule_ref="node_rule_ref" id="">
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.create>
      <node_graph__selection/>
      <person__selection>
        <property property_rule_ref="property_ref">
        </property>
      </person__selection>
    </person.create>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/mutate_from](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__mutate_from.md)

#### Tags:
- from_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <mutations>
          <property_mutation property_rule_ref="property">
            <from participant="self">
              <operation initial="1"/>
            </from>
          </property_mutation>
        </mutations>
        <on_person/>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="3">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/mutate_from/participant_self](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__mutate_from__participant_self.md)

#### Tags:
- from_person
  - participant `self`
  - property_mutation

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
      <entry id="property_dependant" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <mutations>
          <property_mutation property_rule_ref="property">
            <from participant="self">
              <operation initial="1">
                <add_property property_rule_ref="property_dependant"/>
              </operation>
            </from>
          </property_mutation>
        </mutations>
        <on_person/>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
          <property property_rule_ref="property_dependant" value="1"/>
        </properties>
      </person>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/mutate_from/participant_target](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__mutate_from__participant_target.md)

#### Tags:
- from_person
  - participant `self`
  - property_mutation

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
      <entry id="property_dependant" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <mutations>
          <property_mutation property_rule_ref="property">
            <from participant="target">
              <operation initial="1">
                <add_property property_rule_ref="property_dependant"/>
              </operation>
            </from>
          </property_mutation>
        </mutations>
        <on_person/>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
          <property property_rule_ref="property_dependant" value="1"/>
        </properties>
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property_dependant" value="2"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/mutate_from/property_unset/default_value/dependant_value](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__mutate_from__property_unset__default_value__dependant_value.md)

#### Tags:
- from_person
  - participant `self`
  - property_mutation
  - person_default

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
        <person_default initial="1"/>
      </entry>
      <entry id="property_dependant" units="points">
        <person_default initial="1"/>
      </entry>
    </property_rule>
    <action_rule>
      <from_person id="from_person_rule">
        <mutations>
          <property_mutation property_rule_ref="property">
            <from participant="self">
              <operation initial="1">
                <add_property property_rule_ref="property_dependant"/>
              </operation>
            </from>
          </property_mutation>
        </mutations>
        <on_person/>
      </from_person>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1"/>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/mutate_from/property_unset/default_value](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__mutate_from__property_unset__default_value.md)

#### Tags:
- from_person
  - participant `self`
  - property_mutation
  - person_default

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
        <person_default initial="1"/>
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <mutations>
          <property_mutation property_rule_ref="property">
            <from participant="self">
              <operation initial="1"/>
            </from>
          </property_mutation>
        </mutations>
        <on_person/>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
      </person>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/mutate_from/property_unset](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__mutate_from__property_unset.md)

#### Tags:
- from_person
  - participant `self`
  - property_mutation

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
      <entry id="property_dependant" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <mutations>
          <property_mutation property_rule_ref="property">
            <from participant="self">
              <operation initial="1"/>
            </from>
          </property_mutation>
        </mutations>
        <on_person/>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
      </person>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/on_person/mutate_on](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__on_person__mutate_on.md)

#### Tags:
- from_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <on_person>
          <mutations>
            <property_mutation property_rule_ref="property">
              <from participant="self">
                <operation initial="1"/>
              </from>
            </property_mutation>
          </mutations>
        </on_person>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="3">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/on_person/mutate_on/participant_self](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__on_person__mutate_on__participant_self.md)

#### Tags:
- from_person
  - participant `self`
  - property_mutation

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
      <entry id="property_dependant" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <on_person>
          <mutations>
            <property_mutation property_rule_ref="property">
              <from participant="self">
                <operation initial="1">
                  <add_property property_rule_ref="property_dependant"/>
                </operation>
              </from>
            </property_mutation>
          </mutations>
        </on_person>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
          <property property_rule_ref="property_dependant" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/on_person/mutate_on/participant_target](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__on_person__mutate_on__participant_target.md)

#### Tags:
- from_person
  - participant `self`
  - property_mutation

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
      <entry id="property_dependant" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <on_person>
          <mutations>
            <property_mutation property_rule_ref="property">
              <from participant="target">
                <operation initial="1">
                  <add_property property_rule_ref="property_dependant"/>
                </operation>
              </from>
            </property_mutation>
          </mutations>
        </on_person>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property_dependant" value="1"/>
        </properties>
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/on_person/selection/classificaiton/invalid](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__on_person__selection__classificaiton__invalid.md)

#### Tags:
- from_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
    </property_rule>

    <classification_rule>
      <entry id="classification_rule"/>
      <entry id="classification_rule_other"/>
    </classification_rule>
    <action_rule>
      <from_person id="from_person_rule">
        <on_person>
          <selection>
            <classification classification_rule_ref="classification_rule"/>
          </selection>
          <mutations>
            <property_mutation property_rule_ref="property">
              <from participant="self">
                <operation initial="1"/>
              </from>
            </property_mutation>
          </mutations>
        </on_person>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1"/>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
        <classifications>
          <classification classification_rule_ref="classification_rule_other"/>
        </classifications>
      </person>
      <person id="3"/>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/on_person/selection/classificaiton/valid](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__on_person__selection__classificaiton__valid.md)

#### Tags:
- from_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
    </property_rule>

    <classification_rule>
      <entry id="classification_rule"/>
    </classification_rule>
    <action_rule>
      <from_person id="from_person_rule">
        <on_person>
          <selection>
            <classification classification_rule_ref="classification_rule"/>
          </selection>
          <mutations>
            <property_mutation property_rule_ref="property">
              <from participant="self">
                <operation initial="1"/>
              </from>
            </property_mutation>
          </mutations>
        </on_person>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1"/>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
        <classifications>
          <classification classification_rule_ref="classification_rule"/>
        </classifications>
      </person>
      <person id="3"/>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/on_person/selection/from_person_same_location_graph_node/no_location](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__on_person__selection__from_person_same_location_graph_node__no_location.md)

#### Tags:
- from_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <on_person>
          <selection>
            <from_person_same_location_graph_node value="true"/>
          </selection>
          <mutations>
            <property_mutation property_rule_ref="property">
              <from participant="self">
                <operation initial="1"/>
              </from>
            </property_mutation>
          </mutations>
        </on_person>
      </from_person>
    </action_rule>
    <location_graph_rule id="location_graph_id">
      <setup>
        <starting_node node_rule_ref="node_rule_id"/>
      </setup>
      <node_rule id="node_rule_id"/>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
    <location>
      <location_graph>
        <rule location_graph_rule_ref="location_graph_id"/>
        <node node_rule_ref="node_rule_id" id="node_0"/>
      </location_graph>
    </location>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/on_person/selection/from_person_same_location_graph_node/same_location](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__on_person__selection__from_person_same_location_graph_node__same_location.md)

#### Tags:
- from_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <on_person>
          <selection>
            <from_person_same_location_graph_node value="true"/>
          </selection>
          <mutations>
            <property_mutation property_rule_ref="property">
              <from participant="self">
                <operation initial="1"/>
              </from>
            </property_mutation>
          </mutations>
        </on_person>
      </from_person>
    </action_rule>
    <location_graph_rule id="location_graph_id">
      <setup>
        <starting_node node_rule_ref="node_rule_id"/>
      </setup>
      <node_rule id="node_rule_id"/>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
    <location>
      <location_graph>
        <rule location_graph_rule_ref="location_graph_id"/>
        <node node_rule_ref="node_rule_id" id="node_0">
          <people>
            <person person_id_ref="1"/>
            <person person_id_ref="2"/>
          </people>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/selection](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__selection.md)

#### Tags:
- from_person
  - type__person_selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <selection>
          <property property_rule_ref="property">
            <max initial="0"/>
          </property>
        </selection>
        <mutations>
          <property_mutation property_rule_ref="property">
            <from participant="self">
              <operation initial="1"/>
            </from>
          </property_mutation>
        </mutations>
        <on_person/>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="3">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/selection/property/max/min_unset](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__selection__property__max__min_unset.md)

#### Tags:
- from_person
  - type__person_selection
  - property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <selection>
          <property property_rule_ref="property">
            <max initial="2"/>
          </property>
        </selection>
        <mutations>
          <property_mutation property_rule_ref="property">
            <from participant="self">
              <operation initial="1"/>
            </from>
          </property_mutation>
        </mutations>
        <on_person/>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="3">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/from_person/selection/property/min/max_unset](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__from_person__selection__property__min__max_unset.md)

#### Tags:
- from_person
  - type__person_selection
  - property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd"
>
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
      </entry>
    </property_rule>

    <action_rule>
      <from_person id="from_person_rule">
        <selection>
          <property property_rule_ref="property">
            <min initial="0"/>
          </property>
        </selection>
        <mutations>
          <property_mutation property_rule_ref="property">
            <from participant="self">
              <operation initial="1"/>
            </from>
          </property_mutation>
        </mutations>
        <on_person/>
      </from_person>
    </action_rule>
  </rule_group>

  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="3">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <from_person person_id_ref="1" from_person_rule_ref="from_person_rule">
      <on_person person_id_ref="2"/>
    </from_person>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/minimal](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__minimal.md)

#### Tags:
- action_rule

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from/>
          <on/>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1"/>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/from/property_mutation/add_to_existing](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__from__property_mutation__add_to_existing.md)

#### Tags:
- global_action
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="10">
                    <add_property property_rule_ref="property"/>
                  </operation>
                </from>
              </property_mutation>
            </person>
          </from>
          <on>
            <person/>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/from/property_mutation/existing](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__from__property_mutation__existing.md)

#### Tags:
- global_action
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="10"/>
                </from>
              </property_mutation>
            </person>
          </from>
          <on>
            <person/>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2"/>
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/from/property_mutation/no_property](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__from__property_mutation__no_property.md)

#### Tags:
- global_action
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="1"/>
                </from>
              </property_mutation>
            </person>
          </from>
          <on>
            <person/>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1"/>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/from/selection/apply](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__from__selection__apply.md)

#### Tags:
- global_action
- property
- type__person_selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <classification_rule>
      <entry id="classification"/>
    </classification_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person>
              <select>
                <classification classification_rule_ref="classification"/>
              </select>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="10"/>
                </from>
              </property_mutation>
            </person>
          </from>
          <on>
            <person/>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
        <classifications>
          <classification classification_rule_ref="classification"/>
        </classifications>
      </person>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/from/selection/exclude](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__from__selection__exclude.md)

#### Tags:
- global_action
- property
- type__person_selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <classification_rule>
      <entry id="classification"/>
    </classification_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person>
              <select>
                <classification classification_rule_ref="classification"/>
              </select>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="10"/>
                </from>
              </property_mutation>
            </person>
          </from>
          <on>
            <person/>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/on/property_mutation/add_to_existing](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__on__property_mutation__add_to_existing.md)

#### Tags:
- global_action
- property
- type__person_selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person/>
          </from>
          <on>
            <person>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="10">
                    <add_property property_rule_ref="property"/>
                  </operation>
                </from>
              </property_mutation>
            </person>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1"/>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/on/property_mutation/existing](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__on__property_mutation__existing.md)

#### Tags:
- global_action
- property
- type__person_selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person/>
          </from>
          <on>
            <person>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="10"/>
                </from>
              </property_mutation>
            </person>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1"/>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/on/property_mutation/no_property](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__on__property_mutation__no_property.md)

#### Tags:
- global_action
- property
- type__person_selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person/>
          </from>
          <on>
            <person>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="1"/>
                </from>
              </property_mutation>
            </person>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1"/>
      <person id="2"/>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/on/selection/apply](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__on__selection__apply.md)

#### Tags:
- global_action
- property
- type__person_selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <classification_rule>
      <entry id="classification"/>
    </classification_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person/>
          </from>
          <on>
            <person>
              <select>
                <classification classification_rule_ref="classification"/>
              </select>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="10"/>
                </from>
              </property_mutation>
            </person>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1"/>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
        <classifications>
          <classification classification_rule_ref="classification"/>
        </classifications>
      </person>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/action_rule/global/person/on/selection/exclude](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__action_rule__global__person__on__selection__exclude.md)

#### Tags:
- global_action
- property
- type__person_selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="units"/>
    </property_rule>
    <classification_rule>
      <entry id="classification"/>
    </classification_rule>
    <action_rule>
      <global>
        <entry id="global_action">
          <from>
            <person/>
          </from>
          <on>
            <person>
              <select>
                <classification classification_rule_ref="classification"/>
              </select>
              <property_mutation property_rule_ref="property">
                <from participant="self">
                  <operation initial="10"/>
                </from>
              </property_mutation>
            </person>
          </on>
        </entry>
      </global>
    </action_rule>
  </rule_group>
  <data>
    <people>
      <person id="1"/>
      <person id="2">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/classification/person/empty__property_rule](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__classification__person__empty__property_rule.md)

#### Tags:
- person
- classification
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="attribute" units="points"/>
    </property_rule>
    <classification_rule>
      <entry id="classification">
        <property property_rule_ref="attribute" is="equal">
          <operation initial="10"/>
        </property>
      </entry>
    </classification_rule>
  </rule_group>

  <data>
    <people>
      <person id="0">
        <properties/>
        <classifications/>
      </person>
    </people>
  </data>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/classification/person/property_rule__with__person_default](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__classification__person__property_rule__with__person_default.md)

#### Tags:
- person
- classification
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
      <entry value="4"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="attribute" units="points">
        <person_default initial="10">
          <and do="add_dice" value="100"/>
        </person_default>
      </entry>
    </property_rule>
    <classification_rule>
      <entry id="classification">
        <property property_rule_ref="attribute" is="greaterThanOrEqual">
          <operation initial="10"/>
        </property>
      </entry>
    </classification_rule>
  </rule_group>

  <data>
    <people>
      <person id="0">
        <properties/>
        <classifications/>
      </person>
      <person id="1">
        <properties/>
        <classifications/>
      </person>
      <person id="2">
        <properties/>
        <classifications/>
      </person>
    </people>
  </data>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/empty](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__empty.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id"/>
  <data/>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/min/classification](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__min__classification.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
        <person_default initial="10">
        </person_default>
      </entry>
    </property_rule>
    <classification_rule>
      <entry id="classification">
        <property property_rule_ref="property" is="lessThan">
          <operation initial="1">
            <and do="add_dice" value="3"/>
          </operation>
        </property>
      </entry>
    </classification_rule>
    <race_rule>
      <entry id="race">
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0"/>
          </value>
          <expected target="self">
            <operation initial="0"/>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="event">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="2"/>
            <classification classification_rule_ref="classification"/>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="0"/>
    </people>
  </data>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/min/no_people](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__min__no_people.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="3"/>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
        <person_default initial="10">
        </person_default>
      </entry>
    </property_rule>
    <race_rule>
      <entry id="race">
      </entry>
      <entry id="second_race">
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0"/>
          </value>
          <expected target="self">
            <operation initial="0"/>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="event">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="3"/>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="0">
      </person>
    </people>
  </data>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/min/property/max](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__min__property__max.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="3"/>
      <entry value="2"/>
      <entry value="4"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
        <person_default initial="10">
        </person_default>
      </entry>
    </property_rule>
    <race_rule>
      <entry id="race">
      </entry>
      <entry id="second_race">
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0"/>
          </value>
          <expected target="self">
            <operation initial="0"/>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="event">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="3"/>
            <property property_rule_ref="property">
              <max initial="0">
                <and do="add_dice" value="5"/>
              </max>
            </property>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="0"/>
    </people>
  </data>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/min/property/min](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__min__property__min.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="3"/>
      <entry value="2"/>
      <entry value="4"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points">
        <person_default initial="0">
        </person_default>
      </entry>
    </property_rule>
    <race_rule>
      <entry id="race">
      </entry>
      <entry id="second_race">
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0"/>
          </value>
          <expected target="self">
            <operation initial="0"/>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="event">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="3"/>
            <property property_rule_ref="property">
              <min initial="0">
                <and do="add_dice" value="5"/>
              </min>
            </property>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="0">
      </person>
    </people>
  </data>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/min/race](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__min__race.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <race_rule>
      <entry id="race">
      </entry>
      <entry id="second_race">
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0"/>
          </value>
          <expected target="self">
            <operation initial="0"/>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="event">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="2"/>
            <race race_rule_ref="race"/>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="0"/>
    </people>
  </data>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/min/radius](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__min__radius.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
      <entry value="4"/>
      <entry value="5"/>
      <entry value="6"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <race_rule>
      <entry id="race">
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0"/>
          </value>
          <expected target="self">
            <operation initial="0"/>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="event">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="self">
            <radius initial="100"/>
            <min initial="3"/>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="0"/>
    </people>
  </data>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/min/reuse_person](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__min__reuse_person.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <race_rule>
      <entry id="race">
      </entry>
      <entry id="second_race">
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0"/>
          </value>
          <expected target="self">
            <operation initial="0"/>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="event">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="2"/>
          </select_person>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="0"/>
    </people>
  </data>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/property_mutation/add](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__property_mutation__add.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points"/>
    </property_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0">
              <and do="add" value="0"/>
            </operation>
          </value>
          <expected target="target">
            <operation initial="0">
              <and do="add" value="0"/>
            </operation>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="item_select">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="1"/>
          </select_person>
          <property_mutation property_rule_ref="property" initial="1"/>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="1"/>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/property_mutation/item](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__property_mutation__item.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points"/>
    </property_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0">
              <and do="add" value="0"/>
            </operation>
          </value>
          <expected target="target">
            <operation initial="0">
              <and do="add" value="0"/>
            </operation>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="item_select">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="1"/>
          </select_person>
          <property_mutation property_rule_ref="property" initial="1"/>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/event/person_select/property_mutation/modify](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__event__person_select__property_mutation__modify.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property" units="points"/>
    </property_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <test>
          <value target="target">
            <operation initial="0">
              <and do="add" value="0"/>
            </operation>
          </value>
          <expected target="target">
            <operation initial="0">
              <and do="add" value="0"/>
            </operation>
          </expected>
        </test>
      </person_to_person>
    </action_rule>
    <events_rule>
      <entry id="item_select">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="1"/>
          </select_person>
          <property_mutation property_rule_ref="property" initial="1"/>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <data>
    <people>
      <person id="1">
        <properties>
          <property property_rule_ref="property" value="1"/>
        </properties>
      </person>
    </people>
  </data>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/add_classification/append_classification](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__add_classification__append_classification.md)

#### Tags:
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
    <location_classification_rule>
      <entry id="location_classification_rule_id"/>
      <entry id="my_classification"/>
    </location_classification_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <classifications>
            <classification location_classification_rule_ref="my_classification"/>
          </classifications>
        </node>
        <node node_rule_ref="node" id="node_id_1">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.add_classification>
      <node_graph_selection>
        <has__node_graph_id node_graph_id_ref="node_id"/>
      </node_graph_selection>
      <to_be_added__classification location_classification_rule_ref="location_classification_rule_id"/>
    </location_graph.node.add_classification>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/add_classification/empty](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__add_classification__empty.md)

#### Tags:
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
    <location_classification_rule>
      <entry id="location_classification_rule_id"/>
    </location_classification_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.add_classification>
      <node_graph_selection/>
      <to_be_added__classification location_classification_rule_ref="location_classification_rule_id"/>
    </location_graph.node.add_classification>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/add_classification/location_graph_id](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__add_classification__location_graph_id.md)

#### Tags:
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
    <location_classification_rule>
      <entry id="location_classification_rule_id"/>
    </location_classification_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
        <node node_rule_ref="node" id="node_id_1">
          <position x="0" y="0"/>
        </node>
      </location_graph>
      <location_graph id="location_graph_id_2">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
        <node node_rule_ref="node" id="node_id_1">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.add_classification>
      <node_graph_selection>
        <in__location_graph>
          <has__location_graph_id location_graph_id_ref="location_graph_id"/>
        </in__location_graph>
        <has__node_graph_id node_graph_id_ref="node_id"/>
      </node_graph_selection>
      <to_be_added__classification location_classification_rule_ref="location_classification_rule_id"/>
    </location_graph.node.add_classification>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/add_classification/node_id](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__add_classification__node_id.md)

#### Tags:
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
    <location_classification_rule>
      <entry id="location_classification_rule_id"/>
    </location_classification_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
        <node node_rule_ref="node" id="node_id_1">
          <position x="0" y="0"/>
        </node>
      </location_graph>
      <location_graph id="location_graph_id_2">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
        <node node_rule_ref="node" id="node_id_1">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.add_classification>
      <node_graph_selection>
        <has__node_graph_id node_graph_id_ref="node_id"/>
      </node_graph_selection>
      <to_be_added__classification location_classification_rule_ref="location_classification_rule_id"/>
    </location_graph.node.add_classification>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/adjacentDepthLimit_2](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__adjacentDepthLimit_2.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="2" distance="100"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="A">
          <position x="0" y="0"/>
          <link_to node_id_ref="B" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="B">
          <position x="100" y="0"/>
          <link_to node_id_ref="C" total_progress="0"/>
          <link_to node_id_ref="A" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="C">
          <position x="100" y="100"/>
          <link_to node_id_ref="D" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="D">
          <position x="0" y="100"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="A"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/classification_location](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__classification_location.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_classification_rule>
      <entry id="classification_location_rule_id"/>
    </location_classification_rule>
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <classifications>
          <classification location_classification_rule_ref="classification_location_rule_id"/>
        </classifications>
        <link_group_list>
          <link_group id="all" angle="0" angleMax="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="1"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>

  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/distance_to_progress_multiplier](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__distance_to_progress_multiplier.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="2" maxDistance="4">
              <distance_to_progress_multiplier initial="2"/>
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/existing_person/apply_classification](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__existing_person__apply_classification.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent
- classification
- existing_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <classification_rule>
      <entry id="classification_rule_id"/>
    </classification_rule>
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="1"/>
          </link_group>
        </link_group_list>
        <existing_person min="3">
          <person_selection>
            <classification classification_rule_ref="classification_rule_id"/>
          </person_selection>
        </existing_person>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people/>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/existing_person](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__existing_person.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent
- existing_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="1"/>
          </link_group>
        </link_group_list>
        <existing_person min="3">
          <person_selection/>
        </existing_person>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people/>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/existing_person/multiple_rules](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__existing_person__multiple_rules.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent
- existing_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="1"/>
          </link_group>
        </link_group_list>
        <existing_person min="3">
          <person_selection/>
        </existing_person>
      </node_rule>
      <node_rule id="other_rule">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="1"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people/>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="other_rule" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/existing_person/property_selection](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__existing_person__property_selection.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent
- classification
- property
- existing_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <property_rule>
      <entry id="property_rule_id" units=""/>
    </property_rule>
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="1"/>
          </link_group>
        </link_group_list>
        <existing_person min="3">
          <person_selection>
            <property property_rule_ref="property_rule_id">
              <min initial="1"/>
              <max initial="2"/>
            </property>
          </person_selection>
        </existing_person>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people/>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/limit/batch](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__limit__batch.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" limit="1">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/limit](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__limit.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" limit="1">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="second_node" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="second_node">
          <position x="100" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/limit/multipleLinkGroups](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__limit__multipleLinkGroups.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" limit="1">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
          </link_group>
          <link_group id="second_all" angle="0" limit="1">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="second_node" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="second_node">
          <position x="100" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/link_group_rule](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__link_group_rule.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <link_group_rule_list>
      <link_group_rule id="link_group_rule_id" angle="0">
        <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
      </link_group_rule>
    </link_group_rule_list>
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <reference link_group_rule_ref="link_group_rule_id"/>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/maintain_link_limits/adjacent_depth_limit](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__maintain_link_limits__adjacent_depth_limit.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <next_world_step value="../gui-client/data"/>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="4"/>
    <randomization_table>
      <entry value="3"/>
      <entry value="6"/>
      <entry value="5"/>
      <entry value="7"/>
      <entry value="1"/>
      <entry value="10"/>
      <entry value="7"/>
      <entry value="3"/>
      <entry value="8"/>
      <entry value="4"/>
      <entry value="9"/>
      <entry value="2"/>
      <entry value="10"/>
      <entry value="1"/>
      <entry value="6"/>
      <entry value="5"/>
      <entry value="1"/>
      <entry value="8"/>
      <entry value="7"/>
      <entry value="3"/>
      <entry value="5"/>
      <entry value="4"/>
      <entry value="2"/>
      <entry value="6"/>
      <entry value="10"/>
      <entry value="9"/>
      <entry value="9"/>
      <entry value="6"/>
      <entry value="7"/>
      <entry value="2"/>
      <entry value="10"/>
      <entry value="4"/>
      <entry value="5"/>
      <entry value="1"/>
      <entry value="3"/>
      <entry value="8"/>
      <entry value="6"/>
      <entry value="5"/>
      <entry value="1"/>
      <entry value="10"/>
      <entry value="4"/>
      <entry value="3"/>
      <entry value="7"/>
      <entry value="2"/>
      <entry value="8"/>
      <entry value="9"/>
      <entry value="2"/>
      <entry value="3"/>
      <entry value="7"/>
      <entry value="5"/>
      <entry value="1"/>
      <entry value="9"/>
      <entry value="10"/>
      <entry value="6"/>
      <entry value="4"/>
      <entry value="8"/>
      <entry value="8"/>
      <entry value="4"/>
      <entry value="2"/>
      <entry value="6"/>
      <entry value="3"/>
      <entry value="7"/>
      <entry value="10"/>
      <entry value="1"/>
      <entry value="9"/>
      <entry value="5"/>
      <entry value="5"/>
      <entry value="9"/>
      <entry value="1"/>
      <entry value="10"/>
      <entry value="2"/>
      <entry value="4"/>
      <entry value="8"/>
      <entry value="7"/>
      <entry value="3"/>
      <entry value="6"/>
      <entry value="3"/>
      <entry value="6"/>
      <entry value="5"/>
      <entry value="8"/>
      <entry value="10"/>
      <entry value="9"/>
      <entry value="4"/>
      <entry value="7"/>
      <entry value="2"/>
      <entry value="1"/>
      <entry value="4"/>
      <entry value="8"/>
      <entry value="1"/>
      <entry value="7"/>
      <entry value="6"/>
      <entry value="5"/>
      <entry value="9"/>
      <entry value="2"/>
      <entry value="3"/>
      <entry value="10"/>
      <entry value="4"/>
      <entry value="9"/>
      <entry value="2"/>
      <entry value="8"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="city"/>
      </setup>
      <node_rule id="city">
        <link_group_list>
          <link_group id="0" angle="0" angleMax="0" limit="1">
            <to_option node_rule_ref="city" adjacent_depth_limit="100" distance="1" maxDistance="1"/>
          </link_group>
          <link_group id="90" angle="90" angleMax="90" limit="1">
            <to_option node_rule_ref="city" adjacent_depth_limit="100" distance="1" maxDistance="1"/>
          </link_group>
        </link_group_list>
      </node_rule>
      <node_rule id="plains">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="0" limit="10"/>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="first world">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="city" id="Capital">
          <position x="0" y="0"/>
          <link_to node_id_ref="0.0" total_progress="0"/>
          <link_to node_id_ref="0.1" total_progress="0"/>
          <link_to node_id_ref="0.2" total_progress="0"/>
          <link_to node_id_ref="0.3" total_progress="0"/>
        </node>
        <node node_rule_ref="city" id="0.0">
          <position x="1" y="0"/>
          <link_to node_id_ref="Capital" total_progress="0"/>
          <link_to node_id_ref="0.1" total_progress="0"/>
          <link_to node_id_ref="0.2" total_progress="0"/>
          <link_to node_id_ref="0.3" total_progress="0"/>
        </node>
        <node node_rule_ref="city" id="0.1">
          <position x="2" y="0"/>
          <link_to node_id_ref="0.0" total_progress="0"/>
          <link_to node_id_ref="0.2" total_progress="0"/>
          <link_to node_id_ref="0.3" total_progress="0"/>
        </node>
        <node node_rule_ref="city" id="0.2">
          <position x="3" y="0"/>
          <link_to node_id_ref="0.1" total_progress="0"/>
          <link_to node_id_ref="0.3" total_progress="0"/>
        </node>
        <node node_rule_ref="city" id="0.3">
          <position x="4" y="0"/>
          <link_to node_id_ref="0.2" total_progress="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="first world" node_id_ref="0.3"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/maintain_link_limits/angle](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__maintain_link_limits__angle.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="city"/>
      </setup>
      <node_rule id="city">
        <link_group_list>
          <link_group id="0" angle="0" limit="1">
            <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="3"/>
          </link_group>
          <link_group id="90" angle="90" limit="1">
            <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="3"/>
          </link_group>
          <link_group id="270" angle="270" limit="1">
            <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="3"/>
          </link_group>
        </link_group_list>
      </node_rule>
      <node_rule id="plains">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="360" limit="10">
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id" />
        <node node_rule_ref="city" id="Capital">
          <position x="0" y="0"/>
          <link_to node_id_ref="1.0" total_progress="0"/>
          <link_to node_id_ref="1.1" total_progress="0"/>
          <link_to node_id_ref="1.2" total_progress="0"/>
        </node>
        <node node_rule_ref="plains" id="1.0">
          <position x="0" y="-1"/>
        </node>
        <node node_rule_ref="plains" id="1.1">
          <position x="0" y="1"/>
        </node>
        <node node_rule_ref="plains" id="1.2">
          <position x="1" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>

  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="Capital"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/maintain_link_limits/angle/no_op](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__maintain_link_limits__angle__no_op.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <next_world_step value="../gui-client/data" />
    <elapsed_time value="0" />
    <stepDuration value="0" />
    <counter value="2" />
    <randomization_table>
      <entry value="2" />
      <entry value="8" />
      <entry value="3" />
      <entry value="6" />
      <entry value="5" />
      <entry value="7" />
      <entry value="1" />
      <entry value="10" />
      <entry value="7" />
      <entry value="3" />
      <entry value="8" />
      <entry value="4" />
      <entry value="9" />
      <entry value="2" />
      <entry value="10" />
      <entry value="1" />
      <entry value="6" />
      <entry value="5" />
      <entry value="1" />
      <entry value="8" />
      <entry value="7" />
      <entry value="3" />
      <entry value="5" />
      <entry value="4" />
      <entry value="2" />
      <entry value="6" />
      <entry value="10" />
      <entry value="9" />
      <entry value="9" />
      <entry value="6" />
      <entry value="7" />
      <entry value="2" />
      <entry value="10" />
      <entry value="4" />
      <entry value="5" />
      <entry value="1" />
      <entry value="3" />
      <entry value="8" />
      <entry value="6" />
      <entry value="5" />
      <entry value="1" />
      <entry value="10" />
      <entry value="4" />
      <entry value="3" />
      <entry value="7" />
      <entry value="2" />
      <entry value="8" />
      <entry value="9" />
      <entry value="2" />
      <entry value="3" />
      <entry value="7" />
      <entry value="5" />
      <entry value="1" />
      <entry value="9" />
      <entry value="10" />
      <entry value="6" />
      <entry value="4" />
      <entry value="8" />
      <entry value="8" />
      <entry value="4" />
      <entry value="2" />
      <entry value="6" />
      <entry value="3" />
      <entry value="7" />
      <entry value="10" />
      <entry value="1" />
      <entry value="9" />
      <entry value="5" />
      <entry value="5" />
      <entry value="9" />
      <entry value="1" />
      <entry value="10" />
      <entry value="2" />
      <entry value="4" />
      <entry value="8" />
      <entry value="7" />
      <entry value="3" />
      <entry value="6" />
      <entry value="3" />
      <entry value="6" />
      <entry value="5" />
      <entry value="8" />
      <entry value="10" />
      <entry value="9" />
      <entry value="4" />
      <entry value="7" />
      <entry value="2" />
      <entry value="1" />
      <entry value="4" />
      <entry value="8" />
      <entry value="1" />
      <entry value="7" />
      <entry value="6" />
      <entry value="5" />
      <entry value="9" />
      <entry value="2" />
      <entry value="3" />
      <entry value="10" />
      <entry value="4" />
      <entry value="9" />
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="city" />
      </setup>
      <node_rule id="city">
        <link_group_list>
          <link_group id="0" angle="0" limit="1">
            <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="1" />
          </link_group>
          <link_group id="90" angle="90" limit="1">
            <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="1" />
          </link_group>
        </link_group_list>
      </node_rule>
      <node_rule id="plains">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="360" limit="10" />
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="first world">
        <rule location_graph_rule_ref="location_graph_rule_id" />
        <node node_rule_ref="city" id="Capital">
          <position x="0" y="0" />
          <link_to node_id_ref="1.0" total_progress="0" />
          <link_to node_id_ref="1.1" total_progress="0" />
        </node>
        <node node_rule_ref="plains" id="1.0">
          <position x="1" y="0" />
        </node>
        <node node_rule_ref="plains" id="1.1">
          <position x="0" y="1" />
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="first world" node_id_ref="Capital" />
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/maxAngle](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__maxAngle.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="360">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/maxAngle/negative_value](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__maxAngle__negative_value.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="-360">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/maxDistance](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__maxDistance.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0" maxDistance="10"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/name/existing_person](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__name__existing_person.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent
- name

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <name_rule>
      <entry id="name_rule_id">
        <name_token prefix="node">
          <one_of>
            <name_token prefix="First"/>
          </one_of>
        </name_token>
      </entry>
    </name_rule>
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <name name_rule_ref="name_rule_id"/>
        <existing_person min="2">
          <person_selection/>
        </existing_person>
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/name](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__name.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent
- name

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <name_rule>
      <entry id="name_rule_id">
        <name_token prefix="node">
          <one_of>
            <name_token prefix="First"/>
          </one_of>
        </name_token>
      </entry>
    </name_rule>
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <name name_rule_ref="name_rule_id"/>
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/progress_property/adjacent_link](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__progress_property__adjacent_link.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="2" distance="100">
              <person_progress_property initial="2">
                <and do="add" value="1">
                  <and do="divide" value="1"/>
                </and>
              </person_progress_property>
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="A">
          <position x="0" y="0"/>
          <link_to node_id_ref="B" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="B">
          <position x="100" y="0"/>
          <link_to node_id_ref="C" total_progress="0"/>
          <link_to node_id_ref="A" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="C">
          <position x="100" y="100"/>
          <link_to node_id_ref="D" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="D">
          <position x="0" y="100"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="A"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_adjacent/progress_property](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_adjacent__progress_property.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="2" maxDistance="4">
              <person_progress_property initial="2">
                <and do="add" value="1">
                  <and do="divide" value="1"/>
                </and>
              </person_progress_property>
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_location_graph](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_location_graph.md)

#### Tags:
- location_graph
- location_graph.create

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="360">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data/>
  <actions>
    <location_graph.create location_graph_rule_ref="location_graph_rule_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/create_location_graph/necesary_node](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__create_location_graph__necesary_node.md)

#### Tags:
- location_graph
- location_graph.create
- necessary_node

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
        <necessary_node node_rule_ref="node" min="3"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="360">
            <to_option node_rule_ref="node" adjacent_depth_limit="1" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data/>
  <actions>
    <location_graph.create location_graph_rule_ref="location_graph_rule_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/validation/node_graph_id_ref](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__validation__node_graph_id_ref.md)

#### Tags:
- validation
- location_graph_id_ref

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="360">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id"/>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="invalid_location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/validation/node_id_ref](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__validation__node_id_ref.md)

#### Tags:
- validation
- node_id_ref

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="360">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id"/>
      </location_graph>
    </location>
  </data>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="invalid_node_id"/>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/location_graph/validation/node_rule_ref](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__location_graph__validation__node_rule_ref.md)

#### Tags:
- validation
- node_rule_ref

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0" angleMax="360">
            <to_option node_rule_ref="other" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data/>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/name_rule/name_token/one_of](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__name_rule__name_token__one_of.md)

#### Tags:
- name_rule

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <name_rule>
      <entry id="name_rule">
        <name_token prefix="prefix">
          <one_of>
            <name_token prefix="first one_of"/>
          </one_of>
        </name_token>
      </entry>
    </name_rule>
  </rule_group>
  <data/>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/name_rule/name_token/prefix](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__name_rule__name_token__prefix.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <name_rule>
      <entry id="name_rule">
        <name_token prefix="prefix"/>
      </entry>
    </name_rule>
  </rule_group>
  <data/>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/name_rule/name_token/recursive](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__name_rule__name_token__recursive.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group">
    <name_rule>
      <entry id="name_rule">
        <name_token prefix="[prefix]">
          <one_of>
            <name_token prefix="[one of]">
              <one_of>
                <name_token prefix="[second one of]">
                  <ref name_rule_ref="name_metadata_ref"/>
                </name_token>
              </one_of>
            </name_token>
          </one_of>
        </name_token>
      </entry>
      <entry id="name_metadata_ref">
        <name_token prefix="[ref_prefix]"/>
      </entry>
    </name_rule>
  </rule_group>
  <data/>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/name_rule/name_token/ref](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__name_rule__name_token__ref.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <name_rule>
      <entry id="name_rule">
        <name_token prefix="[prefix]">
          <ref name_rule_ref="name_metadata_ref"/>
        </name_token>
      </entry>
      <entry id="name_metadata_ref">
        <name_token prefix="[ref_prefix]"/>
      </entry>
    </name_rule>
  </rule_group>
  <data/>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/find_path_towards/from_link](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__find_path_towards__from_link.md)

#### Tags:
- person
- person.move_to
- find_path_towards

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1">
            <people>
              <person person_id_ref="person_id" accumulated_progress="0"/>
            </people>
          </link_to>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="4"/>
          <link_to node_id_ref="node_id_3" total_progress="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_3">
          <position x="0" y="3"/>
          <link_to node_id_ref="node_id_4" total_progress="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_4">
          <position x="0" y="2"/>
          <link_to node_id_ref="node_id_destination" total_progress="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <find_path_towards>
        <has__node_graph_id node_graph_id_ref="node_id_destination"/>
      </find_path_towards>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/find_path_towards](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__find_path_towards.md)

#### Tags:
- person
- person.move_to
- find_path_towards

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1"/>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="4"/>
          <link_to node_id_ref="node_id_3" total_progress="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_3">
          <position x="0" y="3"/>
          <link_to node_id_ref="node_id_4" total_progress="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_4">
          <position x="0" y="2"/>
          <link_to node_id_ref="node_id_destination" total_progress="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <find_path_towards>
        <has__node_graph_id node_graph_id_ref="node_id_destination"/>
      </find_path_towards>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/find_path_towards/multiple_paths](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__find_path_towards__multiple_paths.md)

#### Tags:
- person
- person.move_to
- find_path_towards

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1"/>
          <link_to node_id_ref="node_id_4" total_progress="1"/>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="4"/>
          <link_to node_id_ref="node_id_3" total_progress="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_3">
          <position x="0" y="3"/>
          <link_to node_id_ref="node_id_4" total_progress="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_4">
          <position x="0" y="2"/>
          <link_to node_id_ref="node_id_destination" total_progress="1"/>
        </node>
      </location_graph>
    </location>
  </data>

  <actions>
    <person.move_to person_id_ref="person_id">
      <find_path_towards>
        <has__node_graph_id node_graph_id_ref="node_id_destination"/>
      </find_path_towards>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/find_path_towards/multiple_paths/multiple_costs](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__find_path_towards__multiple_paths__multiple_costs.md)

#### Tags:
- person
- person.move_to
- find_path_towards

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1"/>
          <link_to node_id_ref="node_id_4" total_progress="1000"/>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="4"/>
          <link_to node_id_ref="node_id_3" total_progress="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_3">
          <position x="0" y="3"/>
          <link_to node_id_ref="node_id_4" total_progress="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_4">
          <position x="0" y="2"/>
          <link_to node_id_ref="node_id_destination" total_progress="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <find_path_towards>
        <has__node_graph_id node_graph_id_ref="node_id_destination"/>
      </find_path_towards>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/empty_path](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__empty_path.md)

#### Tags:
- person
- person.move_to
- path

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1">
            <person_progress_property initial="3"/>
          </link_to>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <path>
      </path>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/node_to_node/from_link](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__node_to_node__from_link.md)

#### Tags:
- person
- person.move_to
- path
- person_progress_property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1">
            <person_progress_property initial="4"/>
            <people>
              <person person_id_ref="person_id" accumulated_progress="1"/>
            </people>
          </link_to>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="1"/>
          <link_to node_id_ref="node_id_destination" total_progress="9">
            <person_progress_property initial="10"/>
          </link_to>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <path>
        <node node_id_ref="node_id_destination"/>
      </path>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/node_to_node/from_link/middle_of_path](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__node_to_node__from_link__middle_of_path.md)

#### Tags:
- person
- person.move_to
- path
- person_progress_property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1">
            <person_progress_property initial="4"/>
            <people>
              <person person_id_ref="person_id" accumulated_progress="1"/>
            </people>
          </link_to>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="1"/>
          <link_to node_id_ref="node_id_destination" total_progress="9">
            <person_progress_property initial="10"/>
          </link_to>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <path>
        <node node_id_ref="node_id"/>
        <node node_id_ref="node_id_destination"/>
      </path>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/node_to_node/from_link/middle_of_path/to_empty](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__node_to_node__from_link__middle_of_path__to_empty.md)

#### Tags:
- person
- person.move_to
- path
- person_progress_property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="first world">
        <rule location_graph_rule_ref="location_graph_rule_id" />
        <node node_rule_ref="node" id="origin">
          <position x="0" y="0" />
          <link_to node_id_ref="0.0" total_progress="5">
            <person_progress_property initial="1" />
            <people />
          </link_to>
          <people>
            <person person_id_ref="1" />
          </people>
        </node>
        <node node_rule_ref="node" id="0.0">
          <position x="8" y="0" />
          <link_to node_id_ref="0.1" total_progress="5">
            <person_progress_property initial="1" />
            <people />
          </link_to>
          <people />
        </node>
        <node node_rule_ref="node" id="0.1">
          <position x="4" y="3" />
          <link_to node_id_ref="origin" total_progress="5">
            <person_progress_property initial="1" />
            <people />
          </link_to>
          <people>
            <person person_id_ref="0" />
          </people>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="0">
      <path>
        <node node_id_ref="0.1" />
      </path>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/node_to_node](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__node_to_node.md)

#### Tags:
- person
- person.move_to
- path
- person_progress_property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1">
            <person_progress_property initial="4"/>
          </link_to>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="1"/>
          <link_to node_id_ref="node_id_destination" total_progress="1">
            <person_progress_property initial="4"/>
          </link_to>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <path>
        <node node_id_ref="node_id_2"/>
        <node node_id_ref="node_id_destination"/>
      </path>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/node_to_node/middle_of_path](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__node_to_node__middle_of_path.md)

#### Tags:
- person
- person.move_to
- path
- person_progress_property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1">
            <person_progress_property initial="4"/>
          </link_to>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="1"/>
          <link_to node_id_ref="node_id_destination" total_progress="9">
            <person_progress_property initial="1"/>
          </link_to>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <path>
        <node node_id_ref="node_id_2"/>
        <node node_id_ref="node_id_destination"/>
      </path>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/node_to_node/no_path](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__node_to_node__no_path.md)

#### Tags:
- person
- person.move_to
- path
- person_progress_property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1">
            <person_progress_property initial="3"/>
          </link_to>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="1"/>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <path>
        <node node_id_ref="node_id_2"/>
        <node node_id_ref="node_id_destination"/>
      </path>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/node_to_node/partial_over_node](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__node_to_node__partial_over_node.md)

#### Tags:
- person
- person.move_to
- path
- person_progress_property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_2" total_progress="1">
            <person_progress_property initial="4"/>
          </link_to>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_2">
          <position x="0" y="1"/>
          <link_to node_id_ref="node_id_destination" total_progress="10">
            <person_progress_property initial="9"/>
          </link_to>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <path>
        <node node_id_ref="node_id_2"/>
        <node node_id_ref="node_id_destination"/>
      </path>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/person_progress_property](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__person_progress_property.md)

#### Tags:
- person
- person.move_to
- path
- person_progress_property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_destination" total_progress="10">
            <person_progress_property initial="1"/>
          </link_to>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.move_to person_id_ref="person_id">
      <path>
        <node node_id_ref="node_id_destination"/>
      </path>
    </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/move_to/path/person_progress_property/unset](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__move_to__path__person_progress_property__unset.md)

#### Tags:
- person
- person.move_to
- path
- person_progress_property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id_destination" total_progress="1"/>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="node_id_destination">
          <position x="0" y="1"/>
        </node>
      </location_graph>
    </location>
  </data>

  <actions>
  <person.move_to person_id_ref="person_id">
    <path>
      <node node_id_ref="node_id_destination"/>
    </path>
  </person.move_to>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/teleport_to/has_location](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__teleport_to__has_location.md)

#### Tags:
- person
- person.teleport

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <people>
            <person person_id_ref="person_id"/>
          </people>
        </node>
        <node node_rule_ref="node" id="second_node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.teleport person_id_ref="person_id">
      <location_graph location_graph_id_ref="location_graph_id" node_id_ref="second_node_id"/>
    </person.teleport>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/teleport_to](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__teleport_to.md)

#### Tags:
- person
- person.teleport

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>

  <actions>
    <person.teleport person_id_ref="person_id">
      <location_graph location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    </person.teleport>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/teleport_to/link_to/has_location](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__teleport_to__link_to__has_location.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="second_node_id" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="second_node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="node_id" total_progress="0">
            <people>
              <person person_id_ref="person_id" accumulated_progress="0"/>
            </people>
          </link_to>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.teleport person_id_ref="person_id">
      <link_to accumulated_progress="1">
        <selection>
          <origin__node_graph__selection>
            <has__node_graph_id node_graph_id_ref="node_id"/>
          </origin__node_graph__selection>
        </selection>
      </link_to>
    </person.teleport>
  </actions>
</world_step>
```

## [../specification-test/src/test/java/ro/anud/xml_xsd/specification/blackbox/person/teleport_to/link_to](./..__specification-test__src__test__java__ro__anud__xml_xsd__specification__blackbox__person__teleport_to__link_to.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="1"/>
      <entry value="2"/>
      <entry value="3"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <location_graph_rule id="location_graph_rule_id">
      <setup>
        <starting_node node_rule_ref="node"/>
      </setup>
      <node_rule id="node">
        <link_group_list>
          <link_group id="all" angle="0">
            <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0">
            </to_option>
          </link_group>
        </link_group_list>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <data>
    <people>
      <person id="person_id">
      </person>
    </people>
    <location>
      <location_graph id="location_graph_id">
        <rule location_graph_rule_ref="location_graph_rule_id"/>
        <node node_rule_ref="node" id="node_id">
          <position x="0" y="0"/>
          <link_to node_id_ref="second_node_id" total_progress="0"/>
        </node>
        <node node_rule_ref="node" id="second_node_id">
          <position x="0" y="0"/>
        </node>
      </location_graph>
    </location>
  </data>
  <actions>
    <person.teleport person_id_ref="person_id">
      <link_to accumulated_progress="1">
        <selection>
          <origin__node_graph__selection>
            <has__node_graph_id node_graph_id_ref="node_id"/>
          </origin__node_graph__selection>
        </selection>
      </link_to>
    </person.teleport>
  </actions>
</world_step>
```

