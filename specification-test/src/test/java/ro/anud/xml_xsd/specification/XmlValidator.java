package ro.anud.xml_xsd.specification;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.regex.Pattern;

import static java.util.Optional.empty;

public class XmlValidator {
    private static boolean validateXMLSchema(String xsdPath, String xmlString) throws SAXException, IOException {

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdPath));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8))));
        return true;
    }

    public static void validateXmlString(Class<?> runningTestClass, String xmlFile) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            var document = documentBuilderFactory.newDocumentBuilder().parse(new ByteArrayInputStream(xmlFile.getBytes(StandardCharsets.UTF_8)));
            var schemaPathString = document.getDocumentElement().getAttribute("xsi:noNamespaceSchemaLocation");
            var runningTestClassPath = runningTestClass.getResource("").getPath().replaceFirst("/..", "");
            var rootRelativePathString = runningTestClassPath + schemaPathString;
            rootRelativePathString = rootRelativePathString.replaceFirst(Pattern.quote("/.."),"");
            Assertions.assertThat(validateXMLSchema(rootRelativePathString, xmlFile))
                .isEqualTo(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Optional<DynamicTest> validateXmlString(Class<?> runningTestClass, String displayName, Optional<String> xmlFileOptional) {
        if(xmlFileOptional.isEmpty()) {
            return empty();
        }
        var xmlFile = xmlFileOptional.get();
        var test = DynamicTest.dynamicTest(displayName, () -> {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            var document = documentBuilderFactory.newDocumentBuilder().parse(new ByteArrayInputStream(xmlFile.getBytes(StandardCharsets.UTF_8)));
            var schemaPathString = document.getDocumentElement().getAttribute("xsi:noNamespaceSchemaLocation");
            var runningTestClassPath = runningTestClass.getResource("").getPath().replaceFirst("/..", "");
            var rootRelativePathString = runningTestClassPath + schemaPathString;
            rootRelativePathString = rootRelativePathString.replaceFirst(Pattern.quote("/.."),"");
            Assertions.assertThat(validateXMLSchema(rootRelativePathString, xmlFile))
                    .isEqualTo(true);
        });

        return Optional.of(test);
    }
}
