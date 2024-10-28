package ro.anud.xml_xsd.implementation;

import io.opentelemetry.instrumentation.log4j.appender.v2_17.OpenTelemetryAppender;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImplementationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplementationApplication.class, args);

	}

}
