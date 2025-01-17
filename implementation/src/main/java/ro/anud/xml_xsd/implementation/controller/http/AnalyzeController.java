package ro.anud.xml_xsd.implementation.controller.http;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ro.anud.xml_xsd.implementation.middleware.EventsMetadata;
import ro.anud.xml_xsd.implementation.middleware.PersonAssignClassification;
import ro.anud.xml_xsd.implementation.middleware.action.FromPersonAction;
import ro.anud.xml_xsd.implementation.middleware.action.PersonCreateAction;
import ro.anud.xml_xsd.implementation.middleware.locationGraph.LocationGraphAddClassification;
import ro.anud.xml_xsd.implementation.middleware.locationGraph.LocationGraphCreate;
import ro.anud.xml_xsd.implementation.middleware.locationGraph.LocationGraphCreateAdjacent;
import ro.anud.xml_xsd.implementation.middleware.person.PersonMoveTo;
import ro.anud.xml_xsd.implementation.middleware.person.PersonTeleportTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.InstanceTypeEnum;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.RawNode;
import ro.anud.xml_xsd.implementation.validator.AtrributeValidator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

@RestController()
@AllArgsConstructor
@RequestMapping("/analyze")
public class AnalyzeController {

    @PostMapping("/execute/name_rule/{nameRule}")
    public ResponseEntity<String> executeNameRule(
        @RequestBody String request,
        @PathVariable String nameRule) throws ParserConfigurationException, IOException, SAXException {
        var logger = logEnter();
        var worldStepInstance = buildWorldStepInstance(request);
        var result = worldStepInstance.name.calculateNameFromRefString(nameRule);
        logger.log("result", result);
        return ResponseEntity.of(result);
    }

    @PostMapping("/execute")
    public ResponseEntity<String> execute(@RequestBody String request) {
        var logger = logEnter("");
        try {
            var worldStepInstance = buildWorldStepInstance(request);
            logger.log("validating");
            var validationResult = new AtrributeValidator()
                .validate(worldStepInstance.getWorldStep());
            if (!validationResult.isEmpty()) {
                logger.log("validation failed");
                return ResponseEntity.status(400).body(validationResult.stream()
                    .map(invalidAttribute -> {
                        var allowedValues = String.join(", ", invalidAttribute.allowedValues());
                        return "ValidationError: " + invalidAttribute.value() + " at " + invalidAttribute.path() + " not in [" + allowedValues + "]";
                    })
                    .collect(Collectors.joining("\n"))
                );
            }
            logger.log("validating done");

            FromPersonAction.apply(worldStepInstance);
            PersonCreateAction.personCreateAction(worldStepInstance);
            LocationGraphCreate.apply(worldStepInstance);
            LocationGraphCreateAdjacent.apply(worldStepInstance);
            PersonMoveTo.apply(worldStepInstance);
            PersonTeleportTo.apply(worldStepInstance);
            EventsMetadata.apply(worldStepInstance);
            LocationGraphAddClassification.locationGraphAddClassification(worldStepInstance);
            PersonAssignClassification.apply(worldStepInstance);

            return ResponseEntity.ok(serializeWorldStepInstance(worldStepInstance.getOutInstance()).orElse(""));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(Arrays.stream(e.getStackTrace()).toList().toString());
        }
        //        return ResponseEntity.ok(request);
    }

    public static WorldStep buildWorldStep(String string) throws SAXException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(string)));
            var rawNode = RawNode.fromNode(document.getDocumentElement());
            return WorldStep.fromRawNode(rawNode);
        } catch (ParserConfigurationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static WorldStepInstance buildWorldStepInstance(String string) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(string)));
        var rawNode = RawNode.fromNode(document.getDocumentElement());

        var worldStepInstance = new WorldStepInstance().setWorldStep(WorldStep.fromRawNode(rawNode));
        worldStepInstance.instance = InstanceTypeEnum.FIRST;
        var outWorldStepInstance = new WorldStepInstance().setWorldStep(WorldStep.fromRawNode(rawNode));
        outWorldStepInstance.instance = InstanceTypeEnum.SECOND;
        worldStepInstance.setOutInstance(outWorldStepInstance);
        outWorldStepInstance.setOutInstance(worldStepInstance);
        return worldStepInstance;
    }

    public static Optional<String> serializeWorldStepInstance(WorldStepInstance worldStepInstance) throws TransformerException {
        worldStepInstance.getWorldStep()
            .flatMap(WorldStep::getWorldMetadata)
            .ifPresent(worldMetadata -> worldStepInstance
                .getOutInstance()
                .getWorldStep()
                .flatMap(WorldStep::getWorldMetadata)
                .map(WorldMetadata::getCounter)
                .ifPresent(worldMetadata::setCounter)
            );
        var outputDocument = worldStepInstance.offsetRandomizationTable()
            .getWorldStep()
            .map(worldStep -> {
                try {
                    return worldStep.serializeIntoRawNode().toDocument("world_step");
                } catch (ParserConfigurationException e) {
                    throw new RuntimeException(e);
                }
            });

        if(outputDocument.isEmpty()) {
            return Optional.empty();
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(outputDocument.get()), new StreamResult(writer));
        return Optional.of(writer.getBuffer().toString());
    }
}
