package ro.anud.xml_xsd.implementation;

import org.springframework.stereotype.Component;
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
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class WorldStepRunner {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private volatile boolean isRunning = true;
    private  CompletableFuture<Object> finishedThread = CompletableFuture.completedFuture(this);

    private void runStep(WorldStepInstance worldStepInstance) {
        FromPersonAction.apply(worldStepInstance);
        PersonCreateAction.personCreateAction(worldStepInstance);
        LocationGraphCreate.apply(worldStepInstance);
        LocationGraphCreateAdjacent.apply(worldStepInstance);
        PersonMoveTo.apply(worldStepInstance);
        PersonTeleportTo.apply(worldStepInstance);
        EventsMetadata.apply(worldStepInstance);
        LocationGraphAddClassification.locationGraphAddClassification(worldStepInstance);
        PersonAssignClassification.apply(worldStepInstance);


    }

    public WorldStepRunner start(WorldStepInstance worldStepInstance, WebSocketHandler webSocketHandler) {

        var innerWorldStepInstance = new AtomicReference<>(worldStepInstance);
        long intervalUs = 100_000_000;
        isRunning = true;
        CompletableFuture<Object> firstRun = new CompletableFuture<>();
        finishedThread = new CompletableFuture<>();
        new Thread(() -> {
            firstRun.complete(this);
            while (isRunning) {
                long startTime = System.nanoTime();
                System.out.println("------------------------------------------");
                System.out.println("Running task");
                try {
                    innerWorldStepInstance.getAndUpdate(worldStepInstance1 -> {
                        worldStepInstance1.setWebSocketHandler(webSocketHandler);
                        runStep(worldStepInstance1);
                        worldStepInstance1.setWebSocketHandler(null);
                        worldStepInstance1.getOutInstance().setWebSocketHandler(webSocketHandler);
                        return worldStepInstance1.getOutInstance();
                    });
                } catch (Exception e) {
                    e.printStackTrace(); // Handle exceptions in the task
                }
                long elapsedTime = System.nanoTime() - startTime;
                long sleepTime = intervalUs - elapsedTime;
                System.out.println("------------------------------------------");
                System.out.println("Task Finished in : " + String.format("%,d",elapsedTime) + "us");
                System.out.println("Sleeping         : " + String.format("%,d",sleepTime) + "us");
                System.out.println("------------------------------------------");

                if (sleepTime > 0) {
                    try {
                        Thread.sleep((sleepTime / 1_000_000), (int) (sleepTime % 1_000_000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            finishedThread.complete(this);
        }).start();
        try {
            firstRun.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public WorldStepRunner stop() {
        isRunning = false;
        try {
            finishedThread.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

}
