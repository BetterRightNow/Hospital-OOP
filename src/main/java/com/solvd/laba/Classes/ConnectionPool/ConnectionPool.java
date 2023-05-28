package com.solvd.laba.classes.connectionPool;

import java.util.concurrent.*;

public class ConnectionPool {
    private BlockingQueue<Connection> connections; // Queue to hold the available connections
    private Semaphore semaphore; // Semaphore to control access to connections
    private int poolSize; // Maximum number of connections in the pool

    private static class ConnectionPoolHolder {
        static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    private ConnectionPool() {
        // Private constructor for lazy initialization
    }

    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        connections = new ArrayBlockingQueue<>(poolSize); // Initialize the blocking queue with the specified pool size
        semaphore = new Semaphore(poolSize); // Initialize the semaphore with the specified pool size
        for (int i = 0; i < poolSize; i++) {
            connections.add(new Connection()); // Add connections to the queue
        }
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE; // Return the instance of the ConnectionPool
    }

    public Connection getConnection() throws InterruptedException {
        semaphore.acquire(); // Acquire a permit from the semaphore
        Connection connection = connections.poll(); // Get a connection from the queue
        if (connection == null) {
            connection = new Connection(); // Create a new connection if the queue is empty
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection); // Add the released connection back to the queue
        semaphore.release(); // Release a permit in the semaphore
    }

    public static ConnectionPool createInstance(int poolSize) {
        return new ConnectionPool(poolSize); // Create a new instance of ConnectionPool with the specified pool size
    }
}

