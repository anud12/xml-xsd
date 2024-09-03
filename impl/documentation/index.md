# Index

## [./action/person/create/empty](./.__documentation__action__person__create__empty.md)

#### Tags:
action,person,person.create,

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
  <people/>
  <actions>
    <person.create>
      <node_graph__selection/>
      <person__selection/>
    </person.create>
  </actions>
</world_step>
```

## [./action/person/create/property](./.__documentation__action__person__create__property.md)

#### Tags:
- action
- person
- person.create,
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
  <people/>
  <location_graph>
    <rule location_graph_rule_ref=""/>
    <node node_rule_ref="node_rule_ref" id="">
    </node>
  </location_graph>
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

## [./action_rule/global/minimal](./.__documentation__action_rule__global__minimal.md)

#### Tags:
- action_rule

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
  <items/>
  <people>
    <person id="1"/>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/from/property_mutation/add_to_existing](./.__documentation__action_rule__global__person__from__property_mutation__add_to_existing.md)

#### Tags:
- global_action
- property

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
  <items/>
  <people>
    <person id="1">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
    <person id="2"/>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/from/property_mutation/existing](./.__documentation__action_rule__global__person__from__property_mutation__existing.md)

#### Tags:
- global_action
- property

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
  <items/>
  <people>
    <person id="1">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
    <person id="2"/>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2"/>
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/from/property_mutation/no_property](./.__documentation__action_rule__global__person__from__property_mutation__no_property.md)

#### Tags:
- global_action
- property

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
  <items/>
  <people>
    <person id="1"/>
    <person id="2"/>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/from/selection/apply](./.__documentation__action_rule__global__person__from__selection__apply.md)

#### Tags:
- global_action
- property
- type__person_selection

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
  <items/>
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
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/from/selection/exclude](./.__documentation__action_rule__global__person__from__selection__exclude.md)

#### Tags:
- global_action
- property
- type__person_selection

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
  <items/>
  <people>
    <person id="1">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
    <person id="2"/>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/not_eligible](./.__documentation__action_rule__global__person__not_eligible.md)

#### Tags:
- action_rule
- global_action
- type__person_selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
            </person>
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
  <items/>
  <people>
    <person id="1"/>
    <person id="2">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/on/property_mutation/add_to_existing](./.__documentation__action_rule__global__person__on__property_mutation__add_to_existing.md)

#### Tags:
- global_action
- property
- type__person_selection

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
  <items/>
  <people>
    <person id="1"/>
    <person id="2">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/on/property_mutation/existing](./.__documentation__action_rule__global__person__on__property_mutation__existing.md)

#### Tags:
- global_action
- property
- type__person_selection

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
  <items/>
  <people>
    <person id="1"/>
    <person id="2">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/on/property_mutation/no_property](./.__documentation__action_rule__global__person__on__property_mutation__no_property.md)

#### Tags:
- global_action
- property
- type__person_selection

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
  <items/>
  <people>
    <person id="1"/>
    <person id="2"/>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/on/selection/apply](./.__documentation__action_rule__global__person__on__selection__apply.md)

#### Tags:
- global_action
- property
- type__person_selection

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
  <items/>
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
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/global/person/on/selection/exclude](./.__documentation__action_rule__global__person__on__selection__exclude.md)

#### Tags:
- global_action
- property
- type__person_selection

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
  <items/>
  <people>
    <person id="1"/>
    <person id="2">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_ref="global_action" person_ref="2" />
    </by>
  </actions>
</world_step>
```

## [./action_rule/person_to_person](./.__documentation__action_rule__person_to_person.md)

