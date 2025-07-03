package ro.anud.xml_xsd.websocket.tests;

import ro.anud.xml_xsd.strategy.TestStrategy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public record ReadFromFileStep() {

    public record FileResult<T>(T parent, String fileString) {}


    public static TestStrategy.AndLambda<TestStrategy.Value<String>> run(final Class<?> runningClass, String fileName) {
        return caseBuilder -> caseBuilder.and(TestStrategy
            .group(ReadFromFileStep.class.getSimpleName())
            .and(
                "read from File", () -> {
                    String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();
                    String fileString = new String(Files.readAllBytes(Path.of(
                        relativePath,
                        fileName))
                    );
                    fileString = fileString.replace("\r\n", "\n");
                    return fileString;
                }));
    }

    public static <T> TestStrategy.ValueAndLambda<T, TestStrategy.Value<FileResult<T>>> wrap(
        final Class<?> runningClass,
        String fileName) {
        return caseBuilder -> caseBuilder.and(
            "read from File", (value) -> {
                String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();
                String fileString = new String(Files.readAllBytes(Path.of(
                    relativePath,
                    fileName))
                );
                fileString = fileString.replace("\r\n", "\n");
                return new FileResult<>(value, fileString);
            });
    }
}
