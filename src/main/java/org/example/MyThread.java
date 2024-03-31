package org.example;

public class MyThread extends Thread{


    public void run() {
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        printMyName();
    }
        private void printMyName(){
        System.out.println("Hello from MyThread"+Thread.currentThread().getName());
    }
}