#### Tags:
- person_to_person

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../world_step.xsd"
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
      <entry id="strength" units="points">
        <person_default initial="0">
          <and do="add" value="10"/>
        </person_default>
      </entry>
      <entry id="health" units="points">
        <person_default initial="0">
          <and do="add" value="10"/>
        </person_default>
      </entry>
    </property_rule>

    <race_rule>
      <entry id="human">
        <movement value="5" inclusive="true"/>
      </entry>
    </race_rule>

    <action_rule>
      <person_to_person id="meleeAttack">
        <max_range>
          <operation initial="0">
            <and do="add" value="1"/>
          </operation>
        </max_range>
        <test>
          <value target="self">
            <operation initial="0">
              <and do="add" value="3"/>
            </operation>
          </value>
          <expected target="target">
            <operation initial="0">
              <and do="add" value="3"/>
            </operation>
          </expected>
        </test>

        <property_mutation property_rule_ref="health" on="target">
          <from participant="self">
            <operation initial="0">
              <add_property property_rule_ref="strength"/>
              <and do="divide" value="2"/>
            </operation>
          </from>
        </property_mutation>
      </person_to_person>
    </action_rule>
  </rule_group>

  <people>
    <person id="Billy">
      <race race_rule_ref="human"/>
      <location x="10" y="10"/>
      <properties/>
    </person>
    <person id="Bob">
      <race race_rule_ref="human"/>
      <location x="10" y="10"/>
      <properties/>
    </person>
  </people>
  <actions>
    <person.on_person.property_mutation person_id_ref="Billy" target_person_id_ref="Bob" action_property_mutation_rule_ref="meleeAttack"/>
  </actions>
</world_step>
```

## [./classification/item/add/compute_property](./.__documentation__classification__item__add__compute_property.md)

#### Tags:
- item
- classification
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
      <entry id="property" units="">
        <item_default initial="10"/>
      </entry>
    </property_rule>
    <classification_rule>
      <entry id="classification">
        <property property_rule_ref="property" is="equal">
          <operation initial="10"/>
        </property>
      </entry>
    </classification_rule>
  </rule_group>

  <items>
    <item id="0">
    </item>
  </items>
</world_step>
```

## [./classification/item/add/property_exists](./.__documentation__classification__item__add__property_exists.md)

#### Tags:
- item
- classification
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
      <entry id="property" units=""/>
    </property_rule>
    <classification_rule>
      <entry id="classification">
        <property property_rule_ref="property" is="equal">
          <operation initial="10"/>
        </property>
      </entry>
    </classification_rule>
  </rule_group>

  <items>
    <item id="0">
      <properties>
        <property property_rule_ref="property" value="10"/>
      </properties>
    </item>
  </items>
</world_step>
```

## [./classification/item/dont_add/compute_property](./.__documentation__classification__item__dont_add__compute_property.md)

#### Tags:
- item
- classification
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
      <entry id="property" units="">
      </entry>
    </property_rule>
    <classification_rule>
      <entry id="classification">
        <property property_rule_ref="property" is="equal">
          <operation initial="10"/>
        </property>
      </entry>
    </classification_rule>
  </rule_group>

  <items>
    <item id="0">
    </item>
  </items>
</world_step>
```

## [./classification/item/keep](./.__documentation__classification__item__keep.md)

#### Tags:
- item
- classification

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>

  <rule_group id="rule_group_id">
    <classification_rule>
      <entry id="classification"/>
    </classification_rule>
  </rule_group>

  <items>
    <item id="0">
      <classifications>
        <classification classification_rule_ref="classification"/>
      </classifications>
    </item>
  </items>
</world_step>
```

## [./classification/person/empty property_rule](./.__documentation__classification__person__empty property_rule.md)

#### Tags:
- person
- classification
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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

  <people>
    <person id="0">
      <location x="0" y="0"/>
      <properties/>
      <classifications/>
    </person>
  </people>
</world_step>
```

## [./classification/person/property_rule with person_default](./.__documentation__classification__person__property_rule with person_default.md)

#### Tags:
- person
- classification
- property

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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

  <people>
    <person id="0">
      <location x="0" y="0"/>
      <properties/>
      <classifications/>
    </person>
    <person id="1">
      <location x="0" y="0"/>
      <properties/>
      <classifications/>
    </person>
    <person id="2">
      <location x="0" y="0"/>
      <properties/>
      <classifications/>
    </person>
  </people>
