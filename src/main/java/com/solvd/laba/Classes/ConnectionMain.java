package com.solvd.laba.Classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ConnectionMain {
    public static void main(String[] args) {
        int poolSize = 5;
        ConnectionPool connectionPool = ConnectionPool.createInstance(poolSize);

        int numConnections = 7;

        Logger connectionLogger = LogManager.getLogger();
        connectionLogger.info("\nConnectionTest launched");

        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < numConnections; i++) {
            executorService.execute(() -> {
                try {
                    connectionLogger.info("Thread " + Thread.currentThread().getId() + " waiting for connection...");
                    Connection connection = connectionPool.getConnection();
                    connectionLogger.info("Thread " + Thread.currentThread().getId() + " got connection: " + connection);
                    Thread.sleep(2000);
                    connectionPool.releaseConnection(connection);
                    connectionLogger.info("Thread " + Thread.currentThread().getId() + " released connection: " + connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}
