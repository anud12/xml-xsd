package ro.anud.xml_xsd.specification.analyze_websocket.zone_rule.append_region.different_rotation.from_rotation_normal.from_left_portal.to_bottom_portal;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
#Append region from left portal to target bottom portal
##When
- an append region rule is applied to a zone
##It should
it should append a region to the zone at the position
`X:92 y:1003`


Due to:
* translate origin
```
x:0,y:0 -> x:100,y:1000
```

* translate bounding box
```
x = x - (FromWidth / 2)
x = x - (10 / 2)
x:100,y:1000 -> x:95,y:1000
```

* translate available portal
```
y = y - FromPortalStart + (OriginRegionHeight / 2)
y = y - 1 + 3
x:95,y:1000 -> x:95,y:1002
```

* rotate target position
```
From left to top = "clockwise"
```

* translate destination portal
```
y = y - ToPortalStart - portalSize + (NewRegionWidth / 2)
y = y + 3 - 3
 x:95,y:1002 ->  x:95,y:1002
```

* translate To Bonding Box
```
x = x - (ToWidth / 2)
x = x - (6 / 2)
 x:95,y:1002 -> 92:1002
```
 */

/*tags
- zone
- region
- creation
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
