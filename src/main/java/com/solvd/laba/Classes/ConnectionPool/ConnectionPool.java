package com.solvd.laba.Classes.ConnectionPool;

import java.util.concurrent.*;

public class ConnectionPool {
    private BlockingQueue<Connection> connections;
    private Semaphore semaphore;
    private int poolSize;

    private static class ConnectionPoolHolder {
        static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    private ConnectionPool() {
        // Private constructor for lazy initialization
    }

    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        connections = new ArrayBlockingQueue<>(poolSize);
        semaphore = new Semaphore(poolSize);
        for (int i = 0; i < poolSize; i++) {
            connections.add(new Connection());
        }
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    public Connection getConnection() throws InterruptedException {
        semaphore.acquire();
        Connection connection = connections.poll();
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection);
        semaphore.release();
    }

    public static ConnectionPool createInstance(int poolSize) {
        return new ConnectionPool(poolSize);
    }
}