</world_step>
```

## [./empty](./.__documentation__empty.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id"/>
</world_step>
```

## [./event/item_select/any_item](./.__documentation__event__item_select__any_item.md)

#### Tags:
- item

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
        <min_range>
          <operation initial="0"/>
        </min_range>
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
    <item_rule>
      <entry id="item_rule">
        <name>
          <name_token prefix="item_name"/>
        </name>
      </entry>
    </item_rule>
    <events_rule>
      <entry id="item_select">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_item origin="target">
            <min initial="1"/>
          </select_item>
        </then>

      </entry>
    </events_rule>
  </rule_group>
  <items/>
  <people>
    <person id="1">
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [./event/item_select/no_item_rules](./.__documentation__event__item_select__no_item_rules.md)

#### Tags:
- item

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
  <world_metadata>
    <elapsed_time value="0"/>
    <stepDuration value="0"/>
    <counter value="0"/>
    <randomization_table>
      <entry value="2"/>
    </randomization_table>
  </world_metadata>
  <rule_group id="rule_group_id">
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
        <min_range>
          <operation initial="0"/>
        </min_range>
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
          <select_item origin="target">
            <min initial="1"/>
          </select_item>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <items/>
  <people>
    <person id="1">
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [./event/item_select/property_mutation/add](./.__documentation__event__item_select__property_mutation__add.md)

#### Tags:
- item
- property_mutation

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <max_range>
          <operation initial="0"/>
        </max_range>
        <min_range>
          <operation initial="0"/>
        </min_range>
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
    <item_rule>
      <entry id="item_rule">
        <name>
          <name_token prefix="item_name"/>
        </name>
      </entry>
    </item_rule>
    <events_rule>
      <entry id="item_select">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_item origin="target">
            <min initial="1"/>
          </select_item>
          <property_mutation property_rule_ref="property" initial="1"/>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <items>
    <item id="0" name="item_name"/>
  </items>
  <people>
    <person id="1">
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [./event/item_select/property_mutation/item](./.__documentation__event__item_select__property_mutation__item.md)

#### Tags:
- item
- property_mutation

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <max_range>
          <operation initial="0"/>
        </max_range>
        <min_range>
          <operation initial="0"/>
        </min_range>
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
    <item_rule>
      <entry id="item_rule">
        <name>
          <name_token prefix="item_name"/>
        </name>
      </entry>
    </item_rule>
    <events_rule>
      <entry id="item_select">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_item origin="target">
            <min initial="1"/>
          </select_item>
          <property_mutation property_rule_ref="property" initial="1"/>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <items>
    <item id="0" name="item_name">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </item>
  </items>
  <people>
    <person id="1">
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [./event/item_select/property_mutation/modify](./.__documentation__event__item_select__property_mutation__modify.md)

