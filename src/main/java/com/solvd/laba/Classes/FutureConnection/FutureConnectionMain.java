package com.solvd.laba.Classes.FutureConnection;

import com.solvd.laba.Classes.ConnectionPool.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureConnectionMain {
    public static void main(String[] args) {
        int poolSize = 5;
//        Create an instance of FutureConnectionPool
        FutureConnectionPool futureConnectionPool = FutureConnectionPool.createInstance(poolSize);

        int numConnections = 7;

        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        Logger futureConnectionLogger = LogManager.getLogger();
        futureConnectionLogger.info("\nConnection test using interfaces Future and CompletableStag launched");

//        Create an array of CompletableFuture objects to store the futures for connection acquisition
        CompletableFuture<Void>[] futures = new CompletableFuture[numConnections];
        for (int i = 0; i < numConnections; i++) {
            futures[i] = CompletableFuture.supplyAsync(() -> {
                        try {
//                            Get a connection from the FutureConnectionPool
                            return futureConnectionPool.getConnection();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }, executorService)
                    .thenAcceptAsync(connectionFuture -> {
//                        Obtain the connection from the CompletableFuture
                        Connection connection = connectionFuture.join();
                        if (connection != null) {
//                            Perform actions with the connection
                            futureConnectionLogger.info("Thread " + Thread.currentThread().getId() +
                                    " got connection: " + connection);
                            try {
                                Thread.sleep(2000); // Simulate work with the connection
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
//                            Release the connection back to the FutureConnectionPool
                            futureConnectionPool.releaseConnection(connection);
                            futureConnectionLogger.info("Thread " + Thread.currentThread().getId() +
                                    " released connection: " + connection);
                        }
                    });
        }

//        Wait for all the CompletableFuture objects to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);

        try {
            allFutures.get(); // Wait until all futures are completed
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
