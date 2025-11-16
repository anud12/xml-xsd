package ro.anud.xml_xsd.specification;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.xmlunit.XMLUnitException;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.ElementSelectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ro.anud.xml_xsd.specification.HttpTestBase.prettyFormat;


public class HttpRequestTest {
    public static final class AnalyzeExecute extends Endpoints {
        @Override
        public String getEndpoint() {
            return "/analyze/execute";
        }
    }

    public static abstract sealed class Endpoints permits AnalyzeExecute, AnalyzeExecuteNameRule {
        public abstract String getEndpoint();

        public static AnalyzeExecute analyzeExecute() {
            return new AnalyzeExecute();
        }

        public static AnalyzeExecuteNameRule analyzeExecuteNameRule(String name) {
            return new AnalyzeExecuteNameRule(name);
        }
    }

    public static final class AnalyzeExecuteNameRule extends Endpoints {
        private final String name;

        public AnalyzeExecuteNameRule(String name) {
            this.name = name;
        }

        @Override
        public String getEndpoint() {
            return "/analyze/execute/name_rule/" + name;
        }
    }

    static private String getFreePort() {
        try (ServerSocket socket = new ServerSocket(0)) {
            socket.setReuseAddress(true);
            return String.valueOf(socket.getLocalPort());
        } catch (IOException e) {
            throw new RuntimeException("Failed to find a free port", e);
        }
    }

    static private Runnable launchChildProcess(String port) {
        System.out.println("Starting server on port " + port);
        ProcessBuilder processBuilder = new ProcessBuilder(
            "node",
            "../gui-client/dependencies_bin/node/bundle.js",
            "--",
            "--port",
            port,
            "--no-websocket"
        );
        processBuilder.redirectErrorStream(true);
        Process process;
        try {
            process = processBuilder.start();
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Failed to start the process", e);
        }

        return () -> {
            process.destroy();
            System.out.println("Server process closed");
        };
    }

    static private void waitForHeartbeat(String url) {
        int maxRetries = 10;
        int currentDelay = 250;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                System.out.println("Sending heartbeat");
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    System.out.println("Heartbeat successful");
                    return;
                }
            } catch (IOException e) {
                System.out.println("Attempt " + attempt + " failed: " + e.getMessage() + ", retrying in " + currentDelay + "ms");
            }
            try {
                Thread.sleep(currentDelay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread was interrupted", e);
            }
            currentDelay = (int) ((currentDelay + 100) * 1.5);
        }
        throw new RuntimeException("All heartbeat attempts failed");

    }

    static public HttpResponse<String> sendRequest(String port, String path, String body) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            String resourcePath = "http://localhost:" + port + path;
            System.out.println("Sending request to " + resourcePath);

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(resourcePath))
                .header("Content-Type", "text/plain")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

            try {
                return client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Request failed", e);
            }
        }
    }


    static public DynamicTest validateExecution(
        Class<?> runningTestClass,
        HttpRequestTest.Endpoints endpoints,
        int expectedCode) {
        return DynamicTest.dynamicTest("Validating execution to endpoint" + endpoints.getEndpoint(), () -> {
            Runnable process = () -> {};
            try {
//                                var port = getFreePort();
//                                process = launchChildProcess(port);
                var port = "8080";
                waitForHeartbeat("http://localhost:" + port + "/health");
                String relativePath = Paths.get(runningTestClass.getResource("").toURI()).toString();
                String input = new String(Files.readAllBytes(Path.of(relativePath, "/1_input.xml")));

                HttpResponse<String> response = sendRequest(port, endpoints.getEndpoint(), input);
                String responseBody = response.body();
                try {
                    String expected = new String(Files.readAllBytes(Path.of(relativePath, "/2_expected.xml")));

                    try {
                        Diff diff = DiffBuilder.compare(prettyFormat(responseBody)).withTest(prettyFormat(expected))
                            .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
                            .checkForSimilar()
                            .build();

                        if(diff.hasDifferences()) {
                            Assertions.assertThat(prettyFormat(responseBody)).isEqualTo(prettyFormat(expected));
                        }
                    } catch (XMLUnitException e) {
                        Assertions.assertThat(prettyFormat(responseBody)).isEqualTo(prettyFormat(expected));
                    }


                } catch (java.nio.file.NoSuchFileException e) {
                    String expected = new String(Files.readAllBytes(Path.of(relativePath, "/2_expected.txt")));

                    Assertions.assertThat(prettyFormat(responseBody)).contains(prettyFormat(expected));
                }
                Assertions.assertThat(response.statusCode()).isEqualTo(expectedCode);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                process.run();
            }
        });

    }
}
