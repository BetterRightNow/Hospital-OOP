package com.solvd.laba.classes.connectionPool;

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
        connectionLogger.info("\nConnection test launched");

//        Create a thread pool with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < numConnections; i++) {
            executorService.execute(() -> { // Execute tasks concurrently
                try {
                    connectionLogger.info("Thread " + Thread.currentThread().getId() + " waiting for connection...");
//                    Acquire a connection from the pool
                    Connection connection = connectionPool.getConnection();
                    connectionLogger.info("Thread " + Thread.currentThread().getId() + " got connection: " + connection);
                    Thread.sleep(2000); // Simulate some work being done with the connection
                    connectionPool.releaseConnection(connection); // Release the connection back to the pool
                    connectionLogger.info("Thread " + Thread.currentThread().getId() + " released connection: " + connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown(); // Shutdown the thread pool
    }
}
