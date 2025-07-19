package ro.anud.xml_xsd.implementation.service.region;

public class RegionRuleChecker {

    public static String sideNegation(String side) {
        return switch (side) {
            case "top" -> "bottom";
            case "left" ->"right";
            case "bottom" -> "top";
            case "right" -> "left";
            default -> throw new IllegalStateException("Unexpected value: " + side);
        };
    }
}
