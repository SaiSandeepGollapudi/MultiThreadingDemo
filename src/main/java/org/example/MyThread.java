package org.example;

public class MyThread extends Thread{


    public void run(){
        try{
            Thread.sleep(2000);

        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("From myThread " +Thread.currentThread().getName());
    }
}
