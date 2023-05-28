package com.solvd.laba.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class RunnableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Logger runnableLogger = LogManager.getLogger();

//        Creating Runnable object and using anonymous class and Runnable interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                runnableLogger.info("1st thread works" + Thread.currentThread().getId());
            }
        };

        Thread thread1 = new Thread(runnable);

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            runnableLogger.info("2nd thread works" + Thread.currentThread().getId());
        });

        Callable callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Callable works";
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(thread1);
        executorService.execute(thread2);

        Future<String> future = executorService.submit(callable1);
        runnableLogger.info(future.get());

        executorService.shutdown();
    }
}
