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
                .rotation("normal")
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

        //        computePosition(parentPortal, parentRegion, newRegion);

        var newPosition = Position.builder()
            .x(newRegion.getPosition().getX())
            .y(newRegion.getPosition().getY())
            .rotation(newRegion.getPosition().getRotation())
            .build();

        translateOrigin(newPosition, parentRegion);
        translateAwayBoundingBox(newPosition, parentAvailablePortal);
        translateAvailablePortalOffset(newPosition, parentAvailablePortal);
        rotateTargetPosition(newPosition, parentAvailablePortal, toRegionPortalRule);
        translateDestinationPortal(newPosition, parentRegion, parentPortal, newRegion);
        translateToBoundingBox(newPosition, parentRegion, parentPortal, newRegion);
        newRegion.setPosition(newPosition);

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

    private Position translateOrigin(final Position position, final Region parentRegion) {
        var logger = LocalLogger.logEnter("RegionInstance.translateOrigin", parentRegion.getId());

        position.setX(position.getX() + parentRegion.getPosition().getX());
        position.setY(position.getY() + parentRegion.getPosition().getY());
        return logger.logReturn(position);
    }

    private record LimitRecord(int height, int width) {}

    private LimitRecord getLimits(Region region) {
        var logger = LocalLogger.logEnter("RegionInstance.getLimits", region.getId());
        var height = switch (region.getPosition().getRotation()) {
            case "normal", "inverted" -> region.getLimit().getHeight();
            case "clockwise", "counterclockwise" -> region.getLimit().getWidth();
            default -> {
                logger.log("Unknown rotation: " + region.getPosition().getRotation());
                throw new IllegalArgumentException("Unknown rotation: " + region.getPosition().getRotation());
            }
        };

        var width = switch (region.getPosition().getRotation()) {
            case "normal", "inverted" -> region.getLimit().getWidth();
            case "clockwise", "counterclockwise" -> region.getLimit().getHeight();
            default -> {
                logger.log("Unknown rotation: " + region.getPosition().getRotation());
                throw new IllegalArgumentException("Unknown rotation: " + region.getPosition().getRotation());
            }
        };
        return logger.logReturn(new LimitRecord(height, width));
    }

    public Position translateAwayBoundingBox(
        final Position position,
        final ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.Portal.Portal portal
    ) {
        var logger = LocalLogger.logEnter("RegionInstance.translateBoundingBox", portal.getId());
        Region region = portal.parentAsAvailablePortals().flatMap(AvailablePortals::parentAsRegion)
            .get();

        var regionLimit = getLimits(region);

        var returnValue = switch (region.getPosition().getRotation()) {
            case "normal" -> switch (portal.getSide()) {
                case "bottom" -> position.setY(position.getY() - regionLimit.height / 2);
                case "left" -> position.setX(position.getX() - regionLimit.width / 2);
                case "right" -> position.setX(position.getX() + regionLimit.width / 2);
                case "top" -> position.setY(position.getY() + regionLimit.height / 2);
                default -> {
                    logger.log("Unknown portal side: " + portal.getSide());
                    throw new IllegalArgumentException("Unknown portal side: " + portal.getSide());
                }
            };
            case "clockwise" -> switch (portal.getSide()){
                case "bottom" -> position.setX(position.getX() - regionLimit.width / 2);
                case "left" -> position.setY(position.getY() + regionLimit.height / 2);
                case "right" -> position.setY(position.getY() - regionLimit.height / 2);
                case "top" -> position.setX(position.getX() + regionLimit.width / 2);
                default -> {
                    logger.log("Unknown portal side: " + portal.getSide());
                    throw new IllegalArgumentException("Unknown portal side: " + portal.getSide());
                }
            };
            default -> {
                logger.log("Unknown position rotation: " + position.getRotation());
                throw new IllegalArgumentException("Unknown position rotation: " + position.getRotation());
            }
        };
        return logger.logReturn(returnValue);
    }

    private Position translateAvailablePortalOffset(
        final Position position,
        final ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.Portal.Portal portal) {
        var logger = LocalLogger.logEnter("RegionInstance.translateAvailablePortalOffset", portal.getId());

        Region region = portal.parentAsAvailablePortals().flatMap(AvailablePortals::parentAsRegion).get();

        var portalStart = portal.getStart();

        var returnValue = switch (region.getPosition().getRotation()) {
            case "normal" -> switch (portal.getSide()) {
                case "top", "bottom" ->
                    position.setX(position.getX() + portalStart - (region.getLimit().getWidth() / 2));
                case "left", "right" ->
                    position.setY(position.getY() - portalStart + (region.getLimit().getHeight() / 2));
                default -> throw new IllegalArgumentException("Unknown portal side: " + portal.getSide());
            };
            case "clockwise" -> switch (portal.getSide()) {
                case "top", "bottom" ->
                    position.setY(position.getY() + portalStart - (region.getLimit().getHeight() / 2));
                case "left", "right" ->
                    position.setX(position.getX() - portalStart + (region.getLimit().getHeight() / 2));
                default -> throw new IllegalArgumentException("Unknown portal side: " + portal.getSide());

            };
            default -> throw new IllegalArgumentException("Unknown rotation: " + region.getPosition().getRotation());
        };
        return logger.logReturn(returnValue);
    }

    private Position translateDestinationPortal(
        final Position position,
        final Region fromRegion,
        final Portal fromPortal,
        final Region targetRegion) {
        var logger = LocalLogger.logEnter("RegionInstance.translateDestinationPortal", fromPortal.getId());

        var fromSide = fromPortal.getFrom().getSide();

        var toEnd = fromPortal.getTo().get().getEnd();
        var toStart = fromPortal.getTo().get().getStart();
        var toSide = fromPortal.getTo().get().getSide();
        var portalSize = Math.abs(toEnd) - Math.abs(toStart);
        Position returnValue = switch (fromRegion.getPosition().getRotation()) {
            case "normal" -> switch (fromSide) {
                case "bottom" -> switch (toSide) {
                    case "bottom" ->
                        position.setX(position.getX() + toStart - (portalSize) - (targetRegion.getLimit().getHeight() / 2));
                    case "left" ->
                        position.setX(position.getX() + toStart + portalSize - (targetRegion.getLimit().getHeight() / 2));
                    case "right" ->
                        position.setX(position.getX() - toStart - (portalSize - 1) + (targetRegion.getLimit().getHeight() / 2));
                    case "top" ->
                        position.setX(position.getX() + toStart + (portalSize + 1) - (targetRegion.getLimit().getHeight() / 2));
                    default -> throw new IllegalArgumentException("Unknown fromPortal toSide: " + toSide);
                };
                case "left" -> switch (toSide) {
                    case "bottom" ->
                        position.setY(position.getY() - toStart - portalSize + (targetRegion.getLimit().getWidth() / 2));
                    case "left" ->
                        position.setY(position.getY() - toStart - portalSize + (targetRegion.getLimit().getHeight() / 2));
                    case "right" ->
                        position.setY(position.getY() + toStart - (portalSize - 1) - (targetRegion.getLimit().getHeight() / 2));
                    case "top" ->
                        position.setY(position.getY() + toStart - (portalSize - 1) - (targetRegion.getLimit().getWidth() / 2));
                    default -> throw new IllegalArgumentException("Unknown fromPortal toSide: " + toSide);
                };
                case "right" -> switch (toSide) {
                    case "bottom" ->
                        position.setY(position.getY() - toStart - (portalSize + 1) + (targetRegion.getLimit().getWidth() / 2));
                    case "left" ->
                        position.setY(position.getY() + toStart - (portalSize - 1) - (targetRegion.getLimit().getHeight() / 2));
                    case "right" ->
                        position.setY(position.getY() - toStart - portalSize + (targetRegion.getLimit().getHeight() / 2));
                    case "top" ->
                        position.setY(position.getY() + toStart - (portalSize) + (targetRegion.getLimit().getWidth() / 2));
                    default -> throw new IllegalArgumentException("Unknown fromPortal toSide: " + toSide);
                };
                case "top" -> switch (toSide) {
                    case "bottom" ->
                        position.setX(position.getX() + toStart - (portalSize - 1) - (targetRegion.getLimit().getHeight() / 2));
                    case "left" ->
                        position.setX(position.getX() - toStart - (portalSize + 1) + (targetRegion.getLimit().getWidth() / 2));
                    case "right" ->
                        position.setX(position.getX() - toStart - portalSize + (targetRegion.getLimit().getHeight() / 2));
                    case "top" ->
                        position.setX(position.getX() + toStart + portalSize - (targetRegion.getLimit().getWidth() / 2));
                    default -> throw new IllegalArgumentException("Unknown fromPortal toSide: " + toSide);
                };
                default -> throw new IllegalArgumentException("Unknown fromPortal fromSide: " + fromSide);
            };
            case "clockwise" -> switch (fromSide) {
                case "bottom" -> switch (toSide) {
                    case "bottom" ->
                        position.setY(position.getY() + toStart - (portalSize) - (targetRegion.getLimit().getHeight() / 2));
                    case "left" ->
                        position.setY(position.getY() - toStart - (portalSize) + (targetRegion.getLimit().getHeight() / 2));
                    case "right" ->
                        position.setY(position.getY() + toStart - (portalSize - 1) - (targetRegion.getLimit().getHeight() / 2));
                    case "top" ->
                        position.setY(position.getY() - toStart - (portalSize + 1) + (targetRegion.getLimit().getHeight() / 2));
                    default -> throw new IllegalArgumentException("Unknown fromPortal toSide: " + toSide);
                };
                case "left" -> switch (toSide) {
                    case "bottom" ->
                        position.setX(position.getX() - toStart - portalSize + (targetRegion.getLimit().getWidth() / 2));
                    case "left" ->
                        position.setX(position.getX() - toStart - portalSize + (targetRegion.getLimit().getHeight() / 2));
                    case "right" ->
                        position.setX(position.getX() + toStart - (portalSize - 1) - (targetRegion.getLimit().getHeight() / 2));
                    case "top" ->
                        position.setX(position.getX() + toStart - (portalSize - 1) - (targetRegion.getLimit().getWidth() / 2));
                    default -> throw new IllegalArgumentException("Unknown fromPortal toSide: " + toSide);
                };
                case "right" -> switch (toSide) {
                    case "bottom" ->
                        position.setX(position.getX() + toStart - (portalSize - 1) - (targetRegion.getLimit().getWidth() / 2));
                    case "left" ->
                        position.setX(position.getX() + toStart - (portalSize - 1) - (targetRegion.getLimit().getHeight() / 2));
                    case "right" ->
                        position.setX(position.getX() - toStart - portalSize + (targetRegion.getLimit().getHeight() / 2));
                    case "top" ->
                        position.setX(position.getX() - toStart - portalSize + (targetRegion.getLimit().getWidth() / 2));
                    default -> throw new IllegalArgumentException("Unknown fromPortal toSide: " + toSide);
                };
                case "top" -> switch (toSide) {
                    case "bottom" ->
                        position.setY(position.getY() + toStart - (portalSize - 1) - (targetRegion.getLimit().getHeight() / 2));
                    case "left" ->
                        position.setY(position.getY() + toStart - (portalSize - 1) - (targetRegion.getLimit().getHeight() / 2));
                    case "right" ->
                        position.setY(position.getY() - toStart - (portalSize) + (targetRegion.getLimit().getHeight() / 2));
                    case "top" ->
                        position.setY(position.getY() + toStart - (portalSize) - (targetRegion.getLimit().getHeight() / 2));
                    default -> throw new IllegalArgumentException("Unknown fromPortal toSide: " + toSide);
                };
                default -> throw new IllegalArgumentException("Unknown fromPortal fromSide: " + fromSide);
            };
            default -> throw new IllegalArgumentException("Unknown position rotation: " + fromRegion.getPosition().getRotation());
        };
        return logger.logReturn(returnValue);
    }


    public Position translateToBoundingBox(
        final Position position,
        final Region fromRegion,
        final Portal parentPortal,
        final Region region) {
        var logger = LocalLogger.logEnter(
            "RegionInstance.translateToBoundingBox",
            parentPortal.getId(),
            region.getId());

        var toSide = parentPortal.getTo().get().getSide();
        var fromSide = parentPortal.getFrom().getSide();

        var returnValue = switch (fromRegion.getPosition().getRotation()) {
            case "normal" -> switch (fromSide) {
                case "bottom" -> switch (toSide) {
                    case "bottom" -> position.setY(position.getY() - (region.getLimit().getHeight() / 2));
                    case "left" -> position.setY(position.getY() - (region.getLimit().getWidth() / 2));
                    case "top" -> position.setY(position.getY() - (region.getLimit().getHeight() / 2));
                    case "right" -> position.setY(position.getY() - (region.getLimit().getWidth() / 2));
                    default -> throw new IllegalArgumentException("Unknown parentPortal toSide: " + toSide);
                };
                case "left" -> switch (toSide) {
                    case "bottom" -> position.setX(position.getX() - (region.getLimit().getHeight() / 2));
                    case "left" -> position.setX(position.getX() - (region.getLimit().getWidth() / 2));
                    case "right" -> position.setX(position.getX() - (region.getLimit().getWidth() / 2));
                    case "top" -> position.setX(position.getX() - (region.getLimit().getHeight() / 2));
                    default -> throw new IllegalArgumentException("Unknown parentPortal toSide: " + toSide);
                };
                case "right" -> switch (toSide) {
                    case "bottom" -> position.setX(position.getX() + (region.getLimit().getHeight() / 2));
                    case "left" -> position.setX(position.getX() + (region.getLimit().getWidth() / 2));
                    case "right" -> position.setX(position.getX() + (region.getLimit().getWidth() / 2));
                    case "top" -> position.setX(position.getX() - (region.getLimit().getHeight() / 2));
                    default -> throw new IllegalArgumentException("Unknown parentPortal toSide: " + toSide);
                };
                case "top" -> switch (toSide) {
                    case "bottom" -> position.setY(position.getY() + (region.getLimit().getHeight() / 2));
                    case "left" -> position.setY(position.getY() + (region.getLimit().getWidth() / 2));
                    case "top" -> position.setY(position.getY() + (region.getLimit().getHeight() / 2));
                    case "right" -> position.setY(position.getY() + (region.getLimit().getWidth() / 2));
                    default -> throw new IllegalArgumentException("Unknown parentPortal toSide: " + toSide);
                };
                default -> throw new IllegalArgumentException("Unknown parentPortal fromSide: " + fromSide);
            };
            case "clockwise" -> switch (fromSide) {
                case "bottom" -> switch (toSide) {
                    case "bottom" -> position.setX(position.getX() - (region.getLimit().getHeight() / 2));
                    case "left" -> position.setX(position.getX() - (region.getLimit().getWidth() / 2));
                    case "right" -> position.setX(position.getX() - (region.getLimit().getWidth() / 2));
                    case "top" -> position.setX(position.getX() - (region.getLimit().getHeight() / 2));
                    default -> throw new IllegalArgumentException("Unknown parentPortal toSide: " + toSide);
                };
                case "left" -> switch (toSide) {
                    case "bottom" -> position.setY(position.getY() + (region.getLimit().getHeight() / 2));
                    case "left" -> position.setY(position.getY() + (region.getLimit().getWidth() / 2));
                    case "right" -> position.setY(position.getY() + (region.getLimit().getWidth() / 2));
                    case "top" -> position.setY(position.getY() + (region.getLimit().getHeight() / 2));
                    default -> throw new IllegalArgumentException("Unknown parentPortal toSide: " + toSide);
                };
                case "right" -> switch (toSide) {
                    case "bottom" -> position.setY(position.getY() - (region.getLimit().getHeight() / 2));
                    case "left" -> position.setY(position.getY() - (region.getLimit().getWidth() / 2));
                    case "right" -> position.setY(position.getY() - (region.getLimit().getWidth() / 2));
                    case "top" -> position.setY(position.getY() - (region.getLimit().getHeight() / 2));
                    default -> throw new IllegalArgumentException("Unknown parentPortal toSide: " + toSide);
                };
                case "top" -> switch (toSide) {
                    case "bottom" -> position.setX(position.getX() + (region.getLimit().getHeight() / 2));
                    case "left" -> position.setX(position.getX() + (region.getLimit().getWidth() / 2));
                    case "right" -> position.setX(position.getX() + (region.getLimit().getWidth() / 2));
                    case "top" -> position.setX(position.getX() + (region.getLimit().getHeight() / 2));
                    default -> throw new IllegalArgumentException("Unknown parentPortal toSide: " + toSide);
                };
                default -> throw new IllegalArgumentException("Unknown parentPortal fromSide: " + fromSide);
            };
            default -> throw new IllegalArgumentException("Unknown position rotation: " + fromRegion.getPosition().getRotation());
        };

        return logger.logReturn(returnValue);
    }


    private Position rotateTargetPosition(
        final Position position,
        final ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.AvailablePortals.Portal.Portal availablePortal,
        final ro.anud.xml_xsd.implementation.model.Type_regionRule.Portals.Portal.Portal toPortalRule) {
        var logger = LocalLogger.logEnter(
            "RegionInstance.rotateTargetPosition",
            availablePortal.getId(),
            toPortalRule.getPortalRuleRef());

        Region fromRegion = availablePortal.parentAsAvailablePortals().flatMap(AvailablePortals::parentAsRegion).get();


        var returnValue = switch (fromRegion.getPosition().getRotation()) {
            case "normal" -> switch (availablePortal.getSide()) {
                case "bottom" -> switch (toPortalRule.getSide()) {
                    case "bottom" -> position.setRotation("inverted");
                    case "left" -> position.setRotation("clockwise");
                    case "right" -> position.setRotation("counterclockwise");
                    case "top" -> position.setRotation("normal");
                    default ->
                        throw new IllegalArgumentException("Unknown toPortalRule side: " + toPortalRule.getSide());
                };
                case "left" -> switch (toPortalRule.getSide()) {
                    case "bottom" -> position.setRotation("counterclockwise");
                    case "left" -> position.setRotation("inverted");
                    case "right" -> position.setRotation("normal");
                    case "top" -> position.setRotation("clockwise");
                    default ->
                        throw new IllegalArgumentException("Unknown toPortalRule side: " + toPortalRule.getSide());
                };
                case "right" -> switch (toPortalRule.getSide()) {
                    case "bottom" -> position.setRotation("clockwise");
                    case "left" -> position.setRotation("normal");
                    case "right" -> position.setRotation("inverted");
                    case "top" -> position.setRotation("counterclockwise");
                    default ->
                        throw new IllegalArgumentException("Unknown toPortalRule side: " + toPortalRule.getSide());
                };
                case "top" -> switch (toPortalRule.getSide()) {
                    case "bottom" -> position.setRotation("normal");
                    case "left" -> position.setRotation("counterclockwise");
                    case "right" -> position.setRotation("clockwise");
                    case "top" -> position.setRotation("inverted");
                    default ->
                        throw new IllegalArgumentException("Unknown toPortalRule side: " + toPortalRule.getSide());
                };
                default ->
                    throw new IllegalArgumentException("Unknown available toPortalRule side: " + availablePortal.getSide());
            };
            case "clockwise" -> switch (availablePortal.getSide()) {
                case "bottom" -> switch (toPortalRule.getSide()) {
                    case "bottom" -> position.setRotation("counterclockwise");
                    case "left" -> position.setRotation("inverted");
                    case "right" -> position.setRotation("normal");
                    case "top" -> position.setRotation("clockwise");
                    default ->
                        throw new IllegalArgumentException("Unknown toPortalRule side: " + toPortalRule.getSide());
                };
                case "left" -> switch (toPortalRule.getSide()) {
                    case "bottom" -> position.setRotation("normal");
                    case "left" -> position.setRotation("counterclockwise");
                    case "right" -> position.setRotation("clockwise");
                    case "top" -> position.setRotation("inverted");
                    default ->
                        throw new IllegalArgumentException("Unknown toPortalRule side: " + toPortalRule.getSide());
                };
                case "right" -> switch (toPortalRule.getSide()) {
                    case "bottom" -> position.setRotation("inverted");
                    case "left" -> position.setRotation("clockwise");
                    case "right" -> position.setRotation("counterclockwise");
                    case "top" -> position.setRotation("normal");
                    default -> throw new IllegalArgumentException("Unknown toPortalRule side: " + toPortalRule.getSide());
                };
                case "top" ->  switch (toPortalRule.getSide()) {
                    case "bottom" -> position.setRotation("counterclockwise");
                    default -> throw new IllegalArgumentException("Unknown toPortalRule side: " + toPortalRule.getSide());
                };
                default ->
                    throw new IllegalArgumentException("Unknown available toPortalRule side: " + availablePortal.getSide());
            };
            default -> {
                logger.log("Unknown position rotation: " + position.getRotation());
                throw new IllegalArgumentException("Unknown position rotation: " + position.getRotation());
            }
        };

        return logger.logReturn(returnValue);
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
            var parentOffset = parentPortal.getFrom().getStart();
            var targetOffset = -toPortal.getStart() + (targetRegion.getLimit().getHeight() / 2);
            var offset = targetOffset + parentOffset;

            var parentPosition = parentRegion.getPosition().getY() - (parentRegion.getLimit().getHeight() / 2);


            var finalY = offset + portalSizeOffset + parentPosition;
            position.setY(finalY);
        }


        if (List.of("top", "bottom").contains(parentPortal.getFrom().getSide())) {

            var parentOffset = parentPortal.getFrom().getStart();
            var targetOffset = -toPortal.getStart() + (targetRegion.getLimit().getWidth() / 2);
            var offset = targetOffset + parentOffset;

            var parentPosition = parentRegion.getPosition().getX() - (parentRegion.getLimit().getWidth() / 2);

            var finalX = offset + portalSizeOffset + parentPosition;

            position.setX(finalX);
        }

        logger.logReturnVoid("computed position", position.getX(), position.getY());
    }
}
