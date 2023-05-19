package com.solvd.laba.Classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Logger futureLogger = LogManager.getLogger();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Supplier is done " + Thread.currentThread().getName();
        }, executorService);

        completableFuture.thenRun(() -> {
            futureLogger.info("Runnable executed " + Thread.currentThread().getName());
        });

        executorService.shutdown();
        futureLogger.info(completableFuture.get());
    }
}