#### Tags:
- item
- property_mutation

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <max_range>
          <operation initial="0"/>
        </max_range>
        <min_range>
          <operation initial="0"/>
        </min_range>
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
    <item_rule>
      <entry id="item_rule">
        <name>
          <name_token prefix="item_name"/>
        </name>
      </entry>
    </item_rule>
    <events_rule>
      <entry id="item_select">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_item origin="target">
            <min initial="1"/>
          </select_item>
          <property_mutation property_rule_ref="property" initial="1"/>
        </then>
      </entry>
    </events_rule>
  </rule_group>
  <items>
    <item id="0" name="item_name">
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </item>
  </items>
  <people>
    <person id="1">
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [./event/person_select/min/classification](./.__documentation__event__person_select__min__classification.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <icon/>
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
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
    <locations_markov_chain/>
  </rule_group>
  <people>
    <person id="0">
      <location x="0" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [./event/person_select/min/inventory/empty](./.__documentation__event__person_select__min__inventory__empty.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../world_step.xsd">
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
    <race_rule>
      <entry id="race">
        <icon/>
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
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
    <item_rule>
      <entry id="item">
        <name>
          <name_token prefix="item"/>
        </name>
      </entry>
      <entry id="second_item">
        <name>
          <name_token prefix="second_item"/>
        </name>
      </entry>
      <entry id="third_item">
        <name>
          <name_token prefix="third_item"/>
        </name>
      </entry>
    </item_rule>
    <events_rule>
      <entry id="event">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="3"/>
            <inventory>
              <item>
                <min initial="4"/>
              </item>
            </inventory>
          </select_person>
        </then>
      </entry>
    </events_rule>
    <locations_markov_chain/>
  </rule_group>
  <people>
    <person id="0">
      <location x="0" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [./event/person_select/min/inventory/property](./.__documentation__event__person_select__min__inventory__property.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../world_step.xsd">
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
    <race_rule>
      <entry id="race">
        <icon/>
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
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
    <item_rule>
      <entry id="item">
        <name>
          <name_token prefix="item"/>
        </name>
      </entry>
      <entry id="second_item">
        <name>
          <name_token prefix="second_item"/>
        </name>
      </entry>
      <entry id="third_item">
        <name>
          <name_token prefix="third_item"/>
        </name>
      </entry>
    </item_rule>
    <events_rule>
      <entry id="event">
        <when>
          <person_action_used action_rule_ref="action_rule"/>
        </when>
        <then>
          <select_person origin="target">
            <min initial="3"/>
            <inventory>
              <item>
                <min initial="4"/>
                <properties>
                  <property property_rule_ref="property" value="1"/>
                </properties>
              </item>
            </inventory>
          </select_person>
        </then>
      </entry>
    </events_rule>
    <locations_markov_chain/>
  </rule_group>
  <people>
    <person id="0">
      <location x="0" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [./event/person_select/min/no_people](./.__documentation__event__person_select__min__no_people.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <icon/>
      </entry>
      <entry id="second_race">
        <icon/>
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
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
    <locations_markov_chain/>
  </rule_group>
  <people>
    <person id="0">
      <location x="0" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [./event/person_select/min/property/max](./.__documentation__event__person_select__min__property__max.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../world_step.xsd">
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
        <icon/>
      </entry>
      <entry id="second_race">
        <icon/>
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
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
    <locations_markov_chain/>
  </rule_group>
  <people>
    <person id="0">
      <location x="0" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [./event/person_select/min/property/min](./.__documentation__event__person_select__min__property__min.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../world_step.xsd">
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
        <person_default initial="0">
        </person_default>
      </entry>
    </property_rule>
    <race_rule>
      <entry id="race">
        <icon/>
      </entry>
      <entry id="second_race">
        <icon/>
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
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
    <locations_markov_chain/>
  </rule_group>
  <people>
    <person id="0">
      <location x="0" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [./event/person_select/min/race](./.__documentation__event__person_select__min__race.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <icon/>
      </entry>
      <entry id="second_race">
        <icon/>
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
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
    <locations_markov_chain/>
  </rule_group>
  <people>
    <person id="0">
      <location x="0" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [./event/person_select/min/radius](./.__documentation__event__person_select__min__radius.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <icon/>
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
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
    <locations_markov_chain/>
  </rule_group>
  <people>
    <person id="0">
      <location x="0" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [./event/person_select/min/reuse_person](./.__documentation__event__person_select__min__reuse_person.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <icon/>
      </entry>
      <entry id="second_race">
        <icon/>
      </entry>
    </race_rule>
    <action_rule>
      <person_to_person id="action_rule">
        <max_range>
          <operation initial="0"/>
        </max_range>
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
    <locations_markov_chain/>
  </rule_group>
  <people>
    <person id="0">
      <location x="1" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="0">
      <do action_rule_ref="action_rule" person_ref="0"/>
    </by>
  </actions>
</world_step>
```

## [./event/person_select/property_mutation/add](./.__documentation__event__person_select__property_mutation__add.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <max_range>
          <operation initial="0"/>
        </max_range>
        <min_range>
          <operation initial="0"/>
        </min_range>
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
    <item_rule>
      <entry id="item_rule">
        <name>
          <name_token prefix="item_name"/>
        </name>
      </entry>
    </item_rule>
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
  <people>
    <person id="1">
      <location x="0" y="0"/>
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [./event/person_select/property_mutation/item](./.__documentation__event__person_select__property_mutation__item.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <max_range>
          <operation initial="0"/>
        </max_range>
        <min_range>
          <operation initial="0"/>
        </min_range>
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
    <item_rule>
      <entry id="item_rule">
        <name>
          <name_token prefix="item_name"/>
        </name>
      </entry>
    </item_rule>
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
  <people>
    <person id="1">
      <location x="0" y="0"/>
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [./event/person_select/property_mutation/modify](./.__documentation__event__person_select__property_mutation__modify.md)

#### Tags:
- person_select

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <max_range>
          <operation initial="0"/>
        </max_range>
        <min_range>
          <operation initial="0"/>
        </min_range>
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
    <item_rule>
      <entry id="item_rule">
        <name>
          <name_token prefix="item_name"/>
        </name>
      </entry>
    </item_rule>
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
  <people>
    <person id="1">
      <location x="0" y="0"/>
      <properties>
        <property property_rule_ref="property" value="1"/>
      </properties>
    </person>
  </people>
  <actions>
    <by person_ref="1">
      <do action_rule_ref="action_rule" person_ref="1" />
    </by>
  </actions>
</world_step>
```

## [./location_graph/add_classification/append_classification](./.__documentation__location_graph__add_classification__append_classification.md)

#### Tags:
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
    <location_classification_rule>
      <entry id="location_classification_rule_id"/>
      <entry id="my_classification"/>
    </location_classification_rule>
  </rule_group>
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

## [./location_graph/add_classification/empty](./.__documentation__location_graph__add_classification__empty.md)

#### Tags:
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
    <location_classification_rule>
      <entry id="location_classification_rule_id"/>
    </location_classification_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.add_classification>
      <node_graph_selection/>
      <to_be_added__classification location_classification_rule_ref="location_classification_rule_id"/>
    </location_graph.node.add_classification>
  </actions>
</world_step>
```

## [./location_graph/add_classification/location_graph_id](./.__documentation__location_graph__add_classification__location_graph_id.md)

#### Tags:
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
    <location_classification_rule>
      <entry id="location_classification_rule_id"/>
    </location_classification_rule>
  </rule_group>
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

## [./location_graph/add_classification/node_id](./.__documentation__location_graph__add_classification__node_id.md)

#### Tags:
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
    <location_classification_rule>
      <entry id="location_classification_rule_id"/>
    </location_classification_rule>
  </rule_group>
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

## [./location_graph/create_adjacent/adjacentDepthLimit_2](./.__documentation__location_graph__create_adjacent__adjacentDepthLimit_2.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="2" distance="100"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="A">
      <position x="0" y="0"/>
      <link_to node_id_ref="B"/>
    </node>
    <node node_rule_ref="node" id="B">
      <position x="100" y="0"/>
      <link_to node_id_ref="C"/>
      <link_to node_id_ref="A"/>
    </node>
    <node node_rule_ref="node" id="C">
      <position x="100" y="100"/>
      <link_to node_id_ref="D"/>
    </node>
    <node node_rule_ref="node" id="D">
      <position x="0" y="100"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="A"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/classification_location](./.__documentation__location_graph__create_adjacent__classification_location.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" angleMax="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="1"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/existing_person](./.__documentation__location_graph__create_adjacent__existing_person.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" angleMax="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="1"/>
        </link_group>
        <existing_person min="3">
          <person_selection/>
        </existing_person>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <people/>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent](./.__documentation__location_graph__create_adjacent.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/limit/batch](./.__documentation__location_graph__create_adjacent__limit__batch.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" limit="1">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/limit](./.__documentation__location_graph__create_adjacent__limit.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" limit="1">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
      <link_to node_id_ref="second_node"/>
    </node>
    <node node_rule_ref="node" id="second_node">
      <position x="100" y="0"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/limit/multipleLinkGroups](./.__documentation__location_graph__create_adjacent__limit__multipleLinkGroups.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" limit="1">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
        </link_group>
        <link_group id="second_all" angle="0" limit="1">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
      <link_to node_id_ref="second_node"/>
    </node>
    <node node_rule_ref="node" id="second_node">
      <position x="100" y="0"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/maintain_link_limits/adjacent_depth_limit](./.__documentation__location_graph__create_adjacent__maintain_link_limits__adjacent_depth_limit.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <link_group id="0" angle="0" angleMax="0" limit="1">
          <to_option node_rule_ref="city" adjacent_depth_limit="100" distance="1" maxDistance="1"/>
        </link_group>
        <link_group id="90" angle="90" angleMax="90" limit="1">
          <to_option node_rule_ref="city" adjacent_depth_limit="100" distance="1" maxDistance="1"/>
        </link_group>
      </node_rule>
      <node_rule id="plains">
        <link_group id="all" angle="0" angleMax="0" limit="10"/>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="first world">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="city" id="Capital">
      <position x="0" y="0"/>
      <link_to node_id_ref="0.0"/>
      <link_to node_id_ref="0.1"/>
      <link_to node_id_ref="0.2"/>
      <link_to node_id_ref="0.3"/>
    </node>
    <node node_rule_ref="city" id="0.0">
      <position x="1" y="0"/>
      <link_to node_id_ref="Capital"/>
      <link_to node_id_ref="0.1"/>
      <link_to node_id_ref="0.2"/>
      <link_to node_id_ref="0.3"/>
    </node>
    <node node_rule_ref="city" id="0.1">
      <position x="2" y="0"/>
      <link_to node_id_ref="0.0"/>
      <link_to node_id_ref="0.2"/>
      <link_to node_id_ref="0.3"/>
    </node>
    <node node_rule_ref="city" id="0.2">
      <position x="3" y="0"/>
      <link_to node_id_ref="0.1"/>
      <link_to node_id_ref="0.3"/>
    </node>
    <node node_rule_ref="city" id="0.3">
      <position x="4" y="0"/>
      <link_to node_id_ref="0.2"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="first world" node_id_ref="0.3"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/maintain_link_limits/angle](./.__documentation__location_graph__create_adjacent__maintain_link_limits__angle.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../world_step.xsd">
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
        <link_group id="0" angle="0" limit="1">
          <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="3"/>
        </link_group>
        <link_group id="90" angle="90" limit="1">
          <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="3"/>
        </link_group>
        <link_group id="270" angle="270" limit="1">
          <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="3"/>
        </link_group>
      </node_rule>
      <node_rule id="plains">
        <link_group id="all" angle="0" angleMax="360" limit="10">
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id" />
    <node node_rule_ref="city" id="Capital">
      <position x="0" y="0"/>
      <link_to node_id_ref="1.0"/>
      <link_to node_id_ref="1.1"/>
      <link_to node_id_ref="1.2"/>
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
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="Capital"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/maintain_link_limits/angle/no_op](./.__documentation__location_graph__create_adjacent__maintain_link_limits__angle__no_op.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../../../world_step.xsd">
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
        <link_group id="0" angle="0" limit="1">
          <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="1" adjacent_distance_max="1" adjacent_distance_min="0" />
        </link_group>
        <link_group id="90" angle="90" limit="1">
          <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="1" adjacent_distance_max="1" adjacent_distance_min="0" />
        </link_group>
      </node_rule>
      <node_rule id="plains">
        <link_group id="all" angle="0" angleMax="360" limit="10" />
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="first world">
    <rule location_graph_rule_ref="location_graph_rule_id" />
    <node node_rule_ref="city" id="Capital">
      <position x="0" y="0" />
      <link_to node_id_ref="1.0" />
      <link_to node_id_ref="1.1" />
    </node>
    <node node_rule_ref="plains" id="1.0">
      <position x="1" y="0" />
    </node>
    <node node_rule_ref="plains" id="1.1">
      <position x="0" y="1" />
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="first world" node_id_ref="Capital" />
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/maxAngle](./.__documentation__location_graph__create_adjacent__maxAngle.md)

#### Tags:
- location_graph
- location_graph.node.create_adjacent

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" angleMax="360">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="100"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [./location_graph/create_adjacent/maxDistance](./.__documentation__location_graph__create_adjacent__maxDistance.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0" maxDistance="10"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
    </node>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [./location_graph/create_location_graph](./.__documentation__location_graph__create_location_graph.md)

#### Tags:
- location_graph
- location_graph.create

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" angleMax="360">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>

  <actions>
    <location_graph.create location_graph_rule_ref="location_graph_rule_id"/>
  </actions>
</world_step>
```

## [./location_graph/create_location_graph/necesary_node](./.__documentation__location_graph__create_location_graph__necesary_node.md)

#### Tags:
- location_graph
- location_graph.create
- necessary_node

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" angleMax="360">
          <to_option node_rule_ref="node" adjacent_depth_limit="1" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>

  <actions>
    <location_graph.create location_graph_rule_ref="location_graph_rule_id"/>
  </actions>
</world_step>
```

## [./location_graph/validation/node_graph_id_ref](./.__documentation__location_graph__validation__node_graph_id_ref.md)

#### Tags:
- validation
- location_graph_id_ref

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" angleMax="360">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id"/>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="invalid_location_graph_id" node_id_ref="node_id"/>
  </actions>
</world_step>
```

## [./location_graph/validation/node_id_ref](./.__documentation__location_graph__validation__node_id_ref.md)

#### Tags:
- validation
- node_id_ref

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" angleMax="360">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id"/>
  </location_graph>
  <actions>
    <location_graph.node.create_adjacent location_graph_id_ref="location_graph_id" node_id_ref="invalid_node_id"/>
  </actions>
</world_step>
```

## [./location_graph/validation/node_rule_ref](./.__documentation__location_graph__validation__node_rule_ref.md)

#### Tags:
- validation
- node_rule_ref

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0" angleMax="360">
          <to_option node_rule_ref="other" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
</world_step>
```

## [./name_rule/name_token/one_of](./.__documentation__name_rule__name_token__one_of.md)

#### Tags:
- name_rule

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
</world_step>
```

## [./name_rule/name_token/prefix](./.__documentation__name_rule__name_token__prefix.md)

#### Tags:
- name_rule

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
</world_step>
```

## [./name_rule/name_token/recursive](./.__documentation__name_rule__name_token__recursive.md)

#### Tags:
- name_rule

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
</world_step>
```

## [./name_rule/name_token/ref](./.__documentation__name_rule__name_token__ref.md)

#### Tags:
undefined

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
</world_step>
```

## [./person/teleport_to/has_location](./.__documentation__person__teleport_to__has_location.md)

#### Tags:
- person
- person.teleport

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <people>
    <person id="person_id">
    </person>
  </people>
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
  <actions>
    <person.teleport person_id_ref="person_id">
      <location_graph location_graph_id_ref="location_graph_id" node_id_ref="second_node_id"/>
    </person.teleport>
  </actions>
</world_step>
```

## [./person/teleport_to](./.__documentation__person__teleport_to.md)

#### Tags:
- person
- person.teleport

#### Input XML
```xml
<world_step
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="../../../../../../world_step.xsd">
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
        <link_group id="all" angle="0">
          <to_option node_rule_ref="node" adjacent_depth_limit="0" distance="0"/>
        </link_group>
      </node_rule>
    </location_graph_rule>
  </rule_group>
  <people>
    <person id="person_id">
    </person>
  </people>
  <location_graph id="location_graph_id">
    <rule location_graph_rule_ref="location_graph_rule_id"/>
    <node node_rule_ref="node" id="node_id">
      <position x="0" y="0"/>
    </node>
  </location_graph>
  <actions>
    <person.teleport person_id_ref="person_id">
      <location_graph location_graph_id_ref="location_graph_id" node_id_ref="node_id"/>
    </person.teleport>
  </actions>
</world_step>
```

