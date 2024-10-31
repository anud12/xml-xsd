package ro.anud.xml_xsd.implementation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

@RestController()
public class HealthController {

    @GetMapping("/health")
    public String health() {
        logEnter("Health ok");
        return "Ok";
    }
}
