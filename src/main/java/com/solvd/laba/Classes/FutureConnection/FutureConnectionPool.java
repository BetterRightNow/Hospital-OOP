package com.solvd.laba.classes.futureConnection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.*;
import com.solvd.laba.classes.connectionPool.Connection;

public class FutureConnectionPool {
    private BlockingQueue<Connection> connections;
    private Semaphore semaphore;
    private int poolSize;

    private static class FutureConnectionPoolHolder {
        static final FutureConnectionPool INSTANCE = new FutureConnectionPool();
    }

    private FutureConnectionPool() {
        // Private constructor for lazy initialization
    }

    private FutureConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        connections = new ArrayBlockingQueue<>(poolSize); // Create a blocking queue with the specified pool size
        semaphore = new Semaphore(poolSize); // Create a semaphore with the specified pool size
        for (int i = 0; i < poolSize; i++) {
            connections.add(new Connection()); // Create and add connections to the queue
        }
    }

    public static FutureConnectionPool getInstance() {
        return FutureConnectionPoolHolder.INSTANCE;
    }

    public CompletableFuture<Connection> getConnection() throws InterruptedException {
//        Create a CompletableFuture to hold the future connection
        CompletableFuture<Connection> future = new CompletableFuture<>();
        semaphore.acquire(); // Acquire a permit from the semaphore
        Connection connection = connections.poll(); // Get a connection from the queue
        if (connection != null) {
            future.complete(connection); // Complete the future with the acquired connection
        } else {
            CompletableFuture.supplyAsync(() -> {
                try {
                    return connections.take(); // Take a connection from the queue (waits if the queue is empty)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).thenAccept(future::complete); // Complete the future with the taken connection
        }
        return future;
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection); // Add the released connection back to the queue
        semaphore.release(); // Release a permit to the semaphore
    }

//    Create a new instance of FutureConnectionPool
    public static FutureConnectionPool createInstance(int poolSize) {
        return new FutureConnectionPool(poolSize);
    }
}
