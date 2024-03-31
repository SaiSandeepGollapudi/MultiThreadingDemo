package org.example;

import java.util.concurrent.*;

public class ThreadServiceExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        System.out.println("Starting here");
        long start = System.currentTimeMillis();

        System.out.println("Name of thread: "+ Thread.currentThread().getName());

        MyThread mythread= new MyThread();
        mythread.start();

        long end = System.currentTimeMillis();
        System.out.println("Time taken: "+ (end-start));

    }}