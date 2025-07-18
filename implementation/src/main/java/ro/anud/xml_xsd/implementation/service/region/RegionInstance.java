package ro.anud.xml_xsd.implementation.service.region;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Limit.Limit;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.From.From;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.Portal;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.To.To;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.ToRule.ToRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Position.Position;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Rule.Rule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
        var data = worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamData)
            .toList();
        repository.index(data);
    }

    public Region createRegion(Entry regionRule) {

        var regionId = worldStepInstance.getNextId();
        var portals = regionRule.streamPortal()
            .map(portal -> {
                return Portal
                    .builder()
                    .id(worldStepInstance.getNextId())
                    .from(From.builder()
                        .end(worldStepInstance.computeOperation(portal.getFrom().getWidth()).get())
                        .side(portal.getFrom().getSide())
                        .start(worldStepInstance.computeOperation(portal.getFrom().getPosition()).get())
                        .build())
                    .toRule(Optional.of(ToRule.builder()
                        .region(portal.getTo().streamRegion()
                            .map(region -> ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.ToRule.Region.Region.builder()
                                .regionRuleRef(region.getRegionRuleRef())
                                .end(region.getWidth())
                                .start(region.getPosition())
                                .side(region.getSide())

                                .build())
                            .toList())
                        .build()))
                    .build();
            })
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
        if(!portals.isEmpty()) {
            builder.portals(Optional.of(Portals.builder().portal(portals).build()));
        }
        return builder
            .build();
    }

    public void appendFromPortal(final Portal parentPortal) {
        var parentRegion = parentPortal.parentAsPortals()
            .flatMap(Portals::parentAsRegion)
            .get();
        var parentZone = parentRegion.parentAsZone().get();
        var toRegionRule = worldStepInstance.randomFrom(parentPortal.getToRule().get().getRegion()).get();
        var newRegion = createRegion(worldStepInstance.ruleRepository.regionRule.getById(toRegionRule.getRegionRuleRef()).get());

        var outParentRegion = worldStepInstance.getOutInstance().region.repository.findByZoneIdAndRegionId(
            parentZone.getId(),
            parentRegion.getId()).get();
        var outPortal = outParentRegion.streamPortals()
            .flatMap(Portals::streamPortal)
            .filter(portal -> portal.getId().equals(parentPortal.getId()))
            .findFirst()
            .get();


        outPortal.getToRule().ifPresent(ToRule::removeFromParent);
        outPortal.setTo(To.builder()
            .zoneRef(parentZone.getId())
            .side(toRegionRule.getSide())
            .start(worldStepInstance.computeOperation(toRegionRule.getStart()).get())
            .end(Optional.of(worldStepInstance.computeOperation(toRegionRule.getEnd()).get()))
            .regionRef(newRegion.getId())
            .build()
        );
        computePosition(outPortal, parentRegion, newRegion);

        var outZone = worldStepInstance.getOutInstance().zone.repository.findById(parentZone.getId()).get();
        outZone.addRegion(newRegion);
    }

    private void computePosition(final Portal parentPortal, final Region parentRegion, final Region targetRegion) {

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

        if (List.of("left", "right").contains(parentPortal.getFrom().getSide())) {
            var parentOffset = - parentPortal.getFrom().getStart() + parentRegion.getLimit().getHeight();
            var targetOffset = - toPortal.getStart() + targetRegion.getLimit().getHeight();
            var offset = targetOffset - parentOffset;

            var fromPortalLength = Math.abs(parentPortal.getFrom().getEnd() - parentPortal.getFrom().getStart());
            var toPortalLength = Math.abs(parentPortal.getTo().flatMap(To::getEnd).orElse(0) - parentPortal.getTo().map(To::getStart).orElse(0));

            var portalMin = Math.min(fromPortalLength, toPortalLength);
            var portalMax = Math.max(fromPortalLength, toPortalLength);

            var halfMax = portalMax / 2;
            var halfMin = portalMin / 2;

            var portalSizeOffset = halfMax - halfMin;


            var finalX = offset + portalSizeOffset + parentRegion.getPosition().getX();
            position.setY(finalX);
        }


        if (List.of("top", "bottom").contains(parentPortal.getFrom().getSide())) {

            var parentOffset = - parentPortal.getFrom().getStart() + parentRegion.getLimit().getWidth();
            var targetOffset = - toPortal.getStart() + targetRegion.getLimit().getWidth();
            var offset = targetOffset - parentOffset;

            var fromPortalLength = Math.abs(parentPortal.getFrom().getEnd() - parentPortal.getFrom().getStart());
            var toPortalLength = Math.abs(parentPortal.getTo().flatMap(To::getEnd).orElse(0) - parentPortal.getTo().map(To::getStart).orElse(0));

            var portalMin = Math.min(fromPortalLength, toPortalLength);
            var portalMax = Math.max(fromPortalLength, toPortalLength);

            var halfMax = portalMax / 2;
            var halfMin = portalMin / 2;

            var portalSizeOffset = halfMax - halfMin;


            var finalX = offset + portalSizeOffset + parentRegion.getPosition().getY();
            position.setX(finalX);
        }
    }
}
