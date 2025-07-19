package ro.anud.xml_xsd.implementation.service.region;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.From.From;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.Portal;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.To.To;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.LocalLogger;

import java.util.List;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.service.region.RegionRuleChecker.sideNegation;

public class RegionInstance {
    private final WorldStepInstance worldStepInstance;
    public final RegionRepository repository = new RegionRepository();

    public RegionInstance(final WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    public Region createStartingRegion(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.Entry.Entry zoneRule) {
        var rule = worldStepInstance.ruleRepository.regionRule.getById(zoneRule.getStartingRegion().getRegionRuleRef());
        return createRegion(rule.get());
    }

    public void index() {
        var logger = LocalLogger.logEnter("RegionInstance.index");
        var data = worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamData)
            .toList();
        repository.index(data);
        logger.logReturnVoid();
    }

    public Region createRegion(Entry regionRule) {
        var logger = LocalLogger.logEnter("RegionInstance.createRegion");

        var regionId = worldStepInstance.getNextId();
        var builder = Region.builder()
            .id(regionId)
            .rule(Rule.builder()
                .ruleIdRef(regionRule.getId())
                .build())
            .limit(Limit.builder()
                .height(worldStepInstance.computeOperation(regionRule.getLimit().getHeight()).get())
                .width(worldStepInstance.computeOperation(regionRule.getLimit().getWidth()).get())
                .build())
            .position(Position.builder()
                .x(0)
                .y(0)
                .build());
        return logger.logReturn(builder.build());
    }

    public void appendTo(final Region parentRegion) {
        var logger = LocalLogger.logEnter("RegionInstance.appendFromPortal", parentRegion.getId());
        var parentZone = parentRegion.parentAsZone().get();

        var parentRegionRule = worldStepInstance.ruleRepository.regionRule.getById(parentRegion.getRule().getRuleIdRef()).get();

        var parentPortalRule = worldStepInstance.randomFrom(parentRegionRule.streamPortal())
            .get();
        var parentPortalRuleRegion = parentPortalRule.getTo().getRegion();

        var newRegionRule = worldStepInstance.ruleRepository.regionRule.getById(parentPortalRuleRegion.getRegionRuleRef()).get();

        var newRegion = createRegion(newRegionRule);

        var fromStart = worldStepInstance.computeOperation(parentPortalRule.getFrom().getStart()).get();
        var fromEnd = worldStepInstance.computeOperation(parentPortalRule.getFrom().getWidth()).get();

        var toStart = worldStepInstance.computeOperation(parentPortalRule.getTo().getRegion().getStart()).get();
        var toEnd = worldStepInstance.computeOperation(parentPortalRule.getTo().getRegion().getWidth()).get();

        var parentPortal = Portal.builder()
            .id(worldStepInstance.getNextId())
            .from(From.builder()
                .side(parentPortalRule.getFrom().getSide())
                .start(fromStart)
                .end(fromEnd)
                .build())
            .to(Optional.ofNullable(To.builder()
                .zoneRef(parentZone.getId())
                .side(parentPortalRule.getTo().getRegion().getSide())
                .regionRef(newRegion.getId())
                .start(toStart)
                .end(toStart + toEnd)
                .build()))
            .build();
        computePosition(parentPortal, parentRegion, newRegion);

        var outZone = worldStepInstance.getOutInstance().zone.repository.findById(parentZone.getId()).get();
        outZone.addRegion(newRegion);

        var outRegion = worldStepInstance.getOutInstance().region.repository.findByZoneIdAndRegionId(
            parentZone.getId(),
            parentRegion.getId());
        outRegion.get().getPortalsOrDefault().addPortal(parentPortal);
        logger.logReturnVoid("appending region", newRegion.getId(), "to parent region", parentRegion.getId());
    }


    private void computePosition(final Portal parentPortal, final Region parentRegion, final Region targetRegion) {
        var logger = LocalLogger.logEnter("RegionInstance.computePosition", parentPortal.getId(), targetRegion.getId());

        var toPortal = parentPortal.getTo().get();
        var position = targetRegion.getPosition();
        if ("right".equals(parentPortal.getFrom().getSide())) {
            position
                .setX(parentRegion.getPosition().getX() + parentRegion.getLimit().getWidth() / 2 + targetRegion.getLimit().getWidth() / 2);
        }
        if ("left".equals(parentPortal.getFrom().getSide())) {
            position
                .setX(parentRegion.getPosition().getX() - parentRegion.getLimit().getWidth() / 2 - targetRegion.getLimit().getWidth() / 2);
        }
        if ("top".equals(parentPortal.getFrom().getSide())) {
            position
                .setY(parentRegion.getPosition().getY() + parentRegion.getLimit().getHeight() / 2 + targetRegion.getLimit().getHeight() / 2);
        }
        if ("bottom".equals(parentPortal.getFrom().getSide())) {
            position
                .setY(parentRegion.getPosition().getY() - parentRegion.getLimit().getHeight() / 2 - targetRegion.getLimit().getHeight() / 2);
        }

        var fromPortalLength = Math.abs(parentPortal.getFrom().getEnd() - parentPortal.getFrom().getStart());
        var toPortalLength = Math.abs(parentPortal.getTo().map(To::getEnd).orElse(0) - parentPortal.getTo().map(To::getStart).orElse(
            0));

        var portalMin = Math.min(fromPortalLength, toPortalLength);
        var portalMax = Math.max(fromPortalLength, toPortalLength);

        var halfMax = portalMax / 2;
        var halfMin = portalMin / 2;

        var portalSizeOffset = halfMax - halfMin;

        if (List.of("left", "right").contains(parentPortal.getFrom().getSide())) {
            var parentOffset = -parentPortal.getFrom().getStart() + parentRegion.getLimit().getHeight();
            var targetOffset = -toPortal.getStart() + targetRegion.getLimit().getHeight();
            var offset = targetOffset - parentOffset;

            var finalY = offset + portalSizeOffset + parentRegion.getPosition().getX();
            position.setY(finalY);
        }


        if (List.of("top", "bottom").contains(parentPortal.getFrom().getSide())) {

            var parentOffset = -parentPortal.getFrom().getStart() + parentRegion.getLimit().getWidth();
            var targetOffset = -toPortal.getStart() + targetRegion.getLimit().getWidth();
            var offset = targetOffset - parentOffset;

            var finalX = offset + portalSizeOffset + parentRegion.getPosition().getY();

            position.setX(finalX);
        }

        logger.logReturnVoid("computed position", position.getX(), position.getY());
    }
}
