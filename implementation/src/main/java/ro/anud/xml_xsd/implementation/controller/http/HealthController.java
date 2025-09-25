package ro.anud.xml_xsd.implementation.controller.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@RestController()
public class HealthController {

    @GetMapping("/health")
    public String health() {
        try (var scope = logScope()) {
            return scope.logReturn("Ok");
        }

    }
}
