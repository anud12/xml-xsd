package ro.anud.xml_xsd.implementation.service.region;

import ro.anud.xml_xsd.implementation.model.Type_regionRule.Portal.Portal;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.util.LocalLogger;

import java.util.List;

public class RegionRuleChecker {

    public record PortalPair(
        ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portal.Portal fromRegion,
        Portal portalRule) {
    }

    public static String sideNegation(String side) {
        return switch (side) {
            case "top" -> "bottom";
            case "left" ->"right";
            case "bottom" -> "top";
            case "right" -> "left";
            default -> throw new IllegalStateException("Unexpected value: " + side);
        };
    }


    private static boolean sideNegation(final PortalPair portalPair) {
        var portal = portalPair.portalRule;
        return switch (portalPair.fromRegion.getFrom().getSide()) {
            case "top" -> portal.getFrom().getSide().equals("bottom");
            case "left" -> portal.getFrom().getSide().equals("right");
            case "bottom" -> portal.getFrom().getSide().equals("top");
            case "right" -> portal.getFrom().getSide().equals("left");
            default -> throw new IllegalStateException("Unexpected value: " + portalPair.fromRegion.getFrom().getSide());
        };
    }


}
