package ro.anud.xml_xsd.websocket.tests;

import ro.anud.xml_xsd.specification.XmlValidator;
import ro.anud.xml_xsd.strategy.TestStrategy;

public class AnalyzeTest {
    public static TestStrategy runTestRelativeToClass(
        final Class<?> aClass) {
        var startStop = new StartStop();
        return TestStrategy.group("analyze test")
            .and(ReadFromFileStep.run(aClass,"1_input.xml"))
            .and("1_input.xml", string -> {
                XmlValidator.validateXmlString(aClass, string);
            })
            .and(ReadFromFileStep.run(aClass,"2_expected.xml"))
            .and("2_expected.xml", string -> {
                XmlValidator.validateXmlString(aClass, string);
            })
            .and(LoadStep.run(aClass, "1_input.xml"))
            .and(startStop.send())
            .and(startStop.waitUntilFinished())
            .and(Download.assertXml(aClass,"2_expected.xml"));
    }
}
