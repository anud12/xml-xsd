package ro.anud.xml_xsd.websocket.tests;

import ro.anud.xml_xsd.cases.CaseBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public record ReadFromFileStep() {

    public record FileResult<T>(T parent, String fileString) {}


    public static CaseBuilder.AndLambda<CaseBuilder.Value<String>> run(final Class<?> runningClass, String fileName) {
        return caseBuilder -> caseBuilder.and(CaseBuilder
            .group(ReadFromFileStep.class.getSimpleName())
            .and(
                "read from File", () -> {
                    String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();
                    String fileString = new String(Files.readAllBytes(Path.of(
                        relativePath,
                        fileName))
                    );
                    return fileString;
                }));
    }

    public static <T> CaseBuilder.ValueAndLambda<T, CaseBuilder.Value<FileResult<T>>> wrap(
        final Class<?> runningClass,
        String fileName) {
        return caseBuilder -> caseBuilder.and(
            "read from File", (value) -> {
                String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();
                String fileString = new String(Files.readAllBytes(Path.of(
                    relativePath,
                    fileName))
                );
                return new FileResult<>(value, fileString);
            });
    }
}
