package com.solvd.laba.Classes.FutureConnection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.*;
import com.solvd.laba.Classes.ConnectionPool.Connection;

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
        connections = new ArrayBlockingQueue<>(poolSize);
        semaphore = new Semaphore(poolSize);
        for (int i = 0; i < poolSize; i++) {
            connections.add(new Connection());
        }
    }

    public static FutureConnectionPool getInstance() {
        return FutureConnectionPoolHolder.INSTANCE;
    }

    public CompletableFuture<Connection> getConnection() throws InterruptedException {
        CompletableFuture<Connection> future = new CompletableFuture<>();
        semaphore.acquire();
        Connection connection = connections.poll();
        if (connection != null) {
            future.complete(connection);
        } else {
            CompletableFuture.supplyAsync(() -> {
                try {
                    return connections.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).thenAccept(future::complete);
        }
        return future;
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection);
        semaphore.release();
    }

    public static FutureConnectionPool createInstance(int poolSize) {
        return new FutureConnectionPool(poolSize);
    }
}
