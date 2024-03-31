package org.example;

import java.util.concurrent.*;

public class ThreadServiceExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        System.out.println("Starting here");
        long start = System.currentTimeMillis();

        System.out.println("Name of thread: "+ Thread.currentThread().getName());

        MyThread myThread1= new MyThread();
        myThread1.start();

        MyThread myThread2= new MyThread();
        myThread2.start();

        MyThread myThread3= new MyThread();
        myThread3.start();

        myThread1.join();// telling main method to wait for thread1 to join it and then only move
        myThread2.join();
        myThread3.join();

        long end = System.currentTimeMillis();
        System.out.println("Time taken: "+ (end-start));

    }}