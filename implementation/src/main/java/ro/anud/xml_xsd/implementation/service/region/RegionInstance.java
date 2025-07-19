package ro.anud.xml_xsd.implementation.service.region;

import ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portals;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.AvailablePortals;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.From.From;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.Portal;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.To.To;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.LocalLogger;

import java.util.List;
import java.util.Optional;

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

        List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.Portal.Portal> portals = regionRule.streamPortals()
            .flatMap(Portals::streamPortal)
            .map(portal -> ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.Portal.Portal.builder()
                .id(worldStepInstance.getNextId())
                .side(portal.getSide())
                .start(worldStepInstance.computeOperation(portal.getStart()).get())
                .portalRuleRef(portal.getPortalRuleRef())
                .build())
            .toList();

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
        if (!portals.isEmpty()) {
            builder.availablePortals(Optional.of(
                    AvailablePortals.builder()
                        .portal(portals)
                        .build()
                )
            );
        }
        return logger.logReturn(builder.build());
    }

    public void appendTo(final Region parentRegion) {
        var logger = LocalLogger.logEnter("RegionInstance.appendFromPortal", parentRegion.getId());
        var parentZone = parentRegion.parentAsZone().get();

        var parentRegionRule = worldStepInstance.ruleRepository.regionRule.getById(parentRegion.getRule().getRuleIdRef()).get();

        var parentAvailablePortal = worldStepInstance.randomFrom(parentRegion.streamAvailablePortals().flatMap(
                AvailablePortals::streamPortal).toList())
            .get();
        var parentPortalRule = worldStepInstance.ruleRepository.portalRule.getById(parentAvailablePortal.getPortalRuleRef()).get();

        var parentPortalRuleRegion = worldStepInstance.randomFrom(parentPortalRule.getTo().getRegion()).get();

        var newRegionRule = worldStepInstance.ruleRepository.regionRule.getById(parentPortalRuleRegion.getRegionRuleRef()).get();

        var newRegion = createRegion(newRegionRule);

        ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal toRegionPortalRule = worldStepInstance.randomFrom(
            newRegionRule.streamPortals()
                .flatMap(Portals::streamPortal)
                .toList()
        ).get();

        var portalWidth = parentPortalRule.getLimit().getWidth();

        var fromStart = parentAvailablePortal.getStart();
        var fromEnd = fromStart + portalWidth;

        var toStart = worldStepInstance.computeOperation(toRegionPortalRule.getStart()).get();

        var parentPortal = Portal.builder()
            .id(worldStepInstance.getNextId())
            .from(From.builder()
                .side(parentAvailablePortal.getSide())
                .start(fromStart)
                .end(fromEnd)
                .build())
            .to(Optional.ofNullable(To.builder()
                .zoneRef(parentZone.getId())
                .side(toRegionPortalRule.getSide())
                .regionRef(newRegion.getId())
                .start(toStart)
                .end(toStart + portalWidth)
                .build()))
            .build();
        computePosition(parentPortal, parentRegion, newRegion);

        var outZone = worldStepInstance.getOutInstance().zone.repository.findById(parentZone.getId()).get();
        outZone.addRegion(newRegion);

        var outRegion = worldStepInstance.getOutInstance().region.repository.findByZoneIdAndRegionId(
            parentZone.getId(),
            parentRegion.getId());

        outRegion.get().getPortalsOrDefault().addPortal(parentPortal);
        outRegion.get().streamAvailablePortals()
            .flatMap(AvailablePortals::streamPortal)
            .filter(portal -> portal.getId().equals(parentAvailablePortal.getId()))
            .findFirst()
            .ifPresent(ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.Portal.Portal::removeFromParent);

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
