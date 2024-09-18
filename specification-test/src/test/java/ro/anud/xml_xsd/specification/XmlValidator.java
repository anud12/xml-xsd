package ro.anud.xml_xsd.specification;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class XmlValidator {
    private static boolean validateXMLSchema(String xsdPath, String xmlString) throws SAXException, IOException {

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdPath));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8))));
        return true;
    }

    public static DynamicTest validateXmlString(String displayName, String xmlFile) {
        return DynamicTest.dynamicTest(displayName, () -> {
            Assertions.assertThat(validateXMLSchema("./../world_step.xsd", xmlFile))
                    .isEqualTo(true);
        });
    }
}
