package ro.anud.xml_xsd.specification;

import org.junit.jupiter.api.DynamicTest;

import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class HttpTestBase {

    public static String prettyFormat(String input) {

        String lfInput = input.replace("\r\n", "\n");

        try {
            String xsltDocument = """
                    <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
                        <xsl:output omit-xml-declaration="yes"/>
                        <xsl:strip-space elements="*"/>
                        <xsl:output method="xml" encoding="UTF-8"/>
                    
                        <xsl:template match="@*|node()">
                            <xsl:copy>
                                <xsl:apply-templates select="@*|node()"/>
                            </xsl:copy>
                        </xsl:template>
                    
                    </xsl:stylesheet>
                    """;
            int indent = 2;
            Source xmlInput = new StreamSource(new StringReader(lfInput));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(new StringReader(xsltDocument)));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (javax.xml.transform.TransformerException e) {
            return lfInput;
        }
    }
    static public Optional<String> getInputXmlRelativeToClass(Class<?> clazz) {
        try {
            String relativePath = Paths.get(clazz.getResource("").toURI()).toString();
            return Optional.of(new String(Files.readAllBytes(Path.of(relativePath, "/1_input.xml"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    static public Optional<String> getOutputXmlRelativeToClass(Class<?> clazz) {
        try {
            String relativeDirectoryPathString = Paths.get(clazz.getResource("").toURI()).toString();
            Path relativePath = Path.of(relativeDirectoryPathString, "/2_expected.xml");

            return Optional.of(new String(Files.readAllBytes(relativePath)));
        } catch (Exception e) {
            if(e instanceof NoSuchFileException) {
                return Optional.empty();
            }
            throw new RuntimeException(e);
        }
    }

    static public Collection<DynamicTest> runTestRelativeToClass(Class<?> runningTestClass, HttpRequestTest.Endpoints endpoints, int expectedCode) {

        var testList = new ArrayList<DynamicTest>();
        XmlValidator.validateXmlString(runningTestClass, "Validating input xml",getInputXmlRelativeToClass(runningTestClass))
                .ifPresent(testList::add);
        testList.add(HttpRequestTest.validateExecution(runningTestClass,endpoints,expectedCode));
        XmlValidator.validateXmlString(runningTestClass, "Validating expected xml",getOutputXmlRelativeToClass(runningTestClass))
                .ifPresent(testList::add);
        return testList;
    }

    static public Collection<DynamicTest> runTestRelativeToClass(Class<?> clazz) {
        return runTestRelativeToClass(clazz, new HttpRequestTest.AnalyzeExecute(), 200);
    }

    static public Collection<DynamicTest> runTestRelativeToClass(Class<?> clazz, HttpRequestTest.Endpoints endpoints) {
        return runTestRelativeToClass(clazz, endpoints, 200);
    }

    public static Collection<DynamicTest> runTestRelativeToClassWithError(final Class<?> aClass) {
        return runTestRelativeToClass(aClass, new HttpRequestTest.AnalyzeExecute(), 500);
    }

    public static Collection<DynamicTest> runTestRelativeToClassWithValidationError(final Class<?> aClass) {
        return runTestRelativeToClass(aClass, new HttpRequestTest.AnalyzeExecute(), 400);
    }
}
