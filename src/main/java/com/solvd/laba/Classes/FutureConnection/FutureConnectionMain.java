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
        FutureConnectionPool futureConnectionPool = FutureConnectionPool.createInstance(poolSize);

        int numConnections = 7;

        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        Logger futureConnectionLogger = LogManager.getLogger();
        futureConnectionLogger.info("\nConnection test using interfaces Future and CompletableStag launched");

        CompletableFuture<Void>[] futures = new CompletableFuture[numConnections];
        for (int i = 0; i < numConnections; i++) {
            futures[i] = CompletableFuture.supplyAsync(() -> {
                        try {
                            return futureConnectionPool.getConnection();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }, executorService)
                    .thenAcceptAsync(connectionFuture -> {
                        Connection connection = connectionFuture.join();
                        if (connection != null) {
                            futureConnectionLogger.info("Thread " + Thread.currentThread().getId() +
                                    " got connection: " + connection);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            futureConnectionPool.releaseConnection(connection);
                            futureConnectionLogger.info("Thread " + Thread.currentThread().getId() +
                                    " released connection: " + connection);
                        }
                    });
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);

        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
