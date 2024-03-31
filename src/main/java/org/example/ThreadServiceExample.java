package org.example;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadServiceExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        System.out.println("Starting here");
        long start = System.currentTimeMillis();

        System.out.println("Name of thread: "+ Thread.currentThread().getName());

        MyThread myThread1= new MyThread();
//myThread1.start();

        MyThread myThread2= new MyThread();
//        myThread2.start();

        MyThread myThread3= new MyThread();
      //  myThread3.start();

//
//        myThread1.join();// telling main method to wait for thread1 to join it and then only move
//        myThread2.join();
//        myThread3.join();


        ExecutorService service= Executors.newFixedThreadPool(3);

// Task Submission: Tasks are submitted to the ExecutorService using the submit() method, which returns a Future object representing the result of the task.
//
// Asynchronous Execution: The tasks submitted to the ExecutorService are executed asynchronously in separate threads,
// allowing other tasks to be executed concurrently.
//The Future objects returned by the submit() method allow you to
// retrieve the results of the tasks using the get() method.
        Future<Integer> aFuture =service.submit(() -> {

            return getMyInteger();
        });

        Future<Integer> bFuture =service.submit(() -> {

            return getMyInteger();
        });

        Future<Integer> cFuture =service.submit(() -> {

            return getMyInteger();
        });

//        CompletableFuture.supplyAsync(...) initiates an asynchronous task to retrieve an integer.
       CompletableFuture<Integer> aCompFuture=CompletableFuture.supplyAsync(
                () -> {
                    try {
                        return getMyInteger(); // return 1;
                    }catch (FileNotFoundException ex){
                        System.out.println("I faced exception");
                        return 1;
                    }

                } // 1000 secs
               //        thenApplyAsync(...) is used to chain additional processing steps to the result of the asynchronous task.
//        Each thenApplyAsync call defines a function to be applied asynchronously to the result of the previous stage, forming a chain of asynchronous operations.

       ).thenApplyAsync((a) -> {
            System.out.println(a+1);
            return a+1;
        }).thenApplyAsync((a) -> {
            System.out.println(a+1);
            return a+1;
        }).thenApplyAsync((a) -> {
            System.out.println(a+1);
            return a+1;
        });

        int finalValue=aCompFuture.get();
        System.out.println(finalValue);

        long end=System.currentTimeMillis();

        System.out.println("Time taken: "+(end-start));

        // System.out.println(a);
        service.shutdown();


    }

    public static Integer getMyInteger() throws FileNotFoundException {
        try{
            Thread.sleep(1000);
        }catch (Exception e){


        }

        //This code generates a random boolean value (n) using Random().nextBoolean(). If n is true, it throws a FileNotFoundException.
        // Otherwise, it prints "Here after exceptions" to the console and returns the integer value 1
        Boolean n= new Random().nextBoolean();
        if(n){
            throw new FileNotFoundException();
        }
        System.out.println("Here after exceptions");

        return 1;
    }
}