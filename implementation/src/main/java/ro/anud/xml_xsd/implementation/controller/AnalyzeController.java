package ro.anud.xml_xsd.implementation.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ro.anud.xml_xsd.implementation.middleware.PersonAssignClassification;
import ro.anud.xml_xsd.implementation.middleware.action.FromPersonAction;
import ro.anud.xml_xsd.implementation.middleware.action.PersonCreateAction;
import ro.anud.xml_xsd.implementation.middleware.locationGraph.LocationGraphAddClassification;
import ro.anud.xml_xsd.implementation.middleware.locationGraph.LocationGraphCreate;
import ro.anud.xml_xsd.implementation.middleware.locationGraph.LocationGraphCreateAdjacent;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.InstanceTypeEnum;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.RawNode;
import ro.anud.xml_xsd.implementation.validator.AtrributeValidator;
import ro.anud.xml_xsd.implementation.validator.attributeValidator.LocationGraphIdRefValidator;

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
        var worldStepInstance = buildInstance(request);
        var result = worldStepInstance.name.calculateNameFromRefString(nameRule);
        logger.log("result", result);
        return ResponseEntity.of(result);
    }

    @PostMapping("/execute")
    public ResponseEntity<String> execute(@RequestBody String request) {
        var logger = logEnter("");
        try {
            var worldStepInstance = buildInstance(request);
            var validationResult = new AtrributeValidator()
                .validate(worldStepInstance.getWorldStep());
            if (!validationResult.isEmpty()) {
                return ResponseEntity.status(400).body(validationResult.stream()
                    .map(invalidAttribute -> {
                        var allowedValues = String.join(", ", invalidAttribute.allowedValues());
                        return "ValidationError: " + invalidAttribute.value() + " at " + invalidAttribute.path() + " not in [" + allowedValues + "]";
                    })
                    .collect(Collectors.joining("\n"))
                );
            }

            FromPersonAction.apply(worldStepInstance);
            PersonCreateAction.apply(worldStepInstance);
            LocationGraphCreate.apply(worldStepInstance);
            LocationGraphCreateAdjacent.apply(worldStepInstance);
            LocationGraphAddClassification.apply(worldStepInstance);
            PersonAssignClassification.apply(worldStepInstance);

            logger.logTodo("make creating person use out instance");
            //            outWorldStepInstance.getWorldStep().getWorldMetadata().getCounter().setValue(
            //                outWorldStepInstance.getWorldStep().getWorldMetadata().getCounter().getValue() +
            //                    worldStepInstance.getWorldStep().getWorldMetadata().getCounter().getValue()
            //            );
            return ResponseEntity.ok(serializeWorldStepInstance(worldStepInstance));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(Arrays.stream(e.getStackTrace()).toList().toString());
        }
        //        return ResponseEntity.ok(request);
    }

    private WorldStepInstance buildInstance(String string) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(string)));
        var rawNode = RawNode.fromNode(document.getDocumentElement());

        var worldStepInstance = new WorldStepInstance(WorldStep.fromRawNode(rawNode));
        worldStepInstance.instance = InstanceTypeEnum.FIRST;
        //            var outWorldStepInstance = new WorldStepInstance(WorldStep.fromRawNode(rawNode));
        //            outWorldStepInstance.instance = InstanceTypeEnum.SECOND;
        worldStepInstance.setOutInstance(worldStepInstance);
        //            outWorldStepInstance.setOutInstance(worldStepInstance);
        return worldStepInstance;
    }

    private String serializeWorldStepInstance(WorldStepInstance worldStepInstance) throws ParserConfigurationException, TransformerException {
        var outputDocument = worldStepInstance.getOutInstance().offsetRandomizationTable().getWorldStep()
            .serializeIntoRawNode()
            .toDocument("world_step");
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(outputDocument), new StreamResult(writer));
        return writer.getBuffer().toString();
    }
}
