package ro.anud.xml_xsd.implementation.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.util.RawNode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@RestController()
@RequestMapping("/analyze")
public class AnalyzeController {

    @PostMapping("/execute")
    public ResponseEntity<String> execute(@RequestBody String request) {
//        System.out.println(request);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(request)));
            var rawNode = RawNode.fromNode(document.getDocumentElement());
            var step = WorldStep.fromRawNode(rawNode);
            var outputDocument = step.getRawNode().toDocument("world_step");
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(outputDocument), new StreamResult(writer));
            return ResponseEntity.ok(writer.getBuffer().toString());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(Arrays.stream(e.getStackTrace()).toList().toString());
        }
//        return ResponseEntity.ok(request);
    }
}
