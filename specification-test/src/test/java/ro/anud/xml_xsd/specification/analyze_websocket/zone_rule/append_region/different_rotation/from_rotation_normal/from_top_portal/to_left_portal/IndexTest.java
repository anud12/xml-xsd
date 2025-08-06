package ro.anud.xml_xsd.specification.analyze_websocket.zone_rule.append_region.different_rotation.from_rotation_normal.from_top_portal.to_left_portal;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
#Append region from top portal to target left portal
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
y = y + (FromHeight / 2)
y = y + (10 / 2)
x:100,y:1000 -> x:100,y:1003
```

* translate available portal
```
x = x + FromPortalStart + (OriginRegionWidth / 2)
x = x + 3 + 5
x:100,y:1003 -> x:98,y:1003
```

* rotate target position
```
From top to left = "counterclockwise"
```

* translate destination portal
```
x = x - ToPortalStart - (portalSize + 1) + (NewRegionWidth / 2)
x = x - 1 + 2 - 5
 x:98,y:1003 ->  x:100,y:1003
```

* translate To Bonding Box
```
y = y + (ToWidth / 2)
y = y + (10 / 2)
 x:100,y:1003 -> 100:1008
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
