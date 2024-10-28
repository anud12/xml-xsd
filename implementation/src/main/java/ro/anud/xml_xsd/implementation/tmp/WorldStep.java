package ro.anud.xml_xsd.implementation.tmp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ro.anud.xml_xsd.implementation.util.RawNode;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
final class RuleGroup {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private final RawNode rawNode;
    private final String id;

    static public RuleGroup fromRawNode(RawNode rawNode) {
        logEnter();
        return logReturn(RuleGroup.builder()
                .rawNode(rawNode)
                .id(rawNode.getAttributeRequired("id"))
                .build()
        );
    }
}

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public final class WorldStep {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private final RawNode rawNode;
    private final RuleGroup worldMetadata;

    public static WorldStep fromRawNode(RawNode rawNode) {
        logEnter();
        var worldMetadata = RuleGroup.fromRawNode(rawNode.getChildrenFirstRequired("rule_group"));

        return logReturn(WorldStep.builder()
                .rawNode(rawNode)
                .worldMetadata(worldMetadata)
                .build()
        );
    }
}
